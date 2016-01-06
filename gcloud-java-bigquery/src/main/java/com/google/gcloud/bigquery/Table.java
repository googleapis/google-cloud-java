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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.Page;

import java.util.List;
import java.util.Objects;

/**
 * A Google BigQuery Table.
 *
 * <p>Objects of this class are immutable. Operations that modify the table like {@link #update}
 * return a new object. To get a {@code Table} object with the most recent information use
 * {@link #reload}.
 * </p>
 */
public final class Table {

  private final BigQuery bigquery;
  private final BaseTableInfo info;

  /**
   * Constructs a {@code Table} object for the provided {@code TableInfo}. The BigQuery service
   * is used to issue requests.
   *
   * @param bigquery the BigQuery service used for issuing requests
   * @param info table's info
   */
  public Table(BigQuery bigquery, BaseTableInfo info) {
    this.bigquery = checkNotNull(bigquery);
    this.info = checkNotNull(info);
  }

  /**
   * Creates a {@code Table} object for the provided dataset and table's user-defined ids. Performs
   * an RPC call to get the latest table information.
   *
   * @param bigquery the BigQuery service used for issuing requests
   * @param dataset the dataset's user-defined id
   * @param table the table's user-defined id
   * @param options table options
   * @return the {@code Table} object or {@code null} if not found
   * @throws BigQueryException upon failure
   */
  public static Table load(BigQuery bigquery, String dataset, String table,
      BigQuery.TableOption... options) {
    return load(bigquery, TableId.of(dataset, table), options);
  }

  /**
   * Creates a {@code Table} object for the provided table identity. Performs an RPC call to get the
   * latest table information.
   *
   * @param bigquery the BigQuery service used for issuing requests
   * @param table the table's identity
   * @param options table options
   * @return the {@code Table} object or {@code null} if not found
   * @throws BigQueryException upon failure
   */
  public static Table load(BigQuery bigquery, TableId table, BigQuery.TableOption... options) {
    BaseTableInfo info = bigquery.getTable(table, options);
    return info != null ? new Table(bigquery, info) : null;
  }

  /**
   * Returns the table's information.
   */
  public BaseTableInfo info() {
    return info;
  }

  /**
   * Checks if this table exists.
   *
   * @return {@code true} if this table exists, {@code false} otherwise
   * @throws BigQueryException upon failure
   */
  public boolean exists() {
    return bigquery.getTable(info.tableId(), BigQuery.TableOption.fields()) != null;
  }

  /**
   * Fetches current table's latest information. Returns {@code null} if the table does not exist.
   *
   * @param options table options
   * @return a {@code Table} object with latest information or {@code null} if not found
   * @throws BigQueryException upon failure
   */
  public Table reload(BigQuery.TableOption... options) {
    return Table.load(bigquery, info.tableId(), options);
  }

  /**
   * Updates the table's information. Dataset's and table's user-defined ids cannot be changed. A
   * new {@code Table} object is returned.
   *
   * @param tableInfo new table's information. Dataset's and table's user-defined ids must match the
   *     ones of the current table
   * @param options dataset options
   * @return a {@code Table} object with updated information
   * @throws BigQueryException upon failure
   */
  public Table update(BaseTableInfo tableInfo, BigQuery.TableOption... options) {
    checkArgument(Objects.equals(tableInfo.tableId().dataset(),
        info.tableId().dataset()), "Dataset's user-defined ids must match");
    checkArgument(Objects.equals(tableInfo.tableId().table(),
        info.tableId().table()), "Table's user-defined ids must match");
    return new Table(bigquery, bigquery.update(tableInfo, options));
  }

  /**
   * Deletes this table.
   *
   * @return {@code true} if table was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  public boolean delete() {
    return bigquery.delete(info.tableId());
  }

  /**
   * Insert rows into the table.
   *
   * @param rows rows to be inserted
   * @throws BigQueryException upon failure
   */
  InsertAllResponse insert(Iterable<InsertAllRequest.RowToInsert> rows) throws BigQueryException {
    return bigquery.insertAll(InsertAllRequest.of(info.tableId(), rows));
  }

