/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Auto-generated code. Do not edit.

package com.google.cloud.vertexai.genai.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.time.Instant;
import java.util.Optional;

/** The metadata values for memories. */
@AutoValue
@JsonDeserialize(builder = MemoryMetadataValue.Builder.class)
public abstract class MemoryMetadataValue extends JsonSerializable {
  /** Boolean value. */
  @JsonProperty("boolValue")
  public abstract Optional<Boolean> boolValue();

  /** Double value. */
  @JsonProperty("doubleValue")
  public abstract Optional<Double> doubleValue();

  /** String value. */
  @JsonProperty("stringValue")
  public abstract Optional<String> stringValue();

  /**
   * Timestamp value. When filtering on timestamp values, only the seconds field will be compared.
   */
  @JsonProperty("timestampValue")
  public abstract Optional<Instant> timestampValue();

  /** Instantiates a builder for MemoryMetadataValue. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_MemoryMetadataValue.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for MemoryMetadataValue. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `MemoryMetadataValue.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_MemoryMetadataValue.Builder();
    }

    /**
     * Setter for boolValue.
     *
     * <p>boolValue: Boolean value.
     */
    @JsonProperty("boolValue")
    public abstract Builder boolValue(boolean boolValue);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder boolValue(Optional<Boolean> boolValue);

    /** Clears the value of boolValue field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearBoolValue() {
      return boolValue(Optional.empty());
    }

    /**
     * Setter for doubleValue.
     *
     * <p>doubleValue: Double value.
     */
    @JsonProperty("doubleValue")
    public abstract Builder doubleValue(Double doubleValue);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder doubleValue(Optional<Double> doubleValue);

    /** Clears the value of doubleValue field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDoubleValue() {
      return doubleValue(Optional.empty());
    }

    /**
     * Setter for stringValue.
     *
     * <p>stringValue: String value.
     */
    @JsonProperty("stringValue")
    public abstract Builder stringValue(String stringValue);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder stringValue(Optional<String> stringValue);

    /** Clears the value of stringValue field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearStringValue() {
      return stringValue(Optional.empty());
    }

    /**
     * Setter for timestampValue.
     *
     * <p>timestampValue: Timestamp value. When filtering on timestamp values, only the seconds
     * field will be compared.
     */
    @JsonProperty("timestampValue")
    public abstract Builder timestampValue(Instant timestampValue);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder timestampValue(Optional<Instant> timestampValue);

    /** Clears the value of timestampValue field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTimestampValue() {
      return timestampValue(Optional.empty());
    }

    public abstract MemoryMetadataValue build();
  }

  /** Deserializes a JSON string to a MemoryMetadataValue object. */
  @ExcludeFromGeneratedCoverageReport
  public static MemoryMetadataValue fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, MemoryMetadataValue.class);
  }
}
