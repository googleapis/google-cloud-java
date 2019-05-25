/*
 * Copyright 2019 Google LLC
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

import static com.google.cloud.compute.v1.RouteClient.ListRoutesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteRouteHttpRequest;
import com.google.cloud.compute.v1.GetRouteHttpRequest;
import com.google.cloud.compute.v1.InsertRouteHttpRequest;
import com.google.cloud.compute.v1.ListRoutesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Route;
import com.google.cloud.compute.v1.RouteList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class RouteStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteRouteHttpRequest, Operation> deleteRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRouteCallable()");
  }

  @BetaApi
  public UnaryCallable<GetRouteHttpRequest, Route> getRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: getRouteCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertRouteHttpRequest, Operation> insertRouteCallable() {
    throw new UnsupportedOperationException("Not implemented: insertRouteCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRoutesHttpRequest, ListRoutesPagedResponse> listRoutesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRoutesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRoutesHttpRequest, RouteList> listRoutesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRoutesCallable()");
  }

  @Override
  public abstract void close();
}
