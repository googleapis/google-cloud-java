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
public class ContentName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_CONTENT =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/content/{content}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String content;

  @Deprecated
  protected ContentName() {
    networkCode = null;
    content = null;
  }

  private ContentName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    content = Preconditions.checkNotNull(builder.getContent());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getContent() {
    return content;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ContentName of(String networkCode, String content) {
    return newBuilder().setNetworkCode(networkCode).setContent(content).build();
  }

  public static String format(String networkCode, String content) {
    return newBuilder().setNetworkCode(networkCode).setContent(content).build().toString();
  }

  public static ContentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_CONTENT.validatedMatch(
            formattedString, "ContentName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("content"));
  }

  public static List<ContentName> parseList(List<String> formattedStrings) {
    List<ContentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ContentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ContentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_CONTENT.matches(formattedString);
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
          if (content != null) {
            fieldMapBuilder.put("content", content);
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
    return NETWORK_CODE_CONTENT.instantiate("network_code", networkCode, "content", content);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ContentName that = ((ContentName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.content, that.content);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(content);
    return h;
  }

  /** Builder for networks/{network_code}/content/{content}. */
  public static class Builder {
    private String networkCode;
    private String content;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getContent() {
      return content;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setContent(String content) {
      this.content = content;
      return this;
    }

    private Builder(ContentName contentName) {
      this.networkCode = contentName.networkCode;
      this.content = contentName.content;
    }

    public ContentName build() {
      return new ContentName(this);
    }
  }
}
