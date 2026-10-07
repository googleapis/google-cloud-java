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

package com.google.cloud.chronicle.v1;

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
public class LogTypeSchemaName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_INSTANCE_FEED_SOURCE_TYPE_LOG_TYPE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/instances/{instance}/feedSourceTypeSchemas/{feed_source_type}/logTypeSchemas/{log_type}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String instance;
  private final String feedSourceType;
  private final String logType;

  @Deprecated
  protected LogTypeSchemaName() {
    project = null;
    location = null;
    instance = null;
    feedSourceType = null;
    logType = null;
  }

  private LogTypeSchemaName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    instance = Preconditions.checkNotNull(builder.getInstance());
    feedSourceType = Preconditions.checkNotNull(builder.getFeedSourceType());
    logType = Preconditions.checkNotNull(builder.getLogType());
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

  public String getFeedSourceType() {
    return feedSourceType;
  }

  public String getLogType() {
    return logType;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LogTypeSchemaName of(
      String project, String location, String instance, String feedSourceType, String logType) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInstance(instance)
        .setFeedSourceType(feedSourceType)
        .setLogType(logType)
        .build();
  }

  public static String format(
      String project, String location, String instance, String feedSourceType, String logType) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInstance(instance)
        .setFeedSourceType(feedSourceType)
        .setLogType(logType)
        .build()
        .toString();
  }

  public static @Nullable LogTypeSchemaName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_INSTANCE_FEED_SOURCE_TYPE_LOG_TYPE.validatedMatch(
            formattedString, "LogTypeSchemaName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("instance"),
        matchMap.get("feed_source_type"),
        matchMap.get("log_type"));
  }

  public static List<LogTypeSchemaName> parseList(List<String> formattedStrings) {
    List<LogTypeSchemaName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable LogTypeSchemaName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LogTypeSchemaName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_INSTANCE_FEED_SOURCE_TYPE_LOG_TYPE.matches(formattedString);
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
          if (feedSourceType != null) {
            fieldMapBuilder.put("feed_source_type", feedSourceType);
          }
          if (logType != null) {
            fieldMapBuilder.put("log_type", logType);
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
    return PROJECT_LOCATION_INSTANCE_FEED_SOURCE_TYPE_LOG_TYPE.instantiate(
        "project",
        project,
        "location",
        location,
        "instance",
        instance,
        "feed_source_type",
        feedSourceType,
        "log_type",
        logType);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      LogTypeSchemaName that = ((LogTypeSchemaName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.instance, that.instance)
          && Objects.equals(this.feedSourceType, that.feedSourceType)
          && Objects.equals(this.logType, that.logType);
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
    h ^= Objects.hashCode(feedSourceType);
    h *= 1000003;
    h ^= Objects.hashCode(logType);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/instances/{instance}/feedSourceTypeSchemas/{feed_source_type}/logTypeSchemas/{log_type}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String instance;
    private String feedSourceType;
    private String logType;

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

    public String getFeedSourceType() {
      return feedSourceType;
    }

    public String getLogType() {
      return logType;
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

    public Builder setFeedSourceType(String feedSourceType) {
      this.feedSourceType = feedSourceType;
      return this;
    }

    public Builder setLogType(String logType) {
      this.logType = logType;
      return this;
    }

    private Builder(LogTypeSchemaName logTypeSchemaName) {
      this.project = logTypeSchemaName.project;
      this.location = logTypeSchemaName.location;
      this.instance = logTypeSchemaName.instance;
      this.feedSourceType = logTypeSchemaName.feedSourceType;
      this.logType = logTypeSchemaName.logType;
    }

    public LogTypeSchemaName build() {
      return new LogTypeSchemaName(this);
    }
  }
}
