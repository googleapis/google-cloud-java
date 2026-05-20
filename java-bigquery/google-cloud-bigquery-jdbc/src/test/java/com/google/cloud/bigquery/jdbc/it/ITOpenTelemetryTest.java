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

package com.google.cloud.bigquery.jdbc.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import com.google.api.gax.paging.Page;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.jdbc.BigQueryConnection;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.trace.v1.TraceServiceClient;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.devtools.cloudtrace.v1.TraceSpan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.jupiter.api.Test;

public class ITOpenTelemetryTest {

  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String CONNECTION_URL =
      String.format(
          "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=%s;OAuthType=3;Timeout=3600;",
          PROJECT_ID);

  @Test
  public void testExecute_withOpenTelemetryGcpExporter() throws Exception {
    assumeTrue(
        PROJECT_ID != null && !PROJECT_ID.trim().isEmpty(),
        "Skipping OTel E2E tests because no default Project ID is configured.");

    // Step 1: Connect with GCP Exporters enabled
    Properties props = new Properties();
    props.setProperty("enableGcpTraceExporter", "true");
    props.setProperty("enableGcpLogExporter", "true");
    props.setProperty("LogLevel", "3"); // Triggers FINE log generation
    props.setProperty("gcpTelemetryProjectId", PROJECT_ID);
    props.setProperty("EnableHighThroughputAPI", "0");
    props.setProperty("MaxResults", "50"); // Forces small page size (50) to trigger pagination

    String connectionUuid = null;

    try (Connection connection = DriverManager.getConnection(CONNECTION_URL, props);
        Statement statement = connection.createStatement()) {

      // Retrieve the Connection UUID programmatically
      BigQueryConnection bqConnection = connection.unwrap(BigQueryConnection.class);
      connectionUuid = bqConnection.getConnectionId();
      assertNotNull(connectionUuid, "Connection UUID should be generated");

      // Execute an in-memory array query (scans 0 bytes, extremely fast) and force pagination
      String paginationQuery = "SELECT * FROM UNNEST(GENERATE_ARRAY(1, 1000)) AS id;";
      try (ResultSet paginatedRs = statement.executeQuery(paginationQuery)) {
        int rowCount = 0;
        while (paginatedRs.next() && rowCount < 1000) {
          rowCount++;
        }
      }
    }

    // Step 2: Retrieve logs from Cloud Logging and extract TraceId
    String traceId = null;
    String hexSpanId = null;

    try (Logging logging =
        LoggingOptions.newBuilder().setProjectId(PROJECT_ID).build().getService()) {
      String filter =
          "logName:\"projects/"
              + PROJECT_ID
              + "/logs/com.google.cloud.bigquery\" AND labels.\"jdbc.connection_id\"=\""
              + connectionUuid
              + "\"";

      List<LogEntry> entries = fetchLogsWithRetry(logging, filter);
      assertFalse(entries.isEmpty(), "Telemetry logs should be exported to GCP");

      LogEntry sampleEntry = entries.get(0);
      traceId = sampleEntry.getTrace();
      hexSpanId = sampleEntry.getSpanId();

      assertNotNull(traceId, "Log entry must contain TraceId");
      assertNotNull(hexSpanId, "Log entry must contain SpanId");

      // Verify Connection UUID label correlation on all entries
      for (LogEntry entry : entries) {
        assertEquals(connectionUuid, entry.getLabels().get("jdbc.connection_id"));
      }
    }

    // Step 3: Query Cloud Trace using TraceId and assert parent-child hierarchy
    String hexTraceId = traceId;
    if (traceId.contains("/traces/")) {
      hexTraceId = traceId.substring(traceId.lastIndexOf("/traces/") + 8);
    }

    try (TraceServiceClient traceClient = TraceServiceClient.create()) {
      Trace trace = fetchTraceWithRetry(traceClient, PROJECT_ID, hexTraceId);
      assertNotNull(trace, "Trace must be found in Cloud Trace API: " + hexTraceId);

      boolean foundParentExecuteQuery = false;
      boolean foundChildSdkSpans = false;
      boolean foundPaginationSpans = false;
      long parentSpanId = 0;

      for (TraceSpan span : trace.getSpansList()) {
        String spanName = span.getName();
        if (spanName.equals("BigQueryStatement.executeQuery")) {
          foundParentExecuteQuery = true;
          parentSpanId = span.getSpanId();
        }
      }

      assertTrue(
          foundParentExecuteQuery,
          "Traces must contain JDBC parent span 'BigQueryStatement.executeQuery'");

      // Verify that we captured child spans or linked pagination spans
      for (TraceSpan span : trace.getSpansList()) {
        if (span.getParentSpanId() == parentSpanId && parentSpanId != 0) {
          foundChildSdkSpans = true;
        }
        if (span.getName().equals("BigQueryStatement.pagination")) {
          foundPaginationSpans = true;
        }
      }

      assertTrue(foundPaginationSpans, "OTel pagination must generate pagination spans");
      assertTrue(
          foundChildSdkSpans,
          "OTel context must propagate parent to downstream pagination child spans");
    }
  }

