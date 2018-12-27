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
import com.google.bigtable.v2.SampleRowKeysRequest;
import com.google.bigtable.v2.SampleRowKeysResponse;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.KeyOffset;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;

/** Simple wrapper for SampleRowKeys to wrap the request and response protobufs. */
class SampleRowKeysCallable extends UnaryCallable<String, List<KeyOffset>> {
  private final RequestContext requestContext;
  private final UnaryCallable<SampleRowKeysRequest, List<SampleRowKeysResponse>> inner;

  SampleRowKeysCallable(
      UnaryCallable<SampleRowKeysRequest, List<SampleRowKeysResponse>> inner,
      RequestContext requestContext) {

    this.requestContext = requestContext;
    this.inner = inner;
  }

  @Override
  public ApiFuture<List<KeyOffset>> futureCall(String tableId, ApiCallContext context) {
    String tableName =
        NameUtil.formatTableName(
            requestContext.getProjectId(), requestContext.getInstanceId(), tableId);

    SampleRowKeysRequest request =
        SampleRowKeysRequest.newBuilder()
            .setTableName(tableName)
            .setAppProfileId(requestContext.getAppProfileId())
            .build();

    ApiFuture<List<SampleRowKeysResponse>> rawResponse = inner.futureCall(request, context);

    return ApiFutures.transform(
        rawResponse,
        new ApiFunction<List<SampleRowKeysResponse>, List<KeyOffset>>() {
          @Override
          public List<KeyOffset> apply(List<SampleRowKeysResponse> rawResponse) {
            return convert(rawResponse);
          }
        },
        MoreExecutors.directExecutor());
  }

  private static List<KeyOffset> convert(List<SampleRowKeysResponse> rawResponse) {
    ImmutableList.Builder<KeyOffset> results = ImmutableList.builder();

    for (SampleRowKeysResponse element : rawResponse) {
      results.add(KeyOffset.create(element.getRowKey(), element.getOffsetBytes()));
    }

    return results.build();
  }
}
