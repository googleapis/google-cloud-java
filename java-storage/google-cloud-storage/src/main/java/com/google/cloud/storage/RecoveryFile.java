/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.storage;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Set;

/**
 * When uploading to GCS, there are times when memory buffers are not preferable. This class
 * encapsulates the logic and lifecycle for a file written to local disk which can be used for
 * upload recovery in the case an upload is interrupted.
 */
final class RecoveryFile implements AutoCloseable {
  private static final Set<OpenOption> writeOpsNew =
      ImmutableSet.of(
          StandardOpenOption.CREATE,
          StandardOpenOption.WRITE,
          StandardOpenOption.TRUNCATE_EXISTING);
  private static final Set<OpenOption> writeOpsExisting =
      ImmutableSet.of(
          StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
  private static final Set<OpenOption> readOps = ImmutableSet.of(StandardOpenOption.READ);

  private final Path path;
  private final ThroughputSink throughputSink;
  private final Runnable onCloseCallback;

  private boolean newFile;

  RecoveryFile(Path path, ThroughputSink throughputSink, Runnable onCloseCallback) {
    this.path = path;
    this.throughputSink = throughputSink;
    this.onCloseCallback = onCloseCallback;
    this.newFile = true;
  }

  public Path getPath() {
    return path;
  }

  public Path touch() throws IOException {
    newFile = false;
    return Files.createFile(path);
  }

  public SeekableByteChannel reader() throws IOException {
    return Files.newByteChannel(path, readOps);
  }

  public WritableByteChannel writer() throws IOException {
    try {
      return throughputSink.decorate(
          Files.newByteChannel(path, newFile ? writeOpsNew : writeOpsExisting));
    } finally {
      newFile = false;
    }
  }

  public GatheringByteChannel syncingChannel() throws IOException {
    try {
      return throughputSink.decorate(
          new SyncingFileChannel(FileChannel.open(path, newFile ? writeOpsNew : writeOpsExisting)));
    } finally {
      newFile = false;
    }
  }

  @Override
  public void close() throws IOException {
    Files.deleteIfExists(path);
    onCloseCallback.run();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("path", path)
        .add("throughputSink", throughputSink)
        .add("onCloseCallback", onCloseCallback)
        .toString();
  }

  Unsafe unsafe() {
    return new Unsafe();
  }

  final class Unsafe {
    public Path touch() throws UnsafeIOException {
      try {
        return RecoveryFile.this.touch();
      } catch (IOException e) {
        throw new UnsafeIOException(e);
      }
    }
  }

  static final class UnsafeIOException extends RuntimeException {
    private UnsafeIOException(IOException cause) {
      super(cause);
    }
  }
}
