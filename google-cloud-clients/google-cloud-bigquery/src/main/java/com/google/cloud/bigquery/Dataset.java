/*
 * Copyright 2015 Google LLC
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

import com.google.api.gax.paging.Page;
import com.google.cloud.bigquery.BigQuery.DatasetDeleteOption;
import com.google.cloud.bigquery.BigQuery.DatasetOption;
import com.google.cloud.bigquery.BigQuery.TableListOption;
import com.google.cloud.bigquery.BigQuery.TableOption;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A Google BigQuery Dataset.
 *
 * <p>Objects of this class are immutable. Operations that modify the dataset like {@link #update}
 * return a new object. To get a {@code Dataset} object with the most recent information use {@link
 * #reload}. {@code Dataset} adds a layer of service-related functionality over {@link DatasetInfo}.
 */
public class Dataset extends DatasetInfo {

  private static final long serialVersionUID = -4272921483363065593L;

  private final BigQueryOptions options;
  private transient BigQuery bigquery;

  /** A builder for {@code Dataset} objects. */
  public static final class Builder extends DatasetInfo.Builder {

    private final BigQuery bigquery;
    private final DatasetInfo.BuilderImpl infoBuilder;

    Builder(BigQuery bigquery, DatasetId datasetId) {
      this.bigquery = bigquery;
      this.infoBuilder = new DatasetInfo.BuilderImpl();
      this.infoBuilder.setDatasetId(datasetId);
    }

    Builder(Dataset dataset) {
      this.bigquery = dataset.bigquery;
      this.infoBuilder = new DatasetInfo.BuilderImpl(dataset);
    }

    @Override
    public Builder setDatasetId(DatasetId datasetId) {
      infoBuilder.setDatasetId(datasetId);
      return this;
    }

    @Override
    public Builder setAcl(List<Acl> acl) {
      infoBuilder.setAcl(acl);
      return this;
    }

    @Override
    Builder setCreationTime(Long creationTime) {
      infoBuilder.setCreationTime(creationTime);
      return this;
    }

    @Override
    public Builder setDefaultTableLifetime(Long defaultTableLifetime) {
      infoBuilder.setDefaultTableLifetime(defaultTableLifetime);
      return this;
    }

    @Override
    public Builder setDescription(String description) {
      infoBuilder.setDescription(description);
      return this;
    }

    @Override
    Builder setEtag(String etag) {
      infoBuilder.setEtag(etag);
      return this;
    }

    @Override
    public Builder setFriendlyName(String friendlyName) {
      infoBuilder.setFriendlyName(friendlyName);
      return this;
    }

    @Override
    Builder setGeneratedId(String generatedId) {
      infoBuilder.setGeneratedId(generatedId);
      return this;
    }

    @Override
    Builder setLastModified(Long lastModified) {
      infoBuilder.setLastModified(lastModified);
      return this;
    }

    @Override
    public Builder setLocation(String location) {
      infoBuilder.setLocation(location);
      return this;
    }

    @Override
    Builder setSelfLink(String selfLink) {
      infoBuilder.setSelfLink(selfLink);
      return this;
    }

    @Override
    public Builder setLabels(Map<String, String> labels) {
      infoBuilder.setLabels(labels);
      return this;
    }

    @Override
    public Builder setDefaultEncryptionConfiguration(
        EncryptionConfiguration defaultEncryptionConfiguration) {
      infoBuilder.setDefaultEncryptionConfiguration(defaultEncryptionConfiguration);
      return this;
    }

    @Override
    public Builder setDefaultPartitionExpirationMs(Long defaultPartitionExpirationMs) {
      infoBuilder.setDefaultPartitionExpirationMs(defaultPartitionExpirationMs);
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
    this.options = bigquery.getOptions();
  }

  /**
   * Checks if this dataset exists.
   *
   * <p>Example of checking whether a dataset exists.
   *
   * <pre>{@code
   * boolean exists = dataset.exists();
   * if (exists) {
   *   // the dataset exists
   * } else {
   *   // the dataset was not found
   * }
   * }</pre>
   *
   * @return {@code true} if this dataset exists, {@code false} otherwise
   * @throws BigQueryException upon failure
   */
  public boolean exists() {
    return bigquery.getDataset(getDatasetId(), DatasetOption.fields()) != null;
  }

