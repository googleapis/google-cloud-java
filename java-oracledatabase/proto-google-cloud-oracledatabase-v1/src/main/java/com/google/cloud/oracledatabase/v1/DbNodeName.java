/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.oracledatabase.v1;

import com.google.api.pathtemplate.PathTemplate;
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
public class DbNodeName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CLOUD_VM_CLUSTER_DB_NODE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/cloudVmClusters/{cloud_vm_cluster}/dbNodes/{db_node}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String cloudVmCluster;
  private final String dbNode;

  @Deprecated
  protected DbNodeName() {
    project = null;
    location = null;
    cloudVmCluster = null;
    dbNode = null;
  }

  private DbNodeName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    cloudVmCluster = Preconditions.checkNotNull(builder.getCloudVmCluster());
    dbNode = Preconditions.checkNotNull(builder.getDbNode());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getCloudVmCluster() {
    return cloudVmCluster;
  }

  public String getDbNode() {
    return dbNode;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DbNodeName of(
      String project, String location, String cloudVmCluster, String dbNode) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCloudVmCluster(cloudVmCluster)
        .setDbNode(dbNode)
        .build();
  }

  public static String format(
      String project, String location, String cloudVmCluster, String dbNode) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCloudVmCluster(cloudVmCluster)
        .setDbNode(dbNode)
        .build()
        .toString();
  }

  public static DbNodeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CLOUD_VM_CLUSTER_DB_NODE.validatedMatch(
            formattedString, "DbNodeName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("cloud_vm_cluster"),
        matchMap.get("db_node"));
  }

  public static List<DbNodeName> parseList(List<String> formattedStrings) {
    List<DbNodeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DbNodeName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DbNodeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CLOUD_VM_CLUSTER_DB_NODE.matches(formattedString);
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
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (cloudVmCluster != null) {
            fieldMapBuilder.put("cloud_vm_cluster", cloudVmCluster);
          }
          if (dbNode != null) {
            fieldMapBuilder.put("db_node", dbNode);
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
    return PROJECT_LOCATION_CLOUD_VM_CLUSTER_DB_NODE.instantiate(
        "project",
        project,
        "location",
        location,
        "cloud_vm_cluster",
        cloudVmCluster,
        "db_node",
        dbNode);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DbNodeName that = ((DbNodeName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.cloudVmCluster, that.cloudVmCluster)
          && Objects.equals(this.dbNode, that.dbNode);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(cloudVmCluster);
    h *= 1000003;
    h ^= Objects.hashCode(dbNode);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/cloudVmClusters/{cloud_vm_cluster}/dbNodes/{db_node}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String cloudVmCluster;
    private String dbNode;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCloudVmCluster() {
      return cloudVmCluster;
    }

    public String getDbNode() {
      return dbNode;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCloudVmCluster(String cloudVmCluster) {
      this.cloudVmCluster = cloudVmCluster;
      return this;
    }

    public Builder setDbNode(String dbNode) {
      this.dbNode = dbNode;
      return this;
    }

    private Builder(DbNodeName dbNodeName) {
      this.project = dbNodeName.project;
      this.location = dbNodeName.location;
      this.cloudVmCluster = dbNodeName.cloudVmCluster;
      this.dbNode = dbNodeName.dbNode;
    }

    public DbNodeName build() {
      return new DbNodeName(this);
    }
  }
}
