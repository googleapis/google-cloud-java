/*
 * Copyright 2015 Google LLC
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

import static com.google.cloud.RetryHelper.runWithRetries;
import static java.util.concurrent.Executors.callable;

import com.google.cloud.BaseWriteChannel;
import com.google.cloud.RestorableState;
import com.google.cloud.RetryHelper;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.spi.v1.StorageRpc;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.Callable;

/** Write channel implementation to upload Google Cloud Storage blobs. */
class BlobWriteChannel extends BaseWriteChannel<StorageOptions, BlobInfo> {

  BlobWriteChannel(StorageOptions options, BlobInfo blob, Map<StorageRpc.Option, ?> optionsMap) {
    this(options, blob, open(options, blob, optionsMap));
  }

  BlobWriteChannel(StorageOptions options, URL signedURL) {
    this(options, open(signedURL, options));
  }

  BlobWriteChannel(StorageOptions options, BlobInfo blobInfo, String uploadId) {
    super(options, blobInfo, uploadId);
  }

  BlobWriteChannel(StorageOptions options, String uploadId) {
    super(options, null, uploadId);
  }

  @Override
  protected void flushBuffer(final int length, final boolean last) {
    try {
      runWithRetries(
          callable(
              new Runnable() {
                @Override
                public void run() {
                  getOptions()
                      .getStorageRpcV1()
                      .write(getUploadId(), getBuffer(), 0, getPosition(), length, last);
                }
              }),
          getOptions().getRetrySettings(),
          StorageImpl.EXCEPTION_HANDLER,
          getOptions().getClock());
    } catch (RetryHelper.RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  protected StateImpl.Builder stateBuilder() {
    return StateImpl.builder(getOptions(), getEntity(), getUploadId());
  }

  private static String open(
      final StorageOptions options,
      final BlobInfo blob,
      final Map<StorageRpc.Option, ?> optionsMap) {
    try {
      return runWithRetries(
          new Callable<String>() {
            @Override
            public String call() {
              return options.getStorageRpcV1().open(blob.toPb(), optionsMap);
            }
          },
          options.getRetrySettings(),
          StorageImpl.EXCEPTION_HANDLER,
          options.getClock());
    } catch (RetryHelper.RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  private static String open(final URL signedURL, final StorageOptions options) {
    try {
      return runWithRetries(
          new Callable<String>() {
            @Override
            public String call() {
              if (!isValidSignedURL(signedURL.getQuery())) {
                throw new StorageException(2, "invalid signedURL");
              }
              return options.getStorageRpcV1().open(signedURL.toString());
            }
          },
          options.getRetrySettings(),
          StorageImpl.EXCEPTION_HANDLER,
          options.getClock());
    } catch (RetryHelper.RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  private static boolean isValidSignedURL(String signedURLQuery) {
    boolean isValid = true;
    if (signedURLQuery.startsWith("X-Goog-Algorithm=")) {
      if (!signedURLQuery.contains("&X-Goog-Credential=")
          || !signedURLQuery.contains("&X-Goog-Date=")
          || !signedURLQuery.contains("&X-Goog-Expires=")
          || !signedURLQuery.contains("&X-Goog-SignedHeaders=")
          || !signedURLQuery.contains("&X-Goog-Signature=")) {
        isValid = false;
      }
    } else if (signedURLQuery.startsWith("GoogleAccessId=")) {
      if (!signedURLQuery.contains("&Expires=") || !signedURLQuery.contains("&Signature=")) {
        isValid = false;
      }
    } else {
      isValid = false;
    }
    return isValid;
  }

  static class StateImpl extends BaseWriteChannel.BaseState<StorageOptions, BlobInfo> {

    private static final long serialVersionUID = -9028324143780151286L;

    StateImpl(Builder builder) {
      super(builder);
    }

    static class Builder extends BaseWriteChannel.BaseState.Builder<StorageOptions, BlobInfo> {

      private Builder(StorageOptions options, BlobInfo blobInfo, String uploadId) {
        super(options, blobInfo, uploadId);
      }

      @Override
      public RestorableState<WriteChannel> build() {
        return new StateImpl(this);
      }
    }

    static Builder builder(StorageOptions options, BlobInfo blobInfo, String uploadId) {
      return new Builder(options, blobInfo, uploadId);
    }

    @Override
    public WriteChannel restore() {
      BlobWriteChannel channel = new BlobWriteChannel(serviceOptions, entity, uploadId);
      channel.restore(this);
      return channel;
    }
  }
}
