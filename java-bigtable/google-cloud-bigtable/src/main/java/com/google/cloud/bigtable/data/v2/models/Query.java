/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.models;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.RowFilter;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.RowSet;
import com.google.cloud.bigtable.data.v2.internal.ByteStringComparator;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.internal.RowSetUtil;
import com.google.cloud.bigtable.data.v2.models.Range.ByteStringRange;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.Nonnull;

/** A simple wrapper to construct a query for the ReadRows RPC. */
public final class Query implements Serializable {
  private static final long serialVersionUID = -316972783499434755L;

  // bigtable can server the largest filter size of 20KB.
  private static final int MAX_FILTER_SIZE = 20 * 1024;

  private final String tableId;
  private transient ReadRowsRequest.Builder builder = ReadRowsRequest.newBuilder();

  /**
   * Constructs a new Query object for the specified table id. The table id will be combined with
   * the instance name specified in the {@link
   * com.google.cloud.bigtable.data.v2.BigtableDataSettings}.
   */
  public static Query create(String tableId) {
    return new Query(tableId);
  }

  private Query(String tableId) {
    this.tableId = tableId;
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    builder = ReadRowsRequest.newBuilder().mergeFrom(input);
  }

  private void writeObject(ObjectOutputStream output) throws IOException {
    output.defaultWriteObject();
    builder.build().writeTo(output);
  }

  /** Adds a key to looked up */
  public Query rowKey(String key) {
    Preconditions.checkNotNull(key, "Key can't be null.");
    return rowKey(ByteString.copyFromUtf8(key));
  }

  /** Adds a key to looked up */
  public Query rowKey(ByteString key) {
    Preconditions.checkNotNull(key, "Key can't be null.");
    builder.getRowsBuilder().addRowKeys(key);

    return this;
  }

  public Query prefix(ByteString prefix) {
    return range(ByteStringRange.prefix(prefix));
  }

  public Query prefix(String prefix) {
    return range(ByteStringRange.prefix(prefix));
  }

  /**
   * Adds a range to be looked up.
   *
   * @param start The beginning of the range (inclusive). Can be null to represent negative
   *     infinity.
   * @param end The end of the range (exclusive). Can be null to represent positive infinity.
   */
  public Query range(String start, String end) {
    return range(wrapKey(start), wrapKey(end));
  }

  /**
   * Adds a range to be looked up.
   *
   * @param start The beginning of the range (inclusive). Can be null to represent negative
   *     infinity.
   * @param end The end of the range (exclusive). Can be null to represent positive infinity.
   */
  public Query range(ByteString start, ByteString end) {
    RowRange.Builder rangeBuilder = RowRange.newBuilder();
    if (start != null) {
      rangeBuilder.setStartKeyClosed(start);
    }
    if (end != null) {
      rangeBuilder.setEndKeyOpen(end);
    }
    builder.getRowsBuilder().addRowRanges(rangeBuilder.build());
    return this;
  }

  /** Adds a range to be looked up. */
  public Query range(ByteStringRange range) {
    RowRange.Builder rangeBuilder = RowRange.newBuilder();

    switch (range.getStartBound()) {
      case OPEN:
        rangeBuilder.setStartKeyOpen(range.getStart());
        break;
      case CLOSED:
        rangeBuilder.setStartKeyClosed(range.getStart());
        break;
      case UNBOUNDED:
        rangeBuilder.clearStartKey();
        break;
      default:
        throw new IllegalStateException("Unknown start bound: " + range.getStartBound());
    }

    switch (range.getEndBound()) {
      case OPEN:
        rangeBuilder.setEndKeyOpen(range.getEnd());
        break;
      case CLOSED:
        rangeBuilder.setEndKeyClosed(range.getEnd());
        break;
      case UNBOUNDED:
        rangeBuilder.clearEndKey();
        break;
      default:
        throw new IllegalStateException("Unknown end bound: " + range.getEndBound());
    }

    builder.getRowsBuilder().addRowRanges(rangeBuilder.build());

    return this;
  }

