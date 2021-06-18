/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.apigateway.v1;

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
public class ServiceName implements ResourceName {
  private static final PathTemplate SERVICE_CONFIG =
      PathTemplate.createWithoutUrlEncoding("services/{service}/configs/{config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String service;
  private final String config;

  @Deprecated
  protected ServiceName() {
    service = null;
    config = null;
  }

  private ServiceName(Builder builder) {
    service = Preconditions.checkNotNull(builder.getService());
    config = Preconditions.checkNotNull(builder.getConfig());
  }

  public String getService() {
    return service;
  }

  public String getConfig() {
    return config;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ServiceName of(String service, String config) {
    return newBuilder().setService(service).setConfig(config).build();
  }

  public static String format(String service, String config) {
    return newBuilder().setService(service).setConfig(config).build().toString();
  }

  public static ServiceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        SERVICE_CONFIG.validatedMatch(
            formattedString, "ServiceName.parse: formattedString not in valid format");
    return of(matchMap.get("service"), matchMap.get("config"));
  }

  public static List<ServiceName> parseList(List<String> formattedStrings) {
    List<ServiceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ServiceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ServiceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return SERVICE_CONFIG.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (service != null) {
            fieldMapBuilder.put("service", service);
          }
          if (config != null) {
            fieldMapBuilder.put("config", config);
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
    return SERVICE_CONFIG.instantiate("service", service, "config", config);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ServiceName that = ((ServiceName) o);
      return Objects.equals(this.service, that.service) && Objects.equals(this.config, that.config);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(service);
    h *= 1000003;
    h ^= Objects.hashCode(config);
    return h;
  }

  /** Builder for services/{service}/configs/{config}. */
  public static class Builder {
    private String service;
    private String config;

    protected Builder() {}

    public String getService() {
      return service;
    }

    public String getConfig() {
      return config;
    }

    public Builder setService(String service) {
      this.service = service;
      return this;
    }

    public Builder setConfig(String config) {
      this.config = config;
      return this;
    }

    private Builder(ServiceName serviceName) {
      this.service = serviceName.service;
      this.config = serviceName.config;
    }

    public ServiceName build() {
      return new ServiceName(this);
    }
  }
}
