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
package com.google.cloud.bigtable.data.v2.stub.mutaterows;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsRequest.Builder;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.MutateRowsResponse.Entry;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException.FailedMutation;
import com.google.cloud.bigtable.gaxx.retrying.NonCancellableFuture;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.rpc.Code;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

// TODO: Try to generalize this using a BatchingDescriptor
/**
 * A stateful {@link Callable} that can be used with gax's {@link
 * com.google.api.gax.retrying.RetryingExecutor} and {@link RetryingFuture}.
 *
 * <p>For every {@link #call()}, it will:
 *
 * <ul>
 *   <li>Send the current request to the {@link #innerCallable}
 *   <li>On RPC completion it will inspect the response. If any entries failed (including the whole
 *       RPC), it will update its internal state so that the next {@link #call()} will only contain
 *       entries that have transient failures.
 * </ul>
 *
 * <p>Expected usage:
 *
 * <pre>{@code
 * MutateRowsAttemptCallable attemptCallable = new MutateRowsAttemptCallable(
 *   stub.mutateRowsCallable().all(),
 *   request,
 *   clientContext.getDefaultCallContext(),
 *   ImmutableSet.of(Code.UNAVAILABLE));
 *
 * RetryingExecutor<Void> retryingExecutor = ...;
 * RetryingFuture<Void> retryingFuture = retryingExecutor.createFuture(attemptCallable);
 * retryCallable.setExternalFuture(retryingFuture);
 * retryCallable.call();
 *
 * try {
 *   retryingFuture.get();
 * } catch(ExecutionException executionError) {
 *   MutateRowsException e = (MutateRowsException) executionError.getCause();
 *
 *   for (FailedMutation m : e.getFailedMutations() {
 *     // handle permanent failures
 *   }
 * }
 * }</pre>
 *
 * <p>Package-private for internal use.
 */
class MutateRowsAttemptCallable implements Callable<Void> {
  // Synthetic status for Mutations that didn't get a result (because the whole RPC failed). It will
  // be exposed in MutateRowsException's FailedMutations.
  private static final StatusCode LOCAL_UNKNOWN_STATUS =
      new StatusCode() {
        @Override
        public Code getCode() {
          return Code.UNKNOWN;
        }

        @Override
        public Object getTransportCode() {
          return null;
        }
      };

  // Everything needed to issue an RPC
  private final UnaryCallable<MutateRowsRequest, List<MutateRowsResponse>> innerCallable;
  private final ApiCallContext callContext;
  private MutateRowsRequest currentRequest;

  // Everything needed to build a retry request
  private List<Integer> originalIndexes;
  private final Set<StatusCode.Code> retryableCodes;
  private final List<FailedMutation> permanentFailures;

  // Parent controller
  private RetryingFuture<Void> externalFuture;

  // Simple wrappers for handling result futures
  private final ApiFunction<List<MutateRowsResponse>, Void> attemptSuccessfulCallback =
      new ApiFunction<List<MutateRowsResponse>, Void>() {
        @Override
        public Void apply(List<MutateRowsResponse> responses) {
          handleAttemptSuccess(responses);
          return null;
        }
      };

  private final ApiFunction<Throwable, List<MutateRowsResponse>> attemptFailedCallback =
      new ApiFunction<Throwable, List<MutateRowsResponse>>() {
        @Override
        public List<MutateRowsResponse> apply(Throwable throwable) {
          handleAttemptError(throwable);
          return null;
        }
      };

  MutateRowsAttemptCallable(
      @Nonnull UnaryCallable<MutateRowsRequest, List<MutateRowsResponse>> innerCallable,
      @Nonnull MutateRowsRequest originalRequest,
      @Nullable ApiCallContext callContext,
      @Nonnull Set<StatusCode.Code> retryableCodes) {
    this.innerCallable = Preconditions.checkNotNull(innerCallable);
    this.currentRequest = Preconditions.checkNotNull(originalRequest);
    this.callContext = callContext;
    this.retryableCodes = Preconditions.checkNotNull(retryableCodes);

    permanentFailures = Lists.newArrayList();
  }

  public void setExternalFuture(RetryingFuture<Void> externalFuture) {
    this.externalFuture = externalFuture;
  }

  /**
   * Send the current request and the parent {@link RetryingFuture} with this attempt's future.
   *
   * <p>On RPC completion this method will preprocess all errors (both RPC level and entry level)
   * and wrap them in a {@link MutateRowsException}. Please note that the results of the RPC are
   * only available in the attempt future that is set on the parent {@link RetryingFuture} and the
   * return of this method should just be ignored.
   */
  @Override
  public Void call() {
    try {
      Preconditions.checkNotNull(
          externalFuture, "External future must be set before starting an attempt");

      Preconditions.checkState(
          currentRequest.getEntriesCount() > 0, "Request doesn't have any mutations to send");

      // Configure the deadline
      ApiCallContext currentCallContext = null;
      if (callContext != null) {
        currentCallContext =
            callContext.withTimeout(externalFuture.getAttemptSettings().getRpcTimeout());
      }

      // Handle concurrent cancellation
      externalFuture.setAttemptFuture(new NonCancellableFuture<Void>());
      if (externalFuture.isDone()) {
        return null;
      }

      // Make the actual call
      ApiFuture<List<MutateRowsResponse>> innerFuture =
          innerCallable.futureCall(currentRequest, currentCallContext);

      // Handle RPC level errors by wrapping them in a MutateRowsException
      ApiFuture<List<MutateRowsResponse>> catching =
          ApiFutures.catching(innerFuture, Throwable.class, attemptFailedCallback);

      // Inspect the results and either propagate the success, or prepare to retry the failed
      // mutations
      ApiFuture<Void> transformed =
          ApiFutures.transform(catching, attemptSuccessfulCallback, MoreExecutors.directExecutor());

      // Notify the parent of the attempt
      externalFuture.setAttemptFuture(transformed);
    } catch (Throwable e) {
      externalFuture.setAttemptFuture(ApiFutures.<Void>immediateFailedFuture(e));
    }

    return null;
  }

