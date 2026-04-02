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

import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ClientStreamReadyObserver;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.common.base.Preconditions;
import io.grpc.ClientCall;
import io.grpc.MethodDescriptor;

/**
 * {@code GrpcDirectBidiStreamingCallable} creates bidirectional streaming gRPC calls.
 *
 * <p>It is used to bridge the abstractions provided by gRPC and GAX.
 *
 * <p>Package-private for internal use.
 */
class GrpcDirectBidiStreamingCallable<RequestT, ResponseT>
    extends BidiStreamingCallable<RequestT, ResponseT> {
  private final MethodDescriptor<RequestT, ResponseT> descriptor;

  GrpcDirectBidiStreamingCallable(MethodDescriptor<RequestT, ResponseT> descriptor) {
    this.descriptor = Preconditions.checkNotNull(descriptor);
  }

  @Override
  public ClientStream<RequestT> internalCall(
      ResponseObserver<ResponseT> responseObserver,
      final ClientStreamReadyObserver<RequestT> onReady,
      ApiCallContext context) {
    Preconditions.checkNotNull(responseObserver);
    final ClientCall<RequestT, ResponseT> call = GrpcClientCalls.newCall(descriptor, context);
    final ClientStream<RequestT> clientStream =
        new ClientStream<RequestT>() {
          @Override
          public void send(RequestT request) {
            call.sendMessage(request);
          }

          @Override
          public void closeSendWithError(Throwable t) {
            call.cancel(null, t);
          }

          @Override
          public void closeSend() {
            call.halfClose();
          }

          @Override
          public boolean isSendReady() {
            return call.isReady();
          }
        };

    GrpcDirectStreamController<RequestT, ResponseT> controller =
        new GrpcDirectStreamController<>(
            call,
            responseObserver,
            new Runnable() {
              @Override
              public void run() {
                onReady.onReady(clientStream);
              }
            });
    controller.startBidi();

    return clientStream;
  }
}
