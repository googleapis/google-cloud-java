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

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class MetadataName implements ResourceName {

  @Deprecated
  protected MetadataName() {}

  private static final String METADATA_FIXED_VALUE = "metadata";
  private static final MetadataName METADATA_INSTANCE = new MetadataName("metadata");
  private static final PathTemplate PROPERTY_METADATA_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("properties/{property}/metadata");

  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;

  private String property;

  public String getProperty() {
    return property;
  }

  private MetadataName(PropertyMetadataBuilder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    pathTemplate = PROPERTY_METADATA_PATH_TEMPLATE;
  }

  private MetadataName(String fixedValue) {
    this.fixedValue = fixedValue;
    fieldValuesMap = ImmutableMap.of("", fixedValue);
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static PropertyMetadataBuilder newPropertyMetadataBuilder() {
    return new PropertyMetadataBuilder();
  }

  public static MetadataName of(String metadata) {
    return METADATA_INSTANCE;
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static MetadataName ofMetadataName() {
    return METADATA_INSTANCE;
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static MetadataName ofPropertyMetadataName(String property) {
    return newPropertyMetadataBuilder().setProperty(property).build();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatMetadataName() {
    return METADATA_FIXED_VALUE;
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatPropertyMetadataName(String property) {
    return newPropertyMetadataBuilder().setProperty(property).build().toString();
  }

  public static MetadataName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (METADATA_FIXED_VALUE.equals(formattedString)) {
      return METADATA_INSTANCE;
    } else if (PROPERTY_METADATA_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROPERTY_METADATA_PATH_TEMPLATE.match(formattedString);
      return ofPropertyMetadataName(matchMap.get("property"));
    }
    throw new ValidationException("JobName.parse: formattedString not in valid format");
  }

  public static List<MetadataName> parseList(List<String> formattedStrings) {
    List<MetadataName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MetadataName> values) {
    List<String> list = new ArrayList<>(values.size());
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
    return METADATA_FIXED_VALUE.equals(formattedString)
        || PROPERTY_METADATA_PATH_TEMPLATE.matches(formattedString);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  /** Builder for properties/{property}/metadata. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class PropertyMetadataBuilder {

    private String property;

    private PropertyMetadataBuilder() {}

    public String getProperty() {
      return property;
    }

    public PropertyMetadataBuilder setProperty(String property) {
      this.property = property;
      return this;
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
    if (o != null || getClass() == o.getClass()) {
      MetadataName that = (MetadataName) o;
      return (Objects.equals(this.property, that.property));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(property);
    return h;
  }
}
