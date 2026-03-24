/*
 * Copyright 2020 Google LLC
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

import static com.google.common.base.Preconditions.checkState;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.Timestamp;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

class AsyncRunnerImpl implements AsyncRunner {
  private final TransactionRunnerImpl delegate;
  private SettableApiFuture<CommitResponse> commitResponse;

  AsyncRunnerImpl(TransactionRunnerImpl delegate) {
    this.delegate = Preconditions.checkNotNull(delegate);
  }

  @Override
  public <R> ApiFuture<R> runAsync(final AsyncWork<R> work, Executor executor) {
    Preconditions.checkState(commitResponse == null, "runAsync() can only be called once");
    commitResponse = SettableApiFuture.create();
    final SettableApiFuture<R> res = SettableApiFuture.create();
    executor.execute(
        () -> {
          try {
            res.set(runTransaction(work));
          } catch (Throwable t) {
            res.setException(t);
          } finally {
            setCommitResponse();
          }
        });
    return res;
  }

  private <R> R runTransaction(final AsyncWork<R> work) {
    return delegate.run(
        transaction -> {
          try {
            return work.doWorkAsync(transaction).get();
          } catch (ExecutionException e) {
            throw SpannerExceptionFactory.asSpannerException(e.getCause());
          } catch (InterruptedException e) {
            throw SpannerExceptionFactory.propagateInterrupt(e);
          }
        });
  }

  private void setCommitResponse() {
    try {
      commitResponse.set(delegate.getCommitResponse());
    } catch (Throwable t) {
      commitResponse.setException(t);
    }
  }

  @Override
  public ApiFuture<Timestamp> getCommitTimestamp() {
    checkState(commitResponse != null, "runAsync() has not yet been called");
    return ApiFutures.transform(
        commitResponse, CommitResponse::getCommitTimestamp, MoreExecutors.directExecutor());
  }

  public ApiFuture<CommitResponse> getCommitResponse() {
    checkState(commitResponse != null, "runAsync() has not yet been called");
    return commitResponse;
  }
}
