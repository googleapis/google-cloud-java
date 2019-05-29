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

import static com.google.cloud.compute.v1.HttpHealthCheckClient.ListHttpHealthChecksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteHttpHealthCheckHttpRequest;
import com.google.cloud.compute.v1.GetHttpHealthCheckHttpRequest;
import com.google.cloud.compute.v1.HttpHealthCheck2;
import com.google.cloud.compute.v1.HttpHealthCheckList;
import com.google.cloud.compute.v1.InsertHttpHealthCheckHttpRequest;
import com.google.cloud.compute.v1.ListHttpHealthChecksHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchHttpHealthCheckHttpRequest;
import com.google.cloud.compute.v1.UpdateHttpHealthCheckHttpRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class HttpHealthCheckStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteHttpHealthCheckHttpRequest, Operation>
      deleteHttpHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteHttpHealthCheckCallable()");
  }

  @BetaApi
  public UnaryCallable<GetHttpHealthCheckHttpRequest, HttpHealthCheck2>
      getHttpHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: getHttpHealthCheckCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertHttpHealthCheckHttpRequest, Operation>
      insertHttpHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: insertHttpHealthCheckCallable()");
  }

  @BetaApi
  public UnaryCallable<ListHttpHealthChecksHttpRequest, ListHttpHealthChecksPagedResponse>
      listHttpHealthChecksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listHttpHealthChecksPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListHttpHealthChecksHttpRequest, HttpHealthCheckList>
      listHttpHealthChecksCallable() {
    throw new UnsupportedOperationException("Not implemented: listHttpHealthChecksCallable()");
  }

  @BetaApi
  public UnaryCallable<PatchHttpHealthCheckHttpRequest, Operation> patchHttpHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: patchHttpHealthCheckCallable()");
  }

  @BetaApi
  public UnaryCallable<UpdateHttpHealthCheckHttpRequest, Operation>
      updateHttpHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: updateHttpHealthCheckCallable()");
  }

  @Override
  public abstract void close();
}
