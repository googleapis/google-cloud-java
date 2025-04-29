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
public class ConversationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CONVERSATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/conversations/{conversation}");
  private static final PathTemplate
      PROJECT_LOCATION_AUTHORIZED_VIEW_SET_AUTHORIZED_VIEW_CONVERSATION =
          PathTemplate.createWithoutUrlEncoding(
              "projects/{project}/locations/{location}/authorizedViewSets/{authorized_view_set}/authorizedViews/{authorized_view}/conversations/{conversation}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String conversation;
  private final String authorizedViewSet;
  private final String authorizedView;

  @Deprecated
  protected ConversationName() {
    project = null;
    location = null;
    conversation = null;
    authorizedViewSet = null;
    authorizedView = null;
  }

  private ConversationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    authorizedViewSet = null;
    authorizedView = null;
    pathTemplate = PROJECT_LOCATION_CONVERSATION;
  }

  private ConversationName(
      ProjectLocationAuthorizedViewSetAuthorizedViewConversationBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    authorizedViewSet = Preconditions.checkNotNull(builder.getAuthorizedViewSet());
    authorizedView = Preconditions.checkNotNull(builder.getAuthorizedView());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    pathTemplate = PROJECT_LOCATION_AUTHORIZED_VIEW_SET_AUTHORIZED_VIEW_CONVERSATION;
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

  public String getAuthorizedViewSet() {
    return authorizedViewSet;
  }

  public String getAuthorizedView() {
    return authorizedView;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationConversationBuilder() {
    return new Builder();
  }

  public static ProjectLocationAuthorizedViewSetAuthorizedViewConversationBuilder
      newProjectLocationAuthorizedViewSetAuthorizedViewConversationBuilder() {
    return new ProjectLocationAuthorizedViewSetAuthorizedViewConversationBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ConversationName of(String project, String location, String conversation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .build();
  }

  public static ConversationName ofProjectLocationConversationName(
      String project, String location, String conversation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .build();
  }

  public static ConversationName ofProjectLocationAuthorizedViewSetAuthorizedViewConversationName(
      String project,
      String location,
      String authorizedViewSet,
      String authorizedView,
      String conversation) {
    return newProjectLocationAuthorizedViewSetAuthorizedViewConversationBuilder()
        .setProject(project)
        .setLocation(location)
        .setAuthorizedViewSet(authorizedViewSet)
        .setAuthorizedView(authorizedView)
        .setConversation(conversation)
        .build();
  }

  public static String format(String project, String location, String conversation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .build()
        .toString();
  }

  public static String formatProjectLocationConversationName(
      String project, String location, String conversation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .build()
        .toString();
  }

  public static String formatProjectLocationAuthorizedViewSetAuthorizedViewConversationName(
      String project,
      String location,
      String authorizedViewSet,
      String authorizedView,
      String conversation) {
    return newProjectLocationAuthorizedViewSetAuthorizedViewConversationBuilder()
        .setProject(project)
        .setLocation(location)
        .setAuthorizedViewSet(authorizedViewSet)
        .setAuthorizedView(authorizedView)
        .setConversation(conversation)
        .build()
        .toString();
  }

  public static ConversationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_CONVERSATION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_CONVERSATION.match(formattedString);
      return ofProjectLocationConversationName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("conversation"));
    } else if (PROJECT_LOCATION_AUTHORIZED_VIEW_SET_AUTHORIZED_VIEW_CONVERSATION.matches(
        formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_AUTHORIZED_VIEW_SET_AUTHORIZED_VIEW_CONVERSATION.match(formattedString);
      return ofProjectLocationAuthorizedViewSetAuthorizedViewConversationName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("authorized_view_set"),
          matchMap.get("authorized_view"),
          matchMap.get("conversation"));
    }
    throw new ValidationException("ConversationName.parse: formattedString not in valid format");
  }

  public static List<ConversationName> parseList(List<String> formattedStrings) {
    List<ConversationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ConversationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ConversationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CONVERSATION.matches(formattedString)
        || PROJECT_LOCATION_AUTHORIZED_VIEW_SET_AUTHORIZED_VIEW_CONVERSATION.matches(
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
      ConversationName that = ((ConversationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.conversation, that.conversation)
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
    h ^= Objects.hashCode(authorizedViewSet);
    h *= 1000003;
    h ^= Objects.hashCode(authorizedView);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/conversations/{conversation}. */
  public static class Builder {
    private String project;
    private String location;
    private String conversation;

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

    private Builder(ConversationName conversationName) {
      Preconditions.checkArgument(
          Objects.equals(conversationName.pathTemplate, PROJECT_LOCATION_CONVERSATION),
          "toBuilder is only supported when ConversationName has the pattern of"
              + " projects/{project}/locations/{location}/conversations/{conversation}");
      this.project = conversationName.project;
      this.location = conversationName.location;
      this.conversation = conversationName.conversation;
    }

    public ConversationName build() {
      return new ConversationName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/authorizedViewSets/{authorized_view_set}/authorizedViews/{authorized_view}/conversations/{conversation}.
   */
  public static class ProjectLocationAuthorizedViewSetAuthorizedViewConversationBuilder {
    private String project;
    private String location;
    private String authorizedViewSet;
    private String authorizedView;
    private String conversation;

    protected ProjectLocationAuthorizedViewSetAuthorizedViewConversationBuilder() {}

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

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationBuilder setProject(
        String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationBuilder setLocation(
        String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationBuilder setAuthorizedViewSet(
        String authorizedViewSet) {
      this.authorizedViewSet = authorizedViewSet;
      return this;
    }

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationBuilder setAuthorizedView(
        String authorizedView) {
      this.authorizedView = authorizedView;
      return this;
    }

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationBuilder setConversation(
        String conversation) {
      this.conversation = conversation;
      return this;
    }

    public ConversationName build() {
      return new ConversationName(this);
    }
  }
}
