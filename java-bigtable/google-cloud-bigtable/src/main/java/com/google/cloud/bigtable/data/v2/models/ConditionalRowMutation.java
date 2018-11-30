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
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.TableName;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.Filters.Filter;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.annotation.Nonnull;

/** Mutates a row atomically based on the output of a condition filter. */
public final class ConditionalRowMutation implements Serializable {
  private static final long serialVersionUID = -3699904745621909502L;

  private final String tableId;
  private transient CheckAndMutateRowRequest.Builder builder =
      CheckAndMutateRowRequest.newBuilder();

  private ConditionalRowMutation(String tableId, ByteString rowKey) {
    this.tableId = tableId;
    builder.setRowKey(rowKey);
  }

  /** Creates a new instance of the mutation builder. */
  public static ConditionalRowMutation create(String tableId, String rowKey) {
    return create(tableId, ByteString.copyFromUtf8(rowKey));
  }

  /** Creates a new instance of the mutation builder. */
  public static ConditionalRowMutation create(String tableId, ByteString rowKey) {
    Validations.validateTableId(tableId);

    return new ConditionalRowMutation(tableId, rowKey);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    builder = CheckAndMutateRowRequest.newBuilder().mergeFrom(input);
  }

  private void writeObject(ObjectOutputStream output) throws IOException {
    output.defaultWriteObject();
    builder.build().writeTo(output);
  }

  /**
   * The filter to be applied to the contents of the specified row. Depending on whether or not any
   * results are yielded, either the mutations added via {@link #then(Mutation)} or {@link
   * #otherwise(Mutation)} will be executed. If unset, checks that the row contains any values at
   * all.
   *
   * <p>Unlike {@link #then(Mutation)} and {@link #otherwise(Mutation)}, only a single condition can
   * be set. However that filter can be a {@link Filters#chain()} or {@link Filters#interleave()},
   * which can wrap multiple other filters.
   *
   * <p>WARNING: {@link Filters#condition(Filter)} is not supported.
   */
  public ConditionalRowMutation condition(@Nonnull Filter condition) {
    Preconditions.checkNotNull(condition);
    Preconditions.checkState(
        !builder.hasPredicateFilter(),
        "Can only have a single condition, please use a Filters#chain or Filters#interleave filter instead");
    // TODO: verify that the condition does not use any FILTERS.condition() filters

    builder.setPredicateFilter(condition.toProto());

    return this;
  }

  /**
   * Adds changes to be atomically applied to the specified row if the condition yields at least one
   * cell when applied to the row.
   *
   * <p>Each {@code mutation} can specify multiple changes and the changes are accumulated each time
   * this method is called. Mutations are applied in order, meaning that earlier mutations can be
   * masked by later ones. Must contain at least one entry if {@link #otherwise(Mutation)} is empty,
   * and at most 100000.
   */
  public ConditionalRowMutation then(@Nonnull Mutation mutation) {
    Preconditions.checkNotNull(mutation);
    builder.addAllTrueMutations(mutation.getMutations());
    return this;
  }

  /**
   * Adds changes to be atomically applied to the specified row if the condition does not yields any
   * cells when applied to the row.
   *
   * <p>Each {@code mutation} can specify multiple changes and the changes are accumulated each time
   * this method is called. Mutations are applied in order, meaning that earlier mutations can be
   * masked by later ones. Must contain at least one entry if {@link #then(Mutation)} is empty, and
   * at most 100000.
   */
  public ConditionalRowMutation otherwise(@Nonnull Mutation mutation) {
    Preconditions.checkNotNull(mutation);
    builder.addAllFalseMutations(mutation.getMutations());
    return this;
  }

  /**
   * Creates the underlying {@link CheckAndMutateRowRequest} protobuf.
   *
   * <p>This method is considered an internal implementation detail and not meant to be used by
   * applications.
   */
  @InternalApi
  public CheckAndMutateRowRequest toProto(RequestContext requestContext) {
    Preconditions.checkState(
        !builder.getTrueMutationsList().isEmpty() || !builder.getFalseMutationsList().isEmpty(),
        "ConditionalRowMutations must have `then` or `otherwise` mutations.");
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
}
