/*
 * Copyright 2016 Google LLC
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

import static com.google.common.base.MoreObjects.firstNonNull;
import static java.util.Arrays.stream;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.ErrorManager;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.jspecify.nullness.Nullable;

/**
 * A logging handler that outputs logs generated with {@link java.util.logging.Logger} to Cloud
 * Logging.
 *
 * <p>Java logging levels (see {@link java.util.logging.Level}) are mapped to the following Google
 * Cloud Logging severities:
 *
 * <table summary="Mapping of Java logging level to Cloud Logging severities">
 * <tr>
 * <th width="50%">Java Level</th>
 * <th>Cloud Logging Severity</th>
 * </tr>
 * <tr>
 * <td>SEVERE</td>
 * <td>ERROR</td>
 * </tr>
 * <tr>
 * <td>WARNING</td>
 * <td>WARNING</td>
 * </tr>
 * <tr>
 * <td>INFO</td>
 * <td>INFO</td>
 * </tr>
 * <tr>
 * <td>CONFIG</td>
 * <td>INFO</td>
 * </tr>
 * <tr>
 * <td>FINE</td>
 * <td>DEBUG</td>
 * </tr>
 * <tr>
 * <td>FINER</td>
 * <td>DEBUG</td>
 * </tr>
 * <tr>
 * <td>FINEST</td>
 * <td>DEBUG</td>
 * </tr>
 * </table>
 *
 * <p>Original Java logging levels are added as labels (with {@code levelName} and {@code
 * levelValue} keys, respectively) to the corresponding Cloud Logging {@link LogEntry}. You can read
 * entry labels using {@link LogEntry#getLabels()}. To use logging levels that correspond to Cloud
 * Logging severities you can use {@link LoggingLevel}.
 *
 * <p><b>Configuration</b>: By default each {@code LoggingHandler} is initialized using the
 * following {@code LogManager} configuration properties (that you can set in the {@code
 * logging.properties} file). If properties are not defined (or have invalid values) then the
 * specified default values are used.
 *
 * <ul>
 *   <li>{@code com.google.cloud.logging.LoggingHandler.log} the log name (defaults to {@code
 *       java.log}).
 *   <li>{@code com.google.cloud.logging.LoggingHandler.level} specifies the default level for the
 *       handler (defaults to {@code Level.INFO}).
 *   <li>{@code com.google.cloud.logging.LoggingHandler.filter} specifies the name of a {@link
 *       Filter} class to use (defaults to no filter).
 *   <li>{@code com.google.cloud.logging.LoggingHandler.formatter} specifies the name of a {@link
 *       Formatter} class to use (defaults to {@link SimpleFormatter}).
 *   <li>{@code com.google.cloud.logging.LoggingHandler.flushLevel} specifies the flush log level.
 *       When a log with this level is published, logs are transmitted to the Cloud Logging service
 *       (defaults to {@link LoggingLevel#ERROR}).
 *   <li>{@code com.google.cloud.logging.LoggingHandler.enhancers} specifies a comma separated list
 *       of {@link LoggingEnhancer} classes. This handler will call each enhancer list whenever it
 *       builds a {@link LogEntry} instance (defaults to empty list).
 *   <li>{@code com.google.cloud.logging.LoggingHandler.resourceType} the type name to use when
 *       creating the default {@link MonitoredResource} (defaults to auto-detected resource type,
 *       else "global").
 *   <li>{@code com.google.cloud.logging.Synchronicity} the synchronicity of the write method to use
 *       to write logs to the Cloud Logging service (defaults to {@link Synchronicity#ASYNC}).
 *   <li>{@code com.google.cloud.logging.LoggingHandler.autoPopulateMetadata} is a boolean flag that
 *       opts-out the population of the log entries metadata before the logs are sent to Cloud
 *       Logging (defaults to {@code true}).
 *   <li>{@code com.google.cloud.logging.LoggingHandler.redirectToStdout} is a boolean flag that
 *       opts-in redirecting the output of the handler to STDOUT instead of ingesting logs to Cloud
 *       Logging using Logging API (defaults to {@code false}). Redirecting logs can be used in
 *       Google Cloud environments with installed logging agent to delegate log ingestions to the
 *       agent. Redirected logs are formatted as one line Json string following the structured
 *       logging guidelines. This flag is deprecated; use {@code
 *       com.google.cloud.logging.LoggingHandler.logTarget} instead.
 *   <li>{@code com.google.cloud.logging.LoggingHandler.logTarget} is an enumeration controlling log
 *       routing (defaults to {@code CLOUD_LOGGING}). If set to STDOUT or STDERR, logs will be
 *       printed to the corresponding stream in the Json format that can be parsed by the logging
 *       agent. If set to CLOUD_LOGGING, logs will be sent directly to the Google Cloud Logging API.
 * </ul>
 *
 * <p>To add a {@code LoggingHandler} to an existing {@link Logger} and be sure to avoid infinite
 * recursion when logging, use the {@link #addHandler(Logger, LoggingHandler)} method. Alternatively
 * you can add the handler via {@code logging.properties}. For example using the following line:
 *
 * <pre>
 * {@code com.example.mypackage.handlers=com.google.cloud.logging.LoggingHandler}
 * </pre>
 *
 * @see <a href="https://cloud.google.com/logging/docs/structured-logging">Structured logging</a>
 */
