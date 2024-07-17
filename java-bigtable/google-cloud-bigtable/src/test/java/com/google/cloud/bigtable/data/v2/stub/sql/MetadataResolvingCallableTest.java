/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.sql;

import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.columnMetadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Value;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.metadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringValue;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.SettableApiFuture;
import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.cloud.bigtable.data.v2.internal.ProtoResultSetMetadata;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.cloud.bigtable.data.v2.stub.sql.MetadataResolvingCallable.MetadataObserver;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi.ServerStreamingStashCallable;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockResponseObserver;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockServerStreamingCall;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockServerStreamingCallable;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockStreamController;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MetadataResolvingCallableTest {

  private static final ExecuteQueryRequest FAKE_REQUEST = ExecuteQueryRequest.newBuilder().build();
  private static final ExecuteQueryResponse METADATA =
      metadata(columnMetadata("foo", stringType()), columnMetadata("bar", int64Type()));
  private static final ExecuteQueryResponse DATA =
      partialResultSetWithToken(stringValue("fooVal"), int64Value(100));

  MockResponseObserver<ExecuteQueryResponse> outerObserver;
  SettableApiFuture<ResultSetMetadata> metadataFuture;
  MetadataResolvingCallable.MetadataObserver observer;

  @Before
  public void setUp() {
    metadataFuture = SettableApiFuture.create();
    outerObserver = new MockResponseObserver<>(true);
    observer = new MetadataObserver(outerObserver, metadataFuture);
  }

  @Test
  public void observer_parsesMetadataSetsFutureAndPassesThroughResponses()
      throws ExecutionException, InterruptedException {
    ServerStreamingStashCallable<ExecuteQueryRequest, ExecuteQueryResponse> innerCallable =
        new ServerStreamingStashCallable<>(Arrays.asList(METADATA, DATA));
    innerCallable.call(FAKE_REQUEST, observer);

    assertThat(metadataFuture.isDone()).isTrue();
    assertThat(metadataFuture.get())
        .isEqualTo(ProtoResultSetMetadata.fromProto(METADATA.getMetadata()));
    assertThat(outerObserver.popNextResponse()).isEqualTo(METADATA);
    assertThat(outerObserver.popNextResponse()).isEqualTo(DATA);
    assertThat(outerObserver.isDone()).isTrue();
    assertThat(outerObserver.getFinalError()).isNull();
  }

  @Test
  public void observer_invalidMetadataFailsFutureAndPassesThroughError() {
    ExecuteQueryResponse invalidMetadataResponse = metadata();
    ServerStreamingStashCallable<ExecuteQueryRequest, ExecuteQueryResponse> innerCallable =
        new ServerStreamingStashCallable<>(Arrays.asList(invalidMetadataResponse, DATA));
    innerCallable.call(FAKE_REQUEST, observer);

    assertThat(metadataFuture.isDone()).isTrue();
    assertThrows(ExecutionException.class, metadataFuture::get);
    ExecutionException e = assertThrows(ExecutionException.class, metadataFuture::get);
    assertThat(e.getCause()).isInstanceOf(IllegalStateException.class);
    assertThat(outerObserver.isDone()).isTrue();
    assertThat(outerObserver.getFinalError()).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void observer_invalidFirstResponseFailsFutureAndPassesThroughError() {
    ServerStreamingStashCallable<ExecuteQueryRequest, ExecuteQueryResponse> innerCallable =
        new ServerStreamingStashCallable<>(Collections.singletonList(DATA));
    innerCallable.call(FAKE_REQUEST, observer);

    assertThat(metadataFuture.isDone()).isTrue();
    assertThrows(ExecutionException.class, metadataFuture::get);
    ExecutionException e = assertThrows(ExecutionException.class, metadataFuture::get);
    assertThat(e.getCause()).isInstanceOf(IllegalStateException.class);
    assertThat(outerObserver.isDone()).isTrue();
    assertThat(outerObserver.getFinalError()).isInstanceOf(IllegalStateException.class);
  }

  // cancel will manifest as an onError call so these are testing both cancellation and
  // other exceptions
  @Test
  public void observer_passesThroughErrorBeforeReceivingMetadata() {
    MockServerStreamingCallable<ExecuteQueryRequest, ExecuteQueryResponse> innerCallable =
        new MockServerStreamingCallable<>();
    innerCallable.call(FAKE_REQUEST, observer);
    MockServerStreamingCall<ExecuteQueryRequest, ExecuteQueryResponse> lastCall =
        innerCallable.popLastCall();
    MockStreamController<ExecuteQueryResponse> innerController = lastCall.getController();

    innerController.getObserver().onError(new CancellationException("Cancelled"));

    assertThat(metadataFuture.isDone()).isTrue();
    assertThrows(ExecutionException.class, metadataFuture::get);
    ExecutionException e = assertThrows(ExecutionException.class, metadataFuture::get);
    assertThat(e.getCause()).isInstanceOf(CancellationException.class);
    assertThat(outerObserver.isDone()).isTrue();
    assertThat(outerObserver.getFinalError()).isInstanceOf(CancellationException.class);
  }

  @Test
  public void observer_passesThroughErrorAfterReceivingMetadata()
      throws ExecutionException, InterruptedException {
    MockServerStreamingCallable<ExecuteQueryRequest, ExecuteQueryResponse> innerCallable =
        new MockServerStreamingCallable<>();
    innerCallable.call(FAKE_REQUEST, observer);
    MockServerStreamingCall<ExecuteQueryRequest, ExecuteQueryResponse> lastCall =
        innerCallable.popLastCall();
    MockStreamController<ExecuteQueryResponse> innerController = lastCall.getController();

    innerController.getObserver().onResponse(METADATA);
    innerController.getObserver().onError(new RuntimeException("exception after metadata"));

    assertThat(metadataFuture.isDone()).isTrue();
    assertThat(metadataFuture.get())
        .isEqualTo(ProtoResultSetMetadata.fromProto(METADATA.getMetadata()));
    assertThat(outerObserver.popNextResponse()).isEqualTo(METADATA);
    assertThat(outerObserver.isDone()).isTrue();
    assertThat(outerObserver.getFinalError()).isInstanceOf(RuntimeException.class);
  }

  @Test
  public void observer_passThroughOnStart() {
    MockServerStreamingCallable<ExecuteQueryRequest, ExecuteQueryResponse> innerCallable =
        new MockServerStreamingCallable<>();
    innerCallable.call(FAKE_REQUEST, observer);
    MockServerStreamingCall<ExecuteQueryRequest, ExecuteQueryResponse> lastCall =
        innerCallable.popLastCall();
    MockStreamController<ExecuteQueryResponse> innerController = lastCall.getController();

    assertThat(outerObserver.getController()).isEqualTo(innerController);
  }

  @Test
  public void observer_onCompleteBeforeMetadata_throwsException() throws InterruptedException {
    MockServerStreamingCallable<ExecuteQueryRequest, ExecuteQueryResponse> innerCallable =
        new MockServerStreamingCallable<>();
    innerCallable.call(FAKE_REQUEST, observer);
    MockServerStreamingCall<ExecuteQueryRequest, ExecuteQueryResponse> lastCall =
        innerCallable.popLastCall();
    MockStreamController<ExecuteQueryResponse> innerController = lastCall.getController();

    innerController.getObserver().onComplete();
    assertThrows(ExecutionException.class, metadataFuture::get);
    ExecutionException e = assertThrows(ExecutionException.class, metadataFuture::get);
    assertThat(e.getCause()).isInstanceOf(IllegalStateException.class);
    assertThat(outerObserver.isDone()).isTrue();
    assertThat(outerObserver.getFinalError()).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void testCallable() throws ExecutionException, InterruptedException {
    ServerStreamingStashCallable<ExecuteQueryRequest, ExecuteQueryResponse> innerCallable =
        new ServerStreamingStashCallable<>(Arrays.asList(METADATA, DATA));
    MetadataResolvingCallable callable = new MetadataResolvingCallable(innerCallable);
    MockResponseObserver<ExecuteQueryResponse> outerObserver = new MockResponseObserver<>(true);
    SettableApiFuture<ResultSetMetadata> metadataFuture = SettableApiFuture.create();
    ExecuteQueryCallContext callContext =
        ExecuteQueryCallContext.create(FAKE_REQUEST, metadataFuture);

    callable.call(callContext, outerObserver);

    assertThat(metadataFuture.isDone()).isTrue();
    assertThat(metadataFuture.get())
        .isEqualTo(ProtoResultSetMetadata.fromProto(METADATA.getMetadata()));
    assertThat(outerObserver.popNextResponse()).isEqualTo(METADATA);
    assertThat(outerObserver.popNextResponse()).isEqualTo(DATA);
    assertThat(outerObserver.isDone()).isTrue();
    assertThat(outerObserver.getFinalError()).isNull();
  }
}
