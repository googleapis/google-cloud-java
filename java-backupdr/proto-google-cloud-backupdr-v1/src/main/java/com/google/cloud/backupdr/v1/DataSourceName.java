/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.backupdr.v1;

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
public class DataSourceName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_BACKUPVAULT_DATASOURCE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/backupVaults/{backupvault}/dataSources/{datasource}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String backupvault;
  private final String datasource;

  @Deprecated
  protected DataSourceName() {
    project = null;
    location = null;
    backupvault = null;
    datasource = null;
  }

  private DataSourceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    backupvault = Preconditions.checkNotNull(builder.getBackupvault());
    datasource = Preconditions.checkNotNull(builder.getDatasource());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getBackupvault() {
    return backupvault;
  }

  public String getDatasource() {
    return datasource;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DataSourceName of(
      String project, String location, String backupvault, String datasource) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBackupvault(backupvault)
        .setDatasource(datasource)
        .build();
  }

  public static String format(
      String project, String location, String backupvault, String datasource) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBackupvault(backupvault)
        .setDatasource(datasource)
        .build()
        .toString();
  }

  public static DataSourceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_BACKUPVAULT_DATASOURCE.validatedMatch(
            formattedString, "DataSourceName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("backupvault"),
        matchMap.get("datasource"));
  }

  public static List<DataSourceName> parseList(List<String> formattedStrings) {
    List<DataSourceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DataSourceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DataSourceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_BACKUPVAULT_DATASOURCE.matches(formattedString);
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
          if (backupvault != null) {
            fieldMapBuilder.put("backupvault", backupvault);
          }
          if (datasource != null) {
            fieldMapBuilder.put("datasource", datasource);
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
    return PROJECT_LOCATION_BACKUPVAULT_DATASOURCE.instantiate(
        "project",
        project,
        "location",
        location,
        "backupvault",
        backupvault,
        "datasource",
        datasource);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DataSourceName that = ((DataSourceName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.backupvault, that.backupvault)
          && Objects.equals(this.datasource, that.datasource);
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
    h ^= Objects.hashCode(backupvault);
    h *= 1000003;
    h ^= Objects.hashCode(datasource);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/backupVaults/{backupvault}/dataSources/{datasource}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String backupvault;
    private String datasource;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getBackupvault() {
      return backupvault;
    }

    public String getDatasource() {
      return datasource;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setBackupvault(String backupvault) {
      this.backupvault = backupvault;
      return this;
    }

    public Builder setDatasource(String datasource) {
      this.datasource = datasource;
      return this;
    }

    private Builder(DataSourceName dataSourceName) {
      this.project = dataSourceName.project;
      this.location = dataSourceName.location;
      this.backupvault = dataSourceName.backupvault;
      this.datasource = dataSourceName.datasource;
    }

    public DataSourceName build() {
      return new DataSourceName(this);
    }
  }
}
