/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery.jdbc;

import com.google.common.annotations.VisibleForTesting;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.ErrorManager;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import javax.annotation.concurrent.GuardedBy;

/**
 * Custom logging handler that dynamically creates and routes log records to per-connection specific
 * log files using the connection ID retrieved from {@link BigQueryJdbcMdc} or a typed {@link
 * ConnectionLogContext}.
 *
 * <p>Uses NIO {@link SeekableByteChannel} directly rather than {@link
 * java.util.logging.FileHandler} so paths are never parsed for {@code %} tokens, no {@code .lck}
 * lock files or world-readable {@code .1} fallback files are created, and {@code 0600} POSIX file
 * permissions are preserved across size-cap wraps.
 */
class PerConnectionFileHandler extends Handler {
  static final int DEFAULT_MAX_LOG_FILE_BYTES = 100 * 1024 * 1024;
  static final String MAX_LOG_FILE_BYTES_SYSTEM_PROPERTY =
      "com.google.cloud.bigquery.jdbc.maxLogFileBytes";

  private static final String DEFAULT_HANDLER_ID = "Jdbc-default";
  private static final int MAX_COLLISION_ATTEMPTS = 64;
  private static final DateTimeFormatter TIMESTAMP_FORMATTER =
      DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
  private static final Set<PosixFilePermission> OWNER_DIR_PERMS =
      PosixFilePermissions.fromString("rwx------");
  private static final Set<PosixFilePermission> OWNER_FILE_PERMS =
      PosixFilePermissions.fromString("rw-------");

  private final Path baseLogPath;
  private final Level level;
  private final int maxFileBytes;
  private final boolean allowImplicitSlots;
  private final Formatter logFormatter;
  private final Set<String> registeredConnections = ConcurrentHashMap.newKeySet();
  private final ConcurrentHashMap<String, ConnectionFileSlot> slots = new ConcurrentHashMap<>();
  private final BoundedLogFileWriter defaultWriter;
  private volatile boolean handlerClosed = false;

  /**
   * Persistent multi-connection handler used by {@link BigQueryJdbcRootLogger}. Each connection
   * registers its own {@code (logPath, level)} slot; a global fallback writer is opened only when
   * JVM-wide {@code BIGQUERY_JDBC_LOG_PATH} and {@code BIGQUERY_JDBC_LOG_LEVEL} environment
   * variables are configured.
   */
  PerConnectionFileHandler() {
    this.level = Level.ALL;
    this.maxFileBytes = resolveMaxLogFileBytes();
    this.allowImplicitSlots = false;
    this.logFormatter = BigQueryJdbcRootLogger.getFormatter();
    setLevel(Level.ALL);
    setFormatter(this.logFormatter);

    String envLogPath = System.getenv(BigQueryJdbcUrlUtility.LOG_PATH_ENV_VAR);
    String envLogLevelStr = System.getenv(BigQueryJdbcUrlUtility.LOG_LEVEL_ENV_VAR);
    BoundedLogFileWriter initializedDefault = null;
    if (envLogPath != null && envLogLevelStr != null) {
      try {
        Level envLevel = BigQueryJdbcUrlUtility.parseLogLevel(envLogLevelStr);
        if (envLevel != Level.OFF) {
          Path verifiedEnvDir = ensureSecureDirectory(Paths.get(envLogPath).toAbsolutePath());
          initializedDefault =
              createLogWriter(DEFAULT_HANDLER_ID, verifiedEnvDir, envLevel, this.maxFileBytes);
        }
      } catch (RuntimeException | IOException e) {
        Exception ex = (e instanceof Exception) ? (Exception) e : new IOException(e);
        reportError("Failed to initialize env default log file", ex, ErrorManager.OPEN_FAILURE);
      }
    }
    this.baseLogPath = null;
    this.defaultWriter = initializedDefault;
  }

  PerConnectionFileHandler(String baseLogPath, Level level) {
    this(baseLogPath, level, resolveMaxLogFileBytes());
  }

