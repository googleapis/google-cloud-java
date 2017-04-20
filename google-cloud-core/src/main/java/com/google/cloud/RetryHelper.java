/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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
import com.google.api.gax.core.RetrySettings;

import com.google.api.gax.retrying.DirectRetryingExecutor;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetryingExecutor;
import com.google.api.gax.retrying.RetryingFuture;
import java.util.concurrent.Callable;

/**
 * Utility class for retrying operations. For more details about the parameters, see {@link
 * RetrySettings}. In case if retrying is unsuccessful, {@link RetryHelperException} will be
 * thrown.
 */
public class RetryHelper {
  public static <V> V runWithRetries(
      Callable<V> callable,
      RetrySettings retrySettings,
      ExceptionHandler exceptionRetryAlgorithm,
      ApiClock clock)
      throws RetryHelperException {
    try {
      RetryAlgorithm retryAlgorithm =
          new RetryAlgorithm(exceptionRetryAlgorithm, new ExponentialRetryAlgorithm(retrySettings, clock));
      RetryingExecutor<V> executor = new DirectRetryingExecutor<>(retryAlgorithm);

      RetryingFuture<V> retryingFuture = executor.createFuture(callable);
      executor.submit(retryingFuture);

      return retryingFuture.get();
    } catch (Exception e) {
      throw new RetryHelperException(e.getCause());
    }
  }

  public static class RetryHelperException extends RuntimeException {

    private static final long serialVersionUID = -8519852520090965314L;

    RetryHelperException(Throwable cause) {
      super(cause);
    }
  }
}
