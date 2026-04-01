/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner.connection.it;

import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.Connection;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITEmulatorConcurrentTransactionsTest extends ITAbstractSpannerTest {
  @Parameters(name = "Use auto-savepoints={0}")
  public static Object[] parameters() {
    return new Object[] {Boolean.TRUE, Boolean.FALSE};
  }

  @Parameter public boolean useAutoSavepointsForEmulator;

  @Override
  public void appendConnectionUri(StringBuilder uri) {
    uri.append(";autoConfigEmulator=true;autoCommit=false;useAutoSavepointsForEmulator=")
        .append(useAutoSavepointsForEmulator);
  }

  @Override
  public boolean doCreateDefaultTestTable() {
    return true;
  }

  @BeforeClass
  public static void onlyOnEmulator() {
    assumeTrue("This test is only intended for the emulator", isUsingEmulator());
  }

  @Before
  public void clearTestData() {
    try (ITConnection connection = createConnection()) {
      connection.bufferedWrite(Mutation.delete("TEST", KeySet.all()));
      connection.commit();
    }
  }

  @Test
  public void testInnerTransaction() {
    try (Connection connection1 = createConnection();
        Connection connection2 = createConnection()) {
      // Run two transactions:
      // 1. First start one transaction.
      // 2. Then start another transaction and commit that transaction.
      // 3. Then commit the first transaction.
      assertEquals(
          1,
          connection1.executeUpdate(Statement.of("insert into test (id, name) values (1, 'One')")));
      assertEquals(
          1,
          connection2.executeUpdate(Statement.of("insert into test (id, name) values (2, 'Two')")));
      connection2.commit();
      connection1.commit();
    }
    verifyRowCount(2L);
  }

  @Test
  public void testOverlappingTransactions() {
    try (Connection connection1 = createConnection();
        Connection connection2 = createConnection()) {
      // Run two transactions:
      // 1. First start one transaction.
      // 2. Then start another transaction.
      // 3. Then commit the first transaction.
      // 4. Then commit the second transaction.
      assertEquals(
          1,
          connection1.executeUpdate(Statement.of("insert into test (id, name) values (1, 'One')")));
      assertEquals(
          1,
          connection2.executeUpdate(Statement.of("insert into test (id, name) values (2, 'Two')")));
      connection1.commit();
      connection2.commit();
    }
    verifyRowCount(2L);
  }

  @Test
  public void testSingleThreadRandomTransactions() {
    AtomicInteger numRowsInserted = new AtomicInteger();
    runRandomTransactions(numRowsInserted);
    verifyRowCount(numRowsInserted.get());
  }

  @Test
  public void testMultiThreadedRandomTransactions() throws Exception {
    int numThreads = ThreadLocalRandom.current().nextInt(10) + 5;
    ExecutorService executor = Executors.newFixedThreadPool(numThreads);
    AtomicInteger numRowsInserted = new AtomicInteger();
    List<Future<?>> futures = new ArrayList<>(numThreads);
    for (int thread = 0; thread < numThreads; thread++) {
      futures.add(executor.submit(() -> runRandomTransactions(numRowsInserted)));
    }
    executor.shutdown();
    assertTrue(executor.awaitTermination(60L, TimeUnit.SECONDS));
    // Get the results of each transaction so the test case fails with a logical error message if
    // any of the transactions failed.
    for (Future<?> future : futures) {
      assertNull(future.get());
    }
    verifyRowCount(numRowsInserted.get());
  }

  private void runRandomTransactions(AtomicInteger numRowsInserted) {
    int numTransactions = ThreadLocalRandom.current().nextInt(25) + 5;
    String sql = "insert into test (id, name) values (@id, 'test')";
    List<Connection> connections = new ArrayList<>(numTransactions);
    try {
      for (int i = 0; i < numTransactions; i++) {
        connections.add(createConnection());
      }
      while (!connections.isEmpty()) {
        int index = ThreadLocalRandom.current().nextInt(connections.size());
        Connection connection = connections.get(index);
        if (ThreadLocalRandom.current().nextInt(10) < 5) {
          connection.commit();
          connection.close();
          assertEquals(connection, connections.remove(index));
        } else {
          assertEquals(
              1,
              connection.executeUpdate(
                  Statement.newBuilder(sql)
                      .bind("id")
                      .to(ThreadLocalRandom.current().nextLong())
                      .build()));
          numRowsInserted.incrementAndGet();
        }
        try {
          // Make sure to have a small wait between statements.
          Thread.sleep(ThreadLocalRandom.current().nextInt(1, 5));
        } catch (InterruptedException interruptedException) {
          throw SpannerExceptionFactory.propagateInterrupt(interruptedException);
        }
      }
    } finally {
      for (Connection connection : connections) {
        connection.close();
      }
    }
  }

  private void verifyRowCount(long expected) {
    try (Connection connection = createConnection()) {
      try (ResultSet resultSet =
          connection.executeQuery(Statement.of("select count(1) from test"))) {
        assertTrue(resultSet.next());
        assertEquals(expected, resultSet.getLong(0));
        assertFalse(resultSet.next());
      }
    }
  }
}
