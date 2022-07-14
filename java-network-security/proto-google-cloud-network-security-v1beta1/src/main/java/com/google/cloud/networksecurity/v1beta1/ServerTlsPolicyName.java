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

package com.google.cloud.networksecurity.v1beta1;

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
public class ServerTlsPolicyName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SERVER_TLS_POLICY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/serverTlsPolicies/{server_tls_policy}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String serverTlsPolicy;

  @Deprecated
  protected ServerTlsPolicyName() {
    project = null;
    location = null;
    serverTlsPolicy = null;
  }

  private ServerTlsPolicyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    serverTlsPolicy = Preconditions.checkNotNull(builder.getServerTlsPolicy());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getServerTlsPolicy() {
    return serverTlsPolicy;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ServerTlsPolicyName of(String project, String location, String serverTlsPolicy) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setServerTlsPolicy(serverTlsPolicy)
        .build();
  }

  public static String format(String project, String location, String serverTlsPolicy) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setServerTlsPolicy(serverTlsPolicy)
        .build()
        .toString();
  }

  public static ServerTlsPolicyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SERVER_TLS_POLICY.validatedMatch(
            formattedString, "ServerTlsPolicyName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("server_tls_policy"));
  }

  public static List<ServerTlsPolicyName> parseList(List<String> formattedStrings) {
    List<ServerTlsPolicyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ServerTlsPolicyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ServerTlsPolicyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SERVER_TLS_POLICY.matches(formattedString);
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
          if (serverTlsPolicy != null) {
            fieldMapBuilder.put("server_tls_policy", serverTlsPolicy);
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
    return PROJECT_LOCATION_SERVER_TLS_POLICY.instantiate(
        "project", project, "location", location, "server_tls_policy", serverTlsPolicy);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ServerTlsPolicyName that = ((ServerTlsPolicyName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.serverTlsPolicy, that.serverTlsPolicy);
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
    h ^= Objects.hashCode(serverTlsPolicy);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/serverTlsPolicies/{server_tls_policy}. */
  public static class Builder {
    private String project;
    private String location;
    private String serverTlsPolicy;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getServerTlsPolicy() {
      return serverTlsPolicy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setServerTlsPolicy(String serverTlsPolicy) {
      this.serverTlsPolicy = serverTlsPolicy;
      return this;
    }

    private Builder(ServerTlsPolicyName serverTlsPolicyName) {
      this.project = serverTlsPolicyName.project;
      this.location = serverTlsPolicyName.location;
      this.serverTlsPolicy = serverTlsPolicyName.serverTlsPolicy;
    }

    public ServerTlsPolicyName build() {
      return new ServerTlsPolicyName(this);
    }
  }
}
