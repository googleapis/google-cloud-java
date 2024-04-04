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
public class FindingName implements ResourceName {
  private static final PathTemplate ORGANIZATION_SOURCE_FINDING =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/sources/{source}/findings/{finding}");
  private static final PathTemplate ORGANIZATION_SOURCE_LOCATION_FINDING =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/sources/{source}/locations/{location}/findings/{finding}");
  private static final PathTemplate FOLDER_SOURCE_FINDING =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/sources/{source}/findings/{finding}");
  private static final PathTemplate FOLDER_SOURCE_LOCATION_FINDING =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/sources/{source}/locations/{location}/findings/{finding}");
  private static final PathTemplate PROJECT_SOURCE_FINDING =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/sources/{source}/findings/{finding}");
  private static final PathTemplate PROJECT_SOURCE_LOCATION_FINDING =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/sources/{source}/locations/{location}/findings/{finding}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String source;
  private final String finding;
  private final String location;
  private final String folder;
  private final String project;

  @Deprecated
  protected FindingName() {
    organization = null;
    source = null;
    finding = null;
    location = null;
    folder = null;
    project = null;
  }

  private FindingName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    source = Preconditions.checkNotNull(builder.getSource());
    finding = Preconditions.checkNotNull(builder.getFinding());
    location = null;
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION_SOURCE_FINDING;
  }

  private FindingName(OrganizationSourceLocationFindingBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    source = Preconditions.checkNotNull(builder.getSource());
    location = Preconditions.checkNotNull(builder.getLocation());
    finding = Preconditions.checkNotNull(builder.getFinding());
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION_SOURCE_LOCATION_FINDING;
  }

  private FindingName(FolderSourceFindingBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    source = Preconditions.checkNotNull(builder.getSource());
    finding = Preconditions.checkNotNull(builder.getFinding());
    organization = null;
    location = null;
    project = null;
    pathTemplate = FOLDER_SOURCE_FINDING;
  }

  private FindingName(FolderSourceLocationFindingBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    source = Preconditions.checkNotNull(builder.getSource());
    location = Preconditions.checkNotNull(builder.getLocation());
    finding = Preconditions.checkNotNull(builder.getFinding());
    organization = null;
    project = null;
    pathTemplate = FOLDER_SOURCE_LOCATION_FINDING;
  }

  private FindingName(ProjectSourceFindingBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    source = Preconditions.checkNotNull(builder.getSource());
    finding = Preconditions.checkNotNull(builder.getFinding());
    organization = null;
    location = null;
    folder = null;
    pathTemplate = PROJECT_SOURCE_FINDING;
  }

  private FindingName(ProjectSourceLocationFindingBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    source = Preconditions.checkNotNull(builder.getSource());
    location = Preconditions.checkNotNull(builder.getLocation());
    finding = Preconditions.checkNotNull(builder.getFinding());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_SOURCE_LOCATION_FINDING;
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

  public String getLocation() {
    return location;
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

  public static Builder newOrganizationSourceFindingBuilder() {
    return new Builder();
  }

  public static OrganizationSourceLocationFindingBuilder
      newOrganizationSourceLocationFindingBuilder() {
    return new OrganizationSourceLocationFindingBuilder();
  }

  public static FolderSourceFindingBuilder newFolderSourceFindingBuilder() {
    return new FolderSourceFindingBuilder();
  }

  public static FolderSourceLocationFindingBuilder newFolderSourceLocationFindingBuilder() {
    return new FolderSourceLocationFindingBuilder();
  }

  public static ProjectSourceFindingBuilder newProjectSourceFindingBuilder() {
    return new ProjectSourceFindingBuilder();
  }

  public static ProjectSourceLocationFindingBuilder newProjectSourceLocationFindingBuilder() {
    return new ProjectSourceLocationFindingBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FindingName of(String organization, String source, String finding) {
    return newBuilder().setOrganization(organization).setSource(source).setFinding(finding).build();
  }

  public static FindingName ofOrganizationSourceFindingName(
      String organization, String source, String finding) {
    return newBuilder().setOrganization(organization).setSource(source).setFinding(finding).build();
  }

  public static FindingName ofOrganizationSourceLocationFindingName(
      String organization, String source, String location, String finding) {
    return newOrganizationSourceLocationFindingBuilder()
        .setOrganization(organization)
        .setSource(source)
        .setLocation(location)
        .setFinding(finding)
        .build();
  }

  public static FindingName ofFolderSourceFindingName(
      String folder, String source, String finding) {
    return newFolderSourceFindingBuilder()
        .setFolder(folder)
        .setSource(source)
        .setFinding(finding)
        .build();
  }

  public static FindingName ofFolderSourceLocationFindingName(
      String folder, String source, String location, String finding) {
    return newFolderSourceLocationFindingBuilder()
        .setFolder(folder)
        .setSource(source)
        .setLocation(location)
        .setFinding(finding)
        .build();
  }

  public static FindingName ofProjectSourceFindingName(
      String project, String source, String finding) {
    return newProjectSourceFindingBuilder()
        .setProject(project)
        .setSource(source)
        .setFinding(finding)
        .build();
  }

  public static FindingName ofProjectSourceLocationFindingName(
      String project, String source, String location, String finding) {
    return newProjectSourceLocationFindingBuilder()
        .setProject(project)
        .setSource(source)
        .setLocation(location)
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

  public static String formatOrganizationSourceFindingName(
      String organization, String source, String finding) {
    return newBuilder()
        .setOrganization(organization)
        .setSource(source)
        .setFinding(finding)
        .build()
        .toString();
  }

  public static String formatOrganizationSourceLocationFindingName(
      String organization, String source, String location, String finding) {
    return newOrganizationSourceLocationFindingBuilder()
        .setOrganization(organization)
        .setSource(source)
        .setLocation(location)
        .setFinding(finding)
        .build()
        .toString();
  }

  public static String formatFolderSourceFindingName(String folder, String source, String finding) {
    return newFolderSourceFindingBuilder()
        .setFolder(folder)
        .setSource(source)
        .setFinding(finding)
        .build()
        .toString();
  }

  public static String formatFolderSourceLocationFindingName(
      String folder, String source, String location, String finding) {
    return newFolderSourceLocationFindingBuilder()
        .setFolder(folder)
        .setSource(source)
        .setLocation(location)
        .setFinding(finding)
        .build()
        .toString();
  }

  public static String formatProjectSourceFindingName(
      String project, String source, String finding) {
    return newProjectSourceFindingBuilder()
        .setProject(project)
        .setSource(source)
        .setFinding(finding)
        .build()
        .toString();
  }

  public static String formatProjectSourceLocationFindingName(
      String project, String source, String location, String finding) {
    return newProjectSourceLocationFindingBuilder()
        .setProject(project)
        .setSource(source)
        .setLocation(location)
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
    } else if (ORGANIZATION_SOURCE_LOCATION_FINDING.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_SOURCE_LOCATION_FINDING.match(formattedString);
      return ofOrganizationSourceLocationFindingName(
          matchMap.get("organization"),
          matchMap.get("source"),
          matchMap.get("location"),
          matchMap.get("finding"));
    } else if (FOLDER_SOURCE_FINDING.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_SOURCE_FINDING.match(formattedString);
      return ofFolderSourceFindingName(
          matchMap.get("folder"), matchMap.get("source"), matchMap.get("finding"));
    } else if (FOLDER_SOURCE_LOCATION_FINDING.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_SOURCE_LOCATION_FINDING.match(formattedString);
      return ofFolderSourceLocationFindingName(
          matchMap.get("folder"),
          matchMap.get("source"),
          matchMap.get("location"),
          matchMap.get("finding"));
    } else if (PROJECT_SOURCE_FINDING.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_SOURCE_FINDING.match(formattedString);
      return ofProjectSourceFindingName(
          matchMap.get("project"), matchMap.get("source"), matchMap.get("finding"));
    } else if (PROJECT_SOURCE_LOCATION_FINDING.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_SOURCE_LOCATION_FINDING.match(formattedString);
      return ofProjectSourceLocationFindingName(
          matchMap.get("project"),
          matchMap.get("source"),
          matchMap.get("location"),
          matchMap.get("finding"));
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
        || ORGANIZATION_SOURCE_LOCATION_FINDING.matches(formattedString)
        || FOLDER_SOURCE_FINDING.matches(formattedString)
        || FOLDER_SOURCE_LOCATION_FINDING.matches(formattedString)
        || PROJECT_SOURCE_FINDING.matches(formattedString)
        || PROJECT_SOURCE_LOCATION_FINDING.matches(formattedString);
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
          if (location != null) {
            fieldMapBuilder.put("location", location);
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
      FindingName that = ((FindingName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.source, that.source)
          && Objects.equals(this.finding, that.finding)
          && Objects.equals(this.location, that.location)
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
    h ^= Objects.hashCode(location);
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

  /**
   * Builder for
   * organizations/{organization}/sources/{source}/locations/{location}/findings/{finding}.
   */
  public static class OrganizationSourceLocationFindingBuilder {
    private String organization;
    private String source;
    private String location;
    private String finding;

    protected OrganizationSourceLocationFindingBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getSource() {
      return source;
    }

    public String getLocation() {
      return location;
    }

    public String getFinding() {
      return finding;
    }

    public OrganizationSourceLocationFindingBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationSourceLocationFindingBuilder setSource(String source) {
      this.source = source;
      return this;
    }

    public OrganizationSourceLocationFindingBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationSourceLocationFindingBuilder setFinding(String finding) {
      this.finding = finding;
      return this;
    }

    public FindingName build() {
      return new FindingName(this);
    }
  }

  /** Builder for folders/{folder}/sources/{source}/findings/{finding}. */
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

  /** Builder for folders/{folder}/sources/{source}/locations/{location}/findings/{finding}. */
  public static class FolderSourceLocationFindingBuilder {
    private String folder;
    private String source;
    private String location;
    private String finding;

    protected FolderSourceLocationFindingBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getSource() {
      return source;
    }

    public String getLocation() {
      return location;
    }

    public String getFinding() {
      return finding;
    }

    public FolderSourceLocationFindingBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderSourceLocationFindingBuilder setSource(String source) {
      this.source = source;
      return this;
    }

    public FolderSourceLocationFindingBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderSourceLocationFindingBuilder setFinding(String finding) {
      this.finding = finding;
      return this;
    }

    public FindingName build() {
      return new FindingName(this);
    }
  }

  /** Builder for projects/{project}/sources/{source}/findings/{finding}. */
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

  /** Builder for projects/{project}/sources/{source}/locations/{location}/findings/{finding}. */
  public static class ProjectSourceLocationFindingBuilder {
    private String project;
    private String source;
    private String location;
    private String finding;

    protected ProjectSourceLocationFindingBuilder() {}

    public String getProject() {
      return project;
    }

    public String getSource() {
      return source;
    }

    public String getLocation() {
      return location;
    }

    public String getFinding() {
      return finding;
    }

    public ProjectSourceLocationFindingBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectSourceLocationFindingBuilder setSource(String source) {
      this.source = source;
      return this;
    }

    public ProjectSourceLocationFindingBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectSourceLocationFindingBuilder setFinding(String finding) {
      this.finding = finding;
      return this;
    }

    public FindingName build() {
      return new FindingName(this);
    }
  }
}
