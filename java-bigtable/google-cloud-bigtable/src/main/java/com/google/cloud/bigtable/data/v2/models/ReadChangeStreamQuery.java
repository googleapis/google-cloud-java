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
import com.google.bigtable.v2.ReadChangeStreamRequest;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.StreamContinuationTokens;
import com.google.bigtable.v2.StreamPartition;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.Range.ByteStringRange;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.threeten.bp.Instant;

/** A simple wrapper to construct a query for the ReadChangeStream RPC. */
@InternalApi("Intended for use by the BigtableIO in apache/beam only.")
public final class ReadChangeStreamQuery implements Serializable, Cloneable {
  private static final long serialVersionUID = 948588515749969176L;

  private final String tableId;
  private transient ReadChangeStreamRequest.Builder builder = ReadChangeStreamRequest.newBuilder();

  /**
   * Constructs a new ReadChangeStreamQuery object for the specified table id. The table id will be
   * combined with the instance name specified in the {@link
   * com.google.cloud.bigtable.data.v2.BigtableDataSettings}.
   */
  public static ReadChangeStreamQuery create(String tableId) {
    return new ReadChangeStreamQuery(tableId);
  }

  private ReadChangeStreamQuery(String tableId) {
    this.tableId = tableId;
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    builder = ReadChangeStreamRequest.newBuilder().mergeFrom(input);
  }

  private void writeObject(ObjectOutputStream output) throws IOException {
    output.defaultWriteObject();
    builder.build().writeTo(output);
  }

  /**
   * Adds a partition.
   *
   * @param rowRange Represents the partition in the form [startKey, endKey). startKey can be null
   *     to represent negative infinity. endKey can be null to represent positive infinity.
   */
  public ReadChangeStreamQuery streamPartition(@Nonnull RowRange rowRange) {
    builder.setPartition(StreamPartition.newBuilder().setRowRange(rowRange).build());
    return this;
  }

  /**
   * Adds a partition.
   *
   * @param start The beginning of the range (inclusive). Can be null to represent negative
   *     infinity.
   * @param end The end of the range (exclusive). Can be null to represent positive infinity.
   */
  public ReadChangeStreamQuery streamPartition(String start, String end) {
    return streamPartition(wrapKey(start), wrapKey(end));
  }

  /**
   * Adds a partition.
   *
   * @param start The beginning of the range (inclusive). Can be null to represent negative
   *     infinity.
   * @param end The end of the range (exclusive). Can be null to represent positive infinity.
   */
  public ReadChangeStreamQuery streamPartition(
      @Nullable ByteString start, @Nullable ByteString end) {
    RowRange.Builder rangeBuilder = RowRange.newBuilder();
    if (start != null) {
      rangeBuilder.setStartKeyClosed(start);
    }
    if (end != null) {
      rangeBuilder.setEndKeyOpen(end);
    }
    return streamPartition(rangeBuilder.build());
  }

  /** Adds a partition. */
  public ReadChangeStreamQuery streamPartition(ByteStringRange range) {
    RowRange.Builder rangeBuilder = RowRange.newBuilder();

    switch (range.getStartBound()) {
      case OPEN:
        throw new IllegalStateException("Start bound should be closed.");
      case CLOSED:
        rangeBuilder.setStartKeyClosed(range.getStart());
        break;
      case UNBOUNDED:
        rangeBuilder.clearStartKey();
        break;
      default:
        throw new IllegalStateException("Unknown start bound: " + range.getStartBound());
    }

    switch (range.getEndBound()) {
      case OPEN:
        rangeBuilder.setEndKeyOpen(range.getEnd());
        break;
      case CLOSED:
        throw new IllegalStateException("End bound should be open.");
      case UNBOUNDED:
        rangeBuilder.clearEndKey();
        break;
      default:
        throw new IllegalStateException("Unknown end bound: " + range.getEndBound());
    }

    return streamPartition(rangeBuilder.build());
  }

