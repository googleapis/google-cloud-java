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

package com.google.cloud.servicedirectory.v1beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ServiceName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/namespaces/{namespace}/services/{service}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String namespace;
  private final String service;

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getNamespace() {
    return namespace;
  }

  public String getService() {
    return service;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ServiceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    namespace = Preconditions.checkNotNull(builder.getNamespace());
    service = Preconditions.checkNotNull(builder.getService());
  }

  public static ServiceName of(String project, String location, String namespace, String service) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setNamespace(namespace)
        .setService(service)
        .build();
  }

  public static String format(String project, String location, String namespace, String service) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setNamespace(namespace)
        .setService(service)
        .build()
        .toString();
  }

  public static ServiceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "ServiceName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("namespace"),
        matchMap.get("service"));
  }

  public static List<ServiceName> parseList(List<String> formattedStrings) {
    List<ServiceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ServiceName> values) {
    List<String> list = new ArrayList<String>(values.size());
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
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("location", location);
          fieldMapBuilder.put("namespace", namespace);
          fieldMapBuilder.put("service", service);
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
        "project", project, "location", location, "namespace", namespace, "service", service);
  }

  /** Builder for ServiceName. */
  public static class Builder {

    private String project;
    private String location;
    private String namespace;
    private String service;

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getNamespace() {
      return namespace;
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

    public Builder setNamespace(String namespace) {
      this.namespace = namespace;
      return this;
    }

    public Builder setService(String service) {
      this.service = service;
      return this;
    }

    private Builder() {}

    private Builder(ServiceName serviceName) {
      project = serviceName.project;
      location = serviceName.location;
      namespace = serviceName.namespace;
      service = serviceName.service;
    }

    public ServiceName build() {
      return new ServiceName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ServiceName) {
      ServiceName that = (ServiceName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.namespace.equals(that.namespace))
          && (this.service.equals(that.service));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= location.hashCode();
    h *= 1000003;
    h ^= namespace.hashCode();
    h *= 1000003;
    h ^= service.hashCode();
    return h;
  }
}
