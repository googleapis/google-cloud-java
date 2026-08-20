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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.common.io.ByteStreams;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * A stream buffer that maintains a sliding single-chunk window over an {@link InputStream} for
 * resumable uploads, yielding self-describing {@link DataChunk} instances and supporting in-memory
 * rewinds and forward seeking.
 */
@BetaApi
@InternalApi
@NullMarked
class RewindableStreamBuffer implements AutoCloseable {

  private final Object lock = new Object();
  private final InputStream source;
  private final int chunkSize;

  // Retained in-memory byte chunk for transmission and intra-chunk rewind.
  @GuardedBy("lock")
  private byte @Nullable [] currentChunk;

  // Absolute byte offset in the stream where currentChunk begins.
  @GuardedBy("lock")
  private long chunkStartOffset = 0L;

  // Current read cursor indicating the start offset for nextChunk().
  @GuardedBy("lock")
  private long cursorOffset = 0L;

  // Indicates whether the end of the underlying stream has been reached.
  @GuardedBy("lock")
  private boolean endOfStream = false;

  RewindableStreamBuffer(InputStream source, int chunkSize) {
    this.source = checkNotNull(source, "source must not be null");
    checkArgument(chunkSize > 0, "chunkSize must be > 0");
    this.chunkSize = chunkSize;
  }

  // Computes the physical byte position read from the underlying stream.
  @GuardedBy("lock")
  private long streamPosition() {
    return chunkStartOffset + (currentChunk != null ? currentChunk.length : 0);
  }

  /**
   * Reads and returns the next {@link DataChunk} of up to {@code chunkSize} bytes.
   *
   * @return data chunk for transmission
   * @throws IOException on error reading from the stream
   */
  DataChunk nextChunk() throws IOException {
    synchronized (lock) {
      // 1. If cursorOffset is within the retained currentChunk (e.g. retry after partial failure)
      if (currentChunk != null && cursorOffset < chunkStartOffset + currentChunk.length) {
        int offsetInChunk = (int) (cursorOffset - chunkStartOffset);
        int length = Math.min(chunkSize, currentChunk.length - offsetInChunk);
        byte[] payload =
            (offsetInChunk == 0 && length == currentChunk.length)
                ? currentChunk
                : Arrays.copyOfRange(currentChunk, offsetInChunk, offsetInChunk + length);
        boolean isFinal = endOfStream && (offsetInChunk + length == currentChunk.length);
        long chunkOffset = cursorOffset;
        cursorOffset += length;
        return DataChunk.create(payload, chunkOffset, isFinal);
      }

      // 2. If already at EOF and no uncommitted bytes remain
      if (endOfStream) {
        return DataChunk.create(new byte[0], cursorOffset, true);
      }

      // 3. Read up to chunkSize from the underlying stream
      byte[] buffer = new byte[chunkSize];
      int totalRead = 0;

      while (totalRead < chunkSize) {
        int read = source.read(buffer, totalRead, chunkSize - totalRead);
        if (read == -1) {
          endOfStream = true;
          break;
        }
        totalRead += read;
      }

      if (totalRead == 0 && endOfStream) {
        return DataChunk.create(new byte[0], cursorOffset, true);
      }

      byte[] payload = totalRead == chunkSize ? buffer : Arrays.copyOf(buffer, totalRead);
      currentChunk = payload;
      chunkStartOffset = cursorOffset;
      cursorOffset += totalRead;

      boolean isFinal = endOfStream;
      return DataChunk.create(payload, chunkStartOffset, isFinal);
    }
  }

  /**
   * Confirms that the server has received bytes up to {@code serverCommittedOffset}.
   *
   * <p>Discards any buffered data prior to {@code serverCommittedOffset}.
   *
   * @param serverCommittedOffset newly confirmed committed offset
   */
  void acknowledge(long serverCommittedOffset) {
    synchronized (lock) {
      if (currentChunk != null && serverCommittedOffset >= chunkStartOffset + currentChunk.length) {
        currentChunk = null;
        chunkStartOffset = serverCommittedOffset;
        if (cursorOffset < serverCommittedOffset) {
          cursorOffset = serverCommittedOffset;
        }
      }
    }
  }

  /**
   * Re-aligns the buffer cursor to {@code serverCommittedOffset} following recovery or session
   * resumption.
   *
   * <ul>
   *   <li>If {@code serverCommittedOffset} is within the retained chunk, rewinds within memory.
   *   <li>If {@code serverCommittedOffset} is ahead, discards buffer and skips forward in the
   *       stream.
   *   <li>If {@code serverCommittedOffset} is before the retained chunk, throws {@link
   *       IOException}.
   * </ul>
   *
   * @param serverCommittedOffset server's committed byte offset
   * @throws IOException if the server offset rolled back before confirmed bytes
   */
  void seekTo(long serverCommittedOffset) throws IOException {
    checkArgument(serverCommittedOffset >= 0, "serverCommittedOffset must not be negative");
    synchronized (lock) {
      // 1. Intra-chunk rewind: cursor moves within existing in-memory chunk
      if (currentChunk != null
          && serverCommittedOffset >= chunkStartOffset
          && serverCommittedOffset <= chunkStartOffset + currentChunk.length) {
        cursorOffset = serverCommittedOffset;
        return;
      }

      // 2. Forward seek (e.g. session resumption): discard buffer and skip underlying stream
      long physicalPosition = streamPosition();
      if (serverCommittedOffset >= physicalPosition) {
        currentChunk = null;
        long bytesToSkip = serverCommittedOffset - physicalPosition;
        if (bytesToSkip > 0) {
          ByteStreams.skipFully(source, bytesToSkip);
        }
        chunkStartOffset = serverCommittedOffset;
        cursorOffset = serverCommittedOffset;
        return;
      }

      // 3. Backward seek outside retained buffer: unrecoverable protocol error
      throw new IOException(
          String.format(
              "Cannot rewind stream to offset %d (retained buffer start: %d). "
                  + "Server committed offset rolled back before confirmed bytes.",
              serverCommittedOffset, chunkStartOffset));
    }
  }

  /** Returns true if the end of the underlying stream has been reached. */
  boolean isEndOfStream() {
    synchronized (lock) {
      return endOfStream
          && (currentChunk == null || cursorOffset >= chunkStartOffset + currentChunk.length);
    }
  }

  @Override
  public void close() throws IOException {
    synchronized (lock) {
      currentChunk = null;
      source.close();
    }
  }
}
