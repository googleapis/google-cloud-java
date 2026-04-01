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

package com.google.cloud.datastore.samples;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;

/** A simple sample to verify that Datastore metrics are being recorded and exported correctly. */
public class MetricsSample {

  public static void main(String[] args) throws Exception {
    String projectId = System.getenv("GOOGLE_CLOUD_PROJECT");
    if (projectId == null || projectId.isEmpty()) {
      System.err.println("Error: GOOGLE_CLOUD_PROJECT environment variable is not set.");
      System.exit(1);
    }

    System.out.println("Starting MetricsSample for project: " + projectId);

    // Initialize Datastore client with metrics enabled by default.
    Datastore datastore =
        DatastoreOptions.newBuilder().setProjectId(projectId).build().getService();

    System.out.println("Executing operations to generate metrics...");

    // 1. Basic Key Lookup
    Key key = datastore.newKeyFactory().setKind("MetricsTask").newKey("sample-task");
    datastore.get(key);
    System.out.println("Performed lookup.");

    // 2. Transactional Read/Write
    datastore.runInTransaction(
        tx -> {
          Entity entity =
              Entity.newBuilder(key)
                  .set("description", "Recorded via MetricsSample")
                  .set("timestamp", System.currentTimeMillis())
                  .build();
          tx.put(entity);
          return null;
        });
    System.out.println("Performed transaction.");

    // 3. Batch operation
    datastore.delete(key);
    System.out.println("Performed delete.");

    System.out.println("Waiting 65 seconds for metrics to be flushed to Cloud Monitoring...");
    // PeriodicMetricReader default interval is 60s.
    Thread.sleep(65000);

    System.out.println("Sample finished. Check the Cloud Monitoring dashboard for:");
    System.out.println(" - firestore.googleapis.com/internal/client/operation_latency");
    System.out.println(" - firestore.googleapis.com/internal/client/transaction_latency");
  }
}
