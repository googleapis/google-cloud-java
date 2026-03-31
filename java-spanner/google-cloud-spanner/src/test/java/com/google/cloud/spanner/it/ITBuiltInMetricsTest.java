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

package com.google.cloud.spanner.it;

import static com.google.cloud.spanner.testing.ExperimentalHostHelper.isExperimentalHost;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.cloud.spanner.*;
import com.google.cloud.spanner.testing.EmulatorSpannerHelper;
import com.google.common.base.Stopwatch;
import com.google.monitoring.v3.ListTimeSeriesRequest;
import com.google.monitoring.v3.ListTimeSeriesResponse;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.TimeInterval;
import com.google.protobuf.util.Timestamps;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITBuiltInMetricsTest {

  private static Database db;
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();

  private static DatabaseClient client;

  private static MetricServiceClient metricClient;

  private static java.util.List<String> METRICS =
      new java.util.ArrayList<String>() {
        {
          add("operation_latencies");
          add("attempt_latencies");
          add("operation_count");
          add("attempt_count");
          add("afe_latencies");
        }
      };

  @BeforeClass
  public static void setUp() throws IOException {
    assumeFalse("not applicable for experimental host", isExperimentalHost());
    assumeFalse("This test requires credentials", EmulatorSpannerHelper.isUsingEmulator());
    metricClient = MetricServiceClient.create();
    // Enable BuiltinMetrics when the metrics are GA'ed
    db = env.getTestHelper().createTestDatabase();
    client = env.getTestHelper().getDatabaseClient(db);
    if (!env.getTestHelper().getOptions().isEnableDirectAccess()) {
      METRICS.add("gfe_latencies");
    }
  }

  @After
  public void tearDown() {
    if (metricClient != null) {
      metricClient.close();
    }
  }

  @Test
  public void testBuiltinMetricsWithDefaultOTEL() throws Exception {
    // This stopwatch is used for to limit fetching of metric data in verifyMetrics
    Stopwatch metricsPollingStopwatch = Stopwatch.createStarted();
    Instant start = Instant.now().minus(Duration.ofMinutes(2));
    Instant end = Instant.now().plus(Duration.ofMinutes(3));
    ProjectName name = ProjectName.of(env.getTestHelper().getOptions().getProjectId());

    TimeInterval interval =
        TimeInterval.newBuilder()
            .setStartTime(Timestamps.fromMillis(start.toEpochMilli()))
            .setEndTime(Timestamps.fromMillis(end.toEpochMilli()))
            .build();

    client
        .readWriteTransaction()
        .run(transaction -> transaction.executeQuery(Statement.of("Select 1")));

    for (String metric : METRICS) {
      String metricFilter =
          String.format(
              "metric.type=\"spanner.googleapis.com/client/%s\""
                  + " AND resource.type=\"spanner_instance\""
                  + " AND metric.labels.method=\"Spanner.Commit\""
                  + " AND resource.labels.instance_id=\"%s\""
                  + " AND metric.labels.database=\"%s\"",
              metric, db.getId().getInstanceId().getInstance(), db.getId().getDatabase());

      ListTimeSeriesRequest.Builder requestBuilder =
          ListTimeSeriesRequest.newBuilder()
              .setName(name.toString())
              .setFilter(metricFilter)
              .setInterval(interval)
              .setView(ListTimeSeriesRequest.TimeSeriesView.FULL);

      ListTimeSeriesRequest request = requestBuilder.build();

      ListTimeSeriesResponse response = metricClient.listTimeSeriesCallable().call(request);
      while (response.getTimeSeriesCount() == 0
          && metricsPollingStopwatch.elapsed(TimeUnit.MINUTES) < 3) {
        // Call listTimeSeries every minute
        Thread.sleep(Duration.ofMinutes(1).toMillis());
        response = metricClient.listTimeSeriesCallable().call(request);
      }

      assertWithMessage("Metric " + metric + " didn't return any data.")
          .that(response.getTimeSeriesCount())
          .isGreaterThan(0);
    }
  }
}
