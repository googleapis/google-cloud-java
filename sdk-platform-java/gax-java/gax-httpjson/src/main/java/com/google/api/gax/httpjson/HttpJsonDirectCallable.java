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

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.base.Preconditions;
import com.google.protobuf.TypeRegistry;

/**
 * {@code HttpJsonDirectCallable} creates HTTP calls.
 *
 * <p>Package-private for internal use.
 */
class HttpJsonDirectCallable<RequestT, ResponseT> extends UnaryCallable<RequestT, ResponseT> {
  private final ApiMethodDescriptor<RequestT, ResponseT> descriptor;
  private final TypeRegistry typeRegistry;

  HttpJsonDirectCallable(ApiMethodDescriptor<RequestT, ResponseT> descriptor) {
    this(descriptor, null);
  }

  HttpJsonDirectCallable(
      ApiMethodDescriptor<RequestT, ResponseT> descriptor, TypeRegistry typeRegistry) {
    this.descriptor = descriptor;
    this.typeRegistry = typeRegistry;
  }

  @Override
  public ApiFuture<ResponseT> futureCall(RequestT request, ApiCallContext inputContext) {
    Preconditions.checkNotNull(request);
    HttpJsonCallContext context = HttpJsonCallContext.createDefault().nullToSelf(inputContext);

    context =
        context.withCallOptions(
            context.getCallOptions().toBuilder().setTypeRegistry(typeRegistry).build());

    HttpJsonClientCall<RequestT, ResponseT> clientCall =
        HttpJsonClientCalls.newCall(descriptor, context);
    return HttpJsonClientCalls.futureUnaryCall(clientCall, request, context);
  }

  @Override
  public String toString() {
    return String.format("direct(%s)", descriptor);
  }
}
