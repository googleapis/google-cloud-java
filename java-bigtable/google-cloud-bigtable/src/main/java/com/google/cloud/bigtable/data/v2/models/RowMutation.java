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
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsRequest.Entry;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.Range.TimestampRange;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import java.io.Serializable;
import javax.annotation.Nonnull;

/**
 * Represents a list of mutations targeted at a single row. It's meant to be used as an parameter
 * for {@link com.google.cloud.bigtable.data.v2.BigtableDataClient#mutateRowAsync(RowMutation)}.
 */
public final class RowMutation implements MutationApi<RowMutation>, Serializable {
  private static final long serialVersionUID = 6529002234913236318L;

  private final TargetId targetId;
  private final ByteString key;
  private final Mutation mutation;

  private RowMutation(TargetId targetId, ByteString key, Mutation mutation) {
    Preconditions.checkNotNull(targetId, "target id can't be null.");

    this.targetId = targetId;
    this.key = key;
    this.mutation = mutation;
  }

  /**
   * @deprecated Please use {@link RowMutation#create(TargetId, String)} instead.
   */
  @Deprecated
  public static RowMutation create(String tableId, String key) {
    return create(tableId, ByteString.copyFromUtf8(key));
  }

  /**
   * Creates a new instance of the mutation builder for the given target with targetId.
   *
   * @see AuthorizedViewId
   * @see TableId
   */
  public static RowMutation create(TargetId targetId, String key) {
    Preconditions.checkNotNull(targetId, "target id can't be null.");
    return create(targetId, ByteString.copyFromUtf8(key));
  }

  /**
   * @deprecated Please use {@link RowMutation#create(TargetId, ByteString)} instead.
   */
  @Deprecated
  public static RowMutation create(String tableId, ByteString key) {
    return new RowMutation(TableId.of(tableId), key, Mutation.create());
  }

  /**
   * Creates a new instance of the mutation builder for the given target with targetId.
   *
   * @see AuthorizedViewId
   * @see TableId
   */
  public static RowMutation create(TargetId targetId, ByteString key) {
    Preconditions.checkNotNull(targetId, "target id can't be null.");
    return new RowMutation(targetId, key, Mutation.create());
  }

  /**
   * @deprecated Please use {@link RowMutation#create(TargetId, String, Mutation)} instead.
   */
  @Deprecated
  public static RowMutation create(String tableId, String key, Mutation mutation) {
    return create(tableId, ByteString.copyFromUtf8(key), mutation);
  }

  /**
   * Creates new instance of mutation builder for the given target with targetId by wrapping
   * existing set of row mutations. The builder will be owned by this RowMutation and should not be
   * used by the caller after this call. This functionality is intended for advanced usage.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * Mutation mutation = Mutation.create()
   *     .setCell("[FAMILY_NAME]", "[QUALIFIER]", [TIMESTAMP], "[VALUE]");
   * RowMutation rowMutation = RowMutation.create(TableId.of("[TABLE]"), "[ROW_KEY]", mutation);
   * </code></pre>
   *
   * @see AuthorizedViewId
   * @see TableId
   */
  public static RowMutation create(TargetId targetId, String key, Mutation mutation) {
    return create(targetId, ByteString.copyFromUtf8(key), mutation);
  }

  /**
   * @deprecated Please use {@link RowMutation#create(TargetId, ByteString, Mutation)} instead.
   */
  @Deprecated
  public static RowMutation create(String tableId, ByteString key, Mutation mutation) {
    return new RowMutation(TableId.of(tableId), key, mutation);
  }

  /**
   * Creates new instance of mutation builder for the given target with targetId by wrapping
   * existing set of row mutations. The builder will be owned by this RowMutation and should not be
   * used by the caller after this call. This functionality is intended for advanced usage.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * Mutation mutation = Mutation.create()
   *     .setCell("[FAMILY_NAME]", "[QUALIFIER]", [TIMESTAMP], "[VALUE]");
   * RowMutation rowMutation = RowMutation.create(TableId.of("[TABLE]"), [BYTE_STRING_ROW_KEY], mutation);
   * </code></pre>
   *
   * @see AuthorizedViewId
   * @see TableId
   */
  public static RowMutation create(TargetId targetId, ByteString key, Mutation mutation) {
    return new RowMutation(targetId, key, mutation);
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

  @Override
  public RowMutation addToCell(
      @Nonnull String familyName,
      @Nonnull Value qualifier,
      @Nonnull Value timestamp,
      @Nonnull Value input) {
    mutation.addToCell(familyName, qualifier, timestamp, input);
    return this;
  }

  @Override
  public RowMutation mergeToCell(
      @Nonnull String familyName,
      @Nonnull Value qualifier,
      @Nonnull Value timestamp,
      @Nonnull Value input) {
    mutation.mergeToCell(familyName, qualifier, timestamp, input);
    return this;
  }

  @InternalApi
  public MutateRowRequest toProto(RequestContext requestContext) {
    MutateRowRequest.Builder builder = MutateRowRequest.newBuilder();
    String resourceName =
        targetId.toResourceName(requestContext.getProjectId(), requestContext.getInstanceId());
    if (targetId.scopedForAuthorizedView()) {
      builder.setAuthorizedViewName(resourceName);
    } else {
      builder.setTableName(resourceName);
    }

    return builder
        .setAppProfileId(requestContext.getAppProfileId())
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
    MutateRowsRequest.Builder builder = MutateRowsRequest.newBuilder();
    String resourceName =
        targetId.toResourceName(requestContext.getProjectId(), requestContext.getInstanceId());
    if (targetId.scopedForAuthorizedView()) {
      builder.setAuthorizedViewName(resourceName);
    } else {
      builder.setTableName(resourceName);
    }

    return builder
        .setAppProfileId(requestContext.getAppProfileId())
        .addEntries(
            Entry.newBuilder().setRowKey(key).addAllMutations(mutation.getMutations()).build())
        .build();
  }

  /**
   * Wraps the protobuf {@link MutateRowRequest}.
   *
   * <p>This is meant for advanced usage only. Please ensure that the MutateRowRequest does not use
   * server side timestamps. The BigtableDataClient assumes that RowMutations are idempotent and is
   * configured to enable retries by default. If serverside timestamps are enabled, this can lead to
   * duplicate mutations.
   *
   * <p>WARNING: when applied, the resulting mutation object will ignore the project id and instance
   * id in the table_name and instead apply the configuration in the client.
   */
  @BetaApi
  public static RowMutation fromProto(@Nonnull MutateRowRequest request) {
    String tableName = request.getTableName();
    String authorizedViewName = request.getAuthorizedViewName();

    return RowMutation.create(
        NameUtil.extractTargetId(tableName, authorizedViewName),
        request.getRowKey(),
        Mutation.fromProto(request.getMutationsList()));
  }
}
