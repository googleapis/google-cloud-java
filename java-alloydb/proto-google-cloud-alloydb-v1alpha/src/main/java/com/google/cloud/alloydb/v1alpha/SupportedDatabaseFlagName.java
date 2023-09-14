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

package com.google.cloud.alloydb.v1alpha;

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
public class SupportedDatabaseFlagName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_FLAG =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}/flags/{flag}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String flag;

  @Deprecated
  protected SupportedDatabaseFlagName() {
    project = null;
    location = null;
    flag = null;
  }

  private SupportedDatabaseFlagName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    flag = Preconditions.checkNotNull(builder.getFlag());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getFlag() {
    return flag;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SupportedDatabaseFlagName of(String project, String location, String flag) {
    return newBuilder().setProject(project).setLocation(location).setFlag(flag).build();
  }

  public static String format(String project, String location, String flag) {
    return newBuilder().setProject(project).setLocation(location).setFlag(flag).build().toString();
  }

  public static SupportedDatabaseFlagName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_FLAG.validatedMatch(
            formattedString,
            "SupportedDatabaseFlagName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("flag"));
  }

  public static List<SupportedDatabaseFlagName> parseList(List<String> formattedStrings) {
    List<SupportedDatabaseFlagName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SupportedDatabaseFlagName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SupportedDatabaseFlagName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_FLAG.matches(formattedString);
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
          if (flag != null) {
            fieldMapBuilder.put("flag", flag);
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
    return PROJECT_LOCATION_FLAG.instantiate(
        "project", project, "location", location, "flag", flag);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SupportedDatabaseFlagName that = ((SupportedDatabaseFlagName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.flag, that.flag);
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
    h ^= Objects.hashCode(flag);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/flags/{flag}. */
  public static class Builder {
    private String project;
    private String location;
    private String flag;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getFlag() {
      return flag;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setFlag(String flag) {
      this.flag = flag;
      return this;
    }

    private Builder(SupportedDatabaseFlagName supportedDatabaseFlagName) {
      this.project = supportedDatabaseFlagName.project;
      this.location = supportedDatabaseFlagName.location;
      this.flag = supportedDatabaseFlagName.flag;
    }

    public SupportedDatabaseFlagName build() {
      return new SupportedDatabaseFlagName(this);
    }
  }
}
