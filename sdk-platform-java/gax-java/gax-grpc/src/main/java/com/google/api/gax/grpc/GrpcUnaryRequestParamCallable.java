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

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.RequestUrlParamsEncoder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.base.Preconditions;

/**
 * A {@code UnaryCallable} that extracts values from the fields of the request and inserts them into
 * headers.
 *
 * <p>Package-private for internal usage.
 */
class GrpcUnaryRequestParamCallable<RequestT, ResponseT>
    extends UnaryCallable<RequestT, ResponseT> {
  private final UnaryCallable<RequestT, ResponseT> callable;
  private final RequestUrlParamsEncoder<RequestT> paramsEncoder;

  GrpcUnaryRequestParamCallable(
      UnaryCallable<RequestT, ResponseT> callable,
      RequestParamsExtractor<RequestT> paramsExtractor) {
    this.callable = Preconditions.checkNotNull(callable);
    this.paramsEncoder = new RequestUrlParamsEncoder<>(Preconditions.checkNotNull(paramsExtractor));
  }

  @Override
  public ApiFuture<ResponseT> futureCall(RequestT request, ApiCallContext inputContext) {
    ApiCallContext newCallContext = inputContext;
    String encodedHeader = paramsEncoder.encode(request);
    if (!encodedHeader.isEmpty()) {
      newCallContext =
          GrpcCallContext.createDefault()
              .nullToSelf(inputContext)
              .withRequestParamsDynamicHeaderOption(encodedHeader);
    }

    return callable.futureCall(request, newCallContext);
  }
}
