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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class AudienceSegmentName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_AUDIENCE_SEGMENT =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/audienceSegments/{audience_segment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String audienceSegment;

  @Deprecated
  protected AudienceSegmentName() {
    networkCode = null;
    audienceSegment = null;
  }

  private AudienceSegmentName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    audienceSegment = Preconditions.checkNotNull(builder.getAudienceSegment());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getAudienceSegment() {
    return audienceSegment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AudienceSegmentName of(String networkCode, String audienceSegment) {
    return newBuilder().setNetworkCode(networkCode).setAudienceSegment(audienceSegment).build();
  }

  public static String format(String networkCode, String audienceSegment) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setAudienceSegment(audienceSegment)
        .build()
        .toString();
  }

  public static AudienceSegmentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_AUDIENCE_SEGMENT.validatedMatch(
            formattedString, "AudienceSegmentName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("audience_segment"));
  }

  public static List<AudienceSegmentName> parseList(List<String> formattedStrings) {
    List<AudienceSegmentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AudienceSegmentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AudienceSegmentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_AUDIENCE_SEGMENT.matches(formattedString);
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
          if (audienceSegment != null) {
            fieldMapBuilder.put("audience_segment", audienceSegment);
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
    return NETWORK_CODE_AUDIENCE_SEGMENT.instantiate(
        "network_code", networkCode, "audience_segment", audienceSegment);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AudienceSegmentName that = ((AudienceSegmentName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.audienceSegment, that.audienceSegment);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(audienceSegment);
    return h;
  }

  /** Builder for networks/{network_code}/audienceSegments/{audience_segment}. */
  public static class Builder {
    private String networkCode;
    private String audienceSegment;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getAudienceSegment() {
      return audienceSegment;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setAudienceSegment(String audienceSegment) {
      this.audienceSegment = audienceSegment;
      return this;
    }

    private Builder(AudienceSegmentName audienceSegmentName) {
      this.networkCode = audienceSegmentName.networkCode;
      this.audienceSegment = audienceSegmentName.audienceSegment;
    }

    public AudienceSegmentName build() {
      return new AudienceSegmentName(this);
    }
  }
}
