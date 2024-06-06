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

package com.google.shopping.merchant.accounts.v1beta;

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
public class OnlineReturnPolicyName implements ResourceName {
  private static final PathTemplate ACCOUNT_RETURN_POLICY =
      PathTemplate.createWithoutUrlEncoding(
          "accounts/{account}/onlineReturnPolicies/{return_policy}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String returnPolicy;

  @Deprecated
  protected OnlineReturnPolicyName() {
    account = null;
    returnPolicy = null;
  }

  private OnlineReturnPolicyName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    returnPolicy = Preconditions.checkNotNull(builder.getReturnPolicy());
  }

  public String getAccount() {
    return account;
  }

  public String getReturnPolicy() {
    return returnPolicy;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static OnlineReturnPolicyName of(String account, String returnPolicy) {
    return newBuilder().setAccount(account).setReturnPolicy(returnPolicy).build();
  }

  public static String format(String account, String returnPolicy) {
    return newBuilder().setAccount(account).setReturnPolicy(returnPolicy).build().toString();
  }

  public static OnlineReturnPolicyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_RETURN_POLICY.validatedMatch(
            formattedString, "OnlineReturnPolicyName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("return_policy"));
  }

  public static List<OnlineReturnPolicyName> parseList(List<String> formattedStrings) {
    List<OnlineReturnPolicyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OnlineReturnPolicyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (OnlineReturnPolicyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_RETURN_POLICY.matches(formattedString);
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
          if (returnPolicy != null) {
            fieldMapBuilder.put("return_policy", returnPolicy);
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
    return ACCOUNT_RETURN_POLICY.instantiate("account", account, "return_policy", returnPolicy);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      OnlineReturnPolicyName that = ((OnlineReturnPolicyName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.returnPolicy, that.returnPolicy);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(returnPolicy);
    return h;
  }

  /** Builder for accounts/{account}/onlineReturnPolicies/{return_policy}. */
  public static class Builder {
    private String account;
    private String returnPolicy;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getReturnPolicy() {
      return returnPolicy;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setReturnPolicy(String returnPolicy) {
      this.returnPolicy = returnPolicy;
      return this;
    }

    private Builder(OnlineReturnPolicyName onlineReturnPolicyName) {
      this.account = onlineReturnPolicyName.account;
      this.returnPolicy = onlineReturnPolicyName.returnPolicy;
    }

    public OnlineReturnPolicyName build() {
      return new OnlineReturnPolicyName(this);
    }
  }
}
