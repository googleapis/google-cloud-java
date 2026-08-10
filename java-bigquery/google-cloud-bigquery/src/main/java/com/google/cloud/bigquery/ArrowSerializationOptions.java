/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery;

import com.google.api.core.BetaApi;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Objects;

/** <b>[Beta]</b> Options specific to the Apache Arrow output format. */
@BetaApi
public final class ArrowSerializationOptions implements Serializable {

  private static final long serialVersionUID = 1L;

  private final String bufferCompression;
  private final String picosTimestampPrecision;

  private ArrowSerializationOptions(Builder builder) {
    this.bufferCompression = builder.bufferCompression;
    this.picosTimestampPrecision = builder.picosTimestampPrecision;
  }

  /**
   * <b>[Beta]</b> Returns the buffer compression algorithm (e.g., LZ4_FRAME, ZSTD, UNCOMPRESSED).
   */
  @BetaApi
  public String getBufferCompression() {
    return bufferCompression;
  }

  /** <b>[Beta]</b> Returns the timestamp precision for Arrow timestamp types. */
  @BetaApi
  public String getPicosTimestampPrecision() {
    return picosTimestampPrecision;
  }

  /** <b>[Beta]</b> Returns a new builder for {@link ArrowSerializationOptions}. */
  @BetaApi
  public static Builder newBuilder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("bufferCompression", bufferCompression)
        .add("picosTimestampPrecision", picosTimestampPrecision)
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArrowSerializationOptions that = (ArrowSerializationOptions) o;
    return Objects.equals(bufferCompression, that.bufferCompression)
        && Objects.equals(picosTimestampPrecision, that.picosTimestampPrecision);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bufferCompression, picosTimestampPrecision);
  }

  com.google.api.services.bigquery.model.ArrowSerializationOptions toPb() {
    return ArrowSerializationOptionsConverter.toPb(this);
  }

  static ArrowSerializationOptions fromPb(
      com.google.api.services.bigquery.model.ArrowSerializationOptions optionsPb) {
    return ArrowSerializationOptionsConverter.fromPb(optionsPb);
  }

  /** <b>[Beta]</b> Builder for {@link ArrowSerializationOptions}. */
  @BetaApi
  public static final class Builder {
    private String bufferCompression;
    private String picosTimestampPrecision;

    private Builder() {}

    /**
     * <b>[Beta]</b> Sets the buffer compression algorithm (e.g., LZ4_FRAME, ZSTD, UNCOMPRESSED).
     */
    @BetaApi
    public Builder setBufferCompression(String bufferCompression) {
      this.bufferCompression = bufferCompression;
      return this;
    }

    /** <b>[Beta]</b> Sets the timestamp precision for Arrow timestamp types. */
    @BetaApi
    public Builder setPicosTimestampPrecision(String picosTimestampPrecision) {
      this.picosTimestampPrecision = picosTimestampPrecision;
      return this;
    }

    /** <b>[Beta]</b> Builds a new instance of {@link ArrowSerializationOptions}. */
    @BetaApi
    public ArrowSerializationOptions build() {
      return new ArrowSerializationOptions(this);
    }
  }
}
