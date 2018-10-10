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

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.ErrorManager;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * A logging handler that outputs logs generated with {@link java.util.logging.Logger}
 * to Stackdriver Logging.
 *
 * <p>Java logging levels (see {@link java.util.logging.Level}) are mapped to the following Google
 * Stackdriver Logging severities:
 *
 * <table summary="Mapping of Java logging level to Stackdriver Logging severities">
 * <tr><th width="50%">Java Level</th><th>Stackdriver Logging Severity</th></tr>
 * <tr><td>SEVERE</td><td>ERROR</td></tr>
 * <tr><td>WARNING</td><td>WARNING</td></tr>
 * <tr><td>INFO</td><td>INFO</td></tr>
 * <tr><td>CONFIG</td><td>INFO</td></tr>
 * <tr><td>FINE</td><td>DEBUG</td></tr>
 * <tr><td>FINER</td><td>DEBUG</td></tr>
 * <tr><td>FINEST</td><td>DEBUG</td></tr>
 * </table>
 *
 * <p>Original Java logging levels are added as labels (with {@code levelName} and {@code
 * levelValue} keys, respectively) to the corresponding Stackdriver Logging {@link LogEntry}. You
 * can read entry labels using {@link LogEntry#getLabels()}. To use logging levels that correspond
 * to Stackdriver Logging severities you can use {@link LoggingLevel}.
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
 *       When a log with this level is published, logs are transmitted to the Stackdriver Logging
 *       service (defaults to {@link LoggingLevel#ERROR}).
 *   <li>{@code com.google.cloud.logging.LoggingHandler.enhancers} specifies a comma separated list
 *       of {@link LoggingEnhancer} classes. This handler will call each enhancer list whenever it builds a
 *       {@link LogEntry} instance (defaults to empty list).
 *   <li>{@code com.google.cloud.logging.LoggingHandler.resourceType} the type name to use when
 *       creating the default {@link MonitoredResource} (defaults to auto-detected resource type,
 *       else "global").
 *   <li>{@code com.google.cloud.logging.Synchronicity} the synchronicity of the write method to use
 *       to write logs to the Stackdriver Logging service (defaults to {@link Synchronicity#ASYNC}).
 * </ul>
 *
 * <p>To add a {@code LoggingHandler} to an existing {@link Logger} and be sure to avoid infinite
 * recursion when logging, use the {@link #addHandler(Logger, LoggingHandler)} method. Alternatively
 * you can add the handler via {@code logging.properties}. For example using the following line:
 *
 * <pre>
 * {@code com.example.mypackage.handlers=com.google.cloud.logging.LoggingHandler}
 * </pre>
 */
public class LoggingHandler extends Handler {

  private static final String HANDLERS_PROPERTY = "handlers";
  private static final String ROOT_LOGGER_NAME = "";
  private static final String[] NO_HANDLERS = new String[0];
  private static final String LEVEL_NAME_KEY = "levelName";
  private static final String LEVEL_VALUE_KEY = "levelValue";

  private final List<LoggingEnhancer> enhancers;
  private final LoggingOptions loggingOptions;

  private volatile Logging logging;

  // Logs with the same severity with the base could be more efficiently sent to Stackdriver.
  // Defaults to level of the handler or Level.FINEST if the handler is set to Level.ALL.
  // Currently there is no way to modify the base level, see
  // https://github.com/googleapis/google-cloud-java/issues/1740 .
  private final Level baseLevel;

  private volatile Level flushLevel;

  private WriteOption[] defaultWriteOptions;

  /** Creates an handler that publishes messages to Stackdriver Logging. */
  public LoggingHandler() {
    this(null, null, null);
  }

  /**
   * Creates a handler that publishes messages to Stackdriver Logging.
   *
   * @param log the name of the log to which log entries are written
   */
  public LoggingHandler(String log) {
    this(log, null, null);
  }

  /**
   * Creates a handler that publishes messages to Stackdriver Logging.
   *
   * @param log the name of the log to which log entries are written
   * @param options options for the Stackdriver Logging service
   */
  public LoggingHandler(String log, LoggingOptions options) {
    this(log, options, null);
  }

  /**
   * Creates a handler that publishes messages to Stackdriver Logging.
   *
   * @param log the name of the log to which log entries are written
   * @param options options for the Stackdriver Logging service
   * @param monitoredResource the monitored resource to which log entries refer. If it is null then
   *     a default resource is created based on the project ID and deployment environment.
   */
  public LoggingHandler(String log, LoggingOptions options, MonitoredResource monitoredResource) {
    this(log, options, monitoredResource, null);
  }

  /**
   * Creates a handler that publishes messages to Stackdriver Logging.
   *
   * @param log the name of the log to which log entries are written
   * @param options options for the Stackdriver Logging service
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
    try {
      loggingOptions = options != null ? options : LoggingOptions.getDefaultInstance();
      LoggingConfig config = new LoggingConfig(getClass().getName());
      setFilter(config.getFilter());
      setFormatter(config.getFormatter());
      Level level = config.getLogLevel();
      setLevel(level);
      baseLevel = level.equals(Level.ALL) ? Level.FINEST : level;
      flushLevel = config.getFlushLevel();
      String logName = log != null ? log : config.getLogName();

      MonitoredResource resource =
          firstNonNull(
              monitoredResource, config.getMonitoredResource(loggingOptions.getProjectId()));
      defaultWriteOptions =
          new WriteOption[] {
          WriteOption.logName(logName),
          WriteOption.resource(resource),
            WriteOption.labels(
                ImmutableMap.of(
                    LEVEL_NAME_KEY,
                    baseLevel.getName(),
                    LEVEL_VALUE_KEY,
                    String.valueOf(baseLevel.intValue())))
          };

      getLogging().setFlushSeverity(severityFor(flushLevel));
      getLogging().setWriteSynchronicity(config.getSynchronicity());

      this.enhancers = new LinkedList<>();

      List<LoggingEnhancer> enhancersParam = firstNonNull(enhancers,
          firstNonNull(config.getEnhancers(), Collections.<LoggingEnhancer>emptyList()));

      this.enhancers.addAll(enhancersParam);

      List<LoggingEnhancer> loggingEnhancers = MonitoredResourceUtil.getResourceEnhancers();
      if (loggingEnhancers != null) {
        this.enhancers.addAll(loggingEnhancers);
      }
    } catch (Exception ex) {
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
    // HACK warning: this logger doesn't work like normal loggers; the log calls are issued
    // from another class instead of by itself, so it can't be configured off like normal
    // loggers. We have to check the source class name instead.
    if ("io.netty.handler.codec.http2.Http2FrameLogger".equals(record.getSourceClassName())) {
      return;
    }
    LogEntry logEntry;
    try {
      logEntry = logEntryFor(record);
    } catch (Exception ex) {
      getErrorManager().error(null, ex, ErrorManager.FORMAT_FAILURE);
      return;
    }
    if (logEntry != null) {
      try {
        getLogging().write(ImmutableList.of(logEntry), defaultWriteOptions);
      } catch (Exception ex) {
        getErrorManager().error(null, ex, ErrorManager.WRITE_FAILURE);
      }
    }
  }

  private LogEntry logEntryFor(LogRecord record) throws Exception {
    String payload = getFormatter().format(record);
    Level level = record.getLevel();
    LogEntry.Builder builder =
        LogEntry.newBuilder(Payload.StringPayload.of(payload))
            .setTimestamp(record.getMillis())
            .setSeverity(severityFor(level));

    if (!baseLevel.equals(level)) {
      builder
          .addLabel("levelName", level.getName())
          .addLabel("levelValue", String.valueOf(level.intValue()));
    }

    for (LoggingEnhancer enhancer : enhancers) {
      enhancer.enhanceLogEntry(builder);
    }
    return builder.build();
  }

  @Override
  public void flush() {
    try {
      getLogging().flush();
    } catch (Exception ex) {
      getErrorManager().error(null, ex, ErrorManager.FLUSH_FAILURE);
    }
  }

  /** Closes the handler and the associated {@link Logging} object. */
  @Override
  public synchronized void close() throws SecurityException {
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
   * @param flushLevel minimum log level to trigger flush
   */
  public void setFlushLevel(Level flushLevel) {
    this.flushLevel = flushLevel;
    getLogging().setFlushSeverity(severityFor(flushLevel));
  }

  /**
   * Sets synchronicity of logging writes. By default, writes are asynchronous.
   * @param synchronicity {@link Synchronicity}
   */
  public void setSynchronicity(Synchronicity synchronicity) {
    getLogging().setWriteSynchronicity(synchronicity);
  }

  /** Get the flush log level. */
  public Synchronicity getSynchronicity() {
    return getLogging().getWriteSynchronicity();
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

    switch (level.intValue()) {
        // FINEST
      case 300:
        return Severity.DEBUG;
        // FINER
      case 400:
        return Severity.DEBUG;
        // FINE
      case 500:
        return Severity.DEBUG;
        // CONFIG
      case 700:
        return Severity.INFO;
        // INFO
      case 800:
        return Severity.INFO;
        // WARNING
      case 900:
        return Severity.WARNING;
        // SEVERE
      case 1000:
        return Severity.ERROR;
      default:
        return Severity.DEFAULT;
    }
  }

  /**
   * Returns an instance of the logging service.
   */
  private Logging getLogging() {
    if (logging == null) {
      synchronized (this) {
        if (logging == null) {
          logging = loggingOptions.getService();
        }
      }
    }
    return logging;
  }
}
