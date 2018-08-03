/*
 * Copyright 2018 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.api.services.bigquery.model.Table;
import com.google.auto.value.AutoValue;
import javax.annotation.Nullable;

/**
 * A Google BigQuery Model table definition. This definition is used to represent a BigQuery
 * ML model.
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/reference/standard-sql/bigqueryml-syntax-create#models_in_bqml_name">BigQuery ML Model</a>
 */
@AutoValue
@BetaApi
public abstract class ModelTableDefinition extends TableDefinition {

  private static final long serialVersionUID = 2113445776046717900L;

  @AutoValue.Builder
  public abstract static class Builder
      extends TableDefinition.Builder<ModelTableDefinition, Builder> {

    public abstract Builder setNumBytes(Long numBytes);

    public abstract Builder setLocation(String location);

    public abstract Builder setType(Type type);

    /** Creates a {@code ModelTableDefinition} object. */
    public abstract ModelTableDefinition build();
  }

  /** Returns the size of this table in bytes, excluding any data in the streaming buffer. */
  @Nullable
  public abstract Long getNumBytes();

  /**
   * Returns the geographic location where the table should reside. This value is inherited from the
   * dataset.
   *
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/managing_jobs_datasets_projects#dataset-location">
   *     Dataset Location</a>
   */
  @Nullable
  public abstract String getLocation();

  /**
   * Returns a builder for a BigQuery ML model table definition.
   */
  public static Builder newBuilder() {
    return new AutoValue_ModelTableDefinition.Builder().setType(Type.MODEL);
  }

  /** Returns a builder for the {@code <ModelTableDefinition} object. */
  public abstract Builder toBuilder();

  @Override
  Table toPb() {
    Table tablePb = super.toPb();
    tablePb.setNumBytes(getNumBytes());
    tablePb.setLocation(getLocation());
    return tablePb;
  }

  @SuppressWarnings("unchecked")
  static ModelTableDefinition fromPb(Table tablePb) {
    Builder builder = newBuilder().table(tablePb);
    return builder.setNumBytes(tablePb.getNumBytes()).setLocation(tablePb.getLocation()).build();
  }
}
