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
package com.google.cloud.bigtable.data.v2.internal.api;

import com.google.bigtable.v2.CloseSessionRequest;
import com.google.bigtable.v2.FeatureFlags;
import com.google.bigtable.v2.SessionMutateRowRequest;
import com.google.bigtable.v2.SessionMutateRowResponse;
import com.google.bigtable.v2.SessionReadRowRequest;
import com.google.bigtable.v2.SessionReadRowResponse;
import com.google.cloud.bigtable.data.v2.internal.channels.ChannelPool;
import com.google.cloud.bigtable.data.v2.internal.csm.Metrics;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.middleware.CancellableVRpc;
import com.google.cloud.bigtable.data.v2.internal.middleware.RetryingVRpc;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcCallContext;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcListener;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolImpl;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcDescriptor;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Message;
import io.grpc.CallOptions;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Metadata;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

class TableBase implements AutoCloseable {
  private final SessionPool<?> sessionPool;
  private final ScheduledExecutorService backgroundExecutor;
  private final Executor userCallbackExecutor;
  private final Metrics metrics;
  private final VRpcDescriptor<?, SessionReadRowRequest, SessionReadRowResponse> readRowDescriptor;
  private final VRpcDescriptor<?, SessionMutateRowRequest, SessionMutateRowResponse>
      mutateRowDescriptor;

  static <ReqT extends Message> TableBase createAndStart(
      ReqT openReq,
      VRpcDescriptor.SessionDescriptor<ReqT> sessionDescriptor,
      VRpcDescriptor<?, SessionReadRowRequest, SessionReadRowResponse> readRowDescriptor,
      VRpcDescriptor<?, SessionMutateRowRequest, SessionMutateRowResponse> mutateRowDescriptor,
      FeatureFlags featureFlags,
      ClientInfo clientInfo,
      ClientConfigurationManager configManager,
      ChannelPool channelPool,
      CallOptions callOptions,
      String sessionPoolName,
      Metrics metrics,
      ScheduledExecutorService executor) {

    SessionPool<ReqT> sessionPool =
        new SessionPoolImpl<>(
            metrics,
            featureFlags,
            clientInfo,
            configManager,
            channelPool,
            callOptions,
            sessionDescriptor,
            sessionPoolName,
            executor);

    sessionPool.start(openReq, new Metadata());

    return new TableBase(sessionPool, readRowDescriptor, mutateRowDescriptor, metrics, executor, executor);
  }

  @VisibleForTesting
  TableBase(
      SessionPool<?> sessionPool,
      VRpcDescriptor<?, SessionReadRowRequest, SessionReadRowResponse> readRowDescriptor,
      VRpcDescriptor<?, SessionMutateRowRequest, SessionMutateRowResponse> mutateRowDescriptor,
      Metrics metrics,
      ScheduledExecutorService backgroundExecutor,
      Executor userCallbackExecutor) {
    this.sessionPool = sessionPool;
    this.readRowDescriptor = readRowDescriptor;
    this.mutateRowDescriptor = mutateRowDescriptor;
    this.metrics = metrics;
    this.backgroundExecutor = backgroundExecutor;
    this.userCallbackExecutor = userCallbackExecutor;
  }

  @Override
  public void close() {
    sessionPool.close(
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionRequest.CloseSessionReason.CLOSE_SESSION_REASON_USER)
            .setDescription("user closed session")
            .build());
  }

  public SessionPool<?> getSessionPool() {
    return sessionPool;
  }

  public void readRow(
      SessionReadRowRequest req, VRpcListener<SessionReadRowResponse> listener, Deadline deadline) {
    Executor opExecutor = MoreExecutors.newSequentialExecutor(userCallbackExecutor);
    RetryingVRpc<SessionReadRowRequest, SessionReadRowResponse> retry =
        new RetryingVRpc<>(() -> sessionPool.newCall(readRowDescriptor), backgroundExecutor, opExecutor);

    VRpcTracer tracer = metrics.newTableTracer(sessionPool.getInfo(), readRowDescriptor, deadline);
    VRpcCallContext ctx = VRpcCallContext.create(deadline, true, tracer, opExecutor);

    CancellableVRpc<SessionReadRowRequest, SessionReadRowResponse> cancellableVRpc =
        new CancellableVRpc<>(retry, Context.current());

    cancellableVRpc.start(req, ctx, listener);
  }

  public void mutateRow(
      SessionMutateRowRequest req,
      VRpcListener<SessionMutateRowResponse> listener,
      Deadline deadline) {
    Executor opExecutor = MoreExecutors.newSequentialExecutor(userCallbackExecutor);
    RetryingVRpc<SessionMutateRowRequest, SessionMutateRowResponse> retry =
        new RetryingVRpc<>(
            () -> sessionPool.newCall(mutateRowDescriptor), backgroundExecutor, opExecutor);

    boolean idempotent = Util.isIdempotent(req.getMutationsList());

    VRpcTracer tracer =
        metrics.newTableTracer(sessionPool.getInfo(), mutateRowDescriptor, deadline);
    VRpcCallContext ctx = VRpcCallContext.create(deadline, idempotent, tracer, opExecutor);

    CancellableVRpc<SessionMutateRowRequest, SessionMutateRowResponse> cancellable =
        new CancellableVRpc<>(retry, Context.current());

    cancellable.start(req, ctx, listener);
  }
}
