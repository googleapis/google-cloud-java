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

import com.google.api.client.http.HttpResponseException;
import com.google.api.core.ApiClock;
import com.google.api.gax.retrying.DirectRetryingExecutor;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.RetryingExecutor;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.retrying.TimedRetryAlgorithm;
import com.google.cloud.RetryHelper;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.ContextKey;
import io.opentelemetry.context.Scope;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BigQueryRetryHelper extends RetryHelper {

  public static final ContextKey<AtomicInteger> RETRY_ATTEMPT_KEY =
      ContextKey.named("bq_retry_attempt");

  private static final Logger LOG = Logger.getLogger(BigQueryRetryHelper.class.getName());

  public static <V> V runWithRetries(
      Callable<V> callable,
      RetrySettings retrySettings,
      ResultRetryAlgorithm<?> resultRetryAlgorithm,
      ApiClock clock,
      BigQueryRetryConfig bigQueryRetryConfig,
      boolean isOpenTelemetryEnabled,
      Tracer openTelemetryTracer)
      throws RetryHelperException {
    Span runWithRetries = null;
    if (isOpenTelemetryEnabled && openTelemetryTracer != null) {
      runWithRetries =
          openTelemetryTracer
              .spanBuilder("com.google.cloud.bigquery.BigQueryRetryHelper.runWithRetries")
              .startSpan();
    }
    Context retryContext = Context.current().with(RETRY_ATTEMPT_KEY, new AtomicInteger(0));
    if (runWithRetries != null) {
      retryContext = retryContext.with(runWithRetries);
    }
    try (Scope runWithRetriesScope = retryContext.makeCurrent()) {
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
      // Checks for IOException and translate it into BigQueryException. The BigQueryException
      // constructor parses the IOException and translate it into internal code.
      if (e.getCause() instanceof IOException) {
        throw new BigQueryRetryHelperException(new BigQueryException((IOException) e.getCause()));
      }
      throw new BigQueryRetryHelperException(e.getCause());
    } finally {
      if (runWithRetries != null) {
        runWithRetries.end();
      }
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

    // Log retry info
    if (LOG.isLoggable(Level.FINEST)) {
      LOG.log(
          Level.FINEST,
          "Retrying with:\n{0}\n{1}",
          new Object[] {
            "BigQuery retried method: " + callable.getClass().getEnclosingMethod().getName(),
            "BigQuery retry settings: " + timedAlgorithm.createFirstAttempt().getGlobalSettings()
          });
    }

    RetryingFuture<V> retryingFuture = executor.createFuture(callable);
    executor.submit(retryingFuture);
    return retryingFuture.get();
  }

  static <V> ResultRetryAlgorithm<V> maybeWrapForHttpRetry(ResultRetryAlgorithm<V> algorithm) {
    if (algorithm == BigQueryBaseService.DEFAULT_BIGQUERY_EXCEPTION_HANDLER) {
      return wrapDefaultAlgorithm(algorithm);
    }
    return algorithm;
  }

  private static <V> ResultRetryAlgorithm<V> wrapDefaultAlgorithm(
      ResultRetryAlgorithm<V> defaultAlgorithm) {
    return new ResultRetryAlgorithm<V>() {
      @Override
      public TimedAttemptSettings createNextAttempt(
          Throwable previousThrowable, V previousResponse, TimedAttemptSettings previousSettings) {
        return defaultAlgorithm.createNextAttempt(
            previousThrowable, previousResponse, previousSettings);
      }

      @Override
      public boolean shouldRetry(Throwable previousThrowable, V previousResponse) {
        if (previousThrowable instanceof HttpResponseException) {
          int statusCode = ((HttpResponseException) previousThrowable).getStatusCode();
          if (statusCode == 500 || statusCode == 502 || statusCode == 503 || statusCode == 504) {
            return true;
          }
        }
        return defaultAlgorithm.shouldRetry(previousThrowable, previousResponse);
      }
    };
  }

  public static class BigQueryRetryHelperException extends RuntimeException {

    private static final long serialVersionUID = -8519852520090965314L;

    BigQueryRetryHelperException(Throwable cause) {
      super(cause);
    }
  }
}
