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
import com.google.bigtable.v2.Mutation.DeleteFromColumn;
import com.google.bigtable.v2.Mutation.DeleteFromFamily;
import com.google.bigtable.v2.Mutation.DeleteFromRow;
import com.google.bigtable.v2.Mutation.SetCell;
import com.google.cloud.bigtable.data.v2.models.Range.TimestampRange;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Longs;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * The concrete implementation of {@link MutationApi} that can be used to create and represent a
 * list of mutations. It used by {@link RowMutation} and {@link ConditionalRowMutation} to
 * encapsulate a list of mutations that will to be applied to a single row.
 */
public final class Mutation implements MutationApi<Mutation>, Serializable {
  private static final long serialVersionUID = 5893216644683374340L;

  @InternalApi("Visible for testing")
  static final int MAX_MUTATIONS = 100_000;

  @InternalApi("Visible for testing")
  static final int MAX_BYTE_SIZE = 200 * 1024 * 1024;

  @InternalApi("Visible for testing")
  static final long SERVER_SIDE_TIMESTAMP = -1;

  private final boolean allowServersideTimestamp;

  private transient ImmutableList.Builder<com.google.bigtable.v2.Mutation> mutations =
      ImmutableList.builder();

  private int numMutations;
  private long byteSize;

  /** Creates new instance of Mutation object. */
  public static Mutation create() {
    return new Mutation(false);
  }

  /**
   * Creates new instance of Mutation object which allows setCell operation to use server side
   * timestamp. This is dangerous because mutations will no longer be idempotent, which might cause
   * multiple duplicate values to be stored in Bigtable. This option should only be used for
   * advanced usecases with extreme care.
   */
  @BetaApi
  public static Mutation createUnsafe() {
    return new Mutation(true);
  }

  /**
   * Wraps the List of protobuf {@link com.google.bigtable.v2.Mutation}. This methods, like {@link
   * #createUnsafe()}, allows setCell operation to use server side timestamp. This is dangerous
   * because mutations will no longer be idempotent, which might cause multiple duplicate values to
   * be stored in Bigtable. This option should only be used for advanced usecases with extreme care.
   */
  @BetaApi
  public static Mutation fromProtoUnsafe(List<com.google.bigtable.v2.Mutation> protos) {
    Mutation mutation = new Mutation(true);
    mutation.mutations.addAll(protos);
    return mutation;
  }

  /**
   * Wraps the List of protobuf {@link com.google.bigtable.v2.Mutation}. This methods, like {@link
   * #createUnsafe()}, allows setCell operation to use server side timestamp. This is dangerous
   * because mutations will no longer be idempotent, which might cause multiple duplicate values to
   * be stored in Bigtable. This option should only be used for advanced usecases with extreme care.
   */
  @BetaApi
  public static Mutation fromProtoUnsafe(Iterable<com.google.bigtable.v2.Mutation> protos) {
    Mutation mutation = new Mutation(true);
    mutation.mutations.addAll(protos);
    return mutation;
  }

  /**
   * Constructs a row mutation from an existing protobuf object.
   *
   * <p>Callers must ensure that the protobuf argument is not using serverside timestamps. The
   * client assumes that all mutations are idempotent and will retry in case of transient errors.
   * This can lead to row duplication.
   *
   * <p>When applied, the resulting Mutation object will ignore the project id and instance id in
   * the table_name and instead apply the configuration in the client
   */
  static Mutation fromProto(List<com.google.bigtable.v2.Mutation> protos) {
    Mutation mutation = new Mutation(false);
    mutation.mutations.addAll(protos);
    return mutation;
  }

  private Mutation(boolean allowServersideTimestamp) {
    this.allowServersideTimestamp = allowServersideTimestamp;
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();

    @SuppressWarnings("unchecked")
    ImmutableList<com.google.bigtable.v2.Mutation> deserialized =
        (ImmutableList<com.google.bigtable.v2.Mutation>) input.readObject();
    this.mutations = ImmutableList.<com.google.bigtable.v2.Mutation>builder().addAll(deserialized);
  }

  private void writeObject(ObjectOutputStream output) throws IOException {
    output.defaultWriteObject();
    output.writeObject(mutations.build());
  }

  @Override
  public Mutation setCell(
      @Nonnull String familyName, @Nonnull String qualifier, @Nonnull String value) {
    return setCell(familyName, wrapByteString(qualifier), wrapByteString(value));
  }

