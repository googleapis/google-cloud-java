/*
 * Copyright 2026 Google LLC
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

import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerException;

import com.google.cloud.Timestamp;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/**
 * A {@link ReadOnlyTransaction} implementation for single-use transactions. This can only be used
 * for a single read or query operation, and provides access to the read timestamp chosen by Cloud
 * Spanner for that operation.
 */
class SingleUseReadOnlyTransaction extends SingleReadContext implements ReadOnlyTransaction {

  @GuardedBy("lock")
  private Timestamp timestamp;

  SingleUseReadOnlyTransaction(SingleReadContext.Builder builder) {
    super(builder);
  }

  @Override
  public Timestamp getReadTimestamp() {
    synchronized (lock) {
      assertTimestampAvailable(timestamp != null);
      return timestamp;
    }
  }

  @Override
  @Nullable
  TransactionSelector getTransactionSelector() {
    TransactionOptions.Builder options = TransactionOptions.newBuilder();
    bound.applyToBuilder(options.getReadOnlyBuilder()).setReturnReadTimestamp(true);
    return TransactionSelector.newBuilder().setSingleUse(options).build();
  }

  @Override
  public void onTransactionMetadata(Transaction transaction, boolean shouldIncludeId) {
    synchronized (lock) {
      if (!transaction.hasReadTimestamp()) {
        throw newSpannerException(
            ErrorCode.INTERNAL, "Missing expected transaction.read_timestamp metadata field");
      }
      try {
        timestamp = Timestamp.fromProto(transaction.getReadTimestamp());
      } catch (IllegalArgumentException e) {
        throw newSpannerException(
            ErrorCode.INTERNAL, "Bad value in transaction.read_timestamp metadata field", e);
      }
    }
  }
}
