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

package com.google.analytics.admin.v1alpha;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class GoogleAdsLinkName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/googleAdsLinks/{google_ads_link}");

  private volatile Map<String, String> fieldValuesMap;

  private final String property;
  private final String googleAdsLink;

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

  private GoogleAdsLinkName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    googleAdsLink = Preconditions.checkNotNull(builder.getGoogleAdsLink());
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
        PATH_TEMPLATE.validatedMatch(
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
    List<String> list = new ArrayList<String>(values.size());
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
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("property", property);
          fieldMapBuilder.put("googleAdsLink", googleAdsLink);
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
    return PATH_TEMPLATE.instantiate("property", property, "google_ads_link", googleAdsLink);
  }

  /** Builder for GoogleAdsLinkName. */
  public static class Builder {

    private String property;
    private String googleAdsLink;

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

    private Builder() {}

    private Builder(GoogleAdsLinkName googleAdsLinkName) {
      property = googleAdsLinkName.property;
      googleAdsLink = googleAdsLinkName.googleAdsLink;
    }

    public GoogleAdsLinkName build() {
      return new GoogleAdsLinkName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof GoogleAdsLinkName) {
      GoogleAdsLinkName that = (GoogleAdsLinkName) o;
      return (this.property.equals(that.property))
          && (this.googleAdsLink.equals(that.googleAdsLink));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= property.hashCode();
    h *= 1000003;
    h ^= googleAdsLink.hashCode();
    return h;
  }
}
