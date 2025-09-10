/*
 * Copyright 2025 Google LLC
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
public class ReportingIdentitySettingsName implements ResourceName {
  private static final PathTemplate PROPERTY =
      PathTemplate.createWithoutUrlEncoding("properties/{property}/reportingIdentitySettings");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;

  @Deprecated
  protected ReportingIdentitySettingsName() {
    property = null;
  }

  private ReportingIdentitySettingsName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
  }

  public String getProperty() {
    return property;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ReportingIdentitySettingsName of(String property) {
    return newBuilder().setProperty(property).build();
  }

  public static String format(String property) {
    return newBuilder().setProperty(property).build().toString();
  }

  public static ReportingIdentitySettingsName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY.validatedMatch(
            formattedString,
            "ReportingIdentitySettingsName.parse: formattedString not in valid format");
    return of(matchMap.get("property"));
  }

  public static List<ReportingIdentitySettingsName> parseList(List<String> formattedStrings) {
    List<ReportingIdentitySettingsName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ReportingIdentitySettingsName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ReportingIdentitySettingsName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY.matches(formattedString);
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
    return PROPERTY.instantiate("property", property);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ReportingIdentitySettingsName that = ((ReportingIdentitySettingsName) o);
      return Objects.equals(this.property, that.property);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    return h;
  }

  /** Builder for properties/{property}/reportingIdentitySettings. */
  public static class Builder {
    private String property;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    private Builder(ReportingIdentitySettingsName reportingIdentitySettingsName) {
      this.property = reportingIdentitySettingsName.property;
    }

    public ReportingIdentitySettingsName build() {
      return new ReportingIdentitySettingsName(this);
    }
  }
}
