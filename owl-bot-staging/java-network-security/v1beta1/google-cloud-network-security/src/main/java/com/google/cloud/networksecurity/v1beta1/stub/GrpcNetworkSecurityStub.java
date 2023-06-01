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

package com.google.cloud.networksecurity.v1beta1.stub;

import static com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient.ListAuthorizationPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient.ListClientTlsPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient.ListServerTlsPoliciesPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.cloud.networksecurity.v1beta1.AuthorizationPolicy;
import com.google.cloud.networksecurity.v1beta1.ClientTlsPolicy;
import com.google.cloud.networksecurity.v1beta1.CreateAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.CreateClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.CreateServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.DeleteAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.DeleteClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.DeleteServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.GetAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.GetClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.GetServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.ListAuthorizationPoliciesRequest;
import com.google.cloud.networksecurity.v1beta1.ListAuthorizationPoliciesResponse;
import com.google.cloud.networksecurity.v1beta1.ListClientTlsPoliciesRequest;
import com.google.cloud.networksecurity.v1beta1.ListClientTlsPoliciesResponse;
import com.google.cloud.networksecurity.v1beta1.ListServerTlsPoliciesRequest;
import com.google.cloud.networksecurity.v1beta1.ListServerTlsPoliciesResponse;
import com.google.cloud.networksecurity.v1beta1.OperationMetadata;
import com.google.cloud.networksecurity.v1beta1.ServerTlsPolicy;
import com.google.cloud.networksecurity.v1beta1.UpdateAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.UpdateClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.UpdateServerTlsPolicyRequest;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the NetworkSecurity service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcNetworkSecurityStub extends NetworkSecurityStub {
  private static final MethodDescriptor<
          ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>
      listAuthorizationPoliciesMethodDescriptor =
          MethodDescriptor
              .<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/ListAuthorizationPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAuthorizationPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAuthorizationPoliciesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAuthorizationPolicyRequest, AuthorizationPolicy>
      getAuthorizationPolicyMethodDescriptor =
          MethodDescriptor.<GetAuthorizationPolicyRequest, AuthorizationPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/GetAuthorizationPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAuthorizationPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AuthorizationPolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAuthorizationPolicyRequest, Operation>
      createAuthorizationPolicyMethodDescriptor =
          MethodDescriptor.<CreateAuthorizationPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/CreateAuthorizationPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAuthorizationPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAuthorizationPolicyRequest, Operation>
      updateAuthorizationPolicyMethodDescriptor =
          MethodDescriptor.<UpdateAuthorizationPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/UpdateAuthorizationPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAuthorizationPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAuthorizationPolicyRequest, Operation>
      deleteAuthorizationPolicyMethodDescriptor =
          MethodDescriptor.<DeleteAuthorizationPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/DeleteAuthorizationPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAuthorizationPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>
      listServerTlsPoliciesMethodDescriptor =
          MethodDescriptor.<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/ListServerTlsPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListServerTlsPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServerTlsPoliciesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServerTlsPolicyRequest, ServerTlsPolicy>
      getServerTlsPolicyMethodDescriptor =
          MethodDescriptor.<GetServerTlsPolicyRequest, ServerTlsPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/GetServerTlsPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServerTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServerTlsPolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateServerTlsPolicyRequest, Operation>
      createServerTlsPolicyMethodDescriptor =
          MethodDescriptor.<CreateServerTlsPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/CreateServerTlsPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServerTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateServerTlsPolicyRequest, Operation>
      updateServerTlsPolicyMethodDescriptor =
          MethodDescriptor.<UpdateServerTlsPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/UpdateServerTlsPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateServerTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteServerTlsPolicyRequest, Operation>
      deleteServerTlsPolicyMethodDescriptor =
          MethodDescriptor.<DeleteServerTlsPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/DeleteServerTlsPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServerTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>
      listClientTlsPoliciesMethodDescriptor =
          MethodDescriptor.<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/ListClientTlsPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListClientTlsPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListClientTlsPoliciesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetClientTlsPolicyRequest, ClientTlsPolicy>
      getClientTlsPolicyMethodDescriptor =
          MethodDescriptor.<GetClientTlsPolicyRequest, ClientTlsPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/GetClientTlsPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetClientTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ClientTlsPolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateClientTlsPolicyRequest, Operation>
      createClientTlsPolicyMethodDescriptor =
          MethodDescriptor.<CreateClientTlsPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/CreateClientTlsPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateClientTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateClientTlsPolicyRequest, Operation>
      updateClientTlsPolicyMethodDescriptor =
          MethodDescriptor.<UpdateClientTlsPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/UpdateClientTlsPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateClientTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteClientTlsPolicyRequest, Operation>
      deleteClientTlsPolicyMethodDescriptor =
          MethodDescriptor.<DeleteClientTlsPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1beta1.NetworkSecurity/DeleteClientTlsPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteClientTlsPolicyRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>
      listAuthorizationPoliciesCallable;
  private final UnaryCallable<
          ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesPagedResponse>
      listAuthorizationPoliciesPagedCallable;
  private final UnaryCallable<GetAuthorizationPolicyRequest, AuthorizationPolicy>
      getAuthorizationPolicyCallable;
  private final UnaryCallable<CreateAuthorizationPolicyRequest, Operation>
      createAuthorizationPolicyCallable;
  private final OperationCallable<
          CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      createAuthorizationPolicyOperationCallable;
  private final UnaryCallable<UpdateAuthorizationPolicyRequest, Operation>
      updateAuthorizationPolicyCallable;
  private final OperationCallable<
          UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      updateAuthorizationPolicyOperationCallable;
  private final UnaryCallable<DeleteAuthorizationPolicyRequest, Operation>
      deleteAuthorizationPolicyCallable;
  private final OperationCallable<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
      deleteAuthorizationPolicyOperationCallable;
  private final UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>
      listServerTlsPoliciesCallable;
  private final UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesPagedResponse>
      listServerTlsPoliciesPagedCallable;
  private final UnaryCallable<GetServerTlsPolicyRequest, ServerTlsPolicy>
      getServerTlsPolicyCallable;
  private final UnaryCallable<CreateServerTlsPolicyRequest, Operation>
      createServerTlsPolicyCallable;
  private final OperationCallable<CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      createServerTlsPolicyOperationCallable;
  private final UnaryCallable<UpdateServerTlsPolicyRequest, Operation>
      updateServerTlsPolicyCallable;
  private final OperationCallable<UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      updateServerTlsPolicyOperationCallable;
  private final UnaryCallable<DeleteServerTlsPolicyRequest, Operation>
      deleteServerTlsPolicyCallable;
  private final OperationCallable<DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
      deleteServerTlsPolicyOperationCallable;
  private final UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>
      listClientTlsPoliciesCallable;
  private final UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesPagedResponse>
      listClientTlsPoliciesPagedCallable;
  private final UnaryCallable<GetClientTlsPolicyRequest, ClientTlsPolicy>
      getClientTlsPolicyCallable;
  private final UnaryCallable<CreateClientTlsPolicyRequest, Operation>
      createClientTlsPolicyCallable;
  private final OperationCallable<CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      createClientTlsPolicyOperationCallable;
  private final UnaryCallable<UpdateClientTlsPolicyRequest, Operation>
      updateClientTlsPolicyCallable;
  private final OperationCallable<UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      updateClientTlsPolicyOperationCallable;
  private final UnaryCallable<DeleteClientTlsPolicyRequest, Operation>
      deleteClientTlsPolicyCallable;
  private final OperationCallable<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
      deleteClientTlsPolicyOperationCallable;
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

  public static final GrpcNetworkSecurityStub create(NetworkSecurityStubSettings settings)
      throws IOException {
    return new GrpcNetworkSecurityStub(settings, ClientContext.create(settings));
  }

  public static final GrpcNetworkSecurityStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcNetworkSecurityStub(
        NetworkSecurityStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcNetworkSecurityStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcNetworkSecurityStub(
        NetworkSecurityStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcNetworkSecurityStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcNetworkSecurityStub(
      NetworkSecurityStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcNetworkSecurityCallableFactory());
  }

  /**
   * Constructs an instance of GrpcNetworkSecurityStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcNetworkSecurityStub(
      NetworkSecurityStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>
        listAuthorizationPoliciesTransportSettings =
            GrpcCallSettings
                .<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>newBuilder()
                .setMethodDescriptor(listAuthorizationPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetAuthorizationPolicyRequest, AuthorizationPolicy>
        getAuthorizationPolicyTransportSettings =
            GrpcCallSettings.<GetAuthorizationPolicyRequest, AuthorizationPolicy>newBuilder()
                .setMethodDescriptor(getAuthorizationPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateAuthorizationPolicyRequest, Operation>
        createAuthorizationPolicyTransportSettings =
            GrpcCallSettings.<CreateAuthorizationPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createAuthorizationPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateAuthorizationPolicyRequest, Operation>
        updateAuthorizationPolicyTransportSettings =
            GrpcCallSettings.<UpdateAuthorizationPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateAuthorizationPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "authorization_policy.name",
                          String.valueOf(request.getAuthorizationPolicy().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteAuthorizationPolicyRequest, Operation>
        deleteAuthorizationPolicyTransportSettings =
            GrpcCallSettings.<DeleteAuthorizationPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteAuthorizationPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>
        listServerTlsPoliciesTransportSettings =
            GrpcCallSettings
                .<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>newBuilder()
                .setMethodDescriptor(listServerTlsPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetServerTlsPolicyRequest, ServerTlsPolicy>
        getServerTlsPolicyTransportSettings =
            GrpcCallSettings.<GetServerTlsPolicyRequest, ServerTlsPolicy>newBuilder()
                .setMethodDescriptor(getServerTlsPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateServerTlsPolicyRequest, Operation>
        createServerTlsPolicyTransportSettings =
            GrpcCallSettings.<CreateServerTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createServerTlsPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateServerTlsPolicyRequest, Operation>
        updateServerTlsPolicyTransportSettings =
            GrpcCallSettings.<UpdateServerTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateServerTlsPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "server_tls_policy.name",
                          String.valueOf(request.getServerTlsPolicy().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteServerTlsPolicyRequest, Operation>
        deleteServerTlsPolicyTransportSettings =
            GrpcCallSettings.<DeleteServerTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteServerTlsPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>
        listClientTlsPoliciesTransportSettings =
            GrpcCallSettings
                .<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>newBuilder()
                .setMethodDescriptor(listClientTlsPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetClientTlsPolicyRequest, ClientTlsPolicy>
        getClientTlsPolicyTransportSettings =
            GrpcCallSettings.<GetClientTlsPolicyRequest, ClientTlsPolicy>newBuilder()
                .setMethodDescriptor(getClientTlsPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateClientTlsPolicyRequest, Operation>
        createClientTlsPolicyTransportSettings =
            GrpcCallSettings.<CreateClientTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createClientTlsPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateClientTlsPolicyRequest, Operation>
        updateClientTlsPolicyTransportSettings =
            GrpcCallSettings.<UpdateClientTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateClientTlsPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "client_tls_policy.name",
                          String.valueOf(request.getClientTlsPolicy().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteClientTlsPolicyRequest, Operation>
        deleteClientTlsPolicyTransportSettings =
            GrpcCallSettings.<DeleteClientTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteClientTlsPolicyMethodDescriptor)
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

    this.listAuthorizationPoliciesCallable =
        callableFactory.createUnaryCallable(
            listAuthorizationPoliciesTransportSettings,
            settings.listAuthorizationPoliciesSettings(),
            clientContext);
    this.listAuthorizationPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listAuthorizationPoliciesTransportSettings,
            settings.listAuthorizationPoliciesSettings(),
            clientContext);
    this.getAuthorizationPolicyCallable =
        callableFactory.createUnaryCallable(
            getAuthorizationPolicyTransportSettings,
            settings.getAuthorizationPolicySettings(),
            clientContext);
    this.createAuthorizationPolicyCallable =
        callableFactory.createUnaryCallable(
            createAuthorizationPolicyTransportSettings,
            settings.createAuthorizationPolicySettings(),
            clientContext);
    this.createAuthorizationPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createAuthorizationPolicyTransportSettings,
            settings.createAuthorizationPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAuthorizationPolicyCallable =
        callableFactory.createUnaryCallable(
            updateAuthorizationPolicyTransportSettings,
            settings.updateAuthorizationPolicySettings(),
            clientContext);
    this.updateAuthorizationPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateAuthorizationPolicyTransportSettings,
            settings.updateAuthorizationPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAuthorizationPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteAuthorizationPolicyTransportSettings,
            settings.deleteAuthorizationPolicySettings(),
            clientContext);
    this.deleteAuthorizationPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteAuthorizationPolicyTransportSettings,
            settings.deleteAuthorizationPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.listServerTlsPoliciesCallable =
        callableFactory.createUnaryCallable(
            listServerTlsPoliciesTransportSettings,
            settings.listServerTlsPoliciesSettings(),
            clientContext);
    this.listServerTlsPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listServerTlsPoliciesTransportSettings,
            settings.listServerTlsPoliciesSettings(),
            clientContext);
    this.getServerTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            getServerTlsPolicyTransportSettings,
            settings.getServerTlsPolicySettings(),
            clientContext);
    this.createServerTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            createServerTlsPolicyTransportSettings,
            settings.createServerTlsPolicySettings(),
            clientContext);
    this.createServerTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createServerTlsPolicyTransportSettings,
            settings.createServerTlsPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateServerTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            updateServerTlsPolicyTransportSettings,
            settings.updateServerTlsPolicySettings(),
            clientContext);
    this.updateServerTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateServerTlsPolicyTransportSettings,
            settings.updateServerTlsPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteServerTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteServerTlsPolicyTransportSettings,
            settings.deleteServerTlsPolicySettings(),
            clientContext);
    this.deleteServerTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteServerTlsPolicyTransportSettings,
            settings.deleteServerTlsPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.listClientTlsPoliciesCallable =
        callableFactory.createUnaryCallable(
            listClientTlsPoliciesTransportSettings,
            settings.listClientTlsPoliciesSettings(),
            clientContext);
    this.listClientTlsPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listClientTlsPoliciesTransportSettings,
            settings.listClientTlsPoliciesSettings(),
            clientContext);
    this.getClientTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            getClientTlsPolicyTransportSettings,
            settings.getClientTlsPolicySettings(),
            clientContext);
    this.createClientTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            createClientTlsPolicyTransportSettings,
            settings.createClientTlsPolicySettings(),
            clientContext);
    this.createClientTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createClientTlsPolicyTransportSettings,
            settings.createClientTlsPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateClientTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            updateClientTlsPolicyTransportSettings,
            settings.updateClientTlsPolicySettings(),
            clientContext);
    this.updateClientTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateClientTlsPolicyTransportSettings,
            settings.updateClientTlsPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteClientTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteClientTlsPolicyTransportSettings,
            settings.deleteClientTlsPolicySettings(),
            clientContext);
    this.deleteClientTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteClientTlsPolicyTransportSettings,
            settings.deleteClientTlsPolicyOperationSettings(),
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
  public UnaryCallable<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>
      listAuthorizationPoliciesCallable() {
    return listAuthorizationPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesPagedResponse>
      listAuthorizationPoliciesPagedCallable() {
    return listAuthorizationPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAuthorizationPolicyRequest, AuthorizationPolicy>
      getAuthorizationPolicyCallable() {
    return getAuthorizationPolicyCallable;
  }

  @Override
  public UnaryCallable<CreateAuthorizationPolicyRequest, Operation>
      createAuthorizationPolicyCallable() {
    return createAuthorizationPolicyCallable;
  }

  @Override
  public OperationCallable<CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      createAuthorizationPolicyOperationCallable() {
    return createAuthorizationPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAuthorizationPolicyRequest, Operation>
      updateAuthorizationPolicyCallable() {
    return updateAuthorizationPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      updateAuthorizationPolicyOperationCallable() {
    return updateAuthorizationPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAuthorizationPolicyRequest, Operation>
      deleteAuthorizationPolicyCallable() {
    return deleteAuthorizationPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
      deleteAuthorizationPolicyOperationCallable() {
    return deleteAuthorizationPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>
      listServerTlsPoliciesCallable() {
    return listServerTlsPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesPagedResponse>
      listServerTlsPoliciesPagedCallable() {
    return listServerTlsPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetServerTlsPolicyRequest, ServerTlsPolicy> getServerTlsPolicyCallable() {
    return getServerTlsPolicyCallable;
  }

  @Override
  public UnaryCallable<CreateServerTlsPolicyRequest, Operation> createServerTlsPolicyCallable() {
    return createServerTlsPolicyCallable;
  }

  @Override
  public OperationCallable<CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      createServerTlsPolicyOperationCallable() {
    return createServerTlsPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateServerTlsPolicyRequest, Operation> updateServerTlsPolicyCallable() {
    return updateServerTlsPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      updateServerTlsPolicyOperationCallable() {
    return updateServerTlsPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServerTlsPolicyRequest, Operation> deleteServerTlsPolicyCallable() {
    return deleteServerTlsPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
      deleteServerTlsPolicyOperationCallable() {
    return deleteServerTlsPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>
      listClientTlsPoliciesCallable() {
    return listClientTlsPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesPagedResponse>
      listClientTlsPoliciesPagedCallable() {
    return listClientTlsPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetClientTlsPolicyRequest, ClientTlsPolicy> getClientTlsPolicyCallable() {
    return getClientTlsPolicyCallable;
  }

  @Override
  public UnaryCallable<CreateClientTlsPolicyRequest, Operation> createClientTlsPolicyCallable() {
    return createClientTlsPolicyCallable;
  }

  @Override
  public OperationCallable<CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      createClientTlsPolicyOperationCallable() {
    return createClientTlsPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateClientTlsPolicyRequest, Operation> updateClientTlsPolicyCallable() {
    return updateClientTlsPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      updateClientTlsPolicyOperationCallable() {
    return updateClientTlsPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteClientTlsPolicyRequest, Operation> deleteClientTlsPolicyCallable() {
    return deleteClientTlsPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
      deleteClientTlsPolicyOperationCallable() {
    return deleteClientTlsPolicyOperationCallable;
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
