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
import com.google.api.core.InternalExtensionOnly;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.Mutation.DeleteFromColumn;
import com.google.bigtable.v2.Mutation.DeleteFromFamily;
import com.google.bigtable.v2.Mutation.DeleteFromRow;
import com.google.bigtable.v2.Mutation.SetCell;
import com.google.cloud.bigtable.data.v2.wrappers.Range.TimestampRange;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * This is the base DSL for creating mutations for {@link RowMutation}
 *
 * <p>Package private to allow extension by Bigtable Client, but the methods are public for external
 * usage in the subclasses.
 */
@InternalExtensionOnly
abstract class AbstractMutation<T extends AbstractMutation> {
  private final ImmutableList.Builder<Mutation> mutations = ImmutableList.builder();

  @InternalExtensionOnly
  AbstractMutation() {}

  /**
   * Adds a mutation which sets the value of the specified cell.
   *
   * <p>This a convenience method that converts Strings to ByteStrings and uses microseconds since
   * epoch as the timestamp.
   */
  public T setCell(@Nonnull String familyName, @Nonnull String qualifier, @Nonnull String value) {
    return setCell(familyName, wrapByteString(qualifier), wrapByteString(value));
  }

  /**
   * Adds a mutation which sets the value of the specified cell.
   *
   * <p>This is a convenience override that converts Strings to ByteStrings.
   */
  public T setCell(
      @Nonnull String familyName,
      @Nonnull String qualifier,
      long timestamp,
      @Nonnull String value) {
    return setCell(familyName, wrapByteString(qualifier), timestamp, wrapByteString(value));
  }

  /**
   * Adds a mutation which sets the value of the specified cell.
   *
   * <p>Uses microseconds since epoch as the timestamp.
   */
  public T setCell(
      @Nonnull String familyName, @Nonnull ByteString qualifier, @Nonnull ByteString value) {
    long timestamp = System.currentTimeMillis() * 1_000;

    return setCell(familyName, qualifier, timestamp, value);
  }

  /** Adds a mutation which sets the value of the specified cell. */
  public T setCell(
      @Nonnull String familyName,
      @Nonnull ByteString qualifier,
      long timestamp,
      @Nonnull ByteString value) {
    Validations.validateFamily(familyName);
    Preconditions.checkNotNull(qualifier, "qualifier can't be null.");
    Preconditions.checkNotNull(value, "value can't be null.");
    Preconditions.checkArgument(timestamp != -1, "Serverside timestamps are not supported");

    Mutation mutation =
        Mutation.newBuilder()
            .setSetCell(
                SetCell.newBuilder()
                    .setFamilyName(familyName)
                    .setColumnQualifier(qualifier)
                    .setTimestampMicros(timestamp)
                    .setValue(value)
                    .build())
            .build();

    mutations.add(mutation);
    return thisT();
  }

  /** Adds a mutation which deletes cells from the specified column. */
  public T deleteCells(@Nonnull String familyName, @Nonnull String qualifier) {
    return deleteCells(familyName, wrapByteString(qualifier));
  }

  /** Adds a mutation which deletes cells from the specified column. */
  public T deleteCells(@Nonnull String familyName, @Nonnull ByteString qualifier) {
    Validations.validateFamily(familyName);
    Preconditions.checkNotNull(qualifier, "qualifier can't be null.");

    return deleteCells(familyName, qualifier, TimestampRange.unbounded());
  }

  /**
   * Adds a mutation which deletes cells from the specified column, restricted to a given timestamp
   * range.
   *
   * @param familyName The family name.
   * @param qualifier The qualifier.
   * @param timestampRange The timestamp range in microseconds.
   */
  public T deleteCells(
      @Nonnull String familyName,
      @Nonnull ByteString qualifier,
      @Nonnull TimestampRange timestampRange) {
    Validations.validateFamily(familyName);
    Preconditions.checkNotNull(qualifier, "qualifier can't be null.");
    Preconditions.checkNotNull(timestampRange, "timestampRange can't be null.");

    DeleteFromColumn.Builder builder =
        DeleteFromColumn.newBuilder().setFamilyName(familyName).setColumnQualifier(qualifier);

    switch (timestampRange.getStartBound()) {
      case CLOSED:
        builder.getTimeRangeBuilder().setStartTimestampMicros(timestampRange.getStart());
        break;
      case OPEN:
        builder.getTimeRangeBuilder().setStartTimestampMicros(timestampRange.getStart() + 1);
        break;
      case UNBOUNDED:
        break;
      default:
        throw new IllegalArgumentException(
            "Unknown start bound: " + timestampRange.getStartBound());
    }
    switch (timestampRange.getEndBound()) {
      case CLOSED:
        builder.getTimeRangeBuilder().setEndTimestampMicros(timestampRange.getEnd() + 1);
        break;
      case OPEN:
        builder.getTimeRangeBuilder().setEndTimestampMicros(timestampRange.getEnd());
        break;
      case UNBOUNDED:
        break;
      default:
        throw new IllegalArgumentException("Unknown end bound: " + timestampRange.getEndBound());
    }

    Mutation mutation = Mutation.newBuilder().setDeleteFromColumn(builder.build()).build();
    mutations.add(mutation);

    return thisT();
  }

  /** Adds a mutation which deletes all cells from the specified column family. */
  public T deleteFamily(@Nonnull String familyName) {
    Validations.validateFamily(familyName);

    Mutation mutation =
        Mutation.newBuilder()
            .setDeleteFromFamily(DeleteFromFamily.newBuilder().setFamilyName(familyName).build())
            .build();
    mutations.add(mutation);

    return thisT();
  }

  /** Adds a mutation which deletes all cells from the containing row. */
  public T deleteRow() {
    Mutation mutation =
        Mutation.newBuilder().setDeleteFromRow(DeleteFromRow.getDefaultInstance()).build();
    mutations.add(mutation);

    return thisT();
  }

  @SuppressWarnings("unchecked")
  private T thisT() {
    return (T) this;
  }

  private static ByteString wrapByteString(String str) {
    if (str == null) {
      return null;
    } else {
      return ByteString.copyFromUtf8(str);
    }
  }

  protected List<Mutation> getMutations() {
    return mutations.build();
  }
}
