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

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.batching.PartitionKey;
import com.google.api.gax.batching.ThresholdBatchReceiver;
import com.google.common.base.Preconditions;
import java.util.List;

/**
 * A ThresholdBatchReceiver which uses a provided {@link BatchingDescriptor} to merge the items from
 * the Batch into a single request, invoke the callable from the Batch to issue the request, split
 * the batch response into the components matching each incoming request, and finally send the
 * result back to the listener for each request.
 *
 * <p>BatchExecutor methods validateBatch and processBatch use the thread-safe guarantee of
 * BatchingDescriptor to achieve thread safety.
 *
 * <p>Package-private for internal use.
 */
class BatchExecutor<RequestT, ResponseT>
    implements ThresholdBatchReceiver<Batch<RequestT, ResponseT>> {

  private final BatchingDescriptor<RequestT, ResponseT> batchingDescriptor;
  private final PartitionKey partitionKey;

  public BatchExecutor(
      BatchingDescriptor<RequestT, ResponseT> batchingDescriptor, PartitionKey partitionKey) {
    this.batchingDescriptor = Preconditions.checkNotNull(batchingDescriptor);
    this.partitionKey = Preconditions.checkNotNull(partitionKey);
  }

  @Override
  public void validateBatch(Batch<RequestT, ResponseT> item) {
    PartitionKey itemPartitionKey = batchingDescriptor.getBatchPartitionKey(item.getRequest());
    if (!itemPartitionKey.equals(partitionKey)) {
      String requestClassName = item.getRequest().getClass().getSimpleName();
      throw new IllegalArgumentException(
          String.format(
              "For type %s, invalid partition key: %s, should be: %s",
              requestClassName, itemPartitionKey, partitionKey));
    }
  }

  @Override
  public ApiFuture<ResponseT> processBatch(Batch<RequestT, ResponseT> batch) {
    UnaryCallable<RequestT, ResponseT> callable = batch.getCallable();
    RequestT request = batch.getRequest();
    final List<BatchedRequestIssuer<ResponseT>> requestIssuerList = batch.getRequestIssuerList();
    ApiFuture<ResponseT> future = callable.futureCall(request);
    ApiFutures.addCallback(
        future,
        new ApiFutureCallback<ResponseT>() {
          @Override
          public void onSuccess(ResponseT result) {
            batchingDescriptor.splitResponse(result, requestIssuerList);
            for (BatchedRequestIssuer<ResponseT> requestIssuer : requestIssuerList) {
              requestIssuer.sendResult();
            }
          }

          @Override
          public void onFailure(Throwable t) {
            batchingDescriptor.splitException(t, requestIssuerList);
            for (BatchedRequestIssuer<ResponseT> requestIssuer : requestIssuerList) {
              requestIssuer.sendResult();
            }
          }
        },
        directExecutor());
    return future;
  }
}
