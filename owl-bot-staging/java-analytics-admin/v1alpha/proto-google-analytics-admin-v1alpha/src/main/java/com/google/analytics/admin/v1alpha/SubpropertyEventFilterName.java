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
public class SubpropertyEventFilterName implements ResourceName {
  private static final PathTemplate PROPERTY_SUB_PROPERTY_EVENT_FILTER =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/subpropertyEventFilters/{sub_property_event_filter}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String subPropertyEventFilter;

  @Deprecated
  protected SubpropertyEventFilterName() {
    property = null;
    subPropertyEventFilter = null;
  }

  private SubpropertyEventFilterName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    subPropertyEventFilter = Preconditions.checkNotNull(builder.getSubPropertyEventFilter());
  }

  public String getProperty() {
    return property;
  }

  public String getSubPropertyEventFilter() {
    return subPropertyEventFilter;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SubpropertyEventFilterName of(String property, String subPropertyEventFilter) {
    return newBuilder()
        .setProperty(property)
        .setSubPropertyEventFilter(subPropertyEventFilter)
        .build();
  }

  public static String format(String property, String subPropertyEventFilter) {
    return newBuilder()
        .setProperty(property)
        .setSubPropertyEventFilter(subPropertyEventFilter)
        .build()
        .toString();
  }

  public static SubpropertyEventFilterName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_SUB_PROPERTY_EVENT_FILTER.validatedMatch(
            formattedString,
            "SubpropertyEventFilterName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("sub_property_event_filter"));
  }

  public static List<SubpropertyEventFilterName> parseList(List<String> formattedStrings) {
    List<SubpropertyEventFilterName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SubpropertyEventFilterName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SubpropertyEventFilterName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_SUB_PROPERTY_EVENT_FILTER.matches(formattedString);
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
          if (subPropertyEventFilter != null) {
            fieldMapBuilder.put("sub_property_event_filter", subPropertyEventFilter);
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
    return PROPERTY_SUB_PROPERTY_EVENT_FILTER.instantiate(
        "property", property, "sub_property_event_filter", subPropertyEventFilter);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SubpropertyEventFilterName that = ((SubpropertyEventFilterName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.subPropertyEventFilter, that.subPropertyEventFilter);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(subPropertyEventFilter);
    return h;
  }

  /** Builder for properties/{property}/subpropertyEventFilters/{sub_property_event_filter}. */
  public static class Builder {
    private String property;
    private String subPropertyEventFilter;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getSubPropertyEventFilter() {
      return subPropertyEventFilter;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setSubPropertyEventFilter(String subPropertyEventFilter) {
      this.subPropertyEventFilter = subPropertyEventFilter;
      return this;
    }

    private Builder(SubpropertyEventFilterName subpropertyEventFilterName) {
      this.property = subpropertyEventFilterName.property;
      this.subPropertyEventFilter = subpropertyEventFilterName.subPropertyEventFilter;
    }

    public SubpropertyEventFilterName build() {
      return new SubpropertyEventFilterName(this);
    }
  }
}
