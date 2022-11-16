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

import static com.google.cloud.aiplatform.v1beta1.DeploymentResourcePoolServiceClient.ListDeploymentResourcePoolsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DeploymentResourcePoolServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DeploymentResourcePoolServiceClient.QueryDeployedModelsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateDeploymentResourcePoolRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteDeploymentResourcePoolRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeploymentResourcePool;
import com.google.cloud.aiplatform.v1beta1.GetDeploymentResourcePoolRequest;
import com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsRequest;
import com.google.cloud.aiplatform.v1beta1.ListDeploymentResourcePoolsResponse;
import com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsRequest;
import com.google.cloud.aiplatform.v1beta1.QueryDeployedModelsResponse;
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
 * Base stub class for the DeploymentResourcePoolService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class DeploymentResourcePoolServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<
          CreateDeploymentResourcePoolRequest,
          DeploymentResourcePool,
          CreateDeploymentResourcePoolOperationMetadata>
      createDeploymentResourcePoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createDeploymentResourcePoolOperationCallable()");
  }

  public UnaryCallable<CreateDeploymentResourcePoolRequest, Operation>
      createDeploymentResourcePoolCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createDeploymentResourcePoolCallable()");
  }

  public UnaryCallable<GetDeploymentResourcePoolRequest, DeploymentResourcePool>
      getDeploymentResourcePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getDeploymentResourcePoolCallable()");
  }

  public UnaryCallable<ListDeploymentResourcePoolsRequest, ListDeploymentResourcePoolsPagedResponse>
      listDeploymentResourcePoolsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDeploymentResourcePoolsPagedCallable()");
  }

  public UnaryCallable<ListDeploymentResourcePoolsRequest, ListDeploymentResourcePoolsResponse>
      listDeploymentResourcePoolsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDeploymentResourcePoolsCallable()");
  }

  public OperationCallable<DeleteDeploymentResourcePoolRequest, Empty, DeleteOperationMetadata>
      deleteDeploymentResourcePoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteDeploymentResourcePoolOperationCallable()");
  }

  public UnaryCallable<DeleteDeploymentResourcePoolRequest, Operation>
      deleteDeploymentResourcePoolCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteDeploymentResourcePoolCallable()");
  }

  public UnaryCallable<QueryDeployedModelsRequest, QueryDeployedModelsPagedResponse>
      queryDeployedModelsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: queryDeployedModelsPagedCallable()");
  }

  public UnaryCallable<QueryDeployedModelsRequest, QueryDeployedModelsResponse>
      queryDeployedModelsCallable() {
    throw new UnsupportedOperationException("Not implemented: queryDeployedModelsCallable()");
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
