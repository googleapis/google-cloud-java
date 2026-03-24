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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.truth.Truth;
import com.google.protobuf.Field;
import com.google.protobuf.Option;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HttpJsonOperationSnapshotCallableTest {

  UnaryCallable<Option, Field> innerCallable;
  OperationSnapshotFactory<Option, Field> operationSnapshotFactory;
  HttpJsonOperationSnapshotCallable<Option, Field> operationSnapCallable;

  @BeforeEach
  @SuppressWarnings("unchecked")
  void init() {
    innerCallable = (UnaryCallable<Option, Field>) mock(UnaryCallable.class);
    operationSnapshotFactory =
        (OperationSnapshotFactory<Option, Field>) mock(OperationSnapshotFactory.class);

    operationSnapCallable =
        new HttpJsonOperationSnapshotCallable<Option, Field>(
            innerCallable, operationSnapshotFactory);
  }

  @Test
  void futureCallTest() throws ExecutionException, InterruptedException {
    Option request = Option.newBuilder().setName("Arizona").build();
    Field field = Field.newBuilder().setName("Georgia").build();
    ApiCallContext context = mock(ApiCallContext.class);
    OperationSnapshot operationSnapshot =
        HttpJsonOperationSnapshot.newBuilder()
            .setName("California")
            .setMetadata(2)
            .setDone(true)
            .setResponse("Florida")
            .setError(0, "no error")
            .build();

    SettableApiFuture<Field> settableApiFuture = SettableApiFuture.create();
    settableApiFuture.set(field);

    when(operationSnapshotFactory.create(request, field)).thenReturn(operationSnapshot);
    when(innerCallable.futureCall(request, context)).thenReturn(settableApiFuture);

    ApiFuture<OperationSnapshot> futureCall = operationSnapCallable.futureCall(request, context);

    Truth.assertThat(futureCall.get().getName()).isEqualTo("California");
  }

  @Test
  void futureCallTestException() throws InterruptedException {
    Option request = Option.newBuilder().setName("Arizona").build();
    Field field = Field.newBuilder().setName("Georgia").build();
    ApiCallContext context = mock(ApiCallContext.class);
    OperationSnapshot operationSnapshot =
        HttpJsonOperationSnapshot.newBuilder()
            .setName("California")
            .setMetadata(2)
            .setDone(true)
            .setResponse("Florida")
            .setError(0, "no error")
            .build();

    SettableApiFuture<Field> settableApiFuture = SettableApiFuture.create();
    settableApiFuture.setException(new RuntimeException("Seattle"));

    when(operationSnapshotFactory.create(request, field)).thenReturn(operationSnapshot);
    when(innerCallable.futureCall(request, context)).thenReturn(settableApiFuture);

    try {
      operationSnapCallable.futureCall(request, context).get();
      Assertions.fail("Exception should have been thrown");
    } catch (ExecutionException e) {
      Truth.assertThat(e).hasMessageThat().contains("Seattle");
    }
  }
}
