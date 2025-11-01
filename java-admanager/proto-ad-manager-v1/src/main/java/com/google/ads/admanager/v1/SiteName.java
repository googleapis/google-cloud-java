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
public class SiteName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_SITE =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/sites/{site}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String site;

  @Deprecated
  protected SiteName() {
    networkCode = null;
    site = null;
  }

  private SiteName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    site = Preconditions.checkNotNull(builder.getSite());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getSite() {
    return site;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SiteName of(String networkCode, String site) {
    return newBuilder().setNetworkCode(networkCode).setSite(site).build();
  }

  public static String format(String networkCode, String site) {
    return newBuilder().setNetworkCode(networkCode).setSite(site).build().toString();
  }

  public static SiteName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_SITE.validatedMatch(
            formattedString, "SiteName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("site"));
  }

  public static List<SiteName> parseList(List<String> formattedStrings) {
    List<SiteName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SiteName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SiteName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_SITE.matches(formattedString);
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
          if (site != null) {
            fieldMapBuilder.put("site", site);
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
    return NETWORK_CODE_SITE.instantiate("network_code", networkCode, "site", site);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SiteName that = ((SiteName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.site, that.site);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(site);
    return h;
  }

  /** Builder for networks/{network_code}/sites/{site}. */
  public static class Builder {
    private String networkCode;
    private String site;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getSite() {
      return site;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setSite(String site) {
      this.site = site;
      return this;
    }

    private Builder(SiteName siteName) {
      this.networkCode = siteName.networkCode;
      this.site = siteName.site;
    }

    public SiteName build() {
      return new SiteName(this);
    }
  }
}
