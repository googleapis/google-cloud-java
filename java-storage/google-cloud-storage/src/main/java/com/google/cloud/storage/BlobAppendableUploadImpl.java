/*
 * Copyright 2025 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;

@BetaApi
final class BlobAppendableUploadImpl implements BlobAppendableUpload {
  private final WritableByteChannelSession<AppendableObjectBufferedWritableByteChannel, BlobInfo>
      delegate;
  private boolean open;

  BlobAppendableUploadImpl(
      WritableByteChannelSession<AppendableObjectBufferedWritableByteChannel, BlobInfo> delegate) {
    this.delegate = delegate;
    this.open = false;
  }

  @Override
  public AppendableUploadWriteableByteChannel open() throws IOException {
    synchronized (this) {
      Preconditions.checkState(!open, "already open");
      open = true;
      return delegate.open();
    }
  }

  @Override
  public ApiFuture<BlobInfo> getResult() {
    return delegate.getResult();
  }

  /**
   * This class extends BufferedWritableByteChannel to handle a special case for Appendable writes,
   * namely closing the stream without finalizing the write. It adds the {@code finalizeWrite}
   * method, which must be manually called to finalize the write. This couldn't be accomplished with
   * the base BufferedWritableByteChannel class because it only has a close() method, which it
   * assumes should finalize the write before the close. It also re-implements
   * SynchronizedBufferedWritableByteChannel to avoid needing to make a decorator class for it and
   * wrap it over this one.
   */
  static final class AppendableObjectBufferedWritableByteChannel
      implements BufferedWritableByteChannel,
          BlobAppendableUpload.AppendableUploadWriteableByteChannel {
    private final BufferedWritableByteChannel buffered;
    private final BidiAppendableUnbufferedWritableByteChannel unbuffered;
    private final boolean finalizeOnClose;
    private final ReentrantLock lock;

    AppendableObjectBufferedWritableByteChannel(
        BufferedWritableByteChannel buffered,
        BidiAppendableUnbufferedWritableByteChannel unbuffered,
        boolean finalizeOnClose) {
      this.buffered = buffered;
      this.unbuffered = unbuffered;
      this.finalizeOnClose = finalizeOnClose;
      this.lock = new ReentrantLock();
    }

    @Override
    public void flush() throws IOException {
      lock.lock();
      try {
        buffered.flush();
        try {
          unbuffered.flush();
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          InterruptedIOException interruptedIOException = new InterruptedIOException();
          interruptedIOException.initCause(e);
          throw interruptedIOException;
        }
      } finally {
        lock.unlock();
      }
    }

    @Override
    public int write(ByteBuffer src) throws IOException {
      boolean locked = lock.tryLock();
      if (!locked) {
        return 0;
      }
      try {
        return buffered.write(src);
      } finally {
        lock.unlock();
      }
    }

    @Override
    public boolean isOpen() {
      lock.lock();
      try {
        return buffered.isOpen();
      } finally {
        lock.unlock();
      }
    }

    @Override
    public void finalizeAndClose() throws IOException {
      lock.lock();
      try {
        if (buffered.isOpen()) {
          unbuffered.nextWriteShouldFinalize();
          buffered.close();
        }
      } finally {
        lock.unlock();
      }
    }

    @Override
    public void closeWithoutFinalizing() throws IOException {
      lock.lock();
      try {
        if (buffered.isOpen()) {
          buffered.close();
        }
      } finally {
        lock.unlock();
      }
    }

    @Override
    public void close() throws IOException {
      if (finalizeOnClose) {
        finalizeAndClose();
      } else {
        closeWithoutFinalizing();
      }
    }
  }
}
