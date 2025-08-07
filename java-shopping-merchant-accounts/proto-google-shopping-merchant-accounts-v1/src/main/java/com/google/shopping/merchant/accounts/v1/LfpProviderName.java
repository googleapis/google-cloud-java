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
public class LfpProviderName implements ResourceName {
  private static final PathTemplate ACCOUNT_OMNICHANNEL_SETTING_LFP_PROVIDER =
      PathTemplate.createWithoutUrlEncoding(
          "accounts/{account}/omnichannelSettings/{omnichannel_setting}/lfpProviders/{lfp_provider}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String omnichannelSetting;
  private final String lfpProvider;

  @Deprecated
  protected LfpProviderName() {
    account = null;
    omnichannelSetting = null;
    lfpProvider = null;
  }

  private LfpProviderName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    omnichannelSetting = Preconditions.checkNotNull(builder.getOmnichannelSetting());
    lfpProvider = Preconditions.checkNotNull(builder.getLfpProvider());
  }

  public String getAccount() {
    return account;
  }

  public String getOmnichannelSetting() {
    return omnichannelSetting;
  }

  public String getLfpProvider() {
    return lfpProvider;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LfpProviderName of(String account, String omnichannelSetting, String lfpProvider) {
    return newBuilder()
        .setAccount(account)
        .setOmnichannelSetting(omnichannelSetting)
        .setLfpProvider(lfpProvider)
        .build();
  }

  public static String format(String account, String omnichannelSetting, String lfpProvider) {
    return newBuilder()
        .setAccount(account)
        .setOmnichannelSetting(omnichannelSetting)
        .setLfpProvider(lfpProvider)
        .build()
        .toString();
  }

  public static LfpProviderName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_OMNICHANNEL_SETTING_LFP_PROVIDER.validatedMatch(
            formattedString, "LfpProviderName.parse: formattedString not in valid format");
    return of(
        matchMap.get("account"), matchMap.get("omnichannel_setting"), matchMap.get("lfp_provider"));
  }

  public static List<LfpProviderName> parseList(List<String> formattedStrings) {
    List<LfpProviderName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LfpProviderName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LfpProviderName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_OMNICHANNEL_SETTING_LFP_PROVIDER.matches(formattedString);
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
          if (omnichannelSetting != null) {
            fieldMapBuilder.put("omnichannel_setting", omnichannelSetting);
          }
          if (lfpProvider != null) {
            fieldMapBuilder.put("lfp_provider", lfpProvider);
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
    return ACCOUNT_OMNICHANNEL_SETTING_LFP_PROVIDER.instantiate(
        "account", account, "omnichannel_setting", omnichannelSetting, "lfp_provider", lfpProvider);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      LfpProviderName that = ((LfpProviderName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.omnichannelSetting, that.omnichannelSetting)
          && Objects.equals(this.lfpProvider, that.lfpProvider);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(omnichannelSetting);
    h *= 1000003;
    h ^= Objects.hashCode(lfpProvider);
    return h;
  }

  /**
   * Builder for
   * accounts/{account}/omnichannelSettings/{omnichannel_setting}/lfpProviders/{lfp_provider}.
   */
  public static class Builder {
    private String account;
    private String omnichannelSetting;
    private String lfpProvider;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getOmnichannelSetting() {
      return omnichannelSetting;
    }

    public String getLfpProvider() {
      return lfpProvider;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setOmnichannelSetting(String omnichannelSetting) {
      this.omnichannelSetting = omnichannelSetting;
      return this;
    }

    public Builder setLfpProvider(String lfpProvider) {
      this.lfpProvider = lfpProvider;
      return this;
    }

    private Builder(LfpProviderName lfpProviderName) {
      this.account = lfpProviderName.account;
      this.omnichannelSetting = lfpProviderName.omnichannelSetting;
      this.lfpProvider = lfpProviderName.lfpProvider;
    }

    public LfpProviderName build() {
      return new LfpProviderName(this);
    }
  }
}
