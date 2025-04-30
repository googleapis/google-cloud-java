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
public class QuotaGroupName implements ResourceName {
  private static final PathTemplate ACCOUNT_QUOTA_GROUP =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/quotaGroups/{quota_group}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String quotaGroup;

  @Deprecated
  protected QuotaGroupName() {
    account = null;
    quotaGroup = null;
  }

  private QuotaGroupName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    quotaGroup = Preconditions.checkNotNull(builder.getQuotaGroup());
  }

  public String getAccount() {
    return account;
  }

  public String getQuotaGroup() {
    return quotaGroup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static QuotaGroupName of(String account, String quotaGroup) {
    return newBuilder().setAccount(account).setQuotaGroup(quotaGroup).build();
  }

  public static String format(String account, String quotaGroup) {
    return newBuilder().setAccount(account).setQuotaGroup(quotaGroup).build().toString();
  }

  public static QuotaGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_QUOTA_GROUP.validatedMatch(
            formattedString, "QuotaGroupName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("quota_group"));
  }

  public static List<QuotaGroupName> parseList(List<String> formattedStrings) {
    List<QuotaGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<QuotaGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (QuotaGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_QUOTA_GROUP.matches(formattedString);
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
          if (quotaGroup != null) {
            fieldMapBuilder.put("quota_group", quotaGroup);
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
    return ACCOUNT_QUOTA_GROUP.instantiate("account", account, "quota_group", quotaGroup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      QuotaGroupName that = ((QuotaGroupName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.quotaGroup, that.quotaGroup);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(quotaGroup);
    return h;
  }

  /** Builder for accounts/{account}/quotaGroups/{quota_group}. */
  public static class Builder {
    private String account;
    private String quotaGroup;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getQuotaGroup() {
      return quotaGroup;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setQuotaGroup(String quotaGroup) {
      this.quotaGroup = quotaGroup;
      return this;
    }

    private Builder(QuotaGroupName quotaGroupName) {
      this.account = quotaGroupName.account;
      this.quotaGroup = quotaGroupName.quotaGroup;
    }

    public QuotaGroupName build() {
      return new QuotaGroupName(this);
    }
  }
}
