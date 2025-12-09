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
public class ApplicationName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_APPLICATION =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/applications/{application}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String application;

  @Deprecated
  protected ApplicationName() {
    networkCode = null;
    application = null;
  }

  private ApplicationName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    application = Preconditions.checkNotNull(builder.getApplication());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getApplication() {
    return application;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ApplicationName of(String networkCode, String application) {
    return newBuilder().setNetworkCode(networkCode).setApplication(application).build();
  }

  public static String format(String networkCode, String application) {
    return newBuilder().setNetworkCode(networkCode).setApplication(application).build().toString();
  }

  public static ApplicationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_APPLICATION.validatedMatch(
            formattedString, "ApplicationName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("application"));
  }

  public static List<ApplicationName> parseList(List<String> formattedStrings) {
    List<ApplicationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ApplicationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ApplicationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_APPLICATION.matches(formattedString);
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
          if (application != null) {
            fieldMapBuilder.put("application", application);
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
    return NETWORK_CODE_APPLICATION.instantiate(
        "network_code", networkCode, "application", application);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ApplicationName that = ((ApplicationName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.application, that.application);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(application);
    return h;
  }

  /** Builder for networks/{network_code}/applications/{application}. */
  public static class Builder {
    private String networkCode;
    private String application;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getApplication() {
      return application;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setApplication(String application) {
      this.application = application;
      return this;
    }

    private Builder(ApplicationName applicationName) {
      this.networkCode = applicationName.networkCode;
      this.application = applicationName.application;
    }

    public ApplicationName build() {
      return new ApplicationName(this);
    }
  }
}
