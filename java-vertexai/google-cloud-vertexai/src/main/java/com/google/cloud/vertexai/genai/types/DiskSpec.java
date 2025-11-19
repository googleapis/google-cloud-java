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

/** Represents the spec of disk options. */
@AutoValue
@JsonDeserialize(builder = DiskSpec.Builder.class)
public abstract class DiskSpec extends JsonSerializable {
  /** Size in GB of the boot disk (default is 100GB). */
  @JsonProperty("bootDiskSizeGb")
  public abstract Optional<Integer> bootDiskSizeGb();

  /**
   * Type of the boot disk. For non-A3U machines, the default value is "pd-ssd", for A3U machines,
   * the default value is "hyperdisk-balanced". Valid values: "pd-ssd" (Persistent Disk Solid State
   * Drive), "pd-standard" (Persistent Disk Hard Disk Drive) or "hyperdisk-balanced".
   */
  @JsonProperty("bootDiskType")
  public abstract Optional<String> bootDiskType();

  /** Instantiates a builder for DiskSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_DiskSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for DiskSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `DiskSpec.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_DiskSpec.Builder();
    }

    /**
     * Setter for bootDiskSizeGb.
     *
     * <p>bootDiskSizeGb: Size in GB of the boot disk (default is 100GB).
     */
    @JsonProperty("bootDiskSizeGb")
    public abstract Builder bootDiskSizeGb(Integer bootDiskSizeGb);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder bootDiskSizeGb(Optional<Integer> bootDiskSizeGb);

    /** Clears the value of bootDiskSizeGb field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearBootDiskSizeGb() {
      return bootDiskSizeGb(Optional.empty());
    }

    /**
     * Setter for bootDiskType.
     *
     * <p>bootDiskType: Type of the boot disk. For non-A3U machines, the default value is "pd-ssd",
     * for A3U machines, the default value is "hyperdisk-balanced". Valid values: "pd-ssd"
     * (Persistent Disk Solid State Drive), "pd-standard" (Persistent Disk Hard Disk Drive) or
     * "hyperdisk-balanced".
     */
    @JsonProperty("bootDiskType")
    public abstract Builder bootDiskType(String bootDiskType);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder bootDiskType(Optional<String> bootDiskType);

    /** Clears the value of bootDiskType field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearBootDiskType() {
      return bootDiskType(Optional.empty());
    }

    public abstract DiskSpec build();
  }

  /** Deserializes a JSON string to a DiskSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static DiskSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, DiskSpec.class);
  }
}
