/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.agentidentity.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class AuthorizationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AUTH_PROVIDER_AUTHORIZATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/authProviders/{auth_provider}/authorizations/{authorization}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String authProvider;
  private final String authorization;

  @Deprecated
  protected AuthorizationName() {
    project = null;
    location = null;
    authProvider = null;
    authorization = null;
  }

  private AuthorizationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    authProvider = Preconditions.checkNotNull(builder.getAuthProvider());
    authorization = Preconditions.checkNotNull(builder.getAuthorization());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAuthProvider() {
    return authProvider;
  }

  public String getAuthorization() {
    return authorization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AuthorizationName of(
      String project, String location, String authProvider, String authorization) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAuthProvider(authProvider)
        .setAuthorization(authorization)
        .build();
  }

  public static String format(
      String project, String location, String authProvider, String authorization) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAuthProvider(authProvider)
        .setAuthorization(authorization)
        .build()
        .toString();
  }

  public static @Nullable AuthorizationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_AUTH_PROVIDER_AUTHORIZATION.validatedMatch(
            formattedString, "AuthorizationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("auth_provider"),
        matchMap.get("authorization"));
  }

  public static List<AuthorizationName> parseList(List<String> formattedStrings) {
    List<AuthorizationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable AuthorizationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AuthorizationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AUTH_PROVIDER_AUTHORIZATION.matches(formattedString);
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
          if (authProvider != null) {
            fieldMapBuilder.put("auth_provider", authProvider);
          }
          if (authorization != null) {
            fieldMapBuilder.put("authorization", authorization);
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
    return PROJECT_LOCATION_AUTH_PROVIDER_AUTHORIZATION.instantiate(
        "project",
        project,
        "location",
        location,
        "auth_provider",
        authProvider,
        "authorization",
        authorization);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AuthorizationName that = ((AuthorizationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.authProvider, that.authProvider)
          && Objects.equals(this.authorization, that.authorization);
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
    h ^= Objects.hashCode(authProvider);
    h *= 1000003;
    h ^= Objects.hashCode(authorization);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/authProviders/{auth_provider}/authorizations/{authorization}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String authProvider;
    private String authorization;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAuthProvider() {
      return authProvider;
    }

    public String getAuthorization() {
      return authorization;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAuthProvider(String authProvider) {
      this.authProvider = authProvider;
      return this;
    }

    public Builder setAuthorization(String authorization) {
      this.authorization = authorization;
      return this;
    }

    private Builder(AuthorizationName authorizationName) {
      this.project = authorizationName.project;
      this.location = authorizationName.location;
      this.authProvider = authorizationName.authProvider;
      this.authorization = authorizationName.authorization;
    }

    public AuthorizationName build() {
      return new AuthorizationName(this);
    }
  }
}
