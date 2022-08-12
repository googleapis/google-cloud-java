/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigtable.stats;

import com.google.api.MonitoredResource;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.auth.Credentials;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.cloud.monitoring.v3.MetricServiceSettings;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.opencensus.common.Duration;
import io.opencensus.exporter.metrics.util.IntervalMetricReader;
import io.opencensus.exporter.metrics.util.MetricReader;
import io.opencensus.metrics.Metrics;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

@InternalApi
public class BigtableStackdriverStatsExporter {
  static final Object lock = new Object();

  @Nullable
  @GuardedBy("lock")
  private static BigtableStackdriverStatsExporter instance = null;

  // Default export interval is 1 minute
  private static final Duration EXPORT_INTERVAL = Duration.create(60, 0);
  private static final String RESOURCE_TYPE = "bigtable_client_raw";

  private final IntervalMetricReader intervalMetricReader;

  private BigtableStackdriverStatsExporter(
      MetricServiceClient metricServiceClient,
      Duration exportInterval,
      MonitoredResource monitoredResource) {
    IntervalMetricReader.Options.Builder intervalMetricReaderOptionsBuilder =
        IntervalMetricReader.Options.builder();
    intervalMetricReaderOptionsBuilder.setExportInterval(exportInterval);
    this.intervalMetricReader =
        IntervalMetricReader.create(
            new BigtableCreateTimeSeriesExporter(metricServiceClient, monitoredResource),
            MetricReader.create(
                MetricReader.Options.builder()
                    .setMetricProducerManager(
                        Metrics.getExportComponent().getMetricProducerManager())
                    .build()),
            intervalMetricReaderOptionsBuilder.build());
  }

  public static void register(Credentials credentials) throws IOException {
    synchronized (lock) {
      Preconditions.checkState(
          instance == null, "Bigtable Stackdriver stats exporter is already created");
      // Default timeout for creating a client is 1 minute
      MetricServiceClient client = createMetricServiceClient(credentials, Duration.create(60L, 0));
      MonitoredResource resourceType =
          MonitoredResource.newBuilder().setType(RESOURCE_TYPE).build();
      instance = new BigtableStackdriverStatsExporter(client, EXPORT_INTERVAL, resourceType);
    }
  }

  @GuardedBy("lock")
  @VisibleForTesting
  static MetricServiceClient createMetricServiceClient(Credentials credentials, Duration deadline)
      throws IOException {
    MetricServiceSettings.Builder settingsBuilder =
        MetricServiceSettings.newBuilder()
            .setTransportChannelProvider(InstantiatingGrpcChannelProvider.newBuilder().build());
    settingsBuilder.setCredentialsProvider(FixedCredentialsProvider.create(credentials));

    org.threeten.bp.Duration stackdriverDuration =
        org.threeten.bp.Duration.ofMillis(deadline.toMillis());
    settingsBuilder.createTimeSeriesSettings().setSimpleTimeoutNoRetries(stackdriverDuration);
    return MetricServiceClient.create(settingsBuilder.build());
  }
}
