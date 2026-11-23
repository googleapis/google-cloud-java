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
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.ErrorManager;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import javax.annotation.concurrent.GuardedBy;

/**
 * Custom logging handler that dynamically creates and routes log records to per-connection log
 * files using NIO {@link SeekableByteChannel} writers with owner-only POSIX permissions, bounded
 * two-file ({@code .log} + {@code .1.log}) rotation, and graceful {@link ErrorManager} degradation.
 */
class PerConnectionFileHandler extends Handler {
  static final long DEFAULT_MAX_LOG_FILE_BYTES = 1024L * 1024L * 1024L;
  static final String MAX_LOG_FILE_BYTES_SYSTEM_PROPERTY =
      "com.google.cloud.bigquery.jdbc.maxLogFileBytes";

  private static final String DEFAULT_HANDLER_ID = "Jdbc-default";
  private static final int MAX_COLLISION_ATTEMPTS = 64;
  private static final DateTimeFormatter TIMESTAMP_FORMATTER =
      DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
  private static final Set<PosixFilePermission> OWNER_DIR_PERMS =
      PosixFilePermissions.fromString("rwx------");
  static final Set<PosixFilePermission> OWNER_FILE_PERMS =
      PosixFilePermissions.fromString("rw-------");
  static final Set<Path> ACTIVE_GLOBAL_PATHS = ConcurrentHashMap.newKeySet();

  private final Path baseLogPath;
  private final Level level;
  private final long maxFileBytes;
  private final Formatter logFormatter;
  final Set<String> registeredConnections = ConcurrentHashMap.newKeySet();
  private final ConcurrentHashMap<String, ConnectionFileSlot> slots = new ConcurrentHashMap<>();
  private final BoundedLogFileWriter defaultWriter;
  volatile boolean handlerClosed = false;

  PerConnectionFileHandler(String baseLogPath, Level level) {
    this(baseLogPath, level, resolveMaxLogFileBytes());
  }

  @VisibleForTesting
  PerConnectionFileHandler(String baseLogPath, Level level, long maxFileBytes) {
    this.level = level;
    this.maxFileBytes = maxFileBytes > 0 ? maxFileBytes : DEFAULT_MAX_LOG_FILE_BYTES;
    this.logFormatter = BigQueryJdbcRootLogger.getFormatter();
    setLevel(level);
    setFormatter(this.logFormatter);

    Path verifiedDir = null;
    BoundedLogFileWriter initializedDefault = null;
    try {
      verifiedDir =
          ensureSecureDirectory(Paths.get(baseLogPath != null ? baseLogPath : "").toAbsolutePath());
      initializedDefault =
          createLogWriter(DEFAULT_HANDLER_ID, verifiedDir, this.level, this.maxFileBytes);
    } catch (Exception e) {
      reportError("Failed to initialize default log file", e, ErrorManager.OPEN_FAILURE);
    }
    this.baseLogPath = verifiedDir;
    this.defaultWriter = initializedDefault;
  }

  static long resolveMaxLogFileBytes() {
    Long configured = Long.getLong(MAX_LOG_FILE_BYTES_SYSTEM_PROPERTY);
    return (configured != null && configured > 0) ? configured : DEFAULT_MAX_LOG_FILE_BYTES;
  }

  static boolean isPosixFileSystem(Path path) {
    return path.getFileSystem().supportedFileAttributeViews().contains("posix");
  }

  static void verifyPosixOwner(Path file) throws IOException {
    if (isPosixFileSystem(file)) {
      String currentUser = System.getProperty("user.name");
      String ownerName = Files.getOwner(file, LinkOption.NOFOLLOW_LINKS).getName();
      if (currentUser == null || currentUser.isEmpty() || !currentUser.equals(ownerName)) {
        throw new FileAlreadyExistsException(
            file.toString(), null, "Log file owner could not be verified: " + ownerName);
      }
    }
  }

