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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Cloud storage source holds the dataset.
 *
 * <p>Currently only one Cloud Storage file path is supported.
 */
@AutoValue
@JsonDeserialize(builder = GcsSource.Builder.class)
public abstract class GcsSource extends JsonSerializable {
  /**
   * Required. Google Cloud Storage URI(-s) to the input file(s). May contain wildcards. For more
   * information on wildcards, see https://cloud.google.com/storage/docs/wildcards.
   */
  @JsonProperty("uris")
  public abstract Optional<List<String>> uris();

  /** Instantiates a builder for GcsSource. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_GcsSource.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for GcsSource. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `GcsSource.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_GcsSource.Builder();
    }

    /**
     * Setter for uris.
     *
     * <p>uris: Required. Google Cloud Storage URI(-s) to the input file(s). May contain wildcards.
     * For more information on wildcards, see https://cloud.google.com/storage/docs/wildcards.
     */
    @JsonProperty("uris")
    public abstract Builder uris(List<String> uris);

    /**
     * Setter for uris.
     *
     * <p>uris: Required. Google Cloud Storage URI(-s) to the input file(s). May contain wildcards.
     * For more information on wildcards, see https://cloud.google.com/storage/docs/wildcards.
     */
    @CanIgnoreReturnValue
    public Builder uris(String... uris) {
      return uris(Arrays.asList(uris));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder uris(Optional<List<String>> uris);

    /** Clears the value of uris field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearUris() {
      return uris(Optional.empty());
    }

    public abstract GcsSource build();
  }

  /** Deserializes a JSON string to a GcsSource object. */
  @ExcludeFromGeneratedCoverageReport
  public static GcsSource fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, GcsSource.class);
  }
}
