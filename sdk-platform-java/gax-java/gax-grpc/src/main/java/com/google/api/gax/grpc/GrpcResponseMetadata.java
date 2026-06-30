/*
 * Copyright 2018 Google LLC
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
import com.google.common.base.Preconditions;
import io.grpc.Metadata;

/**
 * GrpcResponseMetadata provides a mechanism to access the headers and trailers returned by a gRPC
 * client method.
 *
 * <p>NOTE: the GrpcResponseMetadata class is not thread-safe and should NOT be re-used for multiple
 * calls. A new instance of GrpcResponseMetadata should be constructed for each call that requires
 * metadata to be accessed.
 *
 * <p>Example usage:
 *
 * <pre>
 * <code>
 * GrpcResponseMetadata grpcResponseMetadata = new GrpcResponseMetadata();
 * Foo foo = client.getFooCallable().call(getFooRequest, grpcResponseMetadata.createContextWithHandlers());
 * Metadata headers = grpcResponseMetadata.getMetadata();
 * Metadata trailers = grpcResponseMetadata.getTrailingMetadata();
 * </code>
 * </pre>
 */
public class GrpcResponseMetadata implements ResponseMetadataHandler {

  private volatile Metadata responseMetadata;
  private volatile Metadata trailingMetadata;

  /**
   * Constructs a new call context from an existing ApiCallContext, and sets the CallOptions to add
   * handlers to retrieve the headers and trailers, and make them available via the getMetadata and
   * getTrailingMetadata methods.
   */
  public GrpcCallContext addHandlers(ApiCallContext apiCallContext) {
    if (Preconditions.checkNotNull(apiCallContext) instanceof GrpcCallContext) {
      return addHandlers((GrpcCallContext) apiCallContext);
    }
    throw new IllegalArgumentException(
        "context must be an instance of GrpcCallContext, but found "
            + apiCallContext.getClass().getName());
  }

  /**
   * Constructs a new call context and sets the CallOptions to add handlers to retrieve the headers
   * and trailers, and make them available via the getMetadata and getTrailingMetadata methods.
   */
  public GrpcCallContext createContextWithHandlers() {
    return addHandlers(GrpcCallContext.createDefault());
  }

  private GrpcCallContext addHandlers(GrpcCallContext grpcCallContext) {
    return Preconditions.checkNotNull(grpcCallContext)
        .withCallOptions(
            CallOptionsUtil.putMetadataHandlerOption(grpcCallContext.getCallOptions(), this));
  }

  /**
   * Returns the headers from the gRPC method as Metadata. If the call has not completed, will
   * return null.
   */
  public Metadata getMetadata() {
    return responseMetadata;
  }

  /**
   * Returns the trailers from the gRPC method as Metadata. If the call has not completed, will
   * return null.
   */
  public Metadata getTrailingMetadata() {
    return trailingMetadata;
  }

  @Override
  public void onHeaders(Metadata metadata) {
    responseMetadata = metadata;
  }

  @Override
  public void onTrailers(Metadata metadata) {
    trailingMetadata = metadata;
  }
}
