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
package com.google.cloud.bigtable.data.v2.wrappers;

import com.google.api.core.InternalApi;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsRequest.Entry;
import com.google.bigtable.v2.TableName;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.protobuf.ByteString;
import javax.annotation.Nonnull;

public class RowMutation extends AbstractMutation<RowMutation> {

  private final String tableId;
  private final ByteString key;

  private RowMutation(String tableId, ByteString key) {
    this.tableId = tableId;
    this.key = key;
  }

  public static RowMutation create(@Nonnull String tableId, @Nonnull String key) {
    return create(tableId, ByteString.copyFromUtf8(key));
  }

  public static RowMutation create(@Nonnull String tableId, @Nonnull ByteString key) {
    return new RowMutation(tableId, key);
  }

  @InternalApi
  public MutateRowRequest toProto(RequestContext requestContext) {
    TableName tableName =
        TableName.of(
            requestContext.getInstanceName().getProject(),
            requestContext.getInstanceName().getInstance(),
            tableId);

    return MutateRowRequest.newBuilder()
        .setAppProfileId(requestContext.getAppProfileId())
        .setTableName(tableName.toString())
        .setRowKey(key)
        .addAllMutations(getMutations())
        .build();
  }

  /**
   * Creates a single entry bulk {@link com.google.bigtable.v2.MutateRowsRequest}, which will be
   * merged by the batching logic in the callable chain.
   */
  @InternalApi
  public MutateRowsRequest toBulkProto(RequestContext requestContext) {
    TableName tableName =
        TableName.of(
            requestContext.getInstanceName().getProject(),
            requestContext.getInstanceName().getInstance(),
            tableId);

    return MutateRowsRequest.newBuilder()
        .setAppProfileId(requestContext.getAppProfileId())
        .setTableName(tableName.toString())
        .addEntries(Entry.newBuilder().setRowKey(key).addAllMutations(getMutations()).build())
        .build();
  }
}
