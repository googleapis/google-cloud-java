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

package com.google.privacy.dlp.v2;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class InspectTemplateName implements ResourceName {
  private static final PathTemplate ORGANIZATION_INSPECT_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/inspectTemplates/{inspect_template}");
  private static final PathTemplate PROJECT_INSPECT_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/inspectTemplates/{inspect_template}");
  private static final PathTemplate ORGANIZATION_LOCATION_INSPECT_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/inspectTemplates/{inspect_template}");
  private static final PathTemplate PROJECT_LOCATION_INSPECT_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/inspectTemplates/{inspect_template}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String inspectTemplate;
  private final String project;
  private final String location;

  @Deprecated
  protected InspectTemplateName() {
    organization = null;
    inspectTemplate = null;
    project = null;
    location = null;
  }

  private InspectTemplateName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    inspectTemplate = Preconditions.checkNotNull(builder.getInspectTemplate());
    project = null;
    location = null;
    pathTemplate = ORGANIZATION_INSPECT_TEMPLATE;
  }

  private InspectTemplateName(ProjectInspectTemplateBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    inspectTemplate = Preconditions.checkNotNull(builder.getInspectTemplate());
    organization = null;
    location = null;
    pathTemplate = PROJECT_INSPECT_TEMPLATE;
  }

  private InspectTemplateName(OrganizationLocationInspectTemplateBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    inspectTemplate = Preconditions.checkNotNull(builder.getInspectTemplate());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_INSPECT_TEMPLATE;
  }

  private InspectTemplateName(ProjectLocationInspectTemplateBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    inspectTemplate = Preconditions.checkNotNull(builder.getInspectTemplate());
    organization = null;
    pathTemplate = PROJECT_LOCATION_INSPECT_TEMPLATE;
  }

  public String getOrganization() {
    return organization;
  }

  public String getInspectTemplate() {
    return inspectTemplate;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newOrganizationInspectTemplateBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectInspectTemplateBuilder newProjectInspectTemplateBuilder() {
    return new ProjectInspectTemplateBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationLocationInspectTemplateBuilder
      newOrganizationLocationInspectTemplateBuilder() {
    return new OrganizationLocationInspectTemplateBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationInspectTemplateBuilder newProjectLocationInspectTemplateBuilder() {
    return new ProjectLocationInspectTemplateBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static InspectTemplateName of(String organization, String inspectTemplate) {
    return newBuilder().setOrganization(organization).setInspectTemplate(inspectTemplate).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static InspectTemplateName ofOrganizationInspectTemplateName(
      String organization, String inspectTemplate) {
    return newBuilder().setOrganization(organization).setInspectTemplate(inspectTemplate).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static InspectTemplateName ofProjectInspectTemplateName(
      String project, String inspectTemplate) {
    return newProjectInspectTemplateBuilder()
        .setProject(project)
        .setInspectTemplate(inspectTemplate)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static InspectTemplateName ofOrganizationLocationInspectTemplateName(
      String organization, String location, String inspectTemplate) {
    return newOrganizationLocationInspectTemplateBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setInspectTemplate(inspectTemplate)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static InspectTemplateName ofProjectLocationInspectTemplateName(
      String project, String location, String inspectTemplate) {
    return newProjectLocationInspectTemplateBuilder()
        .setProject(project)
        .setLocation(location)
        .setInspectTemplate(inspectTemplate)
        .build();
  }

  public static String format(String organization, String inspectTemplate) {
    return newBuilder()
        .setOrganization(organization)
        .setInspectTemplate(inspectTemplate)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationInspectTemplateName(
      String organization, String inspectTemplate) {
    return newBuilder()
        .setOrganization(organization)
        .setInspectTemplate(inspectTemplate)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectInspectTemplateName(String project, String inspectTemplate) {
    return newProjectInspectTemplateBuilder()
        .setProject(project)
        .setInspectTemplate(inspectTemplate)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationInspectTemplateName(
      String organization, String location, String inspectTemplate) {
    return newOrganizationLocationInspectTemplateBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setInspectTemplate(inspectTemplate)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationInspectTemplateName(
      String project, String location, String inspectTemplate) {
    return newProjectLocationInspectTemplateBuilder()
        .setProject(project)
        .setLocation(location)
        .setInspectTemplate(inspectTemplate)
        .build()
        .toString();
  }

  public static InspectTemplateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_INSPECT_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_INSPECT_TEMPLATE.match(formattedString);
      return ofOrganizationInspectTemplateName(
          matchMap.get("organization"), matchMap.get("inspect_template"));
    } else if (PROJECT_INSPECT_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_INSPECT_TEMPLATE.match(formattedString);
      return ofProjectInspectTemplateName(
          matchMap.get("project"), matchMap.get("inspect_template"));
    } else if (ORGANIZATION_LOCATION_INSPECT_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_INSPECT_TEMPLATE.match(formattedString);
      return ofOrganizationLocationInspectTemplateName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("inspect_template"));
    } else if (PROJECT_LOCATION_INSPECT_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_INSPECT_TEMPLATE.match(formattedString);
      return ofProjectLocationInspectTemplateName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("inspect_template"));
    }
    throw new ValidationException("InspectTemplateName.parse: formattedString not in valid format");
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_INSPECT_TEMPLATE.matches(formattedString)
        || PROJECT_INSPECT_TEMPLATE.matches(formattedString)
        || ORGANIZATION_LOCATION_INSPECT_TEMPLATE.matches(formattedString)
        || PROJECT_LOCATION_INSPECT_TEMPLATE.matches(formattedString);
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
          if (inspectTemplate != null) {
            fieldMapBuilder.put("inspect_template", inspectTemplate);
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

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      InspectTemplateName that = ((InspectTemplateName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.inspectTemplate, that.inspectTemplate)
          && Objects.equals(this.project, that.project)
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
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(inspectTemplate);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for organizations/{organization}/inspectTemplates/{inspect_template}. */
  public static class Builder {
    private String organization;
    private String inspectTemplate;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getInspectTemplate() {
      return inspectTemplate;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setInspectTemplate(String inspectTemplate) {
      this.inspectTemplate = inspectTemplate;
      return this;
    }

    private Builder(InspectTemplateName inspectTemplateName) {
      Preconditions.checkArgument(
          Objects.equals(inspectTemplateName.pathTemplate, ORGANIZATION_INSPECT_TEMPLATE),
          "toBuilder is only supported when InspectTemplateName has the pattern of organizations/{organization}/inspectTemplates/{inspect_template}");
      this.organization = inspectTemplateName.organization;
      this.inspectTemplate = inspectTemplateName.inspectTemplate;
    }

    public InspectTemplateName build() {
      return new InspectTemplateName(this);
    }
  }

  /** Builder for projects/{project}/inspectTemplates/{inspect_template}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectInspectTemplateBuilder {
    private String project;
    private String inspectTemplate;

    protected ProjectInspectTemplateBuilder() {}

    public String getProject() {
      return project;
    }

    public String getInspectTemplate() {
      return inspectTemplate;
    }

    public ProjectInspectTemplateBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectInspectTemplateBuilder setInspectTemplate(String inspectTemplate) {
      this.inspectTemplate = inspectTemplate;
      return this;
    }

    public InspectTemplateName build() {
      return new InspectTemplateName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/inspectTemplates/{inspect_template}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationLocationInspectTemplateBuilder {
    private String organization;
    private String location;
    private String inspectTemplate;

    protected OrganizationLocationInspectTemplateBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getInspectTemplate() {
      return inspectTemplate;
    }

    public OrganizationLocationInspectTemplateBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationInspectTemplateBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationInspectTemplateBuilder setInspectTemplate(String inspectTemplate) {
      this.inspectTemplate = inspectTemplate;
      return this;
    }

    public InspectTemplateName build() {
      return new InspectTemplateName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/inspectTemplates/{inspect_template}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationInspectTemplateBuilder {
    private String project;
    private String location;
    private String inspectTemplate;

    protected ProjectLocationInspectTemplateBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getInspectTemplate() {
      return inspectTemplate;
    }

    public ProjectLocationInspectTemplateBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationInspectTemplateBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationInspectTemplateBuilder setInspectTemplate(String inspectTemplate) {
      this.inspectTemplate = inspectTemplate;
      return this;
    }

    public InspectTemplateName build() {
      return new InspectTemplateName(this);
    }
  }
}
