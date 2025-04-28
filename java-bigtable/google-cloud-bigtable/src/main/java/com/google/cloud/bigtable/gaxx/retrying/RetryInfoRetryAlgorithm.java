/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.gaxx.retrying;

import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.retrying.RetryingContext;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.ApiException;
import com.google.protobuf.util.Durations;
import com.google.rpc.RetryInfo;
import javax.annotation.Nullable;

// TODO move this algorithm to gax
/**
 * This retry algorithm checks the metadata of an exception for additional error details. If the
 * metadata has a RetryInfo field, use the retry delay to set the wait time between attempts.
 */
@InternalApi
public class RetryInfoRetryAlgorithm<ResponseT> extends BasicResultRetryAlgorithm<ResponseT> {

  @Override
  public TimedAttemptSettings createNextAttempt(
      Throwable prevThrowable, ResponseT prevResponse, TimedAttemptSettings prevSettings) {
    java.time.Duration retryDelay = extractRetryDelay(prevThrowable);
    if (retryDelay != null) {
      return prevSettings.toBuilder()
          .setRetryDelayDuration(retryDelay)
          .setRandomizedRetryDelayDuration(retryDelay)
          .setAttemptCount(prevSettings.getAttemptCount() + 1)
          .setOverallAttemptCount(prevSettings.getAttemptCount() + 1)
          .build();
    }
    return null;
  }

  /** Returns true if previousThrowable is an {@link ApiException} that is retryable. */
  @Override
  public boolean shouldRetry(Throwable previousThrowable, ResponseT previousResponse) {
    return shouldRetry(null, previousThrowable, previousResponse);
  }

  /**
   * If {@link RetryingContext#getRetryableCodes()} is not null: Returns true if the status code of
   * previousThrowable is in the list of retryable code of the {@link RetryingContext}.
   *
   * <p>Otherwise it returns the result of {@link #shouldRetry(Throwable, Object)}.
   */
  @Override
  public boolean shouldRetry(
      @Nullable RetryingContext context, Throwable previousThrowable, ResponseT previousResponse) {
    if (extractRetryDelay(previousThrowable) != null) {
      // First check if server wants us to retry
      return true;
    }
    if (context != null && context.getRetryableCodes() != null) {
      // Ignore the isRetryable() value of the throwable if the RetryingContext has a specific list
      // of codes that should be retried.
      return ((previousThrowable instanceof ApiException)
          && context
              .getRetryableCodes()
              .contains(((ApiException) previousThrowable).getStatusCode().getCode()));
    }
    // Server didn't have retry information and there's no retry context, use the local status
    // code config.
    return previousThrowable instanceof ApiException
        && ((ApiException) previousThrowable).isRetryable();
  }

  static java.time.Duration extractRetryDelay(@Nullable Throwable throwable) {
    if (throwable == null) {
      return null;
    }
    if (!(throwable instanceof ApiException)) {
      return null;
    }
    ApiException exception = (ApiException) throwable;
    if (exception.getErrorDetails() == null) {
      return null;
    }
    if (exception.getErrorDetails().getRetryInfo() == null) {
      return null;
    }
    RetryInfo retryInfo = exception.getErrorDetails().getRetryInfo();
    return java.time.Duration.ofMillis(Durations.toMillis(retryInfo.getRetryDelay()));
  }
}
