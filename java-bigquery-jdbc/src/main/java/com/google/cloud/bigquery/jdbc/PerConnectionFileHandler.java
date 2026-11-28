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
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.attribute.UserPrincipal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.ErrorManager;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.regex.Pattern;

/**
 * Custom logging handler that dynamically creates and routes log records to per-connection specific
 * log files using the connection ID retrieved from BigQueryJdbcMdc.
 */
class PerConnectionFileHandler extends Handler {
  private static final String DEFAULT_HANDLER_ID = "Jdbc-default";
  private static final String GLOBAL_LOG_FILE_NAME = "BQ-JDBC-GLOBAL.log";
  private static final long GLOBAL_LOCK_POSITION = Long.MAX_VALUE - 1;
  private static final int MAX_CREATE_ATTEMPTS = 16;
  private static final int MAX_REOPEN_ATTEMPTS = 3;
  private static final Set<Path> ACTIVE_GLOBAL_PATHS = ConcurrentHashMap.newKeySet();
  private static final DateTimeFormatter FILE_TIMESTAMP_FORMAT =
      DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
  private static final Pattern UNSAFE_ID_CHARS = Pattern.compile("[^A-Za-z0-9_-]");
  private static final Set<PosixFilePermission> DIR_PERMS_0700 =
      PosixFilePermissions.fromString("rwx------");
  private static final Set<PosixFilePermission> FILE_PERMS_0600 =
      PosixFilePermissions.fromString("rw-------");
  private static final FileAttribute<Set<PosixFilePermission>> DIR_ATTR_0700 =
      PosixFilePermissions.asFileAttribute(DIR_PERMS_0700);
  private static final FileAttribute<Set<PosixFilePermission>> FILE_ATTR_0600 =
      PosixFilePermissions.asFileAttribute(FILE_PERMS_0600);
  private static final int PROCESS_UID = resolveProcessUid();
  private static final UserPrincipal PROCESS_PRINCIPAL = resolveProcessPrincipal();
  static volatile Integer overrideUidForTesting;

  private final Path baseLogPath;
  private final Level level;
  private final Formatter logFormatter;
  private final ConcurrentHashMap<String, ChannelLogWriter> writers = new ConcurrentHashMap<>();
  private final Object defaultWriterLock = new Object();
  private ChannelLogWriter defaultWriter;
  private volatile boolean handlerClosed = false;

  PerConnectionFileHandler(String baseLogPath, Level level) {
    this.level = level;
    this.logFormatter = BigQueryJdbcRootLogger.getFormatter();
    setLevel(level);
    setFormatter(this.logFormatter);

    Path initializedDir = null;
    try {
      Path candidate = Paths.get(baseLogPath != null ? baseLogPath : "").toAbsolutePath();
      initializedDir = ensureSecureDirectory(candidate);
    } catch (Exception e) {
      reportError("Failed to initialize default log file", e, ErrorManager.OPEN_FAILURE);
    }
    this.baseLogPath = initializedDir;
  }

  private static int resolveProcessUid() {
    Path procSelfStatus = Paths.get("/proc/self/status");
    if (Files.isReadable(procSelfStatus)) {
      try {
        List<String> lines = Files.readAllLines(procSelfStatus, StandardCharsets.UTF_8);
        for (String line : lines) {
          if (line.startsWith("Uid:")) {
            String[] parts = line.split("\\s+");
            if (parts.length >= 3) {
              return Integer.parseInt(parts[2]);
            }
          }
        }
      } catch (Exception ignored) {
        // Fall back to UserPrincipal lookup on platforms without /proc/self/status.
      }
    }
    return -1;
  }

  private static UserPrincipal resolveProcessPrincipal() {
    String userName = System.getProperty("user.name");
    if (userName == null || userName.isEmpty() || "?".equals(userName)) {
      return null;
    }
    try {
      return FileSystems.getDefault()
          .getUserPrincipalLookupService()
          .lookupPrincipalByName(userName);
    } catch (Exception ignored) {
      return null;
    }
  }

