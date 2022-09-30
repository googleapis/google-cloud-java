/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.recommendationengine.v1beta1;

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
public class PredictionApiKeyRegistrationName implements ResourceName {
  private static final PathTemplate
      PROJECT_LOCATION_CATALOG_EVENT_STORE_PREDICTION_API_KEY_REGISTRATION =
          PathTemplate.createWithoutUrlEncoding(
              "projects/{project}/locations/{location}/catalogs/{catalog}/eventStores/{event_store}/predictionApiKeyRegistrations/{prediction_api_key_registration}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String catalog;
  private final String eventStore;
  private final String predictionApiKeyRegistration;

  @Deprecated
  protected PredictionApiKeyRegistrationName() {
    project = null;
    location = null;
    catalog = null;
    eventStore = null;
    predictionApiKeyRegistration = null;
  }

  private PredictionApiKeyRegistrationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    catalog = Preconditions.checkNotNull(builder.getCatalog());
    eventStore = Preconditions.checkNotNull(builder.getEventStore());
    predictionApiKeyRegistration =
        Preconditions.checkNotNull(builder.getPredictionApiKeyRegistration());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getCatalog() {
    return catalog;
  }

  public String getEventStore() {
    return eventStore;
  }

  public String getPredictionApiKeyRegistration() {
    return predictionApiKeyRegistration;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PredictionApiKeyRegistrationName of(
      String project,
      String location,
      String catalog,
      String eventStore,
      String predictionApiKeyRegistration) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCatalog(catalog)
        .setEventStore(eventStore)
        .setPredictionApiKeyRegistration(predictionApiKeyRegistration)
        .build();
  }

  public static String format(
      String project,
      String location,
      String catalog,
      String eventStore,
      String predictionApiKeyRegistration) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCatalog(catalog)
        .setEventStore(eventStore)
        .setPredictionApiKeyRegistration(predictionApiKeyRegistration)
        .build()
        .toString();
  }

  public static PredictionApiKeyRegistrationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CATALOG_EVENT_STORE_PREDICTION_API_KEY_REGISTRATION.validatedMatch(
            formattedString,
            "PredictionApiKeyRegistrationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("catalog"),
        matchMap.get("event_store"),
        matchMap.get("prediction_api_key_registration"));
  }

  public static List<PredictionApiKeyRegistrationName> parseList(List<String> formattedStrings) {
    List<PredictionApiKeyRegistrationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PredictionApiKeyRegistrationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PredictionApiKeyRegistrationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CATALOG_EVENT_STORE_PREDICTION_API_KEY_REGISTRATION.matches(
        formattedString);
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
          if (catalog != null) {
            fieldMapBuilder.put("catalog", catalog);
          }
          if (eventStore != null) {
            fieldMapBuilder.put("event_store", eventStore);
          }
          if (predictionApiKeyRegistration != null) {
            fieldMapBuilder.put("prediction_api_key_registration", predictionApiKeyRegistration);
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
    return PROJECT_LOCATION_CATALOG_EVENT_STORE_PREDICTION_API_KEY_REGISTRATION.instantiate(
        "project",
        project,
        "location",
        location,
        "catalog",
        catalog,
        "event_store",
        eventStore,
        "prediction_api_key_registration",
        predictionApiKeyRegistration);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      PredictionApiKeyRegistrationName that = ((PredictionApiKeyRegistrationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.catalog, that.catalog)
          && Objects.equals(this.eventStore, that.eventStore)
          && Objects.equals(this.predictionApiKeyRegistration, that.predictionApiKeyRegistration);
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
    h ^= Objects.hashCode(catalog);
    h *= 1000003;
    h ^= Objects.hashCode(eventStore);
    h *= 1000003;
    h ^= Objects.hashCode(predictionApiKeyRegistration);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/catalogs/{catalog}/eventStores/{event_store}/predictionApiKeyRegistrations/{prediction_api_key_registration}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String catalog;
    private String eventStore;
    private String predictionApiKeyRegistration;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCatalog() {
      return catalog;
    }

    public String getEventStore() {
      return eventStore;
    }

    public String getPredictionApiKeyRegistration() {
      return predictionApiKeyRegistration;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCatalog(String catalog) {
      this.catalog = catalog;
      return this;
    }

    public Builder setEventStore(String eventStore) {
      this.eventStore = eventStore;
      return this;
    }

    public Builder setPredictionApiKeyRegistration(String predictionApiKeyRegistration) {
      this.predictionApiKeyRegistration = predictionApiKeyRegistration;
      return this;
    }

    private Builder(PredictionApiKeyRegistrationName predictionApiKeyRegistrationName) {
      this.project = predictionApiKeyRegistrationName.project;
      this.location = predictionApiKeyRegistrationName.location;
      this.catalog = predictionApiKeyRegistrationName.catalog;
      this.eventStore = predictionApiKeyRegistrationName.eventStore;
      this.predictionApiKeyRegistration =
          predictionApiKeyRegistrationName.predictionApiKeyRegistration;
    }

    public PredictionApiKeyRegistrationName build() {
      return new PredictionApiKeyRegistrationName(this);
    }
  }
}
