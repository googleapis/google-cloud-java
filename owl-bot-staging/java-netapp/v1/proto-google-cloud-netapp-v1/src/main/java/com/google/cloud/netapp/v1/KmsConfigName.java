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
public class KmsConfigName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_KMS_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/kmsConfigs/{kms_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String kmsConfig;

  @Deprecated
  protected KmsConfigName() {
    project = null;
    location = null;
    kmsConfig = null;
  }

  private KmsConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    kmsConfig = Preconditions.checkNotNull(builder.getKmsConfig());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getKmsConfig() {
    return kmsConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static KmsConfigName of(String project, String location, String kmsConfig) {
    return newBuilder().setProject(project).setLocation(location).setKmsConfig(kmsConfig).build();
  }

  public static String format(String project, String location, String kmsConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setKmsConfig(kmsConfig)
        .build()
        .toString();
  }

  public static KmsConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_KMS_CONFIG.validatedMatch(
            formattedString, "KmsConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("kms_config"));
  }

  public static List<KmsConfigName> parseList(List<String> formattedStrings) {
    List<KmsConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<KmsConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (KmsConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_KMS_CONFIG.matches(formattedString);
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
          if (kmsConfig != null) {
            fieldMapBuilder.put("kms_config", kmsConfig);
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
    return PROJECT_LOCATION_KMS_CONFIG.instantiate(
        "project", project, "location", location, "kms_config", kmsConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      KmsConfigName that = ((KmsConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.kmsConfig, that.kmsConfig);
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
    h ^= Objects.hashCode(kmsConfig);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/kmsConfigs/{kms_config}. */
  public static class Builder {
    private String project;
    private String location;
    private String kmsConfig;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getKmsConfig() {
      return kmsConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setKmsConfig(String kmsConfig) {
      this.kmsConfig = kmsConfig;
      return this;
    }

    private Builder(KmsConfigName kmsConfigName) {
      this.project = kmsConfigName.project;
      this.location = kmsConfigName.location;
      this.kmsConfig = kmsConfigName.kmsConfig;
    }

    public KmsConfigName build() {
      return new KmsConfigName(this);
    }
  }
}
