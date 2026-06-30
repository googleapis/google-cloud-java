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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.bigtable.v2.FakeSessionGrpc;
import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.SessionRequest;
import com.google.bigtable.v2.SessionResponse;
import com.google.cloud.bigtable.data.v2.internal.channels.SessionStream.Listener;
import com.google.cloud.bigtable.data.v2.internal.csm.Metrics;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FallbackChannelPoolTest {
  @Mock private ChannelPool primary;
  @Mock private ChannelPool secondary;
  @Mock private ScheduledExecutorService exec;
  @Mock private ScheduledFuture<?> future;
  @Mock private SessionStream primaryStream;
  @Mock private SessionStream secondaryStream;
  @Mock private Listener listener;
  @Captor ArgumentCaptor<Listener> listenerCaptor;
  private Map<SessionStream, Integer> invocationCount;

  private static final MethodDescriptor<SessionRequest, SessionResponse> methodDescriptor =
      FakeSessionGrpc.getOpenSessionMethod();

  private FallbackConfiguration config;
  private FallbackChannelPool pool;
  private Runnable checkTask;
  private Metrics metrics;

  @BeforeEach
  void setUp() {
    invocationCount = new HashMap<>();
    config =
        FallbackConfiguration.builder()
            .setEnabled(true)
            .setErrorRate(0.5)
            .setCheckInterval(Duration.ofSeconds(10))
            .setPrimary("Primary", primary)
            .setFallback("Fallback", secondary)
            .build();

    // Capture the runnable passed to schedule
    when(exec.schedule(any(Runnable.class), anyLong(), any(TimeUnit.class)))
        .thenAnswer(
            invocation -> {
              checkTask = invocation.getArgument(0);
              return future;
            });

    lenient().when(primary.newStream(any(), any())).thenReturn(primaryStream);
    lenient().when(secondary.newStream(any(), any())).thenReturn(secondaryStream);

    metrics = new NoopMetrics();
    pool = new FallbackChannelPool(config, metrics.getPoolFallbackListener(), exec);
  }

  @AfterEach
  void tearDown() {
    pool.close();
    metrics.close();
  }

  // Makes a call on the fallback channel pool, verifies the `stream` mock got the
  // invocation.
  private Listener openSessionGetListener(SessionStream stream) {
    Integer count = invocationCount.getOrDefault(stream, 0);
    count++;
    invocationCount.put(stream, count);

    SessionStream s = pool.newStream(methodDescriptor, CallOptions.DEFAULT);
    s.start(listener, new Metadata());
    verify(stream, times(count)).start(listenerCaptor.capture(), any());
    return listenerCaptor.getValue();
  }

  // Makes a call on the fallback channel pool, verifies the `stream` mock got the
  // invocation and
  // opens session successfully.
  private void openSessionSuccessfully(SessionStream stream) {
    openSessionGetListener(stream).onBeforeSessionStart(PeerInfo.getDefaultInstance());
  }

  // Makes a call on the fallback channel pool, verifies the `stream` mock got the
  // invocation and
  // terminates the call with the `status`.
  private void openSessionWithError(SessionStream stream, Status status) {
    openSessionGetListener(stream).onClose(status, new Metadata());
  }

  @Test
  void testLifecycle() {
    pool.start();
    verify(primary).start();
    verify(secondary).start();
    verify(exec)
        .schedule(
            any(Runnable.class),
            eq(config.getCheckInterval().toMillis()),
            eq(TimeUnit.MILLISECONDS));

    pool.close();
    verify(primary).close();
    verify(secondary).close();
    verify(future).cancel(false);
  }

  @Test
  void testRoutesToPrimaryByDefault() {
    pool.start();
    SessionStream stream = pool.newStream(methodDescriptor, CallOptions.DEFAULT);

    verify(primary).newStream(any(), any());
    verify(secondary, never()).newStream(any(), any());

    // Verify delegation
    stream.sendMessage(null);
    verify(primaryStream).sendMessage(null);
  }

  @Test
  void testFallbackTrigger() {
    pool.start();

    // 1. Success
    openSessionSuccessfully(primaryStream);

    // 2. Failure
    openSessionWithError(primaryStream, Status.UNAVAILABLE);

    // Current stats: 1 success, 1 failure. Total 2. Rate 0.5.
    // Config error rate is 0.5. So 0.5 >= 0.5 is true. Should switch.

    checkTask.run(); // Execute check

    // Next stream should go to secondary
    SessionStream stream = pool.newStream(methodDescriptor, CallOptions.DEFAULT);
    verify(secondary).newStream(any(), any());

    // Verify delegation
    stream.sendMessage(null);
    verify(secondaryStream).sendMessage(null);
  }

  @Test
  void testForceCloseDoesNotCountAsFailure() {
    pool.start();

    SessionStream stream = pool.newStream(methodDescriptor, CallOptions.DEFAULT);
    stream.start(listener, new Metadata());

    verify(primaryStream).start(listenerCaptor.capture(), any());
    Listener primaryListener = listenerCaptor.getValue();
    primaryListener.onBeforeSessionStart(PeerInfo.getDefaultInstance());

    stream.forceClose("test", null);
    primaryListener.onClose(Status.CANCELLED, new Metadata());

    // 1 success, 0 failure (ignored).
    // Should not fallback.

    checkTask.run();

    pool.newStream(methodDescriptor, CallOptions.DEFAULT);
    verify(secondary, never()).newStream(any(), any());
  }

  @Test
  void testPeerInfoIgnoresFailures() {
    pool.start();

    Listener primaryListener = openSessionGetListener(primaryStream);
    primaryListener.onBeforeSessionStart(PeerInfo.getDefaultInstance());

    primaryListener.onClose(Status.UNAVAILABLE, new Metadata());

    // 1 success, 0 failure (ignored).
    // Should not fallback.

    checkTask.run();

    pool.newStream(methodDescriptor, CallOptions.DEFAULT);
    verify(secondary, never()).newStream(any(), any());
  }

  @Test
  void testStartExceptionCountsAsFailure() {
    doThrow(new RuntimeException("boom")).when(primaryStream).start(any(), any());

    pool.start();
    SessionStream stream = pool.newStream(methodDescriptor, CallOptions.DEFAULT);

    try {
      stream.start(listener, new Metadata());
    } catch (RuntimeException e) {
      // expected
    }

    // 1 failure. Rate 1.0 > 0.5.
    checkTask.run();

    pool.newStream(methodDescriptor, CallOptions.DEFAULT);
    verify(secondary).newStream(any(), any());
  }

  @Test
  void testUpdateConfigChangesInterval() {
    pool.start();
    verify(exec)
        .schedule(
            any(Runnable.class),
            eq(config.getCheckInterval().toMillis()),
            eq(TimeUnit.MILLISECONDS));

    Duration newInterval = Duration.ofSeconds(20);
    FallbackConfiguration newConfig = config.toBuilder().setCheckInterval(newInterval).build();
    pool.updateConfig(newConfig);

    // checkTask.run() should reschedule with the new interval
    checkTask.run();
    verify(exec)
        .schedule(any(Runnable.class), eq(newInterval.toMillis()), eq(TimeUnit.MILLISECONDS));
  }

  @Test
  void testUpdateConfigDisablesFallback() {
    pool.start();
    // Trigger fallback
    openSessionWithError(primaryStream, Status.UNAVAILABLE);

    checkTask.run(); // Now using secondary

    pool.newStream(methodDescriptor, CallOptions.DEFAULT);
    verify(secondary).newStream(any(), any());

    // Disable fallback
    FallbackConfiguration disabledConfig = config.toBuilder().setEnabled(false).build();
    pool.updateConfig(disabledConfig);

    // Should switch back to primary
    pool.newStream(methodDescriptor, CallOptions.DEFAULT);
    verify(primary, times(2)).newStream(any(), any());

    // Even with failures, should not switch to secondary anymore
    openSessionWithError(primaryStream, Status.UNAVAILABLE);

    checkTask.run();
    pool.newStream(methodDescriptor, CallOptions.DEFAULT);
    verify(secondary, times(1)).newStream(any(), any()); // Still 1 from before
  }

  @Test
  void testUpdateConfigChangesErrorRate() {
    pool.start();
    // One failure and one success = 50%
    openSessionWithError(primaryStream, Status.UNAVAILABLE);
    openSessionSuccessfully(primaryStream);

    // Update error rate to be higher
    FallbackConfiguration newConfig = config.toBuilder().setErrorRate(0.6).build();
    pool.updateConfig(newConfig);

    checkTask.run();
    // 0.5 < 0.6, so should NOT switch
    pool.newStream(methodDescriptor, CallOptions.DEFAULT);
    verify(secondary, never()).newStream(any(), any());

    // Update to a lower error rate
    newConfig = config.toBuilder().setErrorRate(0.5).build();
    pool.updateConfig(newConfig);

    // One failure and one success = 50%
    openSessionWithError(primaryStream, Status.UNAVAILABLE);
    openSessionSuccessfully(primaryStream);

    checkTask.run();
    // 0.5 >= 0.5, so should switch
    pool.newStream(methodDescriptor, CallOptions.DEFAULT);
    verify(secondary).newStream(any(), any());
  }

  @Test
  void testUpdateConfigEnablesFallback() {
    FallbackConfiguration disabledConfig = config.toBuilder().setEnabled(false).build();
    pool = new FallbackChannelPool(disabledConfig, metrics.getPoolFallbackListener(), exec);

    pool.start();
    // Primary failure
    openSessionWithError(primaryStream, Status.UNAVAILABLE);
    // Current error rate 1.0

    checkTask.run();
    // Fallback is disabled, should NOT switch
    pool.newStream(methodDescriptor, CallOptions.DEFAULT);
    verify(secondary, never()).newStream(any(), any());

    // Update config to enable fallback
    FallbackConfiguration newConfig = config.toBuilder().setEnabled(true).build();
    pool.updateConfig(newConfig);

    // Primary failure
    openSessionWithError(primaryStream, Status.UNAVAILABLE);
    // Current error rate 1.0

    checkTask.run();
    // 1.0 > 0.5, so should switch
    pool.newStream(methodDescriptor, CallOptions.DEFAULT);
    verify(secondary).newStream(any(), any());
  }

  @Test
  void testRescheduleAfterCheck() {
    pool.start();
    verify(exec, times(1)).schedule(any(Runnable.class), anyLong(), any(TimeUnit.class));

    checkTask.run();
    verify(exec, times(2)).schedule(any(Runnable.class), anyLong(), any(TimeUnit.class));

    checkTask.run();
    verify(exec, times(3)).schedule(any(Runnable.class), anyLong(), any(TimeUnit.class));
  }
}
