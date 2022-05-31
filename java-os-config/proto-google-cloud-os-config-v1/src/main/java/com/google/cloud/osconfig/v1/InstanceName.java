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

package com.google.cloud.osconfig.v1;

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
public class InstanceName implements ResourceName {
  private static final PathTemplate PROJECT_ZONE_INSTANCE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/zones/{zone}/instances/{instance}");
  private static final PathTemplate PROJECT_LOCATION_INSTANCE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/instances/{instance}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String zone;
  private final String instance;
  private final String location;

  @Deprecated
  protected InstanceName() {
    project = null;
    zone = null;
    instance = null;
    location = null;
  }

  private InstanceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    zone = Preconditions.checkNotNull(builder.getZone());
    instance = Preconditions.checkNotNull(builder.getInstance());
    location = null;
    pathTemplate = PROJECT_ZONE_INSTANCE;
  }

  private InstanceName(ProjectLocationInstanceBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    instance = Preconditions.checkNotNull(builder.getInstance());
    zone = null;
    pathTemplate = PROJECT_LOCATION_INSTANCE;
  }

  public String getProject() {
    return project;
  }

  public String getZone() {
    return zone;
  }

  public String getInstance() {
    return instance;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectZoneInstanceBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationInstanceBuilder newProjectLocationInstanceBuilder() {
    return new ProjectLocationInstanceBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static InstanceName of(String project, String zone, String instance) {
    return newBuilder().setProject(project).setZone(zone).setInstance(instance).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static InstanceName ofProjectZoneInstanceName(
      String project, String zone, String instance) {
    return newBuilder().setProject(project).setZone(zone).setInstance(instance).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static InstanceName ofProjectLocationInstanceName(
      String project, String location, String instance) {
    return newProjectLocationInstanceBuilder()
        .setProject(project)
        .setLocation(location)
        .setInstance(instance)
        .build();
  }

  public static String format(String project, String zone, String instance) {
    return newBuilder().setProject(project).setZone(zone).setInstance(instance).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectZoneInstanceName(String project, String zone, String instance) {
    return newBuilder().setProject(project).setZone(zone).setInstance(instance).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationInstanceName(
      String project, String location, String instance) {
    return newProjectLocationInstanceBuilder()
        .setProject(project)
        .setLocation(location)
        .setInstance(instance)
        .build()
        .toString();
  }

  public static InstanceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_ZONE_INSTANCE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_ZONE_INSTANCE.match(formattedString);
      return ofProjectZoneInstanceName(
          matchMap.get("project"), matchMap.get("zone"), matchMap.get("instance"));
    } else if (PROJECT_LOCATION_INSTANCE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_INSTANCE.match(formattedString);
      return ofProjectLocationInstanceName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("instance"));
    }
    throw new ValidationException("InstanceName.parse: formattedString not in valid format");
  }

  public static List<InstanceName> parseList(List<String> formattedStrings) {
    List<InstanceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<InstanceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (InstanceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_ZONE_INSTANCE.matches(formattedString)
        || PROJECT_LOCATION_INSTANCE.matches(formattedString);
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
          if (zone != null) {
            fieldMapBuilder.put("zone", zone);
          }
          if (instance != null) {
            fieldMapBuilder.put("instance", instance);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
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
      InstanceName that = ((InstanceName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.zone, that.zone)
          && Objects.equals(this.instance, that.instance)
          && Objects.equals(this.location, that.location);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(zone);
    h *= 1000003;
    h ^= Objects.hashCode(instance);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/zones/{zone}/instances/{instance}. */
  public static class Builder {
    private String project;
    private String zone;
    private String instance;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getZone() {
      return zone;
    }

    public String getInstance() {
      return instance;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    private Builder(InstanceName instanceName) {
      Preconditions.checkArgument(
          Objects.equals(instanceName.pathTemplate, PROJECT_ZONE_INSTANCE),
          "toBuilder is only supported when InstanceName has the pattern of projects/{project}/zones/{zone}/instances/{instance}");
      this.project = instanceName.project;
      this.zone = instanceName.zone;
      this.instance = instanceName.instance;
    }

    public InstanceName build() {
      return new InstanceName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/instances/{instance}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationInstanceBuilder {
    private String project;
    private String location;
    private String instance;

    protected ProjectLocationInstanceBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getInstance() {
      return instance;
    }

    public ProjectLocationInstanceBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationInstanceBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationInstanceBuilder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    public InstanceName build() {
      return new InstanceName(this);
    }
  }
}
