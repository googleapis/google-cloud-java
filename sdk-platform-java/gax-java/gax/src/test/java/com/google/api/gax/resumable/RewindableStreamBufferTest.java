/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.resumable;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.protobuf.ByteString;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class RewindableStreamBufferTest {

  @Test
  void testReadSequentialChunks() throws IOException {
    byte[] data = "HelloWorld123456".getBytes(StandardCharsets.UTF_8); // 16 bytes
    ByteArrayInputStream stream = new ByteArrayInputStream(data);
    RewindableStreamBuffer buffer = new RewindableStreamBuffer(stream, 8);

    // Read first chunk (8 bytes: "HelloWor")
    ByteString chunk1 = buffer.readChunk(0, 8);
    assertThat(chunk1.toStringUtf8()).isEqualTo("HelloWor");
    assertThat(buffer.isEndOfStream()).isFalse();

    // Commit first chunk
    buffer.commit(8);

    // Read second chunk (8 bytes: "ld123456")
    ByteString chunk2 = buffer.readChunk(8, 8);
    assertThat(chunk2.toStringUtf8()).isEqualTo("ld123456");

    // Read at EOF
    buffer.commit(16);
    ByteString chunk3 = buffer.readChunk(16, 8);
    assertThat(chunk3.isEmpty()).isTrue();
    assertThat(buffer.isEndOfStream()).isTrue();

    buffer.close();
  }

  @Test
  void testSeekAndRewindWithinChunk() throws IOException {
    byte[] data = "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8); // 16 bytes
    ByteArrayInputStream stream = new ByteArrayInputStream(data);
    RewindableStreamBuffer buffer = new RewindableStreamBuffer(stream, 8);

    // Read first chunk of 8 bytes ("01234567")
    ByteString chunk1 = buffer.readChunk(0, 8);
    assertThat(chunk1.toStringUtf8()).isEqualTo("01234567");

    // Simulate failure where server only committed 3 bytes ("012")
    buffer.seek(3);

    // Retry reading from offset 3 (should return slice "34567")
    ByteString retrySlice = buffer.readChunk(3, 8);
    assertThat(retrySlice.toStringUtf8()).isEqualTo("34567");

    // Once server commits full 8 bytes
    buffer.commit(8);

    // Read next chunk ("89ABCDEF")
    ByteString chunk2 = buffer.readChunk(8, 8);
    assertThat(chunk2.toStringUtf8()).isEqualTo("89ABCDEF");

    buffer.close();
  }

  @Test
  void testPartialReadSmallerThanChunkSize() throws IOException {
    byte[] data = "Small".getBytes(StandardCharsets.UTF_8); // 5 bytes
    ByteArrayInputStream stream = new ByteArrayInputStream(data);
    RewindableStreamBuffer buffer = new RewindableStreamBuffer(stream, 10);

    ByteString chunk = buffer.readChunk(0, 10);
    assertThat(chunk.toStringUtf8()).isEqualTo("Small");
    assertThat(buffer.isEndOfStream()).isTrue(); // Encountered EOF while reading

    ByteString nextChunk = buffer.readChunk(5, 10);
    assertThat(nextChunk.isEmpty()).isTrue();
    assertThat(buffer.isEndOfStream()).isTrue();

    buffer.close();
  }

  @Test
  void testEmptyStream() throws IOException {
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[0]);
    RewindableStreamBuffer buffer = new RewindableStreamBuffer(stream, 8);

    ByteString chunk = buffer.readChunk(0, 8);
    assertThat(chunk.isEmpty()).isTrue();
    assertThat(buffer.isEndOfStream()).isTrue();

    buffer.close();
  }

  @Test
  void testSeekFromBeginning() throws IOException {
    byte[] data = "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8); // 16 bytes
    ByteArrayInputStream stream = new ByteArrayInputStream(data);
    RewindableStreamBuffer buffer = new RewindableStreamBuffer(stream, 8);

    // Seek directly to offset 8 before any reads (e.g. resuming session)
    buffer.seek(8);

    ByteString chunk = buffer.readChunk(8, 8);
    assertThat(chunk.toStringUtf8()).isEqualTo("89ABCDEF");
    assertThat(buffer.isEndOfStream()).isFalse();

    buffer.close();
  }

  @Test
  void testSeekForwardAcrossChunks() throws IOException {
    byte[] data = "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8); // 16 bytes
    ByteArrayInputStream stream = new ByteArrayInputStream(data);
    RewindableStreamBuffer buffer = new RewindableStreamBuffer(stream, 4);

    ByteString chunk1 = buffer.readChunk(0, 4);
    assertThat(chunk1.toStringUtf8()).isEqualTo("0123");

    // Seek past chunk 1 to offset 10
    buffer.seek(10);

    ByteString chunk2 = buffer.readChunk(10, 4);
    assertThat(chunk2.toStringUtf8()).isEqualTo("ABCD");

    buffer.close();
  }

  @Test
  void testInvalidChunkSize() {
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[0]);
    assertThrows(IllegalArgumentException.class, () -> new RewindableStreamBuffer(stream, 0));
  }
}
