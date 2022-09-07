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

package com.google.cloud.securitycenter.v1;

import com.google.api.core.BetaApi;
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
  private static final PathTemplate ORGANIZATION_EXPORT =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/bigQueryExports/{export}");
  private static final PathTemplate FOLDER_EXPORT =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/bigQueryExports/{export}");
  private static final PathTemplate PROJECT_EXPORT =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/bigQueryExports/{export}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String export;
  private final String folder;
  private final String project;

  @Deprecated
  protected BigQueryExportName() {
    organization = null;
    export = null;
    folder = null;
    project = null;
  }

  private BigQueryExportName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    export = Preconditions.checkNotNull(builder.getExport());
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION_EXPORT;
  }

  private BigQueryExportName(FolderExportBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    export = Preconditions.checkNotNull(builder.getExport());
    organization = null;
    project = null;
    pathTemplate = FOLDER_EXPORT;
  }

  private BigQueryExportName(ProjectExportBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    export = Preconditions.checkNotNull(builder.getExport());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_EXPORT;
  }

  public String getOrganization() {
    return organization;
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

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newOrganizationExportBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderExportBuilder newFolderExportBuilder() {
    return new FolderExportBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectExportBuilder newProjectExportBuilder() {
    return new ProjectExportBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BigQueryExportName of(String organization, String export) {
    return newBuilder().setOrganization(organization).setExport(export).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static BigQueryExportName ofOrganizationExportName(String organization, String export) {
    return newBuilder().setOrganization(organization).setExport(export).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static BigQueryExportName ofFolderExportName(String folder, String export) {
    return newFolderExportBuilder().setFolder(folder).setExport(export).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static BigQueryExportName ofProjectExportName(String project, String export) {
    return newProjectExportBuilder().setProject(project).setExport(export).build();
  }

  public static String format(String organization, String export) {
    return newBuilder().setOrganization(organization).setExport(export).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationExportName(String organization, String export) {
    return newBuilder().setOrganization(organization).setExport(export).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderExportName(String folder, String export) {
    return newFolderExportBuilder().setFolder(folder).setExport(export).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectExportName(String project, String export) {
    return newProjectExportBuilder().setProject(project).setExport(export).build().toString();
  }

  public static BigQueryExportName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_EXPORT.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_EXPORT.match(formattedString);
      return ofOrganizationExportName(matchMap.get("organization"), matchMap.get("export"));
    } else if (FOLDER_EXPORT.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_EXPORT.match(formattedString);
      return ofFolderExportName(matchMap.get("folder"), matchMap.get("export"));
    } else if (PROJECT_EXPORT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_EXPORT.match(formattedString);
      return ofProjectExportName(matchMap.get("project"), matchMap.get("export"));
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
    return ORGANIZATION_EXPORT.matches(formattedString)
        || FOLDER_EXPORT.matches(formattedString)
        || PROJECT_EXPORT.matches(formattedString);
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
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      BigQueryExportName that = ((BigQueryExportName) o);
      return Objects.equals(this.organization, that.organization)
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
    h ^= Objects.hashCode(export);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for organizations/{organization}/bigQueryExports/{export}. */
  public static class Builder {
    private String organization;
    private String export;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getExport() {
      return export;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setExport(String export) {
      this.export = export;
      return this;
    }

    private Builder(BigQueryExportName bigQueryExportName) {
      Preconditions.checkArgument(
          Objects.equals(bigQueryExportName.pathTemplate, ORGANIZATION_EXPORT),
          "toBuilder is only supported when BigQueryExportName has the pattern of organizations/{organization}/bigQueryExports/{export}");
      this.organization = bigQueryExportName.organization;
      this.export = bigQueryExportName.export;
    }

    public BigQueryExportName build() {
      return new BigQueryExportName(this);
    }
  }

  /** Builder for folders/{folder}/bigQueryExports/{export}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderExportBuilder {
    private String folder;
    private String export;

    protected FolderExportBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getExport() {
      return export;
    }

    public FolderExportBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderExportBuilder setExport(String export) {
      this.export = export;
      return this;
    }

    public BigQueryExportName build() {
      return new BigQueryExportName(this);
    }
  }

  /** Builder for projects/{project}/bigQueryExports/{export}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectExportBuilder {
    private String project;
    private String export;

    protected ProjectExportBuilder() {}

    public String getProject() {
      return project;
    }

    public String getExport() {
      return export;
    }

    public ProjectExportBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectExportBuilder setExport(String export) {
      this.export = export;
      return this;
    }

    public BigQueryExportName build() {
      return new BigQueryExportName(this);
    }
  }
}
