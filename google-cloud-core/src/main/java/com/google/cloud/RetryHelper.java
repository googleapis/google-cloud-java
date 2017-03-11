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

import com.google.api.gax.core.NanoClock;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.retrying.DirectRetryHandler;
import com.google.api.gax.retrying.RetryAttemptSettings;
import com.google.api.gax.retrying.RetryFuture;

import java.util.concurrent.Callable;

/**
 * Utility class for retrying operations. For more details about the parameters, see {@link
 * RetrySettings}.
 *
 */
public class RetryHelper {
  public static <V> V runWithRetries(
      Callable<V> callable,
      RetrySettings retrySettings,
      ExceptionHandler exceptionHandler,
      NanoClock clock)
      throws RetryHelperException {
    try {
      RetryHandler<V> retryHandler = new RetryHandler<>(clock, exceptionHandler);
      RetryFuture<V> retryFuture = retryHandler.createFirstAttempt(callable, retrySettings);
      retryFuture.setAttemptFuture(
          retryHandler.executeAttempt(callable, retryFuture.getAttemptSettings()));
      return retryFuture.get();
    } catch (Exception e) {
      throw new RetryHelperException(e.getCause());
    }
  }

  private static class RetryHandler<V> extends DirectRetryHandler<V> {
    private final ExceptionHandler exceptionHandler;

    private RetryHandler(NanoClock clock, ExceptionHandler exceptionHandler) {
      super(clock);
      this.exceptionHandler = exceptionHandler;
    }

    @Override
    public boolean accept(Throwable e, RetryAttemptSettings nextAttemptSettings) {
      return super.accept(e, nextAttemptSettings)
          && (e instanceof Exception)
          && exceptionHandler.shouldRetry((Exception) e);
    }
  }

  public static class RetryHelperException extends RuntimeException {
    private static final long serialVersionUID = -8519852520090965314L;

    RetryHelperException(Throwable cause) {
      super(cause);
    }
  }
}
