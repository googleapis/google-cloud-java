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

package com.google.ads.admanager.v1;

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
public class PrivateAuctionDealName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_PRIVATE_AUCTION_DEAL =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/privateAuctionDeals/{private_auction_deal}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String privateAuctionDeal;

  @Deprecated
  protected PrivateAuctionDealName() {
    networkCode = null;
    privateAuctionDeal = null;
  }

  private PrivateAuctionDealName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    privateAuctionDeal = Preconditions.checkNotNull(builder.getPrivateAuctionDeal());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getPrivateAuctionDeal() {
    return privateAuctionDeal;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PrivateAuctionDealName of(String networkCode, String privateAuctionDeal) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setPrivateAuctionDeal(privateAuctionDeal)
        .build();
  }

  public static String format(String networkCode, String privateAuctionDeal) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setPrivateAuctionDeal(privateAuctionDeal)
        .build()
        .toString();
  }

  public static PrivateAuctionDealName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_PRIVATE_AUCTION_DEAL.validatedMatch(
            formattedString, "PrivateAuctionDealName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("private_auction_deal"));
  }

  public static List<PrivateAuctionDealName> parseList(List<String> formattedStrings) {
    List<PrivateAuctionDealName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PrivateAuctionDealName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PrivateAuctionDealName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_PRIVATE_AUCTION_DEAL.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (networkCode != null) {
            fieldMapBuilder.put("network_code", networkCode);
          }
          if (privateAuctionDeal != null) {
            fieldMapBuilder.put("private_auction_deal", privateAuctionDeal);
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
    return NETWORK_CODE_PRIVATE_AUCTION_DEAL.instantiate(
        "network_code", networkCode, "private_auction_deal", privateAuctionDeal);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PrivateAuctionDealName that = ((PrivateAuctionDealName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.privateAuctionDeal, that.privateAuctionDeal);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(privateAuctionDeal);
    return h;
  }

  /** Builder for networks/{network_code}/privateAuctionDeals/{private_auction_deal}. */
  public static class Builder {
    private String networkCode;
    private String privateAuctionDeal;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getPrivateAuctionDeal() {
      return privateAuctionDeal;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setPrivateAuctionDeal(String privateAuctionDeal) {
      this.privateAuctionDeal = privateAuctionDeal;
      return this;
    }

    private Builder(PrivateAuctionDealName privateAuctionDealName) {
      this.networkCode = privateAuctionDealName.networkCode;
      this.privateAuctionDeal = privateAuctionDealName.privateAuctionDeal;
    }

    public PrivateAuctionDealName build() {
      return new PrivateAuctionDealName(this);
    }
  }
}
