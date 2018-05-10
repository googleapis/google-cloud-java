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
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsRequest.Entry;
import com.google.bigtable.v2.TableName;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.Range.TimestampRange;
import com.google.protobuf.ByteString;
import java.io.Serializable;
import javax.annotation.Nonnull;

/**
 * Represents a list of mutations targeted at a single row. It's meant to be used as an parameter
 * for {@link com.google.cloud.bigtable.data.v2.BigtableDataClient#mutateRowAsync(RowMutation)}.
 */
public final class RowMutation implements MutationApi<RowMutation>, Serializable {
  private static final long serialVersionUID = 6529002234913236318L;

  private final String tableId;
  private final ByteString key;
  private final Mutation mutation;

  private RowMutation(String tableId, ByteString key) {
    this.tableId = tableId;
    this.key = key;
    this.mutation = Mutation.create();
  }

  public static RowMutation create(@Nonnull String tableId, @Nonnull String key) {
    return create(tableId, ByteString.copyFromUtf8(key));
  }

  public static RowMutation create(@Nonnull String tableId, @Nonnull ByteString key) {
    return new RowMutation(tableId, key);
  }

  @Override
  public RowMutation setCell(
      @Nonnull String familyName, @Nonnull String qualifier, @Nonnull String value) {
    mutation.setCell(familyName, qualifier, value);
    return this;
  }

  @Override
  public RowMutation setCell(
      @Nonnull String familyName,
      @Nonnull String qualifier,
      long timestamp,
      @Nonnull String value) {
    mutation.setCell(familyName, qualifier, timestamp, value);
    return this;
  }

  @Override
  public RowMutation setCell(
      @Nonnull String familyName, @Nonnull ByteString qualifier, @Nonnull ByteString value) {
    mutation.setCell(familyName, qualifier, value);
    return this;
  }

  @Override
  public RowMutation setCell(
      @Nonnull String familyName,
      @Nonnull ByteString qualifier,
      long timestamp,
      @Nonnull ByteString value) {
    mutation.setCell(familyName, qualifier, timestamp, value);
    return this;
  }

  @Override
  public RowMutation deleteCells(@Nonnull String familyName, @Nonnull String qualifier) {
    mutation.deleteCells(familyName, qualifier);
    return this;
  }

  @Override
  public RowMutation deleteCells(@Nonnull String familyName, @Nonnull ByteString qualifier) {
    mutation.deleteCells(familyName, qualifier);
    return this;
  }

  @Override
  public RowMutation deleteCells(
      @Nonnull String familyName,
      @Nonnull ByteString qualifier,
      @Nonnull TimestampRange timestampRange) {
    mutation.deleteCells(familyName, qualifier, timestampRange);
    return this;
  }

  @Override
  public RowMutation deleteFamily(@Nonnull String familyName) {
    mutation.deleteFamily(familyName);
    return this;
  }

  @Override
  public RowMutation deleteRow() {
    mutation.deleteRow();
    return this;
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
        .addAllMutations(mutation.getMutations())
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
        .addEntries(
            Entry.newBuilder().setRowKey(key).addAllMutations(mutation.getMutations()).build())
        .build();
  }
}
