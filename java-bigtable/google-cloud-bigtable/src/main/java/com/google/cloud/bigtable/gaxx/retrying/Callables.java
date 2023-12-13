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
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.ScheduledRetryingExecutor;
import com.google.api.gax.retrying.StreamingRetryAlgorithm;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import java.util.Collection;

// TODO: remove this once ApiResultRetryAlgorithm is added to gax.
/**
 * Class with utility methods to create callable objects using provided settings.
 *
 * <p>The callable objects wrap a given direct callable with features like retry and exception
 * translation.
 */
@InternalApi
public class Callables {

  private Callables() {}

  public static <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> retrying(
      UnaryCallable<RequestT, ResponseT> innerCallable,
      UnaryCallSettings<?, ?> callSettings,
      ClientContext clientContext) {

    UnaryCallSettings<?, ?> settings = callSettings;

    if (areRetriesDisabled(settings.getRetryableCodes(), settings.getRetrySettings())) {
      // When retries are disabled, the total timeout can be treated as the rpc timeout.
      settings =
          settings
              .toBuilder()
              .setSimpleTimeoutNoRetries(settings.getRetrySettings().getTotalTimeout())
              .build();
    }

    RetryAlgorithm<ResponseT> retryAlgorithm =
        new RetryAlgorithm<>(
            new ApiResultRetryAlgorithm<ResponseT>(),
            new ExponentialRetryAlgorithm(settings.getRetrySettings(), clientContext.getClock()));
    ScheduledRetryingExecutor<ResponseT> retryingExecutor =
        new ScheduledRetryingExecutor<>(retryAlgorithm, clientContext.getExecutor());
    return new RetryingCallable<>(
        clientContext.getDefaultCallContext(), innerCallable, retryingExecutor);
  }

  public static <RequestT, ResponseT> ServerStreamingCallable<RequestT, ResponseT> retrying(
      ServerStreamingCallable<RequestT, ResponseT> innerCallable,
      ServerStreamingCallSettings<RequestT, ResponseT> callSettings,
      ClientContext clientContext) {

    ServerStreamingCallSettings<RequestT, ResponseT> settings = callSettings;
    if (areRetriesDisabled(settings.getRetryableCodes(), settings.getRetrySettings())) {
      // When retries are disabled, the total timeout can be treated as the rpc timeout.
      settings =
          settings
              .toBuilder()
              .setSimpleTimeoutNoRetries(settings.getRetrySettings().getTotalTimeout())
              .build();
    }

    StreamingRetryAlgorithm<Void> retryAlgorithm =
        new StreamingRetryAlgorithm<>(
            new ApiResultRetryAlgorithm<Void>(),
            new ExponentialRetryAlgorithm(settings.getRetrySettings(), clientContext.getClock()));

    ScheduledRetryingExecutor<Void> retryingExecutor =
        new ScheduledRetryingExecutor<>(retryAlgorithm, clientContext.getExecutor());

    return new RetryingServerStreamingCallable<>(
        innerCallable, retryingExecutor, settings.getResumptionStrategy());
  }

  private static boolean areRetriesDisabled(
      Collection<StatusCode.Code> retryableCodes, RetrySettings retrySettings) {
    return retrySettings.getMaxAttempts() == 1
        || retryableCodes.isEmpty()
        || (retrySettings.getMaxAttempts() == 0 && retrySettings.getTotalTimeout().isZero());
  }
}
