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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.bigquery.model.Job;
import com.google.api.services.bigquery.model.JobConfiguration;
import com.google.api.services.bigquery.model.JobConfigurationLoad;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableList;
import com.google.gcloud.bigquery.JobStatistics.LoadStatistics;

import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery Load Job. A Load Job loads data from one of several formats into a table. Data is
 * provided as URIs that point to objects in Google Cloud Storage.
 */
public class LoadJobInfo extends JobInfo<LoadStatistics> {

  private static final long serialVersionUID = 6349304826867750535L;

  private final List<String> sourceUris;
  private final LoadConfiguration configuration;

  public static final class Builder extends JobInfo.Builder<LoadJobInfo, LoadStatistics, Builder> {

    private List<String> sourceUris;
    private LoadConfiguration configuration;

    private Builder() {}

    private Builder(LoadJobInfo jobInfo) {
      super(jobInfo);
      this.sourceUris = jobInfo.sourceUris;
      this.configuration = jobInfo.configuration;
    }

    private Builder(Job jobPb) {
      super(jobPb);
      JobConfigurationLoad loadConfigurationPb = jobPb.getConfiguration().getLoad();
      this.configuration = LoadConfiguration.fromPb(loadConfigurationPb);
      this.sourceUris = loadConfigurationPb.getSourceUris();
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

    /**
     * Sets the configuration for the BigQuery Load Job.
     */
    public Builder configuration(LoadConfiguration configuration) {
      this.configuration = configuration;
      return this;
    }

    @Override
    public LoadJobInfo build() {
      return new LoadJobInfo(this);
    }
  }

  private LoadJobInfo(Builder builder) {
    super(builder);
    this.sourceUris = builder.sourceUris;
    this.configuration = builder.configuration;
  }

  /**
   * Returns the fully-qualified URIs that point to source data in Google Cloud Storage (e.g.
   * gs://bucket/path). Each URI can contain one '*' wildcard character and it must come after the
   * 'bucket' name.
   */
  public List<String> sourceUris() {
    return sourceUris;
  }

  /**
   * Returns the configuration for the BigQuery Load Job.
   */
  public LoadConfiguration configuration() {
    return configuration;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  ToStringHelper toStringHelper() {
    return super.toStringHelper().add("sourceUris", sourceUris).add("configuration", configuration);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof LoadJobInfo && Objects.equals(toPb(), ((LoadJobInfo) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), sourceUris, configuration);
  }

  @Override
  Job toPb() {
    JobConfigurationLoad loadConfigurationPb = configuration.toPb();
    loadConfigurationPb.setSourceUris(sourceUris);
    return super.toPb().setConfiguration(new JobConfiguration().setLoad(loadConfigurationPb));
  }

  /**
   * Creates a builder for a BigQuery Load Job given the load configuration and source URI.
   */
  public static Builder builder(LoadConfiguration configuration, String sourceUri) {
    return builder(configuration, ImmutableList.of(checkNotNull(sourceUri)));
  }

  /**
   * Creates a builder for a BigQuery Load Job given the load configuration and source URIs.
   */
  public static Builder builder(LoadConfiguration configuration, List<String> sourceUris) {
    return new Builder().configuration(configuration).sourceUris(sourceUris);
  }

  /**
   * Returns a BigQuery Load Job for the given load configuration and source URI. Job's id is chosen
   * by the service.
   */
  public static LoadJobInfo of(LoadConfiguration configuration, String sourceUri) {
    return builder(configuration, sourceUri).build();
  }

  /**
   * Returns a BigQuery Load Job for the given load configuration and source URIs. Job's id is
   * chosen by the service.
   */
  public static LoadJobInfo of(LoadConfiguration configuration, List<String> sourceUris) {
    return builder(configuration, sourceUris).build();
  }

  /**
   * Returns a BigQuery Load Job for the given load configuration and source URI. Job's id is set to
   * the provided value.
   */
  public static LoadJobInfo of(JobId jobId, LoadConfiguration configuration, String sourceUri) {
    return builder(configuration, sourceUri).jobId(jobId).build();
  }

  /**
   * Returns a BigQuery Load Job for the given load configuration and source URIs. Job's id is set
   * to the provided value.
   */
  public static LoadJobInfo of(JobId jobId, LoadConfiguration configuration,
      List<String> sourceUris) {
    return builder(configuration, sourceUris).jobId(jobId).build();
  }

  @SuppressWarnings("unchecked")
  static LoadJobInfo fromPb(Job jobPb) {
    return new Builder(jobPb).build();
  }
}
