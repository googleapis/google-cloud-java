/*
 * Copyright 2019 Google LLC
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

package com.google.devtools.clouderrorreporting.v1beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
@Deprecated
public class GroupName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/groups/{group}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String group;

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

  private GroupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    group = Preconditions.checkNotNull(builder.getGroup());
  }

  public static GroupName of(String project, String group) {
    return newBuilder().setProject(project).setGroup(group).build();
  }

  public static String format(String project, String group) {
    return newBuilder().setProject(project).setGroup(group).build().toString();
  }

  public static GroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "GroupName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("group"));
  }

  public static List<GroupName> parseList(List<String> formattedStrings) {
    List<GroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GroupName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (GroupName value : values) {
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
          fieldMapBuilder.put("group", group);
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
    return PATH_TEMPLATE.instantiate("project", project, "group", group);
  }

  /** Builder for GroupName. */
  public static class Builder {

    private String project;
    private String group;

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

    private Builder() {}

    private Builder(GroupName groupName) {
      project = groupName.project;
      group = groupName.group;
    }

    public GroupName build() {
      return new GroupName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof GroupName) {
      GroupName that = (GroupName) o;
      return (this.project.equals(that.project)) && (this.group.equals(that.group));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= group.hashCode();
    return h;
  }
}
