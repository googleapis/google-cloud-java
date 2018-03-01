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
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.CheckAndMutateRowResponse;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;

/** Simple wrapper for CheckAndMutateRow to wrap the request and response protobufs. */
class CheckAndMutateRowCallable extends UnaryCallable<ConditionalRowMutation, Boolean> {
  private final UnaryCallable<CheckAndMutateRowRequest, CheckAndMutateRowResponse> inner;
  private final RequestContext requestContext;

  CheckAndMutateRowCallable(
      UnaryCallable<CheckAndMutateRowRequest, CheckAndMutateRowResponse> inner,
      RequestContext requestContext) {
    this.inner = inner;
    this.requestContext = requestContext;
  }

  @Override
  public ApiFuture<Boolean> futureCall(ConditionalRowMutation request, ApiCallContext context) {
    ApiFuture<CheckAndMutateRowResponse> rawResponse =
        inner.futureCall(request.toProto(requestContext), context);

    return ApiFutures.transform(
        rawResponse,
        new ApiFunction<CheckAndMutateRowResponse, Boolean>() {
          @Override
          public Boolean apply(CheckAndMutateRowResponse checkAndMutateRowResponse) {
            return checkAndMutateRowResponse.getPredicateMatched();
          }
        });
  }
}
