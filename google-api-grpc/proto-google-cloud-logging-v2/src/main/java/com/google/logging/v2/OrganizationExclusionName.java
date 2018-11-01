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

package com.google.logging.v2;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class OrganizationExclusionName extends ExclusionName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/exclusions/{exclusion}");

  private volatile Map<String, String> fieldValuesMap;

  private final String organization;
  private final String exclusion;

  public String getOrganization() {
    return organization;
  }

  public String getExclusion() {
    return exclusion;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private OrganizationExclusionName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    exclusion = Preconditions.checkNotNull(builder.getExclusion());
  }

  public static OrganizationExclusionName of(String organization, String exclusion) {
    return newBuilder()
      .setOrganization(organization)
      .setExclusion(exclusion)
      .build();
  }

  public static String format(String organization, String exclusion) {
    return newBuilder()
      .setOrganization(organization)
      .setExclusion(exclusion)
      .build()
      .toString();
  }

  public static OrganizationExclusionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "OrganizationExclusionName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("exclusion"));
  }

  public static List<OrganizationExclusionName> parseList(List<String> formattedStrings) {
    List<OrganizationExclusionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OrganizationExclusionName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (OrganizationExclusionName value : values) {
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
          fieldMapBuilder.put("exclusion", exclusion);
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
    return PATH_TEMPLATE.instantiate("organization", organization, "exclusion", exclusion);
  }

  /** Builder for OrganizationExclusionName. */
  public static class Builder {

    private String organization;
    private String exclusion;

    public String getOrganization() {
      return organization;
    }

    public String getExclusion() {
      return exclusion;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setExclusion(String exclusion) {
      this.exclusion = exclusion;
      return this;
    }

    private Builder() {
    }

    private Builder(OrganizationExclusionName organizationExclusionName) {
      organization = organizationExclusionName.organization;
      exclusion = organizationExclusionName.exclusion;
    }

    public OrganizationExclusionName build() {
      return new OrganizationExclusionName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof OrganizationExclusionName) {
      OrganizationExclusionName that = (OrganizationExclusionName) o;
      return (this.organization.equals(that.organization))
          && (this.exclusion.equals(that.exclusion));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= organization.hashCode();
    h *= 1000003;
    h ^= exclusion.hashCode();
    return h;
  }
}

