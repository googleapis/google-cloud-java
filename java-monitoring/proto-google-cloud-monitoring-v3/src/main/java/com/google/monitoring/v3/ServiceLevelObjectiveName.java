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
public class ServiceLevelObjectiveName implements ResourceName {
  private static final PathTemplate PROJECT_SERVICE_SERVICE_LEVEL_OBJECTIVE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/services/{service}/serviceLevelObjectives/{service_level_objective}");
  private static final PathTemplate ORGANIZATION_SERVICE_SERVICE_LEVEL_OBJECTIVE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/services/{service}/serviceLevelObjectives/{service_level_objective}");
  private static final PathTemplate FOLDER_SERVICE_SERVICE_LEVEL_OBJECTIVE =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/services/{service}/serviceLevelObjectives/{service_level_objective}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String service;
  private final String serviceLevelObjective;
  private final String organization;
  private final String folder;

  @Deprecated
  protected ServiceLevelObjectiveName() {
    project = null;
    service = null;
    serviceLevelObjective = null;
    organization = null;
    folder = null;
  }

  private ServiceLevelObjectiveName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    service = Preconditions.checkNotNull(builder.getService());
    serviceLevelObjective = Preconditions.checkNotNull(builder.getServiceLevelObjective());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_SERVICE_SERVICE_LEVEL_OBJECTIVE;
  }

  private ServiceLevelObjectiveName(OrganizationServiceServiceLevelObjectiveBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    service = Preconditions.checkNotNull(builder.getService());
    serviceLevelObjective = Preconditions.checkNotNull(builder.getServiceLevelObjective());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_SERVICE_SERVICE_LEVEL_OBJECTIVE;
  }

  private ServiceLevelObjectiveName(FolderServiceServiceLevelObjectiveBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    service = Preconditions.checkNotNull(builder.getService());
    serviceLevelObjective = Preconditions.checkNotNull(builder.getServiceLevelObjective());
    project = null;
    organization = null;
    pathTemplate = FOLDER_SERVICE_SERVICE_LEVEL_OBJECTIVE;
  }

  public String getProject() {
    return project;
  }

  public String getService() {
    return service;
  }

  public String getServiceLevelObjective() {
    return serviceLevelObjective;
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
  public static Builder newProjectServiceServiceLevelObjectiveBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationServiceServiceLevelObjectiveBuilder
      newOrganizationServiceServiceLevelObjectiveBuilder() {
    return new OrganizationServiceServiceLevelObjectiveBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderServiceServiceLevelObjectiveBuilder
      newFolderServiceServiceLevelObjectiveBuilder() {
    return new FolderServiceServiceLevelObjectiveBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ServiceLevelObjectiveName of(
      String project, String service, String serviceLevelObjective) {
    return newBuilder()
        .setProject(project)
        .setService(service)
        .setServiceLevelObjective(serviceLevelObjective)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ServiceLevelObjectiveName ofProjectServiceServiceLevelObjectiveName(
      String project, String service, String serviceLevelObjective) {
    return newBuilder()
        .setProject(project)
        .setService(service)
        .setServiceLevelObjective(serviceLevelObjective)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ServiceLevelObjectiveName ofOrganizationServiceServiceLevelObjectiveName(
      String organization, String service, String serviceLevelObjective) {
    return newOrganizationServiceServiceLevelObjectiveBuilder()
        .setOrganization(organization)
        .setService(service)
        .setServiceLevelObjective(serviceLevelObjective)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ServiceLevelObjectiveName ofFolderServiceServiceLevelObjectiveName(
      String folder, String service, String serviceLevelObjective) {
    return newFolderServiceServiceLevelObjectiveBuilder()
        .setFolder(folder)
        .setService(service)
        .setServiceLevelObjective(serviceLevelObjective)
        .build();
  }

  public static String format(String project, String service, String serviceLevelObjective) {
    return newBuilder()
        .setProject(project)
        .setService(service)
        .setServiceLevelObjective(serviceLevelObjective)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectServiceServiceLevelObjectiveName(
      String project, String service, String serviceLevelObjective) {
    return newBuilder()
        .setProject(project)
        .setService(service)
        .setServiceLevelObjective(serviceLevelObjective)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationServiceServiceLevelObjectiveName(
      String organization, String service, String serviceLevelObjective) {
    return newOrganizationServiceServiceLevelObjectiveBuilder()
        .setOrganization(organization)
        .setService(service)
        .setServiceLevelObjective(serviceLevelObjective)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderServiceServiceLevelObjectiveName(
      String folder, String service, String serviceLevelObjective) {
    return newFolderServiceServiceLevelObjectiveBuilder()
        .setFolder(folder)
        .setService(service)
        .setServiceLevelObjective(serviceLevelObjective)
        .build()
        .toString();
  }

  public static ServiceLevelObjectiveName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_SERVICE_SERVICE_LEVEL_OBJECTIVE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_SERVICE_SERVICE_LEVEL_OBJECTIVE.match(formattedString);
      return ofProjectServiceServiceLevelObjectiveName(
          matchMap.get("project"),
          matchMap.get("service"),
          matchMap.get("service_level_objective"));
    } else if (ORGANIZATION_SERVICE_SERVICE_LEVEL_OBJECTIVE.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_SERVICE_SERVICE_LEVEL_OBJECTIVE.match(formattedString);
      return ofOrganizationServiceServiceLevelObjectiveName(
          matchMap.get("organization"),
          matchMap.get("service"),
          matchMap.get("service_level_objective"));
    } else if (FOLDER_SERVICE_SERVICE_LEVEL_OBJECTIVE.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_SERVICE_SERVICE_LEVEL_OBJECTIVE.match(formattedString);
      return ofFolderServiceServiceLevelObjectiveName(
          matchMap.get("folder"), matchMap.get("service"), matchMap.get("service_level_objective"));
    }
    throw new ValidationException(
        "ServiceLevelObjectiveName.parse: formattedString not in valid format");
  }

  public static List<ServiceLevelObjectiveName> parseList(List<String> formattedStrings) {
    List<ServiceLevelObjectiveName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ServiceLevelObjectiveName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ServiceLevelObjectiveName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_SERVICE_SERVICE_LEVEL_OBJECTIVE.matches(formattedString)
        || ORGANIZATION_SERVICE_SERVICE_LEVEL_OBJECTIVE.matches(formattedString)
        || FOLDER_SERVICE_SERVICE_LEVEL_OBJECTIVE.matches(formattedString);
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
          if (serviceLevelObjective != null) {
            fieldMapBuilder.put("service_level_objective", serviceLevelObjective);
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
      ServiceLevelObjectiveName that = ((ServiceLevelObjectiveName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.service, that.service)
          && Objects.equals(this.serviceLevelObjective, that.serviceLevelObjective)
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
    h ^= Objects.hashCode(serviceLevelObjective);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/services/{service}/serviceLevelObjectives/{service_level_objective}.
   */
  public static class Builder {
    private String project;
    private String service;
    private String serviceLevelObjective;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getService() {
      return service;
    }

    public String getServiceLevelObjective() {
      return serviceLevelObjective;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setService(String service) {
      this.service = service;
      return this;
    }

    public Builder setServiceLevelObjective(String serviceLevelObjective) {
      this.serviceLevelObjective = serviceLevelObjective;
      return this;
    }

    private Builder(ServiceLevelObjectiveName serviceLevelObjectiveName) {
      Preconditions.checkArgument(
          Objects.equals(
              serviceLevelObjectiveName.pathTemplate, PROJECT_SERVICE_SERVICE_LEVEL_OBJECTIVE),
          "toBuilder is only supported when ServiceLevelObjectiveName has the pattern of projects/{project}/services/{service}/serviceLevelObjectives/{service_level_objective}");
      project = serviceLevelObjectiveName.project;
      service = serviceLevelObjectiveName.service;
      serviceLevelObjective = serviceLevelObjectiveName.serviceLevelObjective;
    }

    public ServiceLevelObjectiveName build() {
      return new ServiceLevelObjectiveName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/services/{service}/serviceLevelObjectives/{service_level_objective}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationServiceServiceLevelObjectiveBuilder {
    private String organization;
    private String service;
    private String serviceLevelObjective;

    protected OrganizationServiceServiceLevelObjectiveBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getService() {
      return service;
    }

    public String getServiceLevelObjective() {
      return serviceLevelObjective;
    }

    public OrganizationServiceServiceLevelObjectiveBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationServiceServiceLevelObjectiveBuilder setService(String service) {
      this.service = service;
      return this;
    }

    public OrganizationServiceServiceLevelObjectiveBuilder setServiceLevelObjective(
        String serviceLevelObjective) {
      this.serviceLevelObjective = serviceLevelObjective;
      return this;
    }

    public ServiceLevelObjectiveName build() {
      return new ServiceLevelObjectiveName(this);
    }
  }

  /**
   * Builder for
   * folders/{folder}/services/{service}/serviceLevelObjectives/{service_level_objective}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderServiceServiceLevelObjectiveBuilder {
    private String folder;
    private String service;
    private String serviceLevelObjective;

    protected FolderServiceServiceLevelObjectiveBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getService() {
      return service;
    }

    public String getServiceLevelObjective() {
      return serviceLevelObjective;
    }

    public FolderServiceServiceLevelObjectiveBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderServiceServiceLevelObjectiveBuilder setService(String service) {
      this.service = service;
      return this;
    }

    public FolderServiceServiceLevelObjectiveBuilder setServiceLevelObjective(
        String serviceLevelObjective) {
      this.serviceLevelObjective = serviceLevelObjective;
      return this;
    }

    public ServiceLevelObjectiveName build() {
      return new ServiceLevelObjectiveName(this);
    }
  }
}
