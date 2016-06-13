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

import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.StrictMath.max;
import static java.lang.StrictMath.min;
import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.random;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;

import java.io.InterruptedIOException;
import java.nio.channels.ClosedByInterruptException;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class for retrying operations. For more details about the parameters, see
 * {@link RetryParams}. If the request is never successful, a {@link RetriesExhaustedException} will
 * be thrown.
 *
 * @param <V> return value of the closure that is being run with retries
 */
public class RetryHelper<V> {

  private static final Logger log = Logger.getLogger(RetryHelper.class.getName());

  private final Clock clock;
  private final Callable<V> callable;
  private final RetryParams params;
  private final ExceptionHandler exceptionHandler;
  private int attemptNumber;


  private static final ThreadLocal<Context> context = new ThreadLocal<>();

  public static class RetryHelperException extends RuntimeException {

    private static final long serialVersionUID = -2907061015610448235L;

    RetryHelperException() {}

    RetryHelperException(String message) {
      super(message);
    }

    RetryHelperException(Throwable cause) {
      super(cause);
    }

    RetryHelperException(String message, Throwable cause) {
      super(message, cause);
    }
  }

  /**
   * Thrown when a RetryHelper failed to complete its work due to interruption. Throwing this
   * exception also sets the thread interrupt flag.
   */
  public static final class RetryInterruptedException extends RetryHelperException {

    private static final long serialVersionUID = 1678966737697204885L;

    RetryInterruptedException() {}

    /**
     * Sets the caller thread interrupt flag and throws {@code RetryInterruptedException}.
     */
    public static void propagate() throws RetryInterruptedException {
      Thread.currentThread().interrupt();
      throw new RetryInterruptedException();
    }
  }

  /**
   * Thrown when a RetryHelper has attempted the maximum number of attempts allowed by RetryParams
   * and was not successful.
   */
  public static final class RetriesExhaustedException extends RetryHelperException {

    private static final long serialVersionUID = 780199686075408083L;

    RetriesExhaustedException(String message) {
      super(message);
    }

    RetriesExhaustedException(String message, Throwable cause) {
      super(message, cause);
    }
  }

  /**
   * Thrown when RetryHelper callable has indicate it should not be retried.
   */
  public static final class NonRetriableException extends RetryHelperException {

    private static final long serialVersionUID = -2331878521983499652L;

    NonRetriableException(Throwable throwable) {
      super(throwable);
    }
  }

  static class Context {

    private final RetryHelper<?> helper;

    Context(RetryHelper<?> helper) {
      this.helper = helper;
    }

    public RetryParams getRetryParams() {
      return helper.params;
    }

    public int getAttemptNumber() {
      return helper.attemptNumber;
    }
  }

  @VisibleForTesting
  static void setContext(Context ctx) {
    if (ctx == null) {
      context.remove();
    } else {
      context.set(ctx);
    }
  }

  static Context getContext() {
    return context.get();
  }

  @VisibleForTesting
  RetryHelper(Callable<V> callable, RetryParams params, ExceptionHandler exceptionHandler,
      Clock clock) {
    this.callable = checkNotNull(callable);
    this.params = checkNotNull(params);
    this.clock = checkNotNull(clock);
    this.exceptionHandler = checkNotNull(exceptionHandler);
    exceptionHandler.verifyCaller(callable);
  }

  @Override
  public String toString() {
    ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
    toStringHelper.add("params", params);
    toStringHelper.add("clock", clock);
    toStringHelper.add("attemptNumber", attemptNumber);
    toStringHelper.add("callable", callable);
    toStringHelper.add("exceptionHandler", exceptionHandler);
    return toStringHelper.toString();
  }

  private V doRetry() throws RetryHelperException {
    long start = clock.millis();
    while (true) {
      attemptNumber++;
      Exception exception;
      try {
        V value = callable.call();
        if (attemptNumber > 1 && log.isLoggable(Level.FINE)) {
          log.fine(this + ": attempt #" + attemptNumber + " succeeded");
        }
        return value;
      } catch (InterruptedException | InterruptedIOException | ClosedByInterruptException e) {
        if (!exceptionHandler.shouldRetry(e)) {
          RetryInterruptedException.propagate();
        }
        exception = e;
      } catch (Exception e) {
        if (!exceptionHandler.shouldRetry(e)) {
          throw new NonRetriableException(e);
        }
        exception = e;
      }
      if (attemptNumber >= params.retryMaxAttempts()
          || attemptNumber >= params.retryMinAttempts()
          && clock.millis() - start >= params.totalRetryPeriodMillis()) {
        throw new RetriesExhaustedException(this + ": Too many failures, giving up", exception);
      }
      long sleepDurationMillis = getSleepDuration(params, attemptNumber);
      if (log.isLoggable(Level.FINE)) {
        log.fine(this + ": Attempt #" + attemptNumber + " failed [" + exception
            + "], sleeping for " + sleepDurationMillis + " ms");
      }
      try {
        Thread.sleep(sleepDurationMillis);
      } catch (InterruptedException e) {
        // propagate as RetryInterruptedException
        RetryInterruptedException.propagate();
      }
    }
  }

  @VisibleForTesting
  static long getSleepDuration(RetryParams retryParams, int attemptsSoFar) {
    long initialDelay = retryParams.initialRetryDelayMillis();
    double backoffFactor = retryParams.retryDelayBackoffFactor();
    long maxDelay = retryParams.maxRetryDelayMillis();
    long retryDelay = getExponentialValue(initialDelay, backoffFactor, maxDelay, attemptsSoFar);
    return (long) ((random() / 2.0 + .75) * retryDelay);
  }

  private static long getExponentialValue(long initialDelay, double backoffFactor, long maxDelay,
      int attemptsSoFar) {
    return (long) min(maxDelay, pow(backoffFactor, max(1, attemptsSoFar) - 1) * initialDelay);
  }

  public static <V> V runWithRetries(Callable<V> callable) throws RetryHelperException {
    return runWithRetries(callable, RetryParams.defaultInstance(),
        ExceptionHandler.defaultInstance());
  }

  public static <V> V runWithRetries(Callable<V> callable, RetryParams params,
      ExceptionHandler exceptionHandler) throws RetryHelperException {
    return runWithRetries(callable, params, exceptionHandler, Clock.defaultClock());
  }

  public static <V> V runWithRetries(Callable<V> callable, RetryParams params,
      ExceptionHandler exceptionHandler, Clock clock) throws RetryHelperException {
    RetryHelper<V> retryHelper = new RetryHelper<>(callable, params, exceptionHandler, clock);
    Context previousContext = getContext();
    setContext(new Context(retryHelper));
    try {
      return retryHelper.doRetry();
    } finally {
      setContext(previousContext);
    }
  }
}
