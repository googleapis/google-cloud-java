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
public final class SubnetworksExpandIpCidrRangeRequest implements ApiMessage {
  private final String ipCidrRange;

  private SubnetworksExpandIpCidrRangeRequest() {
    this.ipCidrRange = null;
  }

  private SubnetworksExpandIpCidrRangeRequest(String ipCidrRange) {
    this.ipCidrRange = ipCidrRange;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("ipCidrRange")) {
      return ipCidrRange;
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

  public String getIpCidrRange() {
    return ipCidrRange;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SubnetworksExpandIpCidrRangeRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SubnetworksExpandIpCidrRangeRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SubnetworksExpandIpCidrRangeRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SubnetworksExpandIpCidrRangeRequest();
  }

  public static class Builder {
    private String ipCidrRange;

    Builder() {}

    public Builder mergeFrom(SubnetworksExpandIpCidrRangeRequest other) {
      if (other == SubnetworksExpandIpCidrRangeRequest.getDefaultInstance()) return this;
      if (other.getIpCidrRange() != null) {
        this.ipCidrRange = other.ipCidrRange;
      }
      return this;
    }

    Builder(SubnetworksExpandIpCidrRangeRequest source) {
      this.ipCidrRange = source.ipCidrRange;
    }

    public String getIpCidrRange() {
      return ipCidrRange;
    }

    public Builder setIpCidrRange(String ipCidrRange) {
      this.ipCidrRange = ipCidrRange;
      return this;
    }

    public SubnetworksExpandIpCidrRangeRequest build() {
      return new SubnetworksExpandIpCidrRangeRequest(ipCidrRange);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setIpCidrRange(this.ipCidrRange);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SubnetworksExpandIpCidrRangeRequest{" + "ipCidrRange=" + ipCidrRange + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SubnetworksExpandIpCidrRangeRequest) {
      SubnetworksExpandIpCidrRangeRequest that = (SubnetworksExpandIpCidrRangeRequest) o;
      return Objects.equals(this.ipCidrRange, that.getIpCidrRange());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(ipCidrRange);
  }
}
