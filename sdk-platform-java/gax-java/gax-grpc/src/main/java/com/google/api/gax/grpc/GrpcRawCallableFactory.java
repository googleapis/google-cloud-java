/*
 * Copyright 2020 Google LLC
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

import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnaryCallable;
import java.util.Set;

/** Class with utility methods to create low level grpc-based direct callables. */
@InternalApi("For internal use by google-cloud-java clients only")
public class GrpcRawCallableFactory {
  private GrpcRawCallableFactory() {}

  /**
   * Create a Unary callable object with minimal grpc-specific functionality.
   *
   * @param grpcCallSettings the gRPC call settings
   * @param retryableCodes the {@link StatusCode.Code} that should be marked as retryable
   */
  public static <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> createUnaryCallable(
      GrpcCallSettings<RequestT, ResponseT> grpcCallSettings, Set<StatusCode.Code> retryableCodes) {
    UnaryCallable<RequestT, ResponseT> callable =
        new GrpcDirectCallable<>(
            grpcCallSettings.getMethodDescriptor(), grpcCallSettings.shouldAwaitTrailers());

    if (grpcCallSettings.getParamsExtractor() != null) {
      callable =
          new GrpcUnaryRequestParamCallable<>(callable, grpcCallSettings.getParamsExtractor());
    }
    return new GrpcExceptionCallable<>(callable, retryableCodes);
  }

  /**
   * Create a bidirectional streaming callable object with grpc-specific functionality. Designed for
   * use by generated code.
   *
   * @param grpcCallSettings the gRPC call settings
   * @param retryableCodes the {@link StatusCode.Code} that should be marked as retryable
   * @return {@link BidiStreamingCallable} callable object.
   */
  public static <RequestT, ResponseT>
      BidiStreamingCallable<RequestT, ResponseT> createBidiStreamingCallable(
          GrpcCallSettings<RequestT, ResponseT> grpcCallSettings,
          Set<StatusCode.Code> retryableCodes) {
    BidiStreamingCallable<RequestT, ResponseT> callable =
        new GrpcDirectBidiStreamingCallable<>(grpcCallSettings.getMethodDescriptor());

    return new GrpcExceptionBidiStreamingCallable<>(callable, retryableCodes);
  }

  /**
   * Create a server-streaming callable with grpc-specific functionality. Designed for use by
   * generated code.
   *
   * @param grpcCallSettings the gRPC call settings
   * @param retryableCodes the {@link StatusCode.Code} that should be marked as retryable
   */
  public static <RequestT, ResponseT>
      ServerStreamingCallable<RequestT, ResponseT> createServerStreamingCallable(
          GrpcCallSettings<RequestT, ResponseT> grpcCallSettings,
          Set<StatusCode.Code> retryableCodes) {
    ServerStreamingCallable<RequestT, ResponseT> callable =
        new GrpcDirectServerStreamingCallable<>(grpcCallSettings.getMethodDescriptor());
    if (grpcCallSettings.getParamsExtractor() != null) {
      callable =
          new GrpcServerStreamingRequestParamCallable<>(
              callable, grpcCallSettings.getParamsExtractor());
    }
    return new GrpcExceptionServerStreamingCallable<>(callable, retryableCodes);
  }

  /**
   * Create a client-streaming callable object with grpc-specific functionality. Designed for use by
   * generated code.
   *
   * @param grpcCallSettings the gRPC call settings
   * @param retryableCodes the {@link StatusCode.Code} that should be marked as retryable
   */
  public static <RequestT, ResponseT>
      ClientStreamingCallable<RequestT, ResponseT> createClientStreamingCallable(
          GrpcCallSettings<RequestT, ResponseT> grpcCallSettings,
          Set<StatusCode.Code> retryableCodes) {
    ClientStreamingCallable<RequestT, ResponseT> callable =
        new GrpcDirectClientStreamingCallable<>(grpcCallSettings.getMethodDescriptor());

    return new GrpcExceptionClientStreamingCallable<>(callable, retryableCodes);
  }
}
