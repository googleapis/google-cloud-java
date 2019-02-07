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
 * An Instance Group Manager resource. (== resource_for beta.instanceGroupManagers ==) (==
 * resource_for v1.instanceGroupManagers ==) (== resource_for beta.regionInstanceGroupManagers ==)
 * (== resource_for v1.regionInstanceGroupManagers ==)
 */
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

  /** The autohealing policy for this managed instance group. You can specify only one value. */
  public List<InstanceGroupManagerAutoHealingPolicy> getAutoHealingPoliciesList() {
    return autoHealingPolicies;
  }

  /**
   * The base instance name to use for instances in this group. The value must be 1-58 characters
   * long. Instances are named by appending a hyphen and a random four-character string to the base
   * instance name. The base instance name must comply with RFC1035.
   */
  public String getBaseInstanceName() {
    return baseInstanceName;
  }

  /**
   * [Output Only] The creation timestamp for this managed instance group in RFC3339 text format.
   */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * [Output Only] The list of instance actions and the number of instances in this managed instance
   * group that are scheduled for each of those actions.
   */
  public InstanceGroupManagerActionsSummary getCurrentActions() {
    return currentActions;
  }

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
  }

  /** Policy specifying intended distribution of instances in regional managed instance group. */
  public DistributionPolicy getDistributionPolicy() {
    return distributionPolicy;
  }

  /**
   * Fingerprint of this resource. This field may be used in optimistic locking. It will be ignored
   * when inserting an InstanceGroupManager. An up-to-date fingerprint must be provided in order to
   * update the InstanceGroupManager, otherwise the request will fail with error 412
   * conditionNotMet.
   *
   * <p>To see the latest fingerprint, make a get() request to retrieve an InstanceGroupManager.
   */
  public String getFingerprint() {
    return fingerprint;
  }

  /**
   * [Output Only] A unique identifier for this resource type. The server generates this identifier.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] The URL of the Instance Group resource. */
  public String getInstanceGroup() {
    return instanceGroup;
  }

  /**
   * The URL of the instance template that is specified for this managed instance group. The group
   * uses this template to create all new instances in the managed instance group.
   */
  public String getInstanceTemplate() {
    return instanceTemplate;
  }

  /**
   * [Output Only] The resource type, which is always compute#instanceGroupManager for managed
   * instance groups.
   */
  public String getKind() {
    return kind;
  }

  /**
   * The name of the managed instance group. The name must be 1-63 characters long, and comply with
   * RFC1035.
   */
  public String getName() {
    return name;
  }

  /**
   * Named ports configured for the Instance Groups complementary to this Instance Group Manager.
   */
  public List<NamedPort> getNamedPortsList() {
    return namedPorts;
  }

  /**
   * [Output Only] The URL of the region where the managed instance group resides (for regional
   * resources).
   */
  public String getRegion() {
    return region;
  }

  /** [Output Only] The URL for this managed instance group. The server defines this URL. */
  public String getSelfLink() {
    return selfLink;
  }

  /** [Output Only] The status of this managed instance group. */
  public InstanceGroupManagerStatus getStatus() {
    return status;
  }

  /**
   * The URLs for all TargetPool resources to which instances in the instanceGroup field are added.
   * The target pools automatically apply to all of the instances in the managed instance group.
   */
  public List<String> getTargetPoolsList() {
    return targetPools;
  }

  /**
   * The target number of running instances for this managed instance group. Deleting or abandoning
   * instances reduces this number. Resizing the group changes this number.
   */
  public Integer getTargetSize() {
    return targetSize;
  }

  /** The update policy for this managed instance group. */
  public InstanceGroupManagerUpdatePolicy getUpdatePolicy() {
    return updatePolicy;
  }

  /**
   * Specifies the instance templates used by this managed instance group to create instances.
   *
   * <p>Each version is defined by an instanceTemplate. Every template can appear at most once per
   * instance group. This field overrides the top-level instanceTemplate field. Read more about the
   * relationships between these fields. Exactly one version must leave the targetSize field unset.
   * That version will be applied to all remaining instances. For more information, read about
   * canary updates.
   */
  public List<InstanceGroupManagerVersion> getVersionsList() {
    return versions;
  }

  /**
   * [Output Only] The URL of the zone where the managed instance group is located (for zonal
   * resources).
   */
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

    /** The autohealing policy for this managed instance group. You can specify only one value. */
    public List<InstanceGroupManagerAutoHealingPolicy> getAutoHealingPoliciesList() {
      return autoHealingPolicies;
    }

    /** The autohealing policy for this managed instance group. You can specify only one value. */
    public Builder addAllAutoHealingPolicies(
        List<InstanceGroupManagerAutoHealingPolicy> autoHealingPolicies) {
      if (this.autoHealingPolicies == null) {
        this.autoHealingPolicies = new LinkedList<>();
      }
      this.autoHealingPolicies.addAll(autoHealingPolicies);
      return this;
    }

    /** The autohealing policy for this managed instance group. You can specify only one value. */
    public Builder addAutoHealingPolicies(
        InstanceGroupManagerAutoHealingPolicy autoHealingPolicies) {
      if (this.autoHealingPolicies == null) {
        this.autoHealingPolicies = new LinkedList<>();
      }
      this.autoHealingPolicies.add(autoHealingPolicies);
      return this;
    }

    /**
     * The base instance name to use for instances in this group. The value must be 1-58 characters
     * long. Instances are named by appending a hyphen and a random four-character string to the
     * base instance name. The base instance name must comply with RFC1035.
     */
    public String getBaseInstanceName() {
      return baseInstanceName;
    }

    /**
     * The base instance name to use for instances in this group. The value must be 1-58 characters
     * long. Instances are named by appending a hyphen and a random four-character string to the
     * base instance name. The base instance name must comply with RFC1035.
     */
    public Builder setBaseInstanceName(String baseInstanceName) {
      this.baseInstanceName = baseInstanceName;
      return this;
    }

    /**
     * [Output Only] The creation timestamp for this managed instance group in RFC3339 text format.
     */
    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    /**
     * [Output Only] The creation timestamp for this managed instance group in RFC3339 text format.
     */
    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    /**
     * [Output Only] The list of instance actions and the number of instances in this managed
     * instance group that are scheduled for each of those actions.
     */
    public InstanceGroupManagerActionsSummary getCurrentActions() {
      return currentActions;
    }

    /**
     * [Output Only] The list of instance actions and the number of instances in this managed
     * instance group that are scheduled for each of those actions.
     */
    public Builder setCurrentActions(InstanceGroupManagerActionsSummary currentActions) {
      this.currentActions = currentActions;
      return this;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public String getDescription() {
      return description;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /** Policy specifying intended distribution of instances in regional managed instance group. */
    public DistributionPolicy getDistributionPolicy() {
      return distributionPolicy;
    }

    /** Policy specifying intended distribution of instances in regional managed instance group. */
    public Builder setDistributionPolicy(DistributionPolicy distributionPolicy) {
      this.distributionPolicy = distributionPolicy;
      return this;
    }

    /**
     * Fingerprint of this resource. This field may be used in optimistic locking. It will be
     * ignored when inserting an InstanceGroupManager. An up-to-date fingerprint must be provided in
     * order to update the InstanceGroupManager, otherwise the request will fail with error 412
     * conditionNotMet.
     *
     * <p>To see the latest fingerprint, make a get() request to retrieve an InstanceGroupManager.
     */
    public String getFingerprint() {
      return fingerprint;
    }

    /**
     * Fingerprint of this resource. This field may be used in optimistic locking. It will be
     * ignored when inserting an InstanceGroupManager. An up-to-date fingerprint must be provided in
     * order to update the InstanceGroupManager, otherwise the request will fail with error 412
     * conditionNotMet.
     *
     * <p>To see the latest fingerprint, make a get() request to retrieve an InstanceGroupManager.
     */
    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    /**
     * [Output Only] A unique identifier for this resource type. The server generates this
     * identifier.
     */
    public String getId() {
      return id;
    }

    /**
     * [Output Only] A unique identifier for this resource type. The server generates this
     * identifier.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /** [Output Only] The URL of the Instance Group resource. */
    public String getInstanceGroup() {
      return instanceGroup;
    }

    /** [Output Only] The URL of the Instance Group resource. */
    public Builder setInstanceGroup(String instanceGroup) {
      this.instanceGroup = instanceGroup;
      return this;
    }

    /**
     * The URL of the instance template that is specified for this managed instance group. The group
     * uses this template to create all new instances in the managed instance group.
     */
    public String getInstanceTemplate() {
      return instanceTemplate;
    }

    /**
     * The URL of the instance template that is specified for this managed instance group. The group
     * uses this template to create all new instances in the managed instance group.
     */
    public Builder setInstanceTemplate(String instanceTemplate) {
      this.instanceTemplate = instanceTemplate;
      return this;
    }

    /**
     * [Output Only] The resource type, which is always compute#instanceGroupManager for managed
     * instance groups.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] The resource type, which is always compute#instanceGroupManager for managed
     * instance groups.
     */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * The name of the managed instance group. The name must be 1-63 characters long, and comply
     * with RFC1035.
     */
    public String getName() {
      return name;
    }

    /**
     * The name of the managed instance group. The name must be 1-63 characters long, and comply
     * with RFC1035.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * Named ports configured for the Instance Groups complementary to this Instance Group Manager.
     */
    public List<NamedPort> getNamedPortsList() {
      return namedPorts;
    }

    /**
     * Named ports configured for the Instance Groups complementary to this Instance Group Manager.
     */
    public Builder addAllNamedPorts(List<NamedPort> namedPorts) {
      if (this.namedPorts == null) {
        this.namedPorts = new LinkedList<>();
      }
      this.namedPorts.addAll(namedPorts);
      return this;
    }

    /**
     * Named ports configured for the Instance Groups complementary to this Instance Group Manager.
     */
    public Builder addNamedPorts(NamedPort namedPorts) {
      if (this.namedPorts == null) {
        this.namedPorts = new LinkedList<>();
      }
      this.namedPorts.add(namedPorts);
      return this;
    }

    /**
     * [Output Only] The URL of the region where the managed instance group resides (for regional
     * resources).
     */
    public String getRegion() {
      return region;
    }

    /**
     * [Output Only] The URL of the region where the managed instance group resides (for regional
     * resources).
     */
    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    /** [Output Only] The URL for this managed instance group. The server defines this URL. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] The URL for this managed instance group. The server defines this URL. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /** [Output Only] The status of this managed instance group. */
    public InstanceGroupManagerStatus getStatus() {
      return status;
    }

    /** [Output Only] The status of this managed instance group. */
    public Builder setStatus(InstanceGroupManagerStatus status) {
      this.status = status;
      return this;
    }

    /**
     * The URLs for all TargetPool resources to which instances in the instanceGroup field are
     * added. The target pools automatically apply to all of the instances in the managed instance
     * group.
     */
    public List<String> getTargetPoolsList() {
      return targetPools;
    }

    /**
     * The URLs for all TargetPool resources to which instances in the instanceGroup field are
     * added. The target pools automatically apply to all of the instances in the managed instance
     * group.
     */
    public Builder addAllTargetPools(List<String> targetPools) {
      if (this.targetPools == null) {
        this.targetPools = new LinkedList<>();
      }
      this.targetPools.addAll(targetPools);
      return this;
    }

    /**
     * The URLs for all TargetPool resources to which instances in the instanceGroup field are
     * added. The target pools automatically apply to all of the instances in the managed instance
     * group.
     */
    public Builder addTargetPools(String targetPools) {
      if (this.targetPools == null) {
        this.targetPools = new LinkedList<>();
      }
      this.targetPools.add(targetPools);
      return this;
    }

    /**
     * The target number of running instances for this managed instance group. Deleting or
     * abandoning instances reduces this number. Resizing the group changes this number.
     */
    public Integer getTargetSize() {
      return targetSize;
    }

    /**
     * The target number of running instances for this managed instance group. Deleting or
     * abandoning instances reduces this number. Resizing the group changes this number.
     */
    public Builder setTargetSize(Integer targetSize) {
      this.targetSize = targetSize;
      return this;
    }

    /** The update policy for this managed instance group. */
    public InstanceGroupManagerUpdatePolicy getUpdatePolicy() {
      return updatePolicy;
    }

    /** The update policy for this managed instance group. */
    public Builder setUpdatePolicy(InstanceGroupManagerUpdatePolicy updatePolicy) {
      this.updatePolicy = updatePolicy;
      return this;
    }

    /**
     * Specifies the instance templates used by this managed instance group to create instances.
     *
     * <p>Each version is defined by an instanceTemplate. Every template can appear at most once per
     * instance group. This field overrides the top-level instanceTemplate field. Read more about
     * the relationships between these fields. Exactly one version must leave the targetSize field
     * unset. That version will be applied to all remaining instances. For more information, read
     * about canary updates.
     */
    public List<InstanceGroupManagerVersion> getVersionsList() {
      return versions;
    }

    /**
     * Specifies the instance templates used by this managed instance group to create instances.
     *
     * <p>Each version is defined by an instanceTemplate. Every template can appear at most once per
     * instance group. This field overrides the top-level instanceTemplate field. Read more about
     * the relationships between these fields. Exactly one version must leave the targetSize field
     * unset. That version will be applied to all remaining instances. For more information, read
     * about canary updates.
     */
    public Builder addAllVersions(List<InstanceGroupManagerVersion> versions) {
      if (this.versions == null) {
        this.versions = new LinkedList<>();
      }
      this.versions.addAll(versions);
      return this;
    }

    /**
     * Specifies the instance templates used by this managed instance group to create instances.
     *
     * <p>Each version is defined by an instanceTemplate. Every template can appear at most once per
     * instance group. This field overrides the top-level instanceTemplate field. Read more about
     * the relationships between these fields. Exactly one version must leave the targetSize field
     * unset. That version will be applied to all remaining instances. For more information, read
     * about canary updates.
     */
    public Builder addVersions(InstanceGroupManagerVersion versions) {
      if (this.versions == null) {
        this.versions = new LinkedList<>();
      }
      this.versions.add(versions);
      return this;
    }

    /**
     * [Output Only] The URL of the zone where the managed instance group is located (for zonal
     * resources).
     */
    public String getZone() {
      return zone;
    }

    /**
     * [Output Only] The URL of the zone where the managed instance group is located (for zonal
     * resources).
     */
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
