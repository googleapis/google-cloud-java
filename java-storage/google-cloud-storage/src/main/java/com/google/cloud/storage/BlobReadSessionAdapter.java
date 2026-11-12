/*
 * Copyright 2024 Google LLC
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
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.cloud.storage.ZeroCopySupport.DisposableByteString;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SeekableByteChannel;
import org.checkerframework.checker.nullness.qual.Nullable;

final class BlobReadSessionAdapter implements BlobReadSession {

  @VisibleForTesting final ObjectReadSession session;
  @Nullable private final StorageMetricsContext metricsContext;
  @Nullable private final StorageClientMetrics storageClientMetrics;
  @Nullable private volatile Throwable lastOperationError;

  BlobReadSessionAdapter(ObjectReadSession session) {
    this(session, null, null);
  }

  BlobReadSessionAdapter(
      ObjectReadSession session,
      @Nullable StorageMetricsContext metricsContext,
      @Nullable StorageClientMetrics storageClientMetrics) {
    this.session = session;
    this.metricsContext = metricsContext;
    this.storageClientMetrics = storageClientMetrics;
  }

  @Override
  public BlobInfo getBlobInfo() {
    return Conversions.grpc().blobInfo().decode(session.getResource());
  }

  // ApiFutures type is erased, but that's okay. We're only decorating the errors. not changing
  // the return type.
  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  public <Projection> Projection readAs(ReadProjectionConfig<Projection> config) {
    Projection projection;
    try {
      projection = session.readAs(config);
    } catch (Throwable t) {
      lastOperationError = t;
      throw t;
    }
    if (projection instanceof ApiFuture) {
      ApiFuture apiFuture = StorageException.coalesceAsync((ApiFuture) projection);
      if (metricsContext != null) {
        ApiFutures.addCallback(
            apiFuture,
            new ApiFutureCallback<Object>() {
              @Override
              public void onSuccess(Object result) {
                if (result instanceof byte[]) {
                  int len = ((byte[]) result).length;
                  if (len > 0) {
                    metricsContext.addResponseBytes(len);
                  }
                } else if (result instanceof DisposableByteString) {
                  int len = ((DisposableByteString) result).byteString().size();
                  if (len > 0) {
                    metricsContext.addResponseBytes(len);
                  }
                }
              }

              @Override
              public void onFailure(Throwable t) {
                if (!(t instanceof AsyncSessionClosedException)
                    && !(t.getCause() instanceof AsyncSessionClosedException)) {
                  lastOperationError = t;
                }
              }
            },
            MoreExecutors.directExecutor());
      }
      return (Projection) apiFuture;
    }
    if (metricsContext != null && projection instanceof SeekableByteChannel) {
      return (Projection) wrapSeekableByteChannel((SeekableByteChannel) projection);
    }
    if (metricsContext != null && projection instanceof ScatteringByteChannel) {
      return (Projection) wrapScatteringByteChannel((ScatteringByteChannel) projection);
    }
    return projection;
  }

  @Override
  public void close() throws IOException {
    Throwable priorError = lastOperationError;
    Throwable error = null;
    try {
      session.close();
    } catch (Throwable t) {
      error = t;
      throw t;
    } finally {
      if (metricsContext != null && storageClientMetrics != null) {
        metricsContext.recordOperation(storageClientMetrics, error != null ? error : priorError);
      }
    }
  }

  private SeekableByteChannel wrapSeekableByteChannel(SeekableByteChannel delegate) {
    return new SeekableByteChannel() {
      @Override
      public int read(ByteBuffer dst) throws IOException {
        try {
          int read = delegate.read(dst);
          if (read > 0) {
            metricsContext.addResponseBytes(read);
          }
          return read;
        } catch (IOException | RuntimeException | Error e) {
          lastOperationError = e;
          throw e;
        }
      }

      @Override
      public int write(ByteBuffer src) throws IOException {
        return delegate.write(src);
      }

      @Override
      public long position() throws IOException {
        return delegate.position();
      }

      @Override
      public SeekableByteChannel position(long newPosition) throws IOException {
        delegate.position(newPosition);
        return this;
      }

      @Override
      public long size() throws IOException {
        return delegate.size();
      }

      @Override
      public SeekableByteChannel truncate(long size) throws IOException {
        delegate.truncate(size);
        return this;
      }

      @Override
      public boolean isOpen() {
        return delegate.isOpen();
      }

      @Override
      public void close() throws IOException {
        delegate.close();
      }
    };
  }

  private ScatteringByteChannel wrapScatteringByteChannel(ScatteringByteChannel delegate) {
    return new ScatteringByteChannel() {
      @Override
      public int read(ByteBuffer dst) throws IOException {
        try {
          int read = delegate.read(dst);
          if (read > 0) {
            metricsContext.addResponseBytes(read);
          }
          return read;
        } catch (IOException | RuntimeException | Error e) {
          lastOperationError = e;
          throw e;
        }
      }

      @Override
      public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
        try {
          long read = delegate.read(dsts, offset, length);
          if (read > 0) {
            metricsContext.addResponseBytes(read);
          }
          return read;
        } catch (IOException | RuntimeException | Error e) {
          lastOperationError = e;
          throw e;
        }
      }

      @Override
      public long read(ByteBuffer[] dsts) throws IOException {
        try {
          long read = delegate.read(dsts);
          if (read > 0) {
            metricsContext.addResponseBytes(read);
          }
          return read;
        } catch (IOException | RuntimeException | Error e) {
          lastOperationError = e;
          throw e;
        }
      }

      @Override
      public boolean isOpen() {
        return delegate.isOpen();
      }

      @Override
      public void close() throws IOException {
        delegate.close();
      }
    };
  }

  static ApiFuture<BlobReadSession> wrap(ApiFuture<ObjectReadSession> session) {
    return wrap(session, null, null);
  }

  static ApiFuture<BlobReadSession> wrap(
      ApiFuture<ObjectReadSession> session,
      @Nullable StorageMetricsContext metricsContext,
      @Nullable StorageClientMetrics storageClientMetrics) {
    ApiFuture<ObjectReadSession> coalesced = StorageException.coalesceAsync(session);
    if (metricsContext != null && storageClientMetrics != null) {
      ApiFutures.addCallback(
          coalesced,
          new ApiFutureCallback<ObjectReadSession>() {
            @Override
            public void onSuccess(ObjectReadSession result) {}

            @Override
            public void onFailure(Throwable t) {
              metricsContext.recordOperation(storageClientMetrics, t);
            }
          },
          MoreExecutors.directExecutor());
    }
    return ApiFutures.transform(
        coalesced,
        s -> new BlobReadSessionAdapter(s, metricsContext, storageClientMetrics),
        MoreExecutors.directExecutor());
  }
}
