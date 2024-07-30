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

import com.google.api.HttpRule;
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
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the PrivilegedAccessManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonPrivilegedAccessManagerStub extends PrivilegedAccessManagerStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(OperationMetadata.getDescriptor())
          .add(Grant.getDescriptor())
          .add(Entitlement.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>
      checkOnboardingStatusMethodDescriptor =
          ApiMethodDescriptor
              .<CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/CheckOnboardingStatus")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CheckOnboardingStatusRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}:checkOnboardingStatus",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CheckOnboardingStatusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=organizations/*/locations/*}:checkOnboardingStatus",
                          "/v1/{parent=folders/*/locations/*}:checkOnboardingStatus")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CheckOnboardingStatusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CheckOnboardingStatusResponse>newBuilder()
                      .setDefaultInstance(CheckOnboardingStatusResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsMethodDescriptor =
          ApiMethodDescriptor.<ListEntitlementsRequest, ListEntitlementsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/ListEntitlements")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEntitlementsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/entitlements",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntitlementsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=organizations/*/locations/*}/entitlements",
                          "/v1/{parent=folders/*/locations/*}/entitlements")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntitlementsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListEntitlementsResponse>newBuilder()
                      .setDefaultInstance(ListEntitlementsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchEntitlementsRequest, SearchEntitlementsResponse>
      searchEntitlementsMethodDescriptor =
          ApiMethodDescriptor.<SearchEntitlementsRequest, SearchEntitlementsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/SearchEntitlements")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchEntitlementsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/entitlements:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchEntitlementsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=organizations/*/locations/*}/entitlements:search",
                          "/v1/{parent=folders/*/locations/*}/entitlements:search")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchEntitlementsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "callerAccessType", request.getCallerAccessTypeValue());
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchEntitlementsResponse>newBuilder()
                      .setDefaultInstance(SearchEntitlementsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEntitlementRequest, Entitlement>
      getEntitlementMethodDescriptor =
          ApiMethodDescriptor.<GetEntitlementRequest, Entitlement>newBuilder()
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/GetEntitlement")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEntitlementRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entitlements/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=organizations/*/locations/*/entitlements/*}",
                          "/v1/{name=folders/*/locations/*/entitlements/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Entitlement>newBuilder()
                      .setDefaultInstance(Entitlement.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateEntitlementRequest, Operation>
      createEntitlementMethodDescriptor =
          ApiMethodDescriptor.<CreateEntitlementRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/CreateEntitlement")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEntitlementRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/entitlements",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=organizations/*/locations/*}/entitlements",
                          "/v1/{parent=folders/*/locations/*}/entitlements")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "entitlementId", request.getEntitlementId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("entitlement", request.getEntitlement(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateEntitlementRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteEntitlementRequest, Operation>
      deleteEntitlementMethodDescriptor =
          ApiMethodDescriptor.<DeleteEntitlementRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/DeleteEntitlement")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEntitlementRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entitlements/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=organizations/*/locations/*/entitlements/*}",
                          "/v1/{name=folders/*/locations/*/entitlements/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEntitlementRequest> serializer =
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
                  (DeleteEntitlementRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateEntitlementRequest, Operation>
      updateEntitlementMethodDescriptor =
          ApiMethodDescriptor.<UpdateEntitlementRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/UpdateEntitlement")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEntitlementRequest>newBuilder()
                      .setPath(
                          "/v1/{entitlement.name=projects/*/locations/*/entitlements/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "entitlement.name", request.getEntitlement().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{entitlement.name=organizations/*/locations/*/entitlements/*}",
                          "/v1/{entitlement.name=folders/*/locations/*/entitlements/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("entitlement", request.getEntitlement(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateEntitlementRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListGrantsRequest, ListGrantsResponse>
      listGrantsMethodDescriptor =
          ApiMethodDescriptor.<ListGrantsRequest, ListGrantsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/ListGrants")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGrantsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/entitlements/*}/grants",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGrantsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=organizations/*/locations/*/entitlements/*}/grants",
                          "/v1/{parent=folders/*/locations/*/entitlements/*}/grants")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGrantsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListGrantsResponse>newBuilder()
                      .setDefaultInstance(ListGrantsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchGrantsRequest, SearchGrantsResponse>
      searchGrantsMethodDescriptor =
          ApiMethodDescriptor.<SearchGrantsRequest, SearchGrantsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/SearchGrants")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchGrantsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/entitlements/*}/grants:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchGrantsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=organizations/*/locations/*/entitlements/*}/grants:search",
                          "/v1/{parent=folders/*/locations/*/entitlements/*}/grants:search")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchGrantsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "callerRelationship", request.getCallerRelationshipValue());
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchGrantsResponse>newBuilder()
                      .setDefaultInstance(SearchGrantsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGrantRequest, Grant> getGrantMethodDescriptor =
      ApiMethodDescriptor.<GetGrantRequest, Grant>newBuilder()
          .setFullMethodName(
              "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/GetGrant")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetGrantRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/entitlements/*/grants/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetGrantRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths(
                      "/v1/{name=organizations/*/locations/*/entitlements/*/grants/*}",
                      "/v1/{name=folders/*/locations/*/entitlements/*/grants/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetGrantRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Grant>newBuilder()
                  .setDefaultInstance(Grant.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateGrantRequest, Grant> createGrantMethodDescriptor =
      ApiMethodDescriptor.<CreateGrantRequest, Grant>newBuilder()
          .setFullMethodName(
              "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/CreateGrant")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateGrantRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*/entitlements/*}/grants",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateGrantRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setAdditionalPaths(
                      "/v1/{parent=organizations/*/locations/*/entitlements/*}/grants",
                      "/v1/{parent=folders/*/locations/*/entitlements/*}/grants")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateGrantRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("grant", request.getGrant(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Grant>newBuilder()
                  .setDefaultInstance(Grant.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ApproveGrantRequest, Grant>
      approveGrantMethodDescriptor =
          ApiMethodDescriptor.<ApproveGrantRequest, Grant>newBuilder()
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/ApproveGrant")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ApproveGrantRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entitlements/*/grants/*}:approve",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ApproveGrantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=organizations/*/locations/*/entitlements/*/grants/*}:approve",
                          "/v1/{name=folders/*/locations/*/entitlements/*/grants/*}:approve")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ApproveGrantRequest> serializer =
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
                  ProtoMessageResponseParser.<Grant>newBuilder()
                      .setDefaultInstance(Grant.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DenyGrantRequest, Grant> denyGrantMethodDescriptor =
      ApiMethodDescriptor.<DenyGrantRequest, Grant>newBuilder()
          .setFullMethodName(
              "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/DenyGrant")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DenyGrantRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/entitlements/*/grants/*}:deny",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DenyGrantRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths(
                      "/v1/{name=organizations/*/locations/*/entitlements/*/grants/*}:deny",
                      "/v1/{name=folders/*/locations/*/entitlements/*/grants/*}:deny")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DenyGrantRequest> serializer =
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
              ProtoMessageResponseParser.<Grant>newBuilder()
                  .setDefaultInstance(Grant.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<RevokeGrantRequest, Operation>
      revokeGrantMethodDescriptor =
          ApiMethodDescriptor.<RevokeGrantRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManager/RevokeGrant")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RevokeGrantRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entitlements/*/grants/*}:revoke",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RevokeGrantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=organizations/*/locations/*/entitlements/*/grants/*}:revoke",
                          "/v1/{name=folders/*/locations/*/entitlements/*/grants/*}:revoke")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RevokeGrantRequest> serializer =
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
                  (RevokeGrantRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=organizations/*}/locations", "/v1/{name=folders/*}/locations")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=organizations/*/locations/*}",
                          "/v1/{name=folders/*/locations/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPrivilegedAccessManagerStub create(
      PrivilegedAccessManagerStubSettings settings) throws IOException {
    return new HttpJsonPrivilegedAccessManagerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPrivilegedAccessManagerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPrivilegedAccessManagerStub(
        PrivilegedAccessManagerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPrivilegedAccessManagerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPrivilegedAccessManagerStub(
        PrivilegedAccessManagerStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPrivilegedAccessManagerStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPrivilegedAccessManagerStub(
      PrivilegedAccessManagerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonPrivilegedAccessManagerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPrivilegedAccessManagerStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPrivilegedAccessManagerStub(
      PrivilegedAccessManagerStubSettings settings,
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
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setDelete("/v1/{name=organizations/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setDelete("/v1/{name=folders/*/locations/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=organizations/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=folders/*/locations/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=organizations/*/locations/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=folders/*/locations/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>
        checkOnboardingStatusTransportSettings =
            HttpJsonCallSettings
                .<CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>newBuilder()
                .setMethodDescriptor(checkOnboardingStatusMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListEntitlementsRequest, ListEntitlementsResponse>
        listEntitlementsTransportSettings =
            HttpJsonCallSettings.<ListEntitlementsRequest, ListEntitlementsResponse>newBuilder()
                .setMethodDescriptor(listEntitlementsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SearchEntitlementsRequest, SearchEntitlementsResponse>
        searchEntitlementsTransportSettings =
            HttpJsonCallSettings.<SearchEntitlementsRequest, SearchEntitlementsResponse>newBuilder()
                .setMethodDescriptor(searchEntitlementsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetEntitlementRequest, Entitlement> getEntitlementTransportSettings =
        HttpJsonCallSettings.<GetEntitlementRequest, Entitlement>newBuilder()
            .setMethodDescriptor(getEntitlementMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateEntitlementRequest, Operation> createEntitlementTransportSettings =
        HttpJsonCallSettings.<CreateEntitlementRequest, Operation>newBuilder()
            .setMethodDescriptor(createEntitlementMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteEntitlementRequest, Operation> deleteEntitlementTransportSettings =
        HttpJsonCallSettings.<DeleteEntitlementRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEntitlementMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateEntitlementRequest, Operation> updateEntitlementTransportSettings =
        HttpJsonCallSettings.<UpdateEntitlementRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEntitlementMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "entitlement.name", String.valueOf(request.getEntitlement().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListGrantsRequest, ListGrantsResponse> listGrantsTransportSettings =
        HttpJsonCallSettings.<ListGrantsRequest, ListGrantsResponse>newBuilder()
            .setMethodDescriptor(listGrantsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SearchGrantsRequest, SearchGrantsResponse> searchGrantsTransportSettings =
        HttpJsonCallSettings.<SearchGrantsRequest, SearchGrantsResponse>newBuilder()
            .setMethodDescriptor(searchGrantsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetGrantRequest, Grant> getGrantTransportSettings =
        HttpJsonCallSettings.<GetGrantRequest, Grant>newBuilder()
            .setMethodDescriptor(getGrantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateGrantRequest, Grant> createGrantTransportSettings =
        HttpJsonCallSettings.<CreateGrantRequest, Grant>newBuilder()
            .setMethodDescriptor(createGrantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ApproveGrantRequest, Grant> approveGrantTransportSettings =
        HttpJsonCallSettings.<ApproveGrantRequest, Grant>newBuilder()
            .setMethodDescriptor(approveGrantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DenyGrantRequest, Grant> denyGrantTransportSettings =
        HttpJsonCallSettings.<DenyGrantRequest, Grant>newBuilder()
            .setMethodDescriptor(denyGrantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RevokeGrantRequest, Operation> revokeGrantTransportSettings =
        HttpJsonCallSettings.<RevokeGrantRequest, Operation>newBuilder()
            .setMethodDescriptor(revokeGrantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(checkOnboardingStatusMethodDescriptor);
    methodDescriptors.add(listEntitlementsMethodDescriptor);
    methodDescriptors.add(searchEntitlementsMethodDescriptor);
    methodDescriptors.add(getEntitlementMethodDescriptor);
    methodDescriptors.add(createEntitlementMethodDescriptor);
    methodDescriptors.add(deleteEntitlementMethodDescriptor);
    methodDescriptors.add(updateEntitlementMethodDescriptor);
    methodDescriptors.add(listGrantsMethodDescriptor);
    methodDescriptors.add(searchGrantsMethodDescriptor);
    methodDescriptors.add(getGrantMethodDescriptor);
    methodDescriptors.add(createGrantMethodDescriptor);
    methodDescriptors.add(approveGrantMethodDescriptor);
    methodDescriptors.add(denyGrantMethodDescriptor);
    methodDescriptors.add(revokeGrantMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
