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

package com.google.example.library.v1;

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
public class ShelfName implements ResourceName {
  private static final PathTemplate SHELF_ID =
      PathTemplate.createWithoutUrlEncoding("shelves/{shelf_id}");
  private volatile Map<String, String> fieldValuesMap;
  private final String shelfId;

  @Deprecated
  protected ShelfName() {
    shelfId = null;
  }

  private ShelfName(Builder builder) {
    shelfId = Preconditions.checkNotNull(builder.getShelfId());
  }

  public String getShelfId() {
    return shelfId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ShelfName of(String shelfId) {
    return newBuilder().setShelfId(shelfId).build();
  }

  public static String format(String shelfId) {
    return newBuilder().setShelfId(shelfId).build().toString();
  }

  public static ShelfName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        SHELF_ID.validatedMatch(
            formattedString, "ShelfName.parse: formattedString not in valid format");
    return of(matchMap.get("shelf_id"));
  }

  public static List<ShelfName> parseList(List<String> formattedStrings) {
    List<ShelfName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ShelfName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ShelfName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return SHELF_ID.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (shelfId != null) {
            fieldMapBuilder.put("shelf_id", shelfId);
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
    return SHELF_ID.instantiate("shelf_id", shelfId);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ShelfName that = ((ShelfName) o);
      return Objects.equals(this.shelfId, that.shelfId);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(shelfId);
    return h;
  }

  /** Builder for shelves/{shelf_id}. */
  public static class Builder {
    private String shelfId;

    protected Builder() {}

    public String getShelfId() {
      return shelfId;
    }

    public Builder setShelfId(String shelfId) {
      this.shelfId = shelfId;
      return this;
    }

    private Builder(ShelfName shelfName) {
      this.shelfId = shelfName.shelfId;
    }

    public ShelfName build() {
      return new ShelfName(this);
    }
  }
}
