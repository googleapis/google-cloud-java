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

package com.google.cloud.beyondcorp.appconnections.v1;

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
public class AppConnectionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_APP_CONNECTION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/appConnections/{app_connection}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String appConnection;

  @Deprecated
  protected AppConnectionName() {
    project = null;
    location = null;
    appConnection = null;
  }

  private AppConnectionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    appConnection = Preconditions.checkNotNull(builder.getAppConnection());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAppConnection() {
    return appConnection;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AppConnectionName of(String project, String location, String appConnection) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAppConnection(appConnection)
        .build();
  }

  public static String format(String project, String location, String appConnection) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAppConnection(appConnection)
        .build()
        .toString();
  }

  public static AppConnectionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_APP_CONNECTION.validatedMatch(
            formattedString, "AppConnectionName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("app_connection"));
  }

  public static List<AppConnectionName> parseList(List<String> formattedStrings) {
    List<AppConnectionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AppConnectionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AppConnectionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_APP_CONNECTION.matches(formattedString);
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
          if (appConnection != null) {
            fieldMapBuilder.put("app_connection", appConnection);
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
    return PROJECT_LOCATION_APP_CONNECTION.instantiate(
        "project", project, "location", location, "app_connection", appConnection);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      AppConnectionName that = ((AppConnectionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.appConnection, that.appConnection);
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
    h ^= Objects.hashCode(appConnection);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/appConnections/{app_connection}. */
  public static class Builder {
    private String project;
    private String location;
    private String appConnection;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAppConnection() {
      return appConnection;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAppConnection(String appConnection) {
      this.appConnection = appConnection;
      return this;
    }

    private Builder(AppConnectionName appConnectionName) {
      this.project = appConnectionName.project;
      this.location = appConnectionName.location;
      this.appConnection = appConnectionName.appConnection;
    }

    public AppConnectionName build() {
      return new AppConnectionName(this);
    }
  }
}
