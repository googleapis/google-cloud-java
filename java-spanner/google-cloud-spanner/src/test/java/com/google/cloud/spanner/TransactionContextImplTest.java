/*
 * Copyright 2019 Google LLC
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

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyMap;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFutures;
import com.google.cloud.spanner.TransactionRunnerImpl.TransactionContextImpl;
import com.google.cloud.spanner.XGoogSpannerRequestId.NoopRequestIdCreator;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.v1.stub.SpannerStubSettings;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.rpc.Code;
import com.google.rpc.Status;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteBatchDmlResponse;
import io.opentelemetry.api.common.Attributes;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(JUnit4.class)
public class TransactionContextImplTest {

  @Mock private SpannerRpc rpc;

  @Mock private SessionImpl session;

  @Mock private ISpan span;
  @Mock private TraceWrapper tracer;

  @SuppressWarnings("unchecked")
  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    when(rpc.commitAsync(any(CommitRequest.class), anyMap()))
        .thenReturn(
            ApiFutures.immediateFuture(
                com.google.spanner.v1.CommitResponse.newBuilder()
                    .setCommitTimestamp(Timestamp.newBuilder().setSeconds(99L).setNanos(10).build())
                    .build()));
    when(rpc.getRequestIdCreator()).thenReturn(NoopRequestIdCreator.INSTANCE);
    when(session.getName()).thenReturn("test");
    when(session.getRequestIdCreator()).thenReturn(NoopRequestIdCreator.INSTANCE);
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(session.getSpanner()).thenReturn(spanner);
    doNothing().when(span).setStatus(any(Throwable.class));
    doNothing().when(span).end();
    doNothing().when(span).addAnnotation("Starting Commit");
    when(tracer.createStatementAttributes(any(Statement.class), any()))
        .thenReturn(Attributes.empty());
    when(tracer.createStatementBatchAttributes(any(Iterable.class), any()))
        .thenReturn(Attributes.empty());
    when(tracer.spanBuilderWithExplicitParent(SpannerImpl.COMMIT, span)).thenReturn(span);
    when(tracer.spanBuilderWithExplicitParent(
            eq(SpannerImpl.COMMIT), eq(span), any(Attributes.class)))
        .thenReturn(span);
    when(tracer.spanBuilderWithExplicitParent(
            eq(SpannerImpl.BATCH_UPDATE), eq(span), any(Attributes.class)))
        .thenReturn(span);
    when(rpc.getCommitRetrySettings())
        .thenReturn(SpannerStubSettings.newBuilder().commitSettings().getRetrySettings());
  }

  private TransactionContextImpl createContext() {
    return TransactionContextImpl.newBuilder()
        .setSession(session)
        .setRpc(rpc)
        .setSpan(span)
        .setTracer(tracer)
        .setTransactionId(ByteString.copyFromUtf8("test"))
        .setOptions(Options.fromTransactionOptions())
        .build();
  }

  @Test
  public void testCanBufferBeforeCommit() {
    try (TransactionContextImpl context = createContext()) {
      context.buffer(Mutation.delete("test", KeySet.all()));
    }
  }

  @Test
  public void testCanBufferAsyncBeforeCommit() {
    try (TransactionContextImpl context = createContext()) {
      context.bufferAsync(Mutation.delete("test", KeySet.all()));
    }
  }

  @Test
  public void testCanBufferIterableBeforeCommit() {
    try (TransactionContextImpl context = createContext()) {
      context.buffer(Collections.singleton(Mutation.delete("test", KeySet.all())));
    }
  }

  @Test
  public void testCanBufferIterableAsyncBeforeCommit() {
    try (TransactionContextImpl context = createContext()) {
      context.bufferAsync(Collections.singleton(Mutation.delete("test", KeySet.all())));
    }
  }

  @Test
  public void testCannotBufferAfterCommit() {
    try (TransactionContextImpl context = createContext()) {
      context.commit();
      assertThrows(
          IllegalStateException.class, () -> context.buffer(Mutation.delete("test", KeySet.all())));
    }
  }

  @Test
  public void testCannotBufferAsyncAfterCommit() {
    try (TransactionContextImpl context = createContext()) {
      context.commit();
      assertThrows(
          IllegalStateException.class,
          () -> context.bufferAsync(Mutation.delete("test", KeySet.all())));
    }
  }

  @Test
  public void testCannotBufferIterableAfterCommit() {
    try (TransactionContextImpl context = createContext()) {
      context.commit();
      assertThrows(
          IllegalStateException.class,
          () -> context.buffer(Collections.singleton(Mutation.delete("test", KeySet.all()))));
    }
  }

  @Test
  public void testCannotBufferIterableAsyncAfterCommit() {
    try (TransactionContextImpl context = createContext()) {
      context.commit();
      assertThrows(
          IllegalStateException.class,
          () -> context.bufferAsync(Collections.singleton(Mutation.delete("test", KeySet.all()))));
    }
  }

  @Test
  public void testCannotCommitTwice() {
    try (TransactionContextImpl context = createContext()) {
      context.commit();
      assertThrows(IllegalStateException.class, () -> context.commit());
    }
  }

  @Test(expected = AbortedException.class)
  public void batchDmlAborted() {
    batchDml(Code.ABORTED_VALUE);
  }

  @Test(expected = SpannerBatchUpdateException.class)
  public void batchDmlException() {
    batchDml(Code.FAILED_PRECONDITION_VALUE);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testReturnCommitStats() {
    ByteString transactionId = ByteString.copyFromUtf8("test");

    try (TransactionContextImpl context =
        TransactionContextImpl.newBuilder()
            .setSession(session)
            .setRpc(rpc)
            .setSpan(span)
            .setTracer(tracer)
            .setTransactionId(transactionId)
            .setOptions(Options.fromTransactionOptions(Options.commitStats()))
            .build()) {
      context.commitAsync();
      CommitRequest request =
          CommitRequest.newBuilder()
              .setReturnCommitStats(true)
              .setSession(session.getName())
              .setTransactionId(transactionId)
              .build();
      verify(rpc).commitAsync(eq(request), anyMap());
    }
  }

  @SuppressWarnings("unchecked")
  private void batchDml(int status) {
    SessionImpl session = mock(SessionImpl.class);
    when(session.getName()).thenReturn("test");
    when(session.getRequestIdCreator()).thenReturn(NoopRequestIdCreator.INSTANCE);
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(session.getSpanner()).thenReturn(spanner);
    SpannerRpc rpc = mock(SpannerRpc.class);
    ExecuteBatchDmlResponse response =
        ExecuteBatchDmlResponse.newBuilder()
            .setStatus(Status.newBuilder().setCode(status).build())
            .build();
    Statement statement = Statement.of("UPDATE FOO SET BAR=1");

    when(rpc.executeBatchDml(Mockito.any(ExecuteBatchDmlRequest.class), Mockito.anyMap()))
        .thenReturn(response);
    try (TransactionContextImpl impl =
        TransactionContextImpl.newBuilder()
            .setSession(session)
            .setRpc(rpc)
            .setTransactionId(ByteString.copyFromUtf8("test"))
            .setOptions(Options.fromTransactionOptions())
            .setTracer(tracer)
            .setSpan(span)
            .build()) {
      impl.batchUpdate(Collections.singletonList(statement));
    }
  }
}
