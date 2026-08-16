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

package com.google.cloud.productregistry.v1;

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
public class LogicalProductVariantName implements ResourceName {
  private static final PathTemplate LOGICAL_PRODUCT_VARIANT =
      PathTemplate.createWithoutUrlEncoding("logicalProducts/{logical_product}/variants/{variant}");
  private volatile Map<String, String> fieldValuesMap;
  private final String logicalProduct;
  private final String variant;

  @Deprecated
  protected LogicalProductVariantName() {
    logicalProduct = null;
    variant = null;
  }

  private LogicalProductVariantName(Builder builder) {
    logicalProduct = Preconditions.checkNotNull(builder.getLogicalProduct());
    variant = Preconditions.checkNotNull(builder.getVariant());
  }

  public String getLogicalProduct() {
    return logicalProduct;
  }

  public String getVariant() {
    return variant;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LogicalProductVariantName of(String logicalProduct, String variant) {
    return newBuilder().setLogicalProduct(logicalProduct).setVariant(variant).build();
  }

  public static String format(String logicalProduct, String variant) {
    return newBuilder().setLogicalProduct(logicalProduct).setVariant(variant).build().toString();
  }

  public static @Nullable LogicalProductVariantName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        LOGICAL_PRODUCT_VARIANT.validatedMatch(
            formattedString,
            "LogicalProductVariantName.parse: formattedString not in valid format");
    return of(matchMap.get("logical_product"), matchMap.get("variant"));
  }

  public static List<LogicalProductVariantName> parseList(List<String> formattedStrings) {
    List<LogicalProductVariantName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable LogicalProductVariantName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LogicalProductVariantName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return LOGICAL_PRODUCT_VARIANT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (logicalProduct != null) {
            fieldMapBuilder.put("logical_product", logicalProduct);
          }
          if (variant != null) {
            fieldMapBuilder.put("variant", variant);
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
    return LOGICAL_PRODUCT_VARIANT.instantiate(
        "logical_product", logicalProduct, "variant", variant);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      LogicalProductVariantName that = ((LogicalProductVariantName) o);
      return Objects.equals(this.logicalProduct, that.logicalProduct)
          && Objects.equals(this.variant, that.variant);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(logicalProduct);
    h *= 1000003;
    h ^= Objects.hashCode(variant);
    return h;
  }

  /** Builder for logicalProducts/{logical_product}/variants/{variant}. */
  public static class Builder {
    private String logicalProduct;
    private String variant;

    protected Builder() {}

    public String getLogicalProduct() {
      return logicalProduct;
    }

    public String getVariant() {
      return variant;
    }

    public Builder setLogicalProduct(String logicalProduct) {
      this.logicalProduct = logicalProduct;
      return this;
    }

    public Builder setVariant(String variant) {
      this.variant = variant;
      return this;
    }

    private Builder(LogicalProductVariantName logicalProductVariantName) {
      this.logicalProduct = logicalProductVariantName.logicalProduct;
      this.variant = logicalProductVariantName.variant;
    }

    public LogicalProductVariantName build() {
      return new LogicalProductVariantName(this);
    }
  }
}
