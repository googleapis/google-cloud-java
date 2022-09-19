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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.BackendServicesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.BackendServicesClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddSignedUrlKeyBackendServiceRequest;
import com.google.cloud.compute.v1.AggregatedListBackendServicesRequest;
import com.google.cloud.compute.v1.BackendService;
import com.google.cloud.compute.v1.BackendServiceAggregatedList;
import com.google.cloud.compute.v1.BackendServiceGroupHealth;
import com.google.cloud.compute.v1.BackendServiceList;
import com.google.cloud.compute.v1.DeleteBackendServiceRequest;
import com.google.cloud.compute.v1.DeleteSignedUrlKeyBackendServiceRequest;
import com.google.cloud.compute.v1.GetBackendServiceRequest;
import com.google.cloud.compute.v1.GetHealthBackendServiceRequest;
import com.google.cloud.compute.v1.GetIamPolicyBackendServiceRequest;
import com.google.cloud.compute.v1.InsertBackendServiceRequest;
import com.google.cloud.compute.v1.ListBackendServicesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchBackendServiceRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetEdgeSecurityPolicyBackendServiceRequest;
import com.google.cloud.compute.v1.SetIamPolicyBackendServiceRequest;
import com.google.cloud.compute.v1.SetSecurityPolicyBackendServiceRequest;
import com.google.cloud.compute.v1.UpdateBackendServiceRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the BackendServices service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class BackendServicesStub implements BackgroundResource {

  public OperationCallable<AddSignedUrlKeyBackendServiceRequest, Operation, Operation>
      addSignedUrlKeyOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: addSignedUrlKeyOperationCallable()");
  }

  public UnaryCallable<AddSignedUrlKeyBackendServiceRequest, Operation> addSignedUrlKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: addSignedUrlKeyCallable()");
  }

  public UnaryCallable<AggregatedListBackendServicesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<AggregatedListBackendServicesRequest, BackendServiceAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<DeleteBackendServiceRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteBackendServiceRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public OperationCallable<DeleteSignedUrlKeyBackendServiceRequest, Operation, Operation>
      deleteSignedUrlKeyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSignedUrlKeyOperationCallable()");
  }

  public UnaryCallable<DeleteSignedUrlKeyBackendServiceRequest, Operation>
      deleteSignedUrlKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSignedUrlKeyCallable()");
  }

  public UnaryCallable<GetBackendServiceRequest, BackendService> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetHealthBackendServiceRequest, BackendServiceGroupHealth>
      getHealthCallable() {
    throw new UnsupportedOperationException("Not implemented: getHealthCallable()");
  }

  public UnaryCallable<GetIamPolicyBackendServiceRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public OperationCallable<InsertBackendServiceRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertBackendServiceRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListBackendServicesRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListBackendServicesRequest, BackendServiceList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<PatchBackendServiceRequest, Operation, Operation>
      patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchBackendServiceRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public OperationCallable<SetEdgeSecurityPolicyBackendServiceRequest, Operation, Operation>
      setEdgeSecurityPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setEdgeSecurityPolicyOperationCallable()");
  }

  public UnaryCallable<SetEdgeSecurityPolicyBackendServiceRequest, Operation>
      setEdgeSecurityPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setEdgeSecurityPolicyCallable()");
  }

  public UnaryCallable<SetIamPolicyBackendServiceRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public OperationCallable<SetSecurityPolicyBackendServiceRequest, Operation, Operation>
      setSecurityPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setSecurityPolicyOperationCallable()");
  }

  public UnaryCallable<SetSecurityPolicyBackendServiceRequest, Operation>
      setSecurityPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setSecurityPolicyCallable()");
  }

  public OperationCallable<UpdateBackendServiceRequest, Operation, Operation>
      updateOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateOperationCallable()");
  }

  public UnaryCallable<UpdateBackendServiceRequest, Operation> updateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCallable()");
  }

  @Override
  public abstract void close();
}
