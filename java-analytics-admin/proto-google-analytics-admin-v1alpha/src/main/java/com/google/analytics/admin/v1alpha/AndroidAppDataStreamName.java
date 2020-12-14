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
public class AndroidAppDataStreamName implements ResourceName {
  private static final PathTemplate PROPERTY_ANDROID_APP_DATA_STREAM =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/androidAppDataStreams/{android_app_data_stream}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String androidAppDataStream;

  @Deprecated
  protected AndroidAppDataStreamName() {
    property = null;
    androidAppDataStream = null;
  }

  private AndroidAppDataStreamName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    androidAppDataStream = Preconditions.checkNotNull(builder.getAndroidAppDataStream());
  }

  public String getProperty() {
    return property;
  }

  public String getAndroidAppDataStream() {
    return androidAppDataStream;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AndroidAppDataStreamName of(String property, String androidAppDataStream) {
    return newBuilder().setProperty(property).setAndroidAppDataStream(androidAppDataStream).build();
  }

  public static String format(String property, String androidAppDataStream) {
    return newBuilder()
        .setProperty(property)
        .setAndroidAppDataStream(androidAppDataStream)
        .build()
        .toString();
  }

  public static AndroidAppDataStreamName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_ANDROID_APP_DATA_STREAM.validatedMatch(
            formattedString, "AndroidAppDataStreamName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("android_app_data_stream"));
  }

  public static List<AndroidAppDataStreamName> parseList(List<String> formattedStrings) {
    List<AndroidAppDataStreamName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AndroidAppDataStreamName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AndroidAppDataStreamName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_ANDROID_APP_DATA_STREAM.matches(formattedString);
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
          if (androidAppDataStream != null) {
            fieldMapBuilder.put("android_app_data_stream", androidAppDataStream);
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
    return PROPERTY_ANDROID_APP_DATA_STREAM.instantiate(
        "property", property, "android_app_data_stream", androidAppDataStream);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      AndroidAppDataStreamName that = ((AndroidAppDataStreamName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.androidAppDataStream, that.androidAppDataStream);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(androidAppDataStream);
    return h;
  }

  /** Builder for properties/{property}/androidAppDataStreams/{android_app_data_stream}. */
  public static class Builder {
    private String property;
    private String androidAppDataStream;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getAndroidAppDataStream() {
      return androidAppDataStream;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setAndroidAppDataStream(String androidAppDataStream) {
      this.androidAppDataStream = androidAppDataStream;
      return this;
    }

    private Builder(AndroidAppDataStreamName androidAppDataStreamName) {
      property = androidAppDataStreamName.property;
      androidAppDataStream = androidAppDataStreamName.androidAppDataStream;
    }

    public AndroidAppDataStreamName build() {
      return new AndroidAppDataStreamName(this);
    }
  }
}
