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
public final class Firewall implements ApiMessage {
  private final List<Allowed> allowed;
  private final String creationTimestamp;
  private final List<Denied> denied;
  private final String description;
  private final List<String> destinationRanges;
  private final String direction;
  private final Boolean disabled;
  private final String id;
  private final String kind;
  private final FirewallLogConfig logConfig;
  private final String name;
  private final String network;
  private final Integer priority;
  private final String selfLink;
  private final List<String> sourceRanges;
  private final List<String> sourceServiceAccounts;
  private final List<String> sourceTags;
  private final List<String> targetServiceAccounts;
  private final List<String> targetTags;

  private Firewall() {
    this.allowed = null;
    this.creationTimestamp = null;
    this.denied = null;
    this.description = null;
    this.destinationRanges = null;
    this.direction = null;
    this.disabled = null;
    this.id = null;
    this.kind = null;
    this.logConfig = null;
    this.name = null;
    this.network = null;
    this.priority = null;
    this.selfLink = null;
    this.sourceRanges = null;
    this.sourceServiceAccounts = null;
    this.sourceTags = null;
    this.targetServiceAccounts = null;
    this.targetTags = null;
  }

  private Firewall(
      List<Allowed> allowed,
      String creationTimestamp,
      List<Denied> denied,
      String description,
      List<String> destinationRanges,
      String direction,
      Boolean disabled,
      String id,
      String kind,
      FirewallLogConfig logConfig,
      String name,
      String network,
      Integer priority,
      String selfLink,
      List<String> sourceRanges,
      List<String> sourceServiceAccounts,
      List<String> sourceTags,
      List<String> targetServiceAccounts,
      List<String> targetTags) {
    this.allowed = allowed;
    this.creationTimestamp = creationTimestamp;
    this.denied = denied;
    this.description = description;
    this.destinationRanges = destinationRanges;
    this.direction = direction;
    this.disabled = disabled;
    this.id = id;
    this.kind = kind;
    this.logConfig = logConfig;
    this.name = name;
    this.network = network;
    this.priority = priority;
    this.selfLink = selfLink;
    this.sourceRanges = sourceRanges;
    this.sourceServiceAccounts = sourceServiceAccounts;
    this.sourceTags = sourceTags;
    this.targetServiceAccounts = targetServiceAccounts;
    this.targetTags = targetTags;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("allowed".equals(fieldName)) {
      return allowed;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("denied".equals(fieldName)) {
      return denied;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("destinationRanges".equals(fieldName)) {
      return destinationRanges;
    }
    if ("direction".equals(fieldName)) {
      return direction;
    }
    if ("disabled".equals(fieldName)) {
      return disabled;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("logConfig".equals(fieldName)) {
      return logConfig;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("network".equals(fieldName)) {
      return network;
    }
    if ("priority".equals(fieldName)) {
      return priority;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("sourceRanges".equals(fieldName)) {
      return sourceRanges;
    }
    if ("sourceServiceAccounts".equals(fieldName)) {
      return sourceServiceAccounts;
    }
    if ("sourceTags".equals(fieldName)) {
      return sourceTags;
    }
    if ("targetServiceAccounts".equals(fieldName)) {
      return targetServiceAccounts;
    }
    if ("targetTags".equals(fieldName)) {
      return targetTags;
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

  public List<Allowed> getAllowedList() {
    return allowed;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public List<Denied> getDeniedList() {
    return denied;
  }

  public String getDescription() {
    return description;
  }

  public List<String> getDestinationRangesList() {
    return destinationRanges;
  }

  public String getDirection() {
    return direction;
  }

  public Boolean getDisabled() {
    return disabled;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public FirewallLogConfig getLogConfig() {
    return logConfig;
  }

  public String getName() {
    return name;
  }

  public String getNetwork() {
    return network;
  }

  public Integer getPriority() {
    return priority;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public List<String> getSourceRangesList() {
    return sourceRanges;
  }

  public List<String> getSourceServiceAccountsList() {
    return sourceServiceAccounts;
  }

  public List<String> getSourceTagsList() {
    return sourceTags;
  }

  public List<String> getTargetServiceAccountsList() {
    return targetServiceAccounts;
  }

  public List<String> getTargetTagsList() {
    return targetTags;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Firewall prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Firewall getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Firewall DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Firewall();
  }

  public static class Builder {
    private List<Allowed> allowed;
    private String creationTimestamp;
    private List<Denied> denied;
    private String description;
    private List<String> destinationRanges;
    private String direction;
    private Boolean disabled;
    private String id;
    private String kind;
    private FirewallLogConfig logConfig;
    private String name;
    private String network;
    private Integer priority;
    private String selfLink;
    private List<String> sourceRanges;
    private List<String> sourceServiceAccounts;
    private List<String> sourceTags;
    private List<String> targetServiceAccounts;
    private List<String> targetTags;

    Builder() {}

    public Builder mergeFrom(Firewall other) {
      if (other == Firewall.getDefaultInstance()) return this;
      if (other.getAllowedList() != null) {
        this.allowed = other.allowed;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDeniedList() != null) {
        this.denied = other.denied;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getDestinationRangesList() != null) {
        this.destinationRanges = other.destinationRanges;
      }
      if (other.getDirection() != null) {
        this.direction = other.direction;
      }
      if (other.getDisabled() != null) {
        this.disabled = other.disabled;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getLogConfig() != null) {
        this.logConfig = other.logConfig;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getNetwork() != null) {
        this.network = other.network;
      }
      if (other.getPriority() != null) {
        this.priority = other.priority;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSourceRangesList() != null) {
        this.sourceRanges = other.sourceRanges;
      }
      if (other.getSourceServiceAccountsList() != null) {
        this.sourceServiceAccounts = other.sourceServiceAccounts;
      }
      if (other.getSourceTagsList() != null) {
        this.sourceTags = other.sourceTags;
      }
      if (other.getTargetServiceAccountsList() != null) {
        this.targetServiceAccounts = other.targetServiceAccounts;
      }
      if (other.getTargetTagsList() != null) {
        this.targetTags = other.targetTags;
      }
      return this;
    }

    Builder(Firewall source) {
      this.allowed = source.allowed;
      this.creationTimestamp = source.creationTimestamp;
      this.denied = source.denied;
      this.description = source.description;
      this.destinationRanges = source.destinationRanges;
      this.direction = source.direction;
      this.disabled = source.disabled;
      this.id = source.id;
      this.kind = source.kind;
      this.logConfig = source.logConfig;
      this.name = source.name;
      this.network = source.network;
      this.priority = source.priority;
      this.selfLink = source.selfLink;
      this.sourceRanges = source.sourceRanges;
      this.sourceServiceAccounts = source.sourceServiceAccounts;
      this.sourceTags = source.sourceTags;
      this.targetServiceAccounts = source.targetServiceAccounts;
      this.targetTags = source.targetTags;
    }

    public List<Allowed> getAllowedList() {
      return allowed;
    }

    public Builder addAllAllowed(List<Allowed> allowed) {
      if (this.allowed == null) {
        this.allowed = new LinkedList<>();
      }
      this.allowed.addAll(allowed);
      return this;
    }

    public Builder addAllowed(Allowed allowed) {
      if (this.allowed == null) {
        this.allowed = new LinkedList<>();
      }
      this.allowed.add(allowed);
      return this;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public List<Denied> getDeniedList() {
      return denied;
    }

    public Builder addAllDenied(List<Denied> denied) {
      if (this.denied == null) {
        this.denied = new LinkedList<>();
      }
      this.denied.addAll(denied);
      return this;
    }

    public Builder addDenied(Denied denied) {
      if (this.denied == null) {
        this.denied = new LinkedList<>();
      }
      this.denied.add(denied);
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public List<String> getDestinationRangesList() {
      return destinationRanges;
    }

    public Builder addAllDestinationRanges(List<String> destinationRanges) {
      if (this.destinationRanges == null) {
        this.destinationRanges = new LinkedList<>();
      }
      this.destinationRanges.addAll(destinationRanges);
      return this;
    }

    public Builder addDestinationRanges(String destinationRanges) {
      if (this.destinationRanges == null) {
        this.destinationRanges = new LinkedList<>();
      }
      this.destinationRanges.add(destinationRanges);
      return this;
    }

    public String getDirection() {
      return direction;
    }

    public Builder setDirection(String direction) {
      this.direction = direction;
      return this;
    }

    public Boolean getDisabled() {
      return disabled;
    }

    public Builder setDisabled(Boolean disabled) {
      this.disabled = disabled;
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

    public FirewallLogConfig getLogConfig() {
      return logConfig;
    }

    public Builder setLogConfig(FirewallLogConfig logConfig) {
      this.logConfig = logConfig;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getNetwork() {
      return network;
    }

    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    public Integer getPriority() {
      return priority;
    }

    public Builder setPriority(Integer priority) {
      this.priority = priority;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public List<String> getSourceRangesList() {
      return sourceRanges;
    }

    public Builder addAllSourceRanges(List<String> sourceRanges) {
      if (this.sourceRanges == null) {
        this.sourceRanges = new LinkedList<>();
      }
      this.sourceRanges.addAll(sourceRanges);
      return this;
    }

    public Builder addSourceRanges(String sourceRanges) {
      if (this.sourceRanges == null) {
        this.sourceRanges = new LinkedList<>();
      }
      this.sourceRanges.add(sourceRanges);
      return this;
    }

    public List<String> getSourceServiceAccountsList() {
      return sourceServiceAccounts;
    }

    public Builder addAllSourceServiceAccounts(List<String> sourceServiceAccounts) {
      if (this.sourceServiceAccounts == null) {
        this.sourceServiceAccounts = new LinkedList<>();
      }
      this.sourceServiceAccounts.addAll(sourceServiceAccounts);
      return this;
    }

    public Builder addSourceServiceAccounts(String sourceServiceAccounts) {
      if (this.sourceServiceAccounts == null) {
        this.sourceServiceAccounts = new LinkedList<>();
      }
      this.sourceServiceAccounts.add(sourceServiceAccounts);
      return this;
    }

    public List<String> getSourceTagsList() {
      return sourceTags;
    }

    public Builder addAllSourceTags(List<String> sourceTags) {
      if (this.sourceTags == null) {
        this.sourceTags = new LinkedList<>();
      }
      this.sourceTags.addAll(sourceTags);
      return this;
    }

    public Builder addSourceTags(String sourceTags) {
      if (this.sourceTags == null) {
        this.sourceTags = new LinkedList<>();
      }
      this.sourceTags.add(sourceTags);
      return this;
    }

    public List<String> getTargetServiceAccountsList() {
      return targetServiceAccounts;
    }

    public Builder addAllTargetServiceAccounts(List<String> targetServiceAccounts) {
      if (this.targetServiceAccounts == null) {
        this.targetServiceAccounts = new LinkedList<>();
      }
      this.targetServiceAccounts.addAll(targetServiceAccounts);
      return this;
    }

    public Builder addTargetServiceAccounts(String targetServiceAccounts) {
      if (this.targetServiceAccounts == null) {
        this.targetServiceAccounts = new LinkedList<>();
      }
      this.targetServiceAccounts.add(targetServiceAccounts);
      return this;
    }

    public List<String> getTargetTagsList() {
      return targetTags;
    }

    public Builder addAllTargetTags(List<String> targetTags) {
      if (this.targetTags == null) {
        this.targetTags = new LinkedList<>();
      }
      this.targetTags.addAll(targetTags);
      return this;
    }

    public Builder addTargetTags(String targetTags) {
      if (this.targetTags == null) {
        this.targetTags = new LinkedList<>();
      }
      this.targetTags.add(targetTags);
      return this;
    }

    public Firewall build() {

      return new Firewall(
          allowed,
          creationTimestamp,
          denied,
          description,
          destinationRanges,
          direction,
          disabled,
          id,
          kind,
          logConfig,
          name,
          network,
          priority,
          selfLink,
          sourceRanges,
          sourceServiceAccounts,
          sourceTags,
          targetServiceAccounts,
          targetTags);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllAllowed(this.allowed);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.addAllDenied(this.denied);
      newBuilder.setDescription(this.description);
      newBuilder.addAllDestinationRanges(this.destinationRanges);
      newBuilder.setDirection(this.direction);
      newBuilder.setDisabled(this.disabled);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setLogConfig(this.logConfig);
      newBuilder.setName(this.name);
      newBuilder.setNetwork(this.network);
      newBuilder.setPriority(this.priority);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.addAllSourceRanges(this.sourceRanges);
      newBuilder.addAllSourceServiceAccounts(this.sourceServiceAccounts);
      newBuilder.addAllSourceTags(this.sourceTags);
      newBuilder.addAllTargetServiceAccounts(this.targetServiceAccounts);
      newBuilder.addAllTargetTags(this.targetTags);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Firewall{"
        + "allowed="
        + allowed
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "denied="
        + denied
        + ", "
        + "description="
        + description
        + ", "
        + "destinationRanges="
        + destinationRanges
        + ", "
        + "direction="
        + direction
        + ", "
        + "disabled="
        + disabled
        + ", "
        + "id="
        + id
        + ", "
        + "kind="
        + kind
        + ", "
        + "logConfig="
        + logConfig
        + ", "
        + "name="
        + name
        + ", "
        + "network="
        + network
        + ", "
        + "priority="
        + priority
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "sourceRanges="
        + sourceRanges
        + ", "
        + "sourceServiceAccounts="
        + sourceServiceAccounts
        + ", "
        + "sourceTags="
        + sourceTags
        + ", "
        + "targetServiceAccounts="
        + targetServiceAccounts
        + ", "
        + "targetTags="
        + targetTags
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Firewall) {
      Firewall that = (Firewall) o;
      return Objects.equals(this.allowed, that.getAllowedList())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.denied, that.getDeniedList())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.destinationRanges, that.getDestinationRangesList())
          && Objects.equals(this.direction, that.getDirection())
          && Objects.equals(this.disabled, that.getDisabled())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.logConfig, that.getLogConfig())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.priority, that.getPriority())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.sourceRanges, that.getSourceRangesList())
          && Objects.equals(this.sourceServiceAccounts, that.getSourceServiceAccountsList())
          && Objects.equals(this.sourceTags, that.getSourceTagsList())
          && Objects.equals(this.targetServiceAccounts, that.getTargetServiceAccountsList())
          && Objects.equals(this.targetTags, that.getTargetTagsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        allowed,
        creationTimestamp,
        denied,
        description,
        destinationRanges,
        direction,
        disabled,
        id,
        kind,
        logConfig,
        name,
        network,
        priority,
        selfLink,
        sourceRanges,
        sourceServiceAccounts,
        sourceTags,
        targetServiceAccounts,
        targetTags);
  }
}
