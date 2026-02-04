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

/** Spec for tool parameter kv match metric. */
@AutoValue
@JsonDeserialize(builder = ToolParameterKVMatchSpec.Builder.class)
public abstract class ToolParameterKVMatchSpec extends JsonSerializable {
  /** Optional. Whether to use STRICT string match on parameter values. */
  @JsonProperty("useStrictStringMatch")
  public abstract Optional<Boolean> useStrictStringMatch();

  /** Instantiates a builder for ToolParameterKVMatchSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ToolParameterKVMatchSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ToolParameterKVMatchSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ToolParameterKVMatchSpec.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ToolParameterKVMatchSpec.Builder();
    }

    /**
     * Setter for useStrictStringMatch.
     *
     * <p>useStrictStringMatch: Optional. Whether to use STRICT string match on parameter values.
     */
    @JsonProperty("useStrictStringMatch")
    public abstract Builder useStrictStringMatch(boolean useStrictStringMatch);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder useStrictStringMatch(Optional<Boolean> useStrictStringMatch);

    /** Clears the value of useStrictStringMatch field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearUseStrictStringMatch() {
      return useStrictStringMatch(Optional.empty());
    }

    public abstract ToolParameterKVMatchSpec build();
  }

  /** Deserializes a JSON string to a ToolParameterKVMatchSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static ToolParameterKVMatchSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ToolParameterKVMatchSpec.class);
  }
}
