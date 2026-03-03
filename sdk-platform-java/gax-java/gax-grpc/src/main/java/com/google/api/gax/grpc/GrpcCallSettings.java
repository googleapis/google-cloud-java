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

import com.google.api.core.BetaApi;
import com.google.api.gax.rpc.RequestMutator;
import com.google.api.gax.rpc.RequestParamsExtractor;
import io.grpc.MethodDescriptor;

/** Grpc-specific settings for creating callables. */
public class GrpcCallSettings<RequestT, ResponseT> {
  private final MethodDescriptor<RequestT, ResponseT> methodDescriptor;
  private final RequestParamsExtractor<RequestT> paramsExtractor;
  private final RequestMutator<RequestT> requestMutator;
  private final boolean alwaysAwaitTrailers;

  private GrpcCallSettings(Builder<RequestT, ResponseT> builder) {
    this.methodDescriptor = builder.methodDescriptor;
    this.paramsExtractor = builder.paramsExtractor;
    this.requestMutator = builder.requestMutator;
    this.alwaysAwaitTrailers = builder.shouldAwaitTrailers;
  }

  public MethodDescriptor<RequestT, ResponseT> getMethodDescriptor() {
    return methodDescriptor;
  }

  public RequestParamsExtractor<RequestT> getParamsExtractor() {
    return paramsExtractor;
  }

  public RequestMutator<RequestT> getRequestMutator() {
    return requestMutator;
  }

  @BetaApi
  public boolean shouldAwaitTrailers() {
    return alwaysAwaitTrailers;
  }

  public static <RequestT, ResponseT> Builder<RequestT, ResponseT> newBuilder() {
    return new Builder<RequestT, ResponseT>().setShouldAwaitTrailers(true);
  }

  public static <RequestT, ResponseT> GrpcCallSettings<RequestT, ResponseT> create(
      MethodDescriptor<RequestT, ResponseT> methodDescriptor) {
    return GrpcCallSettings.<RequestT, ResponseT>newBuilder()
        .setMethodDescriptor(methodDescriptor)
        .build();
  }

  public Builder toBuilder() {
    return new Builder<>(this);
  }

  public static class Builder<RequestT, ResponseT> {
    private MethodDescriptor<RequestT, ResponseT> methodDescriptor;
    private RequestParamsExtractor<RequestT> paramsExtractor;

    private RequestMutator<RequestT> requestMutator;
    private boolean shouldAwaitTrailers;

    private Builder() {}

    private Builder(GrpcCallSettings<RequestT, ResponseT> settings) {
      this.methodDescriptor = settings.methodDescriptor;
      this.paramsExtractor = settings.paramsExtractor;
      this.requestMutator = settings.requestMutator;
      this.shouldAwaitTrailers = settings.alwaysAwaitTrailers;
    }

    public Builder<RequestT, ResponseT> setMethodDescriptor(
        MethodDescriptor<RequestT, ResponseT> methodDescriptor) {
      this.methodDescriptor = methodDescriptor;
      return this;
    }

    public Builder<RequestT, ResponseT> setParamsExtractor(
        RequestParamsExtractor<RequestT> paramsExtractor) {
      this.paramsExtractor = paramsExtractor;
      return this;
    }

    public Builder<RequestT, ResponseT> setRequestMutator(RequestMutator<RequestT> requestMutator) {
      this.requestMutator = requestMutator;
      return this;
    }

    @BetaApi
    public Builder<RequestT, ResponseT> setShouldAwaitTrailers(boolean b) {
      this.shouldAwaitTrailers = b;
      return this;
    }

    public GrpcCallSettings<RequestT, ResponseT> build() {
      return new GrpcCallSettings<>(this);
    }
  }
}
