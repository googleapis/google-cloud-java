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

package com.google.cloud.memorystore.v1;

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
public class AuthTokenName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_INSTANCE_TOKEN_AUTH_USER_AUTH_TOKEN =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/instances/{instance}/tokenAuthUsers/{token_auth_user}/authTokens/{auth_token}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String instance;
  private final String tokenAuthUser;
  private final String authToken;

  @Deprecated
  protected AuthTokenName() {
    project = null;
    location = null;
    instance = null;
    tokenAuthUser = null;
    authToken = null;
  }

  private AuthTokenName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    instance = Preconditions.checkNotNull(builder.getInstance());
    tokenAuthUser = Preconditions.checkNotNull(builder.getTokenAuthUser());
    authToken = Preconditions.checkNotNull(builder.getAuthToken());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getInstance() {
    return instance;
  }

  public String getTokenAuthUser() {
    return tokenAuthUser;
  }

  public String getAuthToken() {
    return authToken;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AuthTokenName of(
      String project, String location, String instance, String tokenAuthUser, String authToken) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInstance(instance)
        .setTokenAuthUser(tokenAuthUser)
        .setAuthToken(authToken)
        .build();
  }

  public static String format(
      String project, String location, String instance, String tokenAuthUser, String authToken) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInstance(instance)
        .setTokenAuthUser(tokenAuthUser)
        .setAuthToken(authToken)
        .build()
        .toString();
  }

  public static @Nullable AuthTokenName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_INSTANCE_TOKEN_AUTH_USER_AUTH_TOKEN.validatedMatch(
            formattedString, "AuthTokenName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("instance"),
        matchMap.get("token_auth_user"),
        matchMap.get("auth_token"));
  }

  public static List<AuthTokenName> parseList(List<String> formattedStrings) {
    List<AuthTokenName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable AuthTokenName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AuthTokenName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_INSTANCE_TOKEN_AUTH_USER_AUTH_TOKEN.matches(formattedString);
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
          if (instance != null) {
            fieldMapBuilder.put("instance", instance);
          }
          if (tokenAuthUser != null) {
            fieldMapBuilder.put("token_auth_user", tokenAuthUser);
          }
          if (authToken != null) {
            fieldMapBuilder.put("auth_token", authToken);
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
    return PROJECT_LOCATION_INSTANCE_TOKEN_AUTH_USER_AUTH_TOKEN.instantiate(
        "project",
        project,
        "location",
        location,
        "instance",
        instance,
        "token_auth_user",
        tokenAuthUser,
        "auth_token",
        authToken);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AuthTokenName that = ((AuthTokenName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.instance, that.instance)
          && Objects.equals(this.tokenAuthUser, that.tokenAuthUser)
          && Objects.equals(this.authToken, that.authToken);
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
    h ^= Objects.hashCode(instance);
    h *= 1000003;
    h ^= Objects.hashCode(tokenAuthUser);
    h *= 1000003;
    h ^= Objects.hashCode(authToken);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/instances/{instance}/tokenAuthUsers/{token_auth_user}/authTokens/{auth_token}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String instance;
    private String tokenAuthUser;
    private String authToken;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getInstance() {
      return instance;
    }

    public String getTokenAuthUser() {
      return tokenAuthUser;
    }

    public String getAuthToken() {
      return authToken;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    public Builder setTokenAuthUser(String tokenAuthUser) {
      this.tokenAuthUser = tokenAuthUser;
      return this;
    }

    public Builder setAuthToken(String authToken) {
      this.authToken = authToken;
      return this;
    }

    private Builder(AuthTokenName authTokenName) {
      this.project = authTokenName.project;
      this.location = authTokenName.location;
      this.instance = authTokenName.instance;
      this.tokenAuthUser = authTokenName.tokenAuthUser;
      this.authToken = authTokenName.authToken;
    }

    public AuthTokenName build() {
      return new AuthTokenName(this);
    }
  }
}
