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
public class GroupName implements ResourceName {
  private static final PathTemplate PROJECT_HUB_GROUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/global/hubs/{hub}/groups/{group}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String hub;
  private final String group;

  @Deprecated
  protected GroupName() {
    project = null;
    hub = null;
    group = null;
  }

  private GroupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    hub = Preconditions.checkNotNull(builder.getHub());
    group = Preconditions.checkNotNull(builder.getGroup());
  }

  public String getProject() {
    return project;
  }

  public String getHub() {
    return hub;
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

  public static GroupName of(String project, String hub, String group) {
    return newBuilder().setProject(project).setHub(hub).setGroup(group).build();
  }

  public static String format(String project, String hub, String group) {
    return newBuilder().setProject(project).setHub(hub).setGroup(group).build().toString();
  }

  public static GroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_HUB_GROUP.validatedMatch(
            formattedString, "GroupName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("hub"), matchMap.get("group"));
  }

  public static List<GroupName> parseList(List<String> formattedStrings) {
    List<GroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GroupName> values) {
    List<String> list = new ArrayList<>(values.size());
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
    return PROJECT_HUB_GROUP.matches(formattedString);
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
          if (hub != null) {
            fieldMapBuilder.put("hub", hub);
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
    return PROJECT_HUB_GROUP.instantiate("project", project, "hub", hub, "group", group);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      GroupName that = ((GroupName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.hub, that.hub)
          && Objects.equals(this.group, that.group);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(hub);
    h *= 1000003;
    h ^= Objects.hashCode(group);
    return h;
  }

  /** Builder for projects/{project}/locations/global/hubs/{hub}/groups/{group}. */
  public static class Builder {
    private String project;
    private String hub;
    private String group;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getHub() {
      return hub;
    }

    public String getGroup() {
      return group;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setHub(String hub) {
      this.hub = hub;
      return this;
    }

    public Builder setGroup(String group) {
      this.group = group;
      return this;
    }

    private Builder(GroupName groupName) {
      this.project = groupName.project;
      this.hub = groupName.hub;
      this.group = groupName.group;
    }

    public GroupName build() {
      return new GroupName(this);
    }
  }
}
