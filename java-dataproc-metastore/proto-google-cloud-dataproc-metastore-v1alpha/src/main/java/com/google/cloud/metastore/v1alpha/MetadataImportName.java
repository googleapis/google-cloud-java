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

package com.google.cloud.metastore.v1alpha;

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
public class MetadataImportName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SERVICE_METADATA_IMPORT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/services/{service}/metadataImports/{metadata_import}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String service;
  private final String metadataImport;

  @Deprecated
  protected MetadataImportName() {
    project = null;
    location = null;
    service = null;
    metadataImport = null;
  }

  private MetadataImportName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    service = Preconditions.checkNotNull(builder.getService());
    metadataImport = Preconditions.checkNotNull(builder.getMetadataImport());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getService() {
    return service;
  }

  public String getMetadataImport() {
    return metadataImport;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MetadataImportName of(
      String project, String location, String service, String metadataImport) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setService(service)
        .setMetadataImport(metadataImport)
        .build();
  }

  public static String format(
      String project, String location, String service, String metadataImport) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setService(service)
        .setMetadataImport(metadataImport)
        .build()
        .toString();
  }

  public static MetadataImportName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SERVICE_METADATA_IMPORT.validatedMatch(
            formattedString, "MetadataImportName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("service"),
        matchMap.get("metadata_import"));
  }

  public static List<MetadataImportName> parseList(List<String> formattedStrings) {
    List<MetadataImportName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MetadataImportName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MetadataImportName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SERVICE_METADATA_IMPORT.matches(formattedString);
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
          if (service != null) {
            fieldMapBuilder.put("service", service);
          }
          if (metadataImport != null) {
            fieldMapBuilder.put("metadata_import", metadataImport);
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
    return PROJECT_LOCATION_SERVICE_METADATA_IMPORT.instantiate(
        "project",
        project,
        "location",
        location,
        "service",
        service,
        "metadata_import",
        metadataImport);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      MetadataImportName that = ((MetadataImportName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.service, that.service)
          && Objects.equals(this.metadataImport, that.metadataImport);
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
    h ^= Objects.hashCode(service);
    h *= 1000003;
    h ^= Objects.hashCode(metadataImport);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/services/{service}/metadataImports/{metadata_import}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String service;
    private String metadataImport;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getService() {
      return service;
    }

    public String getMetadataImport() {
      return metadataImport;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setService(String service) {
      this.service = service;
      return this;
    }

    public Builder setMetadataImport(String metadataImport) {
      this.metadataImport = metadataImport;
      return this;
    }

    private Builder(MetadataImportName metadataImportName) {
      this.project = metadataImportName.project;
      this.location = metadataImportName.location;
      this.service = metadataImportName.service;
      this.metadataImport = metadataImportName.metadataImport;
    }

    public MetadataImportName build() {
      return new MetadataImportName(this);
    }
  }
}
