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

import static com.google.cloud.compute.v1.NetworkEdgeSecurityServicesClient.AggregatedListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListNetworkEdgeSecurityServicesRequest;
import com.google.cloud.compute.v1.DeleteNetworkEdgeSecurityServiceRequest;
import com.google.cloud.compute.v1.GetNetworkEdgeSecurityServiceRequest;
import com.google.cloud.compute.v1.InsertNetworkEdgeSecurityServiceRequest;
import com.google.cloud.compute.v1.NetworkEdgeSecurityService;
import com.google.cloud.compute.v1.NetworkEdgeSecurityServiceAggregatedList;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchNetworkEdgeSecurityServiceRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the NetworkEdgeSecurityServices service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class NetworkEdgeSecurityServicesStub implements BackgroundResource {

  public UnaryCallable<
          AggregatedListNetworkEdgeSecurityServicesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<
          AggregatedListNetworkEdgeSecurityServicesRequest,
          NetworkEdgeSecurityServiceAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<DeleteNetworkEdgeSecurityServiceRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteNetworkEdgeSecurityServiceRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetNetworkEdgeSecurityServiceRequest, NetworkEdgeSecurityService>
      getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<InsertNetworkEdgeSecurityServiceRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertNetworkEdgeSecurityServiceRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public OperationCallable<PatchNetworkEdgeSecurityServiceRequest, Operation, Operation>
      patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchNetworkEdgeSecurityServiceRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  @Override
  public abstract void close();
}
