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

package com.google.logging.v2;

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
public class BillingAccountName implements ResourceName {
  private static final PathTemplate BILLING_ACCOUNT =
      PathTemplate.createWithoutUrlEncoding("billingAccounts/{billing_account}");
  private volatile Map<String, String> fieldValuesMap;
  private final String billingAccount;

  @Deprecated
  protected BillingAccountName() {
    billingAccount = null;
  }

  private BillingAccountName(Builder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
  }

  public String getBillingAccount() {
    return billingAccount;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BillingAccountName of(String billingAccount) {
    return newBuilder().setBillingAccount(billingAccount).build();
  }

  public static String format(String billingAccount) {
    return newBuilder().setBillingAccount(billingAccount).build().toString();
  }

  public static BillingAccountName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        BILLING_ACCOUNT.validatedMatch(
            formattedString, "BillingAccountName.parse: formattedString not in valid format");
    return of(matchMap.get("billing_account"));
  }

  public static List<BillingAccountName> parseList(List<String> formattedStrings) {
    List<BillingAccountName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BillingAccountName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BillingAccountName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return BILLING_ACCOUNT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (billingAccount != null) {
            fieldMapBuilder.put("billing_account", billingAccount);
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
    return BILLING_ACCOUNT.instantiate("billing_account", billingAccount);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BillingAccountName that = ((BillingAccountName) o);
      return Objects.equals(this.billingAccount, that.billingAccount);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(billingAccount);
    return h;
  }

  /** Builder for billingAccounts/{billing_account}. */
  public static class Builder {
    private String billingAccount;

    protected Builder() {}

    public String getBillingAccount() {
      return billingAccount;
    }

    public Builder setBillingAccount(String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    private Builder(BillingAccountName billingAccountName) {
      this.billingAccount = billingAccountName.billingAccount;
    }

    public BillingAccountName build() {
      return new BillingAccountName(this);
    }
  }
}
