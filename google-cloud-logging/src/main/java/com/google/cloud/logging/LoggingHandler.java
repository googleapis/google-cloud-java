/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.ErrorManager;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * A logging handler that synchronously outputs logs generated with {@link java.util.logging.Logger}
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
 * <p>Original Java logging levels are added as labels (with {@code levelName} and
 * {@code levelValue} keys, respectively) to the corresponding Stackdriver Logging {@link LogEntry}.
 * You can read entry labels using {@link LogEntry#labels()}. To use logging levels that correspond
 * to Stackdriver Logging severities you can use {@link LoggingLevel}.
 *
 * <p><b>Configuration</b>: By default each {@code LoggingHandler} is initialized using the
 * following {@code LogManager} configuration properties (that you can set in the
 * {@code logging.properties} file). If properties are not defined (or have invalid values) then the
 * specified default values are used.
 * <ul>
 * <li>{@code com.google.cloud.logging.LoggingHandler.log} the log name (defaults to
 *     {@code java.log}).
 * <li>{@code com.google.cloud.logging.LoggingHandler.level} specifies the default level for the
 *     handler (defaults to {@code Level.INFO}).
 * <li>{@code com.google.cloud.logging.LoggingHandler.filter} specifies the name of a {@link Filter}
 *     class to use (defaults to no filter).
 * <li>{@code com.google.cloud.logging.LoggingHandler.formatter} specifies the name of a
 *     {@link Formatter} class to use (defaults to {@link SimpleFormatter}).
 * <li>{@code com.google.cloud.logging.LoggingHandler.flushSize} specifies the maximum size of the
 *     log buffer. Once reached, logs are transmitted to the Stackdriver Logging service (defaults
 *     to 1).
 * <li>{@code com.google.cloud.logging.LoggingHandler.flushLevel} specifies the flush log level.
 *     When a log with this level is published, logs are transmitted to the Stackdriver Logging
 *     service (defaults to {@link LoggingLevel#ERROR}).
 * <li>{@code com.google.cloud.logging.LoggingHandler.enhancers} specifies a comma separated list
 *     of {@link Enhancer} classes. This handler will call each enhancer list whenever it builds
 *     a {@link MonitoredResource} or {@link LogEntry} instance (defaults to empty list).
 * <li>{@code com.google.cloud.logging.LoggingHandler.resourceType} the type name to use when 
 *     creating the default {@link MonitoredResource} (defaults to "global").
 * </ul>
 *
 * <p>To add a {@code LoggingHandler} to an existing {@link Logger} and be sure to avoid infinite
 * recursion when logging, use the {@link #addHandler(Logger, LoggingHandler)} method. Alternatively
 * you can add the handler via {@code logging.properties}. For example using the following line:
 * <pre>
 * {@code com.example.mypackage.handlers=com.google.cloud.logging.LoggingHandler}
 * </pre>
 */
public class LoggingHandler extends Handler {

  private static final String HANDLERS_PROPERTY = "handlers";
  private static final String ROOT_LOGGER_NAME = "";
  private static final String[] NO_HANDLERS = new String[0];

  private static final ThreadLocal<Boolean> inPublishCall = new ThreadLocal<>();

  private final LoggingOptions options;
  private final WriteOption[] writeOptions;
  private List<LogEntry> buffer = new LinkedList<>();
  private volatile Logging logging;
  private Level flushLevel;
  private long flushSize;
  private final List<Enhancer> enhancers;

  /**
   * Creates an handler that publishes messages to Stackdriver Logging.
   */
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
   * @param monitoredResource the monitored resource to which log entries refer. If it is null 
   * then a default resource is created based on the project ID. When creating a default resource, if
   * any {@link Enhancer} instances are configured and then each
   * {@link Enhancer#enhanceMonitoredResource(com.google.cloud.MonitoredResource.Builder)} method
   * is called before building the default resource.
   */
  public LoggingHandler(String log, LoggingOptions options, MonitoredResource monitoredResource) {
    this(log, options, monitoredResource,null);
  }
  
  /**
   * Creates a handler that publishes messages to Stackdriver Logging.
   *
   * @param log the name of the log to which log entries are written
   * @param options options for the Stackdriver Logging service
   * @param monitoredResource the monitored resource to which log entries refer. If it is null 
   * then a default resource is created based on the project ID. When creating a default resource, if
   * any {@link Enhancer} instances are configured and then each
   * {@link Enhancer#enhanceMonitoredResource(com.google.cloud.MonitoredResource.Builder)} method
   * is called before building the default resource.
   * @param enhancers List of {@link Enhancer} instances used to enhance any {@link MonitoredResource}
   * or {@link LogEntry} instances built by this handler.
   */
  public LoggingHandler(String log, LoggingOptions options, MonitoredResource monitoredResource, List<Enhancer> enhancers) {
    try {
      LogConfigHelper helper = new LogConfigHelper();
      String className = getClass().getName();
      this.options = options != null ? options : LoggingOptions.getDefaultInstance();
      this.flushLevel = helper.getLevelProperty(className + ".flushLevel", LoggingLevel.ERROR);
      this.flushSize = helper.getLongProperty(className + ".flushSize", 1L);
      setLevel(helper.getLevelProperty(className + ".level", Level.INFO));
      setFilter(helper.getFilterProperty(className + ".filter", null));
      setFormatter(helper.getFormatterProperty(className + ".formatter", new SimpleFormatter()));
      String logName = firstNonNull(log, helper.getProperty(className + ".log", "java.log"));
      this.enhancers = enhancers != null ? enhancers : helper.getEnhancerProperty(className + ".enhancers");
      String resourceType = helper.getProperty(className + ".resourceType", "global");
      MonitoredResource resource = monitoredResource != null ? monitoredResource : getDefaultResource(resourceType);
      writeOptions = new WriteOption[]{WriteOption.logName(logName), WriteOption.resource(resource)};
    } catch (Exception ex) {
      reportError(null, ex, ErrorManager.OPEN_FAILURE);
      throw ex;
    }
  }

  private static List<LoggingHandler> getLoggingHandlers(Logger logger) {
    ImmutableList.Builder<LoggingHandler> builder = ImmutableList.builder();
    for (Handler handler : logger.getHandlers()) {
      if (handler instanceof LoggingHandler) {
        builder.add((LoggingHandler) handler);
      }
    }
    return builder.build();
  }

  private static boolean hasLoggingHandler(Logger logger) {
    // look for Stackdriver Logging handler registered with addHandler()
    for (Handler handler : logger.getHandlers()) {
      if (handler instanceof LoggingHandler) {
        return true;
      }
    }
    // look for Stackdriver Logging handler registered via logging.properties
    String loggerName = logger.getName();
    String propertyName = loggerName.equals(ROOT_LOGGER_NAME)
        ? HANDLERS_PROPERTY : loggerName + "." + HANDLERS_PROPERTY;
    String handlersProperty = LogManager.getLogManager().getProperty(propertyName);
    String[] handlers = handlersProperty != null ? handlersProperty.split(",") : NO_HANDLERS;
    for (String handlerName : handlers) {
      if (handlerName.contains(LoggingHandler.class.getPackage().getName())) {
        return true;
      }
    }
    return false;
  }

  private MonitoredResource getDefaultResource(String resourceType) {
    MonitoredResource.Builder builder = MonitoredResource.newBuilder(resourceType);
    builder.addLabel("project_id", options.getProjectId());
    for (Enhancer enhancer : enhancers) {
      enhancer.enhanceMonitoredResource(builder);
    }
    return builder.build();    
  }

  private static class LogConfigHelper {

    private final LogManager manager = LogManager.getLogManager();

    String getProperty(String name, String defaultValue) {
      return firstNonNull(manager.getProperty(name), defaultValue);
    }

    long getLongProperty(String name, long defaultValue) {
      try {
        return Long.parseLong(manager.getProperty(name));
      } catch (NumberFormatException ex) {
        // If the level does not exist we fall back to default value
      }
      return defaultValue;
    }

    Level getLevelProperty(String name, Level defaultValue) {
      String stringLevel = manager.getProperty(name);
      if (stringLevel == null) {
        return defaultValue;
      }
      try {
        return Level.parse(stringLevel);
      } catch (IllegalArgumentException ex) {
        // If the level does not exist we fall back to default value
      }
      return defaultValue;
    }

    Filter getFilterProperty(String name, Filter defaultValue) {
      String stringFilter = manager.getProperty(name);
      try {
        if (stringFilter != null) {
          Class clz = ClassLoader.getSystemClassLoader().loadClass(stringFilter);
          return (Filter) clz.newInstance();
        }
      } catch (Exception ex) {
        // If we cannot create the filter we fall back to default value
      }
      return defaultValue;
    }

    Formatter getFormatterProperty(String name, Formatter defaultValue) {
      String stringFilter = manager.getProperty(name);
      try {
        if (stringFilter != null) {
          Class clz = ClassLoader.getSystemClassLoader().loadClass(stringFilter);
          return (Formatter) clz.newInstance();
        }
      } catch (Exception ex) {
        // If we cannot create the filter we fall back to default value
      }
      return defaultValue;
    }
    
    List<Enhancer> getEnhancerProperty(String name) {
      String list = manager.getProperty(name);
      try {
        List<Enhancer> enhancers = new ArrayList<>();
        if (list != null) {
          String[] items = list.split(",");
          for (String e_name : items) { 
            Class<? extends Enhancer> clz = (Class<? extends Enhancer>) ClassLoader.getSystemClassLoader().loadClass(e_name);
            enhancers.add((Enhancer) clz.newInstance());
          }
        }
        return enhancers;
      } catch (Exception ex) {
        // If we cannot create the enhancers we fall back to the default
      }
      return Collections.emptyList();
    }
  }

  /**
   * Returns an instance of the logging service.
   */
  Logging getLogging() {
    if (logging == null) {
      synchronized (this) {
        if (logging == null) {
          logging = options.getService();
        }
      }
    }
    return logging;
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

    if (inPublishCall.get() != null) {
      // ignore all logs generated in the course of logging through this handler
      return;
    }
    inPublishCall.set(true);

    try {
      LogEntry entry = entryFor(record);

      List<LogEntry> flushBuffer = null;
      WriteOption[] flushWriteOptions = null;

      synchronized (this) {
        if (entry != null) {
          buffer.add(entry);
        }
        if (buffer.size() >= flushSize || record.getLevel().intValue() >= flushLevel.intValue()) {
          flushBuffer = buffer;
          flushWriteOptions = writeOptions;
          buffer = new LinkedList<>();
        }
      }

      flush(flushBuffer, flushWriteOptions);
    } finally {
      inPublishCall.remove();
    }
  }

  private LogEntry entryFor(LogRecord record) {
    String payload;
    try {
      payload = getFormatter().format(record);
      Level level = record.getLevel();
      LogEntry.Builder builder = LogEntry.newBuilder(Payload.StringPayload.of(payload))
          .addLabel("levelName", level.getName())
          .addLabel("levelValue", String.valueOf(level.intValue()))
          .setTimestamp(record.getMillis())
          .setSeverity(severityFor(level));

      for (Enhancer enhancer : enhancers) {
        enhancer.enhanceLogEntry(builder, record);
      }
      enhanceLogEntry(builder, record);
      return builder.build();
    } catch (Exception ex) {
      // Formatting or enhancing can fail but we should not throw an exception, 
      // we report the error instead
      reportError(null, ex, ErrorManager.FORMAT_FAILURE);
      return null;
    }
  }
  
  @Deprecated
  protected void enhanceLogEntry(LogEntry.Builder builder, LogRecord record) {
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
   * Writes the provided list of log entries to Stackdriver Logging. Override this method to change
   * how entries should be written.
   */
  void write(List<LogEntry> entries, WriteOption... options) {
    getLogging().writeAsync(entries, options);
  }

  @Override
  public void flush() {
    List<LogEntry> flushBuffer;
    WriteOption[] flushWriteOptions;

    synchronized (this) {
      if (buffer.isEmpty()) {
        return;
      }
      flushBuffer = buffer;
      flushWriteOptions = writeOptions;
      buffer = new LinkedList<>();
    }

    flush(flushBuffer, flushWriteOptions);
  }

  private void flush(List<LogEntry> flushBuffer, WriteOption[] flushWriteOptions) {
    if (flushBuffer == null) {
      return;
    }
    try {
      write(flushBuffer, flushWriteOptions);
    } catch (Exception ex) {
      // writing can fail but we should not throw an exception, we report the error instead
      reportError(null, ex, ErrorManager.FLUSH_FAILURE);
    }
  }

  /**
   * Closes the handler and the associated {@link Logging} object.
   */
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

  /**
   * Sets the flush log level. When a log with this level is published, the log buffer is
   * transmitted to the Stackdriver Logging service, regardless of its size. If not set,
   * {@link LoggingLevel#ERROR} is used.
   */
  public synchronized Level setFlushLevel(Level flushLevel) {
    this.flushLevel = flushLevel;
    return flushLevel;
  }

  /**
   * Sets the maximum size of the log buffer. Once the maximum size of the buffer is reached, logs
   * are transmitted to the Stackdriver Logging service. If not set, a log is sent to the service as
   * soon as published.
   */
  public synchronized long setFlushSize(long flushSize) {
    this.flushSize = flushSize;
    return flushSize;
  }

  /**
   * Adds the provided {@code LoggingHandler} to {@code logger}. Use this method to register Cloud
   * Logging handlers instead of {@link Logger#addHandler(Handler)} to avoid infinite recursion
   * when logging.
   */
  public static void addHandler(Logger logger, LoggingHandler handler) {
    logger.addHandler(handler);
  }
  
  /**
   * A Log Enhancer.
   * May be used to enhance the {@link MonitoredResource} and/or the {@link LogEntry}
   */
  public interface Enhancer {
    void enhanceMonitoredResource(MonitoredResource.Builder builder);
    void enhanceLogEntry(LogEntry.Builder builder, LogRecord record);
  }

}
