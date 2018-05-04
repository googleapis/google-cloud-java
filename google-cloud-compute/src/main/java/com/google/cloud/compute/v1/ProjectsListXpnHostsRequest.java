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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class ProjectsListXpnHostsRequest implements ApiMessage {
  private final String organization;

  private ProjectsListXpnHostsRequest() {
    this.organization = null;
  }

  private ProjectsListXpnHostsRequest(String organization) {
    this.organization = organization;
  }

  @Override
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("organization") && organization != null) {
      fieldMap.put("organization", Collections.singletonList(String.valueOf(organization)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("organization")) {
      return String.valueOf(organization);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ProjectsListXpnHostsRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ProjectsListXpnHostsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ProjectsListXpnHostsRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ProjectsListXpnHostsRequest();
  }

  public static class Builder {
    private String organization;

    Builder() {}

    public Builder mergeFrom(ProjectsListXpnHostsRequest other) {
      if (other == ProjectsListXpnHostsRequest.getDefaultInstance()) return this;
      if (other.getOrganization() != null) {
        this.organization = other.organization;
      }
      return this;
    }

    Builder(ProjectsListXpnHostsRequest source) {
      this.organization = source.organization;
    }

    public String getOrganization() {
      return organization;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public ProjectsListXpnHostsRequest build() {
      return new ProjectsListXpnHostsRequest(organization);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setOrganization(this.organization);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ProjectsListXpnHostsRequest{" + "organization=" + organization + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectsListXpnHostsRequest) {
      ProjectsListXpnHostsRequest that = (ProjectsListXpnHostsRequest) o;
      return Objects.equals(this.organization, that.getOrganization());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(organization);
  }
}