  @VisibleForTesting
  PerConnectionFileHandler(String baseLogPath, Level level, int maxFileBytes) {
    this.level = level;
    this.maxFileBytes = maxFileBytes > 0 ? maxFileBytes : DEFAULT_MAX_LOG_FILE_BYTES;
    this.allowImplicitSlots = true;
    this.logFormatter = BigQueryJdbcRootLogger.getFormatter();
    setLevel(level);
    setFormatter(this.logFormatter);

    Path requestedPath = Paths.get(baseLogPath != null ? baseLogPath : "").toAbsolutePath();
    Path verifiedDir = requestedPath;
    BoundedLogFileWriter initializedDefault = null;
    try {
      verifiedDir = ensureSecureDirectory(requestedPath);
      initializedDefault =
          createLogWriter(DEFAULT_HANDLER_ID, verifiedDir, this.level, this.maxFileBytes);
    } catch (IOException e) {
      reportError("Failed to initialize default log file", e, ErrorManager.OPEN_FAILURE);
    }
    this.baseLogPath = verifiedDir;
    this.defaultWriter = initializedDefault;
  }

  static int resolveMaxLogFileBytes() {
    Integer configured = Integer.getInteger(MAX_LOG_FILE_BYTES_SYSTEM_PROPERTY);
    if (configured != null && configured > 0) {
      return configured;
    }
    return DEFAULT_MAX_LOG_FILE_BYTES;
  }

  private static boolean isPosixFileSystem(Path path) {
    return path.getFileSystem().supportedFileAttributeViews().contains("posix");
  }

  /**
   * Ensures {@code dir} exists as a real directory without modifying permissions on pre-existing
   * shared directories, creating any missing subdirectories with {@code 0700} on POSIX systems, and
   * rejecting symbolic links below top-level OS root links (such as macOS {@code /tmp} or {@code
   * /var}).
   */
  static Path ensureSecureDirectory(Path dir) throws IOException {
    Path absPath = dir.toAbsolutePath();
    Path root = absPath.getRoot();
    if (root == null) {
      throw new IOException("Log path has no filesystem root: " + dir);
    }
    boolean isPosix = isPosixFileSystem(absPath);
    FileAttribute<?>[] attrs =
        isPosix
            ? new FileAttribute<?>[] {PosixFilePermissions.asFileAttribute(OWNER_DIR_PERMS)}
            : new FileAttribute<?>[0];

    Path current = root;
    int depth = 0;
    for (Path segment : absPath) {
      String part = segment.toString();
      if (".".equals(part) || part.isEmpty()) {
        continue;
      }
      if ("..".equals(part)) {
        Path parent = current.getParent();
        if (parent != null) {
          current = parent;
          depth = Math.max(0, depth - 1);
        }
        continue;
      }
      depth++;
      current = current.resolve(segment);
      if (Files.isSymbolicLink(current)) {
        if (depth == 1 && Files.isDirectory(current)) {
          current = current.toRealPath();
          depth = current.getNameCount();
          continue;
        }
        throw new IOException("Refusing to traverse symbolic link in log path: " + current);
      }
      if (Files.exists(current, LinkOption.NOFOLLOW_LINKS)) {
        if (!Files.isDirectory(current, LinkOption.NOFOLLOW_LINKS)) {
          throw new IOException("Log path component is not a directory: " + current);
        }
      } else {
        try {
          Files.createDirectory(current, attrs);
          if (isPosix) {
            Files.setPosixFilePermissions(current, OWNER_DIR_PERMS);
          }
        } catch (FileAlreadyExistsException e) {
          if (Files.isSymbolicLink(current)
              || !Files.isDirectory(current, LinkOption.NOFOLLOW_LINKS)) {
            throw new IOException("Log path component is not a regular directory: " + current, e);
          }
        }
      }
    }
    return current;
  }

