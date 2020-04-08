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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class SecurityPoliciesListPreconfiguredExpressionSetsResponse implements ApiMessage {
  private final SecurityPoliciesWafConfig preconfiguredExpressionSets;

  private SecurityPoliciesListPreconfiguredExpressionSetsResponse() {
    this.preconfiguredExpressionSets = null;
  }

  private SecurityPoliciesListPreconfiguredExpressionSetsResponse(
      SecurityPoliciesWafConfig preconfiguredExpressionSets) {
    this.preconfiguredExpressionSets = preconfiguredExpressionSets;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("preconfiguredExpressionSets".equals(fieldName)) {
      return preconfiguredExpressionSets;
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

  public SecurityPoliciesWafConfig getPreconfiguredExpressionSets() {
    return preconfiguredExpressionSets;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(
      SecurityPoliciesListPreconfiguredExpressionSetsResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SecurityPoliciesListPreconfiguredExpressionSetsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SecurityPoliciesListPreconfiguredExpressionSetsResponse DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SecurityPoliciesListPreconfiguredExpressionSetsResponse();
  }

  public static class Builder {
    private SecurityPoliciesWafConfig preconfiguredExpressionSets;

    Builder() {}

    public Builder mergeFrom(SecurityPoliciesListPreconfiguredExpressionSetsResponse other) {
      if (other == SecurityPoliciesListPreconfiguredExpressionSetsResponse.getDefaultInstance())
        return this;
      if (other.getPreconfiguredExpressionSets() != null) {
        this.preconfiguredExpressionSets = other.preconfiguredExpressionSets;
      }
      return this;
    }

    Builder(SecurityPoliciesListPreconfiguredExpressionSetsResponse source) {
      this.preconfiguredExpressionSets = source.preconfiguredExpressionSets;
    }

    public SecurityPoliciesWafConfig getPreconfiguredExpressionSets() {
      return preconfiguredExpressionSets;
    }

    public Builder setPreconfiguredExpressionSets(
        SecurityPoliciesWafConfig preconfiguredExpressionSets) {
      this.preconfiguredExpressionSets = preconfiguredExpressionSets;
      return this;
    }

    public SecurityPoliciesListPreconfiguredExpressionSetsResponse build() {
      return new SecurityPoliciesListPreconfiguredExpressionSetsResponse(
          preconfiguredExpressionSets);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setPreconfiguredExpressionSets(this.preconfiguredExpressionSets);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SecurityPoliciesListPreconfiguredExpressionSetsResponse{"
        + "preconfiguredExpressionSets="
        + preconfiguredExpressionSets
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SecurityPoliciesListPreconfiguredExpressionSetsResponse) {
      SecurityPoliciesListPreconfiguredExpressionSetsResponse that =
          (SecurityPoliciesListPreconfiguredExpressionSetsResponse) o;
      return Objects.equals(
          this.preconfiguredExpressionSets, that.getPreconfiguredExpressionSets());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(preconfiguredExpressionSets);
  }
}
