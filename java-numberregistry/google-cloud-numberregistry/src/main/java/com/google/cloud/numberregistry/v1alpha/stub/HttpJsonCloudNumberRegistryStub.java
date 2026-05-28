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

import com.google.api.HttpRule;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
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
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the CloudNumberRegistry service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonCloudNumberRegistryStub extends CloudNumberRegistryStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(Realm.getDescriptor())
          .add(RegistryBook.getDescriptor())
          .add(IpamAdminScope.getDescriptor())
          .add(CustomRange.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse>
      listIpamAdminScopesMethodDescriptor =
          ApiMethodDescriptor.<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/ListIpamAdminScopes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListIpamAdminScopesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/ipamAdminScopes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListIpamAdminScopesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListIpamAdminScopesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListIpamAdminScopesResponse>newBuilder()
                      .setDefaultInstance(ListIpamAdminScopesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIpamAdminScopeRequest, IpamAdminScope>
      getIpamAdminScopeMethodDescriptor =
          ApiMethodDescriptor.<GetIpamAdminScopeRequest, IpamAdminScope>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/GetIpamAdminScope")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIpamAdminScopeRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/ipamAdminScopes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIpamAdminScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIpamAdminScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IpamAdminScope>newBuilder()
                      .setDefaultInstance(IpamAdminScope.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
      checkAvailabilityIpamAdminScopesMethodDescriptor =
          ApiMethodDescriptor
              .<CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/CheckAvailabilityIpamAdminScopes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CheckAvailabilityIpamAdminScopesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/ipamAdminScopes:checkAvailability",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CheckAvailabilityIpamAdminScopesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CheckAvailabilityIpamAdminScopesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "scopes", request.getScopesList());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CheckAvailabilityIpamAdminScopesResponse>newBuilder()
                      .setDefaultInstance(
                          CheckAvailabilityIpamAdminScopesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateIpamAdminScopeRequest, Operation>
      createIpamAdminScopeMethodDescriptor =
          ApiMethodDescriptor.<CreateIpamAdminScopeRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/CreateIpamAdminScope")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateIpamAdminScopeRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/ipamAdminScopes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIpamAdminScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIpamAdminScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "ipamAdminScopeId", request.getIpamAdminScopeId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("ipamAdminScope", request.getIpamAdminScope(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateIpamAdminScopeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateIpamAdminScopeRequest, Operation>
      updateIpamAdminScopeMethodDescriptor =
          ApiMethodDescriptor.<UpdateIpamAdminScopeRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/UpdateIpamAdminScope")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateIpamAdminScopeRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{ipamAdminScope.name=projects/*/locations/*/ipamAdminScopes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIpamAdminScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "ipamAdminScope.name",
                                request.getIpamAdminScope().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIpamAdminScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("ipamAdminScope", request.getIpamAdminScope(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateIpamAdminScopeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteIpamAdminScopeRequest, Operation>
      deleteIpamAdminScopeMethodDescriptor =
          ApiMethodDescriptor.<DeleteIpamAdminScopeRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/DeleteIpamAdminScope")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteIpamAdminScopeRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/ipamAdminScopes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIpamAdminScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIpamAdminScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteIpamAdminScopeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DisableIpamAdminScopeRequest, Operation>
      disableIpamAdminScopeMethodDescriptor =
          ApiMethodDescriptor.<DisableIpamAdminScopeRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/DisableIpamAdminScope")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DisableIpamAdminScopeRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/ipamAdminScopes/*}:disable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DisableIpamAdminScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DisableIpamAdminScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DisableIpamAdminScopeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CleanupIpamAdminScopeRequest, Operation>
      cleanupIpamAdminScopeMethodDescriptor =
          ApiMethodDescriptor.<CleanupIpamAdminScopeRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/CleanupIpamAdminScope")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CleanupIpamAdminScopeRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/ipamAdminScopes/*}:cleanup",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CleanupIpamAdminScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CleanupIpamAdminScopeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CleanupIpamAdminScopeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListRegistryBooksRequest, ListRegistryBooksResponse>
      listRegistryBooksMethodDescriptor =
          ApiMethodDescriptor.<ListRegistryBooksRequest, ListRegistryBooksResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/ListRegistryBooks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegistryBooksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/registryBooks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegistryBooksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegistryBooksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRegistryBooksResponse>newBuilder()
                      .setDefaultInstance(ListRegistryBooksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRegistryBookRequest, RegistryBook>
      getRegistryBookMethodDescriptor =
          ApiMethodDescriptor.<GetRegistryBookRequest, RegistryBook>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/GetRegistryBook")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegistryBookRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/registryBooks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegistryBookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegistryBookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RegistryBook>newBuilder()
                      .setDefaultInstance(RegistryBook.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchIpResourcesRequest, SearchIpResourcesResponse>
      searchIpResourcesMethodDescriptor =
          ApiMethodDescriptor.<SearchIpResourcesRequest, SearchIpResourcesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/SearchIpResources")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchIpResourcesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/registryBooks/*}:searchIpResources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchIpResourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchIpResourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchIpResourcesResponse>newBuilder()
                      .setDefaultInstance(SearchIpResourcesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateRegistryBookRequest, Operation>
      createRegistryBookMethodDescriptor =
          ApiMethodDescriptor.<CreateRegistryBookRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/CreateRegistryBook")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRegistryBookRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/registryBooks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRegistryBookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRegistryBookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "registryBookId", request.getRegistryBookId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("registryBook", request.getRegistryBook(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateRegistryBookRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateRegistryBookRequest, Operation>
      updateRegistryBookMethodDescriptor =
          ApiMethodDescriptor.<UpdateRegistryBookRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/UpdateRegistryBook")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRegistryBookRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{registryBook.name=projects/*/locations/*/registryBooks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRegistryBookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "registryBook.name", request.getRegistryBook().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRegistryBookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("registryBook", request.getRegistryBook(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateRegistryBookRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteRegistryBookRequest, Operation>
      deleteRegistryBookMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegistryBookRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/DeleteRegistryBook")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegistryBookRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/registryBooks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegistryBookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegistryBookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteRegistryBookRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListRealmsRequest, ListRealmsResponse>
      listRealmsMethodDescriptor =
          ApiMethodDescriptor.<ListRealmsRequest, ListRealmsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/ListRealms")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRealmsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/realms",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRealmsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRealmsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRealmsResponse>newBuilder()
                      .setDefaultInstance(ListRealmsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRealmRequest, Realm> getRealmMethodDescriptor =
      ApiMethodDescriptor.<GetRealmRequest, Realm>newBuilder()
          .setFullMethodName("google.cloud.numberregistry.v1alpha.CloudNumberRegistry/GetRealm")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRealmRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/locations/*/realms/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetRealmRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetRealmRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "view", request.getViewValue());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Realm>newBuilder()
                  .setDefaultInstance(Realm.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateRealmRequest, Operation>
      createRealmMethodDescriptor =
          ApiMethodDescriptor.<CreateRealmRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/CreateRealm")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRealmRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/realms",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRealmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRealmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "realmId", request.getRealmId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("realm", request.getRealm(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateRealmRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateRealmRequest, Operation>
      updateRealmMethodDescriptor =
          ApiMethodDescriptor.<UpdateRealmRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/UpdateRealm")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRealmRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{realm.name=projects/*/locations/*/realms/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRealmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "realm.name", request.getRealm().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRealmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("realm", request.getRealm(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateRealmRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteRealmRequest, Operation>
      deleteRealmMethodDescriptor =
          ApiMethodDescriptor.<DeleteRealmRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/DeleteRealm")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRealmRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/realms/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRealmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRealmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteRealmRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListDiscoveredRangesRequest, ListDiscoveredRangesResponse>
      listDiscoveredRangesMethodDescriptor =
          ApiMethodDescriptor
              .<ListDiscoveredRangesRequest, ListDiscoveredRangesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/ListDiscoveredRanges")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDiscoveredRangesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/discoveredRanges",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDiscoveredRangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDiscoveredRangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDiscoveredRangesResponse>newBuilder()
                      .setDefaultInstance(ListDiscoveredRangesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDiscoveredRangeRequest, DiscoveredRange>
      getDiscoveredRangeMethodDescriptor =
          ApiMethodDescriptor.<GetDiscoveredRangeRequest, DiscoveredRange>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/GetDiscoveredRange")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDiscoveredRangeRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/discoveredRanges/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDiscoveredRangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDiscoveredRangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DiscoveredRange>newBuilder()
                      .setDefaultInstance(DiscoveredRange.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
      findDiscoveredRangeFreeIpRangesMethodDescriptor =
          ApiMethodDescriptor
              .<FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/FindDiscoveredRangeFreeIpRanges")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FindDiscoveredRangeFreeIpRangesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/discoveredRanges/*}:findFreeIpRanges",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FindDiscoveredRangeFreeIpRangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FindDiscoveredRangeFreeIpRangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "cidrPrefixLength", request.getCidrPrefixLength());
                            serializer.putQueryParam(fields, "rangeCount", request.getRangeCount());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FindDiscoveredRangeFreeIpRangesResponse>newBuilder()
                      .setDefaultInstance(
                          FindDiscoveredRangeFreeIpRangesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCustomRangesRequest, ListCustomRangesResponse>
      listCustomRangesMethodDescriptor =
          ApiMethodDescriptor.<ListCustomRangesRequest, ListCustomRangesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/ListCustomRanges")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCustomRangesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/customRanges",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomRangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomRangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCustomRangesResponse>newBuilder()
                      .setDefaultInstance(ListCustomRangesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCustomRangeRequest, CustomRange>
      getCustomRangeMethodDescriptor =
          ApiMethodDescriptor.<GetCustomRangeRequest, CustomRange>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/GetCustomRange")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCustomRangeRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/customRanges/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomRangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomRangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomRange>newBuilder()
                      .setDefaultInstance(CustomRange.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>
      showCustomRangeUtilizationMethodDescriptor =
          ApiMethodDescriptor
              .<ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/ShowCustomRangeUtilization")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ShowCustomRangeUtilizationRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/customRanges/*}:showUtilization",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ShowCustomRangeUtilizationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ShowCustomRangeUtilizationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ShowCustomRangeUtilizationResponse>newBuilder()
                      .setDefaultInstance(ShowCustomRangeUtilizationResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
      showDiscoveredRangeUtilizationMethodDescriptor =
          ApiMethodDescriptor
              .<ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/ShowDiscoveredRangeUtilization")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ShowDiscoveredRangeUtilizationRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/discoveredRanges/*}:showUtilization",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ShowDiscoveredRangeUtilizationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ShowDiscoveredRangeUtilizationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ShowDiscoveredRangeUtilizationResponse>newBuilder()
                      .setDefaultInstance(
                          ShowDiscoveredRangeUtilizationResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>
      findCustomRangeFreeIpRangesMethodDescriptor =
          ApiMethodDescriptor
              .<FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/FindCustomRangeFreeIpRanges")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FindCustomRangeFreeIpRangesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/customRanges/*}:findFreeIpRanges",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FindCustomRangeFreeIpRangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FindCustomRangeFreeIpRangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "cidrPrefixLength", request.getCidrPrefixLength());
                            serializer.putQueryParam(fields, "rangeCount", request.getRangeCount());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FindCustomRangeFreeIpRangesResponse>newBuilder()
                      .setDefaultInstance(FindCustomRangeFreeIpRangesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCustomRangeRequest, Operation>
      createCustomRangeMethodDescriptor =
          ApiMethodDescriptor.<CreateCustomRangeRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/CreateCustomRange")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCustomRangeRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/customRanges",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomRangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomRangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "customRangeId", request.getCustomRangeId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customRange", request.getCustomRange(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateCustomRangeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateCustomRangeRequest, Operation>
      updateCustomRangeMethodDescriptor =
          ApiMethodDescriptor.<UpdateCustomRangeRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/UpdateCustomRange")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCustomRangeRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{customRange.name=projects/*/locations/*/customRanges/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomRangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "customRange.name", request.getCustomRange().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomRangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customRange", request.getCustomRange(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateCustomRangeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteCustomRangeRequest, Operation>
      deleteCustomRangeMethodDescriptor =
          ApiMethodDescriptor.<DeleteCustomRangeRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.numberregistry.v1alpha.CloudNumberRegistry/DeleteCustomRange")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCustomRangeRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/customRanges/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCustomRangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCustomRangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteCustomRangeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCloudNumberRegistryStub create(
      CloudNumberRegistryStubSettings settings) throws IOException {
    return new HttpJsonCloudNumberRegistryStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCloudNumberRegistryStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCloudNumberRegistryStub(
        CloudNumberRegistryStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCloudNumberRegistryStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCloudNumberRegistryStub(
        CloudNumberRegistryStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCloudNumberRegistryStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCloudNumberRegistryStub(
      CloudNumberRegistryStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCloudNumberRegistryCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCloudNumberRegistryStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCloudNumberRegistryStub(
      CloudNumberRegistryStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1alpha/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1alpha/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1alpha/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1alpha/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse>
        listIpamAdminScopesTransportSettings =
            HttpJsonCallSettings
                .<ListIpamAdminScopesRequest, ListIpamAdminScopesResponse>newBuilder()
                .setMethodDescriptor(listIpamAdminScopesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetIpamAdminScopeRequest, IpamAdminScope>
        getIpamAdminScopeTransportSettings =
            HttpJsonCallSettings.<GetIpamAdminScopeRequest, IpamAdminScope>newBuilder()
                .setMethodDescriptor(getIpamAdminScopeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<
            CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
        checkAvailabilityIpamAdminScopesTransportSettings =
            HttpJsonCallSettings
                .<CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
                    newBuilder()
                .setMethodDescriptor(checkAvailabilityIpamAdminScopesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateIpamAdminScopeRequest, Operation>
        createIpamAdminScopeTransportSettings =
            HttpJsonCallSettings.<CreateIpamAdminScopeRequest, Operation>newBuilder()
                .setMethodDescriptor(createIpamAdminScopeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateIpamAdminScopeRequest, Operation>
        updateIpamAdminScopeTransportSettings =
            HttpJsonCallSettings.<UpdateIpamAdminScopeRequest, Operation>newBuilder()
                .setMethodDescriptor(updateIpamAdminScopeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "ipam_admin_scope.name",
                          String.valueOf(request.getIpamAdminScope().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteIpamAdminScopeRequest, Operation>
        deleteIpamAdminScopeTransportSettings =
            HttpJsonCallSettings.<DeleteIpamAdminScopeRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteIpamAdminScopeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<DisableIpamAdminScopeRequest, Operation>
        disableIpamAdminScopeTransportSettings =
            HttpJsonCallSettings.<DisableIpamAdminScopeRequest, Operation>newBuilder()
                .setMethodDescriptor(disableIpamAdminScopeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<CleanupIpamAdminScopeRequest, Operation>
        cleanupIpamAdminScopeTransportSettings =
            HttpJsonCallSettings.<CleanupIpamAdminScopeRequest, Operation>newBuilder()
                .setMethodDescriptor(cleanupIpamAdminScopeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListRegistryBooksRequest, ListRegistryBooksResponse>
        listRegistryBooksTransportSettings =
            HttpJsonCallSettings.<ListRegistryBooksRequest, ListRegistryBooksResponse>newBuilder()
                .setMethodDescriptor(listRegistryBooksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetRegistryBookRequest, RegistryBook> getRegistryBookTransportSettings =
        HttpJsonCallSettings.<GetRegistryBookRequest, RegistryBook>newBuilder()
            .setMethodDescriptor(getRegistryBookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<SearchIpResourcesRequest, SearchIpResourcesResponse>
        searchIpResourcesTransportSettings =
            HttpJsonCallSettings.<SearchIpResourcesRequest, SearchIpResourcesResponse>newBuilder()
                .setMethodDescriptor(searchIpResourcesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<CreateRegistryBookRequest, Operation> createRegistryBookTransportSettings =
        HttpJsonCallSettings.<CreateRegistryBookRequest, Operation>newBuilder()
            .setMethodDescriptor(createRegistryBookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateRegistryBookRequest, Operation> updateRegistryBookTransportSettings =
        HttpJsonCallSettings.<UpdateRegistryBookRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRegistryBookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "registry_book.name", String.valueOf(request.getRegistryBook().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteRegistryBookRequest, Operation> deleteRegistryBookTransportSettings =
        HttpJsonCallSettings.<DeleteRegistryBookRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRegistryBookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListRealmsRequest, ListRealmsResponse> listRealmsTransportSettings =
        HttpJsonCallSettings.<ListRealmsRequest, ListRealmsResponse>newBuilder()
            .setMethodDescriptor(listRealmsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetRealmRequest, Realm> getRealmTransportSettings =
        HttpJsonCallSettings.<GetRealmRequest, Realm>newBuilder()
            .setMethodDescriptor(getRealmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<CreateRealmRequest, Operation> createRealmTransportSettings =
        HttpJsonCallSettings.<CreateRealmRequest, Operation>newBuilder()
            .setMethodDescriptor(createRealmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateRealmRequest, Operation> updateRealmTransportSettings =
        HttpJsonCallSettings.<UpdateRealmRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRealmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("realm.name", String.valueOf(request.getRealm().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteRealmRequest, Operation> deleteRealmTransportSettings =
        HttpJsonCallSettings.<DeleteRealmRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRealmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListDiscoveredRangesRequest, ListDiscoveredRangesResponse>
        listDiscoveredRangesTransportSettings =
            HttpJsonCallSettings
                .<ListDiscoveredRangesRequest, ListDiscoveredRangesResponse>newBuilder()
                .setMethodDescriptor(listDiscoveredRangesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetDiscoveredRangeRequest, DiscoveredRange>
        getDiscoveredRangeTransportSettings =
            HttpJsonCallSettings.<GetDiscoveredRangeRequest, DiscoveredRange>newBuilder()
                .setMethodDescriptor(getDiscoveredRangeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<
            FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
        findDiscoveredRangeFreeIpRangesTransportSettings =
            HttpJsonCallSettings
                .<FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
                    newBuilder()
                .setMethodDescriptor(findDiscoveredRangeFreeIpRangesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListCustomRangesRequest, ListCustomRangesResponse>
        listCustomRangesTransportSettings =
            HttpJsonCallSettings.<ListCustomRangesRequest, ListCustomRangesResponse>newBuilder()
                .setMethodDescriptor(listCustomRangesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetCustomRangeRequest, CustomRange> getCustomRangeTransportSettings =
        HttpJsonCallSettings.<GetCustomRangeRequest, CustomRange>newBuilder()
            .setMethodDescriptor(getCustomRangeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>
        showCustomRangeUtilizationTransportSettings =
            HttpJsonCallSettings
                .<ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>newBuilder()
                .setMethodDescriptor(showCustomRangeUtilizationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<
            ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
        showDiscoveredRangeUtilizationTransportSettings =
            HttpJsonCallSettings
                .<ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
                    newBuilder()
                .setMethodDescriptor(showDiscoveredRangeUtilizationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>
        findCustomRangeFreeIpRangesTransportSettings =
            HttpJsonCallSettings
                .<FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>
                    newBuilder()
                .setMethodDescriptor(findCustomRangeFreeIpRangesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<CreateCustomRangeRequest, Operation> createCustomRangeTransportSettings =
        HttpJsonCallSettings.<CreateCustomRangeRequest, Operation>newBuilder()
            .setMethodDescriptor(createCustomRangeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateCustomRangeRequest, Operation> updateCustomRangeTransportSettings =
        HttpJsonCallSettings.<UpdateCustomRangeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateCustomRangeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "custom_range.name", String.valueOf(request.getCustomRange().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteCustomRangeRequest, Operation> deleteCustomRangeTransportSettings =
        HttpJsonCallSettings.<DeleteCustomRangeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCustomRangeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.updateRealmCallable =
        callableFactory.createUnaryCallable(
            updateRealmTransportSettings, settings.updateRealmSettings(), clientContext);
    this.updateRealmOperationCallable =
        callableFactory.createOperationCallable(
            updateRealmTransportSettings,
            settings.updateRealmOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteRealmCallable =
        callableFactory.createUnaryCallable(
            deleteRealmTransportSettings, settings.deleteRealmSettings(), clientContext);
    this.deleteRealmOperationCallable =
        callableFactory.createOperationCallable(
            deleteRealmTransportSettings,
            settings.deleteRealmOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listIpamAdminScopesMethodDescriptor);
    methodDescriptors.add(getIpamAdminScopeMethodDescriptor);
    methodDescriptors.add(checkAvailabilityIpamAdminScopesMethodDescriptor);
    methodDescriptors.add(createIpamAdminScopeMethodDescriptor);
    methodDescriptors.add(updateIpamAdminScopeMethodDescriptor);
    methodDescriptors.add(deleteIpamAdminScopeMethodDescriptor);
    methodDescriptors.add(disableIpamAdminScopeMethodDescriptor);
    methodDescriptors.add(cleanupIpamAdminScopeMethodDescriptor);
    methodDescriptors.add(listRegistryBooksMethodDescriptor);
    methodDescriptors.add(getRegistryBookMethodDescriptor);
    methodDescriptors.add(searchIpResourcesMethodDescriptor);
    methodDescriptors.add(createRegistryBookMethodDescriptor);
    methodDescriptors.add(updateRegistryBookMethodDescriptor);
    methodDescriptors.add(deleteRegistryBookMethodDescriptor);
    methodDescriptors.add(listRealmsMethodDescriptor);
    methodDescriptors.add(getRealmMethodDescriptor);
    methodDescriptors.add(createRealmMethodDescriptor);
    methodDescriptors.add(updateRealmMethodDescriptor);
    methodDescriptors.add(deleteRealmMethodDescriptor);
    methodDescriptors.add(listDiscoveredRangesMethodDescriptor);
    methodDescriptors.add(getDiscoveredRangeMethodDescriptor);
    methodDescriptors.add(findDiscoveredRangeFreeIpRangesMethodDescriptor);
    methodDescriptors.add(listCustomRangesMethodDescriptor);
    methodDescriptors.add(getCustomRangeMethodDescriptor);
    methodDescriptors.add(showCustomRangeUtilizationMethodDescriptor);
    methodDescriptors.add(showDiscoveredRangeUtilizationMethodDescriptor);
    methodDescriptors.add(findCustomRangeFreeIpRangesMethodDescriptor);
    methodDescriptors.add(createCustomRangeMethodDescriptor);
    methodDescriptors.add(updateCustomRangeMethodDescriptor);
    methodDescriptors.add(deleteCustomRangeMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
