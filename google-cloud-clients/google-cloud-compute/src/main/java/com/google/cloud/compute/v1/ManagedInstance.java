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
/** A Managed Instance resource. */
public final class ManagedInstance implements ApiMessage {
  private final String currentAction;
  private final String id;
  private final String instance;
  private final String instanceStatus;
  private final ManagedInstanceLastAttempt lastAttempt;

  private ManagedInstance() {
    this.currentAction = null;
    this.id = null;
    this.instance = null;
    this.instanceStatus = null;
    this.lastAttempt = null;
  }

  private ManagedInstance(
      String currentAction,
      String id,
      String instance,
      String instanceStatus,
      ManagedInstanceLastAttempt lastAttempt) {
    this.currentAction = currentAction;
    this.id = id;
    this.instance = instance;
    this.instanceStatus = instanceStatus;
    this.lastAttempt = lastAttempt;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("currentAction".equals(fieldName)) {
      return currentAction;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("instance".equals(fieldName)) {
      return instance;
    }
    if ("instanceStatus".equals(fieldName)) {
      return instanceStatus;
    }
    if ("lastAttempt".equals(fieldName)) {
      return lastAttempt;
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
   * [Output Only] The current action that the managed instance group has scheduled for the
   * instance. Possible values: - NONE The instance is running, and the managed instance group does
   * not have any scheduled actions for this instance. - CREATING The managed instance group is
   * creating this instance. If the group fails to create this instance, it will try again until it
   * is successful. - CREATING_WITHOUT_RETRIES The managed instance group is attempting to create
   * this instance only once. If the group fails to create this instance, it does not try again and
   * the group's targetSize value is decreased instead. - RECREATING The managed instance group is
   * recreating this instance. - DELETING The managed instance group is permanently deleting this
   * instance. - ABANDONING The managed instance group is abandoning this instance. The instance
   * will be removed from the instance group and from any target pools that are associated with this
   * group. - RESTARTING The managed instance group is restarting the instance. - REFRESHING The
   * managed instance group is applying configuration changes to the instance without stopping it.
   * For example, the group can update the target pool list for an instance without stopping that
   * instance. - VERIFYING The managed instance group has created the instance and it is in the
   * process of being verified.
   */
  public String getCurrentAction() {
    return currentAction;
  }

  /**
   * [Output only] The unique identifier for this resource. This field is empty when instance does
   * not exist.
   */
  public String getId() {
    return id;
  }

  /**
   * [Output Only] The URL of the instance. The URL can exist even if the instance has not yet been
   * created.
   */
  public String getInstance() {
    return instance;
  }

  /**
   * [Output Only] The status of the instance. This field is empty when the instance does not exist.
   */
  public String getInstanceStatus() {
    return instanceStatus;
  }

  /** [Output Only] Information about the last attempt to create or delete the instance. */
  public ManagedInstanceLastAttempt getLastAttempt() {
    return lastAttempt;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ManagedInstance prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ManagedInstance getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ManagedInstance DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ManagedInstance();
  }

  public static class Builder {
    private String currentAction;
    private String id;
    private String instance;
    private String instanceStatus;
    private ManagedInstanceLastAttempt lastAttempt;

    Builder() {}

    public Builder mergeFrom(ManagedInstance other) {
      if (other == ManagedInstance.getDefaultInstance()) return this;
      if (other.getCurrentAction() != null) {
        this.currentAction = other.currentAction;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getInstance() != null) {
        this.instance = other.instance;
      }
      if (other.getInstanceStatus() != null) {
        this.instanceStatus = other.instanceStatus;
      }
      if (other.getLastAttempt() != null) {
        this.lastAttempt = other.lastAttempt;
      }
      return this;
    }

    Builder(ManagedInstance source) {
      this.currentAction = source.currentAction;
      this.id = source.id;
      this.instance = source.instance;
      this.instanceStatus = source.instanceStatus;
      this.lastAttempt = source.lastAttempt;
    }

    /**
     * [Output Only] The current action that the managed instance group has scheduled for the
     * instance. Possible values: - NONE The instance is running, and the managed instance group
     * does not have any scheduled actions for this instance. - CREATING The managed instance group
     * is creating this instance. If the group fails to create this instance, it will try again
     * until it is successful. - CREATING_WITHOUT_RETRIES The managed instance group is attempting
     * to create this instance only once. If the group fails to create this instance, it does not
     * try again and the group's targetSize value is decreased instead. - RECREATING The managed
     * instance group is recreating this instance. - DELETING The managed instance group is
     * permanently deleting this instance. - ABANDONING The managed instance group is abandoning
     * this instance. The instance will be removed from the instance group and from any target pools
     * that are associated with this group. - RESTARTING The managed instance group is restarting
     * the instance. - REFRESHING The managed instance group is applying configuration changes to
     * the instance without stopping it. For example, the group can update the target pool list for
     * an instance without stopping that instance. - VERIFYING The managed instance group has
     * created the instance and it is in the process of being verified.
     */
    public String getCurrentAction() {
      return currentAction;
    }

    /**
     * [Output Only] The current action that the managed instance group has scheduled for the
     * instance. Possible values: - NONE The instance is running, and the managed instance group
     * does not have any scheduled actions for this instance. - CREATING The managed instance group
     * is creating this instance. If the group fails to create this instance, it will try again
     * until it is successful. - CREATING_WITHOUT_RETRIES The managed instance group is attempting
     * to create this instance only once. If the group fails to create this instance, it does not
     * try again and the group's targetSize value is decreased instead. - RECREATING The managed
     * instance group is recreating this instance. - DELETING The managed instance group is
     * permanently deleting this instance. - ABANDONING The managed instance group is abandoning
     * this instance. The instance will be removed from the instance group and from any target pools
     * that are associated with this group. - RESTARTING The managed instance group is restarting
     * the instance. - REFRESHING The managed instance group is applying configuration changes to
     * the instance without stopping it. For example, the group can update the target pool list for
     * an instance without stopping that instance. - VERIFYING The managed instance group has
     * created the instance and it is in the process of being verified.
     */
    public Builder setCurrentAction(String currentAction) {
      this.currentAction = currentAction;
      return this;
    }

    /**
     * [Output only] The unique identifier for this resource. This field is empty when instance does
     * not exist.
     */
    public String getId() {
      return id;
    }

    /**
     * [Output only] The unique identifier for this resource. This field is empty when instance does
     * not exist.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /**
     * [Output Only] The URL of the instance. The URL can exist even if the instance has not yet
     * been created.
     */
    public String getInstance() {
      return instance;
    }

    /**
     * [Output Only] The URL of the instance. The URL can exist even if the instance has not yet
     * been created.
     */
    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    /**
     * [Output Only] The status of the instance. This field is empty when the instance does not
     * exist.
     */
    public String getInstanceStatus() {
      return instanceStatus;
    }

    /**
     * [Output Only] The status of the instance. This field is empty when the instance does not
     * exist.
     */
    public Builder setInstanceStatus(String instanceStatus) {
      this.instanceStatus = instanceStatus;
      return this;
    }

    /** [Output Only] Information about the last attempt to create or delete the instance. */
    public ManagedInstanceLastAttempt getLastAttempt() {
      return lastAttempt;
    }

    /** [Output Only] Information about the last attempt to create or delete the instance. */
    public Builder setLastAttempt(ManagedInstanceLastAttempt lastAttempt) {
      this.lastAttempt = lastAttempt;
      return this;
    }

    public ManagedInstance build() {

      return new ManagedInstance(currentAction, id, instance, instanceStatus, lastAttempt);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCurrentAction(this.currentAction);
      newBuilder.setId(this.id);
      newBuilder.setInstance(this.instance);
      newBuilder.setInstanceStatus(this.instanceStatus);
      newBuilder.setLastAttempt(this.lastAttempt);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ManagedInstance{"
        + "currentAction="
        + currentAction
        + ", "
        + "id="
        + id
        + ", "
        + "instance="
        + instance
        + ", "
        + "instanceStatus="
        + instanceStatus
        + ", "
        + "lastAttempt="
        + lastAttempt
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ManagedInstance) {
      ManagedInstance that = (ManagedInstance) o;
      return Objects.equals(this.currentAction, that.getCurrentAction())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.instance, that.getInstance())
          && Objects.equals(this.instanceStatus, that.getInstanceStatus())
          && Objects.equals(this.lastAttempt, that.getLastAttempt());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentAction, id, instance, instanceStatus, lastAttempt);
  }
}
