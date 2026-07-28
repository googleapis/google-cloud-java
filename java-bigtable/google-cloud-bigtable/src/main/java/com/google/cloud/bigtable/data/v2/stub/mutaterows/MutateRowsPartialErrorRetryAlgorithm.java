/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.mutaterows;

import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.ResultRetryAlgorithmWithContext;
import com.google.api.gax.retrying.RetryingContext;
import com.google.api.gax.retrying.TimedAttemptSettings;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * This algorithm will retry if there was a retryable failed mutation, or if there wasn't but the
 * underlying algorithm allows a retry.
 */
@InternalApi
public class MutateRowsPartialErrorRetryAlgorithm
    implements ResultRetryAlgorithmWithContext<MutateRowsAttemptResult> {
  private final ResultRetryAlgorithmWithContext<MutateRowsAttemptResult> retryAlgorithm;

  public MutateRowsPartialErrorRetryAlgorithm(
      ResultRetryAlgorithmWithContext<MutateRowsAttemptResult> retryAlgorithm) {
    this.retryAlgorithm = retryAlgorithm;
  }

  @Override
  public boolean shouldRetry(
      Throwable previousThrowable, MutateRowsAttemptResult previousResponse) {
    // handle partial retryable failures
    if (previousResponse != null && !previousResponse.getFailedMutations().isEmpty()) {
      return previousResponse.getIsRetryable();
    }
    // business as usual
    return retryAlgorithm.shouldRetry(previousThrowable, previousResponse);
  }

  @Override
  public boolean shouldRetry(
      @Nullable RetryingContext context,
      Throwable previousThrowable,
      MutateRowsAttemptResult previousResponse) {
    // handle partial retryable failures
    if (previousResponse != null && !previousResponse.getFailedMutations().isEmpty()) {
      return previousResponse.getIsRetryable();
    }
    // business as usual
    return retryAlgorithm.shouldRetry(context, previousThrowable, previousResponse);
  }

  @Override
  public TimedAttemptSettings createNextAttempt(
      Throwable previousThrowable,
      MutateRowsAttemptResult previousResponse,
      TimedAttemptSettings previousSettings) {
    return retryAlgorithm.createNextAttempt(previousThrowable, previousResponse, previousSettings);
  }

  @Override
  public TimedAttemptSettings createNextAttempt(
      RetryingContext context,
      Throwable previousThrowable,
      MutateRowsAttemptResult previousResponse,
      TimedAttemptSettings previousSettings) {
    return retryAlgorithm.createNextAttempt(
        context, previousThrowable, previousResponse, previousSettings);
  }
}
