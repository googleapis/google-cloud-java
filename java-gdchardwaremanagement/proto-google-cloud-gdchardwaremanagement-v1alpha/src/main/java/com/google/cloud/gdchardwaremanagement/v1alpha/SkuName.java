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

package com.google.cloud.gdchardwaremanagement.v1alpha;

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
public class SkuName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SKU =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}/skus/{sku}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String sku;

  @Deprecated
  protected SkuName() {
    project = null;
    location = null;
    sku = null;
  }

  private SkuName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    sku = Preconditions.checkNotNull(builder.getSku());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSku() {
    return sku;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SkuName of(String project, String location, String sku) {
    return newBuilder().setProject(project).setLocation(location).setSku(sku).build();
  }

  public static String format(String project, String location, String sku) {
    return newBuilder().setProject(project).setLocation(location).setSku(sku).build().toString();
  }

  public static SkuName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SKU.validatedMatch(
            formattedString, "SkuName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("sku"));
  }

  public static List<SkuName> parseList(List<String> formattedStrings) {
    List<SkuName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SkuName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SkuName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SKU.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (project != null) {
            fieldMapBuilder.put("project", project);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (sku != null) {
            fieldMapBuilder.put("sku", sku);
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
    return PROJECT_LOCATION_SKU.instantiate("project", project, "location", location, "sku", sku);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SkuName that = ((SkuName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.sku, that.sku);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(sku);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/skus/{sku}. */
  public static class Builder {
    private String project;
    private String location;
    private String sku;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSku() {
      return sku;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSku(String sku) {
      this.sku = sku;
      return this;
    }

    private Builder(SkuName skuName) {
      this.project = skuName.project;
      this.location = skuName.location;
      this.sku = skuName.sku;
    }

    public SkuName build() {
      return new SkuName(this);
    }
  }
}
