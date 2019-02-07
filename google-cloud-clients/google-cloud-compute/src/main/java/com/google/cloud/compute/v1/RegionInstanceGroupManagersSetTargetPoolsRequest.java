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
public final class RegionInstanceGroupManagersSetTargetPoolsRequest implements ApiMessage {
  private final String fingerprint;
  private final List<String> targetPools;

  private RegionInstanceGroupManagersSetTargetPoolsRequest() {
    this.fingerprint = null;
    this.targetPools = null;
  }

  private RegionInstanceGroupManagersSetTargetPoolsRequest(
      String fingerprint, List<String> targetPools) {
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
   * Fingerprint of the target pools information, which is a hash of the contents. This field is
   * used for optimistic locking when you update the target pool entries. This field is optional.
   */
  public String getFingerprint() {
    return fingerprint;
  }

  /**
   * The URL of all TargetPool resources to which instances in the instanceGroup field are added.
   * The target pools automatically apply to all of the instances in the managed instance group.
   */
  public List<String> getTargetPoolsList() {
    return targetPools;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RegionInstanceGroupManagersSetTargetPoolsRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RegionInstanceGroupManagersSetTargetPoolsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RegionInstanceGroupManagersSetTargetPoolsRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RegionInstanceGroupManagersSetTargetPoolsRequest();
  }

  public static class Builder {
    private String fingerprint;
    private List<String> targetPools;

    Builder() {}

    public Builder mergeFrom(RegionInstanceGroupManagersSetTargetPoolsRequest other) {
      if (other == RegionInstanceGroupManagersSetTargetPoolsRequest.getDefaultInstance())
        return this;
      if (other.getFingerprint() != null) {
        this.fingerprint = other.fingerprint;
      }
      if (other.getTargetPoolsList() != null) {
        this.targetPools = other.targetPools;
      }
      return this;
    }

    Builder(RegionInstanceGroupManagersSetTargetPoolsRequest source) {
      this.fingerprint = source.fingerprint;
      this.targetPools = source.targetPools;
    }

    /**
     * Fingerprint of the target pools information, which is a hash of the contents. This field is
     * used for optimistic locking when you update the target pool entries. This field is optional.
     */
    public String getFingerprint() {
      return fingerprint;
    }

    /**
     * Fingerprint of the target pools information, which is a hash of the contents. This field is
     * used for optimistic locking when you update the target pool entries. This field is optional.
     */
    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    /**
     * The URL of all TargetPool resources to which instances in the instanceGroup field are added.
     * The target pools automatically apply to all of the instances in the managed instance group.
     */
    public List<String> getTargetPoolsList() {
      return targetPools;
    }

    /**
     * The URL of all TargetPool resources to which instances in the instanceGroup field are added.
     * The target pools automatically apply to all of the instances in the managed instance group.
     */
    public Builder addAllTargetPools(List<String> targetPools) {
      if (this.targetPools == null) {
        this.targetPools = new LinkedList<>();
      }
      this.targetPools.addAll(targetPools);
      return this;
    }

    /**
     * The URL of all TargetPool resources to which instances in the instanceGroup field are added.
     * The target pools automatically apply to all of the instances in the managed instance group.
     */
    public Builder addTargetPools(String targetPools) {
      if (this.targetPools == null) {
        this.targetPools = new LinkedList<>();
      }
      this.targetPools.add(targetPools);
      return this;
    }

    public RegionInstanceGroupManagersSetTargetPoolsRequest build() {

      return new RegionInstanceGroupManagersSetTargetPoolsRequest(fingerprint, targetPools);
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
    return "RegionInstanceGroupManagersSetTargetPoolsRequest{"
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
    if (o instanceof RegionInstanceGroupManagersSetTargetPoolsRequest) {
      RegionInstanceGroupManagersSetTargetPoolsRequest that =
          (RegionInstanceGroupManagersSetTargetPoolsRequest) o;
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
