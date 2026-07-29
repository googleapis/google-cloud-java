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
import java.io.Serializable;
import java.util.Objects;

/** Options specific to the Apache Arrow output format. */
@BetaApi
public final class ArrowSerializationOptions implements Serializable {

  private static final long serialVersionUID = 1L;

  private final String bufferCompression;
  private final String picosTimestampPrecision;

  private ArrowSerializationOptions(Builder builder) {
    this.bufferCompression = builder.bufferCompression;
    this.picosTimestampPrecision = builder.picosTimestampPrecision;
  }

  public String getBufferCompression() {
    return bufferCompression;
  }

  public String getPicosTimestampPrecision() {
    return picosTimestampPrecision;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return com.google.common.base.MoreObjects.toStringHelper(this)
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
    com.google.api.services.bigquery.model.ArrowSerializationOptions optionsPb =
        new com.google.api.services.bigquery.model.ArrowSerializationOptions();
    if (bufferCompression != null) {
      optionsPb.setBufferCompression(bufferCompression);
    }
    if (picosTimestampPrecision != null) {
      optionsPb.setPicosTimestampPrecision(picosTimestampPrecision);
    }
    return optionsPb;
  }

  static ArrowSerializationOptions fromPb(
      com.google.api.services.bigquery.model.ArrowSerializationOptions optionsPb) {
    if (optionsPb == null) {
      return null;
    }
    return newBuilder()
        .setBufferCompression(optionsPb.getBufferCompression())
        .setPicosTimestampPrecision(optionsPb.getPicosTimestampPrecision())
        .build();
  }

  public static final class Builder {
    private String bufferCompression;
    private String picosTimestampPrecision;

    private Builder() {}

    public Builder setBufferCompression(String bufferCompression) {
      this.bufferCompression = bufferCompression;
      return this;
    }

    public Builder setPicosTimestampPrecision(String picosTimestampPrecision) {
      this.picosTimestampPrecision = picosTimestampPrecision;
      return this;
    }

    public ArrowSerializationOptions build() {
      return new ArrowSerializationOptions(this);
    }
  }
}
