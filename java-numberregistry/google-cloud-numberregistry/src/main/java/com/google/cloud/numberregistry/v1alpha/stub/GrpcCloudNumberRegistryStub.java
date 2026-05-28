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

package com.google.cloud.numberregistry.v1alpha.stub;

import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListCustomRangesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListDiscoveredRangesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListIpamAdminScopesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListRealmsPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListRegistryBooksPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.SearchIpResourcesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesRequest;
import com.google.cloud.numberregistry.v1alpha.CheckAvailabilityIpamAdminScopesResponse;
import com.google.cloud.numberregistry.v1alpha.CleanupIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.CreateCustomRangeRequest;
import com.google.cloud.numberregistry.v1alpha.CreateIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.CreateRealmRequest;
import com.google.cloud.numberregistry.v1alpha.CreateRegistryBookRequest;
import com.google.cloud.numberregistry.v1alpha.CustomRange;
import com.google.cloud.numberregistry.v1alpha.DeleteCustomRangeRequest;
import com.google.cloud.numberregistry.v1alpha.DeleteIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.DeleteRealmRequest;
import com.google.cloud.numberregistry.v1alpha.DeleteRegistryBookRequest;
import com.google.cloud.numberregistry.v1alpha.DisableIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.DiscoveredRange;
import com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesRequest;
import com.google.cloud.numberregistry.v1alpha.FindCustomRangeFreeIpRangesResponse;
import com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesRequest;
import com.google.cloud.numberregistry.v1alpha.FindDiscoveredRangeFreeIpRangesResponse;
import com.google.cloud.numberregistry.v1alpha.GetCustomRangeRequest;
import com.google.cloud.numberregistry.v1alpha.GetDiscoveredRangeRequest;
import com.google.cloud.numberregistry.v1alpha.GetIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.GetRealmRequest;
import com.google.cloud.numberregistry.v1alpha.GetRegistryBookRequest;
import com.google.cloud.numberregistry.v1alpha.IpamAdminScope;
import com.google.cloud.numberregistry.v1alpha.ListCustomRangesRequest;
import com.google.cloud.numberregistry.v1alpha.ListCustomRangesResponse;
import com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesRequest;
import com.google.cloud.numberregistry.v1alpha.ListDiscoveredRangesResponse;
import com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesRequest;
import com.google.cloud.numberregistry.v1alpha.ListIpamAdminScopesResponse;
import com.google.cloud.numberregistry.v1alpha.ListRealmsRequest;
import com.google.cloud.numberregistry.v1alpha.ListRealmsResponse;
import com.google.cloud.numberregistry.v1alpha.ListRegistryBooksRequest;
import com.google.cloud.numberregistry.v1alpha.ListRegistryBooksResponse;
import com.google.cloud.numberregistry.v1alpha.OperationMetadata;
import com.google.cloud.numberregistry.v1alpha.Realm;
import com.google.cloud.numberregistry.v1alpha.RegistryBook;
import com.google.cloud.numberregistry.v1alpha.SearchIpResourcesRequest;
import com.google.cloud.numberregistry.v1alpha.SearchIpResourcesResponse;
import com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationRequest;
import com.google.cloud.numberregistry.v1alpha.ShowCustomRangeUtilizationResponse;
import com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationRequest;
import com.google.cloud.numberregistry.v1alpha.ShowDiscoveredRangeUtilizationResponse;
import com.google.cloud.numberregistry.v1alpha.UpdateCustomRangeRequest;
import com.google.cloud.numberregistry.v1alpha.UpdateIpamAdminScopeRequest;
import com.google.cloud.numberregistry.v1alpha.UpdateRealmRequest;
import com.google.cloud.numberregistry.v1alpha.UpdateRegistryBookRequest;
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
 * gRPC stub implementation for the CloudNumberRegistry service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcCloudNumberRegistryStub extends CloudNumberRegistryStub {
  private static final MethodDescriptor<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse>
      listIpamAdminScopesMethodDescriptor =
          MethodDescriptor.<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/ListIpamAdminScopes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListIpamAdminScopesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIpamAdminScopesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetIpamAdminScopeRequest, IpamAdminScope>
      getIpamAdminScopeMethodDescriptor =
          MethodDescriptor.<GetIpamAdminScopeRequest, IpamAdminScope>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/GetIpamAdminScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetIpamAdminScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IpamAdminScope.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
      checkAvailabilityIpamAdminScopesMethodDescriptor =
          MethodDescriptor
              .<CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/CheckAvailabilityIpamAdminScopes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CheckAvailabilityIpamAdminScopesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      CheckAvailabilityIpamAdminScopesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateIpamAdminScopeRequest, Operation>
      createIpamAdminScopeMethodDescriptor =
          MethodDescriptor.<CreateIpamAdminScopeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/CreateIpamAdminScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateIpamAdminScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateIpamAdminScopeRequest, Operation>
      updateIpamAdminScopeMethodDescriptor =
          MethodDescriptor.<UpdateIpamAdminScopeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/UpdateIpamAdminScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateIpamAdminScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteIpamAdminScopeRequest, Operation>
      deleteIpamAdminScopeMethodDescriptor =
          MethodDescriptor.<DeleteIpamAdminScopeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/DeleteIpamAdminScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteIpamAdminScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DisableIpamAdminScopeRequest, Operation>
      disableIpamAdminScopeMethodDescriptor =
          MethodDescriptor.<DisableIpamAdminScopeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/DisableIpamAdminScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisableIpamAdminScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CleanupIpamAdminScopeRequest, Operation>
      cleanupIpamAdminScopeMethodDescriptor =
          MethodDescriptor.<CleanupIpamAdminScopeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/CleanupIpamAdminScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CleanupIpamAdminScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListRegistryBooksRequest, ListRegistryBooksResponse>
      listRegistryBooksMethodDescriptor =
          MethodDescriptor.<ListRegistryBooksRequest, ListRegistryBooksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/ListRegistryBooks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRegistryBooksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRegistryBooksResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetRegistryBookRequest, RegistryBook>
      getRegistryBookMethodDescriptor =
          MethodDescriptor.<GetRegistryBookRequest, RegistryBook>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/GetRegistryBook")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRegistryBookRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RegistryBook.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SearchIpResourcesRequest, SearchIpResourcesResponse>
      searchIpResourcesMethodDescriptor =
          MethodDescriptor.<SearchIpResourcesRequest, SearchIpResourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/SearchIpResources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchIpResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchIpResourcesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateRegistryBookRequest, Operation>
      createRegistryBookMethodDescriptor =
          MethodDescriptor.<CreateRegistryBookRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/CreateRegistryBook")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRegistryBookRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateRegistryBookRequest, Operation>
      updateRegistryBookMethodDescriptor =
          MethodDescriptor.<UpdateRegistryBookRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/UpdateRegistryBook")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateRegistryBookRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteRegistryBookRequest, Operation>
      deleteRegistryBookMethodDescriptor =
          MethodDescriptor.<DeleteRegistryBookRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/DeleteRegistryBook")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRegistryBookRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListRealmsRequest, ListRealmsResponse>
      listRealmsMethodDescriptor =
          MethodDescriptor.<ListRealmsRequest, ListRealmsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/ListRealms")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRealmsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListRealmsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetRealmRequest, Realm> getRealmMethodDescriptor =
      MethodDescriptor.<GetRealmRequest, Realm>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.numberregistry.v1alpha.CloudNumberRegistry/GetRealm")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRealmRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Realm.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateRealmRequest, Operation> createRealmMethodDescriptor =
      MethodDescriptor.<CreateRealmRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.numberregistry.v1alpha.CloudNumberRegistry/CreateRealm")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateRealmRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateRealmRequest, Operation> updateRealmMethodDescriptor =
      MethodDescriptor.<UpdateRealmRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.numberregistry.v1alpha.CloudNumberRegistry/UpdateRealm")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateRealmRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteRealmRequest, Operation> deleteRealmMethodDescriptor =
      MethodDescriptor.<DeleteRealmRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.numberregistry.v1alpha.CloudNumberRegistry/DeleteRealm")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteRealmRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListDiscoveredRangesRequest, ListDiscoveredRangesResponse>
      listDiscoveredRangesMethodDescriptor =
          MethodDescriptor.<ListDiscoveredRangesRequest, ListDiscoveredRangesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/ListDiscoveredRanges")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDiscoveredRangesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDiscoveredRangesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDiscoveredRangeRequest, DiscoveredRange>
      getDiscoveredRangeMethodDescriptor =
          MethodDescriptor.<GetDiscoveredRangeRequest, DiscoveredRange>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/GetDiscoveredRange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDiscoveredRangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DiscoveredRange.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
      findDiscoveredRangeFreeIpRangesMethodDescriptor =
          MethodDescriptor
              .<FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/FindDiscoveredRangeFreeIpRanges")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      FindDiscoveredRangeFreeIpRangesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      FindDiscoveredRangeFreeIpRangesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListCustomRangesRequest, ListCustomRangesResponse>
      listCustomRangesMethodDescriptor =
          MethodDescriptor.<ListCustomRangesRequest, ListCustomRangesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/ListCustomRanges")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCustomRangesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCustomRangesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetCustomRangeRequest, CustomRange>
      getCustomRangeMethodDescriptor =
          MethodDescriptor.<GetCustomRangeRequest, CustomRange>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/GetCustomRange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCustomRangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomRange.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>
      showCustomRangeUtilizationMethodDescriptor =
          MethodDescriptor
              .<ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/ShowCustomRangeUtilization")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ShowCustomRangeUtilizationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ShowCustomRangeUtilizationResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
      showDiscoveredRangeUtilizationMethodDescriptor =
          MethodDescriptor
              .<ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/ShowDiscoveredRangeUtilization")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ShowDiscoveredRangeUtilizationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ShowDiscoveredRangeUtilizationResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>
      findCustomRangeFreeIpRangesMethodDescriptor =
          MethodDescriptor
              .<FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/FindCustomRangeFreeIpRanges")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FindCustomRangeFreeIpRangesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FindCustomRangeFreeIpRangesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateCustomRangeRequest, Operation>
      createCustomRangeMethodDescriptor =
          MethodDescriptor.<CreateCustomRangeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/CreateCustomRange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCustomRangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateCustomRangeRequest, Operation>
      updateCustomRangeMethodDescriptor =
          MethodDescriptor.<UpdateCustomRangeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/UpdateCustomRange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCustomRangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteCustomRangeRequest, Operation>
      deleteCustomRangeMethodDescriptor =
          MethodDescriptor.<DeleteCustomRangeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/DeleteCustomRange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCustomRangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse>
      listIpamAdminScopesCallable;
  private final UnaryCallable<ListIpamAdminScopesRequest, ListIpamAdminScopesPagedResponse>
      listIpamAdminScopesPagedCallable;
  private final UnaryCallable<GetIpamAdminScopeRequest, IpamAdminScope> getIpamAdminScopeCallable;
  private final UnaryCallable<
          CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
      checkAvailabilityIpamAdminScopesCallable;
  private final UnaryCallable<CreateIpamAdminScopeRequest, Operation> createIpamAdminScopeCallable;
  private final OperationCallable<CreateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      createIpamAdminScopeOperationCallable;
  private final UnaryCallable<UpdateIpamAdminScopeRequest, Operation> updateIpamAdminScopeCallable;
  private final OperationCallable<UpdateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      updateIpamAdminScopeOperationCallable;
  private final UnaryCallable<DeleteIpamAdminScopeRequest, Operation> deleteIpamAdminScopeCallable;
  private final OperationCallable<DeleteIpamAdminScopeRequest, Empty, OperationMetadata>
      deleteIpamAdminScopeOperationCallable;
  private final UnaryCallable<DisableIpamAdminScopeRequest, Operation>
      disableIpamAdminScopeCallable;
  private final OperationCallable<DisableIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      disableIpamAdminScopeOperationCallable;
  private final UnaryCallable<CleanupIpamAdminScopeRequest, Operation>
      cleanupIpamAdminScopeCallable;
  private final OperationCallable<CleanupIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      cleanupIpamAdminScopeOperationCallable;
  private final UnaryCallable<ListRegistryBooksRequest, ListRegistryBooksResponse>
      listRegistryBooksCallable;
  private final UnaryCallable<ListRegistryBooksRequest, ListRegistryBooksPagedResponse>
      listRegistryBooksPagedCallable;
  private final UnaryCallable<GetRegistryBookRequest, RegistryBook> getRegistryBookCallable;
  private final UnaryCallable<SearchIpResourcesRequest, SearchIpResourcesResponse>
      searchIpResourcesCallable;
  private final UnaryCallable<SearchIpResourcesRequest, SearchIpResourcesPagedResponse>
      searchIpResourcesPagedCallable;
  private final UnaryCallable<CreateRegistryBookRequest, Operation> createRegistryBookCallable;
  private final OperationCallable<CreateRegistryBookRequest, RegistryBook, OperationMetadata>
      createRegistryBookOperationCallable;
  private final UnaryCallable<UpdateRegistryBookRequest, Operation> updateRegistryBookCallable;
  private final OperationCallable<UpdateRegistryBookRequest, RegistryBook, OperationMetadata>
      updateRegistryBookOperationCallable;
  private final UnaryCallable<DeleteRegistryBookRequest, Operation> deleteRegistryBookCallable;
  private final OperationCallable<DeleteRegistryBookRequest, Empty, OperationMetadata>
      deleteRegistryBookOperationCallable;
  private final UnaryCallable<ListRealmsRequest, ListRealmsResponse> listRealmsCallable;
  private final UnaryCallable<ListRealmsRequest, ListRealmsPagedResponse> listRealmsPagedCallable;
  private final UnaryCallable<GetRealmRequest, Realm> getRealmCallable;
  private final UnaryCallable<CreateRealmRequest, Operation> createRealmCallable;
  private final OperationCallable<CreateRealmRequest, Realm, OperationMetadata>
      createRealmOperationCallable;
  private final UnaryCallable<UpdateRealmRequest, Operation> updateRealmCallable;
  private final OperationCallable<UpdateRealmRequest, Realm, OperationMetadata>
      updateRealmOperationCallable;
  private final UnaryCallable<DeleteRealmRequest, Operation> deleteRealmCallable;
  private final OperationCallable<DeleteRealmRequest, Empty, OperationMetadata>
      deleteRealmOperationCallable;
  private final UnaryCallable<ListDiscoveredRangesRequest, ListDiscoveredRangesResponse>
      listDiscoveredRangesCallable;
  private final UnaryCallable<ListDiscoveredRangesRequest, ListDiscoveredRangesPagedResponse>
      listDiscoveredRangesPagedCallable;
  private final UnaryCallable<GetDiscoveredRangeRequest, DiscoveredRange>
      getDiscoveredRangeCallable;
  private final UnaryCallable<
          FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
      findDiscoveredRangeFreeIpRangesCallable;
  private final UnaryCallable<ListCustomRangesRequest, ListCustomRangesResponse>
      listCustomRangesCallable;
  private final UnaryCallable<ListCustomRangesRequest, ListCustomRangesPagedResponse>
      listCustomRangesPagedCallable;
  private final UnaryCallable<GetCustomRangeRequest, CustomRange> getCustomRangeCallable;
  private final UnaryCallable<ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>
      showCustomRangeUtilizationCallable;
  private final UnaryCallable<
          ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
      showDiscoveredRangeUtilizationCallable;
  private final UnaryCallable<
          FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>
      findCustomRangeFreeIpRangesCallable;
  private final UnaryCallable<CreateCustomRangeRequest, Operation> createCustomRangeCallable;
  private final OperationCallable<CreateCustomRangeRequest, CustomRange, OperationMetadata>
      createCustomRangeOperationCallable;
  private final UnaryCallable<UpdateCustomRangeRequest, Operation> updateCustomRangeCallable;
  private final OperationCallable<UpdateCustomRangeRequest, CustomRange, OperationMetadata>
      updateCustomRangeOperationCallable;
  private final UnaryCallable<DeleteCustomRangeRequest, Operation> deleteCustomRangeCallable;
  private final OperationCallable<DeleteCustomRangeRequest, Empty, OperationMetadata>
      deleteCustomRangeOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudNumberRegistryStub create(CloudNumberRegistryStubSettings settings)
      throws IOException {
    return new GrpcCloudNumberRegistryStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudNumberRegistryStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCloudNumberRegistryStub(
        CloudNumberRegistryStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudNumberRegistryStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudNumberRegistryStub(
        CloudNumberRegistryStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudNumberRegistryStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudNumberRegistryStub(
      CloudNumberRegistryStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcCloudNumberRegistryCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudNumberRegistryStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudNumberRegistryStub(
      CloudNumberRegistryStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse>
        listIpamAdminScopesTransportSettings =
            GrpcCallSettings.<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse>newBuilder()
                .setMethodDescriptor(listIpamAdminScopesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetIpamAdminScopeRequest, IpamAdminScope> getIpamAdminScopeTransportSettings =
        GrpcCallSettings.<GetIpamAdminScopeRequest, IpamAdminScope>newBuilder()
            .setMethodDescriptor(getIpamAdminScopeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<
            CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
        checkAvailabilityIpamAdminScopesTransportSettings =
            GrpcCallSettings
                .<CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
                    newBuilder()
                .setMethodDescriptor(checkAvailabilityIpamAdminScopesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<CreateIpamAdminScopeRequest, Operation> createIpamAdminScopeTransportSettings =
        GrpcCallSettings.<CreateIpamAdminScopeRequest, Operation>newBuilder()
            .setMethodDescriptor(createIpamAdminScopeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateIpamAdminScopeRequest, Operation> updateIpamAdminScopeTransportSettings =
        GrpcCallSettings.<UpdateIpamAdminScopeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateIpamAdminScopeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "ipam_admin_scope.name",
                      String.valueOf(request.getIpamAdminScope().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteIpamAdminScopeRequest, Operation> deleteIpamAdminScopeTransportSettings =
        GrpcCallSettings.<DeleteIpamAdminScopeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteIpamAdminScopeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<DisableIpamAdminScopeRequest, Operation>
        disableIpamAdminScopeTransportSettings =
            GrpcCallSettings.<DisableIpamAdminScopeRequest, Operation>newBuilder()
                .setMethodDescriptor(disableIpamAdminScopeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CleanupIpamAdminScopeRequest, Operation>
        cleanupIpamAdminScopeTransportSettings =
            GrpcCallSettings.<CleanupIpamAdminScopeRequest, Operation>newBuilder()
                .setMethodDescriptor(cleanupIpamAdminScopeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListRegistryBooksRequest, ListRegistryBooksResponse>
        listRegistryBooksTransportSettings =
            GrpcCallSettings.<ListRegistryBooksRequest, ListRegistryBooksResponse>newBuilder()
                .setMethodDescriptor(listRegistryBooksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetRegistryBookRequest, RegistryBook> getRegistryBookTransportSettings =
        GrpcCallSettings.<GetRegistryBookRequest, RegistryBook>newBuilder()
            .setMethodDescriptor(getRegistryBookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<SearchIpResourcesRequest, SearchIpResourcesResponse>
        searchIpResourcesTransportSettings =
            GrpcCallSettings.<SearchIpResourcesRequest, SearchIpResourcesResponse>newBuilder()
                .setMethodDescriptor(searchIpResourcesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateRegistryBookRequest, Operation> createRegistryBookTransportSettings =
        GrpcCallSettings.<CreateRegistryBookRequest, Operation>newBuilder()
            .setMethodDescriptor(createRegistryBookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateRegistryBookRequest, Operation> updateRegistryBookTransportSettings =
        GrpcCallSettings.<UpdateRegistryBookRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRegistryBookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "registry_book.name", String.valueOf(request.getRegistryBook().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteRegistryBookRequest, Operation> deleteRegistryBookTransportSettings =
        GrpcCallSettings.<DeleteRegistryBookRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRegistryBookMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListRealmsRequest, ListRealmsResponse> listRealmsTransportSettings =
        GrpcCallSettings.<ListRealmsRequest, ListRealmsResponse>newBuilder()
            .setMethodDescriptor(listRealmsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetRealmRequest, Realm> getRealmTransportSettings =
        GrpcCallSettings.<GetRealmRequest, Realm>newBuilder()
            .setMethodDescriptor(getRealmMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateRealmRequest, Operation> createRealmTransportSettings =
        GrpcCallSettings.<CreateRealmRequest, Operation>newBuilder()
            .setMethodDescriptor(createRealmMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateRealmRequest, Operation> updateRealmTransportSettings =
        GrpcCallSettings.<UpdateRealmRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRealmMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("realm.name", String.valueOf(request.getRealm().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteRealmRequest, Operation> deleteRealmTransportSettings =
        GrpcCallSettings.<DeleteRealmRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRealmMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListDiscoveredRangesRequest, ListDiscoveredRangesResponse>
        listDiscoveredRangesTransportSettings =
            GrpcCallSettings.<ListDiscoveredRangesRequest, ListDiscoveredRangesResponse>newBuilder()
                .setMethodDescriptor(listDiscoveredRangesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetDiscoveredRangeRequest, DiscoveredRange>
        getDiscoveredRangeTransportSettings =
            GrpcCallSettings.<GetDiscoveredRangeRequest, DiscoveredRange>newBuilder()
                .setMethodDescriptor(getDiscoveredRangeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<
            FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
        findDiscoveredRangeFreeIpRangesTransportSettings =
            GrpcCallSettings
                .<FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
                    newBuilder()
                .setMethodDescriptor(findDiscoveredRangeFreeIpRangesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListCustomRangesRequest, ListCustomRangesResponse>
        listCustomRangesTransportSettings =
            GrpcCallSettings.<ListCustomRangesRequest, ListCustomRangesResponse>newBuilder()
                .setMethodDescriptor(listCustomRangesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetCustomRangeRequest, CustomRange> getCustomRangeTransportSettings =
        GrpcCallSettings.<GetCustomRangeRequest, CustomRange>newBuilder()
            .setMethodDescriptor(getCustomRangeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>
        showCustomRangeUtilizationTransportSettings =
            GrpcCallSettings
                .<ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>newBuilder()
                .setMethodDescriptor(showCustomRangeUtilizationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
        showDiscoveredRangeUtilizationTransportSettings =
            GrpcCallSettings
                .<ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
                    newBuilder()
                .setMethodDescriptor(showDiscoveredRangeUtilizationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>
        findCustomRangeFreeIpRangesTransportSettings =
            GrpcCallSettings
                .<FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>
                    newBuilder()
                .setMethodDescriptor(findCustomRangeFreeIpRangesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateCustomRangeRequest, Operation> createCustomRangeTransportSettings =
        GrpcCallSettings.<CreateCustomRangeRequest, Operation>newBuilder()
            .setMethodDescriptor(createCustomRangeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateCustomRangeRequest, Operation> updateCustomRangeTransportSettings =
        GrpcCallSettings.<UpdateCustomRangeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateCustomRangeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "custom_range.name", String.valueOf(request.getCustomRange().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteCustomRangeRequest, Operation> deleteCustomRangeTransportSettings =
        GrpcCallSettings.<DeleteCustomRangeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCustomRangeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();

    this.listIpamAdminScopesCallable =
        callableFactory.createUnaryCallable(
            listIpamAdminScopesTransportSettings,
            settings.listIpamAdminScopesSettings(),
            clientContext);
    this.listIpamAdminScopesPagedCallable =
        callableFactory.createPagedCallable(
            listIpamAdminScopesTransportSettings,
            settings.listIpamAdminScopesSettings(),
            clientContext);
    this.getIpamAdminScopeCallable =
        callableFactory.createUnaryCallable(
            getIpamAdminScopeTransportSettings,
            settings.getIpamAdminScopeSettings(),
            clientContext);
    this.checkAvailabilityIpamAdminScopesCallable =
        callableFactory.createUnaryCallable(
            checkAvailabilityIpamAdminScopesTransportSettings,
            settings.checkAvailabilityIpamAdminScopesSettings(),
            clientContext);
    this.createIpamAdminScopeCallable =
        callableFactory.createUnaryCallable(
            createIpamAdminScopeTransportSettings,
            settings.createIpamAdminScopeSettings(),
            clientContext);
    this.createIpamAdminScopeOperationCallable =
        callableFactory.createOperationCallable(
            createIpamAdminScopeTransportSettings,
            settings.createIpamAdminScopeOperationSettings(),
            clientContext,
            operationsStub);
    this.updateIpamAdminScopeCallable =
        callableFactory.createUnaryCallable(
            updateIpamAdminScopeTransportSettings,
            settings.updateIpamAdminScopeSettings(),
            clientContext);
    this.updateIpamAdminScopeOperationCallable =
        callableFactory.createOperationCallable(
            updateIpamAdminScopeTransportSettings,
            settings.updateIpamAdminScopeOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteIpamAdminScopeCallable =
        callableFactory.createUnaryCallable(
            deleteIpamAdminScopeTransportSettings,
            settings.deleteIpamAdminScopeSettings(),
            clientContext);
    this.deleteIpamAdminScopeOperationCallable =
        callableFactory.createOperationCallable(
            deleteIpamAdminScopeTransportSettings,
            settings.deleteIpamAdminScopeOperationSettings(),
            clientContext,
            operationsStub);
    this.disableIpamAdminScopeCallable =
        callableFactory.createUnaryCallable(
            disableIpamAdminScopeTransportSettings,
            settings.disableIpamAdminScopeSettings(),
            clientContext);
    this.disableIpamAdminScopeOperationCallable =
        callableFactory.createOperationCallable(
            disableIpamAdminScopeTransportSettings,
            settings.disableIpamAdminScopeOperationSettings(),
            clientContext,
            operationsStub);
    this.cleanupIpamAdminScopeCallable =
        callableFactory.createUnaryCallable(
            cleanupIpamAdminScopeTransportSettings,
            settings.cleanupIpamAdminScopeSettings(),
            clientContext);
    this.cleanupIpamAdminScopeOperationCallable =
        callableFactory.createOperationCallable(
            cleanupIpamAdminScopeTransportSettings,
            settings.cleanupIpamAdminScopeOperationSettings(),
            clientContext,
            operationsStub);
    this.listRegistryBooksCallable =
        callableFactory.createUnaryCallable(
            listRegistryBooksTransportSettings,
            settings.listRegistryBooksSettings(),
            clientContext);
    this.listRegistryBooksPagedCallable =
        callableFactory.createPagedCallable(
            listRegistryBooksTransportSettings,
            settings.listRegistryBooksSettings(),
            clientContext);
    this.getRegistryBookCallable =
        callableFactory.createUnaryCallable(
            getRegistryBookTransportSettings, settings.getRegistryBookSettings(), clientContext);
    this.searchIpResourcesCallable =
        callableFactory.createUnaryCallable(
            searchIpResourcesTransportSettings,
            settings.searchIpResourcesSettings(),
            clientContext);
    this.searchIpResourcesPagedCallable =
        callableFactory.createPagedCallable(
            searchIpResourcesTransportSettings,
            settings.searchIpResourcesSettings(),
            clientContext);
    this.createRegistryBookCallable =
        callableFactory.createUnaryCallable(
            createRegistryBookTransportSettings,
            settings.createRegistryBookSettings(),
            clientContext);
    this.createRegistryBookOperationCallable =
        callableFactory.createOperationCallable(
            createRegistryBookTransportSettings,
            settings.createRegistryBookOperationSettings(),
            clientContext,
            operationsStub);
    this.updateRegistryBookCallable =
        callableFactory.createUnaryCallable(
            updateRegistryBookTransportSettings,
            settings.updateRegistryBookSettings(),
            clientContext);
    this.updateRegistryBookOperationCallable =
        callableFactory.createOperationCallable(
            updateRegistryBookTransportSettings,
            settings.updateRegistryBookOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteRegistryBookCallable =
        callableFactory.createUnaryCallable(
            deleteRegistryBookTransportSettings,
            settings.deleteRegistryBookSettings(),
            clientContext);
    this.deleteRegistryBookOperationCallable =
        callableFactory.createOperationCallable(
            deleteRegistryBookTransportSettings,
            settings.deleteRegistryBookOperationSettings(),
            clientContext,
            operationsStub);
    this.listRealmsCallable =
        callableFactory.createUnaryCallable(
            listRealmsTransportSettings, settings.listRealmsSettings(), clientContext);
    this.listRealmsPagedCallable =
        callableFactory.createPagedCallable(
            listRealmsTransportSettings, settings.listRealmsSettings(), clientContext);
    this.getRealmCallable =
        callableFactory.createUnaryCallable(
            getRealmTransportSettings, settings.getRealmSettings(), clientContext);
    this.createRealmCallable =
        callableFactory.createUnaryCallable(
            createRealmTransportSettings, settings.createRealmSettings(), clientContext);
    this.createRealmOperationCallable =
        callableFactory.createOperationCallable(
            createRealmTransportSettings,
            settings.createRealmOperationSettings(),
            clientContext,
            operationsStub);
    this.updateRealmCallable =
        callableFactory.createUnaryCallable(
            updateRealmTransportSettings, settings.updateRealmSettings(), clientContext);
    this.updateRealmOperationCallable =
        callableFactory.createOperationCallable(
            updateRealmTransportSettings,
            settings.updateRealmOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteRealmCallable =
        callableFactory.createUnaryCallable(
            deleteRealmTransportSettings, settings.deleteRealmSettings(), clientContext);
    this.deleteRealmOperationCallable =
        callableFactory.createOperationCallable(
            deleteRealmTransportSettings,
            settings.deleteRealmOperationSettings(),
            clientContext,
            operationsStub);
    this.listDiscoveredRangesCallable =
        callableFactory.createUnaryCallable(
            listDiscoveredRangesTransportSettings,
            settings.listDiscoveredRangesSettings(),
            clientContext);
    this.listDiscoveredRangesPagedCallable =
        callableFactory.createPagedCallable(
            listDiscoveredRangesTransportSettings,
            settings.listDiscoveredRangesSettings(),
            clientContext);
    this.getDiscoveredRangeCallable =
        callableFactory.createUnaryCallable(
            getDiscoveredRangeTransportSettings,
            settings.getDiscoveredRangeSettings(),
            clientContext);
    this.findDiscoveredRangeFreeIpRangesCallable =
        callableFactory.createUnaryCallable(
            findDiscoveredRangeFreeIpRangesTransportSettings,
            settings.findDiscoveredRangeFreeIpRangesSettings(),
            clientContext);
    this.listCustomRangesCallable =
        callableFactory.createUnaryCallable(
            listCustomRangesTransportSettings, settings.listCustomRangesSettings(), clientContext);
    this.listCustomRangesPagedCallable =
        callableFactory.createPagedCallable(
            listCustomRangesTransportSettings, settings.listCustomRangesSettings(), clientContext);
    this.getCustomRangeCallable =
        callableFactory.createUnaryCallable(
            getCustomRangeTransportSettings, settings.getCustomRangeSettings(), clientContext);
    this.showCustomRangeUtilizationCallable =
        callableFactory.createUnaryCallable(
            showCustomRangeUtilizationTransportSettings,
            settings.showCustomRangeUtilizationSettings(),
            clientContext);
    this.showDiscoveredRangeUtilizationCallable =
        callableFactory.createUnaryCallable(
            showDiscoveredRangeUtilizationTransportSettings,
            settings.showDiscoveredRangeUtilizationSettings(),
            clientContext);
    this.findCustomRangeFreeIpRangesCallable =
        callableFactory.createUnaryCallable(
            findCustomRangeFreeIpRangesTransportSettings,
            settings.findCustomRangeFreeIpRangesSettings(),
            clientContext);
    this.createCustomRangeCallable =
        callableFactory.createUnaryCallable(
            createCustomRangeTransportSettings,
            settings.createCustomRangeSettings(),
            clientContext);
    this.createCustomRangeOperationCallable =
        callableFactory.createOperationCallable(
            createCustomRangeTransportSettings,
            settings.createCustomRangeOperationSettings(),
            clientContext,
            operationsStub);
    this.updateCustomRangeCallable =
        callableFactory.createUnaryCallable(
            updateCustomRangeTransportSettings,
            settings.updateCustomRangeSettings(),
            clientContext);
    this.updateCustomRangeOperationCallable =
        callableFactory.createOperationCallable(
            updateCustomRangeTransportSettings,
            settings.updateCustomRangeOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteCustomRangeCallable =
        callableFactory.createUnaryCallable(
            deleteCustomRangeTransportSettings,
            settings.deleteCustomRangeSettings(),
            clientContext);
    this.deleteCustomRangeOperationCallable =
        callableFactory.createOperationCallable(
            deleteCustomRangeTransportSettings,
            settings.deleteCustomRangeOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse>
      listIpamAdminScopesCallable() {
    return listIpamAdminScopesCallable;
  }

  @Override
  public UnaryCallable<ListIpamAdminScopesRequest, ListIpamAdminScopesPagedResponse>
      listIpamAdminScopesPagedCallable() {
    return listIpamAdminScopesPagedCallable;
  }

  @Override
  public UnaryCallable<GetIpamAdminScopeRequest, IpamAdminScope> getIpamAdminScopeCallable() {
    return getIpamAdminScopeCallable;
  }

  @Override
  public UnaryCallable<
          CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
      checkAvailabilityIpamAdminScopesCallable() {
    return checkAvailabilityIpamAdminScopesCallable;
  }

  @Override
  public UnaryCallable<CreateIpamAdminScopeRequest, Operation> createIpamAdminScopeCallable() {
    return createIpamAdminScopeCallable;
  }

  @Override
  public OperationCallable<CreateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      createIpamAdminScopeOperationCallable() {
    return createIpamAdminScopeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateIpamAdminScopeRequest, Operation> updateIpamAdminScopeCallable() {
    return updateIpamAdminScopeCallable;
  }

  @Override
  public OperationCallable<UpdateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      updateIpamAdminScopeOperationCallable() {
    return updateIpamAdminScopeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteIpamAdminScopeRequest, Operation> deleteIpamAdminScopeCallable() {
    return deleteIpamAdminScopeCallable;
  }

  @Override
  public OperationCallable<DeleteIpamAdminScopeRequest, Empty, OperationMetadata>
      deleteIpamAdminScopeOperationCallable() {
    return deleteIpamAdminScopeOperationCallable;
  }

  @Override
  public UnaryCallable<DisableIpamAdminScopeRequest, Operation> disableIpamAdminScopeCallable() {
    return disableIpamAdminScopeCallable;
  }

  @Override
  public OperationCallable<DisableIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      disableIpamAdminScopeOperationCallable() {
    return disableIpamAdminScopeOperationCallable;
  }

  @Override
  public UnaryCallable<CleanupIpamAdminScopeRequest, Operation> cleanupIpamAdminScopeCallable() {
    return cleanupIpamAdminScopeCallable;
  }

  @Override
  public OperationCallable<CleanupIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      cleanupIpamAdminScopeOperationCallable() {
    return cleanupIpamAdminScopeOperationCallable;
  }

  @Override
  public UnaryCallable<ListRegistryBooksRequest, ListRegistryBooksResponse>
      listRegistryBooksCallable() {
    return listRegistryBooksCallable;
  }

  @Override
  public UnaryCallable<ListRegistryBooksRequest, ListRegistryBooksPagedResponse>
      listRegistryBooksPagedCallable() {
    return listRegistryBooksPagedCallable;
  }

  @Override
  public UnaryCallable<GetRegistryBookRequest, RegistryBook> getRegistryBookCallable() {
    return getRegistryBookCallable;
  }

  @Override
  public UnaryCallable<SearchIpResourcesRequest, SearchIpResourcesResponse>
      searchIpResourcesCallable() {
    return searchIpResourcesCallable;
  }

  @Override
  public UnaryCallable<SearchIpResourcesRequest, SearchIpResourcesPagedResponse>
      searchIpResourcesPagedCallable() {
    return searchIpResourcesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateRegistryBookRequest, Operation> createRegistryBookCallable() {
    return createRegistryBookCallable;
  }

  @Override
  public OperationCallable<CreateRegistryBookRequest, RegistryBook, OperationMetadata>
      createRegistryBookOperationCallable() {
    return createRegistryBookOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateRegistryBookRequest, Operation> updateRegistryBookCallable() {
    return updateRegistryBookCallable;
  }

  @Override
  public OperationCallable<UpdateRegistryBookRequest, RegistryBook, OperationMetadata>
      updateRegistryBookOperationCallable() {
    return updateRegistryBookOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRegistryBookRequest, Operation> deleteRegistryBookCallable() {
    return deleteRegistryBookCallable;
  }

  @Override
  public OperationCallable<DeleteRegistryBookRequest, Empty, OperationMetadata>
      deleteRegistryBookOperationCallable() {
    return deleteRegistryBookOperationCallable;
  }

  @Override
  public UnaryCallable<ListRealmsRequest, ListRealmsResponse> listRealmsCallable() {
    return listRealmsCallable;
  }

  @Override
  public UnaryCallable<ListRealmsRequest, ListRealmsPagedResponse> listRealmsPagedCallable() {
    return listRealmsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRealmRequest, Realm> getRealmCallable() {
    return getRealmCallable;
  }

  @Override
  public UnaryCallable<CreateRealmRequest, Operation> createRealmCallable() {
    return createRealmCallable;
  }

  @Override
  public OperationCallable<CreateRealmRequest, Realm, OperationMetadata>
      createRealmOperationCallable() {
    return createRealmOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateRealmRequest, Operation> updateRealmCallable() {
    return updateRealmCallable;
  }

  @Override
  public OperationCallable<UpdateRealmRequest, Realm, OperationMetadata>
      updateRealmOperationCallable() {
    return updateRealmOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRealmRequest, Operation> deleteRealmCallable() {
    return deleteRealmCallable;
  }

  @Override
  public OperationCallable<DeleteRealmRequest, Empty, OperationMetadata>
      deleteRealmOperationCallable() {
    return deleteRealmOperationCallable;
  }

  @Override
  public UnaryCallable<ListDiscoveredRangesRequest, ListDiscoveredRangesResponse>
      listDiscoveredRangesCallable() {
    return listDiscoveredRangesCallable;
  }

  @Override
  public UnaryCallable<ListDiscoveredRangesRequest, ListDiscoveredRangesPagedResponse>
      listDiscoveredRangesPagedCallable() {
    return listDiscoveredRangesPagedCallable;
  }

  @Override
  public UnaryCallable<GetDiscoveredRangeRequest, DiscoveredRange> getDiscoveredRangeCallable() {
    return getDiscoveredRangeCallable;
  }

  @Override
  public UnaryCallable<
          FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
      findDiscoveredRangeFreeIpRangesCallable() {
    return findDiscoveredRangeFreeIpRangesCallable;
  }

  @Override
  public UnaryCallable<ListCustomRangesRequest, ListCustomRangesResponse>
      listCustomRangesCallable() {
    return listCustomRangesCallable;
  }

  @Override
  public UnaryCallable<ListCustomRangesRequest, ListCustomRangesPagedResponse>
      listCustomRangesPagedCallable() {
    return listCustomRangesPagedCallable;
  }

  @Override
  public UnaryCallable<GetCustomRangeRequest, CustomRange> getCustomRangeCallable() {
    return getCustomRangeCallable;
  }

  @Override
  public UnaryCallable<ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>
      showCustomRangeUtilizationCallable() {
    return showCustomRangeUtilizationCallable;
  }

  @Override
  public UnaryCallable<
          ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
      showDiscoveredRangeUtilizationCallable() {
    return showDiscoveredRangeUtilizationCallable;
  }

  @Override
  public UnaryCallable<FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>
      findCustomRangeFreeIpRangesCallable() {
    return findCustomRangeFreeIpRangesCallable;
  }

  @Override
  public UnaryCallable<CreateCustomRangeRequest, Operation> createCustomRangeCallable() {
    return createCustomRangeCallable;
  }

  @Override
  public OperationCallable<CreateCustomRangeRequest, CustomRange, OperationMetadata>
      createCustomRangeOperationCallable() {
    return createCustomRangeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateCustomRangeRequest, Operation> updateCustomRangeCallable() {
    return updateCustomRangeCallable;
  }

  @Override
  public OperationCallable<UpdateCustomRangeRequest, CustomRange, OperationMetadata>
      updateCustomRangeOperationCallable() {
    return updateCustomRangeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCustomRangeRequest, Operation> deleteCustomRangeCallable() {
    return deleteCustomRangeCallable;
  }

  @Override
  public OperationCallable<DeleteCustomRangeRequest, Empty, OperationMetadata>
      deleteCustomRangeOperationCallable() {
    return deleteCustomRangeOperationCallable;
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
