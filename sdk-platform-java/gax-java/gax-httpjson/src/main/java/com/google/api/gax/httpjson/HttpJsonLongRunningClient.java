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

import com.google.api.core.ApiFunction;
import com.google.api.core.InternalApi;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.LongRunningClient;
import com.google.api.gax.rpc.TranslatingUnaryCallable;
import com.google.api.gax.rpc.UnaryCallable;

/**
 * Implementation of LongRunningClient based on REST transport.
 *
 * <p>Public for technical reasons. For internal use only.
 */
@InternalApi
public class HttpJsonLongRunningClient<RequestT, OperationT> implements LongRunningClient {

  private final UnaryCallable<RequestT, OperationT> operationCallable;
  private final OperationSnapshotFactory<RequestT, OperationT> operationSnapshotFactory;
  private final PollingRequestFactory<RequestT> pollingRequestFactory;

  public HttpJsonLongRunningClient(
      UnaryCallable<RequestT, OperationT> operationCallable,
      OperationSnapshotFactory<RequestT, OperationT> operationSnapshotFactory,
      PollingRequestFactory<RequestT> pollingRequestFactory) {
    this.operationCallable = operationCallable;
    this.operationSnapshotFactory = operationSnapshotFactory;
    this.pollingRequestFactory = pollingRequestFactory;
  }

  /** {@inheritDoc} */
  @Override
  public UnaryCallable<String, OperationSnapshot> getOperationCallable() {
    return TranslatingUnaryCallable.create(
        operationCallable,
        new ApiFunction<String, RequestT>() {
          @Override
          public RequestT apply(String id) {
            return pollingRequestFactory.create(id);
          }
        },
        new ApiFunction<OperationT, OperationSnapshot>() {
          @Override
          public OperationSnapshot apply(OperationT operation) {
            return operationSnapshotFactory.create(null, operation);
          }
        });
  }

  /** {@inheritDoc} */
  @Override
  public UnaryCallable<String, Void> cancelOperationCallable() {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public UnaryCallable<String, Void> deleteOperationCallable() {
    return null;
  }
}
