/*
 * Copyright 2025 Google LLC
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

import com.google.cloud.BaseServiceException;
import com.google.cloud.storage.ChunkSegmenter.ChunkSegment;
import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class BidiAppendableUnbufferedWritableByteChannel implements UnbufferedWritableByteChannel {

  private final BidiUploadStreamingStream stream;
  private final ChunkSegmenter chunkSegmenter;
  private final long flushInterval;

  private boolean open;
  private long writeOffset;
  private volatile boolean nextWriteShouldFinalize;
  private boolean writeCalledAtLeastOnce;
  private long lastFlushOffset;

  /** If write throws an error, don't attempt to finalize things when {@link #close()} is called. */
  private boolean writeThrewError;

  BidiAppendableUnbufferedWritableByteChannel(
      BidiUploadStreamingStream stream,
      ChunkSegmenter chunkSegmenter,
      long flushInterval,
      long writeOffset) {
    this.stream = stream;
    this.chunkSegmenter = chunkSegmenter;
    this.flushInterval = flushInterval;
    this.open = true;
    this.writeOffset = writeOffset;
    this.nextWriteShouldFinalize = false;
    this.writeThrewError = false;
    this.lastFlushOffset = writeOffset;
  }

  @Override
  public long write(ByteBuffer[] srcs, int srcsOffset, int srcsLength) throws IOException {
    return internalWrite(srcs, srcsOffset, srcsLength);
  }

  @Override
  public long writeAndClose(ByteBuffer[] srcs, int offset, int length) throws IOException {
    long totalRemaining = Buffers.totalRemaining(srcs, offset, length);
    // internalWrite is non-blocking, but close is blocking.
    // loop here to ensure all the bytes we need flush are enqueued before we transition to trying
    // to close.
    long written = 0;
    do {
      written += internalWrite(srcs, offset, length);
    } while (written < totalRemaining);
    close();
    return written;
  }

  @Override
  public boolean isOpen() {
    return open;
  }

  @Override
  public void close() throws IOException {
    if (!open) {
      return;
    }
    try {
      if (writeThrewError) {
        return;
      }

      if (!writeCalledAtLeastOnce) {
        stream.flush();
      }
      if (nextWriteShouldFinalize) {
        //noinspection StatementWithEmptyBody
        while (!stream.finishWrite(writeOffset)) {}
      } else {
        //noinspection StatementWithEmptyBody
        while (!stream.closeStream(writeOffset)) {}
      }

      awaitResultFuture();
    } finally {
      stream.sendClose();
      open = false;
    }
  }

  public void nextWriteShouldFinalize() {
    this.nextWriteShouldFinalize = true;
  }

  void flush() throws InterruptedException {
    stream.flush();
    stream.awaitAckOf(writeOffset);
  }

  private long internalWrite(ByteBuffer[] srcs, int srcsOffset, int srcsLength) throws IOException {
    if (!open) {
      throw new ClosedChannelException();
    }
    // error early. if the result future is already failed, await it to throw the error
    if (stream.getResultFuture().isDone()) {
      awaitResultFuture();
      return 0;
    }
    writeCalledAtLeastOnce = true;

    long availableCapacity = stream.availableCapacity();
    if (availableCapacity <= 0) {
      return 0;
    }
    RewindableContent rewindableContent = RewindableContent.of(srcs, srcsOffset, srcsLength);
    long totalBufferRemaining = rewindableContent.getLength();

    ChunkSegment[] data =
        chunkSegmenter.segmentBuffers(srcs, srcsOffset, srcsLength, true, availableCapacity);
    if (data.length == 0) {
      return 0;
    }
    // we consumed some bytes from srcs, flag our content as dirty since we aren't writing
    // those bytes to implicitly flag as dirty.
    rewindableContent.flagDirty();

    long remainingAfterPacking = Buffers.totalRemaining(srcs, srcsOffset, srcsLength);
    long bytesConsumed = 0;
    for (int i = 0, len = data.length, lastIdx = len - 1; i < len; i++) {
      ChunkSegment datum = data[i];
      int size = datum.getB().size();
      boolean shouldFlush = writeOffset + size >= lastFlushOffset + flushInterval;
      boolean appended;
      if (i < lastIdx && !shouldFlush) {
        appended = stream.append(datum);
      } else if (i == lastIdx && remainingAfterPacking == 0 && nextWriteShouldFinalize) {
        appended = stream.appendAndFinalize(datum);
      } else {
        appended = stream.appendAndFlush(datum);
      }
      if (appended) {
        bytesConsumed += size;
        writeOffset += size;
        if (shouldFlush) {
          lastFlushOffset = writeOffset;
        }
      } else {
        // if we weren't able to trigger a flush by reaching the end of the array and calling
        // appendAndFlush, explicitly call flush here so that some progress can be made.
        // we prefer appendAndFlush so a separate message is not needed, but an extra message
        // in order to make progress and free buffer space is better than ending up in a live-lock.
        stream.flush();
        break;
      }
    }

    if (bytesConsumed != totalBufferRemaining) {
      rewindableContent.rewindTo(bytesConsumed);
    }

    return bytesConsumed;
  }

  private void awaitResultFuture() throws IOException {
    try {
      stream.awaitAckOf(writeOffset);
      stream.getResultFuture().get(10_717, TimeUnit.MILLISECONDS);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      InterruptedIOException ioe = new InterruptedIOException();
      ioe.initCause(e);
      writeThrewError = true;
      throw ioe;
    } catch (ExecutionException e) {
      BaseServiceException coalesce = StorageException.coalesce(e.getCause());
      String message = coalesce.getMessage();
      String ioExceptionMessage = message;
      // if the failure is an upload scenario we detect client side, it's message will be
      // verbose. To avoid duplication, select the first line only for the io exception
      int firstNewLineIndex = message != null ? message.indexOf('\n') : -1;
      if (firstNewLineIndex > -1) {
        ioExceptionMessage = message.substring(0, firstNewLineIndex);
      }
      IOException ioException = new IOException(ioExceptionMessage, coalesce);
      // ioException.addSuppressed(new AsyncStorageTaskException());
      writeThrewError = true;
      throw ioException;
    } catch (TimeoutException e) {
      writeThrewError = true;
      throw new IOException(e);
    }
  }
}
