/*
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import com.google.cloud.spanner.spi.SpannerRpc;
import com.google.cloud.spanner.spi.SpannerRpc.Option;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import com.google.rpc.RetryInfo;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/** Unit test for {@link com.google.cloud.spanner.SpannerImpl.TransactionRunnerImpl} */
@RunWith(JUnit4.class)
public class TransactionRunnerImplTest {
  @Mock private SpannerRpc rpc;
  @Mock private SpannerImpl.SessionImpl session;
  @Mock private SpannerImpl.TransactionRunnerImpl.Sleeper sleeper;
  private SpannerImpl.TransactionRunnerImpl transactionRunner;
  private boolean firstRun;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    firstRun = true;
    transactionRunner = new SpannerImpl.TransactionRunnerImpl(session, rpc, sleeper, 1);
    when(session.beginTransaction()).thenReturn(ByteString.copyFromUtf8("transaction"));
    when(session.getName()).thenReturn("fake_session");
  }

  @Test
  public void runAbort() {
    runTransaction(createRetryException());
    ArgumentCaptor<Long> backoffMillis = ArgumentCaptor.forClass(Long.class);
    verify(sleeper, times(1)).backoffSleep(Mockito.<Context>any(), backoffMillis.capture());
    assertThat(backoffMillis.getValue()).isEqualTo(1001L);
  }

  @Test
  public void runAbortNoRetryInfo() {
    runTransaction(new StatusRuntimeException(Status.fromCodeValue(Status.Code.ABORTED.value())));
    ArgumentCaptor<Long> backoffMillis = ArgumentCaptor.forClass(Long.class);
    verify(sleeper, times(1)).backoffSleep(Mockito.<Context>any(), backoffMillis.capture());
    assertThat(backoffMillis.getValue()).isGreaterThan(0L);
  }

  @Test
  public void commitAbort() {
    final SpannerException error =
        SpannerExceptionFactory.newSpannerException(createRetryException());
    when(rpc.commit(Mockito.<CommitRequest>any(), Mockito.<Map<Option, ?>>any()))
        .thenThrow(error)
        .thenReturn(
            CommitResponse.newBuilder()
                .setCommitTimestamp(Timestamp.newBuilder().setSeconds(100))
                .build());

    transactionRunner.run(
        new TransactionCallable<Void>() {
          @Override
          public Void run(TransactionContext transaction) throws Exception {
            if (firstRun) {
              ((SpannerImpl.TransactionContextImpl) transaction).onError(error);
              firstRun = false;
            }
            return null;
          }
        });

    ArgumentCaptor<Long> backoffMillis = ArgumentCaptor.forClass(Long.class);
    verify(sleeper, times(1)).backoffSleep(Mockito.<Context>any(), backoffMillis.capture());
    assertThat(backoffMillis.getValue()).isEqualTo(1001L);
  }

  private StatusRuntimeException createRetryException() {
    Metadata.Key<RetryInfo> key = ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());
    Status status = Status.fromCodeValue(Status.Code.ABORTED.value());
    Metadata trailers = new Metadata();
    RetryInfo retryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(Duration.newBuilder().setNanos(1000000).setSeconds(1L))
            .build();
    trailers.put(key, retryInfo);
    return new StatusRuntimeException(status, trailers);
  }

  private void runTransaction(final Exception exception) {
    when(rpc.commit(Mockito.<CommitRequest>any(), Mockito.<Map<Option, ?>>any()))
        .thenReturn(
            CommitResponse.newBuilder()
                .setCommitTimestamp(Timestamp.newBuilder().setSeconds(100))
                .build());
    final SpannerException error = SpannerExceptionFactory.newSpannerException(exception);

    transactionRunner.run(
        new TransactionCallable<Void>() {
          @Override
          public Void run(TransactionContext transaction) throws Exception {
            if (firstRun) {
              ((SpannerImpl.TransactionContextImpl) transaction).onError(error);
              firstRun = false;
              throw error;
            }
            return null;
          }
        });
  }
}
