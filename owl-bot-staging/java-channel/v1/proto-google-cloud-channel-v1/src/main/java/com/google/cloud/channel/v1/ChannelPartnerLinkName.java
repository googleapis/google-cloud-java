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
public class ChannelPartnerLinkName implements ResourceName {
  private static final PathTemplate ACCOUNT_CHANNEL_PARTNER_LINK =
      PathTemplate.createWithoutUrlEncoding(
          "accounts/{account}/channelPartnerLinks/{channel_partner_link}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String channelPartnerLink;

  @Deprecated
  protected ChannelPartnerLinkName() {
    account = null;
    channelPartnerLink = null;
  }

  private ChannelPartnerLinkName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    channelPartnerLink = Preconditions.checkNotNull(builder.getChannelPartnerLink());
  }

  public String getAccount() {
    return account;
  }

  public String getChannelPartnerLink() {
    return channelPartnerLink;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ChannelPartnerLinkName of(String account, String channelPartnerLink) {
    return newBuilder().setAccount(account).setChannelPartnerLink(channelPartnerLink).build();
  }

  public static String format(String account, String channelPartnerLink) {
    return newBuilder()
        .setAccount(account)
        .setChannelPartnerLink(channelPartnerLink)
        .build()
        .toString();
  }

  public static ChannelPartnerLinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_CHANNEL_PARTNER_LINK.validatedMatch(
            formattedString, "ChannelPartnerLinkName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("channel_partner_link"));
  }

  public static List<ChannelPartnerLinkName> parseList(List<String> formattedStrings) {
    List<ChannelPartnerLinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ChannelPartnerLinkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ChannelPartnerLinkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_CHANNEL_PARTNER_LINK.matches(formattedString);
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
          if (channelPartnerLink != null) {
            fieldMapBuilder.put("channel_partner_link", channelPartnerLink);
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
    return ACCOUNT_CHANNEL_PARTNER_LINK.instantiate(
        "account", account, "channel_partner_link", channelPartnerLink);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ChannelPartnerLinkName that = ((ChannelPartnerLinkName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.channelPartnerLink, that.channelPartnerLink);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(channelPartnerLink);
    return h;
  }

  /** Builder for accounts/{account}/channelPartnerLinks/{channel_partner_link}. */
  public static class Builder {
    private String account;
    private String channelPartnerLink;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getChannelPartnerLink() {
      return channelPartnerLink;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setChannelPartnerLink(String channelPartnerLink) {
      this.channelPartnerLink = channelPartnerLink;
      return this;
    }

    private Builder(ChannelPartnerLinkName channelPartnerLinkName) {
      this.account = channelPartnerLinkName.account;
      this.channelPartnerLink = channelPartnerLinkName.channelPartnerLink;
    }

    public ChannelPartnerLinkName build() {
      return new ChannelPartnerLinkName(this);
    }
  }
}