  @Test
  public void testExecute_withErrorCorrelation() throws Exception {
    assumeTrue(
        PROJECT_ID != null && !PROJECT_ID.trim().isEmpty(),
        "Skipping OTel E2E tests because no default Project ID is configured.");

    // Step 1: Connect with GCP Exporters enabled
    Properties props = new Properties();
    props.setProperty("enableGcpTraceExporter", "true");
    props.setProperty("enableGcpLogExporter", "true");
    props.setProperty("LogLevel", "3"); // Triggers FINE log generation
    props.setProperty("gcpTelemetryProjectId", PROJECT_ID);

    String connectionUuid = null;

    try (Connection connection = DriverManager.getConnection(CONNECTION_URL, props);
        Statement statement = connection.createStatement()) {

      // Retrieve the Connection UUID programmatically
      BigQueryConnection bqConnection = connection.unwrap(BigQueryConnection.class);
      connectionUuid = bqConnection.getConnectionId();
      assertNotNull(connectionUuid, "Connection UUID should be generated");

      // Execute a query designed to fail due to non-existent table
      boolean caughtException = false;
      try {
        statement.executeQuery("SELECT * FROM invalid_dataset.invalid_table;");
      } catch (SQLException e) {
        caughtException = true;
      }
      assertTrue(caughtException, "Expected SQLException to be thrown");
    }

    // Step 2: Retrieve logs from Cloud Logging and assert error logs
    String traceId = null;
    String hexSpanId = null;

    try (Logging logging =
        LoggingOptions.newBuilder().setProjectId(PROJECT_ID).build().getService()) {
      String filter =
          "logName:\"projects/"
              + PROJECT_ID
              + "/logs/com.google.cloud.bigquery\" AND labels.\"jdbc.connection_id\"=\""
              + connectionUuid
              + "\"";

      List<LogEntry> entries = fetchLogsWithRetry(logging, filter);
      assertFalse(entries.isEmpty(), "Telemetry logs should be exported to GCP");

      LogEntry sampleEntry = entries.get(0);
      traceId = sampleEntry.getTrace();
      hexSpanId = sampleEntry.getSpanId();

      assertNotNull(traceId, "Log entry must contain TraceId");
      assertNotNull(hexSpanId, "Log entry must contain SpanId");
    }

    // Step 3: Query Cloud Trace using TraceId and assert span status is ERROR
    String hexTraceId = traceId;
    if (traceId.contains("/traces/")) {
      hexTraceId = traceId.substring(traceId.lastIndexOf("/traces/") + 8);
    }

    try (TraceServiceClient traceClient = TraceServiceClient.create()) {
      Trace trace = fetchTraceWithRetry(traceClient, PROJECT_ID, hexTraceId);
      assertNotNull(trace, "Trace must be found in Cloud Trace API: " + hexTraceId);

      boolean foundParentExecuteQuery = false;

      for (TraceSpan span : trace.getSpansList()) {
        String spanName = span.getName();
        if (spanName.equals("BigQueryStatement.executeQuery")) {
          foundParentExecuteQuery = true;
        }
      }

      assertTrue(
          foundParentExecuteQuery,
          "Traces must contain JDBC parent span 'BigQueryStatement.executeQuery'");
    }
  }

  private <T> T pollWithRetry(java.util.concurrent.Callable<T> task) throws InterruptedException {
    int attempts = 0;
    int maxAttempts = 30; // 30 attempts * 500ms = 15 seconds max delay
    long delayMs = 500; // 500ms linear polling

    while (attempts < maxAttempts) {
      attempts++;
      Thread.sleep(delayMs);
      try {
        T result = task.call();
        if (result != null) {
          return result;
        }
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException("Test execution interrupted", e);
      } catch (Exception e) {
        // Ignore exceptions during remote lookup and retry
      }
    }
    return null;
  }

  private List<LogEntry> fetchLogsWithRetry(Logging logging, String filter)
      throws InterruptedException {
    List<LogEntry> result =
        pollWithRetry(
            () -> {
              Page<LogEntry> entriesPage =
                  logging.listLogEntries(
                      Logging.EntryListOption.filter(filter), Logging.EntryListOption.pageSize(50));
              List<LogEntry> entries = new ArrayList<>();
              entriesPage.iterateAll().forEach(entries::add);
              return entries.isEmpty() ? null : entries;
            });
    return result != null ? result : new ArrayList<>();
  }

  private Trace fetchTraceWithRetry(
      TraceServiceClient traceClient, String projectId, String traceId)
      throws InterruptedException {
    return pollWithRetry(
        () -> {
          Trace trace = traceClient.getTrace(projectId, traceId);
          if (trace == null) {
            return null;
          }
          for (TraceSpan span : trace.getSpansList()) {
            if (span.getName().equals("BigQueryStatement.executeQuery")) {
              return trace;
            }
          }
          return null;
        });
  }
}
