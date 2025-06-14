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
public class SubpropertySyncConfigName implements ResourceName {
  private static final PathTemplate PROPERTY_SUBPROPERTY_SYNC_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/subpropertySyncConfigs/{subproperty_sync_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String subpropertySyncConfig;

  @Deprecated
  protected SubpropertySyncConfigName() {
    property = null;
    subpropertySyncConfig = null;
  }

  private SubpropertySyncConfigName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    subpropertySyncConfig = Preconditions.checkNotNull(builder.getSubpropertySyncConfig());
  }

  public String getProperty() {
    return property;
  }

  public String getSubpropertySyncConfig() {
    return subpropertySyncConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SubpropertySyncConfigName of(String property, String subpropertySyncConfig) {
    return newBuilder()
        .setProperty(property)
        .setSubpropertySyncConfig(subpropertySyncConfig)
        .build();
  }

  public static String format(String property, String subpropertySyncConfig) {
    return newBuilder()
        .setProperty(property)
        .setSubpropertySyncConfig(subpropertySyncConfig)
        .build()
        .toString();
  }

  public static SubpropertySyncConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_SUBPROPERTY_SYNC_CONFIG.validatedMatch(
            formattedString,
            "SubpropertySyncConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("subproperty_sync_config"));
  }

  public static List<SubpropertySyncConfigName> parseList(List<String> formattedStrings) {
    List<SubpropertySyncConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SubpropertySyncConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SubpropertySyncConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_SUBPROPERTY_SYNC_CONFIG.matches(formattedString);
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
          if (subpropertySyncConfig != null) {
            fieldMapBuilder.put("subproperty_sync_config", subpropertySyncConfig);
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
    return PROPERTY_SUBPROPERTY_SYNC_CONFIG.instantiate(
        "property", property, "subproperty_sync_config", subpropertySyncConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SubpropertySyncConfigName that = ((SubpropertySyncConfigName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.subpropertySyncConfig, that.subpropertySyncConfig);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(subpropertySyncConfig);
    return h;
  }

  /** Builder for properties/{property}/subpropertySyncConfigs/{subproperty_sync_config}. */
  public static class Builder {
    private String property;
    private String subpropertySyncConfig;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getSubpropertySyncConfig() {
      return subpropertySyncConfig;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setSubpropertySyncConfig(String subpropertySyncConfig) {
      this.subpropertySyncConfig = subpropertySyncConfig;
      return this;
    }

    private Builder(SubpropertySyncConfigName subpropertySyncConfigName) {
      this.property = subpropertySyncConfigName.property;
      this.subpropertySyncConfig = subpropertySyncConfigName.subpropertySyncConfig;
    }

    public SubpropertySyncConfigName build() {
      return new SubpropertySyncConfigName(this);
    }
  }
}
