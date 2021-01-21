/*
 * Copyright 2020 Google LLC
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
public class OfferName implements ResourceName {
  private static final PathTemplate ACCOUNT_OFFER =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/offers/{offer}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String offer;

  @Deprecated
  protected OfferName() {
    account = null;
    offer = null;
  }

  private OfferName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    offer = Preconditions.checkNotNull(builder.getOffer());
  }

  public String getAccount() {
    return account;
  }

  public String getOffer() {
    return offer;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static OfferName of(String account, String offer) {
    return newBuilder().setAccount(account).setOffer(offer).build();
  }

  public static String format(String account, String offer) {
    return newBuilder().setAccount(account).setOffer(offer).build().toString();
  }

  public static OfferName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_OFFER.validatedMatch(
            formattedString, "OfferName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("offer"));
  }

  public static List<OfferName> parseList(List<String> formattedStrings) {
    List<OfferName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OfferName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (OfferName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_OFFER.matches(formattedString);
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
          if (offer != null) {
            fieldMapBuilder.put("offer", offer);
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
    return ACCOUNT_OFFER.instantiate("account", account, "offer", offer);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      OfferName that = ((OfferName) o);
      return Objects.equals(this.account, that.account) && Objects.equals(this.offer, that.offer);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(offer);
    return h;
  }

  /** Builder for accounts/{account}/offers/{offer}. */
  public static class Builder {
    private String account;
    private String offer;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getOffer() {
      return offer;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setOffer(String offer) {
      this.offer = offer;
      return this;
    }

    private Builder(OfferName offerName) {
      account = offerName.account;
      offer = offerName.offer;
    }

    public OfferName build() {
      return new OfferName(this);
    }
  }
}
