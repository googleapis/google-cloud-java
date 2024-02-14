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
public class RollupPropertySourceLinkName implements ResourceName {
  private static final PathTemplate PROPERTY_ROLLUP_PROPERTY_SOURCE_LINK =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/rollupPropertySourceLinks/{rollup_property_source_link}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String rollupPropertySourceLink;

  @Deprecated
  protected RollupPropertySourceLinkName() {
    property = null;
    rollupPropertySourceLink = null;
  }

  private RollupPropertySourceLinkName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    rollupPropertySourceLink = Preconditions.checkNotNull(builder.getRollupPropertySourceLink());
  }

  public String getProperty() {
    return property;
  }

  public String getRollupPropertySourceLink() {
    return rollupPropertySourceLink;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RollupPropertySourceLinkName of(String property, String rollupPropertySourceLink) {
    return newBuilder()
        .setProperty(property)
        .setRollupPropertySourceLink(rollupPropertySourceLink)
        .build();
  }

  public static String format(String property, String rollupPropertySourceLink) {
    return newBuilder()
        .setProperty(property)
        .setRollupPropertySourceLink(rollupPropertySourceLink)
        .build()
        .toString();
  }

  public static RollupPropertySourceLinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_ROLLUP_PROPERTY_SOURCE_LINK.validatedMatch(
            formattedString,
            "RollupPropertySourceLinkName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("rollup_property_source_link"));
  }

  public static List<RollupPropertySourceLinkName> parseList(List<String> formattedStrings) {
    List<RollupPropertySourceLinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RollupPropertySourceLinkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RollupPropertySourceLinkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_ROLLUP_PROPERTY_SOURCE_LINK.matches(formattedString);
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
          if (rollupPropertySourceLink != null) {
            fieldMapBuilder.put("rollup_property_source_link", rollupPropertySourceLink);
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
    return PROPERTY_ROLLUP_PROPERTY_SOURCE_LINK.instantiate(
        "property", property, "rollup_property_source_link", rollupPropertySourceLink);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RollupPropertySourceLinkName that = ((RollupPropertySourceLinkName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.rollupPropertySourceLink, that.rollupPropertySourceLink);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(rollupPropertySourceLink);
    return h;
  }

  /** Builder for properties/{property}/rollupPropertySourceLinks/{rollup_property_source_link}. */
  public static class Builder {
    private String property;
    private String rollupPropertySourceLink;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getRollupPropertySourceLink() {
      return rollupPropertySourceLink;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setRollupPropertySourceLink(String rollupPropertySourceLink) {
      this.rollupPropertySourceLink = rollupPropertySourceLink;
      return this;
    }

    private Builder(RollupPropertySourceLinkName rollupPropertySourceLinkName) {
      this.property = rollupPropertySourceLinkName.property;
      this.rollupPropertySourceLink = rollupPropertySourceLinkName.rollupPropertySourceLink;
    }

    public RollupPropertySourceLinkName build() {
      return new RollupPropertySourceLinkName(this);
    }
  }
}
