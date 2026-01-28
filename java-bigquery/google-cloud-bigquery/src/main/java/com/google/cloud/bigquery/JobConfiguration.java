/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import java.io.Serializable;
import java.util.Objects;

/** Base class for a BigQuery job configuration. */
public abstract class JobConfiguration implements Serializable {

  private static final long serialVersionUID = -548132177415406526L;

  private final Type type;

  /** Type of a BigQuery Job. */
  public enum Type {
    /**
     * A Copy Job copies an existing table to another new or existing table. Instances of {@code
     * JobConfiguration} for this type are implemented by {@link CopyJobConfiguration}.
     */
    COPY,
    /**
     * An Extract Job exports a BigQuery table to Google Cloud Storage. Instances of {@code
     * JobConfiguration} for this type are implemented by {@link ExtractJobConfiguration}.
     */
    EXTRACT,
    /**
     * A Load Job loads data from one of several formats into a table. Instances of {@code
     * JobConfiguration} for this type are implemented by {@link LoadJobConfiguration}.
     */
    LOAD,
    /**
     * A Query Job runs a query against BigQuery data. Instances of {@code JobConfiguration} for
     * this type are implemented by {@link QueryJobConfiguration}.
     */
    QUERY
  }

  /**
   * Base builder for job configurations.
   *
   * @param <T> the job configuration type
   * @param <B> the job configuration builder
   */
  public abstract static class Builder<T extends JobConfiguration, B extends Builder<T, B>> {

    private Type type;

    Builder(Type type) {
      this.type = checkNotNull(type);
    }

    @SuppressWarnings("unchecked")
    B self() {
      return (B) this;
    }

    B setType(Type type) {
      this.type = checkNotNull(type);
      return self();
    }

    /** Creates an object. */
    public abstract T build();
  }

  JobConfiguration(Builder builder) {
    this.type = builder.type;
  }

  /** Returns the type of the job configuration. */
  public Type getType() {
    return type;
  }

  /** Returns a builder for the object. */
  public abstract Builder toBuilder();

  ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this).add("type", type);
  }

  @Override
  public String toString() {
    return toStringHelper().toString();
  }

  final int baseHashCode() {
    return Objects.hash(type);
  }

  final boolean baseEquals(JobConfiguration jobConfiguration) {
    return Objects.equals(toPb(), jobConfiguration.toPb());
  }

  abstract JobConfiguration setProjectId(String projectId);

  abstract com.google.api.services.bigquery.model.JobConfiguration toPb();

  @SuppressWarnings("unchecked")
  static <T extends JobConfiguration> T fromPb(
      com.google.api.services.bigquery.model.JobConfiguration configurationPb) {
    if (configurationPb.getCopy() != null) {
      return (T) CopyJobConfiguration.fromPb(configurationPb);
    } else if (configurationPb.getExtract() != null) {
      return (T) ExtractJobConfiguration.fromPb(configurationPb);
    } else if (configurationPb.getLoad() != null) {
      return (T) LoadJobConfiguration.fromPb(configurationPb);
    } else if (configurationPb.getQuery() != null) {
      return (T) QueryJobConfiguration.fromPb(configurationPb);
    } else {
      // never reached
      throw new IllegalArgumentException("Job configuration is not supported");
    }
  }
}
