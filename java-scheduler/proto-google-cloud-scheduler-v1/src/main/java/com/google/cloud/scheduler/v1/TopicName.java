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

package com.google.cloud.scheduler.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class TopicName implements ResourceName {

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

  private TopicName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    topic = Preconditions.checkNotNull(builder.getTopic());
  }

  public static TopicName of(String project, String topic) {
    return newBuilder().setProject(project).setTopic(topic).build();
  }

  public static String format(String project, String topic) {
    return newBuilder().setProject(project).setTopic(topic).build().toString();
  }

  public static TopicName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "TopicName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("topic"));
  }

  public static List<TopicName> parseList(List<String> formattedStrings) {
    List<TopicName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TopicName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (TopicName value : values) {
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

  /** Builder for TopicName. */
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

    private Builder(TopicName topicName) {
      project = topicName.project;
      topic = topicName.topic;
    }

    public TopicName build() {
      return new TopicName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TopicName) {
      TopicName that = (TopicName) o;
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
