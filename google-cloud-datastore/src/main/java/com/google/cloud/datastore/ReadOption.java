/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.datastore;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.cloud.Timestamp;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Specifies options for read operations in Datastore, namely getting/fetching entities and running
 * queries.
 */
public abstract class ReadOption implements Serializable {

  private static final long serialVersionUID = -4406964829189800528L;

  /**
   * Specifies eventual consistency for reads from Datastore. Lookups and ancestor queries using
   * this option permit Datastore to return stale results.
   */
  public static final class EventualConsistency extends ReadOption {

    private static final long serialVersionUID = -6959530217724666172L;

    private final boolean eventualConsistency;

    private EventualConsistency(boolean eventualConsistency) {
      this.eventualConsistency = eventualConsistency;
    }

    public boolean isEventual() {
      return eventualConsistency;
    }
  }

  /**
   * Reads entities as they were at the given time. This may not be older than 270 seconds. This
   * value is only supported for Cloud Firestore in Datastore mode.
   */
  public static final class ReadTime extends ReadOption {

    private static final long serialVersionUID = -6780321449114616067L;

    private final Timestamp time;

    private ReadTime(Timestamp time) {
      this.time = time;
    }

    public Timestamp time() {
      return time;
    }
  }

  /** Specifies transaction to be used when running a {@link Query}. */
  @InternalApi
  static class TransactionId extends ReadOption {

    private final ByteString transactionId;

    TransactionId(ByteString transactionId) {
      this.transactionId = transactionId;
    }

    public ByteString getTransactionId() {
      return transactionId;
    }
  }

  private ReadOption() {}

  /**
   * Returns a {@code ReadOption} that specifies eventual consistency, allowing Datastore to return
   * stale results from gets, fetches, and ancestor queries.
   */
  public static EventualConsistency eventualConsistency() {
    return new EventualConsistency(true);
  }

  /**
   * Returns a {@code ReadOption} that specifies read time, allowing Datastore to return results
   * from lookups and queries at a particular timestamp. This feature is currently in private
   * preview.
   */
  @BetaApi
  public static ReadTime readTime(Timestamp time) {
    return new ReadTime(time);
  }

  /**
   * Returns a {@code ReadOption} that specifies transaction id, allowing Datastore to execute a
   * {@link Query} in this transaction.
   */
  @InternalApi
  public static ReadOption transactionId(String transactionId) {
    return new TransactionId(ByteString.copyFrom(transactionId.getBytes()));
  }

  /**
   * Returns a {@code ReadOption} that specifies transaction id, allowing Datastore to execute a
   * {@link Query} in this transaction.
   */
  @InternalApi
  public static ReadOption transactionId(ByteString transactionId) {
    return new TransactionId(transactionId);
  }

  static Map<Class<? extends ReadOption>, ReadOption> asImmutableMap(ReadOption... options) {
    ImmutableMap.Builder<Class<? extends ReadOption>, ReadOption> builder = ImmutableMap.builder();
    for (ReadOption option : options) {
      builder.put(option.getClass(), option);
    }
    return builder.buildOrThrow();
  }

  static Map<Class<? extends ReadOption>, ReadOption> asImmutableMap(List<ReadOption> options) {
    ImmutableMap.Builder<Class<? extends ReadOption>, ReadOption> builder = ImmutableMap.builder();
    for (ReadOption option : options) {
      builder.put(option.getClass(), option);
    }
    return builder.buildOrThrow();
  }
}
