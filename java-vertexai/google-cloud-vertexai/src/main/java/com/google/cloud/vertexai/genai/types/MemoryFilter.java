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
import java.util.Optional;

/** Filter to apply when retrieving memories. */
@AutoValue
@JsonDeserialize(builder = MemoryFilter.Builder.class)
public abstract class MemoryFilter extends JsonSerializable {
  /**
   * Key of the filter. For example, "author" would apply to `metadata` entries with the key
   * "author".
   */
  @JsonProperty("key")
  public abstract Optional<String> key();

  /** If true, the filter will be negated. */
  @JsonProperty("negate")
  public abstract Optional<Boolean> negate();

  /** Operator to apply to the filter. If not set, then EQUAL will be used. */
  @JsonProperty("op")
  public abstract Optional<Operator> op();

  /** Value to compare to. */
  @JsonProperty("value")
  public abstract Optional<MemoryMetadataValue> value();

  /** Instantiates a builder for MemoryFilter. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_MemoryFilter.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for MemoryFilter. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `MemoryFilter.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_MemoryFilter.Builder();
    }

    /**
     * Setter for key.
     *
     * <p>key: Key of the filter. For example, "author" would apply to `metadata` entries with the
     * key "author".
     */
    @JsonProperty("key")
    public abstract Builder key(String key);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder key(Optional<String> key);

    /** Clears the value of key field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearKey() {
      return key(Optional.empty());
    }

    /**
     * Setter for negate.
     *
     * <p>negate: If true, the filter will be negated.
     */
    @JsonProperty("negate")
    public abstract Builder negate(boolean negate);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder negate(Optional<Boolean> negate);

    /** Clears the value of negate field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearNegate() {
      return negate(Optional.empty());
    }

    /**
     * Setter for op.
     *
     * <p>op: Operator to apply to the filter. If not set, then EQUAL will be used.
     */
    @JsonProperty("op")
    public abstract Builder op(Operator op);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder op(Optional<Operator> op);

    /** Clears the value of op field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearOp() {
      return op(Optional.empty());
    }

    /**
     * Setter for op given a known enum.
     *
     * <p>op: Operator to apply to the filter. If not set, then EQUAL will be used.
     */
    @CanIgnoreReturnValue
    public Builder op(Operator.Known knownType) {
      return op(new Operator(knownType));
    }

    /**
     * Setter for op given a string.
     *
     * <p>op: Operator to apply to the filter. If not set, then EQUAL will be used.
     */
    @CanIgnoreReturnValue
    public Builder op(String op) {
      return op(new Operator(op));
    }

    /**
     * Setter for value.
     *
     * <p>value: Value to compare to.
     */
    @JsonProperty("value")
    public abstract Builder value(MemoryMetadataValue value);

    /**
     * Setter for value builder.
     *
     * <p>value: Value to compare to.
     */
    @CanIgnoreReturnValue
    public Builder value(MemoryMetadataValue.Builder valueBuilder) {
      return value(valueBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder value(Optional<MemoryMetadataValue> value);

    /** Clears the value of value field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearValue() {
      return value(Optional.empty());
    }

    public abstract MemoryFilter build();
  }

  /** Deserializes a JSON string to a MemoryFilter object. */
  @ExcludeFromGeneratedCoverageReport
  public static MemoryFilter fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, MemoryFilter.class);
  }
}
