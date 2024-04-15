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
public class AccessApprovalRequestName implements ResourceName {
  private static final PathTemplate
      ORGANIZATION_LOCATION_CUSTOMER_WORKLOAD_ACCESS_APPROVAL_REQUEST =
          PathTemplate.createWithoutUrlEncoding(
              "organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}/accessApprovalRequests/{access_approval_request}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String location;
  private final String customer;
  private final String workload;
  private final String accessApprovalRequest;

  @Deprecated
  protected AccessApprovalRequestName() {
    organization = null;
    location = null;
    customer = null;
    workload = null;
    accessApprovalRequest = null;
  }

  private AccessApprovalRequestName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    customer = Preconditions.checkNotNull(builder.getCustomer());
    workload = Preconditions.checkNotNull(builder.getWorkload());
    accessApprovalRequest = Preconditions.checkNotNull(builder.getAccessApprovalRequest());
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

  public String getAccessApprovalRequest() {
    return accessApprovalRequest;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AccessApprovalRequestName of(
      String organization,
      String location,
      String customer,
      String workload,
      String accessApprovalRequest) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setCustomer(customer)
        .setWorkload(workload)
        .setAccessApprovalRequest(accessApprovalRequest)
        .build();
  }

  public static String format(
      String organization,
      String location,
      String customer,
      String workload,
      String accessApprovalRequest) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setCustomer(customer)
        .setWorkload(workload)
        .setAccessApprovalRequest(accessApprovalRequest)
        .build()
        .toString();
  }

  public static AccessApprovalRequestName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_LOCATION_CUSTOMER_WORKLOAD_ACCESS_APPROVAL_REQUEST.validatedMatch(
            formattedString,
            "AccessApprovalRequestName.parse: formattedString not in valid format");
    return of(
        matchMap.get("organization"),
        matchMap.get("location"),
        matchMap.get("customer"),
        matchMap.get("workload"),
        matchMap.get("access_approval_request"));
  }

  public static List<AccessApprovalRequestName> parseList(List<String> formattedStrings) {
    List<AccessApprovalRequestName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AccessApprovalRequestName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AccessApprovalRequestName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_CUSTOMER_WORKLOAD_ACCESS_APPROVAL_REQUEST.matches(formattedString);
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
          if (accessApprovalRequest != null) {
            fieldMapBuilder.put("access_approval_request", accessApprovalRequest);
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
    return ORGANIZATION_LOCATION_CUSTOMER_WORKLOAD_ACCESS_APPROVAL_REQUEST.instantiate(
        "organization",
        organization,
        "location",
        location,
        "customer",
        customer,
        "workload",
        workload,
        "access_approval_request",
        accessApprovalRequest);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AccessApprovalRequestName that = ((AccessApprovalRequestName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.customer, that.customer)
          && Objects.equals(this.workload, that.workload)
          && Objects.equals(this.accessApprovalRequest, that.accessApprovalRequest);
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
    h *= 1000003;
    h ^= Objects.hashCode(accessApprovalRequest);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}/accessApprovalRequests/{access_approval_request}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String customer;
    private String workload;
    private String accessApprovalRequest;

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

    public String getAccessApprovalRequest() {
      return accessApprovalRequest;
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

    public Builder setAccessApprovalRequest(String accessApprovalRequest) {
      this.accessApprovalRequest = accessApprovalRequest;
      return this;
    }

    private Builder(AccessApprovalRequestName accessApprovalRequestName) {
      this.organization = accessApprovalRequestName.organization;
      this.location = accessApprovalRequestName.location;
      this.customer = accessApprovalRequestName.customer;
      this.workload = accessApprovalRequestName.workload;
      this.accessApprovalRequest = accessApprovalRequestName.accessApprovalRequest;
    }

    public AccessApprovalRequestName build() {
      return new AccessApprovalRequestName(this);
    }
  }
}
