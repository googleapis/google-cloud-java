/*
 * Copyright 2020 Google LLC
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

package com.google.analytics.admin.v1alpha;

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
public class GoogleAdsLinkName implements ResourceName {
  private static final PathTemplate PROPERTY_GOOGLE_ADS_LINK =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/googleAdsLinks/{google_ads_link}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String googleAdsLink;

  @Deprecated
  protected GoogleAdsLinkName() {
    property = null;
    googleAdsLink = null;
  }

  private GoogleAdsLinkName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    googleAdsLink = Preconditions.checkNotNull(builder.getGoogleAdsLink());
  }

  public String getProperty() {
    return property;
  }

  public String getGoogleAdsLink() {
    return googleAdsLink;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GoogleAdsLinkName of(String property, String googleAdsLink) {
    return newBuilder().setProperty(property).setGoogleAdsLink(googleAdsLink).build();
  }

  public static String format(String property, String googleAdsLink) {
    return newBuilder().setProperty(property).setGoogleAdsLink(googleAdsLink).build().toString();
  }

  public static GoogleAdsLinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_GOOGLE_ADS_LINK.validatedMatch(
            formattedString, "GoogleAdsLinkName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("google_ads_link"));
  }

  public static List<GoogleAdsLinkName> parseList(List<String> formattedStrings) {
    List<GoogleAdsLinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GoogleAdsLinkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GoogleAdsLinkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_GOOGLE_ADS_LINK.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (property != null) {
            fieldMapBuilder.put("property", property);
          }
          if (googleAdsLink != null) {
            fieldMapBuilder.put("google_ads_link", googleAdsLink);
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
    return PROPERTY_GOOGLE_ADS_LINK.instantiate(
        "property", property, "google_ads_link", googleAdsLink);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      GoogleAdsLinkName that = ((GoogleAdsLinkName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.googleAdsLink, that.googleAdsLink);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(googleAdsLink);
    return h;
  }

  /** Builder for properties/{property}/googleAdsLinks/{google_ads_link}. */
  public static class Builder {
    private String property;
    private String googleAdsLink;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getGoogleAdsLink() {
      return googleAdsLink;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setGoogleAdsLink(String googleAdsLink) {
      this.googleAdsLink = googleAdsLink;
      return this;
    }

    private Builder(GoogleAdsLinkName googleAdsLinkName) {
      property = googleAdsLinkName.property;
      googleAdsLink = googleAdsLinkName.googleAdsLink;
    }

    public GoogleAdsLinkName build() {
      return new GoogleAdsLinkName(this);
    }
  }
}
