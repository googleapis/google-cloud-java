/*
 * Copyright 2025 Google LLC
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TmpDir implements AutoCloseable {
  private static final Logger LOGGER = LoggerFactory.getLogger(TmpDir.class);

  private final Path path;

  private TmpDir(Path path) {
    this.path = path;
  }

  public Path getPath() {
    return path;
  }

  /** Delete the TmpFile this handle is holding */
  @Override
  public void close() throws IOException {
    TestUtils.rmDashRf(path);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("path", path).toString();
  }

  /**
   * Create a temporary file, which will be deleted when close is called on the returned {@link
   * TmpDir}
   */
  public static TmpDir of(Path baseDir, String prefix) throws IOException {
    LOGGER.trace("of(baseDir : {}, prefix : {})", baseDir, prefix);
    Path path = Files.createTempDirectory(baseDir, prefix);
    return new TmpDir(path);
  }
}
