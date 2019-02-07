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
public final class ProjectsEnableXpnResourceRequest implements ApiMessage {
  private final XpnResourceId xpnResource;

  private ProjectsEnableXpnResourceRequest() {
    this.xpnResource = null;
  }

  private ProjectsEnableXpnResourceRequest(XpnResourceId xpnResource) {
    this.xpnResource = xpnResource;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("xpnResource".equals(fieldName)) {
      return xpnResource;
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

  /** Service resource (a.k.a service project) ID. */
  public XpnResourceId getXpnResource() {
    return xpnResource;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ProjectsEnableXpnResourceRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ProjectsEnableXpnResourceRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ProjectsEnableXpnResourceRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ProjectsEnableXpnResourceRequest();
  }

  public static class Builder {
    private XpnResourceId xpnResource;

    Builder() {}

    public Builder mergeFrom(ProjectsEnableXpnResourceRequest other) {
      if (other == ProjectsEnableXpnResourceRequest.getDefaultInstance()) return this;
      if (other.getXpnResource() != null) {
        this.xpnResource = other.xpnResource;
      }
      return this;
    }

    Builder(ProjectsEnableXpnResourceRequest source) {
      this.xpnResource = source.xpnResource;
    }

    /** Service resource (a.k.a service project) ID. */
    public XpnResourceId getXpnResource() {
      return xpnResource;
    }

    /** Service resource (a.k.a service project) ID. */
    public Builder setXpnResource(XpnResourceId xpnResource) {
      this.xpnResource = xpnResource;
      return this;
    }

    public ProjectsEnableXpnResourceRequest build() {
      return new ProjectsEnableXpnResourceRequest(xpnResource);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setXpnResource(this.xpnResource);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ProjectsEnableXpnResourceRequest{" + "xpnResource=" + xpnResource + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectsEnableXpnResourceRequest) {
      ProjectsEnableXpnResourceRequest that = (ProjectsEnableXpnResourceRequest) o;
      return Objects.equals(this.xpnResource, that.getXpnResource());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(xpnResource);
  }
}
