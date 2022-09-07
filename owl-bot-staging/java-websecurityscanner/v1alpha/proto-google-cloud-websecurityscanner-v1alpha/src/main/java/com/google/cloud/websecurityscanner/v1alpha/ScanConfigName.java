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

package com.google.cloud.websecurityscanner.v1alpha;

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
public class ScanConfigName implements ResourceName {
  private static final PathTemplate PROJECT_SCAN_CONFIG =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/scanConfigs/{scan_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String scanConfig;

  @Deprecated
  protected ScanConfigName() {
    project = null;
    scanConfig = null;
  }

  private ScanConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    scanConfig = Preconditions.checkNotNull(builder.getScanConfig());
  }

  public String getProject() {
    return project;
  }

  public String getScanConfig() {
    return scanConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ScanConfigName of(String project, String scanConfig) {
    return newBuilder().setProject(project).setScanConfig(scanConfig).build();
  }

  public static String format(String project, String scanConfig) {
    return newBuilder().setProject(project).setScanConfig(scanConfig).build().toString();
  }

  public static ScanConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_SCAN_CONFIG.validatedMatch(
            formattedString, "ScanConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("scan_config"));
  }

  public static List<ScanConfigName> parseList(List<String> formattedStrings) {
    List<ScanConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ScanConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ScanConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_SCAN_CONFIG.matches(formattedString);
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
          if (scanConfig != null) {
            fieldMapBuilder.put("scan_config", scanConfig);
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
    return PROJECT_SCAN_CONFIG.instantiate("project", project, "scan_config", scanConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ScanConfigName that = ((ScanConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.scanConfig, that.scanConfig);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(scanConfig);
    return h;
  }

  /** Builder for projects/{project}/scanConfigs/{scan_config}. */
  public static class Builder {
    private String project;
    private String scanConfig;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getScanConfig() {
      return scanConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setScanConfig(String scanConfig) {
      this.scanConfig = scanConfig;
      return this;
    }

    private Builder(ScanConfigName scanConfigName) {
      this.project = scanConfigName.project;
      this.scanConfig = scanConfigName.scanConfig;
    }

    public ScanConfigName build() {
      return new ScanConfigName(this);
    }
  }
}
