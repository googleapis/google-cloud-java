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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.jspecify.annotations.NullMarked;

/** Manages a single-chunk rewindable buffer over an {@link InputStream} for resumable uploads. */
@NullMarked
final class RewindableStreamBuffer {

  private static final byte[] EMPTY_PAYLOAD = new byte[0];

  private final InputStream inputStream;
  private final int chunkSize;
  private final byte[] buffer;

  private long bufferBaseOffset;
  private int payloadLength;
  private boolean isFinal;
  private boolean streamExhausted;

  RewindableStreamBuffer(InputStream inputStream, int chunkSize) {
    this.inputStream = checkNotNull(inputStream, "inputStream must not be null");
    checkArgument(chunkSize > 0, "chunkSize must be > 0");
    this.chunkSize = chunkSize;
    this.buffer = new byte[chunkSize];
    this.bufferBaseOffset = 0L;
    this.payloadLength = 0;
    this.isFinal = false;
    this.streamExhausted = false;
  }

  /**
   * Advances the buffer past the current payload, reading up to chunk size from the stream.
   *
   * @throws IOException if reading from the stream fails
   */
  void fill() throws IOException {
    this.bufferBaseOffset += payloadLength;
    this.payloadLength = ByteStreams.read(inputStream, buffer, 0, chunkSize);
    this.isFinal = (payloadLength < chunkSize);
    if (this.isFinal) {
      this.streamExhausted = true;
    }
  }

  /**
   * Realigns the buffer window to {@code committedOffset}.
   *
   * <p>Compacts forward within the existing buffer to discard already-committed bytes, and then
   * tops up the buffer to capacity from the underlying stream.
   *
   * @param committedOffset the server's committed byte offset
   * @throws IllegalStateException if {@code committedOffset} is below the buffer's base offset or
   *     beyond the current buffer window
   * @throws IOException if reading from the stream fails
   */
  void realignTo(long committedOffset) throws IOException {
    if (committedOffset < bufferBaseOffset) {
      throw new IllegalStateException(
          String.format(
              "Server committed offset %d is below buffer base offset %d, which the server already"
                  + " acknowledged; the upload cannot continue and must be restarted.",
              committedOffset, bufferBaseOffset));
    }

    if (committedOffset > bufferBaseOffset + payloadLength) {
      throw new IllegalStateException(
          String.format(
              "Server committed offset %d is beyond current buffer window [%d, %d]",
              committedOffset, bufferBaseOffset, bufferBaseOffset + payloadLength));
    }

    int committedWithinBuffer = (int) (committedOffset - bufferBaseOffset);
    int remainingBytes = payloadLength - committedWithinBuffer;

    if (remainingBytes > 0 && committedWithinBuffer > 0) {
      System.arraycopy(buffer, committedWithinBuffer, buffer, 0, remainingBytes);
    }

    this.bufferBaseOffset = committedOffset;
    this.payloadLength = remainingBytes;

    if (!streamExhausted && payloadLength < chunkSize) {
      int space = chunkSize - payloadLength;
      int additionalRead = ByteStreams.read(inputStream, buffer, payloadLength, space);
      payloadLength += additionalRead;
      if (additionalRead < space) {
        streamExhausted = true;
      }
    }

    this.isFinal = streamExhausted;
  }

  byte[] getPayload() {
    if (payloadLength == buffer.length) {
      return buffer;
    }
    if (payloadLength == 0) {
      return EMPTY_PAYLOAD;
    }
    return Arrays.copyOf(buffer, payloadLength);
  }

  long getBufferBaseOffset() {
    return bufferBaseOffset;
  }

  boolean isFinal() {
    return isFinal;
  }
}
