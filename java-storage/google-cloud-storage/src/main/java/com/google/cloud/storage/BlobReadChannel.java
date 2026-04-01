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

import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.ReadChannel;
import com.google.cloud.RestorableState;
import com.google.cloud.storage.BlobReadChannelV2.BlobReadChannelContext;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Objects;

/**
 * Hierarchy retained for {@link RestorableState#restore()}. Will be removed in next major version!
 */
@Deprecated
class BlobReadChannel implements ReadChannel {

  private BlobReadChannel() {}

  @Override
  public RestorableState<ReadChannel> capture() {
    throw new IllegalStateException("Illegal method access");
  }

  @Override
  public boolean isOpen() {
    throw new IllegalStateException("Illegal method access");
  }

  @Override
  public void close() {
    throw new IllegalStateException("Illegal method access");
  }

  @Override
  public void seek(long position) throws IOException {
    throw new IllegalStateException("Illegal method access");
  }

  @Override
  public void setChunkSize(int chunkSize) {
    throw new IllegalStateException("Illegal method access");
  }

  @Override
  public int read(ByteBuffer byteBuffer) throws IOException {
    throw new IllegalStateException("Illegal method access");
  }

  @Override
  public ReadChannel limit(long limit) {
    throw new IllegalStateException("Illegal method access");
  }

  @Override
  public long limit() {
    throw new IllegalStateException("Illegal method access");
  }

  /** Retained for binary compatibility. Will be removed at next major version! */
  @SuppressWarnings("unused")
  @Deprecated
  @VisibleForTesting
  static class StateImpl implements RestorableState<ReadChannel>, Serializable {

    private static final long serialVersionUID = 7784852608213694645L;

    // the following fields are dangling as they are only set via object deserialization, and only
    // read in #restore()
    private HttpStorageOptions serviceOptions;
    private BlobId blob;
    private Map<StorageRpc.Option, ?> requestOptions;
    private String lastEtag;
    private long position;
    private boolean isOpen;
    private boolean endOfStream;
    private int chunkSize;
    private long limit;

    private StateImpl() {}

    @Override
    public ReadChannel restore() {
      StorageObject encode = Conversions.json().blobId().encode(blob);
      BlobReadChannelV2 channel =
          new BlobReadChannelV2(
              encode, requestOptions, BlobReadChannelContext.from(serviceOptions));
      try {
        channel.seek(position);
        channel.limit(limit);
        channel.setChunkSize(chunkSize);
        if (!isOpen) {
          channel.close();
        }
      } catch (IOException e) {
        throw StorageException.coalesce(e);
      }
      return channel;
    }

    @Override
    public int hashCode() {
      return Objects.hash(
          serviceOptions,
          blob,
          requestOptions,
          lastEtag,
          position,
          isOpen,
          endOfStream,
          chunkSize,
          limit);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      if (!(obj instanceof StateImpl)) {
        return false;
      }
      final StateImpl other = (StateImpl) obj;
      return Objects.equals(this.serviceOptions, other.serviceOptions)
          && Objects.equals(this.blob, other.blob)
          && Objects.equals(this.requestOptions, other.requestOptions)
          && Objects.equals(this.lastEtag, other.lastEtag)
          && this.position == other.position
          && this.isOpen == other.isOpen
          && this.endOfStream == other.endOfStream
          && this.chunkSize == other.chunkSize
          && this.limit == other.limit;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("blob", blob)
          .add("position", position)
          .add("isOpen", isOpen)
          .add("endOfStream", endOfStream)
          .add("limit", limit)
          .toString();
    }
  }
}
