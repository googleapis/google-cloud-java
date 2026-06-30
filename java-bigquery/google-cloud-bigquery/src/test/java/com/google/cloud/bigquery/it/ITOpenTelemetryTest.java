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
package com.google.cloud.bigquery.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.telemetry.BigQueryTelemetryTracer;
import com.google.cloud.bigquery.telemetry.HttpTracingRequestInitializer;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.data.StatusData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ITOpenTelemetryTest {

  private static RemoteBigQueryHelper bigqueryHelper;
  private InMemorySpanExporter memoryExporter;
  private Tracer tracer;

  @BeforeAll
  public static void setUpClass() throws IOException {
    bigqueryHelper = RemoteBigQueryHelper.create();
  }

  @BeforeEach
  public void setUp() {
    memoryExporter = InMemorySpanExporter.create();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(memoryExporter))
            .build();
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
    tracer = openTelemetry.getTracer("it-otel-test");
  }

  @Test
  public void testListDatasetsTraced() {
    BigQuery bq =
        bigqueryHelper.getOptions().toBuilder()
            .setEnableOpenTelemetryTracing(true)
            .setOpenTelemetryTracer(tracer)
            .build()
            .getService();

    bq.listDatasets();

    List<SpanData> spans = memoryExporter.getFinishedSpanItems();
    assertNotNull(spans);
    assertFalse(spans.isEmpty(), "Expected at least one span collected");

    boolean foundRpcSpan = false;
    for (SpanData span : spans) {
      if (span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.listDatasets")) {
        foundRpcSpan = true;
        assertEquals(SpanKind.CLIENT, span.getKind());
        assertEquals(StatusData.unset(), span.getStatus());
        Map<AttributeKey<?>, Object> attrs = span.getAttributes().asMap();
        checkGeneralAttributes(attrs);
        assertEquals("GET", attrs.get(HttpTracingRequestInitializer.HTTP_REQUEST_METHOD));
        assertEquals("DatasetService", attrs.get(AttributeKey.stringKey("bq.rpc.service")));
        assertEquals("ListDatasets", attrs.get(AttributeKey.stringKey("bq.rpc.method")));
        assertEquals(
            "bigquery.googleapis.com", attrs.get(HttpTracingRequestInitializer.SERVER_ADDRESS));
        assertEquals(200L, attrs.get(HttpTracingRequestInitializer.HTTP_RESPONSE_STATUS_CODE));
        assertEquals("bigquery.googleapis.com", attrs.get(BigQueryTelemetryTracer.URL_DOMAIN));
        assertEquals(
            "https://bigquery.googleapis.com/bigquery/v2/projects/"
                + bigqueryHelper.getOptions().getProjectId()
                + "/datasets?prettyPrint=false",
            attrs.get(HttpTracingRequestInitializer.URL_FULL));
        assertEquals(
            "//bigquery.googleapis.com/projects/"
                + bigqueryHelper.getOptions().getProjectId()
                + "/datasets",
            attrs.get(BigQueryTelemetryTracer.GCP_RESOURCE_DESTINATION_ID));
        assertEquals(
            "projects/{+projectId}/datasets", attrs.get(BigQueryTelemetryTracer.URL_TEMPLATE));
        assertNull(attrs.get(BigQueryTelemetryTracer.STATUS_MESSAGE));
        assertNull(attrs.get(BigQueryTelemetryTracer.ERROR_TYPE));
        assertNull(attrs.get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
        assertNull(attrs.get(HttpTracingRequestInitializer.HTTP_REQUEST_RESEND_COUNT));
      }
    }
    assertTrue(foundRpcSpan, "Expected to find BigQueryRpc.listDatasets span");
  }

  @Test
  public void testGetDatasetNotFoundTraced() {
    BigQuery bq =
        bigqueryHelper.getOptions().toBuilder()
            .setEnableOpenTelemetryTracing(true)
            .setOpenTelemetryTracer(tracer)
            .build()
            .getService();

    bq.getDataset("non_existent_dataset");

    List<SpanData> spans = memoryExporter.getFinishedSpanItems();
    assertNotNull(spans);
    assertFalse(spans.isEmpty(), "Expected at least one span collected");

    boolean foundRpcSpan = false;
    for (SpanData span : spans) {
      if (span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.getDataset")) {
        foundRpcSpan = true;
        assertEquals(SpanKind.CLIENT, span.getKind());
        assertEquals(StatusData.error(), span.getStatus());
        Map<AttributeKey<?>, Object> attrs = span.getAttributes().asMap();
        checkGeneralAttributes(attrs);
        assertEquals("GET", attrs.get(HttpTracingRequestInitializer.HTTP_REQUEST_METHOD));
        assertEquals("DatasetService", attrs.get(AttributeKey.stringKey("bq.rpc.service")));
        assertEquals("GetDataset", attrs.get(AttributeKey.stringKey("bq.rpc.method")));
        assertEquals(404L, attrs.get(HttpTracingRequestInitializer.HTTP_RESPONSE_STATUS_CODE));
        assertEquals(
            "projects/{+projectId}/datasets/{+datasetId}",
            attrs.get(BigQueryTelemetryTracer.URL_TEMPLATE));
        assertEquals(
            "https://bigquery.googleapis.com/bigquery/v2/projects/"
                + bigqueryHelper.getOptions().getProjectId()
                + "/datasets/non_existent_dataset?prettyPrint=false",
            attrs.get(HttpTracingRequestInitializer.URL_FULL));
        assertEquals(
            "bigquery.googleapis.com", attrs.get(HttpTracingRequestInitializer.SERVER_ADDRESS));
        assertEquals("bigquery.googleapis.com", attrs.get(BigQueryTelemetryTracer.URL_DOMAIN));
        assertEquals(
            "//bigquery.googleapis.com/projects/"
                + bigqueryHelper.getOptions().getProjectId()
                + "/datasets/non_existent_dataset",
            attrs.get(BigQueryTelemetryTracer.GCP_RESOURCE_DESTINATION_ID));

        // Error attributes
        assertEquals("notFound", attrs.get(BigQueryTelemetryTracer.ERROR_TYPE));
        assertEquals(
            "Not found: Dataset "
                + bigqueryHelper.getOptions().getProjectId()
                + ":non_existent_dataset",
            attrs.get(BigQueryTelemetryTracer.STATUS_MESSAGE));
      }
    }
    assertTrue(foundRpcSpan, "Expected to find BigQueryRpc.getDataset span");
  }

  @Test
  public void testClientErrorAndRetriesTraced() {
    // Pass invalid host to force connection error and retries
    BigQuery bq =
        bigqueryHelper.getOptions().toBuilder()
            .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(5).build())
            .setEnableOpenTelemetryTracing(true)
            .setOpenTelemetryTracer(tracer)
            .setHost("https://invalid-host-name-12345.com:8080")
            .build()
            .getService();

    try {
      bq.listDatasets();
      fail("Expected BigQueryException due to invalid host");
    } catch (BigQueryException e) {
      // Expected
    }

    List<SpanData> spans = memoryExporter.getFinishedSpanItems();
    assertNotNull(spans);
    assertFalse(spans.isEmpty(), "Expected at least one span collected");

    int rpcSpanCount = 0;
    for (SpanData span : spans) {
      if (span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.listDatasets")) {
        rpcSpanCount++;
        assertEquals(SpanKind.CLIENT, span.getKind());
        assertEquals(StatusData.error().getStatusCode(), span.getStatus().getStatusCode());
        Map<AttributeKey<?>, Object> attrs = span.getAttributes().asMap();
        checkGeneralAttributes(attrs);
        assertEquals(
            "https://invalid-host-name-12345.com:8080/bigquery/v2/projects/"
                + bigqueryHelper.getOptions().getProjectId()
                + "/datasets?prettyPrint=false",
            (String) attrs.get(HttpTracingRequestInitializer.URL_FULL));
        assertEquals(
            "invalid-host-name-12345.com", attrs.get(HttpTracingRequestInitializer.SERVER_ADDRESS));
        assertEquals(8080L, attrs.get(HttpTracingRequestInitializer.SERVER_PORT));
        assertEquals("invalid-host-name-12345.com", attrs.get(BigQueryTelemetryTracer.URL_DOMAIN));
        assertEquals(
            "projects/{+projectId}/datasets", attrs.get(BigQueryTelemetryTracer.URL_TEMPLATE));
        assertEquals(
            "//bigquery.googleapis.com/projects/"
                + bigqueryHelper.getOptions().getProjectId()
                + "/datasets",
            attrs.get(BigQueryTelemetryTracer.GCP_RESOURCE_DESTINATION_ID));
        checkRetryAttribute(span, rpcSpanCount);

        // Error attributes
        assertEquals(
            "java.net.UnknownHostException", attrs.get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
        assertEquals("CLIENT_CONNECTION_ERROR", attrs.get(BigQueryTelemetryTracer.ERROR_TYPE));
        assertEquals(
            "UnknownHostException: invalid-host-name-12345.com",
            attrs.get(BigQueryTelemetryTracer.STATUS_MESSAGE));
      }
    }
    assertEquals(5, rpcSpanCount, "Expected 5 attempts total");
  }

  @Test
  public void testSimultaneousCallsDoNotAffectResendCountForEachother() {
    BigQuery bq =
        bigqueryHelper.getOptions().toBuilder()
            .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(5).build())
            .setEnableOpenTelemetryTracing(true)
            .setOpenTelemetryTracer(tracer)
            .setHost("https://invalid-host-name-123456.com")
            .build()
            .getService();

    try {
      bq.listDatasets();
      fail("Expected BigQueryException due to invalid host");
    } catch (BigQueryException e) {
      // Expected
    }
    try {
      bq.cancel("test-job-id");
      fail("Expected BigQueryException due to invalid host");
    } catch (BigQueryException e) {
      // Expected
    }

    List<SpanData> spans = memoryExporter.getFinishedSpanItems();
    assertNotNull(spans);
    assertFalse(spans.isEmpty(), "Expected at least one span collected");

    int listDataSpanCount = 0;
    int cancelJobSpanCount = 0;
    for (SpanData span : spans) {
      if (span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.listDatasets")) {
        listDataSpanCount++;
        checkRetryAttribute(span, listDataSpanCount);
      } else if (span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.cancelJob")) {
        cancelJobSpanCount++;
        checkRetryAttribute(span, cancelJobSpanCount);
      }
    }
    assertEquals(5, listDataSpanCount, "Expected 5 attempts total for listDatasets call");
    assertEquals(5, cancelJobSpanCount, "Expected 5 attempts total for cancelJob call");
  }

  @Test
  public void testTracingDisabledNoSpansCollected() {
    BigQuery bq =
        bigqueryHelper.getOptions().toBuilder()
            .setEnableOpenTelemetryTracing(false)
            .setOpenTelemetryTracer(tracer)
            .build()
            .getService();

    bq.listDatasets();

    List<SpanData> spans = memoryExporter.getFinishedSpanItems();
    assertTrue(spans.isEmpty(), "Expected no spans to be collected when tracing is disabled");
  }

  private static void checkRetryAttribute(SpanData span, int listDataSpanCount) {
    Map<AttributeKey<?>, Object> attrs = span.getAttributes().asMap();
    Long resendCount = (Long) attrs.get(HttpTracingRequestInitializer.HTTP_REQUEST_RESEND_COUNT);
    if (listDataSpanCount == 1) {
      assertNull(resendCount, "Expected no resend count for first attempt");
    } else {
      assertNotNull(resendCount, "Expected resend count for retry attempt " + listDataSpanCount);
      assertEquals((long) (listDataSpanCount - 1), resendCount.longValue());
    }
  }

  private void checkGeneralAttributes(Map<AttributeKey<?>, Object> attrs) {
    assertEquals(
        HttpTracingRequestInitializer.HTTP_RPC_SYSTEM_NAME,
        attrs.get(BigQueryTelemetryTracer.RPC_SYSTEM_NAME));
    assertEquals(
        BigQueryTelemetryTracer.BQ_GCP_CLIENT_SERVICE,
        attrs.get(BigQueryTelemetryTracer.GCP_CLIENT_SERVICE));
    assertEquals(
        BigQueryTelemetryTracer.BQ_GCP_CLIENT_REPO,
        attrs.get(BigQueryTelemetryTracer.GCP_CLIENT_REPO));
    assertEquals(
        BigQueryTelemetryTracer.BQ_GCP_CLIENT_ARTIFACT,
        attrs.get(BigQueryTelemetryTracer.GCP_CLIENT_ARTIFACT));
    assertNotNull(attrs.get(BigQueryTelemetryTracer.GCP_CLIENT_VERSION));
  }
}
