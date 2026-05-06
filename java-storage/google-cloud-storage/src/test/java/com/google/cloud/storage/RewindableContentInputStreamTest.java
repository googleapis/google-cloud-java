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

import static com.google.cloud.storage.ByteSizeConstants._256KiB;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.Test;

public final class RewindableContentInputStreamTest {

  @Test
  public void read_empty() throws IOException {
    RewindableContent content = RewindableContent.empty();
    try (RewindableContentInputStream in = new RewindableContentInputStream(content)) {
      int read = in.read();
      assertThat(read).isEqualTo(-1);
    }
  }

  @Test
  public void readB_emptySrc() throws IOException {
    RewindableContent content = RewindableContent.empty();
    try (RewindableContentInputStream in = new RewindableContentInputStream(content)) {
      int read = in.read(new byte[1]);
      assertThat(read).isEqualTo(-1);
    }
  }

  @Test
  public void readB_emptyDst() throws IOException {
    byte[] bytes = DataGenerator.base64Characters().genBytes(1);
    RewindableContent content = RewindableContent.of(ByteBuffer.wrap(bytes));
    try (RewindableContentInputStream in = new RewindableContentInputStream(content)) {
      byte[] tmp = new byte[0];
      int read = in.read(tmp);
      assertThat(read).isEqualTo(0);
    }
  }

  @Test
  public void readB_singleByte() throws IOException {
    byte[] bytes = DataGenerator.base64Characters().genBytes(1);
    RewindableContent content = RewindableContent.of(ByteBuffer.wrap(bytes));
    try (RewindableContentInputStream in = new RewindableContentInputStream(content)) {
      byte[] tmp = new byte[_256KiB];
      int read = in.read(tmp);
      assertThat(read).isEqualTo(1);
      assertThat(tmp[0]).isEqualTo(bytes[0]);
    }
  }

  @Test
  public void read_singleByte() throws IOException {
    byte[] bytes = DataGenerator.base64Characters().genBytes(1);
    RewindableContent content = RewindableContent.of(ByteBuffer.wrap(bytes));
    try (RewindableContentInputStream in = new RewindableContentInputStream(content)) {
      int read = in.read();
      assertThat(read).isEqualTo(bytes[0]);
    }
  }

  @Test
  public void readB_multiContent() throws IOException {
    byte[] bytes = DataGenerator.base64Characters().genBytes(30);
    RewindableContent content =
        RewindableContent.of(
            ByteBuffer.wrap(bytes, 0, 10),
            ByteBuffer.wrap(bytes, 10, 10),
            ByteBuffer.wrap(bytes, 20, 10));
    try (RewindableContentInputStream in = new RewindableContentInputStream(content)) {
      byte[] tmp = new byte[_256KiB];
      int read = in.read(tmp);
      assertThat(read).isEqualTo(30);
      assertThat(xxd(ByteString.copyFrom(tmp, 0, read))).isEqualTo(xxd(bytes));
    }
  }
}
