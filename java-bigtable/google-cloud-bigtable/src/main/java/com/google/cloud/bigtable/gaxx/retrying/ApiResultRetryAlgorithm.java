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
import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.retrying.RetryingContext;
import com.google.api.gax.rpc.ApiException;

/** For internal use, public for technical reasons. */
@InternalApi
public class ApiResultRetryAlgorithm<ResponseT> extends BasicResultRetryAlgorithm<ResponseT> {

  /** Returns true if previousThrowable is an {@link ApiException} that is retryable. */
  @Override
  public boolean shouldRetry(Throwable previousThrowable, ResponseT previousResponse) {
    return (previousThrowable instanceof ApiException)
        && ((ApiException) previousThrowable).isRetryable();
  }

  /**
   * If {@link RetryingContext#getRetryableCodes()} is not null: Returns true if the status code of
   * previousThrowable is in the list of retryable code of the {@link RetryingContext}.
   *
   * <p>Otherwise it returns the result of {@link #shouldRetry(Throwable, Object)}.
   */
  @Override
  public boolean shouldRetry(
      RetryingContext context, Throwable previousThrowable, ResponseT previousResponse) {
    if (context.getRetryableCodes() != null) {
      // Ignore the isRetryable() value of the throwable if the RetryingContext has a specific list
      // of codes that should be retried.
      return (previousThrowable instanceof ApiException)
          && context
              .getRetryableCodes()
              .contains(((ApiException) previousThrowable).getStatusCode().getCode());
    }
    return shouldRetry(previousThrowable, previousResponse);
  }
}
