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
public class BrowserName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_BROWSER =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/browsers/{browser}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String browser;

  @Deprecated
  protected BrowserName() {
    networkCode = null;
    browser = null;
  }

  private BrowserName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    browser = Preconditions.checkNotNull(builder.getBrowser());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getBrowser() {
    return browser;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BrowserName of(String networkCode, String browser) {
    return newBuilder().setNetworkCode(networkCode).setBrowser(browser).build();
  }

  public static String format(String networkCode, String browser) {
    return newBuilder().setNetworkCode(networkCode).setBrowser(browser).build().toString();
  }

  public static BrowserName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_BROWSER.validatedMatch(
            formattedString, "BrowserName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("browser"));
  }

  public static List<BrowserName> parseList(List<String> formattedStrings) {
    List<BrowserName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BrowserName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BrowserName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_BROWSER.matches(formattedString);
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
          if (browser != null) {
            fieldMapBuilder.put("browser", browser);
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
    return NETWORK_CODE_BROWSER.instantiate("network_code", networkCode, "browser", browser);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BrowserName that = ((BrowserName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.browser, that.browser);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(browser);
    return h;
  }

  /** Builder for networks/{network_code}/browsers/{browser}. */
  public static class Builder {
    private String networkCode;
    private String browser;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getBrowser() {
      return browser;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setBrowser(String browser) {
      this.browser = browser;
      return this;
    }

    private Builder(BrowserName browserName) {
      this.networkCode = browserName.networkCode;
      this.browser = browserName.browser;
    }

    public BrowserName build() {
      return new BrowserName(this);
    }
  }
}
