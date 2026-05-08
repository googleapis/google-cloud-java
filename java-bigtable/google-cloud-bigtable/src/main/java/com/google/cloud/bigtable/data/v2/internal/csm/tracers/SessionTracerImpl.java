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

package com.google.cloud.bigtable.data.v2.internal.csm.tracers;

import com.google.bigtable.v2.CloseSessionRequest.CloseSessionReason;
import com.google.bigtable.v2.PeerInfo;
import com.google.cloud.bigtable.data.v2.internal.channels.SessionStream;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry.RecorderRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.ClientSessionDuration.SessionCloseVRpcState;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolInfo;
import com.google.common.base.Stopwatch;
import io.grpc.Status;
import io.grpc.Status.Code;

public class SessionTracerImpl implements SessionTracer {
  private final RecorderRegistry metricRegistry;
  private final SessionPoolInfo poolInfo;

  private final Stopwatch uptime = Stopwatch.createUnstarted();

  private enum State {
    New,
    Ready,
    Closed
  }

  private volatile State state = State.New;
  private volatile boolean hasOkRpcs = false;
  private volatile boolean hasErrorRpcs = false;
  private volatile PeerInfo lastPeerInfo = SessionStream.DISCONNECTED_PEER_INFO;

  public SessionTracerImpl(RecorderRegistry metricRegistry, SessionPoolInfo sessionInfo) {
    this.metricRegistry = metricRegistry;
    this.poolInfo = sessionInfo;
  }

  @Override
  public void onStart() {
    uptime.start();
  }

  @Override
  public void onOpen(PeerInfo peerInfo) {
    state = State.Ready;
    lastPeerInfo = peerInfo;

    metricRegistry.sessionOpenLatency.record(poolInfo, peerInfo, Status.Code.OK, uptime.elapsed());
  }

  @Override
  public void onVRpcClose(Status.Code code) {
    if (code == Code.OK) {
      hasOkRpcs = true;
    } else {
      hasErrorRpcs = true;
    }
  }

  @Override
  public void onClose(PeerInfo peerInfo, CloseSessionReason reason, Status status) {
    lastPeerInfo = peerInfo;

    if (state == State.New) {
      metricRegistry.sessionOpenLatency.record(
          poolInfo, peerInfo, status.getCode(), uptime.elapsed());
    }

    metricRegistry.sessionDuration.record(
        poolInfo,
        peerInfo,
        status.getCode(),
        reason,
        SessionCloseVRpcState.find(hasOkRpcs, hasErrorRpcs),
        state == State.Ready,
        uptime.elapsed());

    state = State.Closed;
  }

  @Override
  public boolean recordAsyncMetrics() {
    if (state == State.Closed) {
      return false;
    }
    metricRegistry.sessionUptime.record(
        poolInfo, lastPeerInfo, state == State.Ready, uptime.elapsed());
    return true;
  }
}
