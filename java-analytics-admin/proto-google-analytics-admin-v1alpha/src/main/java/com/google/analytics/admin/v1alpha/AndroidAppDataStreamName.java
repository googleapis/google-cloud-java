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

package com.google.analytics.admin.v1alpha;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class AndroidAppDataStreamName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/androidAppDataStreams/{android_app_data_stream}");

  private volatile Map<String, String> fieldValuesMap;

  private final String property;
  private final String androidAppDataStream;

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

  private AndroidAppDataStreamName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    androidAppDataStream = Preconditions.checkNotNull(builder.getAndroidAppDataStream());
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
        PATH_TEMPLATE.validatedMatch(
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
    List<String> list = new ArrayList<String>(values.size());
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
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("property", property);
          fieldMapBuilder.put("androidAppDataStream", androidAppDataStream);
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
    return PATH_TEMPLATE.instantiate(
        "property", property, "android_app_data_stream", androidAppDataStream);
  }

  /** Builder for AndroidAppDataStreamName. */
  public static class Builder {

    private String property;
    private String androidAppDataStream;

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

    private Builder() {}

    private Builder(AndroidAppDataStreamName androidAppDataStreamName) {
      property = androidAppDataStreamName.property;
      androidAppDataStream = androidAppDataStreamName.androidAppDataStream;
    }

    public AndroidAppDataStreamName build() {
      return new AndroidAppDataStreamName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AndroidAppDataStreamName) {
      AndroidAppDataStreamName that = (AndroidAppDataStreamName) o;
      return (this.property.equals(that.property))
          && (this.androidAppDataStream.equals(that.androidAppDataStream));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= property.hashCode();
    h *= 1000003;
    h ^= androidAppDataStream.hashCode();
    return h;
  }
}
