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

package com.google.api.cloudquotas.v1;

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
public class LocationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}");
  private static final PathTemplate FOLDER_LOCATION =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/locations/{location}");
  private static final PathTemplate ORGANIZATION_LOCATION =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/locations/{location}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String folder;
  private final String organization;

  @Deprecated
  protected LocationName() {
    project = null;
    location = null;
    folder = null;
    organization = null;
  }

  private LocationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION;
  }

  private LocationName(FolderLocationBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    project = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION;
  }

  private LocationName(OrganizationLocationBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
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

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectLocationBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderLocationBuilder newFolderLocationBuilder() {
    return new FolderLocationBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationLocationBuilder newOrganizationLocationBuilder() {
    return new OrganizationLocationBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LocationName of(String project, String location) {
    return newBuilder().setProject(project).setLocation(location).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static LocationName ofProjectLocationName(String project, String location) {
    return newBuilder().setProject(project).setLocation(location).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static LocationName ofFolderLocationName(String folder, String location) {
    return newFolderLocationBuilder().setFolder(folder).setLocation(location).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static LocationName ofOrganizationLocationName(String organization, String location) {
    return newOrganizationLocationBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .build();
  }

  public static String format(String project, String location) {
    return newBuilder().setProject(project).setLocation(location).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationName(String project, String location) {
    return newBuilder().setProject(project).setLocation(location).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderLocationName(String folder, String location) {
    return newFolderLocationBuilder().setFolder(folder).setLocation(location).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationName(String organization, String location) {
    return newOrganizationLocationBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .build()
        .toString();
  }

  public static LocationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION.match(formattedString);
      return ofProjectLocationName(matchMap.get("project"), matchMap.get("location"));
    } else if (FOLDER_LOCATION.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION.match(formattedString);
      return ofFolderLocationName(matchMap.get("folder"), matchMap.get("location"));
    } else if (ORGANIZATION_LOCATION.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION.match(formattedString);
      return ofOrganizationLocationName(matchMap.get("organization"), matchMap.get("location"));
    }
    throw new ValidationException("LocationName.parse: formattedString not in valid format");
  }

  public static List<LocationName> parseList(List<String> formattedStrings) {
    List<LocationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LocationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LocationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION.matches(formattedString)
        || FOLDER_LOCATION.matches(formattedString)
        || ORGANIZATION_LOCATION.matches(formattedString);
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
      LocationName that = ((LocationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
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
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}. */
  public static class Builder {
    private String project;
    private String location;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    private Builder(LocationName locationName) {
      Preconditions.checkArgument(
          Objects.equals(locationName.pathTemplate, PROJECT_LOCATION),
          "toBuilder is only supported when LocationName has the pattern of projects/{project}/locations/{location}");
      this.project = locationName.project;
      this.location = locationName.location;
    }

    public LocationName build() {
      return new LocationName(this);
    }
  }

  /** Builder for folders/{folder}/locations/{location}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderLocationBuilder {
    private String folder;
    private String location;

    protected FolderLocationBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public FolderLocationBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public LocationName build() {
      return new LocationName(this);
    }
  }

  /** Builder for organizations/{organization}/locations/{location}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationLocationBuilder {
    private String organization;
    private String location;

    protected OrganizationLocationBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public OrganizationLocationBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public LocationName build() {
      return new LocationName(this);
    }
  }
}
