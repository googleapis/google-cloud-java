/*
 * Copyright 2015 Google LLC
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

package com.google.cloud;

import com.google.api.core.ApiClock;
import com.google.api.core.BetaApi;
import com.google.api.gax.retrying.ExponentialPollAlgorithm;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;

import com.google.api.gax.retrying.DirectRetryingExecutor;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetryingExecutor;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.TimedRetryAlgorithm;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Utility class for retrying operations. For more details about the parameters, see {@link
 * RetrySettings}. In case if retrying is unsuccessful, {@link RetryHelperException} will be thrown.
 */
@BetaApi
public class RetryHelper {
  public static <V> V runWithRetries(
      Callable<V> callable,
      RetrySettings retrySettings,
      ResultRetryAlgorithm<?> resultRetryAlgorithm,
      ApiClock clock)
      throws RetryHelperException {
    try {
      // Suppressing should be ok as a workaraund. Current and only ResultRetryAlgorithm
      // implementation does not use response at all, so ignoring its type is ok.
      @SuppressWarnings("unchecked")
      ResultRetryAlgorithm<V> algorithm = (ResultRetryAlgorithm<V>) resultRetryAlgorithm;
      return run(callable, new ExponentialRetryAlgorithm(retrySettings, clock), algorithm);
    } catch (Exception e) {
      //TODO: remove RetryHelperException, throw InterruptedException or ExecutionException#getCause() explicitly
      throw new RetryHelperException(e.getCause());
    }
  }

  public static <V> V poll(
      Callable<V> callable,
      RetrySettings pollSettings,
      ResultRetryAlgorithm<V> resultPollAlgorithm,
      ApiClock clock) throws ExecutionException, InterruptedException {
      return run(callable, new ExponentialPollAlgorithm(pollSettings, clock), resultPollAlgorithm);
  }

  private static <V> V run(
      Callable<V> callable,
      TimedRetryAlgorithm timedAlgorithm,
      ResultRetryAlgorithm<V> resultAlgorithm) throws ExecutionException, InterruptedException {
      RetryAlgorithm<V> retryAlgorithm = new RetryAlgorithm<>(resultAlgorithm, timedAlgorithm);
      RetryingExecutor<V> executor = new DirectRetryingExecutor<>(retryAlgorithm);

      RetryingFuture<V> retryingFuture = executor.createFuture(callable);
      executor.submit(retryingFuture);
      return retryingFuture.get();
  }

  public static class RetryHelperException extends RuntimeException {

    private static final long serialVersionUID = -8519852520090965314L;

    RetryHelperException(Throwable cause) {
      super(cause);
    }
  }
}
