/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.monitoring.dashboard.v1.stub;

import static com.google.cloud.monitoring.dashboard.v1.DashboardsServiceClient.ListDashboardsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.monitoring.dashboard.v1.CreateDashboardRequest;
import com.google.monitoring.dashboard.v1.Dashboard;
import com.google.monitoring.dashboard.v1.DeleteDashboardRequest;
import com.google.monitoring.dashboard.v1.GetDashboardRequest;
import com.google.monitoring.dashboard.v1.ListDashboardsRequest;
import com.google.monitoring.dashboard.v1.ListDashboardsResponse;
import com.google.monitoring.dashboard.v1.UpdateDashboardRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DashboardsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DashboardsServiceStub implements BackgroundResource {

  public UnaryCallable<CreateDashboardRequest, Dashboard> createDashboardCallable() {
    throw new UnsupportedOperationException("Not implemented: createDashboardCallable()");
  }

  public UnaryCallable<ListDashboardsRequest, ListDashboardsPagedResponse>
      listDashboardsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDashboardsPagedCallable()");
  }

  public UnaryCallable<ListDashboardsRequest, ListDashboardsResponse> listDashboardsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDashboardsCallable()");
  }

  public UnaryCallable<GetDashboardRequest, Dashboard> getDashboardCallable() {
    throw new UnsupportedOperationException("Not implemented: getDashboardCallable()");
  }

  public UnaryCallable<DeleteDashboardRequest, Empty> deleteDashboardCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDashboardCallable()");
  }

  public UnaryCallable<UpdateDashboardRequest, Dashboard> updateDashboardCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDashboardCallable()");
  }

  @Override
  public abstract void close();
}
