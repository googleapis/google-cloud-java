/*
 * Copyright 2020 Google LLC
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
public class IosAppDataStreamName implements ResourceName {
  private static final PathTemplate PROPERTY_IOS_APP_DATA_STREAM =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/iosAppDataStreams/{ios_app_data_stream}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String iosAppDataStream;

  @Deprecated
  protected IosAppDataStreamName() {
    property = null;
    iosAppDataStream = null;
  }

  private IosAppDataStreamName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    iosAppDataStream = Preconditions.checkNotNull(builder.getIosAppDataStream());
  }

  public String getProperty() {
    return property;
  }

  public String getIosAppDataStream() {
    return iosAppDataStream;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static IosAppDataStreamName of(String property, String iosAppDataStream) {
    return newBuilder().setProperty(property).setIosAppDataStream(iosAppDataStream).build();
  }

  public static String format(String property, String iosAppDataStream) {
    return newBuilder()
        .setProperty(property)
        .setIosAppDataStream(iosAppDataStream)
        .build()
        .toString();
  }

  public static IosAppDataStreamName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_IOS_APP_DATA_STREAM.validatedMatch(
            formattedString, "IosAppDataStreamName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("ios_app_data_stream"));
  }

  public static List<IosAppDataStreamName> parseList(List<String> formattedStrings) {
    List<IosAppDataStreamName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<IosAppDataStreamName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (IosAppDataStreamName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_IOS_APP_DATA_STREAM.matches(formattedString);
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
          if (iosAppDataStream != null) {
            fieldMapBuilder.put("ios_app_data_stream", iosAppDataStream);
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
    return PROPERTY_IOS_APP_DATA_STREAM.instantiate(
        "property", property, "ios_app_data_stream", iosAppDataStream);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      IosAppDataStreamName that = ((IosAppDataStreamName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.iosAppDataStream, that.iosAppDataStream);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(iosAppDataStream);
    return h;
  }

  /** Builder for properties/{property}/iosAppDataStreams/{ios_app_data_stream}. */
  public static class Builder {
    private String property;
    private String iosAppDataStream;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getIosAppDataStream() {
      return iosAppDataStream;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setIosAppDataStream(String iosAppDataStream) {
      this.iosAppDataStream = iosAppDataStream;
      return this;
    }

    private Builder(IosAppDataStreamName iosAppDataStreamName) {
      property = iosAppDataStreamName.property;
      iosAppDataStream = iosAppDataStreamName.iosAppDataStream;
    }

    public IosAppDataStreamName build() {
      return new IosAppDataStreamName(this);
    }
  }
}
