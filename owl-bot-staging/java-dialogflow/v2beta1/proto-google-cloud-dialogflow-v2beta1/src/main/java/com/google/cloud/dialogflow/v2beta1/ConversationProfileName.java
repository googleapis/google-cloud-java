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
public class ConversationProfileName implements ResourceName {
  private static final PathTemplate PROJECT_CONVERSATION_PROFILE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/conversationProfiles/{conversation_profile}");
  private static final PathTemplate PROJECT_LOCATION_CONVERSATION_PROFILE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/conversationProfiles/{conversation_profile}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String conversationProfile;
  private final String location;

  @Deprecated
  protected ConversationProfileName() {
    project = null;
    conversationProfile = null;
    location = null;
  }

  private ConversationProfileName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    conversationProfile = Preconditions.checkNotNull(builder.getConversationProfile());
    location = null;
    pathTemplate = PROJECT_CONVERSATION_PROFILE;
  }

  private ConversationProfileName(ProjectLocationConversationProfileBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    conversationProfile = Preconditions.checkNotNull(builder.getConversationProfile());
    pathTemplate = PROJECT_LOCATION_CONVERSATION_PROFILE;
  }

  public String getProject() {
    return project;
  }

  public String getConversationProfile() {
    return conversationProfile;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectConversationProfileBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationConversationProfileBuilder
      newProjectLocationConversationProfileBuilder() {
    return new ProjectLocationConversationProfileBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ConversationProfileName of(String project, String conversationProfile) {
    return newBuilder().setProject(project).setConversationProfile(conversationProfile).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ConversationProfileName ofProjectConversationProfileName(
      String project, String conversationProfile) {
    return newBuilder().setProject(project).setConversationProfile(conversationProfile).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ConversationProfileName ofProjectLocationConversationProfileName(
      String project, String location, String conversationProfile) {
    return newProjectLocationConversationProfileBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversationProfile(conversationProfile)
        .build();
  }

  public static String format(String project, String conversationProfile) {
    return newBuilder()
        .setProject(project)
        .setConversationProfile(conversationProfile)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectConversationProfileName(
      String project, String conversationProfile) {
    return newBuilder()
        .setProject(project)
        .setConversationProfile(conversationProfile)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationConversationProfileName(
      String project, String location, String conversationProfile) {
    return newProjectLocationConversationProfileBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversationProfile(conversationProfile)
        .build()
        .toString();
  }

  public static ConversationProfileName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_CONVERSATION_PROFILE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_CONVERSATION_PROFILE.match(formattedString);
      return ofProjectConversationProfileName(
          matchMap.get("project"), matchMap.get("conversation_profile"));
    } else if (PROJECT_LOCATION_CONVERSATION_PROFILE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_CONVERSATION_PROFILE.match(formattedString);
      return ofProjectLocationConversationProfileName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("conversation_profile"));
    }
    throw new ValidationException(
        "ConversationProfileName.parse: formattedString not in valid format");
  }

  public static List<ConversationProfileName> parseList(List<String> formattedStrings) {
    List<ConversationProfileName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ConversationProfileName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ConversationProfileName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_CONVERSATION_PROFILE.matches(formattedString)
        || PROJECT_LOCATION_CONVERSATION_PROFILE.matches(formattedString);
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
          if (conversationProfile != null) {
            fieldMapBuilder.put("conversation_profile", conversationProfile);
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
      ConversationProfileName that = ((ConversationProfileName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.conversationProfile, that.conversationProfile)
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
    h ^= Objects.hashCode(conversationProfile);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/conversationProfiles/{conversation_profile}. */
  public static class Builder {
    private String project;
    private String conversationProfile;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getConversationProfile() {
      return conversationProfile;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setConversationProfile(String conversationProfile) {
      this.conversationProfile = conversationProfile;
      return this;
    }

    private Builder(ConversationProfileName conversationProfileName) {
      Preconditions.checkArgument(
          Objects.equals(conversationProfileName.pathTemplate, PROJECT_CONVERSATION_PROFILE),
          "toBuilder is only supported when ConversationProfileName has the pattern of projects/{project}/conversationProfiles/{conversation_profile}");
      this.project = conversationProfileName.project;
      this.conversationProfile = conversationProfileName.conversationProfile;
    }

    public ConversationProfileName build() {
      return new ConversationProfileName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/conversationProfiles/{conversation_profile}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationConversationProfileBuilder {
    private String project;
    private String location;
    private String conversationProfile;

    protected ProjectLocationConversationProfileBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getConversationProfile() {
      return conversationProfile;
    }

    public ProjectLocationConversationProfileBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationConversationProfileBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationConversationProfileBuilder setConversationProfile(
        String conversationProfile) {
      this.conversationProfile = conversationProfile;
      return this;
    }

    public ConversationProfileName build() {
      return new ConversationProfileName(this);
    }
  }
}
