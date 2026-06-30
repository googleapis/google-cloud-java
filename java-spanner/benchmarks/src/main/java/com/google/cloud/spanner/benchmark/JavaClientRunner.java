/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner.benchmark;

import com.google.cloud.opentelemetry.metric.GoogleCloudMetricExporter;
import com.google.cloud.opentelemetry.trace.TraceExporter;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.ReadOnlyTransaction;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SessionPoolOptions;
import com.google.cloud.spanner.SessionPoolOptionsHelper;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import com.google.common.base.Stopwatch;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

class JavaClientRunner extends AbstractRunner {
  private final DatabaseId databaseId;
  private long numNullValues;
  private long numNonNullValues;

  JavaClientRunner(DatabaseId databaseId) {
    this.databaseId = databaseId;
  }

  @Override
  public List<Duration> execute(BenchmarkingConfiguration configuration) {
    // setup open telemetry metrics and traces
    // setup open telemetry metrics and traces
    SpanExporter traceExporter = TraceExporter.createWithDefaultConfiguration();
    SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(BatchSpanProcessor.builder(traceExporter).build())
            .setResource(
                Resource.create(
                    Attributes.of(
                        AttributeKey.stringKey("service.name"),
                        "Java-MultiplexedSession-Benchmark")))
            .setSampler(Sampler.alwaysOn())
            .build();
    MetricExporter cloudMonitoringExporter =
        GoogleCloudMetricExporter.createWithDefaultConfiguration();
    SdkMeterProvider sdkMeterProvider =
        SdkMeterProvider.builder()
            .registerMetricReader(PeriodicMetricReader.create(cloudMonitoringExporter))
            .build();
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder()
            .setMeterProvider(sdkMeterProvider)
            .setTracerProvider(tracerProvider)
            .build();
    SessionPoolOptions sessionPoolOptions =
        SessionPoolOptionsHelper.setUseMultiplexedSession(
                SessionPoolOptions.newBuilder(), configuration.isUseMultiplexSession())
            .build();
    SpannerOptions.enableOpenTelemetryMetrics();
    SpannerOptions.enableOpenTelemetryTraces();
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setOpenTelemetry(openTelemetry)
            .setProjectId(databaseId.getInstanceId().getProject())
            .setSessionPoolOption(sessionPoolOptions)
            .setHost(SERVER_URL_MAPPING.get(configuration.getEnvironment()))
            .build();
    try (Spanner spanner = options.getService()) {
      DatabaseClient databaseClient = spanner.getDatabaseClient(databaseId);

      List<Future<List<Duration>>> results = new ArrayList<>(configuration.getNumOfClients());
      ExecutorService service = Executors.newFixedThreadPool(configuration.getNumOfClients());
      for (int client = 0; client < configuration.getNumOfClients(); client++) {
        int clientId = client;
        results.add(service.submit(() -> runBenchmark(databaseClient, clientId, configuration)));
      }
      return collectResults(service, results, configuration);
    } catch (Throwable t) {
      throw SpannerExceptionFactory.asSpannerException(t);
    }
  }

  private List<Duration> runBenchmark(
      DatabaseClient databaseClient, int clientId, BenchmarkingConfiguration configuration) {
    List<Duration> results = new ArrayList<>();
    // Execute one query to make sure everything has been warmed up.
    warmUp(databaseClient, clientId, configuration);
    runBenchmark(databaseClient, clientId, configuration, results);
    setBenchmarkingCompleted(clientId);
    return results;
  }

  private void runBenchmark(
      DatabaseClient databaseClient,
      int clientId,
      BenchmarkingConfiguration configuration,
      List<Duration> results) {
    Instant endTime = Instant.now().plus(Duration.ofMinutes(configuration.getExecutionTime()));
    initiateTimer(clientId, "Remaining execution time", endTime);
    while (endTime.isAfter(Instant.now())) {
      try {
        randomWait(configuration.getWaitBetweenRequests());
        results.add(
            executeTransaction(
                databaseClient, configuration.getTransactionType(), configuration.getStaleness()));
      } catch (InterruptedException interruptedException) {
        throw SpannerExceptionFactory.propagateInterrupt(interruptedException);
      }
    }
  }

