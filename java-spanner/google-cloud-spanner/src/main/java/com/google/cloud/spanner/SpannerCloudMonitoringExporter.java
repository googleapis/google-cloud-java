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

package com.google.cloud.spanner;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.auth.Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.cloud.monitoring.v3.MetricServiceSettings;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.TimeSeries;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannelBuilder;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Spanner Cloud Monitoring OpenTelemetry Exporter.
 *
 * <p>The exporter will look for all spanner owned metrics under spanner.googleapis.com
 * instrumentation scope and upload it via the Google Cloud Monitoring API.
 */
class SpannerCloudMonitoringExporter implements MetricExporter {

  private static final Logger logger =
      Logger.getLogger(SpannerCloudMonitoringExporter.class.getName());

  // This the quota limit from Cloud Monitoring. More details in
  // https://cloud.google.com/monitoring/quotas#custom_metrics_quotas.
  private static final int EXPORT_BATCH_SIZE_LIMIT = 200;
  private final Set<String> spannerExportFailureLoggedProjects = ConcurrentHashMap.newKeySet();
  private final MetricServiceClient client;
  private final Supplier<String> fallbackProjectIdSupplier;

  static SpannerCloudMonitoringExporter create(
      Supplier<String> fallbackProjectIdSupplier,
      @Nullable Credentials credentials,
      @Nullable String monitoringHost,
      String universeDomain)
      throws IOException {
    MetricServiceSettings.Builder settingsBuilder = MetricServiceSettings.newBuilder();
    CredentialsProvider credentialsProvider;
    if (credentials == null || credentials instanceof NoCredentials) {
      credentialsProvider = NoCredentialsProvider.create();
    } else {
      credentialsProvider = FixedCredentialsProvider.create(credentials);
    }
    settingsBuilder.setCredentialsProvider(credentialsProvider);
    if (monitoringHost != null) {
      settingsBuilder.setEndpoint(monitoringHost);
    }
    if (!Strings.isNullOrEmpty(universeDomain)) {
      settingsBuilder.setUniverseDomain(universeDomain);
    }

    if (System.getProperty("jmh.monitoring-server-port") != null) {
      settingsBuilder.setTransportChannelProvider(
          InstantiatingGrpcChannelProvider.newBuilder()
              .setCredentials(NoCredentials.getInstance())
              .setChannelConfigurator(
                  managedChannelBuilder ->
                      ManagedChannelBuilder.forAddress(
                              "0.0.0.0",
                              Integer.parseInt(System.getProperty("jmh.monitoring-server-port")))
                          .usePlaintext())
              .build());
    }

    Duration timeout = Duration.ofMinutes(1);
    // TODO: createServiceTimeSeries needs special handling if the request failed. Leaving
    // it as not retried for now.
    settingsBuilder.createServiceTimeSeriesSettings().setSimpleTimeoutNoRetriesDuration(timeout);

    return new SpannerCloudMonitoringExporter(
        fallbackProjectIdSupplier, MetricServiceClient.create(settingsBuilder.build()));
  }

  @VisibleForTesting
  SpannerCloudMonitoringExporter(MetricServiceClient client) {
    this(() -> null, client);
  }

  @VisibleForTesting
  SpannerCloudMonitoringExporter(
      Supplier<String> fallbackProjectIdSupplier, MetricServiceClient client) {
    this.client = client;
    this.fallbackProjectIdSupplier = fallbackProjectIdSupplier;
  }

  @Override
  public CompletableResultCode export(@Nonnull Collection<MetricData> collection) {
    if (client.isShutdown()) {
      logger.log(Level.WARNING, "Exporter is shut down");
      return CompletableResultCode.ofFailure();
    }

    return exportSpannerClientMetrics(collection);
  }

  @VisibleForTesting
  MetricServiceClient getMetricServiceClient() {
    return client;
  }

