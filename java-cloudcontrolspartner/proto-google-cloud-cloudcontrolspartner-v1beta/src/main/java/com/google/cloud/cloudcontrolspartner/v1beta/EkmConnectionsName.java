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

package com.google.cloud.cloudcontrolspartner.v1beta;

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
public class EkmConnectionsName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_CUSTOMER_WORKLOAD =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}/ekmConnections");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String location;
  private final String customer;
  private final String workload;

  @Deprecated
  protected EkmConnectionsName() {
    organization = null;
    location = null;
    customer = null;
    workload = null;
  }

  private EkmConnectionsName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    customer = Preconditions.checkNotNull(builder.getCustomer());
    workload = Preconditions.checkNotNull(builder.getWorkload());
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getCustomer() {
    return customer;
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

  public static EkmConnectionsName of(
      String organization, String location, String customer, String workload) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setCustomer(customer)
        .setWorkload(workload)
        .build();
  }

  public static String format(
      String organization, String location, String customer, String workload) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setCustomer(customer)
        .setWorkload(workload)
        .build()
        .toString();
  }

  public static EkmConnectionsName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_LOCATION_CUSTOMER_WORKLOAD.validatedMatch(
            formattedString, "EkmConnectionsName.parse: formattedString not in valid format");
    return of(
        matchMap.get("organization"),
        matchMap.get("location"),
        matchMap.get("customer"),
        matchMap.get("workload"));
  }

  public static List<EkmConnectionsName> parseList(List<String> formattedStrings) {
    List<EkmConnectionsName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EkmConnectionsName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EkmConnectionsName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_CUSTOMER_WORKLOAD.matches(formattedString);
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
          if (customer != null) {
            fieldMapBuilder.put("customer", customer);
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
    return ORGANIZATION_LOCATION_CUSTOMER_WORKLOAD.instantiate(
        "organization",
        organization,
        "location",
        location,
        "customer",
        customer,
        "workload",
        workload);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      EkmConnectionsName that = ((EkmConnectionsName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.customer, that.customer)
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
    h ^= Objects.hashCode(customer);
    h *= 1000003;
    h ^= Objects.hashCode(workload);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}/ekmConnections.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String customer;
    private String workload;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getCustomer() {
      return customer;
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

    public Builder setCustomer(String customer) {
      this.customer = customer;
      return this;
    }

    public Builder setWorkload(String workload) {
      this.workload = workload;
      return this;
    }

    private Builder(EkmConnectionsName ekmConnectionsName) {
      this.organization = ekmConnectionsName.organization;
      this.location = ekmConnectionsName.location;
      this.customer = ekmConnectionsName.customer;
      this.workload = ekmConnectionsName.workload;
    }

    public EkmConnectionsName build() {
      return new EkmConnectionsName(this);
    }
  }
}
