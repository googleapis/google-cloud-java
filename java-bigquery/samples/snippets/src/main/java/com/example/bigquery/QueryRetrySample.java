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

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.Json;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.http.HttpTransportOptions;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.exporter.logging.LoggingSpanExporter;
import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class QueryRetrySample {

  private static final String TELEMETRY_ENDPOINT = "https://telemetry.googleapis.com/v1/traces";

  public static void main(String[] args) throws IOException, InterruptedException {
    // 1. Obtain Application Default Credentials (ADC) and project ID
    GoogleCredentials credentials =
        GoogleCredentials.getApplicationDefault()
            .createScoped(Collections.singletonList("https://www.googleapis.com/auth/cloud-platform"));
    credentials.refreshIfExpired();
    String token = credentials.getAccessToken().getTokenValue();

    String projectId = ServiceOptions.getDefaultProjectId();
    if (projectId == null || projectId.isEmpty()) {
      projectId = System.getenv("GOOGLE_CLOUD_PROJECT");
    }
    if (projectId == null || projectId.isEmpty()) {
      System.err.println(
          "Project ID not found. Please set the GOOGLE_CLOUD_PROJECT environment variable or authenticate with 'gcloud auth application-default login'.");
      return;
    }

    // 3. Configure OTLP HTTP Span Exporter targeting Google Cloud Trace
    OtlpHttpSpanExporter otlpExporter =
        OtlpHttpSpanExporter.builder()
            .setEndpoint(TELEMETRY_ENDPOINT)
            .addHeader("Authorization", "Bearer " + token)
            .addHeader("x-goog-user-project", projectId)
            .build();

    // 4. Set Resource attributes to associate spans with your GCP Project in Cloud Trace
    Resource resource =
        Resource.getDefault()
            .merge(
                Resource.create(
                    Attributes.builder()
                        .put("gcp.project_id", projectId)
                        .put("service.name", "bigquery-retry-sample")
                        .build()));

    // 5. Build OpenTelemetry SDK with both OTLP HTTP (Cloud Trace) and Logging exporters
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(BatchSpanProcessor.builder(otlpExporter).build())
            .addSpanProcessor(SimpleSpanProcessor.builder(LoggingSpanExporter.create()).build())
            .setResource(resource)
            .setSampler(Sampler.alwaysOn())
            .build();

    OpenTelemetrySdk otel =
        OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build();

    try {
      Tracer tracer = otel.getTracer("bigquery-retry-tracer");

      // 6. Initialize BigQuery client with 2 simulated transient HTTP 503 failures
      int simulatedFailures = 2;
      BigQuery bigquery =
          createBigQueryClient(tracer, credentials, projectId, simulatedFailures);

      // 7. Query a BigQuery public dataset
      String query =
          "SELECT corpus, count(*) AS corpus_count "
              + "FROM `bigquery-public-data.samples.shakespeare` "
              + "GROUP BY corpus "
              + "ORDER BY corpus_count DESC "
              + "LIMIT 5;";

      executeQuery(bigquery, query);
    } finally {
      // 7. Flush and close the SDK to ensure all batched spans reach Cloud Trace
      tracerProvider.close();
      otlpExporter.close();
    }
  }

  public static BigQuery createBigQueryClient(
      Tracer tracer, GoogleCredentials credentials, String projectId, int simulatedFailures) {

    HttpTransportOptions transportOptions =
        HttpTransportOptions.newBuilder()
            .setHttpTransportFactory(() -> new TransientErrorHttpTransport(simulatedFailures))
            .build();

    BigQueryOptions.Builder optionsBuilder =
        BigQueryOptions.newBuilder()
            .setTransportOptions(transportOptions)
            .setEnableOpenTelemetryTracing(true)
            .setOpenTelemetryTracer(tracer);

    if (credentials != null) {
      optionsBuilder.setCredentials(credentials);
    }

    if (projectId != null && !projectId.isEmpty()) {
      optionsBuilder.setProjectId(projectId);
    }

    return optionsBuilder.build().getService();
  }

  public static void executeQuery(BigQuery bigquery, String query) throws InterruptedException {
    System.out.println("\n--- Executing query on public dataset ---");
    System.out.println("Query: " + query + "\n");

    try {
      QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
      TableResult result = bigquery.query(queryConfig);

      System.out.println("\nQuery Results (succeeded after simulated retries):");
      for (FieldValueList row : result.iterateAll()) {
        System.out.printf(
            "corpus: %s, count: %d%n",
            row.get("corpus").getStringValue(), row.get("corpus_count").getLongValue());
      }
    } catch (BigQueryException e) {
      System.out.println(
          "\nCaught expected BigQueryException after retry attempts: " + e.getMessage());
    }
  }

  /**
   * Custom HttpTransport that simulates transient errors for the first N attempts,
   * then executes real HTTP requests against BigQuery via HttpURLConnection.
   */
  static class TransientErrorHttpTransport extends HttpTransport {
    private final int maxFailures;
    private final AtomicInteger attemptCount = new AtomicInteger(0);

    public TransientErrorHttpTransport(int maxFailures) {
      this.maxFailures = maxFailures;
    }

    @Override
    protected LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
      int attempt = attemptCount.incrementAndGet();
      if (attempt <= maxFailures) {
        System.out.printf(
            "[Retry Demo] Attempt #%d: Simulating transient HTTP 503 Service Unavailable (retrying...)%n",
            attempt);
        MockLowLevelHttpRequest mock = new MockLowLevelHttpRequest();
        MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
        response.setStatusCode(503);
        response.setContentType(Json.MEDIA_TYPE);
        response.setContent("{\"error\": {\"code\": 503, \"message\": \"Service Unavailable\"}}");
        mock.setResponse(response);
        return mock;
      }

      System.out.printf(
          "[Retry Demo] Attempt #%d: Forwarding query to live BigQuery endpoint (succeeded)%n",
          attempt);
      HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
      connection.setRequestMethod(method);

      return new LowLevelHttpRequest() {
        @Override
        public void addHeader(String name, String value) {
          connection.addRequestProperty(name, value);
        }

        @Override
        public LowLevelHttpResponse execute() throws IOException {
          if (getStreamingContent() != null) {
            if (getContentType() != null) {
              addHeader("Content-Type", getContentType());
            }
            if (getContentEncoding() != null) {
              addHeader("Content-Encoding", getContentEncoding());
            }
            long contentLength = getContentLength();
            if (contentLength >= 0) {
              connection.setRequestProperty("Content-Length", Long.toString(contentLength));
              connection.setFixedLengthStreamingMode((int) contentLength);
            } else {
              connection.setChunkedStreamingMode(0);
            }
            connection.setDoOutput(true);
            try (OutputStream out = connection.getOutputStream()) {
              getStreamingContent().writeTo(out);
            }
          }
          connection.connect();
          return new RealLowLevelHttpResponse(connection);
        }
      };
    }
  }

  static class RealLowLevelHttpResponse extends LowLevelHttpResponse {
    private final HttpURLConnection connection;
    private final List<String> headerNames = new ArrayList<>();
    private final List<String> headerValues = new ArrayList<>();

    RealLowLevelHttpResponse(HttpURLConnection connection) {
      this.connection = connection;
      for (Map.Entry<String, List<String>> entry : connection.getHeaderFields().entrySet()) {
        if (entry.getKey() != null) {
          for (String value : entry.getValue()) {
            headerNames.add(entry.getKey());
            headerValues.add(value);
          }
        }
      }
    }

    @Override
    public InputStream getContent() throws IOException {
      InputStream in = connection.getErrorStream();
      return in != null ? in : connection.getInputStream();
    }

    @Override
    public String getContentEncoding() {
      return connection.getContentEncoding();
    }

    @Override
    public long getContentLength() {
      String length = connection.getHeaderField("Content-Length");
      return length == null ? -1 : Long.parseLong(length);
    }

    @Override
    public String getContentType() {
      return connection.getContentType();
    }

    @Override
    public String getStatusLine() {
      return connection.getHeaderField(0);
    }

    @Override
    public int getStatusCode() throws IOException {
      return connection.getResponseCode();
    }

    @Override
    public String getReasonPhrase() throws IOException {
      return connection.getResponseMessage();
    }

    @Override
    public int getHeaderCount() {
      return headerNames.size();
    }

    @Override
    public String getHeaderName(int index) {
      return headerNames.get(index);
    }

    @Override
    public String getHeaderValue(int index) {
      return headerValues.get(index);
    }
  }
}
// [END bigquery_query_retry_tracing]
