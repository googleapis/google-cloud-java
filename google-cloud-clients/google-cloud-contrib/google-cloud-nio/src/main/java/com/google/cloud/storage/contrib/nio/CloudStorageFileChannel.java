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
import com.google.common.base.Preconditions;

class CloudStorageFileChannel extends FileChannel {
  private long position = 0L;
  private final SeekableByteChannel writeChannel;

  CloudStorageFileChannel(SeekableByteChannel writeChannel) {
    this.writeChannel = writeChannel;
  }

  @Override
  public int read(ByteBuffer dst) throws IOException {
    int res = writeChannel.read(dst);
    position += res;
    return res;
  }

  @Override
  public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
    long res = 0L;
    for (int i = offset; i < offset + length; i++) {
      res += writeChannel.read(dsts[i]);
    }
    position += res;
    return res;
  }

  @Override
  public int write(ByteBuffer src) throws IOException {
    int res = writeChannel.write(src);
    position += res;
    return res;
  }

  @Override
  public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
    long res = 0L;
    for (int i = offset; i < offset + length; i++) {
      res += writeChannel.write(srcs[i]);
    }
    position += res;
    return res;
  }

  @Override
  public long position() throws IOException {
    return position;
  }

  @Override
  public FileChannel position(long newPosition) throws IOException {
    this.position = newPosition;
    writeChannel.position(newPosition);
    return this;
  }

  @Override
  public long size() throws IOException {
    return writeChannel.size();
  }

  @Override
  public FileChannel truncate(long size) throws IOException {
    writeChannel.truncate(size);
    return this;
  }

  @Override
  public void force(boolean metaData) throws IOException {
    throw new UnsupportedOperationException();
  }

  @Override
  public long transferTo(long position, long count, WritableByteChannel target) throws IOException {
    Preconditions.checkArgument(count <= Integer.MAX_VALUE,
        "Transfering more than Integer.MAX_VALUE bytes is not supported");
    ByteBuffer buffer = ByteBuffer.allocate((int) count);
    long res = read(buffer, position);
    buffer.position(0);
    target.write(buffer);
    return res;
  }

  @Override
  public long transferFrom(ReadableByteChannel src, long position, long count) throws IOException {
    Preconditions.checkArgument(count <= Integer.MAX_VALUE,
        "Transfering more than Integer.MAX_VALUE bytes is not supported");
    ByteBuffer buffer = ByteBuffer.allocate((int) count);
    long res = src.read(buffer);
    write(buffer);
    return res;
  }

  @Override
  public int read(ByteBuffer dst, long position) throws IOException {
    long originalPosition = position();
    position(position);
    int res = writeChannel.read(dst);
    position(originalPosition);
    return res;
  }

  @Override
  public int write(ByteBuffer src, long position) throws IOException {
    long originalPosition = position();
    position(position);
    int res = writeChannel.write(src);
    position(originalPosition);
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
