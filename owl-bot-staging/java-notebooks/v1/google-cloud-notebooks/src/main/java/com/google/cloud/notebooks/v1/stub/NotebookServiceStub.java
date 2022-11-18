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

package com.google.cloud.notebooks.v1.stub;

import static com.google.cloud.notebooks.v1.NotebookServiceClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.notebooks.v1.NotebookServiceClient.ListExecutionsPagedResponse;
import static com.google.cloud.notebooks.v1.NotebookServiceClient.ListInstancesPagedResponse;
import static com.google.cloud.notebooks.v1.NotebookServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.notebooks.v1.NotebookServiceClient.ListSchedulesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.notebooks.v1.CreateEnvironmentRequest;
import com.google.cloud.notebooks.v1.CreateExecutionRequest;
import com.google.cloud.notebooks.v1.CreateInstanceRequest;
import com.google.cloud.notebooks.v1.CreateScheduleRequest;
import com.google.cloud.notebooks.v1.DeleteEnvironmentRequest;
import com.google.cloud.notebooks.v1.DeleteExecutionRequest;
import com.google.cloud.notebooks.v1.DeleteInstanceRequest;
import com.google.cloud.notebooks.v1.DeleteScheduleRequest;
import com.google.cloud.notebooks.v1.DiagnoseInstanceRequest;
import com.google.cloud.notebooks.v1.Environment;
import com.google.cloud.notebooks.v1.Execution;
import com.google.cloud.notebooks.v1.GetEnvironmentRequest;
import com.google.cloud.notebooks.v1.GetExecutionRequest;
import com.google.cloud.notebooks.v1.GetInstanceHealthRequest;
import com.google.cloud.notebooks.v1.GetInstanceHealthResponse;
import com.google.cloud.notebooks.v1.GetInstanceRequest;
import com.google.cloud.notebooks.v1.GetScheduleRequest;
import com.google.cloud.notebooks.v1.Instance;
import com.google.cloud.notebooks.v1.IsInstanceUpgradeableRequest;
import com.google.cloud.notebooks.v1.IsInstanceUpgradeableResponse;
import com.google.cloud.notebooks.v1.ListEnvironmentsRequest;
import com.google.cloud.notebooks.v1.ListEnvironmentsResponse;
import com.google.cloud.notebooks.v1.ListExecutionsRequest;
import com.google.cloud.notebooks.v1.ListExecutionsResponse;
import com.google.cloud.notebooks.v1.ListInstancesRequest;
import com.google.cloud.notebooks.v1.ListInstancesResponse;
import com.google.cloud.notebooks.v1.ListSchedulesRequest;
import com.google.cloud.notebooks.v1.ListSchedulesResponse;
import com.google.cloud.notebooks.v1.OperationMetadata;
import com.google.cloud.notebooks.v1.RegisterInstanceRequest;
import com.google.cloud.notebooks.v1.ReportInstanceInfoRequest;
import com.google.cloud.notebooks.v1.ResetInstanceRequest;
import com.google.cloud.notebooks.v1.RollbackInstanceRequest;
import com.google.cloud.notebooks.v1.Schedule;
import com.google.cloud.notebooks.v1.SetInstanceAcceleratorRequest;
import com.google.cloud.notebooks.v1.SetInstanceLabelsRequest;
import com.google.cloud.notebooks.v1.SetInstanceMachineTypeRequest;
import com.google.cloud.notebooks.v1.StartInstanceRequest;
import com.google.cloud.notebooks.v1.StopInstanceRequest;
import com.google.cloud.notebooks.v1.TriggerScheduleRequest;
import com.google.cloud.notebooks.v1.UpdateInstanceConfigRequest;
import com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsRequest;
import com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsResponse;
import com.google.cloud.notebooks.v1.UpdateShieldedInstanceConfigRequest;
import com.google.cloud.notebooks.v1.UpgradeInstanceInternalRequest;
import com.google.cloud.notebooks.v1.UpgradeInstanceRequest;
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
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
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

  public OperationCallable<RegisterInstanceRequest, Instance, OperationMetadata>
      registerInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: registerInstanceOperationCallable()");
  }

  public UnaryCallable<RegisterInstanceRequest, Operation> registerInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: registerInstanceCallable()");
  }

  public OperationCallable<SetInstanceAcceleratorRequest, Instance, OperationMetadata>
      setInstanceAcceleratorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setInstanceAcceleratorOperationCallable()");
  }

  public UnaryCallable<SetInstanceAcceleratorRequest, Operation> setInstanceAcceleratorCallable() {
    throw new UnsupportedOperationException("Not implemented: setInstanceAcceleratorCallable()");
  }

  public OperationCallable<SetInstanceMachineTypeRequest, Instance, OperationMetadata>
      setInstanceMachineTypeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setInstanceMachineTypeOperationCallable()");
  }

  public UnaryCallable<SetInstanceMachineTypeRequest, Operation> setInstanceMachineTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: setInstanceMachineTypeCallable()");
  }

  public OperationCallable<UpdateInstanceConfigRequest, Instance, OperationMetadata>
      updateInstanceConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateInstanceConfigOperationCallable()");
  }

  public UnaryCallable<UpdateInstanceConfigRequest, Operation> updateInstanceConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceConfigCallable()");
  }

  public OperationCallable<UpdateShieldedInstanceConfigRequest, Instance, OperationMetadata>
      updateShieldedInstanceConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateShieldedInstanceConfigOperationCallable()");
  }

  public UnaryCallable<UpdateShieldedInstanceConfigRequest, Operation>
      updateShieldedInstanceConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateShieldedInstanceConfigCallable()");
  }

  public OperationCallable<SetInstanceLabelsRequest, Instance, OperationMetadata>
      setInstanceLabelsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setInstanceLabelsOperationCallable()");
  }

  public UnaryCallable<SetInstanceLabelsRequest, Operation> setInstanceLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: setInstanceLabelsCallable()");
  }

  public UnaryCallable<UpdateInstanceMetadataItemsRequest, UpdateInstanceMetadataItemsResponse>
      updateInstanceMetadataItemsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateInstanceMetadataItemsCallable()");
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

  public OperationCallable<ReportInstanceInfoRequest, Instance, OperationMetadata>
      reportInstanceInfoOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: reportInstanceInfoOperationCallable()");
  }

  public UnaryCallable<ReportInstanceInfoRequest, Operation> reportInstanceInfoCallable() {
    throw new UnsupportedOperationException("Not implemented: reportInstanceInfoCallable()");
  }

  public UnaryCallable<IsInstanceUpgradeableRequest, IsInstanceUpgradeableResponse>
      isInstanceUpgradeableCallable() {
    throw new UnsupportedOperationException("Not implemented: isInstanceUpgradeableCallable()");
  }

  public UnaryCallable<GetInstanceHealthRequest, GetInstanceHealthResponse>
      getInstanceHealthCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstanceHealthCallable()");
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

  public OperationCallable<UpgradeInstanceInternalRequest, Instance, OperationMetadata>
      upgradeInstanceInternalOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: upgradeInstanceInternalOperationCallable()");
  }

  public UnaryCallable<UpgradeInstanceInternalRequest, Operation>
      upgradeInstanceInternalCallable() {
    throw new UnsupportedOperationException("Not implemented: upgradeInstanceInternalCallable()");
  }

  public UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEnvironmentsPagedCallable()");
  }

  public UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEnvironmentsCallable()");
  }

  public UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: getEnvironmentCallable()");
  }

  public OperationCallable<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createEnvironmentOperationCallable()");
  }

  public UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: createEnvironmentCallable()");
  }

  public OperationCallable<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteEnvironmentOperationCallable()");
  }

  public UnaryCallable<DeleteEnvironmentRequest, Operation> deleteEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEnvironmentCallable()");
  }

  public UnaryCallable<ListSchedulesRequest, ListSchedulesPagedResponse>
      listSchedulesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSchedulesPagedCallable()");
  }

  public UnaryCallable<ListSchedulesRequest, ListSchedulesResponse> listSchedulesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSchedulesCallable()");
  }

  public UnaryCallable<GetScheduleRequest, Schedule> getScheduleCallable() {
    throw new UnsupportedOperationException("Not implemented: getScheduleCallable()");
  }

  public OperationCallable<DeleteScheduleRequest, Empty, OperationMetadata>
      deleteScheduleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteScheduleOperationCallable()");
  }

  public UnaryCallable<DeleteScheduleRequest, Operation> deleteScheduleCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteScheduleCallable()");
  }

  public OperationCallable<CreateScheduleRequest, Schedule, OperationMetadata>
      createScheduleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createScheduleOperationCallable()");
  }

  public UnaryCallable<CreateScheduleRequest, Operation> createScheduleCallable() {
    throw new UnsupportedOperationException("Not implemented: createScheduleCallable()");
  }

  public OperationCallable<TriggerScheduleRequest, Schedule, OperationMetadata>
      triggerScheduleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: triggerScheduleOperationCallable()");
  }

  public UnaryCallable<TriggerScheduleRequest, Operation> triggerScheduleCallable() {
    throw new UnsupportedOperationException("Not implemented: triggerScheduleCallable()");
  }

  public UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listExecutionsPagedCallable()");
  }

  public UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listExecutionsCallable()");
  }

  public UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable() {
    throw new UnsupportedOperationException("Not implemented: getExecutionCallable()");
  }

  public OperationCallable<DeleteExecutionRequest, Empty, OperationMetadata>
      deleteExecutionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExecutionOperationCallable()");
  }

  public UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExecutionCallable()");
  }

  public OperationCallable<CreateExecutionRequest, Execution, OperationMetadata>
      createExecutionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createExecutionOperationCallable()");
  }

  public UnaryCallable<CreateExecutionRequest, Operation> createExecutionCallable() {
    throw new UnsupportedOperationException("Not implemented: createExecutionCallable()");
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
