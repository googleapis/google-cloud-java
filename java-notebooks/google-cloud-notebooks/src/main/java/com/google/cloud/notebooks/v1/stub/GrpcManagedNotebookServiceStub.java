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

import static com.google.cloud.notebooks.v1.ManagedNotebookServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.notebooks.v1.ManagedNotebookServiceClient.ListRuntimesPagedResponse;

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
import com.google.cloud.notebooks.v1.CreateRuntimeRequest;
import com.google.cloud.notebooks.v1.DeleteRuntimeRequest;
import com.google.cloud.notebooks.v1.DiagnoseRuntimeRequest;
import com.google.cloud.notebooks.v1.GetRuntimeRequest;
import com.google.cloud.notebooks.v1.ListRuntimesRequest;
import com.google.cloud.notebooks.v1.ListRuntimesResponse;
import com.google.cloud.notebooks.v1.OperationMetadata;
import com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalRequest;
import com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalResponse;
import com.google.cloud.notebooks.v1.ReportRuntimeEventRequest;
import com.google.cloud.notebooks.v1.ResetRuntimeRequest;
import com.google.cloud.notebooks.v1.Runtime;
import com.google.cloud.notebooks.v1.StartRuntimeRequest;
import com.google.cloud.notebooks.v1.StopRuntimeRequest;
import com.google.cloud.notebooks.v1.SwitchRuntimeRequest;
import com.google.cloud.notebooks.v1.UpdateRuntimeRequest;
import com.google.cloud.notebooks.v1.UpgradeRuntimeRequest;
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
 * gRPC stub implementation for the ManagedNotebookService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcManagedNotebookServiceStub extends ManagedNotebookServiceStub {
  private static final MethodDescriptor<ListRuntimesRequest, ListRuntimesResponse>
      listRuntimesMethodDescriptor =
          MethodDescriptor.<ListRuntimesRequest, ListRuntimesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.ManagedNotebookService/ListRuntimes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRuntimesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRuntimesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRuntimeRequest, Runtime> getRuntimeMethodDescriptor =
      MethodDescriptor.<GetRuntimeRequest, Runtime>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.notebooks.v1.ManagedNotebookService/GetRuntime")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRuntimeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Runtime.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateRuntimeRequest, Operation>
      createRuntimeMethodDescriptor =
          MethodDescriptor.<CreateRuntimeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.ManagedNotebookService/CreateRuntime")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateRuntimeRequest, Operation>
      updateRuntimeMethodDescriptor =
          MethodDescriptor.<UpdateRuntimeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.ManagedNotebookService/UpdateRuntime")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRuntimeRequest, Operation>
      deleteRuntimeMethodDescriptor =
          MethodDescriptor.<DeleteRuntimeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.ManagedNotebookService/DeleteRuntime")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StartRuntimeRequest, Operation>
      startRuntimeMethodDescriptor =
          MethodDescriptor.<StartRuntimeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.ManagedNotebookService/StartRuntime")
              .setRequestMarshaller(ProtoUtils.marshaller(StartRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StopRuntimeRequest, Operation> stopRuntimeMethodDescriptor =
      MethodDescriptor.<StopRuntimeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.notebooks.v1.ManagedNotebookService/StopRuntime")
          .setRequestMarshaller(ProtoUtils.marshaller(StopRuntimeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SwitchRuntimeRequest, Operation>
      switchRuntimeMethodDescriptor =
          MethodDescriptor.<SwitchRuntimeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.ManagedNotebookService/SwitchRuntime")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SwitchRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResetRuntimeRequest, Operation>
      resetRuntimeMethodDescriptor =
          MethodDescriptor.<ResetRuntimeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.ManagedNotebookService/ResetRuntime")
              .setRequestMarshaller(ProtoUtils.marshaller(ResetRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpgradeRuntimeRequest, Operation>
      upgradeRuntimeMethodDescriptor =
          MethodDescriptor.<UpgradeRuntimeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.ManagedNotebookService/UpgradeRuntime")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpgradeRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReportRuntimeEventRequest, Operation>
      reportRuntimeEventMethodDescriptor =
          MethodDescriptor.<ReportRuntimeEventRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.notebooks.v1.ManagedNotebookService/ReportRuntimeEvent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReportRuntimeEventRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          RefreshRuntimeTokenInternalRequest, RefreshRuntimeTokenInternalResponse>
      refreshRuntimeTokenInternalMethodDescriptor =
          MethodDescriptor
              .<RefreshRuntimeTokenInternalRequest, RefreshRuntimeTokenInternalResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.notebooks.v1.ManagedNotebookService/RefreshRuntimeTokenInternal")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RefreshRuntimeTokenInternalRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RefreshRuntimeTokenInternalResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DiagnoseRuntimeRequest, Operation>
      diagnoseRuntimeMethodDescriptor =
          MethodDescriptor.<DiagnoseRuntimeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.notebooks.v1.ManagedNotebookService/DiagnoseRuntime")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DiagnoseRuntimeRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListRuntimesRequest, ListRuntimesResponse> listRuntimesCallable;
  private final UnaryCallable<ListRuntimesRequest, ListRuntimesPagedResponse>
      listRuntimesPagedCallable;
  private final UnaryCallable<GetRuntimeRequest, Runtime> getRuntimeCallable;
  private final UnaryCallable<CreateRuntimeRequest, Operation> createRuntimeCallable;
  private final OperationCallable<CreateRuntimeRequest, Runtime, OperationMetadata>
      createRuntimeOperationCallable;
  private final UnaryCallable<UpdateRuntimeRequest, Operation> updateRuntimeCallable;
  private final OperationCallable<UpdateRuntimeRequest, Runtime, OperationMetadata>
      updateRuntimeOperationCallable;
  private final UnaryCallable<DeleteRuntimeRequest, Operation> deleteRuntimeCallable;
  private final OperationCallable<DeleteRuntimeRequest, Empty, OperationMetadata>
      deleteRuntimeOperationCallable;
  private final UnaryCallable<StartRuntimeRequest, Operation> startRuntimeCallable;
  private final OperationCallable<StartRuntimeRequest, Runtime, OperationMetadata>
      startRuntimeOperationCallable;
  private final UnaryCallable<StopRuntimeRequest, Operation> stopRuntimeCallable;
  private final OperationCallable<StopRuntimeRequest, Runtime, OperationMetadata>
      stopRuntimeOperationCallable;
  private final UnaryCallable<SwitchRuntimeRequest, Operation> switchRuntimeCallable;
  private final OperationCallable<SwitchRuntimeRequest, Runtime, OperationMetadata>
      switchRuntimeOperationCallable;
  private final UnaryCallable<ResetRuntimeRequest, Operation> resetRuntimeCallable;
  private final OperationCallable<ResetRuntimeRequest, Runtime, OperationMetadata>
      resetRuntimeOperationCallable;
  private final UnaryCallable<UpgradeRuntimeRequest, Operation> upgradeRuntimeCallable;
  private final OperationCallable<UpgradeRuntimeRequest, Runtime, OperationMetadata>
      upgradeRuntimeOperationCallable;
  private final UnaryCallable<ReportRuntimeEventRequest, Operation> reportRuntimeEventCallable;
  private final OperationCallable<ReportRuntimeEventRequest, Runtime, OperationMetadata>
      reportRuntimeEventOperationCallable;
  private final UnaryCallable<
          RefreshRuntimeTokenInternalRequest, RefreshRuntimeTokenInternalResponse>
      refreshRuntimeTokenInternalCallable;
  private final UnaryCallable<DiagnoseRuntimeRequest, Operation> diagnoseRuntimeCallable;
  private final OperationCallable<DiagnoseRuntimeRequest, Runtime, OperationMetadata>
      diagnoseRuntimeOperationCallable;
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

  public static final GrpcManagedNotebookServiceStub create(
      ManagedNotebookServiceStubSettings settings) throws IOException {
    return new GrpcManagedNotebookServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcManagedNotebookServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcManagedNotebookServiceStub(
        ManagedNotebookServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcManagedNotebookServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcManagedNotebookServiceStub(
        ManagedNotebookServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcManagedNotebookServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcManagedNotebookServiceStub(
      ManagedNotebookServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcManagedNotebookServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcManagedNotebookServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcManagedNotebookServiceStub(
      ManagedNotebookServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListRuntimesRequest, ListRuntimesResponse> listRuntimesTransportSettings =
        GrpcCallSettings.<ListRuntimesRequest, ListRuntimesResponse>newBuilder()
            .setMethodDescriptor(listRuntimesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetRuntimeRequest, Runtime> getRuntimeTransportSettings =
        GrpcCallSettings.<GetRuntimeRequest, Runtime>newBuilder()
            .setMethodDescriptor(getRuntimeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateRuntimeRequest, Operation> createRuntimeTransportSettings =
        GrpcCallSettings.<CreateRuntimeRequest, Operation>newBuilder()
            .setMethodDescriptor(createRuntimeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateRuntimeRequest, Operation> updateRuntimeTransportSettings =
        GrpcCallSettings.<UpdateRuntimeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRuntimeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("runtime.name", String.valueOf(request.getRuntime().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteRuntimeRequest, Operation> deleteRuntimeTransportSettings =
        GrpcCallSettings.<DeleteRuntimeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRuntimeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StartRuntimeRequest, Operation> startRuntimeTransportSettings =
        GrpcCallSettings.<StartRuntimeRequest, Operation>newBuilder()
            .setMethodDescriptor(startRuntimeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StopRuntimeRequest, Operation> stopRuntimeTransportSettings =
        GrpcCallSettings.<StopRuntimeRequest, Operation>newBuilder()
            .setMethodDescriptor(stopRuntimeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SwitchRuntimeRequest, Operation> switchRuntimeTransportSettings =
        GrpcCallSettings.<SwitchRuntimeRequest, Operation>newBuilder()
            .setMethodDescriptor(switchRuntimeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ResetRuntimeRequest, Operation> resetRuntimeTransportSettings =
        GrpcCallSettings.<ResetRuntimeRequest, Operation>newBuilder()
            .setMethodDescriptor(resetRuntimeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpgradeRuntimeRequest, Operation> upgradeRuntimeTransportSettings =
        GrpcCallSettings.<UpgradeRuntimeRequest, Operation>newBuilder()
            .setMethodDescriptor(upgradeRuntimeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ReportRuntimeEventRequest, Operation> reportRuntimeEventTransportSettings =
        GrpcCallSettings.<ReportRuntimeEventRequest, Operation>newBuilder()
            .setMethodDescriptor(reportRuntimeEventMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RefreshRuntimeTokenInternalRequest, RefreshRuntimeTokenInternalResponse>
        refreshRuntimeTokenInternalTransportSettings =
            GrpcCallSettings
                .<RefreshRuntimeTokenInternalRequest, RefreshRuntimeTokenInternalResponse>
                    newBuilder()
                .setMethodDescriptor(refreshRuntimeTokenInternalMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DiagnoseRuntimeRequest, Operation> diagnoseRuntimeTransportSettings =
        GrpcCallSettings.<DiagnoseRuntimeRequest, Operation>newBuilder()
            .setMethodDescriptor(diagnoseRuntimeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
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

    this.listRuntimesCallable =
        callableFactory.createUnaryCallable(
            listRuntimesTransportSettings, settings.listRuntimesSettings(), clientContext);
    this.listRuntimesPagedCallable =
        callableFactory.createPagedCallable(
            listRuntimesTransportSettings, settings.listRuntimesSettings(), clientContext);
    this.getRuntimeCallable =
        callableFactory.createUnaryCallable(
            getRuntimeTransportSettings, settings.getRuntimeSettings(), clientContext);
    this.createRuntimeCallable =
        callableFactory.createUnaryCallable(
            createRuntimeTransportSettings, settings.createRuntimeSettings(), clientContext);
    this.createRuntimeOperationCallable =
        callableFactory.createOperationCallable(
            createRuntimeTransportSettings,
            settings.createRuntimeOperationSettings(),
            clientContext,
            operationsStub);
    this.updateRuntimeCallable =
        callableFactory.createUnaryCallable(
            updateRuntimeTransportSettings, settings.updateRuntimeSettings(), clientContext);
    this.updateRuntimeOperationCallable =
        callableFactory.createOperationCallable(
            updateRuntimeTransportSettings,
            settings.updateRuntimeOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteRuntimeCallable =
        callableFactory.createUnaryCallable(
            deleteRuntimeTransportSettings, settings.deleteRuntimeSettings(), clientContext);
    this.deleteRuntimeOperationCallable =
        callableFactory.createOperationCallable(
            deleteRuntimeTransportSettings,
            settings.deleteRuntimeOperationSettings(),
            clientContext,
            operationsStub);
    this.startRuntimeCallable =
        callableFactory.createUnaryCallable(
            startRuntimeTransportSettings, settings.startRuntimeSettings(), clientContext);
    this.startRuntimeOperationCallable =
        callableFactory.createOperationCallable(
            startRuntimeTransportSettings,
            settings.startRuntimeOperationSettings(),
            clientContext,
            operationsStub);
    this.stopRuntimeCallable =
        callableFactory.createUnaryCallable(
            stopRuntimeTransportSettings, settings.stopRuntimeSettings(), clientContext);
    this.stopRuntimeOperationCallable =
        callableFactory.createOperationCallable(
            stopRuntimeTransportSettings,
            settings.stopRuntimeOperationSettings(),
            clientContext,
            operationsStub);
    this.switchRuntimeCallable =
        callableFactory.createUnaryCallable(
            switchRuntimeTransportSettings, settings.switchRuntimeSettings(), clientContext);
    this.switchRuntimeOperationCallable =
        callableFactory.createOperationCallable(
            switchRuntimeTransportSettings,
            settings.switchRuntimeOperationSettings(),
            clientContext,
            operationsStub);
    this.resetRuntimeCallable =
        callableFactory.createUnaryCallable(
            resetRuntimeTransportSettings, settings.resetRuntimeSettings(), clientContext);
    this.resetRuntimeOperationCallable =
        callableFactory.createOperationCallable(
            resetRuntimeTransportSettings,
            settings.resetRuntimeOperationSettings(),
            clientContext,
            operationsStub);
    this.upgradeRuntimeCallable =
        callableFactory.createUnaryCallable(
            upgradeRuntimeTransportSettings, settings.upgradeRuntimeSettings(), clientContext);
    this.upgradeRuntimeOperationCallable =
        callableFactory.createOperationCallable(
            upgradeRuntimeTransportSettings,
            settings.upgradeRuntimeOperationSettings(),
            clientContext,
            operationsStub);
    this.reportRuntimeEventCallable =
        callableFactory.createUnaryCallable(
            reportRuntimeEventTransportSettings,
            settings.reportRuntimeEventSettings(),
            clientContext);
    this.reportRuntimeEventOperationCallable =
        callableFactory.createOperationCallable(
            reportRuntimeEventTransportSettings,
            settings.reportRuntimeEventOperationSettings(),
            clientContext,
            operationsStub);
    this.refreshRuntimeTokenInternalCallable =
        callableFactory.createUnaryCallable(
            refreshRuntimeTokenInternalTransportSettings,
            settings.refreshRuntimeTokenInternalSettings(),
            clientContext);
    this.diagnoseRuntimeCallable =
        callableFactory.createUnaryCallable(
            diagnoseRuntimeTransportSettings, settings.diagnoseRuntimeSettings(), clientContext);
    this.diagnoseRuntimeOperationCallable =
        callableFactory.createOperationCallable(
            diagnoseRuntimeTransportSettings,
            settings.diagnoseRuntimeOperationSettings(),
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
  public UnaryCallable<ListRuntimesRequest, ListRuntimesResponse> listRuntimesCallable() {
    return listRuntimesCallable;
  }

  @Override
  public UnaryCallable<ListRuntimesRequest, ListRuntimesPagedResponse> listRuntimesPagedCallable() {
    return listRuntimesPagedCallable;
  }

  @Override
  public UnaryCallable<GetRuntimeRequest, Runtime> getRuntimeCallable() {
    return getRuntimeCallable;
  }

  @Override
  public UnaryCallable<CreateRuntimeRequest, Operation> createRuntimeCallable() {
    return createRuntimeCallable;
  }

  @Override
  public OperationCallable<CreateRuntimeRequest, Runtime, OperationMetadata>
      createRuntimeOperationCallable() {
    return createRuntimeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateRuntimeRequest, Operation> updateRuntimeCallable() {
    return updateRuntimeCallable;
  }

  @Override
  public OperationCallable<UpdateRuntimeRequest, Runtime, OperationMetadata>
      updateRuntimeOperationCallable() {
    return updateRuntimeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRuntimeRequest, Operation> deleteRuntimeCallable() {
    return deleteRuntimeCallable;
  }

  @Override
  public OperationCallable<DeleteRuntimeRequest, Empty, OperationMetadata>
      deleteRuntimeOperationCallable() {
    return deleteRuntimeOperationCallable;
  }

  @Override
  public UnaryCallable<StartRuntimeRequest, Operation> startRuntimeCallable() {
    return startRuntimeCallable;
  }

  @Override
  public OperationCallable<StartRuntimeRequest, Runtime, OperationMetadata>
      startRuntimeOperationCallable() {
    return startRuntimeOperationCallable;
  }

  @Override
  public UnaryCallable<StopRuntimeRequest, Operation> stopRuntimeCallable() {
    return stopRuntimeCallable;
  }

  @Override
  public OperationCallable<StopRuntimeRequest, Runtime, OperationMetadata>
      stopRuntimeOperationCallable() {
    return stopRuntimeOperationCallable;
  }

  @Override
  public UnaryCallable<SwitchRuntimeRequest, Operation> switchRuntimeCallable() {
    return switchRuntimeCallable;
  }

  @Override
  public OperationCallable<SwitchRuntimeRequest, Runtime, OperationMetadata>
      switchRuntimeOperationCallable() {
    return switchRuntimeOperationCallable;
  }

  @Override
  public UnaryCallable<ResetRuntimeRequest, Operation> resetRuntimeCallable() {
    return resetRuntimeCallable;
  }

  @Override
  public OperationCallable<ResetRuntimeRequest, Runtime, OperationMetadata>
      resetRuntimeOperationCallable() {
    return resetRuntimeOperationCallable;
  }

  @Override
  public UnaryCallable<UpgradeRuntimeRequest, Operation> upgradeRuntimeCallable() {
    return upgradeRuntimeCallable;
  }

  @Override
  public OperationCallable<UpgradeRuntimeRequest, Runtime, OperationMetadata>
      upgradeRuntimeOperationCallable() {
    return upgradeRuntimeOperationCallable;
  }

  @Override
  public UnaryCallable<ReportRuntimeEventRequest, Operation> reportRuntimeEventCallable() {
    return reportRuntimeEventCallable;
  }

  @Override
  public OperationCallable<ReportRuntimeEventRequest, Runtime, OperationMetadata>
      reportRuntimeEventOperationCallable() {
    return reportRuntimeEventOperationCallable;
  }

  @Override
  public UnaryCallable<RefreshRuntimeTokenInternalRequest, RefreshRuntimeTokenInternalResponse>
      refreshRuntimeTokenInternalCallable() {
    return refreshRuntimeTokenInternalCallable;
  }

  @Override
  public UnaryCallable<DiagnoseRuntimeRequest, Operation> diagnoseRuntimeCallable() {
    return diagnoseRuntimeCallable;
  }

  @Override
  public OperationCallable<DiagnoseRuntimeRequest, Runtime, OperationMetadata>
      diagnoseRuntimeOperationCallable() {
    return diagnoseRuntimeOperationCallable;
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
