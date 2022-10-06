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
public class GcpUserAccessBindingName implements ResourceName {
  private static final PathTemplate ORGANIZATION_GCP_USER_ACCESS_BINDING =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/gcpUserAccessBindings/{gcp_user_access_binding}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String gcpUserAccessBinding;

  @Deprecated
  protected GcpUserAccessBindingName() {
    organization = null;
    gcpUserAccessBinding = null;
  }

  private GcpUserAccessBindingName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    gcpUserAccessBinding = Preconditions.checkNotNull(builder.getGcpUserAccessBinding());
  }

  public String getOrganization() {
    return organization;
  }

  public String getGcpUserAccessBinding() {
    return gcpUserAccessBinding;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GcpUserAccessBindingName of(String organization, String gcpUserAccessBinding) {
    return newBuilder()
        .setOrganization(organization)
        .setGcpUserAccessBinding(gcpUserAccessBinding)
        .build();
  }

  public static String format(String organization, String gcpUserAccessBinding) {
    return newBuilder()
        .setOrganization(organization)
        .setGcpUserAccessBinding(gcpUserAccessBinding)
        .build()
        .toString();
  }

  public static GcpUserAccessBindingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_GCP_USER_ACCESS_BINDING.validatedMatch(
            formattedString, "GcpUserAccessBindingName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("gcp_user_access_binding"));
  }

  public static List<GcpUserAccessBindingName> parseList(List<String> formattedStrings) {
    List<GcpUserAccessBindingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GcpUserAccessBindingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GcpUserAccessBindingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_GCP_USER_ACCESS_BINDING.matches(formattedString);
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
          if (gcpUserAccessBinding != null) {
            fieldMapBuilder.put("gcp_user_access_binding", gcpUserAccessBinding);
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
    return ORGANIZATION_GCP_USER_ACCESS_BINDING.instantiate(
        "organization", organization, "gcp_user_access_binding", gcpUserAccessBinding);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      GcpUserAccessBindingName that = ((GcpUserAccessBindingName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.gcpUserAccessBinding, that.gcpUserAccessBinding);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(gcpUserAccessBinding);
    return h;
  }

  /** Builder for organizations/{organization}/gcpUserAccessBindings/{gcp_user_access_binding}. */
  public static class Builder {
    private String organization;
    private String gcpUserAccessBinding;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getGcpUserAccessBinding() {
      return gcpUserAccessBinding;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setGcpUserAccessBinding(String gcpUserAccessBinding) {
      this.gcpUserAccessBinding = gcpUserAccessBinding;
      return this;
    }

    private Builder(GcpUserAccessBindingName gcpUserAccessBindingName) {
      this.organization = gcpUserAccessBindingName.organization;
      this.gcpUserAccessBinding = gcpUserAccessBindingName.gcpUserAccessBinding;
    }

    public GcpUserAccessBindingName build() {
      return new GcpUserAccessBindingName(this);
    }
  }
}
