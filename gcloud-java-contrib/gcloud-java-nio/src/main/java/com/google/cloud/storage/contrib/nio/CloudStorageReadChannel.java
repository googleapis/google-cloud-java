/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.NoSuchFileException;

import javax.annotation.CheckReturnValue;
import javax.annotation.concurrent.ThreadSafe;

/**
 * Cloud Storage read channel.
 *
 * @see CloudStorageWriteChannel
 */
@ThreadSafe
final class CloudStorageReadChannel implements SeekableByteChannel {

  private final ReadChannel channel;
  private long position;
  private long size;

  @CheckReturnValue
  @SuppressWarnings("resource")
  static CloudStorageReadChannel create(Storage gcsStorage, BlobId file, long position)
      throws IOException {
    // XXX: Reading size and opening file should be atomic.
    long size = fetchSize(gcsStorage, file);
    ReadChannel channel = gcsStorage.reader(file);
    if (position > 0) {
      channel.seek((int) position);
    }
    return new CloudStorageReadChannel(position, size, channel);
  }

  private CloudStorageReadChannel(long position, long size, ReadChannel channel) {
    this.position = position;
    this.size = size;
    this.channel = channel;
  }

  @Override
  public boolean isOpen() {
    synchronized (this) {
      return channel.isOpen();
    }
  }

  @Override
  public void close() throws IOException {
    synchronized (this) {
      channel.close();
    }
  }

  @Override
  public int read(ByteBuffer dst) throws IOException {
    synchronized (this) {
      checkOpen();
      int amt = channel.read(dst);
      if (amt > 0) {
        position += amt;
        // XXX: This would only ever happen if the fetchSize() race-condition occurred.
        if (position > size) {
          size = position;
        }
      }
      return amt;
    }
  }

  @Override
  public long size() throws IOException {
    synchronized (this) {
      checkOpen();
      return size;
    }
  }

  @Override
  public long position() throws IOException {
    synchronized (this) {
      checkOpen();
      return position;
    }
  }

  @Override
  public SeekableByteChannel position(long newPosition) throws IOException {
    checkArgument(newPosition >= 0);
    synchronized (this) {
      checkOpen();
      if (newPosition == position) {
        return this;
      }
      channel.seek(newPosition);
      position = newPosition;
      return this;
    }
  }

  @Override
  public int write(ByteBuffer src) throws IOException {
    throw new NonWritableChannelException();
  }

  @Override
  public SeekableByteChannel truncate(long size) throws IOException {
    throw new NonWritableChannelException();
  }

  private void checkOpen() throws ClosedChannelException {
    if (!channel.isOpen()) {
      throw new ClosedChannelException();
    }
  }

  private static long fetchSize(Storage gcsStorage, BlobId file) throws IOException {
    BlobInfo blobInfo = gcsStorage.get(file);
    if (blobInfo == null) {
      throw new NoSuchFileException(String.format("gs://%s/%s", file.bucket(), file.name()));
    }
    return blobInfo.size();
  }
}
