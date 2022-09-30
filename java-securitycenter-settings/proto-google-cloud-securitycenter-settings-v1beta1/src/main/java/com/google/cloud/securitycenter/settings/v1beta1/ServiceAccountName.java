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

package com.google.cloud.securitycenter.settings.v1beta1;

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
public class ServiceAccountName implements ResourceName {
  private static final PathTemplate ORGANIZATION =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/serviceAccount");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;

  @Deprecated
  protected ServiceAccountName() {
    organization = null;
  }

  private ServiceAccountName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ServiceAccountName of(String organization) {
    return newBuilder().setOrganization(organization).build();
  }

  public static String format(String organization) {
    return newBuilder().setOrganization(organization).build().toString();
  }

  public static ServiceAccountName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION.validatedMatch(
            formattedString, "ServiceAccountName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"));
  }

  public static List<ServiceAccountName> parseList(List<String> formattedStrings) {
    List<ServiceAccountName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ServiceAccountName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ServiceAccountName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION.matches(formattedString);
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
    return ORGANIZATION.instantiate("organization", organization);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ServiceAccountName that = ((ServiceAccountName) o);
      return Objects.equals(this.organization, that.organization);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for organizations/{organization}/serviceAccount. */
  public static class Builder {
    private String organization;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    private Builder(ServiceAccountName serviceAccountName) {
      this.organization = serviceAccountName.organization;
    }

    public ServiceAccountName build() {
      return new ServiceAccountName(this);
    }
  }
}
