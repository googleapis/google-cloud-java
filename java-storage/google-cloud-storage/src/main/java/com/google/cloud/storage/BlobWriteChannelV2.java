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

import com.google.api.core.ApiFutures;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.RestorableState;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.BlobReadChannelV2.BlobReadChannelContext;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;

final class BlobWriteChannelV2 extends BaseStorageWriteChannel<StorageObject> {

  private final BlobReadChannelContext blobChannelContext;
  private final JsonResumableWrite start;

  BlobWriteChannelV2(BlobReadChannelContext blobChannelContext, JsonResumableWrite start) {
    super(Conversions.json().blobInfo());
    this.start = start;
    this.blobChannelContext = blobChannelContext;
  }

  @Override
  public RestorableState<WriteChannel> capture() {
    lock.lock();
    try {
      final byte[] bufferSnapshot;
      BufferHandle handle = getBufferHandle();
      if (handle.position() > 0) {
        ByteBuffer byteBuffer = handle.get();
        // duplicate so we don't actually modify the existing instance
        ByteBuffer dup = byteBuffer.duplicate();
        dup.flip();
        int remaining = dup.remaining();
        bufferSnapshot = new byte[remaining];
        dup.get(bufferSnapshot);
      } else {
        bufferSnapshot = new byte[0];
      }
      return new BlobWriteChannelV2State(
          blobChannelContext.getStorageOptions(),
          start,
          getCommittedPosition(),
          isOpen(),
          getChunkSize(),
          bufferSnapshot);
    } finally {
      lock.unlock();
    }
  }

  @Override
  protected LazyWriteChannel<StorageObject> newLazyWriteChannel() {
    return new LazyWriteChannel<>(
        () ->
            ResumableMedia.http()
                .write()
                .byteChannel(blobChannelContext.getHttpClientContext())
                .resumable()
                .setCommittedBytesCallback(this::setCommittedPosition)
                .withRetryConfig(
                    blobChannelContext
                        .getRetrier()
                        .withAlg(blobChannelContext.getRetryAlgorithmManager().idempotent()))
                .setHasher(start.getHasher())
                .buffered(getBufferHandle())
                .setStartAsync(ApiFutures.immediateFuture(start))
                .build());
  }

  static final class BlobWriteChannelV2State
      implements RestorableState<WriteChannel>, Serializable {

    private static final long serialVersionUID = -1901664719924133474L;

    private final HttpStorageOptions options;
    private final JsonResumableWrite resumableWrite;

    private final Long position;
    private final Boolean isOpen;
    private final Integer chunkSize;
    private final byte[] bufferSnapshot;

    BlobWriteChannelV2State(
        HttpStorageOptions options,
        JsonResumableWrite resumableWrite,
        Long position,
        Boolean isOpen,
        Integer chunkSize,
        byte[] bufferSnapshot) {
      this.options = options;
      this.resumableWrite = resumableWrite;
      this.position = position;
      this.isOpen = isOpen;
      this.chunkSize = chunkSize;
      this.bufferSnapshot = bufferSnapshot;
    }

    @Override
    public WriteChannel restore() {
      JsonResumableWrite resumableWrite = this.resumableWrite;
      if (position != null) {
        resumableWrite = resumableWrite.withBeginOffset(position);
      }
      BlobWriteChannelV2 channel =
          new BlobWriteChannelV2(BlobReadChannelContext.from(options), resumableWrite);
      if (chunkSize != null) {
        channel.setChunkSize(chunkSize);
      }
      if (bufferSnapshot != null && bufferSnapshot.length > 0) {
        BufferHandle handle = channel.getBufferHandle();
        ByteBuffer byteBuffer = handle.get();
        byteBuffer.put(bufferSnapshot);
      }
      if (position != null) {
        channel.setCommittedPosition(position);
      }
      if (isOpen != null) {
        channel.setOpen(isOpen);
      }
      return channel;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof BlobWriteChannelV2State)) {
        return false;
      }
      BlobWriteChannelV2State that = (BlobWriteChannelV2State) o;
      return Objects.equals(options, that.options)
          && Objects.equals(resumableWrite, that.resumableWrite)
          && Objects.equals(position, that.position)
          && Objects.equals(isOpen, that.isOpen)
          && Objects.equals(chunkSize, that.chunkSize)
          && Arrays.equals(bufferSnapshot, that.bufferSnapshot);
    }

    @Override
    public int hashCode() {
      int result = Objects.hash(options, resumableWrite, position, isOpen, chunkSize);
      result = 31 * result + Arrays.hashCode(bufferSnapshot);
      return result;
    }
  }
}
