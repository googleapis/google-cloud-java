/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub.metrics;

import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.APPLICATION_BLOCKING_LATENCIES_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.ATTEMPT_LATENCIES_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.CLIENT_BLOCKING_LATENCIES_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.CONNECTIVITY_ERROR_COUNT_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.FIRST_RESPONSE_LATENCIES_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.METER_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.OPERATION_LATENCIES_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.PER_CONNECTION_ERROR_COUNT_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.REMAINING_DEADLINE_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.RETRY_COUNT_NAME;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.SERVER_LATENCIES_NAME;

import com.google.api.MonitoredResource;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.auth.Credentials;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.cloud.monitoring.v3.MetricServiceSettings;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/**
 * Bigtable Cloud Monitoring OpenTelemetry Exporter.
 *
 * <p>The exporter will look for all bigtable owned metrics under bigtable.googleapis.com
 * instrumentation scope and upload it via the Google Cloud Monitoring API.
 */
@InternalApi
public final class BigtableCloudMonitoringExporter implements MetricExporter {

  private static final Logger logger =
      Logger.getLogger(BigtableCloudMonitoringExporter.class.getName());

  // This system property can be used to override the monitoring endpoint
  // to a different environment. It's meant for internal testing only and
  // will be removed in future versions. Use settings in EnhancedBigtableStubSettings
  // to override the endpoint.
  @Deprecated @Nullable
  private static final String MONITORING_ENDPOINT_OVERRIDE_SYS_PROP =
      System.getProperty("bigtable.test-monitoring-endpoint");

  private static final String APPLICATION_RESOURCE_PROJECT_ID = "project_id";

  // This the quota limit from Cloud Monitoring. More details in
  // https://cloud.google.com/monitoring/quotas#custom_metrics_quotas.
  private static final int EXPORT_BATCH_SIZE_LIMIT = 200;

  private final String exporterName;

  private final MetricServiceClient client;

  private final TimeSeriesConverter timeSeriesConverter;

  private final AtomicBoolean isShutdown = new AtomicBoolean(false);

  private CompletableResultCode lastExportCode;

  private final AtomicBoolean exportFailureLogged = new AtomicBoolean(false);

  static BigtableCloudMonitoringExporter create(
      String exporterName,
      @Nullable Credentials credentials,
      @Nullable String endpoint,
      TimeSeriesConverter converter)
      throws IOException {

    MetricServiceSettings.Builder settingsBuilder = MetricServiceSettings.newBuilder();
    CredentialsProvider credentialsProvider =
        Optional.ofNullable(credentials)
            .<CredentialsProvider>map(FixedCredentialsProvider::create)
            .orElse(NoCredentialsProvider.create());
    settingsBuilder.setCredentialsProvider(credentialsProvider);
    if (MONITORING_ENDPOINT_OVERRIDE_SYS_PROP != null) {
      logger.warning(
          "Setting the monitoring endpoint through system variable will be removed in future versions");
      settingsBuilder.setEndpoint(MONITORING_ENDPOINT_OVERRIDE_SYS_PROP);
    }
    if (endpoint != null) {
      settingsBuilder.setEndpoint(endpoint);
    }

    Duration timeout = Duration.ofMinutes(1);
    // TODO: createServiceTimeSeries needs special handling if the request failed. Leaving
    // it as not retried for now.
    settingsBuilder.createServiceTimeSeriesSettings().setSimpleTimeoutNoRetriesDuration(timeout);

    return new BigtableCloudMonitoringExporter(
        exporterName, MetricServiceClient.create(settingsBuilder.build()), converter);
  }

  @VisibleForTesting
  BigtableCloudMonitoringExporter(
      String exporterName, MetricServiceClient client, TimeSeriesConverter converter) {
    this.exporterName = exporterName;
    this.client = client;
    this.timeSeriesConverter = converter;
  }

  @Override
  public CompletableResultCode export(Collection<MetricData> metricData) {
    Preconditions.checkState(!isShutdown.get(), "Exporter is shutting down");

    lastExportCode = doExport(metricData);
    return lastExportCode;
  }

  /** Export metrics associated with a BigtableTable resource. */
  private CompletableResultCode doExport(Collection<MetricData> metricData) {
    Map<ProjectName, List<TimeSeries>> bigtableTimeSeries;

    try {
      bigtableTimeSeries = timeSeriesConverter.convert(metricData);
    } catch (Throwable t) {
      logger.log(
          Level.WARNING,
          String.format(
              "Failed to convert %s metric data to cloud monitoring timeseries.", exporterName),
          t);
      return CompletableResultCode.ofFailure();
    }

    // Skips exporting if there's none
    if (bigtableTimeSeries.isEmpty()) {
      return CompletableResultCode.ofSuccess();
    }

    CompletableResultCode exportCode = new CompletableResultCode();
    bigtableTimeSeries.forEach(
        (projectName, ts) -> {
          ApiFuture<List<Empty>> future = exportTimeSeries(projectName, ts);
          ApiFutures.addCallback(
              future,
              new ApiFutureCallback<List<Empty>>() {
                @Override
                public void onFailure(Throwable throwable) {
                  if (exportFailureLogged.compareAndSet(false, true)) {
                    String msg =
                        String.format(
                            "createServiceTimeSeries request failed for %s.", exporterName);
                    if (throwable instanceof PermissionDeniedException) {
                      msg +=
                          String.format(
                              " Need monitoring metric writer permission on project=%s. Follow https://cloud.google.com/bigtable/docs/client-side-metrics-setup to set up permissions.",
                              projectName.getProject());
                    }
                    logger.log(Level.WARNING, msg, throwable);
                  }
                  exportCode.fail();
                }

                @Override
                public void onSuccess(List<Empty> emptyList) {
                  // When an export succeeded reset the export failure flag to false so if there's a
                  // transient failure it'll be logged.
                  exportFailureLogged.set(false);
                  exportCode.succeed();
                }
              },
              MoreExecutors.directExecutor());
        });

    return exportCode;
  }

