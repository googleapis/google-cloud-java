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

package com.google.cloud.bigtable.data.v2.internal.session;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.v2.CloseSessionRequest;
import com.google.bigtable.v2.ClusterInformation;
import com.google.bigtable.v2.OpenSessionRequest;
import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.PeerInfo.TransportType;
import com.google.bigtable.v2.SessionRequestStats;
import com.google.bigtable.v2.VirtualRpcResponse;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.cloud.bigtable.data.v2.internal.session.Session.SessionState;
import com.google.cloud.bigtable.data.v2.internal.session.SessionList.PoolStats;
import com.google.cloud.bigtable.data.v2.internal.session.SessionList.SessionHandle;
import com.google.protobuf.Message;
import com.google.protobuf.util.Durations;
import io.grpc.Metadata;
import java.time.Duration;
import java.time.Instant;
import org.junit.jupiter.api.Test;

class SessionListTest {
  private final FakeSession fakeSession = new FakeSession();

  private static final VRpcResult OK_RESULT =
      VRpcResult.createServerOk(
          VirtualRpcResponse.newBuilder()
              .setRpcId(1)
              .setClusterInfo(ClusterInformation.getDefaultInstance())
              .setStats(
                  SessionRequestStats.newBuilder().setBackendLatency(Durations.fromMicros(500)))
              .build());
  private static final Duration FAKE_VRPC_E2E_LATENCY = Duration.ofMillis(1);

  @Test
  void testInitialStats() {
    SessionList list = new SessionList();
    PoolStats stats = list.getStats();

    assertThat(list.getAfesWithReadySessions()).isEmpty();
    assertThat(list.getAllSessions()).isEmpty();

    assertThat(stats.getStartingCount()).isEqualTo(0);
    assertThat(stats.getReadyCount()).isEqualTo(0);
    assertThat(stats.getInUseCount()).isEqualTo(0);
    assertThat(stats.getExpectedCapacity()).isEqualTo(0);
  }

  @Test
  void testInitialToStarting() {
    SessionList list = new SessionList();
    PoolStats stats = list.getStats();

    fakeSession.state = SessionState.STARTING;
    list.newHandle(fakeSession);

    assertThat(list.getAfesWithReadySessions()).isEmpty();
    assertThat(list.getAllSessions()).hasSize(1);

    assertThat(stats.getStartingCount()).isEqualTo(1);
    assertThat(stats.getReadyCount()).isEqualTo(0);
    assertThat(stats.getInUseCount()).isEqualTo(0);
    assertThat(stats.getExpectedCapacity()).isEqualTo(1);
  }

  @Test
  void testStartingToReady() {
    SessionList list = new SessionList();
    PoolStats stats = list.getStats();

    fakeSession.state = SessionState.STARTING;
    SessionHandle handle = list.newHandle(fakeSession);
    handle.onSessionStarted();

    assertThat(list.getAfesWithReadySessions()).hasSize(1);
    assertThat(list.getAfesWithReadySessions().get(0).sessions).containsExactly(handle);
    assertThat(list.getAllSessions()).containsExactly(handle);

    assertThat(stats.getStartingCount()).isEqualTo(0);
    assertThat(stats.getReadyCount()).isEqualTo(1);
    assertThat(stats.getInUseCount()).isEqualTo(0);
    assertThat(stats.getExpectedCapacity()).isEqualTo(1);
  }

  // TODO: StartingToGoAway? or to REMOVED

  @Test
  void testReadyToInUse() {
    SessionList list = new SessionList();
    PoolStats stats = list.getStats();

    fakeSession.state = SessionState.STARTING;
    SessionHandle handle = list.newHandle(fakeSession);

    fakeSession.state = SessionState.READY;
    handle.onSessionStarted();

    handle = list.checkoutSession(list.getAfesWithReadySessions().get(0)).get();

    assertThat(list.getAfesWithReadySessions()).isEmpty();
    assertThat(list.getAllSessions()).containsExactly(handle);

    assertThat(stats.getStartingCount()).isEqualTo(0);
    assertThat(stats.getReadyCount()).isEqualTo(0);
    assertThat(stats.getInUseCount()).isEqualTo(1);
    assertThat(stats.getExpectedCapacity()).isEqualTo(1);
  }

