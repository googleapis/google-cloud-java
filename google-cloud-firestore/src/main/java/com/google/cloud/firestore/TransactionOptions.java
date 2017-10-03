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

package com.google.cloud.firestore;

import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** Options specifying the behavior of Firestore Transactions. */
public final class TransactionOptions {

  private static final int DEFAULT_NUM_ATTEMPTS = 5;

  private final int numberOfAttempts;
  private final Executor executor;
  private final ByteString previousTransactionId;

  TransactionOptions(int maxAttempts, Executor executor, ByteString previousTransactionId) {
    this.numberOfAttempts = maxAttempts;
    this.executor = executor;
    this.previousTransactionId = previousTransactionId;
  }

  public int getNumberOfAttempts() {
    return numberOfAttempts;
  }

  @Nullable
  public Executor getExecutor() {
    return executor;
  }

  @Nullable
  ByteString getPreviousTransactionId() {
    return previousTransactionId;
  }

  /**
   * Create a default set of options suitable for most use cases. Transactions will be attempted 5
   * times.
   *
   * @return The TransactionOptions object.
   */
  @Nonnull
  public static TransactionOptions create() {
    return new TransactionOptions(DEFAULT_NUM_ATTEMPTS, null, null);
  }

  /**
   * Create a default set of options with a custom number of retry attempts.
   *
   * @param numberOfAttempts The number of execution attempts.
   * @return The TransactionOptions object.
   */
  @Nonnull
  public static TransactionOptions create(int numberOfAttempts) {
    Preconditions.checkArgument(numberOfAttempts > 0, "You must allow at least one attempt");
    return new TransactionOptions(numberOfAttempts, null, null);
  }

  /**
   * Create a default set of options with a custom executor.
   *
   * @param executor The executor to run the user callback code on.
   * @return The TransactionOptions object.
   */
  @Nonnull
  public static TransactionOptions create(@Nonnull Executor executor) {
    return new TransactionOptions(DEFAULT_NUM_ATTEMPTS, executor, null);
  }

  /**
   * Create a default set of options with a custom executor and a custom number of retry attempts.
   *
   * @param executor The executor to run the user callback code on.
   * @param numberOfAttempts The number of execution attempts.
   * @return The TransactionOptions object.
   */
  @Nonnull
  public static TransactionOptions create(@Nonnull Executor executor, int numberOfAttempts) {
    Preconditions.checkArgument(numberOfAttempts > 0, "You must allow at least one attempt");
    return new TransactionOptions(numberOfAttempts, executor, null);
  }
}
