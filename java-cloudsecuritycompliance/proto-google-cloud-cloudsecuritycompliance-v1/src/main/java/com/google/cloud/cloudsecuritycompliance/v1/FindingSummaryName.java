/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.cloudsecuritycompliance.v1;

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
public class FindingSummaryName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_FINDING_SUMMARY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/findingSummaries/{finding_summary}");
  private static final PathTemplate FOLDER_LOCATION_FINDING_SUMMARY =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/findingSummaries/{finding_summary}");
  private static final PathTemplate ORGANIZATION_LOCATION_FINDING_SUMMARY =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/findingSummaries/{finding_summary}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String findingSummary;
  private final String folder;
  private final String organization;

  @Deprecated
  protected FindingSummaryName() {
    project = null;
    location = null;
    findingSummary = null;
    folder = null;
    organization = null;
  }

  private FindingSummaryName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    findingSummary = Preconditions.checkNotNull(builder.getFindingSummary());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION_FINDING_SUMMARY;
  }

  private FindingSummaryName(FolderLocationFindingSummaryBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    findingSummary = Preconditions.checkNotNull(builder.getFindingSummary());
    project = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION_FINDING_SUMMARY;
  }

  private FindingSummaryName(OrganizationLocationFindingSummaryBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    findingSummary = Preconditions.checkNotNull(builder.getFindingSummary());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_FINDING_SUMMARY;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getFindingSummary() {
    return findingSummary;
  }

  public String getFolder() {
    return folder;
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationFindingSummaryBuilder() {
    return new Builder();
  }

  public static FolderLocationFindingSummaryBuilder newFolderLocationFindingSummaryBuilder() {
    return new FolderLocationFindingSummaryBuilder();
  }

  public static OrganizationLocationFindingSummaryBuilder
      newOrganizationLocationFindingSummaryBuilder() {
    return new OrganizationLocationFindingSummaryBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FindingSummaryName of(String project, String location, String findingSummary) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFindingSummary(findingSummary)
        .build();
  }

  public static FindingSummaryName ofProjectLocationFindingSummaryName(
      String project, String location, String findingSummary) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFindingSummary(findingSummary)
        .build();
  }

  public static FindingSummaryName ofFolderLocationFindingSummaryName(
      String folder, String location, String findingSummary) {
    return newFolderLocationFindingSummaryBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setFindingSummary(findingSummary)
        .build();
  }

  public static FindingSummaryName ofOrganizationLocationFindingSummaryName(
      String organization, String location, String findingSummary) {
    return newOrganizationLocationFindingSummaryBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFindingSummary(findingSummary)
        .build();
  }

  public static String format(String project, String location, String findingSummary) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFindingSummary(findingSummary)
        .build()
        .toString();
  }

  public static String formatProjectLocationFindingSummaryName(
      String project, String location, String findingSummary) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFindingSummary(findingSummary)
        .build()
        .toString();
  }

  public static String formatFolderLocationFindingSummaryName(
      String folder, String location, String findingSummary) {
    return newFolderLocationFindingSummaryBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setFindingSummary(findingSummary)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationFindingSummaryName(
      String organization, String location, String findingSummary) {
    return newOrganizationLocationFindingSummaryBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFindingSummary(findingSummary)
        .build()
        .toString();
  }

  public static FindingSummaryName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_FINDING_SUMMARY.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_FINDING_SUMMARY.match(formattedString);
      return ofProjectLocationFindingSummaryName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("finding_summary"));
    } else if (FOLDER_LOCATION_FINDING_SUMMARY.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_FINDING_SUMMARY.match(formattedString);
      return ofFolderLocationFindingSummaryName(
          matchMap.get("folder"), matchMap.get("location"), matchMap.get("finding_summary"));
    } else if (ORGANIZATION_LOCATION_FINDING_SUMMARY.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_FINDING_SUMMARY.match(formattedString);
      return ofOrganizationLocationFindingSummaryName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("finding_summary"));
    }
    throw new ValidationException("FindingSummaryName.parse: formattedString not in valid format");
  }

  public static List<FindingSummaryName> parseList(List<String> formattedStrings) {
    List<FindingSummaryName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FindingSummaryName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FindingSummaryName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_FINDING_SUMMARY.matches(formattedString)
        || FOLDER_LOCATION_FINDING_SUMMARY.matches(formattedString)
        || ORGANIZATION_LOCATION_FINDING_SUMMARY.matches(formattedString);
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
          if (findingSummary != null) {
            fieldMapBuilder.put("finding_summary", findingSummary);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
          }
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
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
    if (o != null && getClass() == o.getClass()) {
      FindingSummaryName that = ((FindingSummaryName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.findingSummary, that.findingSummary)
          && Objects.equals(this.folder, that.folder)
          && Objects.equals(this.organization, that.organization);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(findingSummary);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/findingSummaries/{finding_summary}. */
  public static class Builder {
    private String project;
    private String location;
    private String findingSummary;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getFindingSummary() {
      return findingSummary;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setFindingSummary(String findingSummary) {
      this.findingSummary = findingSummary;
      return this;
    }

    private Builder(FindingSummaryName findingSummaryName) {
      Preconditions.checkArgument(
          Objects.equals(findingSummaryName.pathTemplate, PROJECT_LOCATION_FINDING_SUMMARY),
          "toBuilder is only supported when FindingSummaryName has the pattern of"
              + " projects/{project}/locations/{location}/findingSummaries/{finding_summary}");
      this.project = findingSummaryName.project;
      this.location = findingSummaryName.location;
      this.findingSummary = findingSummaryName.findingSummary;
    }

    public FindingSummaryName build() {
      return new FindingSummaryName(this);
    }
  }

  /** Builder for folders/{folder}/locations/{location}/findingSummaries/{finding_summary}. */
  public static class FolderLocationFindingSummaryBuilder {
    private String folder;
    private String location;
    private String findingSummary;

    protected FolderLocationFindingSummaryBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getFindingSummary() {
      return findingSummary;
    }

    public FolderLocationFindingSummaryBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationFindingSummaryBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationFindingSummaryBuilder setFindingSummary(String findingSummary) {
      this.findingSummary = findingSummary;
      return this;
    }

    public FindingSummaryName build() {
      return new FindingSummaryName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/findingSummaries/{finding_summary}.
   */
  public static class OrganizationLocationFindingSummaryBuilder {
    private String organization;
    private String location;
    private String findingSummary;

    protected OrganizationLocationFindingSummaryBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getFindingSummary() {
      return findingSummary;
    }

    public OrganizationLocationFindingSummaryBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationFindingSummaryBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationFindingSummaryBuilder setFindingSummary(String findingSummary) {
      this.findingSummary = findingSummary;
      return this;
    }

    public FindingSummaryName build() {
      return new FindingSummaryName(this);
    }
  }
}
