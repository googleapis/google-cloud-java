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
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
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

  private RowMutation(String tableId, ByteString key, Mutation mutation) {
    this.tableId = tableId;
    this.key = key;
    this.mutation = mutation;
  }

  /** Creates a new instance of the mutation builder. */
  public static RowMutation create(@Nonnull String tableId, @Nonnull String key) {
    return create(tableId, ByteString.copyFromUtf8(key));
  }

  /** Creates a new instance of the mutation builder. */
  public static RowMutation create(@Nonnull String tableId, @Nonnull ByteString key) {
    return new RowMutation(tableId, key, Mutation.create());
  }

  /**
   * Creates new instance of mutation builder by wrapping existing set of row mutations. The builder
   * will be owned by this RowMutation and should not be used by the caller after this call. This
   * functionality is intended for advanced usage.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * Mutation mutation = Mutation.create()
   *     .setCell("[FAMILY_NAME]", "[QUALIFIER]", [TIMESTAMP], "[VALUE]");
   * RowMutation rowMutation = RowMutation.create("[TABLE]", "[ROW_KEY]", mutation);
   * </code></pre>
   */
  public static RowMutation create(
      @Nonnull String tableId, @Nonnull String key, @Nonnull Mutation mutation) {
    return create(tableId, ByteString.copyFromUtf8(key), mutation);
  }

  /**
   * Creates new instance of mutation builder by wrapping existing set of row mutations. The builder
   * will be owned by this RowMutation and should not be used by the caller after this call. This
   * functionality is intended for advanced usage.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * Mutation mutation = Mutation.create()
   *     .setCell("[FAMILY_NAME]", "[QUALIFIER]", [TIMESTAMP], "[VALUE]");
   * RowMutation rowMutation = RowMutation.create("[TABLE]", [BYTE_STRING_ROW_KEY], mutation);
   * </code></pre>
   */
  public static RowMutation create(
      @Nonnull String tableId, @Nonnull ByteString key, @Nonnull Mutation mutation) {
    return new RowMutation(tableId, key, mutation);
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
  public RowMutation setCell(@Nonnull String familyName, @Nonnull String qualifier, long value) {
    mutation.setCell(familyName, qualifier, value);
    return this;
  }

  @Override
  public RowMutation setCell(
      @Nonnull String familyName, @Nonnull String qualifier, long timestamp, long value) {
    mutation.setCell(familyName, qualifier, timestamp, value);
    return this;
  }

  @Override
  public RowMutation setCell(
      @Nonnull String familyName, @Nonnull ByteString qualifier, long value) {
    mutation.setCell(familyName, qualifier, value);
    return this;
  }

  @Override
  public RowMutation setCell(
      @Nonnull String familyName, @Nonnull ByteString qualifier, long timestamp, long value) {
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
    String tableName =
        NameUtil.formatTableName(
            requestContext.getProjectId(), requestContext.getInstanceId(), tableId);

    return MutateRowRequest.newBuilder()
        .setAppProfileId(requestContext.getAppProfileId())
        .setTableName(tableName)
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
    String tableName =
        NameUtil.formatTableName(
            requestContext.getProjectId(), requestContext.getInstanceId(), tableId);

    return MutateRowsRequest.newBuilder()
        .setAppProfileId(requestContext.getAppProfileId())
        .setTableName(tableName)
        .addEntries(
            Entry.newBuilder().setRowKey(key).addAllMutations(mutation.getMutations()).build())
        .build();
  }
}
