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

import com.google.api.services.storage.model.StorageObject;
import com.google.common.base.MoreObjects;
import com.google.gcloud.RestorableState;
import com.google.gcloud.RetryHelper;
import com.google.gcloud.spi.StorageRpc;

import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * Default implementation for BlobWriteChannel.
 */
class BlobWriteChannelImpl implements BlobWriteChannel {

  private static final long serialVersionUID = 8675286882724938737L;
  private static final int MIN_CHUNK_SIZE = 256 * 1024;
  private static final int DEFAULT_CHUNK_SIZE = 8 * MIN_CHUNK_SIZE;

  private final StorageOptions options;
  private final BlobInfo blobInfo;
  private final String uploadId;
  private int position;
  private byte[] buffer = new byte[0];
  private int limit;
  private boolean isOpen = true;
  private int chunkSize = DEFAULT_CHUNK_SIZE;

  private final StorageRpc storageRpc;
  private final StorageObject storageObject;

  BlobWriteChannelImpl(StorageOptions options, BlobInfo blobInfo,
      Map<StorageRpc.Option, ?> optionsMap) {
    this.options = options;
    this.blobInfo = blobInfo;
    storageRpc = options.storageRpc();
    storageObject = blobInfo.toPb();
    uploadId = storageRpc.open(storageObject, optionsMap);
  }

  BlobWriteChannelImpl(StorageOptions options, BlobInfo blobInfo, String uploadId) {
    this.options = options;
    this.blobInfo = blobInfo;
    this.uploadId = uploadId;
    storageRpc = options.storageRpc();
    storageObject = blobInfo.toPb();
  }

  @Override
  public RestorableState<BlobWriteChannel> save() {
    if (isOpen) {
      flush();
    }
    return StateImpl.builder(options, blobInfo, uploadId)
        .position(position)
        .buffer(Arrays.copyOf(buffer, limit))
        .isOpen(isOpen)
        .chunkSize(chunkSize).build();
  }

  private void flush() {
    if (limit >= chunkSize) {
      final int length = limit - limit % MIN_CHUNK_SIZE;
      try {
        runWithRetries(callable(new Runnable() {
          @Override
          public void run() {
            storageRpc.write(uploadId, buffer, 0, storageObject, position, length, false);
          }
        }), options.retryParams(), StorageImpl.EXCEPTION_HANDLER);
      } catch (RetryHelper.RetryHelperException e) {
        throw StorageException.translateAndThrow(e);
      }
      position += length;
      limit -= length;
      byte[] temp = new byte[chunkSize];
      System.arraycopy(buffer, length, temp, 0, limit);
      buffer = temp;
    }
  }

  private void validateOpen() throws IOException {
    if (!isOpen) {
      throw new IOException("stream is closed");
    }
  }

  @Override
  public int write(ByteBuffer byteBuffer) throws IOException {
    validateOpen();
    int toWrite = byteBuffer.remaining();
    int spaceInBuffer = buffer.length - limit;
    if (spaceInBuffer >= toWrite) {
      byteBuffer.get(buffer, limit, toWrite);
    } else {
      buffer = Arrays.copyOf(buffer, Math.max(chunkSize, buffer.length + toWrite - spaceInBuffer));
      byteBuffer.get(buffer, limit, toWrite);
    }
    limit += toWrite;
    flush();
    return toWrite;
  }

  @Override
  public boolean isOpen() {
    return isOpen;
  }

  @Override
  public void close() throws IOException {
    if (isOpen) {
      try {
        runWithRetries(callable(new Runnable() {
          @Override
          public void run() {
            storageRpc.write(uploadId, buffer, 0, storageObject, position, limit, true);
          }
        }), options.retryParams(), StorageImpl.EXCEPTION_HANDLER);
      } catch (RetryHelper.RetryHelperException e) {
        throw StorageException.translateAndThrow(e);
      }
      position += buffer.length;
      isOpen = false;
      buffer = null;
    }
  }

  @Override
  public void chunkSize(int chunkSize) {
    chunkSize = (chunkSize / MIN_CHUNK_SIZE) * MIN_CHUNK_SIZE;
    this.chunkSize = Math.max(MIN_CHUNK_SIZE, chunkSize);
  }

  static class StateImpl implements RestorableState<BlobWriteChannel>, Serializable {

    private static final long serialVersionUID = 8541062465055125619L;

    private final StorageOptions serviceOptions;
    private final BlobInfo blobInfo;
    private final String uploadId;
    private final int position;
    private final byte[] buffer;
    private final int limit;
    private final boolean isOpen;
    private final int chunkSize;

    StateImpl(Builder builder) {
      this.serviceOptions = builder.serviceOptions;
      this.blobInfo = builder.blobInfo;
      this.uploadId = builder.uploadId;
      this.position = builder.position;
      this.buffer = builder.buffer;
      this.limit = this.buffer.length;
      this.isOpen = builder.isOpen;
      this.chunkSize = builder.chunkSize;
    }

    static class Builder {
      private final StorageOptions serviceOptions;
      private final BlobInfo blobInfo;
      private final String uploadId;
      private int position;
      private byte[] buffer;
      private int limit;
      private boolean isOpen;
      private int chunkSize;

      private Builder(StorageOptions options, BlobInfo blobInfo, String uploadId) {
        this.serviceOptions = options;
        this.blobInfo = blobInfo;
        this.uploadId = uploadId;
      }

      Builder position(int position) {
        this.position = position;
        return this;
      }

      Builder buffer(byte[] buffer) {
        this.buffer = buffer;
        return this;
      }

      Builder isOpen(boolean isOpen) {
        this.isOpen = isOpen;
        return this;
      }

      Builder chunkSize(int chunkSize) {
        this.chunkSize = chunkSize;
        return this;
      }

      RestorableState<BlobWriteChannel> build() {
        return new StateImpl(this);
      }
    }

    static Builder builder(StorageOptions options, BlobInfo blobInfo, String uploadId) {
      return new Builder(options, blobInfo, uploadId);
    }

    @Override
    public BlobWriteChannel restore() {
      BlobWriteChannelImpl channel = new BlobWriteChannelImpl(serviceOptions, blobInfo, uploadId);
      channel.position = position;
      channel.buffer = buffer.clone();
      channel.limit = limit;
      channel.isOpen = isOpen;
      channel.chunkSize = chunkSize;
      return channel;
    }

    @Override
    public int hashCode() {
      return Objects.hash(serviceOptions, blobInfo, uploadId, position, limit, isOpen, chunkSize,
          Arrays.hashCode(buffer));
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
      return Objects.equals(this.serviceOptions, other.serviceOptions) &&
          Objects.equals(this.blobInfo, other.blobInfo) &&
          Objects.equals(this.uploadId, other.uploadId) &&
          Objects.deepEquals(this.buffer, other.buffer) &&
          this.position == other.position &&
          this.limit == other.limit &&
          this.isOpen == other.isOpen &&
          this.chunkSize == other.chunkSize;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("blobInfo", blobInfo)
          .add("uploadId", uploadId)
          .add("position", position)
          .add("isOpen", isOpen)
          .toString();
    }
  }
}
