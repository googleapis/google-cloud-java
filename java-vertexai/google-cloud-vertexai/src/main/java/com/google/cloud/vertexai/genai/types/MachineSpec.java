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

/** Specification of a single machine. */
@AutoValue
@JsonDeserialize(builder = MachineSpec.Builder.class)
public abstract class MachineSpec extends JsonSerializable {
  /** The number of accelerators to attach to the machine. */
  @JsonProperty("acceleratorCount")
  public abstract Optional<Integer> acceleratorCount();

  /**
   * Immutable. The type of accelerator(s) that may be attached to the machine as per
   * accelerator_count.
   */
  @JsonProperty("acceleratorType")
  public abstract Optional<AcceleratorType> acceleratorType();

  /**
   * Optional. Immutable. The Nvidia GPU partition size. When specified, the requested accelerators
   * will be partitioned into smaller GPU partitions. For example, if the request is for 8 units of
   * NVIDIA A100 GPUs, and gpu_partition_size="1g.10gb", the service will create 8 * 7 = 56
   * partitioned MIG instances. The partition size must be a value supported by the requested
   * accelerator. Refer to [Nvidia GPU
   * Partitioning](https://cloud.google.com/kubernetes-engine/docs/how-to/gpus-multi#multi-instance_gpu_partitions)
   * for the available partition sizes. If set, the accelerator_count should be set to 1.
   */
  @JsonProperty("gpuPartitionSize")
  public abstract Optional<String> gpuPartitionSize();

  /**
   * Immutable. The type of the machine. See the [list of machine types supported for
   * prediction](https://cloud.google.com/vertex-ai/docs/predictions/configure-compute#machine-types)
   * See the [list of machine types supported for custom
   * training](https://cloud.google.com/vertex-ai/docs/training/configure-compute#machine-types).
   * For DeployedModel this field is optional, and the default value is `n1-standard-2`. For
   * BatchPredictionJob or as part of WorkerPoolSpec this field is required.
   */
  @JsonProperty("machineType")
  public abstract Optional<String> machineType();

  /** Optional. Immutable. The number of nodes per replica for multihost GPU deployments. */
  @JsonProperty("multihostGpuNodeCount")
  public abstract Optional<Integer> multihostGpuNodeCount();

  /** Optional. Immutable. Configuration controlling how this resource pool consumes reservation. */
  @JsonProperty("reservationAffinity")
  public abstract Optional<ReservationAffinity> reservationAffinity();

  /**
   * Immutable. The topology of the TPUs. Corresponds to the TPU topologies available from GKE.
   * (Example: tpu_topology: "2x2x1").
   */
  @JsonProperty("tpuTopology")
  public abstract Optional<String> tpuTopology();

  /** Instantiates a builder for MachineSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_MachineSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for MachineSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `MachineSpec.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_MachineSpec.Builder();
    }

    /**
     * Setter for acceleratorCount.
     *
     * <p>acceleratorCount: The number of accelerators to attach to the machine.
     */
    @JsonProperty("acceleratorCount")
    public abstract Builder acceleratorCount(Integer acceleratorCount);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder acceleratorCount(Optional<Integer> acceleratorCount);

    /** Clears the value of acceleratorCount field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAcceleratorCount() {
      return acceleratorCount(Optional.empty());
    }

    /**
     * Setter for acceleratorType.
     *
     * <p>acceleratorType: Immutable. The type of accelerator(s) that may be attached to the machine
     * as per accelerator_count.
     */
    @JsonProperty("acceleratorType")
    public abstract Builder acceleratorType(AcceleratorType acceleratorType);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder acceleratorType(Optional<AcceleratorType> acceleratorType);

    /** Clears the value of acceleratorType field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAcceleratorType() {
      return acceleratorType(Optional.empty());
    }

    /**
     * Setter for acceleratorType given a known enum.
     *
     * <p>acceleratorType: Immutable. The type of accelerator(s) that may be attached to the machine
     * as per accelerator_count.
     */
    @CanIgnoreReturnValue
    public Builder acceleratorType(AcceleratorType.Known knownType) {
      return acceleratorType(new AcceleratorType(knownType));
    }

