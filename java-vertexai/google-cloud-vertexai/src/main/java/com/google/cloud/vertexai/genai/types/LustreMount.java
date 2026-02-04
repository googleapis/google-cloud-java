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

/** Represents a mount configuration for Lustre file system. */
@AutoValue
@JsonDeserialize(builder = LustreMount.Builder.class)
public abstract class LustreMount extends JsonSerializable {
  /** Required. The name of the Lustre filesystem. */
  @JsonProperty("filesystem")
  public abstract Optional<String> filesystem();

  /** Required. IP address of the Lustre instance. */
  @JsonProperty("instanceIp")
  public abstract Optional<String> instanceIp();

  /**
   * Required. Destination mount path. The Lustre file system will be mounted for the user under
   * /mnt/lustre/
   */
  @JsonProperty("mountPoint")
  public abstract Optional<String> mountPoint();

  /** Required. The unique identifier of the Lustre volume. */
  @JsonProperty("volumeHandle")
  public abstract Optional<String> volumeHandle();

  /** Instantiates a builder for LustreMount. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_LustreMount.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for LustreMount. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `LustreMount.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_LustreMount.Builder();
    }

    /**
     * Setter for filesystem.
     *
     * <p>filesystem: Required. The name of the Lustre filesystem.
     */
    @JsonProperty("filesystem")
    public abstract Builder filesystem(String filesystem);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder filesystem(Optional<String> filesystem);

    /** Clears the value of filesystem field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearFilesystem() {
      return filesystem(Optional.empty());
    }

    /**
     * Setter for instanceIp.
     *
     * <p>instanceIp: Required. IP address of the Lustre instance.
     */
    @JsonProperty("instanceIp")
    public abstract Builder instanceIp(String instanceIp);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder instanceIp(Optional<String> instanceIp);

    /** Clears the value of instanceIp field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearInstanceIp() {
      return instanceIp(Optional.empty());
    }

    /**
     * Setter for mountPoint.
     *
     * <p>mountPoint: Required. Destination mount path. The Lustre file system will be mounted for
     * the user under /mnt/lustre/
     */
    @JsonProperty("mountPoint")
    public abstract Builder mountPoint(String mountPoint);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder mountPoint(Optional<String> mountPoint);

    /** Clears the value of mountPoint field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMountPoint() {
      return mountPoint(Optional.empty());
    }

    /**
     * Setter for volumeHandle.
     *
     * <p>volumeHandle: Required. The unique identifier of the Lustre volume.
     */
    @JsonProperty("volumeHandle")
    public abstract Builder volumeHandle(String volumeHandle);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder volumeHandle(Optional<String> volumeHandle);

    /** Clears the value of volumeHandle field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearVolumeHandle() {
      return volumeHandle(Optional.empty());
    }

    public abstract LustreMount build();
  }

  /** Deserializes a JSON string to a LustreMount object. */
  @ExcludeFromGeneratedCoverageReport
  public static LustreMount fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, LustreMount.class);
  }
}
