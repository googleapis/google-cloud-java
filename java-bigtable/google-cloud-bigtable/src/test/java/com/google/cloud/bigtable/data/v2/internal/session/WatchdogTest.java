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
import com.google.bigtable.v2.OpenSessionRequest;
import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.PeerInfo.TransportType;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import com.google.cloud.bigtable.data.v2.internal.session.Session.SessionState;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolImpl.Watchdog;
import com.google.cloud.bigtable.data.v2.internal.session.fake.FakeClock;
import com.google.protobuf.Message;
import io.grpc.Metadata;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WatchdogTest {
  private final Duration interval = Duration.ofMinutes(5);
  private BigtableTimer timer;
  private SessionPoolImpl.Watchdog watchdog;
  private SessionList sessions;
  private FakeSession fakeSession = new FakeSession();

  private Instant now;
  private FakeClock fakeClock;

  @BeforeEach
  void setUp() {
    // run() is invoked synchronously in tests; the timer is wired in only so the constructor
    // signature is satisfied. start() / close() are not exercised here.
    timer = new NoOpBigtableTimer();

    now = Instant.now();
    fakeClock = new FakeClock(now);
    sessions = new SessionList();
    watchdog =
        new Watchdog(
            new Object(),
            timer,
            interval,
            sessions,
            NoopMetrics.NoopDebugTracer.INSTANCE,
            fakeClock);
  }

  // A BigtableTimer that drops every newTimeout(). Used because awaitCloseTest drives the watchdog
  // by calling run() directly; the scheduling layer is not under test.
  private static final class NoOpBigtableTimer implements BigtableTimer {
    @Override
    public Timeout newTimeout(Runnable task, long delay, TimeUnit unit) {
      return new Timeout() {
        @Override
        public boolean cancel() {
          return false;
        }

        @Override
        public boolean isCancelled() {
          return true;
        }
      };
    }

    @Override
    public void stop() {}
  }

  @Test
  public void awaitCloseTest() {
    fakeSession.lastStateChange = fakeClock.instant();

    fakeSession.state = SessionState.STARTING;
    SessionList.SessionHandle handle = sessions.newHandle(fakeSession);

    fakeSession.state = SessionState.READY;
    handle.onSessionStarted();

    fakeSession.state = SessionState.WAIT_SERVER_CLOSE;
    handle.onSessionClosing();

    watchdog.run();
    assertThat(fakeSession.forceCloseReason).isNull();

    fakeClock.increment(interval.plus(Duration.ofNanos(1)));
    watchdog.run();

    assertThat(fakeSession.forceCloseReason).isNotNull();
    assertThat(fakeSession.forceCloseReason.getDescription())
        .contains("awaiting close for too long");
  }

  private static class FakeSession implements Session {
    private static final String sessionName = "fake-session";
    private SessionState state = SessionState.NEW;
    private Instant lastStateChange = Instant.now();
    private CloseSessionRequest forceCloseReason = null;

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
    public SessionState getState() {
      return state;
    }

    @Override
    public Instant getLastStateChange() {
      return lastStateChange;
    }

    @Override
    public String getLogName() {
      return sessionName;
    }

    @Override
    public Instant getNextHeartbeat() {
      return Instant.now().plus(Duration.ofMinutes(5));
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
    public void start(OpenSessionRequest req, Metadata headers, Listener sessionListener) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void close(CloseSessionRequest req) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void forceClose(CloseSessionRequest reason) {
      forceCloseReason = reason;
    }

    @Override
    public <OpenReqT extends Message, ReqT extends Message, RespT extends Message>
        VRpc<ReqT, RespT> newCall(VRpcDescriptor<OpenReqT, ReqT, RespT> descriptor)
            throws IllegalStateException {
      throw new UnsupportedOperationException();
    }
  }
}
