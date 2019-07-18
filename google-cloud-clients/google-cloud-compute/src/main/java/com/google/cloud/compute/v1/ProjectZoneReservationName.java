/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.api.resourcenames.ResourceNameFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

@Generated("by GAPIC")
@BetaApi
public final class ProjectZoneReservationName implements ResourceName {
  private final String project;
  private final String reservation;
  private final String zone;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("{project}/zones/{zone}/reservations/{reservation}");

  public static final String SERVICE_ADDRESS = "https://www.googleapis.com/compute/v1/projects/";

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectZoneReservationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    reservation = Preconditions.checkNotNull(builder.getReservation());
    zone = Preconditions.checkNotNull(builder.getZone());
  }

  public static ProjectZoneReservationName of(String project, String reservation, String zone) {
    return newBuilder().setProject(project).setReservation(reservation).setZone(zone).build();
  }

  public static String format(String project, String reservation, String zone) {
    return of(project, reservation, zone).toString();
  }

  public String getProject() {
    return project;
  }

  public String getReservation() {
    return reservation;
  }

  public String getZone() {
    return zone;
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("reservation", reservation);
          fieldMapBuilder.put("zone", zone);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  public static ResourceNameFactory<ProjectZoneReservationName> newFactory() {
    return new ResourceNameFactory<ProjectZoneReservationName>() {
      public ProjectZoneReservationName parse(String formattedString) {
        return ProjectZoneReservationName.parse(formattedString);
      }
    };
  }

  public static ProjectZoneReservationName parse(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            resourcePath, "ProjectZoneReservationName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("reservation"), matchMap.get("zone"));
  }

  public static boolean isParsableFrom(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    return PATH_TEMPLATE.matches(resourcePath);
  }

  public static class Builder {
    private String project;
    private String reservation;
    private String zone;

    public String getProject() {
      return project;
    }

    public String getReservation() {
      return reservation;
    }

    public String getZone() {
      return zone;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setReservation(String reservation) {
      this.reservation = reservation;
      return this;
    }

    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    private Builder() {}

    public Builder(ProjectZoneReservationName projectZoneReservationName) {
      project = projectZoneReservationName.project;
      reservation = projectZoneReservationName.reservation;
      zone = projectZoneReservationName.zone;
    }

    public ProjectZoneReservationName build() {
      return new ProjectZoneReservationName(this);
    }
  }

  @Override
  public String toString() {
    return SERVICE_ADDRESS
        + PATH_TEMPLATE.instantiate(
            "project", project,
            "reservation", reservation,
            "zone", zone);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectZoneReservationName) {
      ProjectZoneReservationName that = (ProjectZoneReservationName) o;
      return Objects.equals(this.project, that.getProject())
          && Objects.equals(this.reservation, that.getReservation())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, reservation, zone);
  }
}
