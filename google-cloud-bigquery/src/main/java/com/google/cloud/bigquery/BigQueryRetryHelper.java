/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.bigquery;

import com.google.api.core.ApiClock;
import com.google.api.gax.retrying.*;
import com.google.cloud.RetryHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class BigQueryRetryHelper extends RetryHelper {

  public static <V> V runWithRetries(
      Callable<V> callable,
      RetrySettings retrySettings,
      ResultRetryAlgorithm<?> resultRetryAlgorithm,
      ApiClock clock,
      BigQueryRetryConfig bigQueryRetryConfig)
      throws RetryHelperException {
    try {
      // Suppressing should be ok as a workaraund. Current and only ResultRetryAlgorithm
      // implementation does not use response at all, so ignoring its type is ok.
      @SuppressWarnings("unchecked")
      ResultRetryAlgorithm<V> algorithm = (ResultRetryAlgorithm<V>) resultRetryAlgorithm;
      return run(
          callable,
          new ExponentialRetryAlgorithm(retrySettings, clock),
          algorithm,
          bigQueryRetryConfig);
    } catch (Exception e) {
      throw new BigQueryRetryHelperException(e.getCause());
    }
  }

  private static <V> V run(
      Callable<V> callable,
      TimedRetryAlgorithm timedAlgorithm,
      ResultRetryAlgorithm<V> resultAlgorithm,
      BigQueryRetryConfig bigQueryRetryConfig)
      throws ExecutionException, InterruptedException {
    RetryAlgorithm<V> retryAlgorithm =
        new BigQueryRetryAlgorithm<>(
            resultAlgorithm,
            timedAlgorithm,
            bigQueryRetryConfig); // using BigQueryRetryAlgorithm in place of
    // com.google.api.gax.retrying.RetryAlgorithm, as
    // BigQueryRetryAlgorithm retries considering bigQueryRetryConfig
    RetryingExecutor<V> executor = new DirectRetryingExecutor<>(retryAlgorithm);

    RetryingFuture<V> retryingFuture = executor.createFuture(callable);
    executor.submit(retryingFuture);
    return retryingFuture.get();
  }

  public static class BigQueryRetryHelperException extends RuntimeException {

    private static final long serialVersionUID = -8519852520090965314L;

    BigQueryRetryHelperException(Throwable cause) {
      super(cause);
    }
  }
}
