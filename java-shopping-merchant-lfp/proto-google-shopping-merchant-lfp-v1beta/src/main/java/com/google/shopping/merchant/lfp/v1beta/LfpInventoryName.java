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

package com.google.shopping.merchant.lfp.v1beta;

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
public class LfpInventoryName implements ResourceName {
  private static final PathTemplate ACCOUNT_TARGET_MERCHANT_STORE_CODE_OFFER =
      PathTemplate.createWithoutUrlEncoding(
          "accounts/{account}/lfpInventories/{target_merchant}~{store_code}~{offer}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String targetMerchant;
  private final String storeCode;
  private final String offer;

  @Deprecated
  protected LfpInventoryName() {
    account = null;
    targetMerchant = null;
    storeCode = null;
    offer = null;
  }

  private LfpInventoryName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    targetMerchant = Preconditions.checkNotNull(builder.getTargetMerchant());
    storeCode = Preconditions.checkNotNull(builder.getStoreCode());
    offer = Preconditions.checkNotNull(builder.getOffer());
  }

  public String getAccount() {
    return account;
  }

  public String getTargetMerchant() {
    return targetMerchant;
  }

  public String getStoreCode() {
    return storeCode;
  }

  public String getOffer() {
    return offer;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LfpInventoryName of(
      String account, String targetMerchant, String storeCode, String offer) {
    return newBuilder()
        .setAccount(account)
        .setTargetMerchant(targetMerchant)
        .setStoreCode(storeCode)
        .setOffer(offer)
        .build();
  }

  public static String format(
      String account, String targetMerchant, String storeCode, String offer) {
    return newBuilder()
        .setAccount(account)
        .setTargetMerchant(targetMerchant)
        .setStoreCode(storeCode)
        .setOffer(offer)
        .build()
        .toString();
  }

  public static LfpInventoryName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_TARGET_MERCHANT_STORE_CODE_OFFER.validatedMatch(
            formattedString, "LfpInventoryName.parse: formattedString not in valid format");
    return of(
        matchMap.get("account"),
        matchMap.get("target_merchant"),
        matchMap.get("store_code"),
        matchMap.get("offer"));
  }

  public static List<LfpInventoryName> parseList(List<String> formattedStrings) {
    List<LfpInventoryName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LfpInventoryName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LfpInventoryName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_TARGET_MERCHANT_STORE_CODE_OFFER.matches(formattedString);
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
          if (targetMerchant != null) {
            fieldMapBuilder.put("target_merchant", targetMerchant);
          }
          if (storeCode != null) {
            fieldMapBuilder.put("store_code", storeCode);
          }
          if (offer != null) {
            fieldMapBuilder.put("offer", offer);
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
    return ACCOUNT_TARGET_MERCHANT_STORE_CODE_OFFER.instantiate(
        "account",
        account,
        "target_merchant",
        targetMerchant,
        "store_code",
        storeCode,
        "offer",
        offer);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      LfpInventoryName that = ((LfpInventoryName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.targetMerchant, that.targetMerchant)
          && Objects.equals(this.storeCode, that.storeCode)
          && Objects.equals(this.offer, that.offer);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(targetMerchant);
    h *= 1000003;
    h ^= Objects.hashCode(storeCode);
    h *= 1000003;
    h ^= Objects.hashCode(offer);
    return h;
  }

  /** Builder for accounts/{account}/lfpInventories/{target_merchant}~{store_code}~{offer}. */
  public static class Builder {
    private String account;
    private String targetMerchant;
    private String storeCode;
    private String offer;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getTargetMerchant() {
      return targetMerchant;
    }

    public String getStoreCode() {
      return storeCode;
    }

    public String getOffer() {
      return offer;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setTargetMerchant(String targetMerchant) {
      this.targetMerchant = targetMerchant;
      return this;
    }

    public Builder setStoreCode(String storeCode) {
      this.storeCode = storeCode;
      return this;
    }

    public Builder setOffer(String offer) {
      this.offer = offer;
      return this;
    }

    private Builder(LfpInventoryName lfpInventoryName) {
      this.account = lfpInventoryName.account;
      this.targetMerchant = lfpInventoryName.targetMerchant;
      this.storeCode = lfpInventoryName.storeCode;
      this.offer = lfpInventoryName.offer;
    }

    public LfpInventoryName build() {
      return new LfpInventoryName(this);
    }
  }
}
