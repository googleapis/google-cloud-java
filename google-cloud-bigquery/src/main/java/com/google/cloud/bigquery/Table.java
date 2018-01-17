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
import com.google.cloud.bigquery.BigQuery.JobOption;
import com.google.cloud.bigquery.BigQuery.TableDataListOption;
import com.google.cloud.bigquery.BigQuery.TableOption;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;

/**
 * A Google BigQuery Table.
 *
 * <p>Objects of this class are immutable. Operations that modify the table like {@link #update}
 * return a new object. To get a {@code Table} object with the most recent information use
 * {@link #reload}. {@code Table} adds a layer of service-related functionality over
 * {@link TableInfo}.
 * </p>
 */
public class Table extends TableInfo {

  private static final long serialVersionUID = 5744556727066570096L;

  private final BigQueryOptions options;
  private transient BigQuery bigquery;

  /**
   * A builder for {@code Table} objects.
   */
  public static class Builder extends TableInfo.Builder {

    private final BigQuery bigquery;
    private final TableInfo.BuilderImpl infoBuilder;

    Builder(BigQuery bigquery, TableId tableId, TableDefinition defintion) {
      this.bigquery = bigquery;
      this.infoBuilder = new TableInfo.BuilderImpl();
      this.infoBuilder.setTableId(tableId).setDefinition(defintion);
    }

    Builder(Table table) {
      this.bigquery = table.bigquery;
      this.infoBuilder = new TableInfo.BuilderImpl(table);
    }

