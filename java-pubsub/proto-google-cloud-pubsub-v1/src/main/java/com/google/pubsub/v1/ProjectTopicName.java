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

package com.google.pubsub.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ProjectTopicName extends TopicName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/topics/{topic}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String topic;

  public String getProject() {
    return project;
  }

  public String getTopic() {
    return topic;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectTopicName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    topic = Preconditions.checkNotNull(builder.getTopic());
  }

  public static ProjectTopicName of(String project, String topic) {
    return newBuilder().setProject(project).setTopic(topic).build();
  }

  public static String format(String project, String topic) {
    return newBuilder().setProject(project).setTopic(topic).build().toString();
  }

  public static ProjectTopicName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "ProjectTopicName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("topic"));
  }

  public static List<ProjectTopicName> parseList(List<String> formattedStrings) {
    List<ProjectTopicName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProjectTopicName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ProjectTopicName value : values) {
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
          fieldMapBuilder.put("topic", topic);
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
    return PATH_TEMPLATE.instantiate("project", project, "topic", topic);
  }

  /** Builder for ProjectTopicName. */
  public static class Builder {

    private String project;
    private String topic;

    public String getProject() {
      return project;
    }

    public String getTopic() {
      return topic;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setTopic(String topic) {
      this.topic = topic;
      return this;
    }

    private Builder() {}

    private Builder(ProjectTopicName projectTopicName) {
      project = projectTopicName.project;
      topic = projectTopicName.topic;
    }

    public ProjectTopicName build() {
      return new ProjectTopicName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectTopicName) {
      ProjectTopicName that = (ProjectTopicName) o;
      return (this.project.equals(that.project)) && (this.topic.equals(that.topic));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= topic.hashCode();
    return h;
  }
}
