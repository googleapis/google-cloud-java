/*
 * Copyright 2022 Google LLC
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

package com.google.monitoring.metricsscope.v1;

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
public class MetricsScopeName implements ResourceName {
  private static final PathTemplate METRICS_SCOPE =
      PathTemplate.createWithoutUrlEncoding("locations/global/metricsScope/{metrics_scope}");
  private volatile Map<String, String> fieldValuesMap;
  private final String metricsScope;

  @Deprecated
  protected MetricsScopeName() {
    metricsScope = null;
  }

  private MetricsScopeName(Builder builder) {
    metricsScope = Preconditions.checkNotNull(builder.getMetricsScope());
  }

  public String getMetricsScope() {
    return metricsScope;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MetricsScopeName of(String metricsScope) {
    return newBuilder().setMetricsScope(metricsScope).build();
  }

  public static String format(String metricsScope) {
    return newBuilder().setMetricsScope(metricsScope).build().toString();
  }

  public static MetricsScopeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        METRICS_SCOPE.validatedMatch(
            formattedString, "MetricsScopeName.parse: formattedString not in valid format");
    return of(matchMap.get("metrics_scope"));
  }

  public static List<MetricsScopeName> parseList(List<String> formattedStrings) {
    List<MetricsScopeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MetricsScopeName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MetricsScopeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return METRICS_SCOPE.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (metricsScope != null) {
            fieldMapBuilder.put("metrics_scope", metricsScope);
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
    return METRICS_SCOPE.instantiate("metrics_scope", metricsScope);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      MetricsScopeName that = ((MetricsScopeName) o);
      return Objects.equals(this.metricsScope, that.metricsScope);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(metricsScope);
    return h;
  }

  /** Builder for locations/global/metricsScope/{metrics_scope}. */
  public static class Builder {
    private String metricsScope;

    protected Builder() {}

    public String getMetricsScope() {
      return metricsScope;
    }

    public Builder setMetricsScope(String metricsScope) {
      this.metricsScope = metricsScope;
      return this;
    }

    private Builder(MetricsScopeName metricsScopeName) {
      this.metricsScope = metricsScopeName.metricsScope;
    }

    public MetricsScopeName build() {
      return new MetricsScopeName(this);
    }
  }
}
