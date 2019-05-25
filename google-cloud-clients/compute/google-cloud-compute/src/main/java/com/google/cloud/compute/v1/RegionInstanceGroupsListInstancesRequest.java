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
public final class RegionInstanceGroupsListInstancesRequest implements ApiMessage {
  private final String instanceState;
  private final String portName;

  private RegionInstanceGroupsListInstancesRequest() {
    this.instanceState = null;
    this.portName = null;
  }

  private RegionInstanceGroupsListInstancesRequest(String instanceState, String portName) {
    this.instanceState = instanceState;
    this.portName = portName;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("instanceState".equals(fieldName)) {
      return instanceState;
    }
    if ("portName".equals(fieldName)) {
      return portName;
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
   * Instances in which state should be returned. Valid options are: 'ALL', 'RUNNING'. By default,
   * it lists all instances.
   */
  public String getInstanceState() {
    return instanceState;
  }

  /**
   * Name of port user is interested in. It is optional. If it is set, only information about this
   * ports will be returned. If it is not set, all the named ports will be returned. Always lists
   * all instances.
   */
  public String getPortName() {
    return portName;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RegionInstanceGroupsListInstancesRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RegionInstanceGroupsListInstancesRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RegionInstanceGroupsListInstancesRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RegionInstanceGroupsListInstancesRequest();
  }

  public static class Builder {
    private String instanceState;
    private String portName;

    Builder() {}

    public Builder mergeFrom(RegionInstanceGroupsListInstancesRequest other) {
      if (other == RegionInstanceGroupsListInstancesRequest.getDefaultInstance()) return this;
      if (other.getInstanceState() != null) {
        this.instanceState = other.instanceState;
      }
      if (other.getPortName() != null) {
        this.portName = other.portName;
      }
      return this;
    }

    Builder(RegionInstanceGroupsListInstancesRequest source) {
      this.instanceState = source.instanceState;
      this.portName = source.portName;
    }

    /**
     * Instances in which state should be returned. Valid options are: 'ALL', 'RUNNING'. By default,
     * it lists all instances.
     */
    public String getInstanceState() {
      return instanceState;
    }

    /**
     * Instances in which state should be returned. Valid options are: 'ALL', 'RUNNING'. By default,
     * it lists all instances.
     */
    public Builder setInstanceState(String instanceState) {
      this.instanceState = instanceState;
      return this;
    }

    /**
     * Name of port user is interested in. It is optional. If it is set, only information about this
     * ports will be returned. If it is not set, all the named ports will be returned. Always lists
     * all instances.
     */
    public String getPortName() {
      return portName;
    }

    /**
     * Name of port user is interested in. It is optional. If it is set, only information about this
     * ports will be returned. If it is not set, all the named ports will be returned. Always lists
     * all instances.
     */
    public Builder setPortName(String portName) {
      this.portName = portName;
      return this;
    }

    public RegionInstanceGroupsListInstancesRequest build() {

      return new RegionInstanceGroupsListInstancesRequest(instanceState, portName);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setInstanceState(this.instanceState);
      newBuilder.setPortName(this.portName);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RegionInstanceGroupsListInstancesRequest{"
        + "instanceState="
        + instanceState
        + ", "
        + "portName="
        + portName
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RegionInstanceGroupsListInstancesRequest) {
      RegionInstanceGroupsListInstancesRequest that = (RegionInstanceGroupsListInstancesRequest) o;
      return Objects.equals(this.instanceState, that.getInstanceState())
          && Objects.equals(this.portName, that.getPortName());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceState, portName);
  }
}
