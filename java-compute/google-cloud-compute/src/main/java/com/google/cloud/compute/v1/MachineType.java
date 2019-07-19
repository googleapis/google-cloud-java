/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * Represents a Machine Type resource.
 *
 * <p>You can use specific machine types for your VM instances based on performance and pricing
 * requirements. For more information, read Machine Types. (== resource_for v1.machineTypes ==) (==
 * resource_for beta.machineTypes ==)
 */
public final class MachineType implements ApiMessage {
  private final String creationTimestamp;
  private final DeprecationStatus deprecated;
  private final String description;
  private final Integer guestCpus;
  private final String id;
  private final Integer imageSpaceGb;
  private final Boolean isSharedCpu;
  private final String kind;
  private final Integer maximumPersistentDisks;
  private final String maximumPersistentDisksSizeGb;
  private final Integer memoryMb;
  private final String name;
  private final List<ScratchDisks> scratchDisks;
  private final String selfLink;
  private final String zone;

  private MachineType() {
    this.creationTimestamp = null;
    this.deprecated = null;
    this.description = null;
    this.guestCpus = null;
    this.id = null;
    this.imageSpaceGb = null;
    this.isSharedCpu = null;
    this.kind = null;
    this.maximumPersistentDisks = null;
    this.maximumPersistentDisksSizeGb = null;
    this.memoryMb = null;
    this.name = null;
    this.scratchDisks = null;
    this.selfLink = null;
    this.zone = null;
  }

