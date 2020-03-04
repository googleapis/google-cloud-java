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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** InstanceGroupManagers.applyUpdatesToInstances */
public final class RegionInstanceGroupManagersApplyUpdatesRequest implements ApiMessage {
  private final List<String> instances;
  private final String minimalAction;
  private final String mostDisruptiveAllowedAction;

  private RegionInstanceGroupManagersApplyUpdatesRequest() {
    this.instances = null;
    this.minimalAction = null;
    this.mostDisruptiveAllowedAction = null;
  }

  private RegionInstanceGroupManagersApplyUpdatesRequest(
      List<String> instances, String minimalAction, String mostDisruptiveAllowedAction) {
    this.instances = instances;
    this.minimalAction = minimalAction;
    this.mostDisruptiveAllowedAction = mostDisruptiveAllowedAction;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("instances".equals(fieldName)) {
      return instances;
    }
    if ("minimalAction".equals(fieldName)) {
      return minimalAction;
    }
    if ("mostDisruptiveAllowedAction".equals(fieldName)) {
      return mostDisruptiveAllowedAction;
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
   * The list of URLs of one or more instances for which you want to apply updates. Each URL can be
   * a full URL or a partial URL, such as zones/[ZONE]/instances/[INSTANCE_NAME].
   */
  public List<String> getInstancesList() {
    return instances;
  }

  /**
   * The minimal action that you want to perform on each instance during the update: - REPLACE: At
   * minimum, delete the instance and create it again. - RESTART: Stop the instance and start it
   * again. - REFRESH: Do not stop the instance. - NONE: Do not disrupt the instance at all. By
   * default, the minimum action is NONE. If your update requires a more disruptive action than you
   * set with this flag, the necessary action is performed to execute the update.
   */
  public String getMinimalAction() {
    return minimalAction;
  }

  /**
   * The most disruptive action that you want to perform on each instance during the update: -
   * REPLACE: Delete the instance and create it again. - RESTART: Stop the instance and start it
   * again. - REFRESH: Do not stop the instance. - NONE: Do not disrupt the instance at all. By
   * default, the most disruptive allowed action is REPLACE. If your update requires a more
   * disruptive action than you set with this flag, the update request will fail.
   */
  public String getMostDisruptiveAllowedAction() {
    return mostDisruptiveAllowedAction;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RegionInstanceGroupManagersApplyUpdatesRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RegionInstanceGroupManagersApplyUpdatesRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RegionInstanceGroupManagersApplyUpdatesRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RegionInstanceGroupManagersApplyUpdatesRequest();
  }

  public static class Builder {
    private List<String> instances;
    private String minimalAction;
    private String mostDisruptiveAllowedAction;

    Builder() {}

    public Builder mergeFrom(RegionInstanceGroupManagersApplyUpdatesRequest other) {
      if (other == RegionInstanceGroupManagersApplyUpdatesRequest.getDefaultInstance()) return this;
      if (other.getInstancesList() != null) {
        this.instances = other.instances;
      }
      if (other.getMinimalAction() != null) {
        this.minimalAction = other.minimalAction;
      }
      if (other.getMostDisruptiveAllowedAction() != null) {
        this.mostDisruptiveAllowedAction = other.mostDisruptiveAllowedAction;
      }
      return this;
    }

    Builder(RegionInstanceGroupManagersApplyUpdatesRequest source) {
      this.instances = source.instances;
      this.minimalAction = source.minimalAction;
      this.mostDisruptiveAllowedAction = source.mostDisruptiveAllowedAction;
    }

    /**
     * The list of URLs of one or more instances for which you want to apply updates. Each URL can
     * be a full URL or a partial URL, such as zones/[ZONE]/instances/[INSTANCE_NAME].
     */
    public List<String> getInstancesList() {
      return instances;
    }

    /**
     * The list of URLs of one or more instances for which you want to apply updates. Each URL can
     * be a full URL or a partial URL, such as zones/[ZONE]/instances/[INSTANCE_NAME].
     */
    public Builder addAllInstances(List<String> instances) {
      if (this.instances == null) {
        this.instances = new LinkedList<>();
      }
      this.instances.addAll(instances);
      return this;
    }

    /**
     * The list of URLs of one or more instances for which you want to apply updates. Each URL can
     * be a full URL or a partial URL, such as zones/[ZONE]/instances/[INSTANCE_NAME].
     */
    public Builder addInstances(String instances) {
      if (this.instances == null) {
        this.instances = new LinkedList<>();
      }
      this.instances.add(instances);
      return this;
    }

    /**
     * The minimal action that you want to perform on each instance during the update: - REPLACE: At
     * minimum, delete the instance and create it again. - RESTART: Stop the instance and start it
     * again. - REFRESH: Do not stop the instance. - NONE: Do not disrupt the instance at all. By
     * default, the minimum action is NONE. If your update requires a more disruptive action than
     * you set with this flag, the necessary action is performed to execute the update.
     */
    public String getMinimalAction() {
      return minimalAction;
    }

    /**
     * The minimal action that you want to perform on each instance during the update: - REPLACE: At
     * minimum, delete the instance and create it again. - RESTART: Stop the instance and start it
     * again. - REFRESH: Do not stop the instance. - NONE: Do not disrupt the instance at all. By
     * default, the minimum action is NONE. If your update requires a more disruptive action than
     * you set with this flag, the necessary action is performed to execute the update.
     */
    public Builder setMinimalAction(String minimalAction) {
      this.minimalAction = minimalAction;
      return this;
    }

    /**
     * The most disruptive action that you want to perform on each instance during the update: -
     * REPLACE: Delete the instance and create it again. - RESTART: Stop the instance and start it
     * again. - REFRESH: Do not stop the instance. - NONE: Do not disrupt the instance at all. By
     * default, the most disruptive allowed action is REPLACE. If your update requires a more
     * disruptive action than you set with this flag, the update request will fail.
     */
    public String getMostDisruptiveAllowedAction() {
      return mostDisruptiveAllowedAction;
    }

    /**
     * The most disruptive action that you want to perform on each instance during the update: -
     * REPLACE: Delete the instance and create it again. - RESTART: Stop the instance and start it
     * again. - REFRESH: Do not stop the instance. - NONE: Do not disrupt the instance at all. By
     * default, the most disruptive allowed action is REPLACE. If your update requires a more
     * disruptive action than you set with this flag, the update request will fail.
     */
    public Builder setMostDisruptiveAllowedAction(String mostDisruptiveAllowedAction) {
      this.mostDisruptiveAllowedAction = mostDisruptiveAllowedAction;
      return this;
    }

    public RegionInstanceGroupManagersApplyUpdatesRequest build() {

      return new RegionInstanceGroupManagersApplyUpdatesRequest(
          instances, minimalAction, mostDisruptiveAllowedAction);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllInstances(this.instances);
      newBuilder.setMinimalAction(this.minimalAction);
      newBuilder.setMostDisruptiveAllowedAction(this.mostDisruptiveAllowedAction);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RegionInstanceGroupManagersApplyUpdatesRequest{"
        + "instances="
        + instances
        + ", "
        + "minimalAction="
        + minimalAction
        + ", "
        + "mostDisruptiveAllowedAction="
        + mostDisruptiveAllowedAction
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RegionInstanceGroupManagersApplyUpdatesRequest) {
      RegionInstanceGroupManagersApplyUpdatesRequest that =
          (RegionInstanceGroupManagersApplyUpdatesRequest) o;
      return Objects.equals(this.instances, that.getInstancesList())
          && Objects.equals(this.minimalAction, that.getMinimalAction())
          && Objects.equals(
              this.mostDisruptiveAllowedAction, that.getMostDisruptiveAllowedAction());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(instances, minimalAction, mostDisruptiveAllowedAction);
  }
}
