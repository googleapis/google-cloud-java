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
public final class InstanceGroupManagersSetTargetPoolsRequest implements ApiMessage {
  private final String fingerprint;
  private final List<String> targetPools;

  private InstanceGroupManagersSetTargetPoolsRequest() {
    this.fingerprint = null;
    this.targetPools = null;
  }

  private InstanceGroupManagersSetTargetPoolsRequest(String fingerprint, List<String> targetPools) {
    this.fingerprint = fingerprint;
    this.targetPools = targetPools;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("fingerprint".equals(fieldName)) {
      return fingerprint;
    }
    if ("targetPools".equals(fieldName)) {
      return targetPools;
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
   * The fingerprint of the target pools information. Use this optional property to prevent
   * conflicts when multiple users change the target pools settings concurrently. Obtain the
   * fingerprint with the instanceGroupManagers.get method. Then, include the fingerprint in your
   * request to ensure that you do not overwrite changes that were applied from another concurrent
   * request.
   */
  public String getFingerprint() {
    return fingerprint;
  }

  /**
   * The list of target pool URLs that instances in this managed instance group belong to. The
   * managed instance group applies these target pools to all of the instances in the group.
   * Existing instances and new instances in the group all receive these target pool settings.
   */
  public List<String> getTargetPoolsList() {
    return targetPools;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstanceGroupManagersSetTargetPoolsRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstanceGroupManagersSetTargetPoolsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstanceGroupManagersSetTargetPoolsRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstanceGroupManagersSetTargetPoolsRequest();
  }

  public static class Builder {
    private String fingerprint;
    private List<String> targetPools;

    Builder() {}

    public Builder mergeFrom(InstanceGroupManagersSetTargetPoolsRequest other) {
      if (other == InstanceGroupManagersSetTargetPoolsRequest.getDefaultInstance()) return this;
      if (other.getFingerprint() != null) {
        this.fingerprint = other.fingerprint;
      }
      if (other.getTargetPoolsList() != null) {
        this.targetPools = other.targetPools;
      }
      return this;
    }

    Builder(InstanceGroupManagersSetTargetPoolsRequest source) {
      this.fingerprint = source.fingerprint;
      this.targetPools = source.targetPools;
    }

    /**
     * The fingerprint of the target pools information. Use this optional property to prevent
     * conflicts when multiple users change the target pools settings concurrently. Obtain the
     * fingerprint with the instanceGroupManagers.get method. Then, include the fingerprint in your
     * request to ensure that you do not overwrite changes that were applied from another concurrent
     * request.
     */
    public String getFingerprint() {
      return fingerprint;
    }

    /**
     * The fingerprint of the target pools information. Use this optional property to prevent
     * conflicts when multiple users change the target pools settings concurrently. Obtain the
     * fingerprint with the instanceGroupManagers.get method. Then, include the fingerprint in your
     * request to ensure that you do not overwrite changes that were applied from another concurrent
     * request.
     */
    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    /**
     * The list of target pool URLs that instances in this managed instance group belong to. The
     * managed instance group applies these target pools to all of the instances in the group.
     * Existing instances and new instances in the group all receive these target pool settings.
     */
    public List<String> getTargetPoolsList() {
      return targetPools;
    }

    /**
     * The list of target pool URLs that instances in this managed instance group belong to. The
     * managed instance group applies these target pools to all of the instances in the group.
     * Existing instances and new instances in the group all receive these target pool settings.
     */
    public Builder addAllTargetPools(List<String> targetPools) {
      if (this.targetPools == null) {
        this.targetPools = new LinkedList<>();
      }
      this.targetPools.addAll(targetPools);
      return this;
    }

    /**
     * The list of target pool URLs that instances in this managed instance group belong to. The
     * managed instance group applies these target pools to all of the instances in the group.
     * Existing instances and new instances in the group all receive these target pool settings.
     */
    public Builder addTargetPools(String targetPools) {
      if (this.targetPools == null) {
        this.targetPools = new LinkedList<>();
      }
      this.targetPools.add(targetPools);
      return this;
    }

    public InstanceGroupManagersSetTargetPoolsRequest build() {

      return new InstanceGroupManagersSetTargetPoolsRequest(fingerprint, targetPools);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setFingerprint(this.fingerprint);
      newBuilder.addAllTargetPools(this.targetPools);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstanceGroupManagersSetTargetPoolsRequest{"
        + "fingerprint="
        + fingerprint
        + ", "
        + "targetPools="
        + targetPools
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstanceGroupManagersSetTargetPoolsRequest) {
      InstanceGroupManagersSetTargetPoolsRequest that =
          (InstanceGroupManagersSetTargetPoolsRequest) o;
      return Objects.equals(this.fingerprint, that.getFingerprint())
          && Objects.equals(this.targetPools, that.getTargetPoolsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fingerprint, targetPools);
  }
}
