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
public class FindingName implements ResourceName {
  private static final PathTemplate ORGANIZATION_SOURCE_FINDING =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/sources/{source}/findings/{finding}");
  private static final PathTemplate FOLDER_SOURCE_FINDING =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/sources/{source}/findings/{finding}");
  private static final PathTemplate PROJECT_SOURCE_FINDING =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/sources/{source}/findings/{finding}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String source;
  private final String finding;
  private final String folder;
  private final String project;

  @Deprecated
  protected FindingName() {
    organization = null;
    source = null;
    finding = null;
    folder = null;
    project = null;
  }

  private FindingName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    source = Preconditions.checkNotNull(builder.getSource());
    finding = Preconditions.checkNotNull(builder.getFinding());
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION_SOURCE_FINDING;
  }

  private FindingName(FolderSourceFindingBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    source = Preconditions.checkNotNull(builder.getSource());
    finding = Preconditions.checkNotNull(builder.getFinding());
    organization = null;
    project = null;
    pathTemplate = FOLDER_SOURCE_FINDING;
  }

  private FindingName(ProjectSourceFindingBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    source = Preconditions.checkNotNull(builder.getSource());
    finding = Preconditions.checkNotNull(builder.getFinding());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_SOURCE_FINDING;
  }

  public String getOrganization() {
    return organization;
  }

  public String getSource() {
    return source;
  }

  public String getFinding() {
    return finding;
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
  public static Builder newOrganizationSourceFindingBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderSourceFindingBuilder newFolderSourceFindingBuilder() {
    return new FolderSourceFindingBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectSourceFindingBuilder newProjectSourceFindingBuilder() {
    return new ProjectSourceFindingBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FindingName of(String organization, String source, String finding) {
    return newBuilder().setOrganization(organization).setSource(source).setFinding(finding).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static FindingName ofOrganizationSourceFindingName(
      String organization, String source, String finding) {
    return newBuilder().setOrganization(organization).setSource(source).setFinding(finding).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static FindingName ofFolderSourceFindingName(
      String folder, String source, String finding) {
    return newFolderSourceFindingBuilder()
        .setFolder(folder)
        .setSource(source)
        .setFinding(finding)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static FindingName ofProjectSourceFindingName(
      String project, String source, String finding) {
    return newProjectSourceFindingBuilder()
        .setProject(project)
        .setSource(source)
        .setFinding(finding)
        .build();
  }

  public static String format(String organization, String source, String finding) {
    return newBuilder()
        .setOrganization(organization)
        .setSource(source)
        .setFinding(finding)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationSourceFindingName(
      String organization, String source, String finding) {
    return newBuilder()
        .setOrganization(organization)
        .setSource(source)
        .setFinding(finding)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderSourceFindingName(String folder, String source, String finding) {
    return newFolderSourceFindingBuilder()
        .setFolder(folder)
        .setSource(source)
        .setFinding(finding)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectSourceFindingName(
      String project, String source, String finding) {
    return newProjectSourceFindingBuilder()
        .setProject(project)
        .setSource(source)
        .setFinding(finding)
        .build()
        .toString();
  }

  public static FindingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_SOURCE_FINDING.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_SOURCE_FINDING.match(formattedString);
      return ofOrganizationSourceFindingName(
          matchMap.get("organization"), matchMap.get("source"), matchMap.get("finding"));
    } else if (FOLDER_SOURCE_FINDING.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_SOURCE_FINDING.match(formattedString);
      return ofFolderSourceFindingName(
          matchMap.get("folder"), matchMap.get("source"), matchMap.get("finding"));
    } else if (PROJECT_SOURCE_FINDING.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_SOURCE_FINDING.match(formattedString);
      return ofProjectSourceFindingName(
          matchMap.get("project"), matchMap.get("source"), matchMap.get("finding"));
    }
    throw new ValidationException("FindingName.parse: formattedString not in valid format");
  }

  public static List<FindingName> parseList(List<String> formattedStrings) {
    List<FindingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FindingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FindingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_SOURCE_FINDING.matches(formattedString)
        || FOLDER_SOURCE_FINDING.matches(formattedString)
        || PROJECT_SOURCE_FINDING.matches(formattedString);
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
          if (finding != null) {
            fieldMapBuilder.put("finding", finding);
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
      FindingName that = ((FindingName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.source, that.source)
          && Objects.equals(this.finding, that.finding)
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
    h ^= Objects.hashCode(finding);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for organizations/{organization}/sources/{source}/findings/{finding}. */
  public static class Builder {
    private String organization;
    private String source;
    private String finding;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getSource() {
      return source;
    }

    public String getFinding() {
      return finding;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setSource(String source) {
      this.source = source;
      return this;
    }

    public Builder setFinding(String finding) {
      this.finding = finding;
      return this;
    }

    private Builder(FindingName findingName) {
      Preconditions.checkArgument(
          Objects.equals(findingName.pathTemplate, ORGANIZATION_SOURCE_FINDING),
          "toBuilder is only supported when FindingName has the pattern of organizations/{organization}/sources/{source}/findings/{finding}");
      this.organization = findingName.organization;
      this.source = findingName.source;
      this.finding = findingName.finding;
    }

    public FindingName build() {
      return new FindingName(this);
    }
  }

  /** Builder for folders/{folder}/sources/{source}/findings/{finding}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderSourceFindingBuilder {
    private String folder;
    private String source;
    private String finding;

    protected FolderSourceFindingBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getSource() {
      return source;
    }

    public String getFinding() {
      return finding;
    }

    public FolderSourceFindingBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderSourceFindingBuilder setSource(String source) {
      this.source = source;
      return this;
    }

    public FolderSourceFindingBuilder setFinding(String finding) {
      this.finding = finding;
      return this;
    }

    public FindingName build() {
      return new FindingName(this);
    }
  }

  /** Builder for projects/{project}/sources/{source}/findings/{finding}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectSourceFindingBuilder {
    private String project;
    private String source;
    private String finding;

    protected ProjectSourceFindingBuilder() {}

    public String getProject() {
      return project;
    }

    public String getSource() {
      return source;
    }

    public String getFinding() {
      return finding;
    }

    public ProjectSourceFindingBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectSourceFindingBuilder setSource(String source) {
      this.source = source;
      return this;
    }

    public ProjectSourceFindingBuilder setFinding(String finding) {
      this.finding = finding;
      return this;
    }

    public FindingName build() {
      return new FindingName(this);
    }
  }
}
