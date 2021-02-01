/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.logging.logback;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import ch.qos.logback.core.util.Loader;
import com.google.api.core.InternalApi;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.LoggingEnhancer;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.MonitoredResourceUtil;
import com.google.cloud.logging.Payload;
import com.google.cloud.logging.Severity;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://logback.qos.ch/">Logback</a> appender for Google Cloud Logging.
 *
 * <p>Appender configuration in <code>logback.xml</code>:
 *
 * <pre>
 *    &lt;appender name="CLOUD" class="com.google.cloud.logging.logback.LoggingAppender"&gt;
 *         &lt;!-- Optional: filter logs at and above this level --&gt;
 *         &lt;filter class="ch.qos.logback.classic.filter.ThresholdFilter"&gt;
 *             &lt;level&gt;INFO&lt;/level&gt;
 *         &lt;/filter&gt;
 *
 *         &lt;!-- Optional: defaults to "java.log" --&gt;
 *         &lt;log&gt;application.log&lt;/log&gt;
 *
 *         &lt;!-- Optional: defaults to "ERROR" --&gt;
 *         &lt;flushLevel&gt;WARNING&lt;/flushLevel&gt;
 *
 *         &lt;!-- Optional: auto detects on App Engine Flex, Standard, GCE and GKE, defaults to "global". See <a
 *         href="https://cloud.google.com/logging/docs/api/v2/resource-list">supported resource types</a> --&gt;
 *         &lt;resourceType&gt;&lt;/resourceType&gt;
 *
 *         &lt;!-- Optional: defaults to the default credentials of the environment --&gt;
 *         &lt;credentialsFile&gt;/path/to/credentials/file&lt;/credentialsFile&gt;
 *
 *         &lt;!-- Optional: add custom labels to log entries using {@link LoggingEnhancer} classes --&gt;
 *         &lt;enhancer&gt;com.example.enhancers.TestLoggingEnhancer&lt/enhancer&gt;
 *         &lt;enhancer&gt;com.example.enhancers.AnotherEnhancer&lt/enhancer&gt;
 *     &lt;/appender&gt;
 * </pre>
 */
