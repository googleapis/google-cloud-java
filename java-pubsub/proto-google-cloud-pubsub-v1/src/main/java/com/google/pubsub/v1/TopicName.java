/*
 * Copyright 2020 Google LLC
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

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class TopicName implements ResourceName {

  @Deprecated
  protected TopicName() {}

  private static final PathTemplate PROJECT_TOPIC_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/topics/{topic}");
  private static final String DELETED_TOPIC_FIXED_VALUE = "_deleted-topic_";
  private static final TopicName DELETED_TOPIC_INSTANCE = new TopicName("_deleted-topic_");

  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;

  private String project;
  private String topic;

  public String getProject() {
    return project;
  }

  public String getTopic() {
    return topic;
  }

  private TopicName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    topic = Preconditions.checkNotNull(builder.getTopic());
    pathTemplate = PROJECT_TOPIC_PATH_TEMPLATE;
  }

  private TopicName(String fixedValue) {
    this.fixedValue = fixedValue;
    fieldValuesMap = ImmutableMap.of("", fixedValue);
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
    return newProjectTopicBuilder().setProject(project).setTopic(topic).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static TopicName ofProjectTopicName(String project, String topic) {
    return newProjectTopicBuilder().setProject(project).setTopic(topic).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static TopicName ofDeletedTopicName() {
    return DELETED_TOPIC_INSTANCE;
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
    return DELETED_TOPIC_FIXED_VALUE;
  }

  public static TopicName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_TOPIC_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_TOPIC_PATH_TEMPLATE.match(formattedString);
      return ofProjectTopicName(matchMap.get("project"), matchMap.get("topic"));
    } else if (DELETED_TOPIC_FIXED_VALUE.equals(formattedString)) {
      return DELETED_TOPIC_INSTANCE;
    }
    throw new ValidationException("JobName.parse: formattedString not in valid format");
  }

  @BetaApi("The method will be renamed to parseList after subclasses of this class are removed.")
  public static List<TopicName> parse(List<String> formattedStrings) {
    List<TopicName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  @BetaApi("The method will be renamed to toStringList after subclasses of this class are removed.")
  public static List<String> toStrings(List<TopicName> values) {
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
    return PROJECT_TOPIC_PATH_TEMPLATE.matches(formattedString)
        || DELETED_TOPIC_FIXED_VALUE.equals(formattedString);
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
          topicName.pathTemplate == PROJECT_TOPIC_PATH_TEMPLATE,
          "toBuilder is only supported when TopicName has the pattern of "
              + "projects/{project}/topics/{topic}.");
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
    if (o != null || getClass() == o.getClass()) {
      TopicName that = (TopicName) o;
      return (Objects.equals(this.project, that.project))
          && (Objects.equals(this.topic, that.topic));
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
    h ^= Objects.hashCode(topic);
    return h;
  }
}
