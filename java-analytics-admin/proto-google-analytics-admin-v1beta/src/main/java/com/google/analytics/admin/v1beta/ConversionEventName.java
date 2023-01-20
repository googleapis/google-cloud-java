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
public class ConversionEventName implements ResourceName {
  private static final PathTemplate PROPERTY_CONVERSION_EVENT =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/conversionEvents/{conversion_event}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String conversionEvent;

  @Deprecated
  protected ConversionEventName() {
    property = null;
    conversionEvent = null;
  }

  private ConversionEventName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    conversionEvent = Preconditions.checkNotNull(builder.getConversionEvent());
  }

  public String getProperty() {
    return property;
  }

  public String getConversionEvent() {
    return conversionEvent;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ConversionEventName of(String property, String conversionEvent) {
    return newBuilder().setProperty(property).setConversionEvent(conversionEvent).build();
  }

  public static String format(String property, String conversionEvent) {
    return newBuilder()
        .setProperty(property)
        .setConversionEvent(conversionEvent)
        .build()
        .toString();
  }

  public static ConversionEventName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_CONVERSION_EVENT.validatedMatch(
            formattedString, "ConversionEventName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("conversion_event"));
  }

  public static List<ConversionEventName> parseList(List<String> formattedStrings) {
    List<ConversionEventName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ConversionEventName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ConversionEventName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_CONVERSION_EVENT.matches(formattedString);
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
          if (conversionEvent != null) {
            fieldMapBuilder.put("conversion_event", conversionEvent);
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
    return PROPERTY_CONVERSION_EVENT.instantiate(
        "property", property, "conversion_event", conversionEvent);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ConversionEventName that = ((ConversionEventName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.conversionEvent, that.conversionEvent);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(conversionEvent);
    return h;
  }

  /** Builder for properties/{property}/conversionEvents/{conversion_event}. */
  public static class Builder {
    private String property;
    private String conversionEvent;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getConversionEvent() {
      return conversionEvent;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setConversionEvent(String conversionEvent) {
      this.conversionEvent = conversionEvent;
      return this;
    }

    private Builder(ConversionEventName conversionEventName) {
      this.property = conversionEventName.property;
      this.conversionEvent = conversionEventName.conversionEvent;
    }

    public ConversionEventName build() {
      return new ConversionEventName(this);
    }
  }
}
