/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import java.util.List;

class BigQueryConnectionProperty {

  private final String name;
  private final String description;
  private final String defaultValue;
  private final List<String> validValues;

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getDefaultValue() {
    return defaultValue;
  }

  public List<String> getValidValues() {
    return validValues;
  }

  BigQueryConnectionProperty(Builder builder) {
    this.name = builder.name;
    this.defaultValue = builder.defaultValue;
    this.description = builder.description;
    this.validValues = builder.validValues;
  }

  /** Returns a builder for a BigQueryConnectionProperty object. */
  static BigQueryConnectionProperty.Builder newBuilder() {
    return new BigQueryConnectionProperty.Builder();
  }

  BigQueryConnectionProperty.Builder toBuilder() {
    return new BigQueryConnectionProperty.Builder(this);
  }

  @Override
  public String toString() {
    return "BigQueryConnectionProperty{"
        + "name='"
        + name
        + '\''
        + ", description='"
        + description
        + '\''
        + ", defaultValue='"
        + defaultValue
        + '\''
        + ", validValues="
        + validValues
        + '}';
  }

  static final class Builder {

    private String name;
    private String description;
    private String defaultValue;
    private List<String> validValues;

    private Builder(BigQueryConnectionProperty bigQueryConnectionProperty) {
      this.name = bigQueryConnectionProperty.name;
      this.description = bigQueryConnectionProperty.description;
      this.defaultValue = bigQueryConnectionProperty.defaultValue;
      this.validValues = bigQueryConnectionProperty.validValues;
    }

    private Builder() {}

    Builder setName(String name) {
      this.name = name;
      return this;
    }

    Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    Builder setDefaultValue(String defaultValue) {
      this.defaultValue = defaultValue;
      return this;
    }

    Builder setValidValues(List<String> validValues) {
      this.validValues = validValues;
      return this;
    }

    BigQueryConnectionProperty build() {
      return new BigQueryConnectionProperty(this);
    }
  }
}
