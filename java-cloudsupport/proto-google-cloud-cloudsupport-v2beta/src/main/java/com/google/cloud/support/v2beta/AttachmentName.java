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
public class AttachmentName implements ResourceName {
  private static final PathTemplate ORGANIZATION_CASE_ATTACHMENT_ID =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/cases/{case}/attachments/{attachment_id}");
  private static final PathTemplate PROJECT_CASE_ATTACHMENT_ID =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/cases/{case}/attachments/{attachment_id}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String case_;
  private final String attachmentId;
  private final String project;

  @Deprecated
  protected AttachmentName() {
    organization = null;
    case_ = null;
    attachmentId = null;
    project = null;
  }

  private AttachmentName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    case_ = Preconditions.checkNotNull(builder.getCase());
    attachmentId = Preconditions.checkNotNull(builder.getAttachmentId());
    project = null;
    pathTemplate = ORGANIZATION_CASE_ATTACHMENT_ID;
  }

  private AttachmentName(ProjectCaseAttachmentIdBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    case_ = Preconditions.checkNotNull(builder.getCase());
    attachmentId = Preconditions.checkNotNull(builder.getAttachmentId());
    organization = null;
    pathTemplate = PROJECT_CASE_ATTACHMENT_ID;
  }

  public String getOrganization() {
    return organization;
  }

  public String getCase() {
    return case_;
  }

  public String getAttachmentId() {
    return attachmentId;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationCaseAttachmentIdBuilder() {
    return new Builder();
  }

  public static ProjectCaseAttachmentIdBuilder newProjectCaseAttachmentIdBuilder() {
    return new ProjectCaseAttachmentIdBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AttachmentName of(String organization, String case_, String attachmentId) {
    return newBuilder()
        .setOrganization(organization)
        .setCase(case_)
        .setAttachmentId(attachmentId)
        .build();
  }

  public static AttachmentName ofOrganizationCaseAttachmentIdName(
      String organization, String case_, String attachmentId) {
    return newBuilder()
        .setOrganization(organization)
        .setCase(case_)
        .setAttachmentId(attachmentId)
        .build();
  }

  public static AttachmentName ofProjectCaseAttachmentIdName(
      String project, String case_, String attachmentId) {
    return newProjectCaseAttachmentIdBuilder()
        .setProject(project)
        .setCase(case_)
        .setAttachmentId(attachmentId)
        .build();
  }

  public static String format(String organization, String case_, String attachmentId) {
    return newBuilder()
        .setOrganization(organization)
        .setCase(case_)
        .setAttachmentId(attachmentId)
        .build()
        .toString();
  }

  public static String formatOrganizationCaseAttachmentIdName(
      String organization, String case_, String attachmentId) {
    return newBuilder()
        .setOrganization(organization)
        .setCase(case_)
        .setAttachmentId(attachmentId)
        .build()
        .toString();
  }

  public static String formatProjectCaseAttachmentIdName(
      String project, String case_, String attachmentId) {
    return newProjectCaseAttachmentIdBuilder()
        .setProject(project)
        .setCase(case_)
        .setAttachmentId(attachmentId)
        .build()
        .toString();
  }

  public static AttachmentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_CASE_ATTACHMENT_ID.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_CASE_ATTACHMENT_ID.match(formattedString);
      return ofOrganizationCaseAttachmentIdName(
          matchMap.get("organization"), matchMap.get("case"), matchMap.get("attachment_id"));
    } else if (PROJECT_CASE_ATTACHMENT_ID.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_CASE_ATTACHMENT_ID.match(formattedString);
      return ofProjectCaseAttachmentIdName(
          matchMap.get("project"), matchMap.get("case"), matchMap.get("attachment_id"));
    }
    throw new ValidationException("AttachmentName.parse: formattedString not in valid format");
  }

  public static List<AttachmentName> parseList(List<String> formattedStrings) {
    List<AttachmentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AttachmentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AttachmentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_CASE_ATTACHMENT_ID.matches(formattedString)
        || PROJECT_CASE_ATTACHMENT_ID.matches(formattedString);
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
          if (attachmentId != null) {
            fieldMapBuilder.put("attachment_id", attachmentId);
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
      AttachmentName that = ((AttachmentName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.case_, that.case_)
          && Objects.equals(this.attachmentId, that.attachmentId)
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
    h ^= Objects.hashCode(attachmentId);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for organizations/{organization}/cases/{case}/attachments/{attachment_id}. */
  public static class Builder {
    private String organization;
    private String case_;
    private String attachmentId;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getCase() {
      return case_;
    }

    public String getAttachmentId() {
      return attachmentId;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setCase(String case_) {
      this.case_ = case_;
      return this;
    }

    public Builder setAttachmentId(String attachmentId) {
      this.attachmentId = attachmentId;
      return this;
    }

    private Builder(AttachmentName attachmentName) {
      Preconditions.checkArgument(
          Objects.equals(attachmentName.pathTemplate, ORGANIZATION_CASE_ATTACHMENT_ID),
          "toBuilder is only supported when AttachmentName has the pattern of"
              + " organizations/{organization}/cases/{case}/attachments/{attachment_id}");
      this.organization = attachmentName.organization;
      this.case_ = attachmentName.case_;
      this.attachmentId = attachmentName.attachmentId;
    }

    public AttachmentName build() {
      return new AttachmentName(this);
    }
  }

  /** Builder for projects/{project}/cases/{case}/attachments/{attachment_id}. */
  public static class ProjectCaseAttachmentIdBuilder {
    private String project;
    private String case_;
    private String attachmentId;

    protected ProjectCaseAttachmentIdBuilder() {}

    public String getProject() {
      return project;
    }

    public String getCase() {
      return case_;
    }

    public String getAttachmentId() {
      return attachmentId;
    }

    public ProjectCaseAttachmentIdBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectCaseAttachmentIdBuilder setCase(String case_) {
      this.case_ = case_;
      return this;
    }

    public ProjectCaseAttachmentIdBuilder setAttachmentId(String attachmentId) {
      this.attachmentId = attachmentId;
      return this;
    }

    public AttachmentName build() {
      return new AttachmentName(this);
    }
  }
}
