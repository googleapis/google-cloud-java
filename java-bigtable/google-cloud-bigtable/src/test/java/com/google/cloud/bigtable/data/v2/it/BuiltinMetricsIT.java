/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.it;

import static com.google.common.truth.Truth.assertWithMessage;
import static com.google.common.truth.TruthJUnit.assume;

import com.google.api.client.util.Lists;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.PrefixGenerator;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.common.base.Stopwatch;
import com.google.monitoring.v3.ListTimeSeriesRequest;
import com.google.monitoring.v3.ListTimeSeriesResponse;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.TimeInterval;
import com.google.protobuf.util.Timestamps;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class BuiltinMetricsIT {
  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();

  private static final Logger logger = Logger.getLogger(BuiltinMetricsIT.class.getName());

  @Rule public Timeout globalTimeout = Timeout.seconds(900);
  private static Table table;
  private static BigtableTableAdminClient tableAdminClient;
  private static MetricServiceClient metricClient;

  public static String[] VIEWS = {
    "operation_latencies",
    "attempt_latencies",
    "connectivity_error_count",
    "application_blocking_latencies"
  };

  @BeforeClass
  public static void setUpClass() throws IOException {
    assume()
        .withMessage("Builtin metrics integration test is not supported by emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    // Enable built in metrics
    BigtableDataSettings.enableBuiltinMetrics();

    // Create a cloud monitoring client
    metricClient = MetricServiceClient.create();

    tableAdminClient = testEnvRule.env().getTableAdminClient();
  }

  @AfterClass
  public static void tearDown() {
    if (metricClient != null) {
      metricClient.close();
    }
    if (table != null) {
      tableAdminClient.deleteTable(table.getId());
    }
  }

  @Test
  public void testBuiltinMetrics() throws Exception {
    logger.info("Started testing builtin metrics");
    table =
        tableAdminClient.createTable(
            CreateTableRequest.of(PrefixGenerator.newPrefix("BuiltinMetricsIT#test"))
                .addFamily("cf"));
    logger.info("Create table: " + table.getId());
    // Send a MutateRow and ReadRows request
    testEnvRule
        .env()
        .getDataClient()
        .mutateRow(RowMutation.create(table.getId(), "a-new-key").setCell("cf", "q", "abc"));
    ArrayList<Row> rows =
        Lists.newArrayList(
            testEnvRule.env().getDataClient().readRows(Query.create(table.getId()).limit(10)));

    Stopwatch stopwatch = Stopwatch.createStarted();

    ProjectName name = ProjectName.of(testEnvRule.env().getProjectId());

    // Restrict time to last 10 minutes and 5 minutes after the request
    long startMillis = System.currentTimeMillis() - Duration.ofMinutes(10).toMillis();
    long endMillis = startMillis + Duration.ofMinutes(15).toMillis();
    TimeInterval interval =
        TimeInterval.newBuilder()
            .setStartTime(Timestamps.fromMillis(startMillis))
            .setEndTime(Timestamps.fromMillis(endMillis))
            .build();

    for (String view : VIEWS) {
      // Filter on instance and method name
      // Verify that metrics are published for MutateRow request
      String metricFilter =
          String.format(
              "metric.type=\"bigtable.googleapis.com/client/%s\" "
                  + "AND resource.labels.instance=\"%s\" AND metric.labels.method=\"Bigtable.MutateRow\""
                  + " AND resource.labels.table=\"%s\"",
              view, testEnvRule.env().getInstanceId(), table.getId());
      ListTimeSeriesRequest.Builder requestBuilder =
          ListTimeSeriesRequest.newBuilder()
              .setName(name.toString())
              .setFilter(metricFilter)
              .setInterval(interval)
              .setView(ListTimeSeriesRequest.TimeSeriesView.FULL);

      verifyMetricsArePublished(requestBuilder.build(), stopwatch, view);

      // Verify that metrics are published for ReadRows request
      metricFilter =
          String.format(
              "metric.type=\"bigtable.googleapis.com/client/%s\" "
                  + "AND resource.labels.instance=\"%s\" AND metric.labels.method=\"Bigtable.ReadRows\""
                  + " AND resource.labels.table=\"%s\"",
              view, testEnvRule.env().getInstanceId(), table.getId());
      requestBuilder.setFilter(metricFilter);

      verifyMetricsArePublished(requestBuilder.build(), stopwatch, view);
    }
  }

  private void verifyMetricsArePublished(
      ListTimeSeriesRequest request, Stopwatch stopwatch, String view) throws Exception {
    ListTimeSeriesResponse response = metricClient.listTimeSeriesCallable().call(request);
    logger.log(
        Level.INFO,
        "Checking for view "
            + view
            + ", has timeseries="
            + response.getTimeSeriesCount()
            + " stopwatch elapsed "
            + stopwatch.elapsed(TimeUnit.MINUTES));
    while (response.getTimeSeriesCount() == 0 && stopwatch.elapsed(TimeUnit.MINUTES) < 10) {
      // Call listTimeSeries every minute
      Thread.sleep(Duration.ofMinutes(1).toMillis());
      response = metricClient.listTimeSeriesCallable().call(request);
    }

    assertWithMessage("View " + view + " didn't return any data.")
        .that(response.getTimeSeriesCount())
        .isGreaterThan(0);
  }
}
