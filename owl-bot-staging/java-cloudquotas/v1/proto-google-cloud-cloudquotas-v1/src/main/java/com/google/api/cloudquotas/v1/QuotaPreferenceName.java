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
public class QuotaPreferenceName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_QUOTA_PREFERENCE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/quotaPreferences/{quota_preference}");
  private static final PathTemplate FOLDER_LOCATION_QUOTA_PREFERENCE =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/quotaPreferences/{quota_preference}");
  private static final PathTemplate ORGANIZATION_LOCATION_QUOTA_PREFERENCE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/quotaPreferences/{quota_preference}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String quotaPreference;
  private final String folder;
  private final String organization;

  @Deprecated
  protected QuotaPreferenceName() {
    project = null;
    location = null;
    quotaPreference = null;
    folder = null;
    organization = null;
  }

  private QuotaPreferenceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    quotaPreference = Preconditions.checkNotNull(builder.getQuotaPreference());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION_QUOTA_PREFERENCE;
  }

  private QuotaPreferenceName(FolderLocationQuotaPreferenceBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    quotaPreference = Preconditions.checkNotNull(builder.getQuotaPreference());
    project = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION_QUOTA_PREFERENCE;
  }

  private QuotaPreferenceName(OrganizationLocationQuotaPreferenceBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    quotaPreference = Preconditions.checkNotNull(builder.getQuotaPreference());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_QUOTA_PREFERENCE;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getQuotaPreference() {
    return quotaPreference;
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

  public static Builder newProjectLocationQuotaPreferenceBuilder() {
    return new Builder();
  }

  public static FolderLocationQuotaPreferenceBuilder newFolderLocationQuotaPreferenceBuilder() {
    return new FolderLocationQuotaPreferenceBuilder();
  }

  public static OrganizationLocationQuotaPreferenceBuilder
      newOrganizationLocationQuotaPreferenceBuilder() {
    return new OrganizationLocationQuotaPreferenceBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static QuotaPreferenceName of(String project, String location, String quotaPreference) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setQuotaPreference(quotaPreference)
        .build();
  }

  public static QuotaPreferenceName ofProjectLocationQuotaPreferenceName(
      String project, String location, String quotaPreference) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setQuotaPreference(quotaPreference)
        .build();
  }

  public static QuotaPreferenceName ofFolderLocationQuotaPreferenceName(
      String folder, String location, String quotaPreference) {
    return newFolderLocationQuotaPreferenceBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setQuotaPreference(quotaPreference)
        .build();
  }

  public static QuotaPreferenceName ofOrganizationLocationQuotaPreferenceName(
      String organization, String location, String quotaPreference) {
    return newOrganizationLocationQuotaPreferenceBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setQuotaPreference(quotaPreference)
        .build();
  }

  public static String format(String project, String location, String quotaPreference) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setQuotaPreference(quotaPreference)
        .build()
        .toString();
  }

  public static String formatProjectLocationQuotaPreferenceName(
      String project, String location, String quotaPreference) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setQuotaPreference(quotaPreference)
        .build()
        .toString();
  }

  public static String formatFolderLocationQuotaPreferenceName(
      String folder, String location, String quotaPreference) {
    return newFolderLocationQuotaPreferenceBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setQuotaPreference(quotaPreference)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationQuotaPreferenceName(
      String organization, String location, String quotaPreference) {
    return newOrganizationLocationQuotaPreferenceBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setQuotaPreference(quotaPreference)
        .build()
        .toString();
  }

  public static QuotaPreferenceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_QUOTA_PREFERENCE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_QUOTA_PREFERENCE.match(formattedString);
      return ofProjectLocationQuotaPreferenceName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("quota_preference"));
    } else if (FOLDER_LOCATION_QUOTA_PREFERENCE.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_QUOTA_PREFERENCE.match(formattedString);
      return ofFolderLocationQuotaPreferenceName(
          matchMap.get("folder"), matchMap.get("location"), matchMap.get("quota_preference"));
    } else if (ORGANIZATION_LOCATION_QUOTA_PREFERENCE.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_QUOTA_PREFERENCE.match(formattedString);
      return ofOrganizationLocationQuotaPreferenceName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("quota_preference"));
    }
    throw new ValidationException("QuotaPreferenceName.parse: formattedString not in valid format");
  }

  public static List<QuotaPreferenceName> parseList(List<String> formattedStrings) {
    List<QuotaPreferenceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<QuotaPreferenceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (QuotaPreferenceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_QUOTA_PREFERENCE.matches(formattedString)
        || FOLDER_LOCATION_QUOTA_PREFERENCE.matches(formattedString)
        || ORGANIZATION_LOCATION_QUOTA_PREFERENCE.matches(formattedString);
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
          if (quotaPreference != null) {
            fieldMapBuilder.put("quota_preference", quotaPreference);
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
      QuotaPreferenceName that = ((QuotaPreferenceName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.quotaPreference, that.quotaPreference)
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
    h ^= Objects.hashCode(quotaPreference);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/quotaPreferences/{quota_preference}. */
  public static class Builder {
    private String project;
    private String location;
    private String quotaPreference;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getQuotaPreference() {
      return quotaPreference;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setQuotaPreference(String quotaPreference) {
      this.quotaPreference = quotaPreference;
      return this;
    }

    private Builder(QuotaPreferenceName quotaPreferenceName) {
      Preconditions.checkArgument(
          Objects.equals(quotaPreferenceName.pathTemplate, PROJECT_LOCATION_QUOTA_PREFERENCE),
          "toBuilder is only supported when QuotaPreferenceName has the pattern of projects/{project}/locations/{location}/quotaPreferences/{quota_preference}");
      this.project = quotaPreferenceName.project;
      this.location = quotaPreferenceName.location;
      this.quotaPreference = quotaPreferenceName.quotaPreference;
    }

    public QuotaPreferenceName build() {
      return new QuotaPreferenceName(this);
    }
  }

  /** Builder for folders/{folder}/locations/{location}/quotaPreferences/{quota_preference}. */
  public static class FolderLocationQuotaPreferenceBuilder {
    private String folder;
    private String location;
    private String quotaPreference;

    protected FolderLocationQuotaPreferenceBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getQuotaPreference() {
      return quotaPreference;
    }

    public FolderLocationQuotaPreferenceBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationQuotaPreferenceBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationQuotaPreferenceBuilder setQuotaPreference(String quotaPreference) {
      this.quotaPreference = quotaPreference;
      return this;
    }

    public QuotaPreferenceName build() {
      return new QuotaPreferenceName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/quotaPreferences/{quota_preference}.
   */
  public static class OrganizationLocationQuotaPreferenceBuilder {
    private String organization;
    private String location;
    private String quotaPreference;

    protected OrganizationLocationQuotaPreferenceBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getQuotaPreference() {
      return quotaPreference;
    }

    public OrganizationLocationQuotaPreferenceBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationQuotaPreferenceBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationQuotaPreferenceBuilder setQuotaPreference(String quotaPreference) {
      this.quotaPreference = quotaPreference;
      return this;
    }

    public QuotaPreferenceName build() {
      return new QuotaPreferenceName(this);
    }
  }
}
