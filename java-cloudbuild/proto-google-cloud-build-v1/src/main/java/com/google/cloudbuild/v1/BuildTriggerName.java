/*
 * Copyright 2020 Google LLC
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

package com.google.cloudbuild.v1;

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
public class BuildTriggerName implements ResourceName {
  private static final PathTemplate PROJECT_TRIGGER =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/triggers/{trigger}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String trigger;

  @Deprecated
  protected BuildTriggerName() {
    project = null;
    trigger = null;
  }

  private BuildTriggerName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    trigger = Preconditions.checkNotNull(builder.getTrigger());
  }

  public String getProject() {
    return project;
  }

  public String getTrigger() {
    return trigger;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BuildTriggerName of(String project, String trigger) {
    return newBuilder().setProject(project).setTrigger(trigger).build();
  }

  public static String format(String project, String trigger) {
    return newBuilder().setProject(project).setTrigger(trigger).build().toString();
  }

  public static BuildTriggerName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_TRIGGER.validatedMatch(
            formattedString, "BuildTriggerName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("trigger"));
  }

  public static List<BuildTriggerName> parseList(List<String> formattedStrings) {
    List<BuildTriggerName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BuildTriggerName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BuildTriggerName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_TRIGGER.matches(formattedString);
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
          if (trigger != null) {
            fieldMapBuilder.put("trigger", trigger);
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
    return PROJECT_TRIGGER.instantiate("project", project, "trigger", trigger);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      BuildTriggerName that = ((BuildTriggerName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.trigger, that.trigger);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(trigger);
    return h;
  }

  /** Builder for projects/{project}/triggers/{trigger}. */
  public static class Builder {
    private String project;
    private String trigger;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getTrigger() {
      return trigger;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setTrigger(String trigger) {
      this.trigger = trigger;
      return this;
    }

    private Builder(BuildTriggerName buildTriggerName) {
      project = buildTriggerName.project;
      trigger = buildTriggerName.trigger;
    }

    public BuildTriggerName build() {
      return new BuildTriggerName(this);
    }
  }
}
