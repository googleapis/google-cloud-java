/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import com.google.common.base.MoreObjects;
import java.util.Objects;

/**
 * Google BigQuery options for AVRO format. This class wraps some properties of AVRO files used by
 * BigQuery to parse external data.
 */
public final class AvroOptions extends FormatOptions {

  private static final long serialVersionUID = 2293570529308612712L;

  private final Boolean useAvroLogicalTypes;

  public static final class Builder {

    private Boolean useAvroLogicalTypes;

    private Builder() {}

    private Builder(AvroOptions avroOptions) {
      this.useAvroLogicalTypes = avroOptions.useAvroLogicalTypes;
    }

    /**
     * [Optional] Sets whether BigQuery should interpret logical types as the corresponding BigQuery
     * data type (for example, TIMESTAMP), instead of using the raw type (for example, INTEGER).
     */
    public Builder setUseAvroLogicalTypes(boolean useAvroLogicalTypes) {
      this.useAvroLogicalTypes = useAvroLogicalTypes;
      return this;
    }

    /** Creates a {@code AvroOptions} object. */
    public AvroOptions build() {
      return new AvroOptions(this);
    }
  }

  private AvroOptions(Builder builder) {
    super(FormatOptions.AVRO);
    this.useAvroLogicalTypes = builder.useAvroLogicalTypes;
  }

  /**
   * Returns whether BigQuery should interpret logical types as the corresponding BigQuery data type
   * (for example, TIMESTAMP), instead of using the raw type (for example, INTEGER).
   */
  public Boolean useAvroLogicalTypes() {
    return useAvroLogicalTypes;
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("type", getType())
        .add("useAvroLogicalTypes", useAvroLogicalTypes)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getType(), useAvroLogicalTypes);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof AvroOptions && Objects.equals(toPb(), ((AvroOptions) obj).toPb());
  }

  com.google.api.services.bigquery.model.AvroOptions toPb() {
    com.google.api.services.bigquery.model.AvroOptions avroOptions =
        new com.google.api.services.bigquery.model.AvroOptions();
    avroOptions.setUseAvroLogicalTypes(useAvroLogicalTypes);
    return avroOptions;
  }

  /** Returns a builder for a AvroOptions object. */
  public static AvroOptions.Builder newBuilder() {
    return new AvroOptions.Builder();
  }

  static AvroOptions fromPb(com.google.api.services.bigquery.model.AvroOptions avroOptions) {
    Builder builder = newBuilder();
    if (avroOptions.getUseAvroLogicalTypes() != null) {
      builder.setUseAvroLogicalTypes(avroOptions.getUseAvroLogicalTypes());
    }
    return builder.build();
  }
}
