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
public class WebPropertyName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_WEB_PROPERTY =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/webProperties/{web_property}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String webProperty;

  @Deprecated
  protected WebPropertyName() {
    networkCode = null;
    webProperty = null;
  }

  private WebPropertyName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    webProperty = Preconditions.checkNotNull(builder.getWebProperty());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getWebProperty() {
    return webProperty;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static WebPropertyName of(String networkCode, String webProperty) {
    return newBuilder().setNetworkCode(networkCode).setWebProperty(webProperty).build();
  }

  public static String format(String networkCode, String webProperty) {
    return newBuilder().setNetworkCode(networkCode).setWebProperty(webProperty).build().toString();
  }

  public static WebPropertyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_WEB_PROPERTY.validatedMatch(
            formattedString, "WebPropertyName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("web_property"));
  }

  public static List<WebPropertyName> parseList(List<String> formattedStrings) {
    List<WebPropertyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<WebPropertyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (WebPropertyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_WEB_PROPERTY.matches(formattedString);
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
          if (webProperty != null) {
            fieldMapBuilder.put("web_property", webProperty);
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
    return NETWORK_CODE_WEB_PROPERTY.instantiate(
        "network_code", networkCode, "web_property", webProperty);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      WebPropertyName that = ((WebPropertyName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.webProperty, that.webProperty);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(webProperty);
    return h;
  }

  /** Builder for networks/{network_code}/webProperties/{web_property}. */
  public static class Builder {
    private String networkCode;
    private String webProperty;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getWebProperty() {
      return webProperty;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setWebProperty(String webProperty) {
      this.webProperty = webProperty;
      return this;
    }

    private Builder(WebPropertyName webPropertyName) {
      this.networkCode = webPropertyName.networkCode;
      this.webProperty = webPropertyName.webProperty;
    }

    public WebPropertyName build() {
      return new WebPropertyName(this);
    }
  }
}
