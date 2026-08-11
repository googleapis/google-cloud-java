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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.BetaApi;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Objects;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/** <b>[Beta]</b> Options specific to the Apache Arrow output format. */
@BetaApi
@NullMarked
public final class ArrowSerializationOptions implements Serializable {

  private static final long serialVersionUID = 1L;

  /** <b>[Beta]</b> Buffer compression codec for Apache Arrow record batches. */
  @BetaApi
  public enum CompressionCodec {
    UNCOMPRESSED("UNCOMPRESSED"),
    LZ4_FRAME("LZ4_FRAME"),
    ZSTD("ZSTD");

    private final String value;

    CompressionCodec(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return value;
    }
  }

  /** <b>[Beta]</b> Timestamp precision for Apache Arrow timestamp types. */
  @BetaApi
  public enum TimestampPrecision {
    PRECISION_MILLIS("PRECISION_MILLIS"),
    PRECISION_MICROS("PRECISION_MICROS"),
    PRECISION_NANOS("PRECISION_NANOS"),
    PRECISION_PICOS("PRECISION_PICOS");

    private final String value;

    TimestampPrecision(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return value;
    }
  }

  private final CompressionCodec bufferCompression;
  private final TimestampPrecision picosTimestampPrecision;

  private ArrowSerializationOptions(Builder builder) {
    this.bufferCompression = builder.bufferCompression;
    this.picosTimestampPrecision = builder.picosTimestampPrecision;
  }

  /**
   * <b>[Beta]</b> Returns the buffer compression algorithm (e.g., LZ4_FRAME, ZSTD, UNCOMPRESSED).
   * Defaults to {@link CompressionCodec#UNCOMPRESSED}.
   */
  @BetaApi
  public CompressionCodec getBufferCompression() {
    return bufferCompression;
  }

  /**
   * <b>[Beta]</b> Returns the timestamp precision for Arrow timestamp types. Defaults to {@link
   * TimestampPrecision#PRECISION_MICROS}.
   *
   * <p>Note: Only applies when {@link QueryResultsFormat#ARROW} is enabled. For Arrow result
   * streams, this precision setting governs binary Arrow timestamp column types and takes
   * precedence over {@link DataFormatOptions.TimestampFormatOptions}, which applies to default
   * {@link QueryResultsFormat#STRUCT_ENCODING} JSON results.
   */
  @BetaApi
  public TimestampPrecision getPicosTimestampPrecision() {
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
  public boolean equals(@Nullable Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArrowSerializationOptions that = (ArrowSerializationOptions) o;
    return bufferCompression == that.bufferCompression
        && picosTimestampPrecision == that.picosTimestampPrecision;
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
    private CompressionCodec bufferCompression = CompressionCodec.UNCOMPRESSED;
    private TimestampPrecision picosTimestampPrecision = TimestampPrecision.PRECISION_MICROS;

    private Builder() {}

    /**
     * <b>[Beta]</b> Sets the buffer compression algorithm (e.g., LZ4_FRAME, ZSTD, UNCOMPRESSED).
     */
    @BetaApi
    public Builder setBufferCompression(CompressionCodec bufferCompression) {
      this.bufferCompression = checkNotNull(bufferCompression, "bufferCompression cannot be null");
      return this;
    }

    /**
     * <b>[Beta]</b> Sets the timestamp precision for Arrow timestamp types.
     *
     * <p>Note: Only applies when {@link QueryResultsFormat#ARROW} is enabled. For Arrow result
     * streams, this precision setting governs binary Arrow timestamp column types and takes
     * precedence over {@link DataFormatOptions.TimestampFormatOptions}, which applies to default
     * {@link QueryResultsFormat#STRUCT_ENCODING} JSON results.
     */
    @BetaApi
    public Builder setPicosTimestampPrecision(TimestampPrecision picosTimestampPrecision) {
      this.picosTimestampPrecision =
          checkNotNull(picosTimestampPrecision, "picosTimestampPrecision cannot be null");
      return this;
    }

    /** <b>[Beta]</b> Builds a new instance of {@link ArrowSerializationOptions}. */
    @BetaApi
    public ArrowSerializationOptions build() {
      return new ArrowSerializationOptions(this);
    }
  }
}
