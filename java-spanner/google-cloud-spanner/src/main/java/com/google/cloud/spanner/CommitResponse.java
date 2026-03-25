/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import com.google.cloud.Timestamp;
import com.google.common.base.Preconditions;
import java.util.Objects;
import javax.annotation.Nullable;

/** Represents a response from a commit operation. */
public class CommitResponse {

  private final com.google.spanner.v1.CommitResponse proto;

  public CommitResponse(Timestamp commitTimestamp) {
    this.proto =
        com.google.spanner.v1.CommitResponse.newBuilder()
            .setCommitTimestamp(commitTimestamp.toProto())
            .build();
  }

  CommitResponse(com.google.spanner.v1.CommitResponse proto) {
    this.proto = Preconditions.checkNotNull(proto);
  }

  /** Returns a {@link Timestamp} representing the commit time of the transaction. */
  public Timestamp getCommitTimestamp() {
    return Timestamp.fromProto(proto.getCommitTimestamp());
  }

  /**
   * Returns a {@link Timestamp} representing the timestamp at which all reads in the transaction
   * ran at, if the transaction ran at repeatable read isolation in internal test environments, and
   * otherwise returns null.
   */
  public @Nullable Timestamp getSnapshotTimestamp() {
    if (proto.getSnapshotTimestamp() == com.google.protobuf.Timestamp.getDefaultInstance()) {
      return null;
    }
    return Timestamp.fromProto(proto.getSnapshotTimestamp());
  }

  /**
   * @return true if the {@link CommitResponse} includes {@link CommitStats}
   */
  public boolean hasCommitStats() {
    return proto.hasCommitStats();
  }

  /**
   * Commit statistics are returned by a read/write transaction if specifically requested by passing
   * in {@link Options#commitStats()} to the transaction.
   */
  public CommitStats getCommitStats() {
    Preconditions.checkState(
        proto.hasCommitStats(), "The CommitResponse does not contain any commit statistics.");
    return CommitStats.fromProto(proto.getCommitStats());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommitResponse that = (CommitResponse) o;
    return Objects.equals(proto, that.proto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(proto);
  }
}
