/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.api.gax.batching.Batcher;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.tracing.ApiTracer;

/**
 * This callable will extract total throttled time from {@link ApiCallContext} and add it to {@link
 * ApiTracer}. This class needs to be wrapped by a callable that injects the {@link ApiTracer}.
 */
@InternalApi
public final class TracedBatcherUnaryCallable<RequestT, ResponseT>
    extends UnaryCallable<RequestT, ResponseT> {
  private final UnaryCallable<RequestT, ResponseT> innerCallable;

  public TracedBatcherUnaryCallable(UnaryCallable innerCallable) {
    this.innerCallable = innerCallable;
  }

  @Override
  public ApiFuture<ResponseT> futureCall(RequestT request, ApiCallContext context) {
    if (context.getOption(Batcher.THROTTLED_TIME_KEY) != null) {
      ApiTracer tracer = context.getTracer();
      // this should always be true
      if (tracer instanceof BigtableTracer) {
        ((BigtableTracer) tracer)
            .batchRequestThrottled(context.getOption(Batcher.THROTTLED_TIME_KEY));
      }
    }
    return innerCallable.futureCall(request, context);
  }
}
