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
package com.google.cloud.bigtable.data.v2.stub.changestream;

import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamController;
import com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsRequest;
import com.google.bigtable.v2.GenerateInitialChangeStreamPartitionsResponse;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.Range.ByteStringRange;

/**
 * Simple wrapper for GenerateInitialChangeStreamPartitions to wrap the request and response
 * protobufs.
 */
public class GenerateInitialChangeStreamPartitionsUserCallable
    extends ServerStreamingCallable<String, ByteStringRange> {
  private final RequestContext requestContext;
  private final ServerStreamingCallable<
          GenerateInitialChangeStreamPartitionsRequest,
          GenerateInitialChangeStreamPartitionsResponse>
      inner;

  public GenerateInitialChangeStreamPartitionsUserCallable(
      ServerStreamingCallable<
              GenerateInitialChangeStreamPartitionsRequest,
              GenerateInitialChangeStreamPartitionsResponse>
          inner,
      RequestContext requestContext) {
    this.requestContext = requestContext;
    this.inner = inner;
  }

  @Override
  public void call(
      String tableId, ResponseObserver<ByteStringRange> responseObserver, ApiCallContext context) {
    String tableName =
        NameUtil.formatTableName(
            requestContext.getProjectId(), requestContext.getInstanceId(), tableId);
    GenerateInitialChangeStreamPartitionsRequest request =
        GenerateInitialChangeStreamPartitionsRequest.newBuilder()
            .setTableName(tableName)
            .setAppProfileId(requestContext.getAppProfileId())
            .build();

    inner.call(request, new ConvertPartitionToRangeObserver(responseObserver), context);
  }

  private static class ConvertPartitionToRangeObserver
      implements ResponseObserver<GenerateInitialChangeStreamPartitionsResponse> {

    private final ResponseObserver<ByteStringRange> outerObserver;

    ConvertPartitionToRangeObserver(ResponseObserver<ByteStringRange> observer) {
      this.outerObserver = observer;
    }

    @Override
    public void onStart(final StreamController controller) {
      outerObserver.onStart(controller);
    }

    @Override
    public void onResponse(GenerateInitialChangeStreamPartitionsResponse response) {
      ByteStringRange byteStringRange =
          ByteStringRange.create(
              response.getPartition().getRowRange().getStartKeyClosed(),
              response.getPartition().getRowRange().getEndKeyOpen());
      outerObserver.onResponse(byteStringRange);
    }

    @Override
    public void onError(Throwable t) {
      outerObserver.onError(t);
    }

    @Override
    public void onComplete() {
      outerObserver.onComplete();
    }
  }
}
