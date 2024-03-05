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

package com.google.cloud.apphub.v1;

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
public class ServiceProjectAttachmentName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SERVICE_PROJECT_ATTACHMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/serviceProjectAttachments/{service_project_attachment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String serviceProjectAttachment;

  @Deprecated
  protected ServiceProjectAttachmentName() {
    project = null;
    location = null;
    serviceProjectAttachment = null;
  }

  private ServiceProjectAttachmentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    serviceProjectAttachment = Preconditions.checkNotNull(builder.getServiceProjectAttachment());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getServiceProjectAttachment() {
    return serviceProjectAttachment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ServiceProjectAttachmentName of(
      String project, String location, String serviceProjectAttachment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setServiceProjectAttachment(serviceProjectAttachment)
        .build();
  }

  public static String format(String project, String location, String serviceProjectAttachment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setServiceProjectAttachment(serviceProjectAttachment)
        .build()
        .toString();
  }

  public static ServiceProjectAttachmentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SERVICE_PROJECT_ATTACHMENT.validatedMatch(
            formattedString,
            "ServiceProjectAttachmentName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("service_project_attachment"));
  }

  public static List<ServiceProjectAttachmentName> parseList(List<String> formattedStrings) {
    List<ServiceProjectAttachmentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ServiceProjectAttachmentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ServiceProjectAttachmentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SERVICE_PROJECT_ATTACHMENT.matches(formattedString);
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
          if (serviceProjectAttachment != null) {
            fieldMapBuilder.put("service_project_attachment", serviceProjectAttachment);
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
    return PROJECT_LOCATION_SERVICE_PROJECT_ATTACHMENT.instantiate(
        "project",
        project,
        "location",
        location,
        "service_project_attachment",
        serviceProjectAttachment);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ServiceProjectAttachmentName that = ((ServiceProjectAttachmentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.serviceProjectAttachment, that.serviceProjectAttachment);
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
    h ^= Objects.hashCode(serviceProjectAttachment);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/serviceProjectAttachments/{service_project_attachment}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String serviceProjectAttachment;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getServiceProjectAttachment() {
      return serviceProjectAttachment;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setServiceProjectAttachment(String serviceProjectAttachment) {
      this.serviceProjectAttachment = serviceProjectAttachment;
      return this;
    }

    private Builder(ServiceProjectAttachmentName serviceProjectAttachmentName) {
      this.project = serviceProjectAttachmentName.project;
      this.location = serviceProjectAttachmentName.location;
      this.serviceProjectAttachment = serviceProjectAttachmentName.serviceProjectAttachment;
    }

    public ServiceProjectAttachmentName build() {
      return new ServiceProjectAttachmentName(this);
    }
  }
}
