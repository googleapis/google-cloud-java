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

package com.google.cloud.bigquery.reservation.v1;

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
public class AssignmentName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_RESERVATION_ASSIGNMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/reservations/{reservation}/assignments/{assignment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String reservation;
  private final String assignment;

  @Deprecated
  protected AssignmentName() {
    project = null;
    location = null;
    reservation = null;
    assignment = null;
  }

  private AssignmentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    reservation = Preconditions.checkNotNull(builder.getReservation());
    assignment = Preconditions.checkNotNull(builder.getAssignment());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getReservation() {
    return reservation;
  }

  public String getAssignment() {
    return assignment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AssignmentName of(
      String project, String location, String reservation, String assignment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReservation(reservation)
        .setAssignment(assignment)
        .build();
  }

  public static String format(
      String project, String location, String reservation, String assignment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReservation(reservation)
        .setAssignment(assignment)
        .build()
        .toString();
  }

  public static AssignmentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_RESERVATION_ASSIGNMENT.validatedMatch(
            formattedString, "AssignmentName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("reservation"),
        matchMap.get("assignment"));
  }

  public static List<AssignmentName> parseList(List<String> formattedStrings) {
    List<AssignmentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AssignmentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AssignmentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_RESERVATION_ASSIGNMENT.matches(formattedString);
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
          if (reservation != null) {
            fieldMapBuilder.put("reservation", reservation);
          }
          if (assignment != null) {
            fieldMapBuilder.put("assignment", assignment);
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
    return PROJECT_LOCATION_RESERVATION_ASSIGNMENT.instantiate(
        "project",
        project,
        "location",
        location,
        "reservation",
        reservation,
        "assignment",
        assignment);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      AssignmentName that = ((AssignmentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.reservation, that.reservation)
          && Objects.equals(this.assignment, that.assignment);
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
    h ^= Objects.hashCode(reservation);
    h *= 1000003;
    h ^= Objects.hashCode(assignment);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/reservations/{reservation}/assignments/{assignment}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String reservation;
    private String assignment;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getReservation() {
      return reservation;
    }

    public String getAssignment() {
      return assignment;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setReservation(String reservation) {
      this.reservation = reservation;
      return this;
    }

    public Builder setAssignment(String assignment) {
      this.assignment = assignment;
      return this;
    }

    private Builder(AssignmentName assignmentName) {
      this.project = assignmentName.project;
      this.location = assignmentName.location;
      this.reservation = assignmentName.reservation;
      this.assignment = assignmentName.assignment;
    }

    public AssignmentName build() {
      return new AssignmentName(this);
    }
  }
}
