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
package com.google.cloud.bigtable.data.v2.stub.mutaterows;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import java.util.List;

/**
 * Converts a stream of {@link MutateRowsResponse}s into a unary MutateRowsResponse. This is
 * necessary to adapt Cloud Bigtable API to work with gax's batching infrastructure.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class MutateRowsSpoolingCallable
    extends UnaryCallable<MutateRowsRequest, MutateRowsResponse> {

  private final ServerStreamingCallable<MutateRowsRequest, MutateRowsResponse> inner;

  public MutateRowsSpoolingCallable(
      ServerStreamingCallable<MutateRowsRequest, MutateRowsResponse> inner) {
    this.inner = inner;
  }

  @Override
  public ApiFuture<MutateRowsResponse> futureCall(
      MutateRowsRequest request, ApiCallContext context) {
    ApiFuture<List<MutateRowsResponse>> rawResponse = inner.all().futureCall(request, context);

    return ApiFutures.transform(
        rawResponse,
        new ApiFunction<List<MutateRowsResponse>, MutateRowsResponse>() {
          @Override
          public MutateRowsResponse apply(List<MutateRowsResponse> input) {
            return convertResponse(input);
          }
        });
  }

  private MutateRowsResponse convertResponse(List<MutateRowsResponse> responses) {
    if (responses.size() == 1) {
      return responses.get(0);
    } else {
      MutateRowsResponse.Builder fullResponseBuilder = MutateRowsResponse.newBuilder();
      for (MutateRowsResponse subResponse : responses) {
        fullResponseBuilder.addAllEntries(subResponse.getEntriesList());
      }
      return fullResponseBuilder.build();
    }
  }
}
