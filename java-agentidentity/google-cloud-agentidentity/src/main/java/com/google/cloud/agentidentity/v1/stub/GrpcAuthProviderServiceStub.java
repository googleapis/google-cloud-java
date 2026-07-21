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

package com.google.cloud.agentidentity.v1.stub;

import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.ListAccessSummariesPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.ListAuthProvidersPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.ListAuthorizationsPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.QueryAuthProvidersPagedResponse;
import static com.google.cloud.agentidentity.v1.AuthProviderServiceClient.QueryWorkloadsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.agentidentity.v1.AccessSummary;
import com.google.cloud.agentidentity.v1.AuthProvider;
import com.google.cloud.agentidentity.v1.Authorization;
import com.google.cloud.agentidentity.v1.CreateAuthProviderRequest;
import com.google.cloud.agentidentity.v1.DeleteAuthProviderRequest;
import com.google.cloud.agentidentity.v1.DeleteAuthorizationRequest;
import com.google.cloud.agentidentity.v1.DisableAuthProviderRequest;
import com.google.cloud.agentidentity.v1.EnableAuthProviderRequest;
import com.google.cloud.agentidentity.v1.GetAccessSummaryRequest;
import com.google.cloud.agentidentity.v1.GetAuthProviderRequest;
import com.google.cloud.agentidentity.v1.GetAuthorizationRequest;
import com.google.cloud.agentidentity.v1.ListAccessSummariesRequest;
import com.google.cloud.agentidentity.v1.ListAccessSummariesResponse;
import com.google.cloud.agentidentity.v1.ListAuthProvidersRequest;
import com.google.cloud.agentidentity.v1.ListAuthProvidersResponse;
import com.google.cloud.agentidentity.v1.ListAuthorizationsRequest;
import com.google.cloud.agentidentity.v1.ListAuthorizationsResponse;
import com.google.cloud.agentidentity.v1.QueryAuthProvidersRequest;
import com.google.cloud.agentidentity.v1.QueryAuthProvidersResponse;
import com.google.cloud.agentidentity.v1.QueryWorkloadsRequest;
import com.google.cloud.agentidentity.v1.QueryWorkloadsResponse;
import com.google.cloud.agentidentity.v1.RevokeAuthorizationRequest;
import com.google.cloud.agentidentity.v1.RevokeAuthorizationResponse;
import com.google.cloud.agentidentity.v1.UndeleteAuthProviderRequest;
import com.google.cloud.agentidentity.v1.UpdateAuthProviderRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AuthProviderService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcAuthProviderServiceStub extends AuthProviderServiceStub {
  private static final MethodDescriptor<ListAuthProvidersRequest, ListAuthProvidersResponse>
      listAuthProvidersMethodDescriptor =
          MethodDescriptor.<ListAuthProvidersRequest, ListAuthProvidersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/ListAuthProviders")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAuthProvidersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAuthProvidersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAuthProviderRequest, AuthProvider>
      getAuthProviderMethodDescriptor =
          MethodDescriptor.<GetAuthProviderRequest, AuthProvider>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/GetAuthProvider")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAuthProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AuthProvider.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAuthProviderRequest, AuthProvider>
      createAuthProviderMethodDescriptor =
          MethodDescriptor.<CreateAuthProviderRequest, AuthProvider>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/CreateAuthProvider")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAuthProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AuthProvider.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateAuthProviderRequest, AuthProvider>
      updateAuthProviderMethodDescriptor =
          MethodDescriptor.<UpdateAuthProviderRequest, AuthProvider>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/UpdateAuthProvider")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAuthProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AuthProvider.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAuthProviderRequest, Empty>
      deleteAuthProviderMethodDescriptor =
          MethodDescriptor.<DeleteAuthProviderRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/DeleteAuthProvider")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAuthProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UndeleteAuthProviderRequest, AuthProvider>
      undeleteAuthProviderMethodDescriptor =
          MethodDescriptor.<UndeleteAuthProviderRequest, AuthProvider>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/UndeleteAuthProvider")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeleteAuthProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AuthProvider.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<QueryAuthProvidersRequest, QueryAuthProvidersResponse>
      queryAuthProvidersMethodDescriptor =
          MethodDescriptor.<QueryAuthProvidersRequest, QueryAuthProvidersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/QueryAuthProviders")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryAuthProvidersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryAuthProvidersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<QueryWorkloadsRequest, QueryWorkloadsResponse>
      queryWorkloadsMethodDescriptor =
          MethodDescriptor.<QueryWorkloadsRequest, QueryWorkloadsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.agentidentity.v1.AuthProviderService/QueryWorkloads")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryWorkloadsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryWorkloadsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListAuthorizationsRequest, ListAuthorizationsResponse>
      listAuthorizationsMethodDescriptor =
          MethodDescriptor.<ListAuthorizationsRequest, ListAuthorizationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/ListAuthorizations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAuthorizationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAuthorizationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAuthorizationRequest, Authorization>
      getAuthorizationMethodDescriptor =
          MethodDescriptor.<GetAuthorizationRequest, Authorization>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/GetAuthorization")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAuthorizationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Authorization.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAuthorizationRequest, Empty>
      deleteAuthorizationMethodDescriptor =
          MethodDescriptor.<DeleteAuthorizationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/DeleteAuthorization")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAuthorizationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListAccessSummariesRequest, ListAccessSummariesResponse>
      listAccessSummariesMethodDescriptor =
          MethodDescriptor.<ListAccessSummariesRequest, ListAccessSummariesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/ListAccessSummaries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAccessSummariesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccessSummariesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAccessSummaryRequest, AccessSummary>
      getAccessSummaryMethodDescriptor =
          MethodDescriptor.<GetAccessSummaryRequest, AccessSummary>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/GetAccessSummary")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAccessSummaryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AccessSummary.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RevokeAuthorizationRequest, RevokeAuthorizationResponse>
      revokeAuthorizationMethodDescriptor =
          MethodDescriptor.<RevokeAuthorizationRequest, RevokeAuthorizationResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/RevokeAuthorization")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RevokeAuthorizationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RevokeAuthorizationResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<EnableAuthProviderRequest, AuthProvider>
      enableAuthProviderMethodDescriptor =
          MethodDescriptor.<EnableAuthProviderRequest, AuthProvider>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/EnableAuthProvider")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnableAuthProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AuthProvider.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DisableAuthProviderRequest, AuthProvider>
      disableAuthProviderMethodDescriptor =
          MethodDescriptor.<DisableAuthProviderRequest, AuthProvider>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.agentidentity.v1.AuthProviderService/DisableAuthProvider")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisableAuthProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AuthProvider.getDefaultInstance()))
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

  private final UnaryCallable<ListAuthProvidersRequest, ListAuthProvidersResponse>
      listAuthProvidersCallable;
  private final UnaryCallable<ListAuthProvidersRequest, ListAuthProvidersPagedResponse>
      listAuthProvidersPagedCallable;
  private final UnaryCallable<GetAuthProviderRequest, AuthProvider> getAuthProviderCallable;
  private final UnaryCallable<CreateAuthProviderRequest, AuthProvider> createAuthProviderCallable;
  private final UnaryCallable<UpdateAuthProviderRequest, AuthProvider> updateAuthProviderCallable;
  private final UnaryCallable<DeleteAuthProviderRequest, Empty> deleteAuthProviderCallable;
  private final UnaryCallable<UndeleteAuthProviderRequest, AuthProvider>
      undeleteAuthProviderCallable;
  private final UnaryCallable<QueryAuthProvidersRequest, QueryAuthProvidersResponse>
      queryAuthProvidersCallable;
  private final UnaryCallable<QueryAuthProvidersRequest, QueryAuthProvidersPagedResponse>
      queryAuthProvidersPagedCallable;
  private final UnaryCallable<QueryWorkloadsRequest, QueryWorkloadsResponse> queryWorkloadsCallable;
  private final UnaryCallable<QueryWorkloadsRequest, QueryWorkloadsPagedResponse>
      queryWorkloadsPagedCallable;
  private final UnaryCallable<ListAuthorizationsRequest, ListAuthorizationsResponse>
      listAuthorizationsCallable;
  private final UnaryCallable<ListAuthorizationsRequest, ListAuthorizationsPagedResponse>
      listAuthorizationsPagedCallable;
  private final UnaryCallable<GetAuthorizationRequest, Authorization> getAuthorizationCallable;
  private final UnaryCallable<DeleteAuthorizationRequest, Empty> deleteAuthorizationCallable;
  private final UnaryCallable<ListAccessSummariesRequest, ListAccessSummariesResponse>
      listAccessSummariesCallable;
  private final UnaryCallable<ListAccessSummariesRequest, ListAccessSummariesPagedResponse>
      listAccessSummariesPagedCallable;
  private final UnaryCallable<GetAccessSummaryRequest, AccessSummary> getAccessSummaryCallable;
  private final UnaryCallable<RevokeAuthorizationRequest, RevokeAuthorizationResponse>
      revokeAuthorizationCallable;
  private final UnaryCallable<EnableAuthProviderRequest, AuthProvider> enableAuthProviderCallable;
  private final UnaryCallable<DisableAuthProviderRequest, AuthProvider> disableAuthProviderCallable;
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

  public static final GrpcAuthProviderServiceStub create(AuthProviderServiceStubSettings settings)
      throws IOException {
    return new GrpcAuthProviderServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAuthProviderServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAuthProviderServiceStub(
        AuthProviderServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAuthProviderServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAuthProviderServiceStub(
        AuthProviderServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAuthProviderServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAuthProviderServiceStub(
      AuthProviderServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAuthProviderServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAuthProviderServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAuthProviderServiceStub(
      AuthProviderServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAuthProvidersRequest, ListAuthProvidersResponse>
        listAuthProvidersTransportSettings =
            GrpcCallSettings.<ListAuthProvidersRequest, ListAuthProvidersResponse>newBuilder()
                .setMethodDescriptor(listAuthProvidersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetAuthProviderRequest, AuthProvider> getAuthProviderTransportSettings =
        GrpcCallSettings.<GetAuthProviderRequest, AuthProvider>newBuilder()
            .setMethodDescriptor(getAuthProviderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateAuthProviderRequest, AuthProvider> createAuthProviderTransportSettings =
        GrpcCallSettings.<CreateAuthProviderRequest, AuthProvider>newBuilder()
            .setMethodDescriptor(createAuthProviderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateAuthProviderRequest, AuthProvider> updateAuthProviderTransportSettings =
        GrpcCallSettings.<UpdateAuthProviderRequest, AuthProvider>newBuilder()
            .setMethodDescriptor(updateAuthProviderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "auth_provider.name", String.valueOf(request.getAuthProvider().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAuthProviderRequest, Empty> deleteAuthProviderTransportSettings =
        GrpcCallSettings.<DeleteAuthProviderRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAuthProviderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<UndeleteAuthProviderRequest, AuthProvider>
        undeleteAuthProviderTransportSettings =
            GrpcCallSettings.<UndeleteAuthProviderRequest, AuthProvider>newBuilder()
                .setMethodDescriptor(undeleteAuthProviderMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<QueryAuthProvidersRequest, QueryAuthProvidersResponse>
        queryAuthProvidersTransportSettings =
            GrpcCallSettings.<QueryAuthProvidersRequest, QueryAuthProvidersResponse>newBuilder()
                .setMethodDescriptor(queryAuthProvidersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<QueryWorkloadsRequest, QueryWorkloadsResponse>
        queryWorkloadsTransportSettings =
            GrpcCallSettings.<QueryWorkloadsRequest, QueryWorkloadsResponse>newBuilder()
                .setMethodDescriptor(queryWorkloadsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListAuthorizationsRequest, ListAuthorizationsResponse>
        listAuthorizationsTransportSettings =
            GrpcCallSettings.<ListAuthorizationsRequest, ListAuthorizationsResponse>newBuilder()
                .setMethodDescriptor(listAuthorizationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetAuthorizationRequest, Authorization> getAuthorizationTransportSettings =
        GrpcCallSettings.<GetAuthorizationRequest, Authorization>newBuilder()
            .setMethodDescriptor(getAuthorizationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<DeleteAuthorizationRequest, Empty> deleteAuthorizationTransportSettings =
        GrpcCallSettings.<DeleteAuthorizationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAuthorizationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListAccessSummariesRequest, ListAccessSummariesResponse>
        listAccessSummariesTransportSettings =
            GrpcCallSettings.<ListAccessSummariesRequest, ListAccessSummariesResponse>newBuilder()
                .setMethodDescriptor(listAccessSummariesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetAccessSummaryRequest, AccessSummary> getAccessSummaryTransportSettings =
        GrpcCallSettings.<GetAccessSummaryRequest, AccessSummary>newBuilder()
            .setMethodDescriptor(getAccessSummaryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<RevokeAuthorizationRequest, RevokeAuthorizationResponse>
        revokeAuthorizationTransportSettings =
            GrpcCallSettings.<RevokeAuthorizationRequest, RevokeAuthorizationResponse>newBuilder()
                .setMethodDescriptor(revokeAuthorizationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<EnableAuthProviderRequest, AuthProvider> enableAuthProviderTransportSettings =
        GrpcCallSettings.<EnableAuthProviderRequest, AuthProvider>newBuilder()
            .setMethodDescriptor(enableAuthProviderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<DisableAuthProviderRequest, AuthProvider>
        disableAuthProviderTransportSettings =
            GrpcCallSettings.<DisableAuthProviderRequest, AuthProvider>newBuilder()
                .setMethodDescriptor(disableAuthProviderMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getResource())
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
            .setResourceNameExtractor(request -> request.getResource())
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
                .setResourceNameExtractor(request -> request.getResource())
                .build();

    this.listAuthProvidersCallable =
        callableFactory.createUnaryCallable(
            listAuthProvidersTransportSettings,
            settings.listAuthProvidersSettings(),
            clientContext);
    this.listAuthProvidersPagedCallable =
        callableFactory.createPagedCallable(
            listAuthProvidersTransportSettings,
            settings.listAuthProvidersSettings(),
            clientContext);
    this.getAuthProviderCallable =
        callableFactory.createUnaryCallable(
            getAuthProviderTransportSettings, settings.getAuthProviderSettings(), clientContext);
    this.createAuthProviderCallable =
        callableFactory.createUnaryCallable(
            createAuthProviderTransportSettings,
            settings.createAuthProviderSettings(),
            clientContext);
    this.updateAuthProviderCallable =
        callableFactory.createUnaryCallable(
            updateAuthProviderTransportSettings,
            settings.updateAuthProviderSettings(),
            clientContext);
    this.deleteAuthProviderCallable =
        callableFactory.createUnaryCallable(
            deleteAuthProviderTransportSettings,
            settings.deleteAuthProviderSettings(),
            clientContext);
    this.undeleteAuthProviderCallable =
        callableFactory.createUnaryCallable(
            undeleteAuthProviderTransportSettings,
            settings.undeleteAuthProviderSettings(),
            clientContext);
    this.queryAuthProvidersCallable =
        callableFactory.createUnaryCallable(
            queryAuthProvidersTransportSettings,
            settings.queryAuthProvidersSettings(),
            clientContext);
    this.queryAuthProvidersPagedCallable =
        callableFactory.createPagedCallable(
            queryAuthProvidersTransportSettings,
            settings.queryAuthProvidersSettings(),
            clientContext);
    this.queryWorkloadsCallable =
        callableFactory.createUnaryCallable(
            queryWorkloadsTransportSettings, settings.queryWorkloadsSettings(), clientContext);
    this.queryWorkloadsPagedCallable =
        callableFactory.createPagedCallable(
            queryWorkloadsTransportSettings, settings.queryWorkloadsSettings(), clientContext);
    this.listAuthorizationsCallable =
        callableFactory.createUnaryCallable(
            listAuthorizationsTransportSettings,
            settings.listAuthorizationsSettings(),
            clientContext);
    this.listAuthorizationsPagedCallable =
        callableFactory.createPagedCallable(
            listAuthorizationsTransportSettings,
            settings.listAuthorizationsSettings(),
            clientContext);
    this.getAuthorizationCallable =
        callableFactory.createUnaryCallable(
            getAuthorizationTransportSettings, settings.getAuthorizationSettings(), clientContext);
    this.deleteAuthorizationCallable =
        callableFactory.createUnaryCallable(
            deleteAuthorizationTransportSettings,
            settings.deleteAuthorizationSettings(),
            clientContext);
    this.listAccessSummariesCallable =
        callableFactory.createUnaryCallable(
            listAccessSummariesTransportSettings,
            settings.listAccessSummariesSettings(),
            clientContext);
    this.listAccessSummariesPagedCallable =
        callableFactory.createPagedCallable(
            listAccessSummariesTransportSettings,
            settings.listAccessSummariesSettings(),
            clientContext);
    this.getAccessSummaryCallable =
        callableFactory.createUnaryCallable(
            getAccessSummaryTransportSettings, settings.getAccessSummarySettings(), clientContext);
    this.revokeAuthorizationCallable =
        callableFactory.createUnaryCallable(
            revokeAuthorizationTransportSettings,
            settings.revokeAuthorizationSettings(),
            clientContext);
    this.enableAuthProviderCallable =
        callableFactory.createUnaryCallable(
            enableAuthProviderTransportSettings,
            settings.enableAuthProviderSettings(),
            clientContext);
    this.disableAuthProviderCallable =
        callableFactory.createUnaryCallable(
            disableAuthProviderTransportSettings,
            settings.disableAuthProviderSettings(),
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
  public UnaryCallable<ListAuthProvidersRequest, ListAuthProvidersResponse>
      listAuthProvidersCallable() {
    return listAuthProvidersCallable;
  }

  @Override
  public UnaryCallable<ListAuthProvidersRequest, ListAuthProvidersPagedResponse>
      listAuthProvidersPagedCallable() {
    return listAuthProvidersPagedCallable;
  }

  @Override
  public UnaryCallable<GetAuthProviderRequest, AuthProvider> getAuthProviderCallable() {
    return getAuthProviderCallable;
  }

  @Override
  public UnaryCallable<CreateAuthProviderRequest, AuthProvider> createAuthProviderCallable() {
    return createAuthProviderCallable;
  }

  @Override
  public UnaryCallable<UpdateAuthProviderRequest, AuthProvider> updateAuthProviderCallable() {
    return updateAuthProviderCallable;
  }

  @Override
  public UnaryCallable<DeleteAuthProviderRequest, Empty> deleteAuthProviderCallable() {
    return deleteAuthProviderCallable;
  }

  @Override
  public UnaryCallable<UndeleteAuthProviderRequest, AuthProvider> undeleteAuthProviderCallable() {
    return undeleteAuthProviderCallable;
  }

  @Override
  public UnaryCallable<QueryAuthProvidersRequest, QueryAuthProvidersResponse>
      queryAuthProvidersCallable() {
    return queryAuthProvidersCallable;
  }

  @Override
  public UnaryCallable<QueryAuthProvidersRequest, QueryAuthProvidersPagedResponse>
      queryAuthProvidersPagedCallable() {
    return queryAuthProvidersPagedCallable;
  }

  @Override
  public UnaryCallable<QueryWorkloadsRequest, QueryWorkloadsResponse> queryWorkloadsCallable() {
    return queryWorkloadsCallable;
  }

  @Override
  public UnaryCallable<QueryWorkloadsRequest, QueryWorkloadsPagedResponse>
      queryWorkloadsPagedCallable() {
    return queryWorkloadsPagedCallable;
  }

  @Override
  public UnaryCallable<ListAuthorizationsRequest, ListAuthorizationsResponse>
      listAuthorizationsCallable() {
    return listAuthorizationsCallable;
  }

  @Override
  public UnaryCallable<ListAuthorizationsRequest, ListAuthorizationsPagedResponse>
      listAuthorizationsPagedCallable() {
    return listAuthorizationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAuthorizationRequest, Authorization> getAuthorizationCallable() {
    return getAuthorizationCallable;
  }

  @Override
  public UnaryCallable<DeleteAuthorizationRequest, Empty> deleteAuthorizationCallable() {
    return deleteAuthorizationCallable;
  }

  @Override
  public UnaryCallable<ListAccessSummariesRequest, ListAccessSummariesResponse>
      listAccessSummariesCallable() {
    return listAccessSummariesCallable;
  }

  @Override
  public UnaryCallable<ListAccessSummariesRequest, ListAccessSummariesPagedResponse>
      listAccessSummariesPagedCallable() {
    return listAccessSummariesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAccessSummaryRequest, AccessSummary> getAccessSummaryCallable() {
    return getAccessSummaryCallable;
  }

  @Override
  public UnaryCallable<RevokeAuthorizationRequest, RevokeAuthorizationResponse>
      revokeAuthorizationCallable() {
    return revokeAuthorizationCallable;
  }

  @Override
  public UnaryCallable<EnableAuthProviderRequest, AuthProvider> enableAuthProviderCallable() {
    return enableAuthProviderCallable;
  }

  @Override
  public UnaryCallable<DisableAuthProviderRequest, AuthProvider> disableAuthProviderCallable() {
    return disableAuthProviderCallable;
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
