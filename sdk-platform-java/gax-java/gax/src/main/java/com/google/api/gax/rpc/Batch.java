/*
 * Copyright 2017 Google LLC
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

import com.google.api.core.InternalApi;
import com.google.api.gax.batching.BatchMerger;
import com.google.api.gax.batching.ElementCounter;
import com.google.api.gax.batching.RequestBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * A Batch contains a collection of requests that are to be batched into a single API call.
 *
 * <p>A Batch contains a single {@link UnaryCallable} object, which will be used to make the API
 * call, and a list of {@link BatchedRequestIssuer} objects, which represent the individual requests
 * in the batch.
 *
 * <p>Additional batches can be merged into an existing batch using the {@link #merge(Batch)}
 * method. Request objects are combined using a {@link RequestBuilder} into a single request.
 *
 * <p>This is public only for technical reasons, for advanced usage.
 */
@InternalApi
public class Batch<RequestT, ResponseT> {
  private final List<BatchedRequestIssuer<ResponseT>> requestIssuerList;

  private final RequestBuilder<RequestT> requestBuilder;
  private UnaryCallable<RequestT, ResponseT> callable;
  private long byteCount;

  public Batch(
      BatchingDescriptor<RequestT, ResponseT> descriptor,
      RequestT request,
      UnaryCallable<RequestT, ResponseT> callable,
      BatchedFuture<ResponseT> batchedFuture) {
    this.requestBuilder = descriptor.getRequestBuilder();
    this.requestIssuerList = new ArrayList<>();
    this.requestBuilder.appendRequest(request);
    this.callable = callable;
    this.requestIssuerList.add(
        new BatchedRequestIssuer<>(batchedFuture, descriptor.countElements(request)));
    this.byteCount = descriptor.countBytes(request);
  }

  public RequestT getRequest() {
    return requestBuilder.build();
  }

  public UnaryCallable<RequestT, ResponseT> getCallable() {
    return callable;
  }

  public List<BatchedRequestIssuer<ResponseT>> getRequestIssuerList() {
    return requestIssuerList;
  }

  public long getByteCount() {
    return byteCount;
  }

  /** Merge the given batch into this batch. */
  public void merge(Batch<RequestT, ResponseT> batch) {
    requestBuilder.appendRequest(batch.getRequest());
    requestIssuerList.addAll(batch.requestIssuerList);
    if (this.callable == null) {
      this.callable = batch.callable;
    }
    this.byteCount += batch.byteCount;
  }

  static class BatchElementCounter<RequestT, ResponseT>
      implements ElementCounter<Batch<RequestT, ResponseT>> {
    private final BatchingDescriptor<RequestT, ResponseT> batchingDescriptor;

    BatchElementCounter(BatchingDescriptor<RequestT, ResponseT> batchingDescriptor) {
      this.batchingDescriptor = batchingDescriptor;
    }

    @Override
    public long count(Batch<RequestT, ResponseT> batch) {
      return batchingDescriptor.countElements(batch.getRequest());
    }
  }

  static class BatchByteCounter<RequestT, ResponseT>
      implements ElementCounter<Batch<RequestT, ResponseT>> {
    @Override
    public long count(Batch<RequestT, ResponseT> batch) {
      return batch.getByteCount();
    }
  }

  static class BatchMergerImpl<RequestT, ResponseT>
      implements BatchMerger<Batch<RequestT, ResponseT>> {
    @Override
    public void merge(Batch<RequestT, ResponseT> batch, Batch<RequestT, ResponseT> newBatch) {
      batch.merge(newBatch);
    }
  }
}
