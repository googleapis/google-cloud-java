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
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class ComponentSettingsName implements ResourceName {
  private static final PathTemplate ORGANIZATION_COMPONENT =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/components/{component}/settings");
  private static final PathTemplate FOLDER_COMPONENT =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/components/{component}/settings");
  private static final PathTemplate PROJECT_COMPONENT =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/components/{component}/settings");
  private static final PathTemplate PROJECT_LOCATION_CLUSTER_COMPONENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/clusters/{cluster}/components/{component}/settings");
  private static final PathTemplate PROJECT_REGION_CLUSTER_COMPONENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/regions/{region}/clusters/{cluster}/components/{component}/settings");
  private static final PathTemplate PROJECT_ZONE_CLUSTER_COMPONENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/zones/{zone}/clusters/{cluster}/components/{component}/settings");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String component;
  private final String folder;
  private final String project;
  private final String location;
  private final String cluster;
  private final String region;
  private final String zone;

  @Deprecated
  protected ComponentSettingsName() {
    organization = null;
    component = null;
    folder = null;
    project = null;
    location = null;
    cluster = null;
    region = null;
    zone = null;
  }

  private ComponentSettingsName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    component = Preconditions.checkNotNull(builder.getComponent());
    folder = null;
    project = null;
    location = null;
    cluster = null;
    region = null;
    zone = null;
    pathTemplate = ORGANIZATION_COMPONENT;
  }

  private ComponentSettingsName(FolderComponentBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    component = Preconditions.checkNotNull(builder.getComponent());
    organization = null;
    project = null;
    location = null;
    cluster = null;
    region = null;
    zone = null;
    pathTemplate = FOLDER_COMPONENT;
  }

  private ComponentSettingsName(ProjectComponentBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    component = Preconditions.checkNotNull(builder.getComponent());
    organization = null;
    folder = null;
    location = null;
    cluster = null;
    region = null;
    zone = null;
    pathTemplate = PROJECT_COMPONENT;
  }

  private ComponentSettingsName(ProjectLocationClusterComponentBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    component = Preconditions.checkNotNull(builder.getComponent());
    organization = null;
    folder = null;
    region = null;
    zone = null;
    pathTemplate = PROJECT_LOCATION_CLUSTER_COMPONENT;
  }

  private ComponentSettingsName(ProjectRegionClusterComponentBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    component = Preconditions.checkNotNull(builder.getComponent());
    organization = null;
    folder = null;
    location = null;
    zone = null;
    pathTemplate = PROJECT_REGION_CLUSTER_COMPONENT;
  }

  private ComponentSettingsName(ProjectZoneClusterComponentBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    zone = Preconditions.checkNotNull(builder.getZone());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    component = Preconditions.checkNotNull(builder.getComponent());
    organization = null;
    folder = null;
    location = null;
    region = null;
    pathTemplate = PROJECT_ZONE_CLUSTER_COMPONENT;
  }

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

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newOrganizationComponentBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderComponentBuilder newFolderComponentBuilder() {
    return new FolderComponentBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectComponentBuilder newProjectComponentBuilder() {
    return new ProjectComponentBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationClusterComponentBuilder newProjectLocationClusterComponentBuilder() {
    return new ProjectLocationClusterComponentBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectRegionClusterComponentBuilder newProjectRegionClusterComponentBuilder() {
    return new ProjectRegionClusterComponentBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectZoneClusterComponentBuilder newProjectZoneClusterComponentBuilder() {
    return new ProjectZoneClusterComponentBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ComponentSettingsName of(String organization, String component) {
    return newBuilder().setOrganization(organization).setComponent(component).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ComponentSettingsName ofOrganizationComponentName(
      String organization, String component) {
    return newBuilder().setOrganization(organization).setComponent(component).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ComponentSettingsName ofFolderComponentName(String folder, String component) {
    return newFolderComponentBuilder().setFolder(folder).setComponent(component).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ComponentSettingsName ofProjectComponentName(String project, String component) {
    return newProjectComponentBuilder().setProject(project).setComponent(component).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ComponentSettingsName ofProjectLocationClusterComponentName(
      String project, String location, String cluster, String component) {
    return newProjectLocationClusterComponentBuilder()
        .setProject(project)
        .setLocation(location)
        .setCluster(cluster)
        .setComponent(component)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ComponentSettingsName ofProjectRegionClusterComponentName(
      String project, String region, String cluster, String component) {
    return newProjectRegionClusterComponentBuilder()
        .setProject(project)
        .setRegion(region)
        .setCluster(cluster)
        .setComponent(component)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ComponentSettingsName ofProjectZoneClusterComponentName(
      String project, String zone, String cluster, String component) {
    return newProjectZoneClusterComponentBuilder()
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
  public static String formatOrganizationComponentName(String organization, String component) {
    return newBuilder().setOrganization(organization).setComponent(component).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderComponentName(String folder, String component) {
    return newFolderComponentBuilder().setFolder(folder).setComponent(component).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectComponentName(String project, String component) {
    return newProjectComponentBuilder()
        .setProject(project)
        .setComponent(component)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationClusterComponentName(
      String project, String location, String cluster, String component) {
    return newProjectLocationClusterComponentBuilder()
        .setProject(project)
        .setLocation(location)
        .setCluster(cluster)
        .setComponent(component)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectRegionClusterComponentName(
      String project, String region, String cluster, String component) {
    return newProjectRegionClusterComponentBuilder()
        .setProject(project)
        .setRegion(region)
        .setCluster(cluster)
        .setComponent(component)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectZoneClusterComponentName(
      String project, String zone, String cluster, String component) {
    return newProjectZoneClusterComponentBuilder()
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
    if (ORGANIZATION_COMPONENT.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_COMPONENT.match(formattedString);
      return ofOrganizationComponentName(matchMap.get("organization"), matchMap.get("component"));
    } else if (FOLDER_COMPONENT.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_COMPONENT.match(formattedString);
      return ofFolderComponentName(matchMap.get("folder"), matchMap.get("component"));
    } else if (PROJECT_COMPONENT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_COMPONENT.match(formattedString);
      return ofProjectComponentName(matchMap.get("project"), matchMap.get("component"));
    } else if (PROJECT_LOCATION_CLUSTER_COMPONENT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_CLUSTER_COMPONENT.match(formattedString);
      return ofProjectLocationClusterComponentName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("cluster"),
          matchMap.get("component"));
    } else if (PROJECT_REGION_CLUSTER_COMPONENT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_REGION_CLUSTER_COMPONENT.match(formattedString);
      return ofProjectRegionClusterComponentName(
          matchMap.get("project"),
          matchMap.get("region"),
          matchMap.get("cluster"),
          matchMap.get("component"));
    } else if (PROJECT_ZONE_CLUSTER_COMPONENT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_ZONE_CLUSTER_COMPONENT.match(formattedString);
      return ofProjectZoneClusterComponentName(
          matchMap.get("project"),
          matchMap.get("zone"),
          matchMap.get("cluster"),
          matchMap.get("component"));
    }
    throw new ValidationException(
        "ComponentSettingsName.parse: formattedString not in valid format");
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
    return ORGANIZATION_COMPONENT.matches(formattedString)
        || FOLDER_COMPONENT.matches(formattedString)
        || PROJECT_COMPONENT.matches(formattedString)
        || PROJECT_LOCATION_CLUSTER_COMPONENT.matches(formattedString)
        || PROJECT_REGION_CLUSTER_COMPONENT.matches(formattedString)
        || PROJECT_ZONE_CLUSTER_COMPONENT.matches(formattedString);
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

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ComponentSettingsName that = ((ComponentSettingsName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.component, that.component)
          && Objects.equals(this.folder, that.folder)
          && Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.cluster, that.cluster)
          && Objects.equals(this.region, that.region)
          && Objects.equals(this.zone, that.zone);
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
          Objects.equals(componentSettingsName.pathTemplate, ORGANIZATION_COMPONENT),
          "toBuilder is only supported when ComponentSettingsName has the pattern of organizations/{organization}/components/{component}/settings");
      this.organization = componentSettingsName.organization;
      this.component = componentSettingsName.component;
    }

    public ComponentSettingsName build() {
      return new ComponentSettingsName(this);
    }
  }

  /** Builder for folders/{folder}/components/{component}/settings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderComponentBuilder {
    private String folder;
    private String component;

    protected FolderComponentBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getComponent() {
      return component;
    }

    public FolderComponentBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderComponentBuilder setComponent(String component) {
      this.component = component;
      return this;
    }

    public ComponentSettingsName build() {
      return new ComponentSettingsName(this);
    }
  }

  /** Builder for projects/{project}/components/{component}/settings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectComponentBuilder {
    private String project;
    private String component;

    protected ProjectComponentBuilder() {}

    public String getProject() {
      return project;
    }

    public String getComponent() {
      return component;
    }

    public ProjectComponentBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectComponentBuilder setComponent(String component) {
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
  public static class ProjectLocationClusterComponentBuilder {
    private String project;
    private String location;
    private String cluster;
    private String component;

    protected ProjectLocationClusterComponentBuilder() {}

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

    public ProjectLocationClusterComponentBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationClusterComponentBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationClusterComponentBuilder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public ProjectLocationClusterComponentBuilder setComponent(String component) {
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
  public static class ProjectRegionClusterComponentBuilder {
    private String project;
    private String region;
    private String cluster;
    private String component;

    protected ProjectRegionClusterComponentBuilder() {}

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

    public ProjectRegionClusterComponentBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectRegionClusterComponentBuilder setRegion(String region) {
      this.region = region;
      return this;
    }

    public ProjectRegionClusterComponentBuilder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public ProjectRegionClusterComponentBuilder setComponent(String component) {
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
  public static class ProjectZoneClusterComponentBuilder {
    private String project;
    private String zone;
    private String cluster;
    private String component;

    protected ProjectZoneClusterComponentBuilder() {}

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

    public ProjectZoneClusterComponentBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectZoneClusterComponentBuilder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public ProjectZoneClusterComponentBuilder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public ProjectZoneClusterComponentBuilder setComponent(String component) {
      this.component = component;
      return this;
    }

    public ComponentSettingsName build() {
      return new ComponentSettingsName(this);
    }
  }
}
