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
public final class InstanceGroupManager implements ApiMessage {
  private final List<InstanceGroupManagerAutoHealingPolicy> autoHealingPolicies;
  private final String baseInstanceName;
  private final String creationTimestamp;
  private final InstanceGroupManagerActionsSummary currentActions;
  private final String description;
  private final DistributionPolicy distributionPolicy;
  private final String fingerprint;
  private final String id;
  private final String instanceGroup;
  private final String instanceTemplate;
  private final String kind;
  private final String name;
  private final List<NamedPort> namedPorts;
  private final String region;
  private final String selfLink;
  private final InstanceGroupManagerStatus status;
  private final List<String> targetPools;
  private final Integer targetSize;
  private final InstanceGroupManagerUpdatePolicy updatePolicy;
  private final List<InstanceGroupManagerVersion> versions;
  private final String zone;

  private InstanceGroupManager() {
    this.autoHealingPolicies = null;
    this.baseInstanceName = null;
    this.creationTimestamp = null;
    this.currentActions = null;
    this.description = null;
    this.distributionPolicy = null;
    this.fingerprint = null;
    this.id = null;
    this.instanceGroup = null;
    this.instanceTemplate = null;
    this.kind = null;
    this.name = null;
    this.namedPorts = null;
    this.region = null;
    this.selfLink = null;
    this.status = null;
    this.targetPools = null;
    this.targetSize = null;
    this.updatePolicy = null;
    this.versions = null;
    this.zone = null;
  }