    /**
     * Setter for acceleratorType given a string.
     *
     * <p>acceleratorType: Immutable. The type of accelerator(s) that may be attached to the machine
     * as per accelerator_count.
     */
    @CanIgnoreReturnValue
    public Builder acceleratorType(String acceleratorType) {
      return acceleratorType(new AcceleratorType(acceleratorType));
    }

    /**
     * Setter for gpuPartitionSize.
     *
     * <p>gpuPartitionSize: Optional. Immutable. The Nvidia GPU partition size. When specified, the
     * requested accelerators will be partitioned into smaller GPU partitions. For example, if the
     * request is for 8 units of NVIDIA A100 GPUs, and gpu_partition_size="1g.10gb", the service
     * will create 8 * 7 = 56 partitioned MIG instances. The partition size must be a value
     * supported by the requested accelerator. Refer to [Nvidia GPU
     * Partitioning](https://cloud.google.com/kubernetes-engine/docs/how-to/gpus-multi#multi-instance_gpu_partitions)
     * for the available partition sizes. If set, the accelerator_count should be set to 1.
     */
    @JsonProperty("gpuPartitionSize")
    public abstract Builder gpuPartitionSize(String gpuPartitionSize);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder gpuPartitionSize(Optional<String> gpuPartitionSize);

    /** Clears the value of gpuPartitionSize field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGpuPartitionSize() {
      return gpuPartitionSize(Optional.empty());
    }

    /**
     * Setter for machineType.
     *
     * <p>machineType: Immutable. The type of the machine. See the [list of machine types supported
     * for
     * prediction](https://cloud.google.com/vertex-ai/docs/predictions/configure-compute#machine-types)
     * See the [list of machine types supported for custom
     * training](https://cloud.google.com/vertex-ai/docs/training/configure-compute#machine-types).
     * For DeployedModel this field is optional, and the default value is `n1-standard-2`. For
     * BatchPredictionJob or as part of WorkerPoolSpec this field is required.
     */
    @JsonProperty("machineType")
    public abstract Builder machineType(String machineType);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder machineType(Optional<String> machineType);

    /** Clears the value of machineType field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMachineType() {
      return machineType(Optional.empty());
    }

    /**
     * Setter for multihostGpuNodeCount.
     *
     * <p>multihostGpuNodeCount: Optional. Immutable. The number of nodes per replica for multihost
     * GPU deployments.
     */
    @JsonProperty("multihostGpuNodeCount")
    public abstract Builder multihostGpuNodeCount(Integer multihostGpuNodeCount);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder multihostGpuNodeCount(Optional<Integer> multihostGpuNodeCount);

    /** Clears the value of multihostGpuNodeCount field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMultihostGpuNodeCount() {
      return multihostGpuNodeCount(Optional.empty());
    }

    /**
     * Setter for reservationAffinity.
     *
     * <p>reservationAffinity: Optional. Immutable. Configuration controlling how this resource pool
     * consumes reservation.
     */
    @JsonProperty("reservationAffinity")
    public abstract Builder reservationAffinity(ReservationAffinity reservationAffinity);

    /**
     * Setter for reservationAffinity builder.
     *
     * <p>reservationAffinity: Optional. Immutable. Configuration controlling how this resource pool
     * consumes reservation.
     */
    @CanIgnoreReturnValue
    public Builder reservationAffinity(ReservationAffinity.Builder reservationAffinityBuilder) {
      return reservationAffinity(reservationAffinityBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder reservationAffinity(Optional<ReservationAffinity> reservationAffinity);

    /** Clears the value of reservationAffinity field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearReservationAffinity() {
      return reservationAffinity(Optional.empty());
    }

    /**
     * Setter for tpuTopology.
     *
     * <p>tpuTopology: Immutable. The topology of the TPUs. Corresponds to the TPU topologies
     * available from GKE. (Example: tpu_topology: "2x2x1").
     */
    @JsonProperty("tpuTopology")
    public abstract Builder tpuTopology(String tpuTopology);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder tpuTopology(Optional<String> tpuTopology);

    /** Clears the value of tpuTopology field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTpuTopology() {
      return tpuTopology(Optional.empty());
    }

    public abstract MachineSpec build();
  }

  /** Deserializes a JSON string to a MachineSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static MachineSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, MachineSpec.class);
  }
}
