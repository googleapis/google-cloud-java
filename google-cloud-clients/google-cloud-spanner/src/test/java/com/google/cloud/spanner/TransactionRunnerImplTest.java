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
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.client.util.BackOff;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import io.grpc.Context;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/** Unit test for {@link com.google.cloud.spanner.SpannerImpl.TransactionRunnerImpl} */
@RunWith(JUnit4.class)
public class TransactionRunnerImplTest {
  @Mock private SpannerRpc rpc;
  @Mock private SpannerImpl.SessionImpl session;
  @Mock private TransactionRunnerImpl.Sleeper sleeper;
  @Mock private TransactionRunnerImpl.TransactionContextImpl txn;
  private TransactionRunnerImpl transactionRunner;
  private boolean firstRun;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    firstRun = true;
    when(session.newTransaction()).thenReturn(txn);
    transactionRunner = new TransactionRunnerImpl(session, rpc, sleeper, 1);
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
    long backoffMillis = 100L;
    when(txn.getRetryDelayInMillis(any(BackOff.class))).thenReturn(backoffMillis);
    runTransaction(SpannerExceptionFactory.newSpannerException(ErrorCode.ABORTED, ""));
    verify(sleeper, times(1)).backoffSleep(any(Context.class), eq(backoffMillis));
  }

  @Test
  public void commitAbort() {
    final SpannerException error =
        SpannerExceptionFactory.newSpannerException(
            SpannerExceptionFactory.newSpannerException(ErrorCode.ABORTED, ""));
    doThrow(error).doNothing().when(txn).commit();
    long backoffMillis = 100L;
    when(txn.getRetryDelayInMillis(any(BackOff.class))).thenReturn(backoffMillis);
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
    verify(sleeper, times(1)).backoffSleep(any(Context.class), eq(backoffMillis));
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
}