  private MachineType(
      String creationTimestamp,
      DeprecationStatus deprecated,
      String description,
      Integer guestCpus,
      String id,
      Integer imageSpaceGb,
      Boolean isSharedCpu,
      String kind,
      Integer maximumPersistentDisks,
      String maximumPersistentDisksSizeGb,
      Integer memoryMb,
      String name,
      List<ScratchDisks> scratchDisks,
      String selfLink,
      String zone) {
    this.creationTimestamp = creationTimestamp;
    this.deprecated = deprecated;
    this.description = description;
    this.guestCpus = guestCpus;
    this.id = id;
    this.imageSpaceGb = imageSpaceGb;
    this.isSharedCpu = isSharedCpu;
    this.kind = kind;
    this.maximumPersistentDisks = maximumPersistentDisks;
    this.maximumPersistentDisksSizeGb = maximumPersistentDisksSizeGb;
    this.memoryMb = memoryMb;
    this.name = name;
    this.scratchDisks = scratchDisks;
    this.selfLink = selfLink;
    this.zone = zone;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("deprecated".equals(fieldName)) {
      return deprecated;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("guestCpus".equals(fieldName)) {
      return guestCpus;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("imageSpaceGb".equals(fieldName)) {
      return imageSpaceGb;
    }
    if ("isSharedCpu".equals(fieldName)) {
      return isSharedCpu;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("maximumPersistentDisks".equals(fieldName)) {
      return maximumPersistentDisks;
    }
    if ("maximumPersistentDisksSizeGb".equals(fieldName)) {
      return maximumPersistentDisksSizeGb;
    }
    if ("memoryMb".equals(fieldName)) {
      return memoryMb;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("scratchDisks".equals(fieldName)) {
      return scratchDisks;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("zone".equals(fieldName)) {
      return zone;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /** [Output Only] The deprecation status associated with this machine type. */
  public DeprecationStatus getDeprecated() {
    return deprecated;
  }

  /** [Output Only] An optional textual description of the resource. */
  public String getDescription() {
    return description;
  }

  /** [Output Only] The number of virtual CPUs that are available to the instance. */
  public Integer getGuestCpus() {
    return guestCpus;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /**
   * [Deprecated] This property is deprecated and will never be populated with any relevant values.
   */
  public Integer getImageSpaceGb() {
    return imageSpaceGb;
  }

  /**
   * [Output Only] Whether this machine type has a shared CPU. See Shared-core machine types for
   * more information.
   */
  public Boolean getIsSharedCpu() {
    return isSharedCpu;
  }

  /** [Output Only] The type of the resource. Always compute#machineType for machine types. */
  public String getKind() {
    return kind;
  }

  /** [Output Only] Maximum persistent disks allowed. */
  public Integer getMaximumPersistentDisks() {
    return maximumPersistentDisks;
  }

  /** [Output Only] Maximum total persistent disks size (GB) allowed. */
  public String getMaximumPersistentDisksSizeGb() {
    return maximumPersistentDisksSizeGb;
  }

  /** [Output Only] The amount of physical memory available to the instance, defined in MB. */
  public Integer getMemoryMb() {
    return memoryMb;
  }

  /** [Output Only] Name of the resource. */
  public String getName() {
    return name;
  }

  /** [Output Only] A list of extended scratch disks assigned to the instance. */
  public List<ScratchDisks> getScratchDisksList() {
    return scratchDisks;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** [Output Only] The name of the zone where the machine type resides, such as us-central1-a. */
  public String getZone() {
    return zone;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(MachineType prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static MachineType getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final MachineType DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new MachineType();
  }

  public static class Builder {
    private String creationTimestamp;
    private DeprecationStatus deprecated;
    private String description;
    private Integer guestCpus;
    private String id;
    private Integer imageSpaceGb;
    private Boolean isSharedCpu;
    private String kind;
    private Integer maximumPersistentDisks;
    private String maximumPersistentDisksSizeGb;
    private Integer memoryMb;
    private String name;
    private List<ScratchDisks> scratchDisks;
    private String selfLink;
    private String zone;

    Builder() {}

    public Builder mergeFrom(MachineType other) {
      if (other == MachineType.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDeprecated() != null) {
        this.deprecated = other.deprecated;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getGuestCpus() != null) {
        this.guestCpus = other.guestCpus;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getImageSpaceGb() != null) {
        this.imageSpaceGb = other.imageSpaceGb;
      }
      if (other.getIsSharedCpu() != null) {
        this.isSharedCpu = other.isSharedCpu;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getMaximumPersistentDisks() != null) {
        this.maximumPersistentDisks = other.maximumPersistentDisks;
      }
      if (other.getMaximumPersistentDisksSizeGb() != null) {
        this.maximumPersistentDisksSizeGb = other.maximumPersistentDisksSizeGb;
      }
      if (other.getMemoryMb() != null) {
        this.memoryMb = other.memoryMb;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getScratchDisksList() != null) {
        this.scratchDisks = other.scratchDisks;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(MachineType source) {
      this.creationTimestamp = source.creationTimestamp;
      this.deprecated = source.deprecated;
      this.description = source.description;
      this.guestCpus = source.guestCpus;
      this.id = source.id;
      this.imageSpaceGb = source.imageSpaceGb;
      this.isSharedCpu = source.isSharedCpu;
      this.kind = source.kind;
      this.maximumPersistentDisks = source.maximumPersistentDisks;
      this.maximumPersistentDisksSizeGb = source.maximumPersistentDisksSizeGb;
      this.memoryMb = source.memoryMb;
      this.name = source.name;
      this.scratchDisks = source.scratchDisks;
      this.selfLink = source.selfLink;
      this.zone = source.zone;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    /** [Output Only] The deprecation status associated with this machine type. */
    public DeprecationStatus getDeprecated() {
      return deprecated;
    }

    /** [Output Only] The deprecation status associated with this machine type. */
    public Builder setDeprecated(DeprecationStatus deprecated) {
      this.deprecated = deprecated;
      return this;
    }

    /** [Output Only] An optional textual description of the resource. */
    public String getDescription() {
      return description;
    }

    /** [Output Only] An optional textual description of the resource. */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /** [Output Only] The number of virtual CPUs that are available to the instance. */
    public Integer getGuestCpus() {
      return guestCpus;
    }

    /** [Output Only] The number of virtual CPUs that are available to the instance. */
    public Builder setGuestCpus(Integer guestCpus) {
      this.guestCpus = guestCpus;
      return this;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public String getId() {
      return id;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /**
     * [Deprecated] This property is deprecated and will never be populated with any relevant
     * values.
     */
    public Integer getImageSpaceGb() {
      return imageSpaceGb;
    }

    /**
     * [Deprecated] This property is deprecated and will never be populated with any relevant
     * values.
     */
    public Builder setImageSpaceGb(Integer imageSpaceGb) {
      this.imageSpaceGb = imageSpaceGb;
      return this;
    }

    /**
     * [Output Only] Whether this machine type has a shared CPU. See Shared-core machine types for
     * more information.
     */
    public Boolean getIsSharedCpu() {
      return isSharedCpu;
    }

    /**
     * [Output Only] Whether this machine type has a shared CPU. See Shared-core machine types for
     * more information.
     */
    public Builder setIsSharedCpu(Boolean isSharedCpu) {
      this.isSharedCpu = isSharedCpu;
      return this;
    }

    /** [Output Only] The type of the resource. Always compute#machineType for machine types. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] The type of the resource. Always compute#machineType for machine types. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /** [Output Only] Maximum persistent disks allowed. */
    public Integer getMaximumPersistentDisks() {
      return maximumPersistentDisks;
    }

    /** [Output Only] Maximum persistent disks allowed. */
    public Builder setMaximumPersistentDisks(Integer maximumPersistentDisks) {
      this.maximumPersistentDisks = maximumPersistentDisks;
      return this;
    }

    /** [Output Only] Maximum total persistent disks size (GB) allowed. */
    public String getMaximumPersistentDisksSizeGb() {
      return maximumPersistentDisksSizeGb;
    }

    /** [Output Only] Maximum total persistent disks size (GB) allowed. */
    public Builder setMaximumPersistentDisksSizeGb(String maximumPersistentDisksSizeGb) {
      this.maximumPersistentDisksSizeGb = maximumPersistentDisksSizeGb;
      return this;
    }

    /** [Output Only] The amount of physical memory available to the instance, defined in MB. */
    public Integer getMemoryMb() {
      return memoryMb;
    }

    /** [Output Only] The amount of physical memory available to the instance, defined in MB. */
    public Builder setMemoryMb(Integer memoryMb) {
      this.memoryMb = memoryMb;
      return this;
    }

    /** [Output Only] Name of the resource. */
    public String getName() {
      return name;
    }

    /** [Output Only] Name of the resource. */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /** [Output Only] A list of extended scratch disks assigned to the instance. */
    public List<ScratchDisks> getScratchDisksList() {
      return scratchDisks;
    }

    /** [Output Only] A list of extended scratch disks assigned to the instance. */
    public Builder addAllScratchDisks(List<ScratchDisks> scratchDisks) {
      if (this.scratchDisks == null) {
        this.scratchDisks = new LinkedList<>();
      }
      this.scratchDisks.addAll(scratchDisks);
      return this;
    }

    /** [Output Only] A list of extended scratch disks assigned to the instance. */
    public Builder addScratchDisks(ScratchDisks scratchDisks) {
      if (this.scratchDisks == null) {
        this.scratchDisks = new LinkedList<>();
      }
      this.scratchDisks.add(scratchDisks);
      return this;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /** [Output Only] The name of the zone where the machine type resides, such as us-central1-a. */
    public String getZone() {
      return zone;
    }

    /** [Output Only] The name of the zone where the machine type resides, such as us-central1-a. */
    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public MachineType build() {

      return new MachineType(
          creationTimestamp,
          deprecated,
          description,
          guestCpus,
          id,
          imageSpaceGb,
          isSharedCpu,
          kind,
          maximumPersistentDisks,
          maximumPersistentDisksSizeGb,
          memoryMb,
          name,
          scratchDisks,
          selfLink,
          zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDeprecated(this.deprecated);
      newBuilder.setDescription(this.description);
      newBuilder.setGuestCpus(this.guestCpus);
      newBuilder.setId(this.id);
      newBuilder.setImageSpaceGb(this.imageSpaceGb);
      newBuilder.setIsSharedCpu(this.isSharedCpu);
      newBuilder.setKind(this.kind);
      newBuilder.setMaximumPersistentDisks(this.maximumPersistentDisks);
      newBuilder.setMaximumPersistentDisksSizeGb(this.maximumPersistentDisksSizeGb);
      newBuilder.setMemoryMb(this.memoryMb);
      newBuilder.setName(this.name);
      newBuilder.addAllScratchDisks(this.scratchDisks);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "MachineType{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "deprecated="
        + deprecated
        + ", "
        + "description="
        + description
        + ", "
        + "guestCpus="
        + guestCpus
        + ", "
        + "id="
        + id
        + ", "
        + "imageSpaceGb="
        + imageSpaceGb
        + ", "
        + "isSharedCpu="
        + isSharedCpu
        + ", "
        + "kind="
        + kind
        + ", "
        + "maximumPersistentDisks="
        + maximumPersistentDisks
        + ", "
        + "maximumPersistentDisksSizeGb="
        + maximumPersistentDisksSizeGb
        + ", "
        + "memoryMb="
        + memoryMb
        + ", "
        + "name="
        + name
        + ", "
        + "scratchDisks="
        + scratchDisks
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "zone="
        + zone
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof MachineType) {
      MachineType that = (MachineType) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.deprecated, that.getDeprecated())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.guestCpus, that.getGuestCpus())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.imageSpaceGb, that.getImageSpaceGb())
          && Objects.equals(this.isSharedCpu, that.getIsSharedCpu())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.maximumPersistentDisks, that.getMaximumPersistentDisks())
          && Objects.equals(
              this.maximumPersistentDisksSizeGb, that.getMaximumPersistentDisksSizeGb())
          && Objects.equals(this.memoryMb, that.getMemoryMb())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.scratchDisks, that.getScratchDisksList())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        deprecated,
        description,
        guestCpus,
        id,
        imageSpaceGb,
        isSharedCpu,
        kind,
        maximumPersistentDisks,
        maximumPersistentDisksSizeGb,
        memoryMb,
        name,
        scratchDisks,
        selfLink,
        zone);
  }
}
