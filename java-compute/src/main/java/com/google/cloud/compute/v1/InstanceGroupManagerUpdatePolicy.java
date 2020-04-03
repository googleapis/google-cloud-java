/*
 * Copyright 2020 Google LLC
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
public final class InstanceGroupManagerUpdatePolicy implements ApiMessage {
  private final String instanceRedistributionType;
  private final FixedOrPercent maxSurge;
  private final FixedOrPercent maxUnavailable;
  private final String minimalAction;
  private final String replacementMethod;
  private final String type;

  private InstanceGroupManagerUpdatePolicy() {
    this.instanceRedistributionType = null;
    this.maxSurge = null;
    this.maxUnavailable = null;
    this.minimalAction = null;
    this.replacementMethod = null;
    this.type = null;
  }

  private InstanceGroupManagerUpdatePolicy(
      String instanceRedistributionType,
      FixedOrPercent maxSurge,
      FixedOrPercent maxUnavailable,
      String minimalAction,
      String replacementMethod,
      String type) {
    this.instanceRedistributionType = instanceRedistributionType;
    this.maxSurge = maxSurge;
    this.maxUnavailable = maxUnavailable;
    this.minimalAction = minimalAction;
    this.replacementMethod = replacementMethod;
    this.type = type;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("instanceRedistributionType".equals(fieldName)) {
      return instanceRedistributionType;
    }
    if ("maxSurge".equals(fieldName)) {
      return maxSurge;
    }
    if ("maxUnavailable".equals(fieldName)) {
      return maxUnavailable;
    }
    if ("minimalAction".equals(fieldName)) {
      return minimalAction;
    }
    if ("replacementMethod".equals(fieldName)) {
      return replacementMethod;
    }
    if ("type".equals(fieldName)) {
      return type;
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
   * The instance redistribution policy for regional managed instance groups. Valid values are: -
   * PROACTIVE (default): The group attempts to maintain an even distribution of VM instances across
   * zones in the region. - NONE: For non-autoscaled groups, proactive redistribution is disabled.
   */
  public String getInstanceRedistributionType() {
    return instanceRedistributionType;
  }

  /**
   * The maximum number of instances that can be created above the specified targetSize during the
   * update process. By default, a fixed value of 1 is used. This value can be either a fixed number
   * or a percentage if the instance group has 10 or more instances. If you set a percentage, the
   * number of instances will be rounded up if necessary.
   *
   * <p>At least one of either maxSurge or maxUnavailable must be greater than 0. Learn more about
   * maxSurge.
   */
  public FixedOrPercent getMaxSurge() {
    return maxSurge;
  }

  /**
   * The maximum number of instances that can be unavailable during the update process. An instance
   * is considered available if all of the following conditions are satisfied:
   *
   * <p>- The instance's status is RUNNING. - If there is a health check on the instance group, the
   * instance's liveness health check result must be HEALTHY at least once. If there is no health
   * check on the group, then the instance only needs to have a status of RUNNING to be considered
   * available. By default, a fixed value of 1 is used. This value can be either a fixed number or a
   * percentage if the instance group has 10 or more instances. If you set a percentage, the number
   * of instances will be rounded up if necessary.
   *
   * <p>At least one of either maxSurge or maxUnavailable must be greater than 0. Learn more about
   * maxUnavailable.
   */
  public FixedOrPercent getMaxUnavailable() {
    return maxUnavailable;
  }

  /**
   * Minimal action to be taken on an instance. You can specify either RESTART to restart existing
   * instances or REPLACE to delete and create new instances from the target template. If you
   * specify a RESTART, the Updater will attempt to perform that action only. However, if the
   * Updater determines that the minimal action you specify is not enough to perform the update, it
   * might perform a more disruptive action.
   */
  public String getMinimalAction() {
    return minimalAction;
  }

  /** What action should be used to replace instances. See minimal_action.REPLACE */
  public String getReplacementMethod() {
    return replacementMethod;
  }

  /**
   * The type of update process. You can specify either PROACTIVE so that the instance group manager
   * proactively executes actions in order to bring instances to their target versions or
   * OPPORTUNISTIC so that no action is proactively executed but the update will be performed as
   * part of other actions (for example, resizes or recreateInstances calls).
   */
  public String getType() {
    return type;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManagerUpdatePolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagerUpdatePolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagerUpdatePolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagerUpdatePolicy();
  }

  public static class Builder {
    private String instanceRedistributionType;
    private FixedOrPercent maxSurge;
    private FixedOrPercent maxUnavailable;
    private String minimalAction;
    private String replacementMethod;
    private String type;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagerUpdatePolicy other) {
      if (other == InstanceGroupManagerUpdatePolicy.getDefaultInstance()) return this;
      if (other.getInstanceRedistributionType() != null) {
        this.instanceRedistributionType = other.instanceRedistributionType;
      }
      if (other.getMaxSurge() != null) {
        this.maxSurge = other.maxSurge;
      }
      if (other.getMaxUnavailable() != null) {
        this.maxUnavailable = other.maxUnavailable;
      }
      if (other.getMinimalAction() != null) {
        this.minimalAction = other.minimalAction;
      }
      if (other.getReplacementMethod() != null) {
        this.replacementMethod = other.replacementMethod;
      }
      if (other.getType() != null) {
        this.type = other.type;
      }
      return this;
    }

    Builder(InstanceGroupManagerUpdatePolicy source) {
      this.instanceRedistributionType = source.instanceRedistributionType;
      this.maxSurge = source.maxSurge;
      this.maxUnavailable = source.maxUnavailable;
      this.minimalAction = source.minimalAction;
      this.replacementMethod = source.replacementMethod;
      this.type = source.type;
    }

    /**
     * The instance redistribution policy for regional managed instance groups. Valid values are: -
     * PROACTIVE (default): The group attempts to maintain an even distribution of VM instances
     * across zones in the region. - NONE: For non-autoscaled groups, proactive redistribution is
     * disabled.
     */
    public String getInstanceRedistributionType() {
      return instanceRedistributionType;
    }

    /**
     * The instance redistribution policy for regional managed instance groups. Valid values are: -
     * PROACTIVE (default): The group attempts to maintain an even distribution of VM instances
     * across zones in the region. - NONE: For non-autoscaled groups, proactive redistribution is
     * disabled.
     */
    public Builder setInstanceRedistributionType(String instanceRedistributionType) {
      this.instanceRedistributionType = instanceRedistributionType;
      return this;
    }

    /**
     * The maximum number of instances that can be created above the specified targetSize during the
     * update process. By default, a fixed value of 1 is used. This value can be either a fixed
     * number or a percentage if the instance group has 10 or more instances. If you set a
     * percentage, the number of instances will be rounded up if necessary.
     *
     * <p>At least one of either maxSurge or maxUnavailable must be greater than 0. Learn more about
     * maxSurge.
     */
    public FixedOrPercent getMaxSurge() {
      return maxSurge;
    }

    /**
     * The maximum number of instances that can be created above the specified targetSize during the
     * update process. By default, a fixed value of 1 is used. This value can be either a fixed
     * number or a percentage if the instance group has 10 or more instances. If you set a
     * percentage, the number of instances will be rounded up if necessary.
     *
     * <p>At least one of either maxSurge or maxUnavailable must be greater than 0. Learn more about
     * maxSurge.
     */
    public Builder setMaxSurge(FixedOrPercent maxSurge) {
      this.maxSurge = maxSurge;
      return this;
    }

    /**
     * The maximum number of instances that can be unavailable during the update process. An
     * instance is considered available if all of the following conditions are satisfied:
     *
     * <p>- The instance's status is RUNNING. - If there is a health check on the instance group,
     * the instance's liveness health check result must be HEALTHY at least once. If there is no
     * health check on the group, then the instance only needs to have a status of RUNNING to be
     * considered available. By default, a fixed value of 1 is used. This value can be either a
     * fixed number or a percentage if the instance group has 10 or more instances. If you set a
     * percentage, the number of instances will be rounded up if necessary.
     *
     * <p>At least one of either maxSurge or maxUnavailable must be greater than 0. Learn more about
     * maxUnavailable.
     */
    public FixedOrPercent getMaxUnavailable() {
      return maxUnavailable;
    }

    /**
     * The maximum number of instances that can be unavailable during the update process. An
     * instance is considered available if all of the following conditions are satisfied:
     *
     * <p>- The instance's status is RUNNING. - If there is a health check on the instance group,
     * the instance's liveness health check result must be HEALTHY at least once. If there is no
     * health check on the group, then the instance only needs to have a status of RUNNING to be
     * considered available. By default, a fixed value of 1 is used. This value can be either a
     * fixed number or a percentage if the instance group has 10 or more instances. If you set a
     * percentage, the number of instances will be rounded up if necessary.
     *
     * <p>At least one of either maxSurge or maxUnavailable must be greater than 0. Learn more about
     * maxUnavailable.
     */
    public Builder setMaxUnavailable(FixedOrPercent maxUnavailable) {
      this.maxUnavailable = maxUnavailable;
      return this;
    }

    /**
     * Minimal action to be taken on an instance. You can specify either RESTART to restart existing
     * instances or REPLACE to delete and create new instances from the target template. If you
     * specify a RESTART, the Updater will attempt to perform that action only. However, if the
     * Updater determines that the minimal action you specify is not enough to perform the update,
     * it might perform a more disruptive action.
     */
    public String getMinimalAction() {
      return minimalAction;
    }

    /**
     * Minimal action to be taken on an instance. You can specify either RESTART to restart existing
     * instances or REPLACE to delete and create new instances from the target template. If you
     * specify a RESTART, the Updater will attempt to perform that action only. However, if the
     * Updater determines that the minimal action you specify is not enough to perform the update,
     * it might perform a more disruptive action.
     */
    public Builder setMinimalAction(String minimalAction) {
      this.minimalAction = minimalAction;
      return this;
    }

    /** What action should be used to replace instances. See minimal_action.REPLACE */
    public String getReplacementMethod() {
      return replacementMethod;
    }

    /** What action should be used to replace instances. See minimal_action.REPLACE */
    public Builder setReplacementMethod(String replacementMethod) {
      this.replacementMethod = replacementMethod;
      return this;
    }

    /**
     * The type of update process. You can specify either PROACTIVE so that the instance group
     * manager proactively executes actions in order to bring instances to their target versions or
     * OPPORTUNISTIC so that no action is proactively executed but the update will be performed as
     * part of other actions (for example, resizes or recreateInstances calls).
     */
    public String getType() {
      return type;
    }

    /**
     * The type of update process. You can specify either PROACTIVE so that the instance group
     * manager proactively executes actions in order to bring instances to their target versions or
     * OPPORTUNISTIC so that no action is proactively executed but the update will be performed as
     * part of other actions (for example, resizes or recreateInstances calls).
     */
    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    public InstanceGroupManagerUpdatePolicy build() {

      return new InstanceGroupManagerUpdatePolicy(
          instanceRedistributionType,
          maxSurge,
          maxUnavailable,
          minimalAction,
          replacementMethod,
          type);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setInstanceRedistributionType(this.instanceRedistributionType);
      newBuilder.setMaxSurge(this.maxSurge);
      newBuilder.setMaxUnavailable(this.maxUnavailable);
      newBuilder.setMinimalAction(this.minimalAction);
      newBuilder.setReplacementMethod(this.replacementMethod);
      newBuilder.setType(this.type);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagerUpdatePolicy{"
        + "instanceRedistributionType="
        + instanceRedistributionType
        + ", "
        + "maxSurge="
        + maxSurge
        + ", "
        + "maxUnavailable="
        + maxUnavailable
        + ", "
        + "minimalAction="
        + minimalAction
        + ", "
        + "replacementMethod="
        + replacementMethod
        + ", "
        + "type="
        + type
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagerUpdatePolicy) {
      InstanceGroupManagerUpdatePolicy that = (InstanceGroupManagerUpdatePolicy) o;
      return Objects.equals(this.instanceRedistributionType, that.getInstanceRedistributionType())
          && Objects.equals(this.maxSurge, that.getMaxSurge())
          && Objects.equals(this.maxUnavailable, that.getMaxUnavailable())
          && Objects.equals(this.minimalAction, that.getMinimalAction())
          && Objects.equals(this.replacementMethod, that.getReplacementMethod())
          && Objects.equals(this.type, that.getType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        instanceRedistributionType,
        maxSurge,
        maxUnavailable,
        minimalAction,
        replacementMethod,
        type);
  }
}
