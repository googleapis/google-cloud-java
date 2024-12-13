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

package com.google.shopping.merchant.reviews.v1beta;

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
public class ProductReviewName implements ResourceName {
  private static final PathTemplate ACCOUNT_PRODUCTREVIEW =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/productReviews/{productreview}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String productreview;

  @Deprecated
  protected ProductReviewName() {
    account = null;
    productreview = null;
  }

  private ProductReviewName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    productreview = Preconditions.checkNotNull(builder.getProductreview());
  }

  public String getAccount() {
    return account;
  }

  public String getProductreview() {
    return productreview;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ProductReviewName of(String account, String productreview) {
    return newBuilder().setAccount(account).setProductreview(productreview).build();
  }

  public static String format(String account, String productreview) {
    return newBuilder().setAccount(account).setProductreview(productreview).build().toString();
  }

  public static ProductReviewName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_PRODUCTREVIEW.validatedMatch(
            formattedString, "ProductReviewName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("productreview"));
  }

  public static List<ProductReviewName> parseList(List<String> formattedStrings) {
    List<ProductReviewName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProductReviewName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ProductReviewName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_PRODUCTREVIEW.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (account != null) {
            fieldMapBuilder.put("account", account);
          }
          if (productreview != null) {
            fieldMapBuilder.put("productreview", productreview);
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
    return ACCOUNT_PRODUCTREVIEW.instantiate("account", account, "productreview", productreview);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ProductReviewName that = ((ProductReviewName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.productreview, that.productreview);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(productreview);
    return h;
  }

  /** Builder for accounts/{account}/productReviews/{productreview}. */
  public static class Builder {
    private String account;
    private String productreview;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getProductreview() {
      return productreview;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setProductreview(String productreview) {
      this.productreview = productreview;
      return this;
    }

    private Builder(ProductReviewName productReviewName) {
      this.account = productReviewName.account;
      this.productreview = productReviewName.productreview;
    }

    public ProductReviewName build() {
      return new ProductReviewName(this);
    }
  }
}
