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

import com.google.api.services.storage.model.StorageObject;
import com.google.common.base.MoreObjects;
import com.google.gcloud.RetryHelper;
import com.google.gcloud.spi.StorageRpc;

import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * Default implementation for BlobReadChannel.
 */
class BlobReadChannelImpl implements BlobReadChannel {

  private static final int DEFAULT_CHUNK_SIZE = 2 * 1024 * 1024;

  private final StorageOptions serviceOptions;
  private final BlobId blob;
  private final Map<StorageRpc.Option, ?> requestOptions;
  private int position;
  private boolean isOpen;
  private boolean endOfStream;
  private int chunkSize = DEFAULT_CHUNK_SIZE;

  private StorageRpc storageRpc;
  private StorageObject storageObject;
  private int bufferPos;
  private byte[] buffer;

  BlobReadChannelImpl(StorageOptions serviceOptions, BlobId blob,
      Map<StorageRpc.Option, ?> requestOptions) {
    this.serviceOptions = serviceOptions;
    this.blob = blob;
    this.requestOptions = requestOptions;
    isOpen = true;
    initTransients();
  }

  @Override
  public State save() {
    StateImpl.Builder builder = StateImpl.builder(serviceOptions, blob, requestOptions)
        .position(position)
        .isOpen(isOpen)
        .endOfStream(endOfStream)
        .chunkSize(chunkSize);
    if (buffer != null) {
      builder.position(position + bufferPos);
      builder.endOfStream(false);
    }
    return builder.build();
  }

  private void initTransients() {
    storageRpc = serviceOptions.storageRpc();
    storageObject = blob.toPb();
  }

  @Override
  public boolean isOpen() {
    return isOpen;
  }

  @Override
  public void close() {
    if (isOpen) {
      buffer = null;
      isOpen = false;
    }
  }

  private void validateOpen() throws IOException {
    if (!isOpen) {
      throw new IOException("stream is closed");
    }
  }

  @Override
  public void seek(int position) throws IOException {
    validateOpen();
    this.position = position;
    buffer = null;
    bufferPos = 0;
    endOfStream = false;
  }

  @Override
  public void chunkSize(int chunkSize) {
    this.chunkSize = chunkSize <= 0 ? DEFAULT_CHUNK_SIZE : chunkSize;
  }

  @Override
  public int read(ByteBuffer byteBuffer) throws IOException {
    validateOpen();
    if (buffer == null) {
      if (endOfStream) {
        return -1;
      }
      final int toRead = Math.max(byteBuffer.remaining(), chunkSize);
      try {
        buffer = runWithRetries(new Callable<byte[]>() {
          @Override
          public byte[] call() {
            return storageRpc.read(storageObject, requestOptions, position, toRead);
          }
        }, serviceOptions.retryParams(), StorageImpl.EXCEPTION_HANDLER);
      } catch (RetryHelper.RetryHelperException e) {
        throw StorageException.translateAndThrow(e);
      }
      if (toRead > buffer.length) {
        endOfStream = true;
        if (buffer.length == 0) {
          buffer = null;
          return -1;
        }
      }
    }
    int toWrite = Math.min(buffer.length - bufferPos, byteBuffer.remaining());
    byteBuffer.put(buffer, bufferPos, toWrite);
    bufferPos += toWrite;
    if (bufferPos >= buffer.length) {
      position += buffer.length;
      buffer = null;
      bufferPos = 0;
    }
    return toWrite;
  }

  static class StateImpl implements BlobReadChannel.State, Serializable {

    private static final long serialVersionUID = 3889420316004453706L;

    private final StorageOptions serviceOptions;
    private final BlobId blob;
    private final Map<StorageRpc.Option, ?> requestOptions;
    private final int position;
    private final boolean isOpen;
    private final boolean endOfStream;
    private final int chunkSize;

    StateImpl(Builder builder) {
      this.serviceOptions = builder.serviceOptions;
      this.blob = builder.blob;
      this.requestOptions = builder.requestOptions;
      this.position = builder.position;
      this.isOpen = builder.isOpen;
      this.endOfStream = builder.endOfStream;
      this.chunkSize = builder.chunkSize;
    }

    public static class Builder {
      private final StorageOptions serviceOptions;
      private final BlobId blob;
      private final Map<StorageRpc.Option, ?> requestOptions;
      private int position;
      private boolean isOpen;
      private boolean endOfStream;
      private int chunkSize;

      private Builder(StorageOptions options, BlobId blob, Map<StorageRpc.Option, ?> reqOptions) {
        this.serviceOptions = options;
        this.blob = blob;
        this.requestOptions = reqOptions;
      }

      public Builder position(int position) {
        this.position = position;
        return this;
      }

      public Builder isOpen(boolean isOpen) {
        this.isOpen = isOpen;
        return this;
      }

      public Builder endOfStream(boolean endOfStream) {
        this.endOfStream = endOfStream;
        return this;
      }

      public Builder chunkSize(int chunkSize) {
        this.chunkSize = chunkSize;
        return this;
      }

      public State build() {
        return new StateImpl(this);
      }
    }

    public static Builder builder(
        StorageOptions options, BlobId blob, Map<StorageRpc.Option, ?> reqOptions) {
      return new Builder(options, blob, reqOptions);
    }

    @Override
    public BlobReadChannel restore() {
      BlobReadChannelImpl channel = new BlobReadChannelImpl(serviceOptions, blob, requestOptions);
      channel.position = position;
      channel.isOpen = isOpen;
      channel.endOfStream = endOfStream;
      channel.chunkSize = chunkSize;
      return channel;
    }

    @Override
    public int hashCode() {
      return Objects.hash(serviceOptions, blob, requestOptions, position, isOpen, endOfStream,
          chunkSize);
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
          Objects.equals(this.blob, other.blob) &&
          Objects.equals(this.requestOptions, other.requestOptions) &&
          this.position == other.position &&
          this.isOpen == other.isOpen &&
          this.endOfStream == other.endOfStream &&
          this.chunkSize == other.chunkSize;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("blob", blob)
          .add("position", position)
          .add("isOpen", isOpen)
          .add("endOfStream", endOfStream)
          .toString();
    }
  }
}
