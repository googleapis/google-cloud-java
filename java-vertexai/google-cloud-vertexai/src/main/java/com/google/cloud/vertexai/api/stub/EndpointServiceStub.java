/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.vertexai.api.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vertexai.api.CreateEndpointOperationMetadata;
import com.google.cloud.vertexai.api.CreateEndpointRequest;
import com.google.cloud.vertexai.api.DeleteEndpointRequest;
import com.google.cloud.vertexai.api.DeleteOperationMetadata;
import com.google.cloud.vertexai.api.DeployModelOperationMetadata;
import com.google.cloud.vertexai.api.DeployModelRequest;
import com.google.cloud.vertexai.api.DeployModelResponse;
import com.google.cloud.vertexai.api.Endpoint;
import com.google.cloud.vertexai.api.EndpointServiceClient.ListEndpointsPagedResponse;
import com.google.cloud.vertexai.api.EndpointServiceClient.ListLocationsPagedResponse;
import com.google.cloud.vertexai.api.GetEndpointRequest;
import com.google.cloud.vertexai.api.ListEndpointsRequest;
import com.google.cloud.vertexai.api.ListEndpointsResponse;
import com.google.cloud.vertexai.api.MutateDeployedModelOperationMetadata;
import com.google.cloud.vertexai.api.MutateDeployedModelRequest;
import com.google.cloud.vertexai.api.MutateDeployedModelResponse;
import com.google.cloud.vertexai.api.UndeployModelOperationMetadata;
import com.google.cloud.vertexai.api.UndeployModelRequest;
import com.google.cloud.vertexai.api.UndeployModelResponse;
import com.google.cloud.vertexai.api.UpdateEndpointRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the EndpointService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class EndpointServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateEndpointRequest, Endpoint, CreateEndpointOperationMetadata>
      createEndpointOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createEndpointOperationCallable()");
  }

  public UnaryCallable<CreateEndpointRequest, Operation> createEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: createEndpointCallable()");
  }

  public UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: getEndpointCallable()");
  }

  public UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEndpointsPagedCallable()");
  }

  public UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEndpointsCallable()");
  }

  public UnaryCallable<UpdateEndpointRequest, Endpoint> updateEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEndpointCallable()");
  }

  public OperationCallable<DeleteEndpointRequest, Empty, DeleteOperationMetadata>
      deleteEndpointOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEndpointOperationCallable()");
  }

  public UnaryCallable<DeleteEndpointRequest, Operation> deleteEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEndpointCallable()");
  }

  public OperationCallable<DeployModelRequest, DeployModelResponse, DeployModelOperationMetadata>
      deployModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deployModelOperationCallable()");
  }

  public UnaryCallable<DeployModelRequest, Operation> deployModelCallable() {
    throw new UnsupportedOperationException("Not implemented: deployModelCallable()");
  }

  public OperationCallable<
          UndeployModelRequest, UndeployModelResponse, UndeployModelOperationMetadata>
      undeployModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: undeployModelOperationCallable()");
  }

  public UnaryCallable<UndeployModelRequest, Operation> undeployModelCallable() {
    throw new UnsupportedOperationException("Not implemented: undeployModelCallable()");
  }

  public OperationCallable<
          MutateDeployedModelRequest,
          MutateDeployedModelResponse,
          MutateDeployedModelOperationMetadata>
      mutateDeployedModelOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: mutateDeployedModelOperationCallable()");
  }

  public UnaryCallable<MutateDeployedModelRequest, Operation> mutateDeployedModelCallable() {
    throw new UnsupportedOperationException("Not implemented: mutateDeployedModelCallable()");
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

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
