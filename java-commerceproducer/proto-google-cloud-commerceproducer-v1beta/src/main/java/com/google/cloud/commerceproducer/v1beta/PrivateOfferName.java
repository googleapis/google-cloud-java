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

package com.google.cloud.commerceproducer.v1beta;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class PrivateOfferName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PRIVATE_OFFER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/privateOffers/{private_offer}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String privateOffer;

  @Deprecated
  protected PrivateOfferName() {
    project = null;
    location = null;
    privateOffer = null;
  }

  private PrivateOfferName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    privateOffer = Preconditions.checkNotNull(builder.getPrivateOffer());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getPrivateOffer() {
    return privateOffer;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PrivateOfferName of(String project, String location, String privateOffer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPrivateOffer(privateOffer)
        .build();
  }

  public static String format(String project, String location, String privateOffer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPrivateOffer(privateOffer)
        .build()
        .toString();
  }

  public static @Nullable PrivateOfferName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PRIVATE_OFFER.validatedMatch(
            formattedString, "PrivateOfferName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("private_offer"));
  }

  public static List<PrivateOfferName> parseList(List<String> formattedStrings) {
    List<PrivateOfferName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable PrivateOfferName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PrivateOfferName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PRIVATE_OFFER.matches(formattedString);
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
          if (privateOffer != null) {
            fieldMapBuilder.put("private_offer", privateOffer);
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
    return PROJECT_LOCATION_PRIVATE_OFFER.instantiate(
        "project", project, "location", location, "private_offer", privateOffer);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PrivateOfferName that = ((PrivateOfferName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.privateOffer, that.privateOffer);
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
    h ^= Objects.hashCode(privateOffer);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/privateOffers/{private_offer}. */
  public static class Builder {
    private String project;
    private String location;
    private String privateOffer;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getPrivateOffer() {
      return privateOffer;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setPrivateOffer(String privateOffer) {
      this.privateOffer = privateOffer;
      return this;
    }

    private Builder(PrivateOfferName privateOfferName) {
      this.project = privateOfferName.project;
      this.location = privateOfferName.location;
      this.privateOffer = privateOfferName.privateOffer;
    }

    public PrivateOfferName build() {
      return new PrivateOfferName(this);
    }
  }
}
