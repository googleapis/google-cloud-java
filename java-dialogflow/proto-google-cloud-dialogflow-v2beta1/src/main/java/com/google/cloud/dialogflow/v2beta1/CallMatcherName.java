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
public class CallMatcherName implements ResourceName {
  private static final PathTemplate PROJECT_CONVERSATION_CALL_MATCHER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/conversations/{conversation}/callMatchers/{call_matcher}");
  private static final PathTemplate PROJECT_LOCATION_CONVERSATION_CALL_MATCHER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/conversations/{conversation}/callMatchers/{call_matcher}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String conversation;
  private final String callMatcher;
  private final String location;

  @Deprecated
  protected CallMatcherName() {
    project = null;
    conversation = null;
    callMatcher = null;
    location = null;
  }

  private CallMatcherName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    callMatcher = Preconditions.checkNotNull(builder.getCallMatcher());
    location = null;
    pathTemplate = PROJECT_CONVERSATION_CALL_MATCHER;
  }

  private CallMatcherName(ProjectLocationConversationCallMatcherBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    callMatcher = Preconditions.checkNotNull(builder.getCallMatcher());
    pathTemplate = PROJECT_LOCATION_CONVERSATION_CALL_MATCHER;
  }

  public String getProject() {
    return project;
  }

  public String getConversation() {
    return conversation;
  }

  public String getCallMatcher() {
    return callMatcher;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectConversationCallMatcherBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationConversationCallMatcherBuilder
      newProjectLocationConversationCallMatcherBuilder() {
    return new ProjectLocationConversationCallMatcherBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CallMatcherName of(String project, String conversation, String callMatcher) {
    return newBuilder()
        .setProject(project)
        .setConversation(conversation)
        .setCallMatcher(callMatcher)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static CallMatcherName ofProjectConversationCallMatcherName(
      String project, String conversation, String callMatcher) {
    return newBuilder()
        .setProject(project)
        .setConversation(conversation)
        .setCallMatcher(callMatcher)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static CallMatcherName ofProjectLocationConversationCallMatcherName(
      String project, String location, String conversation, String callMatcher) {
    return newProjectLocationConversationCallMatcherBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .setCallMatcher(callMatcher)
        .build();
  }

  public static String format(String project, String conversation, String callMatcher) {
    return newBuilder()
        .setProject(project)
        .setConversation(conversation)
        .setCallMatcher(callMatcher)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectConversationCallMatcherName(
      String project, String conversation, String callMatcher) {
    return newBuilder()
        .setProject(project)
        .setConversation(conversation)
        .setCallMatcher(callMatcher)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationConversationCallMatcherName(
      String project, String location, String conversation, String callMatcher) {
    return newProjectLocationConversationCallMatcherBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .setCallMatcher(callMatcher)
        .build()
        .toString();
  }

  public static CallMatcherName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_CONVERSATION_CALL_MATCHER.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_CONVERSATION_CALL_MATCHER.match(formattedString);
      return ofProjectConversationCallMatcherName(
          matchMap.get("project"), matchMap.get("conversation"), matchMap.get("call_matcher"));
    } else if (PROJECT_LOCATION_CONVERSATION_CALL_MATCHER.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_CONVERSATION_CALL_MATCHER.match(formattedString);
      return ofProjectLocationConversationCallMatcherName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("conversation"),
          matchMap.get("call_matcher"));
    }
    throw new ValidationException("CallMatcherName.parse: formattedString not in valid format");
  }

  public static List<CallMatcherName> parseList(List<String> formattedStrings) {
    List<CallMatcherName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CallMatcherName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CallMatcherName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_CONVERSATION_CALL_MATCHER.matches(formattedString)
        || PROJECT_LOCATION_CONVERSATION_CALL_MATCHER.matches(formattedString);
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
          if (callMatcher != null) {
            fieldMapBuilder.put("call_matcher", callMatcher);
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
      CallMatcherName that = ((CallMatcherName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.conversation, that.conversation)
          && Objects.equals(this.callMatcher, that.callMatcher)
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
    h ^= Objects.hashCode(callMatcher);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/conversations/{conversation}/callMatchers/{call_matcher}. */
  public static class Builder {
    private String project;
    private String conversation;
    private String callMatcher;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getConversation() {
      return conversation;
    }

    public String getCallMatcher() {
      return callMatcher;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setConversation(String conversation) {
      this.conversation = conversation;
      return this;
    }

    public Builder setCallMatcher(String callMatcher) {
      this.callMatcher = callMatcher;
      return this;
    }

    private Builder(CallMatcherName callMatcherName) {
      Preconditions.checkArgument(
          Objects.equals(callMatcherName.pathTemplate, PROJECT_CONVERSATION_CALL_MATCHER),
          "toBuilder is only supported when CallMatcherName has the pattern of projects/{project}/conversations/{conversation}/callMatchers/{call_matcher}");
      project = callMatcherName.project;
      conversation = callMatcherName.conversation;
      callMatcher = callMatcherName.callMatcher;
    }

    public CallMatcherName build() {
      return new CallMatcherName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/conversations/{conversation}/callMatchers/{call_matcher}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationConversationCallMatcherBuilder {
    private String project;
    private String location;
    private String conversation;
    private String callMatcher;

    protected ProjectLocationConversationCallMatcherBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getConversation() {
      return conversation;
    }

    public String getCallMatcher() {
      return callMatcher;
    }

    public ProjectLocationConversationCallMatcherBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationConversationCallMatcherBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationConversationCallMatcherBuilder setConversation(String conversation) {
      this.conversation = conversation;
      return this;
    }

    public ProjectLocationConversationCallMatcherBuilder setCallMatcher(String callMatcher) {
      this.callMatcher = callMatcher;
      return this;
    }

    public CallMatcherName build() {
      return new CallMatcherName(this);
    }
  }
}
