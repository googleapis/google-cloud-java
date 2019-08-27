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
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.annotation.Nonnull;

/**
 * Represents a list of mutations for multiple rows. Each mutation contains multiple changes that
 * will be atomically applied to each row. However, ordering between rows is not guaranteed.
 *
 * <p>This class is meant for manual batching, while {@link BulkMutationBatcher} is meant for
 * automatic batching with flow control.
 */
public final class BulkMutation implements Serializable, Cloneable {
  private static final long serialVersionUID = 3522061250439399088L;

  private final String tableId;
  private transient MutateRowsRequest.Builder builder;

  public static BulkMutation create(String tableId) {
    return new BulkMutation(tableId);
  }

  private BulkMutation(@Nonnull String tableId) {
    Preconditions.checkNotNull(tableId);

    this.tableId = tableId;
    this.builder = MutateRowsRequest.newBuilder();
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    builder = MutateRowsRequest.newBuilder().mergeFrom(input);
  }

  private void writeObject(ObjectOutputStream output) throws IOException {
    output.defaultWriteObject();
    builder.build().writeTo(output);
  }

  /**
   * Add mutation for a particular row. The changes in the mutation will be applied atomically.
   * However there is no guarantees about the relative ordering between mutations affecting
   * different rows.
   */
  public BulkMutation add(@Nonnull String rowKey, @Nonnull Mutation mutation) {
    Preconditions.checkNotNull(rowKey);
    Preconditions.checkNotNull(mutation);

    return add(ByteString.copyFromUtf8(rowKey), mutation);
  }

  /**
   * Add mutation for a particular row. The changes in the mutation will be applied atomic. However
   * there is no guarantees about the relative ordering between mutations affecting different rows.
   */
  public BulkMutation add(@Nonnull ByteString rowKey, @Nonnull Mutation mutation) {
    Preconditions.checkNotNull(rowKey);
    Preconditions.checkNotNull(mutation);

    builder.addEntries(
        MutateRowsRequest.Entry.newBuilder()
            .setRowKey(rowKey)
            .addAllMutations(mutation.getMutations())
            .build());
    return this;
  }

  /**
   * Add mutation for a particular row. The changes in the mutation will be applied atomic. However
   * there is no guarantees about the relative ordering between mutations affecting different rows.
   */
  public BulkMutation add(@Nonnull RowMutationEntry entry) {
    Preconditions.checkNotNull(entry, "Row mutation entry can't be null");
    builder.addEntries(entry.toProto());
    return this;
  }

  @InternalApi
  public MutateRowsRequest toProto(RequestContext requestContext) {
    String tableName =
        NameUtil.formatTableName(
            requestContext.getProjectId(), requestContext.getInstanceId(), tableId);

    return builder
        .setTableName(tableName)
        .setAppProfileId(requestContext.getAppProfileId())
        .build();
  }

  /** Creates a copy of {@link BulkMutation}. */
  @Override
  public BulkMutation clone() {
    BulkMutation bulkMutation = BulkMutation.create(tableId);
    bulkMutation.builder = this.builder.clone();
    return bulkMutation;
  }
}
