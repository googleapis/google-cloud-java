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

import com.google.cloud.WriteChannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonReadableChannelException;
import java.nio.channels.SeekableByteChannel;

import javax.annotation.concurrent.ThreadSafe;

/**
 * Cloud Storage write channel.
 *
 * <p>This class does not support seeking, reading, or append.
 *
 * @see CloudStorageReadChannel
 */
@ThreadSafe
final class CloudStorageWriteChannel implements SeekableByteChannel {

  private final WriteChannel channel;
  private long position;
  private long size;

  CloudStorageWriteChannel(WriteChannel channel) {
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
    throw new NonReadableChannelException();
  }

  @Override
  public int write(ByteBuffer src) throws IOException {
    synchronized (this) {
      checkOpen();
      int amt = channel.write(src);
      if (amt > 0) {
        position += amt;
        size += amt;
      }
      return amt;
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
    throw new UnsupportedOperationException();
  }

  @Override
  public long size() throws IOException {
    synchronized (this) {
      checkOpen();
      return size;
    }
  }

  @Override
  public SeekableByteChannel truncate(long newSize) throws IOException {
    // TODO: Emulate this functionality by closing and rewriting old file up to newSize.
    //       Or maybe just swap out GcsStorage for the API client.
    throw new UnsupportedOperationException();
  }

  private void checkOpen() throws ClosedChannelException {
    if (!channel.isOpen()) {
      throw new ClosedChannelException();
    }
  }
}
