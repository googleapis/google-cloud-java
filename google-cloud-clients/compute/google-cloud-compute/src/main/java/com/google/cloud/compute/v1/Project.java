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
 * A Project resource. For an overview of projects, see Cloud Platform Resource Hierarchy. (==
 * resource_for v1.projects ==) (== resource_for beta.projects ==)
 */
public final class Project implements ApiMessage {
  private final Metadata commonInstanceMetadata;
  private final String creationTimestamp;
  private final String defaultNetworkTier;
  private final String defaultServiceAccount;
  private final String description;
  private final List<String> enabledFeatures;
  private final String id;
  private final String kind;
  private final String name;
  private final List<Quota> quotas;
  private final String selfLink;
  private final UsageExportLocation usageExportLocation;
  private final String xpnProjectStatus;

  private Project() {
    this.commonInstanceMetadata = null;
    this.creationTimestamp = null;
    this.defaultNetworkTier = null;
    this.defaultServiceAccount = null;
    this.description = null;
    this.enabledFeatures = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.quotas = null;
    this.selfLink = null;
    this.usageExportLocation = null;
    this.xpnProjectStatus = null;
  }

  private Project(
      Metadata commonInstanceMetadata,
      String creationTimestamp,
      String defaultNetworkTier,
      String defaultServiceAccount,
      String description,
      List<String> enabledFeatures,
      String id,
      String kind,
      String name,
      List<Quota> quotas,
      String selfLink,
      UsageExportLocation usageExportLocation,
      String xpnProjectStatus) {
    this.commonInstanceMetadata = commonInstanceMetadata;
    this.creationTimestamp = creationTimestamp;
    this.defaultNetworkTier = defaultNetworkTier;
    this.defaultServiceAccount = defaultServiceAccount;
    this.description = description;
    this.enabledFeatures = enabledFeatures;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.quotas = quotas;
    this.selfLink = selfLink;
    this.usageExportLocation = usageExportLocation;
    this.xpnProjectStatus = xpnProjectStatus;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("commonInstanceMetadata".equals(fieldName)) {
      return commonInstanceMetadata;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("defaultNetworkTier".equals(fieldName)) {
      return defaultNetworkTier;
    }
    if ("defaultServiceAccount".equals(fieldName)) {
      return defaultServiceAccount;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("enabledFeatures".equals(fieldName)) {
      return enabledFeatures;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("quotas".equals(fieldName)) {
      return quotas;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("usageExportLocation".equals(fieldName)) {
      return usageExportLocation;
    }
    if ("xpnProjectStatus".equals(fieldName)) {
      return xpnProjectStatus;
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

  /**
   * Metadata key/value pairs available to all instances contained in this project. See Custom
   * metadata for more information.
   */
  public Metadata getCommonInstanceMetadata() {
    return commonInstanceMetadata;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * This signifies the default network tier used for configuring resources of the project and can
   * only take the following values: PREMIUM, STANDARD. Initially the default network tier is
   * PREMIUM.
   */
  public String getDefaultNetworkTier() {
    return defaultNetworkTier;
  }

  /** [Output Only] Default service account used by VMs running in this project. */
  public String getDefaultServiceAccount() {
    return defaultServiceAccount;
  }

  /** An optional textual description of the resource. */
  public String getDescription() {
    return description;
  }

  /** Restricted features enabled for use on this project. */
  public List<String> getEnabledFeaturesList() {
    return enabledFeatures;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   * This is not the project ID, and is just a unique ID used by Compute Engine to identify
   * resources.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of the resource. Always compute#project for projects. */
  public String getKind() {
    return kind;
  }

  /**
   * The project ID. For example: my-example-project. Use the project ID to make requests to Compute
   * Engine.
   */
  public String getName() {
    return name;
  }

  /** [Output Only] Quotas assigned to this project. */
  public List<Quota> getQuotasList() {
    return quotas;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * The naming prefix for daily usage reports and the Google Cloud Storage bucket where they are
   * stored.
   */
  public UsageExportLocation getUsageExportLocation() {
    return usageExportLocation;
  }

  /**
   * [Output Only] The role this project has in a shared VPC configuration. Currently only HOST
   * projects are differentiated.
   */
  public String getXpnProjectStatus() {
    return xpnProjectStatus;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Project prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Project getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Project DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Project();
  }

  public static class Builder {
    private Metadata commonInstanceMetadata;
    private String creationTimestamp;
    private String defaultNetworkTier;
    private String defaultServiceAccount;
    private String description;
    private List<String> enabledFeatures;
    private String id;
    private String kind;
    private String name;
    private List<Quota> quotas;
    private String selfLink;
    private UsageExportLocation usageExportLocation;
    private String xpnProjectStatus;

    Builder() {}

    public Builder mergeFrom(Project other) {
      if (other == Project.getDefaultInstance()) return this;
      if (other.getCommonInstanceMetadata() != null) {
        this.commonInstanceMetadata = other.commonInstanceMetadata;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDefaultNetworkTier() != null) {
        this.defaultNetworkTier = other.defaultNetworkTier;
      }
      if (other.getDefaultServiceAccount() != null) {
        this.defaultServiceAccount = other.defaultServiceAccount;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getEnabledFeaturesList() != null) {
        this.enabledFeatures = other.enabledFeatures;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getQuotasList() != null) {
        this.quotas = other.quotas;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getUsageExportLocation() != null) {
        this.usageExportLocation = other.usageExportLocation;
      }
      if (other.getXpnProjectStatus() != null) {
        this.xpnProjectStatus = other.xpnProjectStatus;
      }
      return this;
    }

    Builder(Project source) {
      this.commonInstanceMetadata = source.commonInstanceMetadata;
      this.creationTimestamp = source.creationTimestamp;
      this.defaultNetworkTier = source.defaultNetworkTier;
      this.defaultServiceAccount = source.defaultServiceAccount;
      this.description = source.description;
      this.enabledFeatures = source.enabledFeatures;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.quotas = source.quotas;
      this.selfLink = source.selfLink;
      this.usageExportLocation = source.usageExportLocation;
      this.xpnProjectStatus = source.xpnProjectStatus;
    }

    /**
     * Metadata key/value pairs available to all instances contained in this project. See Custom
     * metadata for more information.
     */
    public Metadata getCommonInstanceMetadata() {
      return commonInstanceMetadata;
    }

    /**
     * Metadata key/value pairs available to all instances contained in this project. See Custom
     * metadata for more information.
     */
    public Builder setCommonInstanceMetadata(Metadata commonInstanceMetadata) {
      this.commonInstanceMetadata = commonInstanceMetadata;
      return this;
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

    /**
     * This signifies the default network tier used for configuring resources of the project and can
     * only take the following values: PREMIUM, STANDARD. Initially the default network tier is
     * PREMIUM.
     */
    public String getDefaultNetworkTier() {
      return defaultNetworkTier;
    }

    /**
     * This signifies the default network tier used for configuring resources of the project and can
     * only take the following values: PREMIUM, STANDARD. Initially the default network tier is
     * PREMIUM.
     */
    public Builder setDefaultNetworkTier(String defaultNetworkTier) {
      this.defaultNetworkTier = defaultNetworkTier;
      return this;
    }

    /** [Output Only] Default service account used by VMs running in this project. */
    public String getDefaultServiceAccount() {
      return defaultServiceAccount;
    }

    /** [Output Only] Default service account used by VMs running in this project. */
    public Builder setDefaultServiceAccount(String defaultServiceAccount) {
      this.defaultServiceAccount = defaultServiceAccount;
      return this;
    }

    /** An optional textual description of the resource. */
    public String getDescription() {
      return description;
    }

    /** An optional textual description of the resource. */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /** Restricted features enabled for use on this project. */
    public List<String> getEnabledFeaturesList() {
      return enabledFeatures;
    }

    /** Restricted features enabled for use on this project. */
    public Builder addAllEnabledFeatures(List<String> enabledFeatures) {
      if (this.enabledFeatures == null) {
        this.enabledFeatures = new LinkedList<>();
      }
      this.enabledFeatures.addAll(enabledFeatures);
      return this;
    }

    /** Restricted features enabled for use on this project. */
    public Builder addEnabledFeatures(String enabledFeatures) {
      if (this.enabledFeatures == null) {
        this.enabledFeatures = new LinkedList<>();
      }
      this.enabledFeatures.add(enabledFeatures);
      return this;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server. This is not the project ID, and is just a unique ID used by Compute Engine to
     * identify resources.
     */
    public String getId() {
      return id;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server. This is not the project ID, and is just a unique ID used by Compute Engine to
     * identify resources.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /** [Output Only] Type of the resource. Always compute#project for projects. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#project for projects. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * The project ID. For example: my-example-project. Use the project ID to make requests to
     * Compute Engine.
     */
    public String getName() {
      return name;
    }

    /**
     * The project ID. For example: my-example-project. Use the project ID to make requests to
     * Compute Engine.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /** [Output Only] Quotas assigned to this project. */
    public List<Quota> getQuotasList() {
      return quotas;
    }

    /** [Output Only] Quotas assigned to this project. */
    public Builder addAllQuotas(List<Quota> quotas) {
      if (this.quotas == null) {
        this.quotas = new LinkedList<>();
      }
      this.quotas.addAll(quotas);
      return this;
    }

    /** [Output Only] Quotas assigned to this project. */
    public Builder addQuotas(Quota quotas) {
      if (this.quotas == null) {
        this.quotas = new LinkedList<>();
      }
      this.quotas.add(quotas);
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

    /**
     * The naming prefix for daily usage reports and the Google Cloud Storage bucket where they are
     * stored.
     */
    public UsageExportLocation getUsageExportLocation() {
      return usageExportLocation;
    }

    /**
     * The naming prefix for daily usage reports and the Google Cloud Storage bucket where they are
     * stored.
     */
    public Builder setUsageExportLocation(UsageExportLocation usageExportLocation) {
      this.usageExportLocation = usageExportLocation;
      return this;
    }

    /**
     * [Output Only] The role this project has in a shared VPC configuration. Currently only HOST
     * projects are differentiated.
     */
    public String getXpnProjectStatus() {
      return xpnProjectStatus;
    }

    /**
     * [Output Only] The role this project has in a shared VPC configuration. Currently only HOST
     * projects are differentiated.
     */
    public Builder setXpnProjectStatus(String xpnProjectStatus) {
      this.xpnProjectStatus = xpnProjectStatus;
      return this;
    }

    public Project build() {

      return new Project(
          commonInstanceMetadata,
          creationTimestamp,
          defaultNetworkTier,
          defaultServiceAccount,
          description,
          enabledFeatures,
          id,
          kind,
          name,
          quotas,
          selfLink,
          usageExportLocation,
          xpnProjectStatus);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCommonInstanceMetadata(this.commonInstanceMetadata);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDefaultNetworkTier(this.defaultNetworkTier);
      newBuilder.setDefaultServiceAccount(this.defaultServiceAccount);
      newBuilder.setDescription(this.description);
      newBuilder.addAllEnabledFeatures(this.enabledFeatures);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.addAllQuotas(this.quotas);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setUsageExportLocation(this.usageExportLocation);
      newBuilder.setXpnProjectStatus(this.xpnProjectStatus);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Project{"
        + "commonInstanceMetadata="
        + commonInstanceMetadata
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "defaultNetworkTier="
        + defaultNetworkTier
        + ", "
        + "defaultServiceAccount="
        + defaultServiceAccount
        + ", "
        + "description="
        + description
        + ", "
        + "enabledFeatures="
        + enabledFeatures
        + ", "
        + "id="
        + id
        + ", "
        + "kind="
        + kind
        + ", "
        + "name="
        + name
        + ", "
        + "quotas="
        + quotas
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "usageExportLocation="
        + usageExportLocation
        + ", "
        + "xpnProjectStatus="
        + xpnProjectStatus
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Project) {
      Project that = (Project) o;
      return Objects.equals(this.commonInstanceMetadata, that.getCommonInstanceMetadata())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.defaultNetworkTier, that.getDefaultNetworkTier())
          && Objects.equals(this.defaultServiceAccount, that.getDefaultServiceAccount())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.enabledFeatures, that.getEnabledFeaturesList())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.quotas, that.getQuotasList())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.usageExportLocation, that.getUsageExportLocation())
          && Objects.equals(this.xpnProjectStatus, that.getXpnProjectStatus());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        commonInstanceMetadata,
        creationTimestamp,
        defaultNetworkTier,
        defaultServiceAccount,
        description,
        enabledFeatures,
        id,
        kind,
        name,
        quotas,
        selfLink,
        usageExportLocation,
        xpnProjectStatus);
  }
}
