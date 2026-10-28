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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public final class RewindablePathContentTest {

  @Rule public final TemporaryFolder temp = new TemporaryFolder();

  @Test
  public void zeroByteFile_rewindToZero_succeeds() throws IOException {
    Path empty = temp.newFile("empty").toPath();
    RewindableContent content = RewindableContent.of(empty);

    // first "attempt"
    assertThat(writeAll(content)).isEmpty();
    // retry rewinds to 0, which must be allowed for a zero-byte file
    content.rewindTo(0);
    assertThat(content.getLength()).isEqualTo(0);
    assertThat(writeAll(content)).isEmpty();
  }

  @Test
  public void nonEmptyFile_rewindToSize_succeeds() throws IOException {
    byte[] bytes = "abcdefghij".getBytes(StandardCharsets.UTF_8);
    Path path = temp.newFile("ten").toPath();
    Files.write(path, bytes);
    RewindableContent content = RewindableContent.of(path);

    content.rewindTo(bytes.length);
    assertThat(content.getLength()).isEqualTo(0);
    assertThat(writeAll(content)).isEmpty();
  }

  @Test
  public void nonEmptyFile_rewindOutOfBounds_throws() throws IOException {
    byte[] bytes = "abcdefghij".getBytes(StandardCharsets.UTF_8);
    Path path = temp.newFile("ten").toPath();
    Files.write(path, bytes);
    RewindableContent content = RewindableContent.of(path);

    assertThrows(IllegalArgumentException.class, () -> content.rewindTo(bytes.length + 1));
    assertThrows(IllegalArgumentException.class, () -> content.rewindTo(-1));
  }

  @Test
  public void rewindToZero_afterFullWrite_replaysIdenticalBytes() throws IOException {
    byte[] bytes = DataGenerator.base64Characters().genBytes(17 * 1024 + 3);
    Path path = temp.newFile("data").toPath();
    Files.write(path, bytes);
    RewindableContent content = RewindableContent.of(path);

    byte[] first = writeAll(content);
    content.rewindTo(0);
    byte[] second = writeAll(content);

    assertThat(first).isEqualTo(bytes);
    assertThat(second).isEqualTo(bytes);
  }

  private static byte[] writeAll(RewindableContent content) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (WritableByteChannel c = Channels.newChannel(baos)) {
      content.writeTo(c);
    }
    return baos.toByteArray();
  }
}
