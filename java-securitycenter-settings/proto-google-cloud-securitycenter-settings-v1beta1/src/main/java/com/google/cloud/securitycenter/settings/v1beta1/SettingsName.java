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
public class SettingsName implements ResourceName {
  private static final PathTemplate ORGANIZATION =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/settings");
  private static final PathTemplate FOLDER =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/settings");
  private static final PathTemplate PROJECT =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/settings");
  private static final PathTemplate PROJECT_LOCATION_CLUSTER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/clusters/{cluster}/settings");
  private static final PathTemplate PROJECT_REGION_CLUSTER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/regions/{region}/clusters/{cluster}/settings");
  private static final PathTemplate PROJECT_ZONE_CLUSTER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/zones/{zone}/clusters/{cluster}/settings");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String folder;
  private final String project;
  private final String location;
  private final String cluster;
  private final String region;
  private final String zone;

  @Deprecated
  protected SettingsName() {
    organization = null;
    folder = null;
    project = null;
    location = null;
    cluster = null;
    region = null;
    zone = null;
  }

  private SettingsName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    folder = null;
    project = null;
    location = null;
    cluster = null;
    region = null;
    zone = null;
    pathTemplate = ORGANIZATION;
  }

  private SettingsName(FolderBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    organization = null;
    project = null;
    location = null;
    cluster = null;
    region = null;
    zone = null;
    pathTemplate = FOLDER;
  }

  private SettingsName(ProjectBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    organization = null;
    folder = null;
    location = null;
    cluster = null;
    region = null;
    zone = null;
    pathTemplate = PROJECT;
  }

  private SettingsName(ProjectLocationClusterBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    organization = null;
    folder = null;
    region = null;
    zone = null;
    pathTemplate = PROJECT_LOCATION_CLUSTER;
  }

  private SettingsName(ProjectRegionClusterBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    organization = null;
    folder = null;
    location = null;
    zone = null;
    pathTemplate = PROJECT_REGION_CLUSTER;
  }

  private SettingsName(ProjectZoneClusterBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    zone = Preconditions.checkNotNull(builder.getZone());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    organization = null;
    folder = null;
    location = null;
    region = null;
    pathTemplate = PROJECT_ZONE_CLUSTER;
  }

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

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newOrganizationBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderBuilder newFolderBuilder() {
    return new FolderBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectBuilder newProjectBuilder() {
    return new ProjectBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationClusterBuilder newProjectLocationClusterBuilder() {
    return new ProjectLocationClusterBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectRegionClusterBuilder newProjectRegionClusterBuilder() {
    return new ProjectRegionClusterBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectZoneClusterBuilder newProjectZoneClusterBuilder() {
    return new ProjectZoneClusterBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SettingsName of(String organization) {
    return newBuilder().setOrganization(organization).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SettingsName ofOrganizationName(String organization) {
    return newBuilder().setOrganization(organization).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SettingsName ofFolderName(String folder) {
    return newFolderBuilder().setFolder(folder).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SettingsName ofProjectName(String project) {
    return newProjectBuilder().setProject(project).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SettingsName ofProjectLocationClusterName(
      String project, String location, String cluster) {
    return newProjectLocationClusterBuilder()
        .setProject(project)
        .setLocation(location)
        .setCluster(cluster)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SettingsName ofProjectRegionClusterName(
      String project, String region, String cluster) {
    return newProjectRegionClusterBuilder()
        .setProject(project)
        .setRegion(region)
        .setCluster(cluster)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SettingsName ofProjectZoneClusterName(String project, String zone, String cluster) {
    return newProjectZoneClusterBuilder()
        .setProject(project)
        .setZone(zone)
        .setCluster(cluster)
        .build();
  }

  public static String format(String organization) {
    return newBuilder().setOrganization(organization).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationName(String organization) {
    return newBuilder().setOrganization(organization).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderName(String folder) {
    return newFolderBuilder().setFolder(folder).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectName(String project) {
    return newProjectBuilder().setProject(project).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationClusterName(
      String project, String location, String cluster) {
    return newProjectLocationClusterBuilder()
        .setProject(project)
        .setLocation(location)
        .setCluster(cluster)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectRegionClusterName(
      String project, String region, String cluster) {
    return newProjectRegionClusterBuilder()
        .setProject(project)
        .setRegion(region)
        .setCluster(cluster)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectZoneClusterName(String project, String zone, String cluster) {
    return newProjectZoneClusterBuilder()
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
    if (ORGANIZATION.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION.match(formattedString);
      return ofOrganizationName(matchMap.get("organization"));
    } else if (FOLDER.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER.match(formattedString);
      return ofFolderName(matchMap.get("folder"));
    } else if (PROJECT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT.match(formattedString);
      return ofProjectName(matchMap.get("project"));
    } else if (PROJECT_LOCATION_CLUSTER.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_CLUSTER.match(formattedString);
      return ofProjectLocationClusterName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("cluster"));
    } else if (PROJECT_REGION_CLUSTER.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_REGION_CLUSTER.match(formattedString);
      return ofProjectRegionClusterName(
          matchMap.get("project"), matchMap.get("region"), matchMap.get("cluster"));
    } else if (PROJECT_ZONE_CLUSTER.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_ZONE_CLUSTER.match(formattedString);
      return ofProjectZoneClusterName(
          matchMap.get("project"), matchMap.get("zone"), matchMap.get("cluster"));
    }
    throw new ValidationException("SettingsName.parse: formattedString not in valid format");
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
    return ORGANIZATION.matches(formattedString)
        || FOLDER.matches(formattedString)
        || PROJECT.matches(formattedString)
        || PROJECT_LOCATION_CLUSTER.matches(formattedString)
        || PROJECT_REGION_CLUSTER.matches(formattedString)
        || PROJECT_ZONE_CLUSTER.matches(formattedString);
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

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      SettingsName that = ((SettingsName) o);
      return Objects.equals(this.organization, that.organization)
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
          Objects.equals(settingsName.pathTemplate, ORGANIZATION),
          "toBuilder is only supported when SettingsName has the pattern of organizations/{organization}/settings");
      organization = settingsName.organization;
    }

    public SettingsName build() {
      return new SettingsName(this);
    }
  }

  /** Builder for folders/{folder}/settings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderBuilder {
    private String folder;

    protected FolderBuilder() {}

    public String getFolder() {
      return folder;
    }

    public FolderBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public SettingsName build() {
      return new SettingsName(this);
    }
  }

  /** Builder for projects/{project}/settings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectBuilder {
    private String project;

    protected ProjectBuilder() {}

    public String getProject() {
      return project;
    }

    public ProjectBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public SettingsName build() {
      return new SettingsName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/clusters/{cluster}/settings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationClusterBuilder {
    private String project;
    private String location;
    private String cluster;

    protected ProjectLocationClusterBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCluster() {
      return cluster;
    }

    public ProjectLocationClusterBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationClusterBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationClusterBuilder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public SettingsName build() {
      return new SettingsName(this);
    }
  }

  /** Builder for projects/{project}/regions/{region}/clusters/{cluster}/settings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectRegionClusterBuilder {
    private String project;
    private String region;
    private String cluster;

    protected ProjectRegionClusterBuilder() {}

    public String getProject() {
      return project;
    }

    public String getRegion() {
      return region;
    }

    public String getCluster() {
      return cluster;
    }

    public ProjectRegionClusterBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectRegionClusterBuilder setRegion(String region) {
      this.region = region;
      return this;
    }

    public ProjectRegionClusterBuilder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public SettingsName build() {
      return new SettingsName(this);
    }
  }

  /** Builder for projects/{project}/zones/{zone}/clusters/{cluster}/settings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectZoneClusterBuilder {
    private String project;
    private String zone;
    private String cluster;

    protected ProjectZoneClusterBuilder() {}

    public String getProject() {
      return project;
    }

    public String getZone() {
      return zone;
    }

    public String getCluster() {
      return cluster;
    }

    public ProjectZoneClusterBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectZoneClusterBuilder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public ProjectZoneClusterBuilder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public SettingsName build() {
      return new SettingsName(this);
    }
  }
}
