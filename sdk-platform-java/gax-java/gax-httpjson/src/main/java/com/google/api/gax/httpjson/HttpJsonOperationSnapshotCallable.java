/*
 * Copyright 2021 Google LLC
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
package com.google.api.gax.httpjson;

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;

/**
 * A {@code UnaryCallable} that wraps a UnaryCallable returning an Operation and returns an
 * OperationSnapshot instead.
 *
 * <p>Public for technical reasons. For internal use only.
 */
@InternalApi
public class HttpJsonOperationSnapshotCallable<RequestT, OperationT>
    extends UnaryCallable<RequestT, OperationSnapshot> {

  private final UnaryCallable<RequestT, OperationT> innerCallable;
  private final OperationSnapshotFactory<RequestT, OperationT> operationSnapshotFactory;

  public HttpJsonOperationSnapshotCallable(
      UnaryCallable<RequestT, OperationT> innerCallable,
      OperationSnapshotFactory<RequestT, OperationT> operationSnapshotFactory) {
    this.innerCallable = innerCallable;
    this.operationSnapshotFactory = operationSnapshotFactory;
  }

  /** {@inheritDoc} */
  @Override
  public ApiFuture<OperationSnapshot> futureCall(final RequestT request, ApiCallContext context) {
    return ApiFutures.transform(
        innerCallable.futureCall(request, context),
        new ApiFunction<OperationT, OperationSnapshot>() {
          @Override
          public OperationSnapshot apply(OperationT operation) {
            return operationSnapshotFactory.create(request, operation);
          }
        },
        directExecutor());
  }
}
