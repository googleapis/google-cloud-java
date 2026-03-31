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

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.storage.RewindableContentPropertyTest.ErroringOutputStream;
import com.google.protobuf.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public final class RewindableByteBufferContentTest {

  private long total;
  private ByteBuffer[] buffers;
  private String fullXxd;

  @Before
  public void setUp() throws Exception {
    // full buffer
    ByteBuffer bufFull = DataGenerator.base64Characters().genByteBuffer(16);
    // limited buffer
    ByteBuffer bufLimit = DataGenerator.base64Characters().genByteBuffer(16);
    bufLimit.limit(15);
    // offset buffer
    ByteBuffer bufOffset = DataGenerator.base64Characters().genByteBuffer(16);
    bufOffset.position(3);
    // offset and limited buffer
    ByteBuffer bufLimitAndOffset = DataGenerator.base64Characters().genByteBuffer(16);
    bufLimitAndOffset.position(9).limit(12);

    total =
        bufFull.remaining()
            + bufLimit.remaining()
            + bufOffset.remaining()
            + bufLimitAndOffset.remaining();
    buffers = new ByteBuffer[] {bufFull, bufLimit, bufOffset, bufLimitAndOffset};
    fullXxd = xxd(false, buffers);
  }

  @Test
  public void getLength() {
    RewindableContent content = RewindableContent.of(buffers);

    assertThat(content.getLength()).isEqualTo(total);
  }

  @Test
  public void writeTo() throws IOException {

    RewindableContent content = RewindableContent.of(buffers);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    content.writeTo(baos);

    String actual = xxd(baos.toByteArray());
    assertThat(actual).isEqualTo(fullXxd);
  }

  @Test
  public void rewind() throws IOException {

    RewindableContent content = RewindableContent.of(buffers);

    assertThrows(
        IOException.class,
        () -> {
          try (ErroringOutputStream erroringOutputStream = new ErroringOutputStream(25)) {
            content.writeTo(erroringOutputStream);
          }
        });
    content.rewindTo(0L);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    content.writeTo(baos);

    String actual = xxd(baos.toByteArray());
    assertThat(actual).isEqualTo(fullXxd);
  }

  @Test
  public void rewindTo() throws Exception {
    RewindableContent content = RewindableContent.of(buffers);

    ByteString reduce =
        Arrays.stream(buffers)
            .map(ByteBuffer::duplicate)
            .map(ByteStringStrategy.noCopy())
            .reduce(ByteString.empty(), ByteString::concat, (l, r) -> r);

    assertThat(content.getLength()).isEqualTo(total);

    int readOffset = 37;
    ByteString substring = reduce.substring(readOffset);
    ByteBuffer readOnlyByteBuffer = substring.asReadOnlyByteBuffer();
    String expected = xxd(false, readOnlyByteBuffer);
    long value = total - readOffset;
    content.rewindTo(readOffset);
    assertThat(content.getLength()).isEqualTo(value);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    content.writeTo(baos);

    String actual = xxd(baos.toByteArray());
    assertAll(
        () -> assertThat(baos.toByteArray()).hasLength(Math.toIntExact(value)),
        () -> assertThat(actual).isEqualTo(expected));
  }

  @Test
  public void rewind_dirtyAware() throws IOException {

    ByteBuffer buf = DataGenerator.base64Characters().genByteBuffer(10);
    buf.position(3).limit(7);

    int position = buf.position();
    int limit = buf.limit();

    RewindableContent content = RewindableContent.of(buf);
    int hackPosition = 2;
    // after content has initialized, mutate the position underneath it. We're doing this to detect
    // if rewind is actually modifying things. It shouldn't until the content is dirtied by calling
    // writeTo
    buf.position(hackPosition);

    // invoke rewind, and expect it to not do anything
    content.rewindTo(0L);
    assertThat(buf.position()).isEqualTo(hackPosition);
    assertThat(buf.limit()).isEqualTo(limit);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    content.writeTo(baos);

    assertThat(buf.position()).isEqualTo(limit);
    assertThat(buf.limit()).isEqualTo(limit);

    content.rewindTo(0L);
    assertThat(buf.position()).isEqualTo(position);
    assertThat(buf.limit()).isEqualTo(limit);
  }
}
