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
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.auth.Credentials;
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
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * <p>The implementation in this file is inspired from the original work done in the Spanner client
 * library (SpannerCloudMonitoringExporter) to export metrics. The logic has been adapted for
 * Datastore's use case.
 */
class DatastoreCloudMonitoringExporter implements MetricExporter {

  private static final Logger logger =
      Logger.getLogger(DatastoreCloudMonitoringExporter.class.getName());

  /**
   * Wrapper class to hold a {@link MetricServiceClient} and its reference count. This is used to
   * share the client across multiple exporter instances.
   */
  static class CachedMetricsClient {
    final MetricServiceClient client;
    final AtomicInteger refCount = new AtomicInteger(0);

    CachedMetricsClient(MetricServiceClient client) {
      this.client = client;
    }
  }

  /**
   * Shared cache for {@link MetricServiceClient} instances, keyed by
   * "projectId:databaseId:credentialsHashCode". Sharing a single gRPC channel across exporter
   * instances that target the same project, database, and credentials avoids per-client channel
   * overhead (threads, connections, memory). The credentials hash ensures that clients using
   * different credentials get their own isolated channel. Reference counting is used to safely shut
   * down the client when no longer needed.
   */
  static final ConcurrentHashMap<String, CachedMetricsClient> METRICS_CLIENT_CACHE =
      new ConcurrentHashMap<>();

  private final MetricServiceClient client;
  private final Map<String, String> clientAttributes;
  private final String cacheKey;

  // This is the quota limit from Cloud Monitoring. More details in
  // https://cloud.google.com/monitoring/quotas#custom_metrics_quotas.
  private static final int EXPORT_BATCH_SIZE_LIMIT = 200;

  // Increase max metadata size to 32MB to avoid "Header size exceeded" errors
  // when receiving large error payloads from Cloud Monitoring.
  private static final int MAX_METADATA_SIZE = 32 * 1024 * 1024;

  // Flag to prevent log spam of any export failures
  private final AtomicBoolean datastoreExportFailureLogged = new AtomicBoolean(false);

  // Flag to prevent double shutdown of this exporter instance
  private final AtomicBoolean isExporterShutDown = new AtomicBoolean(false);

  private final String projectId;

  /**
   * Creates a new instance of the exporter.
   *
   * <p>The gRPC channel is configured with a 32MB inbound metadata limit ({@link
   * #MAX_METADATA_SIZE}) to prevent "Header size exceeded" errors when Cloud Monitoring returns
   * large error payloads in gRPC trailers. The default gRPC limit is too small for some error
   * responses and can mask the real failure reason.
   *
   * <p>{@code createTimeSeries} is used instead of {@code createServiceTimeSeries} because the
   * Firestore namespace in Cloud Monitoring (b/405457573) has not yet been deployed as a service
   * resource. Once the namespace is available, this should be migrated to {@code
   * createServiceTimeSeries} for correct quota and resource attribution.
   *
   * @param projectId the GCP project ID where metrics will be exported.
   * @param credentials the credentials used to authenticate with Cloud Monitoring.
   * @return a new {@link DatastoreCloudMonitoringExporter} instance.
   */
  @Nullable
  static DatastoreCloudMonitoringExporter create(
      String projectId,
      String databaseId,
      Credentials credentials,
      Map<String, String> clientAttributes) {
    int credHash = credentials != null ? credentials.hashCode() : 0;
    String key = projectId + ":" + databaseId + ":" + credHash;

    // Use compute to acquire or create the client atomically with reference counting.
    // If creation fails, we log the error and return null so it's not added to the map.
    CachedMetricsClient cachedMetricsClient =
        METRICS_CLIENT_CACHE.compute(
            key,
            (k, v) -> {
              if (v == null) {
                try {
                  v = new CachedMetricsClient(createMetricServiceClient(credentials));
                } catch (IOException e) {
                  logger.log(
                      Level.WARNING,
                      "Failed to create MetricServiceClient for metrics export. Monitoring will be disabled.",
                      e);
                  return null; // Do not add to map
                }
              }
              v.refCount.incrementAndGet();
              return v;
            });

    // If there is no client in the cache (creation failed), return null.
    if (cachedMetricsClient == null) {
      return null;
    }

    return new DatastoreCloudMonitoringExporter(
        key, projectId, cachedMetricsClient.client, clientAttributes);
  }

