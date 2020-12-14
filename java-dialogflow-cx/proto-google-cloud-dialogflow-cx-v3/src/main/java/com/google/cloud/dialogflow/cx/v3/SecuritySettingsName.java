/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.dialogflow.cx.v3;

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
public class SecuritySettingsName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SECURITY_SETTINGS =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/securitySettings/{security_settings}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String securitySettings;

  @Deprecated
  protected SecuritySettingsName() {
    project = null;
    location = null;
    securitySettings = null;
  }

  private SecuritySettingsName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    securitySettings = Preconditions.checkNotNull(builder.getSecuritySettings());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSecuritySettings() {
    return securitySettings;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SecuritySettingsName of(String project, String location, String securitySettings) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSecuritySettings(securitySettings)
        .build();
  }

  public static String format(String project, String location, String securitySettings) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSecuritySettings(securitySettings)
        .build()
        .toString();
  }

  public static SecuritySettingsName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SECURITY_SETTINGS.validatedMatch(
            formattedString, "SecuritySettingsName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("security_settings"));
  }

  public static List<SecuritySettingsName> parseList(List<String> formattedStrings) {
    List<SecuritySettingsName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SecuritySettingsName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SecuritySettingsName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SECURITY_SETTINGS.matches(formattedString);
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
          if (securitySettings != null) {
            fieldMapBuilder.put("security_settings", securitySettings);
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
    return PROJECT_LOCATION_SECURITY_SETTINGS.instantiate(
        "project", project, "location", location, "security_settings", securitySettings);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      SecuritySettingsName that = ((SecuritySettingsName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.securitySettings, that.securitySettings);
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
    h ^= Objects.hashCode(securitySettings);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/securitySettings/{security_settings}. */
  public static class Builder {
    private String project;
    private String location;
    private String securitySettings;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSecuritySettings() {
      return securitySettings;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSecuritySettings(String securitySettings) {
      this.securitySettings = securitySettings;
      return this;
    }

    private Builder(SecuritySettingsName securitySettingsName) {
      project = securitySettingsName.project;
      location = securitySettingsName.location;
      securitySettings = securitySettingsName.securitySettings;
    }

    public SecuritySettingsName build() {
      return new SecuritySettingsName(this);
    }
  }
}
