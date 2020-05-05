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
public class SettingsName implements ResourceName {

  @Deprecated
  protected SettingsName() {}

  private static final PathTemplate ORGANIZATION_SETTINGS_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/settings");
  private static final PathTemplate FOLDER_SETTINGS_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/settings");
  private static final PathTemplate PROJECT_SETTINGS_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/settings");
  private static final PathTemplate PROJECT_LOCATION_CLUSTER_SETTINGS_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/clusters/{cluster}/settings");
  private static final PathTemplate PROJECT_REGION_CLUSTER_SETTINGS_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/regions/{region}/clusters/{cluster}/settings");
  private static final PathTemplate PROJECT_ZONE_CLUSTER_SETTINGS_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/zones/{zone}/clusters/{cluster}/settings");

  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;

  private String organization;
  private String folder;
  private String project;
  private String location;
  private String cluster;
  private String region;
  private String zone;

  public String getOrganization() {
    return organization;
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

  private SettingsName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    pathTemplate = ORGANIZATION_SETTINGS_PATH_TEMPLATE;
  }

  private SettingsName(FolderSettingsBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    pathTemplate = FOLDER_SETTINGS_PATH_TEMPLATE;
  }

  private SettingsName(ProjectSettingsBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    pathTemplate = PROJECT_SETTINGS_PATH_TEMPLATE;
  }

  private SettingsName(ProjectLocationClusterSettingsBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    pathTemplate = PROJECT_LOCATION_CLUSTER_SETTINGS_PATH_TEMPLATE;
  }

  private SettingsName(ProjectRegionClusterSettingsBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    pathTemplate = PROJECT_REGION_CLUSTER_SETTINGS_PATH_TEMPLATE;
  }

  private SettingsName(ProjectZoneClusterSettingsBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    zone = Preconditions.checkNotNull(builder.getZone());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    pathTemplate = PROJECT_ZONE_CLUSTER_SETTINGS_PATH_TEMPLATE;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newOrganizationSettingsBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderSettingsBuilder newFolderSettingsBuilder() {
    return new FolderSettingsBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectSettingsBuilder newProjectSettingsBuilder() {
    return new ProjectSettingsBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationClusterSettingsBuilder newProjectLocationClusterSettingsBuilder() {
    return new ProjectLocationClusterSettingsBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectRegionClusterSettingsBuilder newProjectRegionClusterSettingsBuilder() {
    return new ProjectRegionClusterSettingsBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectZoneClusterSettingsBuilder newProjectZoneClusterSettingsBuilder() {
    return new ProjectZoneClusterSettingsBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SettingsName of(String organization) {
    return newOrganizationSettingsBuilder().setOrganization(organization).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SettingsName ofOrganizationSettingsName(String organization) {
    return newOrganizationSettingsBuilder().setOrganization(organization).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SettingsName ofFolderSettingsName(String folder) {
    return newFolderSettingsBuilder().setFolder(folder).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SettingsName ofProjectSettingsName(String project) {
    return newProjectSettingsBuilder().setProject(project).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SettingsName ofProjectLocationClusterSettingsName(
      String project, String location, String cluster) {
    return newProjectLocationClusterSettingsBuilder()
        .setProject(project)
        .setLocation(location)
        .setCluster(cluster)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SettingsName ofProjectRegionClusterSettingsName(
      String project, String region, String cluster) {
    return newProjectRegionClusterSettingsBuilder()
        .setProject(project)
        .setRegion(region)
        .setCluster(cluster)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SettingsName ofProjectZoneClusterSettingsName(
      String project, String zone, String cluster) {
    return newProjectZoneClusterSettingsBuilder()
        .setProject(project)
        .setZone(zone)
        .setCluster(cluster)
        .build();
  }

  public static String format(String organization) {
    return newBuilder().setOrganization(organization).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationSettingsName(String organization) {
    return newBuilder().setOrganization(organization).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderSettingsName(String folder) {
    return newFolderSettingsBuilder().setFolder(folder).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectSettingsName(String project) {
    return newProjectSettingsBuilder().setProject(project).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationClusterSettingsName(
      String project, String location, String cluster) {
    return newProjectLocationClusterSettingsBuilder()
        .setProject(project)
        .setLocation(location)
        .setCluster(cluster)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectRegionClusterSettingsName(
      String project, String region, String cluster) {
    return newProjectRegionClusterSettingsBuilder()
        .setProject(project)
        .setRegion(region)
        .setCluster(cluster)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectZoneClusterSettingsName(
      String project, String zone, String cluster) {
    return newProjectZoneClusterSettingsBuilder()
        .setProject(project)
        .setZone(zone)
        .setCluster(cluster)
        .build()
        .toString();
  }

  public static SettingsName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_SETTINGS_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_SETTINGS_PATH_TEMPLATE.match(formattedString);
      return ofOrganizationSettingsName(matchMap.get("organization"));
    } else if (FOLDER_SETTINGS_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_SETTINGS_PATH_TEMPLATE.match(formattedString);
      return ofFolderSettingsName(matchMap.get("folder"));
    } else if (PROJECT_SETTINGS_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_SETTINGS_PATH_TEMPLATE.match(formattedString);
      return ofProjectSettingsName(matchMap.get("project"));
    } else if (PROJECT_LOCATION_CLUSTER_SETTINGS_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_CLUSTER_SETTINGS_PATH_TEMPLATE.match(formattedString);
      return ofProjectLocationClusterSettingsName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("cluster"));
    } else if (PROJECT_REGION_CLUSTER_SETTINGS_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_REGION_CLUSTER_SETTINGS_PATH_TEMPLATE.match(formattedString);
      return ofProjectRegionClusterSettingsName(
          matchMap.get("project"), matchMap.get("region"), matchMap.get("cluster"));
    } else if (PROJECT_ZONE_CLUSTER_SETTINGS_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_ZONE_CLUSTER_SETTINGS_PATH_TEMPLATE.match(formattedString);
      return ofProjectZoneClusterSettingsName(
          matchMap.get("project"), matchMap.get("zone"), matchMap.get("cluster"));
    }
    throw new ValidationException("JobName.parse: formattedString not in valid format");
  }

  public static List<SettingsName> parseList(List<String> formattedStrings) {
    List<SettingsName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SettingsName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SettingsName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_SETTINGS_PATH_TEMPLATE.matches(formattedString)
        || FOLDER_SETTINGS_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_SETTINGS_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_LOCATION_CLUSTER_SETTINGS_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_REGION_CLUSTER_SETTINGS_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_ZONE_CLUSTER_SETTINGS_PATH_TEMPLATE.matches(formattedString);
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

  /** Builder for organizations/{organization}/settings. */
  public static class Builder {

    private String organization;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    private Builder(SettingsName settingsName) {
      Preconditions.checkArgument(
          settingsName.pathTemplate == ORGANIZATION_SETTINGS_PATH_TEMPLATE,
          "toBuilder is only supported when SettingsName has the pattern of "
              + "organizations/{organization}/settings.");
      organization = settingsName.organization;
    }

    public SettingsName build() {
      return new SettingsName(this);
    }
  }

  /** Builder for folders/{folder}/settings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderSettingsBuilder {

    private String folder;

    private FolderSettingsBuilder() {}

    public String getFolder() {
      return folder;
    }

    public FolderSettingsBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public SettingsName build() {
      return new SettingsName(this);
    }
  }

  /** Builder for projects/{project}/settings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectSettingsBuilder {

    private String project;

    private ProjectSettingsBuilder() {}

    public String getProject() {
      return project;
    }

    public ProjectSettingsBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public SettingsName build() {
      return new SettingsName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/clusters/{cluster}/settings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationClusterSettingsBuilder {

    private String project;
    private String location;
    private String cluster;

    private ProjectLocationClusterSettingsBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCluster() {
      return cluster;
    }

    public ProjectLocationClusterSettingsBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationClusterSettingsBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationClusterSettingsBuilder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public SettingsName build() {
      return new SettingsName(this);
    }
  }

  /** Builder for projects/{project}/regions/{region}/clusters/{cluster}/settings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectRegionClusterSettingsBuilder {

    private String project;
    private String region;
    private String cluster;

    private ProjectRegionClusterSettingsBuilder() {}

    public String getProject() {
      return project;
    }

    public String getRegion() {
      return region;
    }

    public String getCluster() {
      return cluster;
    }

    public ProjectRegionClusterSettingsBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectRegionClusterSettingsBuilder setRegion(String region) {
      this.region = region;
      return this;
    }

    public ProjectRegionClusterSettingsBuilder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public SettingsName build() {
      return new SettingsName(this);
    }
  }

  /** Builder for projects/{project}/zones/{zone}/clusters/{cluster}/settings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectZoneClusterSettingsBuilder {

    private String project;
    private String zone;
    private String cluster;

    private ProjectZoneClusterSettingsBuilder() {}

    public String getProject() {
      return project;
    }

    public String getZone() {
      return zone;
    }

    public String getCluster() {
      return cluster;
    }

    public ProjectZoneClusterSettingsBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectZoneClusterSettingsBuilder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public ProjectZoneClusterSettingsBuilder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public SettingsName build() {
      return new SettingsName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      SettingsName that = (SettingsName) o;
      return (Objects.equals(this.organization, that.organization))
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
