/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.locationfinder.v1;

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
public class CloudLocationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CLOUD_LOCATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/cloudLocations/{cloud_location}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String cloudLocation;

  @Deprecated
  protected CloudLocationName() {
    project = null;
    location = null;
    cloudLocation = null;
  }

  private CloudLocationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    cloudLocation = Preconditions.checkNotNull(builder.getCloudLocation());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getCloudLocation() {
    return cloudLocation;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CloudLocationName of(String project, String location, String cloudLocation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCloudLocation(cloudLocation)
        .build();
  }

  public static String format(String project, String location, String cloudLocation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCloudLocation(cloudLocation)
        .build()
        .toString();
  }

  public static CloudLocationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CLOUD_LOCATION.validatedMatch(
            formattedString, "CloudLocationName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("cloud_location"));
  }

  public static List<CloudLocationName> parseList(List<String> formattedStrings) {
    List<CloudLocationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CloudLocationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CloudLocationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CLOUD_LOCATION.matches(formattedString);
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
          if (cloudLocation != null) {
            fieldMapBuilder.put("cloud_location", cloudLocation);
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
    return PROJECT_LOCATION_CLOUD_LOCATION.instantiate(
        "project", project, "location", location, "cloud_location", cloudLocation);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CloudLocationName that = ((CloudLocationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.cloudLocation, that.cloudLocation);
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
    h ^= Objects.hashCode(cloudLocation);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/cloudLocations/{cloud_location}. */
  public static class Builder {
    private String project;
    private String location;
    private String cloudLocation;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCloudLocation() {
      return cloudLocation;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCloudLocation(String cloudLocation) {
      this.cloudLocation = cloudLocation;
      return this;
    }

    private Builder(CloudLocationName cloudLocationName) {
      this.project = cloudLocationName.project;
      this.location = cloudLocationName.location;
      this.cloudLocation = cloudLocationName.cloudLocation;
    }

    public CloudLocationName build() {
      return new CloudLocationName(this);
    }
  }
}
