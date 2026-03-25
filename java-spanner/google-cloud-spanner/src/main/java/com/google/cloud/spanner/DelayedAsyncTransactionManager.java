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
import com.google.cloud.spanner.TransactionManager.TransactionState;
import java.util.concurrent.ExecutionException;

/**
 * Represents a {@link AsyncTransactionManager} using a multiplexed session that is not yet ready.
 * The execution will be delayed until the multiplexed session has been created and is ready. This
 * class is only used during the startup of the client and the multiplexed session has not yet been
 * created.
 */
public class DelayedAsyncTransactionManager implements AsyncTransactionManager {

  private final ApiFuture<AsyncTransactionManager> asyncTransactionManagerApiFuture;

  DelayedAsyncTransactionManager(
      ApiFuture<AsyncTransactionManager> asyncTransactionManagerApiFuture) {
    this.asyncTransactionManagerApiFuture = asyncTransactionManagerApiFuture;
  }

  AsyncTransactionManager getAsyncTransactionManager() {
    try {
      return this.asyncTransactionManagerApiFuture.get();
    } catch (ExecutionException executionException) {
      throw SpannerExceptionFactory.causeAsRunTimeException(executionException);
    } catch (InterruptedException interruptedException) {
      throw SpannerExceptionFactory.propagateInterrupt(interruptedException);
    }
  }

  @Override
  public TransactionContextFuture beginAsync() {
    return getAsyncTransactionManager().beginAsync();
  }

  @Override
  public TransactionContextFuture beginAsync(AbortedException exception) {
    return getAsyncTransactionManager().beginAsync(exception);
  }

  @Override
  public ApiFuture<Void> rollbackAsync() {
    return getAsyncTransactionManager().rollbackAsync();
  }

  @Override
  public TransactionContextFuture resetForRetryAsync() {
    return getAsyncTransactionManager().resetForRetryAsync();
  }

  @Override
  public TransactionState getState() {
    return getAsyncTransactionManager().getState();
  }

  @Override
  public ApiFuture<CommitResponse> getCommitResponse() {
    return getAsyncTransactionManager().getCommitResponse();
  }

  @Override
  public void close() {
    getAsyncTransactionManager().close();
  }

  @Override
  public ApiFuture<Void> closeAsync() {
    return getAsyncTransactionManager().closeAsync();
  }
}