    @Override
    Builder setCreationTime(Long creationTime) {
      infoBuilder.setCreationTime(creationTime);
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
    public Builder setExpirationTime(Long expirationTime) {
      infoBuilder.setExpirationTime(expirationTime);
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
    Builder setLastModifiedTime(Long lastModifiedTime) {
      infoBuilder.setLastModifiedTime(lastModifiedTime);
      return this;
    }

    @Override
    Builder setSelfLink(String selfLink) {
      infoBuilder.setSelfLink(selfLink);
      return this;
    }


    @Override
    public Builder setTableId(TableId tableId) {
      infoBuilder.setTableId(tableId);
      return this;
    }


    @Override
    public Builder setDefinition(TableDefinition definition) {
      infoBuilder.setDefinition(definition);
      return this;
    }

    @Override
    public Table build() {
      return new Table(bigquery, infoBuilder);
    }
  }

  Table(BigQuery bigquery, TableInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.bigquery = checkNotNull(bigquery);
    this.options = bigquery.getOptions();
  }

  /**
   * Checks if this table exists.
   *
   * <p>Example of checking if the table exists.
   * <pre> {@code
   * boolean exists = table.exists();
   * if (exists) {
   *   // the table exists
   * } else {
   *   // the table was not found
   * }
   * }</pre>
   *
   * @return {@code true} if this table exists, {@code false} otherwise
   * @throws BigQueryException upon failure
   */
  public boolean exists() {
    return bigquery.getTable(getTableId(), TableOption.fields()) != null;
  }

  /**
   * Fetches current table's latest information. Returns {@code null} if the table does not exist.
   *
   * <p>Example of fetching the table's latest information, specifying particular table fields to
   * get.
   * <pre> {@code
   * TableField field1 = TableField.LAST_MODIFIED_TIME;
   * TableField field2 = TableField.NUM_ROWS;
   * Table latestTable = table.reload(TableOption.fields(field1, field2));
   * if (latestTable == null) {
   *   // the table was not found
   * }
   * }</pre>
   *
   * @param options table options
   * @return a {@code Table} object with latest information or {@code null} if not found
   * @throws BigQueryException upon failure
   */
  public Table reload(TableOption... options) {
    return bigquery.getTable(getTableId(), options);
  }

  /**
   * Updates the table's information with this table's information. Dataset's and table's
   * user-defined ids cannot be changed. A new {@code Table} object is returned.
   *
   * <p>Example of updating the table's information.
   * <pre> {@code
   * Table updatedTable = table.toBuilder().setDescription("new description").build().update();
   * }</pre>
   *
   * @param options dataset options
   * @return a {@code Table} object with updated information
   * @throws BigQueryException upon failure
   */
  public Table update(TableOption... options) {
    return bigquery.update(this, options);
  }

  /**
   * Deletes this table.
   *
   * <p>Example of deleting the table.
   * <pre> {@code
   * boolean deleted = table.delete();
   * if (deleted) {
   *   // the table was deleted
   * } else {
   *   // the table was not found
   * }
   * }</pre>
   *
   * @return {@code true} if table was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  public boolean delete() {
    return bigquery.delete(getTableId());
  }

  /**
   * Insert rows into the table.
   *
   * <p>Example of inserting rows into the table.
   * <pre> {@code
   * String rowId1 = "rowId1";
   * String rowId2 = "rowId2";
   * List<RowToInsert> rows = new ArrayList<>();
   * Map<String, Object> row1 = new HashMap<>();
   * row1.put("stringField", "value1");
   * row1.put("booleanField", true);
   * Map<String, Object> row2 = new HashMap<>();
   * row2.put("stringField", "value2");
   * row2.put("booleanField", false);
   * rows.add(RowToInsert.of(rowId1, row1));
   * rows.add(RowToInsert.of(rowId2, row2));
   * InsertAllResponse response = table.insert(rows);
   * // do something with response
   * }</pre>
   *
   * @param rows rows to be inserted
   * @throws BigQueryException upon failure
   */
  public InsertAllResponse insert(Iterable<InsertAllRequest.RowToInsert> rows)
      throws BigQueryException {
    return bigquery.insertAll(InsertAllRequest.of(getTableId(), rows));
  }

  /**
   * Insert rows into the table.
   *
   * <p>Example of inserting rows into the table, ignoring invalid rows.
   * <pre> {@code
   * String rowId1 = "rowId1";
   * String rowId2 = "rowId2";
   * List<RowToInsert> rows = new ArrayList<>();
   * Map<String, Object> row1 = new HashMap<>();
   * row1.put("stringField", 1);
   * row1.put("booleanField", true);
   * Map<String, Object> row2 = new HashMap<>();
   * row2.put("stringField", "value2");
   * row2.put("booleanField", false);
   * rows.add(RowToInsert.of(rowId1, row1));
   * rows.add(RowToInsert.of(rowId2, row2));
   * InsertAllResponse response = table.insert(rows, true, true);
   * // do something with response
   * }</pre>
   *
   * @param rows rows to be inserted
   * @param skipInvalidRows whether to insert all valid rows, even if invalid rows exist. If not set
   *     the entire insert operation will fail if rows to be inserted contain an invalid row
   * @param ignoreUnknownValues whether to accept rows that contain values that do not match the
   *     schema. The unknown values are ignored. If not set, rows with unknown values are considered
   *     to be invalid
   * @throws BigQueryException upon failure
   */
  public InsertAllResponse insert(Iterable<InsertAllRequest.RowToInsert> rows,
      boolean skipInvalidRows, boolean ignoreUnknownValues) throws BigQueryException {
    InsertAllRequest request = InsertAllRequest.newBuilder(getTableId(), rows)
        .setSkipInvalidRows(skipInvalidRows)
        .setIgnoreUnknownValues(ignoreUnknownValues)
        .build();
    return bigquery.insertAll(request);
  }

  /**
   * Returns the paginated list rows in this table.
   *
   * <p>Example of listing rows in the table.
   *
   * <pre>{@code
   * // This example reads the result 100 rows per RPC call. If there's no need to limit the number,
   * // simply omit the option.
   * TableResult page = table.list(TableDataListOption.pageSize(100));
   * for (FieldValueList row : page.iterateAll()) {
   *   // do something with the row
   * }
   * }</pre>
   *
   * @param options table data list options
   * @throws BigQueryException upon failure
   */
  public TableResult list(TableDataListOption... options) throws BigQueryException {
    return bigquery.listTableData(getTableId(), options);
  }

  /**
   * Returns the paginated list rows in this table.
   *
   * <p>Example of listing rows in the table.
   *
   * <pre>{@code
   * Schema schema = ...;
   * String field = "my_field";
   * TableResult page = table.list(schema);
   * for (FieldValueList row : page.iterateAll()) {
   *   row.get(field);
   * }
   * }</pre>
   *
   * @param options table data list options
   * @throws BigQueryException upon failure
   */
  public TableResult list(Schema schema, TableDataListOption... options)
      throws BigQueryException {
    return bigquery.listTableData(getTableId(), schema, options);
  }

  /**
   * Starts a BigQuery Job to copy the current table to the provided destination table. Returns the
   * started {@link Job} object.
   *
   * <p>Example of copying the table to a destination table.
   * <pre> {@code
   * String datasetName = "my_dataset";
   * String tableName = "my_destination_table";
   * Job job = table.copy(datasetName, tableName);
   * // Wait for the job to complete.
   * try {
   *   Job completedJob = job.waitFor(RetryOption.checkEvery(1, TimeUnit.SECONDS),
   *       RetryOption.timeout(3, TimeUnit.MINUTES));
   *   if (completedJob != null && completedJob.getStatus().getError() == null) {
   *     // Job completed successfully
   *   } else {
   *     // Handle error case
   *   }
   * } catch (InterruptedException | TimeoutException e) {
   *   // Handle interrupted wait
   * }
   * }</pre>
   *
   * @param destinationDataset the user-defined id of the destination dataset
   * @param destinationTable the user-defined id of the destination table
   * @param options job options
   * @throws BigQueryException upon failure
   */
  public Job copy(String destinationDataset, String destinationTable, JobOption... options)
      throws BigQueryException {
    return copy(TableId.of(destinationDataset, destinationTable), options);
  }

  /**
   * Starts a BigQuery Job to copy the current table to the provided destination table. Returns the
   * started {@link Job} object.
   *
   * <p>Example copying the table to a destination table.
   * <pre> {@code
   * String dataset = "my_dataset";
   * String tableName = "my_destination_table";
   * TableId destinationId = TableId.of(dataset, tableName);
   * JobOption options = JobOption.fields(JobField.STATUS, JobField.USER_EMAIL);
   * Job job = table.copy(destinationId, options);
   * // Wait for the job to complete.
   * try {
   *   Job completedJob = job.waitFor(RetryOption.checkEvery(1, TimeUnit.SECONDS),
   *       RetryOption.timeout(3, TimeUnit.MINUTES));
   *   if (completedJob != null && completedJob.getStatus().getError() == null) {
   *     // Job completed successfully.
   *   } else {
   *     // Handle error case.
   *   }
   * } catch (InterruptedException | TimeoutException e) {
   *   // Handle interrupted wait
   * }
   * }</pre>
   *
   * @param destinationTable the destination table of the copy job
   * @param options job options
   * @throws BigQueryException upon failure
   */
  public Job copy(TableId destinationTable, JobOption... options)
      throws BigQueryException {
    CopyJobConfiguration configuration = CopyJobConfiguration.of(destinationTable, getTableId());
    return bigquery.create(JobInfo.of(configuration), options);
  }

  /**
   * Starts a BigQuery Job to extract the current table to the provided destination URI. Returns the
   * started {@link Job} object.
   *
   * <p>Example extracting data to single Google Cloud Storage file.
   * <pre> {@code
   * String format = "CSV";
   * String gcsUrl = "gs://my_bucket/filename.csv";
   * Job job = table.extract(format, gcsUrl);
   * // Wait for the job to complete
   * try {
   *   Job completedJob = job.waitFor(RetryOption.checkEvery(1, TimeUnit.SECONDS),
   *       RetryOption.timeout(3, TimeUnit.MINUTES));
   *   if (completedJob != null && completedJob.getStatus().getError() == null) {
   *     // Job completed successfully
   *   } else {
   *     // Handle error case
   *   }
   * } catch (InterruptedException | TimeoutException e) {
   *   // Handle interrupted wait
   * }
   * }</pre>
   *
   * @param format the format of the extracted data
   * @param destinationUri the fully-qualified Google Cloud Storage URI (e.g. gs://bucket/path)
   *     where the extracted table should be written
   * @param options job options
   * @throws BigQueryException upon failure
   */
  public Job extract(String format, String destinationUri, JobOption... options)
      throws BigQueryException {
    return extract(format, ImmutableList.of(destinationUri), options);
  }

  /**
   * Starts a BigQuery Job to extract the current table to the provided destination URIs. Returns
   * the started {@link Job} object.
   *
   * <p>Example of partitioning data to a list of Google Cloud Storage files.
   * <pre> {@code
   * String format = "CSV";
   * String gcsUrl1 = "gs://my_bucket/PartitionA_*.csv";
   * String gcsUrl2 = "gs://my_bucket/PartitionB_*.csv";
   * List<String> destinationUris = new ArrayList<>();
   * destinationUris.add(gcsUrl1);
   * destinationUris.add(gcsUrl2);
   * Job job = table.extract(format, destinationUris);
   * // Wait for the job to complete
   * try {
   *   Job completedJob = job.waitFor(RetryOption.checkEvery(1, TimeUnit.SECONDS),
   *       RetryOption.timeout(3, TimeUnit.MINUTES));
   *   if (completedJob != null && completedJob.getStatus().getError() == null) {
   *     // Job completed successfully
   *   } else {
   *     // Handle error case
   *   }
   * } catch (InterruptedException | TimeoutException e) {
   *   // Handle interrupted wait
   * }
   * }</pre>
   *
   * @param format the format of the exported data
   * @param destinationUris the fully-qualified Google Cloud Storage URIs (e.g. gs://bucket/path)
   *     where the extracted table should be written
   * @param options job options
   * @throws BigQueryException upon failure
   */
  public Job extract(String format, List<String> destinationUris, JobOption... options)
      throws BigQueryException {
    ExtractJobConfiguration extractConfiguration =
        ExtractJobConfiguration.of(getTableId(), destinationUris, format);
    return bigquery.create(JobInfo.of(extractConfiguration), options);
  }

  /**
   * Starts a BigQuery Job to load data into the current table from the provided source URI. Returns
   * the started {@link Job} object.
   *
   * <p>Example loading data from a single Google Cloud Storage file.
   * <pre> {@code
   * String sourceUri = "gs://my_bucket/filename.csv";
   * Job job = table.load(FormatOptions.csv(), sourceUri);
   * // Wait for the job to complete
   * try {
   *   Job completedJob = job.waitFor(RetryOption.checkEvery(1, TimeUnit.SECONDS),
   *       RetryOption.timeout(3, TimeUnit.MINUTES));
   *   if (completedJob != null && completedJob.getStatus().getError() == null) {
   *     // Job completed successfully
   *   } else {
   *     // Handle error case
   *   }
   * } catch (InterruptedException | TimeoutException e) {
   *   // Handle interrupted wait
   * }
   * }</pre>
   *
   * @param format the format of the data to load
   * @param sourceUri the fully-qualified Google Cloud Storage URI (e.g. gs://bucket/path) from
   *     which to load the data
   * @param options job options
   * @throws BigQueryException upon failure
   */
  public Job load(FormatOptions format, String sourceUri, JobOption... options)
      throws BigQueryException {
    return load(format, ImmutableList.of(sourceUri), options);
  }

  /**
   * Starts a BigQuery Job to load data into the current table from the provided source URIs.
   * Returns the started {@link Job} object.
   *
   * <p>Example loading data from a list of Google Cloud Storage files.
   * <pre> {@code
   * String gcsUrl1 = "gs://my_bucket/filename1.csv";
   * String gcsUrl2 = "gs://my_bucket/filename2.csv";
   * List<String> sourceUris = new ArrayList<>();
   * sourceUris.add(gcsUrl1);
   * sourceUris.add(gcsUrl2);
   * Job job = table.load(FormatOptions.csv(), sourceUris);
   * // Wait for the job to complete
   * try {
   *   Job completedJob = job.waitFor(RetryOption.checkEvery(1, TimeUnit.SECONDS),
   *       RetryOption.timeout(3, TimeUnit.MINUTES));
   *   if (completedJob != null && completedJob.getStatus().getError() == null) {
   *     // Job completed successfully
   *   } else {
   *     // Handle error case
   *   }
   * } catch (InterruptedException | TimeoutException e) {
   *   // Handle interrupted wait
   * }
   * }</pre>
   *
   * @param format the format of the exported data
   * @param sourceUris the fully-qualified Google Cloud Storage URIs (e.g. gs://bucket/path) from
   *     which to load the data
   * @param options job options
   * @throws BigQueryException upon failure
   */
  public Job load(FormatOptions format, List<String> sourceUris, JobOption... options)
      throws BigQueryException {
    LoadJobConfiguration loadConfig = LoadJobConfiguration.of(getTableId(), sourceUris, format);
    return bigquery.create(JobInfo.of(loadConfig), options);
  }


  /**
   * Returns the table's {@code BigQuery} object used to issue requests.
   */
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
    if (obj == null || !obj.getClass().equals(Table.class)) {
      return false;
    }
    Table other = (Table) obj;
    return Objects.equals(toPb(), other.toPb())
        && Objects.equals(options, other.options);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.bigquery = options.getService();
  }

  static Table fromPb(BigQuery bigquery, com.google.api.services.bigquery.model.Table tablePb) {
    return new Table(bigquery, new TableInfo.BuilderImpl(tablePb));
  }
}
