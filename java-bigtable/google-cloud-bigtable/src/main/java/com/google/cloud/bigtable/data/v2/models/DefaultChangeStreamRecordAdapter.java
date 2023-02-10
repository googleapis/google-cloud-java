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
import com.google.bigtable.v2.ReadChangeStreamResponse;
import com.google.cloud.bigtable.data.v2.models.Range.TimestampRange;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Default implementation of a {@link ChangeStreamRecordAdapter} that uses {@link
 * ChangeStreamRecord}s to represent change stream records.
 */
@InternalApi
public class DefaultChangeStreamRecordAdapter
    implements ChangeStreamRecordAdapter<ChangeStreamRecord> {

  /** {@inheritDoc} */
  @Override
  public ChangeStreamRecordBuilder<ChangeStreamRecord> createChangeStreamRecordBuilder() {
    return new DefaultChangeStreamRecordBuilder();
  }

  /** {@inheritDoc} */
  @Override
  public boolean isHeartbeat(ChangeStreamRecord record) {
    return record instanceof Heartbeat;
  }

  /** {@inheritDoc} */
  @Override
  public String getTokenFromHeartbeat(ChangeStreamRecord record) {
    Preconditions.checkArgument(isHeartbeat(record), "record is not a Heartbeat.");
    return ((Heartbeat) record).getChangeStreamContinuationToken().getToken();
  }

  /** {@inheritDoc} */
  @Override
  public boolean isChangeStreamMutation(ChangeStreamRecord record) {
    return record instanceof ChangeStreamMutation;
  }

  /** {@inheritDoc} */
  @Override
  public String getTokenFromChangeStreamMutation(ChangeStreamRecord record) {
    Preconditions.checkArgument(
        isChangeStreamMutation(record), "record is not a ChangeStreamMutation.");
    return ((ChangeStreamMutation) record).getToken();
  }

  /** {@inheritDoc} */
  static class DefaultChangeStreamRecordBuilder
      implements ChangeStreamRecordBuilder<ChangeStreamRecord> {
    private ChangeStreamMutation.Builder changeStreamMutationBuilder = null;

    // For the current SetCell.
    @Nullable private String family;
    @Nullable private ByteString qualifier;
    private long timestampMicros;
    @Nullable private ByteString value;

    public DefaultChangeStreamRecordBuilder() {
      reset();
    }

    /** {@inheritDoc} */
    @Override
    public ChangeStreamRecord onHeartbeat(ReadChangeStreamResponse.Heartbeat heartbeat) {
      Preconditions.checkState(
          this.changeStreamMutationBuilder == null,
          "Can not create a Heartbeat when there is an existing ChangeStreamMutation being built.");
      return Heartbeat.fromProto(heartbeat);
    }

    /** {@inheritDoc} */
    @Override
    public ChangeStreamRecord onCloseStream(ReadChangeStreamResponse.CloseStream closeStream) {
      Preconditions.checkState(
          this.changeStreamMutationBuilder == null,
          "Can not create a CloseStream when there is an existing ChangeStreamMutation being built.");
      return CloseStream.fromProto(closeStream);
    }

    /** {@inheritDoc} */
    @Override
    public void startUserMutation(
        @Nonnull ByteString rowKey,
        @Nonnull String sourceClusterId,
        long commitTimestamp,
        int tieBreaker) {
      this.changeStreamMutationBuilder =
          ChangeStreamMutation.createUserMutation(
              rowKey, sourceClusterId, commitTimestamp, tieBreaker);
    }

    /** {@inheritDoc} */
    @Override
    public void startGcMutation(@Nonnull ByteString rowKey, long commitTimestamp, int tieBreaker) {
      this.changeStreamMutationBuilder =
          ChangeStreamMutation.createGcMutation(rowKey, commitTimestamp, tieBreaker);
    }

    /** {@inheritDoc} */
    @Override
    public void deleteFamily(@Nonnull String familyName) {
      this.changeStreamMutationBuilder.deleteFamily(familyName);
    }

    /** {@inheritDoc} */
    @Override
    public void deleteCells(
        @Nonnull String familyName,
        @Nonnull ByteString qualifier,
        @Nonnull TimestampRange timestampRange) {
      this.changeStreamMutationBuilder.deleteCells(familyName, qualifier, timestampRange);
    }

    /** {@inheritDoc} */
    @Override
    public void startCell(String family, ByteString qualifier, long timestampMicros) {
      this.family = family;
      this.qualifier = qualifier;
      this.timestampMicros = timestampMicros;
      this.value = ByteString.EMPTY;
    }

    /** {@inheritDoc} */
    @Override
    public void cellValue(ByteString value) {
      this.value = this.value.concat(value);
    }

    /** {@inheritDoc} */
    @Override
    public void finishCell() {
      this.changeStreamMutationBuilder.setCell(
          this.family, this.qualifier, this.timestampMicros, this.value);
    }

    /** {@inheritDoc} */
    @Override
    public ChangeStreamRecord finishChangeStreamMutation(
        @Nonnull String token, long estimatedLowWatermark) {
      this.changeStreamMutationBuilder.setToken(token);
      this.changeStreamMutationBuilder.setEstimatedLowWatermark(estimatedLowWatermark);
      return this.changeStreamMutationBuilder.build();
    }

    /** {@inheritDoc} */
    @Override
    public void reset() {
      changeStreamMutationBuilder = null;

      family = null;
      qualifier = null;
      timestampMicros = 0;
      value = null;
    }
  }
}
