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
import java.lang.management.ManagementFactory;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/** This class is used to log messages from the BigQuery JDBC Driver. */
class BigQueryJdbcRootLogger {

  private static final boolean isTest = Boolean.getBoolean("JDBC_TESTS");
  private static final ConcurrentHashMap<String, ConnectionLogContext> ACTIVE_CONNECTIONS =
      new ConcurrentHashMap<>();

  private static ConsoleHandler testConsoleHandler = null;
  private static volatile boolean externalHandlerAttached;
  private static volatile PerConnectionFileHandler persistentFileHandler = null;
  private static volatile Handler fileHandler = null;
  private static volatile Level explicitGlobalLevel = Level.OFF;
  private static volatile int explicitGlobalLevelValue = ConnectionLogContext.OFF_VALUE;
  private static Level lastDriverAppliedLevel = null;
  private static Level externalFloorLevel = null;

  /**
   * Note: Each connection will have its own file handler with the level and logPath specified in
   * the connection properties. But the logs will be driver logs and not connection specific.
   */
  private static final Logger logger = createRootLogger();

  private static final Logger storageLogger = Logger.getLogger("com.google.cloud.bigquery.storage");

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
      testConsoleHandler = consoleHandler;
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
        String connectionId = BigQueryJdbcMdc.getConnectionId();
        if (connectionId == null || connectionId.isEmpty()) {
          ConnectionLogContext context = ConnectionLogContext.extractFromParameters(record);
          if (context != null) {
            connectionId = context.connectionId();
          }
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
          java.io.StringWriter sw = new java.io.StringWriter();
          record.getThrown().printStackTrace(new java.io.PrintWriter(sw));
          sb.append(sw.toString()).append(System.lineSeparator());
        }

