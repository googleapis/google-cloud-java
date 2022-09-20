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

package com.google.cloud.iam.admin.v1.stub;

import static com.google.cloud.iam.admin.v1.IAMClient.ListRolesPagedResponse;
import static com.google.cloud.iam.admin.v1.IAMClient.ListServiceAccountsPagedResponse;
import static com.google.cloud.iam.admin.v1.IAMClient.QueryGrantableRolesPagedResponse;
import static com.google.cloud.iam.admin.v1.IAMClient.QueryTestablePermissionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.iam.admin.v1.CreateRoleRequest;
import com.google.iam.admin.v1.CreateServiceAccountKeyRequest;
import com.google.iam.admin.v1.CreateServiceAccountRequest;
import com.google.iam.admin.v1.DeleteRoleRequest;
import com.google.iam.admin.v1.DeleteServiceAccountKeyRequest;
import com.google.iam.admin.v1.DeleteServiceAccountRequest;
import com.google.iam.admin.v1.DisableServiceAccountKeyRequest;
import com.google.iam.admin.v1.DisableServiceAccountRequest;
import com.google.iam.admin.v1.EnableServiceAccountKeyRequest;
import com.google.iam.admin.v1.EnableServiceAccountRequest;
import com.google.iam.admin.v1.GetRoleRequest;
import com.google.iam.admin.v1.GetServiceAccountKeyRequest;
import com.google.iam.admin.v1.GetServiceAccountRequest;
import com.google.iam.admin.v1.LintPolicyRequest;
import com.google.iam.admin.v1.LintPolicyResponse;
import com.google.iam.admin.v1.ListRolesRequest;
import com.google.iam.admin.v1.ListRolesResponse;
import com.google.iam.admin.v1.ListServiceAccountKeysRequest;
import com.google.iam.admin.v1.ListServiceAccountKeysResponse;
import com.google.iam.admin.v1.ListServiceAccountsRequest;
import com.google.iam.admin.v1.ListServiceAccountsResponse;
import com.google.iam.admin.v1.PatchServiceAccountRequest;
import com.google.iam.admin.v1.QueryAuditableServicesRequest;
import com.google.iam.admin.v1.QueryAuditableServicesResponse;
import com.google.iam.admin.v1.QueryGrantableRolesRequest;
import com.google.iam.admin.v1.QueryGrantableRolesResponse;
import com.google.iam.admin.v1.QueryTestablePermissionsRequest;
import com.google.iam.admin.v1.QueryTestablePermissionsResponse;
import com.google.iam.admin.v1.Role;
import com.google.iam.admin.v1.ServiceAccount;
import com.google.iam.admin.v1.ServiceAccountKey;
import com.google.iam.admin.v1.SignBlobRequest;
import com.google.iam.admin.v1.SignBlobResponse;
import com.google.iam.admin.v1.SignJwtRequest;
import com.google.iam.admin.v1.SignJwtResponse;
import com.google.iam.admin.v1.UndeleteRoleRequest;
import com.google.iam.admin.v1.UndeleteServiceAccountRequest;
import com.google.iam.admin.v1.UndeleteServiceAccountResponse;
import com.google.iam.admin.v1.UpdateRoleRequest;
import com.google.iam.admin.v1.UploadServiceAccountKeyRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the IAM service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcIAMStub extends IAMStub {
  private static final MethodDescriptor<ListServiceAccountsRequest, ListServiceAccountsResponse>
      listServiceAccountsMethodDescriptor =
          MethodDescriptor.<ListServiceAccountsRequest, ListServiceAccountsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/ListServiceAccounts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListServiceAccountsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServiceAccountsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServiceAccountRequest, ServiceAccount>
      getServiceAccountMethodDescriptor =
          MethodDescriptor.<GetServiceAccountRequest, ServiceAccount>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/GetServiceAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServiceAccount.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateServiceAccountRequest, ServiceAccount>
      createServiceAccountMethodDescriptor =
          MethodDescriptor.<CreateServiceAccountRequest, ServiceAccount>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/CreateServiceAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServiceAccount.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ServiceAccount, ServiceAccount>
      updateServiceAccountMethodDescriptor =
          MethodDescriptor.<ServiceAccount, ServiceAccount>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/UpdateServiceAccount")
              .setRequestMarshaller(ProtoUtils.marshaller(ServiceAccount.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServiceAccount.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PatchServiceAccountRequest, ServiceAccount>
      patchServiceAccountMethodDescriptor =
          MethodDescriptor.<PatchServiceAccountRequest, ServiceAccount>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/PatchServiceAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PatchServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServiceAccount.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteServiceAccountRequest, Empty>
      deleteServiceAccountMethodDescriptor =
          MethodDescriptor.<DeleteServiceAccountRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/DeleteServiceAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          UndeleteServiceAccountRequest, UndeleteServiceAccountResponse>
      undeleteServiceAccountMethodDescriptor =
          MethodDescriptor
              .<UndeleteServiceAccountRequest, UndeleteServiceAccountResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/UndeleteServiceAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeleteServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UndeleteServiceAccountResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<EnableServiceAccountRequest, Empty>
      enableServiceAccountMethodDescriptor =
          MethodDescriptor.<EnableServiceAccountRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/EnableServiceAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnableServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DisableServiceAccountRequest, Empty>
      disableServiceAccountMethodDescriptor =
          MethodDescriptor.<DisableServiceAccountRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/DisableServiceAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisableServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListServiceAccountKeysRequest, ListServiceAccountKeysResponse>
      listServiceAccountKeysMethodDescriptor =
          MethodDescriptor
              .<ListServiceAccountKeysRequest, ListServiceAccountKeysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/ListServiceAccountKeys")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListServiceAccountKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServiceAccountKeysResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServiceAccountKeyRequest, ServiceAccountKey>
      getServiceAccountKeyMethodDescriptor =
          MethodDescriptor.<GetServiceAccountKeyRequest, ServiceAccountKey>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/GetServiceAccountKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServiceAccountKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServiceAccountKey.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateServiceAccountKeyRequest, ServiceAccountKey>
      createServiceAccountKeyMethodDescriptor =
          MethodDescriptor.<CreateServiceAccountKeyRequest, ServiceAccountKey>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/CreateServiceAccountKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceAccountKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServiceAccountKey.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UploadServiceAccountKeyRequest, ServiceAccountKey>
      uploadServiceAccountKeyMethodDescriptor =
          MethodDescriptor.<UploadServiceAccountKeyRequest, ServiceAccountKey>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/UploadServiceAccountKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UploadServiceAccountKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServiceAccountKey.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteServiceAccountKeyRequest, Empty>
      deleteServiceAccountKeyMethodDescriptor =
          MethodDescriptor.<DeleteServiceAccountKeyRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/DeleteServiceAccountKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServiceAccountKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DisableServiceAccountKeyRequest, Empty>
      disableServiceAccountKeyMethodDescriptor =
          MethodDescriptor.<DisableServiceAccountKeyRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/DisableServiceAccountKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisableServiceAccountKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<EnableServiceAccountKeyRequest, Empty>
      enableServiceAccountKeyMethodDescriptor =
          MethodDescriptor.<EnableServiceAccountKeyRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/EnableServiceAccountKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnableServiceAccountKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SignBlobRequest, SignBlobResponse>
      signBlobMethodDescriptor =
          MethodDescriptor.<SignBlobRequest, SignBlobResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/SignBlob")
              .setRequestMarshaller(ProtoUtils.marshaller(SignBlobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SignBlobResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SignJwtRequest, SignJwtResponse> signJwtMethodDescriptor =
      MethodDescriptor.<SignJwtRequest, SignJwtResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.admin.v1.IAM/SignJwt")
          .setRequestMarshaller(ProtoUtils.marshaller(SignJwtRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(SignJwtResponse.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.admin.v1.IAM/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.admin.v1.IAM/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<QueryGrantableRolesRequest, QueryGrantableRolesResponse>
      queryGrantableRolesMethodDescriptor =
          MethodDescriptor.<QueryGrantableRolesRequest, QueryGrantableRolesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/QueryGrantableRoles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryGrantableRolesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryGrantableRolesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRolesRequest, ListRolesResponse>
      listRolesMethodDescriptor =
          MethodDescriptor.<ListRolesRequest, ListRolesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/ListRoles")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRolesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListRolesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRoleRequest, Role> getRoleMethodDescriptor =
      MethodDescriptor.<GetRoleRequest, Role>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.admin.v1.IAM/GetRole")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRoleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Role.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateRoleRequest, Role> createRoleMethodDescriptor =
      MethodDescriptor.<CreateRoleRequest, Role>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.admin.v1.IAM/CreateRole")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateRoleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Role.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateRoleRequest, Role> updateRoleMethodDescriptor =
      MethodDescriptor.<UpdateRoleRequest, Role>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.admin.v1.IAM/UpdateRole")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateRoleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Role.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteRoleRequest, Role> deleteRoleMethodDescriptor =
      MethodDescriptor.<DeleteRoleRequest, Role>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.admin.v1.IAM/DeleteRole")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteRoleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Role.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UndeleteRoleRequest, Role> undeleteRoleMethodDescriptor =
      MethodDescriptor.<UndeleteRoleRequest, Role>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.admin.v1.IAM/UndeleteRole")
          .setRequestMarshaller(ProtoUtils.marshaller(UndeleteRoleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Role.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<
          QueryTestablePermissionsRequest, QueryTestablePermissionsResponse>
      queryTestablePermissionsMethodDescriptor =
          MethodDescriptor
              .<QueryTestablePermissionsRequest, QueryTestablePermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/QueryTestablePermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryTestablePermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryTestablePermissionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          QueryAuditableServicesRequest, QueryAuditableServicesResponse>
      queryAuditableServicesMethodDescriptor =
          MethodDescriptor
              .<QueryAuditableServicesRequest, QueryAuditableServicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/QueryAuditableServices")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryAuditableServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryAuditableServicesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<LintPolicyRequest, LintPolicyResponse>
      lintPolicyMethodDescriptor =
          MethodDescriptor.<LintPolicyRequest, LintPolicyResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.admin.v1.IAM/LintPolicy")
              .setRequestMarshaller(ProtoUtils.marshaller(LintPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LintPolicyResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListServiceAccountsRequest, ListServiceAccountsResponse>
      listServiceAccountsCallable;
  private final UnaryCallable<ListServiceAccountsRequest, ListServiceAccountsPagedResponse>
      listServiceAccountsPagedCallable;
  private final UnaryCallable<GetServiceAccountRequest, ServiceAccount> getServiceAccountCallable;
  private final UnaryCallable<CreateServiceAccountRequest, ServiceAccount>
      createServiceAccountCallable;
  private final UnaryCallable<ServiceAccount, ServiceAccount> updateServiceAccountCallable;
  private final UnaryCallable<PatchServiceAccountRequest, ServiceAccount>
      patchServiceAccountCallable;
  private final UnaryCallable<DeleteServiceAccountRequest, Empty> deleteServiceAccountCallable;
  private final UnaryCallable<UndeleteServiceAccountRequest, UndeleteServiceAccountResponse>
      undeleteServiceAccountCallable;
  private final UnaryCallable<EnableServiceAccountRequest, Empty> enableServiceAccountCallable;
  private final UnaryCallable<DisableServiceAccountRequest, Empty> disableServiceAccountCallable;
  private final UnaryCallable<ListServiceAccountKeysRequest, ListServiceAccountKeysResponse>
      listServiceAccountKeysCallable;
  private final UnaryCallable<GetServiceAccountKeyRequest, ServiceAccountKey>
      getServiceAccountKeyCallable;
  private final UnaryCallable<CreateServiceAccountKeyRequest, ServiceAccountKey>
      createServiceAccountKeyCallable;
  private final UnaryCallable<UploadServiceAccountKeyRequest, ServiceAccountKey>
      uploadServiceAccountKeyCallable;
  private final UnaryCallable<DeleteServiceAccountKeyRequest, Empty>
      deleteServiceAccountKeyCallable;
  private final UnaryCallable<DisableServiceAccountKeyRequest, Empty>
      disableServiceAccountKeyCallable;
  private final UnaryCallable<EnableServiceAccountKeyRequest, Empty>
      enableServiceAccountKeyCallable;
  private final UnaryCallable<SignBlobRequest, SignBlobResponse> signBlobCallable;
  private final UnaryCallable<SignJwtRequest, SignJwtResponse> signJwtCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<QueryGrantableRolesRequest, QueryGrantableRolesResponse>
      queryGrantableRolesCallable;
  private final UnaryCallable<QueryGrantableRolesRequest, QueryGrantableRolesPagedResponse>
      queryGrantableRolesPagedCallable;
  private final UnaryCallable<ListRolesRequest, ListRolesResponse> listRolesCallable;
  private final UnaryCallable<ListRolesRequest, ListRolesPagedResponse> listRolesPagedCallable;
  private final UnaryCallable<GetRoleRequest, Role> getRoleCallable;
  private final UnaryCallable<CreateRoleRequest, Role> createRoleCallable;
  private final UnaryCallable<UpdateRoleRequest, Role> updateRoleCallable;
  private final UnaryCallable<DeleteRoleRequest, Role> deleteRoleCallable;
  private final UnaryCallable<UndeleteRoleRequest, Role> undeleteRoleCallable;
  private final UnaryCallable<QueryTestablePermissionsRequest, QueryTestablePermissionsResponse>
      queryTestablePermissionsCallable;
  private final UnaryCallable<
          QueryTestablePermissionsRequest, QueryTestablePermissionsPagedResponse>
      queryTestablePermissionsPagedCallable;
  private final UnaryCallable<QueryAuditableServicesRequest, QueryAuditableServicesResponse>
      queryAuditableServicesCallable;
  private final UnaryCallable<LintPolicyRequest, LintPolicyResponse> lintPolicyCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcIAMStub create(IAMStubSettings settings) throws IOException {
    return new GrpcIAMStub(settings, ClientContext.create(settings));
  }

  public static final GrpcIAMStub create(ClientContext clientContext) throws IOException {
    return new GrpcIAMStub(IAMStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcIAMStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcIAMStub(IAMStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcIAMStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcIAMStub(IAMStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcIAMCallableFactory());
  }

  /**
   * Constructs an instance of GrpcIAMStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcIAMStub(
      IAMStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListServiceAccountsRequest, ListServiceAccountsResponse>
        listServiceAccountsTransportSettings =
            GrpcCallSettings.<ListServiceAccountsRequest, ListServiceAccountsResponse>newBuilder()
                .setMethodDescriptor(listServiceAccountsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetServiceAccountRequest, ServiceAccount> getServiceAccountTransportSettings =
        GrpcCallSettings.<GetServiceAccountRequest, ServiceAccount>newBuilder()
            .setMethodDescriptor(getServiceAccountMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateServiceAccountRequest, ServiceAccount>
        createServiceAccountTransportSettings =
            GrpcCallSettings.<CreateServiceAccountRequest, ServiceAccount>newBuilder()
                .setMethodDescriptor(createServiceAccountMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ServiceAccount, ServiceAccount> updateServiceAccountTransportSettings =
        GrpcCallSettings.<ServiceAccount, ServiceAccount>newBuilder()
            .setMethodDescriptor(updateServiceAccountMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<PatchServiceAccountRequest, ServiceAccount>
        patchServiceAccountTransportSettings =
            GrpcCallSettings.<PatchServiceAccountRequest, ServiceAccount>newBuilder()
                .setMethodDescriptor(patchServiceAccountMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "service_account.name",
                          String.valueOf(request.getServiceAccount().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteServiceAccountRequest, Empty> deleteServiceAccountTransportSettings =
        GrpcCallSettings.<DeleteServiceAccountRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteServiceAccountMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UndeleteServiceAccountRequest, UndeleteServiceAccountResponse>
        undeleteServiceAccountTransportSettings =
            GrpcCallSettings
                .<UndeleteServiceAccountRequest, UndeleteServiceAccountResponse>newBuilder()
                .setMethodDescriptor(undeleteServiceAccountMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<EnableServiceAccountRequest, Empty> enableServiceAccountTransportSettings =
        GrpcCallSettings.<EnableServiceAccountRequest, Empty>newBuilder()
            .setMethodDescriptor(enableServiceAccountMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DisableServiceAccountRequest, Empty> disableServiceAccountTransportSettings =
        GrpcCallSettings.<DisableServiceAccountRequest, Empty>newBuilder()
            .setMethodDescriptor(disableServiceAccountMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListServiceAccountKeysRequest, ListServiceAccountKeysResponse>
        listServiceAccountKeysTransportSettings =
            GrpcCallSettings
                .<ListServiceAccountKeysRequest, ListServiceAccountKeysResponse>newBuilder()
                .setMethodDescriptor(listServiceAccountKeysMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetServiceAccountKeyRequest, ServiceAccountKey>
        getServiceAccountKeyTransportSettings =
            GrpcCallSettings.<GetServiceAccountKeyRequest, ServiceAccountKey>newBuilder()
                .setMethodDescriptor(getServiceAccountKeyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateServiceAccountKeyRequest, ServiceAccountKey>
        createServiceAccountKeyTransportSettings =
            GrpcCallSettings.<CreateServiceAccountKeyRequest, ServiceAccountKey>newBuilder()
                .setMethodDescriptor(createServiceAccountKeyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UploadServiceAccountKeyRequest, ServiceAccountKey>
        uploadServiceAccountKeyTransportSettings =
            GrpcCallSettings.<UploadServiceAccountKeyRequest, ServiceAccountKey>newBuilder()
                .setMethodDescriptor(uploadServiceAccountKeyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteServiceAccountKeyRequest, Empty>
        deleteServiceAccountKeyTransportSettings =
            GrpcCallSettings.<DeleteServiceAccountKeyRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteServiceAccountKeyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DisableServiceAccountKeyRequest, Empty>
        disableServiceAccountKeyTransportSettings =
            GrpcCallSettings.<DisableServiceAccountKeyRequest, Empty>newBuilder()
                .setMethodDescriptor(disableServiceAccountKeyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<EnableServiceAccountKeyRequest, Empty>
        enableServiceAccountKeyTransportSettings =
            GrpcCallSettings.<EnableServiceAccountKeyRequest, Empty>newBuilder()
                .setMethodDescriptor(enableServiceAccountKeyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SignBlobRequest, SignBlobResponse> signBlobTransportSettings =
        GrpcCallSettings.<SignBlobRequest, SignBlobResponse>newBuilder()
            .setMethodDescriptor(signBlobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SignJwtRequest, SignJwtResponse> signJwtTransportSettings =
        GrpcCallSettings.<SignJwtRequest, SignJwtResponse>newBuilder()
            .setMethodDescriptor(signJwtMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
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
    GrpcCallSettings<QueryGrantableRolesRequest, QueryGrantableRolesResponse>
        queryGrantableRolesTransportSettings =
            GrpcCallSettings.<QueryGrantableRolesRequest, QueryGrantableRolesResponse>newBuilder()
                .setMethodDescriptor(queryGrantableRolesMethodDescriptor)
                .build();
    GrpcCallSettings<ListRolesRequest, ListRolesResponse> listRolesTransportSettings =
        GrpcCallSettings.<ListRolesRequest, ListRolesResponse>newBuilder()
            .setMethodDescriptor(listRolesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetRoleRequest, Role> getRoleTransportSettings =
        GrpcCallSettings.<GetRoleRequest, Role>newBuilder()
            .setMethodDescriptor(getRoleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateRoleRequest, Role> createRoleTransportSettings =
        GrpcCallSettings.<CreateRoleRequest, Role>newBuilder()
            .setMethodDescriptor(createRoleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateRoleRequest, Role> updateRoleTransportSettings =
        GrpcCallSettings.<UpdateRoleRequest, Role>newBuilder()
            .setMethodDescriptor(updateRoleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteRoleRequest, Role> deleteRoleTransportSettings =
        GrpcCallSettings.<DeleteRoleRequest, Role>newBuilder()
            .setMethodDescriptor(deleteRoleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UndeleteRoleRequest, Role> undeleteRoleTransportSettings =
        GrpcCallSettings.<UndeleteRoleRequest, Role>newBuilder()
            .setMethodDescriptor(undeleteRoleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<QueryTestablePermissionsRequest, QueryTestablePermissionsResponse>
        queryTestablePermissionsTransportSettings =
            GrpcCallSettings
                .<QueryTestablePermissionsRequest, QueryTestablePermissionsResponse>newBuilder()
                .setMethodDescriptor(queryTestablePermissionsMethodDescriptor)
                .build();
    GrpcCallSettings<QueryAuditableServicesRequest, QueryAuditableServicesResponse>
        queryAuditableServicesTransportSettings =
            GrpcCallSettings
                .<QueryAuditableServicesRequest, QueryAuditableServicesResponse>newBuilder()
                .setMethodDescriptor(queryAuditableServicesMethodDescriptor)
                .build();
    GrpcCallSettings<LintPolicyRequest, LintPolicyResponse> lintPolicyTransportSettings =
        GrpcCallSettings.<LintPolicyRequest, LintPolicyResponse>newBuilder()
            .setMethodDescriptor(lintPolicyMethodDescriptor)
            .build();

    this.listServiceAccountsCallable =
        callableFactory.createUnaryCallable(
            listServiceAccountsTransportSettings,
            settings.listServiceAccountsSettings(),
            clientContext);
    this.listServiceAccountsPagedCallable =
        callableFactory.createPagedCallable(
            listServiceAccountsTransportSettings,
            settings.listServiceAccountsSettings(),
            clientContext);
    this.getServiceAccountCallable =
        callableFactory.createUnaryCallable(
            getServiceAccountTransportSettings,
            settings.getServiceAccountSettings(),
            clientContext);
    this.createServiceAccountCallable =
        callableFactory.createUnaryCallable(
            createServiceAccountTransportSettings,
            settings.createServiceAccountSettings(),
            clientContext);
    this.updateServiceAccountCallable =
        callableFactory.createUnaryCallable(
            updateServiceAccountTransportSettings,
            settings.updateServiceAccountSettings(),
            clientContext);
    this.patchServiceAccountCallable =
        callableFactory.createUnaryCallable(
            patchServiceAccountTransportSettings,
            settings.patchServiceAccountSettings(),
            clientContext);
    this.deleteServiceAccountCallable =
        callableFactory.createUnaryCallable(
            deleteServiceAccountTransportSettings,
            settings.deleteServiceAccountSettings(),
            clientContext);
    this.undeleteServiceAccountCallable =
        callableFactory.createUnaryCallable(
            undeleteServiceAccountTransportSettings,
            settings.undeleteServiceAccountSettings(),
            clientContext);
    this.enableServiceAccountCallable =
        callableFactory.createUnaryCallable(
            enableServiceAccountTransportSettings,
            settings.enableServiceAccountSettings(),
            clientContext);
    this.disableServiceAccountCallable =
        callableFactory.createUnaryCallable(
            disableServiceAccountTransportSettings,
            settings.disableServiceAccountSettings(),
            clientContext);
    this.listServiceAccountKeysCallable =
        callableFactory.createUnaryCallable(
            listServiceAccountKeysTransportSettings,
            settings.listServiceAccountKeysSettings(),
            clientContext);
    this.getServiceAccountKeyCallable =
        callableFactory.createUnaryCallable(
            getServiceAccountKeyTransportSettings,
            settings.getServiceAccountKeySettings(),
            clientContext);
    this.createServiceAccountKeyCallable =
        callableFactory.createUnaryCallable(
            createServiceAccountKeyTransportSettings,
            settings.createServiceAccountKeySettings(),
            clientContext);
    this.uploadServiceAccountKeyCallable =
        callableFactory.createUnaryCallable(
            uploadServiceAccountKeyTransportSettings,
            settings.uploadServiceAccountKeySettings(),
            clientContext);
    this.deleteServiceAccountKeyCallable =
        callableFactory.createUnaryCallable(
            deleteServiceAccountKeyTransportSettings,
            settings.deleteServiceAccountKeySettings(),
            clientContext);
    this.disableServiceAccountKeyCallable =
        callableFactory.createUnaryCallable(
            disableServiceAccountKeyTransportSettings,
            settings.disableServiceAccountKeySettings(),
            clientContext);
    this.enableServiceAccountKeyCallable =
        callableFactory.createUnaryCallable(
            enableServiceAccountKeyTransportSettings,
            settings.enableServiceAccountKeySettings(),
            clientContext);
    this.signBlobCallable =
        callableFactory.createUnaryCallable(
            signBlobTransportSettings, settings.signBlobSettings(), clientContext);
    this.signJwtCallable =
        callableFactory.createUnaryCallable(
            signJwtTransportSettings, settings.signJwtSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);
    this.queryGrantableRolesCallable =
        callableFactory.createUnaryCallable(
            queryGrantableRolesTransportSettings,
            settings.queryGrantableRolesSettings(),
            clientContext);
    this.queryGrantableRolesPagedCallable =
        callableFactory.createPagedCallable(
            queryGrantableRolesTransportSettings,
            settings.queryGrantableRolesSettings(),
            clientContext);
    this.listRolesCallable =
        callableFactory.createUnaryCallable(
            listRolesTransportSettings, settings.listRolesSettings(), clientContext);
    this.listRolesPagedCallable =
        callableFactory.createPagedCallable(
            listRolesTransportSettings, settings.listRolesSettings(), clientContext);
    this.getRoleCallable =
        callableFactory.createUnaryCallable(
            getRoleTransportSettings, settings.getRoleSettings(), clientContext);
    this.createRoleCallable =
        callableFactory.createUnaryCallable(
            createRoleTransportSettings, settings.createRoleSettings(), clientContext);
    this.updateRoleCallable =
        callableFactory.createUnaryCallable(
            updateRoleTransportSettings, settings.updateRoleSettings(), clientContext);
    this.deleteRoleCallable =
        callableFactory.createUnaryCallable(
            deleteRoleTransportSettings, settings.deleteRoleSettings(), clientContext);
    this.undeleteRoleCallable =
        callableFactory.createUnaryCallable(
            undeleteRoleTransportSettings, settings.undeleteRoleSettings(), clientContext);
    this.queryTestablePermissionsCallable =
        callableFactory.createUnaryCallable(
            queryTestablePermissionsTransportSettings,
            settings.queryTestablePermissionsSettings(),
            clientContext);
    this.queryTestablePermissionsPagedCallable =
        callableFactory.createPagedCallable(
            queryTestablePermissionsTransportSettings,
            settings.queryTestablePermissionsSettings(),
            clientContext);
    this.queryAuditableServicesCallable =
        callableFactory.createUnaryCallable(
            queryAuditableServicesTransportSettings,
            settings.queryAuditableServicesSettings(),
            clientContext);
    this.lintPolicyCallable =
        callableFactory.createUnaryCallable(
            lintPolicyTransportSettings, settings.lintPolicySettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListServiceAccountsRequest, ListServiceAccountsResponse>
      listServiceAccountsCallable() {
    return listServiceAccountsCallable;
  }

  @Override
  public UnaryCallable<ListServiceAccountsRequest, ListServiceAccountsPagedResponse>
      listServiceAccountsPagedCallable() {
    return listServiceAccountsPagedCallable;
  }

  @Override
  public UnaryCallable<GetServiceAccountRequest, ServiceAccount> getServiceAccountCallable() {
    return getServiceAccountCallable;
  }

  @Override
  public UnaryCallable<CreateServiceAccountRequest, ServiceAccount> createServiceAccountCallable() {
    return createServiceAccountCallable;
  }

  @Override
  public UnaryCallable<ServiceAccount, ServiceAccount> updateServiceAccountCallable() {
    return updateServiceAccountCallable;
  }

  @Override
  public UnaryCallable<PatchServiceAccountRequest, ServiceAccount> patchServiceAccountCallable() {
    return patchServiceAccountCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceAccountRequest, Empty> deleteServiceAccountCallable() {
    return deleteServiceAccountCallable;
  }

  @Override
  public UnaryCallable<UndeleteServiceAccountRequest, UndeleteServiceAccountResponse>
      undeleteServiceAccountCallable() {
    return undeleteServiceAccountCallable;
  }

  @Override
  public UnaryCallable<EnableServiceAccountRequest, Empty> enableServiceAccountCallable() {
    return enableServiceAccountCallable;
  }

  @Override
  public UnaryCallable<DisableServiceAccountRequest, Empty> disableServiceAccountCallable() {
    return disableServiceAccountCallable;
  }

  @Override
  public UnaryCallable<ListServiceAccountKeysRequest, ListServiceAccountKeysResponse>
      listServiceAccountKeysCallable() {
    return listServiceAccountKeysCallable;
  }

  @Override
  public UnaryCallable<GetServiceAccountKeyRequest, ServiceAccountKey>
      getServiceAccountKeyCallable() {
    return getServiceAccountKeyCallable;
  }

  @Override
  public UnaryCallable<CreateServiceAccountKeyRequest, ServiceAccountKey>
      createServiceAccountKeyCallable() {
    return createServiceAccountKeyCallable;
  }

  @Override
  public UnaryCallable<UploadServiceAccountKeyRequest, ServiceAccountKey>
      uploadServiceAccountKeyCallable() {
    return uploadServiceAccountKeyCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceAccountKeyRequest, Empty> deleteServiceAccountKeyCallable() {
    return deleteServiceAccountKeyCallable;
  }

  @Override
  public UnaryCallable<DisableServiceAccountKeyRequest, Empty> disableServiceAccountKeyCallable() {
    return disableServiceAccountKeyCallable;
  }

  @Override
  public UnaryCallable<EnableServiceAccountKeyRequest, Empty> enableServiceAccountKeyCallable() {
    return enableServiceAccountKeyCallable;
  }

  @Override
  public UnaryCallable<SignBlobRequest, SignBlobResponse> signBlobCallable() {
    return signBlobCallable;
  }

  @Override
  public UnaryCallable<SignJwtRequest, SignJwtResponse> signJwtCallable() {
    return signJwtCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public UnaryCallable<QueryGrantableRolesRequest, QueryGrantableRolesResponse>
      queryGrantableRolesCallable() {
    return queryGrantableRolesCallable;
  }

  @Override
  public UnaryCallable<QueryGrantableRolesRequest, QueryGrantableRolesPagedResponse>
      queryGrantableRolesPagedCallable() {
    return queryGrantableRolesPagedCallable;
  }

  @Override
  public UnaryCallable<ListRolesRequest, ListRolesResponse> listRolesCallable() {
    return listRolesCallable;
  }

  @Override
  public UnaryCallable<ListRolesRequest, ListRolesPagedResponse> listRolesPagedCallable() {
    return listRolesPagedCallable;
  }

  @Override
  public UnaryCallable<GetRoleRequest, Role> getRoleCallable() {
    return getRoleCallable;
  }

  @Override
  public UnaryCallable<CreateRoleRequest, Role> createRoleCallable() {
    return createRoleCallable;
  }

  @Override
  public UnaryCallable<UpdateRoleRequest, Role> updateRoleCallable() {
    return updateRoleCallable;
  }

  @Override
  public UnaryCallable<DeleteRoleRequest, Role> deleteRoleCallable() {
    return deleteRoleCallable;
  }

  @Override
  public UnaryCallable<UndeleteRoleRequest, Role> undeleteRoleCallable() {
    return undeleteRoleCallable;
  }

  @Override
  public UnaryCallable<QueryTestablePermissionsRequest, QueryTestablePermissionsResponse>
      queryTestablePermissionsCallable() {
    return queryTestablePermissionsCallable;
  }

  @Override
  public UnaryCallable<QueryTestablePermissionsRequest, QueryTestablePermissionsPagedResponse>
      queryTestablePermissionsPagedCallable() {
    return queryTestablePermissionsPagedCallable;
  }

  @Override
  public UnaryCallable<QueryAuditableServicesRequest, QueryAuditableServicesResponse>
      queryAuditableServicesCallable() {
    return queryAuditableServicesCallable;
  }

  @Override
  public UnaryCallable<LintPolicyRequest, LintPolicyResponse> lintPolicyCallable() {
    return lintPolicyCallable;
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
