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
public class AnalysisName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CONVERSATION_ANALYSIS =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/conversations/{conversation}/analyses/{analysis}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String conversation;
  private final String analysis;

  @Deprecated
  protected AnalysisName() {
    project = null;
    location = null;
    conversation = null;
    analysis = null;
  }

  private AnalysisName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    analysis = Preconditions.checkNotNull(builder.getAnalysis());
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

  public static Builder newBuilder() {
    return new Builder();
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

  public static AnalysisName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CONVERSATION_ANALYSIS.validatedMatch(
            formattedString, "AnalysisName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("conversation"),
        matchMap.get("analysis"));
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
    return PROJECT_LOCATION_CONVERSATION_ANALYSIS.matches(formattedString);
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
    return PROJECT_LOCATION_CONVERSATION_ANALYSIS.instantiate(
        "project",
        project,
        "location",
        location,
        "conversation",
        conversation,
        "analysis",
        analysis);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      AnalysisName that = ((AnalysisName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.conversation, that.conversation)
          && Objects.equals(this.analysis, that.analysis);
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
    h ^= Objects.hashCode(analysis);
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
      this.project = analysisName.project;
      this.location = analysisName.location;
      this.conversation = analysisName.conversation;
      this.analysis = analysisName.analysis;
    }

    public AnalysisName build() {
      return new AnalysisName(this);
    }
  }
}