  private void warmUp(
      DatabaseClient databaseClient, int clientId, BenchmarkingConfiguration configuration) {
    Instant endTime = Instant.now().plus(Duration.ofMinutes(configuration.getWarmupTime()));
    initiateTimer(clientId, "Remaining warmup time", endTime);
    while (endTime.isAfter(Instant.now())) {
      executeTransaction(
          databaseClient, configuration.getTransactionType(), configuration.getStaleness());
    }
  }

  private Duration executeTransaction(
      DatabaseClient client, TransactionType transactionType, int staleness) {
    Stopwatch watch = Stopwatch.createStarted();
    switch (transactionType) {
      case READ_ONLY_SINGLE_USE_READ:
        executeSingleUseReadOnlyTransactionWithRead(client, staleness);
        break;
      case READ_ONLY_SINGLE_USE_QUERY:
        executeSingleUseReadOnlyTransactionWithQuery(client, staleness);
        break;
      case READ_ONLY_MULTI_USE:
        executeMultiUseReadOnlyTransaction(client);
        break;
      case READ_WRITE:
        executeReadWriteTransaction(client);
        break;
    }
    return watch.elapsed();
  }

  private void executeSingleUseReadOnlyTransactionWithRead(DatabaseClient client, int staleness) {
    List<String> columns = new ArrayList<>();
    int key = getRandomKey();
    columns.add("ID");
    try (ResultSet resultSet =
        client
            .singleUse(TimestampBound.ofExactStaleness(staleness, TimeUnit.SECONDS))
            .read(TABLE_NAME, KeySet.singleKey(Key.of(key)), columns)) {
      while (resultSet.next()) {
        for (int i = 0; i < resultSet.getColumnCount(); i++) {
          if (resultSet.isNull(i)) {
            numNullValues++;
          } else {
            numNonNullValues++;
          }
        }
      }
    }
  }

  private void executeSingleUseReadOnlyTransactionWithQuery(DatabaseClient client, int staleness) {
    try (ResultSet resultSet =
        client
            .singleUse(TimestampBound.ofExactStaleness(staleness, TimeUnit.SECONDS))
            .executeQuery(getRandomisedReadStatement())) {
      while (resultSet.next()) {
        for (int i = 0; i < resultSet.getColumnCount(); i++) {
          if (resultSet.isNull(i)) {
            numNullValues++;
          } else {
            numNonNullValues++;
          }
        }
      }
    }
  }

  private void executeMultiUseReadOnlyTransaction(DatabaseClient client) {
    try (ReadOnlyTransaction transaction = client.readOnlyTransaction()) {
      ResultSet resultSet = transaction.executeQuery(getRandomisedReadStatement());
      iterateResultSet(resultSet);

      ResultSet resultSet1 = transaction.executeQuery(getRandomisedReadStatement());
      iterateResultSet(resultSet1);

      ResultSet resultSet2 = transaction.executeQuery(getRandomisedReadStatement());
      iterateResultSet(resultSet2);

      ResultSet resultSet3 = transaction.executeQuery(getRandomisedReadStatement());
      iterateResultSet(resultSet3);
    }
  }

  private void iterateResultSet(ResultSet resultSet) {
    while (resultSet.next()) {
      for (int i = 0; i < resultSet.getColumnCount(); i++) {
        if (resultSet.isNull(i)) {
          numNullValues++;
        } else {
          numNonNullValues++;
        }
      }
    }
  }

  private void executeReadWriteTransaction(DatabaseClient client) {
    client
        .readWriteTransaction()
        .run(transaction -> transaction.executeUpdate(getRandomisedUpdateStatement()));
  }

  static Statement getRandomisedReadStatement() {
    return Statement.newBuilder(SELECT_QUERY).bind(ID_COLUMN_NAME).to(getRandomKey()).build();
  }

  static Statement getRandomisedUpdateStatement() {
    return Statement.newBuilder(UPDATE_QUERY).bind(ID_COLUMN_NAME).to(getRandomKey()).build();
  }

  static int getRandomKey() {
    return ThreadLocalRandom.current().nextInt(TOTAL_RECORDS);
  }
}
