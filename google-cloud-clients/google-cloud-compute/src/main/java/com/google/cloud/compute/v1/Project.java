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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
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
    if (fieldName.equals("commonInstanceMetadata")) {
      return commonInstanceMetadata;
    }
    if (fieldName.equals("creationTimestamp")) {
      return creationTimestamp;
    }
    if (fieldName.equals("defaultNetworkTier")) {
      return defaultNetworkTier;
    }
    if (fieldName.equals("defaultServiceAccount")) {
      return defaultServiceAccount;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("enabledFeatures")) {
      return enabledFeatures;
    }
    if (fieldName.equals("id")) {
      return id;
    }
    if (fieldName.equals("kind")) {
      return kind;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("quotas")) {
      return quotas;
    }
    if (fieldName.equals("selfLink")) {
      return selfLink;
    }
    if (fieldName.equals("usageExportLocation")) {
      return usageExportLocation;
    }
    if (fieldName.equals("xpnProjectStatus")) {
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
  public List<String> getFieldMask() {
    return null;
  }

  public Metadata getCommonInstanceMetadata() {
    return commonInstanceMetadata;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDefaultNetworkTier() {
    return defaultNetworkTier;
  }

  public String getDefaultServiceAccount() {
    return defaultServiceAccount;
  }

  public String getDescription() {
    return description;
  }

  public List<String> getEnabledFeaturesList() {
    return enabledFeatures;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public List<Quota> getQuotasList() {
    return quotas;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public UsageExportLocation getUsageExportLocation() {
    return usageExportLocation;
  }

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

    public Metadata getCommonInstanceMetadata() {
      return commonInstanceMetadata;
    }

    public Builder setCommonInstanceMetadata(Metadata commonInstanceMetadata) {
      this.commonInstanceMetadata = commonInstanceMetadata;
      return this;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public String getDefaultNetworkTier() {
      return defaultNetworkTier;
    }

    public Builder setDefaultNetworkTier(String defaultNetworkTier) {
      this.defaultNetworkTier = defaultNetworkTier;
      return this;
    }

    public String getDefaultServiceAccount() {
      return defaultServiceAccount;
    }

    public Builder setDefaultServiceAccount(String defaultServiceAccount) {
      this.defaultServiceAccount = defaultServiceAccount;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public List<String> getEnabledFeaturesList() {
      return enabledFeatures;
    }

    public Builder addAllEnabledFeatures(List<String> enabledFeatures) {
      if (this.enabledFeatures == null) {
        this.enabledFeatures = new LinkedList<>();
      }
      this.enabledFeatures.addAll(enabledFeatures);
      return this;
    }

    public Builder addEnabledFeatures(String enabledFeatures) {
      if (this.enabledFeatures == null) {
        this.enabledFeatures = new LinkedList<>();
      }
      this.enabledFeatures.add(enabledFeatures);
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
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

    public List<Quota> getQuotasList() {
      return quotas;
    }

    public Builder addAllQuotas(List<Quota> quotas) {
      if (this.quotas == null) {
        this.quotas = new LinkedList<>();
      }
      this.quotas.addAll(quotas);
      return this;
    }

    public Builder addQuotas(Quota quotas) {
      if (this.quotas == null) {
        this.quotas = new LinkedList<>();
      }
      this.quotas.add(quotas);
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public UsageExportLocation getUsageExportLocation() {
      return usageExportLocation;
    }

    public Builder setUsageExportLocation(UsageExportLocation usageExportLocation) {
      this.usageExportLocation = usageExportLocation;
      return this;
    }

    public String getXpnProjectStatus() {
      return xpnProjectStatus;
    }

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
