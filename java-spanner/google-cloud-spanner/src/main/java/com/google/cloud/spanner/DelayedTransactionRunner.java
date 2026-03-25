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

package com.google.cloud.spanner;

import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

/**
 * Represents a {@link TransactionRunner} using a multiplexed session that is not yet ready. The
 * execution will be delayed until the multiplexed session has been created and is ready. This class
 * is only used during the startup of the client and the multiplexed session has not yet been
 * created.
 */
class DelayedTransactionRunner implements TransactionRunner {
  private final ApiFuture<TransactionRunner> transactionRunnerFuture;

  DelayedTransactionRunner(ApiFuture<TransactionRunner> transactionRunnerFuture) {
    this.transactionRunnerFuture = transactionRunnerFuture;
  }

  TransactionRunner getTransactionRunner() {
    try {
      return this.transactionRunnerFuture.get();
    } catch (ExecutionException executionException) {
      throw SpannerExceptionFactory.causeAsRunTimeException(executionException);
    } catch (InterruptedException interruptedException) {
      throw SpannerExceptionFactory.propagateInterrupt(interruptedException);
    }
  }

  @Nullable
  @Override
  public <T> T run(TransactionCallable<T> callable) {
    return getTransactionRunner().run(callable);
  }

  @Override
  public Timestamp getCommitTimestamp() {
    return getTransactionRunner().getCommitTimestamp();
  }

  @Override
  public CommitResponse getCommitResponse() {
    return getTransactionRunner().getCommitResponse();
  }

  @Override
  public TransactionRunner allowNestedTransaction() {
    return getTransactionRunner().allowNestedTransaction();
  }
}
