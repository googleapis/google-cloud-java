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
public class BrowserLanguageName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_BROWSER_LANGUAGE =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/browserLanguages/{browser_language}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String browserLanguage;

  @Deprecated
  protected BrowserLanguageName() {
    networkCode = null;
    browserLanguage = null;
  }

  private BrowserLanguageName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    browserLanguage = Preconditions.checkNotNull(builder.getBrowserLanguage());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getBrowserLanguage() {
    return browserLanguage;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BrowserLanguageName of(String networkCode, String browserLanguage) {
    return newBuilder().setNetworkCode(networkCode).setBrowserLanguage(browserLanguage).build();
  }

  public static String format(String networkCode, String browserLanguage) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setBrowserLanguage(browserLanguage)
        .build()
        .toString();
  }

  public static BrowserLanguageName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_BROWSER_LANGUAGE.validatedMatch(
            formattedString, "BrowserLanguageName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("browser_language"));
  }

  public static List<BrowserLanguageName> parseList(List<String> formattedStrings) {
    List<BrowserLanguageName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BrowserLanguageName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BrowserLanguageName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_BROWSER_LANGUAGE.matches(formattedString);
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
          if (browserLanguage != null) {
            fieldMapBuilder.put("browser_language", browserLanguage);
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
    return NETWORK_CODE_BROWSER_LANGUAGE.instantiate(
        "network_code", networkCode, "browser_language", browserLanguage);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BrowserLanguageName that = ((BrowserLanguageName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.browserLanguage, that.browserLanguage);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(browserLanguage);
    return h;
  }

  /** Builder for networks/{network_code}/browserLanguages/{browser_language}. */
  public static class Builder {
    private String networkCode;
    private String browserLanguage;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getBrowserLanguage() {
      return browserLanguage;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setBrowserLanguage(String browserLanguage) {
      this.browserLanguage = browserLanguage;
      return this;
    }

    private Builder(BrowserLanguageName browserLanguageName) {
      this.networkCode = browserLanguageName.networkCode;
      this.browserLanguage = browserLanguageName.browserLanguage;
    }

    public BrowserLanguageName build() {
      return new BrowserLanguageName(this);
    }
  }
}
