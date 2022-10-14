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

package com.google.cloud.edgecontainer.v1;

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
public class MachineName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_MACHINE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/machines/{machine}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String machine;

  @Deprecated
  protected MachineName() {
    project = null;
    location = null;
    machine = null;
  }

  private MachineName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    machine = Preconditions.checkNotNull(builder.getMachine());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getMachine() {
    return machine;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MachineName of(String project, String location, String machine) {
    return newBuilder().setProject(project).setLocation(location).setMachine(machine).build();
  }

  public static String format(String project, String location, String machine) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMachine(machine)
        .build()
        .toString();
  }

  public static MachineName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_MACHINE.validatedMatch(
            formattedString, "MachineName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("machine"));
  }

  public static List<MachineName> parseList(List<String> formattedStrings) {
    List<MachineName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MachineName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MachineName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_MACHINE.matches(formattedString);
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
          if (machine != null) {
            fieldMapBuilder.put("machine", machine);
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
    return PROJECT_LOCATION_MACHINE.instantiate(
        "project", project, "location", location, "machine", machine);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      MachineName that = ((MachineName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.machine, that.machine);
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
    h ^= Objects.hashCode(machine);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/machines/{machine}. */
  public static class Builder {
    private String project;
    private String location;
    private String machine;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getMachine() {
      return machine;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setMachine(String machine) {
      this.machine = machine;
      return this;
    }

    private Builder(MachineName machineName) {
      this.project = machineName.project;
      this.location = machineName.location;
      this.machine = machineName.machine;
    }

    public MachineName build() {
      return new MachineName(this);
    }
  }
}