  private InstanceGroupManager(
      List<InstanceGroupManagerAutoHealingPolicy> autoHealingPolicies,
      String baseInstanceName,
      String creationTimestamp,
      InstanceGroupManagerActionsSummary currentActions,
      String description,
      DistributionPolicy distributionPolicy,
      String fingerprint,
      String id,
      String instanceGroup,
      String instanceTemplate,
      String kind,
      String name,
      List<NamedPort> namedPorts,
      String region,
      String selfLink,
      InstanceGroupManagerStatus status,
      List<String> targetPools,
      Integer targetSize,
      InstanceGroupManagerUpdatePolicy updatePolicy,
      List<InstanceGroupManagerVersion> versions,
      String zone) {
    this.autoHealingPolicies = autoHealingPolicies;
    this.baseInstanceName = baseInstanceName;
    this.creationTimestamp = creationTimestamp;
    this.currentActions = currentActions;
    this.description = description;
    this.distributionPolicy = distributionPolicy;
    this.fingerprint = fingerprint;
    this.id = id;
    this.instanceGroup = instanceGroup;
    this.instanceTemplate = instanceTemplate;
    this.kind = kind;
    this.name = name;
    this.namedPorts = namedPorts;
    this.region = region;
    this.selfLink = selfLink;
    this.status = status;
    this.targetPools = targetPools;
    this.targetSize = targetSize;
    this.updatePolicy = updatePolicy;
    this.versions = versions;
    this.zone = zone;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("autoHealingPolicies".equals(fieldName)) {
      return autoHealingPolicies;
    }
    if ("baseInstanceName".equals(fieldName)) {
      return baseInstanceName;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("currentActions".equals(fieldName)) {
      return currentActions;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("distributionPolicy".equals(fieldName)) {
      return distributionPolicy;
    }
    if ("fingerprint".equals(fieldName)) {
      return fingerprint;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("instanceGroup".equals(fieldName)) {
      return instanceGroup;
    }
    if ("instanceTemplate".equals(fieldName)) {
      return instanceTemplate;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("namedPorts".equals(fieldName)) {
      return namedPorts;
    }
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("status".equals(fieldName)) {
      return status;
    }
    if ("targetPools".equals(fieldName)) {
      return targetPools;
    }
    if ("targetSize".equals(fieldName)) {
      return targetSize;
    }
    if ("updatePolicy".equals(fieldName)) {
      return updatePolicy;
    }
    if ("versions".equals(fieldName)) {
      return versions;
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
  public List<String> getFieldMask() {
    return null;
  }

  public List<InstanceGroupManagerAutoHealingPolicy> getAutoHealingPoliciesList() {
    return autoHealingPolicies;
  }

  public String getBaseInstanceName() {
    return baseInstanceName;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public InstanceGroupManagerActionsSummary getCurrentActions() {
    return currentActions;
  }

  public String getDescription() {
    return description;
  }

  public DistributionPolicy getDistributionPolicy() {
    return distributionPolicy;
  }

  public String getFingerprint() {
    return fingerprint;
  }

  public String getId() {
    return id;
  }

  public String getInstanceGroup() {
    return instanceGroup;
  }

  public String getInstanceTemplate() {
    return instanceTemplate;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public List<NamedPort> getNamedPortsList() {
    return namedPorts;
  }

  public String getRegion() {
    return region;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public InstanceGroupManagerStatus getStatus() {
    return status;
  }

  public List<String> getTargetPoolsList() {
    return targetPools;
  }

  public Integer getTargetSize() {
    return targetSize;
  }

  public InstanceGroupManagerUpdatePolicy getUpdatePolicy() {
    return updatePolicy;
  }

  public List<InstanceGroupManagerVersion> getVersionsList() {
    return versions;
  }

  public String getZone() {
    return zone;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManager prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManager getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManager DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManager();
  }

  public static class Builder {
    private List<InstanceGroupManagerAutoHealingPolicy> autoHealingPolicies;
    private String baseInstanceName;
    private String creationTimestamp;
    private InstanceGroupManagerActionsSummary currentActions;
    private String description;
    private DistributionPolicy distributionPolicy;
    private String fingerprint;
    private String id;
    private String instanceGroup;
    private String instanceTemplate;
    private String kind;
    private String name;
    private List<NamedPort> namedPorts;
    private String region;
    private String selfLink;
    private InstanceGroupManagerStatus status;
    private List<String> targetPools;
    private Integer targetSize;
    private InstanceGroupManagerUpdatePolicy updatePolicy;
    private List<InstanceGroupManagerVersion> versions;
    private String zone;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManager other) {
      if (other == InstanceGroupManager.getDefaultInstance()) return this;
      if (other.getAutoHealingPoliciesList() != null) {
        this.autoHealingPolicies = other.autoHealingPolicies;
      }
      if (other.getBaseInstanceName() != null) {
        this.baseInstanceName = other.baseInstanceName;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getCurrentActions() != null) {
        this.currentActions = other.currentActions;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getDistributionPolicy() != null) {
        this.distributionPolicy = other.distributionPolicy;
      }
      if (other.getFingerprint() != null) {
        this.fingerprint = other.fingerprint;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getInstanceGroup() != null) {
        this.instanceGroup = other.instanceGroup;
      }
      if (other.getInstanceTemplate() != null) {
        this.instanceTemplate = other.instanceTemplate;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getNamedPortsList() != null) {
        this.namedPorts = other.namedPorts;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      if (other.getTargetPoolsList() != null) {
        this.targetPools = other.targetPools;
      }
      if (other.getTargetSize() != null) {
        this.targetSize = other.targetSize;
      }
      if (other.getUpdatePolicy() != null) {
        this.updatePolicy = other.updatePolicy;
      }
      if (other.getVersionsList() != null) {
        this.versions = other.versions;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(InstanceGroupManager source) {
      this.autoHealingPolicies = source.autoHealingPolicies;
      this.baseInstanceName = source.baseInstanceName;
      this.creationTimestamp = source.creationTimestamp;
      this.currentActions = source.currentActions;
      this.description = source.description;
      this.distributionPolicy = source.distributionPolicy;
      this.fingerprint = source.fingerprint;
      this.id = source.id;
      this.instanceGroup = source.instanceGroup;
      this.instanceTemplate = source.instanceTemplate;
      this.kind = source.kind;
      this.name = source.name;
      this.namedPorts = source.namedPorts;
      this.region = source.region;
      this.selfLink = source.selfLink;
      this.status = source.status;
      this.targetPools = source.targetPools;
      this.targetSize = source.targetSize;
      this.updatePolicy = source.updatePolicy;
      this.versions = source.versions;
      this.zone = source.zone;
    }

    public List<InstanceGroupManagerAutoHealingPolicy> getAutoHealingPoliciesList() {
      return autoHealingPolicies;
    }

    public Builder addAllAutoHealingPolicies(
        List<InstanceGroupManagerAutoHealingPolicy> autoHealingPolicies) {
      if (this.autoHealingPolicies == null) {
        this.autoHealingPolicies = new LinkedList<>();
      }
      this.autoHealingPolicies.addAll(autoHealingPolicies);
      return this;
    }

    public Builder addAutoHealingPolicies(
        InstanceGroupManagerAutoHealingPolicy autoHealingPolicies) {
      if (this.autoHealingPolicies == null) {
        this.autoHealingPolicies = new LinkedList<>();
      }
      this.autoHealingPolicies.add(autoHealingPolicies);
      return this;
    }

    public String getBaseInstanceName() {
      return baseInstanceName;
    }

    public Builder setBaseInstanceName(String baseInstanceName) {
      this.baseInstanceName = baseInstanceName;
      return this;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public InstanceGroupManagerActionsSummary getCurrentActions() {
      return currentActions;
    }

    public Builder setCurrentActions(InstanceGroupManagerActionsSummary currentActions) {
      this.currentActions = currentActions;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public DistributionPolicy getDistributionPolicy() {
      return distributionPolicy;
    }

    public Builder setDistributionPolicy(DistributionPolicy distributionPolicy) {
      this.distributionPolicy = distributionPolicy;
      return this;
    }

    public String getFingerprint() {
      return fingerprint;
    }

    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public String getInstanceGroup() {
      return instanceGroup;
    }

    public Builder setInstanceGroup(String instanceGroup) {
      this.instanceGroup = instanceGroup;
      return this;
    }

    public String getInstanceTemplate() {
      return instanceTemplate;
    }

    public Builder setInstanceTemplate(String instanceTemplate) {
      this.instanceTemplate = instanceTemplate;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public List<NamedPort> getNamedPortsList() {
      return namedPorts;
    }

    public Builder addAllNamedPorts(List<NamedPort> namedPorts) {
      if (this.namedPorts == null) {
        this.namedPorts = new LinkedList<>();
      }
      this.namedPorts.addAll(namedPorts);
      return this;
    }

    public Builder addNamedPorts(NamedPort namedPorts) {
      if (this.namedPorts == null) {
        this.namedPorts = new LinkedList<>();
      }
      this.namedPorts.add(namedPorts);
      return this;
    }

    public String getRegion() {
      return region;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public InstanceGroupManagerStatus getStatus() {
      return status;
    }

    public Builder setStatus(InstanceGroupManagerStatus status) {
      this.status = status;
      return this;
    }

    public List<String> getTargetPoolsList() {
      return targetPools;
    }

    public Builder addAllTargetPools(List<String> targetPools) {
      if (this.targetPools == null) {
        this.targetPools = new LinkedList<>();
      }
      this.targetPools.addAll(targetPools);
      return this;
    }

    public Builder addTargetPools(String targetPools) {
      if (this.targetPools == null) {
        this.targetPools = new LinkedList<>();
      }
      this.targetPools.add(targetPools);
      return this;
    }

    public Integer getTargetSize() {
      return targetSize;
    }

    public Builder setTargetSize(Integer targetSize) {
      this.targetSize = targetSize;
      return this;
    }

    public InstanceGroupManagerUpdatePolicy getUpdatePolicy() {
      return updatePolicy;
    }

    public Builder setUpdatePolicy(InstanceGroupManagerUpdatePolicy updatePolicy) {
      this.updatePolicy = updatePolicy;
      return this;
    }

    public List<InstanceGroupManagerVersion> getVersionsList() {
      return versions;
    }

    public Builder addAllVersions(List<InstanceGroupManagerVersion> versions) {
      if (this.versions == null) {
        this.versions = new LinkedList<>();
      }
      this.versions.addAll(versions);
      return this;
    }

    public Builder addVersions(InstanceGroupManagerVersion versions) {
      if (this.versions == null) {
        this.versions = new LinkedList<>();
      }
      this.versions.add(versions);
      return this;
    }

    public String getZone() {
      return zone;
    }

    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public InstanceGroupManager build() {

      return new InstanceGroupManager(
          autoHealingPolicies,
          baseInstanceName,
          creationTimestamp,
          currentActions,
          description,
          distributionPolicy,
          fingerprint,
          id,
          instanceGroup,
          instanceTemplate,
          kind,
          name,
          namedPorts,
          region,
          selfLink,
          status,
          targetPools,
          targetSize,
          updatePolicy,
          versions,
          zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllAutoHealingPolicies(this.autoHealingPolicies);
      newBuilder.setBaseInstanceName(this.baseInstanceName);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setCurrentActions(this.currentActions);
      newBuilder.setDescription(this.description);
      newBuilder.setDistributionPolicy(this.distributionPolicy);
      newBuilder.setFingerprint(this.fingerprint);
      newBuilder.setId(this.id);
      newBuilder.setInstanceGroup(this.instanceGroup);
      newBuilder.setInstanceTemplate(this.instanceTemplate);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.addAllNamedPorts(this.namedPorts);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setStatus(this.status);
      newBuilder.addAllTargetPools(this.targetPools);
      newBuilder.setTargetSize(this.targetSize);
      newBuilder.setUpdatePolicy(this.updatePolicy);
      newBuilder.addAllVersions(this.versions);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManager{"
        + "autoHealingPolicies="
        + autoHealingPolicies
        + ", "
        + "baseInstanceName="
        + baseInstanceName
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "currentActions="
        + currentActions
        + ", "
        + "description="
        + description
        + ", "
        + "distributionPolicy="
        + distributionPolicy
        + ", "
        + "fingerprint="
        + fingerprint
        + ", "
        + "id="
        + id
        + ", "
        + "instanceGroup="
        + instanceGroup
        + ", "
        + "instanceTemplate="
        + instanceTemplate
        + ", "
        + "kind="
        + kind
        + ", "
        + "name="
        + name
        + ", "
        + "namedPorts="
        + namedPorts
        + ", "
        + "region="
        + region
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "status="
        + status
        + ", "
        + "targetPools="
        + targetPools
        + ", "
        + "targetSize="
        + targetSize
        + ", "
        + "updatePolicy="
        + updatePolicy
        + ", "
        + "versions="
        + versions
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
    if (o instanceof InstanceGroupManager) {
      InstanceGroupManager that = (InstanceGroupManager) o;
      return Objects.equals(this.autoHealingPolicies, that.getAutoHealingPoliciesList())
          && Objects.equals(this.baseInstanceName, that.getBaseInstanceName())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.currentActions, that.getCurrentActions())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.distributionPolicy, that.getDistributionPolicy())
          && Objects.equals(this.fingerprint, that.getFingerprint())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.instanceGroup, that.getInstanceGroup())
          && Objects.equals(this.instanceTemplate, that.getInstanceTemplate())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.namedPorts, that.getNamedPortsList())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.status, that.getStatus())
          && Objects.equals(this.targetPools, that.getTargetPoolsList())
          && Objects.equals(this.targetSize, that.getTargetSize())
          && Objects.equals(this.updatePolicy, that.getUpdatePolicy())
          && Objects.equals(this.versions, that.getVersionsList())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        autoHealingPolicies,
        baseInstanceName,
        creationTimestamp,
        currentActions,
        description,
        distributionPolicy,
        fingerprint,
        id,
        instanceGroup,
        instanceTemplate,
        kind,
        name,
        namedPorts,
        region,
        selfLink,
        status,
        targetPools,
        targetSize,
        updatePolicy,
        versions,
        zone);
  }
}
