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
package com.google.cloud.bigtable.admin.v2.stub;

import com.google.api.core.ApiAsyncFunction;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.retrying.ExponentialPollAlgorithm;
import com.google.api.gax.retrying.NonCancellableFuture;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.RetryingExecutor;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.retrying.ScheduledRetryingExecutor;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.admin.v2.CheckConsistencyRequest;
import com.google.bigtable.admin.v2.CheckConsistencyResponse;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import com.google.cloud.bigtable.admin.v2.models.ConsistencyRequest;
import com.google.cloud.bigtable.data.v2.internal.TableAdminRequestContext;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

/**
 * Callable that waits until either replication or Data Boost has caught up to the point it was
 * called.
 *
 * <p>This callable wraps GenerateConsistencyToken and CheckConsistency RPCs. It will generate a
 * token then poll until isConsistent is true.
 */
class AwaitConsistencyCallable extends UnaryCallable<ConsistencyRequest, Void> {
  private final UnaryCallable<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
      generateCallable;
  private final UnaryCallable<CheckConsistencyRequest, CheckConsistencyResponse> checkCallable;
  private final RetryingExecutor<CheckConsistencyResponse> executor;

  private final TableAdminRequestContext requestContext;

  static AwaitConsistencyCallable create(
      UnaryCallable<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
          generateCallable,
      UnaryCallable<CheckConsistencyRequest, CheckConsistencyResponse> checkCallable,
      ClientContext clientContext,
      RetrySettings pollingSettings,
      TableAdminRequestContext requestContext) {

    RetryAlgorithm<CheckConsistencyResponse> retryAlgorithm =
        new RetryAlgorithm<>(
            new PollResultAlgorithm(),
            new ExponentialPollAlgorithm(pollingSettings, clientContext.getClock()));

    RetryingExecutor<CheckConsistencyResponse> retryingExecutor =
        new ScheduledRetryingExecutor<>(retryAlgorithm, clientContext.getExecutor());

    return new AwaitConsistencyCallable(
        generateCallable, checkCallable, retryingExecutor, requestContext);
  }

  @VisibleForTesting
  AwaitConsistencyCallable(
      UnaryCallable<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
          generateCallable,
      UnaryCallable<CheckConsistencyRequest, CheckConsistencyResponse> checkCallable,
      RetryingExecutor<CheckConsistencyResponse> executor,
      TableAdminRequestContext requestContext) {
    this.generateCallable = generateCallable;
    this.checkCallable = checkCallable;
    this.executor = executor;
    this.requestContext = requestContext;
  }

  @Override
  public ApiFuture<Void> futureCall(
      final ConsistencyRequest consistencyRequest, final ApiCallContext apiCallContext) {

    // If the token is already provided, skip generation and poll directly.
    if (consistencyRequest.getConsistencyToken() != null) {
      CheckConsistencyRequest request =
          consistencyRequest.toCheckConsistencyProto(
              requestContext, consistencyRequest.getConsistencyToken());
      return pollToken(request, apiCallContext);
    }

    ApiFuture<GenerateConsistencyTokenResponse> tokenFuture =
        generateToken(consistencyRequest.toGenerateTokenProto(requestContext), apiCallContext);

    return ApiFutures.transformAsync(
        tokenFuture,
        new ApiAsyncFunction<GenerateConsistencyTokenResponse, Void>() {
          @Override
          public ApiFuture<Void> apply(GenerateConsistencyTokenResponse input) {
            CheckConsistencyRequest request =
                consistencyRequest.toCheckConsistencyProto(
                    requestContext, input.getConsistencyToken());
            return pollToken(request, apiCallContext);
          }
        },
        MoreExecutors.directExecutor());
  }

  private ApiFuture<GenerateConsistencyTokenResponse> generateToken(
      GenerateConsistencyTokenRequest generateRequest, ApiCallContext context) {
    return generateCallable.futureCall(generateRequest, context);
  }

  private ApiFuture<Void> pollToken(CheckConsistencyRequest request, ApiCallContext context) {
    AttemptCallable<CheckConsistencyRequest, CheckConsistencyResponse> attemptCallable =
        new AttemptCallable<>(checkCallable, request, context);
    RetryingFuture<CheckConsistencyResponse> retryingFuture =
        executor.createFuture(attemptCallable);
    attemptCallable.setExternalFuture(retryingFuture);
    attemptCallable.call();

    return ApiFutures.transform(
        retryingFuture,
        new ApiFunction<CheckConsistencyResponse, Void>() {
          @Override
          public Void apply(CheckConsistencyResponse input) {
            return null;
          }
        },
        MoreExecutors.directExecutor());
  }

  /** A callable representing an attempt to make an RPC call. */
  private static class AttemptCallable<RequestT, ResponseT> implements Callable<ResponseT> {
    private final UnaryCallable<RequestT, ResponseT> callable;
    private final RequestT request;

    private volatile RetryingFuture<ResponseT> externalFuture;
    private volatile ApiCallContext callContext;

    AttemptCallable(
        UnaryCallable<RequestT, ResponseT> callable, RequestT request, ApiCallContext callContext) {
      this.callable = callable;
      this.request = request;
      this.callContext = callContext;
    }

    void setExternalFuture(RetryingFuture<ResponseT> externalFuture) {
      this.externalFuture = externalFuture;
    }

    @Override
    public ResponseT call() {
      try {
        // NOTE: unlike gax's AttemptCallable, this ignores rpc timeouts
        externalFuture.setAttemptFuture(new NonCancellableFuture<ResponseT>());
        if (externalFuture.isDone()) {
          return null;
        }
        ApiFuture<ResponseT> internalFuture = callable.futureCall(request, callContext);
        externalFuture.setAttemptFuture(internalFuture);
      } catch (Throwable e) {
        externalFuture.setAttemptFuture(ApiFutures.<ResponseT>immediateFailedFuture(e));
      }

      return null;
    }
  }

  /**
   * A polling algorithm for waiting for a consistent {@link CheckConsistencyResponse}. Please note
   * that this class doesn't handle retryable errors and expects the underlying callable chain to
   * handle this.
   */
  private static class PollResultAlgorithm
      implements ResultRetryAlgorithm<CheckConsistencyResponse> {
    @Override
    public TimedAttemptSettings createNextAttempt(
        Throwable prevThrowable,
        CheckConsistencyResponse prevResponse,
        TimedAttemptSettings prevSettings) {
      return null;
    }

    @Override
    public boolean shouldRetry(Throwable prevThrowable, CheckConsistencyResponse prevResponse)
        throws CancellationException {
      return prevResponse != null && !prevResponse.getConsistent();
    }
  }
}
