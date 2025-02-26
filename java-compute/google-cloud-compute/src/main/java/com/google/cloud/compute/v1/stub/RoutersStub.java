/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RoutersClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.GetNatMappingInfoPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.ListBgpRoutesPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.ListPagedResponse;
import static com.google.cloud.compute.v1.RoutersClient.ListRoutePoliciesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListRoutersRequest;
import com.google.cloud.compute.v1.DeleteRoutePolicyRouterRequest;
import com.google.cloud.compute.v1.DeleteRouterRequest;
import com.google.cloud.compute.v1.GetNatIpInfoRouterRequest;
import com.google.cloud.compute.v1.GetNatMappingInfoRoutersRequest;
import com.google.cloud.compute.v1.GetRoutePolicyRouterRequest;
import com.google.cloud.compute.v1.GetRouterRequest;
import com.google.cloud.compute.v1.GetRouterStatusRouterRequest;
import com.google.cloud.compute.v1.InsertRouterRequest;
import com.google.cloud.compute.v1.ListBgpRoutesRoutersRequest;
import com.google.cloud.compute.v1.ListRoutePoliciesRoutersRequest;
import com.google.cloud.compute.v1.ListRoutersRequest;
import com.google.cloud.compute.v1.NatIpInfoResponse;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRoutePolicyRouterRequest;
import com.google.cloud.compute.v1.PatchRouterRequest;
import com.google.cloud.compute.v1.PreviewRouterRequest;
import com.google.cloud.compute.v1.Router;
import com.google.cloud.compute.v1.RouterAggregatedList;
import com.google.cloud.compute.v1.RouterList;
import com.google.cloud.compute.v1.RouterStatusResponse;
import com.google.cloud.compute.v1.RoutersGetRoutePolicyResponse;
import com.google.cloud.compute.v1.RoutersListBgpRoutes;
import com.google.cloud.compute.v1.RoutersListRoutePolicies;
import com.google.cloud.compute.v1.RoutersPreviewResponse;
import com.google.cloud.compute.v1.UpdateRoutePolicyRouterRequest;
import com.google.cloud.compute.v1.UpdateRouterRequest;
import com.google.cloud.compute.v1.VmEndpointNatMappingsList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Routers service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RoutersStub implements BackgroundResource {

  public UnaryCallable<AggregatedListRoutersRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<AggregatedListRoutersRequest, RouterAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<DeleteRouterRequest, Operation, Operation> deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteRouterRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public OperationCallable<DeleteRoutePolicyRouterRequest, Operation, Operation>
      deleteRoutePolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteRoutePolicyOperationCallable()");
  }

  public UnaryCallable<DeleteRoutePolicyRouterRequest, Operation> deleteRoutePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRoutePolicyCallable()");
  }

  public UnaryCallable<GetRouterRequest, Router> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetNatIpInfoRouterRequest, NatIpInfoResponse> getNatIpInfoCallable() {
    throw new UnsupportedOperationException("Not implemented: getNatIpInfoCallable()");
  }

  public UnaryCallable<GetNatMappingInfoRoutersRequest, GetNatMappingInfoPagedResponse>
      getNatMappingInfoPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: getNatMappingInfoPagedCallable()");
  }

  public UnaryCallable<GetNatMappingInfoRoutersRequest, VmEndpointNatMappingsList>
      getNatMappingInfoCallable() {
    throw new UnsupportedOperationException("Not implemented: getNatMappingInfoCallable()");
  }

  public UnaryCallable<GetRoutePolicyRouterRequest, RoutersGetRoutePolicyResponse>
      getRoutePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getRoutePolicyCallable()");
  }

  public UnaryCallable<GetRouterStatusRouterRequest, RouterStatusResponse>
      getRouterStatusCallable() {
    throw new UnsupportedOperationException("Not implemented: getRouterStatusCallable()");
  }

  public OperationCallable<InsertRouterRequest, Operation, Operation> insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertRouterRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListRoutersRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListRoutersRequest, RouterList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<ListBgpRoutesRoutersRequest, ListBgpRoutesPagedResponse>
      listBgpRoutesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBgpRoutesPagedCallable()");
  }

  public UnaryCallable<ListBgpRoutesRoutersRequest, RoutersListBgpRoutes> listBgpRoutesCallable() {
    throw new UnsupportedOperationException("Not implemented: listBgpRoutesCallable()");
  }

  public UnaryCallable<ListRoutePoliciesRoutersRequest, ListRoutePoliciesPagedResponse>
      listRoutePoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRoutePoliciesPagedCallable()");
  }

  public UnaryCallable<ListRoutePoliciesRoutersRequest, RoutersListRoutePolicies>
      listRoutePoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRoutePoliciesCallable()");
  }

  public OperationCallable<PatchRouterRequest, Operation, Operation> patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchRouterRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public OperationCallable<PatchRoutePolicyRouterRequest, Operation, Operation>
      patchRoutePolicyOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchRoutePolicyOperationCallable()");
  }

  public UnaryCallable<PatchRoutePolicyRouterRequest, Operation> patchRoutePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: patchRoutePolicyCallable()");
  }

  public UnaryCallable<PreviewRouterRequest, RoutersPreviewResponse> previewCallable() {
    throw new UnsupportedOperationException("Not implemented: previewCallable()");
  }

  public OperationCallable<UpdateRouterRequest, Operation, Operation> updateOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateOperationCallable()");
  }

  public UnaryCallable<UpdateRouterRequest, Operation> updateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCallable()");
  }

  public OperationCallable<UpdateRoutePolicyRouterRequest, Operation, Operation>
      updateRoutePolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateRoutePolicyOperationCallable()");
  }

  public UnaryCallable<UpdateRoutePolicyRouterRequest, Operation> updateRoutePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRoutePolicyCallable()");
  }

  @Override
  public abstract void close();
}
