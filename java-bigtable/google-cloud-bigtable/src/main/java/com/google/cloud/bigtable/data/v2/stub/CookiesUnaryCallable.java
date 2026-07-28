/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.cloud.bigtable.data.v2.stub.CookiesHolder.COOKIES_HOLDER_KEY;

import com.google.api.core.ApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;

/**
 * The cookie holder will act as operation scoped storage for all retry attempts. Each attempt's
 * cookies will be merged into the value holder and will be sent out with the next retry attempt.
 */
class CookiesUnaryCallable<RequestT, ResponseT> extends UnaryCallable<RequestT, ResponseT> {
  private final UnaryCallable<RequestT, ResponseT> innerCallable;

  CookiesUnaryCallable(UnaryCallable<RequestT, ResponseT> callable) {
    this.innerCallable = callable;
  }

  @Override
  public ApiFuture<ResponseT> futureCall(RequestT request, ApiCallContext context) {
    GrpcCallContext grpcCallContext = (GrpcCallContext) context;
    return innerCallable.futureCall(
        request,
        grpcCallContext.withCallOptions(
            grpcCallContext.getCallOptions().withOption(COOKIES_HOLDER_KEY, new CookiesHolder())));
  }
}
