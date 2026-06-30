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

import com.google.cloud.storage.BufferedReadableByteChannelSession.BufferedReadableByteChannel;
import com.google.cloud.storage.UnbufferedReadableByteChannelSession.UnbufferedReadableByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;

final class DefaultBufferedReadableByteChannel implements BufferedReadableByteChannel {

  private final BufferHandle handle;

  private final UnbufferedReadableByteChannel channel;

  private boolean flipped = false;
  private boolean retEOF = false;

  DefaultBufferedReadableByteChannel(BufferHandle handle, UnbufferedReadableByteChannel channel) {
    this.handle = handle;
    this.channel = channel;
  }

  @Override
  public int read(ByteBuffer dst) throws IOException {
    if (retEOF) {
      retEOF = false;
      return -1;
    } else if (!enqueuedBytes() && !channel.isOpen()) {
      throw new ClosedChannelException();
    }

    int bytesConsumed = 0;

    while (dst.hasRemaining()) {
      int bufferRemaining = handle.remaining();

      int dstRemaining = dst.remaining();
      int dstPosition = dst.position();

      final int tmpBytesCopied;
      if (enqueuedBytes()) {
        ByteBuffer buffer = handle.get();
        if (!flipped) {
          buffer.flip();
          flipped = true;
        }
        long copy = Buffers.copy(buffer, new ByteBuffer[] {dst});
        if (buffer.remaining() == 0) {
          Buffers.clear(buffer);
        }
        tmpBytesCopied = Math.toIntExact(copy);
      } else {
        if (bufferRemaining <= dstRemaining) {
          ByteBuffer buf;
          if (bufferRemaining == dstRemaining) {
            // the available space in dst is the same as our buffer rather than reading into buffer
            // before copying to dst, simply read directly into dst
            buf = dst;
          } else {
            // the available space in dst is larger than our buffer rather than reading into buffer
            // before copying to dst, simply read a buffer size worth of bytes directly into dst
            buf = dst.slice();
            Buffers.limit(buf, bufferRemaining);
          }
          int read = channel.read(buf);
          if (read == -1) {
            if (bytesConsumed == 0) {
              close();
              return -1;
            } else {
              retEOF = true;
              close();
              break;
            }
          }
          Buffers.position(dst, dstPosition + read);
          tmpBytesCopied = read;
        } else {

          // the amount of space remaining in dst is smaller than our buffer,
          // create a slice of our buffer such that
          // dst.remaning() + bufSlice.remaning() == buffer.capacity

          ByteBuffer buffer = handle.get();
          ByteBuffer slice = buffer.slice();
          int sliceCapacity = buffer.capacity() - dstRemaining;
          Buffers.limit(slice, sliceCapacity);

          ByteBuffer[] dsts = {dst, slice};
          long read = channel.read(dsts);
          if (read == -1) {
            if (bytesConsumed == 0) {
              close();
              return -1;
            } else {
              retEOF = true;
              close();
              break;
            }
          } else if (read < dstRemaining) {
            // we didn't read enough bytes to fill up dst, no need to advance buffer position
            tmpBytesCopied = Math.toIntExact(read);
          } else {
            // we read some bytes into slice
            // determine the position buffer needs to be set to
            long bytesReadIntoBuffer = read - dstRemaining;
            Buffers.position(buffer, Math.toIntExact(bytesReadIntoBuffer));
            flipped = false;
            tmpBytesCopied = dstRemaining;
          }
        }
      }
      bytesConsumed += tmpBytesCopied;
    }
    return bytesConsumed;
  }

  @Override
  public boolean isOpen() {
    return enqueuedBytes() || (!retEOF && channel.isOpen());
  }

  @Override
  public void close() throws IOException {
    channel.close();
  }

  private boolean enqueuedBytes() {
    return handle.position() > 0;
  }
}
