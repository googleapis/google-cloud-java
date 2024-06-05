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

package com.google.shopping.merchant.promotions.v1beta;

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
public class PromotionName implements ResourceName {
  private static final PathTemplate ACCOUNT_PROMOTION =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/promotions/{promotion}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String promotion;

  @Deprecated
  protected PromotionName() {
    account = null;
    promotion = null;
  }

  private PromotionName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    promotion = Preconditions.checkNotNull(builder.getPromotion());
  }

  public String getAccount() {
    return account;
  }

  public String getPromotion() {
    return promotion;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PromotionName of(String account, String promotion) {
    return newBuilder().setAccount(account).setPromotion(promotion).build();
  }

  public static String format(String account, String promotion) {
    return newBuilder().setAccount(account).setPromotion(promotion).build().toString();
  }

  public static PromotionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_PROMOTION.validatedMatch(
            formattedString, "PromotionName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("promotion"));
  }

  public static List<PromotionName> parseList(List<String> formattedStrings) {
    List<PromotionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PromotionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PromotionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_PROMOTION.matches(formattedString);
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
          if (promotion != null) {
            fieldMapBuilder.put("promotion", promotion);
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
    return ACCOUNT_PROMOTION.instantiate("account", account, "promotion", promotion);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PromotionName that = ((PromotionName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.promotion, that.promotion);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(promotion);
    return h;
  }

  /** Builder for accounts/{account}/promotions/{promotion}. */
  public static class Builder {
    private String account;
    private String promotion;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getPromotion() {
      return promotion;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setPromotion(String promotion) {
      this.promotion = promotion;
      return this;
    }

    private Builder(PromotionName promotionName) {
      this.account = promotionName.account;
      this.promotion = promotionName.promotion;
    }

    public PromotionName build() {
      return new PromotionName(this);
    }
  }
}
