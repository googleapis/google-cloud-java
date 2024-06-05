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
public class UserName implements ResourceName {
  private static final PathTemplate ACCOUNT_EMAIL =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/users/{email}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String email;

  @Deprecated
  protected UserName() {
    account = null;
    email = null;
  }

  private UserName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    email = Preconditions.checkNotNull(builder.getEmail());
  }

  public String getAccount() {
    return account;
  }

  public String getEmail() {
    return email;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static UserName of(String account, String email) {
    return newBuilder().setAccount(account).setEmail(email).build();
  }

  public static String format(String account, String email) {
    return newBuilder().setAccount(account).setEmail(email).build().toString();
  }

  public static UserName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_EMAIL.validatedMatch(
            formattedString, "UserName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("email"));
  }

  public static List<UserName> parseList(List<String> formattedStrings) {
    List<UserName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<UserName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (UserName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_EMAIL.matches(formattedString);
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
          if (email != null) {
            fieldMapBuilder.put("email", email);
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
    return ACCOUNT_EMAIL.instantiate("account", account, "email", email);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      UserName that = ((UserName) o);
      return Objects.equals(this.account, that.account) && Objects.equals(this.email, that.email);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(email);
    return h;
  }

  /** Builder for accounts/{account}/users/{email}. */
  public static class Builder {
    private String account;
    private String email;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getEmail() {
      return email;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setEmail(String email) {
      this.email = email;
      return this;
    }

    private Builder(UserName userName) {
      this.account = userName.account;
      this.email = userName.email;
    }

    public UserName build() {
      return new UserName(this);
    }
  }
}
