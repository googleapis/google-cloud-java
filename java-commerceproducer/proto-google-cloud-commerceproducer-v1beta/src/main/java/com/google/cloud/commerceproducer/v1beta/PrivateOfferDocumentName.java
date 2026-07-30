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
public class PrivateOfferDocumentName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PRIVATE_OFFER_DOCUMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/privateOffers/{private_offer}/documents/{document}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String privateOffer;
  private final String document;

  @Deprecated
  protected PrivateOfferDocumentName() {
    project = null;
    location = null;
    privateOffer = null;
    document = null;
  }

  private PrivateOfferDocumentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    privateOffer = Preconditions.checkNotNull(builder.getPrivateOffer());
    document = Preconditions.checkNotNull(builder.getDocument());
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

  public String getDocument() {
    return document;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PrivateOfferDocumentName of(
      String project, String location, String privateOffer, String document) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPrivateOffer(privateOffer)
        .setDocument(document)
        .build();
  }

  public static String format(
      String project, String location, String privateOffer, String document) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPrivateOffer(privateOffer)
        .setDocument(document)
        .build()
        .toString();
  }

  public static @Nullable PrivateOfferDocumentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PRIVATE_OFFER_DOCUMENT.validatedMatch(
            formattedString, "PrivateOfferDocumentName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("private_offer"),
        matchMap.get("document"));
  }

  public static List<PrivateOfferDocumentName> parseList(List<String> formattedStrings) {
    List<PrivateOfferDocumentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable PrivateOfferDocumentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PrivateOfferDocumentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PRIVATE_OFFER_DOCUMENT.matches(formattedString);
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
          if (document != null) {
            fieldMapBuilder.put("document", document);
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
    return PROJECT_LOCATION_PRIVATE_OFFER_DOCUMENT.instantiate(
        "project",
        project,
        "location",
        location,
        "private_offer",
        privateOffer,
        "document",
        document);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PrivateOfferDocumentName that = ((PrivateOfferDocumentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.privateOffer, that.privateOffer)
          && Objects.equals(this.document, that.document);
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
    h *= 1000003;
    h ^= Objects.hashCode(document);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/privateOffers/{private_offer}/documents/{document}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String privateOffer;
    private String document;

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

    public String getDocument() {
      return document;
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

    public Builder setDocument(String document) {
      this.document = document;
      return this;
    }

    private Builder(PrivateOfferDocumentName privateOfferDocumentName) {
      this.project = privateOfferDocumentName.project;
      this.location = privateOfferDocumentName.location;
      this.privateOffer = privateOfferDocumentName.privateOffer;
      this.document = privateOfferDocumentName.document;
    }

    public PrivateOfferDocumentName build() {
      return new PrivateOfferDocumentName(this);
    }
  }
}
