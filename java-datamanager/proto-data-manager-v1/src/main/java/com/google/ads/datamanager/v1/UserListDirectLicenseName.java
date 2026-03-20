/*
 * Copyright 2026 Google LLC
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

package com.google.ads.datamanager.v1;

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
public class UserListDirectLicenseName implements ResourceName {
  private static final PathTemplate ACCOUNT_TYPE_ACCOUNT_USER_LIST_DIRECT_LICENSE =
      PathTemplate.createWithoutUrlEncoding(
          "accountTypes/{account_type}/accounts/{account}/userListDirectLicenses/{user_list_direct_license}");
  private volatile Map<String, String> fieldValuesMap;
  private final String accountType;
  private final String account;
  private final String userListDirectLicense;

  @Deprecated
  protected UserListDirectLicenseName() {
    accountType = null;
    account = null;
    userListDirectLicense = null;
  }

  private UserListDirectLicenseName(Builder builder) {
    accountType = Preconditions.checkNotNull(builder.getAccountType());
    account = Preconditions.checkNotNull(builder.getAccount());
    userListDirectLicense = Preconditions.checkNotNull(builder.getUserListDirectLicense());
  }

  public String getAccountType() {
    return accountType;
  }

  public String getAccount() {
    return account;
  }

  public String getUserListDirectLicense() {
    return userListDirectLicense;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static UserListDirectLicenseName of(
      String accountType, String account, String userListDirectLicense) {
    return newBuilder()
        .setAccountType(accountType)
        .setAccount(account)
        .setUserListDirectLicense(userListDirectLicense)
        .build();
  }

  public static String format(String accountType, String account, String userListDirectLicense) {
    return newBuilder()
        .setAccountType(accountType)
        .setAccount(account)
        .setUserListDirectLicense(userListDirectLicense)
        .build()
        .toString();
  }

  public static UserListDirectLicenseName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_TYPE_ACCOUNT_USER_LIST_DIRECT_LICENSE.validatedMatch(
            formattedString,
            "UserListDirectLicenseName.parse: formattedString not in valid format");
    return of(
        matchMap.get("account_type"),
        matchMap.get("account"),
        matchMap.get("user_list_direct_license"));
  }

  public static List<UserListDirectLicenseName> parseList(List<String> formattedStrings) {
    List<UserListDirectLicenseName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<UserListDirectLicenseName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (UserListDirectLicenseName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_TYPE_ACCOUNT_USER_LIST_DIRECT_LICENSE.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (accountType != null) {
            fieldMapBuilder.put("account_type", accountType);
          }
          if (account != null) {
            fieldMapBuilder.put("account", account);
          }
          if (userListDirectLicense != null) {
            fieldMapBuilder.put("user_list_direct_license", userListDirectLicense);
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
    return ACCOUNT_TYPE_ACCOUNT_USER_LIST_DIRECT_LICENSE.instantiate(
        "account_type",
        accountType,
        "account",
        account,
        "user_list_direct_license",
        userListDirectLicense);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      UserListDirectLicenseName that = ((UserListDirectLicenseName) o);
      return Objects.equals(this.accountType, that.accountType)
          && Objects.equals(this.account, that.account)
          && Objects.equals(this.userListDirectLicense, that.userListDirectLicense);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(accountType);
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(userListDirectLicense);
    return h;
  }

  /**
   * Builder for
   * accountTypes/{account_type}/accounts/{account}/userListDirectLicenses/{user_list_direct_license}.
   */
  public static class Builder {
    private String accountType;
    private String account;
    private String userListDirectLicense;

    protected Builder() {}

    public String getAccountType() {
      return accountType;
    }

    public String getAccount() {
      return account;
    }

    public String getUserListDirectLicense() {
      return userListDirectLicense;
    }

    public Builder setAccountType(String accountType) {
      this.accountType = accountType;
      return this;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setUserListDirectLicense(String userListDirectLicense) {
      this.userListDirectLicense = userListDirectLicense;
      return this;
    }

    private Builder(UserListDirectLicenseName userListDirectLicenseName) {
      this.accountType = userListDirectLicenseName.accountType;
      this.account = userListDirectLicenseName.account;
      this.userListDirectLicense = userListDirectLicenseName.userListDirectLicense;
    }

    public UserListDirectLicenseName build() {
      return new UserListDirectLicenseName(this);
    }
  }
}
