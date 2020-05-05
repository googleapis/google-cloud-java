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

package com.google.cloud.securitycenter.settings.v1beta1;

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

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ComponentSettingsName implements ResourceName {

  @Deprecated
  protected ComponentSettingsName() {}

  private static final PathTemplate ORGANIZATION_COMPONENT_SETTINGS_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/components/{component}/settings");
  private static final PathTemplate FOLDER_COMPONENT_SETTINGS_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/components/{component}/settings");
  private static final PathTemplate PROJECT_COMPONENT_SETTINGS_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/components/{component}/settings");
  private static final PathTemplate PROJECT_LOCATION_CLUSTER_COMPONENT_SETTINGS_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/clusters/{cluster}/components/{component}/settings");
  private static final PathTemplate PROJECT_REGION_CLUSTER_COMPONENT_SETTINGS_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/regions/{region}/clusters/{cluster}/components/{component}/settings");
  private static final PathTemplate PROJECT_ZONE_CLUSTER_COMPONENT_SETTINGS_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/zones/{zone}/clusters/{cluster}/components/{component}/settings");

  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;

  private String organization;
  private String component;
  private String folder;
  private String project;
  private String location;
  private String cluster;
  private String region;
  private String zone;

  public String getOrganization() {
    return organization;
  }

  public String getComponent() {
    return component;
  }

  public String getFolder() {
    return folder;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getCluster() {
    return cluster;
  }

  public String getRegion() {
    return region;
  }

  public String getZone() {
    return zone;
  }

  private ComponentSettingsName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    component = Preconditions.checkNotNull(builder.getComponent());
    pathTemplate = ORGANIZATION_COMPONENT_SETTINGS_PATH_TEMPLATE;
  }

  private ComponentSettingsName(FolderComponentSettingsBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    component = Preconditions.checkNotNull(builder.getComponent());
    pathTemplate = FOLDER_COMPONENT_SETTINGS_PATH_TEMPLATE;
  }

  private ComponentSettingsName(ProjectComponentSettingsBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    component = Preconditions.checkNotNull(builder.getComponent());
    pathTemplate = PROJECT_COMPONENT_SETTINGS_PATH_TEMPLATE;
  }

  private ComponentSettingsName(ProjectLocationClusterComponentSettingsBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    component = Preconditions.checkNotNull(builder.getComponent());
    pathTemplate = PROJECT_LOCATION_CLUSTER_COMPONENT_SETTINGS_PATH_TEMPLATE;
  }

  private ComponentSettingsName(ProjectRegionClusterComponentSettingsBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    component = Preconditions.checkNotNull(builder.getComponent());
    pathTemplate = PROJECT_REGION_CLUSTER_COMPONENT_SETTINGS_PATH_TEMPLATE;
  }

  private ComponentSettingsName(ProjectZoneClusterComponentSettingsBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    zone = Preconditions.checkNotNull(builder.getZone());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    component = Preconditions.checkNotNull(builder.getComponent());
    pathTemplate = PROJECT_ZONE_CLUSTER_COMPONENT_SETTINGS_PATH_TEMPLATE;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newOrganizationComponentSettingsBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderComponentSettingsBuilder newFolderComponentSettingsBuilder() {
    return new FolderComponentSettingsBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectComponentSettingsBuilder newProjectComponentSettingsBuilder() {
    return new ProjectComponentSettingsBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationClusterComponentSettingsBuilder
      newProjectLocationClusterComponentSettingsBuilder() {
    return new ProjectLocationClusterComponentSettingsBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectRegionClusterComponentSettingsBuilder
      newProjectRegionClusterComponentSettingsBuilder() {
    return new ProjectRegionClusterComponentSettingsBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectZoneClusterComponentSettingsBuilder
      newProjectZoneClusterComponentSettingsBuilder() {
    return new ProjectZoneClusterComponentSettingsBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ComponentSettingsName of(String organization, String component) {
    return newOrganizationComponentSettingsBuilder()
        .setOrganization(organization)
        .setComponent(component)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ComponentSettingsName ofOrganizationComponentSettingsName(
      String organization, String component) {
    return newOrganizationComponentSettingsBuilder()
        .setOrganization(organization)
        .setComponent(component)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ComponentSettingsName ofFolderComponentSettingsName(
      String folder, String component) {
    return newFolderComponentSettingsBuilder().setFolder(folder).setComponent(component).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ComponentSettingsName ofProjectComponentSettingsName(
      String project, String component) {
    return newProjectComponentSettingsBuilder().setProject(project).setComponent(component).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ComponentSettingsName ofProjectLocationClusterComponentSettingsName(
      String project, String location, String cluster, String component) {
    return newProjectLocationClusterComponentSettingsBuilder()
        .setProject(project)
        .setLocation(location)
        .setCluster(cluster)
        .setComponent(component)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ComponentSettingsName ofProjectRegionClusterComponentSettingsName(
      String project, String region, String cluster, String component) {
    return newProjectRegionClusterComponentSettingsBuilder()
        .setProject(project)
        .setRegion(region)
        .setCluster(cluster)
        .setComponent(component)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ComponentSettingsName ofProjectZoneClusterComponentSettingsName(
      String project, String zone, String cluster, String component) {
    return newProjectZoneClusterComponentSettingsBuilder()
        .setProject(project)
        .setZone(zone)
        .setCluster(cluster)
        .setComponent(component)
        .build();
  }

  public static String format(String organization, String component) {
    return newBuilder().setOrganization(organization).setComponent(component).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationComponentSettingsName(
      String organization, String component) {
    return newBuilder().setOrganization(organization).setComponent(component).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderComponentSettingsName(String folder, String component) {
    return newFolderComponentSettingsBuilder()
        .setFolder(folder)
        .setComponent(component)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectComponentSettingsName(String project, String component) {
    return newProjectComponentSettingsBuilder()
        .setProject(project)
        .setComponent(component)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationClusterComponentSettingsName(
      String project, String location, String cluster, String component) {
    return newProjectLocationClusterComponentSettingsBuilder()
        .setProject(project)
        .setLocation(location)
        .setCluster(cluster)
        .setComponent(component)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectRegionClusterComponentSettingsName(
      String project, String region, String cluster, String component) {
    return newProjectRegionClusterComponentSettingsBuilder()
        .setProject(project)
        .setRegion(region)
        .setCluster(cluster)
        .setComponent(component)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectZoneClusterComponentSettingsName(
      String project, String zone, String cluster, String component) {
    return newProjectZoneClusterComponentSettingsBuilder()
        .setProject(project)
        .setZone(zone)
        .setCluster(cluster)
        .setComponent(component)
        .build()
        .toString();
  }

  public static ComponentSettingsName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_COMPONENT_SETTINGS_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_COMPONENT_SETTINGS_PATH_TEMPLATE.match(formattedString);
      return ofOrganizationComponentSettingsName(
          matchMap.get("organization"), matchMap.get("component"));
    } else if (FOLDER_COMPONENT_SETTINGS_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_COMPONENT_SETTINGS_PATH_TEMPLATE.match(formattedString);
      return ofFolderComponentSettingsName(matchMap.get("folder"), matchMap.get("component"));
    } else if (PROJECT_COMPONENT_SETTINGS_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_COMPONENT_SETTINGS_PATH_TEMPLATE.match(formattedString);
      return ofProjectComponentSettingsName(matchMap.get("project"), matchMap.get("component"));
    } else if (PROJECT_LOCATION_CLUSTER_COMPONENT_SETTINGS_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_CLUSTER_COMPONENT_SETTINGS_PATH_TEMPLATE.match(formattedString);
      return ofProjectLocationClusterComponentSettingsName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("cluster"),
          matchMap.get("component"));
    } else if (PROJECT_REGION_CLUSTER_COMPONENT_SETTINGS_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_REGION_CLUSTER_COMPONENT_SETTINGS_PATH_TEMPLATE.match(formattedString);
      return ofProjectRegionClusterComponentSettingsName(
          matchMap.get("project"),
          matchMap.get("region"),
          matchMap.get("cluster"),
          matchMap.get("component"));
    } else if (PROJECT_ZONE_CLUSTER_COMPONENT_SETTINGS_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_ZONE_CLUSTER_COMPONENT_SETTINGS_PATH_TEMPLATE.match(formattedString);
      return ofProjectZoneClusterComponentSettingsName(
          matchMap.get("project"),
          matchMap.get("zone"),
          matchMap.get("cluster"),
          matchMap.get("component"));
    }
    throw new ValidationException("JobName.parse: formattedString not in valid format");
  }

  public static List<ComponentSettingsName> parseList(List<String> formattedStrings) {
    List<ComponentSettingsName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ComponentSettingsName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ComponentSettingsName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_COMPONENT_SETTINGS_PATH_TEMPLATE.matches(formattedString)
        || FOLDER_COMPONENT_SETTINGS_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_COMPONENT_SETTINGS_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_LOCATION_CLUSTER_COMPONENT_SETTINGS_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_REGION_CLUSTER_COMPONENT_SETTINGS_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_ZONE_CLUSTER_COMPONENT_SETTINGS_PATH_TEMPLATE.matches(formattedString);
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
          if (component != null) {
            fieldMapBuilder.put("component", component);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
          }
          if (project != null) {
            fieldMapBuilder.put("project", project);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (cluster != null) {
            fieldMapBuilder.put("cluster", cluster);
          }
          if (region != null) {
            fieldMapBuilder.put("region", region);
          }
          if (zone != null) {
            fieldMapBuilder.put("zone", zone);
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

  /** Builder for organizations/{organization}/components/{component}/settings. */
  public static class Builder {

    private String organization;
    private String component;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getComponent() {
      return component;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setComponent(String component) {
      this.component = component;
      return this;
    }

    private Builder(ComponentSettingsName componentSettingsName) {
      Preconditions.checkArgument(
          componentSettingsName.pathTemplate == ORGANIZATION_COMPONENT_SETTINGS_PATH_TEMPLATE,
          "toBuilder is only supported when ComponentSettingsName has the pattern of "
              + "organizations/{organization}/components/{component}/settings.");
      organization = componentSettingsName.organization;
      component = componentSettingsName.component;
    }

    public ComponentSettingsName build() {
      return new ComponentSettingsName(this);
    }
  }

  /** Builder for folders/{folder}/components/{component}/settings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderComponentSettingsBuilder {

    private String folder;
    private String component;

    private FolderComponentSettingsBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getComponent() {
      return component;
    }

    public FolderComponentSettingsBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderComponentSettingsBuilder setComponent(String component) {
      this.component = component;
      return this;
    }

    public ComponentSettingsName build() {
      return new ComponentSettingsName(this);
    }
  }

  /** Builder for projects/{project}/components/{component}/settings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectComponentSettingsBuilder {

    private String project;
    private String component;

    private ProjectComponentSettingsBuilder() {}

    public String getProject() {
      return project;
    }

    public String getComponent() {
      return component;
    }

    public ProjectComponentSettingsBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectComponentSettingsBuilder setComponent(String component) {
      this.component = component;
      return this;
    }

    public ComponentSettingsName build() {
      return new ComponentSettingsName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/clusters/{cluster}/components/{component}/settings.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationClusterComponentSettingsBuilder {

    private String project;
    private String location;
    private String cluster;
    private String component;

    private ProjectLocationClusterComponentSettingsBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCluster() {
      return cluster;
    }

    public String getComponent() {
      return component;
    }

    public ProjectLocationClusterComponentSettingsBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationClusterComponentSettingsBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationClusterComponentSettingsBuilder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public ProjectLocationClusterComponentSettingsBuilder setComponent(String component) {
      this.component = component;
      return this;
    }

    public ComponentSettingsName build() {
      return new ComponentSettingsName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/regions/{region}/clusters/{cluster}/components/{component}/settings.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectRegionClusterComponentSettingsBuilder {

    private String project;
    private String region;
    private String cluster;
    private String component;

    private ProjectRegionClusterComponentSettingsBuilder() {}

    public String getProject() {
      return project;
    }

    public String getRegion() {
      return region;
    }

    public String getCluster() {
      return cluster;
    }

    public String getComponent() {
      return component;
    }

    public ProjectRegionClusterComponentSettingsBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectRegionClusterComponentSettingsBuilder setRegion(String region) {
      this.region = region;
      return this;
    }

    public ProjectRegionClusterComponentSettingsBuilder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public ProjectRegionClusterComponentSettingsBuilder setComponent(String component) {
      this.component = component;
      return this;
    }

    public ComponentSettingsName build() {
      return new ComponentSettingsName(this);
    }
  }

  /**
   * Builder for projects/{project}/zones/{zone}/clusters/{cluster}/components/{component}/settings.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectZoneClusterComponentSettingsBuilder {

    private String project;
    private String zone;
    private String cluster;
    private String component;

    private ProjectZoneClusterComponentSettingsBuilder() {}

    public String getProject() {
      return project;
    }

    public String getZone() {
      return zone;
    }

    public String getCluster() {
      return cluster;
    }

    public String getComponent() {
      return component;
    }

    public ProjectZoneClusterComponentSettingsBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectZoneClusterComponentSettingsBuilder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public ProjectZoneClusterComponentSettingsBuilder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public ProjectZoneClusterComponentSettingsBuilder setComponent(String component) {
      this.component = component;
      return this;
    }

    public ComponentSettingsName build() {
      return new ComponentSettingsName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ComponentSettingsName that = (ComponentSettingsName) o;
      return (Objects.equals(this.organization, that.organization))
          && (Objects.equals(this.component, that.component))
          && (Objects.equals(this.folder, that.folder))
          && (Objects.equals(this.project, that.project))
          && (Objects.equals(this.location, that.location))
          && (Objects.equals(this.cluster, that.cluster))
          && (Objects.equals(this.region, that.region))
          && (Objects.equals(this.zone, that.zone));
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
    h ^= Objects.hashCode(component);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(cluster);
    h *= 1000003;
    h ^= Objects.hashCode(region);
    h *= 1000003;
    h ^= Objects.hashCode(zone);
    return h;
  }
}
