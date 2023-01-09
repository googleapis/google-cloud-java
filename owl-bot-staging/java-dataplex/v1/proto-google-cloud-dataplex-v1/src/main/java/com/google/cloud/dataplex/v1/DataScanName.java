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
public class DataScanName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATASCAN =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataScans/{dataScan}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String dataScan;

  @Deprecated
  protected DataScanName() {
    project = null;
    location = null;
    dataScan = null;
  }

  private DataScanName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataScan = Preconditions.checkNotNull(builder.getDataScan());
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

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DataScanName of(String project, String location, String dataScan) {
    return newBuilder().setProject(project).setLocation(location).setDataScan(dataScan).build();
  }

  public static String format(String project, String location, String dataScan) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataScan(dataScan)
        .build()
        .toString();
  }

  public static DataScanName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DATASCAN.validatedMatch(
            formattedString, "DataScanName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("dataScan"));
  }

  public static List<DataScanName> parseList(List<String> formattedStrings) {
    List<DataScanName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DataScanName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DataScanName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATASCAN.matches(formattedString);
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
    return PROJECT_LOCATION_DATASCAN.instantiate(
        "project", project, "location", location, "dataScan", dataScan);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      DataScanName that = ((DataScanName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataScan, that.dataScan);
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
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/dataScans/{dataScan}. */
  public static class Builder {
    private String project;
    private String location;
    private String dataScan;

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

    private Builder(DataScanName dataScanName) {
      this.project = dataScanName.project;
      this.location = dataScanName.location;
      this.dataScan = dataScanName.dataScan;
    }

    public DataScanName build() {
      return new DataScanName(this);
    }
  }
}
