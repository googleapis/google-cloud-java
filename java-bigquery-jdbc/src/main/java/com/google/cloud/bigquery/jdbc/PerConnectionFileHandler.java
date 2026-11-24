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
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalNotFoundException;
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
 * files using NIO {@link SeekableByteChannel} writers with owner-only POSIX permissions and
 * graceful {@link ErrorManager} degradation.
 */
class PerConnectionFileHandler extends Handler {
  private static final String DEFAULT_HANDLER_ID = "Jdbc-default";
  private static final int MAX_COLLISION_ATTEMPTS = 64;
  private static final DateTimeFormatter TIMESTAMP_FORMATTER =
      DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
  private static final Set<PosixFilePermission> OWNER_DIR_PERMS =
      PosixFilePermissions.fromString("rwx------");
  private static final Set<PosixFilePermission> OWNER_FILE_PERMS =
      PosixFilePermissions.fromString("rw-------");
  private static final Set<Path> ACTIVE_GLOBAL_PATHS = ConcurrentHashMap.newKeySet();

  private final Path baseLogPath;
  private final Level level;
  private final Formatter logFormatter;
  private final ConcurrentHashMap<String, ChannelLogWriter> writers = new ConcurrentHashMap<>();
  private final ChannelLogWriter defaultWriter;
  private volatile boolean handlerClosed = false;

  PerConnectionFileHandler(String baseLogPath, Level level) {
    this.level = level;
    this.logFormatter = BigQueryJdbcRootLogger.getFormatter();
    setLevel(level);
    setFormatter(this.logFormatter);

    Path verifiedDir = null;
    ChannelLogWriter initializedDefault = null;
    try {
      verifiedDir =
          ensureSecureDirectory(Paths.get(baseLogPath != null ? baseLogPath : "").toAbsolutePath());
      initializedDefault = createLogWriter(DEFAULT_HANDLER_ID, verifiedDir, this.level);
    } catch (Exception e) {
      reportError("Failed to initialize default log file", e, ErrorManager.OPEN_FAILURE);
    }
    this.baseLogPath = verifiedDir;
    this.defaultWriter = initializedDefault;
  }

  private static boolean isPosixFileSystem(Path path) {
    return path.getFileSystem().supportedFileAttributeViews().contains("posix");
  }

