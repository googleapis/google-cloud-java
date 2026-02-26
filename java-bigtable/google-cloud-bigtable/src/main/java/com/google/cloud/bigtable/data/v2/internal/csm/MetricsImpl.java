/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal.csm;

import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.OpencensusTracerFactory;
import com.google.auth.Credentials;
import com.google.cloud.bigtable.Version;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry.RecorderRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.EnvInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.opencensus.MetricsTracerFactory;
import com.google.cloud.bigtable.data.v2.internal.csm.opencensus.RpcMeasureConstants;
import com.google.cloud.bigtable.data.v2.stub.metrics.BigtableCloudMonitoringExporter;
import com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsTracerFactory;
import com.google.cloud.bigtable.data.v2.stub.metrics.ChannelPoolMetricsTracer;
import com.google.cloud.bigtable.data.v2.stub.metrics.CompositeTracerFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.grpc.ManagedChannelBuilder;
import io.grpc.opentelemetry.GrpcOpenTelemetry;
import io.opencensus.stats.StatsRecorder;
import io.opencensus.tags.TagKey;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tagger;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReaderBuilder;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import javax.annotation.Nullable;

public class MetricsImpl implements Metrics, Closeable {
  private final MetricRegistry metricRegistry;

  private final ApiTracerFactory userTracerFactory;
  private final @Nullable OpenTelemetrySdk internalOtel;
  private final @Nullable OpenTelemetry userOtel;
  private final ScheduledExecutorService executor;
  private final Tagger ocTagger;
  private final StatsRecorder ocRecorder;

  @Nullable private final GrpcOpenTelemetry grpcOtel;
  @Nullable private final ChannelPoolMetricsTracer channelPoolMetricsTracer;
  private final List<ScheduledFuture<?>> tasks = new ArrayList<>();

  public MetricsImpl(
      MetricRegistry metricRegistry,
      ClientInfo clientInfo,
      ApiTracerFactory userTracerFactory,
      @Nullable OpenTelemetrySdk internalOtel,
      @Nullable OpenTelemetry userOtel,
      Tagger ocTagger,
      StatsRecorder ocRecorder,
      ScheduledExecutorService executor) {
    this.metricRegistry = metricRegistry;
    this.userTracerFactory = Preconditions.checkNotNull(userTracerFactory);

    this.internalOtel = internalOtel;
    this.userOtel = userOtel;

    this.ocTagger = ocTagger;
    this.ocRecorder = ocRecorder;

    this.executor = executor;

    if (internalOtel != null) {
      this.grpcOtel =
          GrpcOpenTelemetry.newBuilder()
              .sdk(internalOtel)
              .addOptionalLabel("grpc.lb.locality")
              // Disable default grpc metrics
              .disableAllMetrics()
              // Enable specific grpc metrics
              .enableMetrics(metricRegistry.getGrpcMetricNames())
              .build();
    } else {
      this.grpcOtel = null;
    }

    if (internalOtel != null) {
      this.channelPoolMetricsTracer =
          new ChannelPoolMetricsTracer(
              metricRegistry.newRecorderRegistry(internalOtel.getMeterProvider()), clientInfo);
    } else {
      this.channelPoolMetricsTracer = null;
    }
  }

  @Override
  public void close() {
    for (ScheduledFuture<?> task : tasks) {
      task.cancel(false);
    }
    if (internalOtel != null) {
      internalOtel.close();
    }
  }

  @Override
  public void start() {
    if (channelPoolMetricsTracer != null) {
      tasks.add(channelPoolMetricsTracer.start(executor));
    }
  }

  @Override
  public <T extends ManagedChannelBuilder<?>> T configureGrpcChannel(T channelBuilder) {
    if (grpcOtel == null) {
      return channelBuilder;
    }
    grpcOtel.configureChannelBuilder(channelBuilder);
    return channelBuilder;
  }

