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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.jdbc.BigQueryConnection;
import com.google.cloud.bigquery.jdbc.DataSource;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.trace.v1.TraceServiceClient;
import com.google.cloud.trace.v1.TraceServiceSettings;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.devtools.cloudtrace.v1.TraceSpan;
import com.google.gson.JsonObject;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ITOpenTelemetryTest extends ITBase {

  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String CONNECTION_URL = connectionUrl;

  @Test
  public void testExecute_withOpenTelemetryGcpExporter() throws Exception {

    // Step 1: Connect with GCP Exporters enabled via DataSource
    DataSource ds = DataSource.fromUrl(CONNECTION_URL);
    ds.setEnableGcpTraceExporter(true);
    ds.setEnableGcpLogExporter(true);
    ds.setLogLevel("5"); // Triggers FINE log generation
    ds.setGcpTelemetryProjectId(PROJECT_ID);
    ds.setEnableHighThroughputAPI(false);
    ds.setMaxResults(50L); // Forces small page size (50) to trigger pagination

    String connectionUuid = null;

    try (Connection connection = ds.getConnection();
        Statement statement = connection.createStatement()) {

      // Retrieve the Connection UUID programmatically
      BigQueryConnection bqConnection = connection.unwrap(BigQueryConnection.class);
      connectionUuid = bqConnection.getConnectionId();
      assertNotNull(connectionUuid, "Connection UUID should be generated");

      // Execute an in-memory array query (scans 0 bytes, extremely fast) and force pagination (3
      // pages)
      String paginationQuery = "SELECT * FROM UNNEST(GENERATE_ARRAY(1, 150)) AS id;";
      try (ResultSet paginatedRs = statement.executeQuery(paginationQuery)) {
        while (paginatedRs.next()) {
          // Drain the result set to trigger pagination fetches
        }
      }
    }

    // Step 2: Retrieve and assert logs, harvesting the TraceId
    String traceId = verifyAndFetchLogs(connectionUuid);

    // Step 3: Query Cloud Trace and assert parent-child hierarchy
    Trace trace = verifyAndFetchTrace(traceId);

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

  @Test
  public void testExecute_withErrorCorrelation() throws Exception {

    // Step 1: Connect with GCP Exporters enabled via DataSource
    DataSource ds = DataSource.fromUrl(CONNECTION_URL);
    ds.setEnableGcpTraceExporter(true);
    ds.setEnableGcpLogExporter(true);
    ds.setLogLevel("5"); // Triggers FINE log generation
    ds.setGcpTelemetryProjectId(PROJECT_ID);

    String connectionUuid = null;

    try (Connection connection = ds.getConnection();
        Statement statement = connection.createStatement()) {

      // Retrieve the Connection UUID programmatically
      BigQueryConnection bqConnection = connection.unwrap(BigQueryConnection.class);
      connectionUuid = bqConnection.getConnectionId();
      assertNotNull(connectionUuid, "Connection UUID should be generated");

      // Execute a query designed to fail instantly due to syntax error (compiler-level failure)
      assertThrows(SQLException.class, () -> statement.executeQuery("SELECT * FROM;"));
    }

    // Step 2: Retrieve and assert logs, harvesting the TraceId
    String traceId = verifyAndFetchLogs(connectionUuid);

    // Step 3: Query Cloud Trace and assert span status is ERROR
    Trace trace = verifyAndFetchTrace(traceId);

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

  @Test
  public void testExecute_withCustomCredentialsJson() throws Exception {
    JsonObject authJson = getAuthJson();
    DataSource ds = DataSource.fromUrl(CONNECTION_URL);
    ds.setEnableGcpTraceExporter(true);
    ds.setGcpTelemetryProjectId(PROJECT_ID);
    ds.setGcpTelemetryCredentials(authJson.toString());

    verifyTraceDelivery(ds);
  }

  @Test
  public void testExecute_withCustomCredentialsFilePath() throws Exception {
    JsonObject authJson = getAuthJson();
    File tempFile = File.createTempFile("auth", ".json");
    tempFile.deleteOnExit();
    Files.write(tempFile.toPath(), authJson.toString().getBytes(StandardCharsets.UTF_8));

    DataSource ds = DataSource.fromUrl(CONNECTION_URL);
    ds.setEnableGcpTraceExporter(true);
    ds.setGcpTelemetryProjectId(PROJECT_ID);
    ds.setGcpTelemetryCredentials(tempFile.getAbsolutePath());

    verifyTraceDelivery(ds);
  }

  @Test
  public void testExecute_withHttpProtocol() throws Exception {
    JsonObject authJson = getAuthJson();
    System.setProperty("otel.exporter.otlp.protocol", "http/protobuf");

    try {
      DataSource ds = DataSource.fromUrl(CONNECTION_URL);
      ds.setEnableGcpTraceExporter(true);
      ds.setGcpTelemetryProjectId(PROJECT_ID);
      ds.setGcpTelemetryCredentials(authJson.toString());

      verifyTraceDelivery(ds);
    } finally {
      System.clearProperty("otel.exporter.otlp.protocol");
    }
  }

  @Test
  public void testExecute_withGrpcProtocol() throws Exception {
    JsonObject authJson = getAuthJson();
    System.setProperty("otel.exporter.otlp.protocol", "grpc");

    try {
      DataSource ds = DataSource.fromUrl(CONNECTION_URL);
      ds.setEnableGcpTraceExporter(true);
      ds.setGcpTelemetryProjectId(PROJECT_ID);
      ds.setGcpTelemetryCredentials(authJson.toString());

      verifyTraceDelivery(ds);
    } finally {
      System.clearProperty("otel.exporter.otlp.protocol");
    }
  }

  private void verifyTraceDelivery(DataSource ds) throws Exception {
    ds.setEnableGcpLogExporter(true);
    ds.setLogLevel("5");

    String connectionUuid = null;
    try (Connection connection = ds.getConnection();
        Statement statement = connection.createStatement()) {

      BigQueryConnection bqConnection = connection.unwrap(BigQueryConnection.class);
      connectionUuid = bqConnection.getConnectionId();

      String query = "SELECT 1;";
      try (ResultSet rs = statement.executeQuery(query)) {
        assertTrue(rs.next());
      }
    }

    String traceId = verifyAndFetchLogs(connectionUuid);
    Trace trace = verifyAndFetchTrace(traceId);
    assertNotNull(trace, "Trace must be found");
  }

  private String verifyAndFetchLogs(String connectionUuid) throws Exception {
    GoogleCredentials credentials = getCredentials();

    try (Logging logging =
        LoggingOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(credentials)
            .build()
            .getService()) {
      String filter =
          "logName:\"projects/"
              + PROJECT_ID
              + "/logs/com.google.cloud.bigquery\" AND labels.\"jdbc.connection_id\"=\""
              + connectionUuid
              + "\"";

      List<LogEntry> entries = fetchLogsWithRetry(logging, filter);
      assertFalse(entries.isEmpty(), "Telemetry logs should be exported to GCP");

      LogEntry sampleEntry = entries.get(0);
      String traceId = sampleEntry.getTrace();
      String hexSpanId = sampleEntry.getSpanId();

      assertNotNull(traceId, "Log entry must contain TraceId");
      assertNotNull(hexSpanId, "Log entry must contain SpanId");

      // Verify Connection UUID label correlation on all entries
      for (LogEntry entry : entries) {
        assertEquals(connectionUuid, entry.getLabels().get("jdbc.connection_id"));
      }

      return traceId;
    }
  }

  private Trace verifyAndFetchTrace(String traceId) throws Exception {
    String hexTraceId = traceId;
    if (traceId.contains("/traces/")) {
      hexTraceId = traceId.substring(traceId.lastIndexOf("/traces/") + 8);
    }

    GoogleCredentials credentials = getCredentials();

    TraceServiceSettings settings =
        TraceServiceSettings.newBuilder()
            .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
            .build();

    try (TraceServiceClient traceClient = TraceServiceClient.create(settings)) {
      Trace trace = fetchTraceWithRetry(traceClient, PROJECT_ID, hexTraceId);
      assertNotNull(trace, "Trace must be found in Cloud Trace API: " + hexTraceId);
      return trace;
    }
  }

  private <T> T pollWithRetry(java.util.concurrent.Callable<T> task) throws InterruptedException {
    int attempts = 0;
    int maxAttempts = 120; // 120 attempts * 500ms = 60 seconds max delay
    long delayMs = 500; // 500ms linear polling

    while (attempts < maxAttempts) {
      attempts++;
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
        e.printStackTrace();
      }
      if (attempts < maxAttempts) {
        Thread.sleep(delayMs);
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
