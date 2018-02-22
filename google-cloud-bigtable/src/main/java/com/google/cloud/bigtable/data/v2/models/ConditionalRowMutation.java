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

/** Mutates a row atomically based on the output of a condition filter. */
public final class ConditionalRowMutation {
  private final String tableId;
  private final CheckAndMutateRowRequest.Builder builder = CheckAndMutateRowRequest.newBuilder();

  private ConditionalRowMutation(String tableId, ByteString rowKey) {
    this.tableId = tableId;
    builder.setRowKey(rowKey);
  }

  /** Creates a new instance of the mutation builder. */
  public static ConditionalRowMutation create(String tableId, String key) {
    return create(tableId, ByteString.copyFromUtf8(key));
  }

  /** Creates a new instance of the mutation builder. */
  public static ConditionalRowMutation create(String tableId, ByteString key) {
    Validations.validateTableId(tableId);

    return new ConditionalRowMutation(tableId, key);
  }

  /**
   * The filter to be applied to the contents of the specified row. Depending on whether or not any
   * results are yielded, either the mutations added via {@link #then(Mutation)} or {@link
   * #otherwise(Mutation)} will be executed. If unset, checks that the row contains any values at
   * all.
   */
  public ConditionalRowMutation condition(Filter condition) {
    Preconditions.checkState(
        !builder.hasPredicateFilter(),
        "Can only have a single condition, please use a Filters#chain or Filters#interleave filter instead");

    builder.setPredicateFilter(condition.toProto());

    return this;
  }

  /**
   * Adds changes to be atomically applied to the specified row if the condition yields at least one
   * cell when applied to the row. Entries are applied in order, meaning that earlier mutations can
   * be masked by later ones. Must contain at least one entry if {@link #otherwise(Mutation)} is
   * empty, and at most 100000.
   */
  public ConditionalRowMutation then(Mutation mutation) {
    builder.addAllTrueMutations(mutation.getMutations());
    return this;
  }

  /**
   * Adds changes to be atomically applied to the specified row if the condition does not yield any
   * cells when applied to the row. Entries are applied in order, meaning that earlier mutations can
   * be masked by later ones. Must contain at least one entry if {@link #then(Mutation)} is empty,
   * and at most 100000.
   */
  public ConditionalRowMutation otherwise(Mutation mutation) {
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