  /**
   * Opens or creates {@code file} for appending with {@code 0600} permissions on POSIX systems,
   * rejecting symbolic links, non-regular files, and files owned by a different OS user.
   */
  static SeekableByteChannel openSecureAppendChannel(Path file) throws IOException {
    if (Files.isSymbolicLink(file)) {
      throw new IOException("Refusing to write logs to symbolic link: " + file);
    }
    boolean isPosix = isPosixFileSystem(file);
    FileAttribute<?>[] attrs =
        isPosix
            ? new FileAttribute<?>[] {PosixFilePermissions.asFileAttribute(OWNER_FILE_PERMS)}
            : new FileAttribute<?>[0];

    Set<OpenOption> createNewOpts = new HashSet<>();
    createNewOpts.add(StandardOpenOption.CREATE_NEW);
    createNewOpts.add(StandardOpenOption.WRITE);
    try {
      SeekableByteChannel channel = Files.newByteChannel(file, createNewOpts, attrs);
      if (isPosix) {
        Files.setPosixFilePermissions(file, OWNER_FILE_PERMS);
      }
      return channel;
    } catch (FileAlreadyExistsException existsEx) {
      if (Files.isSymbolicLink(file) || !Files.isRegularFile(file, LinkOption.NOFOLLOW_LINKS)) {
        throw new IOException("Refusing to write logs to non-regular file: " + file, existsEx);
      }
      if (isPosix) {
        String currentUser = System.getProperty("user.name");
        String ownerName = Files.getOwner(file, LinkOption.NOFOLLOW_LINKS).getName();
        if (currentUser != null && !currentUser.isEmpty() && !currentUser.equals(ownerName)) {
          throw new FileAlreadyExistsException(
              file.toString(), null, "Log file is owned by a different OS user: " + ownerName);
        }
        Files.setPosixFilePermissions(file, OWNER_FILE_PERMS);
      }
      Set<OpenOption> writeExistingOpts = new HashSet<>();
      writeExistingOpts.add(StandardOpenOption.WRITE);
      writeExistingOpts.add(LinkOption.NOFOLLOW_LINKS);
      SeekableByteChannel channel = Files.newByteChannel(file, writeExistingOpts);
      channel.position(channel.size());
      return channel;
    }
  }

  private static SeekableByteChannel openExclusiveNewChannel(Path file) throws IOException {
    boolean isPosix = isPosixFileSystem(file);
    FileAttribute<?>[] attrs =
        isPosix
            ? new FileAttribute<?>[] {PosixFilePermissions.asFileAttribute(OWNER_FILE_PERMS)}
            : new FileAttribute<?>[0];
    Set<OpenOption> opts = new HashSet<>();
    opts.add(StandardOpenOption.CREATE_NEW);
    opts.add(StandardOpenOption.WRITE);
    SeekableByteChannel channel = Files.newByteChannel(file, opts, attrs);
    if (isPosix) {
      Files.setPosixFilePermissions(file, OWNER_FILE_PERMS);
    }
    return channel;
  }

  private BoundedLogFileWriter createLogWriter(
      String id, Path logDir, Level writerLevel, int limitBytes) {
    try {
      Path verifiedDir = ensureSecureDirectory(logDir);
      SeekableByteChannel channel = openChannelForId(verifiedDir, id);
      try {
        return new BoundedLogFileWriter(channel, writerLevel, limitBytes, logFormatter, this);
      } catch (IOException initEx) {
        try {
          channel.close();
        } catch (IOException closeEx) {
          initEx.addSuppressed(closeEx);
        }
        throw initEx;
      }
    } catch (IOException e) {
      reportError("Failed to create log file for connection " + id, e, ErrorManager.OPEN_FAILURE);
      return null;
    }
  }

