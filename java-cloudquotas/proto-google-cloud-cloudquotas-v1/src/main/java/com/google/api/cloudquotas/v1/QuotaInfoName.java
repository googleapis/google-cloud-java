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
public class QuotaInfoName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SERVICE_QUOTA_INFO =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/services/{service}/quotaInfos/{quota_info}");
  private static final PathTemplate FOLDER_LOCATION_SERVICE_QUOTA_INFO =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/services/{service}/quotaInfos/{quota_info}");
  private static final PathTemplate ORGANIZATION_LOCATION_SERVICE_QUOTA_INFO =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/services/{service}/quotaInfos/{quota_info}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String service;
  private final String quotaInfo;
  private final String folder;
  private final String organization;

  @Deprecated
  protected QuotaInfoName() {
    project = null;
    location = null;
    service = null;
    quotaInfo = null;
    folder = null;
    organization = null;
  }

  private QuotaInfoName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    service = Preconditions.checkNotNull(builder.getService());
    quotaInfo = Preconditions.checkNotNull(builder.getQuotaInfo());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION_SERVICE_QUOTA_INFO;
  }

  private QuotaInfoName(FolderLocationServiceQuotaInfoBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    service = Preconditions.checkNotNull(builder.getService());
    quotaInfo = Preconditions.checkNotNull(builder.getQuotaInfo());
    project = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION_SERVICE_QUOTA_INFO;
  }

  private QuotaInfoName(OrganizationLocationServiceQuotaInfoBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    service = Preconditions.checkNotNull(builder.getService());
    quotaInfo = Preconditions.checkNotNull(builder.getQuotaInfo());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_SERVICE_QUOTA_INFO;
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

  public String getQuotaInfo() {
    return quotaInfo;
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
  public static Builder newProjectLocationServiceQuotaInfoBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderLocationServiceQuotaInfoBuilder newFolderLocationServiceQuotaInfoBuilder() {
    return new FolderLocationServiceQuotaInfoBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationLocationServiceQuotaInfoBuilder
      newOrganizationLocationServiceQuotaInfoBuilder() {
    return new OrganizationLocationServiceQuotaInfoBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static QuotaInfoName of(
      String project, String location, String service, String quotaInfo) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setService(service)
        .setQuotaInfo(quotaInfo)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static QuotaInfoName ofProjectLocationServiceQuotaInfoName(
      String project, String location, String service, String quotaInfo) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setService(service)
        .setQuotaInfo(quotaInfo)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static QuotaInfoName ofFolderLocationServiceQuotaInfoName(
      String folder, String location, String service, String quotaInfo) {
    return newFolderLocationServiceQuotaInfoBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setService(service)
        .setQuotaInfo(quotaInfo)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static QuotaInfoName ofOrganizationLocationServiceQuotaInfoName(
      String organization, String location, String service, String quotaInfo) {
    return newOrganizationLocationServiceQuotaInfoBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setService(service)
        .setQuotaInfo(quotaInfo)
        .build();
  }

  public static String format(String project, String location, String service, String quotaInfo) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setService(service)
        .setQuotaInfo(quotaInfo)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationServiceQuotaInfoName(
      String project, String location, String service, String quotaInfo) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setService(service)
        .setQuotaInfo(quotaInfo)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderLocationServiceQuotaInfoName(
      String folder, String location, String service, String quotaInfo) {
    return newFolderLocationServiceQuotaInfoBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setService(service)
        .setQuotaInfo(quotaInfo)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationServiceQuotaInfoName(
      String organization, String location, String service, String quotaInfo) {
    return newOrganizationLocationServiceQuotaInfoBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setService(service)
        .setQuotaInfo(quotaInfo)
        .build()
        .toString();
  }

  public static QuotaInfoName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_SERVICE_QUOTA_INFO.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_SERVICE_QUOTA_INFO.match(formattedString);
      return ofProjectLocationServiceQuotaInfoName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("service"),
          matchMap.get("quota_info"));
    } else if (FOLDER_LOCATION_SERVICE_QUOTA_INFO.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_SERVICE_QUOTA_INFO.match(formattedString);
      return ofFolderLocationServiceQuotaInfoName(
          matchMap.get("folder"),
          matchMap.get("location"),
          matchMap.get("service"),
          matchMap.get("quota_info"));
    } else if (ORGANIZATION_LOCATION_SERVICE_QUOTA_INFO.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_SERVICE_QUOTA_INFO.match(formattedString);
      return ofOrganizationLocationServiceQuotaInfoName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("service"),
          matchMap.get("quota_info"));
    }
    throw new ValidationException("QuotaInfoName.parse: formattedString not in valid format");
  }

  public static List<QuotaInfoName> parseList(List<String> formattedStrings) {
    List<QuotaInfoName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<QuotaInfoName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (QuotaInfoName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SERVICE_QUOTA_INFO.matches(formattedString)
        || FOLDER_LOCATION_SERVICE_QUOTA_INFO.matches(formattedString)
        || ORGANIZATION_LOCATION_SERVICE_QUOTA_INFO.matches(formattedString);
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
          if (quotaInfo != null) {
            fieldMapBuilder.put("quota_info", quotaInfo);
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
      QuotaInfoName that = ((QuotaInfoName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.service, that.service)
          && Objects.equals(this.quotaInfo, that.quotaInfo)
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
    h ^= Objects.hashCode(service);
    h *= 1000003;
    h ^= Objects.hashCode(quotaInfo);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/services/{service}/quotaInfos/{quota_info}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String service;
    private String quotaInfo;

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

    public String getQuotaInfo() {
      return quotaInfo;
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

    public Builder setQuotaInfo(String quotaInfo) {
      this.quotaInfo = quotaInfo;
      return this;
    }

    private Builder(QuotaInfoName quotaInfoName) {
      Preconditions.checkArgument(
          Objects.equals(quotaInfoName.pathTemplate, PROJECT_LOCATION_SERVICE_QUOTA_INFO),
          "toBuilder is only supported when QuotaInfoName has the pattern of projects/{project}/locations/{location}/services/{service}/quotaInfos/{quota_info}");
      this.project = quotaInfoName.project;
      this.location = quotaInfoName.location;
      this.service = quotaInfoName.service;
      this.quotaInfo = quotaInfoName.quotaInfo;
    }

    public QuotaInfoName build() {
      return new QuotaInfoName(this);
    }
  }

  /**
   * Builder for folders/{folder}/locations/{location}/services/{service}/quotaInfos/{quota_info}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderLocationServiceQuotaInfoBuilder {
    private String folder;
    private String location;
    private String service;
    private String quotaInfo;

    protected FolderLocationServiceQuotaInfoBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getService() {
      return service;
    }

    public String getQuotaInfo() {
      return quotaInfo;
    }

    public FolderLocationServiceQuotaInfoBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationServiceQuotaInfoBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationServiceQuotaInfoBuilder setService(String service) {
      this.service = service;
      return this;
    }

    public FolderLocationServiceQuotaInfoBuilder setQuotaInfo(String quotaInfo) {
      this.quotaInfo = quotaInfo;
      return this;
    }

    public QuotaInfoName build() {
      return new QuotaInfoName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/services/{service}/quotaInfos/{quota_info}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationLocationServiceQuotaInfoBuilder {
    private String organization;
    private String location;
    private String service;
    private String quotaInfo;

    protected OrganizationLocationServiceQuotaInfoBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getService() {
      return service;
    }

    public String getQuotaInfo() {
      return quotaInfo;
    }

    public OrganizationLocationServiceQuotaInfoBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationServiceQuotaInfoBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationServiceQuotaInfoBuilder setService(String service) {
      this.service = service;
      return this;
    }

    public OrganizationLocationServiceQuotaInfoBuilder setQuotaInfo(String quotaInfo) {
      this.quotaInfo = quotaInfo;
      return this;
    }

    public QuotaInfoName build() {
      return new QuotaInfoName(this);
    }
  }
}
