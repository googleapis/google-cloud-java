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

package com.google.cloud.dataplex.v1;

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
public class PartitionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_LAKE_ZONE_ENTITY_PARTITION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/lakes/{lake}/zones/{zone}/entities/{entity}/partitions/{partition}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String lake;
  private final String zone;
  private final String entity;
  private final String partition;

  @Deprecated
  protected PartitionName() {
    project = null;
    location = null;
    lake = null;
    zone = null;
    entity = null;
    partition = null;
  }

  private PartitionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    lake = Preconditions.checkNotNull(builder.getLake());
    zone = Preconditions.checkNotNull(builder.getZone());
    entity = Preconditions.checkNotNull(builder.getEntity());
    partition = Preconditions.checkNotNull(builder.getPartition());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getLake() {
    return lake;
  }

  public String getZone() {
    return zone;
  }

  public String getEntity() {
    return entity;
  }

  public String getPartition() {
    return partition;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PartitionName of(
      String project, String location, String lake, String zone, String entity, String partition) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setLake(lake)
        .setZone(zone)
        .setEntity(entity)
        .setPartition(partition)
        .build();
  }

  public static String format(
      String project, String location, String lake, String zone, String entity, String partition) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setLake(lake)
        .setZone(zone)
        .setEntity(entity)
        .setPartition(partition)
        .build()
        .toString();
  }

  public static PartitionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_LAKE_ZONE_ENTITY_PARTITION.validatedMatch(
            formattedString, "PartitionName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("lake"),
        matchMap.get("zone"),
        matchMap.get("entity"),
        matchMap.get("partition"));
  }

  public static List<PartitionName> parseList(List<String> formattedStrings) {
    List<PartitionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PartitionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PartitionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_LAKE_ZONE_ENTITY_PARTITION.matches(formattedString);
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
          if (lake != null) {
            fieldMapBuilder.put("lake", lake);
          }
          if (zone != null) {
            fieldMapBuilder.put("zone", zone);
          }
          if (entity != null) {
            fieldMapBuilder.put("entity", entity);
          }
          if (partition != null) {
            fieldMapBuilder.put("partition", partition);
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
    return PROJECT_LOCATION_LAKE_ZONE_ENTITY_PARTITION.instantiate(
        "project",
        project,
        "location",
        location,
        "lake",
        lake,
        "zone",
        zone,
        "entity",
        entity,
        "partition",
        partition);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      PartitionName that = ((PartitionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.lake, that.lake)
          && Objects.equals(this.zone, that.zone)
          && Objects.equals(this.entity, that.entity)
          && Objects.equals(this.partition, that.partition);
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
    h ^= Objects.hashCode(lake);
    h *= 1000003;
    h ^= Objects.hashCode(zone);
    h *= 1000003;
    h ^= Objects.hashCode(entity);
    h *= 1000003;
    h ^= Objects.hashCode(partition);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/lakes/{lake}/zones/{zone}/entities/{entity}/partitions/{partition}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String lake;
    private String zone;
    private String entity;
    private String partition;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getLake() {
      return lake;
    }

    public String getZone() {
      return zone;
    }

    public String getEntity() {
      return entity;
    }

    public String getPartition() {
      return partition;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setLake(String lake) {
      this.lake = lake;
      return this;
    }

    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public Builder setEntity(String entity) {
      this.entity = entity;
      return this;
    }

    public Builder setPartition(String partition) {
      this.partition = partition;
      return this;
    }

    private Builder(PartitionName partitionName) {
      this.project = partitionName.project;
      this.location = partitionName.location;
      this.lake = partitionName.lake;
      this.zone = partitionName.zone;
      this.entity = partitionName.entity;
      this.partition = partitionName.partition;
    }

    public PartitionName build() {
      return new PartitionName(this);
    }
  }
}
