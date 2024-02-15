/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.vmwareengine.v1;

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
public class LoggingServerName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PRIVATE_CLOUD_LOGGING_SERVER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/privateClouds/{private_cloud}/loggingServers/{logging_server}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String privateCloud;
  private final String loggingServer;

  @Deprecated
  protected LoggingServerName() {
    project = null;
    location = null;
    privateCloud = null;
    loggingServer = null;
  }

  private LoggingServerName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    privateCloud = Preconditions.checkNotNull(builder.getPrivateCloud());
    loggingServer = Preconditions.checkNotNull(builder.getLoggingServer());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getPrivateCloud() {
    return privateCloud;
  }

  public String getLoggingServer() {
    return loggingServer;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LoggingServerName of(
      String project, String location, String privateCloud, String loggingServer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPrivateCloud(privateCloud)
        .setLoggingServer(loggingServer)
        .build();
  }

  public static String format(
      String project, String location, String privateCloud, String loggingServer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPrivateCloud(privateCloud)
        .setLoggingServer(loggingServer)
        .build()
        .toString();
  }

  public static LoggingServerName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PRIVATE_CLOUD_LOGGING_SERVER.validatedMatch(
            formattedString, "LoggingServerName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("private_cloud"),
        matchMap.get("logging_server"));
  }

  public static List<LoggingServerName> parseList(List<String> formattedStrings) {
    List<LoggingServerName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LoggingServerName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LoggingServerName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PRIVATE_CLOUD_LOGGING_SERVER.matches(formattedString);
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
          if (privateCloud != null) {
            fieldMapBuilder.put("private_cloud", privateCloud);
          }
          if (loggingServer != null) {
            fieldMapBuilder.put("logging_server", loggingServer);
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
    return PROJECT_LOCATION_PRIVATE_CLOUD_LOGGING_SERVER.instantiate(
        "project",
        project,
        "location",
        location,
        "private_cloud",
        privateCloud,
        "logging_server",
        loggingServer);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      LoggingServerName that = ((LoggingServerName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.privateCloud, that.privateCloud)
          && Objects.equals(this.loggingServer, that.loggingServer);
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
    h ^= Objects.hashCode(privateCloud);
    h *= 1000003;
    h ^= Objects.hashCode(loggingServer);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/privateClouds/{private_cloud}/loggingServers/{logging_server}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String privateCloud;
    private String loggingServer;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getPrivateCloud() {
      return privateCloud;
    }

    public String getLoggingServer() {
      return loggingServer;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setPrivateCloud(String privateCloud) {
      this.privateCloud = privateCloud;
      return this;
    }

    public Builder setLoggingServer(String loggingServer) {
      this.loggingServer = loggingServer;
      return this;
    }

    private Builder(LoggingServerName loggingServerName) {
      this.project = loggingServerName.project;
      this.location = loggingServerName.location;
      this.privateCloud = loggingServerName.privateCloud;
      this.loggingServer = loggingServerName.loggingServer;
    }

    public LoggingServerName build() {
      return new LoggingServerName(this);
    }
  }
}
