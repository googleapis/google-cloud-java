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
public final class Autoscaler implements ApiMessage {
  private final AutoscalingPolicy autoscalingPolicy;
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final String region;
  private final String selfLink;
  private final String status;
  private final List<AutoscalerStatusDetails> statusDetails;
  private final String target;
  private final String zone;

  private Autoscaler() {
    this.autoscalingPolicy = null;
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.region = null;
    this.selfLink = null;
    this.status = null;
    this.statusDetails = null;
    this.target = null;
    this.zone = null;
  }

  private Autoscaler(
      AutoscalingPolicy autoscalingPolicy,
      String creationTimestamp,
      String description,
      String id,
      String kind,
      String name,
      String region,
      String selfLink,
      String status,
      List<AutoscalerStatusDetails> statusDetails,
      String target,
      String zone) {
    this.autoscalingPolicy = autoscalingPolicy;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.region = region;
    this.selfLink = selfLink;
    this.status = status;
    this.statusDetails = statusDetails;
    this.target = target;
    this.zone = zone;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("autoscalingPolicy".equals(fieldName)) {
      return autoscalingPolicy;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
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
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("status".equals(fieldName)) {
      return status;
    }
    if ("statusDetails".equals(fieldName)) {
      return statusDetails;
    }
    if ("target".equals(fieldName)) {
      return target;
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

  public AutoscalingPolicy getAutoscalingPolicy() {
    return autoscalingPolicy;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
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

  public String getRegion() {
    return region;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public String getStatus() {
    return status;
  }

  public List<AutoscalerStatusDetails> getStatusDetailsList() {
    return statusDetails;
  }

  public String getTarget() {
    return target;
  }

  public String getZone() {
    return zone;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Autoscaler prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Autoscaler getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Autoscaler DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Autoscaler();
  }

  public static class Builder {
    private AutoscalingPolicy autoscalingPolicy;
    private String creationTimestamp;
    private String description;
    private String id;
    private String kind;
    private String name;
    private String region;
    private String selfLink;
    private String status;
    private List<AutoscalerStatusDetails> statusDetails;
    private String target;
    private String zone;

    Builder() {}

    public Builder mergeFrom(Autoscaler other) {
      if (other == Autoscaler.getDefaultInstance()) return this;
      if (other.getAutoscalingPolicy() != null) {
        this.autoscalingPolicy = other.autoscalingPolicy;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
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
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      if (other.getStatusDetailsList() != null) {
        this.statusDetails = other.statusDetails;
      }
      if (other.getTarget() != null) {
        this.target = other.target;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(Autoscaler source) {
      this.autoscalingPolicy = source.autoscalingPolicy;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.region = source.region;
      this.selfLink = source.selfLink;
      this.status = source.status;
      this.statusDetails = source.statusDetails;
      this.target = source.target;
      this.zone = source.zone;
    }

    public AutoscalingPolicy getAutoscalingPolicy() {
      return autoscalingPolicy;
    }

    public Builder setAutoscalingPolicy(AutoscalingPolicy autoscalingPolicy) {
      this.autoscalingPolicy = autoscalingPolicy;
      return this;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
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

    public String getStatus() {
      return status;
    }

    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public List<AutoscalerStatusDetails> getStatusDetailsList() {
      return statusDetails;
    }

    public Builder addAllStatusDetails(List<AutoscalerStatusDetails> statusDetails) {
      if (this.statusDetails == null) {
        this.statusDetails = new LinkedList<>();
      }
      this.statusDetails.addAll(statusDetails);
      return this;
    }

    public Builder addStatusDetails(AutoscalerStatusDetails statusDetails) {
      if (this.statusDetails == null) {
        this.statusDetails = new LinkedList<>();
      }
      this.statusDetails.add(statusDetails);
      return this;
    }

    public String getTarget() {
      return target;
    }

    public Builder setTarget(String target) {
      this.target = target;
      return this;
    }

    public String getZone() {
      return zone;
    }

    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public Autoscaler build() {

      return new Autoscaler(
          autoscalingPolicy,
          creationTimestamp,
          description,
          id,
          kind,
          name,
          region,
          selfLink,
          status,
          statusDetails,
          target,
          zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAutoscalingPolicy(this.autoscalingPolicy);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setStatus(this.status);
      newBuilder.addAllStatusDetails(this.statusDetails);
      newBuilder.setTarget(this.target);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Autoscaler{"
        + "autoscalingPolicy="
        + autoscalingPolicy
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
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
        + "region="
        + region
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "status="
        + status
        + ", "
        + "statusDetails="
        + statusDetails
        + ", "
        + "target="
        + target
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
    if (o instanceof Autoscaler) {
      Autoscaler that = (Autoscaler) o;
      return Objects.equals(this.autoscalingPolicy, that.getAutoscalingPolicy())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.status, that.getStatus())
          && Objects.equals(this.statusDetails, that.getStatusDetailsList())
          && Objects.equals(this.target, that.getTarget())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        autoscalingPolicy,
        creationTimestamp,
        description,
        id,
        kind,
        name,
        region,
        selfLink,
        status,
        statusDetails,
        target,
        zone);
  }
}
