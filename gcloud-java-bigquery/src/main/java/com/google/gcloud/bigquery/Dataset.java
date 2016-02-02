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

import com.google.gcloud.Page;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;

/**
 * A Google BigQuery Dataset.
 *
 * <p>Objects of this class are immutable. Operations that modify the dataset like {@link #update}
 * return a new object. To get a {@code Dataset} object with the most recent information use
 * {@link #reload}. {@code Dataset} adds a layer of service-related functionality over
 * {@link DatasetInfo}.
 * </p>
 */
public final class Dataset extends DatasetInfo {

  private static final long serialVersionUID = -4272921483363065593L;

  private final BigQueryOptions options;
  private transient BigQuery bigquery;

  static final class Builder extends DatasetInfo.Builder {

    private final BigQuery bigquery;
    private final DatasetInfo.BuilderImpl infoBuilder;

    private Builder(BigQuery bigquery) {
      this.bigquery = bigquery;
      this.infoBuilder = new DatasetInfo.BuilderImpl();
    }

    private Builder(Dataset dataset) {
      this.bigquery = dataset.bigquery;
      this.infoBuilder = new DatasetInfo.BuilderImpl(dataset);
    }

    @Override
    public Builder datasetId(DatasetId datasetId) {
      infoBuilder.datasetId(datasetId);
      return this;
    }

    @Override
    public Builder acl(List<Acl> acl) {
      infoBuilder.acl(acl);
      return this;
    }

    @Override
    Builder creationTime(Long creationTime) {
      infoBuilder.creationTime(creationTime);
      return this;
    }

    @Override
    public Builder defaultTableLifetime(Long defaultTableLifetime) {
      infoBuilder.defaultTableLifetime(defaultTableLifetime);
      return this;
    }

    @Override
    public Builder description(String description) {
      infoBuilder.description(description);
      return this;
    }

    @Override
    Builder etag(String etag) {
      infoBuilder.etag(etag);
      return this;
    }

    @Override
    public Builder friendlyName(String friendlyName) {
      infoBuilder.friendlyName(friendlyName);
      return this;
    }

    @Override
    Builder id(String id) {
      infoBuilder.id(id);
      return this;
    }

    @Override
    Builder lastModified(Long lastModified) {
      infoBuilder.lastModified(lastModified);
      return this;
    }

    @Override
    public Builder location(String location) {
      infoBuilder.location(location);
      return this;
    }

    @Override
    Builder selfLink(String selfLink) {
      infoBuilder.selfLink(selfLink);
      return this;
    }

    @Override
    public Dataset build() {
      return new Dataset(bigquery, infoBuilder);
    }
  }

  Dataset(BigQuery bigquery, DatasetInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.bigquery = checkNotNull(bigquery);
    this.options = bigquery.options();
  }

  /**
   * Creates a {@code Dataset} object for the provided dataset's user-defined id. Performs an RPC
   * call to get the latest dataset information.
   *
   * @param bigquery the BigQuery service used for issuing requests
   * @param dataset dataset's user-defined id
   * @param options dataset options
   * @return the {@code Dataset} object or {@code null} if not found
   * @throws BigQueryException upon failure
   */
  public static Dataset get(BigQuery bigquery, String dataset, BigQuery.DatasetOption... options) {
    return bigquery.getDataset(dataset, options);
  }

  /**
   * Checks if this dataset exists.
   *
   * @return {@code true} if this dataset exists, {@code false} otherwise
   * @throws BigQueryException upon failure
   */
  public boolean exists() {
    return bigquery.getDataset(datasetId(), BigQuery.DatasetOption.fields()) != null;
  }

  /**
   * Fetches current dataset's latest information. Returns {@code null} if the dataset does not
   * exist.
   *
   * @param options dataset options
   * @return a {@code Dataset} object with latest information or {@code null} if not found
   * @throws BigQueryException upon failure
   */
  public Dataset reload(BigQuery.DatasetOption... options) {
    return Dataset.get(bigquery, datasetId().dataset(), options);
  }

  /**
   * Updates the dataset's information with this dataset's information. Dataset's user-defined id
   * cannot be changed. A new {@code Dataset} object is returned.
   *
   * @param options dataset options
   * @return a {@code Dataset} object with updated information
   * @throws BigQueryException upon failure
   */
  public Dataset update(BigQuery.DatasetOption... options) {
    return bigquery.update(this, options);
  }

  /**
   * Deletes this dataset.
   *
   * @return {@code true} if dataset was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  public boolean delete() {
    return bigquery.delete(datasetId());
  }

  /**
   * Returns the paginated list of tables in this dataset.
   *
   * @param options options for listing tables
   * @throws BigQueryException upon failure
   */
  public Page<Table> list(BigQuery.TableListOption... options) {
    return bigquery.listTables(datasetId(), options);
  }

  /**
   * Returns the requested table in this dataset or {@code null} if not found.
   *
   * @param table user-defined id of the requested table
   * @param options table options
   * @throws BigQueryException upon failure
   */
  public Table get(String table, BigQuery.TableOption... options) {
    return bigquery.getTable(TableId.of(datasetId().dataset(), table), options);
  }

  /**
   * Creates a new table in this dataset.
   *
   * @param table the table's user-defined id
   * @param definition the table's definition
   * @param options options for table creation
   * @return a {@code Table} object for the created table
   * @throws BigQueryException upon failure
   */
  public Table create(String table, TableDefinition definition, BigQuery.TableOption... options) {
    TableInfo tableInfo = TableInfo.of(TableId.of(datasetId().dataset(), table), definition);
    return bigquery.create(tableInfo, options);
  }

  /**
   * Returns the dataset's {@code BigQuery} object used to issue requests.
   */
  public BigQuery bigquery() {
    return bigquery;
  }

  public static Builder builder(BigQuery bigquery, DatasetId datasetId) {
    return new Builder(bigquery).datasetId(datasetId);
  }

  /**
   * Returns a builder for a {@code DatasetInfo} object given it's user-defined id.
   */
  public static Builder builder(BigQuery bigquery, String datasetId) {
    return builder(bigquery, DatasetId.of(datasetId));
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Dataset
        && Objects.equals(toPb(), ((Dataset) obj).toPb())
        && Objects.equals(options, ((Dataset) obj).options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.bigquery = options.service();
  }

  static Dataset fromPb(BigQuery bigquery,
      com.google.api.services.bigquery.model.Dataset datasetPb) {
    return new Dataset(bigquery, new DatasetInfo.BuilderImpl(datasetPb));
  }
}
