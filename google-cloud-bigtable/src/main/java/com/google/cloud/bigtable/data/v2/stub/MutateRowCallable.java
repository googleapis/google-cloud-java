/*
 * Copyright 2018 Google LLC
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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.RowMutation;

/** Simple wrapper for MutateRow to wrap the request and response protobufs. */
class MutateRowCallable extends UnaryCallable<RowMutation, Void> {
  private final UnaryCallable<MutateRowRequest, MutateRowResponse> inner;
  private final RequestContext requestContext;

  MutateRowCallable(
      UnaryCallable<MutateRowRequest, MutateRowResponse> inner, RequestContext requestContext) {

    this.inner = inner;
    this.requestContext = requestContext;
  }

  @Override
  public ApiFuture<Void> futureCall(RowMutation request, ApiCallContext context) {
    ApiFuture<MutateRowResponse> rawResponse =
        inner.futureCall(request.toProto(requestContext), context);

    return ApiFutures.transform(
        rawResponse,
        new ApiFunction<MutateRowResponse, Void>() {
          @Override
          public Void apply(MutateRowResponse mutateRowResponse) {
            return null;
          }
        });
  }
}
