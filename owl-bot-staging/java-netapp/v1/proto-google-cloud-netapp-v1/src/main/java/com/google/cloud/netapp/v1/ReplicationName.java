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

package com.google.cloud.netapp.v1;

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
public class ReplicationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_VOLUME_REPLICATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/volumes/{volume}/replications/{replication}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String volume;
  private final String replication;

  @Deprecated
  protected ReplicationName() {
    project = null;
    location = null;
    volume = null;
    replication = null;
  }

  private ReplicationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    volume = Preconditions.checkNotNull(builder.getVolume());
    replication = Preconditions.checkNotNull(builder.getReplication());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getVolume() {
    return volume;
  }

  public String getReplication() {
    return replication;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ReplicationName of(
      String project, String location, String volume, String replication) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setVolume(volume)
        .setReplication(replication)
        .build();
  }

  public static String format(String project, String location, String volume, String replication) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setVolume(volume)
        .setReplication(replication)
        .build()
        .toString();
  }

  public static ReplicationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_VOLUME_REPLICATION.validatedMatch(
            formattedString, "ReplicationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("volume"),
        matchMap.get("replication"));
  }

  public static List<ReplicationName> parseList(List<String> formattedStrings) {
    List<ReplicationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ReplicationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ReplicationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_VOLUME_REPLICATION.matches(formattedString);
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
          if (volume != null) {
            fieldMapBuilder.put("volume", volume);
          }
          if (replication != null) {
            fieldMapBuilder.put("replication", replication);
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
    return PROJECT_LOCATION_VOLUME_REPLICATION.instantiate(
        "project", project, "location", location, "volume", volume, "replication", replication);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ReplicationName that = ((ReplicationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.volume, that.volume)
          && Objects.equals(this.replication, that.replication);
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
    h ^= Objects.hashCode(volume);
    h *= 1000003;
    h ^= Objects.hashCode(replication);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/volumes/{volume}/replications/{replication}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String volume;
    private String replication;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getVolume() {
      return volume;
    }

    public String getReplication() {
      return replication;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setVolume(String volume) {
      this.volume = volume;
      return this;
    }

    public Builder setReplication(String replication) {
      this.replication = replication;
      return this;
    }

    private Builder(ReplicationName replicationName) {
      this.project = replicationName.project;
      this.location = replicationName.location;
      this.volume = replicationName.volume;
      this.replication = replicationName.replication;
    }

    public ReplicationName build() {
      return new ReplicationName(this);
    }
  }
}
