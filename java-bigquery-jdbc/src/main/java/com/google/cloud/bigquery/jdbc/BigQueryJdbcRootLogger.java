/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.common.base.Strings;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.context.Context;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.management.ManagementFactory;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/** This class is used to log messages from the BigQuery JDBC Driver. */
class BigQueryJdbcRootLogger {

  /**
   * Note: Each connection will have its own file handler with the level and logPath specified in
   * the connection properties. But the logs will be driver logs and not connection specific.
   */
  private static final Logger logger = Logger.getLogger("com.google.cloud.bigquery");

  private static final Logger storageLogger = Logger.getLogger("com.google.cloud.bigquery.storage");
  private static final boolean isTest = Boolean.getBoolean("JDBC_TESTS");

  private static final Object HANDLER_LOCK = new Object();
  private static final ConcurrentHashMap<String, ConnectionLogConfig> activeConnections =
      new ConcurrentHashMap<>();
  private static final Map<String, ManagedFileHandler> handlersByPath = new HashMap<>();
  private static int activePreConnectScopes = 0;
  private static Level externalRootLevel = null;
  private static Level lastManagedRootLevel = logger.getLevel();

  static final String PROCESS_ID = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];

  private static final DateTimeFormatter DATE_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").withZone(ZoneId.systemDefault());

  static String getThreadName(long threadId) {
    Thread current = Thread.currentThread();
    if (current.getId() == threadId) {
      return current.getName();
    }
    ThreadGroup rootGroup = current.getThreadGroup();
    while (rootGroup.getParent() != null) {
      rootGroup = rootGroup.getParent();
    }

    int count = rootGroup.activeCount();
    Thread[] threads = new Thread[count * 2];
    int actualCount = rootGroup.enumerate(threads);
    for (int i = 0; i < actualCount; i++) {
      if (threads[i].getId() == threadId) {
        return threads[i].getName();
      }
    }
    return "";
  }

  static {
    logger.setUseParentHandlers(false);
    storageLogger.setUseParentHandlers(true);
    if (isTest) {
      ConsoleHandler consoleHandler = new ConsoleHandler();
      consoleHandler.setLevel(Level.SEVERE);
      consoleHandler.setFormatter(getFormatter());
      logger.addHandler(consoleHandler);
    }
  }

  public static Formatter getFormatter() {
    return new Formatter() {
      private static final int MAX_THREAD_NAME_LENGTH = 15;

      private void appendTraceBlock(StringBuilder sb) {
        SpanContext spanContext = Span.fromContext(Context.current()).getSpanContext();
        if (!spanContext.isValid()) {
          return;
        }
        sb.append("[trace_id=")
            .append(spanContext.getTraceId())
            .append(" span_id=")
            .append(spanContext.getSpanId())
            .append("] ");
      }

      @Override
      public String format(LogRecord record) {
        String date = DATE_FORMATTER.format(Instant.ofEpochMilli(record.getMillis()));
        ConnectionLogContext paramContext = ConnectionLogContext.extractFromParameters(record);
        String connectionId = paramContext != null ? paramContext.connectionId() : null;
        if (connectionId == null || connectionId.isEmpty()) {
          connectionId = BigQueryJdbcMdc.getConnectionId();
        }
        String connStr =
            (connectionId != null && !connectionId.isEmpty()) ? connectionId : "NO_CONN";

        long threadId = record.getThreadID();
        String threadName = getThreadName(threadId);

        if (threadName.length() > MAX_THREAD_NAME_LENGTH) {
          threadName = threadName.substring(threadName.length() - MAX_THREAD_NAME_LENGTH);
        }
        int totalPad = MAX_THREAD_NAME_LENGTH - threadName.length();
        int leftPad = totalPad / 2;
        String centeredThreadName =
            Strings.repeat(" ", leftPad) + threadName + Strings.repeat(" ", totalPad - leftPad);

        String sourceClassName =
            record.getSourceClassName() != null
                ? record.getSourceClassName()
                : record.getLoggerName();
        String sourceMethodName = record.getSourceMethodName();

        // Expected log format: yyyy-MM-dd HH:mm:ss.SSS [CONNECTION_ID] [trace_id=<trace_id>
        // span_id=<span_id>] LEVEL PID --- [THREAD] CLASS METHOD: MESSAGE
        StringBuilder sb = new StringBuilder(256);
        sb.append(date).append(" [").append(connStr).append("] ");
        appendTraceBlock(sb);
        sb.append(Strings.padEnd(record.getLevel().getName(), 7, ' '))
            .append(" ")
            .append(PROCESS_ID)
            .append(" --- [")
            .append(centeredThreadName)
            .append("] ")
            .append(Strings.padEnd(sourceClassName != null ? sourceClassName : "", 65, ' '))
            .append(" ")
            .append(Strings.padEnd(sourceMethodName != null ? sourceMethodName : "", 30, ' '))
            .append(": ")
            .append(record.getMessage())
            .append(System.lineSeparator());

        if (record.getThrown() != null) {
          StringWriter sw = new StringWriter();
          record.getThrown().printStackTrace(new PrintWriter(sw));
          sb.append(sw.toString()).append(System.lineSeparator());
        }

        return sb.toString();
      }
    };
  }

  public static Logger getRootLogger() {
    return logger;
  }

  static ConnectionLogContext getConnectionContext(String connectionId) {
    if (connectionId == null) {
      return null;
    }
    ConnectionLogConfig config = activeConnections.get(connectionId);
    return config != null ? config.context : null;
  }

  public static void setLevel(Level level, String logPath) throws IOException {
    synchronized (HANDLER_LOCK) {
      externalRootLevel = null;
      updateEffectiveRootLevelLocked();
    }
  }

  static BigQueryJdbcMdc.MdcCloseable openPreConnectScope(Level level, String logPath) {
    Level effectiveLevel = level != null ? level : Level.OFF;
    ManagedFileHandler tempHandler = null;
    boolean countedScope = false;
    synchronized (HANDLER_LOCK) {
      if (effectiveLevel != Level.OFF) {
        activePreConnectScopes++;
        countedScope = true;
        if (logPath != null) {
          try {
            tempHandler = acquireHandlerLocked(logPath);
          } catch (Exception ex) {
            logger.warning("Log File warning : " + ex);
          }
        }
      }
      updateEffectiveRootLevelLocked();
    }
    Path preConnectDir = tempHandler != null ? tempHandler.handler.getBaseLogPath() : null;
    BigQueryJdbcMdc.MdcCloseable mdcScope =
        BigQueryJdbcMdc.withContext(
            ConnectionLogContext.preConnect(effectiveLevel.intValue(), preConnectDir));
    final ManagedFileHandler acquired = tempHandler;
    final boolean decrementScope = countedScope;
    return () -> {
      try {
        mdcScope.close();
      } finally {
        if (decrementScope || acquired != null) {
          synchronized (HANDLER_LOCK) {
            if (decrementScope && activePreConnectScopes > 0) {
              activePreConnectScopes--;
            }
            releaseHandlerLocked(acquired);
            updateEffectiveRootLevelLocked();
          }
        }
      }
    };
  }

  static void registerConnection(String connectionId, String rawLogLevel, String logPath) {
    if (connectionId == null || connectionId.isEmpty()) {
      return;
    }
    synchronized (HANDLER_LOCK) {
      captureExternalRootLevelLocked();
      Level connLevel =
          rawLogLevel != null
              ? BigQueryJdbcUrlUtility.parseLogLevel(rawLogLevel)
              : (externalRootLevel != null ? externalRootLevel : Level.OFF);
      if (connLevel == null) {
        connLevel = Level.OFF;
      }
      ManagedFileHandler managed = null;
      if (connLevel != Level.OFF && logPath != null) {
        try {
          managed = acquireHandlerLocked(logPath);
          managed.handler.registerConnection(connectionId, connLevel);
        } catch (Exception ex) {
          logger.warning("Log File warning : " + ex);
        }
      }
      ConnectionLogConfig previous =
          activeConnections.put(
              connectionId,
              new ConnectionLogConfig(
                  new ConnectionLogContext(connectionId, connLevel.intValue()),
                  connLevel,
                  managed));
      if (previous != null && previous.managedHandler != null) {
        previous.managedHandler.handler.closeHandler(connectionId);
        releaseHandlerLocked(previous.managedHandler);
      }
      updateEffectiveRootLevelLocked();
    }
  }

  public static void closeConnectionHandler(String connectionId) {
    if (connectionId == null) {
      return;
    }
    synchronized (HANDLER_LOCK) {
      captureExternalRootLevelLocked();
      ConnectionLogConfig removed = activeConnections.remove(connectionId);
      if (removed != null && removed.managedHandler != null) {
        try {
          removed.managedHandler.handler.closeHandler(connectionId);
        } finally {
          releaseHandlerLocked(removed.managedHandler);
        }
      }
      updateEffectiveRootLevelLocked();
    }
  }

  static void resetForTest() {
    synchronized (HANDLER_LOCK) {
      activeConnections.clear();
      for (ManagedFileHandler managed : handlersByPath.values()) {
        try {
          managed.handler.close();
        } catch (Exception ignored) {
        } finally {
          logger.removeHandler(managed.handler);
        }
      }
      handlersByPath.clear();
      activePreConnectScopes = 0;
      externalRootLevel = null;
      lastManagedRootLevel = Level.OFF;
      logger.setLevel(Level.OFF);
    }
  }

  private static void captureExternalRootLevelLocked() {
    Level current = logger.getLevel();
    if (current != lastManagedRootLevel) {
      externalRootLevel = current;
    }
  }

  private static void updateEffectiveRootLevelLocked() {
    if (activePreConnectScopes > 0) {
      lastManagedRootLevel = Level.ALL;
      logger.setLevel(Level.ALL);
      return;
    }
    Level effective = externalRootLevel != null ? externalRootLevel : Level.OFF;
    int minVal = effective != null ? effective.intValue() : Level.OFF.intValue();
    for (ConnectionLogConfig cfg : activeConnections.values()) {
      int connVal = cfg.level.intValue();
      if (connVal < minVal) {
        minVal = connVal;
        effective = cfg.level;
      }
    }
    if (effective == null) {
      effective = Level.OFF;
    }
    lastManagedRootLevel = effective;
    logger.setLevel(effective);
  }

  private static String canonicalPathKey(String logPath) {
    String normalized = logPath == null ? "" : logPath;
    try {
      return Paths.get(normalized).toAbsolutePath().normalize().toString();
    } catch (InvalidPathException e) {
      return normalized;
    }
  }

  private static ManagedFileHandler acquireHandlerLocked(String logPath) {
    String key = canonicalPathKey(logPath);
    ManagedFileHandler managed = handlersByPath.get(key);
    if (managed == null) {
      String pathArg = logPath == null ? "" : logPath;
      if (!pathArg.isEmpty() && !pathArg.endsWith("/")) {
        pathArg = pathArg + "/";
      }
      PerConnectionFileHandler created =
          new PerConnectionFileHandler(
              pathArg, Level.ALL, PerConnectionFileHandler.resolveMaxLogFileBytes(), true);
      logger.addHandler(created);
      logger.setUseParentHandlers(false);
      managed = new ManagedFileHandler(key, created);
      handlersByPath.put(key, managed);
    }
    managed.refCount++;
    return managed;
  }

  private static void releaseHandlerLocked(ManagedFileHandler managed) {
    if (managed == null) {
      return;
    }
    managed.refCount--;
    if (managed.refCount <= 0) {
      handlersByPath.remove(managed.pathKey);
      try {
        managed.handler.close();
      } finally {
        logger.removeHandler(managed.handler);
      }
    }
  }

  private static final class ManagedFileHandler {
    final String pathKey;
    final PerConnectionFileHandler handler;
    int refCount;

    ManagedFileHandler(String pathKey, PerConnectionFileHandler handler) {
      this.pathKey = pathKey;
      this.handler = handler;
      this.refCount = 0;
    }
  }

  private static final class ConnectionLogConfig {
    final ConnectionLogContext context;
    final Level level;
    final ManagedFileHandler managedHandler;

    ConnectionLogConfig(
        ConnectionLogContext context, Level level, ManagedFileHandler managedHandler) {
      this.context = context;
      this.level = level;
      this.managedHandler = managedHandler;
    }
  }
}
