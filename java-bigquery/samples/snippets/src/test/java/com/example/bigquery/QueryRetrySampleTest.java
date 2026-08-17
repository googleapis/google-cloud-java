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

package com.example.bigquery;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.http.HttpTransportOptions;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.exporter.logging.LoggingSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Proxy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QueryRetrySampleTest {

  private ByteArrayOutputStream bout;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    originalPrintStream = System.out;
    System.setOut(new PrintStream(bout));
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testCreateBigQueryClientConfiguration() {
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.builder(LoggingSpanExporter.create()).build())
            .setSampler(Sampler.alwaysOn())
            .build();
    OpenTelemetry otel = OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();
    Tracer tracer = otel.getTracer("test-tracer");

    BigQuery bigquery =
        QueryRetrySample.createBigQueryClient(tracer, null, "test-project", 2);

    BigQueryOptions options = bigquery.getOptions();
    assertThat(options.getProjectId()).isEqualTo("test-project");
    assertThat(options.isOpenTelemetryTracingEnabled()).isTrue();
    assertThat(options.getOpenTelemetryTracer()).isEqualTo(tracer);

    HttpTransportOptions transportOptions = (HttpTransportOptions) options.getTransportOptions();
    assertThat(transportOptions.getHttpTransportFactory()).isNotNull();
    assertThat(options.getResultRetryAlgorithm()).isNotNull();
  }

  @Test
  public void testExecuteQueryCatchesBigQueryException() throws Exception {
    BigQuery mockBigQuery =
        (BigQuery)
            Proxy.newProxyInstance(
                BigQuery.class.getClassLoader(),
                new Class<?>[] {BigQuery.class},
                (proxy, method, methodArgs) -> {
                  if (method.getName().equals("getOptions")) {
                    return BigQueryOptions.newBuilder().setProjectId("test-project").build();
                  }
                  if (method.getName().equals("query")
                      && methodArgs != null
                      && methodArgs.length > 0
                      && methodArgs[0] instanceof QueryJobConfiguration) {
                    throw new BigQueryException(503, "Rate limit exceeded (simulated retry failure)");
                  }
                  return null;
                });

    String query =
        "SELECT corpus, count(*) AS corpus_count "
            + "FROM `bigquery-public-data.samples.shakespeare` "
            + "GROUP BY corpus "
            + "ORDER BY corpus_count DESC "
            + "LIMIT 5;";

    QueryRetrySample.executeQuery(mockBigQuery, query);

    String output = bout.toString();
    assertThat(output).contains("--- Executing query on public dataset ---");
    assertThat(output).contains("Caught expected BigQueryException after retry attempts");
    assertThat(output).contains("Rate limit exceeded");
  }

  @Test
  public void testExecuteQuerySuccess() throws Exception {
    com.google.cloud.bigquery.FieldValue f1 =
        com.google.cloud.bigquery.FieldValue.of(
            com.google.cloud.bigquery.FieldValue.Attribute.PRIMITIVE, "hamlet");
    com.google.cloud.bigquery.FieldValue f2 =
        com.google.cloud.bigquery.FieldValue.of(
            com.google.cloud.bigquery.FieldValue.Attribute.PRIMITIVE, "242");
    com.google.cloud.bigquery.FieldValueList row =
        com.google.cloud.bigquery.FieldValueList.of(
            com.google.common.collect.ImmutableList.of(f1, f2),
            com.google.cloud.bigquery.Field.of("corpus", com.google.cloud.bigquery.StandardSQLTypeName.STRING),
            com.google.cloud.bigquery.Field.of("corpus_count", com.google.cloud.bigquery.StandardSQLTypeName.INT64));

    com.google.cloud.PageImpl<com.google.cloud.bigquery.FieldValueList> page =
        new com.google.cloud.PageImpl<>(
            null, null, com.google.common.collect.ImmutableList.of(row));
    com.google.cloud.bigquery.TableResult tableResult =
        com.google.cloud.bigquery.TableResult.newBuilder()
            .setPageNoSchema(page)
            .setTotalRows(1L)
            .build();

    BigQuery mockBigQuery =
        (BigQuery)
            Proxy.newProxyInstance(
                BigQuery.class.getClassLoader(),
                new Class<?>[] {BigQuery.class},
                (proxy, method, methodArgs) -> {
                  if (method.getName().equals("getOptions")) {
                    return BigQueryOptions.newBuilder().setProjectId("test-project").build();
                  }
                  if (method.getName().equals("query")
                      && methodArgs != null
                      && methodArgs.length > 0
                      && methodArgs[0] instanceof QueryJobConfiguration) {
                    return tableResult;
                  }
                  return null;
                });

    String query =
        "SELECT corpus, count(*) AS corpus_count "
            + "FROM `bigquery-public-data.samples.shakespeare` "
            + "GROUP BY corpus "
            + "ORDER BY corpus_count DESC "
            + "LIMIT 5;";

    QueryRetrySample.executeQuery(mockBigQuery, query);

    String output = bout.toString();
    assertThat(output).contains("--- Executing query on public dataset ---");
    assertThat(output).contains("Query Results (succeeded after simulated retries):");
    assertThat(output).contains("corpus: hamlet, count: 242");
  }

  @Test
  public void testTransientErrorHttpTransport() throws java.io.IOException {
    QueryRetrySample.TransientErrorHttpTransport transport =
        new QueryRetrySample.TransientErrorHttpTransport(2);

    // Attempt #1 -> simulated 503
    com.google.api.client.http.LowLevelHttpRequest req1 =
        transport.buildRequest("GET", "https://bigquery.googleapis.com/test");
    com.google.api.client.http.LowLevelHttpResponse resp1 = req1.execute();
    assertThat(resp1.getStatusCode()).isEqualTo(503);
    assertThat(resp1.getContentType()).isEqualTo("application/json; charset=UTF-8");

    // Attempt #2 -> simulated 503
    com.google.api.client.http.LowLevelHttpRequest req2 =
        transport.buildRequest("GET", "https://bigquery.googleapis.com/test");
    com.google.api.client.http.LowLevelHttpResponse resp2 = req2.execute();
    assertThat(resp2.getStatusCode()).isEqualTo(503);

    // Attempt #3 -> forwards to live connection
    com.google.api.client.http.LowLevelHttpRequest req3 =
        transport.buildRequest("GET", "http://127.0.0.1:0");
    assertThat(req3)
        .isNotInstanceOf(com.google.api.client.testing.http.MockLowLevelHttpRequest.class);
  }
}
