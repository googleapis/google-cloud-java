/*
 * Copyright 2018 Google LLC
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
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.DeadlineExceededException;
import org.threeten.bp.Duration;

/** For internal use, public for technical reasons. */
@InternalApi
public class ApiResultRetryAlgorithm<ResponseT> implements ResultRetryAlgorithm<ResponseT> {
  // Duration to sleep on if the error is DEADLINE_EXCEEDED.
  public static final Duration DEADLINE_SLEEP_DURATION = Duration.ofMillis(1);

  @Override
  public TimedAttemptSettings createNextAttempt(
      Throwable prevThrowable, ResponseT prevResponse, TimedAttemptSettings prevSettings) {
    if (prevThrowable != null && prevThrowable instanceof DeadlineExceededException) {
      return TimedAttemptSettings.newBuilder()
          .setGlobalSettings(prevSettings.getGlobalSettings())
          .setRetryDelay(prevSettings.getRetryDelay())
          .setRpcTimeout(prevSettings.getRpcTimeout())
          .setRandomizedRetryDelay(DEADLINE_SLEEP_DURATION)
          .setAttemptCount(prevSettings.getAttemptCount() + 1)
          .setFirstAttemptStartTimeNanos(prevSettings.getFirstAttemptStartTimeNanos())
          .build();
    }
    return null;
  }

  @Override
  public boolean shouldRetry(Throwable prevThrowable, ResponseT prevResponse) {
    return (prevThrowable instanceof ApiException) && ((ApiException) prevThrowable).isRetryable();
  }
}
