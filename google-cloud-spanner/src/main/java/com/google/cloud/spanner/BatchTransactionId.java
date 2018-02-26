/*
 * Copyright 2017 Google LLC
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
import com.google.protobuf.ByteString;
import java.io.Serializable;
import java.util.Objects;

/**
 * {@code BatchTransactionId} is unique identifier for {@link BatchReadOnlyTransaction}. It can be
 * used to re-initialize a BatchReadOnlyTransaction on different machine or process by calling
 * {@link BatchClient#batchReadOnlyTransaction(BatchTransactionId)}.
 */
public class BatchTransactionId implements Serializable {

  private final ByteString transactionId;
  private final String sessionId;
  private final Timestamp timestamp;
  private static final long serialVersionUID = 8067099123096783939L;

  BatchTransactionId(String sessionId, ByteString transactionId, Timestamp timestamp) {
    this.transactionId = Preconditions.checkNotNull(transactionId);
    this.sessionId = Preconditions.checkNotNull(sessionId);
    this.timestamp = Preconditions.checkNotNull(timestamp);
  }

  ByteString getTransactionId() {
    return transactionId;
  }

  String getSessionId() {
    return sessionId;
  }

  Timestamp getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return String.format(
        "transactionId: %s, sessionId: %s, timestamp: %s",
        transactionId.toStringUtf8(), sessionId, timestamp);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    BatchTransactionId that = (BatchTransactionId) o;
    return Objects.equals(getTransactionId(), that.getTransactionId())
        && Objects.equals(getTimestamp(), that.getTimestamp())
        && Objects.equals(getSessionId(), that.getSessionId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTransactionId(), getTimestamp(), getSessionId());
  }
}
