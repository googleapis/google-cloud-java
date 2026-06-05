/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class BigQueryJdbcMdcTest {

  @AfterEach
  public void tearDown() {
    BigQueryJdbcMdc.clear();
  }

  @Test
  public void testRegisterAndRetrieveConnectionId() {
    BigQueryJdbcMdc.registerInstance("JdbcConnection-123");
    assertEquals("JdbcConnection-123", BigQueryJdbcMdc.getConnectionId());
  }

  @Test
  public void testClearContext() {
    BigQueryJdbcMdc.registerInstance("JdbcConnection-456");
    assertEquals("JdbcConnection-456", BigQueryJdbcMdc.getConnectionId());
    BigQueryJdbcMdc.clear();
    assertNull(BigQueryJdbcMdc.getConnectionId());
  }

  @Test
  public void testThreadInheritance() throws InterruptedException {
    BigQueryJdbcMdc.registerInstance("JdbcConnection-parent");
    assertEquals("JdbcConnection-parent", BigQueryJdbcMdc.getConnectionId());

    AtomicReference<String> childConnectionId = new AtomicReference<>();
    CountDownLatch latch = new CountDownLatch(1);

    Thread childThread =
        new Thread(
            () -> {
              childConnectionId.set(BigQueryJdbcMdc.getConnectionId());
              latch.countDown();
            });
    childThread.start();
    assertTrue(latch.await(5, TimeUnit.SECONDS));

    assertEquals("JdbcConnection-parent", childConnectionId.get());
  }

  @Test
  public void testThreadIsolation() throws InterruptedException {
    CountDownLatch threadARegistered = new CountDownLatch(1);
    CountDownLatch threadBRegistered = new CountDownLatch(1);
    CountDownLatch testFinished = new CountDownLatch(2);

    AtomicReference<String> threadAIdBeforeB = new AtomicReference<>();
    AtomicReference<String> threadAIdAfterB = new AtomicReference<>();
    AtomicReference<String> threadBIdBeforeRegister = new AtomicReference<>();
    AtomicReference<String> threadBIdAfterRegister = new AtomicReference<>();

    Thread threadA =
        new Thread(
            () -> {
              try {
                BigQueryJdbcMdc.registerInstance("JdbcConnection-A");
                threadAIdBeforeB.set(BigQueryJdbcMdc.getConnectionId());
                threadARegistered.countDown();

                threadBRegistered.await();
                threadAIdAfterB.set(BigQueryJdbcMdc.getConnectionId());
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              } finally {
                testFinished.countDown();
              }
            });

    Thread threadB =
        new Thread(
            () -> {
              try {
                threadARegistered.await();
                threadBIdBeforeRegister.set(BigQueryJdbcMdc.getConnectionId());

                BigQueryJdbcMdc.registerInstance("JdbcConnection-B");
                threadBIdAfterRegister.set(BigQueryJdbcMdc.getConnectionId());
                threadBRegistered.countDown();
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              } finally {
                testFinished.countDown();
              }
            });

    threadA.start();
    threadB.start();

    assertTrue(testFinished.await(5, TimeUnit.SECONDS));

    assertEquals("JdbcConnection-A", threadAIdBeforeB.get());
    assertNull(threadBIdBeforeRegister.get());
    assertEquals("JdbcConnection-B", threadBIdAfterRegister.get());
    assertEquals("JdbcConnection-A", threadAIdAfterB.get());
  }

  @Test
  public void testMdcCloseableClearsContext() {
    try (BigQueryJdbcMdc.MdcCloseable mdc =
        BigQueryJdbcMdc.registerInstance("JdbcConnection-789")) {
      assertEquals("JdbcConnection-789", BigQueryJdbcMdc.getConnectionId());
    }
    assertNull(BigQueryJdbcMdc.getConnectionId());
  }

  @Test
  public void testExecutorPropagatesMdc() throws Exception {
    BigQueryJdbcMdc.registerInstance("JdbcConnection-Executor-Test");
    ExecutorService executor = BigQueryJdbcMdc.newFixedThreadPool(2);

    try {
      // Test Runnable submission
      CountDownLatch runnableLatch = new CountDownLatch(1);
      AtomicReference<String> runnableMdcVal = new AtomicReference<>();
      executor.execute(
          () -> {
            runnableMdcVal.set(BigQueryJdbcMdc.getConnectionId());
            runnableLatch.countDown();
          });
      assertTrue(runnableLatch.await(5, TimeUnit.SECONDS));
      assertEquals("JdbcConnection-Executor-Test", runnableMdcVal.get());

      // Test Callable submission
      Future<String> callableFuture =
          executor.submit(
              () -> {
                return BigQueryJdbcMdc.getConnectionId();
              });
      assertEquals("JdbcConnection-Executor-Test", callableFuture.get(5, TimeUnit.SECONDS));

      // Test context is cleared on worker thread after task completion
      CountDownLatch cleanupLatch = new CountDownLatch(1);
      AtomicReference<String> postTaskMdcVal = new AtomicReference<>("initial-non-null");
      executor.execute(
          () -> {
            // Run a task on a potentially reused thread
            postTaskMdcVal.set(BigQueryJdbcMdc.getConnectionId());
            cleanupLatch.countDown();
          });
      assertTrue(cleanupLatch.await(5, TimeUnit.SECONDS));
      // Since the main thread has context set, the second task will also capture and set it.
      // Let's clear the context on the main thread, and submit a task to check if the thread-local
      // is clean for a thread that has previously executed tasks.
      BigQueryJdbcMdc.clear();
      CountDownLatch cleanMainLatch = new CountDownLatch(1);
      AtomicReference<String> cleanThreadMdcVal = new AtomicReference<>("initial-non-null");
      executor.execute(
          () -> {
            cleanThreadMdcVal.set(BigQueryJdbcMdc.getConnectionId());
            cleanMainLatch.countDown();
          });
      assertTrue(cleanMainLatch.await(5, TimeUnit.SECONDS));
      // It should be null because the submitting thread had no context set,
      // and the previous task's close() call cleaned the ThreadLocal.
      assertNull(cleanThreadMdcVal.get());

    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  public void testExecutorThrowsNpeOnNullCommand() {
    ExecutorService executor = BigQueryJdbcMdc.newFixedThreadPool(2);
    try {
      assertThrows(NullPointerException.class, () -> executor.execute(null));
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  public void testExecutorWrapsCustomRunnableFuture() throws Exception {
    BigQueryJdbcMdc.registerInstance("JdbcConnection-CustomFuture-Test");
    ExecutorService executor = BigQueryJdbcMdc.newFixedThreadPool(2);
    try {
      CountDownLatch latch = new CountDownLatch(1);
      AtomicReference<String> mdcVal = new AtomicReference<>();
      RunnableFuture<Void> customFuture =
          new FutureTask<>(
              () -> {
                mdcVal.set(BigQueryJdbcMdc.getConnectionId());
                latch.countDown();
              },
              null);

      executor.execute(customFuture);
      assertTrue(latch.await(5, TimeUnit.SECONDS));
      assertEquals("JdbcConnection-CustomFuture-Test", mdcVal.get());
    } finally {
      executor.shutdownNow();
    }
  }
}
