/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.container.v1;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class OperationName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}/operations/{operation}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String operation;

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getOperation() {
    return operation;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private OperationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    operation = Preconditions.checkNotNull(builder.getOperation());
  }

  public static OperationName of(String project, String location, String operation) {
    return newBuilder()
      .setProject(project)
      .setLocation(location)
      .setOperation(operation)
      .build();
  }

  public static String format(String project, String location, String operation) {
    return newBuilder()
      .setProject(project)
      .setLocation(location)
      .setOperation(operation)
      .build()
      .toString();
  }

  public static OperationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "OperationName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("operation"));
  }

  public static List<OperationName> parseList(List<String> formattedStrings) {
    List<OperationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OperationName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (OperationName value : values) {
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
          fieldMapBuilder.put("operation", operation);
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
    return PATH_TEMPLATE.instantiate("project", project, "location", location, "operation", operation);
  }

  /** Builder for OperationName. */
  public static class Builder {

    private String project;
    private String location;
    private String operation;

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getOperation() {
      return operation;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setOperation(String operation) {
      this.operation = operation;
      return this;
    }

    private Builder() {
    }

    private Builder(OperationName operationName) {
      project = operationName.project;
      location = operationName.location;
      operation = operationName.operation;
    }

    public OperationName build() {
      return new OperationName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof OperationName) {
      OperationName that = (OperationName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.operation.equals(that.operation));
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
    h ^= operation.hashCode();
    return h;
  }
}

