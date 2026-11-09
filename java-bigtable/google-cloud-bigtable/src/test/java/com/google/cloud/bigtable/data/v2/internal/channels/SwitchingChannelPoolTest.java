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
package com.google.cloud.bigtable.data.v2.internal.channels;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.bigtable.v2.ClientConfiguration;
import com.google.bigtable.v2.FakeSessionGrpc;
import com.google.bigtable.v2.SessionClientConfiguration;
import com.google.bigtable.v2.SessionClientConfiguration.ChannelPoolConfiguration;
import com.google.bigtable.v2.SessionClientConfiguration.ChannelPoolConfiguration.CloudPathOnly;
import com.google.bigtable.v2.SessionClientConfiguration.ChannelPoolConfiguration.DirectAccessOnly;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders.ChannelProvider;
import com.google.cloud.bigtable.data.v2.internal.channels.SessionStream.Listener;
import com.google.cloud.bigtable.data.v2.internal.csm.Metrics;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager.ListenerHandle;
import io.grpc.CallOptions;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Status;
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SwitchingChannelPoolTest {
  @Mock private ChannelProvider primaryProvider;
  @Mock private ChannelProvider fallbackProvider;
  @Mock private ManagedChannelBuilder<?> primaryBuilder;
  @Mock private ManagedChannelBuilder<?> fallbackBuilder;
  @Mock private ManagedChannel primaryChannel;
  @Mock private ManagedChannel fallbackChannel;
  @Mock private ClientConfigurationManager configManager;
  @Mock private ListenerHandle listenerHandle;
  @Mock private ScheduledExecutorService backgroundExecutor;
  @Mock private ScheduledFuture<?> scheduledFuture;
  @Mock private Listener streamListener;

  private Metrics metrics;

  private static final ChannelPoolConfiguration ENABLED_CLOUD_CONFIG =
      ChannelPoolConfiguration.newBuilder()
          .setMinServerCount(2)
          .setMaxServerCount(10)
          .setPerServerSessionCount(5)
          .setCloudPathOnly(CloudPathOnly.getDefaultInstance())
          .build();

  private static final ChannelPoolConfiguration ENABLED_DIRECT_CONFIG =
      ChannelPoolConfiguration.newBuilder()
          .setMinServerCount(2)
          .setMaxServerCount(10)
          .setPerServerSessionCount(5)
          .setDirectAccessOnly(DirectAccessOnly.getDefaultInstance())
          .build();

  @BeforeEach
  @SuppressWarnings({"unchecked", "rawtypes"})
  void setUp() {
    metrics = new NoopMetrics();
    when(configManager.addListener(any(), any())).thenReturn(listenerHandle);
    when(backgroundExecutor.scheduleAtFixedRate(
            any(Runnable.class), anyLong(), anyLong(), any(TimeUnit.class)))
        .thenReturn((ScheduledFuture) scheduledFuture);

    when(primaryProvider.newChannelBuilder()).thenReturn((ManagedChannelBuilder) primaryBuilder);
    when(primaryBuilder.intercept(any(ClientInterceptor[].class)))
        .thenReturn((ManagedChannelBuilder) primaryBuilder);
    when(primaryBuilder.build()).thenReturn(primaryChannel);

    lenient()
        .when(fallbackProvider.newChannelBuilder())
        .thenReturn((ManagedChannelBuilder) fallbackBuilder);
    lenient()
        .when(fallbackBuilder.intercept(any(ClientInterceptor[].class)))
        .thenReturn((ManagedChannelBuilder) fallbackBuilder);
    lenient().when(fallbackBuilder.build()).thenReturn(fallbackChannel);
  }

  private static ClientConfiguration clientConfigWithChannelConfig(
      ChannelPoolConfiguration channelConfig) {
    return ClientConfiguration.newBuilder()
        .setSessionConfiguration(
            SessionClientConfiguration.newBuilder().setChannelConfiguration(channelConfig))
        .build();
  }

  @Test
  void startWithEmptyConfigUsesNoopPoolAndTransitionsToEnabledAndBack() {
    when(primaryProvider.getFallback()).thenReturn(Optional.empty());
    when(configManager.getClientConfiguration())
        .thenReturn(ClientConfiguration.getDefaultInstance());

    SwitchingChannelPool pool =
        new SwitchingChannelPool(primaryProvider, configManager, metrics, backgroundExecutor);
    pool.start();

    // No channels created when config is default/empty.
    verify(primaryProvider, never()).newChannelBuilder();

    SessionStream disabledStream =
        pool.newStream(FakeSessionGrpc.getOpenSessionMethod(), CallOptions.DEFAULT);
    disabledStream.start(streamListener, new Metadata());
    ArgumentCaptor<Status> statusCaptor = ArgumentCaptor.forClass(Status.class);
    verify(streamListener).onClose(statusCaptor.capture(), any(Metadata.class));
    assertThat(statusCaptor.getValue().getCode()).isEqualTo(Status.Code.UNAVAILABLE);

    // Enable channel pool via updateConfig.
    pool.updateConfig(ENABLED_CLOUD_CONFIG);
    verify(primaryProvider, times(2)).newChannelBuilder();
    verify(primaryChannel, never()).shutdown();

    // Disable channel pool via updateConfig(getDefaultInstance()) -> closes active pool.
    pool.updateConfig(ChannelPoolConfiguration.getDefaultInstance());
    verify(primaryChannel, times(2)).shutdown();
    verify(scheduledFuture).cancel(false);

    Listener secondListener = mock(Listener.class);
    SessionStream disabledAgainStream =
        pool.newStream(FakeSessionGrpc.getOpenSessionMethod(), CallOptions.DEFAULT);
    disabledAgainStream.start(secondListener, new Metadata());
    ArgumentCaptor<Status> secondStatusCaptor = ArgumentCaptor.forClass(Status.class);
    verify(secondListener).onClose(secondStatusCaptor.capture(), any(Metadata.class));
    assertThat(secondStatusCaptor.getValue().getCode()).isEqualTo(Status.Code.UNAVAILABLE);

    pool.close();
  }

  @Test
  void fallbackAvailableTransitionsBetweenEnabledAndDisabled() {
    when(primaryProvider.getFallback()).thenReturn(Optional.of(fallbackProvider));
    when(configManager.getClientConfiguration())
        .thenReturn(clientConfigWithChannelConfig(ENABLED_DIRECT_CONFIG));

    SwitchingChannelPool pool =
        new SwitchingChannelPool(primaryProvider, configManager, metrics, backgroundExecutor);
    pool.start();

    verify(primaryProvider, times(2)).newChannelBuilder();
    verify(primaryChannel, never()).shutdown();

    // Transition to disabled (e.g. session_load = 0 clears session_configuration).
    pool.updateConfig(ChannelPoolConfiguration.getDefaultInstance());
    verify(primaryChannel, times(2)).shutdown();
    verify(scheduledFuture).cancel(false);
    verify(fallbackProvider, never()).newChannelBuilder();

    // Transition back to enabled with CloudPathOnly.
    pool.updateConfig(ENABLED_CLOUD_CONFIG);
    verify(fallbackProvider, times(2)).newChannelBuilder();
    verify(fallbackChannel, never()).shutdown();

    pool.close();
    verify(fallbackChannel, times(2)).shutdown();
  }
}
