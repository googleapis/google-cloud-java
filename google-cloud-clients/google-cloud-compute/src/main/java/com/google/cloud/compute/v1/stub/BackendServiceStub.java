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

import static com.google.cloud.compute.v1.BackendServiceClient.AggregatedListBackendServicesPagedResponse;
import static com.google.cloud.compute.v1.BackendServiceClient.ListBackendServicesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddSignedUrlKeyBackendServiceHttpRequest;
import com.google.cloud.compute.v1.AggregatedListBackendServicesHttpRequest;
import com.google.cloud.compute.v1.BackendService;
import com.google.cloud.compute.v1.BackendServiceAggregatedList;
import com.google.cloud.compute.v1.BackendServiceGroupHealth;
import com.google.cloud.compute.v1.BackendServiceList;
import com.google.cloud.compute.v1.DeleteBackendServiceHttpRequest;
import com.google.cloud.compute.v1.DeleteSignedUrlKeyBackendServiceHttpRequest;
import com.google.cloud.compute.v1.GetBackendServiceHttpRequest;
import com.google.cloud.compute.v1.GetHealthBackendServiceHttpRequest;
import com.google.cloud.compute.v1.InsertBackendServiceHttpRequest;
import com.google.cloud.compute.v1.ListBackendServicesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchBackendServiceHttpRequest;
import com.google.cloud.compute.v1.SetSecurityPolicyBackendServiceHttpRequest;
import com.google.cloud.compute.v1.UpdateBackendServiceHttpRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class BackendServiceStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<AddSignedUrlKeyBackendServiceHttpRequest, Operation>
      addSignedUrlKeyBackendServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: addSignedUrlKeyBackendServiceCallable()");
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListBackendServicesHttpRequest, AggregatedListBackendServicesPagedResponse>
      aggregatedListBackendServicesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListBackendServicesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListBackendServicesHttpRequest, BackendServiceAggregatedList>
      aggregatedListBackendServicesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListBackendServicesCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteBackendServiceHttpRequest, Operation> deleteBackendServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackendServiceCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteSignedUrlKeyBackendServiceHttpRequest, Operation>
      deleteSignedUrlKeyBackendServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSignedUrlKeyBackendServiceCallable()");
  }

  @BetaApi
  public UnaryCallable<GetBackendServiceHttpRequest, BackendService> getBackendServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackendServiceCallable()");
  }

  @BetaApi
  public UnaryCallable<GetHealthBackendServiceHttpRequest, BackendServiceGroupHealth>
      getHealthBackendServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: getHealthBackendServiceCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertBackendServiceHttpRequest, Operation> insertBackendServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: insertBackendServiceCallable()");
  }

  @BetaApi
  public UnaryCallable<ListBackendServicesHttpRequest, ListBackendServicesPagedResponse>
      listBackendServicesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackendServicesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListBackendServicesHttpRequest, BackendServiceList>
      listBackendServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackendServicesCallable()");
  }

  @BetaApi
  public UnaryCallable<PatchBackendServiceHttpRequest, Operation> patchBackendServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: patchBackendServiceCallable()");
  }

  @BetaApi
  public UnaryCallable<SetSecurityPolicyBackendServiceHttpRequest, Operation>
      setSecurityPolicyBackendServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setSecurityPolicyBackendServiceCallable()");
  }

  @BetaApi
  public UnaryCallable<UpdateBackendServiceHttpRequest, Operation> updateBackendServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBackendServiceCallable()");
  }

  @Override
  public abstract void close();
}
