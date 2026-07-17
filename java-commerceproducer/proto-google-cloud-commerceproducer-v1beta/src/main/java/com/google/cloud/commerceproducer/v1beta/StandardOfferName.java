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
public class StandardOfferName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SERVICE_STANDARD_OFFER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/services/{service}/standardOffers/{standard_offer}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String service;
  private final String standardOffer;

  @Deprecated
  protected StandardOfferName() {
    project = null;
    location = null;
    service = null;
    standardOffer = null;
  }

  private StandardOfferName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    service = Preconditions.checkNotNull(builder.getService());
    standardOffer = Preconditions.checkNotNull(builder.getStandardOffer());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getService() {
    return service;
  }

  public String getStandardOffer() {
    return standardOffer;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static StandardOfferName of(
      String project, String location, String service, String standardOffer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setService(service)
        .setStandardOffer(standardOffer)
        .build();
  }

  public static String format(
      String project, String location, String service, String standardOffer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setService(service)
        .setStandardOffer(standardOffer)
        .build()
        .toString();
  }

  public static @Nullable StandardOfferName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SERVICE_STANDARD_OFFER.validatedMatch(
            formattedString, "StandardOfferName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("service"),
        matchMap.get("standard_offer"));
  }

  public static List<StandardOfferName> parseList(List<String> formattedStrings) {
    List<StandardOfferName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable StandardOfferName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (StandardOfferName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SERVICE_STANDARD_OFFER.matches(formattedString);
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
          if (service != null) {
            fieldMapBuilder.put("service", service);
          }
          if (standardOffer != null) {
            fieldMapBuilder.put("standard_offer", standardOffer);
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
    return PROJECT_LOCATION_SERVICE_STANDARD_OFFER.instantiate(
        "project",
        project,
        "location",
        location,
        "service",
        service,
        "standard_offer",
        standardOffer);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      StandardOfferName that = ((StandardOfferName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.service, that.service)
          && Objects.equals(this.standardOffer, that.standardOffer);
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
    h ^= Objects.hashCode(service);
    h *= 1000003;
    h ^= Objects.hashCode(standardOffer);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/services/{service}/standardOffers/{standard_offer}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String service;
    private String standardOffer;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getService() {
      return service;
    }

    public String getStandardOffer() {
      return standardOffer;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setService(String service) {
      this.service = service;
      return this;
    }

    public Builder setStandardOffer(String standardOffer) {
      this.standardOffer = standardOffer;
      return this;
    }

    private Builder(StandardOfferName standardOfferName) {
      this.project = standardOfferName.project;
      this.location = standardOfferName.location;
      this.service = standardOfferName.service;
      this.standardOffer = standardOfferName.standardOffer;
    }

    public StandardOfferName build() {
      return new StandardOfferName(this);
    }
  }
}
