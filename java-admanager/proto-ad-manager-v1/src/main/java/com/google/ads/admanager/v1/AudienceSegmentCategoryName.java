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
public class AudienceSegmentCategoryName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_AUDIENCE_SEGMENT_CATEGORY =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/audienceSegmentCategories/{audience_segment_category}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String audienceSegmentCategory;

  @Deprecated
  protected AudienceSegmentCategoryName() {
    networkCode = null;
    audienceSegmentCategory = null;
  }

  private AudienceSegmentCategoryName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    audienceSegmentCategory = Preconditions.checkNotNull(builder.getAudienceSegmentCategory());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getAudienceSegmentCategory() {
    return audienceSegmentCategory;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AudienceSegmentCategoryName of(String networkCode, String audienceSegmentCategory) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setAudienceSegmentCategory(audienceSegmentCategory)
        .build();
  }

  public static String format(String networkCode, String audienceSegmentCategory) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setAudienceSegmentCategory(audienceSegmentCategory)
        .build()
        .toString();
  }

  public static @Nullable AudienceSegmentCategoryName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_AUDIENCE_SEGMENT_CATEGORY.validatedMatch(
            formattedString,
            "AudienceSegmentCategoryName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("audience_segment_category"));
  }

  public static List<AudienceSegmentCategoryName> parseList(List<String> formattedStrings) {
    List<AudienceSegmentCategoryName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable AudienceSegmentCategoryName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AudienceSegmentCategoryName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_AUDIENCE_SEGMENT_CATEGORY.matches(formattedString);
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
          if (audienceSegmentCategory != null) {
            fieldMapBuilder.put("audience_segment_category", audienceSegmentCategory);
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
    return NETWORK_CODE_AUDIENCE_SEGMENT_CATEGORY.instantiate(
        "network_code", networkCode, "audience_segment_category", audienceSegmentCategory);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AudienceSegmentCategoryName that = ((AudienceSegmentCategoryName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.audienceSegmentCategory, that.audienceSegmentCategory);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(audienceSegmentCategory);
    return h;
  }

  /** Builder for networks/{network_code}/audienceSegmentCategories/{audience_segment_category}. */
  public static class Builder {
    private String networkCode;
    private String audienceSegmentCategory;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getAudienceSegmentCategory() {
      return audienceSegmentCategory;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setAudienceSegmentCategory(String audienceSegmentCategory) {
      this.audienceSegmentCategory = audienceSegmentCategory;
      return this;
    }

    private Builder(AudienceSegmentCategoryName audienceSegmentCategoryName) {
      this.networkCode = audienceSegmentCategoryName.networkCode;
      this.audienceSegmentCategory = audienceSegmentCategoryName.audienceSegmentCategory;
    }

    public AudienceSegmentCategoryName build() {
      return new AudienceSegmentCategoryName(this);
    }
  }
}
