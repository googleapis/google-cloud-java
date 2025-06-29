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
public class PrivateAuctionName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_PRIVATE_AUCTION =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/privateAuctions/{private_auction}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String privateAuction;

  @Deprecated
  protected PrivateAuctionName() {
    networkCode = null;
    privateAuction = null;
  }

  private PrivateAuctionName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    privateAuction = Preconditions.checkNotNull(builder.getPrivateAuction());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getPrivateAuction() {
    return privateAuction;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PrivateAuctionName of(String networkCode, String privateAuction) {
    return newBuilder().setNetworkCode(networkCode).setPrivateAuction(privateAuction).build();
  }

  public static String format(String networkCode, String privateAuction) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setPrivateAuction(privateAuction)
        .build()
        .toString();
  }

  public static PrivateAuctionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_PRIVATE_AUCTION.validatedMatch(
            formattedString, "PrivateAuctionName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("private_auction"));
  }

  public static List<PrivateAuctionName> parseList(List<String> formattedStrings) {
    List<PrivateAuctionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PrivateAuctionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PrivateAuctionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_PRIVATE_AUCTION.matches(formattedString);
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
          if (privateAuction != null) {
            fieldMapBuilder.put("private_auction", privateAuction);
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
    return NETWORK_CODE_PRIVATE_AUCTION.instantiate(
        "network_code", networkCode, "private_auction", privateAuction);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PrivateAuctionName that = ((PrivateAuctionName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.privateAuction, that.privateAuction);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(privateAuction);
    return h;
  }

  /** Builder for networks/{network_code}/privateAuctions/{private_auction}. */
  public static class Builder {
    private String networkCode;
    private String privateAuction;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getPrivateAuction() {
      return privateAuction;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setPrivateAuction(String privateAuction) {
      this.privateAuction = privateAuction;
      return this;
    }

    private Builder(PrivateAuctionName privateAuctionName) {
      this.networkCode = privateAuctionName.networkCode;
      this.privateAuction = privateAuctionName.privateAuction;
    }

    public PrivateAuctionName build() {
      return new PrivateAuctionName(this);
    }
  }
}
