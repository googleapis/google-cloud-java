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
package com.google.api.gax.httpjson;

import com.google.api.gax.rpc.RequestMutator;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.protobuf.TypeRegistry;

/** HTTP-specific settings for creating callables. */
public class HttpJsonCallSettings<RequestT, ResponseT> {
  private final ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor;
  private final RequestParamsExtractor<RequestT> paramsExtractor;

  private final RequestMutator<RequestT> requestMutator;
  private final TypeRegistry typeRegistry;

  private HttpJsonCallSettings(Builder<RequestT, ResponseT> builder) {
    this.methodDescriptor = builder.methodDescriptor;
    this.paramsExtractor = builder.paramsExtractor;
    this.requestMutator = builder.requestMutator;
    this.typeRegistry = builder.typeRegistry;
  }

  public ApiMethodDescriptor<RequestT, ResponseT> getMethodDescriptor() {
    return methodDescriptor;
  }

  public RequestParamsExtractor<RequestT> getParamsExtractor() {
    return paramsExtractor;
  }

  public RequestMutator<RequestT> getRequestMutator() {
    return requestMutator;
  }

  public TypeRegistry getTypeRegistry() {
    return typeRegistry;
  }

  public static <RequestT, ResponseT> Builder<RequestT, ResponseT> newBuilder() {
    return new Builder<>();
  }

  public static <RequestT, ResponseT> HttpJsonCallSettings<RequestT, ResponseT> create(
      ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor) {
    return HttpJsonCallSettings.<RequestT, ResponseT>newBuilder()
        .setMethodDescriptor(methodDescriptor)
        .build();
  }

  public Builder toBuilder() {
    return new Builder<>(this);
  }

  public static class Builder<RequestT, ResponseT> {

    private RequestMutator<RequestT> requestMutator;
    private ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor;
    private RequestParamsExtractor<RequestT> paramsExtractor;
    private TypeRegistry typeRegistry;

    private Builder() {}

    private Builder(HttpJsonCallSettings<RequestT, ResponseT> settings) {
      this.methodDescriptor = settings.methodDescriptor;
    }

    public Builder<RequestT, ResponseT> setMethodDescriptor(
        ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor) {
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

    public Builder<RequestT, ResponseT> setTypeRegistry(TypeRegistry typeRegistry) {
      this.typeRegistry = typeRegistry;
      return this;
    }

    public HttpJsonCallSettings<RequestT, ResponseT> build() {
      return new HttpJsonCallSettings<>(this);
    }
  }
}
