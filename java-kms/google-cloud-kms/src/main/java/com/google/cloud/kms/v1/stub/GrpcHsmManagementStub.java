/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.kms.v1.stub;

import static com.google.cloud.kms.v1.HsmManagementClient.ListLocationsPagedResponse;
import static com.google.cloud.kms.v1.HsmManagementClient.ListSingleTenantHsmInstanceProposalsPagedResponse;
import static com.google.cloud.kms.v1.HsmManagementClient.ListSingleTenantHsmInstancesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalRequest;
import com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalResponse;
import com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceMetadata;
import com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalMetadata;
import com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest;
import com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceRequest;
import com.google.cloud.kms.v1.DeleteSingleTenantHsmInstanceProposalRequest;
import com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalMetadata;
import com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalRequest;
import com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalResponse;
import com.google.cloud.kms.v1.GetSingleTenantHsmInstanceProposalRequest;
import com.google.cloud.kms.v1.GetSingleTenantHsmInstanceRequest;
import com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsRequest;
import com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsResponse;
import com.google.cloud.kms.v1.ListSingleTenantHsmInstancesRequest;
import com.google.cloud.kms.v1.ListSingleTenantHsmInstancesResponse;
import com.google.cloud.kms.v1.SingleTenantHsmInstance;
import com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the HsmManagement service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcHsmManagementStub extends HsmManagementStub {
  private static final MethodDescriptor<
          ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesResponse>
      listSingleTenantHsmInstancesMethodDescriptor =
          MethodDescriptor
              .<ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.HsmManagement/ListSingleTenantHsmInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSingleTenantHsmInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSingleTenantHsmInstancesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSingleTenantHsmInstanceRequest, SingleTenantHsmInstance>
      getSingleTenantHsmInstanceMethodDescriptor =
          MethodDescriptor.<GetSingleTenantHsmInstanceRequest, SingleTenantHsmInstance>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.HsmManagement/GetSingleTenantHsmInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSingleTenantHsmInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SingleTenantHsmInstance.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateSingleTenantHsmInstanceRequest, Operation>
      createSingleTenantHsmInstanceMethodDescriptor =
          MethodDescriptor.<CreateSingleTenantHsmInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.kms.v1.HsmManagement/CreateSingleTenantHsmInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSingleTenantHsmInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateSingleTenantHsmInstanceProposalRequest, Operation>
      createSingleTenantHsmInstanceProposalMethodDescriptor =
          MethodDescriptor.<CreateSingleTenantHsmInstanceProposalRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.kms.v1.HsmManagement/CreateSingleTenantHsmInstanceProposal")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateSingleTenantHsmInstanceProposalRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ApproveSingleTenantHsmInstanceProposalRequest,
          ApproveSingleTenantHsmInstanceProposalResponse>
      approveSingleTenantHsmInstanceProposalMethodDescriptor =
          MethodDescriptor
              .<ApproveSingleTenantHsmInstanceProposalRequest,
                  ApproveSingleTenantHsmInstanceProposalResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.kms.v1.HsmManagement/ApproveSingleTenantHsmInstanceProposal")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ApproveSingleTenantHsmInstanceProposalRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ApproveSingleTenantHsmInstanceProposalResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExecuteSingleTenantHsmInstanceProposalRequest, Operation>
      executeSingleTenantHsmInstanceProposalMethodDescriptor =
          MethodDescriptor.<ExecuteSingleTenantHsmInstanceProposalRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.kms.v1.HsmManagement/ExecuteSingleTenantHsmInstanceProposal")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ExecuteSingleTenantHsmInstanceProposalRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetSingleTenantHsmInstanceProposalRequest, SingleTenantHsmInstanceProposal>
      getSingleTenantHsmInstanceProposalMethodDescriptor =
          MethodDescriptor
              .<GetSingleTenantHsmInstanceProposalRequest, SingleTenantHsmInstanceProposal>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.kms.v1.HsmManagement/GetSingleTenantHsmInstanceProposal")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetSingleTenantHsmInstanceProposalRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SingleTenantHsmInstanceProposal.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListSingleTenantHsmInstanceProposalsRequest, ListSingleTenantHsmInstanceProposalsResponse>
      listSingleTenantHsmInstanceProposalsMethodDescriptor =
          MethodDescriptor
              .<ListSingleTenantHsmInstanceProposalsRequest,
                  ListSingleTenantHsmInstanceProposalsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.kms.v1.HsmManagement/ListSingleTenantHsmInstanceProposals")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListSingleTenantHsmInstanceProposalsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListSingleTenantHsmInstanceProposalsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteSingleTenantHsmInstanceProposalRequest, Empty>
      deleteSingleTenantHsmInstanceProposalMethodDescriptor =
          MethodDescriptor.<DeleteSingleTenantHsmInstanceProposalRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.kms.v1.HsmManagement/DeleteSingleTenantHsmInstanceProposal")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteSingleTenantHsmInstanceProposalRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<
          ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesResponse>
      listSingleTenantHsmInstancesCallable;
  private final UnaryCallable<
          ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesPagedResponse>
      listSingleTenantHsmInstancesPagedCallable;
  private final UnaryCallable<GetSingleTenantHsmInstanceRequest, SingleTenantHsmInstance>
      getSingleTenantHsmInstanceCallable;
  private final UnaryCallable<CreateSingleTenantHsmInstanceRequest, Operation>
      createSingleTenantHsmInstanceCallable;
  private final OperationCallable<
          CreateSingleTenantHsmInstanceRequest,
          SingleTenantHsmInstance,
          CreateSingleTenantHsmInstanceMetadata>
      createSingleTenantHsmInstanceOperationCallable;
  private final UnaryCallable<CreateSingleTenantHsmInstanceProposalRequest, Operation>
      createSingleTenantHsmInstanceProposalCallable;
  private final OperationCallable<
          CreateSingleTenantHsmInstanceProposalRequest,
          SingleTenantHsmInstanceProposal,
          CreateSingleTenantHsmInstanceProposalMetadata>
      createSingleTenantHsmInstanceProposalOperationCallable;
  private final UnaryCallable<
          ApproveSingleTenantHsmInstanceProposalRequest,
          ApproveSingleTenantHsmInstanceProposalResponse>
      approveSingleTenantHsmInstanceProposalCallable;
  private final UnaryCallable<ExecuteSingleTenantHsmInstanceProposalRequest, Operation>
      executeSingleTenantHsmInstanceProposalCallable;
  private final OperationCallable<
          ExecuteSingleTenantHsmInstanceProposalRequest,
          ExecuteSingleTenantHsmInstanceProposalResponse,
          ExecuteSingleTenantHsmInstanceProposalMetadata>
      executeSingleTenantHsmInstanceProposalOperationCallable;
  private final UnaryCallable<
          GetSingleTenantHsmInstanceProposalRequest, SingleTenantHsmInstanceProposal>
      getSingleTenantHsmInstanceProposalCallable;
  private final UnaryCallable<
          ListSingleTenantHsmInstanceProposalsRequest, ListSingleTenantHsmInstanceProposalsResponse>
      listSingleTenantHsmInstanceProposalsCallable;
  private final UnaryCallable<
          ListSingleTenantHsmInstanceProposalsRequest,
          ListSingleTenantHsmInstanceProposalsPagedResponse>
      listSingleTenantHsmInstanceProposalsPagedCallable;
  private final UnaryCallable<DeleteSingleTenantHsmInstanceProposalRequest, Empty>
      deleteSingleTenantHsmInstanceProposalCallable;
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

  public static final GrpcHsmManagementStub create(HsmManagementStubSettings settings)
      throws IOException {
    return new GrpcHsmManagementStub(settings, ClientContext.create(settings));
  }

  public static final GrpcHsmManagementStub create(ClientContext clientContext) throws IOException {
    return new GrpcHsmManagementStub(HsmManagementStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcHsmManagementStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcHsmManagementStub(
        HsmManagementStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcHsmManagementStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcHsmManagementStub(HsmManagementStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcHsmManagementCallableFactory());
  }

  /**
   * Constructs an instance of GrpcHsmManagementStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcHsmManagementStub(
      HsmManagementStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesResponse>
        listSingleTenantHsmInstancesTransportSettings =
            GrpcCallSettings
                .<ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesResponse>
                    newBuilder()
                .setMethodDescriptor(listSingleTenantHsmInstancesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetSingleTenantHsmInstanceRequest, SingleTenantHsmInstance>
        getSingleTenantHsmInstanceTransportSettings =
            GrpcCallSettings
                .<GetSingleTenantHsmInstanceRequest, SingleTenantHsmInstance>newBuilder()
                .setMethodDescriptor(getSingleTenantHsmInstanceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateSingleTenantHsmInstanceRequest, Operation>
        createSingleTenantHsmInstanceTransportSettings =
            GrpcCallSettings.<CreateSingleTenantHsmInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(createSingleTenantHsmInstanceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateSingleTenantHsmInstanceProposalRequest, Operation>
        createSingleTenantHsmInstanceProposalTransportSettings =
            GrpcCallSettings.<CreateSingleTenantHsmInstanceProposalRequest, Operation>newBuilder()
                .setMethodDescriptor(createSingleTenantHsmInstanceProposalMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ApproveSingleTenantHsmInstanceProposalRequest,
            ApproveSingleTenantHsmInstanceProposalResponse>
        approveSingleTenantHsmInstanceProposalTransportSettings =
            GrpcCallSettings
                .<ApproveSingleTenantHsmInstanceProposalRequest,
                    ApproveSingleTenantHsmInstanceProposalResponse>
                    newBuilder()
                .setMethodDescriptor(approveSingleTenantHsmInstanceProposalMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ExecuteSingleTenantHsmInstanceProposalRequest, Operation>
        executeSingleTenantHsmInstanceProposalTransportSettings =
            GrpcCallSettings.<ExecuteSingleTenantHsmInstanceProposalRequest, Operation>newBuilder()
                .setMethodDescriptor(executeSingleTenantHsmInstanceProposalMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetSingleTenantHsmInstanceProposalRequest, SingleTenantHsmInstanceProposal>
        getSingleTenantHsmInstanceProposalTransportSettings =
            GrpcCallSettings
                .<GetSingleTenantHsmInstanceProposalRequest, SingleTenantHsmInstanceProposal>
                    newBuilder()
                .setMethodDescriptor(getSingleTenantHsmInstanceProposalMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListSingleTenantHsmInstanceProposalsRequest,
            ListSingleTenantHsmInstanceProposalsResponse>
        listSingleTenantHsmInstanceProposalsTransportSettings =
            GrpcCallSettings
                .<ListSingleTenantHsmInstanceProposalsRequest,
                    ListSingleTenantHsmInstanceProposalsResponse>
                    newBuilder()
                .setMethodDescriptor(listSingleTenantHsmInstanceProposalsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteSingleTenantHsmInstanceProposalRequest, Empty>
        deleteSingleTenantHsmInstanceProposalTransportSettings =
            GrpcCallSettings.<DeleteSingleTenantHsmInstanceProposalRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteSingleTenantHsmInstanceProposalMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
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

    this.listSingleTenantHsmInstancesCallable =
        callableFactory.createUnaryCallable(
            listSingleTenantHsmInstancesTransportSettings,
            settings.listSingleTenantHsmInstancesSettings(),
            clientContext);
    this.listSingleTenantHsmInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listSingleTenantHsmInstancesTransportSettings,
            settings.listSingleTenantHsmInstancesSettings(),
            clientContext);
    this.getSingleTenantHsmInstanceCallable =
        callableFactory.createUnaryCallable(
            getSingleTenantHsmInstanceTransportSettings,
            settings.getSingleTenantHsmInstanceSettings(),
            clientContext);
    this.createSingleTenantHsmInstanceCallable =
        callableFactory.createUnaryCallable(
            createSingleTenantHsmInstanceTransportSettings,
            settings.createSingleTenantHsmInstanceSettings(),
            clientContext);
    this.createSingleTenantHsmInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createSingleTenantHsmInstanceTransportSettings,
            settings.createSingleTenantHsmInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.createSingleTenantHsmInstanceProposalCallable =
        callableFactory.createUnaryCallable(
            createSingleTenantHsmInstanceProposalTransportSettings,
            settings.createSingleTenantHsmInstanceProposalSettings(),
            clientContext);
    this.createSingleTenantHsmInstanceProposalOperationCallable =
        callableFactory.createOperationCallable(
            createSingleTenantHsmInstanceProposalTransportSettings,
            settings.createSingleTenantHsmInstanceProposalOperationSettings(),
            clientContext,
            operationsStub);
    this.approveSingleTenantHsmInstanceProposalCallable =
        callableFactory.createUnaryCallable(
            approveSingleTenantHsmInstanceProposalTransportSettings,
            settings.approveSingleTenantHsmInstanceProposalSettings(),
            clientContext);
    this.executeSingleTenantHsmInstanceProposalCallable =
        callableFactory.createUnaryCallable(
            executeSingleTenantHsmInstanceProposalTransportSettings,
            settings.executeSingleTenantHsmInstanceProposalSettings(),
            clientContext);
    this.executeSingleTenantHsmInstanceProposalOperationCallable =
        callableFactory.createOperationCallable(
            executeSingleTenantHsmInstanceProposalTransportSettings,
            settings.executeSingleTenantHsmInstanceProposalOperationSettings(),
            clientContext,
            operationsStub);
    this.getSingleTenantHsmInstanceProposalCallable =
        callableFactory.createUnaryCallable(
            getSingleTenantHsmInstanceProposalTransportSettings,
            settings.getSingleTenantHsmInstanceProposalSettings(),
            clientContext);
    this.listSingleTenantHsmInstanceProposalsCallable =
        callableFactory.createUnaryCallable(
            listSingleTenantHsmInstanceProposalsTransportSettings,
            settings.listSingleTenantHsmInstanceProposalsSettings(),
            clientContext);
    this.listSingleTenantHsmInstanceProposalsPagedCallable =
        callableFactory.createPagedCallable(
            listSingleTenantHsmInstanceProposalsTransportSettings,
            settings.listSingleTenantHsmInstanceProposalsSettings(),
            clientContext);
    this.deleteSingleTenantHsmInstanceProposalCallable =
        callableFactory.createUnaryCallable(
            deleteSingleTenantHsmInstanceProposalTransportSettings,
            settings.deleteSingleTenantHsmInstanceProposalSettings(),
            clientContext);
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
  public UnaryCallable<ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesResponse>
      listSingleTenantHsmInstancesCallable() {
    return listSingleTenantHsmInstancesCallable;
  }

  @Override
  public UnaryCallable<
          ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesPagedResponse>
      listSingleTenantHsmInstancesPagedCallable() {
    return listSingleTenantHsmInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSingleTenantHsmInstanceRequest, SingleTenantHsmInstance>
      getSingleTenantHsmInstanceCallable() {
    return getSingleTenantHsmInstanceCallable;
  }

  @Override
  public UnaryCallable<CreateSingleTenantHsmInstanceRequest, Operation>
      createSingleTenantHsmInstanceCallable() {
    return createSingleTenantHsmInstanceCallable;
  }

  @Override
  public OperationCallable<
          CreateSingleTenantHsmInstanceRequest,
          SingleTenantHsmInstance,
          CreateSingleTenantHsmInstanceMetadata>
      createSingleTenantHsmInstanceOperationCallable() {
    return createSingleTenantHsmInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<CreateSingleTenantHsmInstanceProposalRequest, Operation>
      createSingleTenantHsmInstanceProposalCallable() {
    return createSingleTenantHsmInstanceProposalCallable;
  }

  @Override
  public OperationCallable<
          CreateSingleTenantHsmInstanceProposalRequest,
          SingleTenantHsmInstanceProposal,
          CreateSingleTenantHsmInstanceProposalMetadata>
      createSingleTenantHsmInstanceProposalOperationCallable() {
    return createSingleTenantHsmInstanceProposalOperationCallable;
  }

  @Override
  public UnaryCallable<
          ApproveSingleTenantHsmInstanceProposalRequest,
          ApproveSingleTenantHsmInstanceProposalResponse>
      approveSingleTenantHsmInstanceProposalCallable() {
    return approveSingleTenantHsmInstanceProposalCallable;
  }

  @Override
  public UnaryCallable<ExecuteSingleTenantHsmInstanceProposalRequest, Operation>
      executeSingleTenantHsmInstanceProposalCallable() {
    return executeSingleTenantHsmInstanceProposalCallable;
  }

  @Override
  public OperationCallable<
          ExecuteSingleTenantHsmInstanceProposalRequest,
          ExecuteSingleTenantHsmInstanceProposalResponse,
          ExecuteSingleTenantHsmInstanceProposalMetadata>
      executeSingleTenantHsmInstanceProposalOperationCallable() {
    return executeSingleTenantHsmInstanceProposalOperationCallable;
  }

  @Override
  public UnaryCallable<GetSingleTenantHsmInstanceProposalRequest, SingleTenantHsmInstanceProposal>
      getSingleTenantHsmInstanceProposalCallable() {
    return getSingleTenantHsmInstanceProposalCallable;
  }

  @Override
  public UnaryCallable<
          ListSingleTenantHsmInstanceProposalsRequest, ListSingleTenantHsmInstanceProposalsResponse>
      listSingleTenantHsmInstanceProposalsCallable() {
    return listSingleTenantHsmInstanceProposalsCallable;
  }

  @Override
  public UnaryCallable<
          ListSingleTenantHsmInstanceProposalsRequest,
          ListSingleTenantHsmInstanceProposalsPagedResponse>
      listSingleTenantHsmInstanceProposalsPagedCallable() {
    return listSingleTenantHsmInstanceProposalsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteSingleTenantHsmInstanceProposalRequest, Empty>
      deleteSingleTenantHsmInstanceProposalCallable() {
    return deleteSingleTenantHsmInstanceProposalCallable;
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
