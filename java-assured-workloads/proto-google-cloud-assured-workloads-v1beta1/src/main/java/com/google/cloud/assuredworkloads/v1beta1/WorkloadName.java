/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class WorkloadName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/workloads/{workload}");

  private volatile Map<String, String> fieldValuesMap;

  private final String organization;
  private final String location;
  private final String workload;

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

  private WorkloadName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    workload = Preconditions.checkNotNull(builder.getWorkload());
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
        PATH_TEMPLATE.validatedMatch(
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
    List<String> list = new ArrayList<String>(values.size());
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
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("organization", organization);
          fieldMapBuilder.put("location", location);
          fieldMapBuilder.put("workload", workload);
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
    return PATH_TEMPLATE.instantiate(
        "organization", organization, "location", location, "workload", workload);
  }

  /** Builder for WorkloadName. */
  public static class Builder {

    private String organization;
    private String location;
    private String workload;

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

    private Builder() {}

    private Builder(WorkloadName workloadName) {
      organization = workloadName.organization;
      location = workloadName.location;
      workload = workloadName.workload;
    }

    public WorkloadName build() {
      return new WorkloadName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof WorkloadName) {
      WorkloadName that = (WorkloadName) o;
      return (this.organization.equals(that.organization))
          && (this.location.equals(that.location))
          && (this.workload.equals(that.workload));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= organization.hashCode();
    h *= 1000003;
    h ^= location.hashCode();
    h *= 1000003;
    h ^= workload.hashCode();
    return h;
  }
}
