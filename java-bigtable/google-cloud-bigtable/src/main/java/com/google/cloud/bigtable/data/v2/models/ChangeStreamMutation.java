/*
 * Copyright 2022 Google LLC
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
import com.google.auto.value.AutoValue;
import com.google.cloud.bigtable.data.v2.models.Range.TimestampRange;
import com.google.cloud.bigtable.data.v2.stub.changestream.ChangeStreamRecordMerger;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.io.Serializable;
import javax.annotation.Nonnull;
import org.threeten.bp.Instant;

/**
 * A ChangeStreamMutation represents a list of mods(represented by List<{@link Entry}>) targeted at
 * a single row, which is concatenated by {@link ChangeStreamRecordMerger}. It represents a logical
 * row mutation and can be converted to the original write request(i.e. {@link RowMutation} or
 * {@link RowMutationEntry}.
 *
 * <p>A ChangeStreamMutation can be constructed in two ways, depending on whether it's a user
 * initiated mutation or a Garbage Collection mutation. Either way, the caller should explicitly set
 * `token` and `estimatedLowWatermark` before build(), otherwise it'll raise an error.
 *
 * <p>Case 1) User initiated mutation.
 *
 * <pre>{@code
 * ChangeStreamMutation.Builder builder = ChangeStreamMutation.createUserMutation(...);
 * builder.setCell(...);
 * builder.deleteFamily(...);
 * builder.deleteCells(...);
 * ChangeStreamMutation changeStreamMutation = builder.setToken(...).setEstimatedLowWatermark().build();
 * }</pre>
 *
 * Case 2) Garbage Collection mutation.
 *
 * <pre>{@code
 * ChangeStreamMutation.Builder builder = ChangeStreamMutation.createGcMutation(...);
 * builder.setCell(...);
 * builder.deleteFamily(...);
 * builder.deleteCells(...);
 * ChangeStreamMutation changeStreamMutation = builder.setToken(...).setEstimatedLowWatermark().build();
 * }</pre>
 */
@InternalApi("Intended for use by the BigtableIO in apache/beam only.")
@AutoValue
public abstract class ChangeStreamMutation implements ChangeStreamRecord, Serializable {
  private static final long serialVersionUID = 8419520253162024218L;

  public enum MutationType {
    USER,
    GARBAGE_COLLECTION
  }

  /**
   * Creates a new instance of a user initiated mutation. It returns a builder instead of a
   * ChangeStreamMutation because `token` and `loWatermark` must be set later when we finish
   * building the logical mutation.
   */
  static Builder createUserMutation(
      @Nonnull ByteString rowKey,
      @Nonnull String sourceClusterId,
      Instant commitTimestamp,
      int tieBreaker) {
    return builder()
        .setRowKey(rowKey)
        .setType(MutationType.USER)
        .setSourceClusterId(sourceClusterId)
        .setCommitTimestamp(commitTimestamp)
        .setTieBreaker(tieBreaker);
  }

  /**
   * Creates a new instance of a GC mutation. It returns a builder instead of a ChangeStreamMutation
   * because `token` and `loWatermark` must be set later when we finish building the logical
   * mutation.
   */
  static Builder createGcMutation(
      @Nonnull ByteString rowKey, Instant commitTimestamp, int tieBreaker) {
    return builder()
        .setRowKey(rowKey)
        .setType(MutationType.GARBAGE_COLLECTION)
        .setSourceClusterId("")
        .setCommitTimestamp(commitTimestamp)
        .setTieBreaker(tieBreaker);
  }

  /** Get the row key of the current mutation. */
  @Nonnull
  public abstract ByteString getRowKey();

  /** Get the type of the current mutation. */
  @Nonnull
  public abstract MutationType getType();

  /** Get the source cluster id of the current mutation. */
  @Nonnull
  public abstract String getSourceClusterId();

  /** Get the commit timestamp of the current mutation. */
  public abstract Instant getCommitTimestamp();

  /**
   * Get the tie breaker of the current mutation. This is used to resolve conflicts when multiple
   * mutations are applied to different clusters at the same time.
   */
  public abstract int getTieBreaker();