  /**
   * Handle an RPC level failure by generating a {@link FailedMutation} for each expected entry. The
   * newly generated {@link FailedMutation}s will be combined with the permanentFailures to give the
   * caller the whole picture since the first call. This method will always throw a {@link
   * MutateRowsException}.
   */
  private void handleAttemptError(Throwable rpcError) {
    ApiException entryError = createSyntheticErrorForRpcFailure(rpcError);
    ImmutableList.Builder<FailedMutation> allFailures = ImmutableList.builder();
    MutateRowsRequest lastRequest = currentRequest;

    allFailures.addAll(permanentFailures);

    Builder builder = lastRequest.toBuilder().clearEntries();
    List<Integer> newOriginalIndexes = Lists.newArrayList();

    for (int i = 0; i < currentRequest.getEntriesCount(); i++) {
      int origIndex = getOriginalIndex(i);

      FailedMutation failedMutation = FailedMutation.create(origIndex, entryError);
      allFailures.add(failedMutation);

      if (!failedMutation.getError().isRetryable()) {
        permanentFailures.add(failedMutation);
      } else {
        // Schedule the mutation entry for the next RPC by adding it to the request builder and
        // recording its original index
        newOriginalIndexes.add(origIndex);
        builder.addEntries(lastRequest.getEntries(i));
      }
    }

    currentRequest = builder.build();
    originalIndexes = newOriginalIndexes;

    throw new MutateRowsException(rpcError, allFailures.build(), entryError.isRetryable());
  }

  /**
   * Handle entry level failures. All new response entries are inspected for failure. If any
   * transient failures are found, their corresponding mutations are scheduled for the next RPC. The
   * caller is notified of both new found errors and pre-existing permanent errors in the thrown
   * {@link MutateRowsException}. If no errors exist, then the attempt future is successfully
   * completed.
   */
  private void handleAttemptSuccess(List<MutateRowsResponse> responses) {
    List<FailedMutation> allFailures = Lists.newArrayList(permanentFailures);
    MutateRowsRequest lastRequest = currentRequest;

    Builder builder = lastRequest.toBuilder().clearEntries();
    List<Integer> newOriginalIndexes = Lists.newArrayList();

    for (MutateRowsResponse response : responses) {
      for (Entry entry : response.getEntriesList()) {
        if (entry.getStatus().getCode() == Code.OK_VALUE) {
          continue;
        }

        int origIndex = getOriginalIndex((int) entry.getIndex());

        FailedMutation failedMutation =
            FailedMutation.create(origIndex, createEntryError(entry.getStatus()));

        allFailures.add(failedMutation);

        if (!failedMutation.getError().isRetryable()) {
          permanentFailures.add(failedMutation);
        } else {
          // Schedule the mutation entry for the next RPC by adding it to the request builder and
          // recording it's original index
          newOriginalIndexes.add(origIndex);
          builder.addEntries(lastRequest.getEntries((int) entry.getIndex()));
        }
      }
    }

    currentRequest = builder.build();
    originalIndexes = newOriginalIndexes;

    if (!allFailures.isEmpty()) {
      boolean isRetryable = builder.getEntriesCount() > 0;
      throw new MutateRowsException(null, allFailures, isRetryable);
    }
  }

  /**
   * Remap the entry index in the current attempt back to its original index in the first request.
   */
  private int getOriginalIndex(int index) {
    return (originalIndexes != null) ? originalIndexes.get(index) : index;
  }

  /** Convert an entry's status from a protobuf to an {@link ApiException}. */
  private ApiException createEntryError(com.google.rpc.Status protoStatus) {
    io.grpc.Status grpcStatus =
        io.grpc.Status.fromCodeValue(protoStatus.getCode())
            .withDescription(protoStatus.getMessage());

    StatusCode gaxStatusCode = GrpcStatusCode.of(grpcStatus.getCode());

    return ApiExceptionFactory.createException(
        grpcStatus.asRuntimeException(),
        gaxStatusCode,
        retryableCodes.contains(gaxStatusCode.getCode()));
  }

  /**
   * Create a synthetic {@link ApiException} for an individual entry. When the entire RPC fails, it
   * implies that all entries failed as well. This helper is used to make that behavior explicit.
   * The generated exception will have the overall error as its cause.
   */
  private static ApiException createSyntheticErrorForRpcFailure(Throwable overallRequestError) {
    if (overallRequestError instanceof ApiException) {
      ApiException requestApiException = (ApiException) overallRequestError;

      return ApiExceptionFactory.createException(
          "Didn't receive a result for this mutation entry",
          overallRequestError,
          requestApiException.getStatusCode(),
          requestApiException.isRetryable());
    }

    return ApiExceptionFactory.createException(
        "Didn't receive a result for this mutation entry",
        overallRequestError,
        LOCAL_UNKNOWN_STATUS,
        false);
  }
}
