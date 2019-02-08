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
/** Authorization-related information used by Cloud Audit Logging. */
public final class AuthorizationLoggingOptions implements ApiMessage {
  private final String permissionType;

  private AuthorizationLoggingOptions() {
    this.permissionType = null;
  }

  private AuthorizationLoggingOptions(String permissionType) {
    this.permissionType = permissionType;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("permissionType".equals(fieldName)) {
      return permissionType;
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

  /** The type of the permission that was checked. */
  public String getPermissionType() {
    return permissionType;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AuthorizationLoggingOptions prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AuthorizationLoggingOptions getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AuthorizationLoggingOptions DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AuthorizationLoggingOptions();
  }

  public static class Builder {
    private String permissionType;

    Builder() {}

    public Builder mergeFrom(AuthorizationLoggingOptions other) {
      if (other == AuthorizationLoggingOptions.getDefaultInstance()) return this;
      if (other.getPermissionType() != null) {
        this.permissionType = other.permissionType;
      }
      return this;
    }

    Builder(AuthorizationLoggingOptions source) {
      this.permissionType = source.permissionType;
    }

    /** The type of the permission that was checked. */
    public String getPermissionType() {
      return permissionType;
    }

    /** The type of the permission that was checked. */
    public Builder setPermissionType(String permissionType) {
      this.permissionType = permissionType;
      return this;
    }

    public AuthorizationLoggingOptions build() {
      return new AuthorizationLoggingOptions(permissionType);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setPermissionType(this.permissionType);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AuthorizationLoggingOptions{" + "permissionType=" + permissionType + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AuthorizationLoggingOptions) {
      AuthorizationLoggingOptions that = (AuthorizationLoggingOptions) o;
      return Objects.equals(this.permissionType, that.getPermissionType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(permissionType);
  }
}