  /** Get the token of the current mutation, which can be used to resume the changestream. */
  @Nonnull
  public abstract String getToken();

  /** Get the low watermark of the current mutation. */
  public abstract Instant getEstimatedLowWatermark();

  /** Get the list of mods of the current mutation. */
  @Nonnull
  public abstract ImmutableList<Entry> getEntries();

  /** Returns a new builder for this class. */
  static Builder builder() {
    return new AutoValue_ChangeStreamMutation.Builder();
  }

  /** Helper class to create a ChangeStreamMutation. */
  @InternalApi("Intended for use by the BigtableIO in apache/beam only.")
  @AutoValue.Builder
  abstract static class Builder {
    abstract Builder setRowKey(@Nonnull ByteString rowKey);

    abstract Builder setType(@Nonnull MutationType type);

    abstract Builder setSourceClusterId(@Nonnull String sourceClusterId);

    abstract Builder setCommitTimestamp(Instant commitTimestamp);

    abstract Builder setTieBreaker(int tieBreaker);

    abstract ImmutableList.Builder<Entry> entriesBuilder();

    abstract Builder setToken(@Nonnull String token);

    abstract Builder setEstimatedLowWatermark(Instant estimatedLowWatermark);

    Builder setCell(
        @Nonnull String familyName,
        @Nonnull ByteString qualifier,
        long timestamp,
        @Nonnull ByteString value) {
      this.entriesBuilder().add(SetCell.create(familyName, qualifier, timestamp, value));
      return this;
    }

    Builder deleteCells(
        @Nonnull String familyName,
        @Nonnull ByteString qualifier,
        @Nonnull TimestampRange timestampRange) {
      this.entriesBuilder().add(DeleteCells.create(familyName, qualifier, timestampRange));
      return this;
    }

    Builder deleteFamily(@Nonnull String familyName) {
      this.entriesBuilder().add(DeleteFamily.create(familyName));
      return this;
    }

    abstract ChangeStreamMutation build();
  }

  public RowMutation toRowMutation(@Nonnull String tableId) {
    RowMutation rowMutation = RowMutation.create(tableId, getRowKey());
    for (Entry entry : getEntries()) {
      if (entry instanceof DeleteFamily) {
        rowMutation.deleteFamily(((DeleteFamily) entry).getFamilyName());
      } else if (entry instanceof DeleteCells) {
        DeleteCells deleteCells = (DeleteCells) entry;
        rowMutation.deleteCells(
            deleteCells.getFamilyName(),
            deleteCells.getQualifier(),
            deleteCells.getTimestampRange());
      } else if (entry instanceof SetCell) {
        SetCell setCell = (SetCell) entry;
        rowMutation.setCell(
            setCell.getFamilyName(),
            setCell.getQualifier(),
            setCell.getTimestamp(),
            setCell.getValue());
      } else {
        throw new IllegalArgumentException("Unexpected Entry type.");
      }
    }
    return rowMutation;
  }

  public RowMutationEntry toRowMutationEntry() {
    RowMutationEntry rowMutationEntry = RowMutationEntry.create(getRowKey());
    for (Entry entry : getEntries()) {
      if (entry instanceof DeleteFamily) {
        rowMutationEntry.deleteFamily(((DeleteFamily) entry).getFamilyName());
      } else if (entry instanceof DeleteCells) {
        DeleteCells deleteCells = (DeleteCells) entry;
        rowMutationEntry.deleteCells(
            deleteCells.getFamilyName(),
            deleteCells.getQualifier(),
            deleteCells.getTimestampRange());
      } else if (entry instanceof SetCell) {
        SetCell setCell = (SetCell) entry;
        rowMutationEntry.setCell(
            setCell.getFamilyName(),
            setCell.getQualifier(),
            setCell.getTimestamp(),
            setCell.getValue());
      } else {
        throw new IllegalArgumentException("Unexpected Entry type.");
      }
    }
    return rowMutationEntry;
  }
}
