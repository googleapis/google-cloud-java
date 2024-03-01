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

package com.google.cloud.migrationcenter.v1;

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
public class ErrorFrameName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SOURCE_ERROR_FRAME =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/sources/{source}/errorFrames/{error_frame}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String source;
  private final String errorFrame;

  @Deprecated
  protected ErrorFrameName() {
    project = null;
    location = null;
    source = null;
    errorFrame = null;
  }

  private ErrorFrameName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    source = Preconditions.checkNotNull(builder.getSource());
    errorFrame = Preconditions.checkNotNull(builder.getErrorFrame());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSource() {
    return source;
  }

  public String getErrorFrame() {
    return errorFrame;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ErrorFrameName of(
      String project, String location, String source, String errorFrame) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSource(source)
        .setErrorFrame(errorFrame)
        .build();
  }

  public static String format(String project, String location, String source, String errorFrame) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSource(source)
        .setErrorFrame(errorFrame)
        .build()
        .toString();
  }

  public static ErrorFrameName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SOURCE_ERROR_FRAME.validatedMatch(
            formattedString, "ErrorFrameName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("source"),
        matchMap.get("error_frame"));
  }

  public static List<ErrorFrameName> parseList(List<String> formattedStrings) {
    List<ErrorFrameName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ErrorFrameName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ErrorFrameName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SOURCE_ERROR_FRAME.matches(formattedString);
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
          if (source != null) {
            fieldMapBuilder.put("source", source);
          }
          if (errorFrame != null) {
            fieldMapBuilder.put("error_frame", errorFrame);
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
    return PROJECT_LOCATION_SOURCE_ERROR_FRAME.instantiate(
        "project", project, "location", location, "source", source, "error_frame", errorFrame);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ErrorFrameName that = ((ErrorFrameName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.source, that.source)
          && Objects.equals(this.errorFrame, that.errorFrame);
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
    h ^= Objects.hashCode(source);
    h *= 1000003;
    h ^= Objects.hashCode(errorFrame);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/sources/{source}/errorFrames/{error_frame}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String source;
    private String errorFrame;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSource() {
      return source;
    }

    public String getErrorFrame() {
      return errorFrame;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSource(String source) {
      this.source = source;
      return this;
    }

    public Builder setErrorFrame(String errorFrame) {
      this.errorFrame = errorFrame;
      return this;
    }

    private Builder(ErrorFrameName errorFrameName) {
      this.project = errorFrameName.project;
      this.location = errorFrameName.location;
      this.source = errorFrameName.source;
      this.errorFrame = errorFrameName.errorFrame;
    }

    public ErrorFrameName build() {
      return new ErrorFrameName(this);
    }
  }
}
