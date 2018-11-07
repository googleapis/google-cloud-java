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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class InstanceGroupManagerActionsSummary implements ApiMessage {
  private final Integer abandoning;
  private final Integer creating;
  private final Integer creatingWithoutRetries;
  private final Integer deleting;
  private final Integer none;
  private final Integer recreating;
  private final Integer refreshing;
  private final Integer restarting;
  private final Integer verifying;

  private InstanceGroupManagerActionsSummary() {
    this.abandoning = null;
    this.creating = null;
    this.creatingWithoutRetries = null;
    this.deleting = null;
    this.none = null;
    this.recreating = null;
    this.refreshing = null;
    this.restarting = null;
    this.verifying = null;
  }

  private InstanceGroupManagerActionsSummary(
      Integer abandoning,
      Integer creating,
      Integer creatingWithoutRetries,
      Integer deleting,
      Integer none,
      Integer recreating,
      Integer refreshing,
      Integer restarting,
      Integer verifying) {
    this.abandoning = abandoning;
    this.creating = creating;
    this.creatingWithoutRetries = creatingWithoutRetries;
    this.deleting = deleting;
    this.none = none;
    this.recreating = recreating;
    this.refreshing = refreshing;
    this.restarting = restarting;
    this.verifying = verifying;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("abandoning")) {
      return abandoning;
    }
    if (fieldName.equals("creating")) {
      return creating;
    }
    if (fieldName.equals("creatingWithoutRetries")) {
      return creatingWithoutRetries;
    }
    if (fieldName.equals("deleting")) {
      return deleting;
    }
    if (fieldName.equals("none")) {
      return none;
    }
    if (fieldName.equals("recreating")) {
      return recreating;
    }
    if (fieldName.equals("refreshing")) {
      return refreshing;
    }
    if (fieldName.equals("restarting")) {
      return restarting;
    }
    if (fieldName.equals("verifying")) {
      return verifying;
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

  public Integer getAbandoning() {
    return abandoning;
  }

  public Integer getCreating() {
    return creating;
  }

  public Integer getCreatingWithoutRetries() {
    return creatingWithoutRetries;
  }

  public Integer getDeleting() {
    return deleting;
  }

  public Integer getNone() {
    return none;
  }

  public Integer getRecreating() {
    return recreating;
  }

  public Integer getRefreshing() {
    return refreshing;
  }

  public Integer getRestarting() {
    return restarting;
  }

  public Integer getVerifying() {
    return verifying;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManagerActionsSummary prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagerActionsSummary getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagerActionsSummary DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagerActionsSummary();
  }

  public static class Builder {
    private Integer abandoning;
    private Integer creating;
    private Integer creatingWithoutRetries;
    private Integer deleting;
    private Integer none;
    private Integer recreating;
    private Integer refreshing;
    private Integer restarting;
    private Integer verifying;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagerActionsSummary other) {
      if (other == InstanceGroupManagerActionsSummary.getDefaultInstance()) return this;
      if (other.getAbandoning() != null) {
        this.abandoning = other.abandoning;
      }
      if (other.getCreating() != null) {
        this.creating = other.creating;
      }
      if (other.getCreatingWithoutRetries() != null) {
        this.creatingWithoutRetries = other.creatingWithoutRetries;
      }
      if (other.getDeleting() != null) {
        this.deleting = other.deleting;
      }
      if (other.getNone() != null) {
        this.none = other.none;
      }
      if (other.getRecreating() != null) {
        this.recreating = other.recreating;
      }
      if (other.getRefreshing() != null) {
        this.refreshing = other.refreshing;
      }
      if (other.getRestarting() != null) {
        this.restarting = other.restarting;
      }
      if (other.getVerifying() != null) {
        this.verifying = other.verifying;
      }
      return this;
    }

    Builder(InstanceGroupManagerActionsSummary source) {
      this.abandoning = source.abandoning;
      this.creating = source.creating;
      this.creatingWithoutRetries = source.creatingWithoutRetries;
      this.deleting = source.deleting;
      this.none = source.none;
      this.recreating = source.recreating;
      this.refreshing = source.refreshing;
      this.restarting = source.restarting;
      this.verifying = source.verifying;
    }

    public Integer getAbandoning() {
      return abandoning;
    }

    public Builder setAbandoning(Integer abandoning) {
      this.abandoning = abandoning;
      return this;
    }

    public Integer getCreating() {
      return creating;
    }

    public Builder setCreating(Integer creating) {
      this.creating = creating;
      return this;
    }

    public Integer getCreatingWithoutRetries() {
      return creatingWithoutRetries;
    }

    public Builder setCreatingWithoutRetries(Integer creatingWithoutRetries) {
      this.creatingWithoutRetries = creatingWithoutRetries;
      return this;
    }

    public Integer getDeleting() {
      return deleting;
    }

    public Builder setDeleting(Integer deleting) {
      this.deleting = deleting;
      return this;
    }

    public Integer getNone() {
      return none;
    }

    public Builder setNone(Integer none) {
      this.none = none;
      return this;
    }

    public Integer getRecreating() {
      return recreating;
    }

    public Builder setRecreating(Integer recreating) {
      this.recreating = recreating;
      return this;
    }

    public Integer getRefreshing() {
      return refreshing;
    }

    public Builder setRefreshing(Integer refreshing) {
      this.refreshing = refreshing;
      return this;
    }

    public Integer getRestarting() {
      return restarting;
    }

    public Builder setRestarting(Integer restarting) {
      this.restarting = restarting;
      return this;
    }

    public Integer getVerifying() {
      return verifying;
    }

    public Builder setVerifying(Integer verifying) {
      this.verifying = verifying;
      return this;
    }

    public InstanceGroupManagerActionsSummary build() {

      return new InstanceGroupManagerActionsSummary(
          abandoning,
          creating,
          creatingWithoutRetries,
          deleting,
          none,
          recreating,
          refreshing,
          restarting,
          verifying);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAbandoning(this.abandoning);
      newBuilder.setCreating(this.creating);
      newBuilder.setCreatingWithoutRetries(this.creatingWithoutRetries);
      newBuilder.setDeleting(this.deleting);
      newBuilder.setNone(this.none);
      newBuilder.setRecreating(this.recreating);
      newBuilder.setRefreshing(this.refreshing);
      newBuilder.setRestarting(this.restarting);
      newBuilder.setVerifying(this.verifying);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagerActionsSummary{"
        + "abandoning="
        + abandoning
        + ", "
        + "creating="
        + creating
        + ", "
        + "creatingWithoutRetries="
        + creatingWithoutRetries
        + ", "
        + "deleting="
        + deleting
        + ", "
        + "none="
        + none
        + ", "
        + "recreating="
        + recreating
        + ", "
        + "refreshing="
        + refreshing
        + ", "
        + "restarting="
        + restarting
        + ", "
        + "verifying="
        + verifying
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagerActionsSummary) {
      InstanceGroupManagerActionsSummary that = (InstanceGroupManagerActionsSummary) o;
      return Objects.equals(this.abandoning, that.getAbandoning())
          && Objects.equals(this.creating, that.getCreating())
          && Objects.equals(this.creatingWithoutRetries, that.getCreatingWithoutRetries())
          && Objects.equals(this.deleting, that.getDeleting())
          && Objects.equals(this.none, that.getNone())
          && Objects.equals(this.recreating, that.getRecreating())
          && Objects.equals(this.refreshing, that.getRefreshing())
          && Objects.equals(this.restarting, that.getRestarting())
          && Objects.equals(this.verifying, that.getVerifying());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        abandoning,
        creating,
        creatingWithoutRetries,
        deleting,
        none,
        recreating,
        refreshing,
        restarting,
        verifying);
  }
}
