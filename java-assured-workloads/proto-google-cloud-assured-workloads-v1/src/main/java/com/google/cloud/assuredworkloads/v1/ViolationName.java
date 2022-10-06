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

package com.google.cloud.assuredworkloads.v1;

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
public class ViolationName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_WORKLOAD_VIOLATION =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/workloads/{workload}/violations/{violation}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String location;
  private final String workload;
  private final String violation;

  @Deprecated
  protected ViolationName() {
    organization = null;
    location = null;
    workload = null;
    violation = null;
  }

  private ViolationName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    workload = Preconditions.checkNotNull(builder.getWorkload());
    violation = Preconditions.checkNotNull(builder.getViolation());
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getWorkload() {
    return workload;
  }

  public String getViolation() {
    return violation;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ViolationName of(
      String organization, String location, String workload, String violation) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setWorkload(workload)
        .setViolation(violation)
        .build();
  }

  public static String format(
      String organization, String location, String workload, String violation) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setWorkload(workload)
        .setViolation(violation)
        .build()
        .toString();
  }

  public static ViolationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_LOCATION_WORKLOAD_VIOLATION.validatedMatch(
            formattedString, "ViolationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("organization"),
        matchMap.get("location"),
        matchMap.get("workload"),
        matchMap.get("violation"));
  }

  public static List<ViolationName> parseList(List<String> formattedStrings) {
    List<ViolationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ViolationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ViolationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_WORKLOAD_VIOLATION.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (workload != null) {
            fieldMapBuilder.put("workload", workload);
          }
          if (violation != null) {
            fieldMapBuilder.put("violation", violation);
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
    return ORGANIZATION_LOCATION_WORKLOAD_VIOLATION.instantiate(
        "organization",
        organization,
        "location",
        location,
        "workload",
        workload,
        "violation",
        violation);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ViolationName that = ((ViolationName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.workload, that.workload)
          && Objects.equals(this.violation, that.violation);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(workload);
    h *= 1000003;
    h ^= Objects.hashCode(violation);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/workloads/{workload}/violations/{violation}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String workload;
    private String violation;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getWorkload() {
      return workload;
    }

    public String getViolation() {
      return violation;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setWorkload(String workload) {
      this.workload = workload;
      return this;
    }

    public Builder setViolation(String violation) {
      this.violation = violation;
      return this;
    }

    private Builder(ViolationName violationName) {
      this.organization = violationName.organization;
      this.location = violationName.location;
      this.workload = violationName.workload;
      this.violation = violationName.violation;
    }

    public ViolationName build() {
      return new ViolationName(this);
    }
  }
}