  /** Sets the startTime to read the change stream. */
  public ReadChangeStreamQuery startTime(Instant value) {
    Preconditions.checkState(
        !builder.hasContinuationTokens(),
        "startTime and continuationTokens can't be specified together");
    builder.setStartTime(
        Timestamp.newBuilder()
            .setSeconds(value.getEpochSecond())
            .setNanos(value.getNano())
            .build());
    return this;
  }

  /** Sets the endTime to read the change stream. */
  public ReadChangeStreamQuery endTime(Instant value) {
    builder.setEndTime(
        Timestamp.newBuilder()
            .setSeconds(value.getEpochSecond())
            .setNanos(value.getNano())
            .build());
    return this;
  }

  /** Sets the stream continuation tokens to read the change stream. */
  public ReadChangeStreamQuery continuationTokens(
      List<ChangeStreamContinuationToken> changeStreamContinuationTokens) {
    Preconditions.checkState(
        !builder.hasStartTime(), "startTime and continuationTokens can't be specified together");
    StreamContinuationTokens.Builder streamContinuationTokensBuilder =
        StreamContinuationTokens.newBuilder();
    for (ChangeStreamContinuationToken changeStreamContinuationToken :
        changeStreamContinuationTokens) {
      streamContinuationTokensBuilder.addTokens(changeStreamContinuationToken.getTokenProto());
    }
    builder.setContinuationTokens(streamContinuationTokensBuilder);
    return this;
  }

  /** Sets the heartbeat duration for the change stream. */
  public ReadChangeStreamQuery heartbeatDuration(java.time.Duration duration) {
    builder.setHeartbeatDuration(
        Duration.newBuilder()
            .setSeconds(duration.getSeconds())
            .setNanos(duration.getNano())
            .build());
    return this;
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi("Used in Changestream beam pipeline.")
  public ReadChangeStreamRequest toProto(RequestContext requestContext) {
    String tableName =
        NameUtil.formatTableName(
            requestContext.getProjectId(), requestContext.getInstanceId(), tableId);

    return builder
        .setTableName(tableName)
        .setAppProfileId(requestContext.getAppProfileId())
        .build();
  }

  /**
   * Wraps the protobuf {@link ReadChangeStreamRequest}.
   *
   * <p>WARNING: Please note that the project id & instance id in the table name will be overwritten
   * by the configuration in the BigtableDataClient.
   */
  public static ReadChangeStreamQuery fromProto(@Nonnull ReadChangeStreamRequest request) {
    ReadChangeStreamQuery query =
        new ReadChangeStreamQuery(NameUtil.extractTableIdFromTableName(request.getTableName()));
    query.builder = request.toBuilder();

    return query;
  }

  @Override
  protected ReadChangeStreamQuery clone() {
    ReadChangeStreamQuery query = ReadChangeStreamQuery.create(tableId);
    query.builder = this.builder.clone();
    return query;
  }

  @Nullable
  private static ByteString wrapKey(@Nullable String key) {
    if (key == null) {
      return null;
    }
    return ByteString.copyFromUtf8(key);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReadChangeStreamQuery query = (ReadChangeStreamQuery) o;
    return Objects.equal(tableId, query.tableId)
        && Objects.equal(builder.getPartition(), query.builder.getPartition())
        && Objects.equal(builder.getStartTime(), query.builder.getStartTime())
        && Objects.equal(builder.getEndTime(), query.builder.getEndTime())
        && Objects.equal(builder.getContinuationTokens(), query.builder.getContinuationTokens())
        && Objects.equal(builder.getHeartbeatDuration(), query.builder.getHeartbeatDuration());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        tableId,
        builder.getPartition(),
        builder.getStartTime(),
        builder.getEndTime(),
        builder.getContinuationTokens(),
        builder.getHeartbeatDuration());
  }

  @Override
  public String toString() {
    ReadChangeStreamRequest request = builder.build();

    return MoreObjects.toStringHelper(this)
        .add("tableId", tableId)
        .add("partition", request.getPartition())
        .add("startTime", request.getStartTime())
        .add("endTime", request.getEndTime())
        .add("continuationTokens", request.getContinuationTokens())
        .add("heartbeatDuration", request.getHeartbeatDuration())
        .toString();
  }
}
