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

package com.google.cloud.spanner.it;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.common.base.Stopwatch;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITSpannerOptionsTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  @Rule public ExpectedException expectedException = ExpectedException.none();
  private static Database db;

  @Before
  public void setUp() throws Exception {
    db = env.getTestHelper().createTestDatabase();
  }

  @After
  public void tearDown() throws Exception {
    db.drop();
  }

  private static final int NUMBER_OF_TEST_RUNS = 2;
  private static final int DEFAULT_NUM_CHANNELS = 4;
  private static final int NUM_THREADS_PER_CHANNEL = 4;
  private static final String SPANNER_THREAD_NAME = "Cloud-Spanner-TransportChannel";
  private static final String THREAD_PATTERN = "%s-[0-9]+";

  @Test
  public void testCloseAllThreadsWhenClosingSpanner() throws InterruptedException {
    // The IT environment has already started some worker threads.
    int baseThreadCount = getNumberOfThreadsWithName(SPANNER_THREAD_NAME);
    for (int i = 0; i < NUMBER_OF_TEST_RUNS; i++) {
      assertThat(getNumberOfThreadsWithName(SPANNER_THREAD_NAME), is(equalTo(baseThreadCount)));
      // Create Spanner instance.
      // We make a copy of the options instance, as SpannerOptions caches any service object
      // that has been handed out.
      SpannerOptions options = env.getTestHelper().getOptions().toBuilder().build();
      Spanner spanner = options.getService();
      // Get a database client and do a query. This should initiate threads for the Spanner service.
      DatabaseClient client = spanner.getDatabaseClient(db.getId());
      List<ResultSet> resultSets = new ArrayList<>();
      // SpannerStub affiliates a channel with a session, so we need to use multiple sessions
      // to ensure we also hit multiple channels.
      for (int i2 = 0; i2 < options.getSessionPoolOptions().getMaxSessions(); i2++) {
        ResultSet rs =
            client
                .singleUse()
                .executeQuery(Statement.of("SELECT 1 AS COL1 UNION ALL SELECT 2 AS COL2"));
        // Execute ResultSet#next() to send the query to Spanner.
        rs.next();
        // Delay closing the result set in order to force the use of multiple sessions.
        // As each session is linked to one transport channel, using multiple different
        // sessions should initialize multiple transport channels.
        resultSets.add(rs);
        // Check whether the number of expected threads has been reached.
        if (getNumberOfThreadsWithName(SPANNER_THREAD_NAME)
            == DEFAULT_NUM_CHANNELS * NUM_THREADS_PER_CHANNEL + baseThreadCount) {
          break;
        }
      }
      for (ResultSet rs : resultSets) {
        rs.close();
      }
      // Check the number of threads after the query. Doing a request should initialize a thread
      // pool for the underlying SpannerClient.
      assertThat(
          getNumberOfThreadsWithName(SPANNER_THREAD_NAME),
          is(equalTo(DEFAULT_NUM_CHANNELS * NUM_THREADS_PER_CHANNEL + baseThreadCount)));

      // Then do a request to the InstanceAdmin service and check the number of threads.
      // Doing a request should initialize a thread pool for the underlying InstanceAdminClient.
      for (int i2 = 0; i2 < DEFAULT_NUM_CHANNELS * 2; i2++) {
        InstanceAdminClient instanceAdminClient = spanner.getInstanceAdminClient();
        instanceAdminClient.listInstances();
      }
      assertThat(
          getNumberOfThreadsWithName(SPANNER_THREAD_NAME),
          is(equalTo(2 * DEFAULT_NUM_CHANNELS * NUM_THREADS_PER_CHANNEL + baseThreadCount)));

      // Then do a request to the DatabaseAdmin service and check the number of threads.
      // Doing a request should initialize a thread pool for the underlying DatabaseAdminClient.
      for (int i2 = 0; i2 < DEFAULT_NUM_CHANNELS * 2; i2++) {
        DatabaseAdminClient databaseAdminClient = spanner.getDatabaseAdminClient();
        databaseAdminClient.listDatabases(db.getId().getInstanceId().getInstance());
      }
      assertThat(
          getNumberOfThreadsWithName(SPANNER_THREAD_NAME),
          is(equalTo(3 * DEFAULT_NUM_CHANNELS * NUM_THREADS_PER_CHANNEL + baseThreadCount)));

      // Now close the Spanner instance and check whether the threads are shutdown or not.
      spanner.close();
      // Wait a little to allow the threads to actually shutdown.
      Stopwatch watch = Stopwatch.createStarted();
      while (getNumberOfThreadsWithName(SPANNER_THREAD_NAME) > baseThreadCount
          && watch.elapsed(TimeUnit.SECONDS) < 2) {
        Thread.sleep(50L);
      }
      assertThat(getNumberOfThreadsWithName(SPANNER_THREAD_NAME), is(equalTo(baseThreadCount)));
    }
  }

  @Test
  public void testMultipleSpannersFromSameSpannerOptions() throws InterruptedException {
    int baseThreadCount = getNumberOfThreadsWithName(SPANNER_THREAD_NAME);
    SpannerOptions options = env.getTestHelper().getOptions().toBuilder().build();
    try (Spanner spanner1 = options.getService()) {
      // Having both in the try-with-resources block is not possible, as it is the same instance.
      // One will be closed before the other, and the closing of the second instance would fail.
      Spanner spanner2 = options.getService();
      assertThat(spanner1 == spanner2, is(true));
      DatabaseClient client1 = spanner1.getDatabaseClient(db.getId());
      DatabaseClient client2 = spanner2.getDatabaseClient(db.getId());
      assertThat(client1 == client2, is(true));
      try (ResultSet rs1 =
              client1
                  .singleUse()
                  .executeQuery(Statement.of("SELECT 1 AS COL1 UNION ALL SELECT 2 AS COL2"));
          ResultSet rs2 =
              client2
                  .singleUse()
                  .executeQuery(Statement.of("SELECT 1 AS COL1 UNION ALL SELECT 2 AS COL2")); ) {
        while (rs1.next() && rs2.next()) {
          // Do nothing, just consume the result sets.
        }
      }
    }
    Stopwatch watch = Stopwatch.createStarted();
    while (getNumberOfThreadsWithName(SPANNER_THREAD_NAME) > baseThreadCount
        && watch.elapsed(TimeUnit.SECONDS) < 2) {
      Thread.sleep(50L);
    }
    assertThat(getNumberOfThreadsWithName(SPANNER_THREAD_NAME), is(equalTo(baseThreadCount)));
  }

  private int getNumberOfThreadsWithName(String serviceName) {
    Pattern pattern = Pattern.compile(String.format(THREAD_PATTERN, serviceName));
    ThreadGroup group = Thread.currentThread().getThreadGroup();
    while (group.getParent() != null) {
      group = group.getParent();
    }
    Thread[] threads = new Thread[100 * NUMBER_OF_TEST_RUNS];
    int numberOfThreads = group.enumerate(threads);
    int res = 0;
    for (int i = 0; i < numberOfThreads; i++) {
      if (pattern.matcher(threads[i].getName()).matches()) {
        res++;
      }
    }
    return res;
  }
}
