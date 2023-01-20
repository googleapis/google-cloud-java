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
public class PrivateCloudName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PRIVATE_CLOUD =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/privateClouds/{private_cloud}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String privateCloud;

  @Deprecated
  protected PrivateCloudName() {
    project = null;
    location = null;
    privateCloud = null;
  }

  private PrivateCloudName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    privateCloud = Preconditions.checkNotNull(builder.getPrivateCloud());
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

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PrivateCloudName of(String project, String location, String privateCloud) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPrivateCloud(privateCloud)
        .build();
  }

  public static String format(String project, String location, String privateCloud) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPrivateCloud(privateCloud)
        .build()
        .toString();
  }

  public static PrivateCloudName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PRIVATE_CLOUD.validatedMatch(
            formattedString, "PrivateCloudName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("private_cloud"));
  }

  public static List<PrivateCloudName> parseList(List<String> formattedStrings) {
    List<PrivateCloudName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PrivateCloudName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PrivateCloudName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PRIVATE_CLOUD.matches(formattedString);
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
    return PROJECT_LOCATION_PRIVATE_CLOUD.instantiate(
        "project", project, "location", location, "private_cloud", privateCloud);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      PrivateCloudName that = ((PrivateCloudName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.privateCloud, that.privateCloud);
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
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/privateClouds/{private_cloud}. */
  public static class Builder {
    private String project;
    private String location;
    private String privateCloud;

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

    private Builder(PrivateCloudName privateCloudName) {
      this.project = privateCloudName.project;
      this.location = privateCloudName.location;
      this.privateCloud = privateCloudName.privateCloud;
    }

    public PrivateCloudName build() {
      return new PrivateCloudName(this);
    }
  }
}
