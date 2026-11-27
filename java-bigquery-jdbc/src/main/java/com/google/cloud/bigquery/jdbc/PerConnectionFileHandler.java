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
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
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
  static final long DEFAULT_MAX_LOG_FILE_BYTES = 1024L * 1024L * 1024L;
  static final String MAX_LOG_FILE_BYTES_SYSTEM_PROPERTY =
      "com.google.cloud.bigquery.jdbc.maxLogFileBytes";
  private static final String DEFAULT_HANDLER_ID = "Jdbc-default";
  private static final String GLOBAL_LOG_FILE_NAME = "BQ-JDBC-GLOBAL.log";
  private static final long GLOBAL_LOCK_POSITION = Long.MAX_VALUE - 1;
  private static final int MAX_CREATE_ATTEMPTS = 16;
  private static final int MAX_REOPEN_ATTEMPTS = 3;
  private static final int MAX_WRITE_CHUNK_BYTES = 8192;
  private static final int MAX_DISTINCT_REPORTED_ERRORS = 64;
  private static final long OPEN_RETRY_BACKOFF_NANOS = 5_000_000_000L;
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
  private static final AtomicReference<String> LAST_WARNED_MAX_BYTES = new AtomicReference<>();
  static volatile Integer overrideUidForTesting;

  private final Path baseLogPath;
  private final boolean basePathPosix;
  private final Level level;
  private final long maxFileBytes;
  private final boolean managed;
  private final Formatter logFormatter;
  private final ConcurrentHashMap<String, ConnectionWriterSlot> slots = new ConcurrentHashMap<>();
  private final ReentrantLock defaultWriterLock = new ReentrantLock();
  private ChannelLogWriter defaultWriter;
  private boolean defaultWriterHasBackoff;
  private long defaultWriterNextOpenNanos;
  private volatile boolean handlerClosed = false;

  PerConnectionFileHandler(String baseLogPath, Level level) {
    this(baseLogPath, level, resolveMaxLogFileBytes(), false);
  }

  PerConnectionFileHandler(String baseLogPath, Level level, long maxFileBytes) {
    this(baseLogPath, level, maxFileBytes, false);
  }

  PerConnectionFileHandler(String baseLogPath, Level level, long maxFileBytes, boolean managed) {
    this.level = level;
    this.maxFileBytes = maxFileBytes <= 0L ? DEFAULT_MAX_LOG_FILE_BYTES : maxFileBytes;
    this.managed = managed;
    this.logFormatter = BigQueryJdbcRootLogger.getFormatter();
    setLevel(level);
    setFormatter(this.logFormatter);
    setErrorManager(new DeduplicatingErrorManager());

    Path initializedDir = null;
    boolean detectedPosix = false;
    try {
      Path candidate =
          Paths.get(baseLogPath != null ? baseLogPath : "").toAbsolutePath().normalize();
      Path root = candidate.getRoot();
      detectedPosix = root != null && supportsPosix(root);
      initializedDir = ensureSecureDirectory(candidate, detectedPosix);
    } catch (Exception e) {
      reportError("Failed to initialize default log file", e, ErrorManager.OPEN_FAILURE);
    }
    this.baseLogPath = initializedDir;
    this.basePathPosix = detectedPosix;
  }

  Path getBaseLogPath() {
    return baseLogPath;
  }

  void registerConnection(String connectionId, Level connLevel) {
    if (!managed
        || handlerClosed
        || connectionId == null
        || connectionId.isEmpty()
        || connLevel == null
        || connLevel == Level.OFF) {
      return;
    }
    ConnectionWriterSlot previous = slots.put(connectionId, new ConnectionWriterSlot(connLevel));
    if (previous != null) {
      previous.closeSlot();
    }
  }

  static long resolveMaxLogFileBytes() {
    String raw;
    try {
      raw = System.getProperty(MAX_LOG_FILE_BYTES_SYSTEM_PROPERTY);
    } catch (SecurityException e) {
      return DEFAULT_MAX_LOG_FILE_BYTES;
    }
    if (raw != null && !raw.trim().isEmpty()) {
      String trimmed = raw.trim();
      try {
        long parsed = Long.parseLong(trimmed);
        if (parsed > 0L) {
          return parsed;
        }
      } catch (NumberFormatException ignored) {
        // Fall back to 1 GiB default on invalid property value.
      }
      if (!trimmed.equals(LAST_WARNED_MAX_BYTES.getAndSet(trimmed))) {
        new ErrorManager()
            .error(
                "Ignoring invalid " + MAX_LOG_FILE_BYTES_SYSTEM_PROPERTY + " value: " + trimmed,
                null,
                ErrorManager.GENERIC_FAILURE);
      }
    }
    return DEFAULT_MAX_LOG_FILE_BYTES;
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
    return ensureSecureDirectory(normalized, root != null && supportsPosix(root));
  }

  private static Path ensureSecureDirectory(Path dir, boolean isPosix) throws IOException {
    Path normalized = dir.toAbsolutePath().normalize();
    Path root = normalized.getRoot();
    if (root == null) {
      throw new IOException("Cannot resolve root for log path: " + dir);
    }
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
        EnumSet.of(
            StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
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

  private static Path deriveBackupPath(Path activePath) {
    String fileName = activePath.getFileName().toString();
    String backupName =
        fileName.endsWith(".log")
            ? fileName.substring(0, fileName.length() - 4) + ".1.log"
            : fileName + ".1";
    return activePath.resolveSibling(backupName);
  }

  private static OpenedLogFile reopenRotatedTarget(
      Path logDir, String id, Path preferredPath, Path heldClaimKey, boolean isPosix)
      throws IOException {
    try {
      FileChannel fc = openExclusiveNewChannel(preferredPath, isPosix);
      FileLock lock = null;
      if (DEFAULT_HANDLER_ID.equals(id)) {
        try {
          lock = tryAcquireSentinelLock(fc);
        } catch (IOException ignored) {
          // Locking unsupported on filesystem; CREATE_NEW still succeeded.
        }
      }
      return new OpenedLogFile(preferredPath, fc, lock, heldClaimKey);
    } catch (FileAlreadyExistsException contended) {
      if (heldClaimKey != null) {
        ACTIVE_GLOBAL_PATHS.remove(heldClaimKey);
      }
      return DEFAULT_HANDLER_ID.equals(id)
          ? openFallbackGlobalChannel(logDir, isPosix)
          : openConnectionChannel(logDir, id, isPosix);
    }
  }

  ChannelLogWriter createLogWriter(String id, Path logDir, Level writerLevel, long limitBytes) {
    if (logDir == null) {
      return null;
    }
    boolean interrupted = Thread.interrupted();
    try {
      boolean isPosix = (logDir == baseLogPath) ? basePathPosix : supportsPosix(logDir);
      Path verifiedDir = ensureSecureDirectory(logDir, isPosix);
      OpenedLogFile opened =
          DEFAULT_HANDLER_ID.equals(id)
              ? openGlobalChannel(verifiedDir, isPosix)
              : openConnectionChannel(verifiedDir, id, isPosix);
      return new ChannelLogWriter(
          id, verifiedDir, opened, isPosix, writerLevel, limitBytes, logFormatter, this);
    } catch (Exception e) {
      reportError("Failed to create log file for connection " + id, e, ErrorManager.OPEN_FAILURE);
      return null;
    } finally {
      if (interrupted) {
        Thread.currentThread().interrupt();
      }
    }
  }

  @Override
  public void publish(LogRecord record) {
    if (handlerClosed || record == null || !isLoggable(record)) {
      return;
    }

    ConnectionLogContext context = ConnectionLogContext.extractFromParameters(record);
    if (context == null) {
      context = BigQueryJdbcMdc.getConnectionContext();
    }
    String connectionId = context != null ? context.connectionId() : null;

    if (managed) {
      if (connectionId != null && !connectionId.isEmpty()) {
        ConnectionWriterSlot slot = slots.get(connectionId);
        if (slot == null || !slot.allows(record.getLevel())) {
          return;
        }
        if (baseLogPath != null) {
          publishToSlot(slot, connectionId, record);
        }
        return;
      }
      if (context == null
          || !context.isLoggable(record.getLevel())
          || context.preConnectDir() == null
          || baseLogPath == null
          || !baseLogPath.equals(context.preConnectDir())) {
        return;
      }
      publishToDefault(record);
      return;
    }

    if (connectionId != null && !connectionId.isEmpty() && baseLogPath != null) {
      ConnectionWriterSlot slot =
          slots.compute(
              connectionId,
              (id, existing) -> {
                if (handlerClosed) {
                  return null;
                }
                if (existing != null && !existing.isClosed()) {
                  return existing;
                }
                return new ConnectionWriterSlot(this.level);
              });
      if (slot != null) {
        publishToSlot(slot, connectionId, record);
      }
      return;
    }

    publishToDefault(record);
  }

  private void publishToDefault(LogRecord record) {
    ChannelLogWriter target;
    defaultWriterLock.lock();
    try {
      if (handlerClosed || baseLogPath == null) {
        return;
      }
      if (defaultWriter == null) {
        long now = System.nanoTime();
        if (!defaultWriterHasBackoff || now - defaultWriterNextOpenNanos >= 0L) {
          defaultWriter = createLogWriter(DEFAULT_HANDLER_ID, baseLogPath, level, maxFileBytes);
          defaultWriterHasBackoff = (defaultWriter == null);
          defaultWriterNextOpenNanos = now + OPEN_RETRY_BACKOFF_NANOS;
        }
      }
      target = defaultWriter;
    } finally {
      defaultWriterLock.unlock();
    }
    if (!handlerClosed && target != null && !target.publish(record)) {
      defaultWriterLock.lock();
      try {
        if (defaultWriter == target) {
          defaultWriter = null;
        }
      } finally {
        defaultWriterLock.unlock();
      }
    }
  }

  private void publishToSlot(ConnectionWriterSlot slot, String connectionId, LogRecord record) {
    ChannelLogWriter target;
    slot.lock.lock();
    try {
      if (slot.closed || handlerClosed) {
        slot.closeSlot();
        return;
      }
      if (slot.writer == null) {
        long now = System.nanoTime();
        if (!slot.hasBackoff || now - slot.nextOpenAttemptNanos >= 0L) {
          slot.writer = createLogWriter(connectionId, baseLogPath, slot.allowedLevel, maxFileBytes);
          slot.hasBackoff = (slot.writer == null);
          slot.nextOpenAttemptNanos = now + OPEN_RETRY_BACKOFF_NANOS;
        }
      }
      target = slot.writer;
    } finally {
      slot.lock.unlock();
    }
    if (handlerClosed) {
      return;
    }
    if (target == null) {
      publishToDefault(record);
    } else if (!target.publish(record)) {
      slot.lock.lock();
      try {
        if (slot.writer == target) {
          slot.writer = null;
        }
      } finally {
        slot.lock.unlock();
      }
    }
  }

  @Override
  public void flush() {
    // Unbuffered OS file channel writes are immediately visible to readers without JVM buffering.
  }

  @Override
  public void close() throws SecurityException {
    handlerClosed = true;
    for (String id : slots.keySet()) {
      ConnectionWriterSlot removed = slots.remove(id);
      if (removed != null) {
        removed.closeSlot();
      }
    }
    for (ConnectionWriterSlot remaining : slots.values()) {
      remaining.closeSlot();
    }
    slots.clear();
    defaultWriterLock.lock();
    try {
      if (defaultWriter != null) {
        defaultWriter.close();
        defaultWriter = null;
      }
    } finally {
      defaultWriterLock.unlock();
    }
  }

  void closeHandler(String connectionId) {
    if (connectionId != null) {
      ConnectionWriterSlot removed = slots.remove(connectionId);
      if (removed != null) {
        removed.closeSlot();
      }
    }
  }

  private static final class ConnectionWriterSlot {
    final ReentrantLock lock = new ReentrantLock();
    final Level allowedLevel;
    ChannelLogWriter writer;
    boolean closed;
    boolean hasBackoff;
    long nextOpenAttemptNanos;

    ConnectionWriterSlot(Level allowedLevel) {
      this.allowedLevel = allowedLevel;
    }

    boolean allows(Level recordLevel) {
      return allowedLevel != null
          && allowedLevel != Level.OFF
          && recordLevel != null
          && recordLevel.intValue() >= allowedLevel.intValue();
    }

    boolean isClosed() {
      lock.lock();
      try {
        return closed;
      } finally {
        lock.unlock();
      }
    }

    void closeSlot() {
      lock.lock();
      try {
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
      } finally {
        lock.unlock();
      }
    }
  }

  private static final class DeduplicatingErrorManager extends ErrorManager {
    private final Set<String> seen = ConcurrentHashMap.newKeySet();

    @Override
    public void error(String msg, Exception ex, int code) {
      String key = code + ":" + (msg != null ? msg : "");
      if (seen.size() >= MAX_DISTINCT_REPORTED_ERRORS || !seen.add(key)) {
        return;
      }
      String text = "java.util.logging.ErrorManager: " + code + (msg != null ? ": " + msg : "");
      System.err.println(text);
      if (ex != null) {
        ex.printStackTrace(System.err);
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
    private final ReentrantLock lock = new ReentrantLock();
    private final String id;
    private final Path logDir;
    private final boolean isPosix;
    private final Level writerLevel;
    private final long maxBytes;
    private final Formatter formatter;
    private final PerConnectionFileHandler owner;
    private Path filePath;
    private Path globalClaimKey;
    private FileChannel channel;
    private FileLock fileLock;
    private long writtenBytes;
    private boolean closed;

    ChannelLogWriter(
        String id,
        Path logDir,
        OpenedLogFile opened,
        boolean isPosix,
        Level writerLevel,
        long maxBytes,
        Formatter formatter,
        PerConnectionFileHandler owner)
        throws IOException {
      this.id = id;
      this.logDir = logDir;
      this.filePath = opened.path;
      this.channel = opened.channel;
      this.fileLock = opened.lock;
      this.globalClaimKey = opened.globalClaimKey;
      this.isPosix = isPosix;
      this.writerLevel = writerLevel;
      this.maxBytes = maxBytes;
      this.formatter = formatter;
      this.owner = owner;
      this.writtenBytes = opened.channel.size();
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
      this.writtenBytes = reopened.size();
    }

    private void rotate() throws IOException {
      Path backupPath = deriveBackupPath(filePath);
      if (Files.exists(backupPath, LinkOption.NOFOLLOW_LINKS)) {
        BasicFileAttributes backupAttrs =
            Files.readAttributes(backupPath, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        if (backupAttrs.isSymbolicLink()) {
          Files.deleteIfExists(backupPath);
        } else if (!backupAttrs.isRegularFile() || backupAttrs.isOther()) {
          throw new IOException("Refusing to rotate onto non-regular backup path: " + backupPath);
        }
      }
      if (fileLock != null && fileLock.isValid()) {
        try {
          fileLock.release();
        } catch (IOException ignored) {
        }
        fileLock = null;
      }
      if (channel != null) {
        channel.close();
        channel = null;
      }
      try {
        Files.move(filePath, backupPath, StandardCopyOption.REPLACE_EXISTING);
      } catch (Exception moveEx) {
        try {
          reopenAfterInterrupt();
        } catch (Exception recoverEx) {
          moveEx.addSuppressed(recoverEx);
        }
        if (moveEx instanceof IOException) {
          throw (IOException) moveEx;
        }
        throw new IOException("Failed to move active log file to backup", moveEx);
      }
      if (isPosix) {
        try {
          Files.setPosixFilePermissions(backupPath, FILE_PERMS_0600);
        } catch (Exception permEx) {
          owner.reportError(
              "Failed to set permissions on rotated log file", permEx, ErrorManager.WRITE_FAILURE);
        }
      }
      OpenedLogFile reopened = reopenRotatedTarget(logDir, id, filePath, globalClaimKey, isPosix);
      this.filePath = reopened.path;
      this.channel = reopened.channel;
      this.fileLock = reopened.lock;
      this.globalClaimKey = reopened.globalClaimKey;
      this.writtenBytes = reopened.channel.size();
    }

    private void truncateInPlace(Exception rotEx, int incomingBytes) throws IOException {
      if (channel == null || !channel.isOpen()) {
        reopenAfterInterrupt();
      }
      channel.truncate(0L);
      channel.position(0L);
      writtenBytes = 0L;
      String reason = rotEx.getClass().getSimpleName();
      byte[] notice =
          ("[LOG TRUNCATED: backup rotation failed (" + reason + ")]" + System.lineSeparator())
              .getBytes(StandardCharsets.UTF_8);
      if (maxBytes <= 0L || notice.length <= maxBytes - incomingBytes) {
        ByteBuffer noticeBuf = ByteBuffer.wrap(notice);
        while (noticeBuf.hasRemaining()) {
          writtenBytes += channel.write(noticeBuf);
        }
      }
    }

    boolean publish(LogRecord record) {
      if (record.getLevel().intValue() < writerLevel.intValue()) {
        return true;
      }
      String formatted;
      try {
        formatted = formatter.format(record);
      } catch (Exception e) {
        owner.reportError("Failed to format log record", e, ErrorManager.FORMAT_FAILURE);
        return true;
      }
      byte[] bytes = formatted.getBytes(StandardCharsets.UTF_8);
      lock.lock();
      try {
        if (closed) {
          return false;
        }
        boolean interrupted = false;
        try {
          for (int attempt = 0; attempt < MAX_REOPEN_ATTEMPTS; attempt++) {
            interrupted |= Thread.interrupted();
            try {
              if (channel == null || !channel.isOpen()) {
                reopenAfterInterrupt();
              }
              if (maxBytes > 0L
                  && writtenBytes > 0L
                  && (writtenBytes >= maxBytes || bytes.length > maxBytes - writtenBytes)) {
                try {
                  rotate();
                } catch (Exception rotEx) {
                  owner.reportError("Failed to rotate log file", rotEx, ErrorManager.WRITE_FAILURE);
                  truncateInPlace(rotEx, bytes.length);
                }
              }
              ByteBuffer buf = ByteBuffer.wrap(bytes);
              int total = bytes.length;
              while (buf.position() < total) {
                buf.limit(Math.min(buf.position() + MAX_WRITE_CHUNK_BYTES, total));
                while (buf.hasRemaining()) {
                  writtenBytes += channel.write(buf);
                }
              }
              return true;
            } catch (ClosedByInterruptException cbie) {
              interrupted = true;
              Thread.interrupted();
              if (attempt + 1 >= MAX_REOPEN_ATTEMPTS) {
                owner.reportError(
                    "Failed to write log record after interrupt", cbie, ErrorManager.WRITE_FAILURE);
                return true;
              }
            }
          }
        } catch (IOException e) {
          owner.reportError("Failed to write log record", e, ErrorManager.WRITE_FAILURE);
          if (channel == null) {
            closed = true;
            if (globalClaimKey != null) {
              ACTIVE_GLOBAL_PATHS.remove(globalClaimKey);
              globalClaimKey = null;
            }
            return false;
          }
        } finally {
          if (interrupted) {
            Thread.currentThread().interrupt();
          }
        }
        return true;
      } finally {
        lock.unlock();
      }
    }

    void close() {
      lock.lock();
      try {
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
            globalClaimKey = null;
          }
        }
      } finally {
        lock.unlock();
      }
    }
  }
}