public class LoggingHandler extends Handler {

  private static final String LEVEL_NAME_KEY = "levelName";
  private static final String LEVEL_VALUE_KEY = "levelValue";

  /** Where to send logs. */
  public enum LogTarget {
    /** Sends logs to the Cloud Logging API. */
    CLOUD_LOGGING,
    /** Sends JSON-formatted logs to stdout, for use with the Google Cloud logging agent. */
    STDOUT,
    /** Sends JSON-formatted logs to stderr, for use with the Google Cloud logging agent. */
    STDERR
  }

  private final List<LoggingEnhancer> enhancers;
  private final LoggingOptions loggingOptions;

  private volatile Logging logging;

  // Logs with the same severity with the base could be more efficiently sent to
  // Cloud.
  // Defaults to level of the handler or Level.FINEST if the handler is set to
  // Level.ALL.
  // Currently there is no way to modify the base level, see
  // https://github.com/googleapis/google-cloud-java/issues/1740 .
  private final Level baseLevel;

  private volatile Level flushLevel;

  private volatile Boolean autoPopulateMetadata;
  private volatile LogTarget logTarget;

  private final WriteOption[] defaultWriteOptions;

  /** Creates an handler that publishes messages to Cloud Logging. */
  public LoggingHandler() {
    this(null, null, null);
  }

  /**
   * Creates a handler that publishes messages to Cloud Logging.
   *
   * @param log the name of the log to which log entries are written
   */
  public LoggingHandler(String log) {
    this(log, null, null);
  }

  /**
   * Creates a handler that publishes messages to Cloud Logging.
   *
   * @param log the name of the log to which log entries are written
   * @param options options for the Cloud Logging service
   */
  public LoggingHandler(String log, LoggingOptions options) {
    this(log, options, null);
  }

  /**
   * Creates a handler that publishes messages to Cloud Logging.
   *
   * @param log the name of the log to which log entries are written
   * @param options options for the Cloud Logging service
   * @param monitoredResource the monitored resource to which log entries refer. If it is null then
   *     a default resource is created based on the project ID and deployment environment.
   */
  public LoggingHandler(String log, LoggingOptions options, MonitoredResource monitoredResource) {
    this(log, options, monitoredResource, null, null);
  }

  /**
   * Creates a handler that publishes messages to Cloud Logging.
   *
   * @param log the name of the log to which log entries are written
   * @param options options for the Cloud Logging service
   * @param monitoredResource the monitored resource to which log entries refer. If it is null then
   *     a default resource is created based on the project ID and deployment environment.
   * @param enhancers List of {@link LoggingEnhancer} instances used to enhance any{@link LogEntry}
   *     instances built by this handler.
   */
  public LoggingHandler(
      String log,
      LoggingOptions options,
      MonitoredResource monitoredResource,
      List<LoggingEnhancer> enhancers) {
    this(log, options, monitoredResource, enhancers, null);
  }