  @Test
  void testReadyInUseToIdle() {
    SessionList list = new SessionList();
    PoolStats stats = list.getStats();

    fakeSession.state = SessionState.STARTING;
    SessionHandle handle = list.newHandle(fakeSession);

    fakeSession.state = SessionState.READY;
    handle.onSessionStarted();

    handle = list.checkoutSession(list.getAfesWithReadySessions().get(0)).get();
    handle.onVRpcFinish(FAKE_VRPC_E2E_LATENCY, OK_RESULT);

    assertThat(list.getAfesWithReadySessions().get(0).sessions).containsExactly(handle);
    assertThat(list.getAllSessions()).containsExactly(handle);

    assertThat(stats.getStartingCount()).isEqualTo(0);
    assertThat(stats.getReadyCount()).isEqualTo(1);
    assertThat(stats.getInUseCount()).isEqualTo(0);
    assertThat(stats.getExpectedCapacity()).isEqualTo(1);
  }

  @Test
  void testReadyIdleToSoftClosing() {
    SessionList list = new SessionList();
    PoolStats stats = list.getStats();

    fakeSession.state = SessionState.STARTING;
    SessionHandle handle = list.newHandle(fakeSession);

    fakeSession.state = SessionState.READY;
    handle.onSessionStarted();

    // idle session after a goaway skips CLOSING
    fakeSession.state = SessionState.WAIT_SERVER_CLOSE;
    handle.onSessionClosing();

    assertThat(list.getAfesWithReadySessions()).isEmpty();
    assertThat(list.getAllSessions()).containsExactly(handle);

    assertThat(stats.getStartingCount()).isEqualTo(0);
    assertThat(stats.getReadyCount()).isEqualTo(0);
    assertThat(stats.getInUseCount()).isEqualTo(0);
    assertThat(stats.getExpectedCapacity()).isEqualTo(0);
  }

  @Test
  void testReadyInUseToSoftClosing() {
    SessionList list = new SessionList();
    PoolStats stats = list.getStats();

    fakeSession.state = SessionState.STARTING;
    SessionHandle handle = list.newHandle(fakeSession);

    fakeSession.state = SessionState.READY;
    handle.onSessionStarted();

    handle = list.checkoutSession(list.getAfesWithReadySessions().get(0)).get();

    fakeSession.state = SessionState.CLOSING;
    handle.onSessionClosing();

    assertThat(list.getAfesWithReadySessions()).isEmpty();
    assertThat(list.getAllSessions()).containsExactly(handle);

    assertThat(stats.getStartingCount()).isEqualTo(0);
    assertThat(stats.getReadyCount()).isEqualTo(0);
    assertThat(stats.getInUseCount()).isEqualTo(1);
    assertThat(stats.getExpectedCapacity()).isEqualTo(0);
  }

  @Test
  void testClosingInUseToAwaitClose() {
    SessionList list = new SessionList();
    PoolStats stats = list.getStats();

    fakeSession.state = SessionState.STARTING;
    SessionHandle handle = list.newHandle(fakeSession);

    fakeSession.state = SessionState.READY;
    handle.onSessionStarted();

    handle = list.checkoutSession(list.getAfesWithReadySessions().get(0)).get();
    handle.onVRpcFinish(FAKE_VRPC_E2E_LATENCY, OK_RESULT);

    // idle ready session skips CLOSING
    fakeSession.state = SessionState.WAIT_SERVER_CLOSE;
    handle.onSessionClosing();

    assertThat(list.getAfesWithReadySessions()).isEmpty();
    assertThat(list.getAllSessions()).containsExactly(handle);

    assertThat(stats.getStartingCount()).isEqualTo(0);
    assertThat(stats.getReadyCount()).isEqualTo(0);
    assertThat(stats.getInUseCount()).isEqualTo(0);
    assertThat(stats.getExpectedCapacity()).isEqualTo(0);
  }

