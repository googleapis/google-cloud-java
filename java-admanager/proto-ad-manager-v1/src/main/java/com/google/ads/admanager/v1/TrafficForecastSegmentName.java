/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class TrafficForecastSegmentName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_TRAFFIC_FORECAST_SEGMENT =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/trafficForecastSegments/{traffic_forecast_segment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String trafficForecastSegment;

  @Deprecated
  protected TrafficForecastSegmentName() {
    networkCode = null;
    trafficForecastSegment = null;
  }

  private TrafficForecastSegmentName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    trafficForecastSegment = Preconditions.checkNotNull(builder.getTrafficForecastSegment());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getTrafficForecastSegment() {
    return trafficForecastSegment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TrafficForecastSegmentName of(String networkCode, String trafficForecastSegment) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setTrafficForecastSegment(trafficForecastSegment)
        .build();
  }

  public static String format(String networkCode, String trafficForecastSegment) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setTrafficForecastSegment(trafficForecastSegment)
        .build()
        .toString();
  }

  public static @Nullable TrafficForecastSegmentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_TRAFFIC_FORECAST_SEGMENT.validatedMatch(
            formattedString,
            "TrafficForecastSegmentName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("traffic_forecast_segment"));
  }

  public static List<TrafficForecastSegmentName> parseList(List<String> formattedStrings) {
    List<TrafficForecastSegmentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable TrafficForecastSegmentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TrafficForecastSegmentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_TRAFFIC_FORECAST_SEGMENT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (networkCode != null) {
            fieldMapBuilder.put("network_code", networkCode);
          }
          if (trafficForecastSegment != null) {
            fieldMapBuilder.put("traffic_forecast_segment", trafficForecastSegment);
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
    return NETWORK_CODE_TRAFFIC_FORECAST_SEGMENT.instantiate(
        "network_code", networkCode, "traffic_forecast_segment", trafficForecastSegment);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TrafficForecastSegmentName that = ((TrafficForecastSegmentName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.trafficForecastSegment, that.trafficForecastSegment);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(trafficForecastSegment);
    return h;
  }

  /** Builder for networks/{network_code}/trafficForecastSegments/{traffic_forecast_segment}. */
  public static class Builder {
    private String networkCode;
    private String trafficForecastSegment;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getTrafficForecastSegment() {
      return trafficForecastSegment;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setTrafficForecastSegment(String trafficForecastSegment) {
      this.trafficForecastSegment = trafficForecastSegment;
      return this;
    }

    private Builder(TrafficForecastSegmentName trafficForecastSegmentName) {
      this.networkCode = trafficForecastSegmentName.networkCode;
      this.trafficForecastSegment = trafficForecastSegmentName.trafficForecastSegment;
    }

    public TrafficForecastSegmentName build() {
      return new TrafficForecastSegmentName(this);
    }
  }
}
