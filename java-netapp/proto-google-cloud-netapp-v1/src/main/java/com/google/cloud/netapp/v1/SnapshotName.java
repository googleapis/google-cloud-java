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
public class SnapshotName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_VOLUME_SNAPSHOT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/volumes/{volume}/snapshots/{snapshot}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String volume;
  private final String snapshot;

  @Deprecated
  protected SnapshotName() {
    project = null;
    location = null;
    volume = null;
    snapshot = null;
  }

  private SnapshotName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    volume = Preconditions.checkNotNull(builder.getVolume());
    snapshot = Preconditions.checkNotNull(builder.getSnapshot());
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

  public String getSnapshot() {
    return snapshot;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SnapshotName of(String project, String location, String volume, String snapshot) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setVolume(volume)
        .setSnapshot(snapshot)
        .build();
  }

  public static String format(String project, String location, String volume, String snapshot) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setVolume(volume)
        .setSnapshot(snapshot)
        .build()
        .toString();
  }

  public static SnapshotName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_VOLUME_SNAPSHOT.validatedMatch(
            formattedString, "SnapshotName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("volume"),
        matchMap.get("snapshot"));
  }

  public static List<SnapshotName> parseList(List<String> formattedStrings) {
    List<SnapshotName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SnapshotName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SnapshotName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_VOLUME_SNAPSHOT.matches(formattedString);
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
          if (snapshot != null) {
            fieldMapBuilder.put("snapshot", snapshot);
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
    return PROJECT_LOCATION_VOLUME_SNAPSHOT.instantiate(
        "project", project, "location", location, "volume", volume, "snapshot", snapshot);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SnapshotName that = ((SnapshotName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.volume, that.volume)
          && Objects.equals(this.snapshot, that.snapshot);
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
    h ^= Objects.hashCode(snapshot);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/volumes/{volume}/snapshots/{snapshot}. */
  public static class Builder {
    private String project;
    private String location;
    private String volume;
    private String snapshot;

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

    public String getSnapshot() {
      return snapshot;
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

    public Builder setSnapshot(String snapshot) {
      this.snapshot = snapshot;
      return this;
    }

    private Builder(SnapshotName snapshotName) {
      this.project = snapshotName.project;
      this.location = snapshotName.location;
      this.volume = snapshotName.volume;
      this.snapshot = snapshotName.snapshot;
    }

    public SnapshotName build() {
      return new SnapshotName(this);
    }
  }
}
