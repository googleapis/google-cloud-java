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

package com.google.privacy.dlp.v2;

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
public class OrganizationName implements ResourceName {
  private static final PathTemplate ORGANIZATION =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;

  @Deprecated
  protected OrganizationName() {
    organization = null;
  }

  private OrganizationName(Builder builder) {
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

  public static OrganizationName of(String organization) {
    return newBuilder().setOrganization(organization).build();
  }

  public static String format(String organization) {
    return newBuilder().setOrganization(organization).build().toString();
  }

  public static OrganizationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION.validatedMatch(
            formattedString, "OrganizationName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"));
  }

  public static List<OrganizationName> parseList(List<String> formattedStrings) {
    List<OrganizationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OrganizationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (OrganizationName value : values) {
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
      OrganizationName that = ((OrganizationName) o);
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

  /** Builder for organizations/{organization}. */
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

    private Builder(OrganizationName organizationName) {
      this.organization = organizationName.organization;
    }

    public OrganizationName build() {
      return new OrganizationName(this);
    }
  }
}
