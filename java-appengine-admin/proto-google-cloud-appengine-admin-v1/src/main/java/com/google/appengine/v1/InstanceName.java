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

package com.google.appengine.v1;

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
public class InstanceName implements ResourceName {
  private static final PathTemplate APP_SERVICE_VERSION_INSTANCE =
      PathTemplate.createWithoutUrlEncoding(
          "apps/{app}/services/{service}/versions/{version}/instances/{instance}");
  private volatile Map<String, String> fieldValuesMap;
  private final String app;
  private final String service;
  private final String version;
  private final String instance;

  @Deprecated
  protected InstanceName() {
    app = null;
    service = null;
    version = null;
    instance = null;
  }

  private InstanceName(Builder builder) {
    app = Preconditions.checkNotNull(builder.getApp());
    service = Preconditions.checkNotNull(builder.getService());
    version = Preconditions.checkNotNull(builder.getVersion());
    instance = Preconditions.checkNotNull(builder.getInstance());
  }

  public String getApp() {
    return app;
  }

  public String getService() {
    return service;
  }

  public String getVersion() {
    return version;
  }

  public String getInstance() {
    return instance;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static InstanceName of(String app, String service, String version, String instance) {
    return newBuilder()
        .setApp(app)
        .setService(service)
        .setVersion(version)
        .setInstance(instance)
        .build();
  }

  public static String format(String app, String service, String version, String instance) {
    return newBuilder()
        .setApp(app)
        .setService(service)
        .setVersion(version)
        .setInstance(instance)
        .build()
        .toString();
  }

  public static InstanceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        APP_SERVICE_VERSION_INSTANCE.validatedMatch(
            formattedString, "InstanceName.parse: formattedString not in valid format");
    return of(
        matchMap.get("app"),
        matchMap.get("service"),
        matchMap.get("version"),
        matchMap.get("instance"));
  }

  public static List<InstanceName> parseList(List<String> formattedStrings) {
    List<InstanceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<InstanceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (InstanceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return APP_SERVICE_VERSION_INSTANCE.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (app != null) {
            fieldMapBuilder.put("app", app);
          }
          if (service != null) {
            fieldMapBuilder.put("service", service);
          }
          if (version != null) {
            fieldMapBuilder.put("version", version);
          }
          if (instance != null) {
            fieldMapBuilder.put("instance", instance);
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
    return APP_SERVICE_VERSION_INSTANCE.instantiate(
        "app", app, "service", service, "version", version, "instance", instance);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      InstanceName that = ((InstanceName) o);
      return Objects.equals(this.app, that.app)
          && Objects.equals(this.service, that.service)
          && Objects.equals(this.version, that.version)
          && Objects.equals(this.instance, that.instance);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(app);
    h *= 1000003;
    h ^= Objects.hashCode(service);
    h *= 1000003;
    h ^= Objects.hashCode(version);
    h *= 1000003;
    h ^= Objects.hashCode(instance);
    return h;
  }

  /** Builder for apps/{app}/services/{service}/versions/{version}/instances/{instance}. */
  public static class Builder {
    private String app;
    private String service;
    private String version;
    private String instance;

    protected Builder() {}

    public String getApp() {
      return app;
    }

    public String getService() {
      return service;
    }

    public String getVersion() {
      return version;
    }

    public String getInstance() {
      return instance;
    }

    public Builder setApp(String app) {
      this.app = app;
      return this;
    }

    public Builder setService(String service) {
      this.service = service;
      return this;
    }

    public Builder setVersion(String version) {
      this.version = version;
      return this;
    }

    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    private Builder(InstanceName instanceName) {
      app = instanceName.app;
      service = instanceName.service;
      version = instanceName.version;
      instance = instanceName.instance;
    }

    public InstanceName build() {
      return new InstanceName(this);
    }
  }
}
