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

/** Specifies source code provided as a byte stream. */
@AutoValue
@JsonDeserialize(builder = ReasoningEngineSpecSourceCodeSpecInlineSource.Builder.class)
public abstract class ReasoningEngineSpecSourceCodeSpecInlineSource extends JsonSerializable {
  /**
   * Required. Input only. The application source code archive, provided as a compressed tarball
   * (.tar.gz) file.
   */
  @JsonProperty("sourceArchive")
  public abstract Optional<byte[]> sourceArchive();

  /** Instantiates a builder for ReasoningEngineSpecSourceCodeSpecInlineSource. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ReasoningEngineSpecSourceCodeSpecInlineSource.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ReasoningEngineSpecSourceCodeSpecInlineSource. */
  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * For internal usage. Please use `ReasoningEngineSpecSourceCodeSpecInlineSource.builder()` for
     * instantiation.
     */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ReasoningEngineSpecSourceCodeSpecInlineSource.Builder();
    }

    /**
     * Setter for sourceArchive.
     *
     * <p>sourceArchive: Required. Input only. The application source code archive, provided as a
     * compressed tarball (.tar.gz) file.
     */
    @JsonProperty("sourceArchive")
    public abstract Builder sourceArchive(byte[] sourceArchive);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder sourceArchive(Optional<byte[]> sourceArchive);

    /** Clears the value of sourceArchive field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSourceArchive() {
      return sourceArchive(Optional.empty());
    }

    public abstract ReasoningEngineSpecSourceCodeSpecInlineSource build();
  }

  /** Deserializes a JSON string to a ReasoningEngineSpecSourceCodeSpecInlineSource object. */
  @ExcludeFromGeneratedCoverageReport
  public static ReasoningEngineSpecSourceCodeSpecInlineSource fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(
        jsonString, ReasoningEngineSpecSourceCodeSpecInlineSource.class);
  }
}