  static void verifyPosixOwner(Path file) throws IOException {
    if (isPosixFileSystem(file)) {
      String currentUser = System.getProperty("user.name");
      UserPrincipal fileOwner = Files.getOwner(file, LinkOption.NOFOLLOW_LINKS);
      UserPrincipal currentOwner = null;
      if (currentUser != null && !currentUser.isEmpty()) {
        try {
          currentOwner =
              file.getFileSystem()
                  .getUserPrincipalLookupService()
                  .lookupPrincipalByName(currentUser);
        } catch (UserPrincipalNotFoundException ignored) {
          // Leave currentOwner null so FileAlreadyExistsException is thrown below.
        }
      }
      if (!fileOwner.equals(currentOwner)) {
        throw new FileAlreadyExistsException(
            file.toString(), null, "Log file owner could not be verified: " + fileOwner.getName());
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

  private static void closeQuietlyWithSuppressed(SeekableByteChannel channel, Throwable primary) {
    if (channel == null) {
      return;
    }
    try {
      channel.close();
    } catch (IOException closeEx) {
      primary.addSuppressed(closeEx);
    }
  }

  private static OpenedChannel openLockedGlobalChannel(Path file) throws IOException {
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
      return new OpenedChannel(claim, channel);
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

  private ChannelLogWriter createLogWriter(String id, Path logDir, Level writerLevel) {
    if (logDir == null) {
      return null;
    }
    try {
      OpenedChannel opened = allocateChannel(ensureSecureDirectory(logDir), id);
      try {
        return new ChannelLogWriter(opened, writerLevel, logFormatter, this);
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
      try {
        return new OpenedChannel(null, openExclusiveNewChannel(logDir.resolve(fileName)));
      } catch (FileAlreadyExistsException e) {
        // Same-second prefix collision or pre-existing file; retry with collision counter.
      }
    }
    throw new IOException("Unable to allocate unique log file for connection " + id);
  }

  @Override
  public void publish(LogRecord record) {
    if (handlerClosed || !isLoggable(record)) {
      return;
    }

    String connectionId = BigQueryJdbcMdc.getConnectionId();
    if (connectionId == null || connectionId.isEmpty()) {
      Object[] params = record.getParameters();
      if (params != null && params.length > 0 && params[0] instanceof String) {
        connectionId = (String) params[0];
      }
    }

    if (connectionId != null && !connectionId.isEmpty()) {
      ChannelLogWriter writer =
          writers.computeIfAbsent(
              connectionId, id -> handlerClosed ? null : createLogWriter(id, baseLogPath, level));
      if (writer != null) {
        if (handlerClosed) {
          writers.remove(connectionId, writer);
          writer.close();
          return;
        }
        writer.publish(record);
        return;
      }
    }

    if (!handlerClosed && defaultWriter != null) {
      defaultWriter.publish(record);
    }
  }

  @Override
  public void flush() {
    // No-op: ChannelLogWriter writes directly to SeekableByteChannel (OS page cache)
    // without any JVM-level buffering.
  }

  @Override
  public void close() throws SecurityException {
    handlerClosed = true;
    for (String id : writers.keySet()) {
      ChannelLogWriter removed = writers.remove(id);
      if (removed != null) {
        removed.close();
      }
    }
    if (defaultWriter != null) {
      defaultWriter.close();
    }
  }

  public void closeHandler(String connectionId) {
    if (connectionId != null) {
      ChannelLogWriter writer = writers.remove(connectionId);
      if (writer != null) {
        writer.close();
      }
    }
  }

  private static final class OpenedChannel {
    final Path claimedGlobalPath;
    final SeekableByteChannel channel;

    OpenedChannel(Path claimedGlobalPath, SeekableByteChannel channel) {
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

  private static final class ChannelLogWriter {
    private final Path claimedGlobalPath;
    private final SeekableByteChannel channel;
    private final Level writerLevel;
    private final Formatter formatter;
    private final PerConnectionFileHandler owner;

    @GuardedBy("this")
    private boolean closed;

    ChannelLogWriter(
        OpenedChannel opened,
        Level writerLevel,
        Formatter formatter,
        PerConnectionFileHandler owner) {
      this.claimedGlobalPath = opened.claimedGlobalPath;
      this.channel = opened.channel;
      this.writerLevel = writerLevel;
      this.formatter = formatter;
      this.owner = owner;
    }

    synchronized void publish(LogRecord record) {
      if (closed || record.getLevel().intValue() < writerLevel.intValue()) {
        return;
      }
      String formatted;
      try {
        formatted = formatter.format(record);
      } catch (Exception ex) {
        owner.reportError("Failed to format log record", ex, ErrorManager.FORMAT_FAILURE);
        return;
      }
      try {
        ByteBuffer buffer = ByteBuffer.wrap(formatted.getBytes(StandardCharsets.UTF_8));
        while (buffer.hasRemaining()) {
          channel.write(buffer);
        }
      } catch (Exception ex) {
        owner.reportError("Failed to write log record", ex, ErrorManager.WRITE_FAILURE);
      }
    }

    synchronized void close() {
      if (!closed) {
        closed = true;
        try {
          channel.close();
        } catch (Exception ex) {
          owner.reportError("Failed to close log file", ex, ErrorManager.CLOSE_FAILURE);
        } finally {
          if (claimedGlobalPath != null) {
            ACTIVE_GLOBAL_PATHS.remove(claimedGlobalPath);
          }
        }
      }
    }
  }
}
