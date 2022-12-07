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

package com.google.cloud.accessapproval.v1;

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
public class ApprovalRequestName implements ResourceName {
  private static final PathTemplate PROJECT_APPROVAL_REQUEST =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/approvalRequests/{approval_request}");
  private static final PathTemplate FOLDER_APPROVAL_REQUEST =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/approvalRequests/{approval_request}");
  private static final PathTemplate ORGANIZATION_APPROVAL_REQUEST =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/approvalRequests/{approval_request}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String approvalRequest;
  private final String folder;
  private final String organization;

  @Deprecated
  protected ApprovalRequestName() {
    project = null;
    approvalRequest = null;
    folder = null;
    organization = null;
  }

  private ApprovalRequestName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    approvalRequest = Preconditions.checkNotNull(builder.getApprovalRequest());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_APPROVAL_REQUEST;
  }

  private ApprovalRequestName(FolderApprovalRequestBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    approvalRequest = Preconditions.checkNotNull(builder.getApprovalRequest());
    project = null;
    organization = null;
    pathTemplate = FOLDER_APPROVAL_REQUEST;
  }

  private ApprovalRequestName(OrganizationApprovalRequestBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    approvalRequest = Preconditions.checkNotNull(builder.getApprovalRequest());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_APPROVAL_REQUEST;
  }

  public String getProject() {
    return project;
  }

  public String getApprovalRequest() {
    return approvalRequest;
  }

  public String getFolder() {
    return folder;
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectApprovalRequestBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderApprovalRequestBuilder newFolderApprovalRequestBuilder() {
    return new FolderApprovalRequestBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationApprovalRequestBuilder newOrganizationApprovalRequestBuilder() {
    return new OrganizationApprovalRequestBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ApprovalRequestName of(String project, String approvalRequest) {
    return newBuilder().setProject(project).setApprovalRequest(approvalRequest).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ApprovalRequestName ofProjectApprovalRequestName(
      String project, String approvalRequest) {
    return newBuilder().setProject(project).setApprovalRequest(approvalRequest).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ApprovalRequestName ofFolderApprovalRequestName(
      String folder, String approvalRequest) {
    return newFolderApprovalRequestBuilder()
        .setFolder(folder)
        .setApprovalRequest(approvalRequest)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ApprovalRequestName ofOrganizationApprovalRequestName(
      String organization, String approvalRequest) {
    return newOrganizationApprovalRequestBuilder()
        .setOrganization(organization)
        .setApprovalRequest(approvalRequest)
        .build();
  }

  public static String format(String project, String approvalRequest) {
    return newBuilder().setProject(project).setApprovalRequest(approvalRequest).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectApprovalRequestName(String project, String approvalRequest) {
    return newBuilder().setProject(project).setApprovalRequest(approvalRequest).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderApprovalRequestName(String folder, String approvalRequest) {
    return newFolderApprovalRequestBuilder()
        .setFolder(folder)
        .setApprovalRequest(approvalRequest)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationApprovalRequestName(
      String organization, String approvalRequest) {
    return newOrganizationApprovalRequestBuilder()
        .setOrganization(organization)
        .setApprovalRequest(approvalRequest)
        .build()
        .toString();
  }

  public static ApprovalRequestName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_APPROVAL_REQUEST.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_APPROVAL_REQUEST.match(formattedString);
      return ofProjectApprovalRequestName(
          matchMap.get("project"), matchMap.get("approval_request"));
    } else if (FOLDER_APPROVAL_REQUEST.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_APPROVAL_REQUEST.match(formattedString);
      return ofFolderApprovalRequestName(matchMap.get("folder"), matchMap.get("approval_request"));
    } else if (ORGANIZATION_APPROVAL_REQUEST.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_APPROVAL_REQUEST.match(formattedString);
      return ofOrganizationApprovalRequestName(
          matchMap.get("organization"), matchMap.get("approval_request"));
    }
    throw new ValidationException("ApprovalRequestName.parse: formattedString not in valid format");
  }

  public static List<ApprovalRequestName> parseList(List<String> formattedStrings) {
    List<ApprovalRequestName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ApprovalRequestName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ApprovalRequestName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_APPROVAL_REQUEST.matches(formattedString)
        || FOLDER_APPROVAL_REQUEST.matches(formattedString)
        || ORGANIZATION_APPROVAL_REQUEST.matches(formattedString);
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
          if (approvalRequest != null) {
            fieldMapBuilder.put("approval_request", approvalRequest);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
          }
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
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
      ApprovalRequestName that = ((ApprovalRequestName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.approvalRequest, that.approvalRequest)
          && Objects.equals(this.folder, that.folder)
          && Objects.equals(this.organization, that.organization);
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
    h ^= Objects.hashCode(approvalRequest);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/approvalRequests/{approval_request}. */
  public static class Builder {
    private String project;
    private String approvalRequest;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getApprovalRequest() {
      return approvalRequest;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setApprovalRequest(String approvalRequest) {
      this.approvalRequest = approvalRequest;
      return this;
    }

    private Builder(ApprovalRequestName approvalRequestName) {
      Preconditions.checkArgument(
          Objects.equals(approvalRequestName.pathTemplate, PROJECT_APPROVAL_REQUEST),
          "toBuilder is only supported when ApprovalRequestName has the pattern of projects/{project}/approvalRequests/{approval_request}");
      this.project = approvalRequestName.project;
      this.approvalRequest = approvalRequestName.approvalRequest;
    }

    public ApprovalRequestName build() {
      return new ApprovalRequestName(this);
    }
  }

  /** Builder for folders/{folder}/approvalRequests/{approval_request}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderApprovalRequestBuilder {
    private String folder;
    private String approvalRequest;

    protected FolderApprovalRequestBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getApprovalRequest() {
      return approvalRequest;
    }

    public FolderApprovalRequestBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderApprovalRequestBuilder setApprovalRequest(String approvalRequest) {
      this.approvalRequest = approvalRequest;
      return this;
    }

    public ApprovalRequestName build() {
      return new ApprovalRequestName(this);
    }
  }

  /** Builder for organizations/{organization}/approvalRequests/{approval_request}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationApprovalRequestBuilder {
    private String organization;
    private String approvalRequest;

    protected OrganizationApprovalRequestBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getApprovalRequest() {
      return approvalRequest;
    }

    public OrganizationApprovalRequestBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationApprovalRequestBuilder setApprovalRequest(String approvalRequest) {
      this.approvalRequest = approvalRequest;
      return this;
    }

    public ApprovalRequestName build() {
      return new ApprovalRequestName(this);
    }
  }
}
