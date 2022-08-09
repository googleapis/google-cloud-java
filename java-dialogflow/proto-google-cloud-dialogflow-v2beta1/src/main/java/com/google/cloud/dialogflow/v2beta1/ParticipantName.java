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
public class ParticipantName implements ResourceName {
  private static final PathTemplate PROJECT_CONVERSATION_PARTICIPANT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/conversations/{conversation}/participants/{participant}");
  private static final PathTemplate PROJECT_LOCATION_CONVERSATION_PARTICIPANT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/conversations/{conversation}/participants/{participant}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String conversation;
  private final String participant;
  private final String location;

  @Deprecated
  protected ParticipantName() {
    project = null;
    conversation = null;
    participant = null;
    location = null;
  }

  private ParticipantName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    participant = Preconditions.checkNotNull(builder.getParticipant());
    location = null;
    pathTemplate = PROJECT_CONVERSATION_PARTICIPANT;
  }

  private ParticipantName(ProjectLocationConversationParticipantBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    participant = Preconditions.checkNotNull(builder.getParticipant());
    pathTemplate = PROJECT_LOCATION_CONVERSATION_PARTICIPANT;
  }

  public String getProject() {
    return project;
  }

  public String getConversation() {
    return conversation;
  }

  public String getParticipant() {
    return participant;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectConversationParticipantBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationConversationParticipantBuilder
      newProjectLocationConversationParticipantBuilder() {
    return new ProjectLocationConversationParticipantBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ParticipantName of(String project, String conversation, String participant) {
    return newBuilder()
        .setProject(project)
        .setConversation(conversation)
        .setParticipant(participant)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ParticipantName ofProjectConversationParticipantName(
      String project, String conversation, String participant) {
    return newBuilder()
        .setProject(project)
        .setConversation(conversation)
        .setParticipant(participant)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ParticipantName ofProjectLocationConversationParticipantName(
      String project, String location, String conversation, String participant) {
    return newProjectLocationConversationParticipantBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .setParticipant(participant)
        .build();
  }

  public static String format(String project, String conversation, String participant) {
    return newBuilder()
        .setProject(project)
        .setConversation(conversation)
        .setParticipant(participant)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectConversationParticipantName(
      String project, String conversation, String participant) {
    return newBuilder()
        .setProject(project)
        .setConversation(conversation)
        .setParticipant(participant)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationConversationParticipantName(
      String project, String location, String conversation, String participant) {
    return newProjectLocationConversationParticipantBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .setParticipant(participant)
        .build()
        .toString();
  }

  public static ParticipantName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_CONVERSATION_PARTICIPANT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_CONVERSATION_PARTICIPANT.match(formattedString);
      return ofProjectConversationParticipantName(
          matchMap.get("project"), matchMap.get("conversation"), matchMap.get("participant"));
    } else if (PROJECT_LOCATION_CONVERSATION_PARTICIPANT.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_CONVERSATION_PARTICIPANT.match(formattedString);
      return ofProjectLocationConversationParticipantName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("conversation"),
          matchMap.get("participant"));
    }
    throw new ValidationException("ParticipantName.parse: formattedString not in valid format");
  }

  public static List<ParticipantName> parseList(List<String> formattedStrings) {
    List<ParticipantName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ParticipantName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ParticipantName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_CONVERSATION_PARTICIPANT.matches(formattedString)
        || PROJECT_LOCATION_CONVERSATION_PARTICIPANT.matches(formattedString);
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
          if (participant != null) {
            fieldMapBuilder.put("participant", participant);
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
      ParticipantName that = ((ParticipantName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.conversation, that.conversation)
          && Objects.equals(this.participant, that.participant)
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
    h ^= Objects.hashCode(participant);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/conversations/{conversation}/participants/{participant}. */
  public static class Builder {
    private String project;
    private String conversation;
    private String participant;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getConversation() {
      return conversation;
    }

    public String getParticipant() {
      return participant;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setConversation(String conversation) {
      this.conversation = conversation;
      return this;
    }

    public Builder setParticipant(String participant) {
      this.participant = participant;
      return this;
    }

    private Builder(ParticipantName participantName) {
      Preconditions.checkArgument(
          Objects.equals(participantName.pathTemplate, PROJECT_CONVERSATION_PARTICIPANT),
          "toBuilder is only supported when ParticipantName has the pattern of projects/{project}/conversations/{conversation}/participants/{participant}");
      this.project = participantName.project;
      this.conversation = participantName.conversation;
      this.participant = participantName.participant;
    }

    public ParticipantName build() {
      return new ParticipantName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/conversations/{conversation}/participants/{participant}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationConversationParticipantBuilder {
    private String project;
    private String location;
    private String conversation;
    private String participant;

    protected ProjectLocationConversationParticipantBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getConversation() {
      return conversation;
    }

    public String getParticipant() {
      return participant;
    }

    public ProjectLocationConversationParticipantBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationConversationParticipantBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationConversationParticipantBuilder setConversation(String conversation) {
      this.conversation = conversation;
      return this;
    }

    public ProjectLocationConversationParticipantBuilder setParticipant(String participant) {
      this.participant = participant;
      return this;
    }

    public ParticipantName build() {
      return new ParticipantName(this);
    }
  }
}
