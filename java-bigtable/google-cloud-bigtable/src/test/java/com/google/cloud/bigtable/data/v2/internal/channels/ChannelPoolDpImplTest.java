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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.bigtable.v2.FakeSessionGrpc;
import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.SessionClientConfiguration.ChannelPoolConfiguration;
import com.google.cloud.bigtable.data.v2.internal.channels.SessionStream.Listener;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DebugTagTracer;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.Status;
import java.time.Clock;
import java.time.Instant;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ChannelPoolDpImplTest {
  @Mock private ScheduledExecutorService bgExecutor;

  @Mock private Supplier<ManagedChannel> channelSupplier;

  @Mock private ClientCall<Object, Object> clientCall;

  @Mock private ManagedChannel channel;

  @Captor private ArgumentCaptor<ClientCall.Listener<Object>> listener;

  private final DebugTagTracer debugTagTracer = NoopMetrics.NoopDebugTracer.INSTANCE;

  private static final ChannelPoolConfiguration defaultConfig =
      ChannelPoolConfiguration.newBuilder()
          .setMinServerCount(2)
          .setMaxServerCount(25)
          .setPerServerSessionCount(10)
          .build();

  @Test
  void testInitialService() {
    when(channelSupplier.get()).thenReturn(channel);

    ChannelPoolDpImpl pool =
        new ChannelPoolDpImpl(channelSupplier, defaultConfig, debugTagTracer, bgExecutor);
    pool.serviceChannels();

    verify(channelSupplier, times(pool.minGroups)).get();

    pool.close();
  }

  @Test
  void testNewStreamStartsASingleChannel() {
    when(channelSupplier.get()).thenReturn(channel);
    when(channel.newCall(any(), any())).thenReturn(clientCall);

    ChannelPool pool =
        new ChannelPoolDpImpl(channelSupplier, defaultConfig, debugTagTracer, bgExecutor);

    SessionStream ignored =
        pool.newStream(FakeSessionGrpc.getOpenSessionMethod(), CallOptions.DEFAULT);

    // Only 1 channel created
    verify(channelSupplier, times(1)).get();
    // And that channel was asked to create a new session
    verify(channel, times(1)).newCall(any(), any());

    pool.close();
  }

  @Test
  void testSecondChannelCreatedWhenFirstIsFull() {
    when(channelSupplier.get()).thenReturn(channel);
    when(channel.newCall(any(), any())).thenReturn(clientCall);
    ChannelPoolDpImpl pool =
        new ChannelPoolDpImpl(channelSupplier, defaultConfig, debugTagTracer, bgExecutor);

    // Starting channels are half-filled.
    for (int i = 0; i < pool.softMaxPerGroup / 2; i++) {
      pool.newStream(FakeSessionGrpc.getOpenSessionMethod(), CallOptions.DEFAULT);
    }
    // Only 1 channel created.
    verify(channelSupplier, times(1)).get();
    // And that channel was asked to create all the sessions on until max
    verify(channel, times(pool.softMaxPerGroup / 2)).newCall(any(), any());

    // Next call triggers creation of a new channel.
    ManagedChannel otherChannel = Mockito.mock(ManagedChannel.class);
    doReturn(otherChannel).when(channelSupplier).get();
    when(otherChannel.newCall(any(), any())).thenReturn(clientCall);

    pool.newStream(FakeSessionGrpc.getOpenSessionMethod(), CallOptions.DEFAULT);
    verify(channelSupplier, times(2)).get();
    verify(otherChannel, times(1)).newCall(any(), any());

    pool.close();
  }

  @Test
  void testClosingASessionFreesASlot() {
    when(channelSupplier.get()).thenReturn(channel);
    when(channel.newCall(any(), any())).thenReturn(clientCall);
    doNothing().when(clientCall).start(listener.capture(), any());
    ChannelPoolDpImpl pool =
        new ChannelPoolDpImpl(channelSupplier, defaultConfig, debugTagTracer, bgExecutor);

    // fill up the channel
    for (int i = 0; i < pool.softMaxPerGroup / 2; i++) {
      pool.newStream(FakeSessionGrpc.getOpenSessionMethod(), CallOptions.DEFAULT)
          .start(Mockito.mock(Listener.class), new Metadata());
    }

    // release one session
    ClientCall.Listener<Object> value = listener.getValue();
    value.onClose(Status.OK, new Metadata());

    // next call should not trigger creation of another channel
    pool.newStream(FakeSessionGrpc.getOpenSessionMethod(), CallOptions.DEFAULT)
        .start(Mockito.mock(Listener.class), new Metadata());

    // So invocation count should stay at 1 from the first channel
    verify(channelSupplier, times(1)).get();

    pool.close();
  }

  @Test
  void testLeastLoadedChannelGetsNext() {
    ManagedChannel channel1 = mock(ManagedChannel.class);
    when(channel1.newCall(any(), any())).thenReturn(clientCall);

    ManagedChannel channel2 = mock(ManagedChannel.class);
    when(channel2.newCall(any(), any())).thenReturn(clientCall);

    when(channelSupplier.get()).thenReturn(channel1, channel2);
    doNothing().when(clientCall).start(listener.capture(), any());

    ChannelPoolDpImpl pool =
        new ChannelPoolDpImpl(channelSupplier, defaultConfig, debugTagTracer, bgExecutor);

    // fill up 2 channels
    for (int i = 0; i < pool.softMaxPerGroup; i++) {
      pool.newStream(FakeSessionGrpc.getOpenSessionMethod(), CallOptions.DEFAULT)
          .start(Mockito.mock(Listener.class), new Metadata());
    }
    verify(channelSupplier, times(2)).get();

    List<ClientCall.Listener<Object>> allListeners = listener.getAllValues();

    // release one session
    allListeners.get(0).onClose(Status.OK, new Metadata());

    // next call should be created on the first channel
    pool.newStream(FakeSessionGrpc.getOpenSessionMethod(), CallOptions.DEFAULT)
        .start(Mockito.mock(Listener.class), new Metadata());

    // Now the first channel has an extra call
    verify(channel1, times(pool.softMaxPerGroup / 2 + 1)).newCall(any(), any());

    pool.close();
  }

  @Test
  void testDownsize() {
    when(channelSupplier.get()).thenReturn(channel);
    when(channel.newCall(any(), any())).thenReturn(clientCall);
    doNothing().when(clientCall).start(listener.capture(), any());
    doReturn(Attributes.EMPTY).when(clientCall).getAttributes();

    Clock clock = Mockito.mock(Clock.class);
    when(clock.instant()).thenReturn(Instant.now());

    ChannelPoolDpImpl pool =
        new ChannelPoolDpImpl(
            channelSupplier, defaultConfig, "pool", debugTagTracer, bgExecutor, clock);

    int numChannels = 5;
    int numSessions = numChannels * pool.softMaxPerGroup / 2;

    for (int i = 0; i < numSessions; i++) {
      pool.newStream(FakeSessionGrpc.getOpenSessionMethod(), CallOptions.DEFAULT)
          .start(Mockito.mock(Listener.class), new Metadata());
    }

    verify(channelSupplier, times(numChannels)).get();

    int i = 0;
    // Start and finish all sessions.
    for (ClientCall.Listener<Object> listener : listener.getAllValues()) {
      // Afe Id of 0 creates an empty protobuf which does not get picks up in
      // onHeaders, this is why we start with 555.
      PeerInfo peerInfo =
          PeerInfo.newBuilder().setApplicationFrontendId(555 + i / numChannels).build();
      Metadata headers = new Metadata();
      headers.put(
          SessionStreamImpl.PEER_INFO_KEY,
          Base64.getEncoder().encodeToString(peerInfo.toByteArray()));
      listener.onHeaders(headers);
      i++;
      listener.onClose(Status.OK, new Metadata());
    }

    when(clock.instant()).thenReturn(Instant.now());
    pool.serviceChannels();
    verify(channel, times(numChannels - pool.minGroups)).shutdown();

    pool.close();
  }

  @Test
  void testDownsizeToOptimal() {
    when(channelSupplier.get()).thenReturn(channel);
    when(channel.newCall(any(), any())).thenReturn(clientCall);
    doNothing().when(clientCall).start(listener.capture(), any());
    doReturn(Attributes.EMPTY).when(clientCall).getAttributes();

    Clock clock = Mockito.mock(Clock.class);
    when(clock.instant()).thenReturn(Instant.now());

    ChannelPoolDpImpl pool =
        new ChannelPoolDpImpl(
            channelSupplier, defaultConfig, "pool", debugTagTracer, bgExecutor, clock);

    int numChannels = 5;
    int numSessions = numChannels * pool.softMaxPerGroup / 2;

    for (int i = 0; i < numSessions; i++) {
      pool.newStream(FakeSessionGrpc.getOpenSessionMethod(), CallOptions.DEFAULT)
          .start(Mockito.mock(Listener.class), new Metadata());
    }

    verify(channelSupplier, times(numChannels)).get();

    int i = 0;
    // Start all sessions.
    for (ClientCall.Listener<Object> listener : listener.getAllValues()) {
      // Afe Id of 0 creates an empty protobuf which does not get picks up in
      // onHeaders, this is why we start with 555.
      PeerInfo peerInfo =
          PeerInfo.newBuilder().setApplicationFrontendId(555 + i / numChannels).build();
      Metadata headers = new Metadata();
      headers.put(
          SessionStreamImpl.PEER_INFO_KEY,
          Base64.getEncoder().encodeToString(peerInfo.toByteArray()));
      listener.onHeaders(headers);
      i++;
    }

    // Now we have 25 sessions on 5 channel groups each of 1 channel.
    // Let's close 6 sessions from different channels/AFEs.
    i = 0;
    for (ClientCall.Listener<Object> listener : listener.getAllValues()) {
      if (i % 4 == 0 && i != 0) {
        listener.onClose(Status.OK, new Metadata());
      }
      i++;
    }

    // Now we should have 19 sessions on 5 channel groups each of 1 channel.
    // I.e. dumpState
    // FINE: ChannelPool channelGroups: 5, channels: 5, starting channels: 0, totalStreams: 19,
    // AFEs: 5, distribution: [4, 4, 4, 4, 3]
    when(clock.instant()).thenReturn(Instant.now());
    pool.serviceChannels();

    // Should scale down to 4 channels. 19 / 5 round up = 4.
    verify(channel, times(numChannels - 4)).shutdown();

    pool.close();
  }

  @Test
  void testRecycleChannelOnUnimplemented() {
    when(channelSupplier.get()).thenReturn(channel);
    when(channel.newCall(any(), any())).thenReturn(clientCall);
    doNothing().when(clientCall).start(listener.capture(), any());

    ChannelPool pool =
        new ChannelPoolDpImpl(channelSupplier, defaultConfig, debugTagTracer, bgExecutor);

    pool.newStream(FakeSessionGrpc.getOpenSessionMethod(), CallOptions.DEFAULT)
        .start(Mockito.mock(Listener.class), new Metadata());

    // Only 1 channel created initially
    verify(channelSupplier, times(1)).get();

    // Release with UNIMPLEMENTED status
    ClientCall.Listener<Object> value = listener.getValue();
    value.onClose(Status.UNIMPLEMENTED, new Metadata());

    // The channel should be shutdown
    verify(channel, times(1)).shutdown();

    // And a new channel should be requested from the supplier
    verify(channelSupplier, times(2)).get();

    pool.close();
  }

  @Test
  void testRecycleChannelInGroupOnUnimplemented() {
    when(channelSupplier.get()).thenReturn(channel);
    when(channel.newCall(any(), any())).thenReturn(clientCall);
    doNothing().when(clientCall).start(listener.capture(), any());
    doReturn(Attributes.EMPTY).when(clientCall).getAttributes();

    ChannelPool pool =
        new ChannelPoolDpImpl(channelSupplier, defaultConfig, debugTagTracer, bgExecutor);

    pool.newStream(FakeSessionGrpc.getOpenSessionMethod(), CallOptions.DEFAULT)
        .start(Mockito.mock(Listener.class), new Metadata());

    ClientCall.Listener<Object> value = listener.getValue();

    // Assign to a group by providing AFE ID
    PeerInfo peerInfo = PeerInfo.newBuilder().setApplicationFrontendId(555).build();
    Metadata headers = new Metadata();
    headers.put(
        SessionStreamImpl.PEER_INFO_KEY,
        Base64.getEncoder().encodeToString(peerInfo.toByteArray()));
    value.onHeaders(headers);

    // This call is successful
    value.onClose(Status.OK, new Metadata());

    // Another call
    pool.newStream(FakeSessionGrpc.getOpenSessionMethod(), CallOptions.DEFAULT)
        .start(Mockito.mock(Listener.class), new Metadata());

    value = listener.getValue();

    // Release with UNIMPLEMENTED status
    value.onClose(Status.UNIMPLEMENTED, new Metadata());

    // The channel should be shutdown
    verify(channel, times(1)).shutdown();

    // And a new channel should be requested from the supplier
    verify(channelSupplier, times(2)).get();

    pool.close();
  }
}
