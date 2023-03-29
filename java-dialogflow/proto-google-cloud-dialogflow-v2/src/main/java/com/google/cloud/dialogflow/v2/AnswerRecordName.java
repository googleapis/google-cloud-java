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
public class AnswerRecordName implements ResourceName {
  private static final PathTemplate PROJECT_ANSWER_RECORD =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/answerRecords/{answer_record}");
  private static final PathTemplate PROJECT_LOCATION_ANSWER_RECORD =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/answerRecords/{answer_record}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String answerRecord;
  private final String location;

  @Deprecated
  protected AnswerRecordName() {
    project = null;
    answerRecord = null;
    location = null;
  }

  private AnswerRecordName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    answerRecord = Preconditions.checkNotNull(builder.getAnswerRecord());
    location = null;
    pathTemplate = PROJECT_ANSWER_RECORD;
  }

  private AnswerRecordName(ProjectLocationAnswerRecordBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    answerRecord = Preconditions.checkNotNull(builder.getAnswerRecord());
    pathTemplate = PROJECT_LOCATION_ANSWER_RECORD;
  }

  public String getProject() {
    return project;
  }

  public String getAnswerRecord() {
    return answerRecord;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectAnswerRecordBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationAnswerRecordBuilder newProjectLocationAnswerRecordBuilder() {
    return new ProjectLocationAnswerRecordBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AnswerRecordName of(String project, String answerRecord) {
    return newBuilder().setProject(project).setAnswerRecord(answerRecord).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static AnswerRecordName ofProjectAnswerRecordName(String project, String answerRecord) {
    return newBuilder().setProject(project).setAnswerRecord(answerRecord).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static AnswerRecordName ofProjectLocationAnswerRecordName(
      String project, String location, String answerRecord) {
    return newProjectLocationAnswerRecordBuilder()
        .setProject(project)
        .setLocation(location)
        .setAnswerRecord(answerRecord)
        .build();
  }

  public static String format(String project, String answerRecord) {
    return newBuilder().setProject(project).setAnswerRecord(answerRecord).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectAnswerRecordName(String project, String answerRecord) {
    return newBuilder().setProject(project).setAnswerRecord(answerRecord).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationAnswerRecordName(
      String project, String location, String answerRecord) {
    return newProjectLocationAnswerRecordBuilder()
        .setProject(project)
        .setLocation(location)
        .setAnswerRecord(answerRecord)
        .build()
        .toString();
  }

  public static AnswerRecordName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_ANSWER_RECORD.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_ANSWER_RECORD.match(formattedString);
      return ofProjectAnswerRecordName(matchMap.get("project"), matchMap.get("answer_record"));
    } else if (PROJECT_LOCATION_ANSWER_RECORD.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_ANSWER_RECORD.match(formattedString);
      return ofProjectLocationAnswerRecordName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("answer_record"));
    }
    throw new ValidationException("AnswerRecordName.parse: formattedString not in valid format");
  }

  public static List<AnswerRecordName> parseList(List<String> formattedStrings) {
    List<AnswerRecordName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AnswerRecordName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AnswerRecordName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_ANSWER_RECORD.matches(formattedString)
        || PROJECT_LOCATION_ANSWER_RECORD.matches(formattedString);
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
          if (answerRecord != null) {
            fieldMapBuilder.put("answer_record", answerRecord);
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
      AnswerRecordName that = ((AnswerRecordName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.answerRecord, that.answerRecord)
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
    h ^= Objects.hashCode(answerRecord);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/answerRecords/{answer_record}. */
  public static class Builder {
    private String project;
    private String answerRecord;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getAnswerRecord() {
      return answerRecord;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setAnswerRecord(String answerRecord) {
      this.answerRecord = answerRecord;
      return this;
    }

    private Builder(AnswerRecordName answerRecordName) {
      Preconditions.checkArgument(
          Objects.equals(answerRecordName.pathTemplate, PROJECT_ANSWER_RECORD),
          "toBuilder is only supported when AnswerRecordName has the pattern of projects/{project}/answerRecords/{answer_record}");
      this.project = answerRecordName.project;
      this.answerRecord = answerRecordName.answerRecord;
    }

    public AnswerRecordName build() {
      return new AnswerRecordName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/answerRecords/{answer_record}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationAnswerRecordBuilder {
    private String project;
    private String location;
    private String answerRecord;

    protected ProjectLocationAnswerRecordBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAnswerRecord() {
      return answerRecord;
    }

    public ProjectLocationAnswerRecordBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationAnswerRecordBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationAnswerRecordBuilder setAnswerRecord(String answerRecord) {
      this.answerRecord = answerRecord;
      return this;
    }

    public AnswerRecordName build() {
      return new AnswerRecordName(this);
    }
  }
}
