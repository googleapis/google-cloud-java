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

package com.google.monitoring.v3;

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
public class AlertPolicyName implements ResourceName {
  private static final PathTemplate PROJECT_ALERT_POLICY =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/alertPolicies/{alert_policy}");
  private static final PathTemplate ORGANIZATION_ALERT_POLICY =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/alertPolicies/{alert_policy}");
  private static final PathTemplate FOLDER_ALERT_POLICY =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/alertPolicies/{alert_policy}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String alertPolicy;
  private final String organization;
  private final String folder;

  @Deprecated
  protected AlertPolicyName() {
    project = null;
    alertPolicy = null;
    organization = null;
    folder = null;
  }

  private AlertPolicyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    alertPolicy = Preconditions.checkNotNull(builder.getAlertPolicy());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_ALERT_POLICY;
  }

  private AlertPolicyName(OrganizationAlertPolicyBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    alertPolicy = Preconditions.checkNotNull(builder.getAlertPolicy());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_ALERT_POLICY;
  }

  private AlertPolicyName(FolderAlertPolicyBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    alertPolicy = Preconditions.checkNotNull(builder.getAlertPolicy());
    project = null;
    organization = null;
    pathTemplate = FOLDER_ALERT_POLICY;
  }

  public String getProject() {
    return project;
  }

  public String getAlertPolicy() {
    return alertPolicy;
  }

  public String getOrganization() {
    return organization;
  }

  public String getFolder() {
    return folder;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectAlertPolicyBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationAlertPolicyBuilder newOrganizationAlertPolicyBuilder() {
    return new OrganizationAlertPolicyBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderAlertPolicyBuilder newFolderAlertPolicyBuilder() {
    return new FolderAlertPolicyBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AlertPolicyName of(String project, String alertPolicy) {
    return newBuilder().setProject(project).setAlertPolicy(alertPolicy).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static AlertPolicyName ofProjectAlertPolicyName(String project, String alertPolicy) {
    return newBuilder().setProject(project).setAlertPolicy(alertPolicy).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static AlertPolicyName ofOrganizationAlertPolicyName(
      String organization, String alertPolicy) {
    return newOrganizationAlertPolicyBuilder()
        .setOrganization(organization)
        .setAlertPolicy(alertPolicy)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static AlertPolicyName ofFolderAlertPolicyName(String folder, String alertPolicy) {
    return newFolderAlertPolicyBuilder().setFolder(folder).setAlertPolicy(alertPolicy).build();
  }

  public static String format(String project, String alertPolicy) {
    return newBuilder().setProject(project).setAlertPolicy(alertPolicy).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectAlertPolicyName(String project, String alertPolicy) {
    return newBuilder().setProject(project).setAlertPolicy(alertPolicy).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationAlertPolicyName(String organization, String alertPolicy) {
    return newOrganizationAlertPolicyBuilder()
        .setOrganization(organization)
        .setAlertPolicy(alertPolicy)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderAlertPolicyName(String folder, String alertPolicy) {
    return newFolderAlertPolicyBuilder()
        .setFolder(folder)
        .setAlertPolicy(alertPolicy)
        .build()
        .toString();
  }

  public static AlertPolicyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_ALERT_POLICY.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_ALERT_POLICY.match(formattedString);
      return ofProjectAlertPolicyName(matchMap.get("project"), matchMap.get("alert_policy"));
    } else if (ORGANIZATION_ALERT_POLICY.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_ALERT_POLICY.match(formattedString);
      return ofOrganizationAlertPolicyName(
          matchMap.get("organization"), matchMap.get("alert_policy"));
    } else if (FOLDER_ALERT_POLICY.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_ALERT_POLICY.match(formattedString);
      return ofFolderAlertPolicyName(matchMap.get("folder"), matchMap.get("alert_policy"));
    }
    throw new ValidationException("AlertPolicyName.parse: formattedString not in valid format");
  }

  public static List<AlertPolicyName> parseList(List<String> formattedStrings) {
    List<AlertPolicyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AlertPolicyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AlertPolicyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_ALERT_POLICY.matches(formattedString)
        || ORGANIZATION_ALERT_POLICY.matches(formattedString)
        || FOLDER_ALERT_POLICY.matches(formattedString);
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
          if (alertPolicy != null) {
            fieldMapBuilder.put("alert_policy", alertPolicy);
          }
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
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
      AlertPolicyName that = ((AlertPolicyName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.alertPolicy, that.alertPolicy)
          && Objects.equals(this.organization, that.organization)
          && Objects.equals(this.folder, that.folder);
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
    h ^= Objects.hashCode(alertPolicy);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    return h;
  }

  /** Builder for projects/{project}/alertPolicies/{alert_policy}. */
  public static class Builder {
    private String project;
    private String alertPolicy;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getAlertPolicy() {
      return alertPolicy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setAlertPolicy(String alertPolicy) {
      this.alertPolicy = alertPolicy;
      return this;
    }

    private Builder(AlertPolicyName alertPolicyName) {
      Preconditions.checkArgument(
          Objects.equals(alertPolicyName.pathTemplate, PROJECT_ALERT_POLICY),
          "toBuilder is only supported when AlertPolicyName has the pattern of projects/{project}/alertPolicies/{alert_policy}");
      this.project = alertPolicyName.project;
      this.alertPolicy = alertPolicyName.alertPolicy;
    }

    public AlertPolicyName build() {
      return new AlertPolicyName(this);
    }
  }

  /** Builder for organizations/{organization}/alertPolicies/{alert_policy}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationAlertPolicyBuilder {
    private String organization;
    private String alertPolicy;

    protected OrganizationAlertPolicyBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getAlertPolicy() {
      return alertPolicy;
    }

    public OrganizationAlertPolicyBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationAlertPolicyBuilder setAlertPolicy(String alertPolicy) {
      this.alertPolicy = alertPolicy;
      return this;
    }

    public AlertPolicyName build() {
      return new AlertPolicyName(this);
    }
  }

  /** Builder for folders/{folder}/alertPolicies/{alert_policy}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderAlertPolicyBuilder {
    private String folder;
    private String alertPolicy;

    protected FolderAlertPolicyBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getAlertPolicy() {
      return alertPolicy;
    }

    public FolderAlertPolicyBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderAlertPolicyBuilder setAlertPolicy(String alertPolicy) {
      this.alertPolicy = alertPolicy;
      return this;
    }

    public AlertPolicyName build() {
      return new AlertPolicyName(this);
    }
  }
}
