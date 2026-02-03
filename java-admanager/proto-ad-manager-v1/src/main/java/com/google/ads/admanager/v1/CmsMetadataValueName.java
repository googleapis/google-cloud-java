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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class CmsMetadataValueName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_CMS_METADATA_VALUE =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/cmsMetadataValues/{cms_metadata_value}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String cmsMetadataValue;

  @Deprecated
  protected CmsMetadataValueName() {
    networkCode = null;
    cmsMetadataValue = null;
  }

  private CmsMetadataValueName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    cmsMetadataValue = Preconditions.checkNotNull(builder.getCmsMetadataValue());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getCmsMetadataValue() {
    return cmsMetadataValue;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CmsMetadataValueName of(String networkCode, String cmsMetadataValue) {
    return newBuilder().setNetworkCode(networkCode).setCmsMetadataValue(cmsMetadataValue).build();
  }

  public static String format(String networkCode, String cmsMetadataValue) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setCmsMetadataValue(cmsMetadataValue)
        .build()
        .toString();
  }

  public static CmsMetadataValueName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_CMS_METADATA_VALUE.validatedMatch(
            formattedString, "CmsMetadataValueName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("cms_metadata_value"));
  }

  public static List<CmsMetadataValueName> parseList(List<String> formattedStrings) {
    List<CmsMetadataValueName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CmsMetadataValueName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CmsMetadataValueName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_CMS_METADATA_VALUE.matches(formattedString);
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
          if (cmsMetadataValue != null) {
            fieldMapBuilder.put("cms_metadata_value", cmsMetadataValue);
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
    return NETWORK_CODE_CMS_METADATA_VALUE.instantiate(
        "network_code", networkCode, "cms_metadata_value", cmsMetadataValue);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CmsMetadataValueName that = ((CmsMetadataValueName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.cmsMetadataValue, that.cmsMetadataValue);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(cmsMetadataValue);
    return h;
  }

  /** Builder for networks/{network_code}/cmsMetadataValues/{cms_metadata_value}. */
  public static class Builder {
    private String networkCode;
    private String cmsMetadataValue;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getCmsMetadataValue() {
      return cmsMetadataValue;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setCmsMetadataValue(String cmsMetadataValue) {
      this.cmsMetadataValue = cmsMetadataValue;
      return this;
    }

    private Builder(CmsMetadataValueName cmsMetadataValueName) {
      this.networkCode = cmsMetadataValueName.networkCode;
      this.cmsMetadataValue = cmsMetadataValueName.cmsMetadataValue;
    }

    public CmsMetadataValueName build() {
      return new CmsMetadataValueName(this);
    }
  }
}
