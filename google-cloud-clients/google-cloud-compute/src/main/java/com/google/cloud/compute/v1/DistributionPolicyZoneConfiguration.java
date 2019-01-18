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
public final class DistributionPolicyZoneConfiguration implements ApiMessage {
  private final String zone;

  private DistributionPolicyZoneConfiguration() {
    this.zone = null;
  }

  private DistributionPolicyZoneConfiguration(String zone) {
    this.zone = zone;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("zone".equals(fieldName)) {
      return zone;
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

  public String getZone() {
    return zone;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(DistributionPolicyZoneConfiguration prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static DistributionPolicyZoneConfiguration getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final DistributionPolicyZoneConfiguration DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new DistributionPolicyZoneConfiguration();
  }

  public static class Builder {
    private String zone;

    Builder() {}

    public Builder mergeFrom(DistributionPolicyZoneConfiguration other) {
      if (other == DistributionPolicyZoneConfiguration.getDefaultInstance()) return this;
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(DistributionPolicyZoneConfiguration source) {
      this.zone = source.zone;
    }

    public String getZone() {
      return zone;
    }

    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public DistributionPolicyZoneConfiguration build() {
      return new DistributionPolicyZoneConfiguration(zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "DistributionPolicyZoneConfiguration{" + "zone=" + zone + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DistributionPolicyZoneConfiguration) {
      DistributionPolicyZoneConfiguration that = (DistributionPolicyZoneConfiguration) o;
      return Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(zone);
  }
}
