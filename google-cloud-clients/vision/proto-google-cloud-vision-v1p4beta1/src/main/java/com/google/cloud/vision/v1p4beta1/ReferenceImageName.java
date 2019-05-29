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

package com.google.cloud.vision.v1p4beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ReferenceImageName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/products/{product}/referenceImages/{reference_image}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String product;
  private final String referenceImage;

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getProduct() {
    return product;
  }

  public String getReferenceImage() {
    return referenceImage;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ReferenceImageName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    product = Preconditions.checkNotNull(builder.getProduct());
    referenceImage = Preconditions.checkNotNull(builder.getReferenceImage());
  }

  public static ReferenceImageName of(
      String project, String location, String product, String referenceImage) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setProduct(product)
        .setReferenceImage(referenceImage)
        .build();
  }

  public static String format(
      String project, String location, String product, String referenceImage) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setProduct(product)
        .setReferenceImage(referenceImage)
        .build()
        .toString();
  }

  public static ReferenceImageName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "ReferenceImageName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("product"),
        matchMap.get("reference_image"));
  }

  public static List<ReferenceImageName> parseList(List<String> formattedStrings) {
    List<ReferenceImageName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ReferenceImageName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ReferenceImageName value : values) {
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
          fieldMapBuilder.put("referenceImage", referenceImage);
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
    return PATH_TEMPLATE.instantiate(
        "project",
        project,
        "location",
        location,
        "product",
        product,
        "reference_image",
        referenceImage);
  }

  /** Builder for ReferenceImageName. */
  public static class Builder {

    private String project;
    private String location;
    private String product;
    private String referenceImage;

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getProduct() {
      return product;
    }

    public String getReferenceImage() {
      return referenceImage;
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

    public Builder setReferenceImage(String referenceImage) {
      this.referenceImage = referenceImage;
      return this;
    }

    private Builder() {}

    private Builder(ReferenceImageName referenceImageName) {
      project = referenceImageName.project;
      location = referenceImageName.location;
      product = referenceImageName.product;
      referenceImage = referenceImageName.referenceImage;
    }

    public ReferenceImageName build() {
      return new ReferenceImageName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ReferenceImageName) {
      ReferenceImageName that = (ReferenceImageName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.product.equals(that.product))
          && (this.referenceImage.equals(that.referenceImage));
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
    h *= 1000003;
    h ^= referenceImage.hashCode();
    return h;
  }
}
