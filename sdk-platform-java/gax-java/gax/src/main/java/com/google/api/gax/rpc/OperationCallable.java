/*
 * Copyright 2017 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.api.gax.longrunning.OperationFuture;

/**
 * An OperationCallable is an immutable object which is capable of initiating RPC calls to
 * long-running API methods and returning an {@link OperationFuture} to manage the polling of the
 * Operation and getting the response.
 *
 * <p>It is considered advanced usage for a user to create an OperationCallable themselves. This
 * class is intended to be created by a generated client class, and configured by instances of
 * OperationCallSettings.Builder which are exposed through the client settings class.
 */
public abstract class OperationCallable<RequestT, ResponseT, MetadataT> {

  protected OperationCallable() {}

  /**
   * Initiates an operation asynchronously.
   *
   * @param request The request to initiate the operation.
   * @param context {@link ApiCallContext} to make the call with
   * @return {@link OperationFuture} for the call result
   */
  public abstract OperationFuture<ResponseT, MetadataT> futureCall(
      RequestT request, ApiCallContext context);

  /**
   * Same as {@link #futureCall(Object, ApiCallContext)}, with a null context.
   *
   * @param request request
   * @return {@link ApiFuture} for the call result
   */
  public OperationFuture<ResponseT, MetadataT> futureCall(RequestT request) {
    return futureCall(request, null);
  }

  /**
   * Perform a call synchronously.
   *
   * @param request The request to initiate the operation.
   * @param context {@link ApiCallContext} to make the call with
   * @return the call result
   * @throws ApiException if there is any bad status in the response.
   * @throws RuntimeException if there is any other exception unrelated to bad status.
   */
  public ResponseT call(RequestT request, ApiCallContext context) {
    return ApiExceptions.callAndTranslateApiException(futureCall(request, context));
  }

  /**
   * Same as {@link #call(Object, ApiCallContext)}, with a null context.
   *
   * @param request The request to initiate the operation.
   * @return the call result
   * @throws ApiException if there is any bad status in the response.
   * @throws RuntimeException if there is any other exception unrelated to bad status.
   */
  public ResponseT call(RequestT request) {
    return ApiExceptions.callAndTranslateApiException(futureCall(request));
  }

  /**
   * Creates a new {@link OperationFuture} to watch an operation that has been initiated previously.
   * Note: This is not type-safe at static time; the result type can only be checked once the
   * operation finishes.
   *
   * @param operationName The name of the operation to resume.
   * @param context {@link ApiCallContext} to make the call with
   * @return {@link OperationFuture} for the call result.
   */
  public abstract OperationFuture<ResponseT, MetadataT> resumeFutureCall(
      String operationName, ApiCallContext context);

  /**
   * Creates a new {@link OperationFuture} to watch an operation that has been initiated previously.
   * Note: This is not type-safe at static time; the result type can only be checked once the
   * operation finishes.
   *
   * @param operationName The name of the operation to resume.
   * @return {@link OperationFuture} for the call result.
   */
  public OperationFuture<ResponseT, MetadataT> resumeFutureCall(String operationName) {
    return resumeFutureCall(operationName, null);
  }

  /**
   * Sends a cancellation request to the server for the operation with name {@code operationName}.
   *
   * @param operationName The name of the operation to cancel.
   * @param context {@link ApiCallContext} to make the call with
   * @return the future which completes once the operation is canceled on the server side.
   */
  public abstract ApiFuture<Void> cancel(String operationName, ApiCallContext context);

  /**
   * Sends a cancellation request to the server for the operation with name {@code operationName}.
   *
   * @param operationName The name of the operation to cancel.
   * @return the future which completes once the operation is canceled on the server side.
   */
  public ApiFuture<Void> cancel(String operationName) {
    return cancel(operationName, null);
  }

  /**
   * Returns a new {@code OperationCallable} with an {@link ApiCallContext} that is used as a
   * default when none is supplied in individual calls.
   *
   * @param defaultCallContext the default {@link ApiCallContext}.
   */
  public OperationCallable<RequestT, ResponseT, MetadataT> withDefaultCallContext(
      final ApiCallContext defaultCallContext) {
    return new OperationCallable<RequestT, ResponseT, MetadataT>() {
      @Override
      public OperationFuture<ResponseT, MetadataT> futureCall(
          RequestT request, ApiCallContext thisCallContext) {
        return OperationCallable.this.futureCall(
            request, defaultCallContext.merge(thisCallContext));
      }

      @Override
      public OperationFuture<ResponseT, MetadataT> resumeFutureCall(
          String operationName, ApiCallContext thisCallContext) {
        return OperationCallable.this.resumeFutureCall(
            operationName, defaultCallContext.merge(thisCallContext));
      }

      @Override
      public ApiFuture<Void> cancel(String operationName, ApiCallContext thisCallContext) {
        return OperationCallable.this.cancel(
            operationName, defaultCallContext.merge(thisCallContext));
      }
    };
  }
}
