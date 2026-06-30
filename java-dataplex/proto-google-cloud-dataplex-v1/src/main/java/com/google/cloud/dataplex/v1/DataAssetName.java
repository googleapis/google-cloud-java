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

package com.google.cloud.dataplex.v1;

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
public class DataAssetName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATA_PRODUCT_DATA_ASSET =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataProducts/{data_product}/dataAssets/{data_asset}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String dataProduct;
  private final String dataAsset;

  @Deprecated
  protected DataAssetName() {
    project = null;
    location = null;
    dataProduct = null;
    dataAsset = null;
  }

  private DataAssetName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataProduct = Preconditions.checkNotNull(builder.getDataProduct());
    dataAsset = Preconditions.checkNotNull(builder.getDataAsset());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDataProduct() {
    return dataProduct;
  }

  public String getDataAsset() {
    return dataAsset;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DataAssetName of(
      String project, String location, String dataProduct, String dataAsset) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataProduct(dataProduct)
        .setDataAsset(dataAsset)
        .build();
  }

  public static String format(
      String project, String location, String dataProduct, String dataAsset) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataProduct(dataProduct)
        .setDataAsset(dataAsset)
        .build()
        .toString();
  }

  public static DataAssetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DATA_PRODUCT_DATA_ASSET.validatedMatch(
            formattedString, "DataAssetName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("data_product"),
        matchMap.get("data_asset"));
  }

  public static List<DataAssetName> parseList(List<String> formattedStrings) {
    List<DataAssetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DataAssetName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DataAssetName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATA_PRODUCT_DATA_ASSET.matches(formattedString);
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
          if (dataProduct != null) {
            fieldMapBuilder.put("data_product", dataProduct);
          }
          if (dataAsset != null) {
            fieldMapBuilder.put("data_asset", dataAsset);
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
    return PROJECT_LOCATION_DATA_PRODUCT_DATA_ASSET.instantiate(
        "project",
        project,
        "location",
        location,
        "data_product",
        dataProduct,
        "data_asset",
        dataAsset);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DataAssetName that = ((DataAssetName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataProduct, that.dataProduct)
          && Objects.equals(this.dataAsset, that.dataAsset);
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
    h ^= Objects.hashCode(dataProduct);
    h *= 1000003;
    h ^= Objects.hashCode(dataAsset);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/dataProducts/{data_product}/dataAssets/{data_asset}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataProduct;
    private String dataAsset;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDataProduct() {
      return dataProduct;
    }

    public String getDataAsset() {
      return dataAsset;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDataProduct(String dataProduct) {
      this.dataProduct = dataProduct;
      return this;
    }

    public Builder setDataAsset(String dataAsset) {
      this.dataAsset = dataAsset;
      return this;
    }

    private Builder(DataAssetName dataAssetName) {
      this.project = dataAssetName.project;
      this.location = dataAssetName.location;
      this.dataProduct = dataAssetName.dataProduct;
      this.dataAsset = dataAssetName.dataAsset;
    }

    public DataAssetName build() {
      return new DataAssetName(this);
    }
  }
}
