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

import static com.google.cloud.storage.ByteSizeConstants._2MiB;
import static java.util.Objects.requireNonNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.qual.Nullable;

abstract class BaseStorageReadChannel<T> implements StorageReadChannel {

  private final Decoder<T, BlobInfo> objectDecoder;
  private final SettableApiFuture<T> result;

  private boolean open;
  private ByteRangeSpec byteRangeSpec;
  private int chunkSize = _2MiB;
  private BufferHandle bufferHandle;
  private LazyReadChannel<?, T> lazyReadChannel;
  protected final ReentrantLock lock;

  protected BaseStorageReadChannel(Decoder<T, BlobInfo> objectDecoder) {
    this.objectDecoder = objectDecoder;
    this.result = SettableApiFuture.create();
    this.open = true;
    this.byteRangeSpec = ByteRangeSpec.nullRange();
    this.lock = new ReentrantLock();
  }

  @Override
  public final void setChunkSize(int chunkSize) {
    lock.lock();
    try {
      StorageException.wrapIOException(() -> maybeResetChannel(true));
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
  public final void close() {
    lock.lock();
    try {
      open = false;
      if (internalGetLazyChannel().isOpen()) {
        ReadableByteChannel channel = internalGetLazyChannel().getChannel();
        StorageException.wrapIOException(channel::close);
      }
    } finally {
      lock.unlock();
    }
  }

  @Override
  public final StorageReadChannel setByteRangeSpec(ByteRangeSpec byteRangeSpec) {
    requireNonNull(byteRangeSpec, "byteRangeSpec must be non null");
    lock.lock();
    try {
      if (!this.byteRangeSpec.equals(byteRangeSpec)) {
        StorageException.wrapIOException(() -> maybeResetChannel(false));
        this.byteRangeSpec = byteRangeSpec;
      }
      return this;
    } finally {
      lock.unlock();
    }
  }

  @Override
  public final ByteRangeSpec getByteRangeSpec() {
    return byteRangeSpec;
  }

  @Override
  public final int read(ByteBuffer dst) throws IOException {
    lock.lock();
    try {
      // BlobReadChannel only considered itself closed if close had been called on it.
      if (!open) {
        throw new ClosedChannelException();
      }
      long diff = byteRangeSpec.length();
      // the check on beginOffset >= 0 used to be a precondition on seek(long)
      // move it here to preserve existing behavior while allowing new negative offsets
      if (diff <= 0 && byteRangeSpec.beginOffset() >= 0) {
        return -1;
      }
      try {
        // trap if the fact that tmp is already closed, and instead return -1
        ReadableByteChannel tmp = internalGetLazyChannel().getChannel();
        if (!tmp.isOpen()) {
          return -1;
        }
        int read = tmp.read(dst);
        if (read != -1) {
          byteRangeSpec = byteRangeSpec.withShiftBeginOffset(read);
        }
        return read;
      } catch (StorageException e) {
        if (e.getCode() == 416) {
          // HttpStorageRpc turns 416 into a null etag with an empty byte array, leading
          // BlobReadChannel to believe it read 0 bytes, returning -1 and leaving the channel open.
          // Emulate that same behavior here to preserve behavior compatibility, though this should
          // be removed in the next major version.
          return -1;
        } else {
          throw new IOException(e);
        }
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
      bufferHandle = BufferHandle.allocate(chunkSize);
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

  protected abstract LazyReadChannel<?, T> newLazyReadChannel();

  private void maybeResetChannel(boolean freeBuffer) throws IOException {
    if (lazyReadChannel != null) {
      if (lazyReadChannel.isOpen()) {
        lazyReadChannel.getChannel().close();
      }
      if (bufferHandle != null && !freeBuffer) {
        bufferHandle.get().clear();
      } else if (freeBuffer) {
        bufferHandle = null;
      }
      lazyReadChannel = null;
    }
  }

  private LazyReadChannel<?, T> internalGetLazyChannel() {
    if (lazyReadChannel == null) {
      LazyReadChannel<?, T> tmp = newLazyReadChannel();
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
      lazyReadChannel = tmp;
    }
    return lazyReadChannel;
  }
}
