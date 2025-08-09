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

package com.google.cloud.support.v2beta;

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
public class CommentName implements ResourceName {
  private static final PathTemplate ORGANIZATION_CASE_COMMENT =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/cases/{case}/comments/{comment}");
  private static final PathTemplate PROJECT_CASE_COMMENT =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/cases/{case}/comments/{comment}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String case_;
  private final String comment;
  private final String project;

  @Deprecated
  protected CommentName() {
    organization = null;
    case_ = null;
    comment = null;
    project = null;
  }

  private CommentName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    case_ = Preconditions.checkNotNull(builder.getCase());
    comment = Preconditions.checkNotNull(builder.getComment());
    project = null;
    pathTemplate = ORGANIZATION_CASE_COMMENT;
  }

  private CommentName(ProjectCaseCommentBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    case_ = Preconditions.checkNotNull(builder.getCase());
    comment = Preconditions.checkNotNull(builder.getComment());
    organization = null;
    pathTemplate = PROJECT_CASE_COMMENT;
  }

  public String getOrganization() {
    return organization;
  }

  public String getCase() {
    return case_;
  }

  public String getComment() {
    return comment;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationCaseCommentBuilder() {
    return new Builder();
  }

  public static ProjectCaseCommentBuilder newProjectCaseCommentBuilder() {
    return new ProjectCaseCommentBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CommentName of(String organization, String case_, String comment) {
    return newBuilder().setOrganization(organization).setCase(case_).setComment(comment).build();
  }

  public static CommentName ofOrganizationCaseCommentName(
      String organization, String case_, String comment) {
    return newBuilder().setOrganization(organization).setCase(case_).setComment(comment).build();
  }

  public static CommentName ofProjectCaseCommentName(String project, String case_, String comment) {
    return newProjectCaseCommentBuilder()
        .setProject(project)
        .setCase(case_)
        .setComment(comment)
        .build();
  }

  public static String format(String organization, String case_, String comment) {
    return newBuilder()
        .setOrganization(organization)
        .setCase(case_)
        .setComment(comment)
        .build()
        .toString();
  }

  public static String formatOrganizationCaseCommentName(
      String organization, String case_, String comment) {
    return newBuilder()
        .setOrganization(organization)
        .setCase(case_)
        .setComment(comment)
        .build()
        .toString();
  }

  public static String formatProjectCaseCommentName(String project, String case_, String comment) {
    return newProjectCaseCommentBuilder()
        .setProject(project)
        .setCase(case_)
        .setComment(comment)
        .build()
        .toString();
  }

  public static CommentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_CASE_COMMENT.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_CASE_COMMENT.match(formattedString);
      return ofOrganizationCaseCommentName(
          matchMap.get("organization"), matchMap.get("case"), matchMap.get("comment"));
    } else if (PROJECT_CASE_COMMENT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_CASE_COMMENT.match(formattedString);
      return ofProjectCaseCommentName(
          matchMap.get("project"), matchMap.get("case"), matchMap.get("comment"));
    }
    throw new ValidationException("CommentName.parse: formattedString not in valid format");
  }

  public static List<CommentName> parseList(List<String> formattedStrings) {
    List<CommentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CommentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CommentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_CASE_COMMENT.matches(formattedString)
        || PROJECT_CASE_COMMENT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (case_ != null) {
            fieldMapBuilder.put("case", case_);
          }
          if (comment != null) {
            fieldMapBuilder.put("comment", comment);
          }
          if (project != null) {
            fieldMapBuilder.put("project", project);
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
      CommentName that = ((CommentName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.case_, that.case_)
          && Objects.equals(this.comment, that.comment)
          && Objects.equals(this.project, that.project);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(case_);
    h *= 1000003;
    h ^= Objects.hashCode(comment);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for organizations/{organization}/cases/{case}/comments/{comment}. */
  public static class Builder {
    private String organization;
    private String case_;
    private String comment;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getCase() {
      return case_;
    }

    public String getComment() {
      return comment;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setCase(String case_) {
      this.case_ = case_;
      return this;
    }

    public Builder setComment(String comment) {
      this.comment = comment;
      return this;
    }

    private Builder(CommentName commentName) {
      Preconditions.checkArgument(
          Objects.equals(commentName.pathTemplate, ORGANIZATION_CASE_COMMENT),
          "toBuilder is only supported when CommentName has the pattern of"
              + " organizations/{organization}/cases/{case}/comments/{comment}");
      this.organization = commentName.organization;
      this.case_ = commentName.case_;
      this.comment = commentName.comment;
    }

    public CommentName build() {
      return new CommentName(this);
    }
  }

  /** Builder for projects/{project}/cases/{case}/comments/{comment}. */
  public static class ProjectCaseCommentBuilder {
    private String project;
    private String case_;
    private String comment;

    protected ProjectCaseCommentBuilder() {}

    public String getProject() {
      return project;
    }

    public String getCase() {
      return case_;
    }

    public String getComment() {
      return comment;
    }

    public ProjectCaseCommentBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectCaseCommentBuilder setCase(String case_) {
      this.case_ = case_;
      return this;
    }

    public ProjectCaseCommentBuilder setComment(String comment) {
      this.comment = comment;
      return this;
    }

    public CommentName build() {
      return new CommentName(this);
    }
  }
}
