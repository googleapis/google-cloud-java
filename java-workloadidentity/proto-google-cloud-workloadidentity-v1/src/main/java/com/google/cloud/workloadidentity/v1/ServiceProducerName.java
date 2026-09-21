/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.workloadidentity.v1;

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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class ServiceProducerName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SERVICE_PRODUCER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/serviceProducers/{service_producer}");
  private static final PathTemplate FOLDER_LOCATION_SERVICE_PRODUCER =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/serviceProducers/{service_producer}");
  private static final PathTemplate ORGANIZATION_LOCATION_SERVICE_PRODUCER =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/serviceProducers/{service_producer}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String serviceProducer;
  private final String folder;
  private final String organization;

  @Deprecated
  protected ServiceProducerName() {
    project = null;
    location = null;
    serviceProducer = null;
    folder = null;
    organization = null;
  }

  private ServiceProducerName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    serviceProducer = Preconditions.checkNotNull(builder.getServiceProducer());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION_SERVICE_PRODUCER;
  }

  private ServiceProducerName(FolderLocationServiceProducerBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    serviceProducer = Preconditions.checkNotNull(builder.getServiceProducer());
    project = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION_SERVICE_PRODUCER;
  }

  private ServiceProducerName(OrganizationLocationServiceProducerBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    serviceProducer = Preconditions.checkNotNull(builder.getServiceProducer());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_SERVICE_PRODUCER;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getServiceProducer() {
    return serviceProducer;
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

  public static Builder newProjectLocationServiceProducerBuilder() {
    return new Builder();
  }

  public static FolderLocationServiceProducerBuilder newFolderLocationServiceProducerBuilder() {
    return new FolderLocationServiceProducerBuilder();
  }

  public static OrganizationLocationServiceProducerBuilder
      newOrganizationLocationServiceProducerBuilder() {
    return new OrganizationLocationServiceProducerBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ServiceProducerName of(String project, String location, String serviceProducer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setServiceProducer(serviceProducer)
        .build();
  }

  public static ServiceProducerName ofProjectLocationServiceProducerName(
      String project, String location, String serviceProducer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setServiceProducer(serviceProducer)
        .build();
  }

  public static ServiceProducerName ofFolderLocationServiceProducerName(
      String folder, String location, String serviceProducer) {
    return newFolderLocationServiceProducerBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setServiceProducer(serviceProducer)
        .build();
  }

  public static ServiceProducerName ofOrganizationLocationServiceProducerName(
      String organization, String location, String serviceProducer) {
    return newOrganizationLocationServiceProducerBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setServiceProducer(serviceProducer)
        .build();
  }

  public static String format(String project, String location, String serviceProducer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setServiceProducer(serviceProducer)
        .build()
        .toString();
  }

  public static String formatProjectLocationServiceProducerName(
      String project, String location, String serviceProducer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setServiceProducer(serviceProducer)
        .build()
        .toString();
  }

  public static String formatFolderLocationServiceProducerName(
      String folder, String location, String serviceProducer) {
    return newFolderLocationServiceProducerBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setServiceProducer(serviceProducer)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationServiceProducerName(
      String organization, String location, String serviceProducer) {
    return newOrganizationLocationServiceProducerBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setServiceProducer(serviceProducer)
        .build()
        .toString();
  }

  public static @Nullable ServiceProducerName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_SERVICE_PRODUCER.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_SERVICE_PRODUCER.match(formattedString);
      return ofProjectLocationServiceProducerName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("service_producer"));
    } else if (FOLDER_LOCATION_SERVICE_PRODUCER.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_SERVICE_PRODUCER.match(formattedString);
      return ofFolderLocationServiceProducerName(
          matchMap.get("folder"), matchMap.get("location"), matchMap.get("service_producer"));
    } else if (ORGANIZATION_LOCATION_SERVICE_PRODUCER.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_SERVICE_PRODUCER.match(formattedString);
      return ofOrganizationLocationServiceProducerName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("service_producer"));
    }
    throw new ValidationException("ServiceProducerName.parse: formattedString not in valid format");
  }

  public static List<ServiceProducerName> parseList(List<String> formattedStrings) {
    List<ServiceProducerName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable ServiceProducerName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ServiceProducerName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SERVICE_PRODUCER.matches(formattedString)
        || FOLDER_LOCATION_SERVICE_PRODUCER.matches(formattedString)
        || ORGANIZATION_LOCATION_SERVICE_PRODUCER.matches(formattedString);
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
          if (serviceProducer != null) {
            fieldMapBuilder.put("service_producer", serviceProducer);
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
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ServiceProducerName that = ((ServiceProducerName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.serviceProducer, that.serviceProducer)
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
    h ^= Objects.hashCode(serviceProducer);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/serviceProducers/{service_producer}. */
  public static class Builder {
    private String project;
    private String location;
    private String serviceProducer;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getServiceProducer() {
      return serviceProducer;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setServiceProducer(String serviceProducer) {
      this.serviceProducer = serviceProducer;
      return this;
    }

    private Builder(ServiceProducerName serviceProducerName) {
      Preconditions.checkArgument(
          Objects.equals(serviceProducerName.pathTemplate, PROJECT_LOCATION_SERVICE_PRODUCER),
          "toBuilder is only supported when ServiceProducerName has the pattern of"
              + " projects/{project}/locations/{location}/serviceProducers/{service_producer}");
      this.project = serviceProducerName.project;
      this.location = serviceProducerName.location;
      this.serviceProducer = serviceProducerName.serviceProducer;
    }

    public ServiceProducerName build() {
      return new ServiceProducerName(this);
    }
  }

  /** Builder for folders/{folder}/locations/{location}/serviceProducers/{service_producer}. */
  public static class FolderLocationServiceProducerBuilder {
    private String folder;
    private String location;
    private String serviceProducer;

    protected FolderLocationServiceProducerBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getServiceProducer() {
      return serviceProducer;
    }

    public FolderLocationServiceProducerBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationServiceProducerBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationServiceProducerBuilder setServiceProducer(String serviceProducer) {
      this.serviceProducer = serviceProducer;
      return this;
    }

    public ServiceProducerName build() {
      return new ServiceProducerName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/serviceProducers/{service_producer}.
   */
  public static class OrganizationLocationServiceProducerBuilder {
    private String organization;
    private String location;
    private String serviceProducer;

    protected OrganizationLocationServiceProducerBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getServiceProducer() {
      return serviceProducer;
    }

    public OrganizationLocationServiceProducerBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationServiceProducerBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationServiceProducerBuilder setServiceProducer(String serviceProducer) {
      this.serviceProducer = serviceProducer;
      return this;
    }

    public ServiceProducerName build() {
      return new ServiceProducerName(this);
    }
  }
}
