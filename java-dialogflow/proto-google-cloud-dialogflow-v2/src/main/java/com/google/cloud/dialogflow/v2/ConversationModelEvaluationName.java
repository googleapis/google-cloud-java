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
public class ConversationModelEvaluationName implements ResourceName {
  private static final PathTemplate PROJECT_CONVERSATION_MODEL_EVALUATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/conversationModels/{conversation_model}/evaluations/{evaluation}");
  private static final PathTemplate PROJECT_LOCATION_CONVERSATION_MODEL_EVALUATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/conversationModels/{conversation_model}/evaluations/{evaluation}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String conversationModel;
  private final String evaluation;
  private final String location;

  @Deprecated
  protected ConversationModelEvaluationName() {
    project = null;
    conversationModel = null;
    evaluation = null;
    location = null;
  }

  private ConversationModelEvaluationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    conversationModel = Preconditions.checkNotNull(builder.getConversationModel());
    evaluation = Preconditions.checkNotNull(builder.getEvaluation());
    location = null;
    pathTemplate = PROJECT_CONVERSATION_MODEL_EVALUATION;
  }

  private ConversationModelEvaluationName(
      ProjectLocationConversationModelEvaluationBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    conversationModel = Preconditions.checkNotNull(builder.getConversationModel());
    evaluation = Preconditions.checkNotNull(builder.getEvaluation());
    pathTemplate = PROJECT_LOCATION_CONVERSATION_MODEL_EVALUATION;
  }

  public String getProject() {
    return project;
  }

  public String getConversationModel() {
    return conversationModel;
  }

  public String getEvaluation() {
    return evaluation;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectConversationModelEvaluationBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationConversationModelEvaluationBuilder
      newProjectLocationConversationModelEvaluationBuilder() {
    return new ProjectLocationConversationModelEvaluationBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ConversationModelEvaluationName of(
      String project, String conversationModel, String evaluation) {
    return newBuilder()
        .setProject(project)
        .setConversationModel(conversationModel)
        .setEvaluation(evaluation)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ConversationModelEvaluationName ofProjectConversationModelEvaluationName(
      String project, String conversationModel, String evaluation) {
    return newBuilder()
        .setProject(project)
        .setConversationModel(conversationModel)
        .setEvaluation(evaluation)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ConversationModelEvaluationName ofProjectLocationConversationModelEvaluationName(
      String project, String location, String conversationModel, String evaluation) {
    return newProjectLocationConversationModelEvaluationBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversationModel(conversationModel)
        .setEvaluation(evaluation)
        .build();
  }

  public static String format(String project, String conversationModel, String evaluation) {
    return newBuilder()
        .setProject(project)
        .setConversationModel(conversationModel)
        .setEvaluation(evaluation)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectConversationModelEvaluationName(
      String project, String conversationModel, String evaluation) {
    return newBuilder()
        .setProject(project)
        .setConversationModel(conversationModel)
        .setEvaluation(evaluation)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationConversationModelEvaluationName(
      String project, String location, String conversationModel, String evaluation) {
    return newProjectLocationConversationModelEvaluationBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversationModel(conversationModel)
        .setEvaluation(evaluation)
        .build()
        .toString();
  }

  public static ConversationModelEvaluationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_CONVERSATION_MODEL_EVALUATION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_CONVERSATION_MODEL_EVALUATION.match(formattedString);
      return ofProjectConversationModelEvaluationName(
          matchMap.get("project"), matchMap.get("conversation_model"), matchMap.get("evaluation"));
    } else if (PROJECT_LOCATION_CONVERSATION_MODEL_EVALUATION.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_CONVERSATION_MODEL_EVALUATION.match(formattedString);
      return ofProjectLocationConversationModelEvaluationName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("conversation_model"),
          matchMap.get("evaluation"));
    }
    throw new ValidationException(
        "ConversationModelEvaluationName.parse: formattedString not in valid format");
  }

  public static List<ConversationModelEvaluationName> parseList(List<String> formattedStrings) {
    List<ConversationModelEvaluationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ConversationModelEvaluationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ConversationModelEvaluationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_CONVERSATION_MODEL_EVALUATION.matches(formattedString)
        || PROJECT_LOCATION_CONVERSATION_MODEL_EVALUATION.matches(formattedString);
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
          if (conversationModel != null) {
            fieldMapBuilder.put("conversation_model", conversationModel);
          }
          if (evaluation != null) {
            fieldMapBuilder.put("evaluation", evaluation);
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
      ConversationModelEvaluationName that = ((ConversationModelEvaluationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.conversationModel, that.conversationModel)
          && Objects.equals(this.evaluation, that.evaluation)
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
    h ^= Objects.hashCode(conversationModel);
    h *= 1000003;
    h ^= Objects.hashCode(evaluation);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/conversationModels/{conversation_model}/evaluations/{evaluation}.
   */
  public static class Builder {
    private String project;
    private String conversationModel;
    private String evaluation;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getConversationModel() {
      return conversationModel;
    }

    public String getEvaluation() {
      return evaluation;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setConversationModel(String conversationModel) {
      this.conversationModel = conversationModel;
      return this;
    }

    public Builder setEvaluation(String evaluation) {
      this.evaluation = evaluation;
      return this;
    }

    private Builder(ConversationModelEvaluationName conversationModelEvaluationName) {
      Preconditions.checkArgument(
          Objects.equals(
              conversationModelEvaluationName.pathTemplate, PROJECT_CONVERSATION_MODEL_EVALUATION),
          "toBuilder is only supported when ConversationModelEvaluationName has the pattern of projects/{project}/conversationModels/{conversation_model}/evaluations/{evaluation}");
      this.project = conversationModelEvaluationName.project;
      this.conversationModel = conversationModelEvaluationName.conversationModel;
      this.evaluation = conversationModelEvaluationName.evaluation;
    }

    public ConversationModelEvaluationName build() {
      return new ConversationModelEvaluationName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/conversationModels/{conversation_model}/evaluations/{evaluation}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationConversationModelEvaluationBuilder {
    private String project;
    private String location;
    private String conversationModel;
    private String evaluation;

    protected ProjectLocationConversationModelEvaluationBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getConversationModel() {
      return conversationModel;
    }

    public String getEvaluation() {
      return evaluation;
    }

    public ProjectLocationConversationModelEvaluationBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationConversationModelEvaluationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationConversationModelEvaluationBuilder setConversationModel(
        String conversationModel) {
      this.conversationModel = conversationModel;
      return this;
    }

    public ProjectLocationConversationModelEvaluationBuilder setEvaluation(String evaluation) {
      this.evaluation = evaluation;
      return this;
    }

    public ConversationModelEvaluationName build() {
      return new ConversationModelEvaluationName(this);
    }
  }
}
