/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.storage.contrib.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;

class CloudStorageWriteFileChannel extends FileChannel {
  private static final String WRITE_ONLY = "This FileChannel is write-only";
  private SeekableByteChannel writeChannel;
  private boolean valid = true;

  CloudStorageWriteFileChannel(SeekableByteChannel writeChannel) {
    this.writeChannel = writeChannel;
  }

  private void checkValid() throws IOException {
    if (!valid) {
      // These methods are only supported to be called once, because the underlying channel does not
      // support changing the position.
      throw new IOException(
          "This FileChannel is no longer valid. "
              + "A Cloud Storage FileChannel is invalidated after calling one of "
              + "the methods FileChannel#write(ByteBuffer, long) or "
              + "FileChannel#transferFrom(ReadableByteChannel, long, long)");
    }
    if (!writeChannel.isOpen()) {
      throw new IOException("This FileChannel is closed");
    }
  }

  @Override
  public int read(ByteBuffer dst) throws IOException {
    throw new UnsupportedOperationException(WRITE_ONLY);
  }

  @Override
  public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
    throw new UnsupportedOperationException(WRITE_ONLY);
  }

  @Override
  public synchronized int write(ByteBuffer src) throws IOException {
    checkValid();
    return writeChannel.write(src);
  }

  @Override
  public synchronized long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
    checkValid();
    long res = 0L;
    for (int i = offset; i < offset + length; i++) {
      res += writeChannel.write(srcs[i]);
    }
    return res;
  }

  @Override
  public synchronized long position() throws IOException {
    checkValid();
    return writeChannel.position();
  }

  @Override
  public synchronized FileChannel position(long newPosition) throws IOException {
    if (newPosition != position()) {
      writeChannel.position(newPosition);
    }
    return this;
  }

  @Override
  public synchronized long size() throws IOException {
    checkValid();
    return writeChannel.size();
  }

  @Override
  public synchronized FileChannel truncate(long size) throws IOException {
    checkValid();
    writeChannel.truncate(size);
    return this;
  }

  @Override
  public void force(boolean metaData) throws IOException {
    throw new UnsupportedOperationException();
  }

  @Override
  public long transferTo(long position, long count, WritableByteChannel target) throws IOException {
    throw new UnsupportedOperationException(WRITE_ONLY);
  }

  @Override
  public synchronized long transferFrom(ReadableByteChannel src, long position, long count)
      throws IOException {
    if (position != position()) {
      throw new UnsupportedOperationException(
          "This FileChannel only supports transferFrom at the current position");
    }
    int blockSize = (int) Math.min(count, 0xfffffL);
    long res = 0L;
    int bytesRead = 0;
    ByteBuffer buffer = ByteBuffer.allocate(blockSize);
    while (res < count && bytesRead >= 0) {
      buffer.position(0);
      bytesRead = src.read(buffer);
      if (bytesRead > 0) {
        buffer.position(0);
        buffer.limit(bytesRead);
        write(buffer);
        res += bytesRead;
      }
    }
    // The channel is no longer valid as the position has been updated, and there is no way of
    // resetting it, but this way we at least support the write-at-position and transferFrom
    // methods being called once.
    this.valid = false;
    return res;
  }

  @Override
  public int read(ByteBuffer dst, long position) throws IOException {
    throw new UnsupportedOperationException(WRITE_ONLY);
  }

  @Override
  public synchronized int write(ByteBuffer src, long position) throws IOException {
    if (position != position()) {
      throw new UnsupportedOperationException(
          "This FileChannel only supports write at the current position");
    }
    int res = writeChannel.write(src);
    // The channel is no longer valid as the position has been updated, and there is no way of
    // resetting it, but this way we at least support the write-at-position and transferFrom
    // methods being called once.
    this.valid = false;
    return res;
  }

  @Override
  public MappedByteBuffer map(MapMode mode, long position, long size) throws IOException {
    throw new UnsupportedOperationException();
  }

  @Override
  public FileLock lock(long position, long size, boolean shared) throws IOException {
    throw new UnsupportedOperationException();
  }

  @Override
  public FileLock tryLock(long position, long size, boolean shared) throws IOException {
    throw new UnsupportedOperationException();
  }

  @Override
  protected void implCloseChannel() throws IOException {
    writeChannel.close();
  }
}
