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

// [START bigquery_query_retry_tracing]
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.Json;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.auth.http.HttpTransportFactory;
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
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class QueryRetrySample {

  private static final String TELEMETRY_ENDPOINT = "https://telemetry.googleapis.com/v1/traces";

  public static void main(String[] args) throws IOException, InterruptedException {
    // 1. Configure Java Util Logging (JUL) to output FINEST retry and HTTP logs to console
    configureLogging();

    // 2. Obtain Application Default Credentials (ADC) and project ID
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
      projectId = "lawrence-test-project-2";
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
      // 8. Flush and close the SDK to ensure all batched spans reach Cloud Trace
      tracerProvider.forceFlush();
      otel.close();
    }
  }

  public static BigQuery createBigQueryClient(
      Tracer tracer, GoogleCredentials credentials, String projectId, int simulatedFailures) {

    // Configure retry settings with 4 max attempts and exponential backoff
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setMaxAttempts(4)
            .setInitialRetryDelayDuration(Duration.ofMillis(500))
            .setRetryDelayMultiplier(1.5)
            .setMaxRetryDelayDuration(Duration.ofSeconds(2))
            .setTotalTimeoutDuration(Duration.ofSeconds(20))
            .build();

    // Intercept HTTP transport to return HTTP 503 for the first N attempts
    HttpTransportFactory transportFactory = new TransientErrorTransportFactory(simulatedFailures);

    HttpTransportOptions transportOptions =
        HttpTransportOptions.newBuilder()
            .setHttpTransportFactory(transportFactory)
            .setConnectTimeout(5000)
            .setReadTimeout(10000)
            .build();

    // Configure retry algorithm to retry transient HTTP 5xx errors (500, 502, 503, 504)
    ResultRetryAlgorithm<?> resultRetryAlgorithm =
        new ResultRetryAlgorithm<Object>() {
          @Override
          public TimedAttemptSettings createNextAttempt(
              Throwable prevThrowable, Object prevResponse, TimedAttemptSettings prevSettings) {
            return null;
          }

          @Override
          public boolean shouldRetry(Throwable prevThrowable, Object prevResponse) {
            if (prevThrowable instanceof HttpResponseException) {
              int code = ((HttpResponseException) prevThrowable).getStatusCode();
              return code == 500 || code == 502 || code == 503 || code == 504;
            }
            if (prevThrowable instanceof BigQueryException) {
              return ((BigQueryException) prevThrowable).isRetryable();
            }
            return false;
          }
        };

    BigQueryOptions.Builder optionsBuilder =
        BigQueryOptions.newBuilder()
            .setRetrySettings(retrySettings)
            .setResultRetryAlgorithm(resultRetryAlgorithm)
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

      System.out.println("\nQuery Results (succeeded on Attempt #3 after 2 retries):");
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
   * Factory providing an HttpTransport that simulates transient HTTP 503 errors.
   */
  static class TransientErrorTransportFactory implements HttpTransportFactory {
    private final HttpTransport transport;

    public TransientErrorTransportFactory(int maxFailures) {
      this.transport = new TransientErrorHttpTransport(maxFailures);
    }

    @Override
    public HttpTransport create() {
      return transport;
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
            "[Transport Injector] Attempt #%d -> Simulating transient HTTP 503 Service Unavailable%n",
            attempt);
        return new MockLowLevelHttpRequest() {
          @Override
          public LowLevelHttpResponse execute() throws IOException {
            MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
            response.setStatusCode(503);
            response.setContentType(Json.MEDIA_TYPE);
            response.setContent(
                "{\n"
                    + "  \"error\": {\n"
                    + "    \"code\": 503,\n"
                    + "    \"message\": \"Service Unavailable (simulated transient error for retry demonstration)\",\n"
                    + "    \"status\": \"UNAVAILABLE\"\n"
                    + "  }\n"
                    + "}");
            return response;
          }
        };
      }
      System.out.printf(
          "[Transport Injector] Attempt #%d -> Forwarding to live BigQuery endpoint%n", attempt);
      URL targetUrl = new URL(url);
      HttpURLConnection connection = (HttpURLConnection) targetUrl.openConnection();
      connection.setRequestMethod(method);
      connection.setUseCaches(false);
      connection.setInstanceFollowRedirects(false);

      return new LowLevelHttpRequest() {
        @Override
        public void addHeader(String name, String value) {
          connection.addRequestProperty(name, value);
        }

        @Override
        public void setTimeout(int connectTimeout, int readTimeout) {
          connection.setConnectTimeout(connectTimeout);
          connection.setReadTimeout(readTimeout);
        }

        @Override
        public LowLevelHttpResponse execute() throws IOException {
          if (getStreamingContent() != null) {
            connection.setDoOutput(true);
            getStreamingContent().writeTo(connection.getOutputStream());
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
        String key = entry.getKey();
        if (key != null) {
          for (String value : entry.getValue()) {
            headerNames.add(key);
            headerValues.add(value);
          }
        }
      }
    }

    @Override
    public InputStream getContent() throws IOException {
      InputStream in = connection.getErrorStream();
      if (in == null) {
        in = connection.getInputStream();
      }
      return in;
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

  public static void configureLogging() {
    Logger rootLogger = Logger.getLogger("");
    rootLogger.setLevel(Level.ALL);

    // Remove existing handlers to avoid duplicates and ensure a clean ALL level handler
    for (Handler handler : rootLogger.getHandlers()) {
      rootLogger.removeHandler(handler);
    }

    ConsoleHandler consoleHandler = new ConsoleHandler();
    consoleHandler.setLevel(Level.ALL);
    consoleHandler.setFormatter(new SimpleFormatter());
    rootLogger.addHandler(consoleHandler);

    // Enable FINEST logging on BigQuery, GAX, and Google HTTP client packages
    Logger.getLogger("com.google.cloud.bigquery").setLevel(Level.FINEST);
    Logger.getLogger("com.google.api.gax").setLevel(Level.FINEST);
    Logger.getLogger(LoggingSpanExporter.class.getName()).setLevel(Level.ALL);
  }
}
// [END bigquery_query_retry_tracing]
