/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.policysimulator.v1;

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
public class OrgPolicyViolationName implements ResourceName {
  private static final PathTemplate
      ORGANIZATION_LOCATION_ORG_POLICY_VIOLATIONS_PREVIEW_ORG_POLICY_VIOLATION =
          PathTemplate.createWithoutUrlEncoding(
              "organizations/{organization}/locations/{location}/orgPolicyViolationsPreviews/{org_policy_violations_preview}/orgPolicyViolations/{org_policy_violation}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String location;
  private final String orgPolicyViolationsPreview;
  private final String orgPolicyViolation;

  @Deprecated
  protected OrgPolicyViolationName() {
    organization = null;
    location = null;
    orgPolicyViolationsPreview = null;
    orgPolicyViolation = null;
  }

  private OrgPolicyViolationName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    orgPolicyViolationsPreview =
        Preconditions.checkNotNull(builder.getOrgPolicyViolationsPreview());
    orgPolicyViolation = Preconditions.checkNotNull(builder.getOrgPolicyViolation());
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getOrgPolicyViolationsPreview() {
    return orgPolicyViolationsPreview;
  }

  public String getOrgPolicyViolation() {
    return orgPolicyViolation;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static OrgPolicyViolationName of(
      String organization,
      String location,
      String orgPolicyViolationsPreview,
      String orgPolicyViolation) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setOrgPolicyViolationsPreview(orgPolicyViolationsPreview)
        .setOrgPolicyViolation(orgPolicyViolation)
        .build();
  }

  public static String format(
      String organization,
      String location,
      String orgPolicyViolationsPreview,
      String orgPolicyViolation) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setOrgPolicyViolationsPreview(orgPolicyViolationsPreview)
        .setOrgPolicyViolation(orgPolicyViolation)
        .build()
        .toString();
  }

  public static OrgPolicyViolationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_LOCATION_ORG_POLICY_VIOLATIONS_PREVIEW_ORG_POLICY_VIOLATION.validatedMatch(
            formattedString, "OrgPolicyViolationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("organization"),
        matchMap.get("location"),
        matchMap.get("org_policy_violations_preview"),
        matchMap.get("org_policy_violation"));
  }

  public static List<OrgPolicyViolationName> parseList(List<String> formattedStrings) {
    List<OrgPolicyViolationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OrgPolicyViolationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (OrgPolicyViolationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_ORG_POLICY_VIOLATIONS_PREVIEW_ORG_POLICY_VIOLATION.matches(
        formattedString);
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
          if (orgPolicyViolationsPreview != null) {
            fieldMapBuilder.put("org_policy_violations_preview", orgPolicyViolationsPreview);
          }
          if (orgPolicyViolation != null) {
            fieldMapBuilder.put("org_policy_violation", orgPolicyViolation);
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
    return ORGANIZATION_LOCATION_ORG_POLICY_VIOLATIONS_PREVIEW_ORG_POLICY_VIOLATION.instantiate(
        "organization",
        organization,
        "location",
        location,
        "org_policy_violations_preview",
        orgPolicyViolationsPreview,
        "org_policy_violation",
        orgPolicyViolation);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      OrgPolicyViolationName that = ((OrgPolicyViolationName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.orgPolicyViolationsPreview, that.orgPolicyViolationsPreview)
          && Objects.equals(this.orgPolicyViolation, that.orgPolicyViolation);
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
    h ^= Objects.hashCode(orgPolicyViolationsPreview);
    h *= 1000003;
    h ^= Objects.hashCode(orgPolicyViolation);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/orgPolicyViolationsPreviews/{org_policy_violations_preview}/orgPolicyViolations/{org_policy_violation}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String orgPolicyViolationsPreview;
    private String orgPolicyViolation;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getOrgPolicyViolationsPreview() {
      return orgPolicyViolationsPreview;
    }

    public String getOrgPolicyViolation() {
      return orgPolicyViolation;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setOrgPolicyViolationsPreview(String orgPolicyViolationsPreview) {
      this.orgPolicyViolationsPreview = orgPolicyViolationsPreview;
      return this;
    }

    public Builder setOrgPolicyViolation(String orgPolicyViolation) {
      this.orgPolicyViolation = orgPolicyViolation;
      return this;
    }

    private Builder(OrgPolicyViolationName orgPolicyViolationName) {
      this.organization = orgPolicyViolationName.organization;
      this.location = orgPolicyViolationName.location;
      this.orgPolicyViolationsPreview = orgPolicyViolationName.orgPolicyViolationsPreview;
      this.orgPolicyViolation = orgPolicyViolationName.orgPolicyViolation;
    }

    public OrgPolicyViolationName build() {
      return new OrgPolicyViolationName(this);
    }
  }
}
