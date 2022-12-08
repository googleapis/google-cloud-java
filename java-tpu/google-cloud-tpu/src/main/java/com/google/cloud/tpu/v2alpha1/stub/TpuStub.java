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

package com.google.cloud.tpu.v2alpha1.stub;

import static com.google.cloud.tpu.v2alpha1.TpuClient.ListAcceleratorTypesPagedResponse;
import static com.google.cloud.tpu.v2alpha1.TpuClient.ListLocationsPagedResponse;
import static com.google.cloud.tpu.v2alpha1.TpuClient.ListNodesPagedResponse;
import static com.google.cloud.tpu.v2alpha1.TpuClient.ListQueuedResourcesPagedResponse;
import static com.google.cloud.tpu.v2alpha1.TpuClient.ListRuntimeVersionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.tpu.v2alpha1.AcceleratorType;
import com.google.cloud.tpu.v2alpha1.CreateNodeRequest;
import com.google.cloud.tpu.v2alpha1.CreateQueuedResourceRequest;
import com.google.cloud.tpu.v2alpha1.DeleteNodeRequest;
import com.google.cloud.tpu.v2alpha1.DeleteQueuedResourceRequest;
import com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityRequest;
import com.google.cloud.tpu.v2alpha1.GenerateServiceIdentityResponse;
import com.google.cloud.tpu.v2alpha1.GetAcceleratorTypeRequest;
import com.google.cloud.tpu.v2alpha1.GetGuestAttributesRequest;
import com.google.cloud.tpu.v2alpha1.GetGuestAttributesResponse;
import com.google.cloud.tpu.v2alpha1.GetNodeRequest;
import com.google.cloud.tpu.v2alpha1.GetQueuedResourceRequest;
import com.google.cloud.tpu.v2alpha1.GetRuntimeVersionRequest;
import com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesRequest;
import com.google.cloud.tpu.v2alpha1.ListAcceleratorTypesResponse;
import com.google.cloud.tpu.v2alpha1.ListNodesRequest;
import com.google.cloud.tpu.v2alpha1.ListNodesResponse;
import com.google.cloud.tpu.v2alpha1.ListQueuedResourcesRequest;
import com.google.cloud.tpu.v2alpha1.ListQueuedResourcesResponse;
import com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsRequest;
import com.google.cloud.tpu.v2alpha1.ListRuntimeVersionsResponse;
import com.google.cloud.tpu.v2alpha1.Node;
import com.google.cloud.tpu.v2alpha1.OperationMetadata;
import com.google.cloud.tpu.v2alpha1.QueuedResource;
import com.google.cloud.tpu.v2alpha1.RuntimeVersion;
import com.google.cloud.tpu.v2alpha1.SimulateMaintenanceEventRequest;
import com.google.cloud.tpu.v2alpha1.StartNodeRequest;
import com.google.cloud.tpu.v2alpha1.StopNodeRequest;
import com.google.cloud.tpu.v2alpha1.UpdateNodeRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Tpu service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class TpuStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListNodesRequest, ListNodesPagedResponse> listNodesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodesPagedCallable()");
  }

  public UnaryCallable<ListNodesRequest, ListNodesResponse> listNodesCallable() {
    throw new UnsupportedOperationException("Not implemented: listNodesCallable()");
  }

  public UnaryCallable<GetNodeRequest, Node> getNodeCallable() {
    throw new UnsupportedOperationException("Not implemented: getNodeCallable()");
  }

  public OperationCallable<CreateNodeRequest, Node, OperationMetadata>
      createNodeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createNodeOperationCallable()");
  }

  public UnaryCallable<CreateNodeRequest, Operation> createNodeCallable() {
    throw new UnsupportedOperationException("Not implemented: createNodeCallable()");
  }

  public OperationCallable<DeleteNodeRequest, Empty, OperationMetadata>
      deleteNodeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNodeOperationCallable()");
  }

  public UnaryCallable<DeleteNodeRequest, Operation> deleteNodeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNodeCallable()");
  }

  public OperationCallable<StopNodeRequest, Node, OperationMetadata> stopNodeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: stopNodeOperationCallable()");
  }

  public UnaryCallable<StopNodeRequest, Operation> stopNodeCallable() {
    throw new UnsupportedOperationException("Not implemented: stopNodeCallable()");
  }

  public OperationCallable<StartNodeRequest, Node, OperationMetadata> startNodeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: startNodeOperationCallable()");
  }

  public UnaryCallable<StartNodeRequest, Operation> startNodeCallable() {
    throw new UnsupportedOperationException("Not implemented: startNodeCallable()");
  }

  public OperationCallable<UpdateNodeRequest, Node, OperationMetadata>
      updateNodeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNodeOperationCallable()");
  }

  public UnaryCallable<UpdateNodeRequest, Operation> updateNodeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNodeCallable()");
  }

  public UnaryCallable<ListQueuedResourcesRequest, ListQueuedResourcesPagedResponse>
      listQueuedResourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listQueuedResourcesPagedCallable()");
  }

  public UnaryCallable<ListQueuedResourcesRequest, ListQueuedResourcesResponse>
      listQueuedResourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: listQueuedResourcesCallable()");
  }

  public UnaryCallable<GetQueuedResourceRequest, QueuedResource> getQueuedResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: getQueuedResourceCallable()");
  }

  public OperationCallable<CreateQueuedResourceRequest, QueuedResource, OperationMetadata>
      createQueuedResourceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createQueuedResourceOperationCallable()");
  }

  public UnaryCallable<CreateQueuedResourceRequest, Operation> createQueuedResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: createQueuedResourceCallable()");
  }

  public OperationCallable<DeleteQueuedResourceRequest, QueuedResource, OperationMetadata>
      deleteQueuedResourceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteQueuedResourceOperationCallable()");
  }

  public UnaryCallable<DeleteQueuedResourceRequest, Operation> deleteQueuedResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteQueuedResourceCallable()");
  }

  public UnaryCallable<GenerateServiceIdentityRequest, GenerateServiceIdentityResponse>
      generateServiceIdentityCallable() {
    throw new UnsupportedOperationException("Not implemented: generateServiceIdentityCallable()");
  }

  public UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAcceleratorTypesPagedCallable()");
  }

  public UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>
      listAcceleratorTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAcceleratorTypesCallable()");
  }

  public UnaryCallable<GetAcceleratorTypeRequest, AcceleratorType> getAcceleratorTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: getAcceleratorTypeCallable()");
  }

  public UnaryCallable<ListRuntimeVersionsRequest, ListRuntimeVersionsPagedResponse>
      listRuntimeVersionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRuntimeVersionsPagedCallable()");
  }

  public UnaryCallable<ListRuntimeVersionsRequest, ListRuntimeVersionsResponse>
      listRuntimeVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRuntimeVersionsCallable()");
  }

  public UnaryCallable<GetRuntimeVersionRequest, RuntimeVersion> getRuntimeVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: getRuntimeVersionCallable()");
  }

  public UnaryCallable<GetGuestAttributesRequest, GetGuestAttributesResponse>
      getGuestAttributesCallable() {
    throw new UnsupportedOperationException("Not implemented: getGuestAttributesCallable()");
  }

  public OperationCallable<SimulateMaintenanceEventRequest, Node, OperationMetadata>
      simulateMaintenanceEventOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: simulateMaintenanceEventOperationCallable()");
  }

  public UnaryCallable<SimulateMaintenanceEventRequest, Operation>
      simulateMaintenanceEventCallable() {
    throw new UnsupportedOperationException("Not implemented: simulateMaintenanceEventCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
