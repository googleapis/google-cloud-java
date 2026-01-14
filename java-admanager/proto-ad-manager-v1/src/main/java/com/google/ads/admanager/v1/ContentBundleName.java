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
public class ContentBundleName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_CONTENT_BUNDLE =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/contentBundles/{content_bundle}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String contentBundle;

  @Deprecated
  protected ContentBundleName() {
    networkCode = null;
    contentBundle = null;
  }

  private ContentBundleName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    contentBundle = Preconditions.checkNotNull(builder.getContentBundle());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getContentBundle() {
    return contentBundle;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ContentBundleName of(String networkCode, String contentBundle) {
    return newBuilder().setNetworkCode(networkCode).setContentBundle(contentBundle).build();
  }

  public static String format(String networkCode, String contentBundle) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setContentBundle(contentBundle)
        .build()
        .toString();
  }

  public static ContentBundleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_CONTENT_BUNDLE.validatedMatch(
            formattedString, "ContentBundleName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("content_bundle"));
  }

  public static List<ContentBundleName> parseList(List<String> formattedStrings) {
    List<ContentBundleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ContentBundleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ContentBundleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_CONTENT_BUNDLE.matches(formattedString);
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
          if (contentBundle != null) {
            fieldMapBuilder.put("content_bundle", contentBundle);
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
    return NETWORK_CODE_CONTENT_BUNDLE.instantiate(
        "network_code", networkCode, "content_bundle", contentBundle);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ContentBundleName that = ((ContentBundleName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.contentBundle, that.contentBundle);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(contentBundle);
    return h;
  }

  /** Builder for networks/{network_code}/contentBundles/{content_bundle}. */
  public static class Builder {
    private String networkCode;
    private String contentBundle;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getContentBundle() {
      return contentBundle;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setContentBundle(String contentBundle) {
      this.contentBundle = contentBundle;
      return this;
    }

    private Builder(ContentBundleName contentBundleName) {
      this.networkCode = contentBundleName.networkCode;
      this.contentBundle = contentBundleName.contentBundle;
    }

    public ContentBundleName build() {
      return new ContentBundleName(this);
    }
  }
}
