/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.readrows;

import com.google.api.core.InternalApi;
import com.google.api.gax.batching.BatchEntry;
import com.google.api.gax.batching.BatchingDescriptor;
import com.google.api.gax.batching.BatchingRequestBuilder;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.protobuf.ByteString;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation for {@link BatchingDescriptor} to split batch response or exception into
 * individual row request.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications directly.
 */
@InternalApi("For internal use only")
public class ReadRowsBatchingDescriptor
    implements BatchingDescriptor<ByteString, Row, Query, List<Row>> {

  @Override
  public BatchingRequestBuilder<ByteString, Query> newRequestBuilder(Query query) {
    return new BulkReadRequestBuilder(query);
  }

  @Override
  public void splitResponse(List<Row> rowsResponse, List<BatchEntry<ByteString, Row>> entries) {
    Map<ByteString, Row> rowKeys = new HashMap<>();
    for (Row row : rowsResponse) {
      rowKeys.put(row.getKey(), row);
    }

    for (BatchEntry<ByteString, Row> entry : entries) {
      entry.getResultFuture().set(rowKeys.get(entry.getElement()));
    }
  }

  @Override
  public void splitException(Throwable throwable, List<BatchEntry<ByteString, Row>> entries) {
    for (BatchEntry<ByteString, Row> resultEntry : entries) {
      resultEntry.getResultFuture().setException(throwable);
    }
  }

  @Override
  public long countBytes(ByteString bytes) {
    return bytes.size();
  }

  static class BulkReadRequestBuilder implements BatchingRequestBuilder<ByteString, Query> {
    private final Query query;

    BulkReadRequestBuilder(Query query) {
      this.query = query.clone();
    }

    @Override
    public void add(ByteString rowKey) {
      query.rowKey(rowKey);
    }

    @Override
    public Query build() {
      return query;
    }
  }
}
