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

package com.google.cloud.assuredworkloads.v1beta1;

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
public class WorkloadName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_WORKLOAD =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/workloads/{workload}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String location;
  private final String workload;

  @Deprecated
  protected WorkloadName() {
    organization = null;
    location = null;
    workload = null;
  }

  private WorkloadName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    workload = Preconditions.checkNotNull(builder.getWorkload());
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

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static WorkloadName of(String organization, String location, String workload) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setWorkload(workload)
        .build();
  }

  public static String format(String organization, String location, String workload) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setWorkload(workload)
        .build()
        .toString();
  }

  public static WorkloadName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_LOCATION_WORKLOAD.validatedMatch(
            formattedString, "WorkloadName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("location"), matchMap.get("workload"));
  }

  public static List<WorkloadName> parseList(List<String> formattedStrings) {
    List<WorkloadName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<WorkloadName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (WorkloadName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_WORKLOAD.matches(formattedString);
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
    return ORGANIZATION_LOCATION_WORKLOAD.instantiate(
        "organization", organization, "location", location, "workload", workload);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      WorkloadName that = ((WorkloadName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.workload, that.workload);
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
    return h;
  }

  /** Builder for organizations/{organization}/locations/{location}/workloads/{workload}. */
  public static class Builder {
    private String organization;
    private String location;
    private String workload;

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

    private Builder(WorkloadName workloadName) {
      organization = workloadName.organization;
      location = workloadName.location;
      workload = workloadName.workload;
    }

    public WorkloadName build() {
      return new WorkloadName(this);
    }
  }
}
