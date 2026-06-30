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
public class PartnerLinkName implements ResourceName {
  private static final PathTemplate ACCOUNT_TYPE_ACCOUNT_PARTNER_LINK =
      PathTemplate.createWithoutUrlEncoding(
          "accountTypes/{account_type}/accounts/{account}/partnerLinks/{partner_link}");
  private volatile Map<String, String> fieldValuesMap;
  private final String accountType;
  private final String account;
  private final String partnerLink;

  @Deprecated
  protected PartnerLinkName() {
    accountType = null;
    account = null;
    partnerLink = null;
  }

  private PartnerLinkName(Builder builder) {
    accountType = Preconditions.checkNotNull(builder.getAccountType());
    account = Preconditions.checkNotNull(builder.getAccount());
    partnerLink = Preconditions.checkNotNull(builder.getPartnerLink());
  }

  public String getAccountType() {
    return accountType;
  }

  public String getAccount() {
    return account;
  }

  public String getPartnerLink() {
    return partnerLink;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PartnerLinkName of(String accountType, String account, String partnerLink) {
    return newBuilder()
        .setAccountType(accountType)
        .setAccount(account)
        .setPartnerLink(partnerLink)
        .build();
  }

  public static String format(String accountType, String account, String partnerLink) {
    return newBuilder()
        .setAccountType(accountType)
        .setAccount(account)
        .setPartnerLink(partnerLink)
        .build()
        .toString();
  }

  public static PartnerLinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_TYPE_ACCOUNT_PARTNER_LINK.validatedMatch(
            formattedString, "PartnerLinkName.parse: formattedString not in valid format");
    return of(matchMap.get("account_type"), matchMap.get("account"), matchMap.get("partner_link"));
  }

  public static List<PartnerLinkName> parseList(List<String> formattedStrings) {
    List<PartnerLinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PartnerLinkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PartnerLinkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_TYPE_ACCOUNT_PARTNER_LINK.matches(formattedString);
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
          if (partnerLink != null) {
            fieldMapBuilder.put("partner_link", partnerLink);
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
    return ACCOUNT_TYPE_ACCOUNT_PARTNER_LINK.instantiate(
        "account_type", accountType, "account", account, "partner_link", partnerLink);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PartnerLinkName that = ((PartnerLinkName) o);
      return Objects.equals(this.accountType, that.accountType)
          && Objects.equals(this.account, that.account)
          && Objects.equals(this.partnerLink, that.partnerLink);
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
    h ^= Objects.hashCode(partnerLink);
    return h;
  }

  /** Builder for accountTypes/{account_type}/accounts/{account}/partnerLinks/{partner_link}. */
  public static class Builder {
    private String accountType;
    private String account;
    private String partnerLink;

    protected Builder() {}

    public String getAccountType() {
      return accountType;
    }

    public String getAccount() {
      return account;
    }

    public String getPartnerLink() {
      return partnerLink;
    }

    public Builder setAccountType(String accountType) {
      this.accountType = accountType;
      return this;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setPartnerLink(String partnerLink) {
      this.partnerLink = partnerLink;
      return this;
    }

    private Builder(PartnerLinkName partnerLinkName) {
      this.accountType = partnerLinkName.accountType;
      this.account = partnerLinkName.account;
      this.partnerLink = partnerLinkName.partnerLink;
    }

    public PartnerLinkName build() {
      return new PartnerLinkName(this);
    }
  }
}
