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
public class DaiEncodingProfileName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_DAI_ENCODING_PROFILE =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/daiEncodingProfiles/{dai_encoding_profile}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String daiEncodingProfile;

  @Deprecated
  protected DaiEncodingProfileName() {
    networkCode = null;
    daiEncodingProfile = null;
  }

  private DaiEncodingProfileName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    daiEncodingProfile = Preconditions.checkNotNull(builder.getDaiEncodingProfile());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getDaiEncodingProfile() {
    return daiEncodingProfile;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DaiEncodingProfileName of(String networkCode, String daiEncodingProfile) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setDaiEncodingProfile(daiEncodingProfile)
        .build();
  }

  public static String format(String networkCode, String daiEncodingProfile) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setDaiEncodingProfile(daiEncodingProfile)
        .build()
        .toString();
  }

  public static @Nullable DaiEncodingProfileName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_DAI_ENCODING_PROFILE.validatedMatch(
            formattedString, "DaiEncodingProfileName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("dai_encoding_profile"));
  }

  public static List<DaiEncodingProfileName> parseList(List<String> formattedStrings) {
    List<DaiEncodingProfileName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable DaiEncodingProfileName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DaiEncodingProfileName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_DAI_ENCODING_PROFILE.matches(formattedString);
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
          if (daiEncodingProfile != null) {
            fieldMapBuilder.put("dai_encoding_profile", daiEncodingProfile);
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
    return NETWORK_CODE_DAI_ENCODING_PROFILE.instantiate(
        "network_code", networkCode, "dai_encoding_profile", daiEncodingProfile);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DaiEncodingProfileName that = ((DaiEncodingProfileName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.daiEncodingProfile, that.daiEncodingProfile);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(daiEncodingProfile);
    return h;
  }

  /** Builder for networks/{network_code}/daiEncodingProfiles/{dai_encoding_profile}. */
  public static class Builder {
    private String networkCode;
    private String daiEncodingProfile;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getDaiEncodingProfile() {
      return daiEncodingProfile;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setDaiEncodingProfile(String daiEncodingProfile) {
      this.daiEncodingProfile = daiEncodingProfile;
      return this;
    }

    private Builder(DaiEncodingProfileName daiEncodingProfileName) {
      this.networkCode = daiEncodingProfileName.networkCode;
      this.daiEncodingProfile = daiEncodingProfileName.daiEncodingProfile;
    }

    public DaiEncodingProfileName build() {
      return new DaiEncodingProfileName(this);
    }
  }
}