  /**
   * Creates a handler that publishes messages to Cloud Logging. Auto-population of the logs
   * metadata can be opted-out in {@code options} argument or in the configuration file. At least
   * one flag {@link LoggingOptions} or {@link LoggingConfig} has to be explicitly set to {@code
   * false} in order to opt-out the metadata auto-population.
   *
   * @param log the name of the log to which log entries are written
   * @param options options for the Cloud Logging service
   * @param monitoredResource the monitored resource to which log entries refer. If it is null then
   *     a default resource is created based on the project ID and deployment environment.
   * @param enhancers List of {@link LoggingEnhancer} instances used to enhance any{@link LogEntry}
   *     instances built by this handler.
   * @param destination the log destination {@link LogDestinationName} (see 'logName' parameter in
   *     https://cloud.google.com/logging/docs/reference/v2/rest/v2/LogEntry)
   */
  public LoggingHandler(
      String log,
      LoggingOptions options,
      MonitoredResource monitoredResource,
      List<LoggingEnhancer> enhancers,
      LogDestinationName destination) {
    try {
      loggingOptions = options != null ? options : LoggingOptions.getDefaultInstance();
      LoggingConfig config = new LoggingConfig(getClass().getName());
      setFilter(config.getFilter());
      setFormatter(config.getFormatter());
      Level level = config.getLogLevel();
      setLevel(level);
      baseLevel = level.equals(Level.ALL) ? Level.FINEST : level;
      flushLevel = config.getFlushLevel();
      Boolean f1 = loggingOptions.getAutoPopulateMetadata();
      Boolean f2 = config.getAutoPopulateMetadata();
      autoPopulateMetadata = isTrueOrNull(f1) && isTrueOrNull(f2);
      logTarget =
          config
              .getLogTarget()
              .orElse(
                  firstNonNull(config.getRedirectToStdout(), Boolean.FALSE)
                      ? LogTarget.STDOUT
                      : LogTarget.CLOUD_LOGGING);
      String logName = log != null ? log : config.getLogName();
      MonitoredResource resource =
          firstNonNull(
              monitoredResource, config.getMonitoredResource(loggingOptions.getProjectId()));
      List<WriteOption> writeOptions = new ArrayList<>();
      writeOptions.add(WriteOption.logName(logName));
      if (resource != null) {
        writeOptions.add(WriteOption.resource(resource));
      }
      writeOptions.add(
          WriteOption.labels(
              ImmutableMap.of(
                  LEVEL_NAME_KEY,
                  baseLevel.getName(),
                  LEVEL_VALUE_KEY,
                  String.valueOf(baseLevel.intValue()))));
      if (destination != null) {
        writeOptions.add(WriteOption.destination(destination));
      }
      defaultWriteOptions = Iterables.toArray(writeOptions, WriteOption.class);

      logging = loggingOptions.getService();
      logging.setFlushSeverity(severityFor(flushLevel));
      logging.setWriteSynchronicity(config.getSynchronicity());

      this.enhancers = new ArrayList<>();

      List<LoggingEnhancer> enhancersParam =
          firstNonNull(enhancers, firstNonNull(config.getEnhancers(), ImmutableList.of()));

      this.enhancers.addAll(enhancersParam);

      // In the following line getResourceEnhancers() never returns null (@NotNull
      // attribute)
      List<LoggingEnhancer> loggingEnhancers = MonitoredResourceUtil.getResourceEnhancers();
      this.enhancers.addAll(loggingEnhancers);
    } catch (RuntimeException ex) {
      reportError(null, ex, ErrorManager.OPEN_FAILURE);
      throw ex;
    }
  }

  @Override
  public void publish(LogRecord record) {
    // check that the log record should be logged
    if (!isLoggable(record)) {
      return;
    }
    // HACK warning: this logger doesn't work like normal loggers; the log calls are
    // issued
    // from another class instead of by itself, so it can't be configured off like
    // normal
    // loggers. We have to check the source class name instead.
    if ("io.netty.handler.codec.http2.Http2FrameLogger".equals(record.getSourceClassName())) {
      return;
    }
    LogEntry logEntry;
    try {
      logEntry = logEntryFor(record).build();
    } catch (RuntimeException ex) {
      getErrorManager().error(null, ex, ErrorManager.FORMAT_FAILURE);
      return;
    }
    if (logEntry != null) {
      try {
        Iterable<LogEntry> logEntries =
            logTarget == LogTarget.CLOUD_LOGGING
                ? ImmutableList.of(logEntry)
                : Instrumentation.populateInstrumentationInfo(ImmutableList.of(logEntry)).y();
        if (autoPopulateMetadata) {
          logEntries =
              logging.populateMetadata(
                  logEntries, getMonitoredResource(), "com.google.cloud.logging", "java");
        }
        switch (logTarget) {
          case STDOUT:
            logEntries.forEach(log -> System.out.println(log.toStructuredJsonString()));
            break;
          case STDERR:
            logEntries.forEach(log -> System.err.println(log.toStructuredJsonString()));
            break;
          case CLOUD_LOGGING:
            logging.write(logEntries, defaultWriteOptions);
            break;
        }
      } catch (RuntimeException ex) {
        getErrorManager().error(null, ex, ErrorManager.WRITE_FAILURE);
      }
    }
  }

  private @Nullable MonitoredResource getMonitoredResource() {
    Optional<WriteOption> resourceOption =
        stream(defaultWriteOptions)
            .filter(o -> o.getOptionType() == WriteOption.OptionType.RESOURCE)
            .findFirst();
    if (resourceOption.isPresent()) {
      return (MonitoredResource) resourceOption.get().getValue();
    }
    return null;
  }

