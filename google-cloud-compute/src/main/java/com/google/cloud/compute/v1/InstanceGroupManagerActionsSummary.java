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
public final class InstanceGroupManagerActionsSummary implements ApiMessage {
  private final Integer abandoning;
  private final Integer creating;
  private final Integer creatingWithoutRetries;
  private final Integer deleting;
  private final Integer none;
  private final Integer recreating;
  private final Integer refreshing;
  private final Integer restarting;

  private InstanceGroupManagerActionsSummary() {
    this.abandoning = null;
    this.creating = null;
    this.creatingWithoutRetries = null;
    this.deleting = null;
    this.none = null;
    this.recreating = null;
    this.refreshing = null;
    this.restarting = null;
  }


  private InstanceGroupManagerActionsSummary(
      Integer abandoning,
      Integer creating,
      Integer creatingWithoutRetries,
      Integer deleting,
      Integer none,
      Integer recreating,
      Integer refreshing,
      Integer restarting
      ) {
    this.abandoning = abandoning;
    this.creating = creating;
    this.creatingWithoutRetries = creatingWithoutRetries;
    this.deleting = deleting;
    this.none = none;
    this.recreating = recreating;
    this.refreshing = refreshing;
    this.restarting = restarting;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("abandoning") && abandoning != null) {
      fieldMap.put("abandoning", Collections.singletonList(String.valueOf(abandoning)));
    }
    if (fieldNames.contains("creating") && creating != null) {
      fieldMap.put("creating", Collections.singletonList(String.valueOf(creating)));
    }
    if (fieldNames.contains("creatingWithoutRetries") && creatingWithoutRetries != null) {
      fieldMap.put("creatingWithoutRetries", Collections.singletonList(String.valueOf(creatingWithoutRetries)));
    }
    if (fieldNames.contains("deleting") && deleting != null) {
      fieldMap.put("deleting", Collections.singletonList(String.valueOf(deleting)));
    }
    if (fieldNames.contains("none") && none != null) {
      fieldMap.put("none", Collections.singletonList(String.valueOf(none)));
    }
    if (fieldNames.contains("recreating") && recreating != null) {
      fieldMap.put("recreating", Collections.singletonList(String.valueOf(recreating)));
    }
    if (fieldNames.contains("refreshing") && refreshing != null) {
      fieldMap.put("refreshing", Collections.singletonList(String.valueOf(refreshing)));
    }
    if (fieldNames.contains("restarting") && restarting != null) {
      fieldMap.put("restarting", Collections.singletonList(String.valueOf(restarting)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("abandoning")) {
      return String.valueOf(abandoning);
    }
    if (fieldName.equals("creating")) {
      return String.valueOf(creating);
    }
    if (fieldName.equals("creatingWithoutRetries")) {
      return String.valueOf(creatingWithoutRetries);
    }
    if (fieldName.equals("deleting")) {
      return String.valueOf(deleting);
    }
    if (fieldName.equals("none")) {
      return String.valueOf(none);
    }
    if (fieldName.equals("recreating")) {
      return String.valueOf(recreating);
    }
    if (fieldName.equals("refreshing")) {
      return String.valueOf(refreshing);
    }
    if (fieldName.equals("restarting")) {
      return String.valueOf(restarting);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
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


  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(InstanceGroupManagerActionsSummary prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
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


    public InstanceGroupManagerActionsSummary build() {







      return new InstanceGroupManagerActionsSummary(
        abandoning,
        creating,
        creatingWithoutRetries,
        deleting,
        none,
        recreating,
        refreshing,
        restarting
      );
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
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagerActionsSummary{"
        + "abandoning=" + abandoning + ", "
        + "creating=" + creating + ", "
        + "creatingWithoutRetries=" + creatingWithoutRetries + ", "
        + "deleting=" + deleting + ", "
        + "none=" + none + ", "
        + "recreating=" + recreating + ", "
        + "refreshing=" + refreshing + ", "
        + "restarting=" + restarting
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagerActionsSummary) {
      InstanceGroupManagerActionsSummary that = (InstanceGroupManagerActionsSummary) o;
      return
          Objects.equals(this.abandoning, that.getAbandoning()) &&
          Objects.equals(this.creating, that.getCreating()) &&
          Objects.equals(this.creatingWithoutRetries, that.getCreatingWithoutRetries()) &&
          Objects.equals(this.deleting, that.getDeleting()) &&
          Objects.equals(this.none, that.getNone()) &&
          Objects.equals(this.recreating, that.getRecreating()) &&
          Objects.equals(this.refreshing, that.getRefreshing()) &&
          Objects.equals(this.restarting, that.getRestarting())
          ;
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
      restarting
    );
  }
}
