/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.compute.deprecated;

import com.google.api.services.compute.model.MachineType.ScratchDisks;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * A Google Compute Engine machine type. A machine type determine the virtualized hardware
 * specifications of your virtual machine instances, such as the amount of memory or number of
 * virtual CPUs.
 *
 * @see <a href="https://cloud.google.com/compute/docs/machine-types">Machine Types</a>
 */
public class MachineType implements Serializable {

  static final Function<com.google.api.services.compute.model.MachineType, MachineType>
      FROM_PB_FUNCTION =
          new Function<com.google.api.services.compute.model.MachineType, MachineType>() {
            @Override
            public MachineType apply(com.google.api.services.compute.model.MachineType pb) {
              return MachineType.fromPb(pb);
            }
          };
  static final Function<MachineType, com.google.api.services.compute.model.MachineType>
      TO_PB_FUNCTION =
          new Function<MachineType, com.google.api.services.compute.model.MachineType>() {
            @Override
            public com.google.api.services.compute.model.MachineType apply(MachineType type) {
              return type.toPb();
            }
          };
  private static final DateTimeFormatter TIMESTAMP_FORMATTER = ISODateTimeFormat.dateTime();

  private static final long serialVersionUID = -4210962597502860450L;

  private final MachineTypeId machineTypeId;
  private final String generatedId;
  private final Long creationTimestamp;
  private final String description;
  private final Integer cpus;
  private final Integer memoryMb;
  private final List<Integer> scratchDisksSizeGb;
  private final Integer maximumPersistentDisks;
  private final Long maximumPersistentDisksSizeGb;
  private final DeprecationStatus<MachineTypeId> deprecationStatus;

  static final class Builder {

    private MachineTypeId machineTypeId;
    private String generatedId;
    private Long creationTimestamp;
    private String description;
    private Integer cpus;
    private Integer memoryMb;
    private List<Integer> scratchDisksSizeGb;
    private Integer maximumPersistentDisks;
    private Long maximumPersistentDisksSizeGb;
    private DeprecationStatus<MachineTypeId> deprecationStatus;

    private Builder() {}

    Builder setMachineTypeId(MachineTypeId machineTypeId) {
      this.machineTypeId = machineTypeId;
      return this;
    }

    Builder setGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    Builder setCreationTimestamp(Long creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    Builder setCpus(Integer cpus) {
      this.cpus = cpus;
      return this;
    }

    Builder setMemoryMb(Integer memoryMb) {
      this.memoryMb = memoryMb;
      return this;
    }

    Builder setScratchDisksSizeGb(List<Integer> scratchDisksSizeGb) {
      this.scratchDisksSizeGb = scratchDisksSizeGb;
      return this;
    }

    Builder setMaximumPersistentDisks(Integer maximumPersistentDisks) {
      this.maximumPersistentDisks = maximumPersistentDisks;
      return this;
    }

    Builder setMaximumPersistentDisksSizeGb(Long maximumPersistentDisksSizeGb) {
      this.maximumPersistentDisksSizeGb = maximumPersistentDisksSizeGb;
      return this;
    }

    Builder setDeprecationStatus(DeprecationStatus<MachineTypeId> deprecationStatus) {
      this.deprecationStatus = deprecationStatus;
      return this;
    }

    MachineType build() {
      return new MachineType(this);
    }
  }

  private MachineType(Builder builder) {
    this.machineTypeId = builder.machineTypeId;
    this.generatedId = builder.generatedId;
    this.creationTimestamp = builder.creationTimestamp;
    this.description = builder.description;
    this.cpus = builder.cpus;
    this.memoryMb = builder.memoryMb;
    this.scratchDisksSizeGb = builder.scratchDisksSizeGb;
    this.maximumPersistentDisks = builder.maximumPersistentDisks;
    this.maximumPersistentDisksSizeGb = builder.maximumPersistentDisksSizeGb;
    this.deprecationStatus = builder.deprecationStatus;
  }

  /** Returns the machine type's identity. */
  public MachineTypeId getMachineTypeId() {
    return machineTypeId;
  }

  /** Returns the service-generated unique identifier for the machine type. */
  public String getGeneratedId() {
    return generatedId;
  }

  /** Returns the creation timestamp in milliseconds since epoch. */
  public Long getCreationTimestamp() {
    return creationTimestamp;
  }

  /** Returns an optional textual description of the machine type. */
  public String getDescription() {
    return description;
  }

  /** Returns the number of virtual CPUs that are available to the instance. */
  public Integer getCpus() {
    return cpus;
  }

  /** Returns the amount of physical memory available to the instance, defined in MB. */
  public Integer getMemoryMb() {
    return memoryMb;
  }