  protected LogEntry.Builder logEntryFor(LogRecord record) {
    String payload = getFormatter().format(record);
    Level level = record.getLevel();
    LogEntry.Builder builder =
        LogEntry.newBuilder(Payload.StringPayload.of(payload))
            .setTimestamp(Instant.ofEpochMilli(record.getMillis()))
            .setSeverity(severityFor(level));

    if (!baseLevel.equals(level)) {
      builder
          .addLabel("levelName", level.getName())
          .addLabel("levelValue", String.valueOf(level.intValue()));
    }

    for (LoggingEnhancer enhancer : enhancers) {
      enhancer.enhanceLogEntry(builder);
    }
    return builder;
  }

  @Override
  public void flush() {
    try {
      logging.flush();
    } catch (RuntimeException ex) {
      getErrorManager().error(null, ex, ErrorManager.FLUSH_FAILURE);
    }
  }

  /** Closes the handler and the associated {@link Logging} object. */
  @Override
  public synchronized void close() {
    if (logging != null) {
      try {
        logging.close();
      } catch (Exception ex) {
        // ignore
      }
    }
    logging = null;
  }

  /** Get the flush log level. */
  public Level getFlushLevel() {
    return flushLevel;
  }

  /**
   * Sets minimum logging level to log immediately and flush any pending writes.
   *
   * @param flushLevel minimum log level to trigger flush
   */
  public void setFlushLevel(Level flushLevel) {
    this.flushLevel = flushLevel;
    logging.setFlushSeverity(severityFor(flushLevel));
  }

  /**
   * Sets synchronicity of logging writes. By default, writes are asynchronous.
   *
   * @param synchronicity {@link Synchronicity}
   */
  public void setSynchronicity(Synchronicity synchronicity) {
    logging.setWriteSynchronicity(synchronicity);
  }

  /** Get the flush log level. */
  public Synchronicity getSynchronicity() {
    return logging.getWriteSynchronicity();
  }

  /** Sets the metadata auto population flag. */
  public void setAutoPopulateMetadata(boolean value) {
    this.autoPopulateMetadata = value;
  }

  /** Gets the metadata auto population flag. */
  public Boolean getAutoPopulateMetadata() {
    return this.autoPopulateMetadata;
  }

  /**
   * Enable/disable redirection to STDOUT. If set to {@code true}, logs will be printed to STDOUT in
   * the Json format that can be parsed by the logging agent. If set to {@code false}, logs will be
   * ingested to Cloud Logging by calling Logging API.
   *
   * <p>This method is mutually exclusive with {@link #setLogTarget(LogTarget)}.
   *
   * @deprecated Use {@link #setLogTarget(LogTarget)}.
   */
  @Deprecated
  public void setRedirectToStdout(boolean value) {
    this.logTarget = value ? LogTarget.STDOUT : LogTarget.CLOUD_LOGGING;
  }

  /*
   * @deprecated Use {@link #getLogTarget()}.
   */
  @Deprecated
  public Boolean getRedirectToStdout() {
    return this.logTarget == LogTarget.STDOUT;
  }

  /**
   * Configure the destination for ingested logs. If set to STDOUT or STDERR, logs will be printed
   * to the corresponding stream in the Json format that can be parsed by the logging agent. If set
   * to CLOUD_LOGGING, logs will be sent directly to the Google Cloud Logging API.
   *
   * <p>This method is mutually exclusive with {@link #setRedirectToStdout(boolean)}.
   */
  public void setLogTarget(LogTarget value) {
    this.logTarget = value;
  }

  public LogTarget getLogTarget() {
    return logTarget;
  }

  /**
   * Adds the provided {@code LoggingHandler} to {@code logger}. Use this method to register Cloud
   * Logging handlers instead of {@link Logger#addHandler(Handler)} to avoid infinite recursion when
   * logging.
   */
  public static void addHandler(Logger logger, LoggingHandler handler) {
    logger.addHandler(handler);
  }

  private static Severity severityFor(Level level) {
    if (level instanceof LoggingLevel) {
      return ((LoggingLevel) level).getSeverity();
    }
    // Choose the severity based on Level range.
    // The assumption is that Level values below maintain same numeric value
    int value = level.intValue();
    if (value <= Level.FINE.intValue()) {
      return Severity.DEBUG;
    } else if (value <= Level.INFO.intValue()) {
      return Severity.INFO;
    } else if (value <= Level.WARNING.intValue()) {
      return Severity.WARNING;
    } else if (value <= Level.SEVERE.intValue()) {
      return Severity.ERROR;
    } else if (value == Level.OFF.intValue()) {
      return Severity.NONE;
    }
    return Severity.DEFAULT;
  }

  private static boolean isTrueOrNull(Boolean b) {
    return b == null || b.equals(Boolean.TRUE);
  }
}
