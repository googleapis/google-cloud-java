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
public class RichMediaAdsCompanyName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_RICH_MEDIA_ADS_COMPANY =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/richMediaAdsCompanies/{rich_media_ads_company}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String richMediaAdsCompany;

  @Deprecated
  protected RichMediaAdsCompanyName() {
    networkCode = null;
    richMediaAdsCompany = null;
  }

  private RichMediaAdsCompanyName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    richMediaAdsCompany = Preconditions.checkNotNull(builder.getRichMediaAdsCompany());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getRichMediaAdsCompany() {
    return richMediaAdsCompany;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RichMediaAdsCompanyName of(String networkCode, String richMediaAdsCompany) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setRichMediaAdsCompany(richMediaAdsCompany)
        .build();
  }

  public static String format(String networkCode, String richMediaAdsCompany) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setRichMediaAdsCompany(richMediaAdsCompany)
        .build()
        .toString();
  }

  public static @Nullable RichMediaAdsCompanyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_RICH_MEDIA_ADS_COMPANY.validatedMatch(
            formattedString, "RichMediaAdsCompanyName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("rich_media_ads_company"));
  }

  public static List<RichMediaAdsCompanyName> parseList(List<String> formattedStrings) {
    List<RichMediaAdsCompanyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable RichMediaAdsCompanyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RichMediaAdsCompanyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_RICH_MEDIA_ADS_COMPANY.matches(formattedString);
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
          if (richMediaAdsCompany != null) {
            fieldMapBuilder.put("rich_media_ads_company", richMediaAdsCompany);
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
    return NETWORK_CODE_RICH_MEDIA_ADS_COMPANY.instantiate(
        "network_code", networkCode, "rich_media_ads_company", richMediaAdsCompany);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RichMediaAdsCompanyName that = ((RichMediaAdsCompanyName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.richMediaAdsCompany, that.richMediaAdsCompany);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(richMediaAdsCompany);
    return h;
  }

  /** Builder for networks/{network_code}/richMediaAdsCompanies/{rich_media_ads_company}. */
  public static class Builder {
    private String networkCode;
    private String richMediaAdsCompany;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getRichMediaAdsCompany() {
      return richMediaAdsCompany;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setRichMediaAdsCompany(String richMediaAdsCompany) {
      this.richMediaAdsCompany = richMediaAdsCompany;
      return this;
    }

    private Builder(RichMediaAdsCompanyName richMediaAdsCompanyName) {
      this.networkCode = richMediaAdsCompanyName.networkCode;
      this.richMediaAdsCompany = richMediaAdsCompanyName.richMediaAdsCompany;
    }

    public RichMediaAdsCompanyName build() {
      return new RichMediaAdsCompanyName(this);
    }
  }
}
