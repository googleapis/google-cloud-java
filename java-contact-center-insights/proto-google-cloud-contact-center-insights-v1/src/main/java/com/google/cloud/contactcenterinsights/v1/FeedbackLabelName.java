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

package com.google.cloud.contactcenterinsights.v1;

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
public class FeedbackLabelName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CONVERSATION_FEEDBACK_LABEL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/conversations/{conversation}/feedbackLabels/{feedback_label}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String conversation;
  private final String feedbackLabel;

  @Deprecated
  protected FeedbackLabelName() {
    project = null;
    location = null;
    conversation = null;
    feedbackLabel = null;
  }

  private FeedbackLabelName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    feedbackLabel = Preconditions.checkNotNull(builder.getFeedbackLabel());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getConversation() {
    return conversation;
  }

  public String getFeedbackLabel() {
    return feedbackLabel;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FeedbackLabelName of(
      String project, String location, String conversation, String feedbackLabel) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .setFeedbackLabel(feedbackLabel)
        .build();
  }

  public static String format(
      String project, String location, String conversation, String feedbackLabel) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .setFeedbackLabel(feedbackLabel)
        .build()
        .toString();
  }

  public static FeedbackLabelName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CONVERSATION_FEEDBACK_LABEL.validatedMatch(
            formattedString, "FeedbackLabelName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("conversation"),
        matchMap.get("feedback_label"));
  }

  public static List<FeedbackLabelName> parseList(List<String> formattedStrings) {
    List<FeedbackLabelName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FeedbackLabelName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FeedbackLabelName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CONVERSATION_FEEDBACK_LABEL.matches(formattedString);
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
          if (conversation != null) {
            fieldMapBuilder.put("conversation", conversation);
          }
          if (feedbackLabel != null) {
            fieldMapBuilder.put("feedback_label", feedbackLabel);
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
    return PROJECT_LOCATION_CONVERSATION_FEEDBACK_LABEL.instantiate(
        "project",
        project,
        "location",
        location,
        "conversation",
        conversation,
        "feedback_label",
        feedbackLabel);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      FeedbackLabelName that = ((FeedbackLabelName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.conversation, that.conversation)
          && Objects.equals(this.feedbackLabel, that.feedbackLabel);
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
    h ^= Objects.hashCode(conversation);
    h *= 1000003;
    h ^= Objects.hashCode(feedbackLabel);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/conversations/{conversation}/feedbackLabels/{feedback_label}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String conversation;
    private String feedbackLabel;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getConversation() {
      return conversation;
    }

    public String getFeedbackLabel() {
      return feedbackLabel;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setConversation(String conversation) {
      this.conversation = conversation;
      return this;
    }

    public Builder setFeedbackLabel(String feedbackLabel) {
      this.feedbackLabel = feedbackLabel;
      return this;
    }

    private Builder(FeedbackLabelName feedbackLabelName) {
      this.project = feedbackLabelName.project;
      this.location = feedbackLabelName.location;
      this.conversation = feedbackLabelName.conversation;
      this.feedbackLabel = feedbackLabelName.feedbackLabel;
    }

    public FeedbackLabelName build() {
      return new FeedbackLabelName(this);
    }
  }
}
