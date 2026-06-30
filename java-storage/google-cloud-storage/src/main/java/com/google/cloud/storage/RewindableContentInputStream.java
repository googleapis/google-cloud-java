/*
 * Copyright 2023 Google LLC
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

import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;

/**
 * Facade which makes an instance of {@link RewindableContent} appear as an input stream.
 *
 * <p>It does this by calling {@link RewindableContent#writeTo(GatheringByteChannel)} on an
 * anonymous channel which closes over the read destination.
 */
final class RewindableContentInputStream extends InputStream {

  private final RewindableContent content;

  RewindableContentInputStream(RewindableContent content) {
    this.content = content;
  }

  @Override
  public int read() throws IOException {
    byte[] tmp = new byte[1];
    int read = read(tmp);
    if (read == -1) {
      return -1;
    } else {
      return tmp[0] & 0xFF;
    }
  }

  @Override
  public int read(byte[] b, int off, int len) throws IOException {
    // define a byte buffer as the destination for our write
    ByteBuffer dst = ByteBuffer.wrap(b, off, len);
    int remaining = dst.remaining();
    if (remaining == 0) {
      return 0;
    }
    long written =
        content.writeTo(
            new AnonWritableByteChannel() {
              @Override
              public long write(ByteBuffer[] srcs, int offset, int length) {
                // srcs here is the bytes of content
                long total = 0;
                for (int i = offset; i < length; i++) {
                  ByteBuffer src = srcs[i];
                  // copy what we can from our src to the dst buffer
                  long written = Buffers.copy(src, dst);
                  total += written;
                }
                return total;
              }
            });
    // if the dst has space, but we didn't write anything means we didn't have anything to write
    if (written == 0) {
      return -1;
    }
    return Math.toIntExact(written);
  }

  private abstract static class AnonWritableByteChannel implements UnbufferedWritableByteChannel {

    @Override
    public boolean isOpen() {
      return true;
    }

    @Override
    public void close() {}
  }
}
