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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AsyncTransactionManager.AsyncTransactionFunction;
import com.google.cloud.spanner.AsyncTransactionManager.AsyncTransactionStep;
import com.google.cloud.spanner.AsyncTransactionManager.CommitTimestampFuture;
import com.google.cloud.spanner.AsyncTransactionManager.TransactionContextFuture;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class TransactionContextFutureImpl extends ForwardingApiFuture<TransactionContext>
    implements TransactionContextFuture {

  @InternalApi
  interface CommittableAsyncTransactionManager extends AsyncTransactionManager {
    void onError(Throwable t);

    ApiFuture<Timestamp> commitAsync();
  }

  /**
   * {@link ApiFuture} that returns a commit timestamp. Any {@link AbortedException} that is thrown
   * by either the commit call or any other rpc during the transaction will be thrown by the {@link
   * #get()} method of this future as an {@link AbortedException} and not as an {@link
   * ExecutionException} with an {@link AbortedException} as its cause.
   */
  static class CommitTimestampFutureImpl extends ForwardingApiFuture<Timestamp>
      implements CommitTimestampFuture {
    CommitTimestampFutureImpl(ApiFuture<Timestamp> delegate) {
      super(Preconditions.checkNotNull(delegate));
    }

    @Override
    public Timestamp get() throws AbortedException, ExecutionException, InterruptedException {
      try {
        return super.get();
      } catch (ExecutionException e) {
        if (e.getCause() != null && e.getCause() instanceof AbortedException) {
          throw (AbortedException) e.getCause();
        }
        throw e;
      }
    }

    @Override
    public Timestamp get(long timeout, TimeUnit unit)
        throws AbortedException, ExecutionException, InterruptedException, TimeoutException {
      try {
        return super.get(timeout, unit);
      } catch (ExecutionException e) {
        if (e.getCause() != null && e.getCause() instanceof AbortedException) {
          throw (AbortedException) e.getCause();
        }
        throw e;
      }
    }
  }

  class AsyncTransactionStatementImpl<I, O> extends ForwardingApiFuture<O>
      implements AsyncTransactionStep<I, O> {
    final ApiFuture<TransactionContext> txnFuture;
    final SettableApiFuture<O> statementResult;

    AsyncTransactionStatementImpl(
        final ApiFuture<TransactionContext> txnFuture,
        ApiFuture<I> input,
        final AsyncTransactionFunction<I, O> function,
        Executor executor) {
      this(SettableApiFuture.create(), txnFuture, input, function, executor);
    }

    AsyncTransactionStatementImpl(
        SettableApiFuture<O> delegate,
        final ApiFuture<TransactionContext> txnFuture,
        ApiFuture<I> input,
        final AsyncTransactionFunction<I, O> function,
        final Executor executor) {
      super(delegate);
      this.statementResult = delegate;
      this.txnFuture = txnFuture;
      ApiFutures.addCallback(
          input,
          new ApiFutureCallback<I>() {
            @Override
            public void onFailure(Throwable t) {
              mgr.onError(t);
              statementResult.setException(t);
              txnResult.setException(t);
            }

            @Override
            public void onSuccess(I result) {
              try {
                ApiFutures.addCallback(
                    runAsyncTransactionFunction(function, txnFuture.get(), result, executor),
                    new ApiFutureCallback<O>() {
                      @Override
                      public void onFailure(Throwable t) {
                        mgr.onError(t);
                        statementResult.setException(t);
                        txnResult.setException(t);
                      }

                      @Override
                      public void onSuccess(O result) {
                        statementResult.set(result);
                      }
                    },
                    MoreExecutors.directExecutor());
              } catch (Throwable t) {
                mgr.onError(t);
                statementResult.setException(t);
                txnResult.setException(t);
              }
            }
          },
          MoreExecutors.directExecutor());
    }

    @Override
    public <RES> AsyncTransactionStatementImpl<O, RES> then(
        AsyncTransactionFunction<O, RES> next, Executor executor) {
      return new AsyncTransactionStatementImpl<>(txnFuture, statementResult, next, executor);
    }

    @Override
    public CommitTimestampFuture commitAsync() {
      ApiFutures.addCallback(
          statementResult,
          new ApiFutureCallback<O>() {
            @Override
            public void onFailure(Throwable t) {
              mgr.onError(t);
              txnResult.setException(t);
            }

            @Override
            public void onSuccess(O result) {
              ApiFutures.addCallback(
                  mgr.commitAsync(),
                  new ApiFutureCallback<Timestamp>() {
                    @Override
                    public void onFailure(Throwable t) {
                      mgr.onError(t);
                      txnResult.setException(t);
                    }

                    @Override
                    public void onSuccess(Timestamp result) {
                      txnResult.set(result);
                    }
                  },
                  MoreExecutors.directExecutor());
            }
          },
          MoreExecutors.directExecutor());
      return new CommitTimestampFutureImpl(txnResult);
    }
  }

  static <I, O> ApiFuture<O> runAsyncTransactionFunction(
      final AsyncTransactionFunction<I, O> function,
      final TransactionContext txn,
      final I input,
      Executor executor)
      throws Exception {
    // Shortcut for common path.
    if (executor == MoreExecutors.directExecutor()) {
      return Preconditions.checkNotNull(
          function.apply(txn, input),
          "AsyncTransactionFunction returned <null>. Did you mean to return"
              + " ApiFutures.immediateFuture(null)?");
    } else {
      final SettableApiFuture<O> res = SettableApiFuture.create();
      executor.execute(
          () -> {
            try {
              ApiFuture<O> functionResult =
                  Preconditions.checkNotNull(
                      function.apply(txn, input),
                      "AsyncTransactionFunction returned <null>. Did you mean to return"
                          + " ApiFutures.immediateFuture(null)?");
              ApiFutures.addCallback(
                  functionResult,
                  new ApiFutureCallback<O>() {
                    @Override
                    public void onFailure(Throwable t) {
                      res.setException(t);
                    }

                    @Override
                    public void onSuccess(O result) {
                      res.set(result);
                    }
                  },
                  MoreExecutors.directExecutor());
            } catch (Throwable t) {
              res.setException(t);
            }
          });
      return res;
    }
  }

  final CommittableAsyncTransactionManager mgr;
  final SettableApiFuture<Timestamp> txnResult = SettableApiFuture.create();

  TransactionContextFutureImpl(
      CommittableAsyncTransactionManager mgr, ApiFuture<TransactionContext> txnFuture) {
    super(txnFuture);
    this.mgr = mgr;
  }

  @Override
  public <O> AsyncTransactionStatementImpl<Void, O> then(
      AsyncTransactionFunction<Void, O> function, Executor executor) {
    final SettableApiFuture<Void> input = SettableApiFuture.create();
    ApiFutures.addCallback(
        this,
        new ApiFutureCallback<TransactionContext>() {
          @Override
          public void onFailure(Throwable t) {
            mgr.onError(t);
            input.setException(t);
          }

          @Override
          public void onSuccess(TransactionContext result) {
            input.set(null);
          }
        },
        MoreExecutors.directExecutor());
    return new AsyncTransactionStatementImpl<>(this, input, function, executor);
  }
}
