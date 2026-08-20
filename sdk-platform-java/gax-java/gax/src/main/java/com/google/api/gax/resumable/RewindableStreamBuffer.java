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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.InternalApi;
import com.google.common.io.ByteStreams;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * A package-private stream buffer that supports single-chunk rewind and seeking over an {@link
 * InputStream} for resumable uploads.
 */
@NullMarked
@InternalApi
public class RewindableStreamBuffer implements AutoCloseable {

  private final InputStream source;
  private final int chunkSize;

  private byte @Nullable [] currentChunkData;
  private long currentChunkStartOffset = 0L;
  private long streamPosition = 0L;
  private boolean endOfStream = false;

  public RewindableStreamBuffer(InputStream source, int chunkSize) {
    this.source = checkNotNull(source);
    checkArgument(chunkSize > 0, "chunkSize must be > 0");
    this.chunkSize = chunkSize;
  }

  /**
   * Reads up to {@code maxBytes} from the underlying stream starting at {@code targetOffset}. If
   * bytes for this offset are already in the buffer (e.g. during a retry attempt), returns the
   * uncommitted slice without reading anew from the source stream.
   *
   * @param targetOffset expected start offset of the chunk
   * @param maxBytes maximum bytes to return in this chunk
   * @return byte data for the chunk, or {@link ByteString#EMPTY} if EOF is reached
   * @throws IOException on I/O error reading from stream
   */
  public synchronized ByteString readChunk(long targetOffset, int maxBytes) throws IOException {
    if (currentChunkData != null
        && targetOffset >= currentChunkStartOffset
        && targetOffset < currentChunkStartOffset + currentChunkData.length) {
      int offsetInChunk = (int) (targetOffset - currentChunkStartOffset);
      int len = Math.min(maxBytes, currentChunkData.length - offsetInChunk);
      return ByteString.copyFrom(currentChunkData, offsetInChunk, len);
    }

    if (endOfStream) {
      return ByteString.EMPTY;
    }

    byte[] buffer = new byte[maxBytes];
    int totalRead = 0;
    while (totalRead < maxBytes) {
      int read = source.read(buffer, totalRead, maxBytes - totalRead);
      if (read == -1) {
        endOfStream = true;
        break;
      }
      totalRead += read;
    }

    if (totalRead == 0) {
      return ByteString.EMPTY;
    }

    streamPosition += totalRead;
    if (totalRead < maxBytes) {
      currentChunkData = Arrays.copyOf(buffer, totalRead);
    } else {
      currentChunkData = buffer;
    }
    currentChunkStartOffset = targetOffset;
    return ByteString.copyFrom(currentChunkData);
  }

  /** Returns true if the end of the underlying stream has been reached. */
  public synchronized boolean isEndOfStream() {
    return endOfStream;
  }

  /**
   * Seeks the buffer position to {@code committedOffset} as reported by {@code queryStatus}.
   *
   * @param committedOffset server's committed byte count
   * @throws IOException on I/O error skipping bytes in the source stream
   */
  public synchronized void seek(long committedOffset) throws IOException {
    if (committedOffset < currentChunkStartOffset) {
      throw new IllegalArgumentException(
          "Cannot seek backwards before current chunk start offset " + currentChunkStartOffset);
    }
    if (currentChunkData != null
        && committedOffset < currentChunkStartOffset + currentChunkData.length) {
      return;
    }
    currentChunkData = null;
    long bytesToSkip = committedOffset - streamPosition;
    if (bytesToSkip > 0) {
      ByteStreams.skipFully(source, bytesToSkip);
      streamPosition = committedOffset;
    }
    currentChunkStartOffset = committedOffset;
  }

  /**
   * Commits and discards buffered data up to {@code committedOffset}.
   *
   * @param committedOffset newly confirmed committed offset
   */
  public synchronized void commit(long committedOffset) {
    if (currentChunkData != null
        && committedOffset >= currentChunkStartOffset + currentChunkData.length) {
      currentChunkData = null;
      currentChunkStartOffset = committedOffset;
    }
  }

  @Override
  public synchronized void close() throws IOException {
    source.close();
  }
}
