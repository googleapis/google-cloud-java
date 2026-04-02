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

package com.google.cloud.auditmanager.v1;

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
public class StandardName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_STANDARD =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/standards/{standard}");
  private static final PathTemplate FOLDER_LOCATION_STANDARD =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/standards/{standard}");
  private static final PathTemplate ORGANIZATION_LOCATION_STANDARD =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/standards/{standard}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String standard;
  private final String folder;
  private final String organization;

  @Deprecated
  protected StandardName() {
    project = null;
    location = null;
    standard = null;
    folder = null;
    organization = null;
  }

  private StandardName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    standard = Preconditions.checkNotNull(builder.getStandard());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION_STANDARD;
  }

  private StandardName(FolderLocationStandardBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    standard = Preconditions.checkNotNull(builder.getStandard());
    project = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION_STANDARD;
  }

  private StandardName(OrganizationLocationStandardBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    standard = Preconditions.checkNotNull(builder.getStandard());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_STANDARD;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getStandard() {
    return standard;
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

  public static Builder newProjectLocationStandardBuilder() {
    return new Builder();
  }

  public static FolderLocationStandardBuilder newFolderLocationStandardBuilder() {
    return new FolderLocationStandardBuilder();
  }

  public static OrganizationLocationStandardBuilder newOrganizationLocationStandardBuilder() {
    return new OrganizationLocationStandardBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static StandardName of(String project, String location, String standard) {
    return newBuilder().setProject(project).setLocation(location).setStandard(standard).build();
  }

  public static StandardName ofProjectLocationStandardName(
      String project, String location, String standard) {
    return newBuilder().setProject(project).setLocation(location).setStandard(standard).build();
  }

  public static StandardName ofFolderLocationStandardName(
      String folder, String location, String standard) {
    return newFolderLocationStandardBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setStandard(standard)
        .build();
  }

  public static StandardName ofOrganizationLocationStandardName(
      String organization, String location, String standard) {
    return newOrganizationLocationStandardBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setStandard(standard)
        .build();
  }

  public static String format(String project, String location, String standard) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setStandard(standard)
        .build()
        .toString();
  }

  public static String formatProjectLocationStandardName(
      String project, String location, String standard) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setStandard(standard)
        .build()
        .toString();
  }

  public static String formatFolderLocationStandardName(
      String folder, String location, String standard) {
    return newFolderLocationStandardBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setStandard(standard)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationStandardName(
      String organization, String location, String standard) {
    return newOrganizationLocationStandardBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setStandard(standard)
        .build()
        .toString();
  }

  public static StandardName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_STANDARD.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_STANDARD.match(formattedString);
      return ofProjectLocationStandardName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("standard"));
    } else if (FOLDER_LOCATION_STANDARD.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_STANDARD.match(formattedString);
      return ofFolderLocationStandardName(
          matchMap.get("folder"), matchMap.get("location"), matchMap.get("standard"));
    } else if (ORGANIZATION_LOCATION_STANDARD.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_STANDARD.match(formattedString);
      return ofOrganizationLocationStandardName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("standard"));
    }
    throw new ValidationException("StandardName.parse: formattedString not in valid format");
  }

  public static List<StandardName> parseList(List<String> formattedStrings) {
    List<StandardName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<StandardName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (StandardName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_STANDARD.matches(formattedString)
        || FOLDER_LOCATION_STANDARD.matches(formattedString)
        || ORGANIZATION_LOCATION_STANDARD.matches(formattedString);
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
          if (standard != null) {
            fieldMapBuilder.put("standard", standard);
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
      StandardName that = ((StandardName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.standard, that.standard)
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
    h ^= Objects.hashCode(standard);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/standards/{standard}. */
  public static class Builder {
    private String project;
    private String location;
    private String standard;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getStandard() {
      return standard;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setStandard(String standard) {
      this.standard = standard;
      return this;
    }

    private Builder(StandardName standardName) {
      Preconditions.checkArgument(
          Objects.equals(standardName.pathTemplate, PROJECT_LOCATION_STANDARD),
          "toBuilder is only supported when StandardName has the pattern of"
              + " projects/{project}/locations/{location}/standards/{standard}");
      this.project = standardName.project;
      this.location = standardName.location;
      this.standard = standardName.standard;
    }

    public StandardName build() {
      return new StandardName(this);
    }
  }

  /** Builder for folders/{folder}/locations/{location}/standards/{standard}. */
  public static class FolderLocationStandardBuilder {
    private String folder;
    private String location;
    private String standard;

    protected FolderLocationStandardBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getStandard() {
      return standard;
    }

    public FolderLocationStandardBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationStandardBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationStandardBuilder setStandard(String standard) {
      this.standard = standard;
      return this;
    }

    public StandardName build() {
      return new StandardName(this);
    }
  }

  /** Builder for organizations/{organization}/locations/{location}/standards/{standard}. */
  public static class OrganizationLocationStandardBuilder {
    private String organization;
    private String location;
    private String standard;

    protected OrganizationLocationStandardBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getStandard() {
      return standard;
    }

    public OrganizationLocationStandardBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationStandardBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationStandardBuilder setStandard(String standard) {
      this.standard = standard;
      return this;
    }

    public StandardName build() {
      return new StandardName(this);
    }
  }
}
