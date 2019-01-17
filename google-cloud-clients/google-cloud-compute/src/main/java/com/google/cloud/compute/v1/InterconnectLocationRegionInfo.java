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
public final class InterconnectLocationRegionInfo implements ApiMessage {
  private final String expectedRttMs;
  private final String locationPresence;
  private final String region;

  private InterconnectLocationRegionInfo() {
    this.expectedRttMs = null;
    this.locationPresence = null;
    this.region = null;
  }

  private InterconnectLocationRegionInfo(
      String expectedRttMs, String locationPresence, String region) {
    this.expectedRttMs = expectedRttMs;
    this.locationPresence = locationPresence;
    this.region = region;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("expectedRttMs".equals(fieldName)) {
      return expectedRttMs;
    }
    if ("locationPresence".equals(fieldName)) {
      return locationPresence;
    }
    if ("region".equals(fieldName)) {
      return region;
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

  public String getExpectedRttMs() {
    return expectedRttMs;
  }

  public String getLocationPresence() {
    return locationPresence;
  }

  public String getRegion() {
    return region;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InterconnectLocationRegionInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InterconnectLocationRegionInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InterconnectLocationRegionInfo DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InterconnectLocationRegionInfo();
  }

  public static class Builder {
    private String expectedRttMs;
    private String locationPresence;
    private String region;

    Builder() {}

    public Builder mergeFrom(InterconnectLocationRegionInfo other) {
      if (other == InterconnectLocationRegionInfo.getDefaultInstance()) return this;
      if (other.getExpectedRttMs() != null) {
        this.expectedRttMs = other.expectedRttMs;
      }
      if (other.getLocationPresence() != null) {
        this.locationPresence = other.locationPresence;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      return this;
    }

    Builder(InterconnectLocationRegionInfo source) {
      this.expectedRttMs = source.expectedRttMs;
      this.locationPresence = source.locationPresence;
      this.region = source.region;
    }

    public String getExpectedRttMs() {
      return expectedRttMs;
    }

    public Builder setExpectedRttMs(String expectedRttMs) {
      this.expectedRttMs = expectedRttMs;
      return this;
    }

    public String getLocationPresence() {
      return locationPresence;
    }

    public Builder setLocationPresence(String locationPresence) {
      this.locationPresence = locationPresence;
      return this;
    }

    public String getRegion() {
      return region;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public InterconnectLocationRegionInfo build() {

      return new InterconnectLocationRegionInfo(expectedRttMs, locationPresence, region);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setExpectedRttMs(this.expectedRttMs);
      newBuilder.setLocationPresence(this.locationPresence);
      newBuilder.setRegion(this.region);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InterconnectLocationRegionInfo{"
        + "expectedRttMs="
        + expectedRttMs
        + ", "
        + "locationPresence="
        + locationPresence
        + ", "
        + "region="
        + region
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InterconnectLocationRegionInfo) {
      InterconnectLocationRegionInfo that = (InterconnectLocationRegionInfo) o;
      return Objects.equals(this.expectedRttMs, that.getExpectedRttMs())
          && Objects.equals(this.locationPresence, that.getLocationPresence())
          && Objects.equals(this.region, that.getRegion());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(expectedRttMs, locationPresence, region);
  }
}
