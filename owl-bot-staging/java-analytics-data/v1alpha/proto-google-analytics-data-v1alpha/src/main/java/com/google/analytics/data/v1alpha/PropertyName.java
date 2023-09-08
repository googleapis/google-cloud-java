/*
 * Copyright 2023 Google LLC
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

package com.google.analytics.data.v1alpha;

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
public class PropertyName implements ResourceName {
  private static final PathTemplate PROPERTY_ID =
      PathTemplate.createWithoutUrlEncoding("properties/{propertyId}");
  private volatile Map<String, String> fieldValuesMap;
  private final String propertyId;

  @Deprecated
  protected PropertyName() {
    propertyId = null;
  }

  private PropertyName(Builder builder) {
    propertyId = Preconditions.checkNotNull(builder.getPropertyId());
  }

  public String getPropertyId() {
    return propertyId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PropertyName of(String propertyId) {
    return newBuilder().setPropertyId(propertyId).build();
  }

  public static String format(String propertyId) {
    return newBuilder().setPropertyId(propertyId).build().toString();
  }

  public static PropertyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_ID.validatedMatch(
            formattedString, "PropertyName.parse: formattedString not in valid format");
    return of(matchMap.get("propertyId"));
  }

  public static List<PropertyName> parseList(List<String> formattedStrings) {
    List<PropertyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PropertyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PropertyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_ID.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (propertyId != null) {
            fieldMapBuilder.put("propertyId", propertyId);
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
    return PROPERTY_ID.instantiate("propertyId", propertyId);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PropertyName that = ((PropertyName) o);
      return Objects.equals(this.propertyId, that.propertyId);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(propertyId);
    return h;
  }

  /** Builder for properties/{propertyId}. */
  public static class Builder {
    private String propertyId;

    protected Builder() {}

    public String getPropertyId() {
      return propertyId;
    }

    public Builder setPropertyId(String propertyId) {
      this.propertyId = propertyId;
      return this;
    }

    private Builder(PropertyName propertyName) {
      this.propertyId = propertyName.propertyId;
    }

    public PropertyName build() {
      return new PropertyName(this);
    }
  }
}
