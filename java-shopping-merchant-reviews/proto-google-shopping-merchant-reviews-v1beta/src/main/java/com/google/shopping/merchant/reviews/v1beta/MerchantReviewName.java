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
public class MerchantReviewName implements ResourceName {
  private static final PathTemplate ACCOUNT_NAME =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/merchantReviews/{name}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String name;

  @Deprecated
  protected MerchantReviewName() {
    account = null;
    name = null;
  }

  private MerchantReviewName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    name = Preconditions.checkNotNull(builder.getName());
  }

  public String getAccount() {
    return account;
  }

  public String getName() {
    return name;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MerchantReviewName of(String account, String name) {
    return newBuilder().setAccount(account).setName(name).build();
  }

  public static String format(String account, String name) {
    return newBuilder().setAccount(account).setName(name).build().toString();
  }

  public static MerchantReviewName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_NAME.validatedMatch(
            formattedString, "MerchantReviewName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("name"));
  }

  public static List<MerchantReviewName> parseList(List<String> formattedStrings) {
    List<MerchantReviewName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MerchantReviewName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MerchantReviewName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_NAME.matches(formattedString);
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
          if (name != null) {
            fieldMapBuilder.put("name", name);
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
    return ACCOUNT_NAME.instantiate("account", account, "name", name);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MerchantReviewName that = ((MerchantReviewName) o);
      return Objects.equals(this.account, that.account) && Objects.equals(this.name, that.name);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(name);
    return h;
  }

  /** Builder for accounts/{account}/merchantReviews/{name}. */
  public static class Builder {
    private String account;
    private String name;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getName() {
      return name;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    private Builder(MerchantReviewName merchantReviewName) {
      this.account = merchantReviewName.account;
      this.name = merchantReviewName.name;
    }

    public MerchantReviewName build() {
      return new MerchantReviewName(this);
    }
  }
}
