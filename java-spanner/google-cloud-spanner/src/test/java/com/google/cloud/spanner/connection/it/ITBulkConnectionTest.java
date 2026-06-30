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

package com.google.cloud.spanner.connection.it;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SerialIntegrationTest;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Test opening multiple generic (not JDBC) Spanner connections. This test should not be run in
 * parallel with other tests in the same JVM, as it tries to close all active connections, and
 * should not try to close connections of other integration tests.
 */
@Category(SerialIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITBulkConnectionTest extends ITAbstractSpannerTest {
  private static final int NUMBER_OF_TEST_CONNECTIONS = 250;

  @Test
  public void testBulkCreateConnectionsSingleThreaded() {
    List<ITConnection> connections = new ArrayList<>();
    for (int i = 0; i < NUMBER_OF_TEST_CONNECTIONS; i++) {
      connections.add(createConnection());
    }
    for (ITConnection connection : connections) {
      try (ResultSet rs = connection.executeQuery(Statement.of("select 1"))) {
        assertThat(rs.next(), is(true));
        assertThat(connection.getReadTimestamp(), is(notNullValue()));
      }
    }
    for (ITConnection connection : connections) {
      connection.close();
    }
    // close Spanner instances explicitly. This method will throw an exception if there are any
    // connections still open in the pool
    closeSpanner();
  }

  @Test
  public void testBulkCreateConnectionsMultiThreaded() throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(50);
    for (int i = 0; i < NUMBER_OF_TEST_CONNECTIONS; i++) {
      executor.submit(
          () -> {
            try (ITConnection connection = createConnection()) {
              try (ResultSet rs = connection.executeQuery(Statement.of("select 1"))) {
                assertThat(rs.next(), is(true));
                assertThat(connection.getReadTimestamp(), is(notNullValue()));
              }
            }
            return null;
          });
    }
    executor.shutdown();
    executor.awaitTermination(10L, TimeUnit.SECONDS);
    // close Spanner instances explicitly. This method will throw an exception if there are any
    // connections still open in the pool
    closeSpanner();
  }
}
