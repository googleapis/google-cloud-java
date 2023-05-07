/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.dialogflow.v2beta1;

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
public class ConversationName implements ResourceName {
  private static final PathTemplate PROJECT_CONVERSATION =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/conversations/{conversation}");
  private static final PathTemplate PROJECT_LOCATION_CONVERSATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/conversations/{conversation}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String conversation;
  private final String location;

  @Deprecated
  protected ConversationName() {
    project = null;
    conversation = null;
    location = null;
  }

  private ConversationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    location = null;
    pathTemplate = PROJECT_CONVERSATION;
  }

  private ConversationName(ProjectLocationConversationBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    pathTemplate = PROJECT_LOCATION_CONVERSATION;
  }

  public String getProject() {
    return project;
  }

  public String getConversation() {
    return conversation;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectConversationBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationConversationBuilder newProjectLocationConversationBuilder() {
    return new ProjectLocationConversationBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ConversationName of(String project, String conversation) {
    return newBuilder().setProject(project).setConversation(conversation).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ConversationName ofProjectConversationName(String project, String conversation) {
    return newBuilder().setProject(project).setConversation(conversation).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ConversationName ofProjectLocationConversationName(
      String project, String location, String conversation) {
    return newProjectLocationConversationBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .build();
  }

  public static String format(String project, String conversation) {
    return newBuilder().setProject(project).setConversation(conversation).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectConversationName(String project, String conversation) {
    return newBuilder().setProject(project).setConversation(conversation).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationConversationName(
      String project, String location, String conversation) {
    return newProjectLocationConversationBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .build()
        .toString();
  }

  public static ConversationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_CONVERSATION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_CONVERSATION.match(formattedString);
      return ofProjectConversationName(matchMap.get("project"), matchMap.get("conversation"));
    } else if (PROJECT_LOCATION_CONVERSATION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_CONVERSATION.match(formattedString);
      return ofProjectLocationConversationName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("conversation"));
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
    return PROJECT_CONVERSATION.matches(formattedString)
        || PROJECT_LOCATION_CONVERSATION.matches(formattedString);
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
          if (conversation != null) {
            fieldMapBuilder.put("conversation", conversation);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
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
      ConversationName that = ((ConversationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.conversation, that.conversation)
          && Objects.equals(this.location, that.location);
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
    h ^= Objects.hashCode(conversation);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/conversations/{conversation}. */
  public static class Builder {
    private String project;
    private String conversation;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getConversation() {
      return conversation;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setConversation(String conversation) {
      this.conversation = conversation;
      return this;
    }

    private Builder(ConversationName conversationName) {
      Preconditions.checkArgument(
          Objects.equals(conversationName.pathTemplate, PROJECT_CONVERSATION),
          "toBuilder is only supported when ConversationName has the pattern of projects/{project}/conversations/{conversation}");
      this.project = conversationName.project;
      this.conversation = conversationName.conversation;
    }

    public ConversationName build() {
      return new ConversationName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/conversations/{conversation}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationConversationBuilder {
    private String project;
    private String location;
    private String conversation;

    protected ProjectLocationConversationBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getConversation() {
      return conversation;
    }

    public ProjectLocationConversationBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationConversationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationConversationBuilder setConversation(String conversation) {
      this.conversation = conversation;
      return this;
    }

    public ConversationName build() {
      return new ConversationName(this);
    }
  }
}
