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

import com.google.bigtable.v2.FeatureFlags;
import com.google.bigtable.v2.OpenAuthorizedViewRequest;
import com.google.bigtable.v2.OpenAuthorizedViewRequest.Permission;
import com.google.bigtable.v2.SessionMutateRowRequest;
import com.google.bigtable.v2.SessionMutateRowResponse;
import com.google.bigtable.v2.SessionReadRowRequest;
import com.google.bigtable.v2.SessionReadRowResponse;
import com.google.cloud.bigtable.data.v2.internal.channels.ChannelPool;
import com.google.cloud.bigtable.data.v2.internal.csm.Metrics;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcDescriptor;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import io.grpc.CallOptions;
import io.grpc.Deadline;
import java.io.Closeable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledExecutorService;

public class AuthorizedViewAsync implements AutoCloseable, Closeable {

  private final TableBase base;

  static AuthorizedViewAsync createAndStart(
      FeatureFlags featureFlags,
      ClientInfo clientInfo,
      ClientConfigurationManager configManager,
      ChannelPool channelPool,
      CallOptions callOptions,
      String tableId,
      String viewId,
      Permission permission,
      Metrics metrics,
      ScheduledExecutorService executorService) {

    AuthorizedViewName viewName =
        AuthorizedViewName.builder()
            .setProjectId(clientInfo.getInstanceName().getProjectId())
            .setInstanceId(clientInfo.getInstanceName().getInstanceId())
            .setTableId(tableId)
            .setAuthorizedViewId(viewId)
            .build();

    OpenAuthorizedViewRequest openRequest =
        OpenAuthorizedViewRequest.newBuilder()
            .setAuthorizedViewName(viewName.toString())
            .setAppProfileId(clientInfo.getAppProfileId())
            .setPermission(permission)
            .build();

    TableBase base =
        TableBase.createAndStart(
            openRequest,
            VRpcDescriptor.AUTHORIZED_VIEW_SESSION,
            VRpcDescriptor.READ_ROW_AUTH_VIEW,
            VRpcDescriptor.MUTATE_ROW_AUTH_VIEW,
            featureFlags,
            clientInfo,
            configManager,
            channelPool,
            callOptions,
            viewName.toString(),
            metrics,
            executorService);

    return new AuthorizedViewAsync(base);
  }

  AuthorizedViewAsync(TableBase viewBase) {
    this.base = viewBase;
  }

  public SessionPool<?> getSessionPool() {
    return base.getSessionPool();
  }

  public CompletableFuture<SessionReadRowResponse> readRow(
      SessionReadRowRequest req, Deadline deadline) {
    UnaryResponseFuture<SessionReadRowResponse> f = new UnaryResponseFuture<>();
    base.readRow(req, f, deadline);
    return f;
  }

  public CompletableFuture<SessionMutateRowResponse> mutateRow(
      SessionMutateRowRequest req, Deadline deadline) {
    UnaryResponseFuture<SessionMutateRowResponse> f = new UnaryResponseFuture<>();
    base.mutateRow(req, f, deadline);
    return f;
  }

  @Override
  public void close() {
    this.base.close();
  }
}