  private static SeekableByteChannel openChannelForId(Path logDir, String id) throws IOException {
    if (DEFAULT_HANDLER_ID.equals(id)) {
      Path globalPath = logDir.resolve("BQ-JDBC-GLOBAL.log");
      try {
        return openSecureAppendChannel(globalPath);
      } catch (FileAlreadyExistsException foreignOwnerEx) {
        // Shared directory (e.g., /tmp) already contains another OS user's global log file;
        // isolate this JVM's global log by process ID using exclusive creation.
        for (int attempt = 0; attempt < MAX_COLLISION_ATTEMPTS; attempt++) {
          String suffix =
              attempt == 0
                  ? BigQueryJdbcRootLogger.PROCESS_ID
                  : BigQueryJdbcRootLogger.PROCESS_ID + "-" + attempt;
          Path pidGlobal = logDir.resolve("BQ-JDBC-GLOBAL-" + suffix + ".log");
          try {
            return openSecureAppendChannel(pidGlobal);
          } catch (FileAlreadyExistsException retryEx) {
            // Try next suffix.
          }
        }
        throw foreignOwnerEx;
      }
    }

    String uuid = id.startsWith("BQ-JDBC-") ? id.substring("BQ-JDBC-".length()) : id;
    String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMATTER);
    String shortUuid = uuid.length() >= 4 ? uuid.substring(0, 4) : uuid;
    for (int attempt = 0; attempt < MAX_COLLISION_ATTEMPTS; attempt++) {
      String fileName =
          attempt == 0
              ? "BQ-JDBC-" + timestamp + "-" + shortUuid + ".log"
              : "BQ-JDBC-" + timestamp + "-" + attempt + "-" + shortUuid + ".log";
      try {
        return openExclusiveNewChannel(logDir.resolve(fileName));
      } catch (FileAlreadyExistsException e) {
        // Same-second prefix collision or pre-existing file; retry with collision counter.
      }
    }
    throw new IOException("Unable to allocate unique log file for connection " + id);
  }

  void registerConnection(String connectionId) {
    if (connectionId == null || connectionId.isEmpty() || handlerClosed) {
      return;
    }
    registeredConnections.add(connectionId);
  }

  void registerConnection(String connectionId, Level connectionLevel, String connectionLogPath)
      throws IOException {
    if (connectionId == null
        || connectionId.isEmpty()
        || handlerClosed
        || connectionLevel == null
        || connectionLevel == Level.OFF
        || connectionLogPath == null) {
      return;
    }
    Path verifiedDir = ensureSecureDirectory(Paths.get(connectionLogPath).toAbsolutePath());
    registeredConnections.add(connectionId);
    ConnectionFileSlot previous =
        slots.put(connectionId, new ConnectionFileSlot(verifiedDir, connectionLevel, maxFileBytes));
    if (previous != null) {
      previous.closeSlot();
    }
  }

  private boolean canOpenSlotFor(String connectionId) {
    return !handlerClosed
        && allowImplicitSlots
        && baseLogPath != null
        && (registeredConnections.contains(connectionId)
            || BigQueryJdbcRootLogger.isConnectionActive(connectionId));
  }

  @Override
  public void publish(LogRecord record) {
    if (handlerClosed || !isLoggable(record)) {
      return;
    }

    String connectionId = BigQueryJdbcMdc.getConnectionId();
    if (connectionId == null || connectionId.isEmpty()) {
      ConnectionLogContext context = ConnectionLogContext.extractFromParameters(record);
      if (context != null) {
        connectionId = context.connectionId();
      }
    }

    if (connectionId != null && !connectionId.isEmpty()) {
      ConnectionFileSlot slot =
          slots.compute(
              connectionId,
              (id, existing) -> {
                if (existing != null) {
                  return existing.isClosed() ? null : existing;
                }
                if (!canOpenSlotFor(id)) {
                  return null;
                }
                return new ConnectionFileSlot(baseLogPath, level, maxFileBytes);
              });
      if (slot != null && slot.publishIfOpen(record, connectionId, this)) {
        return;
      }
      if (!allowImplicitSlots) {
        // On the persistent multi-connection handler, connection-attributed records without an
        // active file slot (e.g., LogLevel=0 or Cloud-Only mode) must not spill to defaultWriter.
        return;
      }
    }

    if (!handlerClosed && defaultWriter != null) {
      defaultWriter.publish(record);
    }
  }

  @Override
  public void flush() {
    if (defaultWriter != null) {
      defaultWriter.flush();
    }
    for (ConnectionFileSlot slot : slots.values()) {
      slot.flushSlot();
    }
  }

  @Override
  public void close() throws SecurityException {
    handlerClosed = true;
    registeredConnections.clear();
    for (String id : slots.keySet()) {
      ConnectionFileSlot removed = slots.remove(id);
      if (removed != null) {
        try {
          removed.closeSlot();
        } catch (Exception ignored) {
          // Best-effort close across remaining connection slots.
        }
      }
    }
    if (defaultWriter != null) {
      defaultWriter.close();
    }
  }

  public void closeHandler(String connectionId) {
    if (connectionId == null) {
      return;
    }
    registeredConnections.remove(connectionId);
    ConnectionFileSlot slot = slots.remove(connectionId);
    if (slot != null) {
      slot.closeSlot();
    }
  }

  private void reportHandlerError(String msg, Exception ex, int code) {
    reportError(msg, ex, code);
  }

  private static final class BoundedLogFileWriter {
    private final SeekableByteChannel channel;
    private final Level writerLevel;
    private final int maxBytes;
    private final Formatter formatter;
    private final PerConnectionFileHandler owner;

    @GuardedBy("this")
    private long writtenBytes;

    @GuardedBy("this")
    private boolean closed;

    BoundedLogFileWriter(
        SeekableByteChannel channel,
        Level writerLevel,
        int maxBytes,
        Formatter formatter,
        PerConnectionFileHandler owner)
        throws IOException {
      this.channel = channel;
      this.writerLevel = writerLevel;
      this.maxBytes = maxBytes;
      this.formatter = formatter;
      this.owner = owner;
      this.writtenBytes = channel.size();
    }

    synchronized void publish(LogRecord record) {
      if (closed || record.getLevel().intValue() < writerLevel.intValue()) {
        return;
      }
      String formatted;
      try {
        formatted = formatter.format(record);
      } catch (Exception ex) {
        owner.reportHandlerError("Failed to format log record", ex, ErrorManager.FORMAT_FAILURE);
        return;
      }
      byte[] bytes = formatted.getBytes(StandardCharsets.UTF_8);
      try {
        if (maxBytes > 0 && writtenBytes > 0 && writtenBytes + bytes.length > maxBytes) {
          channel.truncate(0);
          channel.position(0);
          writtenBytes = 0;
        }
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        while (buffer.hasRemaining()) {
          writtenBytes += channel.write(buffer);
        }
      } catch (IOException ex) {
        owner.reportHandlerError("Failed to write log record", ex, ErrorManager.WRITE_FAILURE);
      }
    }

    synchronized void flush() {
      if (closed) {
        return;
      }
      if (channel instanceof FileChannel) {
        try {
          ((FileChannel) channel).force(false);
        } catch (IOException ex) {
          owner.reportHandlerError("Failed to flush log file", ex, ErrorManager.FLUSH_FAILURE);
        }
      }
    }

    synchronized void close() {
      if (closed) {
        return;
      }
      closed = true;
      try {
        channel.close();
      } catch (IOException ex) {
        owner.reportHandlerError("Failed to close log file", ex, ErrorManager.CLOSE_FAILURE);
      }
    }
  }

  private static final class ConnectionFileSlot {
    private final Path logPath;
    private final Level level;
    private final int maxFileBytes;

    @GuardedBy("this")
    private BoundedLogFileWriter writer;

    @GuardedBy("this")
    private boolean closed;

    ConnectionFileSlot(Path logPath, Level level, int maxFileBytes) {
      this.logPath = logPath;
      this.level = level;
      this.maxFileBytes = maxFileBytes;
    }

    synchronized boolean isClosed() {
      return closed;
    }

    synchronized boolean publishIfOpen(
        LogRecord record, String connectionId, PerConnectionFileHandler owner) {
      if (closed
          || owner.handlerClosed
          || (!owner.registeredConnections.contains(connectionId)
              && !BigQueryJdbcRootLogger.isConnectionActive(connectionId))) {
        closeSlot();
        owner.slots.remove(connectionId, this);
        return false;
      }
      if (record.getLevel().intValue() < level.intValue()) {
        return true;
      }
      if (writer == null) {
        writer = owner.createLogWriter(connectionId, logPath, level, maxFileBytes);
        if (writer == null) {
          return false;
        }
      }
      writer.publish(record);
      return true;
    }

    synchronized void flushSlot() {
      if (!closed && writer != null) {
        writer.flush();
      }
    }

    synchronized void closeSlot() {
      if (closed) {
        return;
      }
      closed = true;
      if (writer != null) {
        try {
          writer.close();
        } finally {
          writer = null;
        }
      }
    }
  }
}
