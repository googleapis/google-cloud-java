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

import static com.google.cloud.bigquery.telemetry.ErrorTypeUtil.ErrorType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.telemetry.BigQueryTelemetryTracer;
import com.google.cloud.bigquery.telemetry.HttpTracingRequestInitializer;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ITOpenTelemetryTest {

  private static BigQuery bigquery;
  private static RemoteBigQueryHelper bigqueryHelper;
  private InMemorySpanExporter memoryExporter;
  private OpenTelemetry openTelemetry;
  private Tracer tracer;

  @BeforeAll
  public static void setUpClass() throws IOException {
    System.setProperty("com.google.cloud.bigquery.http.tracing.dev.enabled", "true");
    bigqueryHelper = RemoteBigQueryHelper.create();
    bigquery = bigqueryHelper.getOptions().getService();
  }

  @BeforeEach
  public void setUp() {
    memoryExporter = InMemorySpanExporter.create();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(memoryExporter))
            .build();
    openTelemetry = OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
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
    assertTrue(spans.size() > 0, "Expected at least one span collected");

    boolean foundRpcSpan = false;
    for (SpanData span : spans) {
      if (span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.listDatasets")) {
        foundRpcSpan = true;
        Map<AttributeKey<?>, Object> attrs = span.getAttributes().asMap();

        assertEquals("GET", attrs.get(HttpTracingRequestInitializer.HTTP_REQUEST_METHOD));
        assertEquals("DatasetService", attrs.get(AttributeKey.stringKey("bq.rpc.service")));
        assertEquals("ListDatasets", attrs.get(AttributeKey.stringKey("bq.rpc.method")));
        assertEquals("bigquery.googleapis.com", attrs.get(BigQueryTelemetryTracer.SERVER_ADDRESS));
        checkGeneralAttributes(attrs);

        assertEquals(
            "https://bigquery.googleapis.com/bigquery/v2/projects/gcloud-devel/datasets?prettyPrint=false",
            (String) attrs.get(HttpTracingRequestInitializer.URL_FULL));

        String destinationId =
            (String) attrs.get(BigQueryTelemetryTracer.GCP_RESOURCE_DESTINATION_ID);
        assertNotNull(destinationId);
        assertTrue(destinationId.contains("projects/"));
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
    assertTrue(spans.size() > 0, "Expected at least one span collected");

    boolean foundRpcSpan = false;
    for (SpanData span : spans) {
      if (span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.getDataset")) {
        foundRpcSpan = true;
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
            "https://bigquery.googleapis.com/bigquery/v2/projects/gcloud-devel/datasets/non_existent_dataset?prettyPrint=false",
            attrs.get(HttpTracingRequestInitializer.URL_FULL));
        assertEquals("bigquery.googleapis.com", attrs.get(BigQueryTelemetryTracer.SERVER_ADDRESS));

        // Error attributes
        assertEquals("notFound", attrs.get(BigQueryTelemetryTracer.ERROR_TYPE));
        assertEquals(
            "Not found: Dataset gcloud-devel:non_existent_dataset",
            attrs.get(BigQueryTelemetryTracer.STATUS_MESSAGE));
      }
    }
    assertTrue(foundRpcSpan, "Expected to find BigQueryRpc.getDataset span");
  }

  @Test
  public void testConnectionErrorRetriesTraced() {
    // Pass invalid host to force connection error and retries
    BigQuery bq =
        bigqueryHelper.getOptions().toBuilder()
            .setEnableOpenTelemetryTracing(true)
            .setOpenTelemetryTracer(tracer)
            .setHost("https://invalid-host-name-12345.com")
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
    assertTrue(spans.size() > 0, "Expected at least one span collected");

    int rpcSpanCount = 0;
    for (SpanData span : spans) {
      if (span.getName().equals("com.google.cloud.bigquery.BigQueryRpc.listDatasets")) {
        rpcSpanCount++;
        Map<AttributeKey<?>, Object> attrs = span.getAttributes().asMap();

        // Validate common attributes if they are set before failure
        checkGeneralAttributes(attrs);
        assertEquals(
            "https://invalid-host-name-12345.com/bigquery/v2/projects/gcloud-devel/datasets?prettyPrint=false",
            (String) attrs.get(HttpTracingRequestInitializer.URL_FULL));
        assertEquals(
            "invalid-host-name-12345.com", attrs.get(BigQueryTelemetryTracer.SERVER_ADDRESS));

        Long resendCount =
            (Long) attrs.get(HttpTracingRequestInitializer.HTTP_REQUEST_RESEND_COUNT);
        if (rpcSpanCount == 1) {
          assertTrue(resendCount == null || resendCount == 0);
        } else {
          assertNotNull(resendCount, "Expected resend count for retry attempt " + rpcSpanCount);
          assertEquals((long) (rpcSpanCount - 1), resendCount.longValue());
        }

        // Error attributes
        assertEquals(
            "java.net.UnknownHostException", attrs.get(BigQueryTelemetryTracer.EXCEPTION_TYPE));
        assertEquals(
            ErrorType.CLIENT_CONNECTION_ERROR.toString(),
            attrs.get(BigQueryTelemetryTracer.ERROR_TYPE));
        assertNotNull(attrs.get(BigQueryTelemetryTracer.STATUS_MESSAGE));
      }
    }
    assertTrue(rpcSpanCount > 0, "Expected to find at least one listDatasets span");
    // Verify it went up to 4 (5 attempts total: 1 original + 4 retries)
    assertEquals(5, rpcSpanCount, "Expected 5 attempts total if it retries up to 4 times");
  }

  private void checkGeneralAttributes(Map<AttributeKey<?>, Object> attrs) {
    assertEquals("http", attrs.get(BigQueryTelemetryTracer.RPC_SYSTEM_NAME));
    assertEquals(
        BigQueryTelemetryTracer.BQ_GCP_CLIENT_SERVICE,
        attrs.get(BigQueryTelemetryTracer.GCP_CLIENT_SERVICE));
    assertEquals(
        BigQueryTelemetryTracer.BQ_GCP_CLIENT_REPO,
        attrs.get(BigQueryTelemetryTracer.GCP_CLIENT_REPO));
    assertEquals(
        BigQueryTelemetryTracer.BQ_GCP_CLIENT_LANGUAGE,
        attrs.get(BigQueryTelemetryTracer.GCP_CLIENT_LANGUAGE));
    assertEquals(
        BigQueryTelemetryTracer.BQ_GCP_CLIENT_ARTIFACT,
        attrs.get(BigQueryTelemetryTracer.GCP_CLIENT_ARTIFACT));
    assertNotNull(attrs.get(BigQueryTelemetryTracer.GCP_CLIENT_VERSION));
  }
}
