/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.grpc;

import static com.google.api.gax.grpc.testing.FakeServiceGrpc.METHOD_RECOGNIZE;
import static com.google.api.gax.grpc.testing.FakeServiceGrpc.METHOD_SERVER_STREAMING_RECOGNIZE;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.grpc.testing.FakeChannelFactory;
import com.google.api.gax.grpc.testing.FakeMethodDescriptor;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.EndpointContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.util.FakeLogHandler;
import com.google.auth.Credentials;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.type.Color;
import com.google.type.Money;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.stub.ClientCalls;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

class ChannelPoolTest {
  private static final int DEFAULT_AWAIT_TERMINATION_SEC = 10;
  private ChannelPool pool;
  private java.nio.file.Path tempCert;

  @AfterEach
  void cleanup() throws InterruptedException, IOException {
    if (pool != null) {
      pool.shutdown();
      pool.awaitTermination(DEFAULT_AWAIT_TERMINATION_SEC, TimeUnit.SECONDS);
    }
    if (tempCert != null) {
      java.nio.file.Files.deleteIfExists(tempCert);
      tempCert = null;
    }
  }

  @Test
  void testAuthority() throws IOException {
    ManagedChannel sub1 = mock(ManagedChannel.class);
    ManagedChannel sub2 = mock(ManagedChannel.class);

    Mockito.when(sub1.authority()).thenReturn("myAuth");

    pool =
        ChannelPool.create(
            ChannelPoolSettings.staticallySized(2),
            new FakeChannelFactory(Arrays.asList(sub1, sub2)),
            null,
            null);
    assertThat(pool.authority()).isEqualTo("myAuth");
  }

  @Test
  void testRoundRobin() throws IOException {
    ManagedChannel sub1 = mock(ManagedChannel.class);
    ManagedChannel sub2 = mock(ManagedChannel.class);

    Mockito.when(sub1.authority()).thenReturn("myAuth");

    ArrayList<ManagedChannel> channels = Lists.newArrayList(sub1, sub2);
    pool =
        ChannelPool.create(
            ChannelPoolSettings.staticallySized(channels.size()),
            new FakeChannelFactory(channels),
            null,
            null);

    verifyTargetChannel(pool, channels, sub1);
    verifyTargetChannel(pool, channels, sub2);
    verifyTargetChannel(pool, channels, sub1);
  }

  private void verifyTargetChannel(
      ChannelPool pool, List<ManagedChannel> channels, ManagedChannel targetChannel) {
    MethodDescriptor<Color, Money> methodDescriptor = METHOD_RECOGNIZE;
    CallOptions callOptions = CallOptions.DEFAULT;
    @SuppressWarnings("unchecked")
    ClientCall<Color, Money> expectedClientCall = mock(ClientCall.class);

    channels.forEach(Mockito::reset);
    Mockito.doReturn(expectedClientCall).when(targetChannel).newCall(methodDescriptor, callOptions);

    ClientCall<Color, Money> actualCall = pool.newCall(methodDescriptor, callOptions);
    Mockito.verify(targetChannel, Mockito.times(1)).newCall(methodDescriptor, callOptions);
    actualCall.start(null, null);
    Mockito.verify(expectedClientCall, Mockito.times(1)).start(Mockito.any(), Mockito.any());

    for (ManagedChannel otherChannel : channels) {
      if (otherChannel != targetChannel) {
        Mockito.verify(otherChannel, Mockito.never()).newCall(methodDescriptor, callOptions);
      }
    }
  }

  private static ChannelFactory createMockChannelFactory(
      List<ManagedChannel> channels, List<ClientCall<Object, Object>> startedCalls) {
    return () -> {
      ManagedChannel channel = mock(ManagedChannel.class);
      Mockito.when(channel.newCall(Mockito.any(), Mockito.any()))
          .thenAnswer(
              invocation -> {
                @SuppressWarnings("unchecked")
                ClientCall<Object, Object> clientCall = mock(ClientCall.class);
                if (startedCalls != null) {
                  startedCalls.add(clientCall);
                }
                return clientCall;
              });

      channels.add(channel);
      return channel;
    };
  }

  @Test
  void ensureEvenDistribution() throws InterruptedException, IOException {
    int numChannels = 10;
    final ManagedChannel[] channels = new ManagedChannel[numChannels];
    final AtomicInteger[] counts = new AtomicInteger[numChannels];

    final MethodDescriptor<Color, Money> methodDescriptor = METHOD_RECOGNIZE;
    final CallOptions callOptions = CallOptions.DEFAULT;
    @SuppressWarnings("unchecked")
    final ClientCall<Color, Money> clientCall = mock(ClientCall.class);

    for (int i = 0; i < numChannels; i++) {
      final int index = i;

      counts[i] = new AtomicInteger();

      channels[i] = mock(ManagedChannel.class);
      Mockito.when(channels[i].newCall(methodDescriptor, callOptions))
          .thenAnswer(
              (ignored) -> {
                counts[index].incrementAndGet();
                return clientCall;
              });
    }

    pool =
        ChannelPool.create(
            ChannelPoolSettings.staticallySized(numChannels),
            new FakeChannelFactory(Arrays.asList(channels)),
            null,
            null);

    int numThreads = 20;
    final int numPerThread = 1000;

    ExecutorService executor = Executors.newFixedThreadPool(numThreads);
    for (int i = 0; i < numThreads; i++) {
      executor.submit(
          () -> {
            for (int j = 0; j < numPerThread; j++) {
              pool.newCall(methodDescriptor, callOptions);
            }
          });
    }
    executor.shutdown();
    boolean shutdown = executor.awaitTermination(1, TimeUnit.MINUTES);
    assertThat(shutdown).isTrue();

    int expectedCount = (numThreads * numPerThread) / numChannels;
    for (AtomicInteger count : counts) {
      assertThat(count.get()).isAnyOf(expectedCount, expectedCount + 1);
    }
  }

  // Test channelPrimer is called same number of times as poolSize if executorService is set to null
  @Test
  void channelPrimerShouldCallPoolConstruction() throws IOException {
    ChannelPrimer mockChannelPrimer =
        mock(ChannelPrimer.class, Mockito.withSettings().withoutAnnotations());
    ManagedChannel channel1 = mock(ManagedChannel.class);
    ManagedChannel channel2 = mock(ManagedChannel.class);

    pool =
        ChannelPool.create(
            ChannelPoolSettings.staticallySized(2).toBuilder()
                .setPreemptiveRefreshEnabled(true)
                .build(),
            new FakeChannelFactory(Arrays.asList(channel1, channel2), mockChannelPrimer),
            null,
            null);
    Mockito.verify(mockChannelPrimer, Mockito.times(2))
        .primeChannel(Mockito.any(ManagedChannel.class));
  }