  private static MetricServiceClient createMetricServiceClient(Credentials credentials)
      throws IOException {
    MetricServiceSettings.Builder settingsBuilder = MetricServiceSettings.newBuilder();

    InstantiatingGrpcChannelProvider transportChannelProvider =
        MetricServiceSettings.defaultGrpcTransportProviderBuilder()
            .setMaxInboundMetadataSize(MAX_METADATA_SIZE)
            .build();
    settingsBuilder.setTransportChannelProvider(transportChannelProvider);

    settingsBuilder.setCredentialsProvider(FixedCredentialsProvider.create(credentials));

    settingsBuilder
        .createTimeSeriesSettings()
        .setSimpleTimeoutNoRetriesDuration(Duration.ofMinutes(1));

    return MetricServiceClient.create(settingsBuilder.build());
  }

  @VisibleForTesting
  DatastoreCloudMonitoringExporter(
      String cacheKey,
      String projectId,
      MetricServiceClient client,
      Map<String, String> clientAttributes) {
    this.cacheKey = cacheKey;
    this.client = client;
    this.projectId = projectId;
    this.clientAttributes = clientAttributes;
  }

  /**
   * Exports the provided collection of {@link MetricData} to Cloud Monitoring.
   *
   * @param collection the collection of metric data to export.
   * @return a {@link CompletableResultCode} indicating the result of the export operation.
   */
  @Override
  public CompletableResultCode export(@Nonnull Collection<MetricData> collection) {
    if (isExporterShutDown.get()) {
      logger.log(Level.WARNING, "Exporter is shut down");
      return CompletableResultCode.ofFailure();
    }

    // Skips exporting if there's none
    if (collection.isEmpty()) {
      return CompletableResultCode.ofSuccess();
    }

    List<TimeSeries> datastoreTimeSeries;
    try {
      // Convert OTel MetricData to Cloud Monitoring TimeSeries.
      datastoreTimeSeries =
          DatastoreCloudMonitoringExporterUtils.convertToDatastoreTimeSeries(
              new ArrayList<>(collection), clientAttributes);
    } catch (Throwable e) {
      logger.log(
          Level.WARNING,
          "Failed to convert Datastore metric data to Cloud Monitoring timeseries.",
          e);
      return CompletableResultCode.ofFailure();
    }

    ProjectName projectName = ProjectName.of(projectId);

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

  /**
   * Best-effort flush of any pending exports.
   *
   * <p>This implementation is a no-op and always returns {@link CompletableResultCode#ofSuccess()}.
   * Because exports are performed asynchronously via {@link ApiFuture} callbacks, this flush cannot
   * guarantee that all concurrent in-flight network requests have completed by the time this method
   * returns. For a stronger guarantee, callers should invoke {@code SdkMeterProvider.forceFlush()},
   * which coordinates across the {@link io.opentelemetry.sdk.metrics.export.MetricReader} and
   * ensures a full collection cycle completes before returning.
   */
  @Override
  public CompletableResultCode flush() {
    return CompletableResultCode.ofSuccess();
  }

  /** Shuts down the exporter and the underlying {@link MetricServiceClient}. */
  @Override
  public CompletableResultCode shutdown() {
    if (!isExporterShutDown.compareAndSet(false, true)) {
      logger.log(Level.WARNING, "shutdown is called multiple times");
      return CompletableResultCode.ofSuccess();
    }
    CompletableResultCode shutdownResult = new CompletableResultCode();
    try {
      // Atomically decrement reference count and cleanup if zero.
      METRICS_CLIENT_CACHE.compute(
          cacheKey,
          (k, v) -> {
            if (v != null && v.refCount.decrementAndGet() == 0) {
              v.client.shutdown();
              return null; // Remove from map to prevent leaks
            }

            return v;
          });
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
