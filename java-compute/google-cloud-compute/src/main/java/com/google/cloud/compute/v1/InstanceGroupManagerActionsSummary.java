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
    if ("abandoning".equals(fieldName)) {
      return abandoning;
    }
    if ("creating".equals(fieldName)) {
      return creating;
    }
    if ("creatingWithoutRetries".equals(fieldName)) {
      return creatingWithoutRetries;
    }
    if ("deleting".equals(fieldName)) {
      return deleting;
    }
    if ("none".equals(fieldName)) {
      return none;
    }
    if ("recreating".equals(fieldName)) {
      return recreating;
    }
    if ("refreshing".equals(fieldName)) {
      return refreshing;
    }
    if ("restarting".equals(fieldName)) {
      return restarting;
    }
    if ("verifying".equals(fieldName)) {
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

  /**
   * [Output Only] The total number of instances in the managed instance group that are scheduled to
   * be abandoned. Abandoning an instance removes it from the managed instance group without
   * deleting it.
   */
  public Integer getAbandoning() {
    return abandoning;
  }

  /**
   * [Output Only] The number of instances in the managed instance group that are scheduled to be
   * created or are currently being created. If the group fails to create any of these instances, it
   * tries again until it creates the instance successfully.
   *
   * <p>If you have disabled creation retries, this field will not be populated; instead, the
   * creatingWithoutRetries field will be populated.
   */
  public Integer getCreating() {
    return creating;
  }

  /**
   * [Output Only] The number of instances that the managed instance group will attempt to create.
   * The group attempts to create each instance only once. If the group fails to create any of these
   * instances, it decreases the group's targetSize value accordingly.
   */
  public Integer getCreatingWithoutRetries() {
    return creatingWithoutRetries;
  }

  /**
   * [Output Only] The number of instances in the managed instance group that are scheduled to be
   * deleted or are currently being deleted.
   */
  public Integer getDeleting() {
    return deleting;
  }

  /**
   * [Output Only] The number of instances in the managed instance group that are running and have
   * no scheduled actions.
   */
  public Integer getNone() {
    return none;
  }

  /**
   * [Output Only] The number of instances in the managed instance group that are scheduled to be
   * recreated or are currently being being recreated. Recreating an instance deletes the existing
   * root persistent disk and creates a new disk from the image that is defined in the instance
   * template.
   */
  public Integer getRecreating() {
    return recreating;
  }

  /**
   * [Output Only] The number of instances in the managed instance group that are being reconfigured
   * with properties that do not require a restart or a recreate action. For example, setting or
   * removing target pools for the instance.
   */
  public Integer getRefreshing() {
    return refreshing;
  }

  /**
   * [Output Only] The number of instances in the managed instance group that are scheduled to be
   * restarted or are currently being restarted.
   */
  public Integer getRestarting() {
    return restarting;
  }

  /**
   * [Output Only] The number of instances in the managed instance group that are being verified.
   * See the managedInstances[].currentAction property in the listManagedInstances method
   * documentation.
   */
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

    /**
     * [Output Only] The total number of instances in the managed instance group that are scheduled
     * to be abandoned. Abandoning an instance removes it from the managed instance group without
     * deleting it.
     */
    public Integer getAbandoning() {
      return abandoning;
    }

    /**
     * [Output Only] The total number of instances in the managed instance group that are scheduled
     * to be abandoned. Abandoning an instance removes it from the managed instance group without
     * deleting it.
     */
    public Builder setAbandoning(Integer abandoning) {
      this.abandoning = abandoning;
      return this;
    }

    /**
     * [Output Only] The number of instances in the managed instance group that are scheduled to be
     * created or are currently being created. If the group fails to create any of these instances,
     * it tries again until it creates the instance successfully.
     *
     * <p>If you have disabled creation retries, this field will not be populated; instead, the
     * creatingWithoutRetries field will be populated.
     */
    public Integer getCreating() {
      return creating;
    }

    /**
     * [Output Only] The number of instances in the managed instance group that are scheduled to be
     * created or are currently being created. If the group fails to create any of these instances,
     * it tries again until it creates the instance successfully.
     *
     * <p>If you have disabled creation retries, this field will not be populated; instead, the
     * creatingWithoutRetries field will be populated.
     */
    public Builder setCreating(Integer creating) {
      this.creating = creating;
      return this;
    }

    /**
     * [Output Only] The number of instances that the managed instance group will attempt to create.
     * The group attempts to create each instance only once. If the group fails to create any of
     * these instances, it decreases the group's targetSize value accordingly.
     */
    public Integer getCreatingWithoutRetries() {
      return creatingWithoutRetries;
    }

    /**
     * [Output Only] The number of instances that the managed instance group will attempt to create.
     * The group attempts to create each instance only once. If the group fails to create any of
     * these instances, it decreases the group's targetSize value accordingly.
     */
    public Builder setCreatingWithoutRetries(Integer creatingWithoutRetries) {
      this.creatingWithoutRetries = creatingWithoutRetries;
      return this;
    }

    /**
     * [Output Only] The number of instances in the managed instance group that are scheduled to be
     * deleted or are currently being deleted.
     */
    public Integer getDeleting() {
      return deleting;
    }

    /**
     * [Output Only] The number of instances in the managed instance group that are scheduled to be
     * deleted or are currently being deleted.
     */
    public Builder setDeleting(Integer deleting) {
      this.deleting = deleting;
      return this;
    }

    /**
     * [Output Only] The number of instances in the managed instance group that are running and have
     * no scheduled actions.
     */
    public Integer getNone() {
      return none;
    }

    /**
     * [Output Only] The number of instances in the managed instance group that are running and have
     * no scheduled actions.
     */
    public Builder setNone(Integer none) {
      this.none = none;
      return this;
    }

    /**
     * [Output Only] The number of instances in the managed instance group that are scheduled to be
     * recreated or are currently being being recreated. Recreating an instance deletes the existing
     * root persistent disk and creates a new disk from the image that is defined in the instance
     * template.
     */
    public Integer getRecreating() {
      return recreating;
    }

    /**
     * [Output Only] The number of instances in the managed instance group that are scheduled to be
     * recreated or are currently being being recreated. Recreating an instance deletes the existing
     * root persistent disk and creates a new disk from the image that is defined in the instance
     * template.
     */
    public Builder setRecreating(Integer recreating) {
      this.recreating = recreating;
      return this;
    }

    /**
     * [Output Only] The number of instances in the managed instance group that are being
     * reconfigured with properties that do not require a restart or a recreate action. For example,
     * setting or removing target pools for the instance.
     */
    public Integer getRefreshing() {
      return refreshing;
    }

    /**
     * [Output Only] The number of instances in the managed instance group that are being
     * reconfigured with properties that do not require a restart or a recreate action. For example,
     * setting or removing target pools for the instance.
     */
    public Builder setRefreshing(Integer refreshing) {
      this.refreshing = refreshing;
      return this;
    }

    /**
     * [Output Only] The number of instances in the managed instance group that are scheduled to be
     * restarted or are currently being restarted.
     */
    public Integer getRestarting() {
      return restarting;
    }

    /**
     * [Output Only] The number of instances in the managed instance group that are scheduled to be
     * restarted or are currently being restarted.
     */
    public Builder setRestarting(Integer restarting) {
      this.restarting = restarting;
      return this;
    }

    /**
     * [Output Only] The number of instances in the managed instance group that are being verified.
     * See the managedInstances[].currentAction property in the listManagedInstances method
     * documentation.
     */
    public Integer getVerifying() {
      return verifying;
    }

    /**
     * [Output Only] The number of instances in the managed instance group that are being verified.
     * See the managedInstances[].currentAction property in the listManagedInstances method
     * documentation.
     */
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
