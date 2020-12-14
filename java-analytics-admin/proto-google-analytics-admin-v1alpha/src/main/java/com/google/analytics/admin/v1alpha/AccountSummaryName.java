/*
 * Copyright 2020 Google LLC
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

package com.google.analytics.admin.v1alpha;

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
public class AccountSummaryName implements ResourceName {
  private static final PathTemplate ACCOUNT_SUMMARY =
      PathTemplate.createWithoutUrlEncoding("accountSummaries/{account_summary}");
  private volatile Map<String, String> fieldValuesMap;
  private final String accountSummary;

  @Deprecated
  protected AccountSummaryName() {
    accountSummary = null;
  }

  private AccountSummaryName(Builder builder) {
    accountSummary = Preconditions.checkNotNull(builder.getAccountSummary());
  }

  public String getAccountSummary() {
    return accountSummary;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AccountSummaryName of(String accountSummary) {
    return newBuilder().setAccountSummary(accountSummary).build();
  }

  public static String format(String accountSummary) {
    return newBuilder().setAccountSummary(accountSummary).build().toString();
  }

  public static AccountSummaryName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_SUMMARY.validatedMatch(
            formattedString, "AccountSummaryName.parse: formattedString not in valid format");
    return of(matchMap.get("account_summary"));
  }

  public static List<AccountSummaryName> parseList(List<String> formattedStrings) {
    List<AccountSummaryName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AccountSummaryName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AccountSummaryName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_SUMMARY.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (accountSummary != null) {
            fieldMapBuilder.put("account_summary", accountSummary);
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
    return ACCOUNT_SUMMARY.instantiate("account_summary", accountSummary);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      AccountSummaryName that = ((AccountSummaryName) o);
      return Objects.equals(this.accountSummary, that.accountSummary);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(accountSummary);
    return h;
  }

  /** Builder for accountSummaries/{account_summary}. */
  public static class Builder {
    private String accountSummary;

    protected Builder() {}

    public String getAccountSummary() {
      return accountSummary;
    }

    public Builder setAccountSummary(String accountSummary) {
      this.accountSummary = accountSummary;
      return this;
    }

    private Builder(AccountSummaryName accountSummaryName) {
      accountSummary = accountSummaryName.accountSummary;
    }

    public AccountSummaryName build() {
      return new AccountSummaryName(this);
    }
  }
}
