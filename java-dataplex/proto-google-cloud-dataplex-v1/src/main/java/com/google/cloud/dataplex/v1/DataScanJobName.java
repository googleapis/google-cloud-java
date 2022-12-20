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

package com.google.cloud.dataplex.v1;

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
public class DataScanJobName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATASCAN_JOB =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataScans/{dataScan}/jobs/{job}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String dataScan;
  private final String job;

  @Deprecated
  protected DataScanJobName() {
    project = null;
    location = null;
    dataScan = null;
    job = null;
  }

  private DataScanJobName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataScan = Preconditions.checkNotNull(builder.getDataScan());
    job = Preconditions.checkNotNull(builder.getJob());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDataScan() {
    return dataScan;
  }

  public String getJob() {
    return job;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DataScanJobName of(String project, String location, String dataScan, String job) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataScan(dataScan)
        .setJob(job)
        .build();
  }

  public static String format(String project, String location, String dataScan, String job) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataScan(dataScan)
        .setJob(job)
        .build()
        .toString();
  }

  public static DataScanJobName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DATASCAN_JOB.validatedMatch(
            formattedString, "DataScanJobName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("dataScan"),
        matchMap.get("job"));
  }

  public static List<DataScanJobName> parseList(List<String> formattedStrings) {
    List<DataScanJobName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DataScanJobName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DataScanJobName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATASCAN_JOB.matches(formattedString);
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
          if (dataScan != null) {
            fieldMapBuilder.put("dataScan", dataScan);
          }
          if (job != null) {
            fieldMapBuilder.put("job", job);
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
    return PROJECT_LOCATION_DATASCAN_JOB.instantiate(
        "project", project, "location", location, "dataScan", dataScan, "job", job);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      DataScanJobName that = ((DataScanJobName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataScan, that.dataScan)
          && Objects.equals(this.job, that.job);
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
    h ^= Objects.hashCode(dataScan);
    h *= 1000003;
    h ^= Objects.hashCode(job);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/dataScans/{dataScan}/jobs/{job}. */
  public static class Builder {
    private String project;
    private String location;
    private String dataScan;
    private String job;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDataScan() {
      return dataScan;
    }

    public String getJob() {
      return job;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDataScan(String dataScan) {
      this.dataScan = dataScan;
      return this;
    }

    public Builder setJob(String job) {
      this.job = job;
      return this;
    }

    private Builder(DataScanJobName dataScanJobName) {
      this.project = dataScanJobName.project;
      this.location = dataScanJobName.location;
      this.dataScan = dataScanJobName.dataScan;
      this.job = dataScanJobName.job;
    }

    public DataScanJobName build() {
      return new DataScanJobName(this);
    }
  }
}
