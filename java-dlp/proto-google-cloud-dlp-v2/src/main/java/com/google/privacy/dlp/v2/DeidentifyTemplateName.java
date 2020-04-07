/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.privacy.dlp.v2;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.Objects;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class DeidentifyTemplateName implements ResourceName {

  @Deprecated
  protected DeidentifyTemplateName() {}

  private static final PathTemplate ORGANIZATION_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/deidentifyTemplates/{deidentify_template}");
  private static final PathTemplate PROJECT_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/deidentifyTemplates/{deidentify_template}");
  private static final PathTemplate ORGANIZATION_LOCATION_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/deidentifyTemplates/{deidentify_template}");
  private static final PathTemplate PROJECT_LOCATION_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/deidentifyTemplates/{deidentify_template}");

  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;

  private String organization;
  private String deidentifyTemplate;
  private String project;
  private String location;

  public String getOrganization() {
    return organization;
  }

  public String getDeidentifyTemplate() {
    return deidentifyTemplate;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  private DeidentifyTemplateName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    deidentifyTemplate = Preconditions.checkNotNull(builder.getDeidentifyTemplate());
    pathTemplate = ORGANIZATION_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE;
  }

  private DeidentifyTemplateName(ProjectDeidentifyTemplateBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    deidentifyTemplate = Preconditions.checkNotNull(builder.getDeidentifyTemplate());
    pathTemplate = PROJECT_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE;
  }

  private DeidentifyTemplateName(OrganizationLocationDeidentifyTemplateBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    deidentifyTemplate = Preconditions.checkNotNull(builder.getDeidentifyTemplate());
    pathTemplate = ORGANIZATION_LOCATION_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE;
  }

  private DeidentifyTemplateName(ProjectLocationDeidentifyTemplateBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    deidentifyTemplate = Preconditions.checkNotNull(builder.getDeidentifyTemplate());
    pathTemplate = PROJECT_LOCATION_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newOrganizationDeidentifyTemplateBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectDeidentifyTemplateBuilder newProjectDeidentifyTemplateBuilder() {
    return new ProjectDeidentifyTemplateBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationLocationDeidentifyTemplateBuilder
      newOrganizationLocationDeidentifyTemplateBuilder() {
    return new OrganizationLocationDeidentifyTemplateBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationDeidentifyTemplateBuilder
      newProjectLocationDeidentifyTemplateBuilder() {
    return new ProjectLocationDeidentifyTemplateBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DeidentifyTemplateName of(String organization, String deidentifyTemplate) {
    return newOrganizationDeidentifyTemplateBuilder()
        .setOrganization(organization)
        .setDeidentifyTemplate(deidentifyTemplate)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static DeidentifyTemplateName ofOrganizationDeidentifyTemplateName(
      String organization, String deidentifyTemplate) {
    return newOrganizationDeidentifyTemplateBuilder()
        .setOrganization(organization)
        .setDeidentifyTemplate(deidentifyTemplate)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static DeidentifyTemplateName ofProjectDeidentifyTemplateName(
      String project, String deidentifyTemplate) {
    return newProjectDeidentifyTemplateBuilder()
        .setProject(project)
        .setDeidentifyTemplate(deidentifyTemplate)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static DeidentifyTemplateName ofOrganizationLocationDeidentifyTemplateName(
      String organization, String location, String deidentifyTemplate) {
    return newOrganizationLocationDeidentifyTemplateBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setDeidentifyTemplate(deidentifyTemplate)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static DeidentifyTemplateName ofProjectLocationDeidentifyTemplateName(
      String project, String location, String deidentifyTemplate) {
    return newProjectLocationDeidentifyTemplateBuilder()
        .setProject(project)
        .setLocation(location)
        .setDeidentifyTemplate(deidentifyTemplate)
        .build();
  }

  public static String format(String organization, String deidentifyTemplate) {
    return newBuilder()
        .setOrganization(organization)
        .setDeidentifyTemplate(deidentifyTemplate)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationDeidentifyTemplateName(
      String organization, String deidentifyTemplate) {
    return newBuilder()
        .setOrganization(organization)
        .setDeidentifyTemplate(deidentifyTemplate)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectDeidentifyTemplateName(
      String project, String deidentifyTemplate) {
    return newProjectDeidentifyTemplateBuilder()
        .setProject(project)
        .setDeidentifyTemplate(deidentifyTemplate)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationDeidentifyTemplateName(
      String organization, String location, String deidentifyTemplate) {
    return newOrganizationLocationDeidentifyTemplateBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setDeidentifyTemplate(deidentifyTemplate)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationDeidentifyTemplateName(
      String project, String location, String deidentifyTemplate) {
    return newProjectLocationDeidentifyTemplateBuilder()
        .setProject(project)
        .setLocation(location)
        .setDeidentifyTemplate(deidentifyTemplate)
        .build()
        .toString();
  }

  public static DeidentifyTemplateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE.match(formattedString);
      return ofOrganizationDeidentifyTemplateName(
          matchMap.get("organization"), matchMap.get("deidentify_template"));
    } else if (PROJECT_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE.match(formattedString);
      return ofProjectDeidentifyTemplateName(
          matchMap.get("project"), matchMap.get("deidentify_template"));
    } else if (ORGANIZATION_LOCATION_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE.match(formattedString);
      return ofOrganizationLocationDeidentifyTemplateName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("deidentify_template"));
    } else if (PROJECT_LOCATION_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE.match(formattedString);
      return ofProjectLocationDeidentifyTemplateName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("deidentify_template"));
    }
    throw new ValidationException("JobName.parse: formattedString not in valid format");
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE.matches(formattedString)
        || ORGANIZATION_LOCATION_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_LOCATION_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE.matches(formattedString);
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
          if (deidentifyTemplate != null) {
            fieldMapBuilder.put("deidentify_template", deidentifyTemplate);
          }
          if (project != null) {
            fieldMapBuilder.put("project", project);
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

  /** Builder for organizations/{organization}/deidentifyTemplates/{deidentify_template}. */
  public static class Builder {

    private String organization;
    private String deidentifyTemplate;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getDeidentifyTemplate() {
      return deidentifyTemplate;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setDeidentifyTemplate(String deidentifyTemplate) {
      this.deidentifyTemplate = deidentifyTemplate;
      return this;
    }

    private Builder(DeidentifyTemplateName deidentifyTemplateName) {
      Preconditions.checkArgument(
          deidentifyTemplateName.pathTemplate == ORGANIZATION_DEIDENTIFY_TEMPLATE_PATH_TEMPLATE,
          "toBuilder is only supported when DeidentifyTemplateName has the pattern of "
              + "organizations/{organization}/deidentifyTemplates/{deidentify_template}.");
      organization = deidentifyTemplateName.organization;
      deidentifyTemplate = deidentifyTemplateName.deidentifyTemplate;
    }

    public DeidentifyTemplateName build() {
      return new DeidentifyTemplateName(this);
    }
  }

  /** Builder for projects/{project}/deidentifyTemplates/{deidentify_template}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectDeidentifyTemplateBuilder {

    private String project;
    private String deidentifyTemplate;

    private ProjectDeidentifyTemplateBuilder() {}

    public String getProject() {
      return project;
    }

    public String getDeidentifyTemplate() {
      return deidentifyTemplate;
    }

    public ProjectDeidentifyTemplateBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectDeidentifyTemplateBuilder setDeidentifyTemplate(String deidentifyTemplate) {
      this.deidentifyTemplate = deidentifyTemplate;
      return this;
    }

    public DeidentifyTemplateName build() {
      return new DeidentifyTemplateName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/deidentifyTemplates/{deidentify_template}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationLocationDeidentifyTemplateBuilder {

    private String organization;
    private String location;
    private String deidentifyTemplate;

    private OrganizationLocationDeidentifyTemplateBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getDeidentifyTemplate() {
      return deidentifyTemplate;
    }

    public OrganizationLocationDeidentifyTemplateBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationDeidentifyTemplateBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationDeidentifyTemplateBuilder setDeidentifyTemplate(
        String deidentifyTemplate) {
      this.deidentifyTemplate = deidentifyTemplate;
      return this;
    }

    public DeidentifyTemplateName build() {
      return new DeidentifyTemplateName(this);
    }
  }

  /**
   * Builder for projects/{project}/locations/{location}/deidentifyTemplates/{deidentify_template}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationDeidentifyTemplateBuilder {

    private String project;
    private String location;
    private String deidentifyTemplate;

    private ProjectLocationDeidentifyTemplateBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDeidentifyTemplate() {
      return deidentifyTemplate;
    }

    public ProjectLocationDeidentifyTemplateBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationDeidentifyTemplateBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationDeidentifyTemplateBuilder setDeidentifyTemplate(
        String deidentifyTemplate) {
      this.deidentifyTemplate = deidentifyTemplate;
      return this;
    }

    public DeidentifyTemplateName build() {
      return new DeidentifyTemplateName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      DeidentifyTemplateName that = (DeidentifyTemplateName) o;
      return (Objects.equals(this.organization, that.organization))
          && (Objects.equals(this.deidentifyTemplate, that.deidentifyTemplate))
          && (Objects.equals(this.project, that.project))
          && (Objects.equals(this.location, that.location));
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
    h ^= Objects.hashCode(deidentifyTemplate);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }
}