  private static boolean supportsPosix(Path path) {
    try {
      return Files.getFileStore(path).supportsFileAttributeView("posix");
    } catch (IOException e) {
      return FileSystems.getDefault().supportedFileAttributeViews().contains("posix");
    }
  }

  private static int effectiveProcessUid() {
    Integer override = overrideUidForTesting;
    return override != null ? override : PROCESS_UID;
  }

  private static void verifySingleLinkCount(Path path) throws IOException {
    try {
      Object nlinkAttr = Files.getAttribute(path, "unix:nlink", LinkOption.NOFOLLOW_LINKS);
      if (nlinkAttr instanceof Number && ((Number) nlinkAttr).intValue() > 1) {
        throw new IOException("Refusing hard-linked log file (nlink > 1): " + path);
      }
    } catch (UnsupportedOperationException | IllegalArgumentException ignored) {
      // Non-Unix filesystems do not expose unix:nlink.
    }
  }

  private static void verifyPosixOwner(Path path, boolean allowRootOwner) throws IOException {
    int processUid = effectiveProcessUid();
    if (processUid >= 0) {
      Object uidAttr = Files.getAttribute(path, "unix:uid", LinkOption.NOFOLLOW_LINKS);
      if (uidAttr instanceof Number) {
        int fileUid = ((Number) uidAttr).intValue();
        if (fileUid == processUid || (allowRootOwner && fileUid == 0)) {
          return;
        }
        throw new IOException("Refusing to use path owned by uid " + fileUid + ": " + path);
      }
    }
    PosixFileAttributes posixAttrs =
        Files.readAttributes(path, PosixFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
    UserPrincipal owner = posixAttrs.owner();
    if (allowRootOwner && owner != null && "root".equals(owner.getName())) {
      return;
    }
    if (PROCESS_PRINCIPAL != null && PROCESS_PRINCIPAL.equals(owner)) {
      return;
    }
    throw new IOException("Refusing to use path owned by untrusted user: " + path);
  }

  static Path ensureSecureDirectory(Path dir) throws IOException {
    Path normalized = dir.toAbsolutePath().normalize();
    Path root = normalized.getRoot();
    if (root == null) {
      throw new IOException("Cannot resolve root for log path: " + dir);
    }
    boolean isPosix = supportsPosix(root);
    Path current = root;
    int nameCount = normalized.getNameCount();
    for (int i = 0; i < nameCount; i++) {
      current = current.resolve(normalized.getName(i));
      boolean isTarget = (i == nameCount - 1);
      if (Files.exists(current, LinkOption.NOFOLLOW_LINKS)) {
        BasicFileAttributes attrs =
            Files.readAttributes(current, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        if (attrs.isSymbolicLink()) {
          if (isTarget || !isPosix) {
            throw new IOException("Refusing to use symbolic link in log path: " + current);
          }
          verifyPosixOwner(current, true);
          if (!Files.isDirectory(current)) {
            throw new IOException("Ancestor symlink does not resolve to directory: " + current);
          }
          continue;
        }
        if (!attrs.isDirectory() || attrs.isOther()) {
          throw new IOException("Log path component is not a regular directory: " + current);
        }
        if (isTarget && isPosix) {
          verifyPosixOwner(current, true);
        }
      } else {
        try {
          if (isPosix) {
            Files.createDirectory(current, DIR_ATTR_0700);
          } else {
            Files.createDirectory(current);
          }
        } catch (FileAlreadyExistsException raceIgnored) {
          BasicFileAttributes attrs =
              Files.readAttributes(current, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
          if (attrs.isSymbolicLink() || !attrs.isDirectory() || attrs.isOther()) {
            throw new IOException("Concurrent non-directory created at log path: " + current);
          }
          if (isTarget && isPosix) {
            verifyPosixOwner(current, true);
          }
        }
      }
    }
    return normalized;
  }

  private static String sanitizeIdSegment(String id) {
    String uuid = id;
    if (id.startsWith("BQ-JDBC-")) {
      uuid = id.substring("BQ-JDBC-".length());
    }
    String cleaned = UNSAFE_ID_CHARS.matcher(uuid).replaceAll("");
    if (cleaned.isEmpty()) {
      cleaned = "conn";
    }
    return cleaned.length() >= 4 ? cleaned.substring(0, 4) : cleaned;
  }

  private static FileChannel openExclusiveNewChannel(Path path, boolean isPosix)
      throws IOException {
    EnumSet<StandardOpenOption> opts =
        EnumSet.of(StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
    if (isPosix) {
      return FileChannel.open(path, opts, FILE_ATTR_0600);
    }
    return FileChannel.open(path, opts);
  }

  private static FileChannel openAppendValidated(Path path, boolean isPosix) throws IOException {
    BasicFileAttributes attrs =
        Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
    if (attrs.isSymbolicLink() || !attrs.isRegularFile() || attrs.isOther()) {
      throw new IOException("Refusing non-regular log file: " + path);
    }
    if (isPosix) {
      verifyPosixOwner(path, false);
      verifySingleLinkCount(path);
      Files.setPosixFilePermissions(path, FILE_PERMS_0600);
    }
    FileChannel fc =
        FileChannel.open(
            path, StandardOpenOption.WRITE, StandardOpenOption.APPEND, LinkOption.NOFOLLOW_LINKS);
    try {
      BasicFileAttributes postAttrs =
          Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
      if (postAttrs.isSymbolicLink() || !postAttrs.isRegularFile() || postAttrs.isOther()) {
        throw new IOException("Log file changed to non-regular file during open: " + path);
      }
      if (isPosix) {
        verifyPosixOwner(path, false);
        verifySingleLinkCount(path);
      }
      return fc;
    } catch (IOException | RuntimeException e) {
      try {
        fc.close();
      } catch (IOException suppressed) {
        e.addSuppressed(suppressed);
      }
      throw e;
    }
  }

  private static FileLock tryAcquireSentinelLock(FileChannel fc) throws IOException {
    try {
      return fc.tryLock(GLOBAL_LOCK_POSITION, 1L, false);
    } catch (OverlappingFileLockException contendedInJvm) {
      return null;
    }
  }

  private static OpenedLogFile openFallbackGlobalChannel(Path logDir, boolean isPosix)
      throws IOException {
    String timestamp = LocalDateTime.now().format(FILE_TIMESTAMP_FORMAT);
    for (int attempt = 0; attempt < MAX_CREATE_ATTEMPTS; attempt++) {
      String suffix = String.format("%04x", ThreadLocalRandom.current().nextInt(0x10000));
      Path candidate = logDir.resolve("BQ-JDBC-GLOBAL-" + timestamp + "-" + suffix + ".log");
      try {
        FileChannel fc = openExclusiveNewChannel(candidate, isPosix);
        FileLock lock = null;
        try {
          lock = tryAcquireSentinelLock(fc);
        } catch (IOException ignored) {
          // Exclusive CREATE_NEW already guarantees uniqueness if locking is unsupported.
        }
        return new OpenedLogFile(candidate, fc, lock, null);
      } catch (FileAlreadyExistsException collision) {
        // Retry with fresh random suffix.
      }
    }
    throw new IOException("Unable to allocate fallback global log file in " + logDir);
  }

  private static OpenedLogFile openGlobalChannel(Path logDir, boolean isPosix) throws IOException {
    Path realLogDir = logDir.toRealPath();
    Path globalPath = realLogDir.resolve(GLOBAL_LOG_FILE_NAME);
    Path claimKey = globalPath;
    if (ACTIVE_GLOBAL_PATHS.add(claimKey)) {
      boolean keepClaim = false;
      try {
        FileChannel fc;
        try {
          fc = openExclusiveNewChannel(globalPath, isPosix);
        } catch (FileAlreadyExistsException existing) {
          fc = openAppendValidated(globalPath, isPosix);
        }
        FileLock lock = null;
        boolean lockSupported = true;
        try {
          lock = tryAcquireSentinelLock(fc);
        } catch (IOException lockUnsupported) {
          lockSupported = false;
        }
        if (lock != null || !lockSupported) {
          keepClaim = true;
          return new OpenedLogFile(globalPath, fc, lock, claimKey);
        }
        fc.close();
      } catch (IOException | RuntimeException primaryFailure) {
        // Fall through to unique per-process global log file when primary is foreign-owned/locked.
      } finally {
        if (!keepClaim) {
          ACTIVE_GLOBAL_PATHS.remove(claimKey);
        }
      }
    }
    return openFallbackGlobalChannel(realLogDir, isPosix);
  }

  private static OpenedLogFile openConnectionChannel(Path logDir, String id, boolean isPosix)
      throws IOException {
    String shortUuid = sanitizeIdSegment(id);
    String timestamp = LocalDateTime.now().format(FILE_TIMESTAMP_FORMAT);
    for (int attempt = 0; attempt < MAX_CREATE_ATTEMPTS; attempt++) {
      String fileName =
          attempt == 0
              ? "BQ-JDBC-" + timestamp + "-" + shortUuid + ".log"
              : "BQ-JDBC-" + timestamp + "-" + attempt + "-" + shortUuid + ".log";
      Path candidate = logDir.resolve(fileName);
      try {
        FileChannel fc = openExclusiveNewChannel(candidate, isPosix);
        return new OpenedLogFile(candidate, fc, null, null);
      } catch (FileAlreadyExistsException collision) {
        // Retry with collision counter when two connections share timestamp + 4-char prefix.
      }
    }
    throw new IOException("Unable to allocate unique log file for connection " + id);
  }

  ChannelLogWriter createLogWriter(String id, Path logDir, Level writerLevel) {
    if (logDir == null) {
      return null;
    }
    try {
      Path verifiedDir = ensureSecureDirectory(logDir);
      boolean isPosix = supportsPosix(verifiedDir);
      OpenedLogFile opened =
          DEFAULT_HANDLER_ID.equals(id)
              ? openGlobalChannel(verifiedDir, isPosix)
              : openConnectionChannel(verifiedDir, id, isPosix);
      return new ChannelLogWriter(opened, isPosix, writerLevel, logFormatter, this);
    } catch (Exception e) {
      reportError("Failed to create log file for connection " + id, e, ErrorManager.OPEN_FAILURE);
      return null;
    }
  }

  private ChannelLogWriter getOrCreateDefaultWriter() {
    synchronized (defaultWriterLock) {
      if (handlerClosed || baseLogPath == null) {
        return null;
      }
      if (defaultWriter == null) {
        defaultWriter = createLogWriter(DEFAULT_HANDLER_ID, baseLogPath, level);
      }
      return defaultWriter;
    }
  }

  @Override
  public void publish(LogRecord record) {
    if (handlerClosed || record == null || !isLoggable(record)) {
      return;
    }

    String connectionId = BigQueryJdbcMdc.getConnectionId();
    if (connectionId == null || connectionId.isEmpty()) {
      Object[] params = record.getParameters();
      if (params != null && params.length > 0 && params[0] instanceof String) {
        connectionId = (String) params[0];
      }
    }
    ChannelLogWriter target = null;

    if (connectionId != null && !connectionId.isEmpty() && baseLogPath != null) {
      target =
          writers.computeIfAbsent(connectionId, id -> createLogWriter(id, baseLogPath, this.level));
    }
    if (target == null) {
      target = getOrCreateDefaultWriter();
    }

    if (!handlerClosed && target != null) {
      target.publish(record);
    }
  }

  @Override
  public void flush() {
    // Unbuffered OS file channel writes are immediately visible to readers without JVM buffering.
  }

  @Override
  public void close() throws SecurityException {
    handlerClosed = true;
    for (ChannelLogWriter writer : writers.values()) {
      try {
        writer.close();
      } catch (Exception ignored) {
      }
    }
    try {
      synchronized (defaultWriterLock) {
        if (defaultWriter != null) {
          defaultWriter.close();
          defaultWriter = null;
        }
      }
    } finally {
      writers.clear();
    }
  }

  void closeHandler(String connectionId) {
    if (connectionId != null) {
      ChannelLogWriter writer = writers.remove(connectionId);
      if (writer != null) {
        writer.close();
      }
    }
  }

  static final class OpenedLogFile {
    final Path path;
    final FileChannel channel;
    final FileLock lock;
    final Path globalClaimKey;

    OpenedLogFile(Path path, FileChannel channel, FileLock lock, Path globalClaimKey) {
      this.path = path;
      this.channel = channel;
      this.lock = lock;
      this.globalClaimKey = globalClaimKey;
    }
  }

  static final class ChannelLogWriter {
    private final Object lock = new Object();
    private final Path filePath;
    private final boolean isPosix;
    private final Path globalClaimKey;
    private final Level writerLevel;
    private final Formatter formatter;
    private final PerConnectionFileHandler owner;
    private SeekableByteChannel channel;
    private FileLock fileLock;
    private boolean closed;

    ChannelLogWriter(
        OpenedLogFile opened,
        boolean isPosix,
        Level writerLevel,
        Formatter formatter,
        PerConnectionFileHandler owner) {
      this.filePath = opened.path;
      this.channel = opened.channel;
      this.fileLock = opened.lock;
      this.globalClaimKey = opened.globalClaimKey;
      this.isPosix = isPosix;
      this.writerLevel = writerLevel;
      this.formatter = formatter;
      this.owner = owner;
    }

    private void reopenAfterInterrupt() throws IOException {
      FileChannel reopened = openAppendValidated(filePath, isPosix);
      FileLock reacquired = null;
      if (globalClaimKey != null) {
        try {
          reacquired = tryAcquireSentinelLock(reopened);
          if (reacquired == null) {
            reopened.close();
            throw new IOException(
                "Lost global log file lock during interrupt recovery: " + filePath);
          }
        } catch (IOException e) {
          try {
            reopened.close();
          } catch (IOException suppressed) {
            e.addSuppressed(suppressed);
          }
          throw e;
        }
      }
      this.channel = reopened;
      this.fileLock = reacquired;
    }

    void publish(LogRecord record) {
      if (record.getLevel().intValue() < writerLevel.intValue()) {
        return;
      }
      String formatted;
      try {
        formatted = formatter.format(record);
      } catch (Exception e) {
        owner.reportError("Failed to format log record", e, ErrorManager.FORMAT_FAILURE);
        return;
      }
      byte[] bytes = formatted.getBytes(StandardCharsets.UTF_8);
      synchronized (lock) {
        if (closed || channel == null) {
          return;
        }
        boolean interrupted = false;
        try {
          for (int attempt = 0; attempt < MAX_REOPEN_ATTEMPTS; attempt++) {
            interrupted |= Thread.interrupted();
            try {
              if (!channel.isOpen()) {
                reopenAfterInterrupt();
              }
              ByteBuffer buf = ByteBuffer.wrap(bytes);
              while (buf.hasRemaining()) {
                channel.write(buf);
              }
              return;
            } catch (ClosedByInterruptException cbie) {
              interrupted = true;
              Thread.interrupted();
              if (attempt + 1 >= MAX_REOPEN_ATTEMPTS) {
                owner.reportError(
                    "Failed to write log record after interrupt", cbie, ErrorManager.WRITE_FAILURE);
                return;
              }
            }
          }
        } catch (IOException e) {
          owner.reportError("Failed to write log record", e, ErrorManager.WRITE_FAILURE);
        } finally {
          if (interrupted) {
            Thread.currentThread().interrupt();
          }
        }
      }
    }

    void close() {
      synchronized (lock) {
        if (closed) {
          return;
        }
        closed = true;
        try {
          if (fileLock != null && fileLock.isValid()) {
            try {
              fileLock.release();
            } catch (IOException ignored) {
            }
          }
          if (channel != null) {
            try {
              channel.close();
            } catch (IOException e) {
              owner.reportError("Failed to close log file", e, ErrorManager.CLOSE_FAILURE);
            }
          }
        } finally {
          fileLock = null;
          channel = null;
          if (globalClaimKey != null) {
            ACTIVE_GLOBAL_PATHS.remove(globalClaimKey);
          }
        }
      }
    }
  }
}