  /** Export client built in metrics */
  private CompletableResultCode exportSpannerClientMetrics(Collection<MetricData> collection) {
    // Skips exporting if there's none
    if (collection.isEmpty()) {
      return CompletableResultCode.ofSuccess();
    }

    List<TimeSeries> spannerTimeSeries;
    try {
      spannerTimeSeries =
          SpannerCloudMonitoringExporterUtils.convertToSpannerTimeSeries(
              collection, fallbackProjectIdSupplier.get());
    } catch (Throwable e) {
      logger.log(
          Level.WARNING,
          "Failed to convert spanner metric data to cloud monitoring timeseries.",
          e);
      return CompletableResultCode.ofFailure();
    }

    if (spannerTimeSeries.isEmpty()) {
      return CompletableResultCode.ofSuccess();
    }

    Map<String, List<TimeSeries>> timeSeriesByProject =
        spannerTimeSeries.stream()
            .collect(
                Collectors.groupingBy(
                    timeSeries ->
                        timeSeries
                            .getResource()
                            .getLabelsMap()
                            .get(BuiltInMetricsConstant.PROJECT_ID_KEY.getKey())));

    List<ApiFuture<List<Empty>>> futures = new ArrayList<>();
    for (Map.Entry<String, List<TimeSeries>> entry : timeSeriesByProject.entrySet()) {
      ProjectName projectName = ProjectName.of(entry.getKey());
      ApiFuture<List<Empty>> future = exportTimeSeriesInBatch(projectName, entry.getValue());
      ApiFutures.addCallback(
          future,
          new ApiFutureCallback<List<Empty>>() {
            @Override
            public void onFailure(Throwable throwable) {
              logExportFailure(throwable, projectName);
            }

            @Override
            public void onSuccess(List<Empty> ignored) {
              spannerExportFailureLoggedProjects.remove(projectName.getProject());
            }
          },
          MoreExecutors.directExecutor());
      futures.add(future);
    }

    ApiFuture<List<List<Empty>>> groupedFuture = ApiFutures.allAsList(futures);
    ApiFuture<List<Empty>> futureList =
        ApiFutures.transform(
            groupedFuture,
            groupedResults ->
                groupedResults.stream().flatMap(List::stream).collect(Collectors.toList()),
            MoreExecutors.directExecutor());

    CompletableResultCode spannerExportCode = new CompletableResultCode();
    ApiFutures.addCallback(
        futureList,
        new ApiFutureCallback<List<Empty>>() {
          @Override
          public void onFailure(Throwable throwable) {
            spannerExportCode.fail();
          }

          @Override
          public void onSuccess(List<Empty> empty) {
            spannerExportCode.succeed();
          }
        },
        MoreExecutors.directExecutor());

    return spannerExportCode;
  }

  private void logExportFailure(Throwable throwable, ProjectName projectName) {
    if (spannerExportFailureLoggedProjects.add(projectName.getProject())) {
      String msg = "createServiceTimeSeries request failed for spanner metrics.";
      if (throwable instanceof PermissionDeniedException) {
        msg +=
            String.format(
                " Need monitoring metric writer permission on project=%s. Follow"
                    + " https://cloud.google.com/spanner/docs/view-manage-client-side-metrics"
                    + "#access-client-side-metrics"
                    + " to set up permissions",
                projectName.getProject());
      } else {
        msg += String.format(" project=%s.", projectName.getProject());
      }
      logger.log(Level.WARNING, msg, throwable);
    }
  }

  private ApiFuture<List<Empty>> exportTimeSeriesInBatch(
      ProjectName projectName, List<TimeSeries> timeSeries) {
    List<ApiFuture<Empty>> batchResults = new ArrayList<>();

    for (List<TimeSeries> batch : Iterables.partition(timeSeries, EXPORT_BATCH_SIZE_LIMIT)) {
      CreateTimeSeriesRequest req =
          CreateTimeSeriesRequest.newBuilder()
              .setName(projectName.toString())
              .addAllTimeSeries(batch)
              .build();
      batchResults.add(this.client.createServiceTimeSeriesCallable().futureCall(req));
    }

    return ApiFutures.allAsList(batchResults);
  }

  @Override
  public CompletableResultCode flush() {
    return CompletableResultCode.ofSuccess();
  }

  @Override
  public CompletableResultCode shutdown() {
    if (client.isShutdown()) {
      logger.log(Level.WARNING, "shutdown is called multiple times");
      return CompletableResultCode.ofSuccess();
    }
    CompletableResultCode shutdownResult = new CompletableResultCode();
    try {
      client.shutdown();
      shutdownResult.succeed();
    } catch (Throwable e) {
      logger.log(Level.WARNING, "failed to shutdown the monitoring client", e);
      shutdownResult.fail();
    }
    return shutdownResult;
  }

  /**
   * For Google Cloud Monitoring always return CUMULATIVE to keep track of the cumulative value of a
   * metric over time.
   */
  @Override
  public AggregationTemporality getAggregationTemporality(@Nonnull InstrumentType instrumentType) {
    return AggregationTemporality.CUMULATIVE;
  }
}
