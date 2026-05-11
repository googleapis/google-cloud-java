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

import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.bigtable.v2.CloseSessionRequest;
import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.TelemetryConfiguration;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.ChannelPoolMetricsTracer;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.CompositeTracerFactory;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DebugTagTracer;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DirectPathCompatibleTracer;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.PoolFallbackListener;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.SessionTracer;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolInfo;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcDescriptor;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import com.google.cloud.bigtable.data.v2.stub.metrics.NoopMetricsProvider.NoopDirectPathCompatibleTracer;
import com.google.common.collect.ImmutableList;
import io.grpc.Deadline;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import java.io.IOException;
import java.time.Duration;
import javax.annotation.Nullable;

public class NoopMetrics implements Metrics {

  @Override
  public void start() {}

  @Override
  public void close() {}

  @Override
  public VRpcTracer newTableTracer(
      SessionPoolInfo poolInfo, VRpcDescriptor descriptor, Deadline deadline) {
    return NoopVrpcTracer.INSTANCE;
  }

  @Override
  public SessionTracer newSessionTracer(SessionPoolInfo poolInfo) {
    return new NoopSessionTracer();
  }

  @Override
  public DirectPathCompatibleTracer getDirectPathCompatibleTracer() {
    return NoopDirectPathCompatibleTracer.INSTANCE;
  }

  @Override
  public DebugTagTracer getDebugTagTracer() {
    return NoopDebugTracer.INSTANCE;
  }

  @Override
  public PoolFallbackListener getPoolFallbackListener() {
    return new NoopPoolFallbackListener();
  }

  @Nullable
  @Override
  public ChannelPoolMetricsTracer getChannelPoolMetricsTracer() {
    return null;
  }

  @Override
  public ApiTracerFactory createTracerFactory(ClientInfo clientInfo) throws IOException {
    return new CompositeTracerFactory(ImmutableList.of());
  }

  @Override
  public <T extends ManagedChannelBuilder<?>> T configureGrpcChannel(T channelBuilder) {
    return channelBuilder;
  }

  public static class NoopVrpcTracer implements VRpcTracer {

    public static final NoopVrpcTracer INSTANCE = new NoopVrpcTracer();

    @Override
    public void onOperationStart() {}

    @Override
    public void onAttemptStart(Object request) {}

    @Override
    public void onRequestSent(PeerInfo peerInfo) {}

    @Override
    public void onResponseReceived() {}

    @Override
    public void recordApplicationBlockingLatencies(Duration elapsed) {}

    @Override
    public void onAttemptFinish(VRpc.VRpcResult result) {}

    @Override
    public void onOperationFinish(VRpc.VRpcResult result) {}
  }

  public static class NoopSessionTracer implements SessionTracer {

    @Override
    public void onStart() {}

    @Override
    public void onOpen(PeerInfo peerInfo) {}

    @Override
    public void onVRpcClose(Status.Code code) {}

    @Override
    public void onClose(
        PeerInfo peerInfo, CloseSessionRequest.CloseSessionReason reason, Status status) {}

    @Override
    public boolean recordAsyncMetrics() {
      return false;
    }
  }

  public static class NoopPoolFallbackListener implements PoolFallbackListener {
    @Override
    public void onFallback(String from, String to, ChannelFallbackReason reason) {}
  }

  public static class NoopDebugTracer extends DebugTagTracer {
    public static final NoopDebugTracer INSTANCE = new NoopDebugTracer();

    @Override
    public void record(TelemetryConfiguration.Level level, String tag) {}

    @Override
    public void setClientConfigurationManager(ClientConfigurationManager manager) {}
  }
}
