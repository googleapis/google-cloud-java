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

package com.google.cloud.apihub.v1;

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
public class HostProjectRegistrationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_HOST_PROJECT_REGISTRATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/hostProjectRegistrations/{host_project_registration}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String hostProjectRegistration;

  @Deprecated
  protected HostProjectRegistrationName() {
    project = null;
    location = null;
    hostProjectRegistration = null;
  }

  private HostProjectRegistrationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    hostProjectRegistration = Preconditions.checkNotNull(builder.getHostProjectRegistration());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getHostProjectRegistration() {
    return hostProjectRegistration;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static HostProjectRegistrationName of(
      String project, String location, String hostProjectRegistration) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setHostProjectRegistration(hostProjectRegistration)
        .build();
  }

  public static String format(String project, String location, String hostProjectRegistration) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setHostProjectRegistration(hostProjectRegistration)
        .build()
        .toString();
  }

  public static HostProjectRegistrationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_HOST_PROJECT_REGISTRATION.validatedMatch(
            formattedString,
            "HostProjectRegistrationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("host_project_registration"));
  }

  public static List<HostProjectRegistrationName> parseList(List<String> formattedStrings) {
    List<HostProjectRegistrationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<HostProjectRegistrationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (HostProjectRegistrationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_HOST_PROJECT_REGISTRATION.matches(formattedString);
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
          if (hostProjectRegistration != null) {
            fieldMapBuilder.put("host_project_registration", hostProjectRegistration);
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
    return PROJECT_LOCATION_HOST_PROJECT_REGISTRATION.instantiate(
        "project",
        project,
        "location",
        location,
        "host_project_registration",
        hostProjectRegistration);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      HostProjectRegistrationName that = ((HostProjectRegistrationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.hostProjectRegistration, that.hostProjectRegistration);
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
    h ^= Objects.hashCode(hostProjectRegistration);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/hostProjectRegistrations/{host_project_registration}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String hostProjectRegistration;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getHostProjectRegistration() {
      return hostProjectRegistration;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setHostProjectRegistration(String hostProjectRegistration) {
      this.hostProjectRegistration = hostProjectRegistration;
      return this;
    }

    private Builder(HostProjectRegistrationName hostProjectRegistrationName) {
      this.project = hostProjectRegistrationName.project;
      this.location = hostProjectRegistrationName.location;
      this.hostProjectRegistration = hostProjectRegistrationName.hostProjectRegistration;
    }

    public HostProjectRegistrationName build() {
      return new HostProjectRegistrationName(this);
    }
  }
}