  private ApiFuture<List<Empty>> exportTimeSeries(
      ProjectName projectName, List<TimeSeries> timeSeries) {
    List<ApiFuture<Empty>> batchResults = new ArrayList<>();

    for (List<TimeSeries> batch : Iterables.partition(timeSeries, EXPORT_BATCH_SIZE_LIMIT)) {
      CreateTimeSeriesRequest req =
          CreateTimeSeriesRequest.newBuilder()
              .setName(projectName.toString())
              .addAllTimeSeries(batch)
              .build();
      ApiFuture<Empty> f = this.client.createServiceTimeSeriesCallable().futureCall(req);
      batchResults.add(f);
    }

    return ApiFutures.allAsList(batchResults);
  }

  @Override
  public CompletableResultCode flush() {
    if (lastExportCode != null) {
      return lastExportCode;
    }
    return CompletableResultCode.ofSuccess();
  }

  @Override
  public CompletableResultCode shutdown() {
    if (!isShutdown.compareAndSet(false, true)) {
      logger.log(Level.WARNING, "shutdown is called multiple times");
      return CompletableResultCode.ofSuccess();
    }
    CompletableResultCode flushResult = flush();
    CompletableResultCode shutdownResult = new CompletableResultCode();
    flushResult.whenComplete(
        () -> {
          Throwable throwable = null;
          try {
            client.shutdown();
          } catch (Throwable e) {
            logger.log(Level.WARNING, "failed to shutdown the monitoring client", e);
            throwable = e;
          }
          if (throwable != null) {
            shutdownResult.fail();
          } else {
            shutdownResult.succeed();
          }
        });
    return CompletableResultCode.ofAll(Arrays.asList(flushResult, shutdownResult));
  }

  /**
   * For Google Cloud Monitoring always return CUMULATIVE to keep track of the cumulative value of a
   * metric over time.
   */
  @Override
  public AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
    return AggregationTemporality.CUMULATIVE;
  }

  interface TimeSeriesConverter {
    Map<ProjectName, List<TimeSeries>> convert(Collection<MetricData> metricData);
  }

  static class PublicTimeSeriesConverter implements TimeSeriesConverter {
    private static final ImmutableList<String> BIGTABLE_TABLE_METRICS =
        ImmutableSet.of(
                OPERATION_LATENCIES_NAME,
                ATTEMPT_LATENCIES_NAME,
                SERVER_LATENCIES_NAME,
                FIRST_RESPONSE_LATENCIES_NAME,
                CLIENT_BLOCKING_LATENCIES_NAME,
                APPLICATION_BLOCKING_LATENCIES_NAME,
                RETRY_COUNT_NAME,
                CONNECTIVITY_ERROR_COUNT_NAME,
                REMAINING_DEADLINE_NAME)
            .stream()
            .map(m -> METER_NAME + m)
            .collect(ImmutableList.toImmutableList());

    private final String taskId;

    PublicTimeSeriesConverter() {
      this(BigtableExporterUtils.DEFAULT_TASK_VALUE.get());
    }

    PublicTimeSeriesConverter(String taskId) {
      this.taskId = taskId;
    }

    @Override
    public Map<ProjectName, List<TimeSeries>> convert(Collection<MetricData> metricData) {
      List<MetricData> relevantData =
          metricData.stream()
              .filter(md -> BIGTABLE_TABLE_METRICS.contains(md.getName()))
              .collect(Collectors.toList());
      if (relevantData.isEmpty()) {
        return ImmutableMap.of();
      }
      return BigtableExporterUtils.convertToBigtableTimeSeries(relevantData, taskId);
    }
  }

  static class InternalTimeSeriesConverter implements TimeSeriesConverter {
    private static final ImmutableList<String> APPLICATION_METRICS =
        ImmutableSet.of(PER_CONNECTION_ERROR_COUNT_NAME).stream()
            .map(m -> METER_NAME + m)
            .collect(ImmutableList.toImmutableList());

    private final String taskId;
    private final Supplier<MonitoredResource> monitoredResource;

    InternalTimeSeriesConverter(Supplier<MonitoredResource> monitoredResource) {
      this(monitoredResource, BigtableExporterUtils.DEFAULT_TASK_VALUE.get());
    }

    InternalTimeSeriesConverter(Supplier<MonitoredResource> monitoredResource, String taskId) {
      this.monitoredResource = monitoredResource;
      this.taskId = taskId;
    }

    @Override
    public Map<ProjectName, List<TimeSeries>> convert(Collection<MetricData> metricData) {
      MonitoredResource monitoredResource = this.monitoredResource.get();
      if (monitoredResource == null) {
        return ImmutableMap.of();
      }

      List<MetricData> relevantData =
          metricData.stream()
              .filter(md -> APPLICATION_METRICS.contains(md.getName()))
              .collect(Collectors.toList());
      if (relevantData.isEmpty()) {
        return ImmutableMap.of();
      }

      return ImmutableMap.of(
          ProjectName.of(monitoredResource.getLabelsOrThrow(APPLICATION_RESOURCE_PROJECT_ID)),
          BigtableExporterUtils.convertToApplicationResourceTimeSeries(
              relevantData, taskId, monitoredResource));
    }
  }
}
