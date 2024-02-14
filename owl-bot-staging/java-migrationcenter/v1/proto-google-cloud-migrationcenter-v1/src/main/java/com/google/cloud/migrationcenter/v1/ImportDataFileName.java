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

package com.google.cloud.migrationcenter.v1;

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
public class ImportDataFileName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_IMPORT_JOB_IMPORT_DATA_FILE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/importJobs/{import_job}/importDataFiles/{import_data_file}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String importJob;
  private final String importDataFile;

  @Deprecated
  protected ImportDataFileName() {
    project = null;
    location = null;
    importJob = null;
    importDataFile = null;
  }

  private ImportDataFileName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    importJob = Preconditions.checkNotNull(builder.getImportJob());
    importDataFile = Preconditions.checkNotNull(builder.getImportDataFile());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getImportJob() {
    return importJob;
  }

  public String getImportDataFile() {
    return importDataFile;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ImportDataFileName of(
      String project, String location, String importJob, String importDataFile) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setImportJob(importJob)
        .setImportDataFile(importDataFile)
        .build();
  }

  public static String format(
      String project, String location, String importJob, String importDataFile) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setImportJob(importJob)
        .setImportDataFile(importDataFile)
        .build()
        .toString();
  }

  public static ImportDataFileName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_IMPORT_JOB_IMPORT_DATA_FILE.validatedMatch(
            formattedString, "ImportDataFileName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("import_job"),
        matchMap.get("import_data_file"));
  }

  public static List<ImportDataFileName> parseList(List<String> formattedStrings) {
    List<ImportDataFileName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ImportDataFileName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ImportDataFileName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_IMPORT_JOB_IMPORT_DATA_FILE.matches(formattedString);
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
          if (importJob != null) {
            fieldMapBuilder.put("import_job", importJob);
          }
          if (importDataFile != null) {
            fieldMapBuilder.put("import_data_file", importDataFile);
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
    return PROJECT_LOCATION_IMPORT_JOB_IMPORT_DATA_FILE.instantiate(
        "project",
        project,
        "location",
        location,
        "import_job",
        importJob,
        "import_data_file",
        importDataFile);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ImportDataFileName that = ((ImportDataFileName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.importJob, that.importJob)
          && Objects.equals(this.importDataFile, that.importDataFile);
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
    h ^= Objects.hashCode(importJob);
    h *= 1000003;
    h ^= Objects.hashCode(importDataFile);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/importJobs/{import_job}/importDataFiles/{import_data_file}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String importJob;
    private String importDataFile;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getImportJob() {
      return importJob;
    }

    public String getImportDataFile() {
      return importDataFile;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setImportJob(String importJob) {
      this.importJob = importJob;
      return this;
    }

    public Builder setImportDataFile(String importDataFile) {
      this.importDataFile = importDataFile;
      return this;
    }

    private Builder(ImportDataFileName importDataFileName) {
      this.project = importDataFileName.project;
      this.location = importDataFileName.location;
      this.importJob = importDataFileName.importJob;
      this.importDataFile = importDataFileName.importDataFile;
    }

    public ImportDataFileName build() {
      return new ImportDataFileName(this);
    }
  }
}
