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

/** Represents a mount configuration for Network File System (NFS) to mount. */
@AutoValue
@JsonDeserialize(builder = NfsMount.Builder.class)
public abstract class NfsMount extends JsonSerializable {
  /** Required. Destination mount path. The NFS will be mounted for the user under /mnt/nfs/ */
  @JsonProperty("mountPoint")
  public abstract Optional<String> mountPoint();

  /**
   * Required. Source path exported from NFS server. Has to start with '/', and combined with the ip
   * address, it indicates the source mount path in the form of `server:path`
   */
  @JsonProperty("path")
  public abstract Optional<String> path();

  /** Required. IP address of the NFS server. */
  @JsonProperty("server")
  public abstract Optional<String> server();

  /** Instantiates a builder for NfsMount. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_NfsMount.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for NfsMount. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `NfsMount.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_NfsMount.Builder();
    }

    /**
     * Setter for mountPoint.
     *
     * <p>mountPoint: Required. Destination mount path. The NFS will be mounted for the user under
     * /mnt/nfs/
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
     * Setter for path.
     *
     * <p>path: Required. Source path exported from NFS server. Has to start with '/', and combined
     * with the ip address, it indicates the source mount path in the form of `server:path`
     */
    @JsonProperty("path")
    public abstract Builder path(String path);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder path(Optional<String> path);

    /** Clears the value of path field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPath() {
      return path(Optional.empty());
    }

    /**
     * Setter for server.
     *
     * <p>server: Required. IP address of the NFS server.
     */
    @JsonProperty("server")
    public abstract Builder server(String server);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder server(Optional<String> server);

    /** Clears the value of server field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearServer() {
      return server(Optional.empty());
    }

    public abstract NfsMount build();
  }

  /** Deserializes a JSON string to a NfsMount object. */
  @ExcludeFromGeneratedCoverageReport
  public static NfsMount fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, NfsMount.class);
  }
}
