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
public class RecurringAudienceListName implements ResourceName {
  private static final PathTemplate PROPERTY_RECURRING_AUDIENCE_LIST =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/recurringAudienceLists/{recurring_audience_list}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String recurringAudienceList;

  @Deprecated
  protected RecurringAudienceListName() {
    property = null;
    recurringAudienceList = null;
  }

  private RecurringAudienceListName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    recurringAudienceList = Preconditions.checkNotNull(builder.getRecurringAudienceList());
  }

  public String getProperty() {
    return property;
  }

  public String getRecurringAudienceList() {
    return recurringAudienceList;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RecurringAudienceListName of(String property, String recurringAudienceList) {
    return newBuilder()
        .setProperty(property)
        .setRecurringAudienceList(recurringAudienceList)
        .build();
  }

  public static String format(String property, String recurringAudienceList) {
    return newBuilder()
        .setProperty(property)
        .setRecurringAudienceList(recurringAudienceList)
        .build()
        .toString();
  }

  public static RecurringAudienceListName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_RECURRING_AUDIENCE_LIST.validatedMatch(
            formattedString,
            "RecurringAudienceListName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("recurring_audience_list"));
  }

  public static List<RecurringAudienceListName> parseList(List<String> formattedStrings) {
    List<RecurringAudienceListName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RecurringAudienceListName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RecurringAudienceListName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_RECURRING_AUDIENCE_LIST.matches(formattedString);
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
          if (recurringAudienceList != null) {
            fieldMapBuilder.put("recurring_audience_list", recurringAudienceList);
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
    return PROPERTY_RECURRING_AUDIENCE_LIST.instantiate(
        "property", property, "recurring_audience_list", recurringAudienceList);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RecurringAudienceListName that = ((RecurringAudienceListName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.recurringAudienceList, that.recurringAudienceList);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(recurringAudienceList);
    return h;
  }

  /** Builder for properties/{property}/recurringAudienceLists/{recurring_audience_list}. */
  public static class Builder {
    private String property;
    private String recurringAudienceList;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getRecurringAudienceList() {
      return recurringAudienceList;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setRecurringAudienceList(String recurringAudienceList) {
      this.recurringAudienceList = recurringAudienceList;
      return this;
    }

    private Builder(RecurringAudienceListName recurringAudienceListName) {
      this.property = recurringAudienceListName.property;
      this.recurringAudienceList = recurringAudienceListName.recurringAudienceList;
    }

    public RecurringAudienceListName build() {
      return new RecurringAudienceListName(this);
    }
  }
}
