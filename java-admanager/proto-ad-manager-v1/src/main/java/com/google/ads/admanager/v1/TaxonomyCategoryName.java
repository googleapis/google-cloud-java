/*
 * Copyright 2024 Google LLC
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
public class TaxonomyCategoryName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_TAXONOMY_CATEGORY =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/taxonomyCategories/{taxonomy_category}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String taxonomyCategory;

  @Deprecated
  protected TaxonomyCategoryName() {
    networkCode = null;
    taxonomyCategory = null;
  }

  private TaxonomyCategoryName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    taxonomyCategory = Preconditions.checkNotNull(builder.getTaxonomyCategory());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getTaxonomyCategory() {
    return taxonomyCategory;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TaxonomyCategoryName of(String networkCode, String taxonomyCategory) {
    return newBuilder().setNetworkCode(networkCode).setTaxonomyCategory(taxonomyCategory).build();
  }

  public static String format(String networkCode, String taxonomyCategory) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setTaxonomyCategory(taxonomyCategory)
        .build()
        .toString();
  }

  public static TaxonomyCategoryName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_TAXONOMY_CATEGORY.validatedMatch(
            formattedString, "TaxonomyCategoryName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("taxonomy_category"));
  }

  public static List<TaxonomyCategoryName> parseList(List<String> formattedStrings) {
    List<TaxonomyCategoryName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TaxonomyCategoryName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TaxonomyCategoryName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_TAXONOMY_CATEGORY.matches(formattedString);
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
          if (taxonomyCategory != null) {
            fieldMapBuilder.put("taxonomy_category", taxonomyCategory);
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
    return NETWORK_CODE_TAXONOMY_CATEGORY.instantiate(
        "network_code", networkCode, "taxonomy_category", taxonomyCategory);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TaxonomyCategoryName that = ((TaxonomyCategoryName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.taxonomyCategory, that.taxonomyCategory);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(taxonomyCategory);
    return h;
  }

  /** Builder for networks/{network_code}/taxonomyCategories/{taxonomy_category}. */
  public static class Builder {
    private String networkCode;
    private String taxonomyCategory;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getTaxonomyCategory() {
      return taxonomyCategory;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setTaxonomyCategory(String taxonomyCategory) {
      this.taxonomyCategory = taxonomyCategory;
      return this;
    }

    private Builder(TaxonomyCategoryName taxonomyCategoryName) {
      this.networkCode = taxonomyCategoryName.networkCode;
      this.taxonomyCategory = taxonomyCategoryName.taxonomyCategory;
    }

    public TaxonomyCategoryName build() {
      return new TaxonomyCategoryName(this);
    }
  }
}
