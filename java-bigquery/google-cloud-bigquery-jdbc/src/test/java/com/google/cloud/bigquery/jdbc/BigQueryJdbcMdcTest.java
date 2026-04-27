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
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BigQueryJdbcMdcTest {

  private BigQueryConnection mockConnection1;
  private BigQueryConnection mockConnection2;

  @BeforeEach
  public void setUp() {
    mockConnection1 = Mockito.mock(BigQueryConnection.class);
    mockConnection2 = Mockito.mock(BigQueryConnection.class);
  }

  @AfterEach
  public void tearDown() {
    BigQueryJdbcMdc.clear();
  }

  @Test
  public void testRegisterAndRetrieveConnectionId() {
    BigQueryJdbcMdc.registerInstance(mockConnection1, "123");
    assertEquals("JdbcConnection-123", BigQueryJdbcMdc.getConnectionId());
  }

  @Test
  public void testRemoveInstance() {
    BigQueryJdbcMdc.registerInstance(mockConnection1, "1");
    assertEquals("JdbcConnection-1", BigQueryJdbcMdc.getConnectionId());

    BigQueryJdbcMdc.removeInstance(mockConnection1);
    // Note: removeInstance does not clear currentConnectionId on the current thread
    // based on current implementation.
    assertEquals("JdbcConnection-1", BigQueryJdbcMdc.getConnectionId());

    BigQueryJdbcMdc.clear();
    assertNull(BigQueryJdbcMdc.getConnectionId());
  }

  @Test
  public void testClearContext() {
    BigQueryJdbcMdc.registerInstance(mockConnection1, "456");
    assertEquals("JdbcConnection-456", BigQueryJdbcMdc.getConnectionId());

    BigQueryJdbcMdc.clear();
    assertNull(BigQueryJdbcMdc.getConnectionId());
  }

  @Test
  public void testThreadInheritance() throws InterruptedException {
    BigQueryJdbcMdc.registerInstance(mockConnection1, "parent");
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
    CountDownLatch threadBChecked = new CountDownLatch(1);
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
                BigQueryJdbcMdc.registerInstance(mockConnection1, "A");
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

                BigQueryJdbcMdc.registerInstance(mockConnection2, "B");
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
}
