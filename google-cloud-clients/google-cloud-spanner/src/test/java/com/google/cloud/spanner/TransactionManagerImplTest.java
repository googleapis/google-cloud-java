/*
 * Copyright 2017 Google LLC
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
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.cloud.Timestamp;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import com.google.cloud.spanner.TransactionManager.TransactionState;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.Transaction;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@RunWith(JUnit4.class)
public class TransactionManagerImplTest {
  private static final class TestExecutorFactory
      implements ExecutorFactory<ScheduledExecutorService> {
    @Override
    public ScheduledExecutorService get() {
      return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void release(ScheduledExecutorService exec) {
      exec.shutdown();
    }
  }

  @Rule public ExpectedException exception = ExpectedException.none();

  @Mock private SessionImpl session;
  @Mock TransactionRunnerImpl.TransactionContextImpl txn;
  private TransactionManagerImpl manager;

  @Before
  public void setUp() {
    initMocks(this);
    manager = new TransactionManagerImpl(session);
  }

  @Test
  public void beginCalledTwiceFails() {
    when(session.newTransaction()).thenReturn(txn);
    assertThat(manager.begin()).isEqualTo(txn);
    assertThat(manager.getState()).isEqualTo(TransactionState.STARTED);
    exception.expect(IllegalStateException.class);
    manager.begin();
  }

  @Test
  public void commitBeforeBeginFails() {
    exception.expect(IllegalStateException.class);
    manager.commit();
  }

  @Test
  public void rollbackBeforeBeginFails() {
    exception.expect(IllegalStateException.class);
    manager.rollback();
  }

  @Test
  public void resetBeforeBeginFails() {
    exception.expect(IllegalStateException.class);
    manager.resetForRetry();
  }

  @Test
  public void transactionRolledBackOnClose() {
    when(session.newTransaction()).thenReturn(txn);
    when(txn.isAborted()).thenReturn(false);
    manager.begin();
    manager.close();
    verify(txn).rollback();
  }

  @Test
  public void commitSucceeds() {
    when(session.newTransaction()).thenReturn(txn);
    Timestamp commitTimestamp = Timestamp.ofTimeMicroseconds(1);
    when(txn.commitTimestamp()).thenReturn(commitTimestamp);
    manager.begin();
    manager.commit();
    assertThat(manager.getState()).isEqualTo(TransactionState.COMMITTED);
    assertThat(manager.getCommitTimestamp()).isEqualTo(commitTimestamp);
  }

  @Test
  public void resetAfterSuccessfulCommitFails() {
    when(session.newTransaction()).thenReturn(txn);
    manager.begin();
    manager.commit();
    exception.expect(IllegalStateException.class);
    manager.resetForRetry();
  }

  @Test
  public void resetAfterAbortSucceeds() {
    when(session.newTransaction()).thenReturn(txn);
    manager.begin();
    doThrow(SpannerExceptionFactory.newSpannerException(ErrorCode.ABORTED, "")).when(txn).commit();
    try {
      manager.commit();
      fail("Expected AbortedException");
    } catch (AbortedException e) {
      assertThat(manager.getState()).isEqualTo(TransactionState.ABORTED);
    }
    txn = Mockito.mock(TransactionRunnerImpl.TransactionContextImpl.class);
    when(session.newTransaction()).thenReturn(txn);
    assertThat(manager.resetForRetry()).isEqualTo(txn);
    assertThat(manager.getState()).isEqualTo(TransactionState.STARTED);
  }

  @Test
  public void resetAfterErrorFails() {
    when(session.newTransaction()).thenReturn(txn);
    manager.begin();
    doThrow(SpannerExceptionFactory.newSpannerException(ErrorCode.UNKNOWN, "")).when(txn).commit();
    try {
      manager.commit();
      fail("Expected AbortedException");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.UNKNOWN);
    }
    exception.expect(IllegalStateException.class);
    manager.resetForRetry();
  }

  @Test
  public void rollbackAfterCommitFails() {
    when(session.newTransaction()).thenReturn(txn);
    manager.begin();
    manager.commit();
    exception.expect(IllegalStateException.class);
    manager.rollback();
  }

  @Test
  public void commitAfterRollbackFails() {
    when(session.newTransaction()).thenReturn(txn);
    manager.begin();
    manager.rollback();
    exception.expect(IllegalStateException.class);
    manager.commit();
  }

  @SuppressWarnings("unchecked")
  @Test
  public void usesPreparedTransaction() {
    SpannerOptions options = mock(SpannerOptions.class);
    GrpcTransportOptions transportOptions = mock(GrpcTransportOptions.class);
    when(transportOptions.getExecutorFactory()).thenReturn(new TestExecutorFactory());
    when(options.getTransportOptions()).thenReturn(transportOptions);
    SessionPoolOptions sessionPoolOptions =
        SessionPoolOptions.newBuilder().setMinSessions(0).build();
    when(options.getSessionPoolOptions()).thenReturn(sessionPoolOptions);
    SpannerRpc rpc = mock(SpannerRpc.class);
    when(rpc.createSession(Mockito.anyString(), Mockito.anyMap(), Mockito.anyMap()))
        .thenAnswer(
            new Answer<com.google.spanner.v1.Session>() {
              @Override
              public com.google.spanner.v1.Session answer(InvocationOnMock invocation)
                  throws Throwable {
                return com.google.spanner.v1.Session.newBuilder()
                    .setName((String) invocation.getArguments()[0])
                    .setCreateTime(
                        com.google.protobuf.Timestamp.newBuilder()
                            .setSeconds(System.currentTimeMillis() * 1000))
                    .build();
              }
            });
    when(rpc.beginTransaction(Mockito.any(BeginTransactionRequest.class), Mockito.anyMap()))
        .thenAnswer(
            new Answer<Transaction>() {
              @Override
              public Transaction answer(InvocationOnMock invocation) throws Throwable {
                return Transaction.newBuilder()
                    .setId(ByteString.copyFromUtf8(UUID.randomUUID().toString()))
                    .build();
              }
            });
    when(rpc.commit(Mockito.any(CommitRequest.class), Mockito.anyMap()))
        .thenAnswer(
            new Answer<CommitResponse>() {
              @Override
              public CommitResponse answer(InvocationOnMock invocation) throws Throwable {
                return CommitResponse.newBuilder()
                    .setCommitTimestamp(
                        com.google.protobuf.Timestamp.newBuilder()
                            .setSeconds(System.currentTimeMillis() * 1000))
                    .build();
              }
            });
    DatabaseId db = DatabaseId.of("test", "test", "test");
    try (SpannerImpl spanner = new SpannerImpl(rpc, options)) {
      DatabaseClient client = spanner.getDatabaseClient(db);
      try (TransactionManager mgr = client.transactionManager()) {
        mgr.begin();
        mgr.commit();
      }
      verify(rpc, times(1))
          .beginTransaction(Mockito.any(BeginTransactionRequest.class), Mockito.anyMap());
    }
  }
}
