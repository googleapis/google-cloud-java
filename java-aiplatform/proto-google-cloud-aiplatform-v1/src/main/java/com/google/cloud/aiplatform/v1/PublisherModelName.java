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

package com.google.cloud.aiplatform.v1;

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
public class PublisherModelName implements ResourceName {
  private static final PathTemplate PUBLISHER_MODEL =
      PathTemplate.createWithoutUrlEncoding("publishers/{publisher}/models/{model}");
  private volatile Map<String, String> fieldValuesMap;
  private final String publisher;
  private final String model;

  @Deprecated
  protected PublisherModelName() {
    publisher = null;
    model = null;
  }

  private PublisherModelName(Builder builder) {
    publisher = Preconditions.checkNotNull(builder.getPublisher());
    model = Preconditions.checkNotNull(builder.getModel());
  }

  public String getPublisher() {
    return publisher;
  }

  public String getModel() {
    return model;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PublisherModelName of(String publisher, String model) {
    return newBuilder().setPublisher(publisher).setModel(model).build();
  }

  public static String format(String publisher, String model) {
    return newBuilder().setPublisher(publisher).setModel(model).build().toString();
  }

  public static PublisherModelName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PUBLISHER_MODEL.validatedMatch(
            formattedString, "PublisherModelName.parse: formattedString not in valid format");
    return of(matchMap.get("publisher"), matchMap.get("model"));
  }

  public static List<PublisherModelName> parseList(List<String> formattedStrings) {
    List<PublisherModelName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PublisherModelName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PublisherModelName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PUBLISHER_MODEL.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (publisher != null) {
            fieldMapBuilder.put("publisher", publisher);
          }
          if (model != null) {
            fieldMapBuilder.put("model", model);
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
    return PUBLISHER_MODEL.instantiate("publisher", publisher, "model", model);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PublisherModelName that = ((PublisherModelName) o);
      return Objects.equals(this.publisher, that.publisher)
          && Objects.equals(this.model, that.model);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(publisher);
    h *= 1000003;
    h ^= Objects.hashCode(model);
    return h;
  }

  /** Builder for publishers/{publisher}/models/{model}. */
  public static class Builder {
    private String publisher;
    private String model;

    protected Builder() {}

    public String getPublisher() {
      return publisher;
    }

    public String getModel() {
      return model;
    }

    public Builder setPublisher(String publisher) {
      this.publisher = publisher;
      return this;
    }

    public Builder setModel(String model) {
      this.model = model;
      return this;
    }

    private Builder(PublisherModelName publisherModelName) {
      this.publisher = publisherModelName.publisher;
      this.model = publisherModelName.model;
    }

    public PublisherModelName build() {
      return new PublisherModelName(this);
    }
  }
}
