/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.changestream;

import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.bigtable.v2.ReadChangeStreamRequest;
import com.google.bigtable.v2.ReadChangeStreamResponse;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamRecordAdapter;
import com.google.cloud.bigtable.gaxx.reframing.ReframingResponseObserver;

/**
 * A ServerStreamingCallable that consumes {@link ReadChangeStreamResponse}s and produces change
 * stream records.
 *
 * <p>This class delegates all the work to gax's {@link ReframingResponseObserver} and the logic to
 * {@link ChangeStreamRecordMerger}.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class ChangeStreamRecordMergingCallable<ChangeStreamRecordT>
    extends ServerStreamingCallable<ReadChangeStreamRequest, ChangeStreamRecordT> {
  private final ServerStreamingCallable<ReadChangeStreamRequest, ReadChangeStreamResponse> inner;
  private final ChangeStreamRecordAdapter<ChangeStreamRecordT> changeStreamRecordAdapter;

  public ChangeStreamRecordMergingCallable(
      ServerStreamingCallable<ReadChangeStreamRequest, ReadChangeStreamResponse> inner,
      ChangeStreamRecordAdapter<ChangeStreamRecordT> changeStreamRecordAdapter) {
    this.inner = inner;
    this.changeStreamRecordAdapter = changeStreamRecordAdapter;
  }

  @Override
  public void call(
      ReadChangeStreamRequest request,
      ResponseObserver<ChangeStreamRecordT> responseObserver,
      ApiCallContext context) {
    ChangeStreamRecordAdapter.ChangeStreamRecordBuilder<ChangeStreamRecordT>
        changeStreamRecordBuilder = changeStreamRecordAdapter.createChangeStreamRecordBuilder();
    ChangeStreamRecordMerger<ChangeStreamRecordT> merger =
        new ChangeStreamRecordMerger<>(changeStreamRecordBuilder);
    ReframingResponseObserver<ReadChangeStreamResponse, ChangeStreamRecordT> innerObserver =
        new ReframingResponseObserver<>(responseObserver, merger);
    inner.call(request, innerObserver, context);
  }
}
