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

package com.google.analytics.data.v1alpha;

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
public class AudienceListName implements ResourceName {
  private static final PathTemplate PROPERTYID_AUDIENCELISTID =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{propertyId}/audienceLists/{audienceListId}");
  private volatile Map<String, String> fieldValuesMap;
  private final String propertyId;
  private final String audienceListId;

  @Deprecated
  protected AudienceListName() {
    propertyId = null;
    audienceListId = null;
  }

  private AudienceListName(Builder builder) {
    propertyId = Preconditions.checkNotNull(builder.getPropertyId());
    audienceListId = Preconditions.checkNotNull(builder.getAudienceListId());
  }

  public String getPropertyId() {
    return propertyId;
  }

  public String getAudienceListId() {
    return audienceListId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AudienceListName of(String propertyId, String audienceListId) {
    return newBuilder().setPropertyId(propertyId).setAudienceListId(audienceListId).build();
  }

  public static String format(String propertyId, String audienceListId) {
    return newBuilder()
        .setPropertyId(propertyId)
        .setAudienceListId(audienceListId)
        .build()
        .toString();
  }

  public static AudienceListName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTYID_AUDIENCELISTID.validatedMatch(
            formattedString, "AudienceListName.parse: formattedString not in valid format");
    return of(matchMap.get("propertyId"), matchMap.get("audienceListId"));
  }

  public static List<AudienceListName> parseList(List<String> formattedStrings) {
    List<AudienceListName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AudienceListName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AudienceListName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTYID_AUDIENCELISTID.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (propertyId != null) {
            fieldMapBuilder.put("propertyId", propertyId);
          }
          if (audienceListId != null) {
            fieldMapBuilder.put("audienceListId", audienceListId);
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
    return PROPERTYID_AUDIENCELISTID.instantiate(
        "propertyId", propertyId, "audienceListId", audienceListId);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AudienceListName that = ((AudienceListName) o);
      return Objects.equals(this.propertyId, that.propertyId)
          && Objects.equals(this.audienceListId, that.audienceListId);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(propertyId);
    h *= 1000003;
    h ^= Objects.hashCode(audienceListId);
    return h;
  }

  /** Builder for properties/{propertyId}/audienceLists/{audienceListId}. */
  public static class Builder {
    private String propertyId;
    private String audienceListId;

    protected Builder() {}

    public String getPropertyId() {
      return propertyId;
    }

    public String getAudienceListId() {
      return audienceListId;
    }

    public Builder setPropertyId(String propertyId) {
      this.propertyId = propertyId;
      return this;
    }

    public Builder setAudienceListId(String audienceListId) {
      this.audienceListId = audienceListId;
      return this;
    }

    private Builder(AudienceListName audienceListName) {
      this.propertyId = audienceListName.propertyId;
      this.audienceListId = audienceListName.audienceListId;
    }

    public AudienceListName build() {
      return new AudienceListName(this);
    }
  }
}
