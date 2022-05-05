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

package com.google.cloud.datastream.v1;

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
public class StreamName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_STREAM =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/streams/{stream}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String stream;

  @Deprecated
  protected StreamName() {
    project = null;
    location = null;
    stream = null;
  }

  private StreamName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    stream = Preconditions.checkNotNull(builder.getStream());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getStream() {
    return stream;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static StreamName of(String project, String location, String stream) {
    return newBuilder().setProject(project).setLocation(location).setStream(stream).build();
  }

  public static String format(String project, String location, String stream) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setStream(stream)
        .build()
        .toString();
  }

  public static StreamName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_STREAM.validatedMatch(
            formattedString, "StreamName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("stream"));
  }

  public static List<StreamName> parseList(List<String> formattedStrings) {
    List<StreamName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<StreamName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (StreamName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_STREAM.matches(formattedString);
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
          if (stream != null) {
            fieldMapBuilder.put("stream", stream);
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
    return PROJECT_LOCATION_STREAM.instantiate(
        "project", project, "location", location, "stream", stream);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      StreamName that = ((StreamName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.stream, that.stream);
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
    h ^= Objects.hashCode(stream);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/streams/{stream}. */
  public static class Builder {
    private String project;
    private String location;
    private String stream;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getStream() {
      return stream;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setStream(String stream) {
      this.stream = stream;
      return this;
    }

    private Builder(StreamName streamName) {
      this.project = streamName.project;
      this.location = streamName.location;
      this.stream = streamName.stream;
    }

    public StreamName build() {
      return new StreamName(this);
    }
  }
}
