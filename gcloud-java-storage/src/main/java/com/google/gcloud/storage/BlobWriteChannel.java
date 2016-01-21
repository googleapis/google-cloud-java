/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage;

import static com.google.gcloud.RetryHelper.runWithRetries;
import static java.util.concurrent.Executors.callable;

import com.google.gcloud.BaseWriteChannel;
import com.google.gcloud.RestorableState;
import com.google.gcloud.RetryHelper;
import com.google.gcloud.WriteChannel;
import com.google.gcloud.spi.StorageRpc;

import java.util.Map;

/**
 * Write channel implementation to upload Google Cloud Storage blobs.
 */
class BlobWriteChannel extends BaseWriteChannel<StorageOptions, BlobInfo> {

  BlobWriteChannel(StorageOptions options, BlobInfo blob, Map<StorageRpc.Option, ?> optionsMap) {
    this(options, blob, options.rpc().open(blob.toPb(), optionsMap));
  }

  BlobWriteChannel(StorageOptions options, BlobInfo blobInfo, String uploadId) {
    super(options, blobInfo, uploadId);
  }

  @Override
  protected void flushBuffer(final int length, final boolean last) {
    try {
      runWithRetries(callable(new Runnable() {
        @Override
        public void run() {
          options().rpc().write(uploadId(), buffer(), 0, position(), length, last);
        }
      }), options().retryParams(), StorageImpl.EXCEPTION_HANDLER);
    } catch (RetryHelper.RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  protected StateImpl.Builder stateBuilder() {
    return StateImpl.builder(options(), entity(), uploadId());
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
