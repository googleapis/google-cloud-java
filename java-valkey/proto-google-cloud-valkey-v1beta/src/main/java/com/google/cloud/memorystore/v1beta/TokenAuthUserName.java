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

package com.google.cloud.memorystore.v1beta;

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
public class TokenAuthUserName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_INSTANCE_TOKEN_AUTH_USER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/instances/{instance}/tokenAuthUsers/{token_auth_user}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String instance;
  private final String tokenAuthUser;

  @Deprecated
  protected TokenAuthUserName() {
    project = null;
    location = null;
    instance = null;
    tokenAuthUser = null;
  }

  private TokenAuthUserName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    instance = Preconditions.checkNotNull(builder.getInstance());
    tokenAuthUser = Preconditions.checkNotNull(builder.getTokenAuthUser());
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

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TokenAuthUserName of(
      String project, String location, String instance, String tokenAuthUser) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInstance(instance)
        .setTokenAuthUser(tokenAuthUser)
        .build();
  }

  public static String format(
      String project, String location, String instance, String tokenAuthUser) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInstance(instance)
        .setTokenAuthUser(tokenAuthUser)
        .build()
        .toString();
  }

  public static @Nullable TokenAuthUserName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_INSTANCE_TOKEN_AUTH_USER.validatedMatch(
            formattedString, "TokenAuthUserName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("instance"),
        matchMap.get("token_auth_user"));
  }

  public static List<TokenAuthUserName> parseList(List<String> formattedStrings) {
    List<TokenAuthUserName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable TokenAuthUserName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TokenAuthUserName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_INSTANCE_TOKEN_AUTH_USER.matches(formattedString);
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
    return PROJECT_LOCATION_INSTANCE_TOKEN_AUTH_USER.instantiate(
        "project",
        project,
        "location",
        location,
        "instance",
        instance,
        "token_auth_user",
        tokenAuthUser);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TokenAuthUserName that = ((TokenAuthUserName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.instance, that.instance)
          && Objects.equals(this.tokenAuthUser, that.tokenAuthUser);
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
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/instances/{instance}/tokenAuthUsers/{token_auth_user}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String instance;
    private String tokenAuthUser;

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

    private Builder(TokenAuthUserName tokenAuthUserName) {
      this.project = tokenAuthUserName.project;
      this.location = tokenAuthUserName.location;
      this.instance = tokenAuthUserName.instance;
      this.tokenAuthUser = tokenAuthUserName.tokenAuthUser;
    }

    public TokenAuthUserName build() {
      return new TokenAuthUserName(this);
    }
  }
}
