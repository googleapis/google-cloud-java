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
public class LfpMerchantStateName implements ResourceName {
  private static final PathTemplate ACCOUNT_LFP_MERCHANT_STATE =
      PathTemplate.createWithoutUrlEncoding(
          "accounts/{account}/lfpMerchantStates/{lfp_merchant_state}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String lfpMerchantState;

  @Deprecated
  protected LfpMerchantStateName() {
    account = null;
    lfpMerchantState = null;
  }

  private LfpMerchantStateName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    lfpMerchantState = Preconditions.checkNotNull(builder.getLfpMerchantState());
  }

  public String getAccount() {
    return account;
  }

  public String getLfpMerchantState() {
    return lfpMerchantState;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LfpMerchantStateName of(String account, String lfpMerchantState) {
    return newBuilder().setAccount(account).setLfpMerchantState(lfpMerchantState).build();
  }

  public static String format(String account, String lfpMerchantState) {
    return newBuilder()
        .setAccount(account)
        .setLfpMerchantState(lfpMerchantState)
        .build()
        .toString();
  }

  public static LfpMerchantStateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_LFP_MERCHANT_STATE.validatedMatch(
            formattedString, "LfpMerchantStateName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("lfp_merchant_state"));
  }

  public static List<LfpMerchantStateName> parseList(List<String> formattedStrings) {
    List<LfpMerchantStateName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LfpMerchantStateName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LfpMerchantStateName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_LFP_MERCHANT_STATE.matches(formattedString);
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
          if (lfpMerchantState != null) {
            fieldMapBuilder.put("lfp_merchant_state", lfpMerchantState);
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
    return ACCOUNT_LFP_MERCHANT_STATE.instantiate(
        "account", account, "lfp_merchant_state", lfpMerchantState);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      LfpMerchantStateName that = ((LfpMerchantStateName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.lfpMerchantState, that.lfpMerchantState);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(lfpMerchantState);
    return h;
  }

  /** Builder for accounts/{account}/lfpMerchantStates/{lfp_merchant_state}. */
  public static class Builder {
    private String account;
    private String lfpMerchantState;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getLfpMerchantState() {
      return lfpMerchantState;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setLfpMerchantState(String lfpMerchantState) {
      this.lfpMerchantState = lfpMerchantState;
      return this;
    }

    private Builder(LfpMerchantStateName lfpMerchantStateName) {
      this.account = lfpMerchantStateName.account;
      this.lfpMerchantState = lfpMerchantStateName.lfpMerchantState;
    }

    public LfpMerchantStateName build() {
      return new LfpMerchantStateName(this);
    }
  }
}
