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
package com.google.api.gax.grpc;

import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.common.base.Preconditions;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.Status;
import java.util.concurrent.CancellationException;

/**
 * Wraps a GRPC ClientCall in a {@link StreamController}. It feeds events to a {@link
 * ResponseObserver} and allows for back pressure.
 *
 * <p>Package-private for internal use.
 */
class GrpcDirectStreamController<RequestT, ResponseT> implements StreamController {
  private static final Runnable NOOP_RUNNABLE =
      new Runnable() {
        @Override
        public void run() {}
      };

  private final ClientCall<RequestT, ResponseT> clientCall;
  private final ResponseObserver<ResponseT> responseObserver;
  private final Runnable onReady;
  private volatile boolean hasStarted;
  private boolean autoflowControl = true;
  private int numRequested;
  private volatile CancellationException cancellationException;

  GrpcDirectStreamController(
      ClientCall<RequestT, ResponseT> clientCall, ResponseObserver<ResponseT> responseObserver) {
    this(clientCall, responseObserver, NOOP_RUNNABLE);
  }

  GrpcDirectStreamController(
      ClientCall<RequestT, ResponseT> clientCall,
      ResponseObserver<ResponseT> responseObserver,
      Runnable onReady) {
    this.clientCall = clientCall;
    this.responseObserver = responseObserver;
    this.onReady = onReady;
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

  void start(RequestT request) {
    startCommon();
    clientCall.sendMessage(request);
    clientCall.halfClose();
  }

  void startBidi() {
    startCommon();
  }

  private void startCommon() {
    responseObserver.onStart(this);

    clientCall.start(new ResponseObserverAdapter(), new Metadata());

    this.hasStarted = true;

    if (autoflowControl) {
      clientCall.request(1);
    } else if (numRequested > 0) {
      clientCall.request(numRequested);
    }
  }

  private class ResponseObserverAdapter extends ClientCall.Listener<ResponseT> {
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
    public void onClose(Status status, Metadata trailers) {
      if (status.isOk()) {
        responseObserver.onComplete();
      } else if (cancellationException != null) {
        // Intercept cancellations and replace with the top level cause
        responseObserver.onError(cancellationException);
      } else {
        responseObserver.onError(status.asRuntimeException(trailers));
      }
    }

    @Override
    public void onReady() {
      onReady.run();
    }
  }
}
