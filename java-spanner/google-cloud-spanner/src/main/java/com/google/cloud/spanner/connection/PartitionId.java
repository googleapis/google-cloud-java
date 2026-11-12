/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.spanner.connection;

import com.google.api.core.InternalApi;
import com.google.cloud.spanner.BatchTransactionId;
import com.google.cloud.spanner.Partition;
import com.google.cloud.spanner.PartitionCodec;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.Objects;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Contains a reference to a {@link BatchTransactionId} and a {@link Partition}. The combination of
 * these two are needed to execute a partition of a partitioned query on a {@link Connection}. A
 * {@link PartitionId} can safely be given to a different connection and/or host to be executed
 * there.
 */
@InternalApi
@NullMarked
public final class PartitionId implements Serializable {
  private static final long serialVersionUID = 239487275L;

  @VisibleForTesting
  static void setLimitsForTesting(
      int testMaxEncodedLength, long testMaxDecompressed, int testMaxPayload) {
    PartitionCodec.setLimitsForTesting(testMaxEncodedLength, testMaxDecompressed, testMaxPayload);
  }

  @VisibleForTesting
  static void resetLimitsForTesting() {
    PartitionCodec.resetLimitsForTesting();
  }

  private final BatchTransactionId transactionId;
  private final Partition partition;

  /**
   * Deserializes a string representation of a {@link PartitionId}. The string must have been
   * created with the {@link #encodeToString(BatchTransactionId, Partition)} method.
   */
  public static PartitionId decodeFromString(@Nullable String id) {
    PartitionCodec.DecodedPartition decoded = PartitionCodec.decodeFromString(id);
    return new PartitionId(decoded.getTransactionId(), decoded.getPartition());
  }

  /**
   * @return A string-encoded version of this {@link PartitionId}. This encoded version can be sent
   *     to any other {@link Connection} to be executed there, including connections on different
   *     hosts than the current host.
   */
  public static String encodeToString(BatchTransactionId transactionId, Partition partition) {
    return PartitionCodec.encodeToString(transactionId, partition);
  }

  private PartitionId(BatchTransactionId transactionId, Partition partition) {
    this.transactionId = Objects.requireNonNull(transactionId);
    this.partition = Objects.requireNonNull(partition);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PartitionId)) {
      return false;
    }
    PartitionId other = (PartitionId) o;
    return Objects.equals(this.transactionId, other.transactionId)
        && Objects.equals(this.partition, other.partition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.transactionId, this.partition);
  }

  public BatchTransactionId getTransactionId() {
    return transactionId;
  }

  public Partition getPartition() {
    return partition;
  }
}
