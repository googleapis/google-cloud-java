/*
 * Copyright 2019 Google LLC
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

import com.google.api.core.ApiClock;
import com.google.api.core.NanoClock;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.cloud.RetryHelper;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.spanner.ErrorHandler.DefaultErrorHandler;
import com.google.cloud.spanner.v1.stub.SpannerStub;
import com.google.cloud.spanner.v1.stub.SpannerStubSettings;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Throwables;
import com.google.spanner.v1.RollbackRequest;
import io.grpc.Context;
import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

/**
 * Util class for retrying aborted transactions. This class is a wrapper around {@link RetryHelper}
 * that uses specific settings to only retry on aborted transactions, without a timeout and without
 * a cap on the number of retries.
 */
class SpannerRetryHelper {

  /**
   * Use the same {@link RetrySettings} for retrying an aborted transaction as for retrying a {@link
   * RollbackRequest}. The {@link RollbackRequest} automatically uses the default retry settings
   * defined for the {@link SpannerStub}. By referencing these settings, the retry settings for
   * retrying aborted transactions will also automatically be updated if the default retry settings
   * are updated.
   *
   * <p>A read/write transaction should not timeout while retrying. The total timeout of the retry
   * settings is therefore set to 24 hours and there is no max attempts value.
   *
   * <p>These default {@link RetrySettings} are only used if no retry information is returned by the
   * {@link AbortedException}.
   */
  @VisibleForTesting
  static final RetrySettings txRetrySettings =
      SpannerStubSettings.newBuilder().rollbackSettings().getRetrySettings().toBuilder()
          .setTotalTimeoutDuration(Duration.ofHours(24L))
          .setMaxAttempts(0)
          .build();

  /** Executes the {@link Callable} and retries if it fails with an {@link AbortedException}. */
  static <T> T runTxWithRetriesOnAborted(Callable<T> callable) {
    return runTxWithRetriesOnAborted(callable, DefaultErrorHandler.INSTANCE);
  }

  static <T> T runTxWithRetriesOnAborted(Callable<T> callable, ErrorHandler errorHandler) {
    return runTxWithRetriesOnAborted(
        callable, errorHandler, txRetrySettings, NanoClock.getDefaultClock());
  }

  /**
   * Executes the {@link Callable} and retries if it fails with an {@link AbortedException} using
   * the specific {@link RetrySettings}.
   */
  @VisibleForTesting
  static <T> T runTxWithRetriesOnAborted(
      Callable<T> callable, RetrySettings retrySettings, ApiClock clock) {
    return runTxWithRetriesOnAborted(callable, DefaultErrorHandler.INSTANCE, retrySettings, clock);
  }

  @VisibleForTesting
  static <T> T runTxWithRetriesOnAborted(
      Callable<T> callable,
      ErrorHandler errorHandler,
      RetrySettings retrySettings,
      ApiClock clock) {
    try {
      return RetryHelper.runWithRetries(callable, retrySettings, new TxRetryAlgorithm<>(), clock);
    } catch (RetryHelperException e) {
      if (e.getCause() != null) {
        Throwables.throwIfUnchecked(errorHandler.translateException(e.getCause()));
      }
      throw e;
    }
  }

  private static class TxRetryAlgorithm<T> implements ResultRetryAlgorithm<T> {
    @Override
    public TimedAttemptSettings createNextAttempt(
        Throwable prevThrowable, T prevResponse, TimedAttemptSettings prevSettings) {
      if (prevThrowable != null) {
        long retryDelay = SpannerException.extractRetryDelay(prevThrowable);
        if (retryDelay > -1L) {
          return prevSettings.toBuilder()
              .setRandomizedRetryDelayDuration(Duration.ofMillis(retryDelay))
              .build();
        }
      }
      return null;
    }

    @Override
    public boolean shouldRetry(Throwable prevThrowable, T prevResponse)
        throws CancellationException {
      if (Context.current().isCancelled()) {
        throw SpannerExceptionFactory.newSpannerExceptionForCancellation(Context.current(), null);
      }
      return prevThrowable instanceof AbortedException
          || prevThrowable instanceof com.google.api.gax.rpc.AbortedException;
    }
  }
}
