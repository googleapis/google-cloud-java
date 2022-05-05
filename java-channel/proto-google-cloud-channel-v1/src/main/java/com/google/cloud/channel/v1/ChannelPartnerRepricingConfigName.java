/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.channel.v1;

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
public class ChannelPartnerRepricingConfigName implements ResourceName {
  private static final PathTemplate ACCOUNT_CHANNEL_PARTNER_CHANNEL_PARTNER_REPRICING_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "accounts/{account}/channelPartnerLinks/{channel_partner}/channelPartnerRepricingConfigs/{channel_partner_repricing_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String channelPartner;
  private final String channelPartnerRepricingConfig;

  @Deprecated
  protected ChannelPartnerRepricingConfigName() {
    account = null;
    channelPartner = null;
    channelPartnerRepricingConfig = null;
  }

  private ChannelPartnerRepricingConfigName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    channelPartner = Preconditions.checkNotNull(builder.getChannelPartner());
    channelPartnerRepricingConfig =
        Preconditions.checkNotNull(builder.getChannelPartnerRepricingConfig());
  }

  public String getAccount() {
    return account;
  }

  public String getChannelPartner() {
    return channelPartner;
  }

  public String getChannelPartnerRepricingConfig() {
    return channelPartnerRepricingConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ChannelPartnerRepricingConfigName of(
      String account, String channelPartner, String channelPartnerRepricingConfig) {
    return newBuilder()
        .setAccount(account)
        .setChannelPartner(channelPartner)
        .setChannelPartnerRepricingConfig(channelPartnerRepricingConfig)
        .build();
  }

  public static String format(
      String account, String channelPartner, String channelPartnerRepricingConfig) {
    return newBuilder()
        .setAccount(account)
        .setChannelPartner(channelPartner)
        .setChannelPartnerRepricingConfig(channelPartnerRepricingConfig)
        .build()
        .toString();
  }

  public static ChannelPartnerRepricingConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_CHANNEL_PARTNER_CHANNEL_PARTNER_REPRICING_CONFIG.validatedMatch(
            formattedString,
            "ChannelPartnerRepricingConfigName.parse: formattedString not in valid format");
    return of(
        matchMap.get("account"),
        matchMap.get("channel_partner"),
        matchMap.get("channel_partner_repricing_config"));
  }

  public static List<ChannelPartnerRepricingConfigName> parseList(List<String> formattedStrings) {
    List<ChannelPartnerRepricingConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ChannelPartnerRepricingConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ChannelPartnerRepricingConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_CHANNEL_PARTNER_CHANNEL_PARTNER_REPRICING_CONFIG.matches(formattedString);
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
          if (channelPartner != null) {
            fieldMapBuilder.put("channel_partner", channelPartner);
          }
          if (channelPartnerRepricingConfig != null) {
            fieldMapBuilder.put("channel_partner_repricing_config", channelPartnerRepricingConfig);
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
    return ACCOUNT_CHANNEL_PARTNER_CHANNEL_PARTNER_REPRICING_CONFIG.instantiate(
        "account",
        account,
        "channel_partner",
        channelPartner,
        "channel_partner_repricing_config",
        channelPartnerRepricingConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ChannelPartnerRepricingConfigName that = ((ChannelPartnerRepricingConfigName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.channelPartner, that.channelPartner)
          && Objects.equals(this.channelPartnerRepricingConfig, that.channelPartnerRepricingConfig);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(channelPartner);
    h *= 1000003;
    h ^= Objects.hashCode(channelPartnerRepricingConfig);
    return h;
  }

  /**
   * Builder for
   * accounts/{account}/channelPartnerLinks/{channel_partner}/channelPartnerRepricingConfigs/{channel_partner_repricing_config}.
   */
  public static class Builder {
    private String account;
    private String channelPartner;
    private String channelPartnerRepricingConfig;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getChannelPartner() {
      return channelPartner;
    }

    public String getChannelPartnerRepricingConfig() {
      return channelPartnerRepricingConfig;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setChannelPartner(String channelPartner) {
      this.channelPartner = channelPartner;
      return this;
    }

    public Builder setChannelPartnerRepricingConfig(String channelPartnerRepricingConfig) {
      this.channelPartnerRepricingConfig = channelPartnerRepricingConfig;
      return this;
    }

    private Builder(ChannelPartnerRepricingConfigName channelPartnerRepricingConfigName) {
      this.account = channelPartnerRepricingConfigName.account;
      this.channelPartner = channelPartnerRepricingConfigName.channelPartner;
      this.channelPartnerRepricingConfig =
          channelPartnerRepricingConfigName.channelPartnerRepricingConfig;
    }

    public ChannelPartnerRepricingConfigName build() {
      return new ChannelPartnerRepricingConfigName(this);
    }
  }
}
