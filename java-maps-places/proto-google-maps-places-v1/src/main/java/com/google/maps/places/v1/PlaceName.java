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

package com.google.maps.places.v1;

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
public class PlaceName implements ResourceName {
  private static final PathTemplate PLACE_ID =
      PathTemplate.createWithoutUrlEncoding("places/{place_id}");
  private volatile Map<String, String> fieldValuesMap;
  private final String placeId;

  @Deprecated
  protected PlaceName() {
    placeId = null;
  }

  private PlaceName(Builder builder) {
    placeId = Preconditions.checkNotNull(builder.getPlaceId());
  }

  public String getPlaceId() {
    return placeId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PlaceName of(String placeId) {
    return newBuilder().setPlaceId(placeId).build();
  }

  public static String format(String placeId) {
    return newBuilder().setPlaceId(placeId).build().toString();
  }

  public static PlaceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PLACE_ID.validatedMatch(
            formattedString, "PlaceName.parse: formattedString not in valid format");
    return of(matchMap.get("place_id"));
  }

  public static List<PlaceName> parseList(List<String> formattedStrings) {
    List<PlaceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PlaceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PlaceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PLACE_ID.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (placeId != null) {
            fieldMapBuilder.put("place_id", placeId);
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
    return PLACE_ID.instantiate("place_id", placeId);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PlaceName that = ((PlaceName) o);
      return Objects.equals(this.placeId, that.placeId);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(placeId);
    return h;
  }

  /** Builder for places/{place_id}. */
  public static class Builder {
    private String placeId;

    protected Builder() {}

    public String getPlaceId() {
      return placeId;
    }

    public Builder setPlaceId(String placeId) {
      this.placeId = placeId;
      return this;
    }

    private Builder(PlaceName placeName) {
      this.placeId = placeName.placeId;
    }

    public PlaceName build() {
      return new PlaceName(this);
    }
  }
}
