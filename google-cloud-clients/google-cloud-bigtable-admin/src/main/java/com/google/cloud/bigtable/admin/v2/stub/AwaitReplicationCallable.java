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
import com.google.bigtable.admin.v2.TableName;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

/**
 * Callable that waits until replication has caught up to the point it was called.
 *
 * <p>This callable wraps GenerateConsistencyToken and CheckConsistency RPCs. It will generate a
 * token then poll until isConsistent is true.
 */
class AwaitReplicationCallable extends UnaryCallable<TableName, Void> {
  private final UnaryCallable<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse> generateCallable;
  private final UnaryCallable<CheckConsistencyRequest, CheckConsistencyResponse> checkCallable;
  private final RetryingExecutor<CheckConsistencyResponse> executor;

  static AwaitReplicationCallable create(
      UnaryCallable<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse> generateCallable,
      UnaryCallable<CheckConsistencyRequest, CheckConsistencyResponse> checkCallable,
      ClientContext clientContext,
      RetrySettings pollingSettings) {

    RetryAlgorithm<CheckConsistencyResponse> retryAlgorithm = new RetryAlgorithm<>(
        new PollResultAlgorithm(),
        new ExponentialPollAlgorithm(pollingSettings, clientContext.getClock())
    );

    RetryingExecutor<CheckConsistencyResponse> retryingExecutor = new ScheduledRetryingExecutor<>(
        retryAlgorithm,
        clientContext.getExecutor()
    );

    return new AwaitReplicationCallable(
        generateCallable,
        checkCallable,
        retryingExecutor
    );
  }

  @VisibleForTesting
  AwaitReplicationCallable(
      UnaryCallable<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse> generateCallable,
      UnaryCallable<CheckConsistencyRequest, CheckConsistencyResponse> checkCallable,
      RetryingExecutor<CheckConsistencyResponse> executor) {
    this.generateCallable = generateCallable;
    this.checkCallable = checkCallable;
    this.executor = executor;
  }

  @Override
  public ApiFuture<Void> futureCall(final TableName tableName, final ApiCallContext context) {
    ApiFuture<GenerateConsistencyTokenResponse> tokenFuture = generateToken(tableName, context);

    return ApiFutures.transformAsync(
        tokenFuture,
        new ApiAsyncFunction<GenerateConsistencyTokenResponse, Void>() {
          @Override
          public ApiFuture<Void> apply(GenerateConsistencyTokenResponse input) {
            CheckConsistencyRequest request = CheckConsistencyRequest.newBuilder()
                .setName(tableName.toString())
                .setConsistencyToken(input.getConsistencyToken())
                .build();

            return pollToken(request, context);
          }
        },
        MoreExecutors.directExecutor()
    );
  }

  private ApiFuture<GenerateConsistencyTokenResponse> generateToken(TableName tableName,
      ApiCallContext context) {
    GenerateConsistencyTokenRequest generateRequest = GenerateConsistencyTokenRequest.newBuilder()
        .setName(tableName.toString())
        .build();
    return generateCallable.futureCall(generateRequest, context);
  }

  private ApiFuture<Void> pollToken(CheckConsistencyRequest request, ApiCallContext context) {
    AttemptCallable<CheckConsistencyRequest, CheckConsistencyResponse> attemptCallable =
        new AttemptCallable<>(checkCallable, request, context);
    RetryingFuture<CheckConsistencyResponse> retryingFuture = executor
        .createFuture(attemptCallable);
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
        MoreExecutors.directExecutor()
    );
  }

  /**
   * A callable representing an attempt to make an RPC call.
   */
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
  private static class PollResultAlgorithm implements
      ResultRetryAlgorithm<CheckConsistencyResponse> {
    @Override
    public TimedAttemptSettings createNextAttempt(Throwable prevThrowable,
        CheckConsistencyResponse prevResponse, TimedAttemptSettings prevSettings) {
      return null;
    }

    @Override
    public boolean shouldRetry(Throwable prevThrowable, CheckConsistencyResponse prevResponse)
        throws CancellationException {
      return prevResponse != null && !prevResponse.getConsistent();
    }
  }
}