  // Test channelPrimer is called periodically, if there's an executorService
  @Test
  void channelPrimerIsCalledPeriodically() throws IOException {
    ChannelPrimer mockChannelPrimer =
        mock(ChannelPrimer.class, Mockito.withSettings().withoutAnnotations());
    ManagedChannel channel1 = mock(ManagedChannel.class);
    ManagedChannel channel2 = mock(ManagedChannel.class);
    ManagedChannel channel3 = mock(ManagedChannel.class);

    List<Runnable> channelRefreshers = new ArrayList<>();

    ScheduledExecutorService scheduledExecutorService =
        Mockito.mock(ScheduledExecutorService.class, Mockito.withSettings().withoutAnnotations());
    FixedExecutorProvider provider = FixedExecutorProvider.create(scheduledExecutorService);

    Answer<?> extractChannelRefresher =
        invocation -> {
          channelRefreshers.add(invocation.getArgument(0));
          return Mockito.mock(ScheduledFuture.class, Mockito.withSettings().withoutAnnotations());
        };

    Mockito.doAnswer(extractChannelRefresher)
        .when(scheduledExecutorService)
        .scheduleAtFixedRate(
            Mockito.any(Runnable.class), Mockito.anyLong(), Mockito.anyLong(), Mockito.any());

    FakeChannelFactory channelFactory =
        new FakeChannelFactory(Arrays.asList(channel1, channel2, channel3), mockChannelPrimer);

    pool =
        new ChannelPool(
            ChannelPoolSettings.staticallySized(1).toBuilder()
                .setPreemptiveRefreshEnabled(true)
                .build(),
            channelFactory,
            provider,
            null);
    // 1 call during the creation
    Mockito.verify(mockChannelPrimer, Mockito.times(1))
        .primeChannel(Mockito.any(ManagedChannel.class));

    channelRefreshers.get(0).run();
    // 1 more call during channel refresh
    Mockito.verify(mockChannelPrimer, Mockito.times(2))
        .primeChannel(Mockito.any(ManagedChannel.class));

    channelRefreshers.get(0).run();
    // 1 more call during channel refresh
    Mockito.verify(mockChannelPrimer, Mockito.times(3))
        .primeChannel(Mockito.any(ManagedChannel.class));
  }

  // ----
  // call should be allowed to complete and the channel should not be shutdown
  @Test
  void callShouldCompleteAfterCreation() throws IOException {
    ManagedChannel underlyingChannel = mock(ManagedChannel.class);
    ManagedChannel replacementChannel = mock(ManagedChannel.class);
    FakeChannelFactory channelFactory =
        new FakeChannelFactory(ImmutableList.of(underlyingChannel, replacementChannel));
    pool = ChannelPool.create(ChannelPoolSettings.staticallySized(1), channelFactory, null, null);

    // create a mock call when new call comes to the underlying channel
    MockClientCall<String, Integer> mockClientCall = new MockClientCall<>(1, Status.OK);
    MockClientCall<String, Integer> spyClientCall = Mockito.spy(mockClientCall);
    Mockito.when(
            underlyingChannel.newCall(
                Mockito.<MethodDescriptor<String, Integer>>any(), Mockito.any(CallOptions.class)))
        .thenReturn(spyClientCall);

    Answer<Object> verifyChannelNotShutdown =
        invocation -> {
          Mockito.verify(underlyingChannel, Mockito.never()).shutdown();
          return invocation.callRealMethod();
        };

    // verify that underlying channel is not shutdown when clientCall is still sending message
    Mockito.doAnswer(verifyChannelNotShutdown).when(spyClientCall).sendMessage(Mockito.anyString());

    // create a new call on entry
    @SuppressWarnings("unchecked")
    ClientCall.Listener<Integer> listener = mock(ClientCall.Listener.class);
    ClientCall<String, Integer> call =
        pool.newCall(FakeMethodDescriptor.create(), CallOptions.DEFAULT);

    pool.refreshAll();
    // shutdown is not called because there is still an outstanding call, even if it hasn't started
    Mockito.verify(underlyingChannel, Mockito.after(200).never()).shutdown();

    // start clientCall
    call.start(listener, new Metadata());
    // send message and end the call
    call.sendMessage("message");
    // shutdown is called because the outstanding call has completed
    Mockito.verify(underlyingChannel, Mockito.atLeastOnce()).shutdown();

    // Replacement channel shouldn't be touched
    Mockito.verify(replacementChannel, Mockito.never()).shutdown();
    Mockito.verify(replacementChannel, Mockito.never()).newCall(Mockito.any(), Mockito.any());
  }

  // call should be allowed to complete and the channel should not be shutdown
  @Test
  void callShouldCompleteAfterStarted() throws IOException {
    final ManagedChannel underlyingChannel = mock(ManagedChannel.class);
    ManagedChannel replacementChannel = mock(ManagedChannel.class);

    FakeChannelFactory channelFactory =
        new FakeChannelFactory(ImmutableList.of(underlyingChannel, replacementChannel));
    pool = ChannelPool.create(ChannelPoolSettings.staticallySized(1), channelFactory, null, null);

    // create a mock call when new call comes to the underlying channel
    MockClientCall<String, Integer> mockClientCall = new MockClientCall<>(1, Status.OK);
    MockClientCall<String, Integer> spyClientCall = Mockito.spy(mockClientCall);
    Mockito.when(
            underlyingChannel.newCall(
                Mockito.<MethodDescriptor<String, Integer>>any(), Mockito.any(CallOptions.class)))
        .thenReturn(spyClientCall);

    Answer<Object> verifyChannelNotShutdown =
        invocation -> {
          Mockito.verify(underlyingChannel, Mockito.never()).shutdown();
          return invocation.callRealMethod();
        };

    // verify that underlying channel is not shutdown when clientCall is still sending message
    Mockito.doAnswer(verifyChannelNotShutdown).when(spyClientCall).sendMessage(Mockito.anyString());

    // create a new call on safeShutdownManagedChannel
    @SuppressWarnings("unchecked")
    ClientCall.Listener<Integer> listener = mock(ClientCall.Listener.class);
    ClientCall<String, Integer> call =
        pool.newCall(FakeMethodDescriptor.create(), CallOptions.DEFAULT);

    // start clientCall
    call.start(listener, new Metadata());
    pool.refreshAll();

    // shutdown is not called because there is still an outstanding call
    Mockito.verify(underlyingChannel, Mockito.after(200).never()).shutdown();
    // send message and end the call
    call.sendMessage("message");
    // shutdown is called because the outstanding call has completed
    Mockito.verify(underlyingChannel, Mockito.atLeastOnce()).shutdown();
  }

  // Channel should be shutdown after a refresh all the calls have completed
  @Test
  void channelShouldShutdown() throws IOException {
    ManagedChannel underlyingChannel = mock(ManagedChannel.class);
    ManagedChannel replacementChannel = mock(ManagedChannel.class);

    FakeChannelFactory channelFactory =
        new FakeChannelFactory(ImmutableList.of(underlyingChannel, replacementChannel));
    pool = ChannelPool.create(ChannelPoolSettings.staticallySized(1), channelFactory, null, null);

    // create a mock call when new call comes to the underlying channel
    MockClientCall<String, Integer> mockClientCall = new MockClientCall<>(1, Status.OK);
    MockClientCall<String, Integer> spyClientCall = Mockito.spy(mockClientCall);
    Mockito.when(
            underlyingChannel.newCall(
                Mockito.<MethodDescriptor<String, Integer>>any(), Mockito.any(CallOptions.class)))
        .thenReturn(spyClientCall);

    Answer<Object> verifyChannelNotShutdown =
        invocation -> {
          Mockito.verify(underlyingChannel, Mockito.never()).shutdown();
          return invocation.callRealMethod();
        };

    // verify that underlying channel is not shutdown when clientCall is still sending message
    Mockito.doAnswer(verifyChannelNotShutdown).when(spyClientCall).sendMessage(Mockito.anyString());

    // create a new call on safeShutdownManagedChannel
    @SuppressWarnings("unchecked")
    ClientCall.Listener<Integer> listener = mock(ClientCall.Listener.class);
    ClientCall<String, Integer> call =
        pool.newCall(FakeMethodDescriptor.create(), CallOptions.DEFAULT);

    // start clientCall
    call.start(listener, new Metadata());
    // send message and end the call
    call.sendMessage("message");
    // shutdown is not called because it has not been shutdown yet
    Mockito.verify(underlyingChannel, Mockito.after(200).never()).shutdown();
    pool.refreshAll();
    // shutdown is called because the outstanding call has completed
    Mockito.verify(underlyingChannel, Mockito.atLeastOnce()).shutdown();
  }

