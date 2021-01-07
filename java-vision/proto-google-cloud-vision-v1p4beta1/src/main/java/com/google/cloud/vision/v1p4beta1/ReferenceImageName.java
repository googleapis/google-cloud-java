/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.vision.v1p4beta1;

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
public class ReferenceImageName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PRODUCT_REFERENCE_IMAGE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/products/{product}/referenceImages/{reference_image}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String product;
  private final String referenceImage;

  @Deprecated
  protected ReferenceImageName() {
    project = null;
    location = null;
    product = null;
    referenceImage = null;
  }

  private ReferenceImageName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    product = Preconditions.checkNotNull(builder.getProduct());
    referenceImage = Preconditions.checkNotNull(builder.getReferenceImage());
  }

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
        PROJECT_LOCATION_PRODUCT_REFERENCE_IMAGE.validatedMatch(
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
    List<String> list = new ArrayList<>(values.size());
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
    return PROJECT_LOCATION_PRODUCT_REFERENCE_IMAGE.matches(formattedString);
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
          if (product != null) {
            fieldMapBuilder.put("product", product);
          }
          if (referenceImage != null) {
            fieldMapBuilder.put("reference_image", referenceImage);
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
    return PROJECT_LOCATION_PRODUCT_REFERENCE_IMAGE.instantiate(
        "project",
        project,
        "location",
        location,
        "product",
        product,
        "reference_image",
        referenceImage);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ReferenceImageName that = ((ReferenceImageName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.product, that.product)
          && Objects.equals(this.referenceImage, that.referenceImage);
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
    h ^= Objects.hashCode(product);
    h *= 1000003;
    h ^= Objects.hashCode(referenceImage);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/products/{product}/referenceImages/{reference_image}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String product;
    private String referenceImage;

    protected Builder() {}

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
}
