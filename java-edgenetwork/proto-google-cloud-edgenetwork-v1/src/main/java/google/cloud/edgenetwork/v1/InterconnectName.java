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

package google.cloud.edgenetwork.v1;

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
public class InterconnectName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ZONE_INTERCONNECT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/zones/{zone}/interconnects/{interconnect}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String zone;
  private final String interconnect;

  @Deprecated
  protected InterconnectName() {
    project = null;
    location = null;
    zone = null;
    interconnect = null;
  }

  private InterconnectName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    zone = Preconditions.checkNotNull(builder.getZone());
    interconnect = Preconditions.checkNotNull(builder.getInterconnect());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getZone() {
    return zone;
  }

  public String getInterconnect() {
    return interconnect;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static InterconnectName of(
      String project, String location, String zone, String interconnect) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setZone(zone)
        .setInterconnect(interconnect)
        .build();
  }

  public static String format(String project, String location, String zone, String interconnect) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setZone(zone)
        .setInterconnect(interconnect)
        .build()
        .toString();
  }

  public static InterconnectName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ZONE_INTERCONNECT.validatedMatch(
            formattedString, "InterconnectName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("zone"),
        matchMap.get("interconnect"));
  }

  public static List<InterconnectName> parseList(List<String> formattedStrings) {
    List<InterconnectName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<InterconnectName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (InterconnectName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ZONE_INTERCONNECT.matches(formattedString);
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
          if (zone != null) {
            fieldMapBuilder.put("zone", zone);
          }
          if (interconnect != null) {
            fieldMapBuilder.put("interconnect", interconnect);
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
    return PROJECT_LOCATION_ZONE_INTERCONNECT.instantiate(
        "project", project, "location", location, "zone", zone, "interconnect", interconnect);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      InterconnectName that = ((InterconnectName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.zone, that.zone)
          && Objects.equals(this.interconnect, that.interconnect);
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
    h ^= Objects.hashCode(zone);
    h *= 1000003;
    h ^= Objects.hashCode(interconnect);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/zones/{zone}/interconnects/{interconnect}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String zone;
    private String interconnect;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getZone() {
      return zone;
    }

    public String getInterconnect() {
      return interconnect;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public Builder setInterconnect(String interconnect) {
      this.interconnect = interconnect;
      return this;
    }

    private Builder(InterconnectName interconnectName) {
      this.project = interconnectName.project;
      this.location = interconnectName.location;
      this.zone = interconnectName.zone;
      this.interconnect = interconnectName.interconnect;
    }

    public InterconnectName build() {
      return new InterconnectName(this);
    }
  }
}