  @Test
  void testCancelBeforeStartReleasesChannelEntry() throws IOException {
    ManagedChannel underlyingChannel = mock(ManagedChannel.class);
    ManagedChannel replacementChannel = mock(ManagedChannel.class);
    FakeChannelFactory channelFactory =
        new FakeChannelFactory(ImmutableList.of(underlyingChannel, replacementChannel));
    pool = ChannelPool.create(ChannelPoolSettings.staticallySized(1), channelFactory, null, null);

    ClientCall<String, Integer> call =
        pool.newCall(FakeMethodDescriptor.create(), CallOptions.DEFAULT);

    pool.refreshAll();
    Mockito.verify(underlyingChannel, Mockito.never()).shutdown();

    call.cancel("Cancelled early", null);
    Mockito.verify(underlyingChannel, Mockito.times(1)).shutdown();
  }

  @Test
  void channelReactiveMTlsRefreshShouldConditionallySwapChannels()
      throws IOException, InterruptedException {
    ManagedChannel underlyingChannel1 = Mockito.mock(ManagedChannel.class);
    ManagedChannel underlyingChannel2 = Mockito.mock(ManagedChannel.class);

    FakeChannelFactory channelFactory =
        new FakeChannelFactory(ImmutableList.of(underlyingChannel1, underlyingChannel2));

    // Create a temp file to act as the cert
    tempCert = java.nio.file.Files.createTempFile("cert", ".pem");

    java.nio.file.Path clientCert =
        java.nio.file.Paths.get("src", "test", "resources", "client_cert.pem");
    java.nio.file.Files.copy(
        clientCert, tempCert, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

    ChannelPoolSettings channelPoolSettings =
        ChannelPoolSettings.builder().setInitialChannelCount(1).build();

    pool = ChannelPool.create(channelPoolSettings, channelFactory, null, tempCert.toString());

    // Initially uses channel1
    pool.newCall(FakeMethodDescriptor.<String, Integer>create(), CallOptions.DEFAULT);
    Mockito.verify(underlyingChannel1, Mockito.times(1))
        .newCall(Mockito.<MethodDescriptor<String, Integer>>any(), Mockito.any(CallOptions.class));

    // Try a reactive refresh *without* changing the cert content (should no-op)
    pool.refresh();

    // Verify it's STILL channel1
    pool.newCall(FakeMethodDescriptor.<String, Integer>create(), CallOptions.DEFAULT);
    Mockito.verify(underlyingChannel1, Mockito.times(2))
        .newCall(Mockito.<MethodDescriptor<String, Integer>>any(), Mockito.any(CallOptions.class));

    // The ChannelPool caches fingerprints for 1000ms, wait for it to expire
    pool.invalidateDiskFingerprintCache();

    java.nio.file.Path rootCert =
        java.nio.file.Paths.get("src", "test", "resources", "root_cert.pem");
    java.nio.file.Files.copy(rootCert, tempCert, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

    // Try a reactive refresh *with* a changed cert content (should swap channels)
    pool.refresh();

    // Verify it is NOW channel2
    pool.newCall(FakeMethodDescriptor.<String, Integer>create(), CallOptions.DEFAULT);
    Mockito.verify(underlyingChannel2, Mockito.times(1))
        .newCall(Mockito.<MethodDescriptor<String, Integer>>any(), Mockito.any(CallOptions.class));
  }

  @Test
  void channelReactiveMTlsRefresh_failedCreationDoesNotMutateFingerprintAndAllowsRetry()
      throws IOException {
    ManagedChannel channel1 = Mockito.mock(ManagedChannel.class);
    ManagedChannel channel2 = Mockito.mock(ManagedChannel.class);
    ChannelFactory channelFactory =
        Mockito.mock(ChannelFactory.class, Mockito.withSettings().withoutAnnotations());

    // Initial creation returns channel1, refresh attempt 1 throws IOException, refresh attempt 2
    // returns channel2
    Mockito.when(channelFactory.createSingleChannel())
        .thenReturn(channel1)
        .thenThrow(new IOException("Transient channel creation error"))
        .thenReturn(channel2);

    tempCert = java.nio.file.Files.createTempFile("cert", ".pem");
    java.nio.file.Path clientCert =
        java.nio.file.Paths.get("src", "test", "resources", "client_cert.pem");
    java.nio.file.Files.copy(
        clientCert, tempCert, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

    ChannelPoolSettings channelPoolSettings =
        ChannelPoolSettings.builder().setInitialChannelCount(1).build();

    pool = ChannelPool.create(channelPoolSettings, channelFactory, null, tempCert.toString());

    // Initially uses channel1
    pool.newCall(FakeMethodDescriptor.<String, Integer>create(), CallOptions.DEFAULT);
    Mockito.verify(channel1, Mockito.times(1))
        .newCall(Mockito.<MethodDescriptor<String, Integer>>any(), Mockito.any(CallOptions.class));

    // Rotate cert on disk
    pool.invalidateDiskFingerprintCache();
    java.nio.file.Path rootCert =
        java.nio.file.Paths.get("src", "test", "resources", "root_cert.pem");
    java.nio.file.Files.copy(rootCert, tempCert, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

    // Refresh attempt 1: createSingleChannel throws IOException.
    // Refresh should fail to replace channel and MUST NOT record the new cert fingerprint as
    // active.
    pool.refresh();

    // Verify still channel1
    pool.newCall(FakeMethodDescriptor.<String, Integer>create(), CallOptions.DEFAULT);
    Mockito.verify(channel1, Mockito.times(2))
        .newCall(Mockito.<MethodDescriptor<String, Integer>>any(), Mockito.any(CallOptions.class));

    // Refresh attempt 2: with the same cert file on disk (cache expired), channelFactory now
    // succeeds.
    // If the fingerprint had been mutated on the failed attempt, this call would be skipped as a
    // duplicate!
    pool.invalidateDiskFingerprintCache();
    pool.refresh();

    // Verify it has now swapped to channel2!
    pool.newCall(FakeMethodDescriptor.<String, Integer>create(), CallOptions.DEFAULT);
    Mockito.verify(channel2, Mockito.times(1))
        .newCall(Mockito.<MethodDescriptor<String, Integer>>any(), Mockito.any(CallOptions.class));
  }

  @Test
  void
      channelReactiveMTlsRefresh_partialFailureInMultiChannelPool_retainsShouldRefreshAndCompletesOnSubsequentRefresh()
          throws IOException {
    ManagedChannel initial1 = Mockito.mock(ManagedChannel.class);
    ManagedChannel initial2 = Mockito.mock(ManagedChannel.class);
    ManagedChannel rotated1 = Mockito.mock(ManagedChannel.class);
    ManagedChannel rotated1SecondPass = Mockito.mock(ManagedChannel.class);
    ManagedChannel rotated2 = Mockito.mock(ManagedChannel.class);
    ChannelFactory channelFactory =
        Mockito.mock(ChannelFactory.class, Mockito.withSettings().withoutAnnotations());

    // Initial creation: initial1, initial2
    // Refresh pass 1: rotated1 succeeds, second throws IOException
    // Refresh pass 2: rotated1SecondPass, rotated2 both succeed
    Mockito.when(channelFactory.createSingleChannel())
        .thenReturn(initial1, initial2)
        .thenReturn(rotated1)
        .thenThrow(new IOException("Transient failure on second sub-channel"))
        .thenReturn(rotated1SecondPass, rotated2);

    tempCert = java.nio.file.Files.createTempFile("cert", ".pem");
    java.nio.file.Path clientCert =
        java.nio.file.Paths.get("src", "test", "resources", "client_cert.pem");
    java.nio.file.Files.copy(
        clientCert, tempCert, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

    pool =
        ChannelPool.create(
            ChannelPoolSettings.staticallySized(2), channelFactory, null, tempCert.toString());

    // Rotate cert on disk
    pool.invalidateDiskFingerprintCache();
    java.nio.file.Path rootCert =
        java.nio.file.Paths.get("src", "test", "resources", "root_cert.pem");
    java.nio.file.Files.copy(rootCert, tempCert, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

    assertThat(pool.shouldRefresh()).isTrue();
    long genBefore = pool.getGeneration();

    // First refresh: partial failure (channel 0 rotates to rotated1, channel 1 fails and keeps
    // initial2)
    pool.refresh();

    // Generation should still increment since partial progress was committed
    assertThat(pool.getGeneration()).isGreaterThan(genBefore);
    // initial1 should have been shut down, initial2 should NOT be shut down yet
    Mockito.verify(initial1).shutdown();
    Mockito.verify(initial2, Mockito.never()).shutdown();

    // Crucial assertion: shouldRefresh() MUST remain true so subsequent 401s on unrotated channel 1
    // trigger retry/refresh
    pool.invalidateDiskFingerprintCache();
    assertThat(pool.shouldRefresh()).isTrue();

    // Second refresh: both channels succeed
    pool.refresh();

    assertThat(pool.shouldRefresh()).isFalse();
    Mockito.verify(initial2).shutdown();
  }

  @Test
  void refreshAll_runtimeExceptionOrError_doesNotLeakCreatedChannels() throws IOException {
    ManagedChannel initial1 = Mockito.mock(ManagedChannel.class);
    ManagedChannel initial2 = Mockito.mock(ManagedChannel.class);
    ManagedChannel createdBeforeRuntimeEx = Mockito.mock(ManagedChannel.class);
    ManagedChannel createdBeforeError = Mockito.mock(ManagedChannel.class);
    ChannelFactory channelFactory =
        Mockito.mock(ChannelFactory.class, Mockito.withSettings().withoutAnnotations());

    Mockito.when(channelFactory.createSingleChannel())
        .thenReturn(initial1, initial2)
        .thenReturn(createdBeforeRuntimeEx)
        .thenThrow(new RuntimeException("Unchecked runtime exception"))
        .thenReturn(createdBeforeError)
        .thenThrow(new AssertionError("Simulated Error during refresh"));

    pool = ChannelPool.create(ChannelPoolSettings.staticallySized(2), channelFactory, null, null);

    // Case 1: RuntimeException on channel 1 after creating channel 0 -> caught as Exception,
    // partial progress committed
    boolean allCreated = pool.refreshAll();
    assertThat(allCreated).isFalse();
    Mockito.verify(initial1).shutdown();

    // Case 2: Error on channel 1 after creating channel 0 -> aborts, finally block must shut down
    // createdBeforeError
    org.junit.jupiter.api.Assertions.assertThrows(AssertionError.class, () -> pool.refreshAll());
    Mockito.verify(createdBeforeError).shutdown();
  }

  @Test
  void refresh_onShutdownPool_noOpsAndCreatesNoChannels() throws IOException {
    ManagedChannel channel1 = mock(ManagedChannel.class);
    ManagedChannel channel2 = mock(ManagedChannel.class);
    ChannelFactory channelFactory =
        Mockito.mock(ChannelFactory.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(channelFactory.createSingleChannel()).thenReturn(channel1, channel2);

    pool = ChannelPool.create(ChannelPoolSettings.staticallySized(1), channelFactory, null, null);
    Mockito.verify(channelFactory, Mockito.times(1)).createSingleChannel();

    pool.shutdown();
    assertThat(pool.isShutdown()).isTrue();

    // Invoking refresh or refreshAll on shut down pool must no-op and never create new subchannels
    pool.refresh();
    boolean refreshed = pool.refreshAll();
    assertThat(refreshed).isFalse();
    Mockito.verify(channelFactory, Mockito.times(1)).createSingleChannel();
    assertThat(pool.isShutdown()).isTrue();
  }

  @Test
  void generationCounterIncrementsOnRefresh() throws IOException {
    ManagedChannel channel1 = mock(ManagedChannel.class);
    ManagedChannel channel2 = mock(ManagedChannel.class);
    ChannelFactory channelFactory =
        Mockito.mock(ChannelFactory.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(channelFactory.createSingleChannel()).thenReturn(channel1, channel2);

    pool = ChannelPool.create(ChannelPoolSettings.staticallySized(1), channelFactory, null, null);
    assertThat(pool.getGeneration()).isEqualTo(0);

    pool.refreshAll();
    assertThat(pool.getGeneration()).isEqualTo(1);
  }

  @Test
  void channelRefreshShouldSwapChannels() throws IOException {
    ManagedChannel underlyingChannel1 = mock(ManagedChannel.class);
    ManagedChannel underlyingChannel2 = mock(ManagedChannel.class);

    // mock executor service to capture the runnable scheduled, so we can invoke it when we want to
    ScheduledExecutorService scheduledExecutorService =
        Mockito.mock(ScheduledExecutorService.class, Mockito.withSettings().withoutAnnotations());
    FixedExecutorProvider provider = FixedExecutorProvider.create(scheduledExecutorService);

    Mockito.doReturn(null)
        .when(scheduledExecutorService)
        .schedule(
            Mockito.any(Runnable.class), Mockito.anyLong(), Mockito.eq(TimeUnit.MILLISECONDS));

    FakeChannelFactory channelFactory =
        new FakeChannelFactory(ImmutableList.of(underlyingChannel1, underlyingChannel2));
    pool =
        new ChannelPool(
            ChannelPoolSettings.staticallySized(1).toBuilder()
                .setPreemptiveRefreshEnabled(true)
                .build(),
            channelFactory,
            provider,
            null);
    Mockito.reset(underlyingChannel1);

    pool.newCall(FakeMethodDescriptor.<String, Integer>create(), CallOptions.DEFAULT);

    Mockito.verify(underlyingChannel1, Mockito.only())
        .newCall(Mockito.<MethodDescriptor<String, Integer>>any(), Mockito.any(CallOptions.class));

    // swap channel
    pool.refreshAll();

    pool.newCall(FakeMethodDescriptor.<String, Integer>create(), CallOptions.DEFAULT);

    Mockito.verify(underlyingChannel2, Mockito.only())
        .newCall(Mockito.<MethodDescriptor<String, Integer>>any(), Mockito.any(CallOptions.class));
  }

  @Test
  void testRefreshWithNullWorkloadCertPathSwapsChannel() throws IOException {
    ScheduledExecutorService executor =
        Mockito.mock(ScheduledExecutorService.class, Mockito.withSettings().withoutAnnotations());
    FixedExecutorProvider provider = FixedExecutorProvider.create(executor);
    ManagedChannel underlyingChannel1 = Mockito.mock(ManagedChannel.class);
    ManagedChannel underlyingChannel2 = Mockito.mock(ManagedChannel.class);
    FakeChannelFactory channelFactory =
        new FakeChannelFactory(ImmutableList.of(underlyingChannel1, underlyingChannel2));
    pool =
        new ChannelPool(
            ChannelPoolSettings.staticallySized(1).toBuilder()
                .setPreemptiveRefreshEnabled(true)
                .build(),
            channelFactory,
            provider,
            null);
    Mockito.reset(underlyingChannel1);

    pool.newCall(FakeMethodDescriptor.<String, Integer>create(), CallOptions.DEFAULT);
    Mockito.verify(underlyingChannel1, Mockito.only())
        .newCall(Mockito.<MethodDescriptor<String, Integer>>any(), Mockito.any(CallOptions.class));

    // Calling refresh() when workloadCertPath is null should fall back to refreshAll()
    pool.refresh();

    pool.newCall(FakeMethodDescriptor.<String, Integer>create(), CallOptions.DEFAULT);
    Mockito.verify(underlyingChannel2, Mockito.only())
        .newCall(Mockito.<MethodDescriptor<String, Integer>>any(), Mockito.any(CallOptions.class));
  }

  @Test
  void channelCountShouldNotChangeWhenOutstandingRpcsAreWithinLimits() throws Exception {
    ScheduledExecutorService executor =
        Mockito.mock(ScheduledExecutorService.class, Mockito.withSettings().withoutAnnotations());
    FixedExecutorProvider provider = FixedExecutorProvider.create(executor);

    List<ManagedChannel> channels = new ArrayList<>();
    List<ClientCall<Object, Object>> startedCalls = new ArrayList<>();

    ChannelFactory channelFactory = createMockChannelFactory(channels, startedCalls);

    pool =
        new ChannelPool(
            ChannelPoolSettings.builder()
                .setInitialChannelCount(2)
                .setMinRpcsPerChannel(1)
                .setMaxRpcsPerChannel(2)
                .build(),
            channelFactory,
            provider,
            null);
    assertThat(pool.entries.get()).hasSize(2);

    // Start the minimum number of
    for (int i = 0; i < 2; i++) {
      ClientCalls.futureUnaryCall(
          pool.newCall(METHOD_RECOGNIZE, CallOptions.DEFAULT), Color.getDefaultInstance());
    }
    pool.resize();
    assertThat(pool.entries.get()).hasSize(2);

    // Add enough RPCs to be just at the brink of expansion
    for (int i = startedCalls.size(); i < 4; i++) {
      ClientCalls.futureUnaryCall(
          pool.newCall(METHOD_RECOGNIZE, CallOptions.DEFAULT), Color.getDefaultInstance());
    }
    pool.resize();
    assertThat(pool.entries.get()).hasSize(2);

    // Add another RPC to push expansion
    pool.newCall(METHOD_RECOGNIZE, CallOptions.DEFAULT);
    pool.resize();
    assertThat(pool.entries.get()).hasSize(4); // += ChannelPool::MAX_RESIZE_DELTA
    assertThat(startedCalls).hasSize(5);

    // Complete RPCs to the brink of shrinking
    @SuppressWarnings("unchecked")
    ArgumentCaptor<ClientCall.Listener<Object>> captor =
        ArgumentCaptor.forClass(ClientCall.Listener.class);
    Mockito.verify(startedCalls.remove(0)).start(captor.capture(), Mockito.any());
    captor.getValue().onClose(Status.ABORTED, new Metadata());
    // Resize twice: the first round maintains the peak from the last cycle
    pool.resize();
    pool.resize();
    assertThat(pool.entries.get()).hasSize(4);
    assertThat(startedCalls).hasSize(4);

    // Complete another RPC to trigger shrinking
    Mockito.verify(startedCalls.remove(0)).start(captor.capture(), Mockito.any());
    captor.getValue().onClose(Status.ABORTED, new Metadata());
    // Resize twice: the first round maintains the peak from the last cycle
    pool.resize();
    pool.resize();
    assertThat(startedCalls).hasSize(3);
    // range of channels is [2-3] rounded down average is 2
    assertThat(pool.entries.get()).hasSize(2);
  }

  @Test
  void customResizeDeltaIsRespected() throws Exception {
    ScheduledExecutorService executor =
        Mockito.mock(ScheduledExecutorService.class, Mockito.withSettings().withoutAnnotations());
    FixedExecutorProvider provider = FixedExecutorProvider.create(executor);

    List<ManagedChannel> channels = new ArrayList<>();

    ChannelFactory channelFactory = createMockChannelFactory(channels, null);

    pool =
        new ChannelPool(
            ChannelPoolSettings.builder()
                .setInitialChannelCount(2)
                .setMinRpcsPerChannel(1)
                .setMaxRpcsPerChannel(2)
                .setMaxResizeDelta(5)
                .build(),
            channelFactory,
            provider,
            null);
    assertThat(pool.entries.get()).hasSize(2);

    // Add 20 RPCs to push expansion
    for (int i = 0; i < 20; i++) {
      ClientCalls.futureUnaryCall(
          pool.newCall(METHOD_RECOGNIZE, CallOptions.DEFAULT), Color.getDefaultInstance());
    }
    pool.resize();
    // delta is 15 - 2 = 13. Capped at maxResizeDelta = 5.
    // Expected size = 2 + 5 = 7.
    assertThat(pool.entries.get()).hasSize(7);
  }

  @Test
  void removedIdleChannelsAreShutdown() throws Exception {
    ScheduledExecutorService executor =
        Mockito.mock(ScheduledExecutorService.class, Mockito.withSettings().withoutAnnotations());
    FixedExecutorProvider provider = FixedExecutorProvider.create(executor);

    List<ManagedChannel> channels = new ArrayList<>();

    List<ClientCall<Object, Object>> startedCalls = new ArrayList<>();
    ChannelFactory channelFactory = createMockChannelFactory(channels, startedCalls);

    pool =
        new ChannelPool(
            ChannelPoolSettings.builder()
                .setInitialChannelCount(2)
                .setMinRpcsPerChannel(1)
                .setMaxRpcsPerChannel(2)
                .build(),
            channelFactory,
            provider,
            null);
    assertThat(pool.entries.get()).hasSize(2);

    // With no outstanding RPCs, the pool should shrink
    pool.resize();
    assertThat(pool.entries.get()).hasSize(1);
    Mockito.verify(channels.get(1), Mockito.times(1)).shutdown();
  }

  @Test
  void removedActiveChannelsAreShutdown() throws Exception {
    ScheduledExecutorService executor =
        Mockito.mock(ScheduledExecutorService.class, Mockito.withSettings().withoutAnnotations());
    FixedExecutorProvider provider = FixedExecutorProvider.create(executor);

    List<ManagedChannel> channels = new ArrayList<>();
    List<ClientCall<Object, Object>> startedCalls = new ArrayList<>();

    ChannelFactory channelFactory = createMockChannelFactory(channels, startedCalls);

    pool =
        new ChannelPool(
            ChannelPoolSettings.builder()
                .setInitialChannelCount(2)
                .setMinRpcsPerChannel(1)
                .setMaxRpcsPerChannel(2)
                .build(),
            channelFactory,
            provider,
            null);
    assertThat(pool.entries.get()).hasSize(2);

    // Start 2 RPCs
    for (int i = 0; i < 2; i++) {
      ClientCalls.futureUnaryCall(
          pool.newCall(METHOD_RECOGNIZE, CallOptions.DEFAULT), Color.getDefaultInstance());
    }
    // Complete the first one
    @SuppressWarnings("unchecked")
    ArgumentCaptor<ClientCall.Listener<Object>> captor =
        ArgumentCaptor.forClass(ClientCall.Listener.class);
    Mockito.verify(startedCalls.get(0)).start(captor.capture(), Mockito.any());
    captor.getValue().onClose(Status.ABORTED, new Metadata());

    // With a single RPC, the pool should shrink
    pool.resize();
    pool.resize();
    assertThat(pool.entries.get()).hasSize(1);

    // While the RPC is outstanding, the channel should still be open
    Mockito.verify(channels.get(1), Mockito.never()).shutdown();

    // Complete the RPC
    Mockito.verify(startedCalls.get(1)).start(captor.capture(), Mockito.any());
    captor.getValue().onClose(Status.ABORTED, new Metadata());
    // Now the channel should be closed
    Mockito.verify(channels.get(1), Mockito.times(1)).shutdown();
  }

  @Test
  void testReleasingClientCallCancelEarly() throws IOException {
    ClientCall mockClientCall = mock(ClientCall.class);
    Mockito.doAnswer(invocation -> null).when(mockClientCall).cancel(Mockito.any(), Mockito.any());
    ManagedChannel fakeChannel = mock(ManagedChannel.class);
    Mockito.when(fakeChannel.newCall(Mockito.any(), Mockito.any())).thenReturn(mockClientCall);
    ChannelPoolSettings channelPoolSettings = ChannelPoolSettings.staticallySized(1);
    ChannelFactory factory = new FakeChannelFactory(ImmutableList.of(fakeChannel));
    pool = ChannelPool.create(channelPoolSettings, factory, null, null);

    EndpointContext endpointContext =
        Mockito.mock(EndpointContext.class, Mockito.withSettings().withoutAnnotations());
    Mockito.doNothing()
        .when(endpointContext)
        .validateUniverseDomain(Mockito.any(Credentials.class), Mockito.any(GrpcStatusCode.class));

    ClientContext context =
        ClientContext.newBuilder()
            .setTransportChannel(GrpcTransportChannel.create(pool))
            .setDefaultCallContext(
                GrpcCallContext.of(pool, CallOptions.DEFAULT).withEndpointContext(endpointContext))
            .build();
    ServerStreamingCallSettings settings =
        ServerStreamingCallSettings.<Color, Money>newBuilder().build();
    ServerStreamingCallable streamingCallable =
        GrpcCallableFactory.createServerStreamingCallable(
            GrpcCallSettings.create(METHOD_SERVER_STREAMING_RECOGNIZE), settings, context);
    Color request = Color.newBuilder().setRed(0.5f).build();

    IllegalStateException e =
        Assertions.assertThrows(
            IllegalStateException.class,
            () ->
                streamingCallable.call(
                    request,
                    new ResponseObserver() {
                      @Override
                      public void onStart(StreamController controller) {
                        controller.cancel();
                      }

                      @Override
                      public void onResponse(Object response) {}

                      @Override
                      public void onError(Throwable t) {}

                      @Override
                      public void onComplete() {}
                    }));
    assertThat(e.getCause()).isInstanceOf(CancellationException.class);
    assertThat(e.getMessage()).isEqualTo("Call is already cancelled");
  }

  @Test
  void repeatedResizingLogsWarningOnExpand() throws Exception {
    ScheduledExecutorService executor =
        Mockito.mock(ScheduledExecutorService.class, Mockito.withSettings().withoutAnnotations());
    FixedExecutorProvider provider = FixedExecutorProvider.create(executor);

    ChannelFactory channelFactory = createMockChannelFactory(new ArrayList<>(), null);

    pool =
        new ChannelPool(
            ChannelPoolSettings.builder()
                .setInitialChannelCount(1)
                .setMinRpcsPerChannel(1)
                .setMaxRpcsPerChannel(2)
                .setMaxResizeDelta(1)
                .setMinChannelCount(1)
                .setMaxChannelCount(10)
                .build(),
            channelFactory,
            provider,
            null);
    assertThat(pool.entries.get()).hasSize(1);

    FakeLogHandler logHandler = new FakeLogHandler();
    ChannelPool.LOG.addHandler(logHandler);

    try {
      // Add 20 RPCs to push expansion
      for (int i = 0; i < 20; i++) {
        ClientCalls.futureUnaryCall(
            pool.newCall(METHOD_RECOGNIZE, CallOptions.DEFAULT), Color.getDefaultInstance());
      }

      // Resize 4 times, should not log warning yet
      for (int i = 0; i < 4; i++) {
        pool.resize();
      }
      assertThat(logHandler.getAllMessages()).isEmpty();

      // 5th resize, should log warning
      pool.resize();
      assertThat(logHandler.getAllMessages()).hasSize(1);
      assertThat(logHandler.getAllMessages())
          .contains(ChannelPool.CHANNEL_POOL_CONSECUTIVE_RESIZING_WARNING);

      // 6th resize, should not log again
      pool.resize();
      assertThat(logHandler.getAllMessages()).hasSize(1);
    } finally {
      ChannelPool.LOG.removeHandler(logHandler);
    }
  }

  @Test
  void repeatedResizingLogsWarningOnShrink() throws Exception {
    ScheduledExecutorService executor =
        Mockito.mock(ScheduledExecutorService.class, Mockito.withSettings().withoutAnnotations());
    FixedExecutorProvider provider = FixedExecutorProvider.create(executor);

    ChannelFactory channelFactory = () -> mock(ManagedChannel.class);

    pool =
        new ChannelPool(
            ChannelPoolSettings.builder()
                .setInitialChannelCount(10)
                .setMinRpcsPerChannel(1)
                .setMaxRpcsPerChannel(2)
                .setMaxResizeDelta(1)
                .setMinChannelCount(1)
                .setMaxChannelCount(10)
                .build(),
            channelFactory,
            provider,
            null);
    assertThat(pool.entries.get()).hasSize(10);

    FakeLogHandler logHandler = new FakeLogHandler();
    ChannelPool.LOG.addHandler(logHandler);

    try {
      // 0 RPCs, should shrink every cycle
      // Resize 4 times, should not log warning yet
      for (int i = 0; i < 4; i++) {
        pool.resize();
      }
      assertThat(logHandler.getAllMessages()).isEmpty();

      // 5th resize, should log warning
      pool.resize();
      assertThat(logHandler.getAllMessages())
          .contains(ChannelPool.CHANNEL_POOL_CONSECUTIVE_RESIZING_WARNING);
    } finally {
      ChannelPool.LOG.removeHandler(logHandler);
    }
  }

  @Test
  void testDoubleRelease() throws Exception {
    FakeLogHandler logHandler = new FakeLogHandler();
    ChannelPool.LOG.addHandler(logHandler);

    try {
      // Create a fake channel pool thats backed by mock channels that simply record invocations
      ClientCall mockClientCall = mock(ClientCall.class);
      ManagedChannel fakeChannel = mock(ManagedChannel.class);
      Mockito.when(fakeChannel.newCall(Mockito.any(), Mockito.any())).thenReturn(mockClientCall);
      ChannelPoolSettings channelPoolSettings = ChannelPoolSettings.staticallySized(1);
      ChannelFactory factory = new FakeChannelFactory(ImmutableList.of(fakeChannel));

      pool = ChannelPool.create(channelPoolSettings, factory, null, null);

      EndpointContext endpointContext =
          Mockito.mock(EndpointContext.class, Mockito.withSettings().withoutAnnotations());
      Mockito.doNothing()
          .when(endpointContext)
          .validateUniverseDomain(
              Mockito.any(Credentials.class), Mockito.any(GrpcStatusCode.class));

      // Construct a fake callable to use the channel pool
      ClientContext context =
          ClientContext.newBuilder()
              .setTransportChannel(GrpcTransportChannel.create(pool))
              .setDefaultCallContext(
                  GrpcCallContext.of(pool, CallOptions.DEFAULT)
                      .withEndpointContext(endpointContext))
              .build();

      UnaryCallSettings<Color, Money> settings =
          UnaryCallSettings.<Color, Money>newUnaryCallSettingsBuilder().build();
      UnaryCallable<Color, Money> callable =
          GrpcCallableFactory.createUnaryCallable(
              GrpcCallSettings.create(METHOD_RECOGNIZE), settings, context);

      // Start the RPC
      ApiFuture<Money> rpcFuture =
          callable.futureCall(Color.getDefaultInstance(), context.getDefaultCallContext());

      // Get the server side listener and intentionally close it twice
      ArgumentCaptor<ClientCall.Listener<?>> clientCallListenerCaptor =
          ArgumentCaptor.forClass(ClientCall.Listener.class);
      Mockito.verify(mockClientCall).start(clientCallListenerCaptor.capture(), Mockito.any());
      clientCallListenerCaptor.getValue().onClose(Status.INTERNAL, new Metadata());
      clientCallListenerCaptor.getValue().onClose(Status.UNKNOWN, new Metadata());

      // Ensure that the channel pool properly logged the double call and kept the refCount correct
      assertThat(logHandler.getAllMessages())
          .contains(
              "Call is being closed more than once. Please make sure that onClose() is not being"
                  + " manually called.");
      assertThat(pool.entries.get()).hasSize(1);
      ChannelPool.Entry entry = pool.entries.get().get(0);
      assertThat(entry.outstandingRpcs.get()).isEqualTo(0);
    } finally {
      ChannelPool.LOG.removeHandler(logHandler);
    }
  }

  @Test
  void settingsValidationFailsWhenMaxResizeDeltaExceedsLimit() {
    ChannelPoolSettings.Builder builder =
        ChannelPoolSettings.builder().setMaxResizeDelta(26).setMaxChannelCount(30);
    assertThrows(IllegalStateException.class, builder::build);
  }

  @Test
  void minChannelsClampedToMaxChannelCountUnderHighLoad() throws Exception {
    ScheduledExecutorService executor =
        Mockito.mock(ScheduledExecutorService.class, Mockito.withSettings().withoutAnnotations());
    FixedExecutorProvider provider = FixedExecutorProvider.create(executor);

    List<ManagedChannel> channels = new ArrayList<>();
    ChannelFactory channelFactory = createMockChannelFactory(channels, null);

    pool =
        new ChannelPool(
            ChannelPoolSettings.builder()
                .setInitialChannelCount(1)
                .setMinRpcsPerChannel(1)
                .setMaxRpcsPerChannel(2)
                .setMaxResizeDelta(10)
                .setMinChannelCount(1)
                .setMaxChannelCount(5)
                .build(),
            channelFactory,
            provider,
            null);
    assertThat(pool.entries.get()).hasSize(1);

    // Add 20 RPCs, which would require 10 channels (20/2)
    // But max is 5
    for (int i = 0; i < 20; i++) {
      ClientCalls.futureUnaryCall(
          pool.newCall(METHOD_RECOGNIZE, CallOptions.DEFAULT), Color.getDefaultInstance());
    }

    pool.resize();

    // Should be clamped to maxChannelCount = 5
    assertThat(pool.entries.get()).hasSize(5);
  }

  @Test
  void maxChannelsClampedToMinChannelCountUnderLowLoad() throws Exception {
    ScheduledExecutorService executor =
        Mockito.mock(ScheduledExecutorService.class, Mockito.withSettings().withoutAnnotations());
    FixedExecutorProvider provider = FixedExecutorProvider.create(executor);

    List<ManagedChannel> channels = new ArrayList<>();
    ChannelFactory channelFactory = createMockChannelFactory(channels, null);

    pool =
        new ChannelPool(
            ChannelPoolSettings.builder()
                .setInitialChannelCount(5)
                .setMinRpcsPerChannel(1)
                .setMaxRpcsPerChannel(2)
                .setMinChannelCount(3)
                .setMaxChannelCount(10)
                .build(),
            channelFactory,
            provider,
            null);
    assertThat(pool.entries.get()).hasSize(5);

    // With no outstanding RPCs, the pool should want to shrink to 0
    // But min is 3
    pool.resize();

    // Should be clamped to minChannelCount = 3
    assertThat(pool.entries.get()).hasSize(3);
  }

  @Test
  void shouldRefresh_doesNotCacheNegativeResultAndDetectsSubsequentRotationImmediately()
      throws IOException {
    ManagedChannel initial = Mockito.mock(ManagedChannel.class);
    ManagedChannel rotated = Mockito.mock(ManagedChannel.class);
    ChannelFactory channelFactory =
        Mockito.mock(ChannelFactory.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(channelFactory.createSingleChannel()).thenReturn(initial, rotated);

    tempCert = java.nio.file.Files.createTempFile("cert", ".pem");
    java.nio.file.Path clientCert =
        java.nio.file.Paths.get("src", "test", "resources", "client_cert.pem");
    java.nio.file.Files.copy(
        clientCert, tempCert, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

    pool =
        ChannelPool.create(
            ChannelPoolSettings.staticallySized(1), channelFactory, null, tempCert.toString());

    // First check returns false (unchanged disk cert)
    assertThat(pool.shouldRefresh()).isFalse();

    // Immediately rotate cert on disk WITHOUT invalidating the 1-second cache
    java.nio.file.Path rootCert =
        java.nio.file.Paths.get("src", "test", "resources", "root_cert.pem");
    java.nio.file.Files.copy(rootCert, tempCert, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

    // Must immediately detect rotation because negative/unchanged disk checks are not cached for 1s
    assertThat(pool.shouldRefresh()).isTrue();

    // Refresh should update activeCertFingerprint and clear any cached positive check
    pool.refresh();
    assertThat(pool.shouldRefresh()).isFalse();
  }

  @Test
  void newCall_whenDelegateThrowsError_releasesEntryAndShutsDownRetiredChannel()
      throws IOException {
    ManagedChannel initial = Mockito.mock(ManagedChannel.class);
    ManagedChannel rotated = Mockito.mock(ManagedChannel.class);
    ChannelFactory channelFactory =
        Mockito.mock(ChannelFactory.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(channelFactory.createSingleChannel()).thenReturn(initial, rotated);
    Mockito.when(initial.newCall(Mockito.any(), Mockito.any()))
        .thenThrow(new LinkageError("Simulated native/JNI linkage error"));

    pool = ChannelPool.create(ChannelPoolSettings.staticallySized(1), channelFactory, null, null);

    assertThrows(LinkageError.class, () -> pool.newCall(METHOD_RECOGNIZE, CallOptions.DEFAULT));

    // Rotating the pool should immediately shut down initial channel because its ref count is 0
    pool.refresh();
    Mockito.verify(initial).shutdown();
  }

  @Test
  @SuppressWarnings("unchecked")
  void start_whenDelegateThrowsError_releasesEntryAndShutsDownRetiredChannel() throws IOException {
    ManagedChannel initial = Mockito.mock(ManagedChannel.class);
    ManagedChannel rotated = Mockito.mock(ManagedChannel.class);
    ClientCall<Color, Money> mockCall = Mockito.mock(ClientCall.class);
    ChannelFactory channelFactory =
        Mockito.mock(ChannelFactory.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(channelFactory.createSingleChannel()).thenReturn(initial, rotated);
    Mockito.when(initial.newCall(Mockito.any(), Mockito.any())).thenReturn((ClientCall) mockCall);
    Mockito.doThrow(new AssertionError("Simulated Error in start"))
        .when(mockCall)
        .start(Mockito.any(), Mockito.any());

    pool = ChannelPool.create(ChannelPoolSettings.staticallySized(1), channelFactory, null, null);

    ClientCall<Color, Money> call = pool.newCall(METHOD_RECOGNIZE, CallOptions.DEFAULT);
    // Rotate pool while call is retained
    pool.refresh();
    Mockito.verify(initial, Mockito.never()).shutdown();

    // Calling start() throws Error, which must release the retained entry and trigger shutdown
    assertThrows(
        AssertionError.class,
        () -> call.start(new ClientCall.Listener<Money>() {}, new io.grpc.Metadata()));
    Mockito.verify(initial).shutdown();
  }

  @Test
  @SuppressWarnings("unchecked")
  void cancel_whenDelegateThrowsException_releasesEntryAndShutsDownRetiredChannel()
      throws IOException {
    ManagedChannel initial = Mockito.mock(ManagedChannel.class);
    ManagedChannel rotated = Mockito.mock(ManagedChannel.class);
    ClientCall<Color, Money> mockCall = Mockito.mock(ClientCall.class);
    ChannelFactory channelFactory =
        Mockito.mock(ChannelFactory.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(channelFactory.createSingleChannel()).thenReturn(initial, rotated);
    Mockito.when(initial.newCall(Mockito.any(), Mockito.any())).thenReturn((ClientCall) mockCall);
    Mockito.doThrow(new RuntimeException("Simulated cancel exception"))
        .when(mockCall)
        .cancel(Mockito.any(), Mockito.any());

    pool = ChannelPool.create(ChannelPoolSettings.staticallySized(1), channelFactory, null, null);

    ClientCall<Color, Money> call = pool.newCall(METHOD_RECOGNIZE, CallOptions.DEFAULT);
    pool.refresh();
    Mockito.verify(initial, Mockito.never()).shutdown();

    assertThrows(RuntimeException.class, () -> call.cancel("cancelled", null));
    Mockito.verify(initial).shutdown();
  }

  @Test
  @SuppressWarnings("unchecked")
  void concurrentStartAndCancel_neverLeaksOrDoubleReleasesEntry() throws Exception {
    ManagedChannel initial = Mockito.mock(ManagedChannel.class);
    ManagedChannel rotated = Mockito.mock(ManagedChannel.class);
    ChannelFactory channelFactory =
        Mockito.mock(ChannelFactory.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(channelFactory.createSingleChannel()).thenReturn(initial, rotated);

    Mockito.when(initial.newCall(Mockito.any(), Mockito.any()))
        .thenAnswer(
            invocation ->
                new ClientCall<Color, Money>() {
                  private Listener<Money> listener;
                  private boolean cancelled;

                  @Override
                  public synchronized void start(
                      Listener<Money> responseListener, io.grpc.Metadata headers) {
                    this.listener = responseListener;
                    if (cancelled) {
                      responseListener.onClose(io.grpc.Status.CANCELLED, new io.grpc.Metadata());
                    }
                  }

                  @Override
                  public synchronized void cancel(String message, Throwable cause) {
                    cancelled = true;
                    if (listener != null) {
                      listener.onClose(io.grpc.Status.CANCELLED, new io.grpc.Metadata());
                    }
                  }

                  @Override
                  public void request(int numMessages) {}

                  @Override
                  public void halfClose() {}

                  @Override
                  public void sendMessage(Color message) {}
                });

    pool = ChannelPool.create(ChannelPoolSettings.staticallySized(1), channelFactory, null, null);

    int iterations = 100;
    java.util.concurrent.ExecutorService executor =
        java.util.concurrent.Executors.newFixedThreadPool(2);
    try {
      for (int i = 0; i < iterations; i++) {
        ClientCall<Color, Money> call = pool.newCall(METHOD_RECOGNIZE, CallOptions.DEFAULT);
        java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(2);
        java.util.concurrent.Future<?> f1 =
            executor.submit(
                () -> {
                  try {
                    barrier.await();
                    call.start(new ClientCall.Listener<Money>() {}, new io.grpc.Metadata());
                  } catch (Exception ignored) {
                  }
                });
        java.util.concurrent.Future<?> f2 =
            executor.submit(
                () -> {
                  try {
                    barrier.await();
                    call.cancel("cancel", null);
                  } catch (Exception ignored) {
                  }
                });
        f1.get(5, java.util.concurrent.TimeUnit.SECONDS);
        f2.get(5, java.util.concurrent.TimeUnit.SECONDS);
      }
    } finally {
      executor.shutdownNow();
    }

    // Rotate pool: initial channel must shut down cleanly, proving outstandingRpcs == 0 (no leaks
    // or negative counts)
    pool.refresh();
    Mockito.verify(initial).shutdown();
  }

  @Test
  void cancel_whenStartedAndSuperCancelThrows_doesNotReleasePrematurelyUntilOnClose()
      throws Exception {
    ManagedChannel initial = Mockito.mock(ManagedChannel.class);
    ManagedChannel replacement = Mockito.mock(ManagedChannel.class);
    @SuppressWarnings("unchecked")
    ClientCall<Color, Money> delegateCall = Mockito.mock(ClientCall.class);
    @SuppressWarnings("unchecked")
    ArgumentCaptor<ClientCall.Listener<Money>> listenerCaptor =
        ArgumentCaptor.forClass(ClientCall.Listener.class);
    Mockito.doThrow(new RuntimeException("cancel failure"))
        .when(delegateCall)
        .cancel(Mockito.any(), Mockito.any());
    Mockito.when(initial.newCall(Mockito.eq(METHOD_RECOGNIZE), Mockito.any()))
        .thenReturn(delegateCall);

    java.util.concurrent.atomic.AtomicInteger createCount =
        new java.util.concurrent.atomic.AtomicInteger(0);
    pool =
        new ChannelPool(
            ChannelPoolSettings.staticallySized(1),
            () -> createCount.getAndIncrement() == 0 ? initial : replacement,
            FixedExecutorProvider.create(Mockito.mock(ScheduledExecutorService.class)),
            null);

    ClientCall<Color, Money> call = pool.newCall(METHOD_RECOGNIZE, CallOptions.DEFAULT);
    call.start(new ClientCall.Listener<Money>() {}, new Metadata());
    Mockito.verify(delegateCall).start(listenerCaptor.capture(), Mockito.any());

    assertThrows(RuntimeException.class, () -> call.cancel("abort", null));

    // Rotate pool while call is still active (onClose hasn't fired yet):
    // initial channel must NOT be shut down yet because call is still active
    pool.refreshAll();
    Mockito.verify(initial, Mockito.never()).shutdown();

    // Once onClose fires, entry is released and initial channel shuts down
    listenerCaptor.getValue().onClose(Status.CANCELLED, new Metadata());
    Mockito.verify(initial).shutdown();
  }

  @Test
  void start_whenCalledTwice_throwsIllegalStateExceptionAndDoesNotReleaseFirstCallEntry()
      throws Exception {
    ManagedChannel initial = Mockito.mock(ManagedChannel.class);
    ManagedChannel replacement = Mockito.mock(ManagedChannel.class);
    @SuppressWarnings("unchecked")
    ClientCall<Color, Money> delegateCall = Mockito.mock(ClientCall.class);
    @SuppressWarnings("unchecked")
    ArgumentCaptor<ClientCall.Listener<Money>> listenerCaptor =
        ArgumentCaptor.forClass(ClientCall.Listener.class);
    Mockito.when(initial.newCall(Mockito.eq(METHOD_RECOGNIZE), Mockito.any()))
        .thenReturn(delegateCall);

    java.util.concurrent.atomic.AtomicInteger createCount =
        new java.util.concurrent.atomic.AtomicInteger(0);
    pool =
        new ChannelPool(
            ChannelPoolSettings.staticallySized(1),
            () -> createCount.getAndIncrement() == 0 ? initial : replacement,
            FixedExecutorProvider.create(Mockito.mock(ScheduledExecutorService.class)),
            null);

    ClientCall<Color, Money> call = pool.newCall(METHOD_RECOGNIZE, CallOptions.DEFAULT);
    call.start(new ClientCall.Listener<Money>() {}, new Metadata());
    Mockito.verify(delegateCall).start(listenerCaptor.capture(), Mockito.any());

    // Duplicate start() must throw IllegalStateException without releasing the entry
    assertThrows(
        IllegalStateException.class,
        () -> call.start(new ClientCall.Listener<Money>() {}, new Metadata()));

    pool.refreshAll();
    Mockito.verify(initial, Mockito.never()).shutdown();

    listenerCaptor.getValue().onClose(Status.OK, new Metadata());
    Mockito.verify(initial).shutdown();
  }
}
