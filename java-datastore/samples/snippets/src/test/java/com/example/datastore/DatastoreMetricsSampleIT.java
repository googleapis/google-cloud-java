/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.datastore;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Key;
import com.rule.SystemsOutRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration test for {@link DatastoreMetricsSample}.
 *
 * <p>Requires a real GCP project with valid Application Default Credentials. Set the following
 * environment variables before running:
 *
 * <ul>
 *   <li>{@code GOOGLE_CLOUD_PROJECT} — GCP project ID
 *   <li>{@code DATASTORE_DATABASE_ID} — Datastore database ID (defaults to {@code ""} for the
 *       default database)
 * </ul>
 *
 * <p>To verify that metrics appeared in Cloud Monitoring after this test runs, navigate to:
 *
 * <pre>
 *   Cloud Console → Monitoring → Metrics Explorer
 *   Metric  : custom.googleapis.com/internal/client/transaction_latency
 *   Resource: firestore.googleapis.com/Database
 *   Label   : service = datastore.googleapis.com
 * </pre>
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DatastoreMetricsSampleIT {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String DATABASE_ID =
      System.getenv().getOrDefault("DATASTORE_DATABASE_ID", "");

  @Rule public final SystemsOutRule systemsOutRule = new SystemsOutRule();

  private Datastore datastore;
  private String kind;

  @Before
  public void setUp() {
    kind = "Kind-" + java.util.UUID.randomUUID().toString().substring(0, 8);
    datastore =
        DatastoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setDatabaseId(DATABASE_ID)
            .build()
            .getService();
    cleanUp();
  }

  @After
  public void tearDown() {
    cleanUp();
    System.setOut(null);
  }

  @Test
  public void testTransactionFlowRecordsMetrics() throws Exception {
    DatastoreMetricsSample.runSample(PROJECT_ID, DATABASE_ID, kind);

    systemsOutRule.assertContains("Built-in metrics are explicitly enabled");
    systemsOutRule.assertContains("Inserted entity");
    systemsOutRule.assertContains("Transaction committed");
    systemsOutRule.assertContains("transaction_latency and transaction_attempt_count metrics recorded");
    systemsOutRule.assertContains("Deleted entity");
    systemsOutRule.assertContains("Metrics will be flushed to Cloud Monitoring");
  }

  @Test
  public void testRunTransactionFlow_updatesEntityCorrectly() {
    DatastoreMetricsSample.runTransactionFlow(datastore, kind);

    // Entity is deleted at the end of the flow; confirm it no longer exists.
    Key key = datastore.newKeyFactory().setKind(kind).newKey("metrics-sample-entity");
    assertThat(datastore.get(key)).isNull();
  }

  private void cleanUp() {
    Key key = datastore.newKeyFactory().setKind(kind).newKey("metrics-sample-entity");
    datastore.delete(key);
  }
}
