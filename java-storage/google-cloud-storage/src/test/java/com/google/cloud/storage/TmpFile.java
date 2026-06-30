/*
 * Copyright 2022 Google LLC
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
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Set;

public final class TmpFile implements AutoCloseable {
  private static final Set<OpenOption> writeOps =
      ImmutableSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE);
  private static final Set<OpenOption> readOps = ImmutableSet.of(StandardOpenOption.READ);

  private final Path path;

  private TmpFile(Path path) {
    this.path = path;
  }

  public Path getPath() {
    return path;
  }

  public SeekableByteChannel reader() throws IOException {
    return Files.newByteChannel(path, readOps);
  }

  public SeekableByteChannel writer() throws IOException {
    return Files.newByteChannel(path, writeOps);
  }

  /** Delete the TmpFile this handle is holding */
  @Override
  public void close() throws IOException {
    Files.delete(path);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("path", path).toString();
  }

  /**
   * Create a temporary file, which will be deleted when close is called on the returned {@link
   * TmpFile}
   */
  public static TmpFile of(Path baseDir, String prefix, String suffix) throws IOException {
    Path path = Files.createTempFile(baseDir, prefix, suffix);
    return new TmpFile(path);
  }
}
