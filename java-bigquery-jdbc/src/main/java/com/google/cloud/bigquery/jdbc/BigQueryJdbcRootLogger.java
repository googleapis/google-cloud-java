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
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
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
  private static volatile boolean externalHandlerAttached = false;

  /**
   * Note: Each connection will have its own file handler with the level and logPath specified in
   * the connection properties. But the logs will be driver logs and not connection specific.
   */
  private static final Logger logger = createRootLogger();

  private static final Logger storageLogger = Logger.getLogger("com.google.cloud.bigquery.storage");

  private static final long CLEANER_IDLE_KEEPALIVE_MS = 60_000L;
  private static final ReentrantLock HANDLER_LOCK = new ReentrantLock();
  private static final ConcurrentHashMap<String, ConnectionLogConfig> activeConnections =
      new ConcurrentHashMap<>();
  private static final Map<String, ManagedFileHandler> handlersByPath = new HashMap<>();
  private static final ReferenceQueue<BigQueryConnection> CLEANUP_QUEUE = new ReferenceQueue<>();
  private static Thread cleanerThread = null;
  private static int trackedConnectionCount = 0;
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
    if (isTest && !hasDriverConsoleHandler(logger)) {
      ConsoleHandler consoleHandler = new TestConsoleHandler();
      consoleHandler.setLevel(Level.SEVERE);
      consoleHandler.setFormatter(getFormatter());
      logger.addHandler(consoleHandler);
    }
    externalHandlerAttached = scanForExternalHandler(logger);
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

  private static final class TestConsoleHandler extends ConsoleHandler {}

  private static boolean hasDriverConsoleHandler(Logger target) {
    String expectedName = TestConsoleHandler.class.getName();
    for (Handler h : target.getHandlers()) {
      if (h instanceof TestConsoleHandler
          || (h != null && expectedName.equals(h.getClass().getName()))) {
        return true;
      }
    }
    return false;
  }

  private static boolean isDriverOwnedHandler(Handler handler) {
    if (handler == null) {
      return false;
    }
    if (handler instanceof PerConnectionFileHandler
        || handler instanceof OpenTelemetryJulHandler
        || handler instanceof TestConsoleHandler) {
      return true;
    }
    String className = handler.getClass().getName();
    return className.equals(PerConnectionFileHandler.class.getName())
        || className.equals(OpenTelemetryJulHandler.class.getName())
        || className.equals(TestConsoleHandler.class.getName());
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

  static ConnectionLogContext resolveContext(String connectionId) {
    if (connectionId == null || connectionId.isEmpty()) {
      return null;
    }
    ConnectionLogConfig config = activeConnections.get(connectionId);
    return config != null ? config.context : ConnectionLogContext.unregistered(connectionId);
  }

  static boolean isConnectionActive(String connectionId) {
    return connectionId != null && activeConnections.containsKey(connectionId);
  }

  static int activeConnectionCount() {
    return activeConnections.size();
  }

  public static void setLevel(Level level, String logPath) throws IOException {
    HANDLER_LOCK.lock();
    try {
      captureExternalRootLevelLocked();
      updateEffectiveRootLevelLocked();
    } finally {
      HANDLER_LOCK.unlock();
    }
  }

  static BigQueryJdbcMdc.MdcCloseable openPreConnectScope(Level level, String logPath) {
    Level effectiveLevel = level != null ? level : Level.OFF;
    ManagedFileHandler tempHandler = null;
    boolean countedScope = false;
    HANDLER_LOCK.lock();
    try {
      captureExternalRootLevelLocked();
      if (effectiveLevel != Level.OFF) {
        activePreConnectScopes++;
        countedScope = true;
        if (logPath != null) {
          try {
            tempHandler = acquireHandlerLocked(logPath);
          } catch (Exception ex) {
            logger.log(Level.WARNING, "Log File warning", ex);
          }
        }
      }
      updateEffectiveRootLevelLocked();
    } finally {
      HANDLER_LOCK.unlock();
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
          HANDLER_LOCK.lock();
          try {
            captureExternalRootLevelLocked();
            if (decrementScope && activePreConnectScopes > 0) {
              activePreConnectScopes--;
            }
            releaseHandlerLocked(acquired);
            updateEffectiveRootLevelLocked();
          } finally {
            HANDLER_LOCK.unlock();
          }
        }
      }
    };
  }

  static void registerConnection(String connectionId, String rawLogLevel, String logPath) {
    if (connectionId == null || connectionId.isEmpty()) {
      return;
    }
    HANDLER_LOCK.lock();
    try {
      captureExternalRootLevelLocked();
      drainCleanupQueueLocked();
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
          logger.log(Level.WARNING, "Log File warning", ex);
        }
      }
      ConnectionLogConfig previous =
          activeConnections.put(
              connectionId,
              new ConnectionLogConfig(
                  new ConnectionLogContext(connectionId, connLevel.intValue()),
                  connLevel,
                  managed));
      if (previous != null) {
        closeConfigLocked(connectionId, previous);
      }
      updateEffectiveRootLevelLocked();
    } finally {
      HANDLER_LOCK.unlock();
    }
  }

  static void trackConnectionLifecycle(BigQueryConnection connection, String connectionId) {
    if (connection == null || connectionId == null) {
      return;
    }
    HANDLER_LOCK.lock();
    try {
      boolean reaped = drainCleanupQueueLocked();
      ConnectionLogConfig config = activeConnections.get(connectionId);
      if (config != null) {
        detachCleanableLocked(config);
        config.cleanable = new ConnectionCleanable(connection, connectionId, CLEANUP_QUEUE);
        trackedConnectionCount++;
        ensureCleanerRunningLocked();
      }
      if (reaped) {
        updateEffectiveRootLevelLocked();
      }
    } finally {
      HANDLER_LOCK.unlock();
    }
  }

  private static void ensureCleanerRunningLocked() {
    if (cleanerThread != null) {
      return;
    }
    try {
      Thread cleaner =
          new Thread(
              BigQueryJdbcRootLogger::runConnectionCleanerLoop,
              "BigQuery-JDBC-Connection-Log-Cleaner");
      cleaner.setDaemon(true);
      cleaner.setContextClassLoader(BigQueryJdbcRootLogger.class.getClassLoader());
      cleaner.start();
      cleanerThread = cleaner;
    } catch (OutOfMemoryError | SecurityException ignored) {
      // Best-effort daemon: drainCleanupQueueLocked() still reclaims queued refs on future calls.
    }
  }

  private static boolean drainCleanupQueueLocked() {
    boolean reapedAny = false;
    Reference<? extends BigQueryConnection> ref;
    while ((ref = CLEANUP_QUEUE.poll()) != null) {
      if (ref instanceof ConnectionCleanable && reapSingleLocked((ConnectionCleanable) ref)) {
        reapedAny = true;
      }
    }
    return reapedAny;
  }

  private static boolean reapSingleLocked(ConnectionCleanable ref) {
    ref.clear();
    ConnectionLogConfig current = activeConnections.get(ref.connectionId);
    if (current == null || current.cleanable != ref) {
      return false;
    }
    captureExternalRootLevelLocked();
    activeConnections.remove(ref.connectionId);
    closeConfigLocked(ref.connectionId, current);
    return true;
  }

  private static void runConnectionCleanerLoop() {
    BigQueryJdbcMdc.clear();
    while (true) {
      try {
        boolean waitIndefinitely;
        HANDLER_LOCK.lock();
        try {
          if (drainCleanupQueueLocked()) {
            updateEffectiveRootLevelLocked();
          }
          waitIndefinitely = trackedConnectionCount > 0;
          Thread.interrupted();
        } finally {
          HANDLER_LOCK.unlock();
        }

        Reference<? extends BigQueryConnection> ref =
            waitIndefinitely
                ? CLEANUP_QUEUE.remove()
                : CLEANUP_QUEUE.remove(CLEANER_IDLE_KEEPALIVE_MS);

        HANDLER_LOCK.lock();
        try {
          boolean reaped =
              (ref instanceof ConnectionCleanable) && reapSingleLocked((ConnectionCleanable) ref);
          try {
            if (drainCleanupQueueLocked()) {
              reaped = true;
            }
          } finally {
            if (reaped) {
              updateEffectiveRootLevelLocked();
            }
          }
          if (ref == null && trackedConnectionCount == 0 && CLEANUP_QUEUE.poll() == null) {
            if (cleanerThread == Thread.currentThread()) {
              cleanerThread = null;
            }
            return;
          }
        } finally {
          HANDLER_LOCK.unlock();
        }
      } catch (InterruptedException ignored) {
        // Woken when trackedConnectionCount reaches 0 to switch to the idle keep-alive window.
      } catch (Throwable ignored) {
        // Survive OOM or unexpected errors while cleaner is active.
      }
    }
  }

  public static void closeConnectionHandler(String connectionId) {
    if (connectionId == null) {
      return;
    }
    HANDLER_LOCK.lock();
    try {
      captureExternalRootLevelLocked();
      drainCleanupQueueLocked();
      ConnectionLogConfig removed = activeConnections.remove(connectionId);
      if (removed != null) {
        closeConfigLocked(connectionId, removed);
      }
      updateEffectiveRootLevelLocked();
    } finally {
      HANDLER_LOCK.unlock();
    }
  }

  static void resetForTest() {
    HANDLER_LOCK.lock();
    try {
      for (ConnectionLogConfig cfg : activeConnections.values()) {
        detachCleanableLocked(cfg);
        cfg.context.setLevelValue(ConnectionLogContext.OFF_VALUE);
      }
      trackedConnectionCount = 0;
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
      logger.setUseParentHandlers(false);
      logger.setLevel(Level.OFF);
      externalHandlerAttached = scanForExternalHandler(logger);
    } finally {
      HANDLER_LOCK.unlock();
    }
  }

  private static void detachCleanableLocked(ConnectionLogConfig config) {
    if (config.cleanable != null) {
      config.cleanable.clear();
      config.cleanable = null;
      if (trackedConnectionCount > 0) {
        trackedConnectionCount--;
      }
      if (trackedConnectionCount == 0
          && cleanerThread != null
          && cleanerThread != Thread.currentThread()) {
        cleanerThread.interrupt();
      }
    }
  }

  private static void closeConfigLocked(String connectionId, ConnectionLogConfig config) {
    detachCleanableLocked(config);
    config.context.setLevelValue(ConnectionLogContext.OFF_VALUE);
    if (config.managedHandler != null) {
      try {
        config.managedHandler.handler.closeHandler(connectionId);
      } finally {
        releaseHandlerLocked(config.managedHandler);
      }
    }
  }

  private static void captureExternalRootLevelLocked() {
    if (!hasExternalHandler()) {
      externalRootLevel = null;
      return;
    }
    Level current = logger.getLevel();
    if (current != lastManagedRootLevel) {
      externalRootLevel = current;
    }
  }

  private static Level resolveInheritedLevel(Logger target) {
    for (Logger parent = target.getParent(); parent != null; parent = parent.getParent()) {
      Level parentLevel = parent.getLevel();
      if (parentLevel != null) {
        return parentLevel;
      }
    }
    return Level.INFO;
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
    if (externalRootLevel == null && hasExternalHandler()) {
      Level inherited = resolveInheritedLevel(logger);
      if (minVal >= inherited.intValue()) {
        lastManagedRootLevel = null;
        logger.setLevel(null);
        return;
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
    ConnectionCleanable cleanable;

    ConnectionLogConfig(
        ConnectionLogContext context, Level level, ManagedFileHandler managedHandler) {
      this.context = context;
      this.level = level;
      this.managedHandler = managedHandler;
    }
  }

  private static final class ConnectionCleanable extends PhantomReference<BigQueryConnection> {
    final String connectionId;

    ConnectionCleanable(
        BigQueryConnection referent,
        String connectionId,
        ReferenceQueue<? super BigQueryConnection> queue) {
      super(referent, queue);
      this.connectionId = connectionId;
    }
  }
}