  @Override
  public Mutation setCell(
      @Nonnull String familyName,
      @Nonnull String qualifier,
      long timestamp,
      @Nonnull String value) {
    return setCell(familyName, wrapByteString(qualifier), timestamp, wrapByteString(value));
  }

  @Override
  public Mutation setCell(
      @Nonnull String familyName, @Nonnull ByteString qualifier, @Nonnull ByteString value) {
    long timestamp = System.currentTimeMillis() * 1_000;

    return setCell(familyName, qualifier, timestamp, value);
  }

  @Override
  public Mutation setCell(
      @Nonnull String familyName,
      @Nonnull ByteString qualifier,
      long timestamp,
      @Nonnull ByteString value) {
    Validations.validateFamily(familyName);
    Preconditions.checkNotNull(qualifier, "qualifier can't be null.");
    Preconditions.checkNotNull(value, "value can't be null.");
    if (!allowServersideTimestamp) {
      Preconditions.checkArgument(
          timestamp != SERVER_SIDE_TIMESTAMP, "Serverside timestamps are not supported");
    }

    addMutation(
        com.google.bigtable.v2.Mutation.newBuilder()
            .setSetCell(
                SetCell.newBuilder()
                    .setFamilyName(familyName)
                    .setColumnQualifier(qualifier)
                    .setTimestampMicros(timestamp)
                    .setValue(value)
                    .build())
            .build());

    return this;
  }

  @Override
  public Mutation setCell(@Nonnull String familyName, @Nonnull String qualifier, long value) {
    return setCell(familyName, wrapByteString(qualifier), value);
  }

  @Override
  public Mutation setCell(
      @Nonnull String familyName, @Nonnull String qualifier, long timestamp, long value) {

    return setCell(familyName, wrapByteString(qualifier), timestamp, value);
  }

  @Override
  public Mutation setCell(@Nonnull String familyName, @Nonnull ByteString qualifier, long value) {

    return setCell(familyName, qualifier, ByteString.copyFrom(Longs.toByteArray(value)));
  }

  @Override
  public Mutation setCell(
      @Nonnull String familyName, @Nonnull ByteString qualifier, long timestamp, long value) {

    return setCell(familyName, qualifier, timestamp, ByteString.copyFrom(Longs.toByteArray(value)));
  }

  @Override
  public Mutation deleteCells(@Nonnull String familyName, @Nonnull String qualifier) {
    return deleteCells(familyName, wrapByteString(qualifier));
  }

  @Override
  public Mutation deleteCells(@Nonnull String familyName, @Nonnull ByteString qualifier) {
    Validations.validateFamily(familyName);
    Preconditions.checkNotNull(qualifier, "qualifier can't be null.");

    return deleteCells(familyName, qualifier, TimestampRange.unbounded());
  }

  @Override
  public Mutation deleteCells(
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

    addMutation(
        com.google.bigtable.v2.Mutation.newBuilder().setDeleteFromColumn(builder.build()).build());

    return this;
  }

  @Override
  public Mutation deleteFamily(@Nonnull String familyName) {
    Validations.validateFamily(familyName);

    addMutation(
        com.google.bigtable.v2.Mutation.newBuilder()
            .setDeleteFromFamily(DeleteFromFamily.newBuilder().setFamilyName(familyName).build())
            .build());

    return this;
  }

  @Override
  public Mutation deleteRow() {
    addMutation(
        com.google.bigtable.v2.Mutation.newBuilder()
            .setDeleteFromRow(DeleteFromRow.getDefaultInstance())
            .build());

    return this;
  }

  private void addMutation(com.google.bigtable.v2.Mutation mutation) {
    Preconditions.checkState(numMutations + 1 <= MAX_MUTATIONS, "Too many mutations per row");
    Preconditions.checkState(
        byteSize + mutation.getSerializedSize() <= MAX_BYTE_SIZE,
        "Byte size of mutations is too large");

    numMutations++;
    byteSize += mutation.getSerializedSize();

    mutations.add(mutation);
  }

  private static ByteString wrapByteString(String str) {
    if (str == null) {
      return null;
    } else {
      return ByteString.copyFromUtf8(str);
    }
  }

  /** Returns the mutation protos. */
  List<com.google.bigtable.v2.Mutation> getMutations() {
    return mutations.build();
  }
}
