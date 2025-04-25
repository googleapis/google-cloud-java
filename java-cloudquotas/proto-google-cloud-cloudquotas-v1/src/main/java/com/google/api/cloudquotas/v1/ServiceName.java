/*
 * Copyright 2025 Google LLC
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
public class ServiceName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SERVICE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/services/{service}");
  private static final PathTemplate FOLDER_LOCATION_SERVICE =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/services/{service}");
  private static final PathTemplate ORGANIZATION_LOCATION_SERVICE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/services/{service}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String service;
  private final String folder;
  private final String organization;

  @Deprecated
  protected ServiceName() {
    project = null;
    location = null;
    service = null;
    folder = null;
    organization = null;
  }

  private ServiceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    service = Preconditions.checkNotNull(builder.getService());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION_SERVICE;
  }

  private ServiceName(FolderLocationServiceBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    service = Preconditions.checkNotNull(builder.getService());
    project = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION_SERVICE;
  }

  private ServiceName(OrganizationLocationServiceBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    service = Preconditions.checkNotNull(builder.getService());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_SERVICE;
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

  public String getFolder() {
    return folder;
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationServiceBuilder() {
    return new Builder();
  }

  public static FolderLocationServiceBuilder newFolderLocationServiceBuilder() {
    return new FolderLocationServiceBuilder();
  }

  public static OrganizationLocationServiceBuilder newOrganizationLocationServiceBuilder() {
    return new OrganizationLocationServiceBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ServiceName of(String project, String location, String service) {
    return newBuilder().setProject(project).setLocation(location).setService(service).build();
  }

  public static ServiceName ofProjectLocationServiceName(
      String project, String location, String service) {
    return newBuilder().setProject(project).setLocation(location).setService(service).build();
  }

  public static ServiceName ofFolderLocationServiceName(
      String folder, String location, String service) {
    return newFolderLocationServiceBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setService(service)
        .build();
  }

  public static ServiceName ofOrganizationLocationServiceName(
      String organization, String location, String service) {
    return newOrganizationLocationServiceBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setService(service)
        .build();
  }

  public static String format(String project, String location, String service) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setService(service)
        .build()
        .toString();
  }

  public static String formatProjectLocationServiceName(
      String project, String location, String service) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setService(service)
        .build()
        .toString();
  }

  public static String formatFolderLocationServiceName(
      String folder, String location, String service) {
    return newFolderLocationServiceBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setService(service)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationServiceName(
      String organization, String location, String service) {
    return newOrganizationLocationServiceBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setService(service)
        .build()
        .toString();
  }

  public static ServiceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_SERVICE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_SERVICE.match(formattedString);
      return ofProjectLocationServiceName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("service"));
    } else if (FOLDER_LOCATION_SERVICE.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_SERVICE.match(formattedString);
      return ofFolderLocationServiceName(
          matchMap.get("folder"), matchMap.get("location"), matchMap.get("service"));
    } else if (ORGANIZATION_LOCATION_SERVICE.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_SERVICE.match(formattedString);
      return ofOrganizationLocationServiceName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("service"));
    }
    throw new ValidationException("ServiceName.parse: formattedString not in valid format");
  }

  public static List<ServiceName> parseList(List<String> formattedStrings) {
    List<ServiceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ServiceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ServiceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SERVICE.matches(formattedString)
        || FOLDER_LOCATION_SERVICE.matches(formattedString)
        || ORGANIZATION_LOCATION_SERVICE.matches(formattedString);
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
      ServiceName that = ((ServiceName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.service, that.service)
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
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/services/{service}. */
  public static class Builder {
    private String project;
    private String location;
    private String service;

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

    private Builder(ServiceName serviceName) {
      Preconditions.checkArgument(
          Objects.equals(serviceName.pathTemplate, PROJECT_LOCATION_SERVICE),
          "toBuilder is only supported when ServiceName has the pattern of projects/{project}/locations/{location}/services/{service}");
      this.project = serviceName.project;
      this.location = serviceName.location;
      this.service = serviceName.service;
    }

    public ServiceName build() {
      return new ServiceName(this);
    }
  }

  /** Builder for folders/{folder}/locations/{location}/services/{service}. */
  public static class FolderLocationServiceBuilder {
    private String folder;
    private String location;
    private String service;

    protected FolderLocationServiceBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getService() {
      return service;
    }

    public FolderLocationServiceBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationServiceBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationServiceBuilder setService(String service) {
      this.service = service;
      return this;
    }

    public ServiceName build() {
      return new ServiceName(this);
    }
  }

  /** Builder for organizations/{organization}/locations/{location}/services/{service}. */
  public static class OrganizationLocationServiceBuilder {
    private String organization;
    private String location;
    private String service;

    protected OrganizationLocationServiceBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getService() {
      return service;
    }

    public OrganizationLocationServiceBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationServiceBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationServiceBuilder setService(String service) {
      this.service = service;
      return this;
    }

    public ServiceName build() {
      return new ServiceName(this);
    }
  }
}
