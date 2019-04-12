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

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;

class CloudStorageReadFileChannel extends FileChannel {
  private static final String READ_ONLY = "This FileChannel is read-only";
  private final SeekableByteChannel readChannel;

  CloudStorageReadFileChannel(SeekableByteChannel readChannel) {
    Preconditions.checkNotNull(readChannel);
    this.readChannel = readChannel;
  }

  @Override
  public int read(ByteBuffer dst) throws IOException {
    return readChannel.read(dst);
  }

  @Override
  public synchronized long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
    long res = 0L;
    for (int i = offset; i < offset + length; i++) {
      res += readChannel.read(dsts[i]);
    }
    return res;
  }

  @Override
  public int write(ByteBuffer src) throws IOException {
    throw new UnsupportedOperationException(READ_ONLY);
  }

  @Override
  public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
    throw new UnsupportedOperationException(READ_ONLY);
  }

  @Override
  public long position() throws IOException {
    return readChannel.position();
  }

  @Override
  public FileChannel position(long newPosition) throws IOException {
    readChannel.position(newPosition);
    return this;
  }

  @Override
  public long size() throws IOException {
    return readChannel.size();
  }

  @Override
  public FileChannel truncate(long size) throws IOException {
    throw new UnsupportedOperationException(READ_ONLY);
  }

  @Override
  public void force(boolean metaData) throws IOException {
    throw new UnsupportedOperationException();
  }

  @Override
  public synchronized long transferTo(
      long transferFromPosition, long count, WritableByteChannel target) throws IOException {
    long res = 0L;
    long originalPosition = position();
    try {
      position(transferFromPosition);
      int blockSize = (int) Math.min(count, 0xfffffL);
      int bytesRead = 0;
      ByteBuffer buffer = ByteBuffer.allocate(blockSize);
      while (res < count && bytesRead >= 0) {
        buffer.position(0);
        bytesRead = read(buffer);
        if (bytesRead > 0) {
          buffer.position(0);
          buffer.limit(bytesRead);
          target.write(buffer);
          res += bytesRead;
        }
      }
      return res;
    } finally {
      position(originalPosition);
    }
  }

  @Override
  public long transferFrom(ReadableByteChannel src, long position, long count) throws IOException {
    throw new UnsupportedOperationException(READ_ONLY);
  }

  @Override
  public synchronized int read(ByteBuffer dst, long readFromPosition) throws IOException {
    long originalPosition = position();
    try {
      position(readFromPosition);
      int res = readChannel.read(dst);
      return res;
    } finally {
      position(originalPosition);
    }
  }

  @Override
  public int write(ByteBuffer src, long position) throws IOException {
    throw new UnsupportedOperationException(READ_ONLY);
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
    readChannel.close();
  }
}
