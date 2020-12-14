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

package com.google.cloud.billing.v1;

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
public class SkuName implements ResourceName {
  private static final PathTemplate SERVICE_SKU =
      PathTemplate.createWithoutUrlEncoding("services/{service}/skus/{sku}");
  private volatile Map<String, String> fieldValuesMap;
  private final String service;
  private final String sku;

  @Deprecated
  protected SkuName() {
    service = null;
    sku = null;
  }

  private SkuName(Builder builder) {
    service = Preconditions.checkNotNull(builder.getService());
    sku = Preconditions.checkNotNull(builder.getSku());
  }

  public String getService() {
    return service;
  }

  public String getSku() {
    return sku;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SkuName of(String service, String sku) {
    return newBuilder().setService(service).setSku(sku).build();
  }

  public static String format(String service, String sku) {
    return newBuilder().setService(service).setSku(sku).build().toString();
  }

  public static SkuName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        SERVICE_SKU.validatedMatch(
            formattedString, "SkuName.parse: formattedString not in valid format");
    return of(matchMap.get("service"), matchMap.get("sku"));
  }

  public static List<SkuName> parseList(List<String> formattedStrings) {
    List<SkuName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SkuName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SkuName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return SERVICE_SKU.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (service != null) {
            fieldMapBuilder.put("service", service);
          }
          if (sku != null) {
            fieldMapBuilder.put("sku", sku);
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
    return SERVICE_SKU.instantiate("service", service, "sku", sku);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      SkuName that = ((SkuName) o);
      return Objects.equals(this.service, that.service) && Objects.equals(this.sku, that.sku);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(service);
    h *= 1000003;
    h ^= Objects.hashCode(sku);
    return h;
  }

  /** Builder for services/{service}/skus/{sku}. */
  public static class Builder {
    private String service;
    private String sku;

    protected Builder() {}

    public String getService() {
      return service;
    }

    public String getSku() {
      return sku;
    }

    public Builder setService(String service) {
      this.service = service;
      return this;
    }

    public Builder setSku(String sku) {
      this.sku = sku;
      return this;
    }

    private Builder(SkuName skuName) {
      service = skuName.service;
      sku = skuName.sku;
    }

    public SkuName build() {
      return new SkuName(this);
    }
  }
}
