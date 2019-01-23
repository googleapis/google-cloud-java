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
public final class TestPermissionsResponse implements ApiMessage {
  private final List<String> permissions;

  private TestPermissionsResponse() {
    this.permissions = null;
  }

  private TestPermissionsResponse(List<String> permissions) {
    this.permissions = permissions;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("permissions".equals(fieldName)) {
      return permissions;
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

  public List<String> getPermissionsList() {
    return permissions;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TestPermissionsResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TestPermissionsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TestPermissionsResponse DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TestPermissionsResponse();
  }

  public static class Builder {
    private List<String> permissions;

    Builder() {}

    public Builder mergeFrom(TestPermissionsResponse other) {
      if (other == TestPermissionsResponse.getDefaultInstance()) return this;
      if (other.getPermissionsList() != null) {
        this.permissions = other.permissions;
      }
      return this;
    }

    Builder(TestPermissionsResponse source) {
      this.permissions = source.permissions;
    }

    public List<String> getPermissionsList() {
      return permissions;
    }

    public Builder addAllPermissions(List<String> permissions) {
      if (this.permissions == null) {
        this.permissions = new LinkedList<>();
      }
      this.permissions.addAll(permissions);
      return this;
    }

    public Builder addPermissions(String permissions) {
      if (this.permissions == null) {
        this.permissions = new LinkedList<>();
      }
      this.permissions.add(permissions);
      return this;
    }

    public TestPermissionsResponse build() {
      return new TestPermissionsResponse(permissions);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllPermissions(this.permissions);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TestPermissionsResponse{" + "permissions=" + permissions + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TestPermissionsResponse) {
      TestPermissionsResponse that = (TestPermissionsResponse) o;
      return Objects.equals(this.permissions, that.getPermissionsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(permissions);
  }
}
