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
public class ContentLabelName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_CONTENT_LABEL =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/contentLabels/{content_label}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String contentLabel;

  @Deprecated
  protected ContentLabelName() {
    networkCode = null;
    contentLabel = null;
  }

  private ContentLabelName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    contentLabel = Preconditions.checkNotNull(builder.getContentLabel());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getContentLabel() {
    return contentLabel;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ContentLabelName of(String networkCode, String contentLabel) {
    return newBuilder().setNetworkCode(networkCode).setContentLabel(contentLabel).build();
  }

  public static String format(String networkCode, String contentLabel) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setContentLabel(contentLabel)
        .build()
        .toString();
  }

  public static ContentLabelName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_CONTENT_LABEL.validatedMatch(
            formattedString, "ContentLabelName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("content_label"));
  }

  public static List<ContentLabelName> parseList(List<String> formattedStrings) {
    List<ContentLabelName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ContentLabelName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ContentLabelName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_CONTENT_LABEL.matches(formattedString);
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
          if (contentLabel != null) {
            fieldMapBuilder.put("content_label", contentLabel);
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
    return NETWORK_CODE_CONTENT_LABEL.instantiate(
        "network_code", networkCode, "content_label", contentLabel);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ContentLabelName that = ((ContentLabelName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.contentLabel, that.contentLabel);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(contentLabel);
    return h;
  }

  /** Builder for networks/{network_code}/contentLabels/{content_label}. */
  public static class Builder {
    private String networkCode;
    private String contentLabel;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getContentLabel() {
      return contentLabel;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setContentLabel(String contentLabel) {
      this.contentLabel = contentLabel;
      return this;
    }

    private Builder(ContentLabelName contentLabelName) {
      this.networkCode = contentLabelName.networkCode;
      this.contentLabel = contentLabelName.contentLabel;
    }

    public ContentLabelName build() {
      return new ContentLabelName(this);
    }
  }
}
