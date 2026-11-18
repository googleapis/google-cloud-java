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
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.BaseServiceException;
import com.google.cloud.storage.ZeroCopySupport.DisposableByteString;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SeekableByteChannel;
import org.jspecify.annotations.Nullable;

final class BlobReadSessionAdapter implements BlobReadSession {

  @VisibleForTesting final ObjectReadSession session;
  private final @Nullable StorageMetricsContext metricsContext;
  private final @Nullable StorageClientMetrics storageClientMetrics;
  private volatile @Nullable Throwable lastOperationError;

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
      lastOperationError = unwrapIoException(t);
      throw t;
    }
    StorageMetricsContext ctx = this.metricsContext;
    if (projection instanceof ApiFuture) {
      ApiFuture<Object> apiFuture = StorageException.coalesceAsync((ApiFuture) projection);
      if (ctx != null) {
        ApiFuture<Object> tracked =
            ApiFutures.transform(
                apiFuture,
                result -> {
                  if (result instanceof byte[]) {
                    int len = ((byte[]) result).length;
                    if (len > 0) {
                      ctx.addResponseBytes(len);
                    }
                  } else if (result instanceof DisposableByteString) {
                    int len = ((DisposableByteString) result).byteString().size();
                    if (len > 0) {
                      ctx.addResponseBytes(len);
                    }
                  }
                  return result;
                },
                MoreExecutors.directExecutor());
        apiFuture =
            ApiFutures.catchingAsync(
                tracked,
                Throwable.class,
                t -> {
                  if (!(t instanceof AsyncSessionClosedException)
                      && !(t.getCause() instanceof AsyncSessionClosedException)) {
                    lastOperationError = t;
                  }
                  return ApiFutures.immediateFailedFuture(t);
                },
                MoreExecutors.directExecutor());
      }
      return (Projection) apiFuture;
    }
    if (ctx != null && projection instanceof SeekableByteChannel) {
      return (Projection) wrapSeekableByteChannel((SeekableByteChannel) projection, ctx);
    }
    if (ctx != null && projection instanceof ScatteringByteChannel) {
      return (Projection) wrapScatteringByteChannel((ScatteringByteChannel) projection, ctx);
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
      error = unwrapIoException(t);
      throw t;
    } finally {
      if (metricsContext != null && storageClientMetrics != null) {
        metricsContext.recordOperation(storageClientMetrics, error != null ? error : priorError);
      }
    }
  }

  static ApiFuture<BlobReadSession> wrap(
      ApiFuture<ObjectReadSession> session,
      @Nullable StorageMetricsContext metricsContext,
      @Nullable StorageClientMetrics storageClientMetrics) {
    ApiFuture<ObjectReadSession> coalesced = StorageException.coalesceAsync(session);
    if (metricsContext != null && storageClientMetrics != null) {
      coalesced =
          ApiFutures.catchingAsync(
              coalesced,
              Throwable.class,
              t -> {
                metricsContext.recordOperation(storageClientMetrics, t);
                return ApiFutures.immediateFailedFuture(t);
              },
              MoreExecutors.directExecutor());
    }
    return ApiFutures.transform(
        coalesced,
        s -> new BlobReadSessionAdapter(s, metricsContext, storageClientMetrics),
        MoreExecutors.directExecutor());
  }

  private SeekableByteChannel wrapSeekableByteChannel(
      SeekableByteChannel delegate, StorageMetricsContext ctx) {
    return new SeekableByteChannel() {
      @Override
      public int read(ByteBuffer dst) throws IOException {
        return (int) trackRead(ctx, () -> delegate.read(dst));
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

  private ScatteringByteChannel wrapScatteringByteChannel(
      ScatteringByteChannel delegate, StorageMetricsContext ctx) {
    return new ScatteringByteChannel() {
      @Override
      public int read(ByteBuffer dst) throws IOException {
        return (int) trackRead(ctx, () -> delegate.read(dst));
      }

      @Override
      public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
        return trackRead(ctx, () -> delegate.read(dsts, offset, length));
      }

      @Override
      public long read(ByteBuffer[] dsts) throws IOException {
        return trackRead(ctx, () -> delegate.read(dsts));
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

  private long trackRead(StorageMetricsContext ctx, ReadOp op) throws IOException {
    try {
      long read = op.read();
      if (read > 0) {
        ctx.addResponseBytes(read);
      }
      return read;
    } catch (IOException | RuntimeException | Error e) {
      lastOperationError = unwrapIoException(e);
      throw e;
    }
  }

  private static Throwable unwrapIoException(Throwable t) {
    if (t instanceof IOException
        && (t.getCause() instanceof BaseServiceException || t.getCause() instanceof ApiException)) {
      return t.getCause();
    }
    return t;
  }

  @FunctionalInterface
  private interface ReadOp {
    long read() throws IOException;
  }
}
