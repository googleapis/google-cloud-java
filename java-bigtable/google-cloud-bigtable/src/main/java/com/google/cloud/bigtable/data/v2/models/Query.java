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

import com.google.api.core.InternalApi;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.TableName;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.Range.ByteStringRange;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/** A simple wrapper to construct a query for the ReadRows RPC. */
public final class Query implements Serializable {
  private static final long serialVersionUID = -316972783499434755L;

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
    builder.setFilter(filter.toProto());
    return this;
  }

  /** Limits the number of rows that can be returned */
  public Query limit(long limit) {
    Preconditions.checkArgument(limit > 0, "Limit must be greater than 0.");
    builder.setRowsLimit(limit);
    return this;
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public ReadRowsRequest toProto(RequestContext requestContext) {
    TableName tableName =
        TableName.of(
            requestContext.getInstanceName().getProject(),
            requestContext.getInstanceName().getInstance(),
            tableId);

    return builder
        .setTableName(tableName.toString())
        .setAppProfileId(requestContext.getAppProfileId())
        .build();
  }

  private static ByteString wrapKey(String key) {
    if (key == null) {
      return null;
    }
    return ByteString.copyFromUtf8(key);
  }
}
