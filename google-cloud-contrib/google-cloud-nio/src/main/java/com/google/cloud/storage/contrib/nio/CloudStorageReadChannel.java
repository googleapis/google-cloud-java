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

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.common.annotations.VisibleForTesting;

import javax.annotation.CheckReturnValue;
import javax.annotation.concurrent.ThreadSafe;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.NoSuchFileException;

import javax.net.ssl.SSLException;
import java.io.EOFException;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import static com.google.common.base.Preconditions.checkArgument;

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
  @VisibleForTesting
  final int maxChannelReopens;
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
      int maxRetries = Math.max(3, maxChannelReopens);
      dst.mark();
      while (true) {
        try {
          dst.reset();
          amt = channel.read(dst);
          break;
        } catch (StorageException exs) {
          if (isReopenable(exs)) {
            // these errors aren't marked as retryable since the channel is closed;
            // but here at this higher level we can retry them.
            reopens++;
            if (reopens > maxChannelReopens) {
              throw new StorageException(exs.getCode(), "All reopens failed", exs);
            }
            sleepForAttempt(reopens);
            innerOpen();
            continue;
          } else if (exs.isRetryable() || exs.getCode() == 500 || exs.getCode() == 503) {
            retries++;
            if (retries > maxRetries) {
              // this exception will be marked as retriable in most cases since
              // it's based on the code. It may be confusing to see a retriable error
              // that says "all retries failed" but understand this to mean:
              // "While in principle you should be able to retry, we already did that
              // for you a few times and it still didn't work so we wouldn't recommend
              // further retries."
              throw new StorageException(exs.getCode(), "All retries failed", exs);
            }
            sleepForAttempt(retries);
            continue;
          }
          // exception is neither reopenable nor retryable
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

  private static boolean isReopenable(Throwable exs) {
    Throwable throwable = exs;
    // ensures finite iteration
    int maxDepth = 10;
    while (throwable != null && maxDepth-- > 0) {
      if ((throwable.getMessage() != null
          && throwable.getMessage().contains("Connection closed prematurely"))
          || throwable instanceof SSLException
          || throwable instanceof EOFException
          || throwable instanceof SocketException
          || throwable instanceof SocketTimeoutException) {
        return true;
      }
      throwable = throwable.getCause();
    }
    return false;
  }

  private void sleepForAttempt(int attempt) {
    // exponential backoff, but let's bound it around 2min.
    // aggressive backoff because we're dealing with unusual cases.
    long delay = 1000L * (1L << Math.min(attempt, 7));
    try {
      Thread.sleep(delay);
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
