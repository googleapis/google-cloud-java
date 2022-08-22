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

package com.google.cloud.dialogflow.v2;

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
public class MessageName implements ResourceName {
  private static final PathTemplate PROJECT_CONVERSATION_MESSAGE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/conversations/{conversation}/messages/{message}");
  private static final PathTemplate PROJECT_LOCATION_CONVERSATION_MESSAGE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/conversations/{conversation}/messages/{message}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String conversation;
  private final String message;
  private final String location;

  @Deprecated
  protected MessageName() {
    project = null;
    conversation = null;
    message = null;
    location = null;
  }

  private MessageName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    message = Preconditions.checkNotNull(builder.getMessage());
    location = null;
    pathTemplate = PROJECT_CONVERSATION_MESSAGE;
  }

  private MessageName(ProjectLocationConversationMessageBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    message = Preconditions.checkNotNull(builder.getMessage());
    pathTemplate = PROJECT_LOCATION_CONVERSATION_MESSAGE;
  }

  public String getProject() {
    return project;
  }

  public String getConversation() {
    return conversation;
  }

  public String getMessage() {
    return message;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectConversationMessageBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationConversationMessageBuilder
      newProjectLocationConversationMessageBuilder() {
    return new ProjectLocationConversationMessageBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MessageName of(String project, String conversation, String message) {
    return newBuilder()
        .setProject(project)
        .setConversation(conversation)
        .setMessage(message)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static MessageName ofProjectConversationMessageName(
      String project, String conversation, String message) {
    return newBuilder()
        .setProject(project)
        .setConversation(conversation)
        .setMessage(message)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static MessageName ofProjectLocationConversationMessageName(
      String project, String location, String conversation, String message) {
    return newProjectLocationConversationMessageBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .setMessage(message)
        .build();
  }

  public static String format(String project, String conversation, String message) {
    return newBuilder()
        .setProject(project)
        .setConversation(conversation)
        .setMessage(message)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectConversationMessageName(
      String project, String conversation, String message) {
    return newBuilder()
        .setProject(project)
        .setConversation(conversation)
        .setMessage(message)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationConversationMessageName(
      String project, String location, String conversation, String message) {
    return newProjectLocationConversationMessageBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .setMessage(message)
        .build()
        .toString();
  }

  public static MessageName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_CONVERSATION_MESSAGE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_CONVERSATION_MESSAGE.match(formattedString);
      return ofProjectConversationMessageName(
          matchMap.get("project"), matchMap.get("conversation"), matchMap.get("message"));
    } else if (PROJECT_LOCATION_CONVERSATION_MESSAGE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_CONVERSATION_MESSAGE.match(formattedString);
      return ofProjectLocationConversationMessageName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("conversation"),
          matchMap.get("message"));
    }
    throw new ValidationException("MessageName.parse: formattedString not in valid format");
  }

  public static List<MessageName> parseList(List<String> formattedStrings) {
    List<MessageName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MessageName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MessageName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_CONVERSATION_MESSAGE.matches(formattedString)
        || PROJECT_LOCATION_CONVERSATION_MESSAGE.matches(formattedString);
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
          if (message != null) {
            fieldMapBuilder.put("message", message);
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
      MessageName that = ((MessageName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.conversation, that.conversation)
          && Objects.equals(this.message, that.message)
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
    h ^= Objects.hashCode(message);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/conversations/{conversation}/messages/{message}. */
  public static class Builder {
    private String project;
    private String conversation;
    private String message;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getConversation() {
      return conversation;
    }

    public String getMessage() {
      return message;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setConversation(String conversation) {
      this.conversation = conversation;
      return this;
    }

    public Builder setMessage(String message) {
      this.message = message;
      return this;
    }

    private Builder(MessageName messageName) {
      Preconditions.checkArgument(
          Objects.equals(messageName.pathTemplate, PROJECT_CONVERSATION_MESSAGE),
          "toBuilder is only supported when MessageName has the pattern of projects/{project}/conversations/{conversation}/messages/{message}");
      this.project = messageName.project;
      this.conversation = messageName.conversation;
      this.message = messageName.message;
    }

    public MessageName build() {
      return new MessageName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/conversations/{conversation}/messages/{message}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationConversationMessageBuilder {
    private String project;
    private String location;
    private String conversation;
    private String message;

    protected ProjectLocationConversationMessageBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getConversation() {
      return conversation;
    }

    public String getMessage() {
      return message;
    }

    public ProjectLocationConversationMessageBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationConversationMessageBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationConversationMessageBuilder setConversation(String conversation) {
      this.conversation = conversation;
      return this;
    }

    public ProjectLocationConversationMessageBuilder setMessage(String message) {
      this.message = message;
      return this;
    }

    public MessageName build() {
      return new MessageName(this);
    }
  }
}
