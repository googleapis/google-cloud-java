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

package com.google.cloud.workstations.v1.stub;

import static com.google.cloud.workstations.v1.WorkstationsClient.ListUsableWorkstationConfigsPagedResponse;
import static com.google.cloud.workstations.v1.WorkstationsClient.ListUsableWorkstationsPagedResponse;
import static com.google.cloud.workstations.v1.WorkstationsClient.ListWorkstationClustersPagedResponse;
import static com.google.cloud.workstations.v1.WorkstationsClient.ListWorkstationConfigsPagedResponse;
import static com.google.cloud.workstations.v1.WorkstationsClient.ListWorkstationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Workstations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcWorkstationsStub extends WorkstationsStub {
  private static final MethodDescriptor<GetWorkstationClusterRequest, WorkstationCluster>
      getWorkstationClusterMethodDescriptor =
          MethodDescriptor.<GetWorkstationClusterRequest, WorkstationCluster>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workstations.v1.Workstations/GetWorkstationCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetWorkstationClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WorkstationCluster.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListWorkstationClustersRequest, ListWorkstationClustersResponse>
      listWorkstationClustersMethodDescriptor =
          MethodDescriptor
              .<ListWorkstationClustersRequest, ListWorkstationClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.workstations.v1.Workstations/ListWorkstationClusters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkstationClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkstationClustersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateWorkstationClusterRequest, Operation>
      createWorkstationClusterMethodDescriptor =
          MethodDescriptor.<CreateWorkstationClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.workstations.v1.Workstations/CreateWorkstationCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWorkstationClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateWorkstationClusterRequest, Operation>
      updateWorkstationClusterMethodDescriptor =
          MethodDescriptor.<UpdateWorkstationClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.workstations.v1.Workstations/UpdateWorkstationCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateWorkstationClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteWorkstationClusterRequest, Operation>
      deleteWorkstationClusterMethodDescriptor =
          MethodDescriptor.<DeleteWorkstationClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.workstations.v1.Workstations/DeleteWorkstationCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteWorkstationClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetWorkstationConfigRequest, WorkstationConfig>
      getWorkstationConfigMethodDescriptor =
          MethodDescriptor.<GetWorkstationConfigRequest, WorkstationConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workstations.v1.Workstations/GetWorkstationConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetWorkstationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WorkstationConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListWorkstationConfigsRequest, ListWorkstationConfigsResponse>
      listWorkstationConfigsMethodDescriptor =
          MethodDescriptor
              .<ListWorkstationConfigsRequest, ListWorkstationConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workstations.v1.Workstations/ListWorkstationConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkstationConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkstationConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsResponse>
      listUsableWorkstationConfigsMethodDescriptor =
          MethodDescriptor
              .<ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.workstations.v1.Workstations/ListUsableWorkstationConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUsableWorkstationConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUsableWorkstationConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateWorkstationConfigRequest, Operation>
      createWorkstationConfigMethodDescriptor =
          MethodDescriptor.<CreateWorkstationConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.workstations.v1.Workstations/CreateWorkstationConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWorkstationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateWorkstationConfigRequest, Operation>
      updateWorkstationConfigMethodDescriptor =
          MethodDescriptor.<UpdateWorkstationConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.workstations.v1.Workstations/UpdateWorkstationConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateWorkstationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteWorkstationConfigRequest, Operation>
      deleteWorkstationConfigMethodDescriptor =
          MethodDescriptor.<DeleteWorkstationConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.workstations.v1.Workstations/DeleteWorkstationConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteWorkstationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetWorkstationRequest, Workstation>
      getWorkstationMethodDescriptor =
          MethodDescriptor.<GetWorkstationRequest, Workstation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workstations.v1.Workstations/GetWorkstation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetWorkstationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Workstation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListWorkstationsRequest, ListWorkstationsResponse>
      listWorkstationsMethodDescriptor =
          MethodDescriptor.<ListWorkstationsRequest, ListWorkstationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workstations.v1.Workstations/ListWorkstations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkstationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkstationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListUsableWorkstationsRequest, ListUsableWorkstationsResponse>
      listUsableWorkstationsMethodDescriptor =
          MethodDescriptor
              .<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workstations.v1.Workstations/ListUsableWorkstations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUsableWorkstationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUsableWorkstationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateWorkstationRequest, Operation>
      createWorkstationMethodDescriptor =
          MethodDescriptor.<CreateWorkstationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workstations.v1.Workstations/CreateWorkstation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWorkstationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateWorkstationRequest, Operation>
      updateWorkstationMethodDescriptor =
          MethodDescriptor.<UpdateWorkstationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workstations.v1.Workstations/UpdateWorkstation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateWorkstationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteWorkstationRequest, Operation>
      deleteWorkstationMethodDescriptor =
          MethodDescriptor.<DeleteWorkstationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workstations.v1.Workstations/DeleteWorkstation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteWorkstationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StartWorkstationRequest, Operation>
      startWorkstationMethodDescriptor =
          MethodDescriptor.<StartWorkstationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workstations.v1.Workstations/StartWorkstation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartWorkstationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StopWorkstationRequest, Operation>
      stopWorkstationMethodDescriptor =
          MethodDescriptor.<StopWorkstationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workstations.v1.Workstations/StopWorkstation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StopWorkstationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenMethodDescriptor =
          MethodDescriptor.<GenerateAccessTokenRequest, GenerateAccessTokenResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workstations.v1.Workstations/GenerateAccessToken")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateAccessTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateAccessTokenResponse.getDefaultInstance()))
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

  private final UnaryCallable<GetWorkstationClusterRequest, WorkstationCluster>
      getWorkstationClusterCallable;
  private final UnaryCallable<ListWorkstationClustersRequest, ListWorkstationClustersResponse>
      listWorkstationClustersCallable;
  private final UnaryCallable<ListWorkstationClustersRequest, ListWorkstationClustersPagedResponse>
      listWorkstationClustersPagedCallable;
  private final UnaryCallable<CreateWorkstationClusterRequest, Operation>
      createWorkstationClusterCallable;
  private final OperationCallable<
          CreateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      createWorkstationClusterOperationCallable;
  private final UnaryCallable<UpdateWorkstationClusterRequest, Operation>
      updateWorkstationClusterCallable;
  private final OperationCallable<
          UpdateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      updateWorkstationClusterOperationCallable;
  private final UnaryCallable<DeleteWorkstationClusterRequest, Operation>
      deleteWorkstationClusterCallable;
  private final OperationCallable<
          DeleteWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      deleteWorkstationClusterOperationCallable;
  private final UnaryCallable<GetWorkstationConfigRequest, WorkstationConfig>
      getWorkstationConfigCallable;
  private final UnaryCallable<ListWorkstationConfigsRequest, ListWorkstationConfigsResponse>
      listWorkstationConfigsCallable;
  private final UnaryCallable<ListWorkstationConfigsRequest, ListWorkstationConfigsPagedResponse>
      listWorkstationConfigsPagedCallable;
  private final UnaryCallable<
          ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsResponse>
      listUsableWorkstationConfigsCallable;
  private final UnaryCallable<
          ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsPagedResponse>
      listUsableWorkstationConfigsPagedCallable;
  private final UnaryCallable<CreateWorkstationConfigRequest, Operation>
      createWorkstationConfigCallable;
  private final OperationCallable<
          CreateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      createWorkstationConfigOperationCallable;
  private final UnaryCallable<UpdateWorkstationConfigRequest, Operation>
      updateWorkstationConfigCallable;
  private final OperationCallable<
          UpdateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      updateWorkstationConfigOperationCallable;
  private final UnaryCallable<DeleteWorkstationConfigRequest, Operation>
      deleteWorkstationConfigCallable;
  private final OperationCallable<
          DeleteWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      deleteWorkstationConfigOperationCallable;
  private final UnaryCallable<GetWorkstationRequest, Workstation> getWorkstationCallable;
  private final UnaryCallable<ListWorkstationsRequest, ListWorkstationsResponse>
      listWorkstationsCallable;
  private final UnaryCallable<ListWorkstationsRequest, ListWorkstationsPagedResponse>
      listWorkstationsPagedCallable;
  private final UnaryCallable<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse>
      listUsableWorkstationsCallable;
  private final UnaryCallable<ListUsableWorkstationsRequest, ListUsableWorkstationsPagedResponse>
      listUsableWorkstationsPagedCallable;
  private final UnaryCallable<CreateWorkstationRequest, Operation> createWorkstationCallable;
  private final OperationCallable<CreateWorkstationRequest, Workstation, OperationMetadata>
      createWorkstationOperationCallable;
  private final UnaryCallable<UpdateWorkstationRequest, Operation> updateWorkstationCallable;
  private final OperationCallable<UpdateWorkstationRequest, Workstation, OperationMetadata>
      updateWorkstationOperationCallable;
  private final UnaryCallable<DeleteWorkstationRequest, Operation> deleteWorkstationCallable;
  private final OperationCallable<DeleteWorkstationRequest, Workstation, OperationMetadata>
      deleteWorkstationOperationCallable;
  private final UnaryCallable<StartWorkstationRequest, Operation> startWorkstationCallable;
  private final OperationCallable<StartWorkstationRequest, Workstation, OperationMetadata>
      startWorkstationOperationCallable;
  private final UnaryCallable<StopWorkstationRequest, Operation> stopWorkstationCallable;
  private final OperationCallable<StopWorkstationRequest, Workstation, OperationMetadata>
      stopWorkstationOperationCallable;
  private final UnaryCallable<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcWorkstationsStub create(WorkstationsStubSettings settings)
      throws IOException {
    return new GrpcWorkstationsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcWorkstationsStub create(ClientContext clientContext) throws IOException {
    return new GrpcWorkstationsStub(WorkstationsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcWorkstationsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcWorkstationsStub(
        WorkstationsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcWorkstationsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcWorkstationsStub(WorkstationsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcWorkstationsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcWorkstationsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcWorkstationsStub(
      WorkstationsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetWorkstationClusterRequest, WorkstationCluster>
        getWorkstationClusterTransportSettings =
            GrpcCallSettings.<GetWorkstationClusterRequest, WorkstationCluster>newBuilder()
                .setMethodDescriptor(getWorkstationClusterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListWorkstationClustersRequest, ListWorkstationClustersResponse>
        listWorkstationClustersTransportSettings =
            GrpcCallSettings
                .<ListWorkstationClustersRequest, ListWorkstationClustersResponse>newBuilder()
                .setMethodDescriptor(listWorkstationClustersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateWorkstationClusterRequest, Operation>
        createWorkstationClusterTransportSettings =
            GrpcCallSettings.<CreateWorkstationClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(createWorkstationClusterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateWorkstationClusterRequest, Operation>
        updateWorkstationClusterTransportSettings =
            GrpcCallSettings.<UpdateWorkstationClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(updateWorkstationClusterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "workstation_cluster.name",
                          String.valueOf(request.getWorkstationCluster().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteWorkstationClusterRequest, Operation>
        deleteWorkstationClusterTransportSettings =
            GrpcCallSettings.<DeleteWorkstationClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteWorkstationClusterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetWorkstationConfigRequest, WorkstationConfig>
        getWorkstationConfigTransportSettings =
            GrpcCallSettings.<GetWorkstationConfigRequest, WorkstationConfig>newBuilder()
                .setMethodDescriptor(getWorkstationConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListWorkstationConfigsRequest, ListWorkstationConfigsResponse>
        listWorkstationConfigsTransportSettings =
            GrpcCallSettings
                .<ListWorkstationConfigsRequest, ListWorkstationConfigsResponse>newBuilder()
                .setMethodDescriptor(listWorkstationConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsResponse>
        listUsableWorkstationConfigsTransportSettings =
            GrpcCallSettings
                .<ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsResponse>
                    newBuilder()
                .setMethodDescriptor(listUsableWorkstationConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateWorkstationConfigRequest, Operation>
        createWorkstationConfigTransportSettings =
            GrpcCallSettings.<CreateWorkstationConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(createWorkstationConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateWorkstationConfigRequest, Operation>
        updateWorkstationConfigTransportSettings =
            GrpcCallSettings.<UpdateWorkstationConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(updateWorkstationConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "workstation_config.name",
                          String.valueOf(request.getWorkstationConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteWorkstationConfigRequest, Operation>
        deleteWorkstationConfigTransportSettings =
            GrpcCallSettings.<DeleteWorkstationConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteWorkstationConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetWorkstationRequest, Workstation> getWorkstationTransportSettings =
        GrpcCallSettings.<GetWorkstationRequest, Workstation>newBuilder()
            .setMethodDescriptor(getWorkstationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListWorkstationsRequest, ListWorkstationsResponse>
        listWorkstationsTransportSettings =
            GrpcCallSettings.<ListWorkstationsRequest, ListWorkstationsResponse>newBuilder()
                .setMethodDescriptor(listWorkstationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse>
        listUsableWorkstationsTransportSettings =
            GrpcCallSettings
                .<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse>newBuilder()
                .setMethodDescriptor(listUsableWorkstationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateWorkstationRequest, Operation> createWorkstationTransportSettings =
        GrpcCallSettings.<CreateWorkstationRequest, Operation>newBuilder()
            .setMethodDescriptor(createWorkstationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateWorkstationRequest, Operation> updateWorkstationTransportSettings =
        GrpcCallSettings.<UpdateWorkstationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateWorkstationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "workstation.name", String.valueOf(request.getWorkstation().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteWorkstationRequest, Operation> deleteWorkstationTransportSettings =
        GrpcCallSettings.<DeleteWorkstationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteWorkstationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<StartWorkstationRequest, Operation> startWorkstationTransportSettings =
        GrpcCallSettings.<StartWorkstationRequest, Operation>newBuilder()
            .setMethodDescriptor(startWorkstationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<StopWorkstationRequest, Operation> stopWorkstationTransportSettings =
        GrpcCallSettings.<StopWorkstationRequest, Operation>newBuilder()
            .setMethodDescriptor(stopWorkstationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
        generateAccessTokenTransportSettings =
            GrpcCallSettings.<GenerateAccessTokenRequest, GenerateAccessTokenResponse>newBuilder()
                .setMethodDescriptor(generateAccessTokenMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("workstation", String.valueOf(request.getWorkstation()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.getWorkstationClusterCallable =
        callableFactory.createUnaryCallable(
            getWorkstationClusterTransportSettings,
            settings.getWorkstationClusterSettings(),
            clientContext);
    this.listWorkstationClustersCallable =
        callableFactory.createUnaryCallable(
            listWorkstationClustersTransportSettings,
            settings.listWorkstationClustersSettings(),
            clientContext);
    this.listWorkstationClustersPagedCallable =
        callableFactory.createPagedCallable(
            listWorkstationClustersTransportSettings,
            settings.listWorkstationClustersSettings(),
            clientContext);
    this.createWorkstationClusterCallable =
        callableFactory.createUnaryCallable(
            createWorkstationClusterTransportSettings,
            settings.createWorkstationClusterSettings(),
            clientContext);
    this.createWorkstationClusterOperationCallable =
        callableFactory.createOperationCallable(
            createWorkstationClusterTransportSettings,
            settings.createWorkstationClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.updateWorkstationClusterCallable =
        callableFactory.createUnaryCallable(
            updateWorkstationClusterTransportSettings,
            settings.updateWorkstationClusterSettings(),
            clientContext);
    this.updateWorkstationClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateWorkstationClusterTransportSettings,
            settings.updateWorkstationClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteWorkstationClusterCallable =
        callableFactory.createUnaryCallable(
            deleteWorkstationClusterTransportSettings,
            settings.deleteWorkstationClusterSettings(),
            clientContext);
    this.deleteWorkstationClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteWorkstationClusterTransportSettings,
            settings.deleteWorkstationClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.getWorkstationConfigCallable =
        callableFactory.createUnaryCallable(
            getWorkstationConfigTransportSettings,
            settings.getWorkstationConfigSettings(),
            clientContext);
    this.listWorkstationConfigsCallable =
        callableFactory.createUnaryCallable(
            listWorkstationConfigsTransportSettings,
            settings.listWorkstationConfigsSettings(),
            clientContext);
    this.listWorkstationConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkstationConfigsTransportSettings,
            settings.listWorkstationConfigsSettings(),
            clientContext);
    this.listUsableWorkstationConfigsCallable =
        callableFactory.createUnaryCallable(
            listUsableWorkstationConfigsTransportSettings,
            settings.listUsableWorkstationConfigsSettings(),
            clientContext);
    this.listUsableWorkstationConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listUsableWorkstationConfigsTransportSettings,
            settings.listUsableWorkstationConfigsSettings(),
            clientContext);
    this.createWorkstationConfigCallable =
        callableFactory.createUnaryCallable(
            createWorkstationConfigTransportSettings,
            settings.createWorkstationConfigSettings(),
            clientContext);
    this.createWorkstationConfigOperationCallable =
        callableFactory.createOperationCallable(
            createWorkstationConfigTransportSettings,
            settings.createWorkstationConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.updateWorkstationConfigCallable =
        callableFactory.createUnaryCallable(
            updateWorkstationConfigTransportSettings,
            settings.updateWorkstationConfigSettings(),
            clientContext);
    this.updateWorkstationConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateWorkstationConfigTransportSettings,
            settings.updateWorkstationConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteWorkstationConfigCallable =
        callableFactory.createUnaryCallable(
            deleteWorkstationConfigTransportSettings,
            settings.deleteWorkstationConfigSettings(),
            clientContext);
    this.deleteWorkstationConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteWorkstationConfigTransportSettings,
            settings.deleteWorkstationConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.getWorkstationCallable =
        callableFactory.createUnaryCallable(
            getWorkstationTransportSettings, settings.getWorkstationSettings(), clientContext);
    this.listWorkstationsCallable =
        callableFactory.createUnaryCallable(
            listWorkstationsTransportSettings, settings.listWorkstationsSettings(), clientContext);
    this.listWorkstationsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkstationsTransportSettings, settings.listWorkstationsSettings(), clientContext);
    this.listUsableWorkstationsCallable =
        callableFactory.createUnaryCallable(
            listUsableWorkstationsTransportSettings,
            settings.listUsableWorkstationsSettings(),
            clientContext);
    this.listUsableWorkstationsPagedCallable =
        callableFactory.createPagedCallable(
            listUsableWorkstationsTransportSettings,
            settings.listUsableWorkstationsSettings(),
            clientContext);
    this.createWorkstationCallable =
        callableFactory.createUnaryCallable(
            createWorkstationTransportSettings,
            settings.createWorkstationSettings(),
            clientContext);
    this.createWorkstationOperationCallable =
        callableFactory.createOperationCallable(
            createWorkstationTransportSettings,
            settings.createWorkstationOperationSettings(),
            clientContext,
            operationsStub);
    this.updateWorkstationCallable =
        callableFactory.createUnaryCallable(
            updateWorkstationTransportSettings,
            settings.updateWorkstationSettings(),
            clientContext);
    this.updateWorkstationOperationCallable =
        callableFactory.createOperationCallable(
            updateWorkstationTransportSettings,
            settings.updateWorkstationOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteWorkstationCallable =
        callableFactory.createUnaryCallable(
            deleteWorkstationTransportSettings,
            settings.deleteWorkstationSettings(),
            clientContext);
    this.deleteWorkstationOperationCallable =
        callableFactory.createOperationCallable(
            deleteWorkstationTransportSettings,
            settings.deleteWorkstationOperationSettings(),
            clientContext,
            operationsStub);
    this.startWorkstationCallable =
        callableFactory.createUnaryCallable(
            startWorkstationTransportSettings, settings.startWorkstationSettings(), clientContext);
    this.startWorkstationOperationCallable =
        callableFactory.createOperationCallable(
            startWorkstationTransportSettings,
            settings.startWorkstationOperationSettings(),
            clientContext,
            operationsStub);
    this.stopWorkstationCallable =
        callableFactory.createUnaryCallable(
            stopWorkstationTransportSettings, settings.stopWorkstationSettings(), clientContext);
    this.stopWorkstationOperationCallable =
        callableFactory.createOperationCallable(
            stopWorkstationTransportSettings,
            settings.stopWorkstationOperationSettings(),
            clientContext,
            operationsStub);
    this.generateAccessTokenCallable =
        callableFactory.createUnaryCallable(
            generateAccessTokenTransportSettings,
            settings.generateAccessTokenSettings(),
            clientContext);
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
  public UnaryCallable<GetWorkstationClusterRequest, WorkstationCluster>
      getWorkstationClusterCallable() {
    return getWorkstationClusterCallable;
  }

  @Override
  public UnaryCallable<ListWorkstationClustersRequest, ListWorkstationClustersResponse>
      listWorkstationClustersCallable() {
    return listWorkstationClustersCallable;
  }

  @Override
  public UnaryCallable<ListWorkstationClustersRequest, ListWorkstationClustersPagedResponse>
      listWorkstationClustersPagedCallable() {
    return listWorkstationClustersPagedCallable;
  }

  @Override
  public UnaryCallable<CreateWorkstationClusterRequest, Operation>
      createWorkstationClusterCallable() {
    return createWorkstationClusterCallable;
  }

  @Override
  public OperationCallable<CreateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      createWorkstationClusterOperationCallable() {
    return createWorkstationClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkstationClusterRequest, Operation>
      updateWorkstationClusterCallable() {
    return updateWorkstationClusterCallable;
  }

  @Override
  public OperationCallable<UpdateWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      updateWorkstationClusterOperationCallable() {
    return updateWorkstationClusterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkstationClusterRequest, Operation>
      deleteWorkstationClusterCallable() {
    return deleteWorkstationClusterCallable;
  }

  @Override
  public OperationCallable<DeleteWorkstationClusterRequest, WorkstationCluster, OperationMetadata>
      deleteWorkstationClusterOperationCallable() {
    return deleteWorkstationClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GetWorkstationConfigRequest, WorkstationConfig>
      getWorkstationConfigCallable() {
    return getWorkstationConfigCallable;
  }

  @Override
  public UnaryCallable<ListWorkstationConfigsRequest, ListWorkstationConfigsResponse>
      listWorkstationConfigsCallable() {
    return listWorkstationConfigsCallable;
  }

  @Override
  public UnaryCallable<ListWorkstationConfigsRequest, ListWorkstationConfigsPagedResponse>
      listWorkstationConfigsPagedCallable() {
    return listWorkstationConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsResponse>
      listUsableWorkstationConfigsCallable() {
    return listUsableWorkstationConfigsCallable;
  }

  @Override
  public UnaryCallable<
          ListUsableWorkstationConfigsRequest, ListUsableWorkstationConfigsPagedResponse>
      listUsableWorkstationConfigsPagedCallable() {
    return listUsableWorkstationConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateWorkstationConfigRequest, Operation>
      createWorkstationConfigCallable() {
    return createWorkstationConfigCallable;
  }

  @Override
  public OperationCallable<CreateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      createWorkstationConfigOperationCallable() {
    return createWorkstationConfigOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkstationConfigRequest, Operation>
      updateWorkstationConfigCallable() {
    return updateWorkstationConfigCallable;
  }

  @Override
  public OperationCallable<UpdateWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      updateWorkstationConfigOperationCallable() {
    return updateWorkstationConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkstationConfigRequest, Operation>
      deleteWorkstationConfigCallable() {
    return deleteWorkstationConfigCallable;
  }

  @Override
  public OperationCallable<DeleteWorkstationConfigRequest, WorkstationConfig, OperationMetadata>
      deleteWorkstationConfigOperationCallable() {
    return deleteWorkstationConfigOperationCallable;
  }

  @Override
  public UnaryCallable<GetWorkstationRequest, Workstation> getWorkstationCallable() {
    return getWorkstationCallable;
  }

  @Override
  public UnaryCallable<ListWorkstationsRequest, ListWorkstationsResponse>
      listWorkstationsCallable() {
    return listWorkstationsCallable;
  }

  @Override
  public UnaryCallable<ListWorkstationsRequest, ListWorkstationsPagedResponse>
      listWorkstationsPagedCallable() {
    return listWorkstationsPagedCallable;
  }

  @Override
  public UnaryCallable<ListUsableWorkstationsRequest, ListUsableWorkstationsResponse>
      listUsableWorkstationsCallable() {
    return listUsableWorkstationsCallable;
  }

  @Override
  public UnaryCallable<ListUsableWorkstationsRequest, ListUsableWorkstationsPagedResponse>
      listUsableWorkstationsPagedCallable() {
    return listUsableWorkstationsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateWorkstationRequest, Operation> createWorkstationCallable() {
    return createWorkstationCallable;
  }

  @Override
  public OperationCallable<CreateWorkstationRequest, Workstation, OperationMetadata>
      createWorkstationOperationCallable() {
    return createWorkstationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateWorkstationRequest, Operation> updateWorkstationCallable() {
    return updateWorkstationCallable;
  }

  @Override
  public OperationCallable<UpdateWorkstationRequest, Workstation, OperationMetadata>
      updateWorkstationOperationCallable() {
    return updateWorkstationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkstationRequest, Operation> deleteWorkstationCallable() {
    return deleteWorkstationCallable;
  }

  @Override
  public OperationCallable<DeleteWorkstationRequest, Workstation, OperationMetadata>
      deleteWorkstationOperationCallable() {
    return deleteWorkstationOperationCallable;
  }

  @Override
  public UnaryCallable<StartWorkstationRequest, Operation> startWorkstationCallable() {
    return startWorkstationCallable;
  }

  @Override
  public OperationCallable<StartWorkstationRequest, Workstation, OperationMetadata>
      startWorkstationOperationCallable() {
    return startWorkstationOperationCallable;
  }

  @Override
  public UnaryCallable<StopWorkstationRequest, Operation> stopWorkstationCallable() {
    return stopWorkstationCallable;
  }

  @Override
  public OperationCallable<StopWorkstationRequest, Workstation, OperationMetadata>
      stopWorkstationOperationCallable() {
    return stopWorkstationOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenCallable() {
    return generateAccessTokenCallable;
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
