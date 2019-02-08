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
public final class InstancesSetMinCpuPlatformRequest implements ApiMessage {
  private final String minCpuPlatform;

  private InstancesSetMinCpuPlatformRequest() {
    this.minCpuPlatform = null;
  }

  private InstancesSetMinCpuPlatformRequest(String minCpuPlatform) {
    this.minCpuPlatform = minCpuPlatform;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("minCpuPlatform".equals(fieldName)) {
      return minCpuPlatform;
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

  /** Minimum cpu/platform this instance should be started at. */
  public String getMinCpuPlatform() {
    return minCpuPlatform;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstancesSetMinCpuPlatformRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstancesSetMinCpuPlatformRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstancesSetMinCpuPlatformRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstancesSetMinCpuPlatformRequest();
  }

  public static class Builder {
    private String minCpuPlatform;

    Builder() {}

    public Builder mergeFrom(InstancesSetMinCpuPlatformRequest other) {
      if (other == InstancesSetMinCpuPlatformRequest.getDefaultInstance()) return this;
      if (other.getMinCpuPlatform() != null) {
        this.minCpuPlatform = other.minCpuPlatform;
      }
      return this;
    }

    Builder(InstancesSetMinCpuPlatformRequest source) {
      this.minCpuPlatform = source.minCpuPlatform;
    }

    /** Minimum cpu/platform this instance should be started at. */
    public String getMinCpuPlatform() {
      return minCpuPlatform;
    }

    /** Minimum cpu/platform this instance should be started at. */
    public Builder setMinCpuPlatform(String minCpuPlatform) {
      this.minCpuPlatform = minCpuPlatform;
      return this;
    }

    public InstancesSetMinCpuPlatformRequest build() {
      return new InstancesSetMinCpuPlatformRequest(minCpuPlatform);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setMinCpuPlatform(this.minCpuPlatform);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstancesSetMinCpuPlatformRequest{" + "minCpuPlatform=" + minCpuPlatform + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstancesSetMinCpuPlatformRequest) {
      InstancesSetMinCpuPlatformRequest that = (InstancesSetMinCpuPlatformRequest) o;
      return Objects.equals(this.minCpuPlatform, that.getMinCpuPlatform());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(minCpuPlatform);
  }
}
