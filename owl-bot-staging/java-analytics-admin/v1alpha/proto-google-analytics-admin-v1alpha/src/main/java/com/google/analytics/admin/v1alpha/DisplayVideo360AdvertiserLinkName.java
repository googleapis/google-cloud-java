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
public class DisplayVideo360AdvertiserLinkName implements ResourceName {
  private static final PathTemplate PROPERTY_DISPLAY_VIDEO360_ADVERTISER_LINK =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/displayVideo360AdvertiserLinks/{display_video_360_advertiser_link}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String displayVideo360AdvertiserLink;

  @Deprecated
  protected DisplayVideo360AdvertiserLinkName() {
    property = null;
    displayVideo360AdvertiserLink = null;
  }

  private DisplayVideo360AdvertiserLinkName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    displayVideo360AdvertiserLink =
        Preconditions.checkNotNull(builder.getDisplayVideo360AdvertiserLink());
  }

  public String getProperty() {
    return property;
  }

  public String getDisplayVideo360AdvertiserLink() {
    return displayVideo360AdvertiserLink;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DisplayVideo360AdvertiserLinkName of(
      String property, String displayVideo360AdvertiserLink) {
    return newBuilder()
        .setProperty(property)
        .setDisplayVideo360AdvertiserLink(displayVideo360AdvertiserLink)
        .build();
  }

  public static String format(String property, String displayVideo360AdvertiserLink) {
    return newBuilder()
        .setProperty(property)
        .setDisplayVideo360AdvertiserLink(displayVideo360AdvertiserLink)
        .build()
        .toString();
  }

  public static DisplayVideo360AdvertiserLinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_DISPLAY_VIDEO360_ADVERTISER_LINK.validatedMatch(
            formattedString,
            "DisplayVideo360AdvertiserLinkName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("display_video_360_advertiser_link"));
  }

  public static List<DisplayVideo360AdvertiserLinkName> parseList(List<String> formattedStrings) {
    List<DisplayVideo360AdvertiserLinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DisplayVideo360AdvertiserLinkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DisplayVideo360AdvertiserLinkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_DISPLAY_VIDEO360_ADVERTISER_LINK.matches(formattedString);
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
          if (displayVideo360AdvertiserLink != null) {
            fieldMapBuilder.put("display_video_360_advertiser_link", displayVideo360AdvertiserLink);
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
    return PROPERTY_DISPLAY_VIDEO360_ADVERTISER_LINK.instantiate(
        "property", property, "display_video_360_advertiser_link", displayVideo360AdvertiserLink);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      DisplayVideo360AdvertiserLinkName that = ((DisplayVideo360AdvertiserLinkName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.displayVideo360AdvertiserLink, that.displayVideo360AdvertiserLink);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(displayVideo360AdvertiserLink);
    return h;
  }

  /**
   * Builder for
   * properties/{property}/displayVideo360AdvertiserLinks/{display_video_360_advertiser_link}.
   */
  public static class Builder {
    private String property;
    private String displayVideo360AdvertiserLink;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getDisplayVideo360AdvertiserLink() {
      return displayVideo360AdvertiserLink;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setDisplayVideo360AdvertiserLink(String displayVideo360AdvertiserLink) {
      this.displayVideo360AdvertiserLink = displayVideo360AdvertiserLink;
      return this;
    }

    private Builder(DisplayVideo360AdvertiserLinkName displayVideo360AdvertiserLinkName) {
      this.property = displayVideo360AdvertiserLinkName.property;
      this.displayVideo360AdvertiserLink =
          displayVideo360AdvertiserLinkName.displayVideo360AdvertiserLink;
    }

    public DisplayVideo360AdvertiserLinkName build() {
      return new DisplayVideo360AdvertiserLinkName(this);
    }
  }
}
