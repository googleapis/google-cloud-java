/*
 * Copyright 2016 Google LLC
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
package com.google.api.gax.rpc;

import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.api.gax.batching.FlowController.FlowControlException;
import com.google.api.gax.batching.FlowController.FlowControlRuntimeException;
import com.google.api.gax.batching.PartitionKey;
import com.google.api.gax.batching.ThresholdBatcher;
import com.google.common.base.Preconditions;

/**
 * A {@link UnaryCallable} which will batch requests based on the given BatchingDescriptor and
 * BatcherFactory. The BatcherFactory provides a distinct Batcher for each partition as specified by
 * the BatchingDescriptor. An example of a batching partition would be a pubsub topic.
 *
 * <p>This is public only for technical reasons, for advanced usage.
 */
@InternalApi("For use by transport-specific implementations")
public class BatchingCallable<RequestT, ResponseT> extends UnaryCallable<RequestT, ResponseT> {
  private final UnaryCallable<RequestT, ResponseT> callable;
  private final BatchingDescriptor<RequestT, ResponseT> batchingDescriptor;
  private final BatcherFactory<RequestT, ResponseT> batcherFactory;

  public BatchingCallable(
      UnaryCallable<RequestT, ResponseT> callable,
      BatchingDescriptor<RequestT, ResponseT> batchingDescriptor,
      BatcherFactory<RequestT, ResponseT> batcherFactory) {
    this.callable = Preconditions.checkNotNull(callable);
    this.batchingDescriptor = Preconditions.checkNotNull(batchingDescriptor);
    this.batcherFactory = Preconditions.checkNotNull(batcherFactory);
  }

  @Override
  public ApiFuture<ResponseT> futureCall(RequestT request, ApiCallContext context) {
    if (batcherFactory.getBatchingSettings().getIsEnabled()) {
      BatchedFuture<ResponseT> result = BatchedFuture.<ResponseT>create();
      UnaryCallable<RequestT, ResponseT> unaryCallable = callable.withDefaultCallContext(context);
      Batch<RequestT, ResponseT> batchableMessage =
          new Batch<RequestT, ResponseT>(batchingDescriptor, request, unaryCallable, result);
      PartitionKey partitionKey = batchingDescriptor.getBatchPartitionKey(request);
      ThresholdBatcher<Batch<RequestT, ResponseT>> batcher =
          batcherFactory.getPushingBatcher(partitionKey);
      try {
        batcher.add(batchableMessage);
        return result;
      } catch (FlowControlException e) {
        throw FlowControlRuntimeException.fromFlowControlException(e);
      }
    } else {
      return callable.futureCall(request, context);
    }
  }
}
