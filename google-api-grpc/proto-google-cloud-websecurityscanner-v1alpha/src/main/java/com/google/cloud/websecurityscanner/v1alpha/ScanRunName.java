/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.websecurityscanner.v1alpha;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.api.resourcenames.ResourceNameType;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ScanRunName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/scanConfigs/{scan_config}/scanRuns/{scan_run}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String scanConfig;
  private final String scanRun;

  public String getProject() {
    return project;
  }

  public String getScanConfig() {
    return scanConfig;
  }

  public String getScanRun() {
    return scanRun;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ScanRunName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    scanConfig = Preconditions.checkNotNull(builder.getScanConfig());
    scanRun = Preconditions.checkNotNull(builder.getScanRun());
  }

  public static ScanRunName of(String project, String scanConfig, String scanRun) {
    return newBuilder()
      .setProject(project)
      .setScanConfig(scanConfig)
      .setScanRun(scanRun)
      .build();
  }

  public static String format(String project, String scanConfig, String scanRun) {
    return newBuilder()
      .setProject(project)
      .setScanConfig(scanConfig)
      .setScanRun(scanRun)
      .build()
      .toString();
  }

  public static ScanRunName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "ScanRunName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("scan_config"), matchMap.get("scan_run"));
  }

  public static List<ScanRunName> parseList(List<String> formattedStrings) {
    List<ScanRunName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ScanRunName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ScanRunName value : values) {
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
          fieldMapBuilder.put("scanConfig", scanConfig);
          fieldMapBuilder.put("scanRun", scanRun);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  /**
   * @deprecated This method is only present to satisfy the ResourceName interface.
   */
  @Deprecated
  public ResourceNameType getType() {
    throw new UnsupportedOperationException("ScanRunName.getType() not supported");
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate("project", project, "scan_config", scanConfig, "scan_run", scanRun);
  }

  /** Builder for ScanRunName. */
  public static class Builder {

    private String project;
    private String scanConfig;
    private String scanRun;

    public String getProject() {
      return project;
    }

    public String getScanConfig() {
      return scanConfig;
    }

    public String getScanRun() {
      return scanRun;
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

    private Builder() {
    }

    private Builder(ScanRunName scanRunName) {
      project = scanRunName.project;
      scanConfig = scanRunName.scanConfig;
      scanRun = scanRunName.scanRun;
    }

    public ScanRunName build() {
      return new ScanRunName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ScanRunName) {
      ScanRunName that = (ScanRunName) o;
      return (this.project.equals(that.project))
          && (this.scanConfig.equals(that.scanConfig))
          && (this.scanRun.equals(that.scanRun));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= scanConfig.hashCode();
    h *= 1000003;
    h ^= scanRun.hashCode();
    return h;
  }
}

