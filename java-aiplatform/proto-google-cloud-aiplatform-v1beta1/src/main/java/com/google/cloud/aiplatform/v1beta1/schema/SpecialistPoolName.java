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

package com.google.cloud.aiplatform.v1beta1.schema;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class SpecialistPoolName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/specialistPools/{specialist_pool}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String specialistPool;

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSpecialistPool() {
    return specialistPool;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private SpecialistPoolName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    specialistPool = Preconditions.checkNotNull(builder.getSpecialistPool());
  }

  public static SpecialistPoolName of(String project, String location, String specialistPool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSpecialistPool(specialistPool)
        .build();
  }

  public static String format(String project, String location, String specialistPool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSpecialistPool(specialistPool)
        .build()
        .toString();
  }

  public static SpecialistPoolName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "SpecialistPoolName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("specialist_pool"));
  }

  public static List<SpecialistPoolName> parseList(List<String> formattedStrings) {
    List<SpecialistPoolName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SpecialistPoolName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (SpecialistPoolName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("location", location);
          fieldMapBuilder.put("specialistPool", specialistPool);
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
    return PATH_TEMPLATE.instantiate(
        "project", project, "location", location, "specialist_pool", specialistPool);
  }

  /** Builder for SpecialistPoolName. */
  public static class Builder {

    private String project;
    private String location;
    private String specialistPool;

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSpecialistPool() {
      return specialistPool;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSpecialistPool(String specialistPool) {
      this.specialistPool = specialistPool;
      return this;
    }

    private Builder() {}

    private Builder(SpecialistPoolName specialistPoolName) {
      project = specialistPoolName.project;
      location = specialistPoolName.location;
      specialistPool = specialistPoolName.specialistPool;
    }

    public SpecialistPoolName build() {
      return new SpecialistPoolName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SpecialistPoolName) {
      SpecialistPoolName that = (SpecialistPoolName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.specialistPool.equals(that.specialistPool));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= location.hashCode();
    h *= 1000003;
    h ^= specialistPool.hashCode();
    return h;
  }
}
