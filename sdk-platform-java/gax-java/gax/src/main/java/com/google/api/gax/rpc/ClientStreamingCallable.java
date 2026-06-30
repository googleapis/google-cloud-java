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

/**
 * A ClientStreamingCallable is an immutable object which is capable of making RPC calls to client
 * streaming API methods. Not all transports support streaming.
 *
 * <p>It is considered advanced usage for a user to create a ClientStreamingCallable themselves.
 * This class is intended to be created by a generated client class, and configured by instances of
 * StreamingCallSettings.Builder which are exposed through the client settings class.
 */
public abstract class ClientStreamingCallable<RequestT, ResponseT> {

  protected ClientStreamingCallable() {}

  /**
   * Conduct a client streaming call with the given {@link ApiCallContext}
   *
   * @param responseObserver {@link ApiStreamObserver} to receive the non-streaming response.
   * @param context {@link ApiCallContext} to provide context information for the RPC call.
   * @return {@link ApiStreamObserver} which is used for making streaming requests.
   */
  public abstract ApiStreamObserver<RequestT> clientStreamingCall(
      ApiStreamObserver<ResponseT> responseObserver, ApiCallContext context);

  /**
   * Conduct a client streaming call
   *
   * @param responseObserver {@link ApiStreamObserver} to receive the non-streaming response.
   * @return {@link ApiStreamObserver} which is used for making streaming requests.
   */
  public ApiStreamObserver<RequestT> clientStreamingCall(
      ApiStreamObserver<ResponseT> responseObserver) {
    return clientStreamingCall(responseObserver, null);
  }

  /**
   * Returns a new {@code ClientStreamingCallable} with an {@link ApiCallContext} that is used as a
   * default when none is supplied in individual calls.
   *
   * @param defaultCallContext the default {@link ApiCallContext}.
   */
  public ClientStreamingCallable<RequestT, ResponseT> withDefaultCallContext(
      final ApiCallContext defaultCallContext) {
    return new ClientStreamingCallable<RequestT, ResponseT>() {
      @Override
      public ApiStreamObserver<RequestT> clientStreamingCall(
          ApiStreamObserver<ResponseT> responseObserver, ApiCallContext thisCallContext) {
        return ClientStreamingCallable.this.clientStreamingCall(
            responseObserver, defaultCallContext.merge(thisCallContext));
      }
    };
  }
}
