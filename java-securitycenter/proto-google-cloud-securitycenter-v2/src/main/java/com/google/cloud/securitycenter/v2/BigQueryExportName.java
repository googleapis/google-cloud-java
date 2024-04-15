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

package com.google.cloud.securitycenter.v2;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
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
public class BigQueryExportName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_EXPORT =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/bigQueryExports/{export}");
  private static final PathTemplate FOLDER_LOCATION_EXPORT =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/bigQueryExports/{export}");
  private static final PathTemplate PROJECT_LOCATION_EXPORT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/bigQueryExports/{export}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String export;
  private final String folder;
  private final String project;

  @Deprecated
  protected BigQueryExportName() {
    organization = null;
    location = null;
    export = null;
    folder = null;
    project = null;
  }

  private BigQueryExportName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    export = Preconditions.checkNotNull(builder.getExport());
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_EXPORT;
  }

  private BigQueryExportName(FolderLocationExportBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    export = Preconditions.checkNotNull(builder.getExport());
    organization = null;
    project = null;
    pathTemplate = FOLDER_LOCATION_EXPORT;
  }

  private BigQueryExportName(ProjectLocationExportBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    export = Preconditions.checkNotNull(builder.getExport());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_LOCATION_EXPORT;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getExport() {
    return export;
  }

  public String getFolder() {
    return folder;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationLocationExportBuilder() {
    return new Builder();
  }

  public static FolderLocationExportBuilder newFolderLocationExportBuilder() {
    return new FolderLocationExportBuilder();
  }

  public static ProjectLocationExportBuilder newProjectLocationExportBuilder() {
    return new ProjectLocationExportBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BigQueryExportName of(String organization, String location, String export) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setExport(export)
        .build();
  }

  public static BigQueryExportName ofOrganizationLocationExportName(
      String organization, String location, String export) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setExport(export)
        .build();
  }

  public static BigQueryExportName ofFolderLocationExportName(
      String folder, String location, String export) {
    return newFolderLocationExportBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setExport(export)
        .build();
  }

  public static BigQueryExportName ofProjectLocationExportName(
      String project, String location, String export) {
    return newProjectLocationExportBuilder()
        .setProject(project)
        .setLocation(location)
        .setExport(export)
        .build();
  }

  public static String format(String organization, String location, String export) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setExport(export)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationExportName(
      String organization, String location, String export) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setExport(export)
        .build()
        .toString();
  }

  public static String formatFolderLocationExportName(
      String folder, String location, String export) {
    return newFolderLocationExportBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setExport(export)
        .build()
        .toString();
  }

  public static String formatProjectLocationExportName(
      String project, String location, String export) {
    return newProjectLocationExportBuilder()
        .setProject(project)
        .setLocation(location)
        .setExport(export)
        .build()
        .toString();
  }

  public static BigQueryExportName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_EXPORT.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_EXPORT.match(formattedString);
      return ofOrganizationLocationExportName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("export"));
    } else if (FOLDER_LOCATION_EXPORT.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_EXPORT.match(formattedString);
      return ofFolderLocationExportName(
          matchMap.get("folder"), matchMap.get("location"), matchMap.get("export"));
    } else if (PROJECT_LOCATION_EXPORT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_EXPORT.match(formattedString);
      return ofProjectLocationExportName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("export"));
    }
    throw new ValidationException("BigQueryExportName.parse: formattedString not in valid format");
  }

  public static List<BigQueryExportName> parseList(List<String> formattedStrings) {
    List<BigQueryExportName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BigQueryExportName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BigQueryExportName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_EXPORT.matches(formattedString)
        || FOLDER_LOCATION_EXPORT.matches(formattedString)
        || PROJECT_LOCATION_EXPORT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (export != null) {
            fieldMapBuilder.put("export", export);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
          }
          if (project != null) {
            fieldMapBuilder.put("project", project);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BigQueryExportName that = ((BigQueryExportName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.export, that.export)
          && Objects.equals(this.folder, that.folder)
          && Objects.equals(this.project, that.project);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(export);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for organizations/{organization}/locations/{location}/bigQueryExports/{export}. */
  public static class Builder {
    private String organization;
    private String location;
    private String export;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getExport() {
      return export;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setExport(String export) {
      this.export = export;
      return this;
    }

    private Builder(BigQueryExportName bigQueryExportName) {
      Preconditions.checkArgument(
          Objects.equals(bigQueryExportName.pathTemplate, ORGANIZATION_LOCATION_EXPORT),
          "toBuilder is only supported when BigQueryExportName has the pattern of organizations/{organization}/locations/{location}/bigQueryExports/{export}");
      this.organization = bigQueryExportName.organization;
      this.location = bigQueryExportName.location;
      this.export = bigQueryExportName.export;
    }

    public BigQueryExportName build() {
      return new BigQueryExportName(this);
    }
  }

  /** Builder for folders/{folder}/locations/{location}/bigQueryExports/{export}. */
  public static class FolderLocationExportBuilder {
    private String folder;
    private String location;
    private String export;

    protected FolderLocationExportBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getExport() {
      return export;
    }

    public FolderLocationExportBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationExportBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationExportBuilder setExport(String export) {
      this.export = export;
      return this;
    }

    public BigQueryExportName build() {
      return new BigQueryExportName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/bigQueryExports/{export}. */
  public static class ProjectLocationExportBuilder {
    private String project;
    private String location;
    private String export;

    protected ProjectLocationExportBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getExport() {
      return export;
    }

    public ProjectLocationExportBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationExportBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationExportBuilder setExport(String export) {
      this.export = export;
      return this;
    }

    public BigQueryExportName build() {
      return new BigQueryExportName(this);
    }
  }
}
