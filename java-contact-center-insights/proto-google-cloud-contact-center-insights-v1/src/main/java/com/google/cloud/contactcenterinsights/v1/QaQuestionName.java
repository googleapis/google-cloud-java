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
public class QaQuestionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_QA_SCORECARD_REVISION_QA_QUESTION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/qaScorecards/{qa_scorecard}/revisions/{revision}/qaQuestions/{qa_question}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String qaScorecard;
  private final String revision;
  private final String qaQuestion;

  @Deprecated
  protected QaQuestionName() {
    project = null;
    location = null;
    qaScorecard = null;
    revision = null;
    qaQuestion = null;
  }

  private QaQuestionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    qaScorecard = Preconditions.checkNotNull(builder.getQaScorecard());
    revision = Preconditions.checkNotNull(builder.getRevision());
    qaQuestion = Preconditions.checkNotNull(builder.getQaQuestion());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getQaScorecard() {
    return qaScorecard;
  }

  public String getRevision() {
    return revision;
  }

  public String getQaQuestion() {
    return qaQuestion;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static QaQuestionName of(
      String project, String location, String qaScorecard, String revision, String qaQuestion) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setQaScorecard(qaScorecard)
        .setRevision(revision)
        .setQaQuestion(qaQuestion)
        .build();
  }

  public static String format(
      String project, String location, String qaScorecard, String revision, String qaQuestion) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setQaScorecard(qaScorecard)
        .setRevision(revision)
        .setQaQuestion(qaQuestion)
        .build()
        .toString();
  }

  public static QaQuestionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_QA_SCORECARD_REVISION_QA_QUESTION.validatedMatch(
            formattedString, "QaQuestionName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("qa_scorecard"),
        matchMap.get("revision"),
        matchMap.get("qa_question"));
  }

  public static List<QaQuestionName> parseList(List<String> formattedStrings) {
    List<QaQuestionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<QaQuestionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (QaQuestionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_QA_SCORECARD_REVISION_QA_QUESTION.matches(formattedString);
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
          if (qaScorecard != null) {
            fieldMapBuilder.put("qa_scorecard", qaScorecard);
          }
          if (revision != null) {
            fieldMapBuilder.put("revision", revision);
          }
          if (qaQuestion != null) {
            fieldMapBuilder.put("qa_question", qaQuestion);
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
    return PROJECT_LOCATION_QA_SCORECARD_REVISION_QA_QUESTION.instantiate(
        "project",
        project,
        "location",
        location,
        "qa_scorecard",
        qaScorecard,
        "revision",
        revision,
        "qa_question",
        qaQuestion);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      QaQuestionName that = ((QaQuestionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.qaScorecard, that.qaScorecard)
          && Objects.equals(this.revision, that.revision)
          && Objects.equals(this.qaQuestion, that.qaQuestion);
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
    h ^= Objects.hashCode(qaScorecard);
    h *= 1000003;
    h ^= Objects.hashCode(revision);
    h *= 1000003;
    h ^= Objects.hashCode(qaQuestion);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/qaScorecards/{qa_scorecard}/revisions/{revision}/qaQuestions/{qa_question}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String qaScorecard;
    private String revision;
    private String qaQuestion;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getQaScorecard() {
      return qaScorecard;
    }

    public String getRevision() {
      return revision;
    }

    public String getQaQuestion() {
      return qaQuestion;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setQaScorecard(String qaScorecard) {
      this.qaScorecard = qaScorecard;
      return this;
    }

    public Builder setRevision(String revision) {
      this.revision = revision;
      return this;
    }

    public Builder setQaQuestion(String qaQuestion) {
      this.qaQuestion = qaQuestion;
      return this;
    }

    private Builder(QaQuestionName qaQuestionName) {
      this.project = qaQuestionName.project;
      this.location = qaQuestionName.location;
      this.qaScorecard = qaQuestionName.qaScorecard;
      this.revision = qaQuestionName.revision;
      this.qaQuestion = qaQuestionName.qaQuestion;
    }

    public QaQuestionName build() {
      return new QaQuestionName(this);
    }
  }
}
