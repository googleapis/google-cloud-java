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
package com.google.cloud.bigtable.data.v2.internal.compat;

import com.google.api.gax.grpc.ChannelPoolSettings;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.auth.Credentials;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.BigtableGrpc.BigtableBlockingV2Stub;
import com.google.bigtable.v2.FeatureFlags;
import com.google.bigtable.v2.GetClientConfigurationRequest;
import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.PeerInfo.TransportType;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders.ChannelProvider;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders.ConfiguredChannelProvider;
import com.google.cloud.bigtable.data.v2.internal.api.Client;
import com.google.cloud.bigtable.data.v2.internal.api.Client.Resource;
import com.google.cloud.bigtable.data.v2.internal.compat.ops.DivertingUnaryCallable;
import com.google.cloud.bigtable.data.v2.internal.compat.ops.MutateRowShim;
import com.google.cloud.bigtable.data.v2.internal.compat.ops.ReadRowShim;
import com.google.cloud.bigtable.data.v2.internal.compat.ops.ReadRowShimInner;
import com.google.cloud.bigtable.data.v2.internal.csm.Metrics;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DirectPathCompatibleTracer;
import com.google.cloud.bigtable.data.v2.internal.dp.DirectAccessInvestigator;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.RowAdapter;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.stub.MetadataExtractorInterceptor;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import java.io.IOException;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * Implementation of a shim to fork off traffic to session based apis. It acts as a factory for
 * callable decorators.
 */
public class ShimImpl implements Shim {
  private static final Logger logger = Logger.getLogger(ShimImpl.class.getName());

  // TODO: this should be a client config
  public static final int MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES = 30;
  private static final Duration DA_CHECK_TIMEOUT = Duration.ofSeconds(5);

  private final ClientConfigurationManager configManager;
  private final Client client;

  private final ReadRowShimInner readRowShimInner;
  private final MutateRowShim mutateRowShim;

  public static Shim create(
      ClientInfo clientInfo,
      @Nullable Credentials callCreds,
      Metrics metrics,
      ScheduledExecutorService bgExecutor,
      StubSettings<?> stubSettings)
      throws IOException {

    TransportChannelProvider transportProvider = stubSettings.getTransportChannelProvider();
    if (!(transportProvider instanceof InstantiatingGrpcChannelProvider)) {
      return new DisabledShim();
    }

    transportProvider =
        ((InstantiatingGrpcChannelProvider) transportProvider)
            .toBuilder()
                .setHeaderProvider(ImmutableMap::of)
                .setChannelPoolSettings(ChannelPoolSettings.staticallySized(1))
                .setAttemptDirectPath(true)
                .setAttemptDirectPathXds()
                .build();

    if (transportProvider.needsEndpoint()) {
      transportProvider = transportProvider.withEndpoint(stubSettings.getEndpoint());
    }
    if (callCreds != null && transportProvider.needsCredentials()) {
      transportProvider = transportProvider.withCredentials(callCreds);
    }
    if (transportProvider.needsBackgroundExecutor()) {
      transportProvider = transportProvider.withBackgroundExecutor(bgExecutor);
    }
    if (transportProvider.needsMtlsEndpoint()
        && !Strings.isNullOrEmpty(stubSettings.getMtlsEndpoint())) {
      transportProvider = transportProvider.withMtlsEndpoint(stubSettings.getMtlsEndpoint());
    }

    // Channel provider for the client. DirectAccess with fallback by default.
    ChannelProvider clientChannelProvider =
        configureChannelProvider(
            GaxDirectAccessChannelProvider.createWithFallback(
                (InstantiatingGrpcChannelProvider) transportProvider, callCreds),
            metrics);

    if (!checkDirectAccessAvailable(
        Client.BASE_FEATURE_FLAGS, clientInfo, clientChannelProvider, metrics, bgExecutor)) {
      // Directpath failed, revert to basic channel provider for the client.
      clientChannelProvider =
          configureChannelProvider(
              new GaxBasicChannelProvider(
                  (InstantiatingGrpcChannelProvider) transportProvider, callCreds),
              metrics);
    }

    // ChannelProvider for configuration manager.
    ChannelProvider configChannelProvider =
        configureChannelProvider(
            new GaxBasicChannelProvider(
                (InstantiatingGrpcChannelProvider) transportProvider, callCreds),
            metrics);

    ClientConfigurationManager configManager =
        new ClientConfigurationManager(
            configChannelProvider.updateFeatureFlags(Client.BASE_FEATURE_FLAGS),
            clientInfo,
            configChannelProvider,
            metrics.getDebugTagTracer(),
            bgExecutor);

    try {
      configManager.start().get();
      metrics.getDebugTagTracer().setClientConfigurationManager(configManager);
    } catch (Exception e) {
      logger.log(Level.WARNING, "Failed to fetch initial client configuration", e);
      configManager.close();
      return new DisabledShim();
    }

    FeatureFlags featureFlags = Client.BASE_FEATURE_FLAGS;

    if (configManager.areSessionsRequired()) {
      featureFlags = featureFlags.toBuilder().setSessionsRequired(true).build();
    }

    Client client =
        new Client(
            clientChannelProvider.updateFeatureFlags(featureFlags),
            clientInfo,
            clientChannelProvider,
            Resource.createShared(metrics),
            Resource.createShared(configManager),
            Resource.createShared(bgExecutor));

    return new ShimImpl(configManager, client);
  }

