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

package com.google.cloud.privilegedaccessmanager.v1.stub;

import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListEntitlementsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListGrantsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.SearchEntitlementsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.SearchGrantsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.privilegedaccessmanager.v1.ApproveGrantRequest;
import com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusRequest;
import com.google.cloud.privilegedaccessmanager.v1.CheckOnboardingStatusResponse;
import com.google.cloud.privilegedaccessmanager.v1.CreateEntitlementRequest;
import com.google.cloud.privilegedaccessmanager.v1.CreateGrantRequest;
import com.google.cloud.privilegedaccessmanager.v1.DeleteEntitlementRequest;
import com.google.cloud.privilegedaccessmanager.v1.DenyGrantRequest;
import com.google.cloud.privilegedaccessmanager.v1.Entitlement;
import com.google.cloud.privilegedaccessmanager.v1.GetEntitlementRequest;
import com.google.cloud.privilegedaccessmanager.v1.GetGrantRequest;
import com.google.cloud.privilegedaccessmanager.v1.Grant;
import com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsRequest;
import com.google.cloud.privilegedaccessmanager.v1.ListEntitlementsResponse;
import com.google.cloud.privilegedaccessmanager.v1.ListGrantsRequest;
import com.google.cloud.privilegedaccessmanager.v1.ListGrantsResponse;
import com.google.cloud.privilegedaccessmanager.v1.OperationMetadata;
import com.google.cloud.privilegedaccessmanager.v1.RevokeGrantRequest;
import com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsRequest;
import com.google.cloud.privilegedaccessmanager.v1.SearchEntitlementsResponse;
import com.google.cloud.privilegedaccessmanager.v1.SearchGrantsRequest;
import com.google.cloud.privilegedaccessmanager.v1.SearchGrantsResponse;
import com.google.cloud.privilegedaccessmanager.v1.UpdateEntitlementRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the PrivilegedAccessManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcPrivilegedAccessManagerStub extends PrivilegedAccessManagerStub {
  private static final MethodDescriptor<CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>
      checkOnboardingStatusMethodDescriptor =
          MethodDescriptor.<CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/CheckOnboardingStatus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CheckOnboardingStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CheckOnboardingStatusResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsMethodDescriptor =
          MethodDescriptor.<ListEntitlementsRequest, ListEntitlementsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/ListEntitlements")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEntitlementsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEntitlementsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchEntitlementsRequest, SearchEntitlementsResponse>
      searchEntitlementsMethodDescriptor =
          MethodDescriptor.<SearchEntitlementsRequest, SearchEntitlementsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/SearchEntitlements")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchEntitlementsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchEntitlementsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEntitlementRequest, Entitlement>
      getEntitlementMethodDescriptor =
          MethodDescriptor.<GetEntitlementRequest, Entitlement>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/GetEntitlement")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEntitlementRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Entitlement.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateEntitlementRequest, Operation>
      createEntitlementMethodDescriptor =
          MethodDescriptor.<CreateEntitlementRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/CreateEntitlement")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEntitlementRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEntitlementRequest, Operation>
      deleteEntitlementMethodDescriptor =
          MethodDescriptor.<DeleteEntitlementRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/DeleteEntitlement")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEntitlementRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateEntitlementRequest, Operation>
      updateEntitlementMethodDescriptor =
          MethodDescriptor.<UpdateEntitlementRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/UpdateEntitlement")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEntitlementRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListGrantsRequest, ListGrantsResponse>
      listGrantsMethodDescriptor =
          MethodDescriptor.<ListGrantsRequest, ListGrantsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/ListGrants")
              .setRequestMarshaller(ProtoUtils.marshaller(ListGrantsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListGrantsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchGrantsRequest, SearchGrantsResponse>
      searchGrantsMethodDescriptor =
          MethodDescriptor.<SearchGrantsRequest, SearchGrantsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/SearchGrants")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchGrantsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchGrantsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGrantRequest, Grant> getGrantMethodDescriptor =
      MethodDescriptor.<GetGrantRequest, Grant>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/GetGrant")
          .setRequestMarshaller(ProtoUtils.marshaller(GetGrantRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Grant.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateGrantRequest, Grant> createGrantMethodDescriptor =
      MethodDescriptor.<CreateGrantRequest, Grant>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/CreateGrant")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateGrantRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Grant.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ApproveGrantRequest, Grant> approveGrantMethodDescriptor =
      MethodDescriptor.<ApproveGrantRequest, Grant>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/ApproveGrant")
          .setRequestMarshaller(ProtoUtils.marshaller(ApproveGrantRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Grant.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DenyGrantRequest, Grant> denyGrantMethodDescriptor =
      MethodDescriptor.<DenyGrantRequest, Grant>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/DenyGrant")
          .setRequestMarshaller(ProtoUtils.marshaller(DenyGrantRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Grant.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<RevokeGrantRequest, Operation> revokeGrantMethodDescriptor =
      MethodDescriptor.<RevokeGrantRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/RevokeGrant")
          .setRequestMarshaller(ProtoUtils.marshaller(RevokeGrantRequest.getDefaultInstance()))
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

  private final UnaryCallable<CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>
      checkOnboardingStatusCallable;
  private final UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsCallable;
  private final UnaryCallable<ListEntitlementsRequest, ListEntitlementsPagedResponse>
      listEntitlementsPagedCallable;
  private final UnaryCallable<SearchEntitlementsRequest, SearchEntitlementsResponse>
      searchEntitlementsCallable;
  private final UnaryCallable<SearchEntitlementsRequest, SearchEntitlementsPagedResponse>
      searchEntitlementsPagedCallable;
  private final UnaryCallable<GetEntitlementRequest, Entitlement> getEntitlementCallable;
  private final UnaryCallable<CreateEntitlementRequest, Operation> createEntitlementCallable;
  private final OperationCallable<CreateEntitlementRequest, Entitlement, OperationMetadata>
      createEntitlementOperationCallable;
  private final UnaryCallable<DeleteEntitlementRequest, Operation> deleteEntitlementCallable;
  private final OperationCallable<DeleteEntitlementRequest, Entitlement, OperationMetadata>
      deleteEntitlementOperationCallable;
  private final UnaryCallable<UpdateEntitlementRequest, Operation> updateEntitlementCallable;
  private final OperationCallable<UpdateEntitlementRequest, Entitlement, OperationMetadata>
      updateEntitlementOperationCallable;
  private final UnaryCallable<ListGrantsRequest, ListGrantsResponse> listGrantsCallable;
  private final UnaryCallable<ListGrantsRequest, ListGrantsPagedResponse> listGrantsPagedCallable;
  private final UnaryCallable<SearchGrantsRequest, SearchGrantsResponse> searchGrantsCallable;
  private final UnaryCallable<SearchGrantsRequest, SearchGrantsPagedResponse>
      searchGrantsPagedCallable;
  private final UnaryCallable<GetGrantRequest, Grant> getGrantCallable;
  private final UnaryCallable<CreateGrantRequest, Grant> createGrantCallable;
  private final UnaryCallable<ApproveGrantRequest, Grant> approveGrantCallable;
  private final UnaryCallable<DenyGrantRequest, Grant> denyGrantCallable;
  private final UnaryCallable<RevokeGrantRequest, Operation> revokeGrantCallable;
  private final OperationCallable<RevokeGrantRequest, Grant, OperationMetadata>
      revokeGrantOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPrivilegedAccessManagerStub create(
      PrivilegedAccessManagerStubSettings settings) throws IOException {
    return new GrpcPrivilegedAccessManagerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPrivilegedAccessManagerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcPrivilegedAccessManagerStub(
        PrivilegedAccessManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPrivilegedAccessManagerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPrivilegedAccessManagerStub(
        PrivilegedAccessManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPrivilegedAccessManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPrivilegedAccessManagerStub(
      PrivilegedAccessManagerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPrivilegedAccessManagerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPrivilegedAccessManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPrivilegedAccessManagerStub(
      PrivilegedAccessManagerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>
        checkOnboardingStatusTransportSettings =
            GrpcCallSettings
                .<CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>newBuilder()
                .setMethodDescriptor(checkOnboardingStatusMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListEntitlementsRequest, ListEntitlementsResponse>
        listEntitlementsTransportSettings =
            GrpcCallSettings.<ListEntitlementsRequest, ListEntitlementsResponse>newBuilder()
                .setMethodDescriptor(listEntitlementsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchEntitlementsRequest, SearchEntitlementsResponse>
        searchEntitlementsTransportSettings =
            GrpcCallSettings.<SearchEntitlementsRequest, SearchEntitlementsResponse>newBuilder()
                .setMethodDescriptor(searchEntitlementsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetEntitlementRequest, Entitlement> getEntitlementTransportSettings =
        GrpcCallSettings.<GetEntitlementRequest, Entitlement>newBuilder()
            .setMethodDescriptor(getEntitlementMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateEntitlementRequest, Operation> createEntitlementTransportSettings =
        GrpcCallSettings.<CreateEntitlementRequest, Operation>newBuilder()
            .setMethodDescriptor(createEntitlementMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteEntitlementRequest, Operation> deleteEntitlementTransportSettings =
        GrpcCallSettings.<DeleteEntitlementRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEntitlementMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateEntitlementRequest, Operation> updateEntitlementTransportSettings =
        GrpcCallSettings.<UpdateEntitlementRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEntitlementMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "entitlement.name", String.valueOf(request.getEntitlement().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListGrantsRequest, ListGrantsResponse> listGrantsTransportSettings =
        GrpcCallSettings.<ListGrantsRequest, ListGrantsResponse>newBuilder()
            .setMethodDescriptor(listGrantsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SearchGrantsRequest, SearchGrantsResponse> searchGrantsTransportSettings =
        GrpcCallSettings.<SearchGrantsRequest, SearchGrantsResponse>newBuilder()
            .setMethodDescriptor(searchGrantsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetGrantRequest, Grant> getGrantTransportSettings =
        GrpcCallSettings.<GetGrantRequest, Grant>newBuilder()
            .setMethodDescriptor(getGrantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateGrantRequest, Grant> createGrantTransportSettings =
        GrpcCallSettings.<CreateGrantRequest, Grant>newBuilder()
            .setMethodDescriptor(createGrantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ApproveGrantRequest, Grant> approveGrantTransportSettings =
        GrpcCallSettings.<ApproveGrantRequest, Grant>newBuilder()
            .setMethodDescriptor(approveGrantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DenyGrantRequest, Grant> denyGrantTransportSettings =
        GrpcCallSettings.<DenyGrantRequest, Grant>newBuilder()
            .setMethodDescriptor(denyGrantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RevokeGrantRequest, Operation> revokeGrantTransportSettings =
        GrpcCallSettings.<RevokeGrantRequest, Operation>newBuilder()
            .setMethodDescriptor(revokeGrantMethodDescriptor)
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

    this.checkOnboardingStatusCallable =
        callableFactory.createUnaryCallable(
            checkOnboardingStatusTransportSettings,
            settings.checkOnboardingStatusSettings(),
            clientContext);
    this.listEntitlementsCallable =
        callableFactory.createUnaryCallable(
            listEntitlementsTransportSettings, settings.listEntitlementsSettings(), clientContext);
    this.listEntitlementsPagedCallable =
        callableFactory.createPagedCallable(
            listEntitlementsTransportSettings, settings.listEntitlementsSettings(), clientContext);
    this.searchEntitlementsCallable =
        callableFactory.createUnaryCallable(
            searchEntitlementsTransportSettings,
            settings.searchEntitlementsSettings(),
            clientContext);
    this.searchEntitlementsPagedCallable =
        callableFactory.createPagedCallable(
            searchEntitlementsTransportSettings,
            settings.searchEntitlementsSettings(),
            clientContext);
    this.getEntitlementCallable =
        callableFactory.createUnaryCallable(
            getEntitlementTransportSettings, settings.getEntitlementSettings(), clientContext);
    this.createEntitlementCallable =
        callableFactory.createUnaryCallable(
            createEntitlementTransportSettings,
            settings.createEntitlementSettings(),
            clientContext);
    this.createEntitlementOperationCallable =
        callableFactory.createOperationCallable(
            createEntitlementTransportSettings,
            settings.createEntitlementOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteEntitlementCallable =
        callableFactory.createUnaryCallable(
            deleteEntitlementTransportSettings,
            settings.deleteEntitlementSettings(),
            clientContext);
    this.deleteEntitlementOperationCallable =
        callableFactory.createOperationCallable(
            deleteEntitlementTransportSettings,
            settings.deleteEntitlementOperationSettings(),
            clientContext,
            operationsStub);
    this.updateEntitlementCallable =
        callableFactory.createUnaryCallable(
            updateEntitlementTransportSettings,
            settings.updateEntitlementSettings(),
            clientContext);
    this.updateEntitlementOperationCallable =
        callableFactory.createOperationCallable(
            updateEntitlementTransportSettings,
            settings.updateEntitlementOperationSettings(),
            clientContext,
            operationsStub);
    this.listGrantsCallable =
        callableFactory.createUnaryCallable(
            listGrantsTransportSettings, settings.listGrantsSettings(), clientContext);
    this.listGrantsPagedCallable =
        callableFactory.createPagedCallable(
            listGrantsTransportSettings, settings.listGrantsSettings(), clientContext);
    this.searchGrantsCallable =
        callableFactory.createUnaryCallable(
            searchGrantsTransportSettings, settings.searchGrantsSettings(), clientContext);
    this.searchGrantsPagedCallable =
        callableFactory.createPagedCallable(
            searchGrantsTransportSettings, settings.searchGrantsSettings(), clientContext);
    this.getGrantCallable =
        callableFactory.createUnaryCallable(
            getGrantTransportSettings, settings.getGrantSettings(), clientContext);
    this.createGrantCallable =
        callableFactory.createUnaryCallable(
            createGrantTransportSettings, settings.createGrantSettings(), clientContext);
    this.approveGrantCallable =
        callableFactory.createUnaryCallable(
            approveGrantTransportSettings, settings.approveGrantSettings(), clientContext);
    this.denyGrantCallable =
        callableFactory.createUnaryCallable(
            denyGrantTransportSettings, settings.denyGrantSettings(), clientContext);
    this.revokeGrantCallable =
        callableFactory.createUnaryCallable(
            revokeGrantTransportSettings, settings.revokeGrantSettings(), clientContext);
    this.revokeGrantOperationCallable =
        callableFactory.createOperationCallable(
            revokeGrantTransportSettings,
            settings.revokeGrantOperationSettings(),
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>
      checkOnboardingStatusCallable() {
    return checkOnboardingStatusCallable;
  }

  @Override
  public UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsCallable() {
    return listEntitlementsCallable;
  }

  @Override
  public UnaryCallable<ListEntitlementsRequest, ListEntitlementsPagedResponse>
      listEntitlementsPagedCallable() {
    return listEntitlementsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchEntitlementsRequest, SearchEntitlementsResponse>
      searchEntitlementsCallable() {
    return searchEntitlementsCallable;
  }

  @Override
  public UnaryCallable<SearchEntitlementsRequest, SearchEntitlementsPagedResponse>
      searchEntitlementsPagedCallable() {
    return searchEntitlementsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEntitlementRequest, Entitlement> getEntitlementCallable() {
    return getEntitlementCallable;
  }

  @Override
  public UnaryCallable<CreateEntitlementRequest, Operation> createEntitlementCallable() {
    return createEntitlementCallable;
  }

  @Override
  public OperationCallable<CreateEntitlementRequest, Entitlement, OperationMetadata>
      createEntitlementOperationCallable() {
    return createEntitlementOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEntitlementRequest, Operation> deleteEntitlementCallable() {
    return deleteEntitlementCallable;
  }

  @Override
  public OperationCallable<DeleteEntitlementRequest, Entitlement, OperationMetadata>
      deleteEntitlementOperationCallable() {
    return deleteEntitlementOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEntitlementRequest, Operation> updateEntitlementCallable() {
    return updateEntitlementCallable;
  }

  @Override
  public OperationCallable<UpdateEntitlementRequest, Entitlement, OperationMetadata>
      updateEntitlementOperationCallable() {
    return updateEntitlementOperationCallable;
  }

  @Override
  public UnaryCallable<ListGrantsRequest, ListGrantsResponse> listGrantsCallable() {
    return listGrantsCallable;
  }

  @Override
  public UnaryCallable<ListGrantsRequest, ListGrantsPagedResponse> listGrantsPagedCallable() {
    return listGrantsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchGrantsRequest, SearchGrantsResponse> searchGrantsCallable() {
    return searchGrantsCallable;
  }

  @Override
  public UnaryCallable<SearchGrantsRequest, SearchGrantsPagedResponse> searchGrantsPagedCallable() {
    return searchGrantsPagedCallable;
  }

  @Override
  public UnaryCallable<GetGrantRequest, Grant> getGrantCallable() {
    return getGrantCallable;
  }

  @Override
  public UnaryCallable<CreateGrantRequest, Grant> createGrantCallable() {
    return createGrantCallable;
  }

  @Override
  public UnaryCallable<ApproveGrantRequest, Grant> approveGrantCallable() {
    return approveGrantCallable;
  }

  @Override
  public UnaryCallable<DenyGrantRequest, Grant> denyGrantCallable() {
    return denyGrantCallable;
  }

  @Override
  public UnaryCallable<RevokeGrantRequest, Operation> revokeGrantCallable() {
    return revokeGrantCallable;
  }

  @Override
  public OperationCallable<RevokeGrantRequest, Grant, OperationMetadata>
      revokeGrantOperationCallable() {
    return revokeGrantOperationCallable;
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
