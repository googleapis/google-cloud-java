/*
 * Copyright 2022 Google LLC
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
package com.google.api.gax.httpjson;

import com.google.api.core.AbstractApiFuture;
import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * {@code HttpJsonClientCalls} creates a new {@code HttpJsonClientCall} from the given call context.
 *
 * <p>Package-private for internal use.
 */
class HttpJsonClientCalls {
  private static final Logger LOGGER = Logger.getLogger(HttpJsonClientCalls.class.getName());

  public static <RequestT, ResponseT> HttpJsonClientCall<RequestT, ResponseT> newCall(
      ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor, ApiCallContext context) {

    HttpJsonCallContext httpJsonContext = HttpJsonCallContext.createDefault().nullToSelf(context);

    // Use the context's timeout instead of calculating a future deadline with the System clock.
    // The timeout value is calculated from TimedAttemptSettings which accounts for the
    // TotalTimeout value set in the RetrySettings.
    if (httpJsonContext.getTimeoutDuration() != null) {
      HttpJsonCallOptions callOptions = httpJsonContext.getCallOptions();
      // HttpJsonChannel expects the HttpJsonCallOptions and we store the timeout duration
      // inside the HttpJsonCallOptions
      // Note: There is manual conversion between threetenbp's Duration and java.util.Duration
      // This is temporary here as we plan to migrate to java.util.Duration
      if (callOptions.getTimeoutDuration() == null
          || httpJsonContext
                  .getTimeoutDuration()
                  .compareTo(
                      java.time.Duration.ofMillis(callOptions.getTimeoutDuration().toMillis()))
              < 0) {
        callOptions =
            callOptions.toBuilder()
                .setTimeoutDuration(
                    java.time.Duration.ofMillis(httpJsonContext.getTimeoutDuration().toMillis()))
                .build();
      }
      httpJsonContext = httpJsonContext.withCallOptions(callOptions);
    }

    // Validate the Universe Domain prior to the call. Only allow the call to go through
    // if the Universe Domain is valid.
    httpJsonContext.validateUniverseDomain();

    // TODO: add headers interceptor logic
    return httpJsonContext.getChannel().newCall(methodDescriptor, httpJsonContext.getCallOptions());
  }

  static <RequestT, ResponseT> ApiFuture<ResponseT> futureUnaryCall(
      HttpJsonClientCall<RequestT, ResponseT> clientCall,
      RequestT request,
      HttpJsonCallContext context) {
    // Start the call
    HttpJsonFuture<ResponseT> future = new HttpJsonFuture<>(clientCall);
    clientCall.start(
        new FutureListener<>(future),
        HttpJsonMetadata.newBuilder().build().withHeaders(context.getExtraHeaders()));

    // Send the request
    try {
      clientCall.sendMessage(request);
      clientCall.halfClose();
      // Request an extra message to detect misconfigured servers
      clientCall.request(2);
    } catch (Throwable sendError) {
      // Cancel if anything goes wrong
      try {
        clientCall.cancel(null, sendError);
      } catch (Throwable cancelError) {
        LOGGER.log(Level.SEVERE, "Error encountered while closing it", sendError);
      }

      throw sendError;
    }

    return future;
  }

  private static class HttpJsonFuture<T> extends AbstractApiFuture<T> {
    private final HttpJsonClientCall<?, T> call;

    private HttpJsonFuture(HttpJsonClientCall<?, T> call) {
      this.call = call;
    }

    @Override
    protected void interruptTask() {
      call.cancel("HttpJsonFuture was cancelled", null);
    }

    @Override
    public boolean set(T value) {
      return super.set(value);
    }

    @Override
    public boolean setException(Throwable throwable) {
      return super.setException(throwable);
    }
  }

  private static class FutureListener<T> extends HttpJsonClientCall.Listener<T> {
    private final HttpJsonFuture<T> future;
    private T message;
    private boolean isMessageReceived;

    private FutureListener(HttpJsonFuture<T> future) {
      this.future = future;
      this.isMessageReceived = false;
    }

    @Override
    public void onMessage(T message) {
      if (isMessageReceived) {
        throw new IllegalStateException("More than one value received for unary call");
      }
      isMessageReceived = true;
      this.message = message;
    }

    @Override
    public void onClose(int statusCode, HttpJsonMetadata trailers) {
      if (!isMessageReceived) {
        if (trailers == null || trailers.getException() == null) {
          future.setException(
              new HttpJsonStatusRuntimeException(
                  statusCode,
                  "Exception during a client call closure",
                  new NullPointerException(
                      "Both response message and response exception were null")));
        } else {
          future.setException(trailers.getException());
        }
      } else {
        future.set(message);
      }
    }
  }
}
