/*
 * Copyright 2020 Google LLC
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
public class MonitoredResourceDescriptorName implements ResourceName {
  private static final PathTemplate PROJECT_MONITORED_RESOURCE_DESCRIPTOR =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/monitoredResourceDescriptors/{monitored_resource_descriptor}");
  private static final PathTemplate ORGANIZATION_MONITORED_RESOURCE_DESCRIPTOR =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/monitoredResourceDescriptors/{monitored_resource_descriptor}");
  private static final PathTemplate FOLDER_MONITORED_RESOURCE_DESCRIPTOR =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/monitoredResourceDescriptors/{monitored_resource_descriptor}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String monitoredResourceDescriptor;
  private final String organization;
  private final String folder;

  @Deprecated
  protected MonitoredResourceDescriptorName() {
    project = null;
    monitoredResourceDescriptor = null;
    organization = null;
    folder = null;
  }

  private MonitoredResourceDescriptorName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    monitoredResourceDescriptor =
        Preconditions.checkNotNull(builder.getMonitoredResourceDescriptor());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_MONITORED_RESOURCE_DESCRIPTOR;
  }

  private MonitoredResourceDescriptorName(OrganizationMonitoredResourceDescriptorBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    monitoredResourceDescriptor =
        Preconditions.checkNotNull(builder.getMonitoredResourceDescriptor());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_MONITORED_RESOURCE_DESCRIPTOR;
  }

  private MonitoredResourceDescriptorName(FolderMonitoredResourceDescriptorBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    monitoredResourceDescriptor =
        Preconditions.checkNotNull(builder.getMonitoredResourceDescriptor());
    project = null;
    organization = null;
    pathTemplate = FOLDER_MONITORED_RESOURCE_DESCRIPTOR;
  }

  public String getProject() {
    return project;
  }

  public String getMonitoredResourceDescriptor() {
    return monitoredResourceDescriptor;
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
  public static Builder newProjectMonitoredResourceDescriptorBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationMonitoredResourceDescriptorBuilder
      newOrganizationMonitoredResourceDescriptorBuilder() {
    return new OrganizationMonitoredResourceDescriptorBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderMonitoredResourceDescriptorBuilder
      newFolderMonitoredResourceDescriptorBuilder() {
    return new FolderMonitoredResourceDescriptorBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MonitoredResourceDescriptorName of(
      String project, String monitoredResourceDescriptor) {
    return newBuilder()
        .setProject(project)
        .setMonitoredResourceDescriptor(monitoredResourceDescriptor)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static MonitoredResourceDescriptorName ofProjectMonitoredResourceDescriptorName(
      String project, String monitoredResourceDescriptor) {
    return newBuilder()
        .setProject(project)
        .setMonitoredResourceDescriptor(monitoredResourceDescriptor)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static MonitoredResourceDescriptorName ofOrganizationMonitoredResourceDescriptorName(
      String organization, String monitoredResourceDescriptor) {
    return newOrganizationMonitoredResourceDescriptorBuilder()
        .setOrganization(organization)
        .setMonitoredResourceDescriptor(monitoredResourceDescriptor)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static MonitoredResourceDescriptorName ofFolderMonitoredResourceDescriptorName(
      String folder, String monitoredResourceDescriptor) {
    return newFolderMonitoredResourceDescriptorBuilder()
        .setFolder(folder)
        .setMonitoredResourceDescriptor(monitoredResourceDescriptor)
        .build();
  }

  public static String format(String project, String monitoredResourceDescriptor) {
    return newBuilder()
        .setProject(project)
        .setMonitoredResourceDescriptor(monitoredResourceDescriptor)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectMonitoredResourceDescriptorName(
      String project, String monitoredResourceDescriptor) {
    return newBuilder()
        .setProject(project)
        .setMonitoredResourceDescriptor(monitoredResourceDescriptor)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationMonitoredResourceDescriptorName(
      String organization, String monitoredResourceDescriptor) {
    return newOrganizationMonitoredResourceDescriptorBuilder()
        .setOrganization(organization)
        .setMonitoredResourceDescriptor(monitoredResourceDescriptor)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderMonitoredResourceDescriptorName(
      String folder, String monitoredResourceDescriptor) {
    return newFolderMonitoredResourceDescriptorBuilder()
        .setFolder(folder)
        .setMonitoredResourceDescriptor(monitoredResourceDescriptor)
        .build()
        .toString();
  }

  public static MonitoredResourceDescriptorName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_MONITORED_RESOURCE_DESCRIPTOR.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_MONITORED_RESOURCE_DESCRIPTOR.match(formattedString);
      return ofProjectMonitoredResourceDescriptorName(
          matchMap.get("project"), matchMap.get("monitored_resource_descriptor"));
    } else if (ORGANIZATION_MONITORED_RESOURCE_DESCRIPTOR.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_MONITORED_RESOURCE_DESCRIPTOR.match(formattedString);
      return ofOrganizationMonitoredResourceDescriptorName(
          matchMap.get("organization"), matchMap.get("monitored_resource_descriptor"));
    } else if (FOLDER_MONITORED_RESOURCE_DESCRIPTOR.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_MONITORED_RESOURCE_DESCRIPTOR.match(formattedString);
      return ofFolderMonitoredResourceDescriptorName(
          matchMap.get("folder"), matchMap.get("monitored_resource_descriptor"));
    }
    throw new ValidationException(
        "MonitoredResourceDescriptorName.parse: formattedString not in valid format");
  }

  public static List<MonitoredResourceDescriptorName> parseList(List<String> formattedStrings) {
    List<MonitoredResourceDescriptorName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MonitoredResourceDescriptorName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MonitoredResourceDescriptorName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_MONITORED_RESOURCE_DESCRIPTOR.matches(formattedString)
        || ORGANIZATION_MONITORED_RESOURCE_DESCRIPTOR.matches(formattedString)
        || FOLDER_MONITORED_RESOURCE_DESCRIPTOR.matches(formattedString);
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
          if (monitoredResourceDescriptor != null) {
            fieldMapBuilder.put("monitored_resource_descriptor", monitoredResourceDescriptor);
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
      MonitoredResourceDescriptorName that = ((MonitoredResourceDescriptorName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.monitoredResourceDescriptor, that.monitoredResourceDescriptor)
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
    h ^= Objects.hashCode(monitoredResourceDescriptor);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    return h;
  }

  /**
   * Builder for projects/{project}/monitoredResourceDescriptors/{monitored_resource_descriptor}.
   */
  public static class Builder {
    private String project;
    private String monitoredResourceDescriptor;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getMonitoredResourceDescriptor() {
      return monitoredResourceDescriptor;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setMonitoredResourceDescriptor(String monitoredResourceDescriptor) {
      this.monitoredResourceDescriptor = monitoredResourceDescriptor;
      return this;
    }

    private Builder(MonitoredResourceDescriptorName monitoredResourceDescriptorName) {
      Preconditions.checkArgument(
          Objects.equals(
              monitoredResourceDescriptorName.pathTemplate, PROJECT_MONITORED_RESOURCE_DESCRIPTOR),
          "toBuilder is only supported when MonitoredResourceDescriptorName has the pattern of projects/{project}/monitoredResourceDescriptors/{monitored_resource_descriptor}");
      project = monitoredResourceDescriptorName.project;
      monitoredResourceDescriptor = monitoredResourceDescriptorName.monitoredResourceDescriptor;
    }

    public MonitoredResourceDescriptorName build() {
      return new MonitoredResourceDescriptorName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/monitoredResourceDescriptors/{monitored_resource_descriptor}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationMonitoredResourceDescriptorBuilder {
    private String organization;
    private String monitoredResourceDescriptor;

    protected OrganizationMonitoredResourceDescriptorBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getMonitoredResourceDescriptor() {
      return monitoredResourceDescriptor;
    }

    public OrganizationMonitoredResourceDescriptorBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationMonitoredResourceDescriptorBuilder setMonitoredResourceDescriptor(
        String monitoredResourceDescriptor) {
      this.monitoredResourceDescriptor = monitoredResourceDescriptor;
      return this;
    }

    public MonitoredResourceDescriptorName build() {
      return new MonitoredResourceDescriptorName(this);
    }
  }

  /** Builder for folders/{folder}/monitoredResourceDescriptors/{monitored_resource_descriptor}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderMonitoredResourceDescriptorBuilder {
    private String folder;
    private String monitoredResourceDescriptor;

    protected FolderMonitoredResourceDescriptorBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getMonitoredResourceDescriptor() {
      return monitoredResourceDescriptor;
    }

    public FolderMonitoredResourceDescriptorBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderMonitoredResourceDescriptorBuilder setMonitoredResourceDescriptor(
        String monitoredResourceDescriptor) {
      this.monitoredResourceDescriptor = monitoredResourceDescriptor;
      return this;
    }

    public MonitoredResourceDescriptorName build() {
      return new MonitoredResourceDescriptorName(this);
    }
  }
}
