/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.servicedirectory.v1beta1;

import com.google.api.pathtemplate.PathTemplate;
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
public class EndpointName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_NAMESPACE_SERVICE_ENDPOINT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/namespaces/{namespace}/services/{service}/endpoints/{endpoint}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String namespace;
  private final String service;
  private final String endpoint;

  @Deprecated
  protected EndpointName() {
    project = null;
    location = null;
    namespace = null;
    service = null;
    endpoint = null;
  }

  private EndpointName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    namespace = Preconditions.checkNotNull(builder.getNamespace());
    service = Preconditions.checkNotNull(builder.getService());
    endpoint = Preconditions.checkNotNull(builder.getEndpoint());
  }

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

  public String getEndpoint() {
    return endpoint;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EndpointName of(
      String project, String location, String namespace, String service, String endpoint) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setNamespace(namespace)
        .setService(service)
        .setEndpoint(endpoint)
        .build();
  }

  public static String format(
      String project, String location, String namespace, String service, String endpoint) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setNamespace(namespace)
        .setService(service)
        .setEndpoint(endpoint)
        .build()
        .toString();
  }

  public static EndpointName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_NAMESPACE_SERVICE_ENDPOINT.validatedMatch(
            formattedString, "EndpointName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("namespace"),
        matchMap.get("service"),
        matchMap.get("endpoint"));
  }

  public static List<EndpointName> parseList(List<String> formattedStrings) {
    List<EndpointName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EndpointName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EndpointName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_NAMESPACE_SERVICE_ENDPOINT.matches(formattedString);
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
          if (namespace != null) {
            fieldMapBuilder.put("namespace", namespace);
          }
          if (service != null) {
            fieldMapBuilder.put("service", service);
          }
          if (endpoint != null) {
            fieldMapBuilder.put("endpoint", endpoint);
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
    return PROJECT_LOCATION_NAMESPACE_SERVICE_ENDPOINT.instantiate(
        "project",
        project,
        "location",
        location,
        "namespace",
        namespace,
        "service",
        service,
        "endpoint",
        endpoint);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      EndpointName that = ((EndpointName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.namespace, that.namespace)
          && Objects.equals(this.service, that.service)
          && Objects.equals(this.endpoint, that.endpoint);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(namespace);
    h *= 1000003;
    h ^= Objects.hashCode(service);
    h *= 1000003;
    h ^= Objects.hashCode(endpoint);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/namespaces/{namespace}/services/{service}/endpoints/{endpoint}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String namespace;
    private String service;
    private String endpoint;

    protected Builder() {}

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

    public String getEndpoint() {
      return endpoint;
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

    public Builder setEndpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    private Builder(EndpointName endpointName) {
      this.project = endpointName.project;
      this.location = endpointName.location;
      this.namespace = endpointName.namespace;
      this.service = endpointName.service;
      this.endpoint = endpointName.endpoint;
    }

    public EndpointName build() {
      return new EndpointName(this);
    }
  }
}
