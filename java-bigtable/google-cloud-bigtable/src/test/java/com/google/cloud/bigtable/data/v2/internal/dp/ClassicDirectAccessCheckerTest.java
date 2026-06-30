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
package com.google.cloud.bigtable.data.v2.internal.dp;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import com.google.bigtable.v2.PeerInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.Util;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DirectPathCompatibleTracer;
import com.google.cloud.bigtable.data.v2.stub.MetadataExtractorInterceptor;
import com.google.cloud.bigtable.gaxx.grpc.ChannelPrimer;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import java.util.concurrent.ScheduledExecutorService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(JUnit4.class)
public class ClassicDirectAccessCheckerTest {

  @Rule public final MockitoRule mockito = MockitoJUnit.rule();

  @Mock private ChannelPrimer mockChannelPrimer;
  @Mock private ManagedChannel mockChannel;
  @Mock private DirectPathCompatibleTracer mockTracer;
  @Mock private MetadataExtractorInterceptor mockInterceptor;
  @Mock private MetadataExtractorInterceptor.SidebandData mockSidebandData;
  @Mock private ScheduledExecutorService mockExecutor;

  private ClassicDirectAccessChecker checker;

  @Before
  public void setUp() throws Exception {
    // Pass null for the executor by default so background investigations aren't triggered
    checker = spy(new ClassicDirectAccessChecker(mockTracer, mockChannelPrimer, mockExecutor));
    doReturn(mockInterceptor).when(checker).createInterceptor();
    when(mockInterceptor.getSidebandData()).thenReturn(mockSidebandData);
  }

  @Test
  public void testEligibleForDirectAccess() {
    PeerInfo peerInfo =
        PeerInfo.newBuilder()
            .setTransportType(PeerInfo.TransportType.TRANSPORT_TYPE_DIRECT_ACCESS)
            .build();
    when(mockSidebandData.getPeerInfo()).thenReturn(peerInfo);
    when(mockSidebandData.getIpProtocol()).thenReturn(Util.IpProtocol.IPV6);

    boolean isEligible = checker.check(mockChannel);

    assertThat(isEligible).isTrue();
    verify(mockChannelPrimer).primeChannel(any(Channel.class));
    verify(mockTracer).recordSuccess(Util.IpProtocol.IPV6);
    verify(mockChannel).shutdownNow();
  }

  @Test
  public void testNotEligibleCFE() {
    PeerInfo peerInfo =
        PeerInfo.newBuilder()
            .setTransportType(PeerInfo.TransportType.TRANSPORT_TYPE_CLOUD_PATH)
            .build();
    when(mockSidebandData.getPeerInfo()).thenReturn(peerInfo);

    boolean isEligible = checker.check(mockChannel);

    assertThat(isEligible).isFalse();
    verifyNoInteractions(mockTracer); // No interactions because executor is null
    verify(mockChannel).shutdownNow();
  }

  @Test
  public void testMissingSidebandData() {
    // Override the Before setup to return null for this specific test
    when(mockInterceptor.getSidebandData()).thenReturn(null);

    boolean isEligible = checker.check(mockChannel);

    assertThat(isEligible).isFalse();
    verifyNoInteractions(mockTracer);
    verify(mockChannel).shutdownNow();
  }

  @Test
  public void testExceptionSafetyAndCleanup() {
    doThrow(new RuntimeException("Simulated primer failure"))
        .when(mockChannelPrimer)
        .primeChannel(any(Channel.class));

    boolean isEligible = checker.check(mockChannel);

    assertThat(isEligible).isFalse();
    verifyNoInteractions(mockTracer);
    verify(mockChannel).shutdownNow();
  }

  @Test
  public void testNullPeerInfoIsHandledSafely() {
    when(mockInterceptor.getSidebandData()).thenReturn(mockSidebandData);

    when(mockSidebandData.getPeerInfo()).thenReturn(null);
    boolean isEligible = checker.check(mockChannel);
    assertThat(isEligible).isFalse();
    verifyNoInteractions(mockTracer);
    verify(mockChannel).shutdownNow();
  }

  @Test
  public void testInvestigationTriggeredOnFailure() {
    // Re-instantiate the checker with a mock executor to verify investigation is scheduled
    checker = spy(new ClassicDirectAccessChecker(mockTracer, mockChannelPrimer, mockExecutor));
    doReturn(mockInterceptor).when(checker).createInterceptor();
    when(mockInterceptor.getSidebandData()).thenReturn(null); // Force a failure

    boolean isEligible = checker.check(mockChannel);

    assertThat(isEligible).isFalse();

    // Verify the checker submitted a Runnable task to the background executor
    ArgumentCaptor<Runnable> runnableCaptor = ArgumentCaptor.forClass(Runnable.class);
    verify(mockExecutor).execute(runnableCaptor.capture());

    // Execute the captured runnable to ensure it safely calls the tracer
    runnableCaptor.getValue().run();
    verify(mockTracer).recordFailure(DirectAccessInvestigator.FailureReason.UNKNOWN);
  }
}