  /**
   * Fetches current dataset's latest information. Returns {@code null} if the dataset does not
   * exist.
   *
   * <p>Example of reloading a dataset.
   *
   * <pre>{@code
   * Dataset latestDataset = dataset.reload();
   * if (latestDataset == null) {
   *   // The dataset was not found
   * }
   * }</pre>
   *
   * @param options dataset options
   * @return a {@code Dataset} object with latest information or {@code null} if not found
   * @throws BigQueryException upon failure
   */
  public Dataset reload(DatasetOption... options) {
    return bigquery.getDataset(getDatasetId().getDataset(), options);
  }

  /**
   * Updates the dataset's information with this dataset's information. Dataset's user-defined id
   * cannot be changed. A new {@code Dataset} object is returned.
   *
   * <p>Example of updating a dataset.
   *
   * <pre>{@code
   * String friendlyName = "my_friendly_name";
   * Builder builder = dataset.toBuilder();
   * builder.setFriendlyName(friendlyName);
   * Dataset updatedDataset = builder.build().update();
   * }</pre>
   *
   * @param options dataset options
   * @return a {@code Dataset} object with updated information
   * @throws BigQueryException upon failure
   */
  public Dataset update(DatasetOption... options) {
    return bigquery.update(this, options);
  }

  /**
   * Deletes this dataset.
   *
   * <p>Example of deleting a dataset.
   *
   * <pre>{@code
   * boolean deleted = dataset.delete();
   * if (deleted) {
   *   // The dataset was deleted
   * } else {
   *   // The dataset was not found
   * }
   * }</pre>
   *
   * @return {@code true} if dataset was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  public boolean delete(DatasetDeleteOption... options) {
    return bigquery.delete(getDatasetId(), options);
  }

  /**
   * Returns the paginated list of tables in this dataset.
   *
   * <p>Example of listing tables in the dataset.
   *
   * <pre>{@code
   * Page<Table> tables = dataset.list();
   * for (Table table : tables.iterateAll()) {
   *   // do something with the table
   * }
   * }</pre>
   *
   * @param options options for listing tables
   * @throws BigQueryException upon failure
   */
  public Page<Table> list(TableListOption... options) {
    return bigquery.listTables(getDatasetId(), options);
  }

  /**
   * Returns the requested table in this dataset or {@code null} if not found.
   *
   * <p>Example of getting a table in the dataset.
   *
   * <pre>{@code
   * String tableName = “my_table”;
   * Table table = dataset.get(tableName);
   * }</pre>
   *
   * @param tableId user-defined id of the requested table
   * @param options table options
   * @throws BigQueryException upon failure
   */
  public Table get(String tableId, TableOption... options) {
    return bigquery.getTable(TableId.of(getDatasetId().getDataset(), tableId), options);
  }

  /**
   * Creates a new table in this dataset.
   *
   * <p>Example of creating a table in the dataset with schema and time partitioning.
   *
   * <pre>{@code
   * String tableName = “my_table”;
   * String fieldName = “my_field”;
   * Schema schema = Schema.of(Field.of(fieldName, LegacySQLTypeName.STRING));
   * StandardTableDefinition definition = StandardTableDefinition.newBuilder()
   *     .setSchema(schema)
   *     .setTimePartitioning(TimePartitioning.of(TimePartitioning.Type.DAY))
   *     .build();
   * Table table = dataset.create(tableName, definition);
   * }</pre>
   *
   * @param tableId the table's user-defined id
   * @param definition the table's definition
   * @param options options for table creation
   * @return a {@code Table} object for the created table
   * @throws BigQueryException upon failure
   */
  public Table create(String tableId, TableDefinition definition, TableOption... options) {
    TableInfo tableInfo =
        TableInfo.of(TableId.of(getDatasetId().getDataset(), tableId), definition);
    return bigquery.create(tableInfo, options);
  }

  /** Returns the dataset's {@code BigQuery} object used to issue requests. */
  public BigQuery getBigQuery() {
    return bigquery;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Dataset.class)) {
      return false;
    }
    Dataset other = (Dataset) obj;
    return Objects.equals(toPb(), other.toPb()) && Objects.equals(options, other.options);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.bigquery = options.getService();
  }

  static Dataset fromPb(
      BigQuery bigquery, com.google.api.services.bigquery.model.Dataset datasetPb) {
    return new Dataset(bigquery, new DatasetInfo.BuilderImpl(datasetPb));
  }
}
