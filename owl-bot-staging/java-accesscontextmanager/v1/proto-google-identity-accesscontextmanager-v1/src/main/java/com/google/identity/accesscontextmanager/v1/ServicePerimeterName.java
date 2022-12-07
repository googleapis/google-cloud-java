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

package com.google.identity.accesscontextmanager.v1;

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
public class ServicePerimeterName implements ResourceName {
  private static final PathTemplate ACCESS_POLICY_SERVICE_PERIMETER =
      PathTemplate.createWithoutUrlEncoding(
          "accessPolicies/{access_policy}/servicePerimeters/{service_perimeter}");
  private volatile Map<String, String> fieldValuesMap;
  private final String accessPolicy;
  private final String servicePerimeter;

  @Deprecated
  protected ServicePerimeterName() {
    accessPolicy = null;
    servicePerimeter = null;
  }

  private ServicePerimeterName(Builder builder) {
    accessPolicy = Preconditions.checkNotNull(builder.getAccessPolicy());
    servicePerimeter = Preconditions.checkNotNull(builder.getServicePerimeter());
  }

  public String getAccessPolicy() {
    return accessPolicy;
  }

  public String getServicePerimeter() {
    return servicePerimeter;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ServicePerimeterName of(String accessPolicy, String servicePerimeter) {
    return newBuilder().setAccessPolicy(accessPolicy).setServicePerimeter(servicePerimeter).build();
  }

  public static String format(String accessPolicy, String servicePerimeter) {
    return newBuilder()
        .setAccessPolicy(accessPolicy)
        .setServicePerimeter(servicePerimeter)
        .build()
        .toString();
  }

  public static ServicePerimeterName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCESS_POLICY_SERVICE_PERIMETER.validatedMatch(
            formattedString, "ServicePerimeterName.parse: formattedString not in valid format");
    return of(matchMap.get("access_policy"), matchMap.get("service_perimeter"));
  }

  public static List<ServicePerimeterName> parseList(List<String> formattedStrings) {
    List<ServicePerimeterName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ServicePerimeterName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ServicePerimeterName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCESS_POLICY_SERVICE_PERIMETER.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (accessPolicy != null) {
            fieldMapBuilder.put("access_policy", accessPolicy);
          }
          if (servicePerimeter != null) {
            fieldMapBuilder.put("service_perimeter", servicePerimeter);
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
    return ACCESS_POLICY_SERVICE_PERIMETER.instantiate(
        "access_policy", accessPolicy, "service_perimeter", servicePerimeter);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ServicePerimeterName that = ((ServicePerimeterName) o);
      return Objects.equals(this.accessPolicy, that.accessPolicy)
          && Objects.equals(this.servicePerimeter, that.servicePerimeter);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(accessPolicy);
    h *= 1000003;
    h ^= Objects.hashCode(servicePerimeter);
    return h;
  }

  /** Builder for accessPolicies/{access_policy}/servicePerimeters/{service_perimeter}. */
  public static class Builder {
    private String accessPolicy;
    private String servicePerimeter;

    protected Builder() {}

    public String getAccessPolicy() {
      return accessPolicy;
    }

    public String getServicePerimeter() {
      return servicePerimeter;
    }

    public Builder setAccessPolicy(String accessPolicy) {
      this.accessPolicy = accessPolicy;
      return this;
    }

    public Builder setServicePerimeter(String servicePerimeter) {
      this.servicePerimeter = servicePerimeter;
      return this;
    }

    private Builder(ServicePerimeterName servicePerimeterName) {
      this.accessPolicy = servicePerimeterName.accessPolicy;
      this.servicePerimeter = servicePerimeterName.servicePerimeter;
    }

    public ServicePerimeterName build() {
      return new ServicePerimeterName(this);
    }
  }
}
