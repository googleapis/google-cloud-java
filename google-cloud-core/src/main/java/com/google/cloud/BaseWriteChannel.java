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

import com.google.api.core.InternalApi;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Base implementation for a {@link WriteChannel}.
 *
 * @param <ServiceOptionsT> the service options used by the channel to issue RPC requests
 * @param <EntityT> the entity this channel writes data to. Possibly with additional configuration
 */
public abstract class BaseWriteChannel<
    ServiceOptionsT extends ServiceOptions<?, ServiceOptionsT>,
    EntityT extends Serializable> implements WriteChannel {

  private static final int MIN_CHUNK_SIZE = 256 * 1024;
  private static final int DEFAULT_CHUNK_SIZE = 8 * MIN_CHUNK_SIZE;

  private final ServiceOptionsT options;
  private final EntityT entity;
  private final String uploadId;
  private long position;
  private byte[] buffer = new byte[0];
  private int limit;
  private boolean isOpen = true;
  private int chunkSize = getDefaultChunkSize();


  protected int getMinChunkSize() {
    return MIN_CHUNK_SIZE;
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


  protected ServiceOptionsT getOptions() {
    return options;
  }


  protected EntityT getEntity() {
    return entity;
  }


  protected String getUploadId() {
    return uploadId;
  }


  protected long getPosition() {
    return position;
  }


  protected byte[] getBuffer() {
    return buffer;
  }


  protected int getLimit() {
    return limit;
  }


  protected int getChunkSize() {
    return chunkSize;
  }


  @Override
  public final void setChunkSize(int chunkSize) {
    chunkSize = (chunkSize / getMinChunkSize()) * getMinChunkSize();
    this.chunkSize = Math.max(getMinChunkSize(), chunkSize);
  }

  @InternalApi("This class should only be extended within google-cloud-java")
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
      ServiceOptionsT extends ServiceOptions<?, ServiceOptionsT>, EntityT extends Serializable>
      implements RestorableState<WriteChannel>, Serializable {

    private static final long serialVersionUID = 8541062465055125619L;

    protected final ServiceOptionsT serviceOptions;
    protected final EntityT entity;
    protected final String uploadId;
    protected final long position;
    protected final byte[] buffer;
    protected final boolean isOpen;
    protected final int chunkSize;

    @InternalApi("This class should only be extended within google-cloud-java")
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
        ServiceOptionsT extends ServiceOptions<?, ServiceOptionsT>,
        EntityT extends Serializable> {
      private final ServiceOptionsT serviceOptions;
      private final EntityT entity;
      private final String uploadId;
      private long position;
      private byte[] buffer;
      private boolean isOpen;
      private int chunkSize;

      @InternalApi("This class should only be extended within google-cloud-java")
      protected Builder(ServiceOptionsT options, EntityT entity, String uploadId) {
        this.serviceOptions = options;
        this.entity = entity;
        this.uploadId = uploadId;
      }


      public Builder<ServiceOptionsT, EntityT> setPosition(long position) {
        this.position = position;
        return this;
      }


      public Builder<ServiceOptionsT, EntityT> setBuffer(byte[] buffer) {
        this.buffer = buffer;
        return this;
      }


      public Builder<ServiceOptionsT, EntityT> setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
        return this;
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

    protected static final class ValueHolder {
      final String name;
      final Object value;

      private ValueHolder(String name, Object value) {
        this.name = name;
        this.value = value;
      }

      public static ValueHolder create(String name, Object value) {
        return new ValueHolder(name, value);
      }

      @Override
      public String toString() {
        String result = name + "=";
        if (value != null && value.getClass().isArray()) {
          Object[] objectArray = new Object[]{value};
          String arrayString = Arrays.deepToString(objectArray);
          result += arrayString.substring(1, arrayString.length() - 1);
        } else {
          result += value;
        }
        return result;
      }
    }

    protected List<ValueHolder> toStringHelper() {
      List<ValueHolder> valueList = new ArrayList<>();
      valueList.add(ValueHolder.create("entity", entity));
      valueList.add(ValueHolder.create("uploadId", uploadId));
      valueList.add(ValueHolder.create("position", String.valueOf(position)));
      valueList.add(ValueHolder.create("isOpen", String.valueOf(isOpen)));
      return valueList;
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append(getClass().getSimpleName())
          .append('{');
      String nextSeparator = "";
      for (ValueHolder valueHolder : toStringHelper()) {
        builder.append(nextSeparator).append(valueHolder);
        nextSeparator = ", ";
      }
      builder.append('}');
      return builder.toString();
    }
  }
}
