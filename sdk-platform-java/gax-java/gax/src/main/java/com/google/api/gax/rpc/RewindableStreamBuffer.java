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
import org.jspecify.annotations.NullMarked;

/**
 * Manages a single-chunk buffer over an {@link InputStream} for resumable uploads.
 *
 * <p>The buffer holds at most one chunk of data in a reused backing array. It supports forward
 * compaction and topping up upon recovery realignment, and enforces the boundary condition that
 * requests to rewind before the buffer's base offset fail with an unrecoverable {@link
 * UploadProtocolViolationException}.
 */
@NullMarked
final class RewindableStreamBuffer {

  private final InputStream inputStream;
  private final int chunkSize;
  private final String uploadUrl;
  private final byte[] buffer;

  private long bufferBaseOffset;
  private int payloadLength;
  private boolean isFinal;
  private boolean streamExhausted;

  RewindableStreamBuffer(InputStream inputStream, int chunkSize, String uploadUrl) {
    this.inputStream = checkNotNull(inputStream, "inputStream must not be null");
    checkArgument(chunkSize > 0, "chunkSize must be > 0");
    this.chunkSize = chunkSize;
    this.uploadUrl = checkNotNull(uploadUrl, "uploadUrl must not be null");
    this.buffer = new byte[chunkSize];
    this.bufferBaseOffset = 0L;
    this.payloadLength = 0;
    this.isFinal = false;
    this.streamExhausted = false;
  }

  /**
   * Advances the buffer from the stream starting at {@code targetOffset}, reading up to chunk size.
   *
   * @param targetOffset the absolute stream offset corresponding to the start of this chunk
   * @throws IOException if reading from the stream fails
   */
  void fill(long targetOffset) throws IOException {
    this.bufferBaseOffset = targetOffset;
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
   * @throws UploadProtocolViolationException if {@code committedOffset} is below the buffer's base
   *     offset or beyond the current buffer window
   * @throws IOException if reading from the stream fails
   */
  void realignTo(long committedOffset) throws IOException {
    if (committedOffset < bufferBaseOffset) {
      throw new UploadProtocolViolationException(
          String.format(
              "Server committed offset %d is below buffer base offset %d for upload URL %s; cannot"
                  + " rewind stream before buffer base",
              committedOffset, bufferBaseOffset, uploadUrl));
    }

    if (committedOffset > bufferBaseOffset + payloadLength) {
      throw new UploadProtocolViolationException(
          String.format(
              "Server committed offset %d is beyond current buffer window [%d, %d] for upload URL"
                  + " %s",
              committedOffset, bufferBaseOffset, bufferBaseOffset + payloadLength, uploadUrl));
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

  byte[] getBuffer() {
    return buffer;
  }

  int getPayloadLength() {
    return payloadLength;
  }

  long getBufferBaseOffset() {
    return bufferBaseOffset;
  }

  boolean isFinal() {
    return isFinal;
  }

  boolean isEmpty() {
    return payloadLength == 0;
  }
}
