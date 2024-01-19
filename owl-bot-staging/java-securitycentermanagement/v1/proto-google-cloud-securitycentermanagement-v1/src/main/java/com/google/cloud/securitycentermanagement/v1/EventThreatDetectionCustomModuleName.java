/*
 * Copyright 2023 Google LLC
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
public class EventThreatDetectionCustomModuleName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_EVENT_THREAT_DETECTION_CUSTOM_MODULE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}");
  private static final PathTemplate PROJECT_LOCATION_EVENT_THREAT_DETECTION_CUSTOM_MODULE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}");
  private static final PathTemplate FOLDER_LOCATION_EVENT_THREAT_DETECTION_CUSTOM_MODULE =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String eventThreatDetectionCustomModule;
  private final String project;
  private final String folder;

  @Deprecated
  protected EventThreatDetectionCustomModuleName() {
    organization = null;
    location = null;
    eventThreatDetectionCustomModule = null;
    project = null;
    folder = null;
  }

  private EventThreatDetectionCustomModuleName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    eventThreatDetectionCustomModule =
        Preconditions.checkNotNull(builder.getEventThreatDetectionCustomModule());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_EVENT_THREAT_DETECTION_CUSTOM_MODULE;
  }

  private EventThreatDetectionCustomModuleName(
      ProjectLocationEventThreatDetectionCustomModuleBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    eventThreatDetectionCustomModule =
        Preconditions.checkNotNull(builder.getEventThreatDetectionCustomModule());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_LOCATION_EVENT_THREAT_DETECTION_CUSTOM_MODULE;
  }

  private EventThreatDetectionCustomModuleName(
      FolderLocationEventThreatDetectionCustomModuleBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    eventThreatDetectionCustomModule =
        Preconditions.checkNotNull(builder.getEventThreatDetectionCustomModule());
    organization = null;
    project = null;
    pathTemplate = FOLDER_LOCATION_EVENT_THREAT_DETECTION_CUSTOM_MODULE;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getEventThreatDetectionCustomModule() {
    return eventThreatDetectionCustomModule;
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
  public static Builder newOrganizationLocationEventThreatDetectionCustomModuleBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationEventThreatDetectionCustomModuleBuilder
      newProjectLocationEventThreatDetectionCustomModuleBuilder() {
    return new ProjectLocationEventThreatDetectionCustomModuleBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderLocationEventThreatDetectionCustomModuleBuilder
      newFolderLocationEventThreatDetectionCustomModuleBuilder() {
    return new FolderLocationEventThreatDetectionCustomModuleBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EventThreatDetectionCustomModuleName of(
      String organization, String location, String eventThreatDetectionCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setEventThreatDetectionCustomModule(eventThreatDetectionCustomModule)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EventThreatDetectionCustomModuleName
      ofOrganizationLocationEventThreatDetectionCustomModuleName(
          String organization, String location, String eventThreatDetectionCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setEventThreatDetectionCustomModule(eventThreatDetectionCustomModule)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EventThreatDetectionCustomModuleName
      ofProjectLocationEventThreatDetectionCustomModuleName(
          String project, String location, String eventThreatDetectionCustomModule) {
    return newProjectLocationEventThreatDetectionCustomModuleBuilder()
        .setProject(project)
        .setLocation(location)
        .setEventThreatDetectionCustomModule(eventThreatDetectionCustomModule)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EventThreatDetectionCustomModuleName
      ofFolderLocationEventThreatDetectionCustomModuleName(
          String folder, String location, String eventThreatDetectionCustomModule) {
    return newFolderLocationEventThreatDetectionCustomModuleBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setEventThreatDetectionCustomModule(eventThreatDetectionCustomModule)
        .build();
  }

  public static String format(
      String organization, String location, String eventThreatDetectionCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setEventThreatDetectionCustomModule(eventThreatDetectionCustomModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationEventThreatDetectionCustomModuleName(
      String organization, String location, String eventThreatDetectionCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setEventThreatDetectionCustomModule(eventThreatDetectionCustomModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationEventThreatDetectionCustomModuleName(
      String project, String location, String eventThreatDetectionCustomModule) {
    return newProjectLocationEventThreatDetectionCustomModuleBuilder()
        .setProject(project)
        .setLocation(location)
        .setEventThreatDetectionCustomModule(eventThreatDetectionCustomModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderLocationEventThreatDetectionCustomModuleName(
      String folder, String location, String eventThreatDetectionCustomModule) {
    return newFolderLocationEventThreatDetectionCustomModuleBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setEventThreatDetectionCustomModule(eventThreatDetectionCustomModule)
        .build()
        .toString();
  }

  public static EventThreatDetectionCustomModuleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_EVENT_THREAT_DETECTION_CUSTOM_MODULE.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_EVENT_THREAT_DETECTION_CUSTOM_MODULE.match(formattedString);
      return ofOrganizationLocationEventThreatDetectionCustomModuleName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("event_threat_detection_custom_module"));
    } else if (PROJECT_LOCATION_EVENT_THREAT_DETECTION_CUSTOM_MODULE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_EVENT_THREAT_DETECTION_CUSTOM_MODULE.match(formattedString);
      return ofProjectLocationEventThreatDetectionCustomModuleName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("event_threat_detection_custom_module"));
    } else if (FOLDER_LOCATION_EVENT_THREAT_DETECTION_CUSTOM_MODULE.matches(formattedString)) {
      Map<String, String> matchMap =
          FOLDER_LOCATION_EVENT_THREAT_DETECTION_CUSTOM_MODULE.match(formattedString);
      return ofFolderLocationEventThreatDetectionCustomModuleName(
          matchMap.get("folder"),
          matchMap.get("location"),
          matchMap.get("event_threat_detection_custom_module"));
    }
    throw new ValidationException(
        "EventThreatDetectionCustomModuleName.parse: formattedString not in valid format");
  }

  public static List<EventThreatDetectionCustomModuleName> parseList(
      List<String> formattedStrings) {
    List<EventThreatDetectionCustomModuleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EventThreatDetectionCustomModuleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EventThreatDetectionCustomModuleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_EVENT_THREAT_DETECTION_CUSTOM_MODULE.matches(formattedString)
        || PROJECT_LOCATION_EVENT_THREAT_DETECTION_CUSTOM_MODULE.matches(formattedString)
        || FOLDER_LOCATION_EVENT_THREAT_DETECTION_CUSTOM_MODULE.matches(formattedString);
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
          if (eventThreatDetectionCustomModule != null) {
            fieldMapBuilder.put(
                "event_threat_detection_custom_module", eventThreatDetectionCustomModule);
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
      EventThreatDetectionCustomModuleName that = ((EventThreatDetectionCustomModuleName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(
              this.eventThreatDetectionCustomModule, that.eventThreatDetectionCustomModule)
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
    h ^= Objects.hashCode(eventThreatDetectionCustomModule);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String eventThreatDetectionCustomModule;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getEventThreatDetectionCustomModule() {
      return eventThreatDetectionCustomModule;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setEventThreatDetectionCustomModule(String eventThreatDetectionCustomModule) {
      this.eventThreatDetectionCustomModule = eventThreatDetectionCustomModule;
      return this;
    }

    private Builder(EventThreatDetectionCustomModuleName eventThreatDetectionCustomModuleName) {
      Preconditions.checkArgument(
          Objects.equals(
              eventThreatDetectionCustomModuleName.pathTemplate,
              ORGANIZATION_LOCATION_EVENT_THREAT_DETECTION_CUSTOM_MODULE),
          "toBuilder is only supported when EventThreatDetectionCustomModuleName has the pattern of organizations/{organization}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}");
      this.organization = eventThreatDetectionCustomModuleName.organization;
      this.location = eventThreatDetectionCustomModuleName.location;
      this.eventThreatDetectionCustomModule =
          eventThreatDetectionCustomModuleName.eventThreatDetectionCustomModule;
    }

    public EventThreatDetectionCustomModuleName build() {
      return new EventThreatDetectionCustomModuleName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationEventThreatDetectionCustomModuleBuilder {
    private String project;
    private String location;
    private String eventThreatDetectionCustomModule;

    protected ProjectLocationEventThreatDetectionCustomModuleBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getEventThreatDetectionCustomModule() {
      return eventThreatDetectionCustomModule;
    }

    public ProjectLocationEventThreatDetectionCustomModuleBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationEventThreatDetectionCustomModuleBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationEventThreatDetectionCustomModuleBuilder
        setEventThreatDetectionCustomModule(String eventThreatDetectionCustomModule) {
      this.eventThreatDetectionCustomModule = eventThreatDetectionCustomModule;
      return this;
    }

    public EventThreatDetectionCustomModuleName build() {
      return new EventThreatDetectionCustomModuleName(this);
    }
  }

  /**
   * Builder for
   * folders/{folder}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderLocationEventThreatDetectionCustomModuleBuilder {
    private String folder;
    private String location;
    private String eventThreatDetectionCustomModule;

    protected FolderLocationEventThreatDetectionCustomModuleBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getEventThreatDetectionCustomModule() {
      return eventThreatDetectionCustomModule;
    }

    public FolderLocationEventThreatDetectionCustomModuleBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationEventThreatDetectionCustomModuleBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationEventThreatDetectionCustomModuleBuilder
        setEventThreatDetectionCustomModule(String eventThreatDetectionCustomModule) {
      this.eventThreatDetectionCustomModule = eventThreatDetectionCustomModule;
      return this;
    }

    public EventThreatDetectionCustomModuleName build() {
      return new EventThreatDetectionCustomModuleName(this);
    }
  }
}
