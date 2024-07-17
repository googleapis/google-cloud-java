/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.cloud.bigtable.data.v2.stub.sql.SqlRowMerger;
import com.google.common.collect.ImmutableList;
import java.util.List;

/**
 * Wrapper around {@link SqlRowMerger} that provides an easy way to transform a set of
 * ExecuteQueryResponses into rows. Must create a new instance per ExecuteQueryRequest, and pass in
 * the response stream of ExecuteQueryResponses in the order they were received.
 */
@InternalApi("For internal use only")
@BetaApi
public class SqlRowMergerUtil implements AutoCloseable {

  private final SqlRowMerger merger;

  public SqlRowMergerUtil() {
    merger = new SqlRowMerger();
  }

  @Override
  public void close() {
    if (merger.hasPartialFrame()) {
      throw new IllegalStateException("Tried to close SqlRowMerger with unconsumed partial data");
    }
  }

  /**
   * Transforms a list of {@link ExecuteQueryResponse} objects into a list of {@link
   * com.google.cloud.bigtable.data.v2.internal.ProtoSqlRow} objects . The first call must contain
   * the ResultSetMetadata as the first ExecuteQueryResponse. This will return any complete {@link
   * com.google.cloud.bigtable.data.v2.internal.ProtoSqlRow}s from the given responses and buffer
   * partial rows waiting for the next ExecuteQueryResponse.
   *
   * @param responses List of {@link ExecuteQueryResponse} for a query
   * @return a list of the complete {@link com.google.cloud.bigtable.data.v2.internal.ProtoSqlRow}s
   *     that have been merged from the given responses.
   */
  public List<SqlRow> parseExecuteQueryResponses(ImmutableList<ExecuteQueryResponse> responses) {
    ImmutableList.Builder<SqlRow> rows = new ImmutableList.Builder<>();

    for (ExecuteQueryResponse response : responses) {
      merger.push(response);
      while (merger.hasFullFrame()) {
        rows.add(merger.pop());
      }
    }
    return rows.build();
  }
}
