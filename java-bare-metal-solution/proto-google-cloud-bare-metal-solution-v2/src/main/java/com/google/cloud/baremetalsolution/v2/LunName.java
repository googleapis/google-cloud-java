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

package com.google.cloud.baremetalsolution.v2;

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
public class LunName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_VOLUME_LUN =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/volumes/{volume}/luns/{lun}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String volume;
  private final String lun;

  @Deprecated
  protected LunName() {
    project = null;
    location = null;
    volume = null;
    lun = null;
  }

  private LunName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    volume = Preconditions.checkNotNull(builder.getVolume());
    lun = Preconditions.checkNotNull(builder.getLun());
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

  public String getLun() {
    return lun;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LunName of(String project, String location, String volume, String lun) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setVolume(volume)
        .setLun(lun)
        .build();
  }

  public static String format(String project, String location, String volume, String lun) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setVolume(volume)
        .setLun(lun)
        .build()
        .toString();
  }

  public static LunName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_VOLUME_LUN.validatedMatch(
            formattedString, "LunName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("volume"),
        matchMap.get("lun"));
  }

  public static List<LunName> parseList(List<String> formattedStrings) {
    List<LunName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LunName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LunName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_VOLUME_LUN.matches(formattedString);
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
          if (lun != null) {
            fieldMapBuilder.put("lun", lun);
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
    return PROJECT_LOCATION_VOLUME_LUN.instantiate(
        "project", project, "location", location, "volume", volume, "lun", lun);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      LunName that = ((LunName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.volume, that.volume)
          && Objects.equals(this.lun, that.lun);
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
    h ^= Objects.hashCode(lun);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/volumes/{volume}/luns/{lun}. */
  public static class Builder {
    private String project;
    private String location;
    private String volume;
    private String lun;

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

    public String getLun() {
      return lun;
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

    public Builder setLun(String lun) {
      this.lun = lun;
      return this;
    }

    private Builder(LunName lunName) {
      this.project = lunName.project;
      this.location = lunName.location;
      this.volume = lunName.volume;
      this.lun = lunName.lun;
    }

    public LunName build() {
      return new LunName(this);
    }
  }
}
