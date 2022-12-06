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

package com.google.cloud.tpu.v1.stub;

import static com.google.cloud.tpu.v1.TpuClient.ListAcceleratorTypesPagedResponse;
import static com.google.cloud.tpu.v1.TpuClient.ListLocationsPagedResponse;
import static com.google.cloud.tpu.v1.TpuClient.ListNodesPagedResponse;
import static com.google.cloud.tpu.v1.TpuClient.ListTensorFlowVersionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.tpu.v1.AcceleratorType;
import com.google.cloud.tpu.v1.CreateNodeRequest;
import com.google.cloud.tpu.v1.DeleteNodeRequest;
import com.google.cloud.tpu.v1.GetAcceleratorTypeRequest;
import com.google.cloud.tpu.v1.GetNodeRequest;
import com.google.cloud.tpu.v1.GetTensorFlowVersionRequest;
import com.google.cloud.tpu.v1.ListAcceleratorTypesRequest;
import com.google.cloud.tpu.v1.ListAcceleratorTypesResponse;
import com.google.cloud.tpu.v1.ListNodesRequest;
import com.google.cloud.tpu.v1.ListNodesResponse;
import com.google.cloud.tpu.v1.ListTensorFlowVersionsRequest;
import com.google.cloud.tpu.v1.ListTensorFlowVersionsResponse;
import com.google.cloud.tpu.v1.Node;
import com.google.cloud.tpu.v1.OperationMetadata;
import com.google.cloud.tpu.v1.ReimageNodeRequest;
import com.google.cloud.tpu.v1.StartNodeRequest;
import com.google.cloud.tpu.v1.StopNodeRequest;
import com.google.cloud.tpu.v1.TensorFlowVersion;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Tpu service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
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

  public OperationCallable<DeleteNodeRequest, Node, OperationMetadata>
      deleteNodeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNodeOperationCallable()");
  }

  public UnaryCallable<DeleteNodeRequest, Operation> deleteNodeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNodeCallable()");
  }

  public OperationCallable<ReimageNodeRequest, Node, OperationMetadata>
      reimageNodeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: reimageNodeOperationCallable()");
  }

  public UnaryCallable<ReimageNodeRequest, Operation> reimageNodeCallable() {
    throw new UnsupportedOperationException("Not implemented: reimageNodeCallable()");
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

  public UnaryCallable<ListTensorFlowVersionsRequest, ListTensorFlowVersionsPagedResponse>
      listTensorFlowVersionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listTensorFlowVersionsPagedCallable()");
  }

  public UnaryCallable<ListTensorFlowVersionsRequest, ListTensorFlowVersionsResponse>
      listTensorFlowVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTensorFlowVersionsCallable()");
  }

  public UnaryCallable<GetTensorFlowVersionRequest, TensorFlowVersion>
      getTensorFlowVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: getTensorFlowVersionCallable()");
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
