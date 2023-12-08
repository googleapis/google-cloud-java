/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.vertexai.v1beta1;

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
public class EndpointName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ENDPOINT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/endpoints/{endpoint}");
  private static final PathTemplate PROJECT_LOCATION_PUBLISHER_MODEL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/publishers/{publisher}/models/{model}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String endpoint;
  private final String publisher;
  private final String model;

  @Deprecated
  protected EndpointName() {
    project = null;
    location = null;
    endpoint = null;
    publisher = null;
    model = null;
  }

  private EndpointName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    endpoint = Preconditions.checkNotNull(builder.getEndpoint());
    publisher = null;
    model = null;
    pathTemplate = PROJECT_LOCATION_ENDPOINT;
  }

  private EndpointName(ProjectLocationPublisherModelBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    publisher = Preconditions.checkNotNull(builder.getPublisher());
    model = Preconditions.checkNotNull(builder.getModel());
    endpoint = null;
    pathTemplate = PROJECT_LOCATION_PUBLISHER_MODEL;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public String getPublisher() {
    return publisher;
  }

  public String getModel() {
    return model;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectLocationEndpointBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationPublisherModelBuilder newProjectLocationPublisherModelBuilder() {
    return new ProjectLocationPublisherModelBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EndpointName of(String project, String location, String endpoint) {
    return newBuilder().setProject(project).setLocation(location).setEndpoint(endpoint).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EndpointName ofProjectLocationEndpointName(
      String project, String location, String endpoint) {
    return newBuilder().setProject(project).setLocation(location).setEndpoint(endpoint).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EndpointName ofProjectLocationPublisherModelName(
      String project, String location, String publisher, String model) {
    return newProjectLocationPublisherModelBuilder()
        .setProject(project)
        .setLocation(location)
        .setPublisher(publisher)
        .setModel(model)
        .build();
  }

  public static String format(String project, String location, String endpoint) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEndpoint(endpoint)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationEndpointName(
      String project, String location, String endpoint) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEndpoint(endpoint)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationPublisherModelName(
      String project, String location, String publisher, String model) {
    return newProjectLocationPublisherModelBuilder()
        .setProject(project)
        .setLocation(location)
        .setPublisher(publisher)
        .setModel(model)
        .build()
        .toString();
  }

  public static EndpointName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_ENDPOINT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_ENDPOINT.match(formattedString);
      return ofProjectLocationEndpointName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("endpoint"));
    } else if (PROJECT_LOCATION_PUBLISHER_MODEL.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_PUBLISHER_MODEL.match(formattedString);
      return ofProjectLocationPublisherModelName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("publisher"),
          matchMap.get("model"));
    }
    throw new ValidationException("EndpointName.parse: formattedString not in valid format");
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
    return PROJECT_LOCATION_ENDPOINT.matches(formattedString)
        || PROJECT_LOCATION_PUBLISHER_MODEL.matches(formattedString);
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
          if (endpoint != null) {
            fieldMapBuilder.put("endpoint", endpoint);
          }
          if (publisher != null) {
            fieldMapBuilder.put("publisher", publisher);
          }
          if (model != null) {
            fieldMapBuilder.put("model", model);
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
      EndpointName that = ((EndpointName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.endpoint, that.endpoint)
          && Objects.equals(this.publisher, that.publisher)
          && Objects.equals(this.model, that.model);
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
    h ^= Objects.hashCode(endpoint);
    h *= 1000003;
    h ^= Objects.hashCode(publisher);
    h *= 1000003;
    h ^= Objects.hashCode(model);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/endpoints/{endpoint}. */
  public static class Builder {
    private String project;
    private String location;
    private String endpoint;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
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

    public Builder setEndpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    private Builder(EndpointName endpointName) {
      Preconditions.checkArgument(
          Objects.equals(endpointName.pathTemplate, PROJECT_LOCATION_ENDPOINT),
          "toBuilder is only supported when EndpointName has the pattern of projects/{project}/locations/{location}/endpoints/{endpoint}");
      this.project = endpointName.project;
      this.location = endpointName.location;
      this.endpoint = endpointName.endpoint;
    }

    public EndpointName build() {
      return new EndpointName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/publishers/{publisher}/models/{model}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationPublisherModelBuilder {
    private String project;
    private String location;
    private String publisher;
    private String model;

    protected ProjectLocationPublisherModelBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getPublisher() {
      return publisher;
    }

    public String getModel() {
      return model;
    }

    public ProjectLocationPublisherModelBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationPublisherModelBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationPublisherModelBuilder setPublisher(String publisher) {
      this.publisher = publisher;
      return this;
    }

    public ProjectLocationPublisherModelBuilder setModel(String model) {
      this.model = model;
      return this;
    }

    public EndpointName build() {
      return new EndpointName(this);
    }
  }
}
