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

/**
 * A UnaryCallable is an immutable object which is capable of making RPC calls to non-streaming API
 * methods.
 *
 * <p>In typical usage, the request to send to the remote service will not be bound to the
 * UnaryCallable, but instead is provided at call time, which allows for a UnaryCallable to be saved
 * and used indefinitely.
 *
 * <p>There are two styles of calls that can be made through a UnaryCallable: synchronous and
 * asynchronous.
 *
 * <p>Synchronous example:
 *
 * <pre>{@code
 * RequestType request = RequestType.newBuilder().build();
 * UnaryCallable<RequestType, ResponseType> unaryCallable = api.doSomethingCallable();
 * ResponseType response = unaryCallable.call();
 * }</pre>
 *
 * <p>Asynchronous example:
 *
 * <pre>{@code
 * RequestType request = RequestType.newBuilder().build();
 * UnaryCallable<RequestType, ResponseType> unaryCallable = api.doSomethingCallable();
 * ApiFuture<ResponseType> resultFuture = unaryCallable.futureCall();
 * // do other work
 * // ...
 * ResponseType response = resultFuture.get();
 * }</pre>
 *
 * <p>It is considered advanced usage for a user to create a UnaryCallable themselves. This class is
 * intended to be created by a generated client class, and configured by instances of
 * UnaryCallSettings.Builder which are exposed through the client settings class.
 */
public abstract class UnaryCallable<RequestT, ResponseT> {

  protected UnaryCallable() {}

  /**
   * Perform a call asynchronously.
   *
   * @param context {@link ApiCallContext} to make the call with
   * @return {@link ApiFuture} for the call result
   */
  public abstract ApiFuture<ResponseT> futureCall(RequestT request, ApiCallContext context);

  /**
   * Same as {@link #futureCall(Object, ApiCallContext)}, with a null context.
   *
   * @param request request
   * @return {@link ApiFuture} for the call result
   */
  public ApiFuture<ResponseT> futureCall(RequestT request) {
    return futureCall(request, null);
  }

  /**
   * Perform a call synchronously.
   *
   * @param request The request to send to the service.
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
   * @param request The request to send to the service.
   * @return the call result
   * @throws ApiException if there is any bad status in the response.
   * @throws RuntimeException if there is any other exception unrelated to bad status.
   */
  public ResponseT call(RequestT request) {
    return ApiExceptions.callAndTranslateApiException(futureCall(request));
  }

  /**
   * Returns a new {@code UnaryCallable} with an {@link ApiCallContext} that is used as a default
   * when none is supplied in individual calls.
   *
   * @param defaultCallContext the default {@link ApiCallContext}.
   */
  public UnaryCallable<RequestT, ResponseT> withDefaultCallContext(
      final ApiCallContext defaultCallContext) {
    return new UnaryCallable<RequestT, ResponseT>() {
      @Override
      public ApiFuture<ResponseT> futureCall(RequestT request, ApiCallContext thisCallContext) {
        return UnaryCallable.this.futureCall(request, defaultCallContext.merge(thisCallContext));
      }
    };
  }
}
