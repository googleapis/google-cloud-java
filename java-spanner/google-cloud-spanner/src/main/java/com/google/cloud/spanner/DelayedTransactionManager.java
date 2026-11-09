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

/**
 * Represents a {@link TransactionManager} using a multiplexed session that is not yet ready. The
 * execution will be delayed until the multiplexed session has been created and is ready. This class
 * is only used during the startup of the client and the multiplexed session has not yet been
 * created.
 */
class DelayedTransactionManager implements TransactionManager {

  private final ApiFuture<TransactionManager> transactionManagerFuture;

  DelayedTransactionManager(ApiFuture<TransactionManager> transactionManagerFuture) {
    this.transactionManagerFuture = transactionManagerFuture;
  }

  TransactionManager getTransactionManager() {
    try {
      return this.transactionManagerFuture.get();
    } catch (ExecutionException executionException) {
      throw SpannerExceptionFactory.causeAsRunTimeException(executionException);
    } catch (InterruptedException interruptedException) {
      throw SpannerExceptionFactory.propagateInterrupt(interruptedException);
    }
  }

  @Override
  public TransactionContext begin() {
    return getTransactionManager().begin();
  }

  @Override
  public TransactionContext begin(AbortedException exception) {
    return getTransactionManager().begin(exception);
  }

  @Override
  public void commit() {
    getTransactionManager().commit();
  }

  @Override
  public void rollback() {
    getTransactionManager().rollback();
  }

  @Override
  public TransactionContext resetForRetry() {
    return getTransactionManager().resetForRetry();
  }

  @Override
  public Timestamp getCommitTimestamp() {
    return getTransactionManager().getCommitTimestamp();
  }

  @Override
  public CommitResponse getCommitResponse() {
    return getTransactionManager().getCommitResponse();
  }

  @Override
  public TransactionState getState() {
    return getTransactionManager().getState();
  }

  @Override
  public void close() {
    getTransactionManager().close();
  }
}
