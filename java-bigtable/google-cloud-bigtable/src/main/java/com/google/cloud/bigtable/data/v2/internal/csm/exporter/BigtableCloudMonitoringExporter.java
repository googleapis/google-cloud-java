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
package com.google.cloud.bigtable.data.v2.internal.csm.exporter;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.auth.Credentials;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.EnvInfo;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.cloud.monitoring.v3.MetricServiceSettings;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
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
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public class BigtableCloudMonitoringExporter implements MetricExporter {
  private static final Logger LOGGER =
      Logger.getLogger(BigtableCloudMonitoringExporter.class.getName());

  // This system property can be used to override the monitoring endpoint
  // to a different environment. It's meant for internal testing only and
  // will be removed in future versions. Use settings in EnhancedBigtableStubSettings
  // to override the endpoint.
  @Deprecated @Nullable
  private static final String MONITORING_ENDPOINT_OVERRIDE_SYS_PROP =
      System.getProperty("bigtable.test-monitoring-endpoint");

  // This the quota limit from Cloud Monitoring. More details in
  // https://cloud.google.com/monitoring/quotas#custom_metrics_quotas.
  private static final int EXPORT_BATCH_SIZE_LIMIT = 200;

  private final Supplier<EnvInfo> envInfo;
  private final ClientInfo clientInfo;
  private final MetricRegistry metricRegistry;
  private final MetricServiceClient client;

  private final AtomicReference<State> state;
  private CompletableResultCode lastExportCode;
  private final AtomicBoolean exportFailureLogged = new AtomicBoolean(false);

  private enum State {
    Running,
    Closing,
    Closed
  }

  public static BigtableCloudMonitoringExporter create(
      MetricRegistry metricRegistry,
      Supplier<EnvInfo> envInfo,
      ClientInfo clientInfo,
      @Nullable Credentials credentials,
      @Nullable String endpoint,
      String universeDomain)
      throws IOException {

    Preconditions.checkNotNull(universeDomain);

    MetricServiceSettings.Builder settingsBuilder =
        MetricServiceSettings.newBuilder()
            .setUniverseDomain(universeDomain)
            .setCredentialsProvider(
                Optional.ofNullable(credentials)
                    .<CredentialsProvider>map(FixedCredentialsProvider::create)
                    .orElse(NoCredentialsProvider.create()));

    if (MONITORING_ENDPOINT_OVERRIDE_SYS_PROP != null) {
      LOGGER.warning(
          "Setting the monitoring endpoint through system variable will be removed in future"
              + " versions");
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
        metricRegistry, envInfo, clientInfo, MetricServiceClient.create(settingsBuilder.build()));
  }

  @VisibleForTesting
  public BigtableCloudMonitoringExporter(
      MetricRegistry metricRegistry,
      Supplier<EnvInfo> envInfo,
      ClientInfo clientInfo,
      MetricServiceClient client) {
    this.metricRegistry = metricRegistry;
    this.envInfo = envInfo;
    this.clientInfo = clientInfo;
    this.client = client;
    this.state = new AtomicReference<>(State.Running);
  }

  public void close() {
    client.close();
  }

  @Override
  public CompletableResultCode export(Collection<MetricData> metricData) {
    Preconditions.checkState(state.get() != State.Closed, "Exporter is closed");

    lastExportCode = doExport(metricData);
    return lastExportCode;
  }

  private CompletableResultCode doExport(Collection<MetricData> metricData) {
    Map<ProjectName, Collection<TimeSeries>> converted;

    try {
      converted = new Converter(metricRegistry, envInfo.get(), clientInfo).convertAll(metricData);
    } catch (Throwable t) {
      if (exportFailureLogged.compareAndSet(false, true)) {
        LOGGER.log(Level.WARNING, "Failed to compose metrics for export", t);
      }

      return CompletableResultCode.ofExceptionalFailure(t);
    }

    List<ApiFuture<?>> futures = new ArrayList<>();

    for (Entry<ProjectName, Collection<TimeSeries>> e : converted.entrySet()) {
      futures.addAll(exportTimeSeries(e.getKey(), e.getValue()));
    }

    CompletableResultCode exportCode = new CompletableResultCode();

    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

    ApiFutures.addCallback(
        ApiFutures.allAsList(futures),
        new ApiFutureCallback<List<Object>>() {
          @Override
          public void onFailure(Throwable throwable) {
            if (exportFailureLogged.compareAndSet(false, true)) {
              String msg = "createServiceTimeSeries request failed";
              if (throwable instanceof PermissionDeniedException) {
                msg +=
                    String.format(
                        " Need monitoring metric writer permission on project=%s. Follow"
                            + " https://cloud.google.com/bigtable/docs/client-side-metrics-setup"
                            + " to set up permissions.",
                        clientInfo.getInstanceName().getProjectId());
              }
              RuntimeException asyncWrapper = new RuntimeException("export failed", throwable);
              asyncWrapper.setStackTrace(stackTrace);

              if (state.get() != State.Closing || state.get() != State.Closed) {
                // ignore the export warning when client is shutting down
                LOGGER.log(Level.WARNING, msg, asyncWrapper);
              }
            }
            exportCode.fail();
          }

          @Override
          public void onSuccess(List<Object> objects) {
            exportFailureLogged.set(false);
            exportCode.succeed();
          }
        },
        MoreExecutors.directExecutor());
    return exportCode;
  }

  private List<ApiFuture<Empty>> exportTimeSeries(
      ProjectName projectName, Collection<TimeSeries> timeSeries) {
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

    return batchResults;
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
    State prevState = state.getAndSet(State.Closed);
    if (prevState == State.Closed) {
      LOGGER.log(Level.WARNING, "shutdown is called multiple times");
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
            LOGGER.log(Level.WARNING, "failed to shutdown the monitoring client", e);
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

  @Override
  public AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
    return AggregationTemporality.CUMULATIVE;
  }

  public void prepareForShutdown() {
    state.compareAndSet(State.Running, State.Closing);
  }
}
