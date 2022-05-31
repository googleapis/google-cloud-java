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

package com.google.cloud.securitycenter.v1p1beta1;

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
public class SourceName implements ResourceName {
  private static final PathTemplate ORGANIZATION_SOURCE =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/sources/{source}");
  private static final PathTemplate FOLDER_SOURCE =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/sources/{source}");
  private static final PathTemplate PROJECT_SOURCE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/sources/{source}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String source;
  private final String folder;
  private final String project;

  @Deprecated
  protected SourceName() {
    organization = null;
    source = null;
    folder = null;
    project = null;
  }

  private SourceName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    source = Preconditions.checkNotNull(builder.getSource());
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION_SOURCE;
  }

  private SourceName(FolderSourceBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    source = Preconditions.checkNotNull(builder.getSource());
    organization = null;
    project = null;
    pathTemplate = FOLDER_SOURCE;
  }

  private SourceName(ProjectSourceBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    source = Preconditions.checkNotNull(builder.getSource());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_SOURCE;
  }

  public String getOrganization() {
    return organization;
  }

  public String getSource() {
    return source;
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
  public static Builder newOrganizationSourceBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderSourceBuilder newFolderSourceBuilder() {
    return new FolderSourceBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectSourceBuilder newProjectSourceBuilder() {
    return new ProjectSourceBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SourceName of(String organization, String source) {
    return newBuilder().setOrganization(organization).setSource(source).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SourceName ofOrganizationSourceName(String organization, String source) {
    return newBuilder().setOrganization(organization).setSource(source).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SourceName ofFolderSourceName(String folder, String source) {
    return newFolderSourceBuilder().setFolder(folder).setSource(source).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SourceName ofProjectSourceName(String project, String source) {
    return newProjectSourceBuilder().setProject(project).setSource(source).build();
  }

  public static String format(String organization, String source) {
    return newBuilder().setOrganization(organization).setSource(source).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationSourceName(String organization, String source) {
    return newBuilder().setOrganization(organization).setSource(source).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderSourceName(String folder, String source) {
    return newFolderSourceBuilder().setFolder(folder).setSource(source).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectSourceName(String project, String source) {
    return newProjectSourceBuilder().setProject(project).setSource(source).build().toString();
  }

  public static SourceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_SOURCE.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_SOURCE.match(formattedString);
      return ofOrganizationSourceName(matchMap.get("organization"), matchMap.get("source"));
    } else if (FOLDER_SOURCE.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_SOURCE.match(formattedString);
      return ofFolderSourceName(matchMap.get("folder"), matchMap.get("source"));
    } else if (PROJECT_SOURCE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_SOURCE.match(formattedString);
      return ofProjectSourceName(matchMap.get("project"), matchMap.get("source"));
    }
    throw new ValidationException("SourceName.parse: formattedString not in valid format");
  }

  public static List<SourceName> parseList(List<String> formattedStrings) {
    List<SourceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SourceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SourceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_SOURCE.matches(formattedString)
        || FOLDER_SOURCE.matches(formattedString)
        || PROJECT_SOURCE.matches(formattedString);
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
          if (source != null) {
            fieldMapBuilder.put("source", source);
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
      SourceName that = ((SourceName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.source, that.source)
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
    h ^= Objects.hashCode(source);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for organizations/{organization}/sources/{source}. */
  public static class Builder {
    private String organization;
    private String source;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getSource() {
      return source;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setSource(String source) {
      this.source = source;
      return this;
    }

    private Builder(SourceName sourceName) {
      Preconditions.checkArgument(
          Objects.equals(sourceName.pathTemplate, ORGANIZATION_SOURCE),
          "toBuilder is only supported when SourceName has the pattern of organizations/{organization}/sources/{source}");
      this.organization = sourceName.organization;
      this.source = sourceName.source;
    }

    public SourceName build() {
      return new SourceName(this);
    }
  }

  /** Builder for folders/{folder}/sources/{source}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderSourceBuilder {
    private String folder;
    private String source;

    protected FolderSourceBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getSource() {
      return source;
    }

    public FolderSourceBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderSourceBuilder setSource(String source) {
      this.source = source;
      return this;
    }

    public SourceName build() {
      return new SourceName(this);
    }
  }

  /** Builder for projects/{project}/sources/{source}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectSourceBuilder {
    private String project;
    private String source;

    protected ProjectSourceBuilder() {}

    public String getProject() {
      return project;
    }

    public String getSource() {
      return source;
    }

    public ProjectSourceBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectSourceBuilder setSource(String source) {
      this.source = source;
      return this;
    }

    public SourceName build() {
      return new SourceName(this);
    }
  }
}
