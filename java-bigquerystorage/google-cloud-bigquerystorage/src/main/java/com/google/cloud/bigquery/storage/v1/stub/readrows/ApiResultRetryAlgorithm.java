/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.bigquery.storage.v1.stub.readrows;

import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.bigquery.storage.util.Errors;
import com.google.cloud.bigquery.storage.v1.BigQueryReadSettings;
import io.grpc.Metadata;
import io.grpc.Status;
import java.time.Duration;

/** For internal use, public for technical reasons. */
@InternalApi
public class ApiResultRetryAlgorithm<ResponseT> implements ResultRetryAlgorithm<ResponseT> {
  // Duration to sleep on if the error is DEADLINE_EXCEEDED.
  public static final Duration DEADLINE_SLEEP_DURATION = Duration.ofMillis(1);

  private final BigQueryReadSettings.RetryAttemptListener retryAttemptListener;

  public ApiResultRetryAlgorithm() {
    this(null);
  }

  public ApiResultRetryAlgorithm(BigQueryReadSettings.RetryAttemptListener retryAttemptListener) {
    super();
    this.retryAttemptListener = retryAttemptListener;
  }

  @Override
  public TimedAttemptSettings createNextAttempt(
      Throwable prevThrowable, ResponseT prevResponse, TimedAttemptSettings prevSettings) {
    if (prevThrowable != null) {
      Status status = Status.fromThrowable(prevThrowable);
      Metadata metadata = Status.trailersFromThrowable(prevThrowable);
      Errors.IsRetryableStatusResult result = Errors.isRetryableStatus(status, metadata);
      if (result.isRetryable) {
        // If result.retryDelay isn't null, we know exactly how long we must wait, so both regular
        // and randomized delays are the same.
        Duration retryDelay = result.retryDelay;
        Duration randomizedRetryDelay = result.retryDelay;
        if (retryDelay == null) {
          retryDelay = prevSettings.getRetryDelayDuration();
          randomizedRetryDelay = DEADLINE_SLEEP_DURATION;
        }
        if (retryAttemptListener != null) {
          retryAttemptListener.onRetryAttempt(status, metadata);
        }
        return TimedAttemptSettings.newBuilder()
            .setGlobalSettings(prevSettings.getGlobalSettings())
            .setRetryDelayDuration(retryDelay)
            .setRpcTimeout(prevSettings.getRpcTimeout())
            .setRandomizedRetryDelayDuration(randomizedRetryDelay)
            .setAttemptCount(prevSettings.getAttemptCount() + 1)
            .setFirstAttemptStartTimeNanos(prevSettings.getFirstAttemptStartTimeNanos())
            .build();
      }
    }
    return null;
  }

  @Override
  public boolean shouldRetry(Throwable prevThrowable, ResponseT prevResponse) {
    if (prevThrowable != null) {
      Status status = Status.fromThrowable(prevThrowable);
      Metadata metadata = Status.trailersFromThrowable(prevThrowable);
      if (Errors.isRetryableStatus(status, metadata).isRetryable) {
        return true;
      }
    }
    return (prevThrowable instanceof ApiException) && ((ApiException) prevThrowable).isRetryable();
  }
}
