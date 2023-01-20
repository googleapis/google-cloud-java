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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
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
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the NotebookService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcNotebookServiceStub extends NotebookServiceStub {
  private static final MethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          MethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/ListInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstancesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInstanceRequest, Instance> getInstanceMethodDescriptor =
      MethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.notebooks.v1.NotebookService/GetInstance")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInstanceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Instance.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          MethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/CreateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RegisterInstanceRequest, Operation>
      registerInstanceMethodDescriptor =
          MethodDescriptor.<RegisterInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/RegisterInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RegisterInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetInstanceAcceleratorRequest, Operation>
      setInstanceAcceleratorMethodDescriptor =
          MethodDescriptor.<SetInstanceAcceleratorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/SetInstanceAccelerator")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetInstanceAcceleratorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetInstanceMachineTypeRequest, Operation>
      setInstanceMachineTypeMethodDescriptor =
          MethodDescriptor.<SetInstanceMachineTypeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/SetInstanceMachineType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetInstanceMachineTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateInstanceConfigRequest, Operation>
      updateInstanceConfigMethodDescriptor =
          MethodDescriptor.<UpdateInstanceConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/UpdateInstanceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInstanceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateShieldedInstanceConfigRequest, Operation>
      updateShieldedInstanceConfigMethodDescriptor =
          MethodDescriptor.<UpdateShieldedInstanceConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.notebooks.v1.NotebookService/UpdateShieldedInstanceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateShieldedInstanceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetInstanceLabelsRequest, Operation>
      setInstanceLabelsMethodDescriptor =
          MethodDescriptor.<SetInstanceLabelsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/SetInstanceLabels")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetInstanceLabelsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          UpdateInstanceMetadataItemsRequest, UpdateInstanceMetadataItemsResponse>
      updateInstanceMetadataItemsMethodDescriptor =
          MethodDescriptor
              .<UpdateInstanceMetadataItemsRequest, UpdateInstanceMetadataItemsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.notebooks.v1.NotebookService/UpdateInstanceMetadataItems")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInstanceMetadataItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UpdateInstanceMetadataItemsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteInstanceRequest, Operation>
      deleteInstanceMethodDescriptor =
          MethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/DeleteInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StartInstanceRequest, Operation>
      startInstanceMethodDescriptor =
          MethodDescriptor.<StartInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/StartInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StopInstanceRequest, Operation>
      stopInstanceMethodDescriptor =
          MethodDescriptor.<StopInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/StopInstance")
              .setRequestMarshaller(ProtoUtils.marshaller(StopInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResetInstanceRequest, Operation>
      resetInstanceMethodDescriptor =
          MethodDescriptor.<ResetInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/ResetInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResetInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReportInstanceInfoRequest, Operation>
      reportInstanceInfoMethodDescriptor =
          MethodDescriptor.<ReportInstanceInfoRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/ReportInstanceInfo")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReportInstanceInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<IsInstanceUpgradeableRequest, IsInstanceUpgradeableResponse>
      isInstanceUpgradeableMethodDescriptor =
          MethodDescriptor.<IsInstanceUpgradeableRequest, IsInstanceUpgradeableResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/IsInstanceUpgradeable")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(IsInstanceUpgradeableRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(IsInstanceUpgradeableResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInstanceHealthRequest, GetInstanceHealthResponse>
      getInstanceHealthMethodDescriptor =
          MethodDescriptor.<GetInstanceHealthRequest, GetInstanceHealthResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/GetInstanceHealth")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetInstanceHealthRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GetInstanceHealthResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpgradeInstanceRequest, Operation>
      upgradeInstanceMethodDescriptor =
          MethodDescriptor.<UpgradeInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/UpgradeInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpgradeInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RollbackInstanceRequest, Operation>
      rollbackInstanceMethodDescriptor =
          MethodDescriptor.<RollbackInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/RollbackInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RollbackInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DiagnoseInstanceRequest, Operation>
      diagnoseInstanceMethodDescriptor =
          MethodDescriptor.<DiagnoseInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/DiagnoseInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DiagnoseInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpgradeInstanceInternalRequest, Operation>
      upgradeInstanceInternalMethodDescriptor =
          MethodDescriptor.<UpgradeInstanceInternalRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.notebooks.v1.NotebookService/UpgradeInstanceInternal")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpgradeInstanceInternalRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsMethodDescriptor =
          MethodDescriptor.<ListEnvironmentsRequest, ListEnvironmentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/ListEnvironments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEnvironmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEnvironmentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEnvironmentRequest, Environment>
      getEnvironmentMethodDescriptor =
          MethodDescriptor.<GetEnvironmentRequest, Environment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/GetEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Environment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateEnvironmentRequest, Operation>
      createEnvironmentMethodDescriptor =
          MethodDescriptor.<CreateEnvironmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/CreateEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEnvironmentRequest, Operation>
      deleteEnvironmentMethodDescriptor =
          MethodDescriptor.<DeleteEnvironmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/DeleteEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSchedulesRequest, ListSchedulesResponse>
      listSchedulesMethodDescriptor =
          MethodDescriptor.<ListSchedulesRequest, ListSchedulesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/ListSchedules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSchedulesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSchedulesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetScheduleRequest, Schedule> getScheduleMethodDescriptor =
      MethodDescriptor.<GetScheduleRequest, Schedule>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.notebooks.v1.NotebookService/GetSchedule")
          .setRequestMarshaller(ProtoUtils.marshaller(GetScheduleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Schedule.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteScheduleRequest, Operation>
      deleteScheduleMethodDescriptor =
          MethodDescriptor.<DeleteScheduleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/DeleteSchedule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateScheduleRequest, Operation>
      createScheduleMethodDescriptor =
          MethodDescriptor.<CreateScheduleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/CreateSchedule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<TriggerScheduleRequest, Operation>
      triggerScheduleMethodDescriptor =
          MethodDescriptor.<TriggerScheduleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/TriggerSchedule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TriggerScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListExecutionsRequest, ListExecutionsResponse>
      listExecutionsMethodDescriptor =
          MethodDescriptor.<ListExecutionsRequest, ListExecutionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/ListExecutions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExecutionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExecutionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetExecutionRequest, Execution>
      getExecutionMethodDescriptor =
          MethodDescriptor.<GetExecutionRequest, Execution>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/GetExecution")
              .setRequestMarshaller(ProtoUtils.marshaller(GetExecutionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Execution.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteExecutionRequest, Operation>
      deleteExecutionMethodDescriptor =
          MethodDescriptor.<DeleteExecutionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/DeleteExecution")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteExecutionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateExecutionRequest, Operation>
      createExecutionMethodDescriptor =
          MethodDescriptor.<CreateExecutionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.NotebookService/CreateExecution")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateExecutionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable;
  private final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable;
  private final UnaryCallable<RegisterInstanceRequest, Operation> registerInstanceCallable;
  private final OperationCallable<RegisterInstanceRequest, Instance, OperationMetadata>
      registerInstanceOperationCallable;
  private final UnaryCallable<SetInstanceAcceleratorRequest, Operation>
      setInstanceAcceleratorCallable;
  private final OperationCallable<SetInstanceAcceleratorRequest, Instance, OperationMetadata>
      setInstanceAcceleratorOperationCallable;
  private final UnaryCallable<SetInstanceMachineTypeRequest, Operation>
      setInstanceMachineTypeCallable;
  private final OperationCallable<SetInstanceMachineTypeRequest, Instance, OperationMetadata>
      setInstanceMachineTypeOperationCallable;
  private final UnaryCallable<UpdateInstanceConfigRequest, Operation> updateInstanceConfigCallable;
  private final OperationCallable<UpdateInstanceConfigRequest, Instance, OperationMetadata>
      updateInstanceConfigOperationCallable;
  private final UnaryCallable<UpdateShieldedInstanceConfigRequest, Operation>
      updateShieldedInstanceConfigCallable;
  private final OperationCallable<UpdateShieldedInstanceConfigRequest, Instance, OperationMetadata>
      updateShieldedInstanceConfigOperationCallable;
  private final UnaryCallable<SetInstanceLabelsRequest, Operation> setInstanceLabelsCallable;
  private final OperationCallable<SetInstanceLabelsRequest, Instance, OperationMetadata>
      setInstanceLabelsOperationCallable;
  private final UnaryCallable<
          UpdateInstanceMetadataItemsRequest, UpdateInstanceMetadataItemsResponse>
      updateInstanceMetadataItemsCallable;
  private final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable;
  private final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable;
  private final UnaryCallable<StartInstanceRequest, Operation> startInstanceCallable;
  private final OperationCallable<StartInstanceRequest, Instance, OperationMetadata>
      startInstanceOperationCallable;
  private final UnaryCallable<StopInstanceRequest, Operation> stopInstanceCallable;
  private final OperationCallable<StopInstanceRequest, Instance, OperationMetadata>
      stopInstanceOperationCallable;
  private final UnaryCallable<ResetInstanceRequest, Operation> resetInstanceCallable;
  private final OperationCallable<ResetInstanceRequest, Instance, OperationMetadata>
      resetInstanceOperationCallable;
  private final UnaryCallable<ReportInstanceInfoRequest, Operation> reportInstanceInfoCallable;
  private final OperationCallable<ReportInstanceInfoRequest, Instance, OperationMetadata>
      reportInstanceInfoOperationCallable;
  private final UnaryCallable<IsInstanceUpgradeableRequest, IsInstanceUpgradeableResponse>
      isInstanceUpgradeableCallable;
  private final UnaryCallable<GetInstanceHealthRequest, GetInstanceHealthResponse>
      getInstanceHealthCallable;
  private final UnaryCallable<UpgradeInstanceRequest, Operation> upgradeInstanceCallable;
  private final OperationCallable<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationCallable;
  private final UnaryCallable<RollbackInstanceRequest, Operation> rollbackInstanceCallable;
  private final OperationCallable<RollbackInstanceRequest, Instance, OperationMetadata>
      rollbackInstanceOperationCallable;
  private final UnaryCallable<DiagnoseInstanceRequest, Operation> diagnoseInstanceCallable;
  private final OperationCallable<DiagnoseInstanceRequest, Instance, OperationMetadata>
      diagnoseInstanceOperationCallable;
  private final UnaryCallable<UpgradeInstanceInternalRequest, Operation>
      upgradeInstanceInternalCallable;
  private final OperationCallable<UpgradeInstanceInternalRequest, Instance, OperationMetadata>
      upgradeInstanceInternalOperationCallable;
  private final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable;
  private final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable;
  private final UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable;
  private final UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable;
  private final OperationCallable<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationCallable;
  private final UnaryCallable<DeleteEnvironmentRequest, Operation> deleteEnvironmentCallable;
  private final OperationCallable<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationCallable;
  private final UnaryCallable<ListSchedulesRequest, ListSchedulesResponse> listSchedulesCallable;
  private final UnaryCallable<ListSchedulesRequest, ListSchedulesPagedResponse>
      listSchedulesPagedCallable;
  private final UnaryCallable<GetScheduleRequest, Schedule> getScheduleCallable;
  private final UnaryCallable<DeleteScheduleRequest, Operation> deleteScheduleCallable;
  private final OperationCallable<DeleteScheduleRequest, Empty, OperationMetadata>
      deleteScheduleOperationCallable;
  private final UnaryCallable<CreateScheduleRequest, Operation> createScheduleCallable;
  private final OperationCallable<CreateScheduleRequest, Schedule, OperationMetadata>
      createScheduleOperationCallable;
  private final UnaryCallable<TriggerScheduleRequest, Operation> triggerScheduleCallable;
  private final OperationCallable<TriggerScheduleRequest, Schedule, OperationMetadata>
      triggerScheduleOperationCallable;
  private final UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable;
  private final UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable;
  private final UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable;
  private final UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable;
  private final OperationCallable<DeleteExecutionRequest, Empty, OperationMetadata>
      deleteExecutionOperationCallable;
  private final UnaryCallable<CreateExecutionRequest, Operation> createExecutionCallable;
  private final OperationCallable<CreateExecutionRequest, Execution, OperationMetadata>
      createExecutionOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcNotebookServiceStub create(NotebookServiceStubSettings settings)
      throws IOException {
    return new GrpcNotebookServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcNotebookServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcNotebookServiceStub(
        NotebookServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcNotebookServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcNotebookServiceStub(
        NotebookServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcNotebookServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcNotebookServiceStub(
      NotebookServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcNotebookServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcNotebookServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcNotebookServiceStub(
      NotebookServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListInstancesRequest, ListInstancesResponse> listInstancesTransportSettings =
        GrpcCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
            .setMethodDescriptor(listInstancesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        GrpcCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateInstanceRequest, Operation> createInstanceTransportSettings =
        GrpcCallSettings.<CreateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RegisterInstanceRequest, Operation> registerInstanceTransportSettings =
        GrpcCallSettings.<RegisterInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(registerInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetInstanceAcceleratorRequest, Operation>
        setInstanceAcceleratorTransportSettings =
            GrpcCallSettings.<SetInstanceAcceleratorRequest, Operation>newBuilder()
                .setMethodDescriptor(setInstanceAcceleratorMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SetInstanceMachineTypeRequest, Operation>
        setInstanceMachineTypeTransportSettings =
            GrpcCallSettings.<SetInstanceMachineTypeRequest, Operation>newBuilder()
                .setMethodDescriptor(setInstanceMachineTypeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateInstanceConfigRequest, Operation> updateInstanceConfigTransportSettings =
        GrpcCallSettings.<UpdateInstanceConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateShieldedInstanceConfigRequest, Operation>
        updateShieldedInstanceConfigTransportSettings =
            GrpcCallSettings.<UpdateShieldedInstanceConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(updateShieldedInstanceConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SetInstanceLabelsRequest, Operation> setInstanceLabelsTransportSettings =
        GrpcCallSettings.<SetInstanceLabelsRequest, Operation>newBuilder()
            .setMethodDescriptor(setInstanceLabelsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateInstanceMetadataItemsRequest, UpdateInstanceMetadataItemsResponse>
        updateInstanceMetadataItemsTransportSettings =
            GrpcCallSettings
                .<UpdateInstanceMetadataItemsRequest, UpdateInstanceMetadataItemsResponse>
                    newBuilder()
                .setMethodDescriptor(updateInstanceMetadataItemsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteInstanceRequest, Operation> deleteInstanceTransportSettings =
        GrpcCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StartInstanceRequest, Operation> startInstanceTransportSettings =
        GrpcCallSettings.<StartInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(startInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StopInstanceRequest, Operation> stopInstanceTransportSettings =
        GrpcCallSettings.<StopInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(stopInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ResetInstanceRequest, Operation> resetInstanceTransportSettings =
        GrpcCallSettings.<ResetInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(resetInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ReportInstanceInfoRequest, Operation> reportInstanceInfoTransportSettings =
        GrpcCallSettings.<ReportInstanceInfoRequest, Operation>newBuilder()
            .setMethodDescriptor(reportInstanceInfoMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<IsInstanceUpgradeableRequest, IsInstanceUpgradeableResponse>
        isInstanceUpgradeableTransportSettings =
            GrpcCallSettings
                .<IsInstanceUpgradeableRequest, IsInstanceUpgradeableResponse>newBuilder()
                .setMethodDescriptor(isInstanceUpgradeableMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "notebook_instance", String.valueOf(request.getNotebookInstance()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetInstanceHealthRequest, GetInstanceHealthResponse>
        getInstanceHealthTransportSettings =
            GrpcCallSettings.<GetInstanceHealthRequest, GetInstanceHealthResponse>newBuilder()
                .setMethodDescriptor(getInstanceHealthMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpgradeInstanceRequest, Operation> upgradeInstanceTransportSettings =
        GrpcCallSettings.<UpgradeInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(upgradeInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RollbackInstanceRequest, Operation> rollbackInstanceTransportSettings =
        GrpcCallSettings.<RollbackInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(rollbackInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DiagnoseInstanceRequest, Operation> diagnoseInstanceTransportSettings =
        GrpcCallSettings.<DiagnoseInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(diagnoseInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpgradeInstanceInternalRequest, Operation>
        upgradeInstanceInternalTransportSettings =
            GrpcCallSettings.<UpgradeInstanceInternalRequest, Operation>newBuilder()
                .setMethodDescriptor(upgradeInstanceInternalMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListEnvironmentsRequest, ListEnvironmentsResponse>
        listEnvironmentsTransportSettings =
            GrpcCallSettings.<ListEnvironmentsRequest, ListEnvironmentsResponse>newBuilder()
                .setMethodDescriptor(listEnvironmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetEnvironmentRequest, Environment> getEnvironmentTransportSettings =
        GrpcCallSettings.<GetEnvironmentRequest, Environment>newBuilder()
            .setMethodDescriptor(getEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentTransportSettings =
        GrpcCallSettings.<CreateEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(createEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteEnvironmentRequest, Operation> deleteEnvironmentTransportSettings =
        GrpcCallSettings.<DeleteEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListSchedulesRequest, ListSchedulesResponse> listSchedulesTransportSettings =
        GrpcCallSettings.<ListSchedulesRequest, ListSchedulesResponse>newBuilder()
            .setMethodDescriptor(listSchedulesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetScheduleRequest, Schedule> getScheduleTransportSettings =
        GrpcCallSettings.<GetScheduleRequest, Schedule>newBuilder()
            .setMethodDescriptor(getScheduleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteScheduleRequest, Operation> deleteScheduleTransportSettings =
        GrpcCallSettings.<DeleteScheduleRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteScheduleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateScheduleRequest, Operation> createScheduleTransportSettings =
        GrpcCallSettings.<CreateScheduleRequest, Operation>newBuilder()
            .setMethodDescriptor(createScheduleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TriggerScheduleRequest, Operation> triggerScheduleTransportSettings =
        GrpcCallSettings.<TriggerScheduleRequest, Operation>newBuilder()
            .setMethodDescriptor(triggerScheduleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListExecutionsRequest, ListExecutionsResponse>
        listExecutionsTransportSettings =
            GrpcCallSettings.<ListExecutionsRequest, ListExecutionsResponse>newBuilder()
                .setMethodDescriptor(listExecutionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetExecutionRequest, Execution> getExecutionTransportSettings =
        GrpcCallSettings.<GetExecutionRequest, Execution>newBuilder()
            .setMethodDescriptor(getExecutionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteExecutionRequest, Operation> deleteExecutionTransportSettings =
        GrpcCallSettings.<DeleteExecutionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteExecutionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateExecutionRequest, Operation> createExecutionTransportSettings =
        GrpcCallSettings.<CreateExecutionRequest, Operation>newBuilder()
            .setMethodDescriptor(createExecutionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource", String.valueOf(request.getResource()));
                      return params.build();
                    })
                .build();

    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.createInstanceCallable =
        callableFactory.createUnaryCallable(
            createInstanceTransportSettings, settings.createInstanceSettings(), clientContext);
    this.createInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createInstanceTransportSettings,
            settings.createInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.registerInstanceCallable =
        callableFactory.createUnaryCallable(
            registerInstanceTransportSettings, settings.registerInstanceSettings(), clientContext);
    this.registerInstanceOperationCallable =
        callableFactory.createOperationCallable(
            registerInstanceTransportSettings,
            settings.registerInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.setInstanceAcceleratorCallable =
        callableFactory.createUnaryCallable(
            setInstanceAcceleratorTransportSettings,
            settings.setInstanceAcceleratorSettings(),
            clientContext);
    this.setInstanceAcceleratorOperationCallable =
        callableFactory.createOperationCallable(
            setInstanceAcceleratorTransportSettings,
            settings.setInstanceAcceleratorOperationSettings(),
            clientContext,
            operationsStub);
    this.setInstanceMachineTypeCallable =
        callableFactory.createUnaryCallable(
            setInstanceMachineTypeTransportSettings,
            settings.setInstanceMachineTypeSettings(),
            clientContext);
    this.setInstanceMachineTypeOperationCallable =
        callableFactory.createOperationCallable(
            setInstanceMachineTypeTransportSettings,
            settings.setInstanceMachineTypeOperationSettings(),
            clientContext,
            operationsStub);
    this.updateInstanceConfigCallable =
        callableFactory.createUnaryCallable(
            updateInstanceConfigTransportSettings,
            settings.updateInstanceConfigSettings(),
            clientContext);
    this.updateInstanceConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateInstanceConfigTransportSettings,
            settings.updateInstanceConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.updateShieldedInstanceConfigCallable =
        callableFactory.createUnaryCallable(
            updateShieldedInstanceConfigTransportSettings,
            settings.updateShieldedInstanceConfigSettings(),
            clientContext);
    this.updateShieldedInstanceConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateShieldedInstanceConfigTransportSettings,
            settings.updateShieldedInstanceConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.setInstanceLabelsCallable =
        callableFactory.createUnaryCallable(
            setInstanceLabelsTransportSettings,
            settings.setInstanceLabelsSettings(),
            clientContext);
    this.setInstanceLabelsOperationCallable =
        callableFactory.createOperationCallable(
            setInstanceLabelsTransportSettings,
            settings.setInstanceLabelsOperationSettings(),
            clientContext,
            operationsStub);
    this.updateInstanceMetadataItemsCallable =
        callableFactory.createUnaryCallable(
            updateInstanceMetadataItemsTransportSettings,
            settings.updateInstanceMetadataItemsSettings(),
            clientContext);
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
    this.deleteInstanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteInstanceTransportSettings,
            settings.deleteInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.startInstanceCallable =
        callableFactory.createUnaryCallable(
            startInstanceTransportSettings, settings.startInstanceSettings(), clientContext);
    this.startInstanceOperationCallable =
        callableFactory.createOperationCallable(
            startInstanceTransportSettings,
            settings.startInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.stopInstanceCallable =
        callableFactory.createUnaryCallable(
            stopInstanceTransportSettings, settings.stopInstanceSettings(), clientContext);
    this.stopInstanceOperationCallable =
        callableFactory.createOperationCallable(
            stopInstanceTransportSettings,
            settings.stopInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.resetInstanceCallable =
        callableFactory.createUnaryCallable(
            resetInstanceTransportSettings, settings.resetInstanceSettings(), clientContext);
    this.resetInstanceOperationCallable =
        callableFactory.createOperationCallable(
            resetInstanceTransportSettings,
            settings.resetInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.reportInstanceInfoCallable =
        callableFactory.createUnaryCallable(
            reportInstanceInfoTransportSettings,
            settings.reportInstanceInfoSettings(),
            clientContext);
    this.reportInstanceInfoOperationCallable =
        callableFactory.createOperationCallable(
            reportInstanceInfoTransportSettings,
            settings.reportInstanceInfoOperationSettings(),
            clientContext,
            operationsStub);
    this.isInstanceUpgradeableCallable =
        callableFactory.createUnaryCallable(
            isInstanceUpgradeableTransportSettings,
            settings.isInstanceUpgradeableSettings(),
            clientContext);
    this.getInstanceHealthCallable =
        callableFactory.createUnaryCallable(
            getInstanceHealthTransportSettings,
            settings.getInstanceHealthSettings(),
            clientContext);
    this.upgradeInstanceCallable =
        callableFactory.createUnaryCallable(
            upgradeInstanceTransportSettings, settings.upgradeInstanceSettings(), clientContext);
    this.upgradeInstanceOperationCallable =
        callableFactory.createOperationCallable(
            upgradeInstanceTransportSettings,
            settings.upgradeInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.rollbackInstanceCallable =
        callableFactory.createUnaryCallable(
            rollbackInstanceTransportSettings, settings.rollbackInstanceSettings(), clientContext);
    this.rollbackInstanceOperationCallable =
        callableFactory.createOperationCallable(
            rollbackInstanceTransportSettings,
            settings.rollbackInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.diagnoseInstanceCallable =
        callableFactory.createUnaryCallable(
            diagnoseInstanceTransportSettings, settings.diagnoseInstanceSettings(), clientContext);
    this.diagnoseInstanceOperationCallable =
        callableFactory.createOperationCallable(
            diagnoseInstanceTransportSettings,
            settings.diagnoseInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.upgradeInstanceInternalCallable =
        callableFactory.createUnaryCallable(
            upgradeInstanceInternalTransportSettings,
            settings.upgradeInstanceInternalSettings(),
            clientContext);
    this.upgradeInstanceInternalOperationCallable =
        callableFactory.createOperationCallable(
            upgradeInstanceInternalTransportSettings,
            settings.upgradeInstanceInternalOperationSettings(),
            clientContext,
            operationsStub);
    this.listEnvironmentsCallable =
        callableFactory.createUnaryCallable(
            listEnvironmentsTransportSettings, settings.listEnvironmentsSettings(), clientContext);
    this.listEnvironmentsPagedCallable =
        callableFactory.createPagedCallable(
            listEnvironmentsTransportSettings, settings.listEnvironmentsSettings(), clientContext);
    this.getEnvironmentCallable =
        callableFactory.createUnaryCallable(
            getEnvironmentTransportSettings, settings.getEnvironmentSettings(), clientContext);
    this.createEnvironmentCallable =
        callableFactory.createUnaryCallable(
            createEnvironmentTransportSettings,
            settings.createEnvironmentSettings(),
            clientContext);
    this.createEnvironmentOperationCallable =
        callableFactory.createOperationCallable(
            createEnvironmentTransportSettings,
            settings.createEnvironmentOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteEnvironmentCallable =
        callableFactory.createUnaryCallable(
            deleteEnvironmentTransportSettings,
            settings.deleteEnvironmentSettings(),
            clientContext);
    this.deleteEnvironmentOperationCallable =
        callableFactory.createOperationCallable(
            deleteEnvironmentTransportSettings,
            settings.deleteEnvironmentOperationSettings(),
            clientContext,
            operationsStub);
    this.listSchedulesCallable =
        callableFactory.createUnaryCallable(
            listSchedulesTransportSettings, settings.listSchedulesSettings(), clientContext);
    this.listSchedulesPagedCallable =
        callableFactory.createPagedCallable(
            listSchedulesTransportSettings, settings.listSchedulesSettings(), clientContext);
    this.getScheduleCallable =
        callableFactory.createUnaryCallable(
            getScheduleTransportSettings, settings.getScheduleSettings(), clientContext);
    this.deleteScheduleCallable =
        callableFactory.createUnaryCallable(
            deleteScheduleTransportSettings, settings.deleteScheduleSettings(), clientContext);
    this.deleteScheduleOperationCallable =
        callableFactory.createOperationCallable(
            deleteScheduleTransportSettings,
            settings.deleteScheduleOperationSettings(),
            clientContext,
            operationsStub);
    this.createScheduleCallable =
        callableFactory.createUnaryCallable(
            createScheduleTransportSettings, settings.createScheduleSettings(), clientContext);
    this.createScheduleOperationCallable =
        callableFactory.createOperationCallable(
            createScheduleTransportSettings,
            settings.createScheduleOperationSettings(),
            clientContext,
            operationsStub);
    this.triggerScheduleCallable =
        callableFactory.createUnaryCallable(
            triggerScheduleTransportSettings, settings.triggerScheduleSettings(), clientContext);
    this.triggerScheduleOperationCallable =
        callableFactory.createOperationCallable(
            triggerScheduleTransportSettings,
            settings.triggerScheduleOperationSettings(),
            clientContext,
            operationsStub);
    this.listExecutionsCallable =
        callableFactory.createUnaryCallable(
            listExecutionsTransportSettings, settings.listExecutionsSettings(), clientContext);
    this.listExecutionsPagedCallable =
        callableFactory.createPagedCallable(
            listExecutionsTransportSettings, settings.listExecutionsSettings(), clientContext);
    this.getExecutionCallable =
        callableFactory.createUnaryCallable(
            getExecutionTransportSettings, settings.getExecutionSettings(), clientContext);
    this.deleteExecutionCallable =
        callableFactory.createUnaryCallable(
            deleteExecutionTransportSettings, settings.deleteExecutionSettings(), clientContext);
    this.deleteExecutionOperationCallable =
        callableFactory.createOperationCallable(
            deleteExecutionTransportSettings,
            settings.deleteExecutionOperationSettings(),
            clientContext,
            operationsStub);
    this.createExecutionCallable =
        callableFactory.createUnaryCallable(
            createExecutionTransportSettings, settings.createExecutionSettings(), clientContext);
    this.createExecutionOperationCallable =
        callableFactory.createOperationCallable(
            createExecutionTransportSettings,
            settings.createExecutionOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  @Override
  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return createInstanceCallable;
  }

  @Override
  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return createInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<RegisterInstanceRequest, Operation> registerInstanceCallable() {
    return registerInstanceCallable;
  }

  @Override
  public OperationCallable<RegisterInstanceRequest, Instance, OperationMetadata>
      registerInstanceOperationCallable() {
    return registerInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<SetInstanceAcceleratorRequest, Operation> setInstanceAcceleratorCallable() {
    return setInstanceAcceleratorCallable;
  }

  @Override
  public OperationCallable<SetInstanceAcceleratorRequest, Instance, OperationMetadata>
      setInstanceAcceleratorOperationCallable() {
    return setInstanceAcceleratorOperationCallable;
  }

  @Override
  public UnaryCallable<SetInstanceMachineTypeRequest, Operation> setInstanceMachineTypeCallable() {
    return setInstanceMachineTypeCallable;
  }

  @Override
  public OperationCallable<SetInstanceMachineTypeRequest, Instance, OperationMetadata>
      setInstanceMachineTypeOperationCallable() {
    return setInstanceMachineTypeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInstanceConfigRequest, Operation> updateInstanceConfigCallable() {
    return updateInstanceConfigCallable;
  }

  @Override
  public OperationCallable<UpdateInstanceConfigRequest, Instance, OperationMetadata>
      updateInstanceConfigOperationCallable() {
    return updateInstanceConfigOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateShieldedInstanceConfigRequest, Operation>
      updateShieldedInstanceConfigCallable() {
    return updateShieldedInstanceConfigCallable;
  }

  @Override
  public OperationCallable<UpdateShieldedInstanceConfigRequest, Instance, OperationMetadata>
      updateShieldedInstanceConfigOperationCallable() {
    return updateShieldedInstanceConfigOperationCallable;
  }

  @Override
  public UnaryCallable<SetInstanceLabelsRequest, Operation> setInstanceLabelsCallable() {
    return setInstanceLabelsCallable;
  }

  @Override
  public OperationCallable<SetInstanceLabelsRequest, Instance, OperationMetadata>
      setInstanceLabelsOperationCallable() {
    return setInstanceLabelsOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInstanceMetadataItemsRequest, UpdateInstanceMetadataItemsResponse>
      updateInstanceMetadataItemsCallable() {
    return updateInstanceMetadataItemsCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return deleteInstanceCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return deleteInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<StartInstanceRequest, Operation> startInstanceCallable() {
    return startInstanceCallable;
  }

  @Override
  public OperationCallable<StartInstanceRequest, Instance, OperationMetadata>
      startInstanceOperationCallable() {
    return startInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<StopInstanceRequest, Operation> stopInstanceCallable() {
    return stopInstanceCallable;
  }

  @Override
  public OperationCallable<StopInstanceRequest, Instance, OperationMetadata>
      stopInstanceOperationCallable() {
    return stopInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<ResetInstanceRequest, Operation> resetInstanceCallable() {
    return resetInstanceCallable;
  }

  @Override
  public OperationCallable<ResetInstanceRequest, Instance, OperationMetadata>
      resetInstanceOperationCallable() {
    return resetInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<ReportInstanceInfoRequest, Operation> reportInstanceInfoCallable() {
    return reportInstanceInfoCallable;
  }

  @Override
  public OperationCallable<ReportInstanceInfoRequest, Instance, OperationMetadata>
      reportInstanceInfoOperationCallable() {
    return reportInstanceInfoOperationCallable;
  }

  @Override
  public UnaryCallable<IsInstanceUpgradeableRequest, IsInstanceUpgradeableResponse>
      isInstanceUpgradeableCallable() {
    return isInstanceUpgradeableCallable;
  }

  @Override
  public UnaryCallable<GetInstanceHealthRequest, GetInstanceHealthResponse>
      getInstanceHealthCallable() {
    return getInstanceHealthCallable;
  }

  @Override
  public UnaryCallable<UpgradeInstanceRequest, Operation> upgradeInstanceCallable() {
    return upgradeInstanceCallable;
  }

  @Override
  public OperationCallable<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationCallable() {
    return upgradeInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<RollbackInstanceRequest, Operation> rollbackInstanceCallable() {
    return rollbackInstanceCallable;
  }

  @Override
  public OperationCallable<RollbackInstanceRequest, Instance, OperationMetadata>
      rollbackInstanceOperationCallable() {
    return rollbackInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<DiagnoseInstanceRequest, Operation> diagnoseInstanceCallable() {
    return diagnoseInstanceCallable;
  }

  @Override
  public OperationCallable<DiagnoseInstanceRequest, Instance, OperationMetadata>
      diagnoseInstanceOperationCallable() {
    return diagnoseInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<UpgradeInstanceInternalRequest, Operation>
      upgradeInstanceInternalCallable() {
    return upgradeInstanceInternalCallable;
  }

  @Override
  public OperationCallable<UpgradeInstanceInternalRequest, Instance, OperationMetadata>
      upgradeInstanceInternalOperationCallable() {
    return upgradeInstanceInternalOperationCallable;
  }

  @Override
  public UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable() {
    return listEnvironmentsCallable;
  }

  @Override
  public UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable() {
    return listEnvironmentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    return getEnvironmentCallable;
  }

  @Override
  public UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable() {
    return createEnvironmentCallable;
  }

  @Override
  public OperationCallable<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationCallable() {
    return createEnvironmentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEnvironmentRequest, Operation> deleteEnvironmentCallable() {
    return deleteEnvironmentCallable;
  }

  @Override
  public OperationCallable<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationCallable() {
    return deleteEnvironmentOperationCallable;
  }

  @Override
  public UnaryCallable<ListSchedulesRequest, ListSchedulesResponse> listSchedulesCallable() {
    return listSchedulesCallable;
  }

  @Override
  public UnaryCallable<ListSchedulesRequest, ListSchedulesPagedResponse>
      listSchedulesPagedCallable() {
    return listSchedulesPagedCallable;
  }

  @Override
  public UnaryCallable<GetScheduleRequest, Schedule> getScheduleCallable() {
    return getScheduleCallable;
  }

  @Override
  public UnaryCallable<DeleteScheduleRequest, Operation> deleteScheduleCallable() {
    return deleteScheduleCallable;
  }

  @Override
  public OperationCallable<DeleteScheduleRequest, Empty, OperationMetadata>
      deleteScheduleOperationCallable() {
    return deleteScheduleOperationCallable;
  }

  @Override
  public UnaryCallable<CreateScheduleRequest, Operation> createScheduleCallable() {
    return createScheduleCallable;
  }

  @Override
  public OperationCallable<CreateScheduleRequest, Schedule, OperationMetadata>
      createScheduleOperationCallable() {
    return createScheduleOperationCallable;
  }

  @Override
  public UnaryCallable<TriggerScheduleRequest, Operation> triggerScheduleCallable() {
    return triggerScheduleCallable;
  }

  @Override
  public OperationCallable<TriggerScheduleRequest, Schedule, OperationMetadata>
      triggerScheduleOperationCallable() {
    return triggerScheduleOperationCallable;
  }

  @Override
  public UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable() {
    return listExecutionsCallable;
  }

  @Override
  public UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable() {
    return listExecutionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable() {
    return getExecutionCallable;
  }

  @Override
  public UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable() {
    return deleteExecutionCallable;
  }

  @Override
  public OperationCallable<DeleteExecutionRequest, Empty, OperationMetadata>
      deleteExecutionOperationCallable() {
    return deleteExecutionOperationCallable;
  }

  @Override
  public UnaryCallable<CreateExecutionRequest, Operation> createExecutionCallable() {
    return createExecutionCallable;
  }

  @Override
  public OperationCallable<CreateExecutionRequest, Execution, OperationMetadata>
      createExecutionOperationCallable() {
    return createExecutionOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
