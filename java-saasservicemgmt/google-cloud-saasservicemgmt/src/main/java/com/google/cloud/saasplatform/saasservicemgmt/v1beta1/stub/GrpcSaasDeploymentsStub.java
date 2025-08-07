/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1.stub;

import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListLocationsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListReleasesPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListSaasPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListTenantsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListUnitKindsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListUnitOperationsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListUnitsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateReleaseRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateSaasRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateTenantRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitOperationRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateUnitRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteReleaseRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteSaasRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteTenantRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitOperationRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteUnitRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetReleaseRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetSaasRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetTenantRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitOperationRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetUnitRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListReleasesResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListSaasResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListTenantsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitKindsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitOperationsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListUnitsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Release;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Saas;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Tenant;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Unit;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitKind;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UnitOperation;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateReleaseRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateSaasRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateTenantRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitOperationRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateUnitRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SaasDeployments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSaasDeploymentsStub extends SaasDeploymentsStub {
  private static final MethodDescriptor<ListSaasRequest, ListSaasResponse>
      listSaasMethodDescriptor =
          MethodDescriptor.<ListSaasRequest, ListSaasResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/ListSaas")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSaasRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSaasResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSaasRequest, Saas> getSaasMethodDescriptor =
      MethodDescriptor.<GetSaasRequest, Saas>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/GetSaas")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSaasRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Saas.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateSaasRequest, Saas> createSaasMethodDescriptor =
      MethodDescriptor.<CreateSaasRequest, Saas>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/CreateSaas")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSaasRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Saas.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSaasRequest, Saas> updateSaasMethodDescriptor =
      MethodDescriptor.<UpdateSaasRequest, Saas>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/UpdateSaas")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSaasRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Saas.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteSaasRequest, Empty> deleteSaasMethodDescriptor =
      MethodDescriptor.<DeleteSaasRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/DeleteSaas")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSaasRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListTenantsRequest, ListTenantsResponse>
      listTenantsMethodDescriptor =
          MethodDescriptor.<ListTenantsRequest, ListTenantsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/ListTenants")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTenantsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTenantsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTenantRequest, Tenant> getTenantMethodDescriptor =
      MethodDescriptor.<GetTenantRequest, Tenant>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/GetTenant")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTenantRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tenant.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateTenantRequest, Tenant> createTenantMethodDescriptor =
      MethodDescriptor.<CreateTenantRequest, Tenant>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/CreateTenant")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateTenantRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tenant.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateTenantRequest, Tenant> updateTenantMethodDescriptor =
      MethodDescriptor.<UpdateTenantRequest, Tenant>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/UpdateTenant")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateTenantRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tenant.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteTenantRequest, Empty> deleteTenantMethodDescriptor =
      MethodDescriptor.<DeleteTenantRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/DeleteTenant")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteTenantRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListUnitKindsRequest, ListUnitKindsResponse>
      listUnitKindsMethodDescriptor =
          MethodDescriptor.<ListUnitKindsRequest, ListUnitKindsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/ListUnitKinds")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUnitKindsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUnitKindsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetUnitKindRequest, UnitKind> getUnitKindMethodDescriptor =
      MethodDescriptor.<GetUnitKindRequest, UnitKind>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/GetUnitKind")
          .setRequestMarshaller(ProtoUtils.marshaller(GetUnitKindRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(UnitKind.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateUnitKindRequest, UnitKind>
      createUnitKindMethodDescriptor =
          MethodDescriptor.<CreateUnitKindRequest, UnitKind>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/CreateUnitKind")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateUnitKindRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UnitKind.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateUnitKindRequest, UnitKind>
      updateUnitKindMethodDescriptor =
          MethodDescriptor.<UpdateUnitKindRequest, UnitKind>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/UpdateUnitKind")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateUnitKindRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UnitKind.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteUnitKindRequest, Empty>
      deleteUnitKindMethodDescriptor =
          MethodDescriptor.<DeleteUnitKindRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/DeleteUnitKind")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteUnitKindRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListUnitsRequest, ListUnitsResponse>
      listUnitsMethodDescriptor =
          MethodDescriptor.<ListUnitsRequest, ListUnitsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/ListUnits")
              .setRequestMarshaller(ProtoUtils.marshaller(ListUnitsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListUnitsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetUnitRequest, Unit> getUnitMethodDescriptor =
      MethodDescriptor.<GetUnitRequest, Unit>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/GetUnit")
          .setRequestMarshaller(ProtoUtils.marshaller(GetUnitRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Unit.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateUnitRequest, Unit> createUnitMethodDescriptor =
      MethodDescriptor.<CreateUnitRequest, Unit>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/CreateUnit")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateUnitRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Unit.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateUnitRequest, Unit> updateUnitMethodDescriptor =
      MethodDescriptor.<UpdateUnitRequest, Unit>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/UpdateUnit")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateUnitRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Unit.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteUnitRequest, Empty> deleteUnitMethodDescriptor =
      MethodDescriptor.<DeleteUnitRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/DeleteUnit")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteUnitRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListUnitOperationsRequest, ListUnitOperationsResponse>
      listUnitOperationsMethodDescriptor =
          MethodDescriptor.<ListUnitOperationsRequest, ListUnitOperationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/ListUnitOperations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUnitOperationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUnitOperationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetUnitOperationRequest, UnitOperation>
      getUnitOperationMethodDescriptor =
          MethodDescriptor.<GetUnitOperationRequest, UnitOperation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/GetUnitOperation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetUnitOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UnitOperation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateUnitOperationRequest, UnitOperation>
      createUnitOperationMethodDescriptor =
          MethodDescriptor.<CreateUnitOperationRequest, UnitOperation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/CreateUnitOperation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateUnitOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UnitOperation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateUnitOperationRequest, UnitOperation>
      updateUnitOperationMethodDescriptor =
          MethodDescriptor.<UpdateUnitOperationRequest, UnitOperation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/UpdateUnitOperation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateUnitOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UnitOperation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteUnitOperationRequest, Empty>
      deleteUnitOperationMethodDescriptor =
          MethodDescriptor.<DeleteUnitOperationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/DeleteUnitOperation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteUnitOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListReleasesRequest, ListReleasesResponse>
      listReleasesMethodDescriptor =
          MethodDescriptor.<ListReleasesRequest, ListReleasesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/ListReleases")
              .setRequestMarshaller(ProtoUtils.marshaller(ListReleasesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReleasesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetReleaseRequest, Release> getReleaseMethodDescriptor =
      MethodDescriptor.<GetReleaseRequest, Release>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/GetRelease")
          .setRequestMarshaller(ProtoUtils.marshaller(GetReleaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Release.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateReleaseRequest, Release>
      createReleaseMethodDescriptor =
          MethodDescriptor.<CreateReleaseRequest, Release>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/CreateRelease")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateReleaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Release.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateReleaseRequest, Release>
      updateReleaseMethodDescriptor =
          MethodDescriptor.<UpdateReleaseRequest, Release>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/UpdateRelease")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateReleaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Release.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteReleaseRequest, Empty> deleteReleaseMethodDescriptor =
      MethodDescriptor.<DeleteReleaseRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/DeleteRelease")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteReleaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
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

  private final UnaryCallable<ListSaasRequest, ListSaasResponse> listSaasCallable;
  private final UnaryCallable<ListSaasRequest, ListSaasPagedResponse> listSaasPagedCallable;
  private final UnaryCallable<GetSaasRequest, Saas> getSaasCallable;
  private final UnaryCallable<CreateSaasRequest, Saas> createSaasCallable;
  private final UnaryCallable<UpdateSaasRequest, Saas> updateSaasCallable;
  private final UnaryCallable<DeleteSaasRequest, Empty> deleteSaasCallable;
  private final UnaryCallable<ListTenantsRequest, ListTenantsResponse> listTenantsCallable;
  private final UnaryCallable<ListTenantsRequest, ListTenantsPagedResponse>
      listTenantsPagedCallable;
  private final UnaryCallable<GetTenantRequest, Tenant> getTenantCallable;
  private final UnaryCallable<CreateTenantRequest, Tenant> createTenantCallable;
  private final UnaryCallable<UpdateTenantRequest, Tenant> updateTenantCallable;
  private final UnaryCallable<DeleteTenantRequest, Empty> deleteTenantCallable;
  private final UnaryCallable<ListUnitKindsRequest, ListUnitKindsResponse> listUnitKindsCallable;
  private final UnaryCallable<ListUnitKindsRequest, ListUnitKindsPagedResponse>
      listUnitKindsPagedCallable;
  private final UnaryCallable<GetUnitKindRequest, UnitKind> getUnitKindCallable;
  private final UnaryCallable<CreateUnitKindRequest, UnitKind> createUnitKindCallable;
  private final UnaryCallable<UpdateUnitKindRequest, UnitKind> updateUnitKindCallable;
  private final UnaryCallable<DeleteUnitKindRequest, Empty> deleteUnitKindCallable;
  private final UnaryCallable<ListUnitsRequest, ListUnitsResponse> listUnitsCallable;
  private final UnaryCallable<ListUnitsRequest, ListUnitsPagedResponse> listUnitsPagedCallable;
  private final UnaryCallable<GetUnitRequest, Unit> getUnitCallable;
  private final UnaryCallable<CreateUnitRequest, Unit> createUnitCallable;
  private final UnaryCallable<UpdateUnitRequest, Unit> updateUnitCallable;
  private final UnaryCallable<DeleteUnitRequest, Empty> deleteUnitCallable;
  private final UnaryCallable<ListUnitOperationsRequest, ListUnitOperationsResponse>
      listUnitOperationsCallable;
  private final UnaryCallable<ListUnitOperationsRequest, ListUnitOperationsPagedResponse>
      listUnitOperationsPagedCallable;
  private final UnaryCallable<GetUnitOperationRequest, UnitOperation> getUnitOperationCallable;
  private final UnaryCallable<CreateUnitOperationRequest, UnitOperation>
      createUnitOperationCallable;
  private final UnaryCallable<UpdateUnitOperationRequest, UnitOperation>
      updateUnitOperationCallable;
  private final UnaryCallable<DeleteUnitOperationRequest, Empty> deleteUnitOperationCallable;
  private final UnaryCallable<ListReleasesRequest, ListReleasesResponse> listReleasesCallable;
  private final UnaryCallable<ListReleasesRequest, ListReleasesPagedResponse>
      listReleasesPagedCallable;
  private final UnaryCallable<GetReleaseRequest, Release> getReleaseCallable;
  private final UnaryCallable<CreateReleaseRequest, Release> createReleaseCallable;
  private final UnaryCallable<UpdateReleaseRequest, Release> updateReleaseCallable;
  private final UnaryCallable<DeleteReleaseRequest, Empty> deleteReleaseCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSaasDeploymentsStub create(SaasDeploymentsStubSettings settings)
      throws IOException {
    return new GrpcSaasDeploymentsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSaasDeploymentsStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSaasDeploymentsStub(
        SaasDeploymentsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSaasDeploymentsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSaasDeploymentsStub(
        SaasDeploymentsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSaasDeploymentsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSaasDeploymentsStub(
      SaasDeploymentsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSaasDeploymentsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSaasDeploymentsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSaasDeploymentsStub(
      SaasDeploymentsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListSaasRequest, ListSaasResponse> listSaasTransportSettings =
        GrpcCallSettings.<ListSaasRequest, ListSaasResponse>newBuilder()
            .setMethodDescriptor(listSaasMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSaasRequest, Saas> getSaasTransportSettings =
        GrpcCallSettings.<GetSaasRequest, Saas>newBuilder()
            .setMethodDescriptor(getSaasMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSaasRequest, Saas> createSaasTransportSettings =
        GrpcCallSettings.<CreateSaasRequest, Saas>newBuilder()
            .setMethodDescriptor(createSaasMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSaasRequest, Saas> updateSaasTransportSettings =
        GrpcCallSettings.<UpdateSaasRequest, Saas>newBuilder()
            .setMethodDescriptor(updateSaasMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("saas.name", String.valueOf(request.getSaas().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSaasRequest, Empty> deleteSaasTransportSettings =
        GrpcCallSettings.<DeleteSaasRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSaasMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListTenantsRequest, ListTenantsResponse> listTenantsTransportSettings =
        GrpcCallSettings.<ListTenantsRequest, ListTenantsResponse>newBuilder()
            .setMethodDescriptor(listTenantsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetTenantRequest, Tenant> getTenantTransportSettings =
        GrpcCallSettings.<GetTenantRequest, Tenant>newBuilder()
            .setMethodDescriptor(getTenantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateTenantRequest, Tenant> createTenantTransportSettings =
        GrpcCallSettings.<CreateTenantRequest, Tenant>newBuilder()
            .setMethodDescriptor(createTenantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateTenantRequest, Tenant> updateTenantTransportSettings =
        GrpcCallSettings.<UpdateTenantRequest, Tenant>newBuilder()
            .setMethodDescriptor(updateTenantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("tenant.name", String.valueOf(request.getTenant().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteTenantRequest, Empty> deleteTenantTransportSettings =
        GrpcCallSettings.<DeleteTenantRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTenantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListUnitKindsRequest, ListUnitKindsResponse> listUnitKindsTransportSettings =
        GrpcCallSettings.<ListUnitKindsRequest, ListUnitKindsResponse>newBuilder()
            .setMethodDescriptor(listUnitKindsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetUnitKindRequest, UnitKind> getUnitKindTransportSettings =
        GrpcCallSettings.<GetUnitKindRequest, UnitKind>newBuilder()
            .setMethodDescriptor(getUnitKindMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateUnitKindRequest, UnitKind> createUnitKindTransportSettings =
        GrpcCallSettings.<CreateUnitKindRequest, UnitKind>newBuilder()
            .setMethodDescriptor(createUnitKindMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateUnitKindRequest, UnitKind> updateUnitKindTransportSettings =
        GrpcCallSettings.<UpdateUnitKindRequest, UnitKind>newBuilder()
            .setMethodDescriptor(updateUnitKindMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("unit_kind.name", String.valueOf(request.getUnitKind().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteUnitKindRequest, Empty> deleteUnitKindTransportSettings =
        GrpcCallSettings.<DeleteUnitKindRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUnitKindMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListUnitsRequest, ListUnitsResponse> listUnitsTransportSettings =
        GrpcCallSettings.<ListUnitsRequest, ListUnitsResponse>newBuilder()
            .setMethodDescriptor(listUnitsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetUnitRequest, Unit> getUnitTransportSettings =
        GrpcCallSettings.<GetUnitRequest, Unit>newBuilder()
            .setMethodDescriptor(getUnitMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateUnitRequest, Unit> createUnitTransportSettings =
        GrpcCallSettings.<CreateUnitRequest, Unit>newBuilder()
            .setMethodDescriptor(createUnitMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateUnitRequest, Unit> updateUnitTransportSettings =
        GrpcCallSettings.<UpdateUnitRequest, Unit>newBuilder()
            .setMethodDescriptor(updateUnitMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("unit.name", String.valueOf(request.getUnit().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteUnitRequest, Empty> deleteUnitTransportSettings =
        GrpcCallSettings.<DeleteUnitRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUnitMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListUnitOperationsRequest, ListUnitOperationsResponse>
        listUnitOperationsTransportSettings =
            GrpcCallSettings.<ListUnitOperationsRequest, ListUnitOperationsResponse>newBuilder()
                .setMethodDescriptor(listUnitOperationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetUnitOperationRequest, UnitOperation> getUnitOperationTransportSettings =
        GrpcCallSettings.<GetUnitOperationRequest, UnitOperation>newBuilder()
            .setMethodDescriptor(getUnitOperationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateUnitOperationRequest, UnitOperation>
        createUnitOperationTransportSettings =
            GrpcCallSettings.<CreateUnitOperationRequest, UnitOperation>newBuilder()
                .setMethodDescriptor(createUnitOperationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateUnitOperationRequest, UnitOperation>
        updateUnitOperationTransportSettings =
            GrpcCallSettings.<UpdateUnitOperationRequest, UnitOperation>newBuilder()
                .setMethodDescriptor(updateUnitOperationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "unit_operation.name",
                          String.valueOf(request.getUnitOperation().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteUnitOperationRequest, Empty> deleteUnitOperationTransportSettings =
        GrpcCallSettings.<DeleteUnitOperationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUnitOperationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListReleasesRequest, ListReleasesResponse> listReleasesTransportSettings =
        GrpcCallSettings.<ListReleasesRequest, ListReleasesResponse>newBuilder()
            .setMethodDescriptor(listReleasesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetReleaseRequest, Release> getReleaseTransportSettings =
        GrpcCallSettings.<GetReleaseRequest, Release>newBuilder()
            .setMethodDescriptor(getReleaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateReleaseRequest, Release> createReleaseTransportSettings =
        GrpcCallSettings.<CreateReleaseRequest, Release>newBuilder()
            .setMethodDescriptor(createReleaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateReleaseRequest, Release> updateReleaseTransportSettings =
        GrpcCallSettings.<UpdateReleaseRequest, Release>newBuilder()
            .setMethodDescriptor(updateReleaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("release.name", String.valueOf(request.getRelease().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteReleaseRequest, Empty> deleteReleaseTransportSettings =
        GrpcCallSettings.<DeleteReleaseRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteReleaseMethodDescriptor)
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

    this.listSaasCallable =
        callableFactory.createUnaryCallable(
            listSaasTransportSettings, settings.listSaasSettings(), clientContext);
    this.listSaasPagedCallable =
        callableFactory.createPagedCallable(
            listSaasTransportSettings, settings.listSaasSettings(), clientContext);
    this.getSaasCallable =
        callableFactory.createUnaryCallable(
            getSaasTransportSettings, settings.getSaasSettings(), clientContext);
    this.createSaasCallable =
        callableFactory.createUnaryCallable(
            createSaasTransportSettings, settings.createSaasSettings(), clientContext);
    this.updateSaasCallable =
        callableFactory.createUnaryCallable(
            updateSaasTransportSettings, settings.updateSaasSettings(), clientContext);
    this.deleteSaasCallable =
        callableFactory.createUnaryCallable(
            deleteSaasTransportSettings, settings.deleteSaasSettings(), clientContext);
    this.listTenantsCallable =
        callableFactory.createUnaryCallable(
            listTenantsTransportSettings, settings.listTenantsSettings(), clientContext);
    this.listTenantsPagedCallable =
        callableFactory.createPagedCallable(
            listTenantsTransportSettings, settings.listTenantsSettings(), clientContext);
    this.getTenantCallable =
        callableFactory.createUnaryCallable(
            getTenantTransportSettings, settings.getTenantSettings(), clientContext);
    this.createTenantCallable =
        callableFactory.createUnaryCallable(
            createTenantTransportSettings, settings.createTenantSettings(), clientContext);
    this.updateTenantCallable =
        callableFactory.createUnaryCallable(
            updateTenantTransportSettings, settings.updateTenantSettings(), clientContext);
    this.deleteTenantCallable =
        callableFactory.createUnaryCallable(
            deleteTenantTransportSettings, settings.deleteTenantSettings(), clientContext);
    this.listUnitKindsCallable =
        callableFactory.createUnaryCallable(
            listUnitKindsTransportSettings, settings.listUnitKindsSettings(), clientContext);
    this.listUnitKindsPagedCallable =
        callableFactory.createPagedCallable(
            listUnitKindsTransportSettings, settings.listUnitKindsSettings(), clientContext);
    this.getUnitKindCallable =
        callableFactory.createUnaryCallable(
            getUnitKindTransportSettings, settings.getUnitKindSettings(), clientContext);
    this.createUnitKindCallable =
        callableFactory.createUnaryCallable(
            createUnitKindTransportSettings, settings.createUnitKindSettings(), clientContext);
    this.updateUnitKindCallable =
        callableFactory.createUnaryCallable(
            updateUnitKindTransportSettings, settings.updateUnitKindSettings(), clientContext);
    this.deleteUnitKindCallable =
        callableFactory.createUnaryCallable(
            deleteUnitKindTransportSettings, settings.deleteUnitKindSettings(), clientContext);
    this.listUnitsCallable =
        callableFactory.createUnaryCallable(
            listUnitsTransportSettings, settings.listUnitsSettings(), clientContext);
    this.listUnitsPagedCallable =
        callableFactory.createPagedCallable(
            listUnitsTransportSettings, settings.listUnitsSettings(), clientContext);
    this.getUnitCallable =
        callableFactory.createUnaryCallable(
            getUnitTransportSettings, settings.getUnitSettings(), clientContext);
    this.createUnitCallable =
        callableFactory.createUnaryCallable(
            createUnitTransportSettings, settings.createUnitSettings(), clientContext);
    this.updateUnitCallable =
        callableFactory.createUnaryCallable(
            updateUnitTransportSettings, settings.updateUnitSettings(), clientContext);
    this.deleteUnitCallable =
        callableFactory.createUnaryCallable(
            deleteUnitTransportSettings, settings.deleteUnitSettings(), clientContext);
    this.listUnitOperationsCallable =
        callableFactory.createUnaryCallable(
            listUnitOperationsTransportSettings,
            settings.listUnitOperationsSettings(),
            clientContext);
    this.listUnitOperationsPagedCallable =
        callableFactory.createPagedCallable(
            listUnitOperationsTransportSettings,
            settings.listUnitOperationsSettings(),
            clientContext);
    this.getUnitOperationCallable =
        callableFactory.createUnaryCallable(
            getUnitOperationTransportSettings, settings.getUnitOperationSettings(), clientContext);
    this.createUnitOperationCallable =
        callableFactory.createUnaryCallable(
            createUnitOperationTransportSettings,
            settings.createUnitOperationSettings(),
            clientContext);
    this.updateUnitOperationCallable =
        callableFactory.createUnaryCallable(
            updateUnitOperationTransportSettings,
            settings.updateUnitOperationSettings(),
            clientContext);
    this.deleteUnitOperationCallable =
        callableFactory.createUnaryCallable(
            deleteUnitOperationTransportSettings,
            settings.deleteUnitOperationSettings(),
            clientContext);
    this.listReleasesCallable =
        callableFactory.createUnaryCallable(
            listReleasesTransportSettings, settings.listReleasesSettings(), clientContext);
    this.listReleasesPagedCallable =
        callableFactory.createPagedCallable(
            listReleasesTransportSettings, settings.listReleasesSettings(), clientContext);
    this.getReleaseCallable =
        callableFactory.createUnaryCallable(
            getReleaseTransportSettings, settings.getReleaseSettings(), clientContext);
    this.createReleaseCallable =
        callableFactory.createUnaryCallable(
            createReleaseTransportSettings, settings.createReleaseSettings(), clientContext);
    this.updateReleaseCallable =
        callableFactory.createUnaryCallable(
            updateReleaseTransportSettings, settings.updateReleaseSettings(), clientContext);
    this.deleteReleaseCallable =
        callableFactory.createUnaryCallable(
            deleteReleaseTransportSettings, settings.deleteReleaseSettings(), clientContext);
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
  public UnaryCallable<ListSaasRequest, ListSaasResponse> listSaasCallable() {
    return listSaasCallable;
  }

  @Override
  public UnaryCallable<ListSaasRequest, ListSaasPagedResponse> listSaasPagedCallable() {
    return listSaasPagedCallable;
  }

  @Override
  public UnaryCallable<GetSaasRequest, Saas> getSaasCallable() {
    return getSaasCallable;
  }

  @Override
  public UnaryCallable<CreateSaasRequest, Saas> createSaasCallable() {
    return createSaasCallable;
  }

  @Override
  public UnaryCallable<UpdateSaasRequest, Saas> updateSaasCallable() {
    return updateSaasCallable;
  }

  @Override
  public UnaryCallable<DeleteSaasRequest, Empty> deleteSaasCallable() {
    return deleteSaasCallable;
  }

  @Override
  public UnaryCallable<ListTenantsRequest, ListTenantsResponse> listTenantsCallable() {
    return listTenantsCallable;
  }

  @Override
  public UnaryCallable<ListTenantsRequest, ListTenantsPagedResponse> listTenantsPagedCallable() {
    return listTenantsPagedCallable;
  }

  @Override
  public UnaryCallable<GetTenantRequest, Tenant> getTenantCallable() {
    return getTenantCallable;
  }

  @Override
  public UnaryCallable<CreateTenantRequest, Tenant> createTenantCallable() {
    return createTenantCallable;
  }

  @Override
  public UnaryCallable<UpdateTenantRequest, Tenant> updateTenantCallable() {
    return updateTenantCallable;
  }

  @Override
  public UnaryCallable<DeleteTenantRequest, Empty> deleteTenantCallable() {
    return deleteTenantCallable;
  }

  @Override
  public UnaryCallable<ListUnitKindsRequest, ListUnitKindsResponse> listUnitKindsCallable() {
    return listUnitKindsCallable;
  }

  @Override
  public UnaryCallable<ListUnitKindsRequest, ListUnitKindsPagedResponse>
      listUnitKindsPagedCallable() {
    return listUnitKindsPagedCallable;
  }

  @Override
  public UnaryCallable<GetUnitKindRequest, UnitKind> getUnitKindCallable() {
    return getUnitKindCallable;
  }

  @Override
  public UnaryCallable<CreateUnitKindRequest, UnitKind> createUnitKindCallable() {
    return createUnitKindCallable;
  }

  @Override
  public UnaryCallable<UpdateUnitKindRequest, UnitKind> updateUnitKindCallable() {
    return updateUnitKindCallable;
  }

  @Override
  public UnaryCallable<DeleteUnitKindRequest, Empty> deleteUnitKindCallable() {
    return deleteUnitKindCallable;
  }

  @Override
  public UnaryCallable<ListUnitsRequest, ListUnitsResponse> listUnitsCallable() {
    return listUnitsCallable;
  }

  @Override
  public UnaryCallable<ListUnitsRequest, ListUnitsPagedResponse> listUnitsPagedCallable() {
    return listUnitsPagedCallable;
  }

  @Override
  public UnaryCallable<GetUnitRequest, Unit> getUnitCallable() {
    return getUnitCallable;
  }

  @Override
  public UnaryCallable<CreateUnitRequest, Unit> createUnitCallable() {
    return createUnitCallable;
  }

  @Override
  public UnaryCallable<UpdateUnitRequest, Unit> updateUnitCallable() {
    return updateUnitCallable;
  }

  @Override
  public UnaryCallable<DeleteUnitRequest, Empty> deleteUnitCallable() {
    return deleteUnitCallable;
  }

  @Override
  public UnaryCallable<ListUnitOperationsRequest, ListUnitOperationsResponse>
      listUnitOperationsCallable() {
    return listUnitOperationsCallable;
  }

  @Override
  public UnaryCallable<ListUnitOperationsRequest, ListUnitOperationsPagedResponse>
      listUnitOperationsPagedCallable() {
    return listUnitOperationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetUnitOperationRequest, UnitOperation> getUnitOperationCallable() {
    return getUnitOperationCallable;
  }

  @Override
  public UnaryCallable<CreateUnitOperationRequest, UnitOperation> createUnitOperationCallable() {
    return createUnitOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateUnitOperationRequest, UnitOperation> updateUnitOperationCallable() {
    return updateUnitOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteUnitOperationRequest, Empty> deleteUnitOperationCallable() {
    return deleteUnitOperationCallable;
  }

  @Override
  public UnaryCallable<ListReleasesRequest, ListReleasesResponse> listReleasesCallable() {
    return listReleasesCallable;
  }

  @Override
  public UnaryCallable<ListReleasesRequest, ListReleasesPagedResponse> listReleasesPagedCallable() {
    return listReleasesPagedCallable;
  }

  @Override
  public UnaryCallable<GetReleaseRequest, Release> getReleaseCallable() {
    return getReleaseCallable;
  }

  @Override
  public UnaryCallable<CreateReleaseRequest, Release> createReleaseCallable() {
    return createReleaseCallable;
  }

  @Override
  public UnaryCallable<UpdateReleaseRequest, Release> updateReleaseCallable() {
    return updateReleaseCallable;
  }

  @Override
  public UnaryCallable<DeleteReleaseRequest, Empty> deleteReleaseCallable() {
    return deleteReleaseCallable;
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