        return sb.toString();
      }
    };
  }

  private static Logger createRootLogger() {
    LogManager manager = LogManager.getLogManager();
    Logger existing = manager.getLogger("com.google.cloud.bigquery");
    if (existing != null) {
      return existing;
    }
    RootDriverLogger customRoot = new RootDriverLogger("com.google.cloud.bigquery");
    if (manager.addLogger(customRoot)) {
      return customRoot;
    }
    return Logger.getLogger("com.google.cloud.bigquery");
  }

  private static final class RootDriverLogger extends Logger {
    RootDriverLogger(String name) {
      super(name, null);
      super.setUseParentHandlers(false);
    }

    @Override
    public synchronized void addHandler(Handler handler) throws SecurityException {
      super.addHandler(handler);
      externalHandlerAttached = scanForExternalHandler(this);
    }

    @Override
    public synchronized void removeHandler(Handler handler) throws SecurityException {
      super.removeHandler(handler);
      externalHandlerAttached = scanForExternalHandler(this);
    }

    @Override
    public synchronized void setUseParentHandlers(boolean useParentHandlers) {
      super.setUseParentHandlers(useParentHandlers);
      externalHandlerAttached = scanForExternalHandler(this);
    }
  }

  static boolean scanForExternalHandler(Logger target) {
    if (target.getUseParentHandlers()) {
      return true;
    }
    for (Handler h : target.getHandlers()) {
      if (!isDriverOwnedHandler(h)) {
        return true;
      }
    }
    return false;
  }

  static boolean hasExternalHandler() {
    if (logger instanceof RootDriverLogger) {
      return externalHandlerAttached;
    }
    return scanForExternalHandler(logger);
  }

  static int explicitGlobalLevelValue() {
    return explicitGlobalLevelValue;
  }

  public static Logger getRootLogger() {
    return logger;
  }

  private static synchronized PerConnectionFileHandler ensurePersistentFileHandlerAttached() {
    if (persistentFileHandler == null) {
      persistentFileHandler = new PerConnectionFileHandler();
    }
    boolean attached = false;
    for (Handler h : logger.getHandlers()) {
      if (h == persistentFileHandler) {
        attached = true;
        break;
      }
    }
    if (!attached) {
      logger.addHandler(persistentFileHandler);
    }
    return persistentFileHandler;
  }

  private static boolean isDriverOwnedHandler(Handler handler) {
    return handler instanceof PerConnectionFileHandler
        || handler instanceof OpenTelemetryJulHandler
        || (testConsoleHandler != null && handler == testConsoleHandler);
  }

  private static synchronized void refreshEffectiveRootLevel() {
    Level current = logger.getLevel();
    if (hasExternalHandler()) {
      if (current != lastDriverAppliedLevel) {
        externalFloorLevel = current;
      }
    } else {
      externalFloorLevel = null;
    }

    int targetValue =
        explicitGlobalLevel != null
            ? explicitGlobalLevel.intValue()
            : ConnectionLogContext.OFF_VALUE;
    String envLevelStr = System.getenv(BigQueryJdbcUrlUtility.LOG_LEVEL_ENV_VAR);
    if (envLevelStr != null) {
      try {
        targetValue =
            Math.min(targetValue, BigQueryJdbcUrlUtility.parseLogLevel(envLevelStr).intValue());
      } catch (RuntimeException ignored) {
        // Invalid env level falls back to active connection levels.
      }
    }
    for (ConnectionLogContext ctx : ACTIVE_CONNECTIONS.values()) {
      int ctxLevel = ctx.levelValue();
      if (ctxLevel != ConnectionLogContext.INHERIT_VALUE) {
        targetValue = Math.min(targetValue, ctxLevel);
      }
    }
    if (externalFloorLevel != null) {
      targetValue = Math.min(targetValue, externalFloorLevel.intValue());
    }
    Level applied = toJulLevel(targetValue);
    lastDriverAppliedLevel = applied;
    logger.setLevel(applied);
  }

  private static Level toJulLevel(int levelValue) {
    if (levelValue <= Level.ALL.intValue()) {
      return Level.ALL;
    }
    if (levelValue <= Level.FINEST.intValue()) {
      return Level.FINEST;
    }
    if (levelValue <= Level.FINER.intValue()) {
      return Level.FINER;
    }
    if (levelValue <= Level.FINE.intValue()) {
      return Level.FINE;
    }
    if (levelValue <= Level.CONFIG.intValue()) {
      return Level.CONFIG;
    }
    if (levelValue <= Level.INFO.intValue()) {
      return Level.INFO;
    }
    if (levelValue <= Level.WARNING.intValue()) {
      return Level.WARNING;
    }
    if (levelValue <= Level.SEVERE.intValue()) {
      return Level.SEVERE;
    }
    return Level.OFF;
  }

  public static synchronized void setLevel(Level level, String logPath) throws IOException {
    Level effective = level != null ? level : Level.OFF;
    explicitGlobalLevel = effective;
    explicitGlobalLevelValue = effective.intValue();
    if (effective != Level.OFF) {
      if (logPath != null) {
        setPath(logPath, effective);
      }
    } else if (fileHandler != null) {
      fileHandler.close();
      logger.removeHandler(fileHandler);
      fileHandler = null;
    }
    refreshEffectiveRootLevel();
  }

  static synchronized void setPath(String logPath, Level level) {
    try {
      if (logPath == null) {
        logPath = "";
      }
      if (!logPath.isEmpty() && !logPath.endsWith("/")) {
        logPath = logPath + "/";
      }

      if (fileHandler != null) {
        fileHandler.close();
        logger.removeHandler(fileHandler);
      }

      fileHandler = new PerConnectionFileHandler(logPath, level);
      fileHandler.setLevel(level);
      logger.addHandler(fileHandler);

    } catch (Exception ex) {
      logger.warning("Log File warning : " + ex);
    }
  }

  static ConnectionLogContext registerConnection(String connectionId) {
    if (connectionId == null || connectionId.isEmpty()) {
      return null;
    }
    ConnectionLogContext context =
        ACTIVE_CONNECTIONS.computeIfAbsent(
            connectionId, id -> new ConnectionLogContext(id, ConnectionLogContext.INHERIT_VALUE));
    Handler currentHandler = fileHandler;
    if (currentHandler instanceof PerConnectionFileHandler) {
      ((PerConnectionFileHandler) currentHandler).registerConnection(connectionId);
    }
    return context;
  }

  static synchronized ConnectionLogContext registerConnection(
      String connectionId, Level level, String logPath) throws IOException {
    if (connectionId == null || connectionId.isEmpty()) {
      return null;
    }
    Level effectiveLevel = level != null ? level : Level.OFF;
    ConnectionLogContext context =
        ACTIVE_CONNECTIONS.compute(
            connectionId,
            (id, existing) -> {
              if (existing == null) {
                return new ConnectionLogContext(id, effectiveLevel.intValue());
              }
              existing.setLevelValue(effectiveLevel.intValue());
              return existing;
            });
    try {
      if (effectiveLevel != Level.OFF && logPath != null) {
        PerConnectionFileHandler persistent = ensurePersistentFileHandlerAttached();
        persistent.registerConnection(connectionId, effectiveLevel, logPath);
      }
      Handler legacy = fileHandler;
      if (legacy instanceof PerConnectionFileHandler) {
        ((PerConnectionFileHandler) legacy).registerConnection(connectionId);
      }
      refreshEffectiveRootLevel();
      return context;
    } catch (IOException | RuntimeException ex) {
      ACTIVE_CONNECTIONS.remove(connectionId, context);
      context.setLevelValue(ConnectionLogContext.OFF_VALUE);
      refreshEffectiveRootLevel();
      throw ex;
    }
  }

  static ConnectionLogContext resolveContext(String connectionId) {
    if (connectionId == null || connectionId.isEmpty()) {
      return null;
    }
    ConnectionLogContext active = ACTIVE_CONNECTIONS.get(connectionId);
    return active != null
        ? active
        : new ConnectionLogContext(connectionId, ConnectionLogContext.INHERIT_VALUE);
  }

  static boolean isConnectionActive(String connectionId) {
    return connectionId != null && ACTIVE_CONNECTIONS.containsKey(connectionId);
  }

  static int activeConnectionCount() {
    return ACTIVE_CONNECTIONS.size();
  }

  public static synchronized void closeConnectionHandler(String connectionId) {
    if (connectionId == null) {
      return;
    }
    ConnectionLogContext removed = ACTIVE_CONNECTIONS.remove(connectionId);
    if (removed != null) {
      removed.setLevelValue(ConnectionLogContext.OFF_VALUE);
    }
    if (persistentFileHandler != null) {
      persistentFileHandler.closeHandler(connectionId);
    }
    Handler currentHandler = fileHandler;
    if (currentHandler instanceof PerConnectionFileHandler) {
      ((PerConnectionFileHandler) currentHandler).closeHandler(connectionId);
    }
    refreshEffectiveRootLevel();
  }

  static synchronized void resetForTesting() {
    for (String id : ACTIVE_CONNECTIONS.keySet()) {
      ConnectionLogContext ctx = ACTIVE_CONNECTIONS.remove(id);
      if (ctx != null) {
        ctx.setLevelValue(ConnectionLogContext.OFF_VALUE);
      }
      if (persistentFileHandler != null) {
        persistentFileHandler.closeHandler(id);
      }
    }
    if (fileHandler != null) {
      fileHandler.close();
      logger.removeHandler(fileHandler);
      fileHandler = null;
    }
    explicitGlobalLevel = Level.OFF;
    explicitGlobalLevelValue = ConnectionLogContext.OFF_VALUE;
    refreshEffectiveRootLevel();
  }
}