  @Override
  public ApiTracerFactory createTracerFactory(ClientInfo clientInfo) {
    ImmutableList.Builder<ApiTracerFactory> tracerFactories = ImmutableList.builder();
    tracerFactories
        .add(createOCTracingFactory(clientInfo))
        .add(createOCMetricsFactory(clientInfo, ocTagger, ocRecorder))
        .add(userTracerFactory);

    if (internalOtel != null) {
      tracerFactories.add(
          createOtelMetricsFactory(
              metricRegistry.newRecorderRegistry(internalOtel.getMeterProvider()), clientInfo));
    }
    if (userOtel != null) {
      tracerFactories.add(
          createOtelMetricsFactory(
              metricRegistry.newRecorderRegistry(userOtel.getMeterProvider()), clientInfo));
    }

    return new CompositeTracerFactory(tracerFactories.build());
  }

  @Override
  @Nullable
  public ChannelPoolMetricsTracer getChannelPoolMetricsTracer() {
    return channelPoolMetricsTracer;
  }

  public static OpenTelemetrySdk createBuiltinOtel(
      MetricRegistry metricRegistry,
      ClientInfo clientInfo,
      @Nullable Credentials defaultCredentials,
      @Nullable String metricsEndpoint,
      String universeDomain,
      ScheduledExecutorService executor)
      throws IOException {

    Credentials credentials =
        BigtableDataSettings.getMetricsCredentials() != null
            ? BigtableDataSettings.getMetricsCredentials()
            : defaultCredentials;

    SdkMeterProviderBuilder meterProvider = SdkMeterProvider.builder();

    MetricExporter publicExporter =
        BigtableCloudMonitoringExporter.create(
            metricRegistry,
            EnvInfo::detect,
            clientInfo,
            credentials,
            metricsEndpoint,
            universeDomain);
    PeriodicMetricReaderBuilder readerBuilder =
        PeriodicMetricReader.builder(publicExporter).setExecutor(executor);
    meterProvider.registerMetricReader(readerBuilder.build());

    return OpenTelemetrySdk.builder().setMeterProvider(meterProvider.build()).build();
  }

  private static ApiTracerFactory createOCTracingFactory(ClientInfo clientInfo) {
    return new OpencensusTracerFactory(
        ImmutableMap.<String, String>builder()
            // Annotate traces with the same tags as metrics
            .put(
                RpcMeasureConstants.BIGTABLE_PROJECT_ID.getName(),
                clientInfo.getInstanceName().getProject())
            .put(
                RpcMeasureConstants.BIGTABLE_INSTANCE_ID.getName(),
                clientInfo.getInstanceName().getInstance())
            .put(
                RpcMeasureConstants.BIGTABLE_APP_PROFILE_ID.getName(), clientInfo.getAppProfileId())
            // Also annotate traces with library versions
            .put("gax", GaxGrpcProperties.getGaxGrpcVersion())
            .put("grpc", GaxGrpcProperties.getGrpcVersion())
            .put("gapic", Version.VERSION)
            .build());
  }

  private static ApiTracerFactory createOCMetricsFactory(
      ClientInfo clientInfo, Tagger tagger, StatsRecorder stats) {

    ImmutableMap<TagKey, TagValue> attributes =
        ImmutableMap.<TagKey, TagValue>builder()
            .put(
                RpcMeasureConstants.BIGTABLE_PROJECT_ID,
                TagValue.create(clientInfo.getInstanceName().getProject()))
            .put(
                RpcMeasureConstants.BIGTABLE_INSTANCE_ID,
                TagValue.create(clientInfo.getInstanceName().getInstance()))
            .put(
                RpcMeasureConstants.BIGTABLE_APP_PROFILE_ID,
                TagValue.create(clientInfo.getAppProfileId()))
            .build();
    return MetricsTracerFactory.create(tagger, stats, attributes);
  }

  private static BuiltinMetricsTracerFactory createOtelMetricsFactory(
      RecorderRegistry recorder, ClientInfo clientInfo) {

    return BuiltinMetricsTracerFactory.create(recorder, clientInfo);
  }
}
