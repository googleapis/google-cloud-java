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

// [START datastore_client_side_metrics]
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOpenTelemetryOptions;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Transaction;

import java.util.UUID;

/**
 * Demonstrates default client-side metrics for the Datastore Java client library using a
 * transaction flow.
 *
 * <p>Usage: DatastoreMetricsSample <projectId> <databaseId>
 *
 * <p>Client-side metrics are automatically exported to Google Cloud Monitoring under the {@code
 * custom.googleapis.com/internal/client} metric prefix, using the {@code
 * firestore.googleapis.com/Database} monitored resource. The {@code service} metric label is set to
 * {@code datastore.googleapis.com} to distinguish Datastore traffic from Firestore.
 *
 * <p>Built-in metrics are currently disabled by default until the Cloud Monitoring namespace is
 * fully deployed. To enable them, set {@link
 * DatastoreOpenTelemetryOptions.Builder#setExportBuiltinMetricsToGoogleCloudMonitoring(boolean)} to
 * {@code true}, or set the environment variable {@code DATASTORE_ENABLE_METRICS=true}.
 *
 * <p>Metrics recorded by this sample:
 *
 * <ul>
 *   <li>{@code transaction_latency} — end-to-end latency of the transaction including retries.
 *   <li>{@code transaction_attempt_count} — number of commit attempts for the transaction.
 * </ul>
 *
 * <p>To verify metrics in Cloud Monitoring after running this sample, navigate to:
 * <b>Cloud Console → Monitoring → Metrics Explorer</b> and filter by:
 *
 * <pre>
 *   Metric  : custom.googleapis.com/internal/client/transaction_latency
 *   Resource: firestore.googleapis.com/Database
 *   Label   : service = datastore.googleapis.com
 * </pre>
 */
public class DatastoreMetricsSample {

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage: DatastoreMetricsSample <projectId> <databaseId>");
      System.exit(1);
    }
    String projectId = args[0];
    String databaseId = args[1];
    String kind = "Kind-" + UUID.randomUUID().toString().substring(0, 8);

    runSample(projectId, databaseId, kind);
  }

  static void runSample(String projectId, String databaseId, String kind) throws Exception {
    // [START datastore_client_side_metrics_default]
    // Built-in metrics are disabled by default. Enable them explicitly.
    DatastoreOptions options =
        DatastoreOptions.newBuilder()
            .setProjectId(projectId)
            .setDatabaseId(databaseId)
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setExportBuiltinMetricsToGoogleCloudMonitoring(true)
                    .build())
            .build();
    // [END datastore_client_side_metrics_default]

    try (Datastore datastore = options.getService()) {
      System.out.printf(
          "Connected to project=%s database=%s%n", projectId, databaseId);
      System.out.println(
          "Built-in metrics are explicitly enabled and will be exported to"
              + " Google Cloud Monitoring under custom.googleapis.com/internal/client/*");

      runTransactionFlow(datastore, kind);

      // The periodic metric reader flushes accumulated metrics to Cloud Monitoring on a fixed
      // interval (default: 60 seconds). A final flush also runs when the JVM shuts down via the
      // registered shutdown hook.
      System.out.println(
          "\nTransaction flow complete. Metrics will be flushed to Cloud Monitoring.");
      System.out.println(
          "Check Cloud Monitoring > Metrics Explorer for:"
              + " custom.googleapis.com/internal/client/transaction_latency");

      // Give some time for the periodic metric reader to flush metrics to Cloud Monitoring.
      System.out.println("Waiting 5 seconds for metrics to flush...");
      Thread.sleep(5000);
    }
  }

  /**
   * Runs a full transaction flow: writes an entity, reads it back within a transaction, updates it,
   * then deletes it. This exercises the read-modify-write pattern that records both {@code
   * transaction_latency} and {@code transaction_attempt_count} metrics.
   */
  static void runTransactionFlow(Datastore datastore, String kind) {
    Key key = datastore.newKeyFactory().setKind(kind).newKey("metrics-sample-entity");

    // Step 1: Insert the entity outside any transaction to establish a baseline.
    Entity initial = Entity.newBuilder(key).set("status", "created").set("value", 0L).build();
    datastore.put(initial);
    System.out.printf("Inserted entity: kind=%s key=%s%n", kind, key.getName());

    // Step 2: Read-modify-write inside a transaction.
    // This is the core pattern that generates transaction_latency and
    // transaction_attempt_count metrics.
    Entity updated =
        datastore.runInTransaction(
            transaction -> {
              Entity current = transaction.get(key);
              Entity modified =
                  Entity.newBuilder(current)
                      .set("status", "updated")
                      .set("value", current.getLong("value") + 1)
                      .build();
              transaction.put(modified);
              return modified;
            });
    System.out.printf(
        "Transaction committed: status=%s value=%d%n",
        updated.getString("status"), updated.getLong("value"));
    System.out.println(
        "  → transaction_latency and transaction_attempt_count metrics recorded.");

    // Step 3: Clean up.
    datastore.delete(key);
    System.out.printf("Deleted entity: kind=%s key=%s%n", kind, key.getName());
  }
}
// [END datastore_client_side_metrics]
