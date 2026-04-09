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

import com.google.bigtable.v2.ClusterInformation;
import com.google.bigtable.v2.PeerInfo;
import com.google.cloud.bigtable.data.v2.internal.channels.SessionStream;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry.RecorderRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.MethodInfo;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult.State;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolInfo;
import com.google.common.base.Stopwatch;
import io.grpc.Deadline;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * <pre>
 * The following events happen in an operation:
 * operation
 *   attempt start
 *     attempt waiting for session / channel
 *     rpc sent from client
 *     rpc waiting for grpc buffer to be ready
 *     receive response from server and calls back app's listener
 *   attempt finish
 *   retry wait
 *   attempt start again
 *   ...
 *   attempt finish
 * operation finish
 * </pre>
 */
public class VRpcTracerImpl implements VRpcTracer {
  private static final ClusterInformation UNKNOWN_CLUSTER =
      ClusterInformation.newBuilder().setZoneId("global").setClusterId("<unspecified>").build();

  private final RecorderRegistry metricRegistry;
  private final SessionPoolInfo poolInfo;
  private final MethodInfo methodInfo;
  private final Deadline originalDeadline;

  private final Stopwatch attemptTimer = Stopwatch.createStarted(); // per attempt
  private final Stopwatch operationTimer = Stopwatch.createStarted(); // per operation
  private final Stopwatch clientBlockingTimer = Stopwatch.createStarted(); // per attempt
  private final Stopwatch firstResponsePerOpTimer = Stopwatch.createStarted(); // per operation
  private Duration applicationBlockingLatency = Duration.ZERO; // per operation
  private long remainingDeadline; // per attempt

  private final Stopwatch applicationBlockingTimer = Stopwatch.createUnstarted();
  private ClusterInformation lastClusterInfo;
  private PeerInfo lastPeerInfo = SessionStream.DISCONNECTED_PEER_INFO;

  private int numAttempts = 0;

  public VRpcTracerImpl(
      RecorderRegistry metricRegistry,
      SessionPoolInfo poolInfo,
      MethodInfo methodInfo,
      Deadline deadline) {
    this.metricRegistry = metricRegistry;
    this.poolInfo = poolInfo;
    this.methodInfo = methodInfo;
    this.originalDeadline = deadline;
    this.lastClusterInfo = UNKNOWN_CLUSTER;
  }

  @Override
  public void onOperationStart() {}

  @Override
  public void onAttemptStart(Object req) {
    if (!attemptTimer.isRunning()) {
      attemptTimer.reset().start();
    }
    if (!clientBlockingTimer.isRunning()) {
      clientBlockingTimer.reset().start();
    }
    remainingDeadline = originalDeadline.timeRemaining(TimeUnit.MILLISECONDS);
    numAttempts++;
  }

  @Override
  public void onRequestSent(PeerInfo peerInfo) {
    this.lastPeerInfo = peerInfo;
    if (clientBlockingTimer.isRunning()) {
      clientBlockingTimer.stop();
    }
  }

  @Override
  public void onResponseReceived() {
    if (firstResponsePerOpTimer.isRunning()) {
      firstResponsePerOpTimer.stop();
    }
    if (!applicationBlockingTimer.isRunning()) {
      applicationBlockingTimer.reset().start();
    }
  }

  @Override
  public void recordApplicationBlockingLatencies(Duration elapsed) {
    applicationBlockingLatency = applicationBlockingLatency.plus(elapsed);
  }

  @Override
  public void onAttemptFinish(VRpcResult result) {
    attemptTimer.stop();

    @SuppressWarnings("AssignmentExpression")
    ClusterInformation clusterInfo =
        lastClusterInfo = Optional.ofNullable(result.getClusterInfo()).orElse(UNKNOWN_CLUSTER);

    metricRegistry.attemptLatency.record(
        poolInfo.getClientInfo(),
        poolInfo.getName(),
        clusterInfo,
        methodInfo,
        result.getStatus().getCode(),
        attemptTimer.elapsed());

    metricRegistry.attemptLatency2.record(
        poolInfo.getClientInfo(),
        poolInfo.getName(),
        lastPeerInfo,
        clusterInfo,
        methodInfo,
        result.getStatus().getCode(),
        attemptTimer.elapsed());

    // TODO: what should be server latency?
    //    metricRegistry.serverLatency.record(
    //        poolInfo, methodInfo, clusterInfo, result.getStatus(), result.getServerLatency());

    // If the result state is not SERVER_RESULT that means the vrpc failed before
    // reaching the AFE and we increment the connectivity error counter.
    metricRegistry.connectivityErrorCount.record(
        poolInfo.getClientInfo(),
        poolInfo.getName(),
        methodInfo,
        clusterInfo,
        result.getStatus().getCode(),
        (result.getState() != State.SERVER_RESULT) ? 1 : 0);

    metricRegistry.clientBlockingLatency.record(
        poolInfo.getClientInfo(),
        poolInfo.getName(),
        methodInfo,
        clusterInfo,
        clientBlockingTimer.elapsed());

    metricRegistry.remainingDeadline.record(
        poolInfo.getClientInfo(),
        poolInfo.getName(),
        methodInfo,
        clusterInfo,
        result.getStatus().getCode(),
        Duration.ofMillis(remainingDeadline));

    metricRegistry.transportLatency.record(
        poolInfo,
        lastPeerInfo,
        methodInfo,
        attemptTimer.elapsed().minus(result.getBackendLatency()));
  }

  @Override
  public void onOperationFinish(VRpcResult result) {
    metricRegistry.operationLatency.record(
        poolInfo.getClientInfo(),
        poolInfo.getName(),
        methodInfo,
        lastClusterInfo,
        result.getStatus().getCode(),
        operationTimer.elapsed());
    metricRegistry.applicationBlockingLatency.record(
        poolInfo.getClientInfo(),
        poolInfo.getName(),
        methodInfo,
        lastClusterInfo,
        applicationBlockingLatency);
    metricRegistry.firstResponseLantency.record(
        poolInfo.getClientInfo(),
        poolInfo.getName(),
        methodInfo,
        lastClusterInfo,
        result.getStatus().getCode(),
        firstResponsePerOpTimer.elapsed());
    metricRegistry.retryCount.record(
        poolInfo.getClientInfo(),
        poolInfo.getName(),
        methodInfo,
        lastClusterInfo,
        result.getStatus().getCode(),
        numAttempts - 1);
  }
}
