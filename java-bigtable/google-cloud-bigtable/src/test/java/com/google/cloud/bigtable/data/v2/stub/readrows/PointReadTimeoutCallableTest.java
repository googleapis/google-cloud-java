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
package com.google.cloud.bigtable.data.v2.stub.readrows;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.RowSet;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class PointReadTimeoutCallableTest {
  @Rule public final MockitoRule moo = MockitoJUnit.rule();

  @Mock private ServerStreamingCallable<ReadRowsRequest, Object> inner;
  private ArgumentCaptor<ApiCallContext> ctxCaptor;
  @Mock private ResponseObserver<Object> responseObserver;

  @Before
  public void setUp() throws Exception {
    ctxCaptor = ArgumentCaptor.forClass(ApiCallContext.class);

    Mockito.doNothing()
        .when(inner)
        .call(
            Mockito.isA(ReadRowsRequest.class),
            Mockito.any(ResponseObserver.class),
            ctxCaptor.capture());
  }

  @Test
  public void promotesStreamWaitTimeout() {
    Duration duration = Duration.ofMillis(100);
    PointReadTimeoutCallable<Object> callable = new PointReadTimeoutCallable<>(inner);

    for (ReadRowsRequest req : createPointReadRequests()) {
      callable.call(
          req, responseObserver, GrpcCallContext.createDefault().withStreamWaitTimeout(duration));

      assertThat(ctxCaptor.getValue().getTimeout()).isEqualTo(duration);
    }
  }

  @Test
  public void promotesStreamWaitTimeoutForRowLimit() {
    Duration duration = Duration.ofMillis(100);
    PointReadTimeoutCallable<Object> callable = new PointReadTimeoutCallable<>(inner);

    for (ReadRowsRequest req : createPointReadRequests()) {
      callable.call(
          createRowsLimitRequest(),
          responseObserver,
          GrpcCallContext.createDefault().withStreamWaitTimeout(duration));

      assertThat(ctxCaptor.getValue().getTimeout()).isEqualTo(duration);
    }
  }

  @Test
  public void respectsExistingTimeout() {
    Duration duration = Duration.ofMillis(100);
    PointReadTimeoutCallable<Object> callable = new PointReadTimeoutCallable<>(inner);

    List<ReadRowsRequest> requests =
        ImmutableList.<ReadRowsRequest>builder()
            .addAll(createPointReadRequests())
            .add(ReadRowsRequest.getDefaultInstance())
            .build();

    for (ReadRowsRequest req : requests) {
      callable.call(req, responseObserver, GrpcCallContext.createDefault().withTimeout(duration));
      assertThat(ctxCaptor.getValue().getTimeout()).isEqualTo(duration);
    }
  }

  @Test
  public void usesMinimum1() {
    Duration attemptTimeout = Duration.ofMillis(100);
    Duration streamTimeout = Duration.ofMillis(200);
    PointReadTimeoutCallable<Object> callable = new PointReadTimeoutCallable<>(inner);

    for (ReadRowsRequest req : createPointReadRequests()) {
      GrpcCallContext ctx =
          GrpcCallContext.createDefault()
              .withTimeout(attemptTimeout)
              .withStreamWaitTimeout(streamTimeout);
      callable.call(req, responseObserver, ctx);

      assertThat(ctxCaptor.getValue().getTimeout()).isEqualTo(attemptTimeout);
    }
  }

  @Test
  public void usesMinimum2() {
    Duration attemptTimeout = Duration.ofMillis(200);
    Duration streamTimeout = Duration.ofMillis(100);
    PointReadTimeoutCallable<Object> callable = new PointReadTimeoutCallable<>(inner);

    for (ReadRowsRequest req : createPointReadRequests()) {
      GrpcCallContext ctx =
          GrpcCallContext.createDefault()
              .withTimeout(attemptTimeout)
              .withStreamWaitTimeout(streamTimeout);

      callable.call(req, responseObserver, ctx);

      assertThat(ctxCaptor.getValue().getTimeout()).isEqualTo(streamTimeout);
    }
  }

  @Test
  public void nonPointReadsAreUntouched() {
    Duration streamTimeout = Duration.ofMillis(100);
    PointReadTimeoutCallable<Object> callable = new PointReadTimeoutCallable<>(inner);

    List<ReadRowsRequest> requests =
        Arrays.<ReadRowsRequest>asList(
            ReadRowsRequest.getDefaultInstance(),
            ReadRowsRequest.newBuilder()
                .setRows(
                    RowSet.newBuilder()
                        .addRowKeys(ByteString.copyFromUtf8("a"))
                        .addRowKeys(ByteString.copyFromUtf8("ab")))
                .build(),
            ReadRowsRequest.newBuilder()
                .setRows(RowSet.newBuilder().addRowRanges(RowRange.getDefaultInstance()))
                .build());

    for (ReadRowsRequest req : requests) {
      callable.call(
          req,
          responseObserver,
          GrpcCallContext.createDefault().withStreamWaitTimeout(streamTimeout));
      assertThat(ctxCaptor.getValue().getTimeout()).isNull();
    }
  }

  private List<ReadRowsRequest> createPointReadRequests() {
    return Arrays.asList(createRowsLimitRequest(), createRowKeyRequest());
  }

  private ReadRowsRequest createRowsLimitRequest() {
    return ReadRowsRequest.newBuilder().setRowsLimit(1).build();
  }

  private ReadRowsRequest createRowKeyRequest() {
    return ReadRowsRequest.newBuilder()
        .setRows(RowSet.newBuilder().addRowKeys(ByteString.copyFromUtf8("key")))
        .build();
  }
}
