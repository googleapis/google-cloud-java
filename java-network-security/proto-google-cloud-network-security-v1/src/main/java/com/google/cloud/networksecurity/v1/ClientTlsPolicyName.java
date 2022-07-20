/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.networksecurity.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class ClientTlsPolicyName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CLIENT_TLS_POLICY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/clientTlsPolicies/{client_tls_policy}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String clientTlsPolicy;

  @Deprecated
  protected ClientTlsPolicyName() {
    project = null;
    location = null;
    clientTlsPolicy = null;
  }

  private ClientTlsPolicyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    clientTlsPolicy = Preconditions.checkNotNull(builder.getClientTlsPolicy());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getClientTlsPolicy() {
    return clientTlsPolicy;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ClientTlsPolicyName of(String project, String location, String clientTlsPolicy) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setClientTlsPolicy(clientTlsPolicy)
        .build();
  }

  public static String format(String project, String location, String clientTlsPolicy) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setClientTlsPolicy(clientTlsPolicy)
        .build()
        .toString();
  }

  public static ClientTlsPolicyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CLIENT_TLS_POLICY.validatedMatch(
            formattedString, "ClientTlsPolicyName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("client_tls_policy"));
  }

  public static List<ClientTlsPolicyName> parseList(List<String> formattedStrings) {
    List<ClientTlsPolicyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ClientTlsPolicyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ClientTlsPolicyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CLIENT_TLS_POLICY.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (project != null) {
            fieldMapBuilder.put("project", project);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (clientTlsPolicy != null) {
            fieldMapBuilder.put("client_tls_policy", clientTlsPolicy);
          }
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  @Override
  public String toString() {
    return PROJECT_LOCATION_CLIENT_TLS_POLICY.instantiate(
        "project", project, "location", location, "client_tls_policy", clientTlsPolicy);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ClientTlsPolicyName that = ((ClientTlsPolicyName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.clientTlsPolicy, that.clientTlsPolicy);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(clientTlsPolicy);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/clientTlsPolicies/{client_tls_policy}. */
  public static class Builder {
    private String project;
    private String location;
    private String clientTlsPolicy;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getClientTlsPolicy() {
      return clientTlsPolicy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setClientTlsPolicy(String clientTlsPolicy) {
      this.clientTlsPolicy = clientTlsPolicy;
      return this;
    }

    private Builder(ClientTlsPolicyName clientTlsPolicyName) {
      this.project = clientTlsPolicyName.project;
      this.location = clientTlsPolicyName.location;
      this.clientTlsPolicy = clientTlsPolicyName.clientTlsPolicy;
    }

    public ClientTlsPolicyName build() {
      return new ClientTlsPolicyName(this);
    }
  }
}
