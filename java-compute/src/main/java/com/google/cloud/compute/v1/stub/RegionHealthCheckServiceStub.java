/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.compute.v1.RegionHealthCheckServiceClient.ListRegionHealthCheckServicesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteRegionHealthCheckServiceHttpRequest;
import com.google.cloud.compute.v1.GetRegionHealthCheckServiceHttpRequest;
import com.google.cloud.compute.v1.HealthCheckService;
import com.google.cloud.compute.v1.HealthCheckServicesList;
import com.google.cloud.compute.v1.InsertRegionHealthCheckServiceHttpRequest;
import com.google.cloud.compute.v1.ListRegionHealthCheckServicesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionHealthCheckServiceHttpRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class RegionHealthCheckServiceStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteRegionHealthCheckServiceHttpRequest, Operation>
      deleteRegionHealthCheckServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteRegionHealthCheckServiceCallable()");
  }

  @BetaApi
  public UnaryCallable<GetRegionHealthCheckServiceHttpRequest, HealthCheckService>
      getRegionHealthCheckServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getRegionHealthCheckServiceCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertRegionHealthCheckServiceHttpRequest, Operation>
      insertRegionHealthCheckServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: insertRegionHealthCheckServiceCallable()");
  }

  @BetaApi
  public UnaryCallable<
          ListRegionHealthCheckServicesHttpRequest, ListRegionHealthCheckServicesPagedResponse>
      listRegionHealthCheckServicesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRegionHealthCheckServicesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionHealthCheckServicesHttpRequest, HealthCheckServicesList>
      listRegionHealthCheckServicesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRegionHealthCheckServicesCallable()");
  }

  @BetaApi
  public UnaryCallable<PatchRegionHealthCheckServiceHttpRequest, Operation>
      patchRegionHealthCheckServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: patchRegionHealthCheckServiceCallable()");
  }

  @Override
  public abstract void close();
}
