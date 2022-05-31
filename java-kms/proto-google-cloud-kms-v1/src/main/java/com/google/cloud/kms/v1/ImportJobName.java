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

package com.google.cloud.kms.v1;

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
public class ImportJobName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_KEY_RING_IMPORT_JOB =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/keyRings/{key_ring}/importJobs/{import_job}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String keyRing;
  private final String importJob;

  @Deprecated
  protected ImportJobName() {
    project = null;
    location = null;
    keyRing = null;
    importJob = null;
  }

  private ImportJobName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    keyRing = Preconditions.checkNotNull(builder.getKeyRing());
    importJob = Preconditions.checkNotNull(builder.getImportJob());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getKeyRing() {
    return keyRing;
  }

  public String getImportJob() {
    return importJob;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ImportJobName of(
      String project, String location, String keyRing, String importJob) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setKeyRing(keyRing)
        .setImportJob(importJob)
        .build();
  }

  public static String format(String project, String location, String keyRing, String importJob) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setKeyRing(keyRing)
        .setImportJob(importJob)
        .build()
        .toString();
  }

  public static ImportJobName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_KEY_RING_IMPORT_JOB.validatedMatch(
            formattedString, "ImportJobName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("key_ring"),
        matchMap.get("import_job"));
  }

  public static List<ImportJobName> parseList(List<String> formattedStrings) {
    List<ImportJobName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ImportJobName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ImportJobName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_KEY_RING_IMPORT_JOB.matches(formattedString);
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
          if (keyRing != null) {
            fieldMapBuilder.put("key_ring", keyRing);
          }
          if (importJob != null) {
            fieldMapBuilder.put("import_job", importJob);
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
    return PROJECT_LOCATION_KEY_RING_IMPORT_JOB.instantiate(
        "project", project, "location", location, "key_ring", keyRing, "import_job", importJob);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ImportJobName that = ((ImportJobName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.keyRing, that.keyRing)
          && Objects.equals(this.importJob, that.importJob);
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
    h ^= Objects.hashCode(keyRing);
    h *= 1000003;
    h ^= Objects.hashCode(importJob);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/keyRings/{key_ring}/importJobs/{import_job}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String keyRing;
    private String importJob;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getKeyRing() {
      return keyRing;
    }

    public String getImportJob() {
      return importJob;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setKeyRing(String keyRing) {
      this.keyRing = keyRing;
      return this;
    }

    public Builder setImportJob(String importJob) {
      this.importJob = importJob;
      return this;
    }

    private Builder(ImportJobName importJobName) {
      this.project = importJobName.project;
      this.location = importJobName.location;
      this.keyRing = importJobName.keyRing;
      this.importJob = importJobName.importJob;
    }

    public ImportJobName build() {
      return new ImportJobName(this);
    }
  }
}
