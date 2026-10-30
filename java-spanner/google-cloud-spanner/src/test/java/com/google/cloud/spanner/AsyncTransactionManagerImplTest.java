/*
 * Copyright 2021 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFutures;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.TransactionManager.TransactionState;
import com.google.protobuf.Empty;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Scope;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AsyncTransactionManagerImplTest {

  @Mock private SessionImpl session;
  @Mock TransactionRunnerImpl.TransactionContextImpl transaction;

  @Test
  public void testCommitReturnsCommitStats() {
    Span oTspan = mock(Span.class);
    ISpan span = new OpenTelemetrySpan(oTspan);
    when(oTspan.makeCurrent()).thenReturn(mock(Scope.class));
    try (AsyncTransactionManagerImpl manager =
        new AsyncTransactionManagerImpl(session, span, Options.commitStats())) {
      when(session.newTransaction(eq(Options.fromTransactionOptions(Options.commitStats())), any()))
          .thenReturn(transaction);
      when(transaction.ensureTxnAsync()).thenReturn(ApiFutures.immediateFuture(null));
      Timestamp commitTimestamp = Timestamp.ofTimeMicroseconds(1);
      CommitResponse response = mock(CommitResponse.class);
      when(response.getCommitTimestamp()).thenReturn(commitTimestamp);
      when(transaction.commitAsync()).thenReturn(ApiFutures.immediateFuture(response));
      manager.beginAsync();
      manager.commitAsync();
      verify(transaction).commitAsync();
    }
  }

  @Test
  public void testCommitFailsWithDeadlineExceededRollsBack() {
    Span oTspan = mock(Span.class);
    ISpan span = new OpenTelemetrySpan(oTspan);
    when(oTspan.makeCurrent()).thenReturn(mock(Scope.class));
    when(session.newTransaction(eq(Options.fromTransactionOptions()), any()))
        .thenReturn(transaction);
    when(transaction.ensureTxnAsync()).thenReturn(ApiFutures.immediateFuture(null));
    when(transaction.commitAsync())
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                SpannerExceptionFactory.newSpannerException(
                    ErrorCode.DEADLINE_EXCEEDED, "commit deadline exceeded")));
    when(transaction.rollbackAsync())
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));
    try (AsyncTransactionManagerImpl manager = new AsyncTransactionManagerImpl(session, span)) {
      manager.beginAsync();
      assertThrows(ExecutionException.class, () -> manager.commitAsync().get());
      assertEquals(TransactionState.COMMIT_FAILED, manager.getState());
      verify(transaction, times(1)).rollbackAsync();
    }
  }

  @Test
  public void testCommitFailsWithCancelledRollsBack() {
    Span oTspan = mock(Span.class);
    ISpan span = new OpenTelemetrySpan(oTspan);
    when(oTspan.makeCurrent()).thenReturn(mock(Scope.class));
    when(session.newTransaction(eq(Options.fromTransactionOptions()), any()))
        .thenReturn(transaction);
    when(transaction.ensureTxnAsync()).thenReturn(ApiFutures.immediateFuture(null));
    when(transaction.commitAsync())
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                SpannerExceptionFactory.newSpannerException(
                    ErrorCode.CANCELLED, "commit cancelled")));
    when(transaction.rollbackAsync())
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));
    try (AsyncTransactionManagerImpl manager = new AsyncTransactionManagerImpl(session, span)) {
      manager.beginAsync();
      assertThrows(ExecutionException.class, () -> manager.commitAsync().get());
      assertEquals(TransactionState.COMMIT_FAILED, manager.getState());
      verify(transaction, times(1)).rollbackAsync();
    }
  }

  @Test
  public void testCommitFailsWithUnavailableRollsBack() {
    Span oTspan = mock(Span.class);
    ISpan span = new OpenTelemetrySpan(oTspan);
    when(oTspan.makeCurrent()).thenReturn(mock(Scope.class));
    when(session.newTransaction(eq(Options.fromTransactionOptions()), any()))
        .thenReturn(transaction);
    when(transaction.ensureTxnAsync()).thenReturn(ApiFutures.immediateFuture(null));
    when(transaction.commitAsync())
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                SpannerExceptionFactory.newSpannerException(
                    ErrorCode.UNAVAILABLE, "commit unavailable")));
    when(transaction.rollbackAsync())
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));
    try (AsyncTransactionManagerImpl manager = new AsyncTransactionManagerImpl(session, span)) {
      manager.beginAsync();
      assertThrows(ExecutionException.class, () -> manager.commitAsync().get());
      assertEquals(TransactionState.COMMIT_FAILED, manager.getState());
      verify(transaction, times(1)).rollbackAsync();
    }
  }

  @Test
  public void testCommitFailsWithResourceExhaustedWithRetryInfoRollsBack() {
    Span oTspan = mock(Span.class);
    ISpan span = new OpenTelemetrySpan(oTspan);
    when(oTspan.makeCurrent()).thenReturn(mock(Scope.class));
    when(session.newTransaction(eq(Options.fromTransactionOptions()), any()))
        .thenReturn(transaction);
    when(transaction.ensureTxnAsync()).thenReturn(ApiFutures.immediateFuture(null));
    when(transaction.commitAsync())
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                TransactionRunnerImplTest.resourceExhaustedWithRetryInfo()));
    when(transaction.rollbackAsync())
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));
    try (AsyncTransactionManagerImpl manager = new AsyncTransactionManagerImpl(session, span)) {
      manager.beginAsync();
      assertThrows(ExecutionException.class, () -> manager.commitAsync().get());
      assertEquals(TransactionState.COMMIT_FAILED, manager.getState());
      verify(transaction, times(1)).rollbackAsync();
    }
  }

  @Test
  public void testCommitFailsWithNonAbortDoesNotRollBack() {
    Span oTspan = mock(Span.class);
    ISpan span = new OpenTelemetrySpan(oTspan);
    when(oTspan.makeCurrent()).thenReturn(mock(Scope.class));
    when(session.newTransaction(eq(Options.fromTransactionOptions()), any()))
        .thenReturn(transaction);
    when(transaction.ensureTxnAsync()).thenReturn(ApiFutures.immediateFuture(null));
    when(transaction.commitAsync())
        .thenReturn(
            ApiFutures.immediateFailedFuture(
                SpannerExceptionFactory.newSpannerException(ErrorCode.UNKNOWN, "unknown error")));
    try (AsyncTransactionManagerImpl manager = new AsyncTransactionManagerImpl(session, span)) {
      manager.beginAsync();
      assertThrows(ExecutionException.class, () -> manager.commitAsync().get());
      assertEquals(TransactionState.COMMIT_FAILED, manager.getState());
    }
    verify(transaction, never()).rollbackAsync();
  }
}
