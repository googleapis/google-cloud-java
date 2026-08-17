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

import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.JobInfo;
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
import java.time.Duration;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
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
  public void testConfigureLogging() {
    QueryRetrySample.configureLogging();

    Logger rootLogger = Logger.getLogger("");
    for (Handler handler : rootLogger.getHandlers()) {
      assertThat(handler.getLevel()).isEqualTo(Level.ALL);
    }

    assertThat(Logger.getLogger("com.google.cloud.bigquery").getLevel()).isEqualTo(Level.FINEST);
    assertThat(Logger.getLogger("com.google.api.gax").getLevel()).isEqualTo(Level.FINEST);
    assertThat(Logger.getLogger(LoggingSpanExporter.class.getName()).getLevel())
        .isEqualTo(Level.ALL);
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

    RetrySettings retrySettings = options.getRetrySettings();
    assertThat(retrySettings.getMaxAttempts()).isEqualTo(4);
    assertThat(retrySettings.getInitialRetryDelayDuration()).isEqualTo(Duration.ofMillis(500));
    assertThat(retrySettings.getRetryDelayMultiplier()).isEqualTo(1.5);
    assertThat(retrySettings.getMaxRetryDelayDuration()).isEqualTo(Duration.ofSeconds(2));
    assertThat(retrySettings.getTotalTimeoutDuration()).isEqualTo(Duration.ofSeconds(20));

    HttpTransportOptions transportOptions = (HttpTransportOptions) options.getTransportOptions();
    assertThat(transportOptions.getHttpTransportFactory()).isNotNull();
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
                  if (method.getName().equals("create")
                      && methodArgs != null
                      && methodArgs.length > 0
                      && methodArgs[0] instanceof JobInfo) {
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
}
