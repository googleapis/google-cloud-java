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

package com.google.cloud.networksecurity.v1;

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
public class InterceptEndpointGroupAssociationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_INTERCEPT_ENDPOINT_GROUP_ASSOCIATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/interceptEndpointGroupAssociations/{intercept_endpoint_group_association}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String interceptEndpointGroupAssociation;

  @Deprecated
  protected InterceptEndpointGroupAssociationName() {
    project = null;
    location = null;
    interceptEndpointGroupAssociation = null;
  }

  private InterceptEndpointGroupAssociationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    interceptEndpointGroupAssociation =
        Preconditions.checkNotNull(builder.getInterceptEndpointGroupAssociation());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getInterceptEndpointGroupAssociation() {
    return interceptEndpointGroupAssociation;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static InterceptEndpointGroupAssociationName of(
      String project, String location, String interceptEndpointGroupAssociation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInterceptEndpointGroupAssociation(interceptEndpointGroupAssociation)
        .build();
  }

  public static String format(
      String project, String location, String interceptEndpointGroupAssociation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInterceptEndpointGroupAssociation(interceptEndpointGroupAssociation)
        .build()
        .toString();
  }

  public static InterceptEndpointGroupAssociationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_INTERCEPT_ENDPOINT_GROUP_ASSOCIATION.validatedMatch(
            formattedString,
            "InterceptEndpointGroupAssociationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("intercept_endpoint_group_association"));
  }

  public static List<InterceptEndpointGroupAssociationName> parseList(
      List<String> formattedStrings) {
    List<InterceptEndpointGroupAssociationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<InterceptEndpointGroupAssociationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (InterceptEndpointGroupAssociationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_INTERCEPT_ENDPOINT_GROUP_ASSOCIATION.matches(formattedString);
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
          if (interceptEndpointGroupAssociation != null) {
            fieldMapBuilder.put(
                "intercept_endpoint_group_association", interceptEndpointGroupAssociation);
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
    return PROJECT_LOCATION_INTERCEPT_ENDPOINT_GROUP_ASSOCIATION.instantiate(
        "project",
        project,
        "location",
        location,
        "intercept_endpoint_group_association",
        interceptEndpointGroupAssociation);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      InterceptEndpointGroupAssociationName that = ((InterceptEndpointGroupAssociationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(
              this.interceptEndpointGroupAssociation, that.interceptEndpointGroupAssociation);
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
    h ^= Objects.hashCode(interceptEndpointGroupAssociation);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/interceptEndpointGroupAssociations/{intercept_endpoint_group_association}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String interceptEndpointGroupAssociation;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getInterceptEndpointGroupAssociation() {
      return interceptEndpointGroupAssociation;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setInterceptEndpointGroupAssociation(String interceptEndpointGroupAssociation) {
      this.interceptEndpointGroupAssociation = interceptEndpointGroupAssociation;
      return this;
    }

    private Builder(InterceptEndpointGroupAssociationName interceptEndpointGroupAssociationName) {
      this.project = interceptEndpointGroupAssociationName.project;
      this.location = interceptEndpointGroupAssociationName.location;
      this.interceptEndpointGroupAssociation =
          interceptEndpointGroupAssociationName.interceptEndpointGroupAssociation;
    }

    public InterceptEndpointGroupAssociationName build() {
      return new InterceptEndpointGroupAssociationName(this);
    }
  }
}
