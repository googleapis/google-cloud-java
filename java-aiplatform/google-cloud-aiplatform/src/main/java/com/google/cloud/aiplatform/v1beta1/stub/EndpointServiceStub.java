/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.EndpointServiceClient.ListEndpointsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.EndpointServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateEndpointOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateEndpointRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteEndpointRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeployModelOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeployModelRequest;
import com.google.cloud.aiplatform.v1beta1.DeployModelResponse;
import com.google.cloud.aiplatform.v1beta1.Endpoint;
import com.google.cloud.aiplatform.v1beta1.FetchPublisherModelConfigRequest;
import com.google.cloud.aiplatform.v1beta1.GetEndpointRequest;
import com.google.cloud.aiplatform.v1beta1.ListEndpointsRequest;
import com.google.cloud.aiplatform.v1beta1.ListEndpointsResponse;
import com.google.cloud.aiplatform.v1beta1.MutateDeployedModelOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.MutateDeployedModelRequest;
import com.google.cloud.aiplatform.v1beta1.MutateDeployedModelResponse;
import com.google.cloud.aiplatform.v1beta1.PublisherModelConfig;
import com.google.cloud.aiplatform.v1beta1.SetPublisherModelConfigOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.SetPublisherModelConfigRequest;
import com.google.cloud.aiplatform.v1beta1.UndeployModelOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UndeployModelRequest;
import com.google.cloud.aiplatform.v1beta1.UndeployModelResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateEndpointLongRunningRequest;
import com.google.cloud.aiplatform.v1beta1.UpdateEndpointOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateEndpointRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
@BetaApi
@Generated("by gapic-generator-java")
public abstract class EndpointServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
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

  public OperationCallable<
          UpdateEndpointLongRunningRequest, Endpoint, UpdateEndpointOperationMetadata>
      updateEndpointLongRunningOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateEndpointLongRunningOperationCallable()");
  }

  public UnaryCallable<UpdateEndpointLongRunningRequest, Operation>
      updateEndpointLongRunningCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEndpointLongRunningCallable()");
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

  public OperationCallable<
          SetPublisherModelConfigRequest,
          PublisherModelConfig,
          SetPublisherModelConfigOperationMetadata>
      setPublisherModelConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setPublisherModelConfigOperationCallable()");
  }

  public UnaryCallable<SetPublisherModelConfigRequest, Operation>
      setPublisherModelConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: setPublisherModelConfigCallable()");
  }

  public UnaryCallable<FetchPublisherModelConfigRequest, PublisherModelConfig>
      fetchPublisherModelConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchPublisherModelConfigCallable()");
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
