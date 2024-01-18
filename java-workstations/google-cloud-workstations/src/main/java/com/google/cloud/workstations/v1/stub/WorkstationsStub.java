/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.workstations.v1.stub;

import static com.google.cloud.workstations.v1.WorkstationsClient.ListUsableWorkstationConfigsPagedResponse;
import static com.google.cloud.workstations.v1.WorkstationsClient.ListUsableWorkstationsPagedResponse;
import static com.google.cloud.workstations.v1.WorkstationsClient.ListWorkstationClustersPagedResponse;
import static com.google.cloud.workstations.v1.WorkstationsClient.ListWorkstationConfigsPagedResponse;
import static com.google.cloud.workstations.v1.WorkstationsClient.ListWorkstationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.workstations.v1.CreateWorkstationClusterRequest;
import com.google.cloud.workstations.v1.CreateWorkstationConfigRequest;
import com.google.cloud.workstations.v1.CreateWorkstationRequest;
import com.google.cloud.workstations.v1.DeleteWorkstationClusterRequest;
import com.google.cloud.workstations.v1.DeleteWorkstationConfigRequest;
import com.google.cloud.workstations.v1.DeleteWorkstationRequest;
import com.google.cloud.workstations.v1.GenerateAccessTokenRequest;
import com.google.cloud.workstations.v1.GenerateAccessTokenResponse;
import com.google.cloud.workstations.v1.GetWorkstationClusterRequest;
import com.google.cloud.workstations.v1.GetWorkstationConfigRequest;
import com.google.cloud.workstations.v1.GetWorkstationRequest;
import com.google.cloud.workstations.v1.ListUsableWorkstationConfigsRequest;
import com.google.cloud.workstations.v1.ListUsableWorkstationConfigsResponse;
import com.google.cloud.workstations.v1.ListUsableWorkstationsRequest;
import com.google.cloud.workstations.v1.ListUsableWorkstationsResponse;
import com.google.cloud.workstations.v1.ListWorkstationClustersRequest;
import com.google.cloud.workstations.v1.ListWorkstationClustersResponse;
import com.google.cloud.workstations.v1.ListWorkstationConfigsRequest;
import com.google.cloud.workstations.v1.ListWorkstationConfigsResponse;
import com.google.cloud.workstations.v1.ListWorkstationsRequest;
import com.google.cloud.workstations.v1.ListWorkstationsResponse;
import com.google.cloud.workstations.v1.OperationMetadata;
import com.google.cloud.workstations.v1.StartWorkstationRequest;
import com.google.cloud.workstations.v1.StopWorkstationRequest;
import com.google.cloud.workstations.v1.UpdateWorkstationClusterRequest;
import com.google.cloud.workstations.v1.UpdateWorkstationConfigRequest;
import com.google.cloud.workstations.v1.UpdateWorkstationRequest;
import com.google.cloud.workstations.v1.Workstation;
import com.google.cloud.workstations.v1.WorkstationCluster;
import com.google.cloud.workstations.v1.WorkstationConfig;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Workstations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class WorkstationsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetWorkstationClusterRequest, WorkstationCluster>
      getWorkstationClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: getWorkstationClusterCallable()");
  }

  public UnaryCallable<ListWorkstationClustersRequest, ListWorkstationClustersPagedResponse>
      listWorkstationClustersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listWorkstationClustersPagedCallable()");
  }

  public UnaryCallable<ListWorkstationClustersRequest, ListWorkstationClustersResponse>
      listWorkstationClustersCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkstationClustersCallable()");
  }

  public OperationCallable<CreateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      createWorkstationClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createWorkstationClusterOperationCallable()");
  }

  public UnaryCallable<CreateWorkstationClusterRequest, Operation>
      createWorkstationClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: createWorkstationClusterCallable()");
  }

  public OperationCallable<UpdateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      updateWorkstationClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateWorkstationClusterOperationCallable()");
  }

  public UnaryCallable<UpdateWorkstationClusterRequest, Operation>
      updateWorkstationClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWorkstationClusterCallable()");
  }

  public OperationCallable<DeleteWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      deleteWorkstationClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteWorkstationClusterOperationCallable()");
  }

  public UnaryCallable<DeleteWorkstationClusterRequest, Operation>
      deleteWorkstationClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWorkstationClusterCallable()");
  }

  public UnaryCallable<GetWorkstationConfigRequest, WorkstationConfig>
      getWorkstationConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getWorkstationConfigCallable()");
  }

  public UnaryCallable<ListWorkstationConfigsRequest, ListWorkstationConfigsPagedResponse>
      listWorkstationConfigsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listWorkstationConfigsPagedCallable()");
  }

  public UnaryCallable<ListWorkstationConfigsRequest, ListWorkstationConfigsResponse>
      listWorkstationConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkstationConfigsCallable()");
  }

  public UnaryCallable<
          ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsPagedResponse>
      listUsableWorkstationConfigsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listUsableWorkstationConfigsPagedCallable()");
  }

  public UnaryCallable<ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsResponse>
      listUsableWorkstationConfigsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listUsableWorkstationConfigsCallable()");
  }

  public OperationCallable<CreateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      createWorkstationConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createWorkstationConfigOperationCallable()");
  }

  public UnaryCallable<CreateWorkstationConfigRequest, Operation>
      createWorkstationConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createWorkstationConfigCallable()");
  }

  public OperationCallable<UpdateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      updateWorkstationConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateWorkstationConfigOperationCallable()");
  }

  public UnaryCallable<UpdateWorkstationConfigRequest, Operation>
      updateWorkstationConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWorkstationConfigCallable()");
  }

  public OperationCallable<DeleteWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      deleteWorkstationConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteWorkstationConfigOperationCallable()");
  }

  public UnaryCallable<DeleteWorkstationConfigRequest, Operation>
      deleteWorkstationConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWorkstationConfigCallable()");
  }

  public UnaryCallable<GetWorkstationRequest, Workstation> getWorkstationCallable() {
    throw new UnsupportedOperationException("Not implemented: getWorkstationCallable()");
  }

  public UnaryCallable<ListWorkstationsRequest, ListWorkstationsPagedResponse>
      listWorkstationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkstationsPagedCallable()");
  }

  public UnaryCallable<ListWorkstationsRequest, ListWorkstationsResponse>
      listWorkstationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listWorkstationsCallable()");
  }

  public UnaryCallable<ListUsableWorkstationsRequest, ListUsableWorkstationsPagedResponse>
      listUsableWorkstationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listUsableWorkstationsPagedCallable()");
  }

  public UnaryCallable<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse>
      listUsableWorkstationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listUsableWorkstationsCallable()");
  }

  public OperationCallable<CreateWorkstationRequest, Workstation, OperationMetadata>
      createWorkstationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createWorkstationOperationCallable()");
  }

  public UnaryCallable<CreateWorkstationRequest, Operation> createWorkstationCallable() {
    throw new UnsupportedOperationException("Not implemented: createWorkstationCallable()");
  }

  public OperationCallable<UpdateWorkstationRequest, Workstation, OperationMetadata>
      updateWorkstationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateWorkstationOperationCallable()");
  }

  public UnaryCallable<UpdateWorkstationRequest, Operation> updateWorkstationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateWorkstationCallable()");
  }

  public OperationCallable<DeleteWorkstationRequest, Workstation, OperationMetadata>
      deleteWorkstationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteWorkstationOperationCallable()");
  }

  public UnaryCallable<DeleteWorkstationRequest, Operation> deleteWorkstationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteWorkstationCallable()");
  }

  public OperationCallable<StartWorkstationRequest, Workstation, OperationMetadata>
      startWorkstationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: startWorkstationOperationCallable()");
  }

  public UnaryCallable<StartWorkstationRequest, Operation> startWorkstationCallable() {
    throw new UnsupportedOperationException("Not implemented: startWorkstationCallable()");
  }

  public OperationCallable<StopWorkstationRequest, Workstation, OperationMetadata>
      stopWorkstationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: stopWorkstationOperationCallable()");
  }

  public UnaryCallable<StopWorkstationRequest, Operation> stopWorkstationCallable() {
    throw new UnsupportedOperationException("Not implemented: stopWorkstationCallable()");
  }

  public UnaryCallable<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenCallable() {
    throw new UnsupportedOperationException("Not implemented: generateAccessTokenCallable()");
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
