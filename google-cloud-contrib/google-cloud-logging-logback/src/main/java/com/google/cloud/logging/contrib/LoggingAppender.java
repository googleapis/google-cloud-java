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

package com.google.cloud.logging.contrib;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.LoggingEnhancer;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.MonitoredResourceUtil;
import com.google.cloud.logging.Payload;
import com.google.cloud.logging.Severity;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://logback.qos.ch/">Logback</a> appender for StackDriver Cloud Logging.
 *
 * <p>Appender configuration in logback.xml:
 * <ul>
 * <li><appender name="CLOUD" class="com.google.cloud.logging.contrib.LoggingAppender"></li>
 * <li><log>application.log</log> (Optional, defaults to "java.log" : Stackdriver log name)</li>
 * <li><level>ERROR</level> (Optional, defaults to "INFO" : logs at or above this level)</li>
 * <li><flushLevel>WARNING</flushLevel> (Optional, defaults to "ERROR")</tr>
 * <li><resourceType></resourceType> (Optional, auto detects on App Engine Flex, Standard, GCE and
 * GKE, defaults to "global".
 * See <a href="https://cloud.google.com/logging/docs/api/v2/resource-list">supported resource
 * types</a>
 * <li>enhancers>com.example.enhancer1, com.example.enhancer2</enhancers></li>
 * <li>(Optional) add custom labels to log entries using {@link LoggingEnhancer} classes.</li>
 * <li></appender></li>
 */
public class LoggingAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

  private static final String LEVEL_NAME_KEY = "levelName";
  private static final String LEVEL_VALUE_KEY = "levelValue";

  private volatile Logging logging;
  private List<LoggingEnhancer> loggingEnhancers;
  private WriteOption[] defaultWriteOptions;

  private Level flushLevel;
  private String log;
  private Level logLevel;
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
   * Sets the minimum logging level, defaults to INFO
   *
   * @param level logback level
   */
  public void setLevel(Level level) {
    this.logLevel = level;
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
   * @param enhancers list of enhancer classnames
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

  Level getLogLevel() {
    return (logLevel != null) ? logLevel : Level.INFO;
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
        for (String e_name : items) {
          Class<? extends LoggingEnhancer> clz =
              (Class<? extends LoggingEnhancer>)
                  ClassLoader.getSystemClassLoader().loadClass(e_name);
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
    Level level = getLogLevel();
    defaultWriteOptions =
        new WriteOption[] {
          WriteOption.logName(getLogName()),
          WriteOption.resource(resource),
          WriteOption.labels(
              ImmutableMap.of(
                  LEVEL_NAME_KEY, level.toString(), LEVEL_VALUE_KEY, String.valueOf(level.toInt())))
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
    if (!isLoggable(e)) {
      return;
    }
    LogEntry logEntry = logEntryFor(e);
    getLogging().write(Collections.singleton(logEntry), defaultWriteOptions);
  }

  private boolean isLoggable(ILoggingEvent e) {
    return e.getLevel().toInt() >= getLogLevel().toInt();
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

    if (level != getLogLevel()) {
      builder
          .addLabel("levelName", level.toString())
          .addLabel("levelValue", String.valueOf(level.toInt()));
    }
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
