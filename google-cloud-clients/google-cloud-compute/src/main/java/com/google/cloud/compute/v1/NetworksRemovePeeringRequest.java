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
public final class NetworksRemovePeeringRequest implements ApiMessage {
  private final String name;

  private NetworksRemovePeeringRequest() {
    this.name = null;
  }

  private NetworksRemovePeeringRequest(String name) {
    this.name = name;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("name".equals(fieldName)) {
      return name;
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

  /** Name of the peering, which should conform to RFC1035. */
  public String getName() {
    return name;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NetworksRemovePeeringRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NetworksRemovePeeringRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NetworksRemovePeeringRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NetworksRemovePeeringRequest();
  }

  public static class Builder {
    private String name;

    Builder() {}

    public Builder mergeFrom(NetworksRemovePeeringRequest other) {
      if (other == NetworksRemovePeeringRequest.getDefaultInstance()) return this;
      if (other.getName() != null) {
        this.name = other.name;
      }
      return this;
    }

    Builder(NetworksRemovePeeringRequest source) {
      this.name = source.name;
    }

    /** Name of the peering, which should conform to RFC1035. */
    public String getName() {
      return name;
    }

    /** Name of the peering, which should conform to RFC1035. */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public NetworksRemovePeeringRequest build() {
      return new NetworksRemovePeeringRequest(name);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setName(this.name);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NetworksRemovePeeringRequest{" + "name=" + name + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworksRemovePeeringRequest) {
      NetworksRemovePeeringRequest that = (NetworksRemovePeeringRequest) o;
      return Objects.equals(this.name, that.getName());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
