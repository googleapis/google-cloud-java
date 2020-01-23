/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.monitoring.v3;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ServiceLevelObjectiveName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/services/{service}/serviceLevelObjectives/{service_level_objective}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String service;
  private final String serviceLevelObjective;

  public String getProject() {
    return project;
  }

  public String getService() {
    return service;
  }

  public String getServiceLevelObjective() {
    return serviceLevelObjective;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ServiceLevelObjectiveName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    service = Preconditions.checkNotNull(builder.getService());
    serviceLevelObjective = Preconditions.checkNotNull(builder.getServiceLevelObjective());
  }

  public static ServiceLevelObjectiveName of(
      String project, String service, String serviceLevelObjective) {
    return newBuilder()
        .setProject(project)
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

  public static ServiceLevelObjectiveName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString,
            "ServiceLevelObjectiveName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"), matchMap.get("service"), matchMap.get("service_level_objective"));
  }

  public static List<ServiceLevelObjectiveName> parseList(List<String> formattedStrings) {
    List<ServiceLevelObjectiveName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ServiceLevelObjectiveName> values) {
    List<String> list = new ArrayList<String>(values.size());
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
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("service", service);
          fieldMapBuilder.put("serviceLevelObjective", serviceLevelObjective);
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
    return PATH_TEMPLATE.instantiate(
        "project", project, "service", service, "service_level_objective", serviceLevelObjective);
  }

  /** Builder for ServiceLevelObjectiveName. */
  public static class Builder {

    private String project;
    private String service;
    private String serviceLevelObjective;

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

    private Builder() {}

    private Builder(ServiceLevelObjectiveName serviceLevelObjectiveName) {
      project = serviceLevelObjectiveName.project;
      service = serviceLevelObjectiveName.service;
      serviceLevelObjective = serviceLevelObjectiveName.serviceLevelObjective;
    }

    public ServiceLevelObjectiveName build() {
      return new ServiceLevelObjectiveName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ServiceLevelObjectiveName) {
      ServiceLevelObjectiveName that = (ServiceLevelObjectiveName) o;
      return (this.project.equals(that.project))
          && (this.service.equals(that.service))
          && (this.serviceLevelObjective.equals(that.serviceLevelObjective));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= service.hashCode();
    h *= 1000003;
    h ^= serviceLevelObjective.hashCode();
    return h;
  }
}
