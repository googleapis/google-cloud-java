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

package com.google.cloud.notebooks.v2.stub;

import static com.google.cloud.notebooks.v2.NotebookServiceClient.ListInstancesPagedResponse;
import static com.google.cloud.notebooks.v2.NotebookServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityRequest;
import com.google.cloud.notebooks.v2.CheckInstanceUpgradabilityResponse;
import com.google.cloud.notebooks.v2.CreateInstanceRequest;
import com.google.cloud.notebooks.v2.DeleteInstanceRequest;
import com.google.cloud.notebooks.v2.DiagnoseInstanceRequest;
import com.google.cloud.notebooks.v2.GetInstanceRequest;
import com.google.cloud.notebooks.v2.Instance;
import com.google.cloud.notebooks.v2.ListInstancesRequest;
import com.google.cloud.notebooks.v2.ListInstancesResponse;
import com.google.cloud.notebooks.v2.OperationMetadata;
import com.google.cloud.notebooks.v2.ResetInstanceRequest;
import com.google.cloud.notebooks.v2.RollbackInstanceRequest;
import com.google.cloud.notebooks.v2.StartInstanceRequest;
import com.google.cloud.notebooks.v2.StopInstanceRequest;
import com.google.cloud.notebooks.v2.UpdateInstanceRequest;
import com.google.cloud.notebooks.v2.UpgradeInstanceRequest;
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
 * Base stub class for the NotebookService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class NotebookServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesPagedCallable()");
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesCallable()");
  }

  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstanceCallable()");
  }

  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceOperationCallable()");
  }

  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceCallable()");
  }

  public OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceOperationCallable()");
  }

  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceCallable()");
  }

  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceOperationCallable()");
  }

  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceCallable()");
  }

  public OperationCallable<StartInstanceRequest, Instance, OperationMetadata>
      startInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: startInstanceOperationCallable()");
  }

  public UnaryCallable<StartInstanceRequest, Operation> startInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: startInstanceCallable()");
  }

  public OperationCallable<StopInstanceRequest, Instance, OperationMetadata>
      stopInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: stopInstanceOperationCallable()");
  }

  public UnaryCallable<StopInstanceRequest, Operation> stopInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: stopInstanceCallable()");
  }

  public OperationCallable<ResetInstanceRequest, Instance, OperationMetadata>
      resetInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: resetInstanceOperationCallable()");
  }

  public UnaryCallable<ResetInstanceRequest, Operation> resetInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: resetInstanceCallable()");
  }

  public UnaryCallable<CheckInstanceUpgradabilityRequest, CheckInstanceUpgradabilityResponse>
      checkInstanceUpgradabilityCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: checkInstanceUpgradabilityCallable()");
  }

  public OperationCallable<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: upgradeInstanceOperationCallable()");
  }

  public UnaryCallable<UpgradeInstanceRequest, Operation> upgradeInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: upgradeInstanceCallable()");
  }

  public OperationCallable<RollbackInstanceRequest, Instance, OperationMetadata>
      rollbackInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: rollbackInstanceOperationCallable()");
  }

  public UnaryCallable<RollbackInstanceRequest, Operation> rollbackInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: rollbackInstanceCallable()");
  }

  public OperationCallable<DiagnoseInstanceRequest, Instance, OperationMetadata>
      diagnoseInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: diagnoseInstanceOperationCallable()");
  }

  public UnaryCallable<DiagnoseInstanceRequest, Operation> diagnoseInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: diagnoseInstanceCallable()");
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
