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
public class MobileDeviceSubmodelName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_MOBILE_DEVICE_SUBMODEL =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/mobileDeviceSubmodels/{mobile_device_submodel}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String mobileDeviceSubmodel;

  @Deprecated
  protected MobileDeviceSubmodelName() {
    networkCode = null;
    mobileDeviceSubmodel = null;
  }

  private MobileDeviceSubmodelName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    mobileDeviceSubmodel = Preconditions.checkNotNull(builder.getMobileDeviceSubmodel());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getMobileDeviceSubmodel() {
    return mobileDeviceSubmodel;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MobileDeviceSubmodelName of(String networkCode, String mobileDeviceSubmodel) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setMobileDeviceSubmodel(mobileDeviceSubmodel)
        .build();
  }

  public static String format(String networkCode, String mobileDeviceSubmodel) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setMobileDeviceSubmodel(mobileDeviceSubmodel)
        .build()
        .toString();
  }

  public static MobileDeviceSubmodelName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_MOBILE_DEVICE_SUBMODEL.validatedMatch(
            formattedString, "MobileDeviceSubmodelName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("mobile_device_submodel"));
  }

  public static List<MobileDeviceSubmodelName> parseList(List<String> formattedStrings) {
    List<MobileDeviceSubmodelName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MobileDeviceSubmodelName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MobileDeviceSubmodelName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_MOBILE_DEVICE_SUBMODEL.matches(formattedString);
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
          if (mobileDeviceSubmodel != null) {
            fieldMapBuilder.put("mobile_device_submodel", mobileDeviceSubmodel);
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
    return NETWORK_CODE_MOBILE_DEVICE_SUBMODEL.instantiate(
        "network_code", networkCode, "mobile_device_submodel", mobileDeviceSubmodel);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MobileDeviceSubmodelName that = ((MobileDeviceSubmodelName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.mobileDeviceSubmodel, that.mobileDeviceSubmodel);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(mobileDeviceSubmodel);
    return h;
  }

  /** Builder for networks/{network_code}/mobileDeviceSubmodels/{mobile_device_submodel}. */
  public static class Builder {
    private String networkCode;
    private String mobileDeviceSubmodel;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getMobileDeviceSubmodel() {
      return mobileDeviceSubmodel;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setMobileDeviceSubmodel(String mobileDeviceSubmodel) {
      this.mobileDeviceSubmodel = mobileDeviceSubmodel;
      return this;
    }

    private Builder(MobileDeviceSubmodelName mobileDeviceSubmodelName) {
      this.networkCode = mobileDeviceSubmodelName.networkCode;
      this.mobileDeviceSubmodel = mobileDeviceSubmodelName.mobileDeviceSubmodel;
    }

    public MobileDeviceSubmodelName build() {
      return new MobileDeviceSubmodelName(this);
    }
  }
}
