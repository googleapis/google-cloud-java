/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.networksecurity.v1beta1;

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
public class DnsThreatDetectorName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DNS_THREAT_DETECTOR =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dnsThreatDetectors/{dns_threat_detector}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String dnsThreatDetector;

  @Deprecated
  protected DnsThreatDetectorName() {
    project = null;
    location = null;
    dnsThreatDetector = null;
  }

  private DnsThreatDetectorName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dnsThreatDetector = Preconditions.checkNotNull(builder.getDnsThreatDetector());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDnsThreatDetector() {
    return dnsThreatDetector;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DnsThreatDetectorName of(
      String project, String location, String dnsThreatDetector) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDnsThreatDetector(dnsThreatDetector)
        .build();
  }

  public static String format(String project, String location, String dnsThreatDetector) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDnsThreatDetector(dnsThreatDetector)
        .build()
        .toString();
  }

  public static DnsThreatDetectorName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DNS_THREAT_DETECTOR.validatedMatch(
            formattedString, "DnsThreatDetectorName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"), matchMap.get("location"), matchMap.get("dns_threat_detector"));
  }

  public static List<DnsThreatDetectorName> parseList(List<String> formattedStrings) {
    List<DnsThreatDetectorName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DnsThreatDetectorName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DnsThreatDetectorName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DNS_THREAT_DETECTOR.matches(formattedString);
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
          if (dnsThreatDetector != null) {
            fieldMapBuilder.put("dns_threat_detector", dnsThreatDetector);
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
    return PROJECT_LOCATION_DNS_THREAT_DETECTOR.instantiate(
        "project", project, "location", location, "dns_threat_detector", dnsThreatDetector);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DnsThreatDetectorName that = ((DnsThreatDetectorName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dnsThreatDetector, that.dnsThreatDetector);
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
    h ^= Objects.hashCode(dnsThreatDetector);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/dnsThreatDetectors/{dns_threat_detector}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dnsThreatDetector;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDnsThreatDetector() {
      return dnsThreatDetector;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDnsThreatDetector(String dnsThreatDetector) {
      this.dnsThreatDetector = dnsThreatDetector;
      return this;
    }

    private Builder(DnsThreatDetectorName dnsThreatDetectorName) {
      this.project = dnsThreatDetectorName.project;
      this.location = dnsThreatDetectorName.location;
      this.dnsThreatDetector = dnsThreatDetectorName.dnsThreatDetector;
    }

    public DnsThreatDetectorName build() {
      return new DnsThreatDetectorName(this);
    }
  }
}
