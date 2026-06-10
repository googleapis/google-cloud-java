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
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class BigQueryJdbcMdcTest extends BigQueryJdbcLoggingBaseTest {

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

  @Test
  public void testPoolThreadInheritanceSevered() throws Exception {
    BigQueryJdbcMdc.registerInstance("JdbcConnection-ParentContext");
    ExecutorService executor = BigQueryJdbcMdc.newFixedThreadPool(1);
    try {
      CountDownLatch initLatch = new CountDownLatch(1);
      executor.execute(initLatch::countDown);
      assertTrue(initLatch.await(5, TimeUnit.SECONDS));

      BigQueryJdbcMdc.clear();

      CountDownLatch taskLatch = new CountDownLatch(1);
      AtomicReference<String> workerMdcVal = new AtomicReference<>("initial-non-null");
      executor.execute(
          () -> {
            workerMdcVal.set(BigQueryJdbcMdc.getConnectionId());
            taskLatch.countDown();
          });

      assertTrue(taskLatch.await(5, TimeUnit.SECONDS));
      assertNull(workerMdcVal.get());
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  public void testConnectionScopedExecutorLifecycle() throws Exception {
    String url1 =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=Proj1;"
            + "OAuthAccessToken=redacted;OAuthClientId=redacted;OAuthClientSecret=redacted;"
            + "metadataFetchThreadCount=5;queryExecutionThreadCount=6;";
    String url2 =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=Proj2;"
            + "OAuthAccessToken=redacted;OAuthClientId=redacted;OAuthClientSecret=redacted;"
            + "metadataFetchThreadCount=10;queryExecutionThreadCount=12;";

    BigQueryConnection conn1 = new BigQueryConnection(url1);
    BigQueryConnection conn2 = new BigQueryConnection(url2);

    try {
      ExecutorService exec1 = conn1.getExecutorService();
      ExecutorService exec2 = conn2.getExecutorService();
      ExecutorService metadataExec1 = conn1.getMetadataExecutor();
      ExecutorService metadataExec2 = conn2.getMetadataExecutor();

      assertTrue(exec1 != exec2);
      assertTrue(exec1 instanceof ThreadPoolExecutor);
      assertTrue(exec2 instanceof ThreadPoolExecutor);
      assertTrue(metadataExec1 instanceof ThreadPoolExecutor);
      assertTrue(metadataExec2 instanceof ThreadPoolExecutor);

      assertEquals(6, ((ThreadPoolExecutor) exec1).getCorePoolSize());
      assertEquals(12, ((ThreadPoolExecutor) exec2).getCorePoolSize());
      assertEquals(5, ((ThreadPoolExecutor) metadataExec1).getCorePoolSize());
      assertEquals(10, ((ThreadPoolExecutor) metadataExec2).getCorePoolSize());

      try (BigQueryJdbcMdc.MdcCloseable mdc =
          BigQueryJdbcMdc.registerInstance(conn1.getConnectionId())) {
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<String> workerMdc = new AtomicReference<>();
        exec1.execute(
            () -> {
              workerMdc.set(BigQueryJdbcMdc.getConnectionId());
              latch.countDown();
            });
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        assertEquals(conn1.getConnectionId(), workerMdc.get());
      }
    } finally {
      try {
        conn1.close();
      } finally {
        conn2.close();
      }
    }

    assertTrue(conn1.getExecutorService().isShutdown());
    assertTrue(conn1.getMetadataExecutor().isShutdown());
    assertTrue(conn2.getExecutorService().isShutdown());
    assertTrue(conn2.getMetadataExecutor().isShutdown());
  }

  @Test
  public void testThreadPoolSaturatingWarning() throws Exception {
    ExecutorService executor = BigQueryJdbcMdc.newFixedThreadPool(1);
    try {
      CountDownLatch blockLatch = new CountDownLatch(1);

      // 1. Submit a task to occupy the single thread
      executor.execute(
          () -> {
            try {
              blockLatch.await();
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          });

      // 2. Submit 11 tasks to fill the queue and trigger the warning threshold of 10 (Math.max(10,
      // 1 * 5))
      for (int i = 0; i < 11; i++) {
        executor.execute(() -> {});
      }

      blockLatch.countDown();

      // Verify that warning was logged
      assertTrue(
          assertLogContains("Thread pool is saturating"),
          "Warning message about thread pool saturation was not logged");
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  public void testThreadPoolHysteresisWarning() throws Exception {
    ExecutorService executor = BigQueryJdbcMdc.newFixedThreadPool(1);
    try {
      CountDownLatch blockLatch1 = new CountDownLatch(1);

      // 1. Submit a task to occupy the single thread
      executor.execute(
          () -> {
            try {
              blockLatch1.await();
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          });

      // 2. Submit 11 tasks (queue size becomes 10 upon 11th task submission)
      for (int i = 0; i < 11; i++) {
        executor.execute(() -> {});
      }

      // Verify that warning was logged
      assertTrue(
          assertLogContains("Thread pool is saturating"),
          "Warning message about thread pool saturation was not logged");

      // Clear the captured logs
      capturedLogs.clear();

      // Release the latch and wait for all tasks to complete, draining the queue to 0 (which is <=
      // recovery threshold)
      blockLatch1.countDown();

      // To ensure all tasks have finished, we submit a final task and wait for its completion
      CountDownLatch syncLatch = new CountDownLatch(1);
      executor.execute(syncLatch::countDown);
      assertTrue(syncLatch.await(5, TimeUnit.SECONDS));

      // Now the queue is empty. Let's block the thread again and submit 11 tasks.
      CountDownLatch blockLatch2 = new CountDownLatch(1);
      executor.execute(
          () -> {
            try {
              blockLatch2.await();
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          });

      for (int i = 0; i < 11; i++) {
        executor.execute(() -> {});
      }

      // Verify warning was logged a second time because the flag was reset
      assertTrue(
          assertLogContains("Thread pool is saturating"),
          "Warning message about thread pool saturation was not logged after recovery");

      blockLatch2.countDown();
    } finally {
      executor.shutdownNow();
    }
  }
}
