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

import static com.google.common.collect.ImmutableList.toImmutableList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/** Represents the spec of a worker pool in a job. */
@AutoValue
@JsonDeserialize(builder = WorkerPoolSpec.Builder.class)
public abstract class WorkerPoolSpec extends JsonSerializable {
  /** The custom container task. */
  @JsonProperty("containerSpec")
  public abstract Optional<ContainerSpec> containerSpec();

  /** Disk spec. */
  @JsonProperty("diskSpec")
  public abstract Optional<DiskSpec> diskSpec();

  /** Optional. List of Lustre mounts. */
  @JsonProperty("lustreMounts")
  public abstract Optional<List<LustreMount>> lustreMounts();

  /** Optional. Immutable. The specification of a single machine. */
  @JsonProperty("machineSpec")
  public abstract Optional<MachineSpec> machineSpec();

  /** Optional. List of NFS mount spec. */
  @JsonProperty("nfsMounts")
  public abstract Optional<List<NfsMount>> nfsMounts();

  /** The Python packaged task. */
  @JsonProperty("pythonPackageSpec")
  public abstract Optional<PythonPackageSpec> pythonPackageSpec();

  /** Optional. The number of worker replicas to use for this worker pool. */
  @JsonProperty("replicaCount")
  public abstract Optional<Long> replicaCount();

  /** Instantiates a builder for WorkerPoolSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_WorkerPoolSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for WorkerPoolSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `WorkerPoolSpec.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_WorkerPoolSpec.Builder();
    }

    /**
     * Setter for containerSpec.
     *
     * <p>containerSpec: The custom container task.
     */
    @JsonProperty("containerSpec")
    public abstract Builder containerSpec(ContainerSpec containerSpec);

    /**
     * Setter for containerSpec builder.
     *
     * <p>containerSpec: The custom container task.
     */
    @CanIgnoreReturnValue
    public Builder containerSpec(ContainerSpec.Builder containerSpecBuilder) {
      return containerSpec(containerSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder containerSpec(Optional<ContainerSpec> containerSpec);

    /** Clears the value of containerSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearContainerSpec() {
      return containerSpec(Optional.empty());
    }

    /**
     * Setter for diskSpec.
     *
     * <p>diskSpec: Disk spec.
     */
    @JsonProperty("diskSpec")
    public abstract Builder diskSpec(DiskSpec diskSpec);

    /**
     * Setter for diskSpec builder.
     *
     * <p>diskSpec: Disk spec.
     */
    @CanIgnoreReturnValue
    public Builder diskSpec(DiskSpec.Builder diskSpecBuilder) {
      return diskSpec(diskSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder diskSpec(Optional<DiskSpec> diskSpec);

    /** Clears the value of diskSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDiskSpec() {
      return diskSpec(Optional.empty());
    }

    /**
     * Setter for lustreMounts.
     *
     * <p>lustreMounts: Optional. List of Lustre mounts.
     */
    @JsonProperty("lustreMounts")
    public abstract Builder lustreMounts(List<LustreMount> lustreMounts);

    /**
     * Setter for lustreMounts.
     *
     * <p>lustreMounts: Optional. List of Lustre mounts.
     */
    @CanIgnoreReturnValue
    public Builder lustreMounts(LustreMount... lustreMounts) {
      return lustreMounts(Arrays.asList(lustreMounts));
    }

    /**
     * Setter for lustreMounts builder.
     *
     * <p>lustreMounts: Optional. List of Lustre mounts.
     */
    @CanIgnoreReturnValue
    public Builder lustreMounts(LustreMount.Builder... lustreMountsBuilders) {
      return lustreMounts(
          Arrays.asList(lustreMountsBuilders).stream()
              .map(LustreMount.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder lustreMounts(Optional<List<LustreMount>> lustreMounts);

    /** Clears the value of lustreMounts field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearLustreMounts() {
      return lustreMounts(Optional.empty());
    }

    /**
     * Setter for machineSpec.
     *
     * <p>machineSpec: Optional. Immutable. The specification of a single machine.
     */
    @JsonProperty("machineSpec")
    public abstract Builder machineSpec(MachineSpec machineSpec);

    /**
     * Setter for machineSpec builder.
     *
     * <p>machineSpec: Optional. Immutable. The specification of a single machine.
     */
    @CanIgnoreReturnValue
    public Builder machineSpec(MachineSpec.Builder machineSpecBuilder) {
      return machineSpec(machineSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder machineSpec(Optional<MachineSpec> machineSpec);

    /** Clears the value of machineSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMachineSpec() {
      return machineSpec(Optional.empty());
    }

    /**
     * Setter for nfsMounts.
     *
     * <p>nfsMounts: Optional. List of NFS mount spec.
     */
    @JsonProperty("nfsMounts")
    public abstract Builder nfsMounts(List<NfsMount> nfsMounts);

    /**
     * Setter for nfsMounts.
     *
     * <p>nfsMounts: Optional. List of NFS mount spec.
     */
    @CanIgnoreReturnValue
    public Builder nfsMounts(NfsMount... nfsMounts) {
      return nfsMounts(Arrays.asList(nfsMounts));
    }

    /**
     * Setter for nfsMounts builder.
     *
     * <p>nfsMounts: Optional. List of NFS mount spec.
     */
    @CanIgnoreReturnValue
    public Builder nfsMounts(NfsMount.Builder... nfsMountsBuilders) {
      return nfsMounts(
          Arrays.asList(nfsMountsBuilders).stream()
              .map(NfsMount.Builder::build)
              .collect(toImmutableList()));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder nfsMounts(Optional<List<NfsMount>> nfsMounts);

    /** Clears the value of nfsMounts field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearNfsMounts() {
      return nfsMounts(Optional.empty());
    }

    /**
     * Setter for pythonPackageSpec.
     *
     * <p>pythonPackageSpec: The Python packaged task.
     */
    @JsonProperty("pythonPackageSpec")
    public abstract Builder pythonPackageSpec(PythonPackageSpec pythonPackageSpec);

    /**
     * Setter for pythonPackageSpec builder.
     *
     * <p>pythonPackageSpec: The Python packaged task.
     */
    @CanIgnoreReturnValue
    public Builder pythonPackageSpec(PythonPackageSpec.Builder pythonPackageSpecBuilder) {
      return pythonPackageSpec(pythonPackageSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder pythonPackageSpec(Optional<PythonPackageSpec> pythonPackageSpec);

    /** Clears the value of pythonPackageSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPythonPackageSpec() {
      return pythonPackageSpec(Optional.empty());
    }

    /**
     * Setter for replicaCount.
     *
     * <p>replicaCount: Optional. The number of worker replicas to use for this worker pool.
     */
    @JsonProperty("replicaCount")
    public abstract Builder replicaCount(Long replicaCount);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder replicaCount(Optional<Long> replicaCount);

    /** Clears the value of replicaCount field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearReplicaCount() {
      return replicaCount(Optional.empty());
    }

    public abstract WorkerPoolSpec build();
  }

  /** Deserializes a JSON string to a WorkerPoolSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static WorkerPoolSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, WorkerPoolSpec.class);
  }
}
