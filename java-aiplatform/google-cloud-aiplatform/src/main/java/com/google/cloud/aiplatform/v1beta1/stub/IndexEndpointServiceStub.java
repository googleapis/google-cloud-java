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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.IndexEndpointServiceClient.ListIndexEndpointsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.IndexEndpointServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateIndexEndpointRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteIndexEndpointRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeployIndexOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeployIndexRequest;
import com.google.cloud.aiplatform.v1beta1.DeployIndexResponse;
import com.google.cloud.aiplatform.v1beta1.GetIndexEndpointRequest;
import com.google.cloud.aiplatform.v1beta1.IndexEndpoint;
import com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsRequest;
import com.google.cloud.aiplatform.v1beta1.ListIndexEndpointsResponse;
import com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexRequest;
import com.google.cloud.aiplatform.v1beta1.MutateDeployedIndexResponse;
import com.google.cloud.aiplatform.v1beta1.UndeployIndexOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UndeployIndexRequest;
import com.google.cloud.aiplatform.v1beta1.UndeployIndexResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateIndexEndpointRequest;
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
 * Base stub class for the IndexEndpointService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class IndexEndpointServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<
          CreateIndexEndpointRequest, IndexEndpoint, CreateIndexEndpointOperationMetadata>
      createIndexEndpointOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createIndexEndpointOperationCallable()");
  }

  public UnaryCallable<CreateIndexEndpointRequest, Operation> createIndexEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: createIndexEndpointCallable()");
  }

  public UnaryCallable<GetIndexEndpointRequest, IndexEndpoint> getIndexEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: getIndexEndpointCallable()");
  }

  public UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsPagedResponse>
      listIndexEndpointsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexEndpointsPagedCallable()");
  }

  public UnaryCallable<ListIndexEndpointsRequest, ListIndexEndpointsResponse>
      listIndexEndpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexEndpointsCallable()");
  }

  public UnaryCallable<UpdateIndexEndpointRequest, IndexEndpoint> updateIndexEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIndexEndpointCallable()");
  }

  public OperationCallable<DeleteIndexEndpointRequest, Empty, DeleteOperationMetadata>
      deleteIndexEndpointOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteIndexEndpointOperationCallable()");
  }

  public UnaryCallable<DeleteIndexEndpointRequest, Operation> deleteIndexEndpointCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIndexEndpointCallable()");
  }

  public OperationCallable<DeployIndexRequest, DeployIndexResponse, DeployIndexOperationMetadata>
      deployIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deployIndexOperationCallable()");
  }

  public UnaryCallable<DeployIndexRequest, Operation> deployIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: deployIndexCallable()");
  }

  public OperationCallable<
          UndeployIndexRequest, UndeployIndexResponse, UndeployIndexOperationMetadata>
      undeployIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: undeployIndexOperationCallable()");
  }

  public UnaryCallable<UndeployIndexRequest, Operation> undeployIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: undeployIndexCallable()");
  }

  public OperationCallable<
          MutateDeployedIndexRequest,
          MutateDeployedIndexResponse,
          MutateDeployedIndexOperationMetadata>
      mutateDeployedIndexOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: mutateDeployedIndexOperationCallable()");
  }

  public UnaryCallable<MutateDeployedIndexRequest, Operation> mutateDeployedIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: mutateDeployedIndexCallable()");
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
