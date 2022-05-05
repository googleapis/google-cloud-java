/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.billing.budgets.v1;

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
public class BudgetName implements ResourceName {
  private static final PathTemplate BILLING_ACCOUNT_BUDGET =
      PathTemplate.createWithoutUrlEncoding("billingAccounts/{billing_account}/budgets/{budget}");
  private volatile Map<String, String> fieldValuesMap;
  private final String billingAccount;
  private final String budget;

  @Deprecated
  protected BudgetName() {
    billingAccount = null;
    budget = null;
  }

  private BudgetName(Builder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    budget = Preconditions.checkNotNull(builder.getBudget());
  }

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
        BILLING_ACCOUNT_BUDGET.validatedMatch(
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
    List<String> list = new ArrayList<>(values.size());
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
    return BILLING_ACCOUNT_BUDGET.matches(formattedString);
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
          if (budget != null) {
            fieldMapBuilder.put("budget", budget);
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
    return BILLING_ACCOUNT_BUDGET.instantiate("billing_account", billingAccount, "budget", budget);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      BudgetName that = ((BudgetName) o);
      return Objects.equals(this.billingAccount, that.billingAccount)
          && Objects.equals(this.budget, that.budget);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(billingAccount);
    h *= 1000003;
    h ^= Objects.hashCode(budget);
    return h;
  }

  /** Builder for billingAccounts/{billing_account}/budgets/{budget}. */
  public static class Builder {
    private String billingAccount;
    private String budget;

    protected Builder() {}

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

    private Builder(BudgetName budgetName) {
      this.billingAccount = budgetName.billingAccount;
      this.budget = budgetName.budget;
    }

    public BudgetName build() {
      return new BudgetName(this);
    }
  }
}
