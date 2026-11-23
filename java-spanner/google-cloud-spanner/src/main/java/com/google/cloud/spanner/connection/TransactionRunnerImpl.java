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

import static com.google.cloud.spanner.SpannerApiFutures.get;

import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.connection.Connection.TransactionCallable;
import com.google.cloud.spanner.connection.ConnectionImpl.Caller;
import com.google.cloud.spanner.connection.UnitOfWork.CallType;
import com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState;
import java.util.concurrent.ThreadLocalRandom;

class TransactionRunnerImpl {
  private static final long MAX_FALLBACK_BACKOFF_MILLIS = 32_000L;

  private final ConnectionImpl connection;

  TransactionRunnerImpl(ConnectionImpl connection) {
    this.connection = connection;
  }

  /**
   * Computes jittered exponential backoff in milliseconds when an {@link AbortedException} does not
   * carry a {@code RetryInfo} delay ({@code getRetryDelayInMillis() < 0}), preventing a tight 0ms
   * CPU spin loop on repeated synthetic aborts while keeping initial retry latency minimal.
   */
  static long nextFallbackBackoffMillis(int fallbackAttempt) {
    long maxWindowMillis =
        Math.min(MAX_FALLBACK_BACKOFF_MILLIS, 1L << Math.min(fallbackAttempt + 1, 15));
    long halfWindowMillis = Math.max(1L, maxWindowMillis / 2L);
    return halfWindowMillis + ThreadLocalRandom.current().nextLong(halfWindowMillis + 1L);
  }

  <T> T run(TransactionCallable<T> callable) {
    connection.beginTransaction();
    // Disable internal retries during this transaction.
    connection.setRetryAbortsInternally(/* retryAbortsInternally= */ false, /* local= */ true);
    UnitOfWork transaction = connection.getCurrentUnitOfWorkOrStartNewUnitOfWork();
    int fallbackAttempts = 0;
    while (true) {
      try {
        T result = callable.run(connection);
        if (transaction.getState() == UnitOfWorkState.ABORTED
            && transaction instanceof ReadWriteTransaction) {
          // Re-surface a caught mid-callable abort before commitAsync so an orphaned replacement
          // ReadWriteTransaction is never silently committed, preserving original RetryInfo.
          AbortedException storedAbort = ((ReadWriteTransaction) transaction).getAbortedException();
          if (storedAbort != null) {
            throw storedAbort;
          }
          ((ReadWriteTransaction) transaction).checkAborted();
        }
        get(connection.commitAsync(CallType.SYNC, Caller.TRANSACTION_RUNNER));
        return result;
      } catch (AbortedException abortedException) {
        try {
          long retryDelayMillis = abortedException.getRetryDelayInMillis();
          long sleepMillis;
          if (retryDelayMillis >= 0L) {
            fallbackAttempts = 0;
            sleepMillis = retryDelayMillis;
          } else {
            sleepMillis = nextFallbackBackoffMillis(fallbackAttempts++);
          }
          //noinspection BusyWait
          Thread.sleep(sleepMillis);
          connection.resetForRetry(transaction);
        } catch (InterruptedException interruptedException) {
          connection.rollbackAfterAbort(transaction);
          throw SpannerExceptionFactory.propagateInterrupt(interruptedException);
        } catch (Throwable t) {
          connection.rollbackAfterAbort(transaction);
          throw t;
        }
      } catch (Throwable t) {
        connection.rollbackAfterAbort(transaction);
        throw t;
      }
    }
  }
}
