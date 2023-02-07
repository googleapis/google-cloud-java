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

package com.google.analytics.admin.v1beta;

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
public class CustomDimensionName implements ResourceName {
  private static final PathTemplate PROPERTY_CUSTOM_DIMENSION =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/customDimensions/{custom_dimension}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String customDimension;

  @Deprecated
  protected CustomDimensionName() {
    property = null;
    customDimension = null;
  }

  private CustomDimensionName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    customDimension = Preconditions.checkNotNull(builder.getCustomDimension());
  }

  public String getProperty() {
    return property;
  }

  public String getCustomDimension() {
    return customDimension;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CustomDimensionName of(String property, String customDimension) {
    return newBuilder().setProperty(property).setCustomDimension(customDimension).build();
  }

  public static String format(String property, String customDimension) {
    return newBuilder()
        .setProperty(property)
        .setCustomDimension(customDimension)
        .build()
        .toString();
  }

  public static CustomDimensionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_CUSTOM_DIMENSION.validatedMatch(
            formattedString, "CustomDimensionName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("custom_dimension"));
  }

  public static List<CustomDimensionName> parseList(List<String> formattedStrings) {
    List<CustomDimensionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CustomDimensionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CustomDimensionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_CUSTOM_DIMENSION.matches(formattedString);
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
          if (customDimension != null) {
            fieldMapBuilder.put("custom_dimension", customDimension);
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
    return PROPERTY_CUSTOM_DIMENSION.instantiate(
        "property", property, "custom_dimension", customDimension);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      CustomDimensionName that = ((CustomDimensionName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.customDimension, that.customDimension);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(customDimension);
    return h;
  }

  /** Builder for properties/{property}/customDimensions/{custom_dimension}. */
  public static class Builder {
    private String property;
    private String customDimension;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getCustomDimension() {
      return customDimension;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setCustomDimension(String customDimension) {
      this.customDimension = customDimension;
      return this;
    }

    private Builder(CustomDimensionName customDimensionName) {
      this.property = customDimensionName.property;
      this.customDimension = customDimensionName.customDimension;
    }

    public CustomDimensionName build() {
      return new CustomDimensionName(this);
    }
  }
}