  /**
   * Sets the filter to apply to each row. Only one filter can be set at a time. To use multiple
   * filters, please use {@link Filters#interleave()} or {@link Filters#chain()}.
   */
  public Query filter(Filters.Filter filter) {
    Preconditions.checkNotNull(filter, "filter can't be null");

    RowFilter rowFilter = filter.toProto();
    Preconditions.checkArgument(
        rowFilter.getSerializedSize() < MAX_FILTER_SIZE, "filter size can't be more than 20KB");

    builder.setFilter(rowFilter);
    return this;
  }

  /** Limits the number of rows that can be returned */
  public Query limit(long limit) {
    Preconditions.checkArgument(limit > 0, "Limit must be greater than 0.");
    builder.setRowsLimit(limit);
    return this;
  }

  /**
   * Split this query into multiple queries that can be evenly distributed across Bigtable nodes and
   * be run in parallel. This method takes the results from {@link
   * com.google.cloud.bigtable.data.v2.BigtableDataClient#sampleRowKeysAsync(String)} to divide this
   * query into a set of disjoint queries that logically combine into form this query.
   *
   * <p>Expected Usage:
   *
   * <pre>{@code
   * List<KeyOffset> keyOffsets = dataClient.sampleRowKeysAsync("my-table").get();
   * List<Query> queryShards = myQuery.shard(keyOffsets);
   * List<ApiFuture<List<Row>>> futures = new ArrayList();
   * for (Query subQuery : queryShards) {
   *   futures.add(dataClient.readRowsCallable().all().futureCall(subQuery));
   * }
   * List<List<Row>> results = ApiFutures.allAsList(futures).get();
   * }</pre>
   */
  public List<Query> shard(List<KeyOffset> sampledRowKeys) {
    Preconditions.checkState(builder.getRowsLimit() == 0, "Can't shard query with row limits");

    ImmutableSortedSet.Builder<ByteString> splitPoints =
        ImmutableSortedSet.orderedBy(ByteStringComparator.INSTANCE);

    for (KeyOffset keyOffset : sampledRowKeys) {
      if (!keyOffset.getKey().isEmpty()) {
        splitPoints.add(keyOffset.getKey());
      }
    }

    return shard(splitPoints.build());
  }

  /**
   * Split this query into multiple queries that logically combine into this query. This is intended
   * to be used by map reduce style frameworks like Beam to split a query across multiple workers.
   *
   * <p>Expected Usage:
   *
   * <pre>{@code
   * List<ByteString> splitPoints = ...;
   * List<Query> queryShards = myQuery.shard(splitPoints);
   * List<ApiFuture<List<Row>>> futures = new ArrayList();
   * for (Query subQuery : queryShards) {
   *   futures.add(dataClient.readRowsCallable().all().futureCall(subQuery));
   * }
   * List<List<Row>> results = ApiFutures.allAsList(futures).get();
   * }</pre>
   */
  public List<Query> shard(SortedSet<ByteString> splitPoints) {
    Preconditions.checkState(builder.getRowsLimit() == 0, "Can't shard a query with a row limit");

    List<RowSet> shardedRowSets = RowSetUtil.shard(builder.getRows(), splitPoints);
    List<Query> shards = Lists.newArrayListWithCapacity(shardedRowSets.size());

    for (RowSet rowSet : shardedRowSets) {
      Query queryShard = new Query(tableId);
      queryShard.builder.mergeFrom(this.builder.build());
      queryShard.builder.setRows(rowSet);
      shards.add(queryShard);
    }

    return shards;
  }

  /**
   * Create a query paginator that'll split the query into smaller chunks.
   *
   * <p>Example usage:
   *
   * <pre>{@code
   * Query query = Query.create(...).range("a", "z");
   * Query.QueryPaginator paginator = query.createQueryPaginator(100);
   * ByteString lastSeenRowKey = ByteString.EMPTY;
   * do {
   *     List<Row> rows = client.readRowsCallable().all().call(paginator.getNextQuery());
   *     for (Row row : rows) {
   *        // do some processing
   *        lastSeenRow = row;
   *     }
   * } while (paginator.advance(lastSeenRowKey));
   * }</pre>
   */
  @BetaApi("This surface is stable yet it might be removed in the future.")
  public QueryPaginator createPaginator(int pageSize) {
    return new QueryPaginator(this, pageSize);
  }

