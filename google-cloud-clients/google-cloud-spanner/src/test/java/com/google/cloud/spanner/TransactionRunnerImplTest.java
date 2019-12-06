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

import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import com.google.cloud.spanner.TransactionRunnerImpl.TransactionContextImpl;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import com.google.rpc.Code;
import com.google.rpc.RetryInfo;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteBatchDmlResponse;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.Transaction;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/** Unit test for {@link com.google.cloud.spanner.SpannerImpl.TransactionRunnerImpl} */
@RunWith(JUnit4.class)
public class TransactionRunnerImplTest {
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

  @Mock private SpannerRpc rpc;
  @Mock private SessionImpl session;
  @Mock private TransactionRunnerImpl.TransactionContextImpl txn;
  private TransactionRunnerImpl transactionRunner;
  private boolean firstRun;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    firstRun = true;
    when(session.newTransaction()).thenReturn(txn);
    transactionRunner = new TransactionRunnerImpl(session, rpc, 1);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void usesPreparedTransaction() {
    SpannerOptions options = mock(SpannerOptions.class);
    when(options.getNumChannels()).thenReturn(4);
    GrpcTransportOptions transportOptions = mock(GrpcTransportOptions.class);
    when(transportOptions.getExecutorFactory()).thenReturn(new TestExecutorFactory());
    when(options.getTransportOptions()).thenReturn(transportOptions);
    SessionPoolOptions sessionPoolOptions =
        SessionPoolOptions.newBuilder().setMinSessions(0).build();
    when(options.getSessionPoolOptions()).thenReturn(sessionPoolOptions);
    when(options.getSessionLabels()).thenReturn(Collections.<String, String>emptyMap());
    SpannerRpc rpc = mock(SpannerRpc.class);
    when(rpc.batchCreateSessions(
            Mockito.anyString(), Mockito.eq(1), Mockito.anyMap(), Mockito.anyMap()))
        .thenAnswer(
            new Answer<List<com.google.spanner.v1.Session>>() {
              @Override
              public List<com.google.spanner.v1.Session> answer(InvocationOnMock invocation)
                  throws Throwable {
                return Arrays.asList(
                    com.google.spanner.v1.Session.newBuilder()
                        .setName((String) invocation.getArguments()[0])
                        .setCreateTime(
                            Timestamp.newBuilder().setSeconds(System.currentTimeMillis() * 1000))
                        .build());
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
                        Timestamp.newBuilder().setSeconds(System.currentTimeMillis() * 1000))
                    .build();
              }
            });
    DatabaseId db = DatabaseId.of("test", "test", "test");
    try (SpannerImpl spanner = new SpannerImpl(rpc, options)) {
      DatabaseClient client = spanner.getDatabaseClient(db);
      client
          .readWriteTransaction()
          .run(
              new TransactionCallable<Void>() {
                @Override
                public Void run(TransactionContext transaction) throws Exception {
                  return null;
                }
              });
      verify(rpc, times(1))
          .beginTransaction(Mockito.any(BeginTransactionRequest.class), Mockito.anyMap());
    }
  }

  @Test
  public void commitSucceeds() {
    final AtomicInteger numCalls = new AtomicInteger(0);
    transactionRunner.run(
        new TransactionCallable<Void>() {
          @Override
          public Void run(TransactionContext transaction) throws Exception {
            numCalls.incrementAndGet();
            return null;
          }
        });
    assertThat(numCalls.get()).isEqualTo(1);
    verify(txn).ensureTxn();
    verify(txn).commit();
  }

  @Test
  public void runAbort() {
    when(txn.isAborted()).thenReturn(true);
    runTransaction(abortedWithRetryInfo());
    verify(txn, times(2)).ensureTxn();
  }

  @Test
  public void commitAbort() {
    final SpannerException error =
        SpannerExceptionFactory.newSpannerException(abortedWithRetryInfo());
    doThrow(error).doNothing().when(txn).commit();
    final AtomicInteger numCalls = new AtomicInteger(0);
    transactionRunner.run(
        new TransactionCallable<Void>() {
          @Override
          public Void run(TransactionContext transaction) throws Exception {
            numCalls.incrementAndGet();
            return null;
          }
        });
    assertThat(numCalls.get()).isEqualTo(2);
    verify(txn, times(2)).ensureTxn();
  }

  @Test
  public void commitFailsWithNonAbort() {
    final SpannerException error =
        SpannerExceptionFactory.newSpannerException(
            SpannerExceptionFactory.newSpannerException(ErrorCode.UNKNOWN, ""));
    doThrow(error).when(txn).commit();
    final AtomicInteger numCalls = new AtomicInteger(0);
    try {
      transactionRunner.run(
          new TransactionCallable<Void>() {
            @Override
            public Void run(TransactionContext transaction) throws Exception {
              numCalls.incrementAndGet();
              return null;
            }
          });
      fail("Expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.UNKNOWN);
    }
    assertThat(numCalls.get()).isEqualTo(1);
    verify(txn, times(1)).ensureTxn();
    verify(txn, times(1)).commit();
  }

  @Test
  public void runResourceExhaustedNoRetry() throws Exception {
    try {
      runTransaction(
          new StatusRuntimeException(Status.fromCodeValue(Status.Code.RESOURCE_EXHAUSTED.value())));
      fail("Expected exception");
    } catch (SpannerException e) {
      // expected.
    }
    verify(txn).rollback();
  }

  @Test
  public void batchDmlAborted() {
    long updateCount[] = batchDmlException(Code.ABORTED_VALUE);
    assertThat(updateCount.length).isEqualTo(2);
    assertThat(updateCount[0]).isEqualTo(1L);
    assertThat(updateCount[1]).isEqualTo(1L);
  }

  @Test
  public void batchDmlFailedPrecondition() {
    try {
      batchDmlException(Code.FAILED_PRECONDITION_VALUE);
      fail("Expected exception");
    } catch (SpannerBatchUpdateException e) {
      assertThat(e.getUpdateCounts().length).isEqualTo(1);
      assertThat(e.getUpdateCounts()[0]).isEqualTo(1L);
      assertThat(e.getCode() == Code.FAILED_PRECONDITION_VALUE);
    }
  }

  @SuppressWarnings("unchecked")
  private long[] batchDmlException(int status) {
    Preconditions.checkArgument(status != Code.OK_VALUE);
    TransactionContextImpl transaction =
        new TransactionContextImpl(
            session, ByteString.copyFromUtf8(UUID.randomUUID().toString()), rpc, 10);
    when(session.newTransaction()).thenReturn(transaction);
    when(session.beginTransaction())
        .thenReturn(ByteString.copyFromUtf8(UUID.randomUUID().toString()));
    when(session.getName()).thenReturn("test");
    TransactionRunnerImpl runner = new TransactionRunnerImpl(session, rpc, 10);
    ExecuteBatchDmlResponse response1 =
        ExecuteBatchDmlResponse.newBuilder()
            .addResultSets(
                ResultSet.newBuilder()
                    .setStats(ResultSetStats.newBuilder().setRowCountExact(1L))
                    .build())
            .setStatus(com.google.rpc.Status.newBuilder().setCode(status).build())
            .build();
    ExecuteBatchDmlResponse response2 =
        ExecuteBatchDmlResponse.newBuilder()
            .addResultSets(
                ResultSet.newBuilder()
                    .setStats(ResultSetStats.newBuilder().setRowCountExact(1L))
                    .build())
            .addResultSets(
                ResultSet.newBuilder()
                    .setStats(ResultSetStats.newBuilder().setRowCountExact(1L))
                    .build())
            .setStatus(com.google.rpc.Status.newBuilder().setCode(Code.OK_VALUE).build())
            .build();
    when(rpc.executeBatchDml(Mockito.any(ExecuteBatchDmlRequest.class), Mockito.anyMap()))
        .thenReturn(response1, response2);
    CommitResponse commitResponse =
        CommitResponse.newBuilder().setCommitTimestamp(Timestamp.getDefaultInstance()).build();
    when(rpc.commit(Mockito.any(CommitRequest.class), Mockito.anyMap())).thenReturn(commitResponse);
    final Statement statement = Statement.of("UPDATE FOO SET BAR=1");
    final AtomicInteger numCalls = new AtomicInteger(0);
    long updateCount[] =
        runner.run(
            new TransactionCallable<long[]>() {
              @Override
              public long[] run(TransactionContext transaction) throws Exception {
                numCalls.incrementAndGet();
                return transaction.batchUpdate(Arrays.asList(statement, statement));
              }
            });
    if (status == Code.ABORTED_VALUE) {
      // Assert that the method ran twice because the first response aborted.
      assertThat(numCalls.get()).isEqualTo(2);
    }
    return updateCount;
  }

  private void runTransaction(final Exception exception) {
    transactionRunner.run(
        new TransactionCallable<Void>() {
          @Override
          public Void run(TransactionContext transaction) throws Exception {
            if (firstRun) {
              firstRun = false;
              throw SpannerExceptionFactory.newSpannerException(exception);
            }
            return null;
          }
        });
  }

  private SpannerException abortedWithRetryInfo() {
    Status status = Status.fromCodeValue(Status.Code.ABORTED.value());
    return SpannerExceptionFactory.newSpannerException(
        ErrorCode.ABORTED, "test", new StatusRuntimeException(status, createRetryTrailers()));
  }

  private Metadata createRetryTrailers() {
    Metadata.Key<RetryInfo> key = ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());
    Metadata trailers = new Metadata();
    RetryInfo retryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(Duration.newBuilder().setNanos(0).setSeconds(0L))
            .build();
    trailers.put(key, retryInfo);
    return trailers;
  }
}
