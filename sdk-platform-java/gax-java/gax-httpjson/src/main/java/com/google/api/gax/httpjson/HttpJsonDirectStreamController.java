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

import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.common.base.Preconditions;
import java.util.concurrent.CancellationException;

/**
 * Wraps a HttpJsonClientCall in a {@link StreamController}. It feeds events to a {@link
 * ResponseObserver} and allows for back pressure.
 *
 * <p>Package-private for internal use.
 */
class HttpJsonDirectStreamController<RequestT, ResponseT> implements StreamController {
  private final HttpJsonClientCall<RequestT, ResponseT> clientCall;
  private final ResponseObserver<ResponseT> responseObserver;
  private volatile boolean hasStarted;
  private volatile boolean autoflowControl = true;
  private volatile int numRequested;
  private volatile CancellationException cancellationException;

  HttpJsonDirectStreamController(
      HttpJsonClientCall<RequestT, ResponseT> clientCall,
      ResponseObserver<ResponseT> responseObserver) {
    this.clientCall = clientCall;
    this.responseObserver = responseObserver;
  }

  @Override
  public void cancel() {
    cancellationException = new CancellationException("User cancelled stream");
    clientCall.cancel(null, cancellationException);
  }

  @Override
  public void disableAutoInboundFlowControl() {
    Preconditions.checkState(
        !hasStarted, "Can't disable automatic flow control after the stream has started.");
    autoflowControl = false;
  }

  @Override
  public void request(int count) {
    Preconditions.checkState(!autoflowControl, "Autoflow control is enabled.");

    // Buffer the requested count in case the consumer requested responses in the onStart()
    if (!hasStarted) {
      numRequested += count;
    } else {
      clientCall.request(count);
    }
  }

  void start(RequestT request, ApiCallContext context) {
    responseObserver.onStart(this);
    this.hasStarted = true;
    clientCall.start(
        new ResponseObserverAdapter(),
        HttpJsonMetadata.newBuilder().build().withHeaders(context.getExtraHeaders()));

    if (autoflowControl) {
      clientCall.request(1);
    } else if (numRequested > 0) {
      clientCall.request(numRequested);
    }

    clientCall.sendMessage(request);
  }

  private class ResponseObserverAdapter extends HttpJsonClientCall.Listener<ResponseT> {
    /**
     * Notifies the outerObserver of the new message and if automatic flow control is enabled,
     * requests the next message. Any errors raised by the outerObserver will be bubbled up to GRPC,
     * which cancel the ClientCall and close this listener.
     *
     * @param message The new message.
     */
    @Override
    public void onMessage(ResponseT message) {
      responseObserver.onResponse(message);

      if (autoflowControl) {
        clientCall.request(1);
      }
    }

    @Override
    public void onClose(int statusCode, HttpJsonMetadata trailers) {
      if (statusCode >= 200 && statusCode < 300) {
        responseObserver.onComplete();
      } else if (cancellationException != null) {
        // Intercept cancellations and replace with the top level cause
        responseObserver.onError(cancellationException);
      } else {
        responseObserver.onError(trailers.getException());
      }
    }
  }
}
