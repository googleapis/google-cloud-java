/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networksecurity.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class SACRealmName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SAC_REALM =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/sacRealms/{sac_realm}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String sacRealm;

  @Deprecated
  protected SACRealmName() {
    project = null;
    location = null;
    sacRealm = null;
  }

  private SACRealmName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    sacRealm = Preconditions.checkNotNull(builder.getSacRealm());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSacRealm() {
    return sacRealm;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SACRealmName of(String project, String location, String sacRealm) {
    return newBuilder().setProject(project).setLocation(location).setSacRealm(sacRealm).build();
  }

  public static String format(String project, String location, String sacRealm) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSacRealm(sacRealm)
        .build()
        .toString();
  }

  public static SACRealmName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SAC_REALM.validatedMatch(
            formattedString, "SACRealmName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("sac_realm"));
  }

  public static List<SACRealmName> parseList(List<String> formattedStrings) {
    List<SACRealmName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SACRealmName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SACRealmName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SAC_REALM.matches(formattedString);
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
          if (sacRealm != null) {
            fieldMapBuilder.put("sac_realm", sacRealm);
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
    return PROJECT_LOCATION_SAC_REALM.instantiate(
        "project", project, "location", location, "sac_realm", sacRealm);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SACRealmName that = ((SACRealmName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.sacRealm, that.sacRealm);
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
    h ^= Objects.hashCode(sacRealm);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/sacRealms/{sac_realm}. */
  public static class Builder {
    private String project;
    private String location;
    private String sacRealm;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSacRealm() {
      return sacRealm;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSacRealm(String sacRealm) {
      this.sacRealm = sacRealm;
      return this;
    }

    private Builder(SACRealmName sACRealmName) {
      this.project = sACRealmName.project;
      this.location = sACRealmName.location;
      this.sacRealm = sACRealmName.sacRealm;
    }

    public SACRealmName build() {
      return new SACRealmName(this);
    }
  }
}
