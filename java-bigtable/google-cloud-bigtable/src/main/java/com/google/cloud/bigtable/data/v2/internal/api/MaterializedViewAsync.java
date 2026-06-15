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
import com.google.bigtable.v2.OpenMaterializedViewRequest;
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

public class MaterializedViewAsync implements AutoCloseable, Closeable {

  private final TableBase base;

  public static MaterializedViewAsync createAndStart(
      FeatureFlags featureFlags,
      ClientInfo clientInfo,
      ClientConfigurationManager configManager,
      ChannelPool channelPool,
      CallOptions callOptions,
      String viewId,
      OpenMaterializedViewRequest.Permission permission,
      Metrics metrics,
      ScheduledExecutorService executorService) {

    MaterializedViewName viewName =
        MaterializedViewName.builder()
            .setProjectId(clientInfo.getInstanceName().getProjectId())
            .setInstanceId(clientInfo.getInstanceName().getInstanceId())
            .setMaterializedViewId(viewId)
            .build();

    OpenMaterializedViewRequest openReq =
        OpenMaterializedViewRequest.newBuilder()
            .setMaterializedViewName(viewName.toString())
            .setAppProfileId(clientInfo.getAppProfileId())
            .setPermission(permission)
            .build();

    TableBase base =
        TableBase.createAndStart(
            openReq,
            VRpcDescriptor.MATERIALIZED_VIEW_SESSION,
            VRpcDescriptor.READ_ROW_MAT_VIEW,
            null,
            featureFlags,
            clientInfo,
            configManager,
            channelPool,
            callOptions,
            viewId,
            metrics,
            executorService);

    return new MaterializedViewAsync(base);
  }

  MaterializedViewAsync(TableBase base) {
    this.base = base;
  }

  public SessionPool<?> getSessionPool() {
    return base.getSessionPool();
  }

  @Override
  public void close() {
    base.close();
  }

  public CompletableFuture<SessionReadRowResponse> readRow(
      SessionReadRowRequest req, Deadline deadline) {
    UnaryResponseFuture<SessionReadRowResponse> f = new UnaryResponseFuture<>();
    base.readRow(req, f, deadline);
    return f;
  }
}
