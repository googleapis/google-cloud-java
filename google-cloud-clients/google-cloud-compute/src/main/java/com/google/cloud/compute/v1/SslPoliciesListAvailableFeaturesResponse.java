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
public final class SslPoliciesListAvailableFeaturesResponse implements ApiMessage {
  private final List<String> features;

  private SslPoliciesListAvailableFeaturesResponse() {
    this.features = null;
  }

  private SslPoliciesListAvailableFeaturesResponse(List<String> features) {
    this.features = features;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("features".equals(fieldName)) {
      return features;
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

  public List<String> getFeaturesList() {
    return features;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SslPoliciesListAvailableFeaturesResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SslPoliciesListAvailableFeaturesResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SslPoliciesListAvailableFeaturesResponse DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SslPoliciesListAvailableFeaturesResponse();
  }

  public static class Builder {
    private List<String> features;

    Builder() {}

    public Builder mergeFrom(SslPoliciesListAvailableFeaturesResponse other) {
      if (other == SslPoliciesListAvailableFeaturesResponse.getDefaultInstance()) return this;
      if (other.getFeaturesList() != null) {
        this.features = other.features;
      }
      return this;
    }

    Builder(SslPoliciesListAvailableFeaturesResponse source) {
      this.features = source.features;
    }

    public List<String> getFeaturesList() {
      return features;
    }

    public Builder addAllFeatures(List<String> features) {
      if (this.features == null) {
        this.features = new LinkedList<>();
      }
      this.features.addAll(features);
      return this;
    }

    public Builder addFeatures(String features) {
      if (this.features == null) {
        this.features = new LinkedList<>();
      }
      this.features.add(features);
      return this;
    }

    public SslPoliciesListAvailableFeaturesResponse build() {
      return new SslPoliciesListAvailableFeaturesResponse(features);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllFeatures(this.features);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SslPoliciesListAvailableFeaturesResponse{" + "features=" + features + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SslPoliciesListAvailableFeaturesResponse) {
      SslPoliciesListAvailableFeaturesResponse that = (SslPoliciesListAvailableFeaturesResponse) o;
      return Objects.equals(this.features, that.getFeaturesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(features);
  }
}
