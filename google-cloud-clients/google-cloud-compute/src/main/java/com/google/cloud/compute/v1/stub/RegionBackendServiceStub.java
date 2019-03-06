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

import static com.google.cloud.compute.v1.RegionBackendServiceClient.ListRegionBackendServicesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.BackendService;
import com.google.cloud.compute.v1.BackendServiceGroupHealth;
import com.google.cloud.compute.v1.BackendServiceList;
import com.google.cloud.compute.v1.DeleteRegionBackendServiceHttpRequest;
import com.google.cloud.compute.v1.GetHealthRegionBackendServiceHttpRequest;
import com.google.cloud.compute.v1.GetRegionBackendServiceHttpRequest;
import com.google.cloud.compute.v1.InsertRegionBackendServiceHttpRequest;
import com.google.cloud.compute.v1.ListRegionBackendServicesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionBackendServiceHttpRequest;
import com.google.cloud.compute.v1.UpdateRegionBackendServiceHttpRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class RegionBackendServiceStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteRegionBackendServiceHttpRequest, Operation>
      deleteRegionBackendServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteRegionBackendServiceCallable()");
  }

  @BetaApi
  public UnaryCallable<GetRegionBackendServiceHttpRequest, BackendService>
      getRegionBackendServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: getRegionBackendServiceCallable()");
  }

  @BetaApi
  public UnaryCallable<GetHealthRegionBackendServiceHttpRequest, BackendServiceGroupHealth>
      getHealthRegionBackendServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getHealthRegionBackendServiceCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertRegionBackendServiceHttpRequest, Operation>
      insertRegionBackendServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: insertRegionBackendServiceCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionBackendServicesHttpRequest, ListRegionBackendServicesPagedResponse>
      listRegionBackendServicesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRegionBackendServicesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionBackendServicesHttpRequest, BackendServiceList>
      listRegionBackendServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRegionBackendServicesCallable()");
  }

  @BetaApi
  public UnaryCallable<PatchRegionBackendServiceHttpRequest, Operation>
      patchRegionBackendServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: patchRegionBackendServiceCallable()");
  }

  @BetaApi
  public UnaryCallable<UpdateRegionBackendServiceHttpRequest, Operation>
      updateRegionBackendServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateRegionBackendServiceCallable()");
  }

  @Override
  public abstract void close();
}
