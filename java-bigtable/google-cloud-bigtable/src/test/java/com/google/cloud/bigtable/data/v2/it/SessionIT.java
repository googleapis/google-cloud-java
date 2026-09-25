/*
 * Copyright 2026 Google LLC
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

import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsTestUtils.getMetricData;
import static com.google.common.truth.Truth.assertWithMessage;
import static com.google.common.truth.TruthJUnit.assume;

import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.cloud.bigtable.test_helpers.env.CloudEnv;
import com.google.cloud.bigtable.test_helpers.env.PrefixGenerator;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Verifies that the Bigtable client routes traffic through the session path when sessions are
 * enabled.
 *
 * <p>This test only runs under the {@code bigtable-session-it} Maven profile, which sets {@code
 * bigtable.internal.client-config-override} to force {@code session_load: 1.0} and points the
 * client at a session-allowlisted instance.
 *
 * <p>Session path activity is verified by asserting that the internal {@code
 * session/open_latencies} metric has data points, which are recorded each time a session is
 * successfully established.
 */
@RunWith(JUnit4.class)
public class SessionIT {

  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();

  private InMemoryMetricReader metricReader;
  private EnhancedBigtableStub stub;

  @Before
  public void setUp() throws IOException {
    assume()
        .withMessage("SessionIT requires a cloud environment, not the emulator")
        .that(testEnvRule.env())
        .isInstanceOf(CloudEnv.class);

    metricReader = InMemoryMetricReader.create();

    stub =
        EnhancedBigtableStub.create(
            testEnvRule.env().getDataClientSettings().getStubSettings().toBuilder()
                .addInternalMetricReader(metricReader)
                .build());

    assume()
        .withMessage(
            "SessionIT requires the session path to be enabled. "
                + "Run with the bigtable-session-it Maven profile.")
        .that(System.getProperty("bigtable.internal.client-config-override"))
        .isNotNull();
  }

  @After
  public void tearDown() {
    if (stub != null) {
      stub.close();
    }
  }

  @Test
  public void testReadAndWriteSucceed() {
    TableId tableId = testEnvRule.env().getTableId();
    String rowKey = PrefixGenerator.newPrefix("SessionIT#readWrite");

    stub.mutateRowCallable()
        .call(
            RowMutation.create(tableId, rowKey)
                .setCell(testEnvRule.env().getFamilyId(), "q", "value"));

    Row row = stub.readRowCallable().call(Query.create(tableId).rowKey(rowKey));
    assertWithMessage("Written row should be readable through the session path")
        .that(row)
        .isNotNull();
  }

  @Test
  public void testSessionsAreEstablished() {
    // Send a few RPCs to ensure the session pool has had a chance to open sessions.
    for (int i = 0; i < 5; i++) {
      stub.readRowCallable().call(Query.create(testEnvRule.env().getTableId()).rowKey("probe-key"));
    }

    // session/open_latencies is recorded in SessionTracerImpl.onOpen() each time a session is
    // successfully established. Non-empty data points prove sessions were opened and used.
    MetricData openLatencies =
        getMetricData(
            metricReader, "bigtable.googleapis.com/internal/client/session/open_latencies");
    assertWithMessage("session/open_latencies should have data points when sessions are active")
        .that(openLatencies.getHistogramData().getPoints())
        .isNotEmpty();
  }
}
