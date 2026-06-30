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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.time.Clock;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import javax.annotation.concurrent.Immutable;

/**
 * Default Configuration to represent uploading to Google Cloud Storage in a chunked manner.
 *
 * <p>Perform a resumable upload, uploading at most {@code chunkSize} bytes each PUT.
 *
 * <p>Configuration of chunk size can be performed via {@link
 * DefaultBlobWriteSessionConfig#withChunkSize(int)}.
 *
 * <p>An instance of this class will provide a {@link BlobWriteSession} is logically equivalent to
 * the following:
 *
 * <pre>{@code
 * Storage storage = ...;
 * WriteChannel writeChannel = storage.writer(BlobInfo, BlobWriteOption);
 * writeChannel.setChunkSize(chunkSize);
 * }</pre>
 *
 * @since 2.26.0 This new api is in preview and is subject to breaking changes.
 */
@Immutable
@BetaApi
@TransportCompatibility({Transport.GRPC, Transport.HTTP})
public final class DefaultBlobWriteSessionConfig extends BlobWriteSessionConfig
    implements BlobWriteSessionConfig.HttpCompatible, BlobWriteSessionConfig.GrpcCompatible {
  private static final long serialVersionUID = -6873740918589930633L;

  private final int chunkSize;

  @InternalApi
  DefaultBlobWriteSessionConfig(int chunkSize) {
    this.chunkSize = chunkSize;
  }

  /**
   * The number of bytes each chunk can be.
   *
   * <p><i>Default:</i> {@code 16777216 (16 MiB)}
   *
   * @see #withChunkSize(int)
   * @since 2.26.0 This new api is in preview and is subject to breaking changes.
   */
  public int getChunkSize() {
    return chunkSize;
  }

  /**
   * Create a new instance with the {@code chunkSize} set to the specified value.
   *
   * <p><i>Default:</i> {@code 16777216 (16 MiB)}
   *
   * @param chunkSize The number of bytes each chunk should be. Must be &gt;= {@code 262144 (256
   *     KiB)}
   * @return The new instance
   * @see #getChunkSize()
   * @since 2.26.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  public DefaultBlobWriteSessionConfig withChunkSize(int chunkSize) {
    Preconditions.checkArgument(
        chunkSize >= ByteSizeConstants._256KiB,
        "chunkSize must be >= %d",
        ByteSizeConstants._256KiB);
    return new DefaultBlobWriteSessionConfig(chunkSize);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DefaultBlobWriteSessionConfig)) {
      return false;
    }
    DefaultBlobWriteSessionConfig that = (DefaultBlobWriteSessionConfig) o;
    return chunkSize == that.chunkSize;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(chunkSize);
  }

  @Override
  @InternalApi
  WriterFactory createFactory(Clock clock) {
    return new Factory(chunkSize);
  }

  @InternalApi
  private static final class Factory implements WriterFactory {

    private final int chunkSize;

    private Factory(int chunkSize) {
      this.chunkSize = chunkSize;
    }

    @InternalApi
    @Override
    public WritableByteChannelSession<?, BlobInfo> writeSession(
        StorageInternal s, BlobInfo info, Opts<ObjectTargetOpt> opts) {
      if (s instanceof GrpcStorageImpl) {
        return new DecoratedWritableByteChannelSession<>(
            new LazySession<>(
                new LazyWriteChannel<>(
                    () -> {
                      GrpcStorageImpl grpc = (GrpcStorageImpl) s;
                      GrpcCallContext grpcCallContext =
                          opts.grpcMetadataMapper().apply(GrpcCallContext.createDefault());
                      WriteObjectRequest req = grpc.getWriteObjectRequest(info, opts);

                      ApiFuture<ResumableWrite> startResumableWrite =
                          grpc.startResumableWrite(grpcCallContext, req, opts);
                      return ResumableMedia.gapic()
                          .write()
                          .byteChannel(
                              grpc.storageClient
                                  .writeObjectCallable()
                                  .withDefaultCallContext(grpcCallContext))
                          .setHasher(opts.getHasher())
                          .setByteStringStrategy(ByteStringStrategy.copy())
                          .resumable()
                          .withRetryConfig(
                              grpc.retrier.withAlg(grpc.retryAlgorithmManager.idempotent()))
                          .buffered(BufferHandle.allocate(chunkSize))
                          .setStartAsync(startResumableWrite)
                          .build();
                    })),
            Conversions.grpc().blobInfo().compose(WriteObjectResponse::getResource));
      } else if (s instanceof StorageImpl) {
        StorageImpl json = (StorageImpl) s;

        return new DecoratedWritableByteChannelSession<>(
            new LazySession<>(
                new LazyWriteChannel<>(
                    () -> {
                      final Map<StorageRpc.Option, ?> optionsMap = opts.getRpcOptions();
                      BlobInfo.Builder builder = info.toBuilder().setMd5(null).setCrc32c(null);
                      BlobInfo updated = opts.blobInfoMapper().apply(builder).build();

                      StorageObject encode = Conversions.json().blobInfo().encode(updated);
                      Supplier<String> uploadIdSupplier =
                          ResumableMedia.startUploadForBlobInfo(
                              json.getOptions(),
                              updated,
                              optionsMap,
                              json.retrier.withAlg(
                                  json.retryAlgorithmManager.getForResumableUploadSessionCreate(
                                      optionsMap)));
                      ApiFuture<JsonResumableWrite> startAsync =
                          ApiFutures.immediateFuture(
                              JsonResumableWrite.of(
                                  encode,
                                  optionsMap,
                                  uploadIdSupplier.get(),
                                  0L,
                                  opts.getHasher(),
                                  opts.getHasher().initialValue()));

                      return ResumableMedia.http()
                          .write()
                          .byteChannel(HttpClientContext.from(json.storageRpc))
                          .resumable()
                          .buffered(BufferHandle.allocate(chunkSize))
                          .setStartAsync(startAsync)
                          .build();
                    })),
            Conversions.json().blobInfo());
      } else {
        throw new IllegalStateException(
            "Unknown Storage implementation: " + s.getClass().getName());
      }
    }
  }

  static final class DecoratedWritableByteChannelSession<WBC extends WritableByteChannel, T>
      implements WritableByteChannelSession<WBC, BlobInfo> {

    private final WritableByteChannelSession<WBC, T> delegate;
    private final Decoder<T, BlobInfo> decoder;

    DecoratedWritableByteChannelSession(
        WritableByteChannelSession<WBC, T> delegate, Decoder<T, BlobInfo> decoder) {
      this.delegate = delegate;
      this.decoder = decoder;
    }

    @Override
    public ApiFuture<WBC> openAsync() {
      return ApiFutures.catchingAsync(
          delegate.openAsync(),
          Throwable.class,
          throwable -> ApiFutures.immediateFailedFuture(StorageException.coalesce(throwable)),
          MoreExecutors.directExecutor());
    }

    @Override
    public ApiFuture<BlobInfo> getResult() {
      ApiFuture<BlobInfo> decodeResult =
          ApiFutures.transform(
              delegate.getResult(), decoder::decode, MoreExecutors.directExecutor());
      return ApiFutures.catchingAsync(
          decodeResult,
          Throwable.class,
          throwable -> ApiFutures.immediateFailedFuture(StorageException.coalesce(throwable)),
          MoreExecutors.directExecutor());
    }
  }

  static final class LazySession<R>
      implements WritableByteChannelSession<BufferedWritableByteChannel, R> {
    private final LazyWriteChannel<R> lazy;

    LazySession(LazyWriteChannel<R> lazy) {
      this.lazy = lazy;
    }

    @Override
    public ApiFuture<BufferedWritableByteChannel> openAsync() {
      // make sure the errors coming out of the BufferedWritableByteChannel are either IOException
      // or StorageException
      return ApiFutures.transform(
          lazy.getSession().openAsync(),
          delegate ->
              new BufferedWritableByteChannel() {
                @Override
                public int write(ByteBuffer src) throws IOException {
                  try {
                    return delegate.write(src);
                  } catch (IOException e) {
                    throw e;
                  } catch (Exception e) {
                    throw StorageException.coalesce(e);
                  }
                }

                @Override
                public void flush() throws IOException {
                  try {
                    delegate.flush();
                  } catch (IOException e) {
                    throw e;
                  } catch (Exception e) {
                    throw StorageException.coalesce(e);
                  }
                }

                @Override
                public boolean isOpen() {
                  try {
                    return delegate.isOpen();
                  } catch (Exception e) {
                    throw StorageException.coalesce(e);
                  }
                }

                @Override
                public void close() throws IOException {
                  try {
                    delegate.close();
                  } catch (IOException e) {
                    throw e;
                  } catch (Exception e) {
                    throw StorageException.coalesce(e);
                  }
                }
              },
          MoreExecutors.directExecutor());
    }

    @Override
    public ApiFuture<R> getResult() {
      return lazy.getSession().getResult();
    }
  }
}
