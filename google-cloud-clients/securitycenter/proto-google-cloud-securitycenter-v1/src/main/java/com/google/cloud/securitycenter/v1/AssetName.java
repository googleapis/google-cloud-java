/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.securitycenter.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class AssetName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/assets/{asset}");

  private volatile Map<String, String> fieldValuesMap;

  private final String organization;
  private final String asset;

  public String getOrganization() {
    return organization;
  }

  public String getAsset() {
    return asset;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private AssetName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    asset = Preconditions.checkNotNull(builder.getAsset());
  }

  public static AssetName of(String organization, String asset) {
    return newBuilder().setOrganization(organization).setAsset(asset).build();
  }

  public static String format(String organization, String asset) {
    return newBuilder().setOrganization(organization).setAsset(asset).build().toString();
  }

  public static AssetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "AssetName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("asset"));
  }

  public static List<AssetName> parseList(List<String> formattedStrings) {
    List<AssetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AssetName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (AssetName value : values) {
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
          fieldMapBuilder.put("organization", organization);
          fieldMapBuilder.put("asset", asset);
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
    return PATH_TEMPLATE.instantiate("organization", organization, "asset", asset);
  }

  /** Builder for AssetName. */
  public static class Builder {

    private String organization;
    private String asset;

    public String getOrganization() {
      return organization;
    }

    public String getAsset() {
      return asset;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setAsset(String asset) {
      this.asset = asset;
      return this;
    }

    private Builder() {}

    private Builder(AssetName assetName) {
      organization = assetName.organization;
      asset = assetName.asset;
    }

    public AssetName build() {
      return new AssetName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AssetName) {
      AssetName that = (AssetName) o;
      return (this.organization.equals(that.organization)) && (this.asset.equals(that.asset));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= organization.hashCode();
    h *= 1000003;
    h ^= asset.hashCode();
    return h;
  }
}
