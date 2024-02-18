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

package com.google.shopping.css.v1;

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
public class AccountLabelName implements ResourceName {
  private static final PathTemplate ACCOUNT_LABEL =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/labels/{label}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String label;

  @Deprecated
  protected AccountLabelName() {
    account = null;
    label = null;
  }

  private AccountLabelName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    label = Preconditions.checkNotNull(builder.getLabel());
  }

  public String getAccount() {
    return account;
  }

  public String getLabel() {
    return label;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AccountLabelName of(String account, String label) {
    return newBuilder().setAccount(account).setLabel(label).build();
  }

  public static String format(String account, String label) {
    return newBuilder().setAccount(account).setLabel(label).build().toString();
  }

  public static AccountLabelName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_LABEL.validatedMatch(
            formattedString, "AccountLabelName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("label"));
  }

  public static List<AccountLabelName> parseList(List<String> formattedStrings) {
    List<AccountLabelName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AccountLabelName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AccountLabelName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_LABEL.matches(formattedString);
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
          if (label != null) {
            fieldMapBuilder.put("label", label);
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
    return ACCOUNT_LABEL.instantiate("account", account, "label", label);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AccountLabelName that = ((AccountLabelName) o);
      return Objects.equals(this.account, that.account) && Objects.equals(this.label, that.label);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(label);
    return h;
  }

  /** Builder for accounts/{account}/labels/{label}. */
  public static class Builder {
    private String account;
    private String label;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getLabel() {
      return label;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setLabel(String label) {
      this.label = label;
      return this;
    }

    private Builder(AccountLabelName accountLabelName) {
      this.account = accountLabelName.account;
      this.label = accountLabelName.label;
    }

    public AccountLabelName build() {
      return new AccountLabelName(this);
    }
  }
}
