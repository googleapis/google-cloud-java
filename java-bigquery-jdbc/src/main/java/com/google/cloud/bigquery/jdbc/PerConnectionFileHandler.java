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
  private static final int MAX_CREATE_ATTEMPTS = 16;
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

  private final Path baseLogPath;
  private final Level level;
  private final Formatter logFormatter;
  private final ConcurrentHashMap<String, ChannelLogWriter> writers = new ConcurrentHashMap<>();
  private final ChannelLogWriter defaultWriter;

  PerConnectionFileHandler(String baseLogPath, Level level) {
    this.level = level;
    this.logFormatter = BigQueryJdbcRootLogger.getFormatter();
    setLevel(level);
    setFormatter(this.logFormatter);

    Path initializedDir = null;
    ChannelLogWriter initializedDefault = null;
    try {
      Path candidate = Paths.get(baseLogPath != null ? baseLogPath : "").toAbsolutePath();
      initializedDir = ensureSecureDirectory(candidate);
      initializedDefault = createLogWriter(DEFAULT_HANDLER_ID, initializedDir, level);
    } catch (Exception e) {
      reportError("Failed to initialize default log file", e, ErrorManager.OPEN_FAILURE);
    }
    this.baseLogPath = initializedDir;
    this.defaultWriter = initializedDefault;
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
    return PROCESS_UID;
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

  private static FileChannel openSecureGlobalChannel(Path globalPath, boolean isPosix)
      throws IOException {
    try {
      return openExclusiveNewChannel(globalPath, isPosix);
    } catch (FileAlreadyExistsException existing) {
      BasicFileAttributes attrs =
          Files.readAttributes(globalPath, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
      if (attrs.isSymbolicLink() || !attrs.isRegularFile() || attrs.isOther()) {
        throw new IOException("Refusing non-regular global log file: " + globalPath);
      }
      if (isPosix) {
        verifyPosixOwner(globalPath, false);
        Files.setPosixFilePermissions(globalPath, FILE_PERMS_0600);
      }
      return FileChannel.open(
          globalPath,
          StandardOpenOption.WRITE,
          StandardOpenOption.APPEND,
          LinkOption.NOFOLLOW_LINKS);
    }
  }

  private static FileChannel openConnectionChannel(Path logDir, String id, boolean isPosix)
      throws IOException {
    String shortUuid = sanitizeIdSegment(id);
    String timestamp = LocalDateTime.now().format(FILE_TIMESTAMP_FORMAT);
    for (int attempt = 0; attempt < MAX_CREATE_ATTEMPTS; attempt++) {
      String fileName =
          attempt == 0
              ? "BQ-JDBC-" + timestamp + "-" + shortUuid + ".log"
              : "BQ-JDBC-" + timestamp + "-" + attempt + "-" + shortUuid + ".log";
      try {
        return openExclusiveNewChannel(logDir.resolve(fileName), isPosix);
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
      SeekableByteChannel channel =
          DEFAULT_HANDLER_ID.equals(id)
              ? openSecureGlobalChannel(verifiedDir.resolve(GLOBAL_LOG_FILE_NAME), isPosix)
              : openConnectionChannel(verifiedDir, id, isPosix);
      return new ChannelLogWriter(channel, writerLevel, logFormatter, this);
    } catch (Exception e) {
      reportError("Failed to create log file for connection " + id, e, ErrorManager.OPEN_FAILURE);
      return null;
    }
  }

  @Override
  public void publish(LogRecord record) {
    if (record == null || !isLoggable(record)) {
      return;
    }

    String connectionId = BigQueryJdbcMdc.getConnectionId();
    if (connectionId == null || connectionId.isEmpty()) {
      Object[] params = record.getParameters();
      if (params != null && params.length > 0 && params[0] instanceof String) {
        connectionId = (String) params[0];
      }
    }
    ChannelLogWriter target = defaultWriter;

    if (connectionId != null && !connectionId.isEmpty() && baseLogPath != null) {
      target =
          writers.computeIfAbsent(connectionId, id -> createLogWriter(id, baseLogPath, this.level));
      if (target == null) {
        target = defaultWriter;
      }
    }

    if (target != null) {
      target.publish(record);
    }
  }

  @Override
  public void flush() {
    // Unbuffered OS file channel writes are immediately visible to readers without JVM buffering.
  }

  @Override
  public void close() throws SecurityException {
    for (ChannelLogWriter writer : writers.values()) {
      try {
        writer.close();
      } catch (Exception ignored) {
      }
    }
    try {
      if (defaultWriter != null) {
        defaultWriter.close();
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

  static final class ChannelLogWriter {
    private final Object lock = new Object();
    private final Level writerLevel;
    private final Formatter formatter;
    private final PerConnectionFileHandler owner;
    private SeekableByteChannel channel;
    private boolean closed;

    ChannelLogWriter(
        SeekableByteChannel channel,
        Level writerLevel,
        Formatter formatter,
        PerConnectionFileHandler owner) {
      this.channel = channel;
      this.writerLevel = writerLevel;
      this.formatter = formatter;
      this.owner = owner;
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
        try {
          ByteBuffer buf = ByteBuffer.wrap(bytes);
          while (buf.hasRemaining()) {
            channel.write(buf);
          }
        } catch (IOException e) {
          owner.reportError("Failed to write log record", e, ErrorManager.WRITE_FAILURE);
        }
      }
    }

    void close() {
      synchronized (lock) {
        if (closed) {
          return;
        }
        closed = true;
        if (channel != null) {
          try {
            channel.close();
          } catch (IOException e) {
            owner.reportError("Failed to close log file", e, ErrorManager.CLOSE_FAILURE);
          }
          channel = null;
        }
      }
    }
  }
}
