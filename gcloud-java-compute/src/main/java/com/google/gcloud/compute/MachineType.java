/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud.compute;

import com.google.api.services.compute.model.MachineType.ScratchDisks;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * A Google Compute Engine machine type. A machine type determine the virtualized hardware
 * specifications of your virtual machine instances, such as the amount of memory or number of
 * virtual CPUs.
 *
 * @see <a href="https://cloud.google.com/compute/docs/machine-types">Machine Types</a>
 */
public final class MachineType implements Serializable {

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

  private static final long serialVersionUID = -4210962597502860450L;

  private final MachineTypeId machineTypeId;
  private final BigInteger id;
  private final String creationTimestamp;
  private final String description;
  private final String selfLink;
  private final Integer guestCpus;
  private final Integer memoryMb;
  private final List<Integer> scratchDisks;
  private final Integer maximumPersistentDisks;
  private final Long maximumPersistentDisksSizeGb;
  private final DeprecationStatus<MachineTypeId> deprecationStatus;

  static final class Builder {

    private MachineTypeId machineTypeId;
    private BigInteger id;
    private String creationTimestamp;
    private String description;
    private String selfLink;
    private Integer guestCpus;
    private Integer memoryMb;
    private List<Integer> scratchDisks;
    private Integer maximumPersistentDisks;
    private Long maximumPersistentDisksSizeGb;
    private DeprecationStatus<MachineTypeId> deprecationStatus;

    private Builder() {}

    Builder machineTypeId(MachineTypeId machineTypeId) {
      this.machineTypeId = machineTypeId;
      return this;
    }

    Builder id(BigInteger id) {
      this.id = id;
      return this;
    }

    Builder creationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    Builder description(String description) {
      this.description = description;
      return this;
    }

    Builder selfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    Builder guestCpus(Integer guestCpus) {
      this.guestCpus = guestCpus;
      return this;
    }

    Builder memoryMb(Integer memoryMb) {
      this.memoryMb = memoryMb;
      return this;
    }

    Builder scratchDisks(List<Integer> scratchDisks) {
      this.scratchDisks = scratchDisks;
      return this;
    }

    Builder maximumPersistentDisks(Integer maximumPersistentDisks) {
      this.maximumPersistentDisks = maximumPersistentDisks;
      return this;
    }

    Builder maximumPersistentDisksSizeGb(Long maximumPersistentDisksSizeGb) {
      this.maximumPersistentDisksSizeGb = maximumPersistentDisksSizeGb;
      return this;
    }

    Builder deprecationStatus(DeprecationStatus<MachineTypeId> deprecationStatus) {
      this.deprecationStatus = deprecationStatus;
      return this;
    }

    MachineType build() {
      return new MachineType(this);
    }
  }

  private MachineType(Builder builder) {
    this.machineTypeId = builder.machineTypeId;
    this.id = builder.id;
    this.creationTimestamp = builder.creationTimestamp;
    this.description = builder.description;
    this.selfLink = builder.selfLink;
    this.guestCpus = builder.guestCpus;
    this.memoryMb = builder.memoryMb;
    this.scratchDisks = builder.scratchDisks;
    this.maximumPersistentDisks = builder.maximumPersistentDisks;
    this.maximumPersistentDisksSizeGb = builder.maximumPersistentDisksSizeGb;
    this.deprecationStatus = builder.deprecationStatus;
  }

  /**
   * Returns the machine type's identity.
   */
  public MachineTypeId machineTypeId() {
    return machineTypeId;
  }

  /**
   * Returns an unique identifier for the machin type; defined by the service.
   */
  public BigInteger id() {
    return id;
  }

  /**
   * Returns the creation timestamp in RFC3339 text format.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc3339.txt">RFC3339</a>
   */
  public String creationTimestamp() {
    return creationTimestamp;
  }

  /**
   * Returns an optional textual description of the machine type.
   */
  public String description() {
    return description;
  }

  /**
   * Returns a service-defined URL for the machine type.
   */
  public String selfLink() {
    return selfLink;
  }

  /**
   * Returns the number of virtual CPUs that are available to the instance.
   */
  public Integer guestCpus() {
    return guestCpus;
  }

  /**
   * Returns the amount of physical memory available to the instance, defined in MB.
   */
  public Integer memoryMb() {
    return memoryMb;
  }

