/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.bigtable.gaxx.grpc;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.bigtable.v2.PingAndWarmResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.time.Clock;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(JUnit4.class)
public class BigtableChannelPoolTest {
  @Rule public final MockitoRule mockito = MockitoJUnit.rule();

  @Mock private Supplier<ManagedChannel> mockChannelFactory;
  @Mock private ChannelPrimer mockChannelPrimer;
  @Mock private ManagedChannel mockChannel;
  @Mock private ClientCall<String, String> mockClientCall;

  private MethodDescriptor<String, String> unaryMethodDescriptor;
  private MethodDescriptor<String, String> streamingMethodDescriptor;

  @Captor private ArgumentCaptor<ClientCall.Listener<String>> listenerCaptor;

  private BigtableChannelPool channelPool;
  private ScheduledExecutorService executorService;

  private static class StringMarshaller implements MethodDescriptor.Marshaller<String> {
    @Override
    public InputStream stream(String value) {
      return null; // Not used in this test
    }

    @Override
    public String parse(InputStream stream) {
      return null; // Not used in this test
    }
  }

  @Before
  public void setUp() throws IOException {
    when(mockChannelFactory.get()).thenReturn(mockChannel);
    when(mockChannel.newCall(
            ArgumentMatchers.<MethodDescriptor<String, String>>any(), any(CallOptions.class)))
        .thenReturn(mockClientCall);
    // Setup MethodDescriptors
    // Initialize real MethodDescriptor instances
    MethodDescriptor.Marshaller<String> marshaller = new StringMarshaller();
    unaryMethodDescriptor =
        MethodDescriptor.<String, String>newBuilder()
            .setType(MethodDescriptor.MethodType.UNARY)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("bigtable", "MutateRow"))
            .setRequestMarshaller(marshaller)
            .setResponseMarshaller(marshaller)
            .build();

