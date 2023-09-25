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
public class SKAdNetworkConversionValueSchemaName implements ResourceName {
  private static final PathTemplate PROPERTY_DATA_STREAM_SKADNETWORK_CONVERSION_VALUE_SCHEMA =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/dataStreams/{data_stream}/sKAdNetworkConversionValueSchema/{skadnetwork_conversion_value_schema}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String dataStream;
  private final String skadnetworkConversionValueSchema;

  @Deprecated
  protected SKAdNetworkConversionValueSchemaName() {
    property = null;
    dataStream = null;
    skadnetworkConversionValueSchema = null;
  }

  private SKAdNetworkConversionValueSchemaName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    dataStream = Preconditions.checkNotNull(builder.getDataStream());
    skadnetworkConversionValueSchema =
        Preconditions.checkNotNull(builder.getSkadnetworkConversionValueSchema());
  }

  public String getProperty() {
    return property;
  }

  public String getDataStream() {
    return dataStream;
  }

  public String getSkadnetworkConversionValueSchema() {
    return skadnetworkConversionValueSchema;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SKAdNetworkConversionValueSchemaName of(
      String property, String dataStream, String skadnetworkConversionValueSchema) {
    return newBuilder()
        .setProperty(property)
        .setDataStream(dataStream)
        .setSkadnetworkConversionValueSchema(skadnetworkConversionValueSchema)
        .build();
  }

  public static String format(
      String property, String dataStream, String skadnetworkConversionValueSchema) {
    return newBuilder()
        .setProperty(property)
        .setDataStream(dataStream)
        .setSkadnetworkConversionValueSchema(skadnetworkConversionValueSchema)
        .build()
        .toString();
  }

  public static SKAdNetworkConversionValueSchemaName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_DATA_STREAM_SKADNETWORK_CONVERSION_VALUE_SCHEMA.validatedMatch(
            formattedString,
            "SKAdNetworkConversionValueSchemaName.parse: formattedString not in valid format");
    return of(
        matchMap.get("property"),
        matchMap.get("data_stream"),
        matchMap.get("skadnetwork_conversion_value_schema"));
  }

  public static List<SKAdNetworkConversionValueSchemaName> parseList(
      List<String> formattedStrings) {
    List<SKAdNetworkConversionValueSchemaName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SKAdNetworkConversionValueSchemaName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SKAdNetworkConversionValueSchemaName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_DATA_STREAM_SKADNETWORK_CONVERSION_VALUE_SCHEMA.matches(formattedString);
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
          if (dataStream != null) {
            fieldMapBuilder.put("data_stream", dataStream);
          }
          if (skadnetworkConversionValueSchema != null) {
            fieldMapBuilder.put(
                "skadnetwork_conversion_value_schema", skadnetworkConversionValueSchema);
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
    return PROPERTY_DATA_STREAM_SKADNETWORK_CONVERSION_VALUE_SCHEMA.instantiate(
        "property",
        property,
        "data_stream",
        dataStream,
        "skadnetwork_conversion_value_schema",
        skadnetworkConversionValueSchema);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SKAdNetworkConversionValueSchemaName that = ((SKAdNetworkConversionValueSchemaName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.dataStream, that.dataStream)
          && Objects.equals(
              this.skadnetworkConversionValueSchema, that.skadnetworkConversionValueSchema);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(dataStream);
    h *= 1000003;
    h ^= Objects.hashCode(skadnetworkConversionValueSchema);
    return h;
  }

  /**
   * Builder for
   * properties/{property}/dataStreams/{data_stream}/sKAdNetworkConversionValueSchema/{skadnetwork_conversion_value_schema}.
   */
  public static class Builder {
    private String property;
    private String dataStream;
    private String skadnetworkConversionValueSchema;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getDataStream() {
      return dataStream;
    }

    public String getSkadnetworkConversionValueSchema() {
      return skadnetworkConversionValueSchema;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setDataStream(String dataStream) {
      this.dataStream = dataStream;
      return this;
    }

    public Builder setSkadnetworkConversionValueSchema(String skadnetworkConversionValueSchema) {
      this.skadnetworkConversionValueSchema = skadnetworkConversionValueSchema;
      return this;
    }

    private Builder(SKAdNetworkConversionValueSchemaName sKAdNetworkConversionValueSchemaName) {
      this.property = sKAdNetworkConversionValueSchemaName.property;
      this.dataStream = sKAdNetworkConversionValueSchemaName.dataStream;
      this.skadnetworkConversionValueSchema =
          sKAdNetworkConversionValueSchemaName.skadnetworkConversionValueSchema;
    }

    public SKAdNetworkConversionValueSchemaName build() {
      return new SKAdNetworkConversionValueSchemaName(this);
    }
  }
}
