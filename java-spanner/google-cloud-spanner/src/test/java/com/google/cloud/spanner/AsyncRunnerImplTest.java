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

import static com.google.cloud.spanner.SpannerApiFutures.get;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AsyncRunnerImplTest {
  private static final ExecutorService executor = Executors.newSingleThreadExecutor();

  @AfterClass
  public static void teardown() {
    executor.shutdown();
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testAsyncRunReturnsResultAndCommitResponse() {
    final Object expectedResult = new Object();
    final CommitResponse expectedCommitResponse = mock(CommitResponse.class);

    TransactionRunnerImpl delegate = mock(TransactionRunnerImpl.class);
    when(delegate.run(any(TransactionCallable.class))).thenReturn(expectedResult);
    when(delegate.getCommitResponse()).thenReturn(expectedCommitResponse);

    AsyncRunnerImpl runner = new AsyncRunnerImpl(delegate);
    ApiFuture<Object> result =
        runner.runAsync(txn -> ApiFutures.immediateFuture(expectedResult), executor);

    assertSame(expectedResult, get(result));
    assertSame(expectedCommitResponse, get(runner.getCommitResponse()));
    assertEquals(
        get(runner.getCommitResponse()).getCommitTimestamp(), get(runner.getCommitTimestamp()));
  }

  @Test
  public void testGetCommitTimestampReturnsErrorBeforeRun() {
    TransactionRunnerImpl delegate = mock(TransactionRunnerImpl.class);
    AsyncRunnerImpl runner = new AsyncRunnerImpl(delegate);
    IllegalStateException e =
        assertThrows(IllegalStateException.class, () -> runner.getCommitTimestamp());
    assertTrue(e.getMessage().contains("runAsync() has not yet been called"));
  }

  @Test
  public void testGetCommitResponseReturnsErrorBeforeRun() {
    TransactionRunnerImpl delegate = mock(TransactionRunnerImpl.class);
    AsyncRunnerImpl runner = new AsyncRunnerImpl(delegate);
    IllegalStateException e =
        assertThrows(IllegalStateException.class, () -> runner.getCommitResponse());
    assertTrue(e.getMessage().contains("runAsync() has not yet been called"));
  }

  @Test
  public void testGetCommitResponseReturnsErrorIfRunFails() {
    final SpannerException expectedException =
        SpannerExceptionFactory.newSpannerException(ErrorCode.ALREADY_EXISTS, "Row already exists");

    TransactionRunnerImpl delegate = mock(TransactionRunnerImpl.class);
    when(delegate.getCommitResponse()).thenThrow(expectedException);

    AsyncRunnerImpl runner = new AsyncRunnerImpl(delegate);
    runner.runAsync(txn -> ApiFutures.immediateFailedFuture(expectedException), executor);

    SpannerException e =
        assertThrows(SpannerException.class, () -> get(runner.getCommitResponse()));
    assertSame(expectedException, e);
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testRunAsyncFailsIfCalledMultipleTimes() {
    final Object result = new Object();
    TransactionRunnerImpl delegate = mock(TransactionRunnerImpl.class);
    when(delegate.run(any(TransactionCallable.class))).thenReturn(result);

    AsyncRunnerImpl runner = new AsyncRunnerImpl(delegate);
    runner.runAsync(txn -> ApiFutures.immediateFuture(result), executor);

    IllegalStateException e =
        assertThrows(
            IllegalStateException.class,
            () -> runner.runAsync(txn -> ApiFutures.immediateFuture(null), executor));
    assertTrue(e.getMessage().contains("runAsync() can only be called once"));
  }
}
