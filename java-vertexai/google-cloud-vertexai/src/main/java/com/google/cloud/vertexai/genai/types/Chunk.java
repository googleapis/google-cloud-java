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

/** A chunk of data. */
@AutoValue
@JsonDeserialize(builder = Chunk.Builder.class)
public abstract class Chunk extends JsonSerializable {
  /** Required. The data in the chunk. */
  @JsonProperty("data")
  public abstract Optional<byte[]> data();

  /** Optional. Metadata that is associated with the data in the payload. */
  @JsonProperty("metadata")
  public abstract Optional<Metadata> metadata();

  /**
   * Required. Mime type of the chunk data. See
   * https://www.iana.org/assignments/media-types/media-types.xhtml for the full list.
   */
  @JsonProperty("mimeType")
  public abstract Optional<String> mimeType();

  /** Instantiates a builder for Chunk. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_Chunk.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for Chunk. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `Chunk.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_Chunk.Builder();
    }

    /**
     * Setter for data.
     *
     * <p>data: Required. The data in the chunk.
     */
    @JsonProperty("data")
    public abstract Builder data(byte[] data);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder data(Optional<byte[]> data);

    /** Clears the value of data field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearData() {
      return data(Optional.empty());
    }

    /**
     * Setter for metadata.
     *
     * <p>metadata: Optional. Metadata that is associated with the data in the payload.
     */
    @JsonProperty("metadata")
    public abstract Builder metadata(Metadata metadata);

    /**
     * Setter for metadata builder.
     *
     * <p>metadata: Optional. Metadata that is associated with the data in the payload.
     */
    @CanIgnoreReturnValue
    public Builder metadata(Metadata.Builder metadataBuilder) {
      return metadata(metadataBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metadata(Optional<Metadata> metadata);

    /** Clears the value of metadata field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetadata() {
      return metadata(Optional.empty());
    }

    /**
     * Setter for mimeType.
     *
     * <p>mimeType: Required. Mime type of the chunk data. See
     * https://www.iana.org/assignments/media-types/media-types.xhtml for the full list.
     */
    @JsonProperty("mimeType")
    public abstract Builder mimeType(String mimeType);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder mimeType(Optional<String> mimeType);

    /** Clears the value of mimeType field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMimeType() {
      return mimeType(Optional.empty());
    }

    public abstract Chunk build();
  }

  /** Deserializes a JSON string to a Chunk object. */
  @ExcludeFromGeneratedCoverageReport
  public static Chunk fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, Chunk.class);
  }
}
