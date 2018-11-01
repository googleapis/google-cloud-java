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
package com.google.cloud.bigtable.data.v2.stub.readrows;

import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.cloud.bigtable.data.v2.models.RowAdapter;
import com.google.cloud.bigtable.data.v2.models.RowAdapter.RowBuilder;
import com.google.cloud.bigtable.gaxx.reframing.ReframingResponseObserver;

/**
 * A ServerStreamingCallable that will merge {@link
 * com.google.bigtable.v2.ReadRowsResponse.CellChunk}s into logical rows. This class delegates all
 * of the work to gax's {@link ReframingResponseObserver} and the logic to {@link RowMerger}.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class RowMergingCallable<RowT> extends ServerStreamingCallable<ReadRowsRequest, RowT> {
  private final ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> inner;
  private final RowAdapter<RowT> rowAdapter;

  public RowMergingCallable(
      ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> inner,
      RowAdapter<RowT> rowAdapter) {
    this.inner = inner;
    this.rowAdapter = rowAdapter;
  }

  @Override
  public void call(
      ReadRowsRequest request, ResponseObserver<RowT> responseObserver, ApiCallContext context) {
    RowBuilder<RowT> rowBuilder = rowAdapter.createRowBuilder();
    RowMerger<RowT> merger = new RowMerger<>(rowBuilder);
    ReframingResponseObserver<ReadRowsResponse, RowT> innerObserver =
        new ReframingResponseObserver<>(responseObserver, merger);
    inner.call(request, innerObserver, context);
  }
}
