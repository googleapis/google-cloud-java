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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class ViewabilityProviderName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_VIEWABILITY_PROVIDER =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/viewabilityProviders/{viewability_provider}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String viewabilityProvider;

  @Deprecated
  protected ViewabilityProviderName() {
    networkCode = null;
    viewabilityProvider = null;
  }

  private ViewabilityProviderName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    viewabilityProvider = Preconditions.checkNotNull(builder.getViewabilityProvider());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getViewabilityProvider() {
    return viewabilityProvider;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ViewabilityProviderName of(String networkCode, String viewabilityProvider) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setViewabilityProvider(viewabilityProvider)
        .build();
  }

  public static String format(String networkCode, String viewabilityProvider) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setViewabilityProvider(viewabilityProvider)
        .build()
        .toString();
  }

  public static @Nullable ViewabilityProviderName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_VIEWABILITY_PROVIDER.validatedMatch(
            formattedString, "ViewabilityProviderName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("viewability_provider"));
  }

  public static List<ViewabilityProviderName> parseList(List<String> formattedStrings) {
    List<ViewabilityProviderName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable ViewabilityProviderName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ViewabilityProviderName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_VIEWABILITY_PROVIDER.matches(formattedString);
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
          if (viewabilityProvider != null) {
            fieldMapBuilder.put("viewability_provider", viewabilityProvider);
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
    return NETWORK_CODE_VIEWABILITY_PROVIDER.instantiate(
        "network_code", networkCode, "viewability_provider", viewabilityProvider);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ViewabilityProviderName that = ((ViewabilityProviderName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.viewabilityProvider, that.viewabilityProvider);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(viewabilityProvider);
    return h;
  }

  /** Builder for networks/{network_code}/viewabilityProviders/{viewability_provider}. */
  public static class Builder {
    private String networkCode;
    private String viewabilityProvider;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getViewabilityProvider() {
      return viewabilityProvider;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setViewabilityProvider(String viewabilityProvider) {
      this.viewabilityProvider = viewabilityProvider;
      return this;
    }

    private Builder(ViewabilityProviderName viewabilityProviderName) {
      this.networkCode = viewabilityProviderName.networkCode;
      this.viewabilityProvider = viewabilityProviderName.viewabilityProvider;
    }

    public ViewabilityProviderName build() {
      return new ViewabilityProviderName(this);
    }
  }
}
