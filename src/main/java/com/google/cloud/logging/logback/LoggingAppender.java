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
import com.google.cloud.logging.Instrumentation;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.LoggingEnhancer;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.MonitoredResourceUtil;
import com.google.cloud.logging.Payload;
import com.google.cloud.logging.Severity;
import com.google.cloud.logging.Synchronicity;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
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
 *         &lt;!-- Optional: defaults to {@code "java.log"} --&gt;
 *         &lt;log&gt;application.log&lt;/log&gt;
 *
 *         &lt;!-- Optional: defaults to {@code "ERROR"} --&gt;
 *         &lt;flushLevel&gt;WARNING&lt;/flushLevel&gt;
 *
 *         &lt;!-- Optional: defaults to {@code ASYNC} --&gt;
 *         &lt;writeSynchronicity&gt;SYNC&lt;/writeSynchronicity&gt;
 *
 *         &lt;!-- Optional: defaults to {@code true} --&gt;
 *         &lt;autoPopulateMetadata&gt;false&lt;/autoPopulateMetadata&gt;
 *
 *         &lt;!-- Optional: defaults to {@code false} --&gt;
 *         &lt;redirectToStdout&gt;true&lt;/redirectToStdout&gt;
 *
 *         &lt;!-- Optional: auto detects on App Engine Flex, Standard, GCE and GKE, defaults to "global". See <a
 *         href=
 * "https://cloud.google.com/logging/docs/api/v2/resource-list">supported resource types</a> --&gt;
 *         &lt;resourceType&gt;&lt;/resourceType&gt;
 *
 *         &lt;!-- Optional: defaults to the default credentials of the environment --&gt;
 *         &lt;credentialsFile&gt;/path/to/credentials/file&lt;/credentialsFile&gt;
 *
 *         &lt;!-- Optional: defaults to the project id obtained during authentication process. Project id is also used to construct resource name of the log entries --&gt;
 *         &lt;logDestinationProjectId&gt;String&lt;/logDestinationProjectId&gt;
 *
 *         &lt;!-- Optional: add custom labels to log entries using {@link LoggingEnhancer} classes --&gt;
 *         &lt;enhancer&gt;com.example.enhancers.TestLoggingEnhancer&lt/enhancer&gt;
 *         &lt;enhancer&gt;com.example.enhancers.AnotherEnhancer&lt/enhancer&gt;
 *
 *         &lt;!-- Optional: specifies if a batch's valid entries should be written even if some other entry failed due to an error. Defaults to {@code true} --&gt;
 *         &lt;partialSuccess&gt;true&lt;/partialSuccess&gt;
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
  public static final String JAVA_LOGBACK_LIBRARY_NAME = "java-logback";
  // Using release-please annotations to update DEFAULT_INSTRUMENTATION_VERSION with latest version.
  // See
  // https://github.com/googleapis/release-please/blob/main/docs/customizing.md#updating-arbitrary-files
  // {x-version-update-start:google-cloud-logging-logback:current}
  public static final String DEFAULT_INSTRUMENTATION_VERSION = "0.129.5-alpha";
  // {x-version-update-end}
  private static boolean instrumentationAdded = false;
  private static Object instrumentationLock = new Object();

  private volatile Logging logging;
  private LoggingOptions loggingOptions;
  private MonitoredResource monitoredResource;
  private List<LoggingEnhancer> loggingEnhancers;
  private List<LoggingEventEnhancer> loggingEventEnhancers;
  private WriteOption[] defaultWriteOptions;

  private Level flushLevel;
  private String log;
  private String resourceType;
  private String credentialsFile;
  private String logDestinationProjectId;
  private boolean autoPopulateMetadata = true;
  private boolean redirectToStdout = false;
  private boolean partialSuccess = true;
  private Synchronicity writeSyncFlag = Synchronicity.ASYNC;
  private final Set<String> enhancerClassNames = new HashSet<>();
  private final Set<String> loggingEventEnhancerClassNames = new HashSet<>();

  /**
   * Sets a threshold for log severity level to flush all log entries that were batched so far.
   *
   * <p>Defaults to Error.
   *
   * @param flushLevel Logback log level
   */
  public void setFlushLevel(Level flushLevel) {
    this.flushLevel = flushLevel;
  }

  /**
   * Sets the LOG_ID part of the <a href="log
   * name">https://cloud.google.com/logging/docs/reference/v2/rest/v2/LogEntry#FIELDS.log_name</a>
   * for which the logs are ingested.
   *
   * @param log LOG_ID part of the name
   */
  public void setLog(String log) {
    this.log = log;
  }

  /**
   * Sets the name of the monitored resource (Optional). If not define the appender will try to
   * identify the resource type automatically. Currently support resource types include "gae_app",
   * "gce_instance", "k8s_container", "cloud_run_revision" and "cloud_function". If the appender
   * fails to identify the resource type it will be set to "global".
   *
   * <p>Must be a one of the <a href=
   * "https://cloud.google.com/logging/docs/api/v2/resource-list">supported</a> resource types.
   *
   * @param resourceType the name of the monitored resource.
   */
  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  /**
   * Sets the path to the <a href="credential
   * file">https://cloud.google.com/iam/docs/creating-managing-service-account-keys</a>. If not set
   * the appender will use {@link GoogleCredentials#getApplicationDefault()} to authenticate.
   *
   * @param credentialsFile the path to the credentials file.
   */
  public void setCredentialsFile(String credentialsFile) {
    this.credentialsFile = credentialsFile;
  }

  /**
   * Sets project ID to be used to customize log destination name for written log entries.
   *
   * @param projectId The project ID to be used to construct the resource destination name for log
   *     entries.
   */
  public void setLogDestinationProjectId(String projectId) {
    this.logDestinationProjectId = projectId;
  }

  /**
   * Sets the log ingestion mode. It can be one of the {@link Synchronicity} values.
   *
   * <p>Default to {@code Synchronicity.ASYNC}
   *
   * @param flag the new ingestion mode.
   */
  public void setWriteSynchronicity(Synchronicity flag) {
    this.writeSyncFlag = flag;
  }

  /**
   * Sets the automatic population of metadata fields for ingested logs.
   *
   * <p>Default to {@code true}.
   *
   * @param flag the metadata auto-population flag.
   */
  public void setAutoPopulateMetadata(boolean flag) {
    autoPopulateMetadata = flag;
  }

  /**
   * Sets the redirect of the appender's output to STDOUT instead of ingesting logs to Cloud Logging
   * using Logging API.
   *
   * <p>Default to {@code false}.
   *
   * @param flag the redirect flag.
   */
  public void setRedirectToStdout(boolean flag) {
    redirectToStdout = flag;
  }

  /**
   * Sets the flag indicating if a batch's valid entries should be written even if some other entry
   * failed due to an error.
   *
   * <p>Default to {@code true}.
   *
   * @param flag the partialSuccess flag.
   */
  public void setPartialSuccess(boolean flag) {
    partialSuccess = flag;
  }

  /** Add extra labels using classes that implement {@link LoggingEnhancer}. */
  public void addEnhancer(String enhancerClassName) {
    this.enhancerClassNames.add(enhancerClassName);
  }

  public void addLoggingEventEnhancer(String enhancerClassName) {
    this.loggingEventEnhancerClassNames.add(enhancerClassName);
  }

  /**
   * Returns the current value of the ingestion mode.
   *
   * <p>The method is deprecated. Use appender configuration to setup the ingestion
   *
   * @return a {@link Synchronicity} value of the ingestion module.
   */
  @Deprecated
  public Synchronicity getWriteSynchronicity() {
    return (this.writeSyncFlag != null) ? this.writeSyncFlag : Synchronicity.ASYNC;
  }

  private void setupMonitoredResource() {
    if (monitoredResource == null && autoPopulateMetadata) {
      monitoredResource = MonitoredResourceUtil.getResource(getProjectId(), resourceType);
    }
  }

  @InternalApi("Visible for testing")
  void setupMonitoredResource(MonitoredResource monitoredResource) {
    this.monitoredResource = monitoredResource;
  }

  private Level getFlushLevel() {
    return (flushLevel != null) ? flushLevel : Level.ERROR;
  }

  private String getLogName() {
    return (log != null) ? log : "java.log";
  }

  private List<LoggingEnhancer> getLoggingEnhancers() {
    return getEnhancers(enhancerClassNames, LoggingEnhancer.class);
  }

  private List<LoggingEventEnhancer> getLoggingEventEnhancers() {
    if (loggingEventEnhancerClassNames.isEmpty()) {
      return DEFAULT_LOGGING_EVENT_ENHANCERS;
    } else {
      return getEnhancers(loggingEventEnhancerClassNames, LoggingEventEnhancer.class);
    }
  }

  private <T> List<T> getEnhancers(Set<String> classNames, Class<T> classOfT) {
    List<T> enhancers = new ArrayList<>();
    if (classNames != null) {
      for (String className : classNames) {
        if (className != null) {
          try {
            T enhancer =
                Loader.loadClass(className.trim())
                    .asSubclass(classOfT)
                    .getDeclaredConstructor()
                    .newInstance();
            enhancers.add(enhancer);
          } catch (Exception ex) {
            // invalid className: ignore
          }
        }
      }
    }
    return enhancers;
  }

  /** Initialize and configure the cloud logging service. */
  @Override
  public synchronized void start() {
    if (isStarted()) {
      return;
    }

    setupMonitoredResource();

    defaultWriteOptions =
        new WriteOption[] {
          WriteOption.logName(getLogName()),
          WriteOption.resource(monitoredResource),
          WriteOption.partialSuccess(partialSuccess)
        };
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
    List<LogEntry> entriesList = new ArrayList<LogEntry>();
    entriesList.add(logEntryFor(e));
    // Check if instrumentation was already added - if not, create a log entry with instrumentation
    // data
    if (!setInstrumentationStatus(true)) {
      entriesList.add(
          Instrumentation.createDiagnosticEntry(
              JAVA_LOGBACK_LIBRARY_NAME, DEFAULT_INSTRUMENTATION_VERSION));
    }
    Iterable<LogEntry> entries = entriesList;
    if (autoPopulateMetadata) {
      entries =
          getLogging()
              .populateMetadata(
                  entries,
                  monitoredResource,
                  "com.google.cloud.logging",
                  "jdk",
                  "sun",
                  "java",
                  "ch.qos.logback");
    }
    if (redirectToStdout) {
      for (LogEntry entry : entries) {
        System.out.println(entry.toStructuredJsonString());
      }
    } else {
      getLogging().write(entries, defaultWriteOptions);
    }
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
          logging.setWriteSynchronicity(writeSyncFlag);
        }
      }
    }
    return logging;
  }

  /** Flushes any pending asynchronous logging writes. */
  @Deprecated
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
      LoggingOptions.Builder builder = LoggingOptions.newBuilder();
      builder.setProjectId(logDestinationProjectId);
      if (!Strings.isNullOrEmpty(credentialsFile)) {
        try {
          builder.setCredentials(
              GoogleCredentials.fromStream(new FileInputStream(credentialsFile)));
        } catch (IOException e) {
          throw new RuntimeException(
              String.format(
                  "Could not read credentials file %s. Please verify that the file exists and is a valid Google credentials file.",
                  credentialsFile),
              e);
        }
      }
      // opt-out metadata auto-population to control it in the appender code
      builder.setAutoPopulateMetadata(false);
      loggingOptions = builder.build();
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
            .setTimestamp(Instant.ofEpochMilli(e.getTimeStamp()))
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

  /**
   * The package-private helper method used to set the flag which indicates if instrumentation info
   * already written or not.
   *
   * @returns The value of the flag before it was set.
   */
  static boolean setInstrumentationStatus(boolean value) {
    if (instrumentationAdded == value) return instrumentationAdded;
    synchronized (instrumentationLock) {
      boolean current = instrumentationAdded;
      instrumentationAdded = value;
      return current;
    }
  }
}
