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
public class AnalysisName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CONVERSATION_ANALYSIS =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/conversations/{conversation}/analyses/{analysis}");
  private static final PathTemplate
      PROJECT_LOCATION_AUTHORIZED_VIEW_SET_AUTHORIZED_VIEW_CONVERSATION_ANALYSIS =
          PathTemplate.createWithoutUrlEncoding(
              "projects/{project}/locations/{location}/authorizedViewSets/{authorized_view_set}/authorizedViews/{authorized_view}/conversations/{conversation}/analyses/{analysis}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String conversation;
  private final String analysis;
  private final String authorizedViewSet;
  private final String authorizedView;

  @Deprecated
  protected AnalysisName() {
    project = null;
    location = null;
    conversation = null;
    analysis = null;
    authorizedViewSet = null;
    authorizedView = null;
  }

  private AnalysisName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    analysis = Preconditions.checkNotNull(builder.getAnalysis());
    authorizedViewSet = null;
    authorizedView = null;
    pathTemplate = PROJECT_LOCATION_CONVERSATION_ANALYSIS;
  }

  private AnalysisName(
      ProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    authorizedViewSet = Preconditions.checkNotNull(builder.getAuthorizedViewSet());
    authorizedView = Preconditions.checkNotNull(builder.getAuthorizedView());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    analysis = Preconditions.checkNotNull(builder.getAnalysis());
    pathTemplate = PROJECT_LOCATION_AUTHORIZED_VIEW_SET_AUTHORIZED_VIEW_CONVERSATION_ANALYSIS;
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

  public String getAnalysis() {
    return analysis;
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

  public static Builder newProjectLocationConversationAnalysisBuilder() {
    return new Builder();
  }

  public static ProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisBuilder
      newProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisBuilder() {
    return new ProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AnalysisName of(
      String project, String location, String conversation, String analysis) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .setAnalysis(analysis)
        .build();
  }

  public static AnalysisName ofProjectLocationConversationAnalysisName(
      String project, String location, String conversation, String analysis) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .setAnalysis(analysis)
        .build();
  }

  public static AnalysisName
      ofProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisName(
          String project,
          String location,
          String authorizedViewSet,
          String authorizedView,
          String conversation,
          String analysis) {
    return newProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisBuilder()
        .setProject(project)
        .setLocation(location)
        .setAuthorizedViewSet(authorizedViewSet)
        .setAuthorizedView(authorizedView)
        .setConversation(conversation)
        .setAnalysis(analysis)
        .build();
  }

  public static String format(
      String project, String location, String conversation, String analysis) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .setAnalysis(analysis)
        .build()
        .toString();
  }

  public static String formatProjectLocationConversationAnalysisName(
      String project, String location, String conversation, String analysis) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversation(conversation)
        .setAnalysis(analysis)
        .build()
        .toString();
  }

  public static String formatProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisName(
      String project,
      String location,
      String authorizedViewSet,
      String authorizedView,
      String conversation,
      String analysis) {
    return newProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisBuilder()
        .setProject(project)
        .setLocation(location)
        .setAuthorizedViewSet(authorizedViewSet)
        .setAuthorizedView(authorizedView)
        .setConversation(conversation)
        .setAnalysis(analysis)
        .build()
        .toString();
  }

  public static AnalysisName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_CONVERSATION_ANALYSIS.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_CONVERSATION_ANALYSIS.match(formattedString);
      return ofProjectLocationConversationAnalysisName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("conversation"),
          matchMap.get("analysis"));
    } else if (PROJECT_LOCATION_AUTHORIZED_VIEW_SET_AUTHORIZED_VIEW_CONVERSATION_ANALYSIS.matches(
        formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_AUTHORIZED_VIEW_SET_AUTHORIZED_VIEW_CONVERSATION_ANALYSIS.match(
              formattedString);
      return ofProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("authorized_view_set"),
          matchMap.get("authorized_view"),
          matchMap.get("conversation"),
          matchMap.get("analysis"));
    }
    throw new ValidationException("AnalysisName.parse: formattedString not in valid format");
  }

  public static List<AnalysisName> parseList(List<String> formattedStrings) {
    List<AnalysisName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AnalysisName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AnalysisName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CONVERSATION_ANALYSIS.matches(formattedString)
        || PROJECT_LOCATION_AUTHORIZED_VIEW_SET_AUTHORIZED_VIEW_CONVERSATION_ANALYSIS.matches(
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
          if (analysis != null) {
            fieldMapBuilder.put("analysis", analysis);
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
      AnalysisName that = ((AnalysisName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.conversation, that.conversation)
          && Objects.equals(this.analysis, that.analysis)
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
    h ^= Objects.hashCode(analysis);
    h *= 1000003;
    h ^= Objects.hashCode(authorizedViewSet);
    h *= 1000003;
    h ^= Objects.hashCode(authorizedView);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/conversations/{conversation}/analyses/{analysis}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String conversation;
    private String analysis;

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

    public String getAnalysis() {
      return analysis;
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

    public Builder setAnalysis(String analysis) {
      this.analysis = analysis;
      return this;
    }

    private Builder(AnalysisName analysisName) {
      Preconditions.checkArgument(
          Objects.equals(analysisName.pathTemplate, PROJECT_LOCATION_CONVERSATION_ANALYSIS),
          "toBuilder is only supported when AnalysisName has the pattern of projects/{project}/locations/{location}/conversations/{conversation}/analyses/{analysis}");
      this.project = analysisName.project;
      this.location = analysisName.location;
      this.conversation = analysisName.conversation;
      this.analysis = analysisName.analysis;
    }

    public AnalysisName build() {
      return new AnalysisName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/authorizedViewSets/{authorized_view_set}/authorizedViews/{authorized_view}/conversations/{conversation}/analyses/{analysis}.
   */
  public static class ProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisBuilder {
    private String project;
    private String location;
    private String authorizedViewSet;
    private String authorizedView;
    private String conversation;
    private String analysis;

    protected ProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisBuilder() {}

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

    public String getAnalysis() {
      return analysis;
    }

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisBuilder setProject(
        String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisBuilder setLocation(
        String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisBuilder
        setAuthorizedViewSet(String authorizedViewSet) {
      this.authorizedViewSet = authorizedViewSet;
      return this;
    }

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisBuilder
        setAuthorizedView(String authorizedView) {
      this.authorizedView = authorizedView;
      return this;
    }

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisBuilder
        setConversation(String conversation) {
      this.conversation = conversation;
      return this;
    }

    public ProjectLocationAuthorizedViewSetAuthorizedViewConversationAnalysisBuilder setAnalysis(
        String analysis) {
      this.analysis = analysis;
      return this;
    }

    public AnalysisName build() {
      return new AnalysisName(this);
    }
  }
}