  /** Creates missing directories with {@code 0700} on POSIX and rejects nested symlinks. */
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

  /** Opens or creates {@code file} with {@code 0600} permissions, rejecting symlinks/non-files. */
  static SeekableByteChannel openSecureAppendChannel(Path file) throws IOException {
    return openSecureAppendChannel(file, true);
  }

  private static SeekableByteChannel openSecureAppendChannel(Path file, boolean tightenOnOpen)
      throws IOException {
    if (Files.isSymbolicLink(file)) {
      throw new IOException("Refusing to write logs to symbolic link: " + file);
    }
    try {
      return openExclusiveNewChannel(file);
    } catch (FileAlreadyExistsException existsEx) {
      if (Files.isSymbolicLink(file) || !Files.isRegularFile(file, LinkOption.NOFOLLOW_LINKS)) {
        throw new IOException("Refusing to write logs to non-regular file: " + file, existsEx);
      }
      verifyPosixOwner(file);
      if (tightenOnOpen && isPosixFileSystem(file)) {
        Files.setPosixFilePermissions(file, OWNER_FILE_PERMS);
      }
      SeekableByteChannel channel =
          Files.newByteChannel(file, StandardOpenOption.WRITE, LinkOption.NOFOLLOW_LINKS);
      try {
        if (tightenOnOpen) {
          channel.position(channel.size());
        }
        return channel;
      } catch (IOException | RuntimeException posEx) {
        closeQuietlyWithSuppressed(channel, posEx);
        throw posEx;
      }
    }
  }

  private static SeekableByteChannel configureNewChannel(
      SeekableByteChannel channel, Path file, boolean isPosix) throws IOException {
    try {
      if (isPosix) {
        Files.setPosixFilePermissions(file, OWNER_FILE_PERMS);
      }
      return channel;
    } catch (IOException | RuntimeException ex) {
      closeQuietlyWithSuppressed(channel, ex);
      throw ex;
    }
  }

  static void closeQuietlyWithSuppressed(SeekableByteChannel channel, Throwable primary) {
    try {
      channel.close();
    } catch (IOException closeEx) {
      primary.addSuppressed(closeEx);
    }
  }

  static OpenedChannel openLockedGlobalChannel(Path file) throws IOException {
    Path claim = file.toAbsolutePath().normalize();
    if (!ACTIVE_GLOBAL_PATHS.add(claim)) {
      throw new FileAlreadyExistsException(
          file.toString(), null, "Global log file is already open in this JVM");
    }
    SeekableByteChannel channel = null;
    boolean transferred = false;
    try {
      channel = openSecureAppendChannel(file, false);
      if (channel instanceof FileChannel) {
        FileLock lock = null;
        boolean lockSupported = true;
        try {
          lock = ((FileChannel) channel).tryLock();
        } catch (OverlappingFileLockException ignored) {
          // Another handler holds the lock on this global log file.
        } catch (IOException lockEx) {
          lockSupported = false;
        }
        if (lockSupported && lock == null) {
          channel.close();
          channel = null;
          throw new FileAlreadyExistsException(
              file.toString(), null, "Global log file is already locked by another process");
        }
      }
      if (isPosixFileSystem(file)) {
        Files.setPosixFilePermissions(file, OWNER_FILE_PERMS);
      }
      channel.position(channel.size());
      transferred = true;
      return new OpenedChannel(file, claim, channel);
    } finally {
      if (!transferred) {
        ACTIVE_GLOBAL_PATHS.remove(claim);
        if (channel != null) {
          try {
            channel.close();
          } catch (IOException ignored) {
          }
        }
      }
    }
  }

  private static SeekableByteChannel openExclusiveNewChannel(Path file) throws IOException {
    boolean isPosix = isPosixFileSystem(file);
    FileAttribute<?>[] attrs =
        isPosix
            ? new FileAttribute<?>[] {PosixFilePermissions.asFileAttribute(OWNER_FILE_PERMS)}
            : new FileAttribute<?>[0];
    return configureNewChannel(
        Files.newByteChannel(
            file, EnumSet.of(StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE), attrs),
        file,
        isPosix);
  }

