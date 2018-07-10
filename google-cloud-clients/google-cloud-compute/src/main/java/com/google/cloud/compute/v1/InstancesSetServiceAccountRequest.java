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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class InstancesSetServiceAccountRequest implements ApiMessage {
  private final String email;
  private final List<String> scopes;

  private InstancesSetServiceAccountRequest() {
    this.email = null;
    this.scopes = null;
  }

  private InstancesSetServiceAccountRequest(String email, List<String> scopes) {
    this.email = email;
    this.scopes = scopes;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("email")) {
      return email;
    }
    if (fieldName.equals("scopes")) {
      return scopes;
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

  public String getEmail() {
    return email;
  }

  public List<String> getScopesList() {
    return scopes;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InstancesSetServiceAccountRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InstancesSetServiceAccountRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InstancesSetServiceAccountRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InstancesSetServiceAccountRequest();
  }

  public static class Builder {
    private String email;
    private List<String> scopes;

    Builder() {}

    public Builder mergeFrom(InstancesSetServiceAccountRequest other) {
      if (other == InstancesSetServiceAccountRequest.getDefaultInstance()) return this;
      if (other.getEmail() != null) {
        this.email = other.email;
      }
      if (other.getScopesList() != null) {
        this.scopes = other.scopes;
      }
      return this;
    }

    Builder(InstancesSetServiceAccountRequest source) {
      this.email = source.email;
      this.scopes = source.scopes;
    }

    public String getEmail() {
      return email;
    }

    public Builder setEmail(String email) {
      this.email = email;
      return this;
    }

    public List<String> getScopesList() {
      return scopes;
    }

    public Builder addAllScopes(List<String> scopes) {
      if (this.scopes == null) {
        this.scopes = new LinkedList<>();
      }
      this.scopes.addAll(scopes);
      return this;
    }

    public Builder addScopes(String scopes) {
      if (this.scopes == null) {
        this.scopes = new LinkedList<>();
      }
      this.scopes.add(scopes);
      return this;
    }

    public InstancesSetServiceAccountRequest build() {

      return new InstancesSetServiceAccountRequest(email, scopes);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setEmail(this.email);
      newBuilder.addAllScopes(this.scopes);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InstancesSetServiceAccountRequest{"
        + "email="
        + email
        + ", "
        + "scopes="
        + scopes
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InstancesSetServiceAccountRequest) {
      InstancesSetServiceAccountRequest that = (InstancesSetServiceAccountRequest) o;
      return Objects.equals(this.email, that.getEmail())
          && Objects.equals(this.scopes, that.getScopesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, scopes);
  }
}
