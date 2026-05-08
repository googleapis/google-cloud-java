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
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import com.google.api.gax.tracing.OpencensusTracerFactory;
import com.google.api.gax.tracing.SpanName;
import com.google.auth.Credentials;
import com.google.cloud.bigtable.Version;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry.RecorderRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics.NoopPoolFallbackListener;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics.NoopSessionTracer;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics.NoopVrpcTracer;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.EnvInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.exporter.BigtableCloudMonitoringExporter;
import com.google.cloud.bigtable.data.v2.internal.csm.exporter.BigtableFilteringExporter;
import com.google.cloud.bigtable.data.v2.internal.csm.exporter.BigtablePeriodicReader;
import com.google.cloud.bigtable.data.v2.internal.csm.opencensus.MetricsTracerFactory;
import com.google.cloud.bigtable.data.v2.internal.csm.opencensus.RpcMeasureConstants;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.BuiltinMetricsTracerFactory;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.ChannelPoolMetricsTracer;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.CompositeTracerFactory;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.CompositeVRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DebugTagTracer;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DebugTagTracerImpl;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DirectPathCompatibleTracer;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DirectPathCompatibleTracerImpl;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.Pacemaker;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.PoolFallbackListener;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.PoolFallbackListenerImpl;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.SessionTracer;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.SessionTracerImpl;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.UserApiVRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracerImpl;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolInfo;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcDescriptor;
import com.google.cloud.bigtable.data.v2.stub.metrics.NoopMetricsProvider;
import com.google.cloud.opentelemetry.metric.GoogleCloudMetricExporter;
import com.google.cloud.opentelemetry.metric.MetricConfiguration;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.grpc.Deadline;
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
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import java.io.Closeable;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class MetricsImpl implements Metrics, Closeable {

  public static final String CUSTOM_METRIC = "bigtable.internal.enable-custom-metric";

  private static final boolean enableCustomMetric =
      Optional.ofNullable(System.getProperty(CUSTOM_METRIC))
          .map(Boolean::parseBoolean)
          .orElse(false);

  private final ApiTracerFactory userTracerFactory;
  private final @Nullable OpenTelemetrySdk internalOtel;
  private final @Nullable MetricRegistry.RecorderRegistry internalRecorder;
  private final @Nullable MetricRegistry.RecorderRegistry userRecorder;
  private final ScheduledExecutorService executor;
  private final Tagger ocTagger;
  private final StatsRecorder ocRecorder;

  @Nullable private final GrpcOpenTelemetry grpcOtel;
  @Nullable private final ChannelPoolMetricsTracer channelPoolMetricsTracer;
  private final DirectPathCompatibleTracer directPathCompatibleTracer;
  private final DebugTagTracer debugTagTracer;
  @Nullable private final Pacemaker pacemaker;
  private final PoolFallbackListener poolFallbackListener;
  private final Object sessionLock = new Object();

  @GuardedBy("sessionLock")
  private final List<SessionTracer> sessionTracers = new ArrayList<>();

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
    this.userTracerFactory = Preconditions.checkNotNull(userTracerFactory);

    this.internalOtel = internalOtel;

    this.ocTagger = ocTagger;
    this.ocRecorder = ocRecorder;

    this.executor = executor;

    if (internalOtel != null) {
      this.internalRecorder =
          metricRegistry.newInternalRecorderRegistry(internalOtel.getMeterProvider());
      this.pacemaker = new Pacemaker(internalRecorder, clientInfo, "background");
      this.channelPoolMetricsTracer = new ChannelPoolMetricsTracer(internalRecorder, clientInfo);
      this.directPathCompatibleTracer =
          new DirectPathCompatibleTracerImpl(clientInfo, internalRecorder);
      this.debugTagTracer = new DebugTagTracerImpl(clientInfo, internalRecorder);
      // Session based channel pool tracer
      this.poolFallbackListener = new PoolFallbackListenerImpl(internalRecorder, clientInfo);
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
      this.internalRecorder = null;
      this.grpcOtel = null;
      this.pacemaker = null;
      this.channelPoolMetricsTracer = null;
      this.directPathCompatibleTracer = NoopMetricsProvider.NoopDirectPathCompatibleTracer.INSTANCE;
      this.debugTagTracer = NoopMetrics.NoopDebugTracer.INSTANCE;
      this.poolFallbackListener = new NoopPoolFallbackListener();
    }

    if (userOtel != null) {
      this.userRecorder = metricRegistry.newUserRecorderRegistry(userOtel.getMeterProvider());
    } else {
      this.userRecorder = null;
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
    if (pacemaker != null) {
      tasks.add(pacemaker.start(executor));
    }
    if (internalOtel != null) {
      tasks.add(
          executor.scheduleAtFixedRate(this::recordAsyncSessionMetrics, 1, 1, TimeUnit.MINUTES));
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
  public VRpcTracer newTableTracer(
      SessionPoolInfo poolInfo, VRpcDescriptor descriptor, Deadline deadline) {
    if (internalRecorder == null) {
      return new NoopVrpcTracer();
    }
    ImmutableList.Builder<VRpcTracer> builder = ImmutableList.builder();
    builder.add(
        new VRpcTracerImpl(
            internalRecorder, poolInfo, descriptor.getMethodInfo(), deadline, enableCustomMetric));
    if (userRecorder != null) {
      builder.add(new VRpcTracerImpl(userRecorder, poolInfo, descriptor.getMethodInfo(), deadline));
    }
    if (userTracerFactory != null) {
      List<String> nameStrings = Splitter.on('.').splitToList(descriptor.getMethodInfo().getName());
      builder.add(
          new UserApiVRpcTracer(
              userTracerFactory.newTracer(
                  null,
                  SpanName.of(nameStrings.get(0), nameStrings.get(1)),
                  descriptor.getMethodInfo().getStreaming()
                      ? OperationType.ServerStreaming
                      : OperationType.Unary),
              poolInfo,
              descriptor));
    }
    return new CompositeVRpcTracer(builder.build());
  }

  @Override
  public SessionTracer newSessionTracer(SessionPoolInfo poolInfo) {
    if (internalRecorder == null) {
      return new NoopSessionTracer();
    }

    SessionTracerImpl tracer = new SessionTracerImpl(internalRecorder, poolInfo);
    synchronized (sessionLock) {
      sessionTracers.add(tracer);
    }
    return tracer;
  }

  private void recordAsyncSessionMetrics() {
    synchronized (sessionLock) {
      sessionTracers.removeIf(tracer -> !tracer.recordAsyncMetrics());
    }
  }

  @Override
  public PoolFallbackListener getPoolFallbackListener() {
    return poolFallbackListener;
  }

  @Override
  public ApiTracerFactory createTracerFactory(ClientInfo clientInfo) {
    ImmutableList.Builder<ApiTracerFactory> tracerFactories = ImmutableList.builder();
    tracerFactories
        .add(createOCTracingFactory(clientInfo))
        .add(createOCMetricsFactory(clientInfo, ocTagger, ocRecorder))
        .add(userTracerFactory);

    if (internalRecorder != null) {
      tracerFactories.add(createOtelMetricsFactory(internalRecorder, clientInfo));
    }
    if (userRecorder != null) {
      tracerFactories.add(createOtelMetricsFactory(userRecorder, clientInfo));
    }

    return new CompositeTracerFactory(tracerFactories.build());
  }

  @Override
  @Nullable
  public ChannelPoolMetricsTracer getChannelPoolMetricsTracer() {
    return channelPoolMetricsTracer;
  }

  @Override
  public DirectPathCompatibleTracer getDirectPathCompatibleTracer() {
    return directPathCompatibleTracer;
  }

  @Override
  public DebugTagTracer getDebugTagTracer() {
    return debugTagTracer;
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

    BigtableCloudMonitoringExporter exporter =
        BigtableCloudMonitoringExporter.create(
            metricRegistry,
            // Lazily compute EnvInfo, but memoize it to make sure it stays constant
            Suppliers.memoize(EnvInfo::detect),
            clientInfo,
            credentials,
            metricsEndpoint,
            universeDomain);

    meterProvider.registerMetricReader(
        new BigtablePeriodicReader(
            new BigtableFilteringExporter(
                exporter,
                input -> input.getName().startsWith("bigtable.googleapis.com/internal/client")),
            executor));

    if (enableCustomMetric) {
      // Monitored resource and project id are detected at export time
      MetricConfiguration metricConfig =
          MetricConfiguration.builder()
              .setCredentials(credentials)
              .setInstrumentationLibraryLabelsEnabled(false)
              .build();
      meterProvider.registerMetricReader(
          PeriodicMetricReader.builder(
                  new BigtableFilteringExporter(
                      GoogleCloudMetricExporter.createWithConfiguration(metricConfig),
                      input -> input.getName().startsWith("bigtable.custom")))
              .setInterval(Duration.ofMinutes(1))
              .build());
    }
    return OpenTelemetrySdk.builder().setMeterProvider(meterProvider.build()).build();
  }

  private static ApiTracerFactory createOCTracingFactory(ClientInfo clientInfo) {
    return new OpencensusTracerFactory(
        ImmutableMap.<String, String>builder()
            // Annotate traces with the same tags as metrics
            .put(
                RpcMeasureConstants.BIGTABLE_PROJECT_ID.getName(),
                clientInfo.getInstanceName().getProjectId())
            .put(
                RpcMeasureConstants.BIGTABLE_INSTANCE_ID.getName(),
                clientInfo.getInstanceName().getInstanceId())
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
                TagValue.create(clientInfo.getInstanceName().getProjectId()))
            .put(
                RpcMeasureConstants.BIGTABLE_INSTANCE_ID,
                TagValue.create(clientInfo.getInstanceName().getInstanceId()))
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
