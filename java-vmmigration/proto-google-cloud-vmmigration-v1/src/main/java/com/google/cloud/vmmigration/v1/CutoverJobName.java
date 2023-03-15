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
public class CutoverJobName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SOURCE_MIGRATING_VM_CUTOVER_JOB =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/sources/{source}/migratingVms/{migrating_vm}/cutoverJobs/{cutover_job}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String source;
  private final String migratingVm;
  private final String cutoverJob;

  @Deprecated
  protected CutoverJobName() {
    project = null;
    location = null;
    source = null;
    migratingVm = null;
    cutoverJob = null;
  }

  private CutoverJobName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    source = Preconditions.checkNotNull(builder.getSource());
    migratingVm = Preconditions.checkNotNull(builder.getMigratingVm());
    cutoverJob = Preconditions.checkNotNull(builder.getCutoverJob());
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

  public String getCutoverJob() {
    return cutoverJob;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CutoverJobName of(
      String project, String location, String source, String migratingVm, String cutoverJob) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSource(source)
        .setMigratingVm(migratingVm)
        .setCutoverJob(cutoverJob)
        .build();
  }

  public static String format(
      String project, String location, String source, String migratingVm, String cutoverJob) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSource(source)
        .setMigratingVm(migratingVm)
        .setCutoverJob(cutoverJob)
        .build()
        .toString();
  }

  public static CutoverJobName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SOURCE_MIGRATING_VM_CUTOVER_JOB.validatedMatch(
            formattedString, "CutoverJobName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("source"),
        matchMap.get("migrating_vm"),
        matchMap.get("cutover_job"));
  }

  public static List<CutoverJobName> parseList(List<String> formattedStrings) {
    List<CutoverJobName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CutoverJobName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CutoverJobName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SOURCE_MIGRATING_VM_CUTOVER_JOB.matches(formattedString);
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
          if (cutoverJob != null) {
            fieldMapBuilder.put("cutover_job", cutoverJob);
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
    return PROJECT_LOCATION_SOURCE_MIGRATING_VM_CUTOVER_JOB.instantiate(
        "project",
        project,
        "location",
        location,
        "source",
        source,
        "migrating_vm",
        migratingVm,
        "cutover_job",
        cutoverJob);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      CutoverJobName that = ((CutoverJobName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.source, that.source)
          && Objects.equals(this.migratingVm, that.migratingVm)
          && Objects.equals(this.cutoverJob, that.cutoverJob);
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
    h *= 1000003;
    h ^= Objects.hashCode(cutoverJob);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/sources/{source}/migratingVms/{migrating_vm}/cutoverJobs/{cutover_job}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String source;
    private String migratingVm;
    private String cutoverJob;

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

    public String getCutoverJob() {
      return cutoverJob;
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

    public Builder setCutoverJob(String cutoverJob) {
      this.cutoverJob = cutoverJob;
      return this;
    }

    private Builder(CutoverJobName cutoverJobName) {
      this.project = cutoverJobName.project;
      this.location = cutoverJobName.location;
      this.source = cutoverJobName.source;
      this.migratingVm = cutoverJobName.migratingVm;
      this.cutoverJob = cutoverJobName.cutoverJob;
    }

    public CutoverJobName build() {
      return new CutoverJobName(this);
    }
  }
}
