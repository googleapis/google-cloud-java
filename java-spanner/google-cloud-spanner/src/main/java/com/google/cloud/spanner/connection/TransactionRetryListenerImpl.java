/*
 * Copyright 2024 Google LLC
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

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TransactionMutationLimitExceededException;
import java.util.UUID;

/** Default (no-op) implementation for {@link TransactionRetryListener}. */
public abstract class TransactionRetryListenerImpl implements TransactionRetryListener {

  @Override
  public void retryStarting(Timestamp transactionStarted, long transactionId, int retryAttempt) {}

  @Override
  public void retryFinished(
      Timestamp transactionStarted, long transactionId, int retryAttempt, RetryResult result) {}

  @Override
  public void retryDmlAsPartitionedDmlStarting(
      UUID executionId, Statement statement, TransactionMutationLimitExceededException exception) {}

  @Override
  public void retryDmlAsPartitionedDmlFinished(
      UUID executionId, Statement statement, long lowerBoundUpdateCount) {}

  @Override
  public void retryDmlAsPartitionedDmlFailed(
      UUID executionId, Statement statement, Throwable exception) {}
}
