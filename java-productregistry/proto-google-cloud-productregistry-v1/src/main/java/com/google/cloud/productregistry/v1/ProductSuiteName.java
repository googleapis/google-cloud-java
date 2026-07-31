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
public class ProductSuiteName implements ResourceName {
  private static final PathTemplate PRODUCT_SUITE =
      PathTemplate.createWithoutUrlEncoding("productSuites/{product_suite}");
  private volatile Map<String, String> fieldValuesMap;
  private final String productSuite;

  @Deprecated
  protected ProductSuiteName() {
    productSuite = null;
  }

  private ProductSuiteName(Builder builder) {
    productSuite = Preconditions.checkNotNull(builder.getProductSuite());
  }

  public String getProductSuite() {
    return productSuite;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ProductSuiteName of(String productSuite) {
    return newBuilder().setProductSuite(productSuite).build();
  }

  public static String format(String productSuite) {
    return newBuilder().setProductSuite(productSuite).build().toString();
  }

  public static @Nullable ProductSuiteName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PRODUCT_SUITE.validatedMatch(
            formattedString, "ProductSuiteName.parse: formattedString not in valid format");
    return of(matchMap.get("product_suite"));
  }

  public static List<ProductSuiteName> parseList(List<String> formattedStrings) {
    List<ProductSuiteName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable ProductSuiteName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ProductSuiteName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PRODUCT_SUITE.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (productSuite != null) {
            fieldMapBuilder.put("product_suite", productSuite);
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
    return PRODUCT_SUITE.instantiate("product_suite", productSuite);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ProductSuiteName that = ((ProductSuiteName) o);
      return Objects.equals(this.productSuite, that.productSuite);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(productSuite);
    return h;
  }

  /** Builder for productSuites/{product_suite}. */
  public static class Builder {
    private String productSuite;

    protected Builder() {}

    public String getProductSuite() {
      return productSuite;
    }

    public Builder setProductSuite(String productSuite) {
      this.productSuite = productSuite;
      return this;
    }

    private Builder(ProductSuiteName productSuiteName) {
      this.productSuite = productSuiteName.productSuite;
    }

    public ProductSuiteName build() {
      return new ProductSuiteName(this);
    }
  }
}
