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

class TransactionRunnerImpl {
  private final ConnectionImpl connection;

  TransactionRunnerImpl(ConnectionImpl connection) {
    this.connection = connection;
  }

  <T> T run(TransactionCallable<T> callable) {
    connection.beginTransaction();
    // Disable internal retries during this transaction.
    connection.setRetryAbortsInternally(/* retryAbortsInternally= */ false, /* local= */ true);
    UnitOfWork transaction = connection.getCurrentUnitOfWorkOrStartNewUnitOfWork();
    while (true) {
      try {
        T result = callable.run(connection);
        get(connection.commitAsync(CallType.SYNC, Caller.TRANSACTION_RUNNER));
        return result;
      } catch (AbortedException abortedException) {
        try {
          //noinspection BusyWait
          Thread.sleep(abortedException.getRetryDelayInMillis());
          connection.resetForRetry(transaction);
        } catch (InterruptedException interruptedException) {
          connection.rollbackAsync(CallType.SYNC, Caller.TRANSACTION_RUNNER);
          throw SpannerExceptionFactory.propagateInterrupt(interruptedException);
        } catch (Throwable t) {
          connection.rollbackAsync(CallType.SYNC, Caller.TRANSACTION_RUNNER);
          throw t;
        }
      } catch (Throwable t) {
        connection.rollbackAsync(CallType.SYNC, Caller.TRANSACTION_RUNNER);
        throw t;
      }
    }
  }
}
