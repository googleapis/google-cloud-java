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

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.TruthJUnit.assume;

import com.google.api.client.util.Lists;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.monitoring.v3.ListTimeSeriesRequest;
import com.google.monitoring.v3.ListTimeSeriesResponse;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.TimeInterval;
import com.google.protobuf.util.Timestamps;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

// TODO: re-enable this test
@RunWith(JUnit4.class)
@Ignore
public class BuiltinMetricsIT {
  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();
  public static MetricServiceClient metricClient;

  public static String[] VIEWS = {
    "operation_latencies",
    "retry_count",
    "attempt_latencies",
    "server_latencies",
    "connectivity_error_count",
    "application_latencies"
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
  }

  @AfterClass
  public static void tearDown() {
    if (metricClient != null) {
      metricClient.close();
    }
  }

  @Test
  public void testBuiltinMetrics() throws Exception {
    // Send a MutateRow and ReadRows request
    testEnvRule
        .env()
        .getDataClient()
        .mutateRow(
            RowMutation.create(testEnvRule.env().getTableId(), "a-new-key")
                .setCell(testEnvRule.env().getFamilyId(), "q", "abc"));
    ArrayList<Row> rows =
        Lists.newArrayList(
            testEnvRule
                .env()
                .getDataClient()
                .readRows(Query.create(testEnvRule.env().getTableId()).limit(10)));

    // Sleep 5 minutes so the metrics could be published and precomputation is done
    Thread.sleep(Duration.ofMinutes(5).toMillis());

    ProjectName name = ProjectName.of(testEnvRule.env().getProjectId());

    // Restrict time to last 10 minutes
    long startMillis = System.currentTimeMillis() - Duration.ofMinutes(10).toMillis();
    TimeInterval interval =
        TimeInterval.newBuilder()
            .setStartTime(Timestamps.fromMillis(startMillis))
            .setEndTime(Timestamps.fromMillis(System.currentTimeMillis()))
            .build();

    for (String view : VIEWS) {
      // Filter on instance and method name
      // Verify that metrics are published for MutateRow request
      String metricFilter =
          String.format(
              "metric.type=\"bigtable.googleapis.com/client/%s\" "
                  + "AND resource.labels.instance=\"%s\" AND metric.labels.method=\"Bigtable.MutateRow\"",
              view, testEnvRule.env().getInstanceId());
      ListTimeSeriesRequest.Builder requestBuilder =
          ListTimeSeriesRequest.newBuilder()
              .setName(name.toString())
              .setFilter(metricFilter)
              .setInterval(interval)
              .setView(ListTimeSeriesRequest.TimeSeriesView.FULL);
      ListTimeSeriesResponse response =
          metricClient.listTimeSeriesCallable().call(requestBuilder.build());
      assertThat(response.getTimeSeriesCount()).isGreaterThan(0);

      // Verify that metrics are published for ReadRows request
      metricFilter =
          String.format(
              "metric.type=\"bigtable.googleapis.com/client/operation_latencies\" "
                  + "AND resource.labels.instance=\"%s\" AND metric.labels.method=\"Bigtable.ReadRows\"",
              testEnvRule.env().getInstanceId());
      requestBuilder.setFilter(metricFilter);
      response = metricClient.listTimeSeriesCallable().call(requestBuilder.build());
      assertThat(response.getTimeSeriesCount()).isGreaterThan(0);
    }
  }
}
