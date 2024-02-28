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

package com.google.cloud.securitycentermanagement.v1;

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
public class EffectiveEventThreatDetectionCustomModuleName implements ResourceName {
  private static final PathTemplate
      ORGANIZATION_LOCATION_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE =
          PathTemplate.createWithoutUrlEncoding(
              "organizations/{organization}/locations/{location}/effectiveEventThreatDetectionCustomModules/{effective_event_threat_detection_custom_module}");
  private static final PathTemplate
      PROJECT_LOCATION_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE =
          PathTemplate.createWithoutUrlEncoding(
              "projects/{project}/locations/{location}/effectiveEventThreatDetectionCustomModules/{effective_event_threat_detection_custom_module}");
  private static final PathTemplate FOLDER_LOCATION_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/effectiveEventThreatDetectionCustomModules/{effective_event_threat_detection_custom_module}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String effectiveEventThreatDetectionCustomModule;
  private final String project;
  private final String folder;

  @Deprecated
  protected EffectiveEventThreatDetectionCustomModuleName() {
    organization = null;
    location = null;
    effectiveEventThreatDetectionCustomModule = null;
    project = null;
    folder = null;
  }

  private EffectiveEventThreatDetectionCustomModuleName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    effectiveEventThreatDetectionCustomModule =
        Preconditions.checkNotNull(builder.getEffectiveEventThreatDetectionCustomModule());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE;
  }

  private EffectiveEventThreatDetectionCustomModuleName(
      ProjectLocationEffectiveEventThreatDetectionCustomModuleBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    effectiveEventThreatDetectionCustomModule =
        Preconditions.checkNotNull(builder.getEffectiveEventThreatDetectionCustomModule());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_LOCATION_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE;
  }

  private EffectiveEventThreatDetectionCustomModuleName(
      FolderLocationEffectiveEventThreatDetectionCustomModuleBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    effectiveEventThreatDetectionCustomModule =
        Preconditions.checkNotNull(builder.getEffectiveEventThreatDetectionCustomModule());
    organization = null;
    project = null;
    pathTemplate = FOLDER_LOCATION_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getEffectiveEventThreatDetectionCustomModule() {
    return effectiveEventThreatDetectionCustomModule;
  }

  public String getProject() {
    return project;
  }

  public String getFolder() {
    return folder;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newOrganizationLocationEffectiveEventThreatDetectionCustomModuleBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationEffectiveEventThreatDetectionCustomModuleBuilder
      newProjectLocationEffectiveEventThreatDetectionCustomModuleBuilder() {
    return new ProjectLocationEffectiveEventThreatDetectionCustomModuleBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderLocationEffectiveEventThreatDetectionCustomModuleBuilder
      newFolderLocationEffectiveEventThreatDetectionCustomModuleBuilder() {
    return new FolderLocationEffectiveEventThreatDetectionCustomModuleBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EffectiveEventThreatDetectionCustomModuleName of(
      String organization, String location, String effectiveEventThreatDetectionCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setEffectiveEventThreatDetectionCustomModule(effectiveEventThreatDetectionCustomModule)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EffectiveEventThreatDetectionCustomModuleName
      ofOrganizationLocationEffectiveEventThreatDetectionCustomModuleName(
          String organization, String location, String effectiveEventThreatDetectionCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setEffectiveEventThreatDetectionCustomModule(effectiveEventThreatDetectionCustomModule)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EffectiveEventThreatDetectionCustomModuleName
      ofProjectLocationEffectiveEventThreatDetectionCustomModuleName(
          String project, String location, String effectiveEventThreatDetectionCustomModule) {
    return newProjectLocationEffectiveEventThreatDetectionCustomModuleBuilder()
        .setProject(project)
        .setLocation(location)
        .setEffectiveEventThreatDetectionCustomModule(effectiveEventThreatDetectionCustomModule)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EffectiveEventThreatDetectionCustomModuleName
      ofFolderLocationEffectiveEventThreatDetectionCustomModuleName(
          String folder, String location, String effectiveEventThreatDetectionCustomModule) {
    return newFolderLocationEffectiveEventThreatDetectionCustomModuleBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setEffectiveEventThreatDetectionCustomModule(effectiveEventThreatDetectionCustomModule)
        .build();
  }

  public static String format(
      String organization, String location, String effectiveEventThreatDetectionCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setEffectiveEventThreatDetectionCustomModule(effectiveEventThreatDetectionCustomModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationEffectiveEventThreatDetectionCustomModuleName(
      String organization, String location, String effectiveEventThreatDetectionCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setEffectiveEventThreatDetectionCustomModule(effectiveEventThreatDetectionCustomModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationEffectiveEventThreatDetectionCustomModuleName(
      String project, String location, String effectiveEventThreatDetectionCustomModule) {
    return newProjectLocationEffectiveEventThreatDetectionCustomModuleBuilder()
        .setProject(project)
        .setLocation(location)
        .setEffectiveEventThreatDetectionCustomModule(effectiveEventThreatDetectionCustomModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderLocationEffectiveEventThreatDetectionCustomModuleName(
      String folder, String location, String effectiveEventThreatDetectionCustomModule) {
    return newFolderLocationEffectiveEventThreatDetectionCustomModuleBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setEffectiveEventThreatDetectionCustomModule(effectiveEventThreatDetectionCustomModule)
        .build()
        .toString();
  }

  public static EffectiveEventThreatDetectionCustomModuleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE.matches(
        formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE.match(
              formattedString);
      return ofOrganizationLocationEffectiveEventThreatDetectionCustomModuleName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("effective_event_threat_detection_custom_module"));
    } else if (PROJECT_LOCATION_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE.matches(
        formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE.match(formattedString);
      return ofProjectLocationEffectiveEventThreatDetectionCustomModuleName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("effective_event_threat_detection_custom_module"));
    } else if (FOLDER_LOCATION_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE.matches(
        formattedString)) {
      Map<String, String> matchMap =
          FOLDER_LOCATION_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE.match(formattedString);
      return ofFolderLocationEffectiveEventThreatDetectionCustomModuleName(
          matchMap.get("folder"),
          matchMap.get("location"),
          matchMap.get("effective_event_threat_detection_custom_module"));
    }
    throw new ValidationException(
        "EffectiveEventThreatDetectionCustomModuleName.parse: formattedString not in valid format");
  }

  public static List<EffectiveEventThreatDetectionCustomModuleName> parseList(
      List<String> formattedStrings) {
    List<EffectiveEventThreatDetectionCustomModuleName> list =
        new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(
      List<EffectiveEventThreatDetectionCustomModuleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EffectiveEventThreatDetectionCustomModuleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE.matches(
            formattedString)
        || PROJECT_LOCATION_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE.matches(formattedString)
        || FOLDER_LOCATION_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE.matches(formattedString);
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
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (effectiveEventThreatDetectionCustomModule != null) {
            fieldMapBuilder.put(
                "effective_event_threat_detection_custom_module",
                effectiveEventThreatDetectionCustomModule);
          }
          if (project != null) {
            fieldMapBuilder.put("project", project);
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
    if (o != null && getClass() == o.getClass()) {
      EffectiveEventThreatDetectionCustomModuleName that =
          ((EffectiveEventThreatDetectionCustomModuleName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(
              this.effectiveEventThreatDetectionCustomModule,
              that.effectiveEventThreatDetectionCustomModule)
          && Objects.equals(this.project, that.project)
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
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(effectiveEventThreatDetectionCustomModule);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/effectiveEventThreatDetectionCustomModules/{effective_event_threat_detection_custom_module}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String effectiveEventThreatDetectionCustomModule;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getEffectiveEventThreatDetectionCustomModule() {
      return effectiveEventThreatDetectionCustomModule;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setEffectiveEventThreatDetectionCustomModule(
        String effectiveEventThreatDetectionCustomModule) {
      this.effectiveEventThreatDetectionCustomModule = effectiveEventThreatDetectionCustomModule;
      return this;
    }

    private Builder(
        EffectiveEventThreatDetectionCustomModuleName
            effectiveEventThreatDetectionCustomModuleName) {
      Preconditions.checkArgument(
          Objects.equals(
              effectiveEventThreatDetectionCustomModuleName.pathTemplate,
              ORGANIZATION_LOCATION_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE),
          "toBuilder is only supported when EffectiveEventThreatDetectionCustomModuleName has the pattern of organizations/{organization}/locations/{location}/effectiveEventThreatDetectionCustomModules/{effective_event_threat_detection_custom_module}");
      this.organization = effectiveEventThreatDetectionCustomModuleName.organization;
      this.location = effectiveEventThreatDetectionCustomModuleName.location;
      this.effectiveEventThreatDetectionCustomModule =
          effectiveEventThreatDetectionCustomModuleName.effectiveEventThreatDetectionCustomModule;
    }

    public EffectiveEventThreatDetectionCustomModuleName build() {
      return new EffectiveEventThreatDetectionCustomModuleName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/effectiveEventThreatDetectionCustomModules/{effective_event_threat_detection_custom_module}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationEffectiveEventThreatDetectionCustomModuleBuilder {
    private String project;
    private String location;
    private String effectiveEventThreatDetectionCustomModule;

    protected ProjectLocationEffectiveEventThreatDetectionCustomModuleBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getEffectiveEventThreatDetectionCustomModule() {
      return effectiveEventThreatDetectionCustomModule;
    }

    public ProjectLocationEffectiveEventThreatDetectionCustomModuleBuilder setProject(
        String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationEffectiveEventThreatDetectionCustomModuleBuilder setLocation(
        String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationEffectiveEventThreatDetectionCustomModuleBuilder
        setEffectiveEventThreatDetectionCustomModule(
            String effectiveEventThreatDetectionCustomModule) {
      this.effectiveEventThreatDetectionCustomModule = effectiveEventThreatDetectionCustomModule;
      return this;
    }

    public EffectiveEventThreatDetectionCustomModuleName build() {
      return new EffectiveEventThreatDetectionCustomModuleName(this);
    }
  }

  /**
   * Builder for
   * folders/{folder}/locations/{location}/effectiveEventThreatDetectionCustomModules/{effective_event_threat_detection_custom_module}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderLocationEffectiveEventThreatDetectionCustomModuleBuilder {
    private String folder;
    private String location;
    private String effectiveEventThreatDetectionCustomModule;

    protected FolderLocationEffectiveEventThreatDetectionCustomModuleBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getEffectiveEventThreatDetectionCustomModule() {
      return effectiveEventThreatDetectionCustomModule;
    }

    public FolderLocationEffectiveEventThreatDetectionCustomModuleBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationEffectiveEventThreatDetectionCustomModuleBuilder setLocation(
        String location) {
      this.location = location;
      return this;
    }

    public FolderLocationEffectiveEventThreatDetectionCustomModuleBuilder
        setEffectiveEventThreatDetectionCustomModule(
            String effectiveEventThreatDetectionCustomModule) {
      this.effectiveEventThreatDetectionCustomModule = effectiveEventThreatDetectionCustomModule;
      return this;
    }

    public EffectiveEventThreatDetectionCustomModuleName build() {
      return new EffectiveEventThreatDetectionCustomModuleName(this);
    }
  }
}
