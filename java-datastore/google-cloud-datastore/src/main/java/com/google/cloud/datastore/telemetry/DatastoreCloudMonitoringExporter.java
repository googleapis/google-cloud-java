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

package com.google.cloud.datastore.telemetry;

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
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.TimeSeries;
import com.google.protobuf.Empty;
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
 * Datastore Cloud Monitoring OpenTelemetry Exporter.
 *
 * <p>The exporter will look for all Datastore-owned metrics under {@link
 * TelemetryConstants#METRIC_PREFIX} instrumentation scope and upload it via the Google Cloud
 * Monitoring API.
 *
 * <p>This implementation is a standalone exporter that does not depend on the {@code
 * com.google.cloud.opentelemetry:exporter-metrics} library, to avoid external version management
 * and ensure tight integration with Datastore requirements.
 *
 * <p>The implementation in this file is inspired from the original work done in the Spanner
 * client library (SpannerCloudMonitoringExporter) to export metrics. The logic has been
 * adapted for Datastore's use case.
 */
class DatastoreCloudMonitoringExporter implements MetricExporter {

  private static final Logger logger =
      Logger.getLogger(DatastoreCloudMonitoringExporter.class.getName());

  // This is the quota limit from Cloud Monitoring. More details in
  // https://cloud.google.com/monitoring/quotas#custom_metrics_quotas.
  private static final int EXPORT_BATCH_SIZE_LIMIT = 200;
  private static final int MAX_METADATA_SIZE = 32 * 1024;
  private final AtomicBoolean datastoreExportFailureLogged = new AtomicBoolean(false);
  private final MetricServiceClient client;
  private final String datastoreProjectId;

  /**
   * Creates a new instance of the exporter.
   *
   * @param projectId the GCP project ID where metrics will be exported.
   * @param credentials the credentials used to authenticate with Cloud Monitoring.
   * @return a new {@link DatastoreCloudMonitoringExporter} instance.
   * @throws IOException if the {@link MetricServiceClient} fails to initialize.
   */
  static DatastoreCloudMonitoringExporter create(
      String projectId, @Nullable Credentials credentials) throws IOException {
    MetricServiceSettings.Builder settingsBuilder = MetricServiceSettings.newBuilder();

    // Increase max metadata size to 1MB to avoid "Header size exceeded" errors
    // when receiving large error payloads from Cloud Monitoring.
    InstantiatingGrpcChannelProvider transportChannelProvider =
        MetricServiceSettings.defaultGrpcTransportProviderBuilder()
            .setMaxInboundMetadataSize(MAX_METADATA_SIZE)
            .build();
    settingsBuilder.setTransportChannelProvider(transportChannelProvider);

    CredentialsProvider credentialsProvider;
    if (credentials == null || credentials instanceof NoCredentials) {
      credentialsProvider = NoCredentialsProvider.create();
    } else {
      credentialsProvider = FixedCredentialsProvider.create(credentials);
    }
    settingsBuilder.setCredentialsProvider(credentialsProvider);

    Duration timeout = Duration.ofMinutes(1);

    // Use `createTimeSeries` instead of `createServiceTimeSeries` as the Firestore namespace
    // is not deployed yet. This results in permission issues as we cannot write Service metrics.
    // This call is done on a best-effort basis and may result in some metrics being dropped.
    settingsBuilder.createTimeSeriesSettings().setSimpleTimeoutNoRetriesDuration(timeout);

    return new DatastoreCloudMonitoringExporter(
        projectId, MetricServiceClient.create(settingsBuilder.build()));
  }

  @VisibleForTesting
  DatastoreCloudMonitoringExporter(String projectId, MetricServiceClient client) {
    this.client = client;
    this.datastoreProjectId = projectId;
  }

  /**
   * Exports the provided collection of {@link MetricData} to Cloud Monitoring.
   *
   * @param collection the collection of metric data to export.
   * @return a {@link CompletableResultCode} indicating the result of the export operation.
   */
  @Override
  public CompletableResultCode export(@Nonnull Collection<MetricData> collection) {
    if (client.isShutdown()) {
      logger.log(Level.WARNING, "Exporter is shut down");
      return CompletableResultCode.ofFailure();
    }

    return exportDatastoreClientMetrics(collection);
  }

  /**
   * Filters and exports Datastore-specific metrics.
   *
   * <p>This method identifies metrics belonging to the Datastore or GAX instrumentation scopes and
   * converts them to Cloud Monitoring {@link TimeSeries} format before uploading.
   *
   * @param collection the full collection of metrics from the OpenTelemetry SDK.
   * @return a {@link CompletableResultCode} indicating success or failure.
   */
  private CompletableResultCode exportDatastoreClientMetrics(Collection<MetricData> collection) {
    // A single OpenTelemetry MeterProvider can be shared across multiple libraries and services
    // in the same JVM. We filter by instrumentation scope (GAX and Datastore) to ensure that
    // this exporter only processes metrics it is designed to handle, avoiding "pollution" from
    // unrelated application or library metrics.
    List<MetricData> datastoreMetricData =
        collection.stream()
            .filter(
                metricData ->
                    metricData
                            .getInstrumentationScopeInfo()
                            .getName()
                            .equals(TelemetryConstants.GAX_METER_NAME)
                        || metricData
                            .getInstrumentationScopeInfo()
                            .getName()
                            .equals(TelemetryConstants.DATASTORE_METER_NAME))
            .collect(Collectors.toList());

    // Users may share a single OpenTelemetry instance across multiple Datastore clients pointing
    // to different projects. Because the MetricReader collects all metrics from the shared
    // provider, we must verify that each metric point matches this exporter's target project.
    // This prevents cross-project pollution and avoids PermissionDenied errors when uploading
    // metrics belonging to a different project.
    if (datastoreMetricData.stream()
        .map(MetricData::getResource)
        .anyMatch(this::shouldSkipPointDataDueToProjectId)) {
      logger.log(
          Level.WARNING, "Some metric data contain a different projectId. These will be skipped.");
      datastoreMetricData =
          datastoreMetricData.stream()
              .filter(metricData -> !shouldSkipPointDataDueToProjectId(metricData.getResource()))
              .collect(Collectors.toList());
    }

    // Skips exporting if there's none
    if (datastoreMetricData.isEmpty()) {
      return CompletableResultCode.ofSuccess();
    }

    List<TimeSeries> datastoreTimeSeries;
    try {
      // Convert OTel MetricData to Cloud Monitoring TimeSeries.
      datastoreTimeSeries =
          DatastoreCloudMonitoringExporterUtils.convertToDatastoreTimeSeries(
              datastoreMetricData);
    } catch (Throwable e) {
      logger.log(
          Level.WARNING,
          "Failed to convert Datastore metric data to Cloud Monitoring timeseries.",
          e);
      return CompletableResultCode.ofFailure();
    }

    ProjectName projectName = ProjectName.of(datastoreProjectId);

    // Perform the actual network call to Cloud Monitoring.
    ApiFuture<List<Empty>> futureList = exportTimeSeriesInBatch(projectName, datastoreTimeSeries);

    CompletableResultCode datastoreExportCode = new CompletableResultCode();
    ApiFutures.addCallback(
        futureList,
        new ApiFutureCallback<List<Empty>>() {
          @Override
          public void onFailure(Throwable throwable) {
            // Only log failure once to avoid log spam, then reset on success.
            if (datastoreExportFailureLogged.compareAndSet(false, true)) {
              String msg = "createTimeSeries request failed for Datastore metrics.";

              if (throwable instanceof PermissionDeniedException) {
                msg +=
                    String.format(
                        " Need monitoring metric writer permission on project=%s.",
                        projectName.getProject());
              }
              logger.log(Level.WARNING, msg, throwable);
            }
            datastoreExportCode.fail();
          }

          @Override
          public void onSuccess(List<Empty> empty) {
            // When an export succeeded reset the export failure flag to false so if there's a
            // transient failure it'll be logged.
            datastoreExportFailureLogged.set(false);
            datastoreExportCode.succeed();
          }
        },
        MoreExecutors.directExecutor());

    return datastoreExportCode;
  }

  /**
   * Checks if the metric data point should be skipped because it belongs to a different project.
   */
  private boolean shouldSkipPointDataDueToProjectId(Resource resource) {
    String projectId = DatastoreCloudMonitoringExporterUtils.getProjectId(resource);
    return !datastoreProjectId.equals(projectId);
  }

  /** Batches and sends the {@link TimeSeries} to Cloud Monitoring. */
  private ApiFuture<List<Empty>> exportTimeSeriesInBatch(
      ProjectName projectName, List<TimeSeries> timeSeries) {
    List<ApiFuture<Empty>> batchResults = new ArrayList<>();

    for (List<TimeSeries> batch : Iterables.partition(timeSeries, EXPORT_BATCH_SIZE_LIMIT)) {
      CreateTimeSeriesRequest req =
          CreateTimeSeriesRequest.newBuilder()
              .setName(projectName.toString())
              .addAllTimeSeries(batch)
              .build();
      batchResults.add(this.client.createTimeSeriesCallable().futureCall(req));
    }

    return ApiFutures.allAsList(batchResults);
  }

  @Override
  public CompletableResultCode flush() {
    return CompletableResultCode.ofSuccess();
  }

  /** Shuts down the exporter and the underlying {@link MetricServiceClient}. */
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
   * Returns the {@link AggregationTemporality} for this exporter.
   *
   * <p>For Google Cloud Monitoring, we always use {@link AggregationTemporality#CUMULATIVE} to
   * maintain a continuous count or sum over time.
   */
  @Override
  public AggregationTemporality getAggregationTemporality(@Nonnull InstrumentType instrumentType) {
    return AggregationTemporality.CUMULATIVE;
  }
}