public class LoggingAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

  private static final String LEVEL_NAME_KEY = "levelName";
  private static final String LEVEL_VALUE_KEY = "levelValue";
  private static final String LOGGER_NAME_KEY = "loggerName";
  private static final String TYPE =
      "type.googleapis.com/google.devtools.clouderrorreporting.v1beta1.ReportedErrorEvent";
  private static final List<LoggingEventEnhancer> DEFAULT_LOGGING_EVENT_ENHANCERS =
      ImmutableList.<LoggingEventEnhancer>of(new MDCEventEnhancer());

  private volatile Logging logging;
  private LoggingOptions loggingOptions;
  private List<LoggingEnhancer> loggingEnhancers;
  private List<LoggingEventEnhancer> loggingEventEnhancers;
  private WriteOption[] defaultWriteOptions;

  private Level flushLevel;
  private String log;
  private String resourceType;
  private String credentialsFile;
  private final Set<String> enhancerClassNames = new HashSet<>();
  private final Set<String> loggingEventEnhancerClassNames = new HashSet<>();

  /**
   * Batched logging requests get immediately flushed for logs at or above this level.
   *
   * <p>Defaults to Error if not set.
   *
   * @param flushLevel Logback log level
   */
  public void setFlushLevel(Level flushLevel) {
    this.flushLevel = flushLevel;
  }

  /**
   * Sets the log filename.
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
   * resource type. gae_app, gce_instance and container are auto-detected.
   *
   * <p>Defaults to "global"
   *
   * @param resourceType name of the monitored resource
   */
  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  /**
   * Sets the credentials file to use to create the {@link LoggingOptions}. The credentials returned
   * by {@link GoogleCredentials#getApplicationDefault()} will be used if no custom credentials file
   * has been set.
   *
   * @param credentialsFile The credentials file to use.
   */
  public void setCredentialsFile(String credentialsFile) {
    this.credentialsFile = credentialsFile;
  }

  /** Add extra labels using classes that implement {@link LoggingEnhancer}. */
  public void addEnhancer(String enhancerClassName) {
    this.enhancerClassNames.add(enhancerClassName);
  }

  public void addLoggingEventEnhancer(String enhancerClassName) {
    this.loggingEventEnhancerClassNames.add(enhancerClassName);
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

  List<LoggingEnhancer> getLoggingEnhancers() {
    return getEnhancers(enhancerClassNames);
  }

  List<LoggingEventEnhancer> getLoggingEventEnhancers() {
    if (loggingEventEnhancerClassNames.isEmpty()) {
      return DEFAULT_LOGGING_EVENT_ENHANCERS;
    } else {
      return getEnhancers(loggingEventEnhancerClassNames);
    }
  }

  <T> List<T> getEnhancers(Set<String> classNames) {
    List<T> loggingEnhancers = new ArrayList<>();
    if (classNames != null) {
      for (String enhancerClassName : classNames) {
        if (enhancerClassName != null) {
          T enhancer = getEnhancer(enhancerClassName);
          if (enhancer != null) {
            loggingEnhancers.add(enhancer);
          }
        }
      }
    }
    return loggingEnhancers;
  }

  private <T> T getEnhancer(String enhancerClassName) {
    try {
      Class<T> clz = (Class<T>) Loader.loadClass(enhancerClassName.trim());
      return clz.getDeclaredConstructor().newInstance();
    } catch (Exception ex) {
      // If we cannot create the enhancer we fallback to null
    }
    return null;
  }

  /** Initialize and configure the cloud logging service. */
  @Override
  public synchronized void start() {
    if (isStarted()) {
      return;
    }
    MonitoredResource resource = getMonitoredResource(getProjectId());
    defaultWriteOptions =
        new WriteOption[] {WriteOption.logName(getLogName()), WriteOption.resource(resource)};
    Level flushLevel = getFlushLevel();
    if (flushLevel != Level.OFF) {
      getLogging().setFlushSeverity(severityFor(flushLevel));
    }
    loggingEnhancers = new ArrayList<>();
    List<LoggingEnhancer> resourceEnhancers = MonitoredResourceUtil.getResourceEnhancers();
    loggingEnhancers.addAll(resourceEnhancers);
    loggingEnhancers.addAll(getLoggingEnhancers());
    loggingEventEnhancers = new ArrayList<>();
    loggingEventEnhancers.addAll(getLoggingEventEnhancers());

    super.start();
  }

  String getProjectId() {
    return getLoggingOptions().getProjectId();
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

  Logging getLogging() {
    if (logging == null) {
      synchronized (this) {
        if (logging == null) {
          logging = getLoggingOptions().getService();
        }
      }
    }
    return logging;
  }

  /** Flushes any pending asynchronous logging writes. */
  public void flush() {
    if (!isStarted()) {
      return;
    }
    synchronized (this) {
      getLogging().flush();
    }
  }

  /** Gets the {@link LoggingOptions} to use for this {@link LoggingAppender}. */
  protected LoggingOptions getLoggingOptions() {
    if (loggingOptions == null) {
      if (Strings.isNullOrEmpty(credentialsFile)) {
        loggingOptions = LoggingOptions.getDefaultInstance();
      } else {
        try {
          loggingOptions =
              LoggingOptions.newBuilder()
                  .setCredentials(
                      GoogleCredentials.fromStream(new FileInputStream(credentialsFile)))
                  .build();
        } catch (IOException e) {
          throw new RuntimeException(
              String.format(
                  "Could not read credentials file %s. Please verify that the file exists and is a valid Google credentials file.",
                  credentialsFile),
              e);
        }
      }
    }
    return loggingOptions;
  }

  private LogEntry logEntryFor(ILoggingEvent e) {
    StringBuilder payload = new StringBuilder().append(e.getFormattedMessage()).append('\n');
    writeStack(e.getThrowableProxy(), "", payload);

    Level level = e.getLevel();
    Severity severity = severityFor(level);

    Map<String, Object> jsonContent = new HashMap<>();
    jsonContent.put("message", payload.toString().trim());
    if (severity == Severity.ERROR) {
      jsonContent.put("@type", TYPE);
    }
    LogEntry.Builder builder =
        LogEntry.newBuilder(Payload.JsonPayload.of(jsonContent))
            .setTimestamp(e.getTimeStamp())
            .setSeverity(severity);
    builder
        .addLabel(LEVEL_NAME_KEY, level.toString())
        .addLabel(LEVEL_VALUE_KEY, String.valueOf(level.toInt()))
        .addLabel(LOGGER_NAME_KEY, e.getLoggerName());

    if (loggingEnhancers != null) {
      for (LoggingEnhancer enhancer : loggingEnhancers) {
        enhancer.enhanceLogEntry(builder);
      }
    }

    if (loggingEventEnhancers != null) {
      for (LoggingEventEnhancer enhancer : loggingEventEnhancers) {
        enhancer.enhanceLogEntry(builder, e);
      }
    }

    return builder.build();
  }

  @InternalApi("Visible for testing")
  static void writeStack(IThrowableProxy throwProxy, String prefix, StringBuilder payload) {
    if (throwProxy == null) {
      return;
    }
    payload
        .append(prefix)
        .append(throwProxy.getClassName())
        .append(": ")
        .append(throwProxy.getMessage())
        .append('\n');
    StackTraceElementProxy[] trace = throwProxy.getStackTraceElementProxyArray();
    if (trace == null) {
      trace = new StackTraceElementProxy[0];
    }

    int commonFrames = throwProxy.getCommonFrames();
    int printFrames = trace.length - commonFrames;
    for (int i = 0; i < printFrames; i++) {
      payload.append("    ").append(trace[i]).append('\n');
    }
    if (commonFrames != 0) {
      payload.append("    ... ").append(commonFrames).append(" common frames elided\n");
    }

    writeStack(throwProxy.getCause(), "caused by: ", payload);
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
