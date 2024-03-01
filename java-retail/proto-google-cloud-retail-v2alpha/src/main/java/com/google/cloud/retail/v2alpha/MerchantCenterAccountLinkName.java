/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.retail.v2alpha;

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
public class MerchantCenterAccountLinkName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CATALOG_MERCHANT_CENTER_ACCOUNT_LINK =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/catalogs/{catalog}/merchantCenterAccountLinks/{merchant_center_account_link}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String catalog;
  private final String merchantCenterAccountLink;

  @Deprecated
  protected MerchantCenterAccountLinkName() {
    project = null;
    location = null;
    catalog = null;
    merchantCenterAccountLink = null;
  }

  private MerchantCenterAccountLinkName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    catalog = Preconditions.checkNotNull(builder.getCatalog());
    merchantCenterAccountLink = Preconditions.checkNotNull(builder.getMerchantCenterAccountLink());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getCatalog() {
    return catalog;
  }

  public String getMerchantCenterAccountLink() {
    return merchantCenterAccountLink;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MerchantCenterAccountLinkName of(
      String project, String location, String catalog, String merchantCenterAccountLink) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCatalog(catalog)
        .setMerchantCenterAccountLink(merchantCenterAccountLink)
        .build();
  }

  public static String format(
      String project, String location, String catalog, String merchantCenterAccountLink) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCatalog(catalog)
        .setMerchantCenterAccountLink(merchantCenterAccountLink)
        .build()
        .toString();
  }

  public static MerchantCenterAccountLinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CATALOG_MERCHANT_CENTER_ACCOUNT_LINK.validatedMatch(
            formattedString,
            "MerchantCenterAccountLinkName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("catalog"),
        matchMap.get("merchant_center_account_link"));
  }

  public static List<MerchantCenterAccountLinkName> parseList(List<String> formattedStrings) {
    List<MerchantCenterAccountLinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MerchantCenterAccountLinkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MerchantCenterAccountLinkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CATALOG_MERCHANT_CENTER_ACCOUNT_LINK.matches(formattedString);
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
          if (catalog != null) {
            fieldMapBuilder.put("catalog", catalog);
          }
          if (merchantCenterAccountLink != null) {
            fieldMapBuilder.put("merchant_center_account_link", merchantCenterAccountLink);
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
    return PROJECT_LOCATION_CATALOG_MERCHANT_CENTER_ACCOUNT_LINK.instantiate(
        "project",
        project,
        "location",
        location,
        "catalog",
        catalog,
        "merchant_center_account_link",
        merchantCenterAccountLink);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MerchantCenterAccountLinkName that = ((MerchantCenterAccountLinkName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.catalog, that.catalog)
          && Objects.equals(this.merchantCenterAccountLink, that.merchantCenterAccountLink);
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
    h ^= Objects.hashCode(catalog);
    h *= 1000003;
    h ^= Objects.hashCode(merchantCenterAccountLink);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/catalogs/{catalog}/merchantCenterAccountLinks/{merchant_center_account_link}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String catalog;
    private String merchantCenterAccountLink;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCatalog() {
      return catalog;
    }

    public String getMerchantCenterAccountLink() {
      return merchantCenterAccountLink;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCatalog(String catalog) {
      this.catalog = catalog;
      return this;
    }

    public Builder setMerchantCenterAccountLink(String merchantCenterAccountLink) {
      this.merchantCenterAccountLink = merchantCenterAccountLink;
      return this;
    }

    private Builder(MerchantCenterAccountLinkName merchantCenterAccountLinkName) {
      this.project = merchantCenterAccountLinkName.project;
      this.location = merchantCenterAccountLinkName.location;
      this.catalog = merchantCenterAccountLinkName.catalog;
      this.merchantCenterAccountLink = merchantCenterAccountLinkName.merchantCenterAccountLink;
    }

    public MerchantCenterAccountLinkName build() {
      return new MerchantCenterAccountLinkName(this);
    }
  }
}
