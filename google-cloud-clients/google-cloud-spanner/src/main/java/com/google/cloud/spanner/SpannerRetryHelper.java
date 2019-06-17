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

import com.google.api.core.NanoClock;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.cloud.RetryHelper;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.common.base.Throwables;
import io.grpc.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import org.threeten.bp.Duration;

/**
 * Util class for retrying aborted transactions. This class is a wrapper around {@link RetryHelper}
 * that uses specific settings to only retry on aborted transactions, without a timeout and without
 * a cap on the number of retries.
 */
class SpannerRetryHelper {
  private static final RetrySettings txRetrySettings =
      RetrySettings.newBuilder()
          .setInitialRetryDelay(Duration.ofMillis(1000L))
          .setMaxRetryDelay(Duration.ofMillis(32000L))
          .setTotalTimeout(Duration.ofMillis(Integer.MAX_VALUE))
          .build();

  /** Executes the {@link Callable} and retries if it fails with an {@link AbortedException}. */
  static <T> T runTxWithRetriesOnAborted(Callable<T> callable) {
    try {
      return RetryHelper.runWithRetries(
          callable, txRetrySettings, new TxRetryAlgorithm<>(), NanoClock.getDefaultClock());
    } catch (RetryHelperException e) {
      if (e.getCause() != null) {
        Throwables.throwIfUnchecked(e.getCause());
      }
      throw e;
    }
  }

  private static class TxRetryAlgorithm<T> implements ResultRetryAlgorithm<T> {
    @Override
    public TimedAttemptSettings createNextAttempt(
        Throwable prevThrowable, T prevResponse, TimedAttemptSettings prevSettings) {
      return null;
    }

    @Override
    public boolean shouldRetry(Throwable prevThrowable, T prevResponse)
        throws CancellationException {
      if (Context.current().isCancelled()) {
        throw SpannerExceptionFactory.newSpannerExceptionForCancellation(Context.current(), null);
      }
      return prevThrowable != null
          && (prevThrowable instanceof AbortedException
              || prevThrowable instanceof com.google.api.gax.rpc.AbortedException);
    }
  }
}
