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
import com.google.cloud.storage.StorageException;

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

  private final Storage gcsStorage;
  private final BlobId file;
  // max # of times we may reopen the file
  private final int maxChannelReopens;
  // how many times we re-opened the file
  private int reopens;
  private ReadChannel channel;
  private long position;
  private long size;

  /**
   * @param maxChannelReopens max number of times to try re-opening the channel if it closes on us unexpectedly.
   */
  @CheckReturnValue
  @SuppressWarnings("resource")
  static CloudStorageReadChannel create(Storage gcsStorage, BlobId file, long position, int maxChannelReopens)
      throws IOException {
    return new CloudStorageReadChannel(gcsStorage, file, position, maxChannelReopens);
  }

  private CloudStorageReadChannel(Storage gcsStorage, BlobId file, long position, int maxChannelReopens) throws IOException {
    this.gcsStorage = gcsStorage;
    this.file = file;
    this.position = position;
    this.reopens = 0;
    this.maxChannelReopens = maxChannelReopens;
    // XXX: Reading size and opening file should be atomic.
    this.size = fetchSize(gcsStorage, file);
    innerOpen();
  }

  private void innerOpen() throws IOException {
    this.channel = gcsStorage.reader(file);
    if (position > 0) {
      channel.seek((int) position);
    }
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
      int amt;
      int retries = 0;
      int maxRetries = 3;
      dst.mark();
      while (true) {
        try {
          dst.reset();
          amt = channel.read(dst);
          break;
        } catch (StorageException exs) {
          if (exs.getMessage().contains("Connection closed prematurely") && reopens < maxChannelReopens) {
            // this error isn't marked as retryable since the channel is closed;
            // but here at this higher level we can retry it.
            reopens++;
            sleepForAttempt(reopens);
            innerOpen();
            continue;
          } else if ((exs.getCode() == 500 || exs.getCode() == 503)  && retries < maxRetries) {
            retries++;
            sleepForAttempt(retries);
            continue;
          }
          throw exs;
        }
      }
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

  private void sleepForAttempt(int attempt) {
    try {
      Thread.sleep((attempt - 1) * 500);
    } catch (InterruptedException iex) {
      // reset interrupt flag
      Thread.currentThread().interrupt();
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
      throw new NoSuchFileException(String.format("gs://%s/%s", file.getBucket(), file.getName()));
    }
    return blobInfo.getSize();
  }
}
