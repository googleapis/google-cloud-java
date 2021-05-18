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

public class ParquetOptions extends FormatOptions {

  private static final long serialVersionUID = 1992L;

  private final Boolean enableListInference;
  private final Boolean enumAsString;

  public Boolean getEnableListInference() {
    return enableListInference;
  }

  public Boolean getEnumAsString() {
    return enumAsString;
  }

  /** A builder for {@code ParquetOptions} objects. */
  public static final class Builder {
    private Boolean enableListInference;
    private Boolean enumAsString;

    private Builder() {}

    private Builder(ParquetOptions parquetOptions) {
      this.enableListInference = parquetOptions.enableListInference;
      this.enumAsString = parquetOptions.enumAsString;
    }

    public Builder setEnableListInference(Boolean enableListInference) {
      this.enableListInference = enableListInference;
      return this;
    }

    public Builder setEnumAsString(Boolean enumAsString) {
      this.enumAsString = enumAsString;
      return this;
    }

    public ParquetOptions build() {
      return new ParquetOptions(this);
    }
  }
  /** Returns a builder for the {@link ParquetOptions} object. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  ParquetOptions(Builder builder) {
    super(FormatOptions.PARQUET);
    enableListInference = builder.enableListInference;
    enumAsString = builder.enumAsString;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("enableListInference", enableListInference)
        .add("enumAsString", enumAsString)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(enableListInference, enumAsString);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(ParquetOptions.class)) {
      return false;
    }
    ParquetOptions other = (ParquetOptions) obj;
    return enableListInference == other.enableListInference && enumAsString == other.enumAsString;
  }

  /** Returns a builder for a {@link ParquetOptions} object. */
  public static ParquetOptions.Builder newBuilder() {
    return new ParquetOptions.Builder();
  }

  static ParquetOptions fromPb(
      com.google.api.services.bigquery.model.ParquetOptions parquetOptions) {
    Builder builder = newBuilder();
    if (parquetOptions.getEnableListInference() != null) {
      builder.setEnableListInference(parquetOptions.getEnableListInference());
    }
    if (parquetOptions.getEnumAsString() != null) {
      builder.setEnumAsString(parquetOptions.getEnumAsString());
    }
    return builder.build();
  }

  com.google.api.services.bigquery.model.ParquetOptions toPb() {
    com.google.api.services.bigquery.model.ParquetOptions parquetOptions =
        new com.google.api.services.bigquery.model.ParquetOptions();
    if (enableListInference != null) {
      parquetOptions.setEnableListInference(enableListInference);
    }
    if (enumAsString != null) {
      parquetOptions.setEnumAsString(enumAsString);
    }
    return parquetOptions;
  }
}
