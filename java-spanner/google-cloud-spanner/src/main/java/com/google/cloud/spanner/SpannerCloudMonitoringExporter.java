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
import io.opentelemetry.sdk.resources.Resource;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
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
  private final AtomicBoolean spannerExportFailureLogged = new AtomicBoolean(false);
  private final AtomicBoolean lastExportSkippedData = new AtomicBoolean(false);
  private final MetricServiceClient client;
  private final String spannerProjectId;

  static SpannerCloudMonitoringExporter create(
      String projectId,
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
        projectId, MetricServiceClient.create(settingsBuilder.build()));
  }

  @VisibleForTesting
  SpannerCloudMonitoringExporter(String projectId, MetricServiceClient client) {
    this.client = client;
    this.spannerProjectId = projectId;
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
    // Filter spanner metrics. Only include metrics that contain a valid project.
    List<MetricData> spannerMetricData = collection.stream().collect(Collectors.toList());

    // Log warnings for metrics that will be skipped.
    boolean mustFilter = false;
    if (spannerMetricData.stream()
        .map(metricData -> metricData.getResource())
        .anyMatch(this::shouldSkipPointDataDueToProjectId)) {
      logger.log(
          Level.WARNING, "Some metric data contain a different projectId. These will be skipped.");
      mustFilter = true;
    }

    if (mustFilter) {
      spannerMetricData =
          spannerMetricData.stream()
              .filter(this::shouldSkipMetricData)
              .collect(Collectors.toList());
    }
    lastExportSkippedData.set(mustFilter);

    // Skips exporting if there's none
    if (spannerMetricData.isEmpty()) {
      return CompletableResultCode.ofSuccess();
    }

    List<TimeSeries> spannerTimeSeries;
    try {
      spannerTimeSeries =
          SpannerCloudMonitoringExporterUtils.convertToSpannerTimeSeries(
              spannerMetricData, this.spannerProjectId);
    } catch (Throwable e) {
      logger.log(
          Level.WARNING,
          "Failed to convert spanner metric data to cloud monitoring timeseries.",
          e);
      return CompletableResultCode.ofFailure();
    }

    ProjectName projectName = ProjectName.of(spannerProjectId);

    ApiFuture<List<Empty>> futureList = exportTimeSeriesInBatch(projectName, spannerTimeSeries);

    CompletableResultCode spannerExportCode = new CompletableResultCode();
    ApiFutures.addCallback(
        futureList,
        new ApiFutureCallback<List<Empty>>() {
          @Override
          public void onFailure(Throwable throwable) {
            if (spannerExportFailureLogged.compareAndSet(false, true)) {
              String msg = "createServiceTimeSeries request failed for spanner metrics.";
              if (throwable instanceof PermissionDeniedException) {
                // TODO: Add the link of public documentation when available in the log message.
                msg +=
                    String.format(
                        " Need monitoring metric writer permission on project=%s. Follow"
                            + " https://cloud.google.com/spanner/docs/view-manage-client-side-metrics#access-client-side-metrics"
                            + " to set up permissions",
                        projectName.getProject());
              }
              logger.log(Level.WARNING, msg, throwable);
            }
            spannerExportCode.fail();
          }

          @Override
          public void onSuccess(List<Empty> empty) {
            // When an export succeeded reset the export failure flag to false so if there's a
            // transient failure it'll be logged.
            spannerExportFailureLogged.set(false);
            spannerExportCode.succeed();
          }
        },
        MoreExecutors.directExecutor());

    return spannerExportCode;
  }

  private boolean shouldSkipMetricData(MetricData metricData) {
    return shouldSkipPointDataDueToProjectId(metricData.getResource());
  }

  private boolean shouldSkipPointDataDueToProjectId(Resource resource) {
    return !spannerProjectId.equals(SpannerCloudMonitoringExporterUtils.getProjectId(resource));
  }

  boolean lastExportSkippedData() {
    return this.lastExportSkippedData.get();
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
