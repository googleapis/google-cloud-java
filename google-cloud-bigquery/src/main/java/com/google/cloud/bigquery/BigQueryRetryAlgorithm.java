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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.ResultRetryAlgorithmWithContext;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetryingContext;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.retrying.TimedRetryAlgorithm;
import com.google.api.gax.retrying.TimedRetryAlgorithmWithContext;
import java.util.Iterator;
import java.util.concurrent.CancellationException;

public class BigQueryRetryAlgorithm<ResponseT> extends RetryAlgorithm<ResponseT> {
  private final BigQueryRetryConfig bigQueryRetryConfig;
  private final ResultRetryAlgorithm<ResponseT> resultAlgorithm;
  private final TimedRetryAlgorithm timedAlgorithm;
  private final ResultRetryAlgorithmWithContext<ResponseT> resultAlgorithmWithContext;
  private final TimedRetryAlgorithmWithContext timedAlgorithmWithContext;

  public BigQueryRetryAlgorithm(
      ResultRetryAlgorithm<ResponseT> resultAlgorithm,
      TimedRetryAlgorithm timedAlgorithm,
      BigQueryRetryConfig bigQueryRetryConfig) {
    super(resultAlgorithm, timedAlgorithm);
    this.bigQueryRetryConfig = checkNotNull(bigQueryRetryConfig);
    this.resultAlgorithm = checkNotNull(resultAlgorithm);
    this.timedAlgorithm = checkNotNull(timedAlgorithm);
    this.resultAlgorithmWithContext = null;
    this.timedAlgorithmWithContext = null;
  }

  @Override
  public boolean shouldRetry(
      RetryingContext context,
      Throwable previousThrowable,
      ResponseT previousResponse,
      TimedAttemptSettings nextAttemptSettings)
      throws CancellationException {
    // Implementing shouldRetryBasedOnBigQueryRetryConfig so that we can retry exceptions based on
    // the exception messages
    return (shouldRetryBasedOnResult(context, previousThrowable, previousResponse)
            || shouldRetryBasedOnBigQueryRetryConfig(previousThrowable, bigQueryRetryConfig))
        && shouldRetryBasedOnTiming(context, nextAttemptSettings);
  }

  private boolean shouldRetryBasedOnBigQueryRetryConfig(
      Throwable previousThrowable, BigQueryRetryConfig bigQueryRetryConfig) {
    /*
    We are deciding if a given error should be retried on the basis of error message.
    Cannot rely on Error/Status code as for example error code 400 (which is not retriable) could be thrown due to rateLimitExceed, which is retriable
     */
    String errorDesc;
    if (previousThrowable != null && (errorDesc = previousThrowable.getMessage()) != null) {
      for (Iterator<String> retriableMessages =
              bigQueryRetryConfig.getRetriableErrorMessages().iterator();
          retriableMessages.hasNext(); ) {
        if (errorDesc.contains(retriableMessages.next())) { // Error message should be retried
          return true;
        }
      }
    }
    return false;
  }

  /*Duplicating this method as it can not be inherited from the RetryAlgorithm due to the default access modifier*/
  boolean shouldRetryBasedOnResult(
      RetryingContext context, Throwable previousThrowable, ResponseT previousResponse) {
    if (resultAlgorithmWithContext != null && context != null) {
      return resultAlgorithmWithContext.shouldRetry(context, previousThrowable, previousResponse);
    }
    return getResultAlgorithm().shouldRetry(previousThrowable, previousResponse);
  }

  /*Duplicating this method as it can not be inherited from the RetryAlgorithm due to the private access modifier*/
  private boolean shouldRetryBasedOnTiming(
      RetryingContext context, TimedAttemptSettings nextAttemptSettings) {
    if (nextAttemptSettings == null) {
      return false;
    }
    if (timedAlgorithmWithContext != null && context != null) {
      return timedAlgorithmWithContext.shouldRetry(context, nextAttemptSettings);
    }
    return getTimedAlgorithm().shouldRetry(nextAttemptSettings);
  }

  @Override
  public TimedAttemptSettings createNextAttempt(
      RetryingContext context,
      Throwable previousThrowable,
      ResponseT previousResponse,
      TimedAttemptSettings previousSettings) {
    // a small optimization that avoids calling relatively heavy methods
    // like timedAlgorithm.createNextAttempt(), when it is not necessary.

    if (!((shouldRetryBasedOnResult(context, previousThrowable, previousResponse)
        || shouldRetryBasedOnBigQueryRetryConfig(
            previousThrowable,
            bigQueryRetryConfig)))) { // Calling shouldRetryBasedOnBigQueryRetryConfig to check if
      // the error message could be retried
      return null;
    }

    TimedAttemptSettings newSettings =
        createNextAttemptBasedOnResult(
            context, previousThrowable, previousResponse, previousSettings);
    if (newSettings == null) {
      newSettings = createNextAttemptBasedOnTiming(context, previousSettings);
    }
    return newSettings;
  }

  /*Duplicating this method as it can not be inherited from the RetryAlgorithm due to the private access modifier*/
  private TimedAttemptSettings createNextAttemptBasedOnResult(
      RetryingContext context,
      Throwable previousThrowable,
      ResponseT previousResponse,
      TimedAttemptSettings previousSettings) {
    if (resultAlgorithmWithContext != null && context != null) {
      return resultAlgorithmWithContext.createNextAttempt(
          context, previousThrowable, previousResponse, previousSettings);
    }
    return getResultAlgorithm()
        .createNextAttempt(previousThrowable, previousResponse, previousSettings);
  }

  /*Duplicating this method as it can not be inherited from the RetryAlgorithm due to the private access modifier*/
  private TimedAttemptSettings createNextAttemptBasedOnTiming(
      RetryingContext context, TimedAttemptSettings previousSettings) {
    if (timedAlgorithmWithContext != null && context != null) {
      return timedAlgorithmWithContext.createNextAttempt(context, previousSettings);
    }
    return getTimedAlgorithm().createNextAttempt(previousSettings);
  }
}
