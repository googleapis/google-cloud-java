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
public class SearchAds360LinkName implements ResourceName {
  private static final PathTemplate PROPERTY_SEARCH_ADS360_LINK =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/searchAds360Links/{search_ads_360_link}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String searchAds360Link;

  @Deprecated
  protected SearchAds360LinkName() {
    property = null;
    searchAds360Link = null;
  }

  private SearchAds360LinkName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    searchAds360Link = Preconditions.checkNotNull(builder.getSearchAds360Link());
  }

  public String getProperty() {
    return property;
  }

  public String getSearchAds360Link() {
    return searchAds360Link;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SearchAds360LinkName of(String property, String searchAds360Link) {
    return newBuilder().setProperty(property).setSearchAds360Link(searchAds360Link).build();
  }

  public static String format(String property, String searchAds360Link) {
    return newBuilder()
        .setProperty(property)
        .setSearchAds360Link(searchAds360Link)
        .build()
        .toString();
  }

  public static SearchAds360LinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_SEARCH_ADS360_LINK.validatedMatch(
            formattedString, "SearchAds360LinkName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("search_ads_360_link"));
  }

  public static List<SearchAds360LinkName> parseList(List<String> formattedStrings) {
    List<SearchAds360LinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SearchAds360LinkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SearchAds360LinkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_SEARCH_ADS360_LINK.matches(formattedString);
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
          if (searchAds360Link != null) {
            fieldMapBuilder.put("search_ads_360_link", searchAds360Link);
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
    return PROPERTY_SEARCH_ADS360_LINK.instantiate(
        "property", property, "search_ads_360_link", searchAds360Link);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SearchAds360LinkName that = ((SearchAds360LinkName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.searchAds360Link, that.searchAds360Link);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(searchAds360Link);
    return h;
  }

  /** Builder for properties/{property}/searchAds360Links/{search_ads_360_link}. */
  public static class Builder {
    private String property;
    private String searchAds360Link;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getSearchAds360Link() {
      return searchAds360Link;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setSearchAds360Link(String searchAds360Link) {
      this.searchAds360Link = searchAds360Link;
      return this;
    }

    private Builder(SearchAds360LinkName searchAds360LinkName) {
      this.property = searchAds360LinkName.property;
      this.searchAds360Link = searchAds360LinkName.searchAds360Link;
    }

    public SearchAds360LinkName build() {
      return new SearchAds360LinkName(this);
    }
  }
}
