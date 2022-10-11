/*
 * Copyright 2019 Google LLC
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
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import java.io.Serializable;
import javax.annotation.Nonnull;

/**
 * Represents a list of mutations targeted at a single row. It is meant to be used as an parameter
 * for {@link com.google.cloud.bigtable.data.v2.BigtableDataClient#newBulkMutationBatcher(String)}.
 *
 * <p>Note: The changes in the mutation will be applied atomically but the ordering between
 * different RowMutationEntry instances is not guaranteed.
 */
public class RowMutationEntry implements MutationApi<RowMutationEntry>, Serializable {
  private static final long serialVersionUID = 1974738836742298192L;

  private final ByteString key;
  private final Mutation mutation;

  private RowMutationEntry(@Nonnull ByteString key, @Nonnull Mutation mutation) {
    Preconditions.checkNotNull(key, "Row key can't be null");
    Preconditions.checkNotNull(mutation, "Row mutation can't be null");

    this.key = key;
    this.mutation = mutation;
  }

  /** Creates a new instance of the mutation builder. */
  public static RowMutationEntry create(@Nonnull String key) {
    Preconditions.checkNotNull(key, "Row key can't be null");
    return create(ByteString.copyFromUtf8(key));
  }

  /** Creates a new instance of the mutation builder. */
  public static RowMutationEntry create(@Nonnull ByteString key) {
    return new RowMutationEntry(key, Mutation.create());
  }

  /** Creates a new instance from existing mutation. */
  @BetaApi
  public static RowMutationEntry createFromMutationUnsafe(
      @Nonnull ByteString key, @Nonnull Mutation mutation) {
    return new RowMutationEntry(key, mutation);
  }

  /**
   * Creates new instance of mutation builder which allows server timestamp for setCell operations.
   *
   * <p>NOTE: This functionality is intended for advanced usage.
   *
   * @see Mutation#createUnsafe() for more explanation.
   */
  @InternalApi("For internal usage only")
  public static RowMutationEntry createUnsafe(@Nonnull ByteString key) {
    return new RowMutationEntry(key, Mutation.createUnsafe());
  }

  /** {@inheritDoc} */
  @Override
  public RowMutationEntry setCell(
      @Nonnull String familyName, @Nonnull String qualifier, @Nonnull String value) {
    mutation.setCell(familyName, qualifier, value);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public RowMutationEntry setCell(
      @Nonnull String familyName,
      @Nonnull String qualifier,
      long timestamp,
      @Nonnull String value) {
    mutation.setCell(familyName, qualifier, timestamp, value);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public RowMutationEntry setCell(
      @Nonnull String familyName, @Nonnull ByteString qualifier, @Nonnull ByteString value) {
    mutation.setCell(familyName, qualifier, value);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public RowMutationEntry setCell(
      @Nonnull String familyName,
      @Nonnull ByteString qualifier,
      long timestamp,
      @Nonnull ByteString value) {
    mutation.setCell(familyName, qualifier, timestamp, value);
    return this;
  }

  @Override
  public RowMutationEntry setCell(
      @Nonnull String familyName, @Nonnull String qualifier, long value) {
    mutation.setCell(familyName, qualifier, value);
    return this;
  }

  @Override
  public RowMutationEntry setCell(
      @Nonnull String familyName, @Nonnull String qualifier, long timestamp, long value) {
    mutation.setCell(familyName, qualifier, timestamp, value);
    return this;
  }

  @Override
  public RowMutationEntry setCell(
      @Nonnull String familyName, @Nonnull ByteString qualifier, long value) {
    mutation.setCell(familyName, qualifier, value);
    return this;
  }

  @Override
  public RowMutationEntry setCell(
      @Nonnull String familyName, @Nonnull ByteString qualifier, long timestamp, long value) {
    mutation.setCell(familyName, qualifier, timestamp, value);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public RowMutationEntry deleteCells(@Nonnull String familyName, @Nonnull String qualifier) {
    mutation.deleteCells(familyName, qualifier);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public RowMutationEntry deleteCells(@Nonnull String familyName, @Nonnull ByteString qualifier) {
    mutation.deleteCells(familyName, qualifier);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public RowMutationEntry deleteCells(
      @Nonnull String familyName,
      @Nonnull ByteString qualifier,
      @Nonnull Range.TimestampRange timestampRange) {
    mutation.deleteCells(familyName, qualifier, timestampRange);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public RowMutationEntry deleteFamily(@Nonnull String familyName) {
    mutation.deleteFamily(familyName);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public RowMutationEntry deleteRow() {
    mutation.deleteRow();
    return this;
  }

  @InternalApi
  public MutateRowsRequest.Entry toProto() {
    return MutateRowsRequest.Entry.newBuilder()
        .setRowKey(key)
        .addAllMutations(mutation.getMutations())
        .build();
  }
}
