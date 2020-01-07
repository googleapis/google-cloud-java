/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.billing.budgets.v1beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class BudgetName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("billingAccounts/{billing_account}/budgets/{budget}");

  private volatile Map<String, String> fieldValuesMap;

  private final String billingAccount;
  private final String budget;

  public String getBillingAccount() {
    return billingAccount;
  }

  public String getBudget() {
    return budget;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private BudgetName(Builder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    budget = Preconditions.checkNotNull(builder.getBudget());
  }

  public static BudgetName of(String billingAccount, String budget) {
    return newBuilder().setBillingAccount(billingAccount).setBudget(budget).build();
  }

  public static String format(String billingAccount, String budget) {
    return newBuilder().setBillingAccount(billingAccount).setBudget(budget).build().toString();
  }

  public static BudgetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "BudgetName.parse: formattedString not in valid format");
    return of(matchMap.get("billing_account"), matchMap.get("budget"));
  }

  public static List<BudgetName> parseList(List<String> formattedStrings) {
    List<BudgetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BudgetName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (BudgetName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("billingAccount", billingAccount);
          fieldMapBuilder.put("budget", budget);
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
    return PATH_TEMPLATE.instantiate("billing_account", billingAccount, "budget", budget);
  }

  /** Builder for BudgetName. */
  public static class Builder {

    private String billingAccount;
    private String budget;

    public String getBillingAccount() {
      return billingAccount;
    }

    public String getBudget() {
      return budget;
    }

    public Builder setBillingAccount(String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    public Builder setBudget(String budget) {
      this.budget = budget;
      return this;
    }

    private Builder() {}

    private Builder(BudgetName budgetName) {
      billingAccount = budgetName.billingAccount;
      budget = budgetName.budget;
    }

    public BudgetName build() {
      return new BudgetName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BudgetName) {
      BudgetName that = (BudgetName) o;
      return (this.billingAccount.equals(that.billingAccount)) && (this.budget.equals(that.budget));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= billingAccount.hashCode();
    h *= 1000003;
    h ^= budget.hashCode();
    return h;
  }
}
