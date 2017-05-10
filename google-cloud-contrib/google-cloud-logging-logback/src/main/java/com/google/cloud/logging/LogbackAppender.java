/*
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.Logging.WriteOption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://logback.qos.ch/">Logback</a> appender for StackDriver Cloud Logging.
 *
 * <p>Appender configuration in logback.xml:
 * <ul>
 * <li>&lt;appender name="CLOUD" class="com.google.cloud.logging.LogbackAppender"&gt;</li>
 * <li>&lt;log&gt;application.log&lt;/log&gt; (Optional, defaults to "java.log" : Stackdriver log name)</li>
 * <li>&lt;level&gt;ERROR&lt;/level&gt; (Optional, defaults to "INFO" : logs at or above this level)</li>
 * <li>&lt;flushLevel&gt;WARNING&lt;/flushLevel&gt; (Optional, defaults to "ERROR")</li>
 * <li>&lt;resourceType&gt;&lt;/resourceType&gt; (Optional, auto detects on App Engine Flex, Standard, GCE and
 * GKE, defaults to "global".
 * See <a href="https://cloud.google.com/logging/docs/api/v2/resource-list">supported resource
 * types</a></li>
 * <li>&lt;enhancers&gt;com.example.enhancer1, com.example.enhancer2&lt;/enhancers&gt;</li>
 * <li>(Optional) add custom labels to log entries using {@link LoggingEnhancer} classes.</li>
 * <li>&lt;/appender&gt;</li>
 * </ul>
 */
public class LogbackAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

  private static final String LEVEL_NAME_KEY = "levelName";
  private static final String LEVEL_VALUE_KEY = "levelValue";

  private volatile Logging logging;
  private List<LoggingEnhancer> loggingEnhancers;
  private WriteOption[] defaultWriteOptions;

  private Level flushLevel;
  private String log;
  private String resourceType;
  private String enhancers;

  /**
   * Batched logging requests get immediately flushed for logs at or above level.
   *
   * <p>Defaults to Error if not set.
   *
   * @param flushLevel Logback log level
   */
  public void setFlushLevel(Level flushLevel) {
    this.flushLevel = flushLevel;
  }

  /**
   * Sets the log filename, defaults to java.log.
   *
   * @param log filename
   */
  public void setLog(String log) {
    this.log = log;
  }

  /**
   * Sets the name of the monitored resource (Optional).
   *
   * <p>Must be a <a href="https://cloud.google.com/logging/docs/api/v2/resource-list">supported</a>
   * resource type. gae_app, gce_instance and container are auto-detected, defaults to "global"
   *
   * @param resourceType name of monitored resource
   */
  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  /**
   * Add extra labels using classes that implement {@link LoggingEnhancer}.
   *
   * @param enhancers list of enhancer classnames (comma separated)
   */
  public void setEnhancers(String enhancers) {
    this.enhancers = enhancers;
  }

  Level getFlushLevel() {
    return (flushLevel != null) ? flushLevel : Level.ERROR;
  }

  String getLogName() {
    return (log != null) ? log : "java.log";
  }

  MonitoredResource getMonitoredResource(String projectId) {
    return MonitoredResourceUtil.getResource(projectId, resourceType);
  }

  List<LoggingEnhancer> getEnhancers() {
    String list = enhancers;
    try {
      List<LoggingEnhancer> enhancers = new ArrayList<>();
      if (list != null) {
        String[] items = list.split(",");
        for (String enhancerName : items) {
          Class<? extends LoggingEnhancer> clz =
              (Class<? extends LoggingEnhancer>)
                  ClassLoader.getSystemClassLoader().loadClass(enhancerName.trim());
          enhancers.add(clz.newInstance());
        }
      }
      return enhancers;
    } catch (Exception ex) {
      // If we cannot create the enhancers we fall back to the default
    }
    return Collections.emptyList();
  }

  /** Initialze and configure the cloud logging service. */
  @Override
  public synchronized void start() {
    MonitoredResource resource = getMonitoredResource(getProjectId());
    defaultWriteOptions =
        new WriteOption[] {
          WriteOption.logName(getLogName()),
          WriteOption.resource(resource)
    };

    getLogging().setFlushSeverity(severityFor(getFlushLevel()));
    loggingEnhancers = new ArrayList<>();
    List<LoggingEnhancer> resourceEnhancers = MonitoredResourceUtil.getResourceEnhancers();
    loggingEnhancers.addAll(resourceEnhancers);
    loggingEnhancers.addAll(getEnhancers());
    super.start();
  }

  protected String getProjectId() {
    return LoggingOptions.getDefaultInstance().getProjectId();
  }

  @Override
  protected void append(ILoggingEvent e) {
    LogEntry logEntry = logEntryFor(e);
    getLogging().write(Collections.singleton(logEntry), defaultWriteOptions);
  }

  @Override
  public synchronized void stop() {
    if (logging != null) {
      try {
        logging.close();
      } catch (Exception ex) {
        // ignore
      }
    }
    logging = null;
    super.stop();
  }

  protected Logging getLogging() {
    if (logging == null) {
      synchronized (this) {
        if (logging == null) {
          logging = LoggingOptions.getDefaultInstance().getService();
        }
      }
    }
    return logging;
  }

  private LogEntry logEntryFor(ILoggingEvent e) {
    String payload = e.getFormattedMessage();
    Level level = e.getLevel();
    LogEntry.Builder builder =
        LogEntry.newBuilder(Payload.StringPayload.of(payload))
            .setTimestamp(e.getTimeStamp())
            .setSeverity(severityFor(level));

    builder.addLabel(LEVEL_NAME_KEY, level.toString())
        .addLabel(LEVEL_VALUE_KEY, String.valueOf(level.toInt()));

    if (loggingEnhancers != null) {
      for (LoggingEnhancer enhancer : loggingEnhancers) {
        enhancer.enhanceLogEntry(builder);
      }
    }

    return builder.build();
  }

  /**
   * Transforms Logback logging levels to Cloud severity.
   *
   * @param level Logback logging level
   * @return Cloud severity level
   */
  private static Severity severityFor(Level level) {
    switch (level.toInt()) {
        // TRACE
      case 5000:
        return Severity.DEBUG;
        // DEBUG
      case 10000:
        return Severity.DEBUG;
        // INFO
      case 20000:
        return Severity.INFO;
        // WARNING
      case 30000:
        return Severity.WARNING;
        // ERROR
      case 40000:
        return Severity.ERROR;
      default:
        return Severity.DEFAULT;
    }
  }
}