    streamingMethodDescriptor =
        MethodDescriptor.<String, String>newBuilder()
            .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("bigtable", "ReadRows"))
            .setRequestMarshaller(marshaller)
            .setResponseMarshaller(marshaller)
            .build();

    executorService = Executors.newSingleThreadScheduledExecutor();

    BigtableChannelPoolSettings settings =
        BigtableChannelPoolSettings.builder()
            .setInitialChannelCount(1)
            .setMinChannelCount(1)
            .setMaxChannelCount(1)
            .build();
    channelPool =
        new BigtableChannelPool(settings, mockChannelFactory, mockChannelPrimer, executorService);

    // Capture the listener when start is called
    // Configure mockClientCall.start to capture the listener
    doNothing().when(mockClientCall).start(listenerCaptor.capture(), any(Metadata.class));
  }

  @After
  public void tearDown() {
    executorService.shutdownNow();
  }

  private void flushExecutor() throws Exception {
    executorService.submit(() -> {}).get(5, TimeUnit.SECONDS);
    executorService.submit(() -> {}).get(5, TimeUnit.SECONDS);
  }

  private BigtableChannelPool.Entry getSingleEntry() {
    List<? extends BigtableChannelObserver> infos = channelPool.getChannelInfos();
    return (BigtableChannelPool.Entry) Iterables.getOnlyElement(infos);
  }

  private ClientCall.Listener<String> startCall(MethodDescriptor<String, String> method) {
    ClientCall<String, String> call = channelPool.newCall(method, CallOptions.DEFAULT);
    call.start(mock(ClientCall.Listener.class), new Metadata());
    return listenerCaptor.getValue();
  }

  @Test
  public void testUnaryRpcSuccess() {
    BigtableChannelPool.Entry entry = getSingleEntry();

    // Before call
    assertThat(entry.getOutstandingUnaryRpcs()).isEqualTo(0);
    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(0);

    ClientCall.Listener<String> listener = startCall(unaryMethodDescriptor);

    // After start
    assertThat(entry.getOutstandingUnaryRpcs()).isEqualTo(1);
    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(0);
    assertThat(entry.totalOutstandingRpcs()).isEqualTo(1);

    // Simulate call success
    listener.onClose(Status.OK, new Metadata());

    // After close
    assertThat(entry.getOutstandingUnaryRpcs()).isEqualTo(0);
    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(0);
    assertThat(entry.totalOutstandingRpcs()).isEqualTo(0);
    assertThat(entry.getAndResetSuccessCount()).isEqualTo(1);
    assertThat(entry.getAndResetErrorCount()).isEqualTo(0);
  }

  @Test
  public void testUnaryRpcFailure() {
    BigtableChannelPool.Entry entry = getSingleEntry();
    ClientCall.Listener<String> listener = startCall(unaryMethodDescriptor);

    assertThat(entry.getOutstandingUnaryRpcs()).isEqualTo(1);

    // Simulate call failure
    listener.onClose(Status.UNAVAILABLE, new Metadata());

    // After close
    assertThat(entry.getOutstandingUnaryRpcs()).isEqualTo(0);
    assertThat(entry.totalOutstandingRpcs()).isEqualTo(0);
    assertThat(entry.getAndResetSuccessCount()).isEqualTo(0);
    assertThat(entry.getAndResetErrorCount()).isEqualTo(1);
  }

  @Test
  public void testStreamingRpcSuccess() {
    BigtableChannelPool.Entry entry = getSingleEntry();

    ClientCall.Listener<String> listener = startCall(streamingMethodDescriptor);

    // After start
    assertThat(entry.getOutstandingUnaryRpcs()).isEqualTo(0);
    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(1);
    assertThat(entry.totalOutstandingRpcs()).isEqualTo(1);

    // Simulate call success
    listener.onClose(Status.OK, new Metadata());

    // After close
    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(0);
    assertThat(entry.totalOutstandingRpcs()).isEqualTo(0);
    assertThat(entry.getAndResetSuccessCount()).isEqualTo(1);
    assertThat(entry.getAndResetErrorCount()).isEqualTo(0);
  }

  @Test
  public void testStreamingRpcFailure() {
    BigtableChannelPool.Entry entry = getSingleEntry();
    ClientCall.Listener<String> listener = startCall(streamingMethodDescriptor);

    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(1);

    // Simulate call failure
    listener.onClose(Status.DEADLINE_EXCEEDED, new Metadata());

    // After close
    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(0);
    assertThat(entry.totalOutstandingRpcs()).isEqualTo(0);
    assertThat(entry.getAndResetSuccessCount()).isEqualTo(0);
    assertThat(entry.getAndResetErrorCount()).isEqualTo(1);
  }

  @Test
  public void testMixedRpcs() {
    BigtableChannelPool.Entry entry = getSingleEntry();

    // 1 Unary OK
    startCall(unaryMethodDescriptor).onClose(Status.OK, new Metadata());
    // 1 Unary Fail
    startCall(unaryMethodDescriptor).onClose(Status.INTERNAL, new Metadata());
    // 1 Streaming OK
    startCall(streamingMethodDescriptor).onClose(Status.OK, new Metadata());
    // 2 Streaming Fail
    startCall(streamingMethodDescriptor).onClose(Status.CANCELLED, new Metadata());
    ClientCall.Listener<String> streamingListener = startCall(streamingMethodDescriptor);

    // Before the last one closes
    assertThat(entry.getOutstandingUnaryRpcs()).isEqualTo(0);
    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(1);
    assertThat(entry.getAndResetSuccessCount()).isEqualTo(2); // 1 Unary + 1 Streaming
    assertThat(entry.getAndResetErrorCount()).isEqualTo(2); // 1 Unary + 1 Streaming

    // Close the last one
    streamingListener.onClose(Status.UNKNOWN, new Metadata());
    assertThat(entry.getOutstandingStreamingRpcs()).isEqualTo(0);
    assertThat(entry.getAndResetSuccessCount()).isEqualTo(0);
    assertThat(entry.getAndResetErrorCount()).isEqualTo(1); // The last failure
    assertThat(entry.totalOutstandingRpcs()).isEqualTo(0);
  }

  @Test
  public void testConstructorContinuesWhenInitialPrimingFails() throws IOException {
    ManagedChannel initialChannel = mock(ManagedChannel.class);
    when(mockChannelFactory.get()).thenReturn(initialChannel);
    doThrow(new RuntimeException("Initial PingAndWarm failed"))
        .when(mockChannelPrimer)
        .primeChannel(initialChannel);

    BigtableChannelPoolSettings settings =
        BigtableChannelPoolSettings.builder()
            .setInitialChannelCount(1)
            .setMinChannelCount(1)
            .setMaxChannelCount(1)
            .build();
    BigtableChannelPool pool =
        new BigtableChannelPool(settings, mockChannelFactory, mockChannelPrimer, executorService);

    assertThat(pool.getChannelInfos()).hasSize(1);
    verify(initialChannel, never()).shutdownNow();
  }

  @Test
  public void testRefreshKeepsOldChannelWhenPrimingFails() {
    BigtableChannelPool.Entry initialEntry = getSingleEntry();
    ManagedChannel badNewChannel = mock(ManagedChannel.class);
    when(mockChannelFactory.get()).thenReturn(badNewChannel);
    doThrow(new RuntimeException("PingAndWarm failed"))
        .when(mockChannelPrimer)
        .primeChannel(badNewChannel);

    channelPool.refresh();

    assertThat(getSingleEntry()).isSameInstanceAs(initialEntry);
    verify(badNewChannel).shutdownNow();
    verify(mockChannel, never()).shutdown();
  }

  @Test
  public void testReplaceOutlierEntryAsyncReplacesUnhealthyChannel() throws Exception {
    BigtableChannelPool.Entry initialEntry = getSingleEntry();
    ManagedChannel replacementChannel = mock(ManagedChannel.class);
    when(mockChannelFactory.get()).thenReturn(replacementChannel);
    when(mockChannelPrimer.sendPrimeRequestsAsync(replacementChannel))
        .thenReturn(ApiFutures.immediateFuture(PingAndWarmResponse.getDefaultInstance()));

    channelPool.replaceOutlierEntryAsync(initialEntry);
    flushExecutor();

    BigtableChannelPool.Entry updatedEntry = getSingleEntry();
    assertThat(updatedEntry).isNotSameInstanceAs(initialEntry);
    assertThat(updatedEntry.getManagedChannel()).isSameInstanceAs(replacementChannel);
    verify(mockChannelPrimer).sendPrimeRequestsAsync(replacementChannel);
    verify(mockChannel).shutdown();
    verify(mockChannel, never()).enterIdle();
  }

  @Test
  public void testReplaceOutlierEntryAsyncFallsBackToEnterIdleWhenPrimingFails() throws Exception {
    BigtableChannelPool.Entry initialEntry = getSingleEntry();
    ManagedChannel badReplacementChannel = mock(ManagedChannel.class);
    when(mockChannelFactory.get()).thenReturn(badReplacementChannel);
    when(mockChannelPrimer.sendPrimeRequestsAsync(badReplacementChannel))
        .thenReturn(ApiFutures.immediateFailedFuture(new RuntimeException("PingAndWarm failed")));

    channelPool.replaceOutlierEntryAsync(initialEntry);
    flushExecutor();

    assertThat(getSingleEntry()).isSameInstanceAs(initialEntry);
    verify(badReplacementChannel).shutdownNow();
    verify(mockChannel, never()).shutdown();
    verify(mockChannel).enterIdle();
  }

  @Test
  public void testReplaceOutlierEntryAsyncDoesNotBlockExecutorWhilePrimingInFlight()
      throws Exception {
    BigtableChannelPool.Entry initialEntry = getSingleEntry();
    ManagedChannel replacementChannel = mock(ManagedChannel.class);
    SettableApiFuture<PingAndWarmResponse> pendingPrime = SettableApiFuture.create();
    when(mockChannelFactory.get()).thenReturn(replacementChannel);
    when(mockChannelPrimer.sendPrimeRequestsAsync(replacementChannel)).thenReturn(pendingPrime);

    channelPool.replaceOutlierEntryAsync(initialEntry);

    // The single-threaded executor must remain unblocked while PingAndWarm is still in flight.
    assertThat(executorService.submit(() -> "unblocked").get(5, TimeUnit.SECONDS))
        .isEqualTo("unblocked");
    assertThat(getSingleEntry()).isSameInstanceAs(initialEntry);

    pendingPrime.set(PingAndWarmResponse.getDefaultInstance());
    flushExecutor();

    assertThat(getSingleEntry().getManagedChannel()).isSameInstanceAs(replacementChannel);
    verify(mockChannel).shutdown();
  }

  @Test
  public void testHealthCheckerEvictionReplacesOutlierEntryInPool() throws Exception {
    BigtableChannelPoolSettings multiChannelSettings =
        BigtableChannelPoolSettings.builder()
            .setInitialChannelCount(2)
            .setMinChannelCount(2)
            .setMaxChannelCount(2)
            .build();
    ManagedChannel healthyChannel = mock(ManagedChannel.class);
    ManagedChannel unhealthyChannel = mock(ManagedChannel.class);
    ManagedChannel replacementChannel = mock(ManagedChannel.class);
    when(mockChannelFactory.get()).thenReturn(healthyChannel, unhealthyChannel, replacementChannel);
    when(mockChannelPrimer.sendPrimeRequestsAsync(replacementChannel))
        .thenReturn(ApiFutures.immediateFuture(PingAndWarmResponse.getDefaultInstance()));

    BigtableChannelPool pool =
        new BigtableChannelPool(
            multiChannelSettings, mockChannelFactory, mockChannelPrimer, executorService);
    @SuppressWarnings("unchecked")
    List<BigtableChannelPool.Entry> initialEntries =
        (List<BigtableChannelPool.Entry>) pool.getChannelInfos();
    BigtableChannelPool.Entry healthyEntry = initialEntries.get(0);
    BigtableChannelPool.Entry outlierEntry = initialEntries.get(1);

    healthyEntry.successfulProbesInWindow.set(10);
    outlierEntry.failedProbesInWindow.set(10);

    @SuppressWarnings("unchecked")
    ChannelPoolHealthChecker healthChecker =
        new ChannelPoolHealthChecker(
            () -> ImmutableList.copyOf((List<BigtableChannelPool.Entry>) pool.getChannelInfos()),
            mockChannelPrimer,
            executorService,
            Clock.systemUTC(),
            pool::replaceOutlierEntryAsync);

    healthChecker.detectAndRemoveOutlierEntries();
    flushExecutor();

    @SuppressWarnings("unchecked")
    List<BigtableChannelPool.Entry> updatedEntries =
        (List<BigtableChannelPool.Entry>) pool.getChannelInfos();
    assertThat(updatedEntries.get(0)).isSameInstanceAs(healthyEntry);
    assertThat(updatedEntries.get(1)).isNotSameInstanceAs(outlierEntry);
    assertThat(updatedEntries.get(1).getManagedChannel()).isSameInstanceAs(replacementChannel);
    verify(unhealthyChannel).shutdown();
    verify(unhealthyChannel, never()).enterIdle();
  }
}
