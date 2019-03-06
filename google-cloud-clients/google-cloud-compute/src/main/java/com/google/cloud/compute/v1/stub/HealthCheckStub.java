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

import static com.google.cloud.compute.v1.HealthCheckClient.ListHealthChecksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteHealthCheckHttpRequest;
import com.google.cloud.compute.v1.GetHealthCheckHttpRequest;
import com.google.cloud.compute.v1.HealthCheck;
import com.google.cloud.compute.v1.HealthCheckList;
import com.google.cloud.compute.v1.InsertHealthCheckHttpRequest;
import com.google.cloud.compute.v1.ListHealthChecksHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchHealthCheckHttpRequest;
import com.google.cloud.compute.v1.UpdateHealthCheckHttpRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class HealthCheckStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteHealthCheckHttpRequest, Operation> deleteHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteHealthCheckCallable()");
  }

  @BetaApi
  public UnaryCallable<GetHealthCheckHttpRequest, HealthCheck> getHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: getHealthCheckCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertHealthCheckHttpRequest, Operation> insertHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: insertHealthCheckCallable()");
  }

  @BetaApi
  public UnaryCallable<ListHealthChecksHttpRequest, ListHealthChecksPagedResponse>
      listHealthChecksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listHealthChecksPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListHealthChecksHttpRequest, HealthCheckList> listHealthChecksCallable() {
    throw new UnsupportedOperationException("Not implemented: listHealthChecksCallable()");
  }

  @BetaApi
  public UnaryCallable<PatchHealthCheckHttpRequest, Operation> patchHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: patchHealthCheckCallable()");
  }

  @BetaApi
  public UnaryCallable<UpdateHealthCheckHttpRequest, Operation> updateHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: updateHealthCheckCallable()");
  }

  @Override
  public abstract void close();
}
