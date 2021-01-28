/*
 * Copyright 2020 Google LLC
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

package com.google.monitoring.v3;

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
public class ServiceName implements ResourceName {
  private static final PathTemplate PROJECT_SERVICE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/services/{service}");
  private static final PathTemplate ORGANIZATION_SERVICE =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/services/{service}");
  private static final PathTemplate FOLDER_SERVICE =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/services/{service}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String service;
  private final String organization;
  private final String folder;

  @Deprecated
  protected ServiceName() {
    project = null;
    service = null;
    organization = null;
    folder = null;
  }

  private ServiceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    service = Preconditions.checkNotNull(builder.getService());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_SERVICE;
  }

  private ServiceName(OrganizationServiceBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    service = Preconditions.checkNotNull(builder.getService());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_SERVICE;
  }

  private ServiceName(FolderServiceBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    service = Preconditions.checkNotNull(builder.getService());
    project = null;
    organization = null;
    pathTemplate = FOLDER_SERVICE;
  }

  public String getProject() {
    return project;
  }

  public String getService() {
    return service;
  }

  public String getOrganization() {
    return organization;
  }

  public String getFolder() {
    return folder;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectServiceBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationServiceBuilder newOrganizationServiceBuilder() {
    return new OrganizationServiceBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderServiceBuilder newFolderServiceBuilder() {
    return new FolderServiceBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ServiceName of(String project, String service) {
    return newBuilder().setProject(project).setService(service).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ServiceName ofProjectServiceName(String project, String service) {
    return newBuilder().setProject(project).setService(service).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ServiceName ofOrganizationServiceName(String organization, String service) {
    return newOrganizationServiceBuilder()
        .setOrganization(organization)
        .setService(service)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ServiceName ofFolderServiceName(String folder, String service) {
    return newFolderServiceBuilder().setFolder(folder).setService(service).build();
  }

  public static String format(String project, String service) {
    return newBuilder().setProject(project).setService(service).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectServiceName(String project, String service) {
    return newBuilder().setProject(project).setService(service).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationServiceName(String organization, String service) {
    return newOrganizationServiceBuilder()
        .setOrganization(organization)
        .setService(service)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderServiceName(String folder, String service) {
    return newFolderServiceBuilder().setFolder(folder).setService(service).build().toString();
  }

  public static ServiceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_SERVICE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_SERVICE.match(formattedString);
      return ofProjectServiceName(matchMap.get("project"), matchMap.get("service"));
    } else if (ORGANIZATION_SERVICE.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_SERVICE.match(formattedString);
      return ofOrganizationServiceName(matchMap.get("organization"), matchMap.get("service"));
    } else if (FOLDER_SERVICE.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_SERVICE.match(formattedString);
      return ofFolderServiceName(matchMap.get("folder"), matchMap.get("service"));
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
    return PROJECT_SERVICE.matches(formattedString)
        || ORGANIZATION_SERVICE.matches(formattedString)
        || FOLDER_SERVICE.matches(formattedString);
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
          if (service != null) {
            fieldMapBuilder.put("service", service);
          }
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
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
      ServiceName that = ((ServiceName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.service, that.service)
          && Objects.equals(this.organization, that.organization)
          && Objects.equals(this.folder, that.folder);
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
    h ^= Objects.hashCode(service);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    return h;
  }

  /** Builder for projects/{project}/services/{service}. */
  public static class Builder {
    private String project;
    private String service;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getService() {
      return service;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setService(String service) {
      this.service = service;
      return this;
    }

    private Builder(ServiceName serviceName) {
      Preconditions.checkArgument(
          Objects.equals(serviceName.pathTemplate, PROJECT_SERVICE),
          "toBuilder is only supported when ServiceName has the pattern of projects/{project}/services/{service}");
      project = serviceName.project;
      service = serviceName.service;
    }

    public ServiceName build() {
      return new ServiceName(this);
    }
  }

  /** Builder for organizations/{organization}/services/{service}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationServiceBuilder {
    private String organization;
    private String service;

    protected OrganizationServiceBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getService() {
      return service;
    }

    public OrganizationServiceBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationServiceBuilder setService(String service) {
      this.service = service;
      return this;
    }

    public ServiceName build() {
      return new ServiceName(this);
    }
  }

  /** Builder for folders/{folder}/services/{service}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderServiceBuilder {
    private String folder;
    private String service;

    protected FolderServiceBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getService() {
      return service;
    }

    public FolderServiceBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderServiceBuilder setService(String service) {
      this.service = service;
      return this;
    }

    public ServiceName build() {
      return new ServiceName(this);
    }
  }
}
