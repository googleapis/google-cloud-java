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

package com.google.cloud.oracledatabase.v1;

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
public class GoldengateConnectionAssignmentName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_GOLDENGATE_CONNECTION_ASSIGNMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/goldengateConnectionAssignments/{goldengate_connection_assignment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String goldengateConnectionAssignment;

  @Deprecated
  protected GoldengateConnectionAssignmentName() {
    project = null;
    location = null;
    goldengateConnectionAssignment = null;
  }

  private GoldengateConnectionAssignmentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    goldengateConnectionAssignment =
        Preconditions.checkNotNull(builder.getGoldengateConnectionAssignment());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getGoldengateConnectionAssignment() {
    return goldengateConnectionAssignment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GoldengateConnectionAssignmentName of(
      String project, String location, String goldengateConnectionAssignment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGoldengateConnectionAssignment(goldengateConnectionAssignment)
        .build();
  }

  public static String format(
      String project, String location, String goldengateConnectionAssignment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGoldengateConnectionAssignment(goldengateConnectionAssignment)
        .build()
        .toString();
  }

  public static @Nullable GoldengateConnectionAssignmentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_GOLDENGATE_CONNECTION_ASSIGNMENT.validatedMatch(
            formattedString,
            "GoldengateConnectionAssignmentName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("goldengate_connection_assignment"));
  }

  public static List<GoldengateConnectionAssignmentName> parseList(List<String> formattedStrings) {
    List<GoldengateConnectionAssignmentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(
      List<@Nullable GoldengateConnectionAssignmentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GoldengateConnectionAssignmentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_GOLDENGATE_CONNECTION_ASSIGNMENT.matches(formattedString);
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
          if (goldengateConnectionAssignment != null) {
            fieldMapBuilder.put("goldengate_connection_assignment", goldengateConnectionAssignment);
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
    return PROJECT_LOCATION_GOLDENGATE_CONNECTION_ASSIGNMENT.instantiate(
        "project",
        project,
        "location",
        location,
        "goldengate_connection_assignment",
        goldengateConnectionAssignment);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      GoldengateConnectionAssignmentName that = ((GoldengateConnectionAssignmentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(
              this.goldengateConnectionAssignment, that.goldengateConnectionAssignment);
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
    h ^= Objects.hashCode(goldengateConnectionAssignment);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/goldengateConnectionAssignments/{goldengate_connection_assignment}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String goldengateConnectionAssignment;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getGoldengateConnectionAssignment() {
      return goldengateConnectionAssignment;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setGoldengateConnectionAssignment(String goldengateConnectionAssignment) {
      this.goldengateConnectionAssignment = goldengateConnectionAssignment;
      return this;
    }

    private Builder(GoldengateConnectionAssignmentName goldengateConnectionAssignmentName) {
      this.project = goldengateConnectionAssignmentName.project;
      this.location = goldengateConnectionAssignmentName.location;
      this.goldengateConnectionAssignment =
          goldengateConnectionAssignmentName.goldengateConnectionAssignment;
    }

    public GoldengateConnectionAssignmentName build() {
      return new GoldengateConnectionAssignmentName(this);
    }
  }
}
