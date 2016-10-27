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

package com.google.cloud;

import com.google.common.base.MoreObjects;

import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.Objects;

/**
 * Base implementation for a {@link WriteChannel}.
 *
 * @param <ServiceOptionsT> the service options used by the channel to issue RPC requests
 * @param <EntityT> the entity this channel writes data to. Possibly with additional configuration
 */
public abstract class BaseWriteChannel<
    ServiceOptionsT extends ServiceOptions<?, ?, ServiceOptionsT>,
    EntityT extends Serializable> implements WriteChannel {

  private static final int MIN_CHUNK_SIZE = 256 * 1024;
  private static final int DEFAULT_CHUNK_SIZE = 8 * MIN_CHUNK_SIZE;

  private final ServiceOptionsT options;
  private final EntityT entity;
  private final String uploadId;
  private int position;
  private byte[] buffer = new byte[0];
  private int limit;
  private boolean isOpen = true;
  private int chunkSize = getDefaultChunkSize();

  @Deprecated
  protected int minChunkSize() {
    return getMinChunkSize();
  }

  protected int getMinChunkSize() {
    return MIN_CHUNK_SIZE;
  }

  @Deprecated
  protected int defaultChunkSize() {
    return getDefaultChunkSize();
  }

  protected int getDefaultChunkSize() {
    return DEFAULT_CHUNK_SIZE;
  }

  /**
   * Writes {@code length} bytes of {@link #getBuffer()} to the {@link #getUploadId()} URL.
   *
   * @param length the number of bytes to write from {@link #getBuffer()}
   * @param last if {@code true} the resumable session is closed
   */
  protected abstract void flushBuffer(int length, boolean last);

  @Deprecated
  protected ServiceOptionsT options() {
    return options;
  }

  protected ServiceOptionsT getOptions() {
    return options;
  }

  @Deprecated
  protected EntityT entity() {
    return getEntity();
  }

  protected EntityT getEntity() {
    return entity;
  }

  @Deprecated
  protected String uploadId() {
    return getUploadId();
  }

  protected String getUploadId() {
    return uploadId;
  }

  @Deprecated
  protected int position() {
    return getPosition();
  }

  protected int getPosition() {
    return position;
  }

  @Deprecated
  protected byte[] buffer() {
    return getBuffer();
  }

  protected byte[] getBuffer() {
    return buffer;
  }

  @Deprecated
  protected int limit() {
    return getLimit();
  }

  protected int getLimit() {
    return limit;
  }

  @Deprecated
  protected int chunkSize() {
    return getChunkSize();
  }

  protected int getChunkSize() {
    return chunkSize;
  }

  @Override
  @Deprecated
  public final void chunkSize(int chunkSize) {
    setChunkSize(chunkSize);
  }

  @Override
  public final void setChunkSize(int chunkSize) {
    chunkSize = (chunkSize / getMinChunkSize()) * getMinChunkSize();
    this.chunkSize = Math.max(getMinChunkSize(), chunkSize);
  }

  protected BaseWriteChannel(ServiceOptionsT options, EntityT entity, String uploadId) {
    this.options = options;
    this.entity = entity;
    this.uploadId = uploadId;
  }

  private void flush() {
    if (limit >= chunkSize) {
      final int length = limit - limit % getMinChunkSize();
      flushBuffer(length, false);
      position += length;
      limit -= length;
      byte[] temp = new byte[chunkSize];
      System.arraycopy(buffer, length, temp, 0, limit);
      buffer = temp;
    }
  }

  private void validateOpen() throws ClosedChannelException {
    if (!isOpen) {
      throw new ClosedChannelException();
    }
  }

  @Override
  public final int write(ByteBuffer byteBuffer) throws IOException {
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
  public final void close() throws IOException {
    if (isOpen) {
      flushBuffer(limit, true);
      position += buffer.length;
      isOpen = false;
      buffer = null;
    }
  }

  /**
   * Creates a {@link BaseState.Builder} for the current write channel.
   */
  protected abstract BaseState.Builder<ServiceOptionsT, EntityT> stateBuilder();

  @Override
  public RestorableState<WriteChannel> capture() {
    byte[] bufferToSave = null;
    if (isOpen) {
      flush();
      bufferToSave = Arrays.copyOf(buffer, limit);
    }
    return stateBuilder()
        .setPosition(position)
        .setBuffer(bufferToSave)
        .setIsOpen(isOpen)
        .setChunkSize(chunkSize)
        .build();
  }

  /**
   * Restores the state of the current write channel given a {@link BaseState} object.
   */
  protected void restore(BaseState state) {
    if (state.buffer != null) {
      this.buffer = state.buffer.clone();
      this.limit = state.buffer.length;
    }
    this.position = state.position;
    this.isOpen = state.isOpen;
    this.chunkSize = state.chunkSize;
  }

  protected abstract static class BaseState<
      ServiceOptionsT extends ServiceOptions<?, ?, ServiceOptionsT>, EntityT extends Serializable>
      implements RestorableState<WriteChannel>, Serializable {

    private static final long serialVersionUID = 8541062465055125619L;

    protected final ServiceOptionsT serviceOptions;
    protected final EntityT entity;
    protected final String uploadId;
    protected final int position;
    protected final byte[] buffer;
    protected final boolean isOpen;
    protected final int chunkSize;

    protected BaseState(Builder<ServiceOptionsT, EntityT> builder) {
      this.serviceOptions = builder.serviceOptions;
      this.entity = builder.entity;
      this.uploadId = builder.uploadId;
      this.position = builder.position;
      this.buffer = builder.buffer;
      this.isOpen = builder.isOpen;
      this.chunkSize = builder.chunkSize;
    }

    /**
     * Base builder for a write channel's state. Users are not supposed to access this class
     * directly.
     *
     * @param <ServiceOptionsT> the service options used by the channel to issue RPC requests
     * @param <EntityT> the entity this channel writes data to. Possibly with additional
     *     configuration
     */
    public abstract static class Builder<
        ServiceOptionsT extends ServiceOptions<?, ?, ServiceOptionsT>,
        EntityT extends Serializable> {
      private final ServiceOptionsT serviceOptions;
      private final EntityT entity;
      private final String uploadId;
      private int position;
      private byte[] buffer;
      private boolean isOpen;
      private int chunkSize;

      protected Builder(ServiceOptionsT options, EntityT entity, String uploadId) {
        this.serviceOptions = options;
        this.entity = entity;
        this.uploadId = uploadId;
      }

      @Deprecated
      public Builder<ServiceOptionsT, EntityT> position(int position) {
        return setPosition(position);
      }

      public Builder<ServiceOptionsT, EntityT> setPosition(int position) {
        this.position = position;
        return this;
      }

      @Deprecated
      public Builder<ServiceOptionsT, EntityT> buffer(byte[] buffer) {
        return setBuffer(buffer);
      }

      public Builder<ServiceOptionsT, EntityT> setBuffer(byte[] buffer) {
        this.buffer = buffer;
        return this;
      }

      @Deprecated
      public Builder<ServiceOptionsT, EntityT> isOpen(boolean isOpen) {
        return setIsOpen(isOpen);
      }

      public Builder<ServiceOptionsT, EntityT> setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
        return this;
      }

      @Deprecated
      public Builder<ServiceOptionsT, EntityT> chunkSize(int chunkSize) {
        return setChunkSize(chunkSize);
      }

      public Builder<ServiceOptionsT, EntityT> setChunkSize(int chunkSize) {
        this.chunkSize = chunkSize;
        return this;
      }

      public abstract RestorableState<WriteChannel> build();
    }

    @Override
    public int hashCode() {
      return Objects.hash(serviceOptions, entity, uploadId, position, isOpen, chunkSize,
          Arrays.hashCode(buffer));
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      if (!(obj instanceof BaseState)) {
        return false;
      }
      final BaseState other = (BaseState) obj;
      return Objects.equals(this.serviceOptions, other.serviceOptions)
          && Objects.equals(this.entity, other.entity)
          && Objects.equals(this.uploadId, other.uploadId)
          && Objects.deepEquals(this.buffer, other.buffer)
          && this.position == other.position
          && this.isOpen == other.isOpen
          && this.chunkSize == other.chunkSize;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("entity", entity)
          .add("uploadId", uploadId)
          .add("position", position)
          .add("isOpen", isOpen)
          .toString();
    }
  }
}
