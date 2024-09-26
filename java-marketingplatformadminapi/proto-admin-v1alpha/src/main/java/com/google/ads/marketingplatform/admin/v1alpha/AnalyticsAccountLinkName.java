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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class AnalyticsAccountLinkName implements ResourceName {
  private static final PathTemplate ORGANIZATION_ANALYTICS_ACCOUNT_LINK =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/analyticsAccountLinks/{analytics_account_link}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String analyticsAccountLink;

  @Deprecated
  protected AnalyticsAccountLinkName() {
    organization = null;
    analyticsAccountLink = null;
  }

  private AnalyticsAccountLinkName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    analyticsAccountLink = Preconditions.checkNotNull(builder.getAnalyticsAccountLink());
  }

  public String getOrganization() {
    return organization;
  }

  public String getAnalyticsAccountLink() {
    return analyticsAccountLink;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AnalyticsAccountLinkName of(String organization, String analyticsAccountLink) {
    return newBuilder()
        .setOrganization(organization)
        .setAnalyticsAccountLink(analyticsAccountLink)
        .build();
  }

  public static String format(String organization, String analyticsAccountLink) {
    return newBuilder()
        .setOrganization(organization)
        .setAnalyticsAccountLink(analyticsAccountLink)
        .build()
        .toString();
  }

  public static AnalyticsAccountLinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_ANALYTICS_ACCOUNT_LINK.validatedMatch(
            formattedString, "AnalyticsAccountLinkName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("analytics_account_link"));
  }

  public static List<AnalyticsAccountLinkName> parseList(List<String> formattedStrings) {
    List<AnalyticsAccountLinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AnalyticsAccountLinkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AnalyticsAccountLinkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_ANALYTICS_ACCOUNT_LINK.matches(formattedString);
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
          if (analyticsAccountLink != null) {
            fieldMapBuilder.put("analytics_account_link", analyticsAccountLink);
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
    return ORGANIZATION_ANALYTICS_ACCOUNT_LINK.instantiate(
        "organization", organization, "analytics_account_link", analyticsAccountLink);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AnalyticsAccountLinkName that = ((AnalyticsAccountLinkName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.analyticsAccountLink, that.analyticsAccountLink);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(analyticsAccountLink);
    return h;
  }

  /** Builder for organizations/{organization}/analyticsAccountLinks/{analytics_account_link}. */
  public static class Builder {
    private String organization;
    private String analyticsAccountLink;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getAnalyticsAccountLink() {
      return analyticsAccountLink;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setAnalyticsAccountLink(String analyticsAccountLink) {
      this.analyticsAccountLink = analyticsAccountLink;
      return this;
    }

    private Builder(AnalyticsAccountLinkName analyticsAccountLinkName) {
      this.organization = analyticsAccountLinkName.organization;
      this.analyticsAccountLink = analyticsAccountLinkName.analyticsAccountLink;
    }

    public AnalyticsAccountLinkName build() {
      return new AnalyticsAccountLinkName(this);
    }
  }
}
