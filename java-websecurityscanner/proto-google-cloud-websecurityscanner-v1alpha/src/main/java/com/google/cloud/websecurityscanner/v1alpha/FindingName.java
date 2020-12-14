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
public class FindingName implements ResourceName {
  private static final PathTemplate PROJECT_SCAN_CONFIG_SCAN_RUN_FINDING =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/scanConfigs/{scan_config}/scanRuns/{scan_run}/findings/{finding}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String scanConfig;
  private final String scanRun;
  private final String finding;

  @Deprecated
  protected FindingName() {
    project = null;
    scanConfig = null;
    scanRun = null;
    finding = null;
  }

  private FindingName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    scanConfig = Preconditions.checkNotNull(builder.getScanConfig());
    scanRun = Preconditions.checkNotNull(builder.getScanRun());
    finding = Preconditions.checkNotNull(builder.getFinding());
  }

  public String getProject() {
    return project;
  }

  public String getScanConfig() {
    return scanConfig;
  }

  public String getScanRun() {
    return scanRun;
  }

  public String getFinding() {
    return finding;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FindingName of(String project, String scanConfig, String scanRun, String finding) {
    return newBuilder()
        .setProject(project)
        .setScanConfig(scanConfig)
        .setScanRun(scanRun)
        .setFinding(finding)
        .build();
  }

  public static String format(String project, String scanConfig, String scanRun, String finding) {
    return newBuilder()
        .setProject(project)
        .setScanConfig(scanConfig)
        .setScanRun(scanRun)
        .setFinding(finding)
        .build()
        .toString();
  }

  public static FindingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_SCAN_CONFIG_SCAN_RUN_FINDING.validatedMatch(
            formattedString, "FindingName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("scan_config"),
        matchMap.get("scan_run"),
        matchMap.get("finding"));
  }

  public static List<FindingName> parseList(List<String> formattedStrings) {
    List<FindingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FindingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FindingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_SCAN_CONFIG_SCAN_RUN_FINDING.matches(formattedString);
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
          if (scanRun != null) {
            fieldMapBuilder.put("scan_run", scanRun);
          }
          if (finding != null) {
            fieldMapBuilder.put("finding", finding);
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
    return PROJECT_SCAN_CONFIG_SCAN_RUN_FINDING.instantiate(
        "project", project, "scan_config", scanConfig, "scan_run", scanRun, "finding", finding);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      FindingName that = ((FindingName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.scanConfig, that.scanConfig)
          && Objects.equals(this.scanRun, that.scanRun)
          && Objects.equals(this.finding, that.finding);
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
    h *= 1000003;
    h ^= Objects.hashCode(scanRun);
    h *= 1000003;
    h ^= Objects.hashCode(finding);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/scanConfigs/{scan_config}/scanRuns/{scan_run}/findings/{finding}.
   */
  public static class Builder {
    private String project;
    private String scanConfig;
    private String scanRun;
    private String finding;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getScanConfig() {
      return scanConfig;
    }

    public String getScanRun() {
      return scanRun;
    }

    public String getFinding() {
      return finding;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setScanConfig(String scanConfig) {
      this.scanConfig = scanConfig;
      return this;
    }

    public Builder setScanRun(String scanRun) {
      this.scanRun = scanRun;
      return this;
    }

    public Builder setFinding(String finding) {
      this.finding = finding;
      return this;
    }

    private Builder(FindingName findingName) {
      project = findingName.project;
      scanConfig = findingName.scanConfig;
      scanRun = findingName.scanRun;
      finding = findingName.finding;
    }

    public FindingName build() {
      return new FindingName(this);
    }
  }
}