  public ShimImpl(ClientConfigurationManager configManager, Client client) {
    this.configManager = configManager;
    this.client = client;

    this.readRowShimInner = new ReadRowShimInner(client);
    this.mutateRowShim = new MutateRowShim(client);
  }

  private static ChannelProvider configureChannelProvider(
      ChannelProvider channelProvider, Metrics metrics) {
    return new ConfiguredChannelProvider(
        channelProvider,
        channelBuilder ->
            metrics
                .configureGrpcChannel(channelBuilder)
                .keepAliveTime(Client.KEEPALIVE_TIME_MS, TimeUnit.MILLISECONDS)
                .keepAliveTimeout(Client.KEEPALIVE_TIMEOUT_MS, TimeUnit.MILLISECONDS)
                // TODO: consider localizing this for large reads
                .maxInboundMessageSize(256 * 1024 * 1024));
  }

  private static boolean checkDirectAccessAvailable(
      FeatureFlags featureFlags,
      ClientInfo clientInfo,
      ChannelProvider channelProvider,
      Metrics metrics,
      ScheduledExecutorService bgExecutor) {
    ManagedChannel channel = channelProvider.newChannelBuilder().build();
    DirectPathCompatibleTracer tracer = metrics.getDirectPathCompatibleTracer();

    Metadata metadata =
        com.google.cloud.bigtable.data.v2.internal.api.Util.composeMetadata(
            channelProvider.updateFeatureFlags(featureFlags),
            ImmutableMap.of(
                "instance_name", clientInfo.getInstanceName().toString(),
                "app_profile_id", clientInfo.getAppProfileId()));
    ClientInterceptor attachMetadata = MetadataUtils.newAttachHeadersInterceptor(metadata);
    MetadataExtractorInterceptor metaInterceptor = new MetadataExtractorInterceptor();

    BigtableBlockingV2Stub stub =
        BigtableGrpc.newBlockingV2Stub(channel).withInterceptors(attachMetadata, metaInterceptor);

    try {
      stub.withDeadlineAfter(DA_CHECK_TIMEOUT)
          .getClientConfiguration(
              GetClientConfigurationRequest.newBuilder()
                  .setInstanceName(clientInfo.getInstanceName().toString())
                  .setAppProfileId(clientInfo.getAppProfileId())
                  .build());
    } catch (Exception e) {
      logger.log(Level.FINE, "DirectAccess check RPC failed.", e);
      // Spin up investigation.
      bgExecutor.execute(() -> DirectAccessInvestigator.investigateAndReport(tracer, e));
      return false;
    } finally {
      channel.shutdownNow();
    }

    TransportType tt =
        Optional.ofNullable(metaInterceptor.getSidebandData().getPeerInfo())
            .map(PeerInfo::getTransportType)
            .orElse(TransportType.TRANSPORT_TYPE_UNKNOWN);

    boolean result =
        tt == TransportType.TRANSPORT_TYPE_DIRECT_ACCESS
            || tt == TransportType.TRANSPORT_TYPE_SESSION_DIRECT_ACCESS;

    if (result) {
      tracer.recordSuccess(metaInterceptor.getSidebandData().getIpProtocol());
    } else {
      // Spin up investigation.
      bgExecutor.execute(() -> DirectAccessInvestigator.investigateAndReport(tracer, null));
    }

    return result;
  }

  @Override
  public void close() {
    client.close();
    configManager.close();
  }

  @Override
  public <RowT> UnaryCallable<Query, RowT> decorateReadRow(
      UnaryCallable<Query, RowT> classic,
      RowAdapter<RowT> rowAdapter,
      UnaryCallSettings<?, ?> settings) {
    return new DivertingUnaryCallable<>(
        configManager,
        classic,
        new ReadRowShim<>(readRowShimInner, rowAdapter),
        Util.extractTimeout(settings));
  }

  @Override
  public UnaryCallable<RowMutation, Void> decorateMutateRow(
      UnaryCallable<RowMutation, Void> classic, UnaryCallSettings<?, ?> settings) {
    return new DivertingUnaryCallable<>(
        configManager, classic, mutateRowShim, Util.extractTimeout(settings));
  }
}
