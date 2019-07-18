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
public final class DisksAddResourcePoliciesRequest implements ApiMessage {
  private final List<String> resourcePolicies;

  private DisksAddResourcePoliciesRequest() {
    this.resourcePolicies = null;
  }

  private DisksAddResourcePoliciesRequest(List<String> resourcePolicies) {
    this.resourcePolicies = resourcePolicies;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("resourcePolicies".equals(fieldName)) {
      return resourcePolicies;
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

  /** Resource policies to be added to this disk. */
  public List<String> getResourcePoliciesList() {
    return resourcePolicies;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(DisksAddResourcePoliciesRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static DisksAddResourcePoliciesRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final DisksAddResourcePoliciesRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new DisksAddResourcePoliciesRequest();
  }

  public static class Builder {
    private List<String> resourcePolicies;

    Builder() {}

    public Builder mergeFrom(DisksAddResourcePoliciesRequest other) {
      if (other == DisksAddResourcePoliciesRequest.getDefaultInstance()) return this;
      if (other.getResourcePoliciesList() != null) {
        this.resourcePolicies = other.resourcePolicies;
      }
      return this;
    }

    Builder(DisksAddResourcePoliciesRequest source) {
      this.resourcePolicies = source.resourcePolicies;
    }

    /** Resource policies to be added to this disk. */
    public List<String> getResourcePoliciesList() {
      return resourcePolicies;
    }

    /** Resource policies to be added to this disk. */
    public Builder addAllResourcePolicies(List<String> resourcePolicies) {
      if (this.resourcePolicies == null) {
        this.resourcePolicies = new LinkedList<>();
      }
      this.resourcePolicies.addAll(resourcePolicies);
      return this;
    }

    /** Resource policies to be added to this disk. */
    public Builder addResourcePolicies(String resourcePolicies) {
      if (this.resourcePolicies == null) {
        this.resourcePolicies = new LinkedList<>();
      }
      this.resourcePolicies.add(resourcePolicies);
      return this;
    }

    public DisksAddResourcePoliciesRequest build() {
      return new DisksAddResourcePoliciesRequest(resourcePolicies);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllResourcePolicies(this.resourcePolicies);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "DisksAddResourcePoliciesRequest{" + "resourcePolicies=" + resourcePolicies + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DisksAddResourcePoliciesRequest) {
      DisksAddResourcePoliciesRequest that = (DisksAddResourcePoliciesRequest) o;
      return Objects.equals(this.resourcePolicies, that.getResourcePoliciesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourcePolicies);
  }
}
