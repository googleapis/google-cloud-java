/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

/**
 * A transaction type that provides guaranteed consistency across several reads, but does not allow
 * writes. Snapshot read-only transactions can be configured to read at timestamps in the past.
 * Snapshot read-only transactions do not need to be committed.
 *
 * <p>Snapshot read-only transactions provide a simpler method than locking read-write transactions
 * for doing several consistent reads. However, this type of transaction does not support writes.
 *
 * <p>Snapshot read-only transactions do not take locks. Instead, they work by choosing a Cloud
 * Spanner timestamp, then executing all reads at that timestamp. Since they do not acquire locks,
 * they do not block concurrent read-write transactions.
 *
 * <p>Unlike locking read-write transactions, snapshot read-only transactions never abort. They can
 * fail if the chosen read timestamp is garbage collected; however, the default garbage collection
 * policy is generous enough that most applications do not need to worry about this in practice. See
 * the class documentation of {@link TimestampBound} for more details.
 *
 * <p>To execute a snapshot transaction, specify a {@link TimestampBound}, which tells Cloud Spanner
 * how to choose a read timestamp.
 *
 * @see Session#singleUseReadOnlyTransaction(TimestampBound)
 * @see Session#readOnlyTransaction(TimestampBound)
 */
public interface ReadOnlyTransaction extends ReadContext {
  /**
   * Returns the timestamp chosen to perform reads and queries in this transaction. The value can
   * only be read after some read or query has either returned some data or completed without
   * returning any data.
   */
  Timestamp getReadTimestamp();
}
