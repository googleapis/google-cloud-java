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
public final class SubnetworksSetPrivateIpGoogleAccessRequest implements ApiMessage {
  private final Boolean privateIpGoogleAccess;

  private SubnetworksSetPrivateIpGoogleAccessRequest() {
    this.privateIpGoogleAccess = null;
  }

  private SubnetworksSetPrivateIpGoogleAccessRequest(Boolean privateIpGoogleAccess) {
    this.privateIpGoogleAccess = privateIpGoogleAccess;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("privateIpGoogleAccess".equals(fieldName)) {
      return privateIpGoogleAccess;
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

  public Boolean getPrivateIpGoogleAccess() {
    return privateIpGoogleAccess;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SubnetworksSetPrivateIpGoogleAccessRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SubnetworksSetPrivateIpGoogleAccessRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SubnetworksSetPrivateIpGoogleAccessRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SubnetworksSetPrivateIpGoogleAccessRequest();
  }

  public static class Builder {
    private Boolean privateIpGoogleAccess;

    Builder() {}

    public Builder mergeFrom(SubnetworksSetPrivateIpGoogleAccessRequest other) {
      if (other == SubnetworksSetPrivateIpGoogleAccessRequest.getDefaultInstance()) return this;
      if (other.getPrivateIpGoogleAccess() != null) {
        this.privateIpGoogleAccess = other.privateIpGoogleAccess;
      }
      return this;
    }

    Builder(SubnetworksSetPrivateIpGoogleAccessRequest source) {
      this.privateIpGoogleAccess = source.privateIpGoogleAccess;
    }

    public Boolean getPrivateIpGoogleAccess() {
      return privateIpGoogleAccess;
    }

    public Builder setPrivateIpGoogleAccess(Boolean privateIpGoogleAccess) {
      this.privateIpGoogleAccess = privateIpGoogleAccess;
      return this;
    }

    public SubnetworksSetPrivateIpGoogleAccessRequest build() {
      return new SubnetworksSetPrivateIpGoogleAccessRequest(privateIpGoogleAccess);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setPrivateIpGoogleAccess(this.privateIpGoogleAccess);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SubnetworksSetPrivateIpGoogleAccessRequest{"
        + "privateIpGoogleAccess="
        + privateIpGoogleAccess
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SubnetworksSetPrivateIpGoogleAccessRequest) {
      SubnetworksSetPrivateIpGoogleAccessRequest that =
          (SubnetworksSetPrivateIpGoogleAccessRequest) o;
      return Objects.equals(this.privateIpGoogleAccess, that.getPrivateIpGoogleAccess());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(privateIpGoogleAccess);
  }
}
