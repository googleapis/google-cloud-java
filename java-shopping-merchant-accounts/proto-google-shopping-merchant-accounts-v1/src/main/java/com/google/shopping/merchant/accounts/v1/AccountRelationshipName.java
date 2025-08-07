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

package com.google.shopping.merchant.accounts.v1;

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
public class AccountRelationshipName implements ResourceName {
  private static final PathTemplate ACCOUNT_RELATIONSHIP =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/relationships/{relationship}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String relationship;

  @Deprecated
  protected AccountRelationshipName() {
    account = null;
    relationship = null;
  }

  private AccountRelationshipName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    relationship = Preconditions.checkNotNull(builder.getRelationship());
  }

  public String getAccount() {
    return account;
  }

  public String getRelationship() {
    return relationship;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AccountRelationshipName of(String account, String relationship) {
    return newBuilder().setAccount(account).setRelationship(relationship).build();
  }

  public static String format(String account, String relationship) {
    return newBuilder().setAccount(account).setRelationship(relationship).build().toString();
  }

  public static AccountRelationshipName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_RELATIONSHIP.validatedMatch(
            formattedString, "AccountRelationshipName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("relationship"));
  }

  public static List<AccountRelationshipName> parseList(List<String> formattedStrings) {
    List<AccountRelationshipName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AccountRelationshipName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AccountRelationshipName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_RELATIONSHIP.matches(formattedString);
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
          if (relationship != null) {
            fieldMapBuilder.put("relationship", relationship);
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
    return ACCOUNT_RELATIONSHIP.instantiate("account", account, "relationship", relationship);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AccountRelationshipName that = ((AccountRelationshipName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.relationship, that.relationship);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(relationship);
    return h;
  }

  /** Builder for accounts/{account}/relationships/{relationship}. */
  public static class Builder {
    private String account;
    private String relationship;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getRelationship() {
      return relationship;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setRelationship(String relationship) {
      this.relationship = relationship;
      return this;
    }

    private Builder(AccountRelationshipName accountRelationshipName) {
      this.account = accountRelationshipName.account;
      this.relationship = accountRelationshipName.relationship;
    }

    public AccountRelationshipName build() {
      return new AccountRelationshipName(this);
    }
  }
}
