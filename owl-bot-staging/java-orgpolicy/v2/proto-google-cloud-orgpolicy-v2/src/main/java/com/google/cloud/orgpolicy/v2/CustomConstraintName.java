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

package com.google.cloud.orgpolicy.v2;

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
public class CustomConstraintName implements ResourceName {
  private static final PathTemplate ORGANIZATION_CUSTOM_CONSTRAINT =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/customConstraints/{custom_constraint}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String customConstraint;

  @Deprecated
  protected CustomConstraintName() {
    organization = null;
    customConstraint = null;
  }

  private CustomConstraintName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    customConstraint = Preconditions.checkNotNull(builder.getCustomConstraint());
  }

  public String getOrganization() {
    return organization;
  }

  public String getCustomConstraint() {
    return customConstraint;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CustomConstraintName of(String organization, String customConstraint) {
    return newBuilder().setOrganization(organization).setCustomConstraint(customConstraint).build();
  }

  public static String format(String organization, String customConstraint) {
    return newBuilder()
        .setOrganization(organization)
        .setCustomConstraint(customConstraint)
        .build()
        .toString();
  }

  public static CustomConstraintName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_CUSTOM_CONSTRAINT.validatedMatch(
            formattedString, "CustomConstraintName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("custom_constraint"));
  }

  public static List<CustomConstraintName> parseList(List<String> formattedStrings) {
    List<CustomConstraintName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CustomConstraintName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CustomConstraintName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_CUSTOM_CONSTRAINT.matches(formattedString);
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
          if (customConstraint != null) {
            fieldMapBuilder.put("custom_constraint", customConstraint);
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
    return ORGANIZATION_CUSTOM_CONSTRAINT.instantiate(
        "organization", organization, "custom_constraint", customConstraint);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CustomConstraintName that = ((CustomConstraintName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.customConstraint, that.customConstraint);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(customConstraint);
    return h;
  }

  /** Builder for organizations/{organization}/customConstraints/{custom_constraint}. */
  public static class Builder {
    private String organization;
    private String customConstraint;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getCustomConstraint() {
      return customConstraint;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setCustomConstraint(String customConstraint) {
      this.customConstraint = customConstraint;
      return this;
    }

    private Builder(CustomConstraintName customConstraintName) {
      this.organization = customConstraintName.organization;
      this.customConstraint = customConstraintName.customConstraint;
    }

    public CustomConstraintName build() {
      return new CustomConstraintName(this);
    }
  }
}
