/*
 * Copyright 2025 Google LLC
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

import com.google.auto.value.AutoValue;
import java.io.Serializable;

/**
 * Google BigQuery DataFormatOptions. Configures the output format for data types returned from
 * BigQuery.
 */
@AutoValue
public abstract class DataFormatOptions implements Serializable {
  public enum TimestampFormatOptions {
    TIMESTAMP_OUTPUT_FORMAT_UNSPECIFIED("TIMESTAMP_OUTPUT_FORMAT_UNSPECIFIED"),
    FLOAT64("FLOAT64"),
    INT64("INT64"),
    ISO8601_STRING("ISO8601_STRING");

    private final String format;

    TimestampFormatOptions(String format) {
      this.format = format;
    }

    @Override
    public String toString() {
      return format;
    }
  }

  public abstract boolean useInt64Timestamp();

  public abstract TimestampFormatOptions timestampFormatOptions();

  public static Builder newBuilder() {
    return new AutoValue_DataFormatOptions.Builder()
        .useInt64Timestamp(false)
        .timestampFormatOptions(TimestampFormatOptions.TIMESTAMP_OUTPUT_FORMAT_UNSPECIFIED);
  }

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder useInt64Timestamp(boolean useInt64Timestamp);

    public abstract Builder timestampFormatOptions(TimestampFormatOptions timestampFormatOptions);

    public abstract DataFormatOptions build();
  }

  com.google.api.services.bigquery.model.DataFormatOptions toPb() {
    com.google.api.services.bigquery.model.DataFormatOptions request =
        new com.google.api.services.bigquery.model.DataFormatOptions();
    request.setUseInt64Timestamp(useInt64Timestamp());
    request.setTimestampOutputFormat(timestampFormatOptions().toString());
    return request;
  }
}
