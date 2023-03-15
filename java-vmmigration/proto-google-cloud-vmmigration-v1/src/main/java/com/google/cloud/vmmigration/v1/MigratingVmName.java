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

package com.google.cloud.vmmigration.v1;

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
public class MigratingVmName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SOURCE_MIGRATING_VM =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/sources/{source}/migratingVms/{migrating_vm}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String source;
  private final String migratingVm;

  @Deprecated
  protected MigratingVmName() {
    project = null;
    location = null;
    source = null;
    migratingVm = null;
  }

  private MigratingVmName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    source = Preconditions.checkNotNull(builder.getSource());
    migratingVm = Preconditions.checkNotNull(builder.getMigratingVm());
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

  public String getMigratingVm() {
    return migratingVm;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MigratingVmName of(
      String project, String location, String source, String migratingVm) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSource(source)
        .setMigratingVm(migratingVm)
        .build();
  }

  public static String format(String project, String location, String source, String migratingVm) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSource(source)
        .setMigratingVm(migratingVm)
        .build()
        .toString();
  }

  public static MigratingVmName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SOURCE_MIGRATING_VM.validatedMatch(
            formattedString, "MigratingVmName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("source"),
        matchMap.get("migrating_vm"));
  }

  public static List<MigratingVmName> parseList(List<String> formattedStrings) {
    List<MigratingVmName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MigratingVmName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MigratingVmName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SOURCE_MIGRATING_VM.matches(formattedString);
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
          if (migratingVm != null) {
            fieldMapBuilder.put("migrating_vm", migratingVm);
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
    return PROJECT_LOCATION_SOURCE_MIGRATING_VM.instantiate(
        "project", project, "location", location, "source", source, "migrating_vm", migratingVm);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      MigratingVmName that = ((MigratingVmName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.source, that.source)
          && Objects.equals(this.migratingVm, that.migratingVm);
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
    h ^= Objects.hashCode(migratingVm);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/sources/{source}/migratingVms/{migrating_vm}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String source;
    private String migratingVm;

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

    public String getMigratingVm() {
      return migratingVm;
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

    public Builder setMigratingVm(String migratingVm) {
      this.migratingVm = migratingVm;
      return this;
    }

    private Builder(MigratingVmName migratingVmName) {
      this.project = migratingVmName.project;
      this.location = migratingVmName.location;
      this.source = migratingVmName.source;
      this.migratingVm = migratingVmName.migratingVm;
    }

    public MigratingVmName build() {
      return new MigratingVmName(this);
    }
  }
}
