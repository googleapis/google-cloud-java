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

import static com.google.cloud.storage.ByteSizeConstants._16MiB;
import static com.google.cloud.storage.ByteSizeConstants._256KiB;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.qual.Nullable;

abstract class BaseStorageWriteChannel<T> implements StorageWriteChannel {

  private final Decoder<T, BlobInfo> objectDecoder;
  private final SettableApiFuture<T> result;
  protected final ReentrantLock lock;

  private long position;
  private boolean open;
  private int chunkSize;
  private LazyWriteChannel<T> lazyWriteChannel;
  private BufferHandle bufferHandle;

  /**
   * This is tracked for compatibility with BlobWriteChannel, such that simply creating a writer
   * will create an object.
   *
   * <p>In the future we should move away from this behavior, and only create an object if write is
   * called.
   */
  protected boolean writeCalledAtLeastOnce;

  protected BaseStorageWriteChannel(Decoder<T, BlobInfo> objectDecoder) {
    this.objectDecoder = objectDecoder;
    this.result = SettableApiFuture.create();
    this.lock = new ReentrantLock();
    this.open = true;
    this.chunkSize = _16MiB;
    this.writeCalledAtLeastOnce = false;
  }

  @Override
  public final void setChunkSize(int chunkSize) {
    lock.lock();
    try {
      Preconditions.checkArgument(chunkSize > 0, "chunkSize must be > 0, received %d", chunkSize);
      Preconditions.checkState(
          bufferHandle == null || bufferHandle.position() == 0,
          "unable to change chunk size with data buffered");
      this.chunkSize = chunkSize;
    } finally {
      lock.unlock();
    }
  }

  @Override
  public final boolean isOpen() {
    lock.lock();
    try {
      return open;
    } finally {
      lock.unlock();
    }
  }

  @Override
  public final void close() throws IOException {
    lock.lock();
    try {
      if (open && !writeCalledAtLeastOnce) {
        this.write(ByteBuffer.allocate(0));
      }
      if (internalGetLazyChannel().isOpen()) {
        StorageException.wrapIOException(internalGetLazyChannel().getChannel()::close);
      }
    } finally {
      open = false;
      lock.unlock();
    }
  }

  @Override
  public final int write(ByteBuffer src) throws IOException {
    lock.lock();
    try {
      if (!open) {
        throw new ClosedChannelException();
      }
      writeCalledAtLeastOnce = true;
      try {
        BufferedWritableByteChannel tmp = internalGetLazyChannel().getChannel();
        if (!tmp.isOpen()) {
          return 0;
        }
        int write = tmp.write(src);
        return write;
      } catch (StorageException e) {
        throw new IOException(e);
      } catch (IOException e) {
        throw e;
      } catch (Exception e) {
        throw new IOException(StorageException.coalesce(e));
      }
    } finally {
      lock.unlock();
    }
  }

  @Override
  public final ApiFuture<BlobInfo> getObject() {
    return ApiFutures.transform(result, objectDecoder::decode, MoreExecutors.directExecutor());
  }

  protected final BufferHandle getBufferHandle() {
    if (bufferHandle == null) {
      bufferHandle = BufferHandle.allocate(Buffers.alignSize(getChunkSize(), _256KiB));
    }
    return bufferHandle;
  }

  protected final int getChunkSize() {
    return chunkSize;
  }

  @Nullable
  protected final T getResolvedObject() {
    if (result.isDone()) {
      return StorageException.wrapFutureGet(result);
    } else {
      return null;
    }
  }

  protected final long getCommittedPosition() {
    return position;
  }

  protected final void setCommittedPosition(long l) {
    position = l;
  }

  protected final void setOpen(boolean isOpen) {
    this.open = isOpen;
  }

  protected abstract LazyWriteChannel<T> newLazyWriteChannel();

  private LazyWriteChannel<T> internalGetLazyChannel() {
    if (lazyWriteChannel == null) {
      LazyWriteChannel<T> tmp = newLazyWriteChannel();
      ApiFuture<T> future = tmp.getSession().getResult();
      ApiFutures.addCallback(
          future,
          new ApiFutureCallback<T>() {
            @Override
            public void onFailure(Throwable t) {
              if (!result.isDone()) {
                result.setException(t);
              }
            }

            @Override
            public void onSuccess(T t) {
              if (!result.isDone()) {
                result.set(t);
              }
            }
          },
          MoreExecutors.directExecutor());
      lazyWriteChannel = tmp;
    }
    return lazyWriteChannel;
  }
}
