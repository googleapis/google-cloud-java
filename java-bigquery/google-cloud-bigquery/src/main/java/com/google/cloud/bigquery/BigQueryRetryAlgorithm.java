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
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.time.Duration;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class BigQueryRetryAlgorithm<ResponseT> extends RetryAlgorithm<ResponseT> {
  private final BigQueryRetryConfig bigQueryRetryConfig;
  private final ResultRetryAlgorithm<ResponseT> resultAlgorithm;
  private final TimedRetryAlgorithm timedAlgorithm;
  private final ResultRetryAlgorithmWithContext<ResponseT> resultAlgorithmWithContext;
  private final TimedRetryAlgorithmWithContext timedAlgorithmWithContext;

  private static final Logger LOG = Logger.getLogger(BigQueryRetryAlgorithm.class.getName());
  private static final UUID RETRY_UUID = UUID.randomUUID();

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
    // Log retry info
    int attemptCount = nextAttemptSettings == null ? 0 : nextAttemptSettings.getAttemptCount();
    Duration retryDelay =
        nextAttemptSettings == null ? Duration.ZERO : nextAttemptSettings.getRetryDelayDuration();
    String errorMessage = previousThrowable != null ? previousThrowable.getMessage() : "";

    // Implementing shouldRetryBasedOnBigQueryRetryConfig so that we can retry exceptions based on
    // the exception messages
    boolean shouldRetry =
        (shouldRetryBasedOnResult(context, previousThrowable, previousResponse)
                || shouldRetryBasedOnBigQueryRetryConfig(
                    previousThrowable, bigQueryRetryConfig, previousResponse))
            && shouldRetryBasedOnTiming(context, nextAttemptSettings);

    if (LOG.isLoggable(Level.FINEST)) {
      LOG.log(
          Level.FINEST,
          "Retrying with:\n{0}\n{1}\n{2}\n{3}\n{4}\n{5}",
          new Object[] {
            "BigQuery attemptCount: " + attemptCount,
            "BigQuery delay: " + retryDelay,
            "BigQuery retriableException: " + previousThrowable,
            "BigQuery shouldRetry: " + shouldRetry,
            "BigQuery previousThrowable.getMessage: " + errorMessage,
            "BigQuery retry identifier: " + RETRY_UUID
          });
    }
    return shouldRetry;
  }

  private boolean shouldRetryBasedOnBigQueryRetryConfig(
      Throwable previousThrowable,
      BigQueryRetryConfig bigQueryRetryConfig,
      ResponseT previousResponse) {
    /*
    We are deciding if a given error should be retried on the basis of error message.
    Cannot rely on Error/Status code as for example error code 400 (which is not retriable) could be thrown due to rateLimitExceed, which is retriable
     */
    String errorDesc = null;
    if (previousThrowable != null) {
      errorDesc = previousThrowable.getMessage();
    } else if (previousResponse != null) {
      /*
      In some cases error messages may come without an exception
      e.g. status code 200 with a rate limit exceeded for job create
      in these cases there is no previousThrowable so we need
      to check for error messages in previousResponse
       */
      errorDesc = getErrorDescFromResponse(previousResponse);
    }

    if (errorDesc != null) {
      errorDesc = errorDesc.toLowerCase(); // for case insensitive comparison
      for (Iterator<String> retriableMessages =
              bigQueryRetryConfig.getRetriableErrorMessages().iterator();
          retriableMessages.hasNext(); ) {
        if (errorDesc.contains(
            retriableMessages
                .next()
                .toLowerCase())) { // Error message should be retried, implementing cases
          // insensitive match
          return true;
        }
      }
      // Check if there's a regex which matches the error message. This avoids too many regex
      // matches which is expensive
      for (Iterator<String> retriableRegExes = bigQueryRetryConfig.getRetriableRegExes().iterator();
          retriableRegExes.hasNext(); ) {
        if (matchRegEx(retriableRegExes.next(), errorDesc)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean matchRegEx(
      String retriableRegEx, String errorDesc) { // cases insensitive match regex matching
    return Pattern.matches(retriableRegEx.toLowerCase(), errorDesc.toLowerCase());
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
            bigQueryRetryConfig,
            previousResponse)))) { // Calling shouldRetryBasedOnBigQueryRetryConfig to check if
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

  private String getErrorDescFromResponse(ResponseT previousResponse) {
    /*
    error messages may come without an exception and must be extracted from response
    following logic based on response body of jobs.insert method, so far the only
    known case where a response with status code 200 may contain an error message
     */
    try {
      JsonObject responseJson =
          JsonParser.parseString(previousResponse.toString()).getAsJsonObject();
      if (responseJson.has("status") && responseJson.getAsJsonObject("status").has("errorResult")) {
        return responseJson
            .getAsJsonObject("status")
            .getAsJsonObject("errorResult")
            .get("message")
            .toString();
      } else {
        return null;
      }
    } catch (Exception e) {
      // exceptions here implies no error message present in response, returning null
      return null;
    }
  }
}
