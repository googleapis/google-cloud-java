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

package com.google.cloud.networkconnectivity.v1;

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
public class ServiceClassName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SERVICE_CLASS =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/serviceClasses/{service_class}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String serviceClass;

  @Deprecated
  protected ServiceClassName() {
    project = null;
    location = null;
    serviceClass = null;
  }

  private ServiceClassName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    serviceClass = Preconditions.checkNotNull(builder.getServiceClass());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getServiceClass() {
    return serviceClass;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ServiceClassName of(String project, String location, String serviceClass) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setServiceClass(serviceClass)
        .build();
  }

  public static String format(String project, String location, String serviceClass) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setServiceClass(serviceClass)
        .build()
        .toString();
  }

  public static ServiceClassName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SERVICE_CLASS.validatedMatch(
            formattedString, "ServiceClassName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("service_class"));
  }

  public static List<ServiceClassName> parseList(List<String> formattedStrings) {
    List<ServiceClassName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ServiceClassName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ServiceClassName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SERVICE_CLASS.matches(formattedString);
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
          if (serviceClass != null) {
            fieldMapBuilder.put("service_class", serviceClass);
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
    return PROJECT_LOCATION_SERVICE_CLASS.instantiate(
        "project", project, "location", location, "service_class", serviceClass);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ServiceClassName that = ((ServiceClassName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.serviceClass, that.serviceClass);
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
    h ^= Objects.hashCode(serviceClass);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/serviceClasses/{service_class}. */
  public static class Builder {
    private String project;
    private String location;
    private String serviceClass;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getServiceClass() {
      return serviceClass;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setServiceClass(String serviceClass) {
      this.serviceClass = serviceClass;
      return this;
    }

    private Builder(ServiceClassName serviceClassName) {
      this.project = serviceClassName.project;
      this.location = serviceClassName.location;
      this.serviceClass = serviceClassName.serviceClass;
    }

    public ServiceClassName build() {
      return new ServiceClassName(this);
    }
  }
}