  /** Returns the size of all extended scratch disks assigned to the instance, defined in GB. */
  public List<Integer> getScratchDisksSizeGb() {
    return scratchDisksSizeGb;
  }

  /** Returns the maximum number of persistent disks allowed by this instance type. */
  public Integer getMaximumPersistentDisks() {
    return maximumPersistentDisks;
  }

  /** Returns the maximum total persistent disks size allowed, defined in GB. */
  public Long getMaximumPersistentDisksSizeGb() {
    return maximumPersistentDisksSizeGb;
  }

  /**
   * Returns the deprecation status of the machine type. If {@link DeprecationStatus#getStatus()} is
   * either {@link DeprecationStatus.Status#DELETED} or {@link DeprecationStatus.Status#OBSOLETE}
   * the machine type should not be used. Returns {@code null} if the machine type is not
   * deprecated.
   */
  public DeprecationStatus<MachineTypeId> getDeprecationStatus() {
    return deprecationStatus;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("machineTypeId", machineTypeId)
        .add("generatedId", generatedId)
        .add("creationTimestamp", creationTimestamp)
        .add("description", description)
        .add("cpus", cpus)
        .add("memoryMb", memoryMb)
        .add("scratchDisksSizeGb", scratchDisksSizeGb)
        .add("maximumPersistentDisks", maximumPersistentDisks)
        .add("maximumPersistentDisksSizeGb", maximumPersistentDisksSizeGb)
        .add("deprecationStatus", deprecationStatus)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(machineTypeId);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(MachineType.class)
            && Objects.equals(toPb(), ((MachineType) obj).toPb());
  }

  com.google.api.services.compute.model.MachineType toPb() {
    com.google.api.services.compute.model.MachineType machineTypePb =
        new com.google.api.services.compute.model.MachineType();
    if (generatedId != null) {
      machineTypePb.setId(new BigInteger(generatedId));
    }
    if (creationTimestamp != null) {
      machineTypePb.setCreationTimestamp(TIMESTAMP_FORMATTER.print(creationTimestamp));
    }
    machineTypePb.setName(machineTypeId.getType());
    machineTypePb.setDescription(description);
    machineTypePb.setSelfLink(machineTypeId.getSelfLink());
    machineTypePb.setGuestCpus(cpus);
    machineTypePb.setMemoryMb(memoryMb);
    if (scratchDisksSizeGb != null) {
      machineTypePb.setScratchDisks(
          Lists.transform(
              scratchDisksSizeGb,
              new Function<Integer, ScratchDisks>() {
                @Override
                public ScratchDisks apply(Integer diskSize) {
                  return new ScratchDisks().setDiskGb(diskSize);
                }
              }));
    }
    machineTypePb.setMaximumPersistentDisks(maximumPersistentDisks);
    machineTypePb.setMaximumPersistentDisksSizeGb(maximumPersistentDisksSizeGb);
    machineTypePb.setZone(machineTypeId.getZoneId().getZone());
    if (deprecationStatus != null) {
      machineTypePb.setDeprecated(deprecationStatus.toPb());
    }
    return machineTypePb;
  }

  static Builder newBuilder() {
    return new Builder();
  }

  static MachineType fromPb(com.google.api.services.compute.model.MachineType machineTypePb) {
    Builder builder = newBuilder();
    builder.setMachineTypeId(MachineTypeId.fromUrl(machineTypePb.getSelfLink()));
    if (machineTypePb.getId() != null) {
      builder.setGeneratedId(machineTypePb.getId().toString());
    }
    if (machineTypePb.getCreationTimestamp() != null) {
      builder.setCreationTimestamp(
          TIMESTAMP_FORMATTER.parseMillis(machineTypePb.getCreationTimestamp()));
    }
    builder.setDescription(machineTypePb.getDescription());
    builder.setCpus(machineTypePb.getGuestCpus());
    builder.setMemoryMb(machineTypePb.getMemoryMb());
    if (machineTypePb.getScratchDisks() != null) {
      builder.setScratchDisksSizeGb(
          Lists.transform(
              machineTypePb.getScratchDisks(),
              new Function<ScratchDisks, Integer>() {
                @Override
                public Integer apply(ScratchDisks scratchDiskPb) {
                  return scratchDiskPb.getDiskGb();
                }
              }));
    }
    builder.setMaximumPersistentDisks(machineTypePb.getMaximumPersistentDisks());
    builder.setMaximumPersistentDisksSizeGb(machineTypePb.getMaximumPersistentDisksSizeGb());
    if (machineTypePb.getDeprecated() != null) {
      builder.setDeprecationStatus(
          DeprecationStatus.fromPb(machineTypePb.getDeprecated(), MachineTypeId.FROM_URL_FUNCTION));
    }
    return builder.build();
  }
}
