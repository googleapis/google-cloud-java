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

package com.google.cloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import com.google.cloud.Page;

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
public final class Table extends TableInfo {

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
      this.infoBuilder.tableId(tableId).definition(defintion);
    }

    Builder(Table table) {
      this.bigquery = table.bigquery;
      this.infoBuilder = new TableInfo.BuilderImpl(table);
    }

    @Override
    Builder creationTime(Long creationTime) {
      infoBuilder.creationTime(creationTime);
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
    public Builder expirationTime(Long expirationTime) {
      infoBuilder.expirationTime(expirationTime);
      return this;
    }

    @Override
    public Builder friendlyName(String friendlyName) {
      infoBuilder.friendlyName(friendlyName);
      return this;
    }

    @Override
    Builder generatedId(String generatedId) {
      infoBuilder.generatedId(generatedId);
      return this;
    }

    @Override
    Builder lastModifiedTime(Long lastModifiedTime) {
      infoBuilder.lastModifiedTime(lastModifiedTime);
      return this;
    }

    @Override
    Builder selfLink(String selfLink) {
      infoBuilder.selfLink(selfLink);
      return this;
    }

    @Override
    public Builder tableId(TableId tableId) {
      infoBuilder.tableId(tableId);
      return this;
    }

    @Override
    public Builder definition(TableDefinition definition) {
      infoBuilder.definition(definition);
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
    this.options = bigquery.options();
  }

  /**
   * Checks if this table exists.
   *
   * @return {@code true} if this table exists, {@code false} otherwise
   * @throws BigQueryException upon failure
   */
  public boolean exists() {
    return bigquery.getTable(tableId(), BigQuery.TableOption.fields()) != null;
  }

  /**
   * Fetches current table's latest information. Returns {@code null} if the table does not exist.
   *
   * @param options table options
   * @return a {@code Table} object with latest information or {@code null} if not found
   * @throws BigQueryException upon failure
   */
  public Table reload(BigQuery.TableOption... options) {
    return bigquery.getTable(tableId(), options);
  }

  /**
   * Updates the table's information with this table's information. Dataset's and table's
   * user-defined ids cannot be changed. A new {@code Table} object is returned.
   *
   * @param options dataset options
   * @return a {@code Table} object with updated information
   * @throws BigQueryException upon failure
   */
  public Table update(BigQuery.TableOption... options) {
    return bigquery.update(this, options);
  }

  /**
   * Deletes this table.
   *
   * @return {@code true} if table was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  public boolean delete() {
    return bigquery.delete(tableId());
  }

  /**
   * Insert rows into the table.
   *
   * @param rows rows to be inserted
   * @throws BigQueryException upon failure
   */
  public InsertAllResponse insert(Iterable<InsertAllRequest.RowToInsert> rows)
      throws BigQueryException {
    return bigquery.insertAll(InsertAllRequest.of(tableId(), rows));
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
  public InsertAllResponse insert(Iterable<InsertAllRequest.RowToInsert> rows,
      boolean skipInvalidRows, boolean ignoreUnknownValues) throws BigQueryException {
    InsertAllRequest request = InsertAllRequest.builder(tableId(), rows)
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
  public Page<List<FieldValue>> list(BigQuery.TableDataListOption... options)
      throws BigQueryException {
    return bigquery.listTableData(tableId(), options);
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
  public Job copy(String destinationDataset, String destinationTable, BigQuery.JobOption... options)
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
  public Job copy(TableId destinationTable, BigQuery.JobOption... options)
      throws BigQueryException {
    CopyJobConfiguration configuration = CopyJobConfiguration.of(destinationTable, tableId());
    return bigquery.create(JobInfo.of(configuration), options);
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
  public Job extract(String format, String destinationUri, BigQuery.JobOption... options)
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
  public Job extract(String format, List<String> destinationUris, BigQuery.JobOption... options)
      throws BigQueryException {
    ExtractJobConfiguration extractConfiguration =
        ExtractJobConfiguration.of(tableId(), destinationUris, format);
    return bigquery.create(JobInfo.of(extractConfiguration), options);
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
  public Job load(FormatOptions format, String sourceUri, BigQuery.JobOption... options)
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
  public Job load(FormatOptions format, List<String> sourceUris, BigQuery.JobOption... options)
      throws BigQueryException {
    LoadJobConfiguration loadConfig = LoadJobConfiguration.of(tableId(), sourceUris, format);
    return bigquery.create(JobInfo.of(loadConfig), options);
  }

  /**
   * Returns the table's {@code BigQuery} object used to issue requests.
   */
  public BigQuery bigquery() {
    return bigquery;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Table
        && Objects.equals(toPb(), ((Table) obj).toPb())
        && Objects.equals(options, ((Table) obj).options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.bigquery = options.service();
  }

  static Table fromPb(BigQuery bigquery, com.google.api.services.bigquery.model.Table tablePb) {
    return new Table(bigquery, new TableInfo.BuilderImpl(tablePb));
  }
}
