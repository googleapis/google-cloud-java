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

import com.google.api.core.ApiFuture;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.BaseWriteChannel;
import com.google.cloud.RestorableState;
import com.google.cloud.WriteChannel;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMap;

/**
 * Hierarchy retained for {@link RestorableState#restore()}. Will be removed in next major version!
 */
@Deprecated
class BlobWriteChannel extends BaseWriteChannel<StorageOptions, BlobInfo>
    implements StorageWriteChannel {

  private BlobWriteChannel() {
    super(null, null, null);
    throw new IllegalStateException("Illegal method access");
  }

  @Override
  public ApiFuture<BlobInfo> getObject() {
    throw new IllegalStateException("Illegal method access");
  }

  @Override
  protected HttpStorageOptions getOptions() {
    throw new IllegalStateException("Illegal method access");
  }

  @Override
  protected void flushBuffer(final int length, final boolean lastChunk) {
    throw new IllegalStateException("Illegal method access");
  }

  protected StateImpl.Builder stateBuilder() {
    throw new IllegalStateException("Illegal method access");
  }

  @Override
  public RestorableState<WriteChannel> capture() {
    throw new IllegalStateException("Illegal method access");
  }

  /** Retained for binary compatibility. Will be removed at next major version! */
  @SuppressWarnings("unused")
  @Deprecated
  @VisibleForTesting
  static class StateImpl extends BaseWriteChannel.BaseState<StorageOptions, BlobInfo> {

    private static final long serialVersionUID = -6700378962714601115L;

    private ResultRetryAlgorithm<?> algorithmForWrite;

    private StateImpl(Builder<StorageOptions, BlobInfo> builder) {
      super(builder);
    }

    @Override
    public WriteChannel restore() {
      try {
        StorageObject encode = entity != null ? Conversions.json().blobInfo().encode(entity) : null;
        return new BlobWriteChannelV2.BlobWriteChannelV2State(
                (HttpStorageOptions) serviceOptions,
                JsonResumableWrite.of(encode, ImmutableMap.of(), uploadId, position),
                position,
                isOpen,
                chunkSize,
                buffer)
            .restore();
      } catch (Exception e) {
        throw StorageException.coalesce(e);
      }
    }
  }
}
