/*
 * Copyright 2022 Google LLC
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

import static com.google.common.base.Preconditions.checkState;

import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;

/**
 * Buffering {@link java.nio.channels.WritableByteChannel} which attempts to maximize the amount of
 * bytes written to the underlying {@link UnbufferedWritableByteChannel} while minimizing
 * unnecessary copying of said bytes.
 *
 * <p>Our flushing strategy is "eager", meaning as soon as we have enough total bytes equal to the
 * capacity of our buffer we will write to the underlying channel.
 *
 * <p>A few strategies are employed to meet the state goals.
 *
 * <ol>
 *   <li>If we do not have any bytes in our buffer and {@code src} is the same size as our buffer,
 *       simply {@link UnbufferedWritableByteChannel#write(ByteBuffer) write(src)} to the the
 *       underlying channel
 *   <li>If we do not have any bytes in our buffer and {@code src} is larger than the size of our
 *       buffer, take a slice of {@code src} the same size as our buffer and {@link
 *       UnbufferedWritableByteChannel#write(ByteBuffer[]) write(slice)} before enqueuing any
 *       outstanding bytes which are smaller than our buffer.
 *   <li>If we do not have any bytes in our buffer and {@code src} is smaller than the size of our
 *       buffer, enqueue it in full
 *   <li>If we do have enqueued bytes and {@code src} is the size of our remaining buffer space
 *       {@link UnbufferedWritableByteChannel#write(ByteBuffer[]) write([buffer, src])} to the
 *       underlying channel
 *   <li>If we do have enqueued bytes and {@code src} is larger than the size of our remaining
 *       buffer space, take a slice of {@code src} the same size as the remaining space in our
 *       buffer and {@link UnbufferedWritableByteChannel#write(ByteBuffer[]) write([buffer, slice])}
 *       to the underlying channel before enqueuing any outstanding bytes which are smaller than our
 *       buffer.
 *   <li>If we do have enqueued bytes and {@code src} is smaller than our remaining buffer space,
 *       enqueue it in full
 * </ol>
 */
final class DefaultBufferedWritableByteChannel implements BufferedWritableByteChannel {

  private final BufferHandle handle;

  private final UnbufferedWritableByteChannel channel;
  private final boolean blocking;

  DefaultBufferedWritableByteChannel(BufferHandle handle, UnbufferedWritableByteChannel channel) {
    this(handle, channel, true);
  }

  DefaultBufferedWritableByteChannel(
      BufferHandle handle, UnbufferedWritableByteChannel channel, boolean blocking) {
    this.handle = handle;
    this.channel = channel;
    this.blocking = blocking;
  }

  @SuppressWarnings("UnnecessaryLocalVariable")
  @Override
  public int write(ByteBuffer src) throws IOException {
    if (!channel.isOpen()) {
      throw new ClosedChannelException();
    }
    int bytesConsumed = 0;

    while (src.hasRemaining()) {
      int srcRemaining = src.remaining();
      int srcPosition = src.position();

      int capacity = handle.capacity();
      int bufferRemaining = handle.remaining();
      int bufferPending = capacity - bufferRemaining;

      boolean enqueuedBytes = enqueuedBytes();
      if (srcRemaining < bufferRemaining) {
        // srcRemaining is smaller than the remaining space in our buffer, enqueue it in full
        handle.get().put(src);
        bytesConsumed += srcRemaining;
        break;
      } else if (enqueuedBytes) {
        // between bufferPending and srcRemaining we have a full buffers worth of data
        // Figure out what we need to do before flushing it

        ByteBuffer buf;
        int sliceLimit = bufferRemaining; // alias for easier readability below
        boolean usingSlice = false;
        if (srcRemaining == bufferRemaining) {
          // our buffer and all of src are equal to a full buffer, no need to slice src
          buf = src;
        } else {
          // our buffer and all of src are larger than a full buffer, take a slice of src such that
          // the total number of bytes are equal to capacity
          ByteBuffer slice = src.slice();
          Buffers.limit(slice, sliceLimit);
          usingSlice = true;
          buf = slice;
        }

        ByteBuffer buffer = handle.get();
        Buffers.flip(buffer);
        ByteBuffer[] srcs = {buffer, buf};
        long write = channel.write(srcs);
        checkState(write >= 0, "write >= 0 (%s > 0)", write);
        if (write == capacity) {
          // we successfully wrote all the bytes we wanted to
          Buffers.clear(buffer);
          if (usingSlice) {
            Buffers.position(src, srcPosition + sliceLimit);
          }
          bytesConsumed += sliceLimit;
        } else {
          if (buffer.hasRemaining()) {
            // we didn't write enough bytes to consume the whole buffer. Do not advance the
            // position of src
            buffer.compact();
          } else {
            // we wrote enough to consume the buffer
            Buffers.clear(buffer);
            // we didn't write enough to consume the whole slice, determine how much of the slice
            // was written and advance the position of src
            int sliceWritten = Math.toIntExact(write - bufferPending);
            Buffers.position(src, srcPosition + sliceWritten);
            bytesConsumed += sliceWritten;
          }

          if (!blocking) {
            break;
          }
        }
      } else {
        // no enqueued data and src is at least as large as our buffer, see if we can simply write
        // the provided src or a slice of it since our buffer is empty
        if (bufferRemaining == srcRemaining) {
          // the capacity of buffer and the bytes remaining in src are the same, directly
          // write src
          int write = channel.write(src);
          checkState(write >= 0, "write >= 0 (%s > 0)", write);
          bytesConsumed += write;
          if (write < srcRemaining && !blocking) {
            break;
          }
        } else {
          // the src provided is larger than our buffer. rather than copying into the buffer, simply
          // write a slice
          ByteBuffer slice = src.slice();
          Buffers.limit(slice, bufferRemaining);
          int write = channel.write(slice);
          checkState(write >= 0, "write >= 0 (%s > 0)", write);
          int newPosition = srcPosition + write;
          Buffers.position(src, newPosition);
          bytesConsumed += write;
          if (write < bufferRemaining && !blocking) {
            break;
          }
        }
      }
    }
    return bytesConsumed;
  }

  @Override
  public boolean isOpen() {
    return channel.isOpen();
  }

  @Override
  public void close() throws IOException {
    if (enqueuedBytes()) {
      ByteBuffer buffer = handle.get();
      Buffers.flip(buffer);
      channel.writeAndClose(buffer);
      if (buffer.hasRemaining()) {
        buffer.compact();
      } else {
        Buffers.clear(buffer);
      }
    } else {
      channel.close();
    }
  }

  @Override
  public void flush() throws IOException {
    while (enqueuedBytes()) {
      ByteBuffer buffer = handle.get();
      Buffers.flip(buffer);
      channel.write(buffer);
      if (buffer.hasRemaining()) {
        buffer.compact();
      } else {
        Buffers.clear(buffer);
      }
    }
  }

  private boolean enqueuedBytes() {
    return handle.position() > 0;
  }
}
