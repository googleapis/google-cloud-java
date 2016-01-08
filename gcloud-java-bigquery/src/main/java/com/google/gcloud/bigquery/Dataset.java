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

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.gcloud.Page;
import com.google.gcloud.PageImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * A Google BigQuery Dataset.
 *
 * <p>Objects of this class are immutable. Operations that modify the dataset like {@link #update}
 * return a new object. To get a {@code Dataset} object with the most recent information use
 * {@link #reload}.
 * </p>
 */
public final class Dataset {

  private final BigQuery bigquery;
  private final DatasetInfo info;

  private static class TablePageFetcher implements PageImpl.NextPageFetcher<Table> {

    private static final long serialVersionUID = 6906197848579250598L;

    private final BigQueryOptions options;
    private final Page<BaseTableInfo> infoPage;

    TablePageFetcher(BigQueryOptions options, Page<BaseTableInfo> infoPage) {
      this.options = options;
      this.infoPage = infoPage;
    }

    @Override
    public Page<Table> nextPage() {
      Page<BaseTableInfo> nextInfoPage = infoPage.nextPage();
      return new PageImpl<>(new TablePageFetcher(options, nextInfoPage),
          nextInfoPage.nextPageCursor(), new LazyTableIterable(options, nextInfoPage.values()));
    }
  }

  private static class LazyTableIterable implements Iterable<Table>, Serializable {

    private static final long serialVersionUID = 3312744215731674032L;

    private final BigQueryOptions options;
    private final Iterable<BaseTableInfo> infoIterable;
    private transient BigQuery bigquery;

    public LazyTableIterable(BigQueryOptions options, Iterable<BaseTableInfo> infoIterable) {
      this.options = options;
      this.infoIterable = infoIterable;
      this.bigquery = options.service();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.bigquery = options.service();
    }

    @Override
    public Iterator<Table> iterator() {
      return Iterators.transform(infoIterable.iterator(), new Function<BaseTableInfo, Table>() {
        @Override
        public Table apply(BaseTableInfo tableInfo) {
          return new Table(bigquery, tableInfo);
        }
      });
    }

    @Override
    public int hashCode() {
      return Objects.hash(options, infoIterable);
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof LazyTableIterable)) {
        return false;
      }
      LazyTableIterable other = (LazyTableIterable) obj;
      return Objects.equals(options, other.options)
          && Objects.equals(infoIterable, other.infoIterable);
    }
  }

  /**
   * Constructs a {@code Dataset} object for the provided {@code DatasetInfo}. The BigQuery service
   * is used to issue requests.
   *
   * @param bigquery the BigQuery service used for issuing requests
   * @param info dataset's info
   */
  public Dataset(BigQuery bigquery, DatasetInfo info) {
    this.bigquery = checkNotNull(bigquery);
    this.info = checkNotNull(info);
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
    DatasetInfo info = bigquery.getDataset(dataset, options);
    return info != null ? new Dataset(bigquery, info) : null;
  }

  /**
   * Returns the dataset's information.
   */
  public DatasetInfo info() {
    return info;
  }

  /**
   * Checks if this dataset exists.
   *
   * @return {@code true} if this dataset exists, {@code false} otherwise
   * @throws BigQueryException upon failure
   */
  public boolean exists() {
    return bigquery.getDataset(info.datasetId(), BigQuery.DatasetOption.fields()) != null;
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
    return Dataset.get(bigquery, info.datasetId().dataset(), options);
  }

  /**
   * Updates the dataset's information. Dataset's user-defined id cannot be changed. A new
   * {@code Dataset} object is returned.
   *
   * @param datasetInfo new dataset's information. User-defined id must match the one of the current
   *     dataset
   * @param options dataset options
   * @return a {@code Dataset} object with updated information
   * @throws BigQueryException upon failure
   */
  public Dataset update(DatasetInfo datasetInfo, BigQuery.DatasetOption... options) {
    checkArgument(Objects.equals(datasetInfo.datasetId().dataset(),
        info.datasetId().dataset()), "Dataset's user-defined ids must match");
    return new Dataset(bigquery, bigquery.update(datasetInfo, options));
  }

  /**
   * Deletes this dataset.
   *
   * @return {@code true} if dataset was deleted, {@code false} if it was not found
   * @throws BigQueryException upon failure
   */
  public boolean delete() {
    return bigquery.delete(info.datasetId());
  }

  /**
   * Returns the paginated list of tables in this dataset.
   *
   * @param options options for listing tables
   * @throws BigQueryException upon failure
   */
  public Page<Table> list(BigQuery.TableListOption... options) {
    Page<BaseTableInfo> infoPage = bigquery.listTables(info.datasetId(), options);
    BigQueryOptions bigqueryOptions = bigquery.options();
    return new PageImpl<>(new TablePageFetcher(bigqueryOptions, infoPage),
        infoPage.nextPageCursor(), new LazyTableIterable(bigqueryOptions, infoPage.values()));
  }

  /**
   * Returns the requested table in this dataset or {@code null} if not found.
   *
   * @param table user-defined id of the requested table
   * @param options table options
   * @throws BigQueryException upon failure
   */
  public Table get(String table, BigQuery.TableOption... options) {
    BaseTableInfo tableInfo =
        bigquery.getTable(TableId.of(info.datasetId().dataset(), table), options);
    return tableInfo != null ? new Table(bigquery, tableInfo) : null;
  }

  /**
   * Creates a new simple table in this dataset.
   *
   * @param table the table's user-defined id
   * @param schema the table's schema
   * @param options options for table creation
   * @return a {@code Table} object for the created table
   * @throws BigQueryException upon failure
   */
  public Table create(String table, Schema schema, BigQuery.TableOption... options) {
    BaseTableInfo tableInfo = TableInfo.of(TableId.of(info.datasetId().dataset(), table), schema);
    return new Table(bigquery, bigquery.create(tableInfo, options));
  }

  /**
   * Creates a new view table in this dataset.
   *
   * @param table the table's user-defined id
   * @param query the query used to generate the table
   * @param functions user-defined functions that can be used by the query
   * @param options options for table creation
   * @return a {@code Table} object for the created table
   * @throws BigQueryException upon failure
   */
  public Table create(String table, String query, List<UserDefinedFunction> functions,
      BigQuery.TableOption... options) {
    BaseTableInfo tableInfo =
        ViewInfo.of(TableId.of(info.datasetId().dataset(), table), query, functions);
    return new Table(bigquery, bigquery.create(tableInfo, options));
  }

  /**
   * Creates a new view table in this dataset.
   *
   * @param table the table's user-defined id
   * @param query the query used to generate the table
   * @param options options for table creation
   * @return a {@code Table} object for the created table
   * @throws BigQueryException upon failure
   */
  public Table create(String table, String query, BigQuery.TableOption... options) {
    BaseTableInfo tableInfo =  ViewInfo.of(TableId.of(info.datasetId().dataset(), table), query);
    return new Table(bigquery, bigquery.create(tableInfo, options));
  }

  /**
   * Creates a new external table in this dataset.
   *
   * @param table the table's user-defined id
   * @param configuration data format, location and other properties of an external table
   * @param options options for table creation
   * @return a {@code Table} object for the created table
   * @throws BigQueryException upon failure
   */
  public Table create(String table, ExternalDataConfiguration configuration,
      BigQuery.TableOption... options) {
    BaseTableInfo tableInfo =
        ExternalTableInfo.of(TableId.of(info.datasetId().dataset(), table), configuration);
    return new Table(bigquery, bigquery.create(tableInfo, options));
  }

  /**
   * Returns the dataset's {@code BigQuery} object used to issue requests.
   */
  public BigQuery bigquery() {
    return bigquery;
  }
}
