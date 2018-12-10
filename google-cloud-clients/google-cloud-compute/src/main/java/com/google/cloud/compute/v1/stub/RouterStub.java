/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RouterClient.AggregatedListRoutersPagedResponse;
import static com.google.cloud.compute.v1.RouterClient.GetNatMappingInfoRoutersPagedResponse;
import static com.google.cloud.compute.v1.RouterClient.ListRoutersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListRoutersHttpRequest;
import com.google.cloud.compute.v1.DeleteRouterHttpRequest;
import com.google.cloud.compute.v1.GetNatMappingInfoRoutersHttpRequest;
import com.google.cloud.compute.v1.GetRouterHttpRequest;
import com.google.cloud.compute.v1.GetRouterStatusRouterHttpRequest;
import com.google.cloud.compute.v1.InsertRouterHttpRequest;
import com.google.cloud.compute.v1.ListRoutersHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRouterHttpRequest;
import com.google.cloud.compute.v1.PreviewRouterHttpRequest;
import com.google.cloud.compute.v1.Router;
import com.google.cloud.compute.v1.RouterAggregatedList;
import com.google.cloud.compute.v1.RouterList;
import com.google.cloud.compute.v1.RouterStatusResponse;
import com.google.cloud.compute.v1.RoutersPreviewResponse;
import com.google.cloud.compute.v1.UpdateRouterHttpRequest;
import com.google.cloud.compute.v1.VmEndpointNatMappingsList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class RouterStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<AggregatedListRoutersHttpRequest, AggregatedListRoutersPagedResponse>
      aggregatedListRoutersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListRoutersPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListRoutersHttpRequest, RouterAggregatedList>
      aggregatedListRoutersCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListRoutersCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteRouterHttpRequest, Operation> deleteRouterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRouterCallable()");
  }

  @BetaApi
  public UnaryCallable<GetRouterHttpRequest, Router> getRouterCallable() {
    throw new UnsupportedOperationException("Not implemented: getRouterCallable()");
  }

  @BetaApi
  public UnaryCallable<GetNatMappingInfoRoutersHttpRequest, GetNatMappingInfoRoutersPagedResponse>
      getNatMappingInfoRoutersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getNatMappingInfoRoutersPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<GetNatMappingInfoRoutersHttpRequest, VmEndpointNatMappingsList>
      getNatMappingInfoRoutersCallable() {
    throw new UnsupportedOperationException("Not implemented: getNatMappingInfoRoutersCallable()");
  }

  @BetaApi
  public UnaryCallable<GetRouterStatusRouterHttpRequest, RouterStatusResponse>
      getRouterStatusRouterCallable() {
    throw new UnsupportedOperationException("Not implemented: getRouterStatusRouterCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertRouterHttpRequest, Operation> insertRouterCallable() {
    throw new UnsupportedOperationException("Not implemented: insertRouterCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRoutersHttpRequest, ListRoutersPagedResponse>
      listRoutersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRoutersPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRoutersHttpRequest, RouterList> listRoutersCallable() {
    throw new UnsupportedOperationException("Not implemented: listRoutersCallable()");
  }

  @BetaApi
  public UnaryCallable<PatchRouterHttpRequest, Operation> patchRouterCallable() {
    throw new UnsupportedOperationException("Not implemented: patchRouterCallable()");
  }

  @BetaApi
  public UnaryCallable<PreviewRouterHttpRequest, RoutersPreviewResponse> previewRouterCallable() {
    throw new UnsupportedOperationException("Not implemented: previewRouterCallable()");
  }

  @BetaApi
  public UnaryCallable<UpdateRouterHttpRequest, Operation> updateRouterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRouterCallable()");
  }

  @Override
  public abstract void close();
}
