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

package com.google.privacy.dlp.v2;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class OrganizationStoredInfoTypeName extends StoredInfoTypeName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/storedInfoTypes/{stored_info_type}");

  private volatile Map<String, String> fieldValuesMap;

  private final String organization;
  private final String storedInfoType;

  public String getOrganization() {
    return organization;
  }

  public String getStoredInfoType() {
    return storedInfoType;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private OrganizationStoredInfoTypeName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    storedInfoType = Preconditions.checkNotNull(builder.getStoredInfoType());
  }

  public static OrganizationStoredInfoTypeName of(String organization, String storedInfoType) {
    return newBuilder().setOrganization(organization).setStoredInfoType(storedInfoType).build();
  }

  public static String format(String organization, String storedInfoType) {
    return newBuilder()
        .setOrganization(organization)
        .setStoredInfoType(storedInfoType)
        .build()
        .toString();
  }

  public static OrganizationStoredInfoTypeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString,
            "OrganizationStoredInfoTypeName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("stored_info_type"));
  }

  public static List<OrganizationStoredInfoTypeName> parseList(List<String> formattedStrings) {
    List<OrganizationStoredInfoTypeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OrganizationStoredInfoTypeName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (OrganizationStoredInfoTypeName value : values) {
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
          fieldMapBuilder.put("storedInfoType", storedInfoType);
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
        "organization", organization, "stored_info_type", storedInfoType);
  }

  /** Builder for OrganizationStoredInfoTypeName. */
  public static class Builder extends StoredInfoTypeName.Builder {

    private String organization;
    private String storedInfoType;

    public String getOrganization() {
      return organization;
    }

    public String getStoredInfoType() {
      return storedInfoType;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setStoredInfoType(String storedInfoType) {
      this.storedInfoType = storedInfoType;
      return this;
    }

    private Builder() {}

    private Builder(OrganizationStoredInfoTypeName organizationStoredInfoTypeName) {
      organization = organizationStoredInfoTypeName.organization;
      storedInfoType = organizationStoredInfoTypeName.storedInfoType;
    }

    public OrganizationStoredInfoTypeName build() {
      return new OrganizationStoredInfoTypeName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof OrganizationStoredInfoTypeName) {
      OrganizationStoredInfoTypeName that = (OrganizationStoredInfoTypeName) o;
      return (this.organization.equals(that.organization))
          && (this.storedInfoType.equals(that.storedInfoType));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= organization.hashCode();
    h *= 1000003;
    h ^= storedInfoType.hashCode();
    return h;
  }
}
