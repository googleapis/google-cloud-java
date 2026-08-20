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
    DataChunk chunk1 = buffer.nextChunk();
    assertThat(new String(chunk1.getPayload(), StandardCharsets.UTF_8)).isEqualTo("HelloWor");
    assertThat(chunk1.getOffset()).isEqualTo(0);
    assertThat(chunk1.isFinal()).isFalse();

    // Acknowledge first chunk
    buffer.acknowledge(8);

    // Read second chunk (8 bytes: "ld123456")
    DataChunk chunk2 = buffer.nextChunk();
    assertThat(new String(chunk2.getPayload(), StandardCharsets.UTF_8)).isEqualTo("ld123456");
    assertThat(chunk2.getOffset()).isEqualTo(8);
    assertThat(chunk2.isFinal()).isFalse();

    // Subsequent read returns empty final chunk
    buffer.acknowledge(16);
    DataChunk chunk3 = buffer.nextChunk();
    assertThat(chunk3.getPayload()).isEmpty();
    assertThat(chunk3.getOffset()).isEqualTo(16);
    assertThat(chunk3.isFinal()).isTrue();

    buffer.close();
  }

  @Test
  void testSeekAndRewindWithinChunk() throws IOException {
    byte[] data = "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8); // 16 bytes
    ByteArrayInputStream stream = new ByteArrayInputStream(data);
    RewindableStreamBuffer buffer = new RewindableStreamBuffer(stream, 8);

    // Read first chunk of 8 bytes ("01234567")
    DataChunk chunk1 = buffer.nextChunk();
    assertThat(new String(chunk1.getPayload(), StandardCharsets.UTF_8)).isEqualTo("01234567");
    assertThat(chunk1.getOffset()).isEqualTo(0);
    assertThat(chunk1.isFinal()).isFalse();

    // Simulate failure where server only committed 3 bytes ("012")
    buffer.seekTo(3);

    // Retry reading from offset 3 (should return slice "34567" from retained buffer)
    DataChunk retrySlice = buffer.nextChunk();
    assertThat(new String(retrySlice.getPayload(), StandardCharsets.UTF_8)).isEqualTo("34567");
    assertThat(retrySlice.getOffset()).isEqualTo(3);
    assertThat(retrySlice.isFinal()).isFalse();

    // Once server commits full 8 bytes
    buffer.acknowledge(8);

    // Read next chunk ("89ABCDEF")
    DataChunk chunk2 = buffer.nextChunk();
    assertThat(new String(chunk2.getPayload(), StandardCharsets.UTF_8)).isEqualTo("89ABCDEF");
    assertThat(chunk2.getOffset()).isEqualTo(8);
    assertThat(chunk2.isFinal()).isFalse();

    // Subsequent read returns empty final chunk
    buffer.acknowledge(16);
    DataChunk chunk3 = buffer.nextChunk();
    assertThat(chunk3.getPayload()).isEmpty();
    assertThat(chunk3.getOffset()).isEqualTo(16);
    assertThat(chunk3.isFinal()).isTrue();

    buffer.close();
  }

  @Test
  void testPartialReadSmallerThanChunkSize() throws IOException {
    byte[] data = "Small".getBytes(StandardCharsets.UTF_8); // 5 bytes
    ByteArrayInputStream stream = new ByteArrayInputStream(data);
    RewindableStreamBuffer buffer = new RewindableStreamBuffer(stream, 10);

    DataChunk chunk = buffer.nextChunk();
    assertThat(new String(chunk.getPayload(), StandardCharsets.UTF_8)).isEqualTo("Small");
    assertThat(chunk.getOffset()).isEqualTo(0);
    assertThat(chunk.isFinal()).isTrue();

    buffer.acknowledge(5);
    DataChunk nextChunk = buffer.nextChunk();
    assertThat(nextChunk.getPayload()).isEmpty();
    assertThat(nextChunk.getOffset()).isEqualTo(5);
    assertThat(nextChunk.isFinal()).isTrue();

    buffer.close();
  }

  @Test
  void testEmptyStream() throws IOException {
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[0]);
    RewindableStreamBuffer buffer = new RewindableStreamBuffer(stream, 8);

    DataChunk chunk = buffer.nextChunk();
    assertThat(chunk.getPayload()).isEmpty();
    assertThat(chunk.getOffset()).isEqualTo(0);
    assertThat(chunk.isFinal()).isTrue();

    buffer.close();
  }

  @Test
  void testSeekFromBeginning() throws IOException {
    byte[] data = "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8); // 16 bytes
    ByteArrayInputStream stream = new ByteArrayInputStream(data);
    RewindableStreamBuffer buffer = new RewindableStreamBuffer(stream, 8);

    // Seek directly to offset 8 before any reads (e.g. resuming session)
    buffer.seekTo(8);

    DataChunk chunk = buffer.nextChunk();
    assertThat(new String(chunk.getPayload(), StandardCharsets.UTF_8)).isEqualTo("89ABCDEF");
    assertThat(chunk.getOffset()).isEqualTo(8);
    assertThat(chunk.isFinal()).isFalse();

    buffer.acknowledge(16);
    DataChunk finalChunk = buffer.nextChunk();
    assertThat(finalChunk.getPayload()).isEmpty();
    assertThat(finalChunk.getOffset()).isEqualTo(16);
    assertThat(finalChunk.isFinal()).isTrue();

    buffer.close();
  }

  @Test
  void testSeekForwardAcrossChunks() throws IOException {
    byte[] data = "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8); // 16 bytes
    ByteArrayInputStream stream = new ByteArrayInputStream(data);
    RewindableStreamBuffer buffer = new RewindableStreamBuffer(stream, 4);

    DataChunk chunk1 = buffer.nextChunk();
    assertThat(new String(chunk1.getPayload(), StandardCharsets.UTF_8)).isEqualTo("0123");
    assertThat(chunk1.getOffset()).isEqualTo(0);
    assertThat(chunk1.isFinal()).isFalse();

    // Seek past chunk 1 to offset 10
    buffer.seekTo(10);

    DataChunk chunk2 = buffer.nextChunk();
    assertThat(new String(chunk2.getPayload(), StandardCharsets.UTF_8)).isEqualTo("ABCD");
    assertThat(chunk2.getOffset()).isEqualTo(10);
    assertThat(chunk2.isFinal()).isFalse();

    buffer.close();
  }

  @Test
  void testConstructorValidatesChunkSize() {
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[0]);
    assertThrows(IllegalArgumentException.class, () -> new RewindableStreamBuffer(stream, 0));
    assertThrows(IllegalArgumentException.class, () -> new RewindableStreamBuffer(stream, -1));
  }

  @Test
  void testCannotSeekBackwardsBeforeChunkStartThrowsIOException() throws IOException {
    byte[] data = "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8);
    ByteArrayInputStream stream = new ByteArrayInputStream(data);
    RewindableStreamBuffer buffer = new RewindableStreamBuffer(stream, 8);

    // Read first chunk (0..8) and acknowledge it
    DataChunk chunk1 = buffer.nextChunk();
    assertThat(chunk1.getOffset()).isEqualTo(0);
    buffer.acknowledge(8);

    // Read second chunk (8..16)
    DataChunk chunk2 = buffer.nextChunk();
    assertThat(chunk2.getOffset()).isEqualTo(8);

    // Attempting to seek back before chunkStartOffset (8) throws IOException
    assertThrows(IOException.class, () -> buffer.seekTo(4));

    buffer.close();
  }
}
