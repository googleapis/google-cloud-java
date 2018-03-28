/*
 * Copyright 2018 Google LLC
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
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
      String zone
      ) {
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
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("creationTimestamp") && creationTimestamp != null) {
      fieldMap.put("creationTimestamp", Collections.singletonList(String.valueOf(creationTimestamp)));
    }
    if (fieldNames.contains("deprecated") && deprecated != null) {
      fieldMap.put("deprecated", Collections.singletonList(String.valueOf(deprecated)));
    }
    if (fieldNames.contains("description") && description != null) {
      fieldMap.put("description", Collections.singletonList(String.valueOf(description)));
    }
    if (fieldNames.contains("guestCpus") && guestCpus != null) {
      fieldMap.put("guestCpus", Collections.singletonList(String.valueOf(guestCpus)));
    }
    if (fieldNames.contains("id") && id != null) {
      fieldMap.put("id", Collections.singletonList(String.valueOf(id)));
    }
    if (fieldNames.contains("imageSpaceGb") && imageSpaceGb != null) {
      fieldMap.put("imageSpaceGb", Collections.singletonList(String.valueOf(imageSpaceGb)));
    }
    if (fieldNames.contains("isSharedCpu") && isSharedCpu != null) {
      fieldMap.put("isSharedCpu", Collections.singletonList(String.valueOf(isSharedCpu)));
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    if (fieldNames.contains("maximumPersistentDisks") && maximumPersistentDisks != null) {
      fieldMap.put("maximumPersistentDisks", Collections.singletonList(String.valueOf(maximumPersistentDisks)));
    }
    if (fieldNames.contains("maximumPersistentDisksSizeGb") && maximumPersistentDisksSizeGb != null) {
      fieldMap.put("maximumPersistentDisksSizeGb", Collections.singletonList(String.valueOf(maximumPersistentDisksSizeGb)));
    }
    if (fieldNames.contains("memoryMb") && memoryMb != null) {
      fieldMap.put("memoryMb", Collections.singletonList(String.valueOf(memoryMb)));
    }
    if (fieldNames.contains("name") && name != null) {
      fieldMap.put("name", Collections.singletonList(String.valueOf(name)));
    }
    if (fieldNames.contains("scratchDisks") && scratchDisks != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (ScratchDisks item : scratchDisks) {
        stringList.add(item.toString());
      }
      fieldMap.put("scratchDisks", stringList.build());
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    if (fieldNames.contains("zone") && zone != null) {
      fieldMap.put("zone", Collections.singletonList(String.valueOf(zone)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("creationTimestamp")) {
      return String.valueOf(creationTimestamp);
    }
    if (fieldName.equals("deprecated")) {
      return String.valueOf(deprecated);
    }
    if (fieldName.equals("description")) {
      return String.valueOf(description);
    }
    if (fieldName.equals("guestCpus")) {
      return String.valueOf(guestCpus);
    }
    if (fieldName.equals("id")) {
      return String.valueOf(id);
    }
    if (fieldName.equals("imageSpaceGb")) {
      return String.valueOf(imageSpaceGb);
    }
    if (fieldName.equals("isSharedCpu")) {
      return String.valueOf(isSharedCpu);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("maximumPersistentDisks")) {
      return String.valueOf(maximumPersistentDisks);
    }
    if (fieldName.equals("maximumPersistentDisksSizeGb")) {
      return String.valueOf(maximumPersistentDisksSizeGb);
    }
    if (fieldName.equals("memoryMb")) {
      return String.valueOf(memoryMb);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("scratchDisks")) {
      return String.valueOf(scratchDisks);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    if (fieldName.equals("zone")) {
      return String.valueOf(zone);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public DeprecationStatus getDeprecated() {
    return deprecated;
  }

  public String getDescription() {
    return description;
  }

  public Integer getGuestCpus() {
    return guestCpus;
  }

  public String getId() {
    return id;
  }

  public Integer getImageSpaceGb() {
    return imageSpaceGb;
  }

  public Boolean getIsSharedCpu() {
    return isSharedCpu;
  }

  public String getKind() {
    return kind;
  }

  public Integer getMaximumPersistentDisks() {
    return maximumPersistentDisks;
  }

  public String getMaximumPersistentDisksSizeGb() {
    return maximumPersistentDisksSizeGb;
  }

  public Integer getMemoryMb() {
    return memoryMb;
  }

  public String getName() {
    return name;
  }

  public List<ScratchDisks> getScratchDisksList() {
    return scratchDisks;
  }

  public String getSelfLink() {
    return selfLink;
  }

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
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
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

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public DeprecationStatus getDeprecated() {
      return deprecated;
    }

    public Builder setDeprecated(DeprecationStatus deprecated) {
      this.deprecated = deprecated;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public Integer getGuestCpus() {
      return guestCpus;
    }

    public Builder setGuestCpus(Integer guestCpus) {
      this.guestCpus = guestCpus;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public Integer getImageSpaceGb() {
      return imageSpaceGb;
    }

    public Builder setImageSpaceGb(Integer imageSpaceGb) {
      this.imageSpaceGb = imageSpaceGb;
      return this;
    }

    public Boolean getIsSharedCpu() {
      return isSharedCpu;
    }

    public Builder setIsSharedCpu(Boolean isSharedCpu) {
      this.isSharedCpu = isSharedCpu;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public Integer getMaximumPersistentDisks() {
      return maximumPersistentDisks;
    }

    public Builder setMaximumPersistentDisks(Integer maximumPersistentDisks) {
      this.maximumPersistentDisks = maximumPersistentDisks;
      return this;
    }

    public String getMaximumPersistentDisksSizeGb() {
      return maximumPersistentDisksSizeGb;
    }

    public Builder setMaximumPersistentDisksSizeGb(String maximumPersistentDisksSizeGb) {
      this.maximumPersistentDisksSizeGb = maximumPersistentDisksSizeGb;
      return this;
    }

    public Integer getMemoryMb() {
      return memoryMb;
    }

    public Builder setMemoryMb(Integer memoryMb) {
      this.memoryMb = memoryMb;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public List<ScratchDisks> getScratchDisksList() {
      return scratchDisks;
    }

    public Builder addAllScratchDisks(List<ScratchDisks> scratchDisks) {
      if (this.scratchDisks == null) {
        this.scratchDisks = new ArrayList<>(scratchDisks.size());
      }
      this.scratchDisks.addAll(scratchDisks);
      return this;
    }

    public Builder addScratchDisks(ScratchDisks scratchDisks) {
      this.scratchDisks.add(scratchDisks);
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public String getZone() {
      return zone;
    }

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
        zone
      );
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
        + "creationTimestamp=" + creationTimestamp + ", "
        + "deprecated=" + deprecated + ", "
        + "description=" + description + ", "
        + "guestCpus=" + guestCpus + ", "
        + "id=" + id + ", "
        + "imageSpaceGb=" + imageSpaceGb + ", "
        + "isSharedCpu=" + isSharedCpu + ", "
        + "kind=" + kind + ", "
        + "maximumPersistentDisks=" + maximumPersistentDisks + ", "
        + "maximumPersistentDisksSizeGb=" + maximumPersistentDisksSizeGb + ", "
        + "memoryMb=" + memoryMb + ", "
        + "name=" + name + ", "
        + "scratchDisks=" + scratchDisks + ", "
        + "selfLink=" + selfLink + ", "
        + "zone=" + zone
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof MachineType) {
      MachineType that = (MachineType) o;
      return
          Objects.equals(this.creationTimestamp, that.getCreationTimestamp()) &&
          Objects.equals(this.deprecated, that.getDeprecated()) &&
          Objects.equals(this.description, that.getDescription()) &&
          Objects.equals(this.guestCpus, that.getGuestCpus()) &&
          Objects.equals(this.id, that.getId()) &&
          Objects.equals(this.imageSpaceGb, that.getImageSpaceGb()) &&
          Objects.equals(this.isSharedCpu, that.getIsSharedCpu()) &&
          Objects.equals(this.kind, that.getKind()) &&
          Objects.equals(this.maximumPersistentDisks, that.getMaximumPersistentDisks()) &&
          Objects.equals(this.maximumPersistentDisksSizeGb, that.getMaximumPersistentDisksSizeGb()) &&
          Objects.equals(this.memoryMb, that.getMemoryMb()) &&
          Objects.equals(this.name, that.getName()) &&
          Objects.equals(this.scratchDisks, that.getScratchDisksList()) &&
          Objects.equals(this.selfLink, that.getSelfLink()) &&
          Objects.equals(this.zone, that.getZone())
          ;
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
      zone
    );
  }
}