  /** Get the minimal range that encloses all of the row keys and ranges in this Query. */
  public ByteStringRange getBound() {
    return RowSetUtil.getBound(builder.getRows());
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public ReadRowsRequest toProto(RequestContext requestContext) {
    String tableName =
        NameUtil.formatTableName(
            requestContext.getProjectId(), requestContext.getInstanceId(), tableId);

    return builder
        .setTableName(tableName)
        .setAppProfileId(requestContext.getAppProfileId())
        .build();
  }

  /**
   * Wraps the protobuf {@link ReadRowsRequest}.
   *
   * <p>WARNING: Please note that the project id & instance id in the table name will be overwritten
   * by the configuration in the BigtableDataClient.
   */
  public static Query fromProto(@Nonnull ReadRowsRequest request) {
    Preconditions.checkArgument(request != null, "ReadRowsRequest must not be null");

    Query query = new Query(NameUtil.extractTableIdFromTableName(request.getTableName()));
    query.builder = request.toBuilder();

    return query;
  }

  public Query clone() {
    Query query = Query.create(tableId);
    query.builder = this.builder.clone();
    return query;
  }

  private static ByteString wrapKey(String key) {
    if (key == null) {
      return null;
    }
    return ByteString.copyFromUtf8(key);
  }

  /**
   * A Query Paginator that will split a query into small chunks. See {@link
   * Query#createPaginator(int)} for example usage.
   */
  @BetaApi("This surface is stable yet it might be removed in the future.")
  public static class QueryPaginator {

    private final boolean hasOverallLimit;
    private long remainingRows;
    private Query query;
    private final int pageSize;
    private ByteString prevSplitPoint;

    QueryPaginator(@Nonnull Query query, int pageSize) {
      this.hasOverallLimit = query.builder.getRowsLimit() > 0;
      this.remainingRows = query.builder.getRowsLimit();
      this.query = query.limit(pageSize);
      if (hasOverallLimit) {
        remainingRows -= pageSize;
      }
      this.pageSize = pageSize;
      this.prevSplitPoint = ByteString.EMPTY;
    }

    /** Return the next query. */
    public Query getNextQuery() {
      return query;
    }

    /**
     * Construct the next query. Return true if there are more queries to return. False if we've
     * read everything.
     */
    public boolean advance(@Nonnull ByteString lastSeenRowKey) {
      Preconditions.checkNotNull(
          lastSeenRowKey, "lastSeenRowKey cannot be null, use ByteString.EMPTY instead.");
      // Full table scans don't have ranges or limits. Running the query again will return an empty
      // list when we reach the end of the table. lastSeenRowKey won't be updated in this case, and
      // we can break out of the loop.
      if (lastSeenRowKey.equals(prevSplitPoint)) {
        return false;
      }
      this.prevSplitPoint = lastSeenRowKey;

      // Set the query limit. If the original limit is set, return false if the new
      // limit is <= 0 to avoid returning more rows than intended.
      if (hasOverallLimit && remainingRows <= 0) {
        return false;
      }
      if (hasOverallLimit) {
        query.limit(Math.min(this.pageSize, remainingRows));
        remainingRows -= pageSize;
      } else {
        query.limit(pageSize);
      }

      // Split the row ranges / row keys. Return false if there's nothing
      // left on the right of the split point.
      RowSetUtil.Split split = RowSetUtil.split(query.builder.getRows(), lastSeenRowKey);
      if (split.getRight() == null) {
        return false;
      }
      query.builder.setRows(split.getRight());
      return true;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Query query = (Query) o;
    return Objects.equal(tableId, query.tableId)
        && Objects.equal(builder.getRows(), query.builder.getRows())
        && Objects.equal(builder.getFilter(), query.builder.getFilter())
        && Objects.equal(builder.getRowsLimit(), query.builder.getRowsLimit());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        tableId, builder.getRows(), builder.getFilter(), builder.getRowsLimit());
  }

  @Override
  public String toString() {
    ReadRowsRequest request = builder.build();

    return MoreObjects.toStringHelper(this)
        .add("tableId", tableId)
        .add("keys", request.getRows().getRowKeysList())
        .add("ranges", request.getRows().getRowRangesList())
        .add("filter", request.getFilter())
        .add("limit", request.getRowsLimit())
        .toString();
  }
}
