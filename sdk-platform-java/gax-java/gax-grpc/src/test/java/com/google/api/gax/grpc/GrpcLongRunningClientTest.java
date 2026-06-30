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
package com.google.api.gax.grpc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.LongRunningClient;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.truth.Truth;
import com.google.longrunning.CancelOperationRequest;
import com.google.longrunning.DeleteOperationRequest;
import com.google.longrunning.GetOperationRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import org.junit.jupiter.api.Test;

class GrpcLongRunningClientTest {

  @Test
  void get() {
    OperationsStub operationsStub = mock(OperationsStub.class);
    when(operationsStub.getOperationCallable())
        .thenReturn(
            new UnaryCallable<GetOperationRequest, Operation>() {
              @Override
              public ApiFuture<Operation> futureCall(
                  GetOperationRequest request, ApiCallContext context) {
                if (!request.getName().equals("poseidon")) {
                  return ApiFutures.immediateFailedFuture(
                      new IllegalStateException("Unexpected request: " + request));
                } else {
                  return ApiFutures.immediateFuture(
                      Operation.newBuilder().setName("greece").build());
                }
              }
            });
    LongRunningClient longRunningClient = new GrpcLongRunningClient(operationsStub);
    Truth.assertThat(longRunningClient.getOperationCallable().call("poseidon").getName())
        .isEqualTo("greece");
  }

  @Test
  void cancel() {
    OperationsStub operationsStub = mock(OperationsStub.class);
    when(operationsStub.cancelOperationCallable())
        .thenReturn(
            new UnaryCallable<CancelOperationRequest, Empty>() {
              @Override
              public ApiFuture<Empty> futureCall(
                  CancelOperationRequest request, ApiCallContext context) {
                if (!request.getName().equals("poseidon")) {
                  return ApiFutures.immediateFailedFuture(
                      new IllegalStateException("Unexpected request: " + request));
                } else {
                  return ApiFutures.immediateFuture(Empty.getDefaultInstance());
                }
              }
            });
    LongRunningClient longRunningClient = new GrpcLongRunningClient(operationsStub);
    Truth.assertThat(longRunningClient.cancelOperationCallable().call("poseidon")).isNull();
  }

  @Test
  void delete() {
    OperationsStub operationsStub = mock(OperationsStub.class);
    when(operationsStub.deleteOperationCallable())
        .thenReturn(
            new UnaryCallable<DeleteOperationRequest, Empty>() {
              @Override
              public ApiFuture<Empty> futureCall(
                  DeleteOperationRequest request, ApiCallContext context) {
                if (!request.getName().equals("poseidon")) {
                  return ApiFutures.immediateFailedFuture(
                      new IllegalStateException("Unexpected request: " + request));
                } else {
                  return ApiFutures.immediateFuture(Empty.getDefaultInstance());
                }
              }
            });
    LongRunningClient longRunningClient = new GrpcLongRunningClient(operationsStub);
    Truth.assertThat(longRunningClient.deleteOperationCallable().call("poseidon")).isNull();
  }
}
