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

package com.google.devtools.clouderrorreporting.v1beta1;

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
public class ErrorGroupName implements ResourceName {
  private static final PathTemplate PROJECT_GROUP =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/groups/{group}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String group;

  @Deprecated
  protected ErrorGroupName() {
    project = null;
    group = null;
  }

  private ErrorGroupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    group = Preconditions.checkNotNull(builder.getGroup());
  }

  public String getProject() {
    return project;
  }

  public String getGroup() {
    return group;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ErrorGroupName of(String project, String group) {
    return newBuilder().setProject(project).setGroup(group).build();
  }

  public static String format(String project, String group) {
    return newBuilder().setProject(project).setGroup(group).build().toString();
  }

  public static ErrorGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_GROUP.validatedMatch(
            formattedString, "ErrorGroupName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("group"));
  }

  public static List<ErrorGroupName> parseList(List<String> formattedStrings) {
    List<ErrorGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ErrorGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ErrorGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_GROUP.matches(formattedString);
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
          if (group != null) {
            fieldMapBuilder.put("group", group);
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
    return PROJECT_GROUP.instantiate("project", project, "group", group);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ErrorGroupName that = ((ErrorGroupName) o);
      return Objects.equals(this.project, that.project) && Objects.equals(this.group, that.group);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(group);
    return h;
  }

  /** Builder for projects/{project}/groups/{group}. */
  public static class Builder {
    private String project;
    private String group;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getGroup() {
      return group;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setGroup(String group) {
      this.group = group;
      return this;
    }

    private Builder(ErrorGroupName errorGroupName) {
      this.project = errorGroupName.project;
      this.group = errorGroupName.group;
    }

    public ErrorGroupName build() {
      return new ErrorGroupName(this);
    }
  }
}
