/*
 * Copyright 2016 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.rpc;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationFutureImpl;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.retrying.RetryingExecutorWithContext;
import com.google.api.gax.retrying.RetryingFuture;

/**
 * An OperationCallableImpl is an immutable object which is capable of initiating RPC calls to
 * long-running API methods and returning a {@link OperationFuture} to manage the polling of the
 * Operation and getting the response.
 *
 * <p>Package-private for internal use.
 */
class OperationCallableImpl<RequestT, ResponseT, MetadataT>
    extends OperationCallable<RequestT, ResponseT, MetadataT> {

  private final UnaryCallable<RequestT, OperationSnapshot> initialCallable;
  private final RetryingExecutorWithContext<OperationSnapshot> executor;
  private final LongRunningClient longRunningClient;
  private final ApiFunction<OperationSnapshot, ResponseT> responseTransformer;
  private final ApiFunction<OperationSnapshot, MetadataT> metadataTransformer;

  OperationCallableImpl(
      UnaryCallable<RequestT, OperationSnapshot> initialCallable,
      RetryingExecutorWithContext<OperationSnapshot> executor,
      LongRunningClient longRunningClient,
      OperationCallSettings<RequestT, ResponseT, MetadataT> operationCallSettings) {
    this.initialCallable = checkNotNull(initialCallable);
    this.executor = checkNotNull(executor);
    this.longRunningClient = checkNotNull(longRunningClient);
    this.responseTransformer = operationCallSettings.getResponseTransformer();
    this.metadataTransformer = operationCallSettings.getMetadataTransformer();
  }

  /**
   * Initiates an operation asynchronously. If the {@link TransportChannel} encapsulated in the
   * given {@link ApiCallContext} is null, a channel must have already been bound at construction
   * time.
   *
   * @param request The request to initiate the operation.
   * @param callContext {@link ApiCallContext} to make the call with
   * @return {@link OperationFuture} for the call result
   */
  @Override
  public OperationFuture<ResponseT, MetadataT> futureCall(
      RequestT request, ApiCallContext callContext) {
    ApiFuture<OperationSnapshot> initialFuture = initialCallable.futureCall(request, callContext);
    return futureCall(initialFuture, callContext);
  }

  /** Waits for the initialFuture to resolve and then starts to poll the return operation. */
  OperationFutureImpl<ResponseT, MetadataT> futureCall(
      ApiFuture<OperationSnapshot> initialFuture, ApiCallContext callContext) {

    RecheckingCallable<RequestT, OperationSnapshot> callable =
        new RecheckingCallable<>(
            new OperationCheckingCallable<RequestT>(longRunningClient, initialFuture), executor);

    // NOTE: OperationCheckingCallable will compose its own request using the resolved
    // initialFuture. So the request parameter to futureCall is ignored
    RetryingFuture<OperationSnapshot> pollingFuture = callable.futureCall(null, callContext);
    return new OperationFutureImpl<>(
        pollingFuture, initialFuture, responseTransformer, metadataTransformer);
  }

  /**
   * Creates a new {@link OperationFuture} to watch an operation that has been initiated previously.
   * Note: This is not type-safe at static time; the result type can only be checked once the
   * operation finishes.
   *
   * @param operationName The name of the operation to resume.
   * @param callContext {@link ApiCallContext} to make the call with
   * @return {@link OperationFuture} for the call result.
   */
  @Override
  public OperationFuture<ResponseT, MetadataT> resumeFutureCall(
      String operationName, ApiCallContext callContext) {
    ApiFuture<OperationSnapshot> firstAttempt =
        longRunningClient.getOperationCallable().futureCall(operationName, callContext);
    return futureCall(firstAttempt, callContext);
  }

  /**
   * Sends a cancellation request to the server for the operation with name {@code operationName}.
   *
   * @param operationName The name of the operation to cancel.
   * @param callContext {@link ApiCallContext} to make the call with
   * @return the future which completes once the operation is canceled on the server side.
   */
  @Override
  public ApiFuture<Void> cancel(String operationName, ApiCallContext callContext) {
    return longRunningClient.cancelOperationCallable().futureCall(operationName, callContext);
  }
}
