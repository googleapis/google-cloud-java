/*
 * Copyright 2022 Google LLC
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

import com.google.api.services.storage.Storage;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.ReadChannel;
import com.google.cloud.RestorableState;
import com.google.cloud.storage.ApiaryUnbufferedReadableByteChannel.ApiaryReadRequest;
import com.google.cloud.storage.HttpDownloadSessionBuilder.ReadableByteChannelSessionBuilder;
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

final class BlobReadChannelV2 extends BaseStorageReadChannel<StorageObject> {

  private final StorageObject storageObject;
  private final Map<StorageRpc.Option, ?> opts;
  private final BlobReadChannelContext blobReadChannelContext;
  private final boolean autoGzipDecompression;

  BlobReadChannelV2(
      StorageObject storageObject,
      Map<StorageRpc.Option, ?> opts,
      BlobReadChannelContext blobReadChannelContext) {
    super(Conversions.json().blobInfo());
    this.storageObject = storageObject;
    this.opts = opts;
    this.blobReadChannelContext = blobReadChannelContext;
    this.autoGzipDecompression =
        // RETURN_RAW_INPUT_STREAM means do not add GZIPInputStream to the pipeline. Meaning, if
        // RETURN_RAW_INPUT_STREAM is false, automatically attempt to decompress if Content-Encoding
        // gzip.
        Boolean.FALSE.equals(opts.get(StorageRpc.Option.RETURN_RAW_INPUT_STREAM));
  }

  @Override
  public RestorableState<ReadChannel> capture() {
    lock.lock();
    try {
      ApiaryReadRequest apiaryReadRequest = getApiaryReadRequest();
      return new BlobReadChannelV2State(
          apiaryReadRequest, blobReadChannelContext.getStorageOptions(), getChunkSize());
    } finally {
      lock.unlock();
    }
  }

  protected LazyReadChannel<?, StorageObject> newLazyReadChannel() {
    return new LazyReadChannel<>(
        () -> {
          ReadableByteChannelSessionBuilder b =
              ResumableMedia.http()
                  .read()
                  .byteChannel(blobReadChannelContext)
                  .setAutoGzipDecompression(autoGzipDecompression);
          BufferHandle bufferHandle = getBufferHandle();
          // because we're erasing the specific type of channel, we need to declare it here.
          // If we don't, the compiler complains we're not returning a compliant type.
          ReadableByteChannelSession<?, StorageObject> session;
          if (bufferHandle.capacity() > 0) {
            session = b.buffered(bufferHandle).setApiaryReadRequest(getApiaryReadRequest()).build();
          } else {
            session = b.unbuffered().setApiaryReadRequest(getApiaryReadRequest()).build();
          }
          return session;
        });
  }

  private ApiaryReadRequest getApiaryReadRequest() {
    StorageObject object = getResolvedObject() != null ? getResolvedObject() : storageObject;
    return new ApiaryReadRequest(object, opts, getByteRangeSpec());
  }

  static final class BlobReadChannelV2State implements RestorableState<ReadChannel>, Serializable {

    private static final long serialVersionUID = -7595661593080505431L;

    private final ApiaryReadRequest request;
    private final HttpStorageOptions options;

    private final Integer chunkSize;

    private BlobReadChannelV2State(
        ApiaryReadRequest request, HttpStorageOptions options, Integer chunkSize) {
      this.request = request;
      this.options = options;
      this.chunkSize = chunkSize;
    }

    @Override
    public ReadChannel restore() {
      BlobReadChannelV2 channel =
          new BlobReadChannelV2(
              request.getObject(), request.getOptions(), BlobReadChannelContext.from(options));
      channel.setByteRangeSpec(request.getByteRangeSpec());
      if (chunkSize != null) {
        channel.setChunkSize(chunkSize);
      }
      return channel;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof BlobReadChannelV2State)) {
        return false;
      }
      BlobReadChannelV2State that = (BlobReadChannelV2State) o;
      return Objects.equals(request, that.request)
          && Objects.equals(options, that.options)
          && Objects.equals(chunkSize, that.chunkSize);
    }

    @Override
    public int hashCode() {
      return Objects.hash(request, options, chunkSize);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("request", request)
          .add("options", options)
          .add("chunkSize", chunkSize)
          .toString();
    }
  }

  static final class BlobReadChannelContext {
    private final HttpStorageOptions storageOptions;
    private final HttpRetryAlgorithmManager retryAlgorithmManager;
    private final HttpClientContext httpClientContext;
    private final Storage apiaryClient;
    private final Retrier retrier;

    private BlobReadChannelContext(
        HttpStorageOptions storageOptions,
        HttpRetryAlgorithmManager retryAlgorithmManager,
        HttpClientContext httpClientContext,
        Storage apiaryClient,
        Retrier retrier) {
      this.storageOptions = storageOptions;
      this.retryAlgorithmManager = retryAlgorithmManager;
      this.httpClientContext = httpClientContext;
      this.apiaryClient = apiaryClient;
      this.retrier = retrier;
    }

    public HttpStorageOptions getStorageOptions() {
      return storageOptions;
    }

    public HttpRetryAlgorithmManager getRetryAlgorithmManager() {
      return retryAlgorithmManager;
    }

    public HttpClientContext getHttpClientContext() {
      return httpClientContext;
    }

    public Storage getApiaryClient() {
      return apiaryClient;
    }

    public Retrier getRetrier() {
      return retrier;
    }

    /**
     * This method is pretty unsafe, but so is all of the Capture/Restore API, and it leaks its
     * sludge all over everything. In general, prefer {@link
     * #from(com.google.cloud.storage.StorageImpl)} over this method.
     *
     * <p>Essentially, cause options to instantiate a StorageImpl if it hasn't done so already, then
     * root around to try and find its retrier.
     */
    static BlobReadChannelContext from(HttpStorageOptions options) {
      com.google.cloud.storage.Storage storage = options.getService();
      if (storage instanceof OtelStorageDecorator) {
        OtelStorageDecorator decorator = (OtelStorageDecorator) storage;
        storage = decorator.delegate;
      }
      if (storage instanceof StorageImpl) {
        StorageImpl impl = (StorageImpl) storage;
        return from(impl);
      }
      throw new IllegalArgumentException(
          "Unable to restore context from provided options instance");
    }

    static BlobReadChannelContext from(com.google.cloud.storage.StorageImpl s) {
      HttpStorageOptions options = s.getOptions();
      return new BlobReadChannelContext(
          options,
          options.getRetryAlgorithmManager(),
          HttpClientContext.from(options.getStorageRpcV1()),
          options.getStorageRpcV1().getStorage(),
          s.retrier);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof BlobReadChannelContext)) {
        return false;
      }
      BlobReadChannelContext that = (BlobReadChannelContext) o;
      return Objects.equals(storageOptions, that.storageOptions)
          && Objects.equals(retryAlgorithmManager, that.retryAlgorithmManager);
    }

    @Override
    public int hashCode() {
      return Objects.hash(storageOptions, retryAlgorithmManager);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("storageOptions", storageOptions).toString();
    }
  }
}