  /**
   * Returns the size of all extended scratch disks assigned to the instance, defined in GB.
   */
  public List<Integer> scratchDisks() {
    return scratchDisks;
  }

  /**
   * Returns the maximum number of persistent disks allowed by this instance type.
   */
  public Integer maximumPersistentDisks() {
    return maximumPersistentDisks;
  }

  /**
   * Returns the maximum total persistent disks size allowed, defined in GB.
   */
  public Long maximumPersistentDisksSizeGb() {
    return maximumPersistentDisksSizeGb;
  }

  /**
   * Returns the deprecation status of the machine type. If {@link DeprecationStatus#status()} is
   * either {@link DeprecationStatus.Status#DELETED} or {@link DeprecationStatus.Status#OBSOLETE}
   * the machine type should not be used. Returns {@code null} if the machine type is not
   * deprecated.
   */
  public DeprecationStatus<MachineTypeId> deprecationStatus() {
    return deprecationStatus;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("machineTypeId", machineTypeId)
        .add("id", id)
        .add("creationTimestamp", creationTimestamp)
        .add("description", description)
        .add("selfLink", selfLink)
        .add("guestCpus", guestCpus)
        .add("memoryMb", memoryMb)
        .add("scratchDisks", scratchDisks)
        .add("maximumPersistentDisks", maximumPersistentDisks)
        .add("maximumPersistentDisksSizeGb", maximumPersistentDisksSizeGb)
        .add("deprecationStatus", deprecationStatus)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(machineTypeId);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof MachineType && Objects.equals(toPb(), ((MachineType) obj).toPb());
  }

  com.google.api.services.compute.model.MachineType toPb() {
    com.google.api.services.compute.model.MachineType machineTypePb =
        new com.google.api.services.compute.model.MachineType();
    machineTypePb.setId(id);
    machineTypePb.setCreationTimestamp(creationTimestamp);
    machineTypePb.setName(machineTypeId.machineType());
    machineTypePb.setDescription(description);
    machineTypePb.setSelfLink(selfLink);
    machineTypePb.setGuestCpus(guestCpus);
    machineTypePb.setMemoryMb(memoryMb);
    if (scratchDisks != null) {
      machineTypePb.setScratchDisks(Lists.transform(scratchDisks,
          new Function<Integer, ScratchDisks>() {
            @Override
            public ScratchDisks apply(Integer diskSize) {
              return new ScratchDisks().setDiskGb(diskSize);
            }
          }));
    }
    machineTypePb.setMaximumPersistentDisks(maximumPersistentDisks);
    machineTypePb.setMaximumPersistentDisksSizeGb(maximumPersistentDisksSizeGb);
    machineTypePb.setZone(machineTypeId.zoneId().zone());
    if (deprecationStatus != null) {
      machineTypePb.setDeprecated(deprecationStatus.toPb());
    }
    return machineTypePb;
  }

  static Builder builder() {
    return new Builder();
  }

  static MachineType fromPb(com.google.api.services.compute.model.MachineType machineTypePb) {
    Builder builder = builder();
    builder.machineTypeId(MachineTypeId.fromUrl(machineTypePb.getSelfLink()));
    builder.id(machineTypePb.getId());
    builder.creationTimestamp(machineTypePb.getCreationTimestamp());
    builder.description(machineTypePb.getDescription());
    builder.selfLink(machineTypePb.getSelfLink());
    builder.guestCpus(machineTypePb.getGuestCpus());
    builder.memoryMb(machineTypePb.getMemoryMb());
    if (machineTypePb.getScratchDisks() != null) {
      builder.scratchDisks(
          Lists.transform(machineTypePb.getScratchDisks(), new Function<ScratchDisks, Integer>() {
            @Override
            public Integer apply(ScratchDisks scratchDiskPb) {
              return scratchDiskPb.getDiskGb();
            }
          }));
    }
    builder.maximumPersistentDisks(machineTypePb.getMaximumPersistentDisks());
    builder.maximumPersistentDisksSizeGb(machineTypePb.getMaximumPersistentDisksSizeGb());
    if (machineTypePb.getDeprecated() != null) {
      builder.deprecationStatus(
          DeprecationStatus.fromPb(machineTypePb.getDeprecated(), MachineTypeId.FROM_URL_FUNCTION));
    }
    return builder.build();
  }
}
