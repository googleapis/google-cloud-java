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
public class AutomaticImprovementsName implements ResourceName {
  private static final PathTemplate ACCOUNT =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/automaticImprovements");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;

  @Deprecated
  protected AutomaticImprovementsName() {
    account = null;
  }

  private AutomaticImprovementsName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
  }

  public String getAccount() {
    return account;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AutomaticImprovementsName of(String account) {
    return newBuilder().setAccount(account).build();
  }

  public static String format(String account) {
    return newBuilder().setAccount(account).build().toString();
  }

  public static AutomaticImprovementsName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT.validatedMatch(
            formattedString,
            "AutomaticImprovementsName.parse: formattedString not in valid format");
    return of(matchMap.get("account"));
  }

  public static List<AutomaticImprovementsName> parseList(List<String> formattedStrings) {
    List<AutomaticImprovementsName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AutomaticImprovementsName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AutomaticImprovementsName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT.matches(formattedString);
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
    return ACCOUNT.instantiate("account", account);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AutomaticImprovementsName that = ((AutomaticImprovementsName) o);
      return Objects.equals(this.account, that.account);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    return h;
  }

  /** Builder for accounts/{account}/automaticImprovements. */
  public static class Builder {
    private String account;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    private Builder(AutomaticImprovementsName automaticImprovementsName) {
      this.account = automaticImprovementsName.account;
    }

    public AutomaticImprovementsName build() {
      return new AutomaticImprovementsName(this);
    }
  }
}