  /**
   * Insert rows into the table.
   *
   * @param rows rows to be inserted
   * @param skipInvalidRows whether to insert all valid rows, even if invalid rows exist. If not set
   *     the entire insert operation will fail if rows to be inserted contain an invalid row
   * @param ignoreUnknownValues whether to accept rows that contain values that do not match the
   *     schema. The unknown values are ignored. If not set, rows with unknown values are considered
   *     to be invalid
   * @throws BigQueryException upon failure
   */
  InsertAllResponse insert(Iterable<InsertAllRequest.RowToInsert> rows, boolean skipInvalidRows,
      boolean ignoreUnknownValues) throws BigQueryException {
    InsertAllRequest request = InsertAllRequest.builder(info.tableId(), rows)
        .skipInvalidRows(skipInvalidRows)
        .ignoreUnknownValues(ignoreUnknownValues)
        .build();
    return bigquery.insertAll(request);
  }

  /**
   * Returns the paginated list rows in this table.
   *
   * @param options table data list options
   * @throws BigQueryException upon failure
   */
  Page<List<FieldValue>> list(BigQuery.TableDataListOption... options) throws BigQueryException {
    return bigquery.listTableData(info.tableId(), options);
  }

  /**
   * Starts a BigQuery Job to copy the current table to the provided destination table. Returns the
   * started {@link Job} object.
   *
   * @param destinationDataset the user-defined id of the destination dataset
   * @param destinationTable the user-defined id of the destination table
   * @param options job options
   * @throws BigQueryException upon failure
   */
  Job copy(String destinationDataset, String destinationTable, BigQuery.JobOption... options)
      throws BigQueryException {
    return copy(TableId.of(destinationDataset, destinationTable), options);
  }

  /**
   * Starts a BigQuery Job to copy the current table to the provided destination table. Returns the
   * started {@link Job} object.
   *
   * @param destinationTable the destination table of the copy job
   * @param options job options
   * @throws BigQueryException upon failure
   */
  Job copy(TableId destinationTable, BigQuery.JobOption... options) throws BigQueryException {
    JobInfo job = bigquery.create(CopyJobInfo.of(destinationTable, info.tableId()), options);
    return new Job(bigquery, job);
  }

  /**
   * Starts a BigQuery Job to extract the current table to the provided destination URI. Returns the
   * started {@link Job} object.
   *
   * @param format the format of the extracted data
   * @param destinationUri the fully-qualified Google Cloud Storage URI (e.g. gs://bucket/path)
   *     where the extracted table should be written
   * @param options job options
   * @throws BigQueryException upon failure
   */
  Job extract(String format, String destinationUri, BigQuery.JobOption... options)
      throws BigQueryException {
    return extract(format, ImmutableList.of(destinationUri), options);
  }

  /**
   * Starts a BigQuery Job to extract the current table to the provided destination URIs. Returns
   * the started {@link Job} object.
   *
   * @param format the format of the exported data
   * @param destinationUris the fully-qualified Google Cloud Storage URIs (e.g. gs://bucket/path)
   *     where the extracted table should be written
   * @param options job options
   * @throws BigQueryException upon failure
   */
  Job extract(String format, List<String> destinationUris, BigQuery.JobOption... options)
      throws BigQueryException {
    return new Job(bigquery,
        bigquery.create(ExtractJobInfo.of(info.tableId(), format, destinationUris), options));
  }

  /**
   * Starts a BigQuery Job to load data into the current table from the provided source URI. Returns
   * the started {@link Job} object.
   *
   * @param format the format of the data to load
   * @param sourceUri the fully-qualified Google Cloud Storage URI (e.g. gs://bucket/path) from
   *     which to load the data
   * @param options job options
   * @throws BigQueryException upon failure
   */
  Job load(FormatOptions format, String sourceUri, BigQuery.JobOption... options)
      throws BigQueryException {
    return load(format, ImmutableList.of(sourceUri), options);
  }

  /**
   * Starts a BigQuery Job to load data into the current table from the provided source URIs.
   * Returns the started {@link Job} object.
   *
   * @param format the format of the exported data
   * @param sourceUris the fully-qualified Google Cloud Storage URIs (e.g. gs://bucket/path) from
   *     which to load the data
   * @param options job options
   * @throws BigQueryException upon failure
   */
  Job load(FormatOptions format, List<String> sourceUris, BigQuery.JobOption... options)
      throws BigQueryException {
    return new Job(bigquery, bigquery.create(LoadJobInfo.of(info.tableId(), format, sourceUris),
        options));
  }

  /**
   * Returns the table's {@code BigQuery} object used to issue requests.
   */
  public BigQuery bigquery() {
    return bigquery;
  }
}
