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

import static com.google.cloud.compute.v1.RegionHealthCheckClient.ListRegionHealthChecksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteRegionHealthCheckHttpRequest;
import com.google.cloud.compute.v1.GetRegionHealthCheckHttpRequest;
import com.google.cloud.compute.v1.HealthCheck;
import com.google.cloud.compute.v1.HealthCheckList;
import com.google.cloud.compute.v1.InsertRegionHealthCheckHttpRequest;
import com.google.cloud.compute.v1.ListRegionHealthChecksHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionHealthCheckHttpRequest;
import com.google.cloud.compute.v1.UpdateRegionHealthCheckHttpRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class RegionHealthCheckStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteRegionHealthCheckHttpRequest, Operation>
      deleteRegionHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRegionHealthCheckCallable()");
  }

  @BetaApi
  public UnaryCallable<GetRegionHealthCheckHttpRequest, HealthCheck>
      getRegionHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: getRegionHealthCheckCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertRegionHealthCheckHttpRequest, Operation>
      insertRegionHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: insertRegionHealthCheckCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionHealthChecksHttpRequest, ListRegionHealthChecksPagedResponse>
      listRegionHealthChecksPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRegionHealthChecksPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionHealthChecksHttpRequest, HealthCheckList>
      listRegionHealthChecksCallable() {
    throw new UnsupportedOperationException("Not implemented: listRegionHealthChecksCallable()");
  }

  @BetaApi
  public UnaryCallable<PatchRegionHealthCheckHttpRequest, Operation>
      patchRegionHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: patchRegionHealthCheckCallable()");
  }

  @BetaApi
  public UnaryCallable<UpdateRegionHealthCheckHttpRequest, Operation>
      updateRegionHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRegionHealthCheckCallable()");
  }

  @Override
  public abstract void close();
}