  @Test
  void testClosingInUseToAwaitCloseWhileRpcIsActive() {
    SessionList list = new SessionList();
    PoolStats stats = list.getStats();

    fakeSession.state = SessionState.STARTING;
    SessionHandle handle = list.newHandle(fakeSession);

    fakeSession.state = SessionState.READY;
    handle.onSessionStarted();

    handle = list.checkoutSession(list.getAfesWithReadySessions().get(0)).get();

    fakeSession.state = SessionState.CLOSING;
    handle.onSessionClosing();

    // Session will auto transition to WAIT_SERVER_CLOSE from CLOSING when vRpc finishes
    fakeSession.state = SessionState.WAIT_SERVER_CLOSE;
    handle.onVRpcFinish(FAKE_VRPC_E2E_LATENCY, OK_RESULT);

    assertThat(list.getAfesWithReadySessions()).isEmpty();
    assertThat(list.getAllSessions()).containsExactly(handle);

    assertThat(stats.getStartingCount()).isEqualTo(0);
    assertThat(stats.getReadyCount()).isEqualTo(0);
    assertThat(stats.getInUseCount()).isEqualTo(0);
    assertThat(stats.getExpectedCapacity()).isEqualTo(0);
  }

  @Test
  void testStartingToClosed() {
    SessionList list = new SessionList();
    PoolStats stats = list.getStats();

    fakeSession.state = SessionState.STARTING;
    SessionHandle handle = list.newHandle(fakeSession);

    // server killed the session before it started
    fakeSession.state = SessionState.CLOSED;
    handle.onSessionClosed(SessionState.STARTING);

    assertThat(list.getAfesWithReadySessions()).isEmpty();
    assertThat(list.getAllSessions()).isEmpty();

    assertThat(stats.getStartingCount()).isEqualTo(0);
    assertThat(stats.getReadyCount()).isEqualTo(0);
    assertThat(stats.getInUseCount()).isEqualTo(0);
    assertThat(stats.getExpectedCapacity()).isEqualTo(0);
  }

  @Test
  void testReadyIdleToClosed() {
    SessionList list = new SessionList();
    PoolStats stats = list.getStats();

    fakeSession.state = SessionState.STARTING;
    SessionHandle handle = list.newHandle(fakeSession);

    fakeSession.state = SessionState.READY;
    handle.onSessionStarted();

    fakeSession.state = SessionState.CLOSED;
    handle.onSessionClosed(SessionState.READY);

    assertThat(list.getAfesWithReadySessions()).isEmpty();
    assertThat(list.getAllSessions()).isEmpty();

    assertThat(stats.getStartingCount()).isEqualTo(0);
    assertThat(stats.getReadyCount()).isEqualTo(0);
    assertThat(stats.getInUseCount()).isEqualTo(0);
    assertThat(stats.getExpectedCapacity()).isEqualTo(0);
  }

  @Test
  void testReadyInUseToClosed() {
    SessionList list = new SessionList();
    PoolStats stats = list.getStats();

    fakeSession.state = SessionState.STARTING;
    SessionHandle handle = list.newHandle(fakeSession);

    fakeSession.state = SessionState.READY;
    handle.onSessionStarted();

    handle = list.checkoutSession(list.getAfesWithReadySessions().get(0)).get();

    fakeSession.state = SessionState.CLOSED;
    handle.onVRpcFinish(FAKE_VRPC_E2E_LATENCY, OK_RESULT);
    handle.onSessionClosed(SessionState.READY);

    assertThat(list.getAfesWithReadySessions()).isEmpty();
    assertThat(list.getAllSessions()).isEmpty();

    assertThat(stats.getStartingCount()).isEqualTo(0);
    assertThat(stats.getReadyCount()).isEqualTo(0);
    assertThat(stats.getInUseCount()).isEqualTo(0);
    assertThat(stats.getExpectedCapacity()).isEqualTo(0);
  }

  @Test
  void testClosingIdleToClosed() {
    SessionList list = new SessionList();
    PoolStats stats = list.getStats();

    fakeSession.state = SessionState.STARTING;
    SessionHandle handle = list.newHandle(fakeSession);

    fakeSession.state = SessionState.READY;
    handle.onSessionStarted();

    fakeSession.state = SessionState.WAIT_SERVER_CLOSE;
    handle.onSessionClosing();

    fakeSession.state = SessionState.CLOSED;
    handle.onSessionClosed(SessionState.WAIT_SERVER_CLOSE);

    assertThat(list.getAfesWithReadySessions()).isEmpty();
    assertThat(list.getAllSessions()).isEmpty();

    assertThat(stats.getStartingCount()).isEqualTo(0);
    assertThat(stats.getReadyCount()).isEqualTo(0);
    assertThat(stats.getInUseCount()).isEqualTo(0);
    assertThat(stats.getExpectedCapacity()).isEqualTo(0);
  }

