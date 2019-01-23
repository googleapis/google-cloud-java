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
public final class DistributionPolicy implements ApiMessage {
  private final List<DistributionPolicyZoneConfiguration> zones;

  private DistributionPolicy() {
    this.zones = null;
  }

  private DistributionPolicy(List<DistributionPolicyZoneConfiguration> zones) {
    this.zones = zones;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("zones".equals(fieldName)) {
      return zones;
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

  public List<DistributionPolicyZoneConfiguration> getZonesList() {
    return zones;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(DistributionPolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static DistributionPolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final DistributionPolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new DistributionPolicy();
  }

  public static class Builder {
    private List<DistributionPolicyZoneConfiguration> zones;

    Builder() {}

    public Builder mergeFrom(DistributionPolicy other) {
      if (other == DistributionPolicy.getDefaultInstance()) return this;
      if (other.getZonesList() != null) {
        this.zones = other.zones;
      }
      return this;
    }

    Builder(DistributionPolicy source) {
      this.zones = source.zones;
    }

    public List<DistributionPolicyZoneConfiguration> getZonesList() {
      return zones;
    }

    public Builder addAllZones(List<DistributionPolicyZoneConfiguration> zones) {
      if (this.zones == null) {
        this.zones = new LinkedList<>();
      }
      this.zones.addAll(zones);
      return this;
    }

    public Builder addZones(DistributionPolicyZoneConfiguration zones) {
      if (this.zones == null) {
        this.zones = new LinkedList<>();
      }
      this.zones.add(zones);
      return this;
    }

    public DistributionPolicy build() {
      return new DistributionPolicy(zones);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllZones(this.zones);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "DistributionPolicy{" + "zones=" + zones + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DistributionPolicy) {
      DistributionPolicy that = (DistributionPolicy) o;
      return Objects.equals(this.zones, that.getZonesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(zones);
  }
}
