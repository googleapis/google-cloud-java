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
package com.google.api.gax.rpc;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class RewindableStreamBufferTest {

  private static final String UPLOAD_URL = "https://upload.example.com/session-1";

  @Test
  void testExactMultiplePayloads() throws IOException {
    byte[] data = "0123456789abcdef".getBytes(StandardCharsets.UTF_8); // 16 bytes, chunk size 8
    RewindableStreamBuffer buffer =
        new RewindableStreamBuffer(new ByteArrayInputStream(data), 8, UPLOAD_URL);

    // Chunk 0: 8 bytes
    buffer.fill();
    assertThat(buffer.getBufferBaseOffset()).isEqualTo(0L);
    assertThat(buffer.getPayload()).hasLength(8);
    assertThat(buffer.isFinal()).isFalse();
    assertThat(new String(buffer.getPayload(), StandardCharsets.UTF_8)).isEqualTo("01234567");

    // Chunk 1: 8 bytes
    buffer.fill();
    assertThat(buffer.getBufferBaseOffset()).isEqualTo(8L);
    assertThat(buffer.getPayload()).hasLength(8);
    assertThat(buffer.isFinal()).isFalse();
    assertThat(new String(buffer.getPayload(), StandardCharsets.UTF_8)).isEqualTo("89abcdef");

    // Final 0-byte finalize chunk
    buffer.fill();
    assertThat(buffer.getBufferBaseOffset()).isEqualTo(16L);
    assertThat(buffer.getPayload()).hasLength(0);
    assertThat(buffer.isFinal()).isTrue();
    assertThat(buffer.getPayload()).isEmpty();
  }

  @Test
  void testShortFinalChunk() throws IOException {
    byte[] data = "short".getBytes(StandardCharsets.UTF_8); // 5 bytes, chunk size 8
    RewindableStreamBuffer buffer =
        new RewindableStreamBuffer(new ByteArrayInputStream(data), 8, UPLOAD_URL);

    buffer.fill();
    assertThat(buffer.getBufferBaseOffset()).isEqualTo(0L);
    assertThat(buffer.getPayload()).hasLength(5);
    assertThat(buffer.isFinal()).isTrue();
    assertThat(new String(buffer.getPayload(), StandardCharsets.UTF_8)).isEqualTo("short");
  }

  @Test
  void testZeroBytePayload() throws IOException {
    RewindableStreamBuffer buffer =
        new RewindableStreamBuffer(new ByteArrayInputStream(new byte[0]), 8, UPLOAD_URL);

    buffer.fill();
    assertThat(buffer.getBufferBaseOffset()).isEqualTo(0L);
    assertThat(buffer.getPayload()).hasLength(0);
    assertThat(buffer.isFinal()).isTrue();
    assertThat(buffer.getPayload()).isEmpty();
  }

  @Test
  void testRealignToMidBufferOffset_compactsAndTopsUp() throws IOException {
    // 20 bytes: chunk size 8
    byte[] data = "0123456789ABCDEFGHIJ".getBytes(StandardCharsets.UTF_8);
    RewindableStreamBuffer buffer =
        new RewindableStreamBuffer(new ByteArrayInputStream(data), 8, UPLOAD_URL);

    // Initial fill: "01234567" (bytes 0..7)
    buffer.fill();
    assertThat(buffer.getPayload()).hasLength(8);
    assertThat(new String(buffer.getPayload(), StandardCharsets.UTF_8)).isEqualTo("01234567");

    // Server committed 5 bytes (0..4), so next committed offset is 5.
    // Remaining uncommitted bytes in buffer: "567" (3 bytes).
    // realignTo(5) compacts "567" to buffer[0..3) and tops up 5 more bytes ("89ABC") from stream.
    buffer.realignTo(5L);
    assertThat(buffer.getBufferBaseOffset()).isEqualTo(5L);
    assertThat(buffer.getPayload()).hasLength(8); // 3 remaining + 5 topped up = 8
    assertThat(buffer.isFinal()).isFalse();
    assertThat(new String(buffer.getPayload(), StandardCharsets.UTF_8)).isEqualTo("56789ABC");
  }

  @Test
  void testRealignToBufferBaseOffset_isNoOp() throws IOException {
    byte[] data = "0123456789".getBytes(StandardCharsets.UTF_8);
    RewindableStreamBuffer buffer =
        new RewindableStreamBuffer(new ByteArrayInputStream(data), 8, UPLOAD_URL);

    buffer.fill();
    assertThat(buffer.getPayload()).hasLength(8);
    assertThat(new String(buffer.getPayload(), StandardCharsets.UTF_8)).isEqualTo("01234567");

    // Realigning to exactly the buffer base offset (0) is a no-op
    buffer.realignTo(0L);
    assertThat(buffer.getBufferBaseOffset()).isEqualTo(0L);
    assertThat(buffer.getPayload()).hasLength(8);
    assertThat(new String(buffer.getPayload(), StandardCharsets.UTF_8)).isEqualTo("01234567");
  }

  @Test
  void testRealignToBelowBaseOffset_throwsIllegalStateException() throws IOException {
    byte[] data = "0123456789abcdef".getBytes(StandardCharsets.UTF_8);
    RewindableStreamBuffer buffer =
        new RewindableStreamBuffer(new ByteArrayInputStream(data), 8, UPLOAD_URL);

    // Advanced to chunk 1 (base offset 8)
    buffer.fill();
    buffer.fill();
    assertThat(buffer.getBufferBaseOffset()).isEqualTo(8L);

    // Server requests offset 4, which is below buffer base offset 8
    IllegalStateException exception =
        assertThrows(IllegalStateException.class, () -> buffer.realignTo(4L));

    assertThat(exception.getMessage()).contains("4");
    assertThat(exception.getMessage()).contains("8");
    assertThat(exception.getMessage()).contains(UPLOAD_URL);
  }

  @Test
  void testRealignToBeyondBufferWindow_throwsIllegalStateException() throws IOException {
    byte[] data = "0123456789abcdef".getBytes(StandardCharsets.UTF_8);
    RewindableStreamBuffer buffer =
        new RewindableStreamBuffer(new ByteArrayInputStream(data), 8, UPLOAD_URL);

    // Initial fill at 0: window is [0, 8]
    buffer.fill();
    assertThat(buffer.getBufferBaseOffset()).isEqualTo(0L);
    assertThat(buffer.getPayload()).hasLength(8);

    // Server reports committed offset 10, which is beyond current buffer window [0, 8]
    IllegalStateException exception =
        assertThrows(IllegalStateException.class, () -> buffer.realignTo(10L));

    assertThat(exception.getMessage()).contains("10");
    assertThat(exception.getMessage()).contains("8");
    assertThat(exception.getMessage()).contains(UPLOAD_URL);
  }

  @Test
  void testRealignToMidBufferOffset_reachingEofMarksFinal() throws IOException {
    // 10 bytes total, chunk size 8
    byte[] data = "0123456789".getBytes(StandardCharsets.UTF_8);
    RewindableStreamBuffer buffer =
        new RewindableStreamBuffer(new ByteArrayInputStream(data), 8, UPLOAD_URL);

    // Initial fill: "01234567" (bytes 0..7), stream still has "89" remaining
    buffer.fill();
    assertThat(buffer.getPayload()).hasLength(8);
    assertThat(buffer.isFinal()).isFalse();

    // Server committed 4 bytes (0..3). Compacts "4567" (4 bytes) and tops up "89" (2 bytes < space)
    buffer.realignTo(4L);
    assertThat(buffer.getBufferBaseOffset()).isEqualTo(4L);
    assertThat(buffer.getPayload()).hasLength(6);
    assertThat(buffer.isFinal()).isTrue();
    assertThat(new String(buffer.getPayload(), StandardCharsets.UTF_8)).isEqualTo("456789");
  }

  @Test
  void testFillWithShortReads_greedilyFillsBufferToCapacity() throws IOException {
    byte[] data = "01234567".getBytes(StandardCharsets.UTF_8); // 8 bytes
    // Stream that yields at most 2 bytes per read
    InputStream shortReadingStream =
        new FilterInputStream(new ByteArrayInputStream(data)) {
          @Override
          public int read(byte[] b, int off, int len) throws IOException {
            return super.read(b, off, Math.min(len, 2));
          }
        };

    RewindableStreamBuffer buffer = new RewindableStreamBuffer(shortReadingStream, 8, UPLOAD_URL);
    buffer.fill();

    // Must greedily fill all 8 bytes despite short reads, and not be marked final yet
    assertThat(buffer.getPayload()).hasLength(8);
    assertThat(buffer.isFinal()).isFalse();
    assertThat(new String(buffer.getPayload(), StandardCharsets.UTF_8)).isEqualTo("01234567");
  }
}