  @Test
  void testClosingInUseToClosed() {
    SessionList list = new SessionList();
    PoolStats stats = list.getStats();

    fakeSession.state = SessionState.STARTING;
    SessionHandle handle = list.newHandle(fakeSession);

    fakeSession.state = SessionState.READY;
    handle.onSessionStarted();

    handle = list.checkoutSession(list.getAfesWithReadySessions().get(0)).get();

    fakeSession.state = SessionState.CLOSING;
    handle.onSessionClosing();

    // Simulate hard session close when a vRpc is outstanding
    fakeSession.state = SessionState.CLOSED;
    handle.onVRpcFinish(FAKE_VRPC_E2E_LATENCY, OK_RESULT);
    handle.onSessionClosed(SessionState.CLOSING);

    assertThat(list.getAfesWithReadySessions()).isEmpty();
    assertThat(list.getAllSessions()).isEmpty();

    assertThat(stats.getStartingCount()).isEqualTo(0);
    assertThat(stats.getReadyCount()).isEqualTo(0);
    assertThat(stats.getInUseCount()).isEqualTo(0);
    assertThat(stats.getExpectedCapacity()).isEqualTo(0);
  }

  @Test
  void testAwaitCloseToSoftClosed() {
    SessionList list = new SessionList();
    PoolStats stats = list.getStats();

    fakeSession.state = SessionState.STARTING;
    SessionHandle handle = list.newHandle(fakeSession);

    fakeSession.state = SessionState.READY;
    handle.onSessionStarted();

    handle = list.checkoutSession(list.getAfesWithReadySessions().get(0)).get();
    handle.onVRpcFinish(FAKE_VRPC_E2E_LATENCY, OK_RESULT);

    fakeSession.state = SessionState.WAIT_SERVER_CLOSE;
    handle.onSessionClosing();

    fakeSession.state = SessionState.CLOSED;
    handle.onSessionClosed(SessionState.WAIT_SERVER_CLOSE);

    assertThat(list.getAfesWithReadySessions()).isEmpty();
    assertThat(list.getAllSessions()).isEmpty();

    assertThat(stats.getStartingCount()).isEqualTo(0);
    assertThat(stats.getReadyCount()).isEqualTo(0);
    assertThat(stats.getInUseCount()).isEqualTo(0);
    assertThat(stats.getExpectedCapacity()).isEqualTo(0);
  }

  // Minimal impl of Session that only exposes state to test SessionList
  private static class FakeSession implements Session {
    private SessionState state = SessionState.NEW;

    @Override
    public SessionState getState() {
      return state;
    }

    @Override
    public PeerInfo getPeerInfo() {
      return PeerInfo.newBuilder()
          .setTransportType(TransportType.TRANSPORT_TYPE_SESSION_DIRECT_ACCESS)
          .setApplicationFrontendId(1234)
          .setApplicationFrontendRegion("us-east1")
          .setApplicationFrontendSubzone("xx")
          .build();
    }

    @Override
    public Instant getLastStateChange() {
      throw new UnsupportedOperationException();
    }

    @Override
    public OpenParams getOpenParams() {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean isOpenParamsUpdated() {
      return false;
    }

    @Override
    public String getLogName() {
      throw new UnsupportedOperationException();
    }

    @Override
    public Instant getNextHeartbeat() {
      return Instant.now().plus(Duration.ofMinutes(5));
    }

    @Override
    public void start(OpenSessionRequest req, Metadata headers, Listener sessionListener) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void close(CloseSessionRequest req) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void forceClose(CloseSessionRequest reason) {
      throw new UnsupportedOperationException();
    }

    @Override
    public <OpenReqT extends Message, ReqT extends Message, RespT extends Message>
        VRpc<ReqT, RespT> newCall(VRpcDescriptor<OpenReqT, ReqT, RespT> descriptor)
            throws IllegalStateException {
      throw new UnsupportedOperationException();
    }
  }
}
