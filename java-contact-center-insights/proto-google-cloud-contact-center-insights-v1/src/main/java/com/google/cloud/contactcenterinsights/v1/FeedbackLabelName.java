/*
 * Copyright 2025 Google LLC
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
public class FeedbackLabelName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CONVERSATION_FEEDBACK_LABEL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/conversations/{conversation}/feedbackLabels/{feedback_label}");
  private static final PathTemplate
      PROJECT_LOCATION_AUTHORIZED_VIEW_SET_AUTHORIZED_VIEW_CONVERSATION_FEEDBACK_LABEL =
          PathTemplate.createWithoutUrlEncoding(
              "projects/{project}/locations/{location}/authorizedViewSets/{authorized_view_set}/authorizedViews/{authorized_view}/conversations/{conversation}/feedbackLabels/{feedback_label}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String conversation;
  private final String feedbackLabel;
  private final String authorizedViewSet;
  private final String authorizedView;

  @Deprecated
  protected FeedbackLabelName() {
    project = null;
    location = null;
    conversation = null;
    feedbackLabel = null;
    authorizedViewSet = null;
    authorizedView = null;
  }

  private FeedbackLabelName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    feedbackLabel = Preconditions.checkNotNull(builder.getFeedbackLabel());
    authorizedViewSet = null;
    authorizedView = null;
    pathTemplate = PROJECT_LOCATION_CONVERSATION_FEEDBACK_LABEL;
  }

  private FeedbackLabelName(
      ProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    authorizedViewSet = Preconditions.checkNotNull(builder.getAuthorizedViewSet());
    authorizedView = Preconditions.checkNotNull(builder.getAuthorizedView());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    feedbackLabel = Preconditions.checkNotNull(builder.getFeedbackLabel());
    pathTemplate = PROJECT_LOCATION_AUTHORIZED_VIEW_SET_AUTHORIZED_VIEW_CONVERSATION_FEEDBACK_LABEL;
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

  public String getAuthorizedViewSet() {
    return authorizedViewSet;
  }

  public String getAuthorizedView() {
    return authorizedView;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationConversationFeedbackLabelBuilder() {
    return new Builder();
  }

  public static ProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelBuilder
      newProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelBuilder() {
    return new ProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelBuilder();
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

  public static FeedbackLabelName ofProjectLocationConversationFeedbackLabelName(
      String project, String location, String conversation, String feedbackLabel) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .setFeedbackLabel(feedbackLabel)
        .build();
  }

  public static FeedbackLabelName
      ofProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelName(
          String project,
          String location,
          String authorizedViewSet,
          String authorizedView,
          String conversation,
          String feedbackLabel) {
    return newProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelBuilder()
        .setProject(project)
        .setLocation(location)
        .setAuthorizedViewSet(authorizedViewSet)
        .setAuthorizedView(authorizedView)
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

  public static String formatProjectLocationConversationFeedbackLabelName(
      String project, String location, String conversation, String feedbackLabel) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .setFeedbackLabel(feedbackLabel)
        .build()
        .toString();
  }

  public static String
      formatProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelName(
          String project,
          String location,
          String authorizedViewSet,
          String authorizedView,
          String conversation,
          String feedbackLabel) {
    return newProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelBuilder()
        .setProject(project)
        .setLocation(location)
        .setAuthorizedViewSet(authorizedViewSet)
        .setAuthorizedView(authorizedView)
        .setConversation(conversation)
        .setFeedbackLabel(feedbackLabel)
        .build()
        .toString();
  }

  public static FeedbackLabelName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_CONVERSATION_FEEDBACK_LABEL.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_CONVERSATION_FEEDBACK_LABEL.match(formattedString);
      return ofProjectLocationConversationFeedbackLabelName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("conversation"),
          matchMap.get("feedback_label"));
    } else if (PROJECT_LOCATION_AUTHORIZED_VIEW_SET_AUTHORIZED_VIEW_CONVERSATION_FEEDBACK_LABEL
        .matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_AUTHORIZED_VIEW_SET_AUTHORIZED_VIEW_CONVERSATION_FEEDBACK_LABEL.match(
              formattedString);
      return ofProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("authorized_view_set"),
          matchMap.get("authorized_view"),
          matchMap.get("conversation"),
          matchMap.get("feedback_label"));
    }
    throw new ValidationException("FeedbackLabelName.parse: formattedString not in valid format");
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
    return PROJECT_LOCATION_CONVERSATION_FEEDBACK_LABEL.matches(formattedString)
        || PROJECT_LOCATION_AUTHORIZED_VIEW_SET_AUTHORIZED_VIEW_CONVERSATION_FEEDBACK_LABEL.matches(
            formattedString);
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
          if (authorizedViewSet != null) {
            fieldMapBuilder.put("authorized_view_set", authorizedViewSet);
          }
          if (authorizedView != null) {
            fieldMapBuilder.put("authorized_view", authorizedView);
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
    if (o != null && getClass() == o.getClass()) {
      FeedbackLabelName that = ((FeedbackLabelName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.conversation, that.conversation)
          && Objects.equals(this.feedbackLabel, that.feedbackLabel)
          && Objects.equals(this.authorizedViewSet, that.authorizedViewSet)
          && Objects.equals(this.authorizedView, that.authorizedView);
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
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(conversation);
    h *= 1000003;
    h ^= Objects.hashCode(feedbackLabel);
    h *= 1000003;
    h ^= Objects.hashCode(authorizedViewSet);
    h *= 1000003;
    h ^= Objects.hashCode(authorizedView);
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
      Preconditions.checkArgument(
          Objects.equals(
              feedbackLabelName.pathTemplate, PROJECT_LOCATION_CONVERSATION_FEEDBACK_LABEL),
          "toBuilder is only supported when FeedbackLabelName has the pattern of"
              + " projects/{project}/locations/{location}/conversations/{conversation}/feedbackLabels/{feedback_label}");
      this.project = feedbackLabelName.project;
      this.location = feedbackLabelName.location;
      this.conversation = feedbackLabelName.conversation;
      this.feedbackLabel = feedbackLabelName.feedbackLabel;
    }

    public FeedbackLabelName build() {
      return new FeedbackLabelName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/authorizedViewSets/{authorized_view_set}/authorizedViews/{authorized_view}/conversations/{conversation}/feedbackLabels/{feedback_label}.
   */
  public static
  class ProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelBuilder {
    private String project;
    private String location;
    private String authorizedViewSet;
    private String authorizedView;
    private String conversation;
    private String feedbackLabel;

    protected ProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAuthorizedViewSet() {
      return authorizedViewSet;
    }

    public String getAuthorizedView() {
      return authorizedView;
    }

    public String getConversation() {
      return conversation;
    }

    public String getFeedbackLabel() {
      return feedbackLabel;
    }

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelBuilder
        setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelBuilder
        setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelBuilder
        setAuthorizedViewSet(String authorizedViewSet) {
      this.authorizedViewSet = authorizedViewSet;
      return this;
    }

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelBuilder
        setAuthorizedView(String authorizedView) {
      this.authorizedView = authorizedView;
      return this;
    }

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelBuilder
        setConversation(String conversation) {
      this.conversation = conversation;
      return this;
    }

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationFeedbackLabelBuilder
        setFeedbackLabel(String feedbackLabel) {
      this.feedbackLabel = feedbackLabel;
      return this;
    }

    public FeedbackLabelName build() {
      return new FeedbackLabelName(this);
    }
  }
}
