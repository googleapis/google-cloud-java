/*
 * Copyright 2026 Google LLC
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

package com.google.ads.marketingplatform.admin.v1alpha;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class AdminAccessBindingName implements ResourceName {
  private static final PathTemplate ORGANIZATION_ADMIN_ACCESS_BINDING =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/adminAccessBindings/{admin_access_binding}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String adminAccessBinding;

  @Deprecated
  protected AdminAccessBindingName() {
    organization = null;
    adminAccessBinding = null;
  }

  private AdminAccessBindingName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    adminAccessBinding = Preconditions.checkNotNull(builder.getAdminAccessBinding());
  }

  public String getOrganization() {
    return organization;
  }

  public String getAdminAccessBinding() {
    return adminAccessBinding;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AdminAccessBindingName of(String organization, String adminAccessBinding) {
    return newBuilder()
        .setOrganization(organization)
        .setAdminAccessBinding(adminAccessBinding)
        .build();
  }

  public static String format(String organization, String adminAccessBinding) {
    return newBuilder()
        .setOrganization(organization)
        .setAdminAccessBinding(adminAccessBinding)
        .build()
        .toString();
  }

  public static @Nullable AdminAccessBindingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_ADMIN_ACCESS_BINDING.validatedMatch(
            formattedString, "AdminAccessBindingName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("admin_access_binding"));
  }

  public static List<AdminAccessBindingName> parseList(List<String> formattedStrings) {
    List<AdminAccessBindingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable AdminAccessBindingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AdminAccessBindingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_ADMIN_ACCESS_BINDING.matches(formattedString);
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
          if (adminAccessBinding != null) {
            fieldMapBuilder.put("admin_access_binding", adminAccessBinding);
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
    return ORGANIZATION_ADMIN_ACCESS_BINDING.instantiate(
        "organization", organization, "admin_access_binding", adminAccessBinding);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AdminAccessBindingName that = ((AdminAccessBindingName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.adminAccessBinding, that.adminAccessBinding);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(adminAccessBinding);
    return h;
  }

  /** Builder for organizations/{organization}/adminAccessBindings/{admin_access_binding}. */
  public static class Builder {
    private String organization;
    private String adminAccessBinding;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getAdminAccessBinding() {
      return adminAccessBinding;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setAdminAccessBinding(String adminAccessBinding) {
      this.adminAccessBinding = adminAccessBinding;
      return this;
    }

    private Builder(AdminAccessBindingName adminAccessBindingName) {
      this.organization = adminAccessBindingName.organization;
      this.adminAccessBinding = adminAccessBindingName.adminAccessBinding;
    }

    public AdminAccessBindingName build() {
      return new AdminAccessBindingName(this);
    }
  }
}
