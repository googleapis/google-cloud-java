/*
 * Copyright 2023 Google LLC
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
public class PhotoMediaName implements ResourceName {
  private static final PathTemplate PLACE_ID_PHOTO_REFERENCE =
      PathTemplate.createWithoutUrlEncoding("places/{place_id}/photos/{photo_reference}/media");
  private volatile Map<String, String> fieldValuesMap;
  private final String placeId;
  private final String photoReference;

  @Deprecated
  protected PhotoMediaName() {
    placeId = null;
    photoReference = null;
  }

  private PhotoMediaName(Builder builder) {
    placeId = Preconditions.checkNotNull(builder.getPlaceId());
    photoReference = Preconditions.checkNotNull(builder.getPhotoReference());
  }

  public String getPlaceId() {
    return placeId;
  }

  public String getPhotoReference() {
    return photoReference;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PhotoMediaName of(String placeId, String photoReference) {
    return newBuilder().setPlaceId(placeId).setPhotoReference(photoReference).build();
  }

  public static String format(String placeId, String photoReference) {
    return newBuilder().setPlaceId(placeId).setPhotoReference(photoReference).build().toString();
  }

  public static PhotoMediaName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PLACE_ID_PHOTO_REFERENCE.validatedMatch(
            formattedString, "PhotoMediaName.parse: formattedString not in valid format");
    return of(matchMap.get("place_id"), matchMap.get("photo_reference"));
  }

  public static List<PhotoMediaName> parseList(List<String> formattedStrings) {
    List<PhotoMediaName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PhotoMediaName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PhotoMediaName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PLACE_ID_PHOTO_REFERENCE.matches(formattedString);
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
          if (photoReference != null) {
            fieldMapBuilder.put("photo_reference", photoReference);
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
    return PLACE_ID_PHOTO_REFERENCE.instantiate(
        "place_id", placeId, "photo_reference", photoReference);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PhotoMediaName that = ((PhotoMediaName) o);
      return Objects.equals(this.placeId, that.placeId)
          && Objects.equals(this.photoReference, that.photoReference);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(placeId);
    h *= 1000003;
    h ^= Objects.hashCode(photoReference);
    return h;
  }

  /** Builder for places/{place_id}/photos/{photo_reference}/media. */
  public static class Builder {
    private String placeId;
    private String photoReference;

    protected Builder() {}

    public String getPlaceId() {
      return placeId;
    }

    public String getPhotoReference() {
      return photoReference;
    }

    public Builder setPlaceId(String placeId) {
      this.placeId = placeId;
      return this;
    }

    public Builder setPhotoReference(String photoReference) {
      this.photoReference = photoReference;
      return this;
    }

    private Builder(PhotoMediaName photoMediaName) {
      this.placeId = photoMediaName.placeId;
      this.photoReference = photoMediaName.photoReference;
    }

    public PhotoMediaName build() {
      return new PhotoMediaName(this);
    }
  }
}
