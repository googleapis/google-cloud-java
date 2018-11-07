/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.vision.v1;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ProductName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}/products/{product}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String product;

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getProduct() {
    return product;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProductName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    product = Preconditions.checkNotNull(builder.getProduct());
  }

  public static ProductName of(String project, String location, String product) {
    return newBuilder()
      .setProject(project)
      .setLocation(location)
      .setProduct(product)
      .build();
  }

  public static String format(String project, String location, String product) {
    return newBuilder()
      .setProject(project)
      .setLocation(location)
      .setProduct(product)
      .build()
      .toString();
  }

  public static ProductName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "ProductName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("product"));
  }

  public static List<ProductName> parseList(List<String> formattedStrings) {
    List<ProductName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProductName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ProductName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("location", location);
          fieldMapBuilder.put("product", product);
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
    return PATH_TEMPLATE.instantiate("project", project, "location", location, "product", product);
  }

  /** Builder for ProductName. */
  public static class Builder {

    private String project;
    private String location;
    private String product;

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getProduct() {
      return product;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setProduct(String product) {
      this.product = product;
      return this;
    }

    private Builder() {
    }

    private Builder(ProductName productName) {
      project = productName.project;
      location = productName.location;
      product = productName.product;
    }

    public ProductName build() {
      return new ProductName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProductName) {
      ProductName that = (ProductName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.product.equals(that.product));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= location.hashCode();
    h *= 1000003;
    h ^= product.hashCode();
    return h;
  }
}

