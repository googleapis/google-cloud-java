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
public class CmsMetadataKeyName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_CMS_METADATA_KEY =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/cmsMetadataKeys/{cms_metadata_key}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String cmsMetadataKey;

  @Deprecated
  protected CmsMetadataKeyName() {
    networkCode = null;
    cmsMetadataKey = null;
  }

  private CmsMetadataKeyName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    cmsMetadataKey = Preconditions.checkNotNull(builder.getCmsMetadataKey());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getCmsMetadataKey() {
    return cmsMetadataKey;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CmsMetadataKeyName of(String networkCode, String cmsMetadataKey) {
    return newBuilder().setNetworkCode(networkCode).setCmsMetadataKey(cmsMetadataKey).build();
  }

  public static String format(String networkCode, String cmsMetadataKey) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setCmsMetadataKey(cmsMetadataKey)
        .build()
        .toString();
  }

  public static CmsMetadataKeyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_CMS_METADATA_KEY.validatedMatch(
            formattedString, "CmsMetadataKeyName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("cms_metadata_key"));
  }

  public static List<CmsMetadataKeyName> parseList(List<String> formattedStrings) {
    List<CmsMetadataKeyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CmsMetadataKeyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CmsMetadataKeyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_CMS_METADATA_KEY.matches(formattedString);
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
          if (cmsMetadataKey != null) {
            fieldMapBuilder.put("cms_metadata_key", cmsMetadataKey);
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
    return NETWORK_CODE_CMS_METADATA_KEY.instantiate(
        "network_code", networkCode, "cms_metadata_key", cmsMetadataKey);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CmsMetadataKeyName that = ((CmsMetadataKeyName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.cmsMetadataKey, that.cmsMetadataKey);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(cmsMetadataKey);
    return h;
  }

  /** Builder for networks/{network_code}/cmsMetadataKeys/{cms_metadata_key}. */
  public static class Builder {
    private String networkCode;
    private String cmsMetadataKey;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getCmsMetadataKey() {
      return cmsMetadataKey;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setCmsMetadataKey(String cmsMetadataKey) {
      this.cmsMetadataKey = cmsMetadataKey;
      return this;
    }

    private Builder(CmsMetadataKeyName cmsMetadataKeyName) {
      this.networkCode = cmsMetadataKeyName.networkCode;
      this.cmsMetadataKey = cmsMetadataKeyName.cmsMetadataKey;
    }

    public CmsMetadataKeyName build() {
      return new CmsMetadataKeyName(this);
    }
  }
}
