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
public final class ProjectsSetDefaultNetworkTierRequest implements ApiMessage {
  private final String networkTier;

  private ProjectsSetDefaultNetworkTierRequest() {
    this.networkTier = null;
  }

  private ProjectsSetDefaultNetworkTierRequest(String networkTier) {
    this.networkTier = networkTier;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("networkTier")) {
      return networkTier;
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

  public String getNetworkTier() {
    return networkTier;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ProjectsSetDefaultNetworkTierRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ProjectsSetDefaultNetworkTierRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ProjectsSetDefaultNetworkTierRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ProjectsSetDefaultNetworkTierRequest();
  }

  public static class Builder {
    private String networkTier;

    Builder() {}

    public Builder mergeFrom(ProjectsSetDefaultNetworkTierRequest other) {
      if (other == ProjectsSetDefaultNetworkTierRequest.getDefaultInstance()) return this;
      if (other.getNetworkTier() != null) {
        this.networkTier = other.networkTier;
      }
      return this;
    }

    Builder(ProjectsSetDefaultNetworkTierRequest source) {
      this.networkTier = source.networkTier;
    }

    public String getNetworkTier() {
      return networkTier;
    }

    public Builder setNetworkTier(String networkTier) {
      this.networkTier = networkTier;
      return this;
    }

    public ProjectsSetDefaultNetworkTierRequest build() {
      return new ProjectsSetDefaultNetworkTierRequest(networkTier);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setNetworkTier(this.networkTier);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ProjectsSetDefaultNetworkTierRequest{" + "networkTier=" + networkTier + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectsSetDefaultNetworkTierRequest) {
      ProjectsSetDefaultNetworkTierRequest that = (ProjectsSetDefaultNetworkTierRequest) o;
      return Objects.equals(this.networkTier, that.getNetworkTier());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkTier);
  }
}
