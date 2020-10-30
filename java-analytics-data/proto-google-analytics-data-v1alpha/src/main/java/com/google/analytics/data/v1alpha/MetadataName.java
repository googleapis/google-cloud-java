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

package com.google.analytics.data.v1alpha;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class MetadataName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("properties/{property}/metadata");

  private volatile Map<String, String> fieldValuesMap;

  private final String property;

  public String getProperty() {
    return property;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private MetadataName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
  }

  public static MetadataName of(String property) {
    return newBuilder().setProperty(property).build();
  }

  public static String format(String property) {
    return newBuilder().setProperty(property).build().toString();
  }

  public static MetadataName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "MetadataName.parse: formattedString not in valid format");
    return of(matchMap.get("property"));
  }

  public static List<MetadataName> parseList(List<String> formattedStrings) {
    List<MetadataName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MetadataName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (MetadataName value : values) {
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
    return PATH_TEMPLATE.instantiate("property", property);
  }

  /** Builder for MetadataName. */
  public static class Builder {

    private String property;

    public String getProperty() {
      return property;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    private Builder() {}

    private Builder(MetadataName metadataName) {
      property = metadataName.property;
    }

    public MetadataName build() {
      return new MetadataName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof MetadataName) {
      MetadataName that = (MetadataName) o;
      return (this.property.equals(that.property));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= property.hashCode();
    return h;
  }
}