  BoundedLogFileWriter createLogWriter(
      String id, Path logDir, Level writerLevel, long limitBytes) {
    if (logDir == null) {
      return null;
    }
    try {
      Path verifiedDir = ensureSecureDirectory(logDir);
      OpenedChannel opened = allocateChannel(verifiedDir, id);
      try {
        return new BoundedLogFileWriter(
            id, verifiedDir, opened, writerLevel, limitBytes, logFormatter, this);
      } catch (Exception initEx) {
        opened.releaseOnFailure(initEx);
        throw initEx;
      }
    } catch (Exception e) {
      reportError("Failed to create log file for connection " + id, e, ErrorManager.OPEN_FAILURE);
      return null;
    }
  }

  private static OpenedChannel allocateChannel(Path logDir, String id) throws IOException {
    if (DEFAULT_HANDLER_ID.equals(id)) {
      FileAlreadyExistsException lastEx = null;
      for (int attempt = 0; attempt <= MAX_COLLISION_ATTEMPTS; attempt++) {
        String name =
            attempt == 0
                ? "BQ-JDBC-GLOBAL.log"
                : attempt == 1
                    ? "BQ-JDBC-GLOBAL-" + BigQueryJdbcRootLogger.PROCESS_ID + ".log"
                    : "BQ-JDBC-GLOBAL-"
                        + BigQueryJdbcRootLogger.PROCESS_ID
                        + "-"
                        + (attempt - 1)
                        + ".log";
        try {
          return openLockedGlobalChannel(logDir.resolve(name));
        } catch (FileAlreadyExistsException ex) {
          lastEx = ex;
        }
      }
      throw lastEx;
    }

    String uuid = id.startsWith("BQ-JDBC-") ? id.substring("BQ-JDBC-".length()) : id;
    String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMATTER);
    String shortUuid = uuid.length() >= 4 ? uuid.substring(0, 4) : uuid;
    for (int attempt = 0; attempt < MAX_COLLISION_ATTEMPTS; attempt++) {
      String fileName =
          attempt == 0
              ? "BQ-JDBC-" + timestamp + "-" + shortUuid + ".log"
              : "BQ-JDBC-" + timestamp + "-" + attempt + "-" + shortUuid + ".log";
      Path candidate = logDir.resolve(fileName);
      try {
        return new OpenedChannel(candidate, null, openExclusiveNewChannel(candidate));
      } catch (FileAlreadyExistsException e) {
        // Same-second prefix collision or pre-existing file; retry with collision counter.
      }
    }
    throw new IOException("Unable to allocate unique log file for connection " + id);
  }

  static OpenedChannel reopenOrAllocate(Path logDir, String id, Path preferred) throws IOException {
    try {
      return DEFAULT_HANDLER_ID.equals(id)
          ? openLockedGlobalChannel(preferred)
          : new OpenedChannel(preferred, null, openExclusiveNewChannel(preferred));
    } catch (FileAlreadyExistsException ex) {
      return allocateChannel(logDir, id);
    }
  }

  static Path deriveBackupPath(Path activePath) {
    String name = activePath.getFileName().toString();
    String backup =
        name.endsWith(".log") ? name.substring(0, name.length() - 4) + ".1.log" : name + ".1";
    return activePath.resolveSibling(backup);
  }

  void registerConnection(String connectionId) {
    if (connectionId != null && !connectionId.isEmpty() && !handlerClosed) {
      registeredConnections.add(connectionId);
    }
  }

  private boolean canOpenSlotFor(String connectionId) {
    return !handlerClosed
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
                return canOpenSlotFor(id)
                    ? new ConnectionFileSlot(baseLogPath, level, maxFileBytes)
                    : null;
              });
      if (slot != null) {
        if (slot.publishIfOpen(record, connectionId, this)) {
          return;
        }
        if (slot.isClosed()) {
          slots.remove(connectionId, slot);
        }
      }
    }

    if (!handlerClosed && defaultWriter != null) {
      defaultWriter.publish(record);
    }
  }

  @Override
  public void flush() {
    // No-op: BoundedLogFileWriter writes directly to SeekableByteChannel (OS page cache)
    // without any JVM-level buffering.
  }

  @Override
  public void close() throws SecurityException {
    handlerClosed = true;
    registeredConnections.clear();
    for (String id : slots.keySet()) {
      ConnectionFileSlot removed = slots.remove(id);
      if (removed != null) {
        removed.closeSlot();
      }
    }
    if (defaultWriter != null) {
      defaultWriter.close();
    }
  }

  public void closeHandler(String connectionId) {
    if (connectionId != null) {
      registeredConnections.remove(connectionId);
      ConnectionFileSlot slot = slots.remove(connectionId);
      if (slot != null) {
        slot.closeSlot();
      }
    }
  }

  private static final class OpenedChannel {
    final Path path;
    final Path claimedGlobalPath;
    final SeekableByteChannel channel;

    OpenedChannel(Path path, Path claimedGlobalPath, SeekableByteChannel channel) {
      this.path = path;
      this.claimedGlobalPath = claimedGlobalPath;
      this.channel = channel;
    }

    void releaseOnFailure(Throwable primary) {
      if (claimedGlobalPath != null) {
        ACTIVE_GLOBAL_PATHS.remove(claimedGlobalPath);
      }
      closeQuietlyWithSuppressed(channel, primary);
    }
  }

  private static final class BoundedLogFileWriter {
    private final String id;
    private final Path logDir;
    private final Level writerLevel;
    private final long maxBytes;
    private final Formatter formatter;
    private final PerConnectionFileHandler owner;

    @GuardedBy("this")
    private Path activePath;

    @GuardedBy("this")
    private Path claimedGlobalPath;

    @GuardedBy("this")
    private SeekableByteChannel channel;

    @GuardedBy("this")
    private long writtenBytes;

    @GuardedBy("this")
    private boolean closed;

    BoundedLogFileWriter(
        String id,
        Path logDir,
        OpenedChannel opened,
        Level writerLevel,
        long maxBytes,
        Formatter formatter,
        PerConnectionFileHandler owner)
        throws IOException {
      this.id = id;
      this.logDir = logDir;
      this.activePath = opened.path;
      this.claimedGlobalPath = opened.claimedGlobalPath;
      this.channel = opened.channel;
      this.writerLevel = writerLevel;
      this.maxBytes = maxBytes;
      this.formatter = formatter;
      this.owner = owner;
      this.writtenBytes = opened.channel.size();
    }

    @GuardedBy("this")
    private void rotate() throws IOException {
      Path backupPath = deriveBackupPath(activePath);
      if (Files.isSymbolicLink(backupPath)) {
        Files.deleteIfExists(backupPath);
      } else if (Files.exists(backupPath, LinkOption.NOFOLLOW_LINKS)) {
        if (!Files.isRegularFile(backupPath, LinkOption.NOFOLLOW_LINKS)) {
          throw new IOException("Refusing to rotate onto non-regular backup path: " + backupPath);
        }
        verifyPosixOwner(backupPath);
      }
      channel.close();
      channel = null;
      if (claimedGlobalPath != null) {
        ACTIVE_GLOBAL_PATHS.remove(claimedGlobalPath);
        claimedGlobalPath = null;
      }
      try {
        Files.move(activePath, backupPath, StandardCopyOption.REPLACE_EXISTING);
      } catch (Exception moveEx) {
        try {
          OpenedChannel recovered =
              DEFAULT_HANDLER_ID.equals(id)
                  ? openLockedGlobalChannel(activePath)
                  : new OpenedChannel(activePath, null, openSecureAppendChannel(activePath));
          activePath = recovered.path;
          claimedGlobalPath = recovered.claimedGlobalPath;
          channel = recovered.channel;
          writtenBytes = channel.size();
        } catch (Exception recoverEx) {
          moveEx.addSuppressed(recoverEx);
        }
        if (moveEx instanceof IOException) {
          throw (IOException) moveEx;
        }
        throw new IOException("Failed to move active log file to backup", moveEx);
      }
      if (isPosixFileSystem(backupPath)) {
        try {
          Files.setPosixFilePermissions(backupPath, OWNER_FILE_PERMS);
        } catch (Exception permEx) {
          owner.reportError(
              "Failed to set permissions on rotated log file", permEx, ErrorManager.WRITE_FAILURE);
        }
      }
      OpenedChannel reopened = reopenOrAllocate(logDir, id, activePath);
      activePath = reopened.path;
      claimedGlobalPath = reopened.claimedGlobalPath;
      channel = reopened.channel;
      writtenBytes = channel.size();
    }

    synchronized boolean publish(LogRecord record) {
      if (closed || channel == null) {
        return false;
      }
      if (record.getLevel().intValue() < writerLevel.intValue()) {
        return true;
      }
      String formatted;
      try {
        formatted = formatter.format(record);
      } catch (Exception ex) {
        owner.reportError("Failed to format log record", ex, ErrorManager.FORMAT_FAILURE);
        return true;
      }
      byte[] bytes = formatted.getBytes(StandardCharsets.UTF_8);
      try {
        if (maxBytes > 0
            && writtenBytes > 0
            && (writtenBytes >= maxBytes || bytes.length > maxBytes - writtenBytes)) {
          try {
            rotate();
          } catch (Exception rotEx) {
            owner.reportError("Failed to rotate log file", rotEx, ErrorManager.WRITE_FAILURE);
            if (channel == null) {
              closed = true;
              return false;
            }
            channel.truncate(0);
            channel.position(0);
            writtenBytes = 0;
          }
        }
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        while (buffer.hasRemaining()) {
          writtenBytes += channel.write(buffer);
        }
      } catch (Exception ex) {
        owner.reportError("Failed to write log record", ex, ErrorManager.WRITE_FAILURE);
      }
      return true;
    }

    synchronized void close() {
      if (!closed) {
        closed = true;
        try {
          if (channel != null) {
            channel.close();
          }
        } catch (Exception ex) {
          owner.reportError("Failed to close log file", ex, ErrorManager.CLOSE_FAILURE);
        } finally {
          channel = null;
          if (claimedGlobalPath != null) {
            ACTIVE_GLOBAL_PATHS.remove(claimedGlobalPath);
            claimedGlobalPath = null;
          }
        }
      }
    }
  }

  private static final class ConnectionFileSlot {
    private final Path logPath;
    private final Level level;
    private final long maxFileBytes;

    @GuardedBy("this")
    private BoundedLogFileWriter writer;

    private volatile boolean closed;

    ConnectionFileSlot(Path logPath, Level level, long maxFileBytes) {
      this.logPath = logPath;
      this.level = level;
      this.maxFileBytes = maxFileBytes;
    }

    boolean isClosed() {
      return closed;
    }

    synchronized boolean publishIfOpen(
        LogRecord record, String connectionId, PerConnectionFileHandler owner) {
      if (closed
          || owner.handlerClosed
          || (!owner.registeredConnections.contains(connectionId)
              && !BigQueryJdbcRootLogger.isConnectionActive(connectionId))) {
        closeSlot();
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
      if (!writer.publish(record)) {
        closeSlot();
        return false;
      }
      return true;
    }

    synchronized void closeSlot() {
      if (!closed) {
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
}
