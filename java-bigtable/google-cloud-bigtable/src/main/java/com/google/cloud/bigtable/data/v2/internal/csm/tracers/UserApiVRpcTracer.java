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

import com.google.api.gax.tracing.ApiTracer;
import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.TableName;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolInfo;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcDescriptor;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

/* A VRpc tracer that wraps the legacy gax ApiTracer */
public class UserApiVRpcTracer implements VRpcTracer {

  private final ApiTracer delegate;
  private final AtomicInteger counter = new AtomicInteger(0);
  private final TableName tableName;
  private final String appProfileId;
  private final VRpcDescriptor descriptor;

  public UserApiVRpcTracer(
      ApiTracer apiTracer, SessionPoolInfo poolInfo, VRpcDescriptor descriptor) {
    this.delegate = apiTracer;
    this.tableName =
        TableName.newBuilder()
            .setProject(poolInfo.getClientInfo().getInstanceName().getProjectId())
            .setInstance(poolInfo.getClientInfo().getInstanceName().getInstanceId())
            .setTable(poolInfo.getName())
            .build();
    this.appProfileId = poolInfo.getClientInfo().getAppProfileId();
    this.descriptor = descriptor;
  }

  @Override
  public void onOperationStart() {}

  @Override
  public void onAttemptStart(Object req) {
    delegate.attemptStarted(
        descriptor.toLegacyProto(tableName.toString(), appProfileId, req),
        counter.getAndIncrement());
  }

  @Override
  public void onRequestSent(PeerInfo peerInfo) {
    delegate.requestSent();
  }

  @Override
  public void onResponseReceived() {
    delegate.responseReceived();
  }

  @Override
  public void recordApplicationBlockingLatencies(Duration elapsed) {}

  @Override
  public void onAttemptFinish(VRpc.VRpcResult result) {
    if (result.getStatus().isOk()) {
      delegate.attemptSucceeded();
    } else {
      delegate.attemptFailedDuration(result.getStatus().asException(), Duration.ZERO);
    }
  }

  @Override
  public void onOperationFinish(VRpc.VRpcResult result) {
    if (result.getStatus().isOk()) {
      delegate.operationSucceeded();
    } else {
      delegate.operationFailed(result.getStatus().asException());
    }
  }
}
