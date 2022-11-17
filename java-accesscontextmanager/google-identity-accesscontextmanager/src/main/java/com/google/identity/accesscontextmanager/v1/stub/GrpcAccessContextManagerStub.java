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

package com.google.identity.accesscontextmanager.v1.stub;

import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListAccessLevelsPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListAccessPoliciesPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListGcpUserAccessBindingsPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListServicePerimetersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.identity.accesscontextmanager.v1.AccessContextManagerOperationMetadata;
import com.google.identity.accesscontextmanager.v1.AccessLevel;
import com.google.identity.accesscontextmanager.v1.AccessPolicy;
import com.google.identity.accesscontextmanager.v1.CommitServicePerimetersRequest;
import com.google.identity.accesscontextmanager.v1.CommitServicePerimetersResponse;
import com.google.identity.accesscontextmanager.v1.CreateAccessLevelRequest;
import com.google.identity.accesscontextmanager.v1.CreateGcpUserAccessBindingRequest;
import com.google.identity.accesscontextmanager.v1.CreateServicePerimeterRequest;
import com.google.identity.accesscontextmanager.v1.DeleteAccessLevelRequest;
import com.google.identity.accesscontextmanager.v1.DeleteAccessPolicyRequest;
import com.google.identity.accesscontextmanager.v1.DeleteGcpUserAccessBindingRequest;
import com.google.identity.accesscontextmanager.v1.DeleteServicePerimeterRequest;
import com.google.identity.accesscontextmanager.v1.GcpUserAccessBinding;
import com.google.identity.accesscontextmanager.v1.GcpUserAccessBindingOperationMetadata;
import com.google.identity.accesscontextmanager.v1.GetAccessLevelRequest;
import com.google.identity.accesscontextmanager.v1.GetAccessPolicyRequest;
import com.google.identity.accesscontextmanager.v1.GetGcpUserAccessBindingRequest;
import com.google.identity.accesscontextmanager.v1.GetServicePerimeterRequest;
import com.google.identity.accesscontextmanager.v1.ListAccessLevelsRequest;
import com.google.identity.accesscontextmanager.v1.ListAccessLevelsResponse;
import com.google.identity.accesscontextmanager.v1.ListAccessPoliciesRequest;
import com.google.identity.accesscontextmanager.v1.ListAccessPoliciesResponse;
import com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsRequest;
import com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsResponse;
import com.google.identity.accesscontextmanager.v1.ListServicePerimetersRequest;
import com.google.identity.accesscontextmanager.v1.ListServicePerimetersResponse;
import com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest;
import com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsResponse;
import com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersRequest;
import com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersResponse;
import com.google.identity.accesscontextmanager.v1.ServicePerimeter;
import com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest;
import com.google.identity.accesscontextmanager.v1.UpdateAccessPolicyRequest;
import com.google.identity.accesscontextmanager.v1.UpdateGcpUserAccessBindingRequest;
import com.google.identity.accesscontextmanager.v1.UpdateServicePerimeterRequest;
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
 * gRPC stub implementation for the AccessContextManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAccessContextManagerStub extends AccessContextManagerStub {
  private static final MethodDescriptor<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
      listAccessPoliciesMethodDescriptor =
          MethodDescriptor.<ListAccessPoliciesRequest, ListAccessPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/ListAccessPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAccessPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccessPoliciesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAccessPolicyRequest, AccessPolicy>
      getAccessPolicyMethodDescriptor =
          MethodDescriptor.<GetAccessPolicyRequest, AccessPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/GetAccessPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAccessPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AccessPolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AccessPolicy, Operation>
      createAccessPolicyMethodDescriptor =
          MethodDescriptor.<AccessPolicy, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/CreateAccessPolicy")
              .setRequestMarshaller(ProtoUtils.marshaller(AccessPolicy.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAccessPolicyRequest, Operation>
      updateAccessPolicyMethodDescriptor =
          MethodDescriptor.<UpdateAccessPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/UpdateAccessPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAccessPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAccessPolicyRequest, Operation>
      deleteAccessPolicyMethodDescriptor =
          MethodDescriptor.<DeleteAccessPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/DeleteAccessPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAccessPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAccessLevelsRequest, ListAccessLevelsResponse>
      listAccessLevelsMethodDescriptor =
          MethodDescriptor.<ListAccessLevelsRequest, ListAccessLevelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/ListAccessLevels")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAccessLevelsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccessLevelsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAccessLevelRequest, AccessLevel>
      getAccessLevelMethodDescriptor =
          MethodDescriptor.<GetAccessLevelRequest, AccessLevel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/GetAccessLevel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAccessLevelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AccessLevel.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAccessLevelRequest, Operation>
      createAccessLevelMethodDescriptor =
          MethodDescriptor.<CreateAccessLevelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/CreateAccessLevel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAccessLevelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAccessLevelRequest, Operation>
      updateAccessLevelMethodDescriptor =
          MethodDescriptor.<UpdateAccessLevelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/UpdateAccessLevel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAccessLevelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAccessLevelRequest, Operation>
      deleteAccessLevelMethodDescriptor =
          MethodDescriptor.<DeleteAccessLevelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/DeleteAccessLevel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAccessLevelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReplaceAccessLevelsRequest, Operation>
      replaceAccessLevelsMethodDescriptor =
          MethodDescriptor.<ReplaceAccessLevelsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/ReplaceAccessLevels")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReplaceAccessLevelsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListServicePerimetersRequest, ListServicePerimetersResponse>
      listServicePerimetersMethodDescriptor =
          MethodDescriptor.<ListServicePerimetersRequest, ListServicePerimetersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/ListServicePerimeters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListServicePerimetersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServicePerimetersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServicePerimeterRequest, ServicePerimeter>
      getServicePerimeterMethodDescriptor =
          MethodDescriptor.<GetServicePerimeterRequest, ServicePerimeter>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/GetServicePerimeter")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServicePerimeterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServicePerimeter.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateServicePerimeterRequest, Operation>
      createServicePerimeterMethodDescriptor =
          MethodDescriptor.<CreateServicePerimeterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/CreateServicePerimeter")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServicePerimeterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateServicePerimeterRequest, Operation>
      updateServicePerimeterMethodDescriptor =
          MethodDescriptor.<UpdateServicePerimeterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/UpdateServicePerimeter")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateServicePerimeterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteServicePerimeterRequest, Operation>
      deleteServicePerimeterMethodDescriptor =
          MethodDescriptor.<DeleteServicePerimeterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/DeleteServicePerimeter")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServicePerimeterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReplaceServicePerimetersRequest, Operation>
      replaceServicePerimetersMethodDescriptor =
          MethodDescriptor.<ReplaceServicePerimetersRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/ReplaceServicePerimeters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReplaceServicePerimetersRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CommitServicePerimetersRequest, Operation>
      commitServicePerimetersMethodDescriptor =
          MethodDescriptor.<CommitServicePerimetersRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/CommitServicePerimeters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CommitServicePerimetersRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsResponse>
      listGcpUserAccessBindingsMethodDescriptor =
          MethodDescriptor
              .<ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/ListGcpUserAccessBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGcpUserAccessBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGcpUserAccessBindingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>
      getGcpUserAccessBindingMethodDescriptor =
          MethodDescriptor.<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/GetGcpUserAccessBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGcpUserAccessBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GcpUserAccessBinding.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateGcpUserAccessBindingRequest, Operation>
      createGcpUserAccessBindingMethodDescriptor =
          MethodDescriptor.<CreateGcpUserAccessBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/CreateGcpUserAccessBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGcpUserAccessBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateGcpUserAccessBindingRequest, Operation>
      updateGcpUserAccessBindingMethodDescriptor =
          MethodDescriptor.<UpdateGcpUserAccessBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/UpdateGcpUserAccessBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGcpUserAccessBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteGcpUserAccessBindingRequest, Operation>
      deleteGcpUserAccessBindingMethodDescriptor =
          MethodDescriptor.<DeleteGcpUserAccessBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/DeleteGcpUserAccessBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGcpUserAccessBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.identity.accesscontextmanager.v1.AccessContextManager/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.identity.accesscontextmanager.v1.AccessContextManager/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.identity.accesscontextmanager.v1.AccessContextManager/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
      listAccessPoliciesCallable;
  private final UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesPagedResponse>
      listAccessPoliciesPagedCallable;
  private final UnaryCallable<GetAccessPolicyRequest, AccessPolicy> getAccessPolicyCallable;
  private final UnaryCallable<AccessPolicy, Operation> createAccessPolicyCallable;
  private final OperationCallable<AccessPolicy, AccessPolicy, AccessContextManagerOperationMetadata>
      createAccessPolicyOperationCallable;
  private final UnaryCallable<UpdateAccessPolicyRequest, Operation> updateAccessPolicyCallable;
  private final OperationCallable<
          UpdateAccessPolicyRequest, AccessPolicy, AccessContextManagerOperationMetadata>
      updateAccessPolicyOperationCallable;
  private final UnaryCallable<DeleteAccessPolicyRequest, Operation> deleteAccessPolicyCallable;
  private final OperationCallable<
          DeleteAccessPolicyRequest, Empty, AccessContextManagerOperationMetadata>
      deleteAccessPolicyOperationCallable;
  private final UnaryCallable<ListAccessLevelsRequest, ListAccessLevelsResponse>
      listAccessLevelsCallable;
  private final UnaryCallable<ListAccessLevelsRequest, ListAccessLevelsPagedResponse>
      listAccessLevelsPagedCallable;
  private final UnaryCallable<GetAccessLevelRequest, AccessLevel> getAccessLevelCallable;
  private final UnaryCallable<CreateAccessLevelRequest, Operation> createAccessLevelCallable;
  private final OperationCallable<
          CreateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
      createAccessLevelOperationCallable;
  private final UnaryCallable<UpdateAccessLevelRequest, Operation> updateAccessLevelCallable;
  private final OperationCallable<
          UpdateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
      updateAccessLevelOperationCallable;
  private final UnaryCallable<DeleteAccessLevelRequest, Operation> deleteAccessLevelCallable;
  private final OperationCallable<
          DeleteAccessLevelRequest, Empty, AccessContextManagerOperationMetadata>
      deleteAccessLevelOperationCallable;
  private final UnaryCallable<ReplaceAccessLevelsRequest, Operation> replaceAccessLevelsCallable;
  private final OperationCallable<
          ReplaceAccessLevelsRequest,
          ReplaceAccessLevelsResponse,
          AccessContextManagerOperationMetadata>
      replaceAccessLevelsOperationCallable;
  private final UnaryCallable<ListServicePerimetersRequest, ListServicePerimetersResponse>
      listServicePerimetersCallable;
  private final UnaryCallable<ListServicePerimetersRequest, ListServicePerimetersPagedResponse>
      listServicePerimetersPagedCallable;
  private final UnaryCallable<GetServicePerimeterRequest, ServicePerimeter>
      getServicePerimeterCallable;
  private final UnaryCallable<CreateServicePerimeterRequest, Operation>
      createServicePerimeterCallable;
  private final OperationCallable<
          CreateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
      createServicePerimeterOperationCallable;
  private final UnaryCallable<UpdateServicePerimeterRequest, Operation>
      updateServicePerimeterCallable;
  private final OperationCallable<
          UpdateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
      updateServicePerimeterOperationCallable;
  private final UnaryCallable<DeleteServicePerimeterRequest, Operation>
      deleteServicePerimeterCallable;
  private final OperationCallable<
          DeleteServicePerimeterRequest, Empty, AccessContextManagerOperationMetadata>
      deleteServicePerimeterOperationCallable;
  private final UnaryCallable<ReplaceServicePerimetersRequest, Operation>
      replaceServicePerimetersCallable;
  private final OperationCallable<
          ReplaceServicePerimetersRequest,
          ReplaceServicePerimetersResponse,
          AccessContextManagerOperationMetadata>
      replaceServicePerimetersOperationCallable;
  private final UnaryCallable<CommitServicePerimetersRequest, Operation>
      commitServicePerimetersCallable;
  private final OperationCallable<
          CommitServicePerimetersRequest,
          CommitServicePerimetersResponse,
          AccessContextManagerOperationMetadata>
      commitServicePerimetersOperationCallable;
  private final UnaryCallable<ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsResponse>
      listGcpUserAccessBindingsCallable;
  private final UnaryCallable<
          ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsPagedResponse>
      listGcpUserAccessBindingsPagedCallable;
  private final UnaryCallable<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>
      getGcpUserAccessBindingCallable;
  private final UnaryCallable<CreateGcpUserAccessBindingRequest, Operation>
      createGcpUserAccessBindingCallable;
  private final OperationCallable<
          CreateGcpUserAccessBindingRequest,
          GcpUserAccessBinding,
          GcpUserAccessBindingOperationMetadata>
      createGcpUserAccessBindingOperationCallable;
  private final UnaryCallable<UpdateGcpUserAccessBindingRequest, Operation>
      updateGcpUserAccessBindingCallable;
  private final OperationCallable<
          UpdateGcpUserAccessBindingRequest,
          GcpUserAccessBinding,
          GcpUserAccessBindingOperationMetadata>
      updateGcpUserAccessBindingOperationCallable;
  private final UnaryCallable<DeleteGcpUserAccessBindingRequest, Operation>
      deleteGcpUserAccessBindingCallable;
  private final OperationCallable<
          DeleteGcpUserAccessBindingRequest, Empty, GcpUserAccessBindingOperationMetadata>
      deleteGcpUserAccessBindingOperationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAccessContextManagerStub create(AccessContextManagerStubSettings settings)
      throws IOException {
    return new GrpcAccessContextManagerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAccessContextManagerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAccessContextManagerStub(
        AccessContextManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAccessContextManagerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAccessContextManagerStub(
        AccessContextManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAccessContextManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAccessContextManagerStub(
      AccessContextManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAccessContextManagerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAccessContextManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAccessContextManagerStub(
      AccessContextManagerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
        listAccessPoliciesTransportSettings =
            GrpcCallSettings.<ListAccessPoliciesRequest, ListAccessPoliciesResponse>newBuilder()
                .setMethodDescriptor(listAccessPoliciesMethodDescriptor)
                .build();
    GrpcCallSettings<GetAccessPolicyRequest, AccessPolicy> getAccessPolicyTransportSettings =
        GrpcCallSettings.<GetAccessPolicyRequest, AccessPolicy>newBuilder()
            .setMethodDescriptor(getAccessPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<AccessPolicy, Operation> createAccessPolicyTransportSettings =
        GrpcCallSettings.<AccessPolicy, Operation>newBuilder()
            .setMethodDescriptor(createAccessPolicyMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateAccessPolicyRequest, Operation> updateAccessPolicyTransportSettings =
        GrpcCallSettings.<UpdateAccessPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAccessPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("policy.name", String.valueOf(request.getPolicy().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteAccessPolicyRequest, Operation> deleteAccessPolicyTransportSettings =
        GrpcCallSettings.<DeleteAccessPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAccessPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListAccessLevelsRequest, ListAccessLevelsResponse>
        listAccessLevelsTransportSettings =
            GrpcCallSettings.<ListAccessLevelsRequest, ListAccessLevelsResponse>newBuilder()
                .setMethodDescriptor(listAccessLevelsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetAccessLevelRequest, AccessLevel> getAccessLevelTransportSettings =
        GrpcCallSettings.<GetAccessLevelRequest, AccessLevel>newBuilder()
            .setMethodDescriptor(getAccessLevelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateAccessLevelRequest, Operation> createAccessLevelTransportSettings =
        GrpcCallSettings.<CreateAccessLevelRequest, Operation>newBuilder()
            .setMethodDescriptor(createAccessLevelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateAccessLevelRequest, Operation> updateAccessLevelTransportSettings =
        GrpcCallSettings.<UpdateAccessLevelRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAccessLevelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "access_level.name", String.valueOf(request.getAccessLevel().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteAccessLevelRequest, Operation> deleteAccessLevelTransportSettings =
        GrpcCallSettings.<DeleteAccessLevelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAccessLevelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ReplaceAccessLevelsRequest, Operation> replaceAccessLevelsTransportSettings =
        GrpcCallSettings.<ReplaceAccessLevelsRequest, Operation>newBuilder()
            .setMethodDescriptor(replaceAccessLevelsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListServicePerimetersRequest, ListServicePerimetersResponse>
        listServicePerimetersTransportSettings =
            GrpcCallSettings
                .<ListServicePerimetersRequest, ListServicePerimetersResponse>newBuilder()
                .setMethodDescriptor(listServicePerimetersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetServicePerimeterRequest, ServicePerimeter>
        getServicePerimeterTransportSettings =
            GrpcCallSettings.<GetServicePerimeterRequest, ServicePerimeter>newBuilder()
                .setMethodDescriptor(getServicePerimeterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateServicePerimeterRequest, Operation>
        createServicePerimeterTransportSettings =
            GrpcCallSettings.<CreateServicePerimeterRequest, Operation>newBuilder()
                .setMethodDescriptor(createServicePerimeterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateServicePerimeterRequest, Operation>
        updateServicePerimeterTransportSettings =
            GrpcCallSettings.<UpdateServicePerimeterRequest, Operation>newBuilder()
                .setMethodDescriptor(updateServicePerimeterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "service_perimeter.name",
                          String.valueOf(request.getServicePerimeter().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteServicePerimeterRequest, Operation>
        deleteServicePerimeterTransportSettings =
            GrpcCallSettings.<DeleteServicePerimeterRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteServicePerimeterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ReplaceServicePerimetersRequest, Operation>
        replaceServicePerimetersTransportSettings =
            GrpcCallSettings.<ReplaceServicePerimetersRequest, Operation>newBuilder()
                .setMethodDescriptor(replaceServicePerimetersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CommitServicePerimetersRequest, Operation>
        commitServicePerimetersTransportSettings =
            GrpcCallSettings.<CommitServicePerimetersRequest, Operation>newBuilder()
                .setMethodDescriptor(commitServicePerimetersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsResponse>
        listGcpUserAccessBindingsTransportSettings =
            GrpcCallSettings
                .<ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsResponse>newBuilder()
                .setMethodDescriptor(listGcpUserAccessBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>
        getGcpUserAccessBindingTransportSettings =
            GrpcCallSettings.<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>newBuilder()
                .setMethodDescriptor(getGcpUserAccessBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateGcpUserAccessBindingRequest, Operation>
        createGcpUserAccessBindingTransportSettings =
            GrpcCallSettings.<CreateGcpUserAccessBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(createGcpUserAccessBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateGcpUserAccessBindingRequest, Operation>
        updateGcpUserAccessBindingTransportSettings =
            GrpcCallSettings.<UpdateGcpUserAccessBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(updateGcpUserAccessBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "gcp_user_access_binding.name",
                          String.valueOf(request.getGcpUserAccessBinding().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteGcpUserAccessBindingRequest, Operation>
        deleteGcpUserAccessBindingTransportSettings =
            GrpcCallSettings.<DeleteGcpUserAccessBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGcpUserAccessBindingMethodDescriptor)
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

    this.listAccessPoliciesCallable =
        callableFactory.createUnaryCallable(
            listAccessPoliciesTransportSettings,
            settings.listAccessPoliciesSettings(),
            clientContext);
    this.listAccessPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listAccessPoliciesTransportSettings,
            settings.listAccessPoliciesSettings(),
            clientContext);
    this.getAccessPolicyCallable =
        callableFactory.createUnaryCallable(
            getAccessPolicyTransportSettings, settings.getAccessPolicySettings(), clientContext);
    this.createAccessPolicyCallable =
        callableFactory.createUnaryCallable(
            createAccessPolicyTransportSettings,
            settings.createAccessPolicySettings(),
            clientContext);
    this.createAccessPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createAccessPolicyTransportSettings,
            settings.createAccessPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAccessPolicyCallable =
        callableFactory.createUnaryCallable(
            updateAccessPolicyTransportSettings,
            settings.updateAccessPolicySettings(),
            clientContext);
    this.updateAccessPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateAccessPolicyTransportSettings,
            settings.updateAccessPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAccessPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteAccessPolicyTransportSettings,
            settings.deleteAccessPolicySettings(),
            clientContext);
    this.deleteAccessPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteAccessPolicyTransportSettings,
            settings.deleteAccessPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.listAccessLevelsCallable =
        callableFactory.createUnaryCallable(
            listAccessLevelsTransportSettings, settings.listAccessLevelsSettings(), clientContext);
    this.listAccessLevelsPagedCallable =
        callableFactory.createPagedCallable(
            listAccessLevelsTransportSettings, settings.listAccessLevelsSettings(), clientContext);
    this.getAccessLevelCallable =
        callableFactory.createUnaryCallable(
            getAccessLevelTransportSettings, settings.getAccessLevelSettings(), clientContext);
    this.createAccessLevelCallable =
        callableFactory.createUnaryCallable(
            createAccessLevelTransportSettings,
            settings.createAccessLevelSettings(),
            clientContext);
    this.createAccessLevelOperationCallable =
        callableFactory.createOperationCallable(
            createAccessLevelTransportSettings,
            settings.createAccessLevelOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAccessLevelCallable =
        callableFactory.createUnaryCallable(
            updateAccessLevelTransportSettings,
            settings.updateAccessLevelSettings(),
            clientContext);
    this.updateAccessLevelOperationCallable =
        callableFactory.createOperationCallable(
            updateAccessLevelTransportSettings,
            settings.updateAccessLevelOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAccessLevelCallable =
        callableFactory.createUnaryCallable(
            deleteAccessLevelTransportSettings,
            settings.deleteAccessLevelSettings(),
            clientContext);
    this.deleteAccessLevelOperationCallable =
        callableFactory.createOperationCallable(
            deleteAccessLevelTransportSettings,
            settings.deleteAccessLevelOperationSettings(),
            clientContext,
            operationsStub);
    this.replaceAccessLevelsCallable =
        callableFactory.createUnaryCallable(
            replaceAccessLevelsTransportSettings,
            settings.replaceAccessLevelsSettings(),
            clientContext);
    this.replaceAccessLevelsOperationCallable =
        callableFactory.createOperationCallable(
            replaceAccessLevelsTransportSettings,
            settings.replaceAccessLevelsOperationSettings(),
            clientContext,
            operationsStub);
    this.listServicePerimetersCallable =
        callableFactory.createUnaryCallable(
            listServicePerimetersTransportSettings,
            settings.listServicePerimetersSettings(),
            clientContext);
    this.listServicePerimetersPagedCallable =
        callableFactory.createPagedCallable(
            listServicePerimetersTransportSettings,
            settings.listServicePerimetersSettings(),
            clientContext);
    this.getServicePerimeterCallable =
        callableFactory.createUnaryCallable(
            getServicePerimeterTransportSettings,
            settings.getServicePerimeterSettings(),
            clientContext);
    this.createServicePerimeterCallable =
        callableFactory.createUnaryCallable(
            createServicePerimeterTransportSettings,
            settings.createServicePerimeterSettings(),
            clientContext);
    this.createServicePerimeterOperationCallable =
        callableFactory.createOperationCallable(
            createServicePerimeterTransportSettings,
            settings.createServicePerimeterOperationSettings(),
            clientContext,
            operationsStub);
    this.updateServicePerimeterCallable =
        callableFactory.createUnaryCallable(
            updateServicePerimeterTransportSettings,
            settings.updateServicePerimeterSettings(),
            clientContext);
    this.updateServicePerimeterOperationCallable =
        callableFactory.createOperationCallable(
            updateServicePerimeterTransportSettings,
            settings.updateServicePerimeterOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteServicePerimeterCallable =
        callableFactory.createUnaryCallable(
            deleteServicePerimeterTransportSettings,
            settings.deleteServicePerimeterSettings(),
            clientContext);
    this.deleteServicePerimeterOperationCallable =
        callableFactory.createOperationCallable(
            deleteServicePerimeterTransportSettings,
            settings.deleteServicePerimeterOperationSettings(),
            clientContext,
            operationsStub);
    this.replaceServicePerimetersCallable =
        callableFactory.createUnaryCallable(
            replaceServicePerimetersTransportSettings,
            settings.replaceServicePerimetersSettings(),
            clientContext);
    this.replaceServicePerimetersOperationCallable =
        callableFactory.createOperationCallable(
            replaceServicePerimetersTransportSettings,
            settings.replaceServicePerimetersOperationSettings(),
            clientContext,
            operationsStub);
    this.commitServicePerimetersCallable =
        callableFactory.createUnaryCallable(
            commitServicePerimetersTransportSettings,
            settings.commitServicePerimetersSettings(),
            clientContext);
    this.commitServicePerimetersOperationCallable =
        callableFactory.createOperationCallable(
            commitServicePerimetersTransportSettings,
            settings.commitServicePerimetersOperationSettings(),
            clientContext,
            operationsStub);
    this.listGcpUserAccessBindingsCallable =
        callableFactory.createUnaryCallable(
            listGcpUserAccessBindingsTransportSettings,
            settings.listGcpUserAccessBindingsSettings(),
            clientContext);
    this.listGcpUserAccessBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listGcpUserAccessBindingsTransportSettings,
            settings.listGcpUserAccessBindingsSettings(),
            clientContext);
    this.getGcpUserAccessBindingCallable =
        callableFactory.createUnaryCallable(
            getGcpUserAccessBindingTransportSettings,
            settings.getGcpUserAccessBindingSettings(),
            clientContext);
    this.createGcpUserAccessBindingCallable =
        callableFactory.createUnaryCallable(
            createGcpUserAccessBindingTransportSettings,
            settings.createGcpUserAccessBindingSettings(),
            clientContext);
    this.createGcpUserAccessBindingOperationCallable =
        callableFactory.createOperationCallable(
            createGcpUserAccessBindingTransportSettings,
            settings.createGcpUserAccessBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.updateGcpUserAccessBindingCallable =
        callableFactory.createUnaryCallable(
            updateGcpUserAccessBindingTransportSettings,
            settings.updateGcpUserAccessBindingSettings(),
            clientContext);
    this.updateGcpUserAccessBindingOperationCallable =
        callableFactory.createOperationCallable(
            updateGcpUserAccessBindingTransportSettings,
            settings.updateGcpUserAccessBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteGcpUserAccessBindingCallable =
        callableFactory.createUnaryCallable(
            deleteGcpUserAccessBindingTransportSettings,
            settings.deleteGcpUserAccessBindingSettings(),
            clientContext);
    this.deleteGcpUserAccessBindingOperationCallable =
        callableFactory.createOperationCallable(
            deleteGcpUserAccessBindingTransportSettings,
            settings.deleteGcpUserAccessBindingOperationSettings(),
            clientContext,
            operationsStub);
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
  public UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesResponse>
      listAccessPoliciesCallable() {
    return listAccessPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesPagedResponse>
      listAccessPoliciesPagedCallable() {
    return listAccessPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAccessPolicyRequest, AccessPolicy> getAccessPolicyCallable() {
    return getAccessPolicyCallable;
  }

  @Override
  public UnaryCallable<AccessPolicy, Operation> createAccessPolicyCallable() {
    return createAccessPolicyCallable;
  }

  @Override
  public OperationCallable<AccessPolicy, AccessPolicy, AccessContextManagerOperationMetadata>
      createAccessPolicyOperationCallable() {
    return createAccessPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAccessPolicyRequest, Operation> updateAccessPolicyCallable() {
    return updateAccessPolicyCallable;
  }

  @Override
  public OperationCallable<
          UpdateAccessPolicyRequest, AccessPolicy, AccessContextManagerOperationMetadata>
      updateAccessPolicyOperationCallable() {
    return updateAccessPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAccessPolicyRequest, Operation> deleteAccessPolicyCallable() {
    return deleteAccessPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteAccessPolicyRequest, Empty, AccessContextManagerOperationMetadata>
      deleteAccessPolicyOperationCallable() {
    return deleteAccessPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<ListAccessLevelsRequest, ListAccessLevelsResponse>
      listAccessLevelsCallable() {
    return listAccessLevelsCallable;
  }

  @Override
  public UnaryCallable<ListAccessLevelsRequest, ListAccessLevelsPagedResponse>
      listAccessLevelsPagedCallable() {
    return listAccessLevelsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAccessLevelRequest, AccessLevel> getAccessLevelCallable() {
    return getAccessLevelCallable;
  }

  @Override
  public UnaryCallable<CreateAccessLevelRequest, Operation> createAccessLevelCallable() {
    return createAccessLevelCallable;
  }

  @Override
  public OperationCallable<
          CreateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
      createAccessLevelOperationCallable() {
    return createAccessLevelOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAccessLevelRequest, Operation> updateAccessLevelCallable() {
    return updateAccessLevelCallable;
  }

  @Override
  public OperationCallable<
          UpdateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
      updateAccessLevelOperationCallable() {
    return updateAccessLevelOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAccessLevelRequest, Operation> deleteAccessLevelCallable() {
    return deleteAccessLevelCallable;
  }

  @Override
  public OperationCallable<DeleteAccessLevelRequest, Empty, AccessContextManagerOperationMetadata>
      deleteAccessLevelOperationCallable() {
    return deleteAccessLevelOperationCallable;
  }

  @Override
  public UnaryCallable<ReplaceAccessLevelsRequest, Operation> replaceAccessLevelsCallable() {
    return replaceAccessLevelsCallable;
  }

  @Override
  public OperationCallable<
          ReplaceAccessLevelsRequest,
          ReplaceAccessLevelsResponse,
          AccessContextManagerOperationMetadata>
      replaceAccessLevelsOperationCallable() {
    return replaceAccessLevelsOperationCallable;
  }

  @Override
  public UnaryCallable<ListServicePerimetersRequest, ListServicePerimetersResponse>
      listServicePerimetersCallable() {
    return listServicePerimetersCallable;
  }

  @Override
  public UnaryCallable<ListServicePerimetersRequest, ListServicePerimetersPagedResponse>
      listServicePerimetersPagedCallable() {
    return listServicePerimetersPagedCallable;
  }

  @Override
  public UnaryCallable<GetServicePerimeterRequest, ServicePerimeter> getServicePerimeterCallable() {
    return getServicePerimeterCallable;
  }

  @Override
  public UnaryCallable<CreateServicePerimeterRequest, Operation> createServicePerimeterCallable() {
    return createServicePerimeterCallable;
  }

  @Override
  public OperationCallable<
          CreateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
      createServicePerimeterOperationCallable() {
    return createServicePerimeterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateServicePerimeterRequest, Operation> updateServicePerimeterCallable() {
    return updateServicePerimeterCallable;
  }

  @Override
  public OperationCallable<
          UpdateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
      updateServicePerimeterOperationCallable() {
    return updateServicePerimeterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServicePerimeterRequest, Operation> deleteServicePerimeterCallable() {
    return deleteServicePerimeterCallable;
  }

  @Override
  public OperationCallable<
          DeleteServicePerimeterRequest, Empty, AccessContextManagerOperationMetadata>
      deleteServicePerimeterOperationCallable() {
    return deleteServicePerimeterOperationCallable;
  }

  @Override
  public UnaryCallable<ReplaceServicePerimetersRequest, Operation>
      replaceServicePerimetersCallable() {
    return replaceServicePerimetersCallable;
  }

  @Override
  public OperationCallable<
          ReplaceServicePerimetersRequest,
          ReplaceServicePerimetersResponse,
          AccessContextManagerOperationMetadata>
      replaceServicePerimetersOperationCallable() {
    return replaceServicePerimetersOperationCallable;
  }

  @Override
  public UnaryCallable<CommitServicePerimetersRequest, Operation>
      commitServicePerimetersCallable() {
    return commitServicePerimetersCallable;
  }

  @Override
  public OperationCallable<
          CommitServicePerimetersRequest,
          CommitServicePerimetersResponse,
          AccessContextManagerOperationMetadata>
      commitServicePerimetersOperationCallable() {
    return commitServicePerimetersOperationCallable;
  }

  @Override
  public UnaryCallable<ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsResponse>
      listGcpUserAccessBindingsCallable() {
    return listGcpUserAccessBindingsCallable;
  }

  @Override
  public UnaryCallable<ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsPagedResponse>
      listGcpUserAccessBindingsPagedCallable() {
    return listGcpUserAccessBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>
      getGcpUserAccessBindingCallable() {
    return getGcpUserAccessBindingCallable;
  }

  @Override
  public UnaryCallable<CreateGcpUserAccessBindingRequest, Operation>
      createGcpUserAccessBindingCallable() {
    return createGcpUserAccessBindingCallable;
  }

  @Override
  public OperationCallable<
          CreateGcpUserAccessBindingRequest,
          GcpUserAccessBinding,
          GcpUserAccessBindingOperationMetadata>
      createGcpUserAccessBindingOperationCallable() {
    return createGcpUserAccessBindingOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateGcpUserAccessBindingRequest, Operation>
      updateGcpUserAccessBindingCallable() {
    return updateGcpUserAccessBindingCallable;
  }

  @Override
  public OperationCallable<
          UpdateGcpUserAccessBindingRequest,
          GcpUserAccessBinding,
          GcpUserAccessBindingOperationMetadata>
      updateGcpUserAccessBindingOperationCallable() {
    return updateGcpUserAccessBindingOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGcpUserAccessBindingRequest, Operation>
      deleteGcpUserAccessBindingCallable() {
    return deleteGcpUserAccessBindingCallable;
  }

  @Override
  public OperationCallable<
          DeleteGcpUserAccessBindingRequest, Empty, GcpUserAccessBindingOperationMetadata>
      deleteGcpUserAccessBindingOperationCallable() {
    return deleteGcpUserAccessBindingOperationCallable;
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
