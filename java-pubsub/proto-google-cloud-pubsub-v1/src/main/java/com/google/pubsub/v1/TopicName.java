/*
 * Copyright 2021 Google LLC
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

package com.google.pubsub.v1;

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
public class TopicName implements ResourceName {
  private static final PathTemplate PROJECT_TOPIC =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/topics/{topic}");
  private static final String DELETED_TOPIC = "_deleted-topic_";
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String topic;

  @Deprecated
  protected TopicName() {
    project = null;
    topic = null;
  }

  private TopicName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    topic = Preconditions.checkNotNull(builder.getTopic());
    pathTemplate = PROJECT_TOPIC;
  }

  private TopicName(String fixedValue) {
    this.fixedValue = fixedValue;
    fieldValuesMap = ImmutableMap.of("", fixedValue);
    project = null;
    topic = null;
  }

  public String getProject() {
    return project;
  }

  public String getTopic() {
    return topic;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectTopicBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TopicName of(String project, String topic) {
    return newBuilder().setProject(project).setTopic(topic).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static TopicName ofProjectTopicName(String project, String topic) {
    return newBuilder().setProject(project).setTopic(topic).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static TopicName ofDeletedTopicName() {
    return new TopicName("_deleted-topic_");
  }

  public static String format(String project, String topic) {
    return newBuilder().setProject(project).setTopic(topic).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectTopicName(String project, String topic) {
    return newBuilder().setProject(project).setTopic(topic).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatDeletedTopicName() {
    return "_deleted-topic_";
  }

  public static TopicName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_TOPIC.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_TOPIC.match(formattedString);
      return ofProjectTopicName(matchMap.get("project"), matchMap.get("topic"));
    } else if (DELETED_TOPIC.equals(formattedString)) {
      return new TopicName("_deleted-topic_");
    }
    throw new ValidationException("TopicName.parse: formattedString not in valid format");
  }

  public static List<TopicName> parseList(List<String> formattedStrings) {
    List<TopicName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TopicName> values) {
    List<String> list = new ArrayList<>(values.size());
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
    return PROJECT_TOPIC.matches(formattedString) || DELETED_TOPIC.equals(formattedString);
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
          if (topic != null) {
            fieldMapBuilder.put("topic", topic);
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
    if (o != null || getClass() == o.getClass()) {
      TopicName that = ((TopicName) o);
      return Objects.equals(this.project, that.project) && Objects.equals(this.topic, that.topic);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(topic);
    return h;
  }

  /** Builder for projects/{project}/topics/{topic}. */
  public static class Builder {
    private String project;
    private String topic;

    protected Builder() {}

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

    private Builder(TopicName topicName) {
      Preconditions.checkArgument(
          Objects.equals(topicName.pathTemplate, PROJECT_TOPIC),
          "toBuilder is only supported when TopicName has the pattern of projects/{project}/topics/{topic}");
      this.project = topicName.project;
      this.topic = topicName.topic;
    }

    public TopicName build() {
      return new TopicName(this);
    }
  }
}
