/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.bigquery;

import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableList;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery Load Job configuration. A Load Job loads data from one of several formats into a
 * table. Data is provided as URIs that point to objects in Google Cloud Storage.
 */
public class LoadJobConfiguration extends LoadConfiguration
    implements JobConfiguration, Serializable {

  private static final long serialVersionUID = -2673554846792429829L;

  private final List<String> sourceUris;

  public static final class Builder
      extends LoadConfiguration.Builder<LoadJobConfiguration, Builder> {

    private List<String> sourceUris;

    private Builder() {
      super();
    }

    private Builder(LoadJobConfiguration loadConfiguration) {
      super(loadConfiguration);
      this.sourceUris = loadConfiguration.sourceUris;
    }

    private Builder(com.google.api.services.bigquery.model.JobConfiguration configurationPb) {
      super(configurationPb);
      if (configurationPb.getLoad().getSourceUris() != null) {
        this.sourceUris = ImmutableList.copyOf(configurationPb.getLoad().getSourceUris());
      }
    }

    /**
     * Sets the fully-qualified URIs that point to source data in Google Cloud Storage (e.g.
     * gs://bucket/path). Each URI can contain one '*' wildcard character and it must come after the
     * 'bucket' name.
     */
    public Builder sourceUris(List<String> sourceUris) {
      this.sourceUris = sourceUris != null ? ImmutableList.copyOf(sourceUris) : null;
      return this;
    }

    @Override
    public LoadJobConfiguration build() {
      return new LoadJobConfiguration(this);
    }
  }

  private LoadJobConfiguration(Builder builder) {
    super(builder);
    this.sourceUris = builder.sourceUris;
  }

  @Override
  public Type type() {
    return Type.LOAD;
  }

  /**
   * Returns the fully-qualified URIs that point to source data in Google Cloud Storage (e.g.
   * gs://bucket/path). Each URI can contain one '*' wildcard character and it must come after the
   * 'bucket' name.
   */
  public List<String> sourceUris() {
    return sourceUris;
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  ToStringHelper toStringHelper() {
    return super.toStringHelper().add("sourceUris", sourceUris);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof LoadJobConfiguration
        && Objects.equals(toPb(), ((LoadJobConfiguration) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), sourceUris);
  }

  com.google.api.services.bigquery.model.JobConfiguration toPb() {
    com.google.api.services.bigquery.model.JobConfiguration configurationPb = super.toPb();
    if (sourceUris != null) {
      configurationPb.getLoad().setSourceUris(ImmutableList.copyOf(sourceUris));
    }
    return configurationPb;
  }

  /**
   * Creates a builder for a BigQuery Load Job configuration given the destination table and source
   * URIs.
   */
  public static Builder builder(TableId destinationTable, List<String> sourceUris) {
    return new Builder().destinationTable(destinationTable).sourceUris(sourceUris);
  }

  /**
   * Creates a builder for a BigQuery Load Job configuration given the destination table and source
   * URI.
   */
  public static Builder builder(TableId destinationTable, String sourceUri) {
    return builder(destinationTable, ImmutableList.of(sourceUri));
  }

  /**
   * Creates a builder for a BigQuery Load Job configuration given the destination table, format and
   * source URIs.
   */
  public static Builder builder(TableId destinationTable, List<String> sourceUris,
      FormatOptions format) {
    return builder(destinationTable, sourceUris).formatOptions(format);
  }

  /**
   * Creates a builder for a BigQuery Load Job configuration given the destination table, format and
   * source URI.
   */
  public static Builder builder(TableId destinationTable, String sourceUri, FormatOptions format) {
    return builder(destinationTable, ImmutableList.of(sourceUri), format);
  }

  /**
   * Returns a BigQuery Load Job Configuration for the given destination table and source URIs.
   */
  public static LoadJobConfiguration of(TableId destinationTable, List<String> sourceUris) {
    return builder(destinationTable, sourceUris).build();
  }

  /**
   * Returns a BigQuery Load Job Configuration for the given destination table and source URI.
   */
  public static LoadJobConfiguration of(TableId destinationTable, String sourceUri) {
    return of(destinationTable, ImmutableList.of(sourceUri));
  }

  /**
   * Returns a BigQuery Load Job Configuration for the given destination table, format and source
   * URI.
   */
  public static LoadJobConfiguration of(TableId destinationTable, List<String> sourceUris,
      FormatOptions format) {
    return builder(destinationTable, sourceUris, format).build();
  }

  /**
   * Returns a BigQuery Load Job Configuration for the given destination table, format and source
   * URI.
   */
  public static LoadJobConfiguration of(TableId destinationTable, String sourceUri,
      FormatOptions format) {
    return of(destinationTable, ImmutableList.of(sourceUri), format);
  }

  static LoadJobConfiguration fromPb(
      com.google.api.services.bigquery.model.JobConfiguration confPb) {
    return new Builder(confPb).build();
  }
}
