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
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
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
 * REST stub implementation for the SaasDeployments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSaasDeploymentsStub extends SaasDeploymentsStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListSaasRequest, ListSaasResponse>
      listSaasMethodDescriptor =
          ApiMethodDescriptor.<ListSaasRequest, ListSaasResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/ListSaas")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSaasRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/saas",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSaasRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSaasRequest> serializer =
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
                  ProtoMessageResponseParser.<ListSaasResponse>newBuilder()
                      .setDefaultInstance(ListSaasResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSaasRequest, Saas> getSaasMethodDescriptor =
      ApiMethodDescriptor.<GetSaasRequest, Saas>newBuilder()
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/GetSaas")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSaasRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=projects/*/locations/*/saas/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSaasRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSaasRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Saas>newBuilder()
                  .setDefaultInstance(Saas.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateSaasRequest, Saas> createSaasMethodDescriptor =
      ApiMethodDescriptor.<CreateSaasRequest, Saas>newBuilder()
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/CreateSaas")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateSaasRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{parent=projects/*/locations/*}/saas",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateSaasRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateSaasRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        serializer.putQueryParam(fields, "saasId", request.getSaasId());
                        serializer.putQueryParam(fields, "validateOnly", request.getValidateOnly());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("saas", request.getSaas(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Saas>newBuilder()
                  .setDefaultInstance(Saas.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateSaasRequest, Saas> updateSaasMethodDescriptor =
      ApiMethodDescriptor.<UpdateSaasRequest, Saas>newBuilder()
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/UpdateSaas")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateSaasRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{saas.name=projects/*/locations/*/saas/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateSaasRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "saas.name", request.getSaas().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateSaasRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "validateOnly", request.getValidateOnly());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("saas", request.getSaas(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Saas>newBuilder()
                  .setDefaultInstance(Saas.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteSaasRequest, Empty> deleteSaasMethodDescriptor =
      ApiMethodDescriptor.<DeleteSaasRequest, Empty>newBuilder()
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/DeleteSaas")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteSaasRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=projects/*/locations/*/saas/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteSaasRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteSaasRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "etag", request.getEtag());
                        serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        serializer.putQueryParam(fields, "validateOnly", request.getValidateOnly());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListTenantsRequest, ListTenantsResponse>
      listTenantsMethodDescriptor =
          ApiMethodDescriptor.<ListTenantsRequest, ListTenantsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/ListTenants")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTenantsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/tenants",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTenantsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTenantsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListTenantsResponse>newBuilder()
                      .setDefaultInstance(ListTenantsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTenantRequest, Tenant> getTenantMethodDescriptor =
      ApiMethodDescriptor.<GetTenantRequest, Tenant>newBuilder()
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/GetTenant")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetTenantRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=projects/*/locations/*/tenants/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetTenantRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetTenantRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Tenant>newBuilder()
                  .setDefaultInstance(Tenant.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateTenantRequest, Tenant>
      createTenantMethodDescriptor =
          ApiMethodDescriptor.<CreateTenantRequest, Tenant>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/CreateTenant")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTenantRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/tenants",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTenantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTenantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "tenantId", request.getTenantId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tenant", request.getTenant(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Tenant>newBuilder()
                      .setDefaultInstance(Tenant.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateTenantRequest, Tenant>
      updateTenantMethodDescriptor =
          ApiMethodDescriptor.<UpdateTenantRequest, Tenant>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/UpdateTenant")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTenantRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{tenant.name=projects/*/locations/*/tenants/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTenantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "tenant.name", request.getTenant().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTenantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tenant", request.getTenant(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Tenant>newBuilder()
                      .setDefaultInstance(Tenant.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteTenantRequest, Empty>
      deleteTenantMethodDescriptor =
          ApiMethodDescriptor.<DeleteTenantRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/DeleteTenant")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTenantRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/tenants/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTenantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTenantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListUnitKindsRequest, ListUnitKindsResponse>
      listUnitKindsMethodDescriptor =
          ApiMethodDescriptor.<ListUnitKindsRequest, ListUnitKindsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/ListUnitKinds")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUnitKindsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/unitKinds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUnitKindsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUnitKindsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListUnitKindsResponse>newBuilder()
                      .setDefaultInstance(ListUnitKindsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetUnitKindRequest, UnitKind>
      getUnitKindMethodDescriptor =
          ApiMethodDescriptor.<GetUnitKindRequest, UnitKind>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/GetUnitKind")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetUnitKindRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/unitKinds/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetUnitKindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetUnitKindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UnitKind>newBuilder()
                      .setDefaultInstance(UnitKind.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateUnitKindRequest, UnitKind>
      createUnitKindMethodDescriptor =
          ApiMethodDescriptor.<CreateUnitKindRequest, UnitKind>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/CreateUnitKind")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateUnitKindRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/unitKinds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUnitKindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUnitKindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "unitKindId", request.getUnitKindId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("unitKind", request.getUnitKind(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UnitKind>newBuilder()
                      .setDefaultInstance(UnitKind.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateUnitKindRequest, UnitKind>
      updateUnitKindMethodDescriptor =
          ApiMethodDescriptor.<UpdateUnitKindRequest, UnitKind>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/UpdateUnitKind")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateUnitKindRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{unitKind.name=projects/*/locations/*/unitKinds/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUnitKindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "unitKind.name", request.getUnitKind().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUnitKindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("unitKind", request.getUnitKind(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UnitKind>newBuilder()
                      .setDefaultInstance(UnitKind.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteUnitKindRequest, Empty>
      deleteUnitKindMethodDescriptor =
          ApiMethodDescriptor.<DeleteUnitKindRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/DeleteUnitKind")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteUnitKindRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/unitKinds/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUnitKindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUnitKindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListUnitsRequest, ListUnitsResponse>
      listUnitsMethodDescriptor =
          ApiMethodDescriptor.<ListUnitsRequest, ListUnitsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/ListUnits")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUnitsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/units",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUnitsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUnitsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListUnitsResponse>newBuilder()
                      .setDefaultInstance(ListUnitsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetUnitRequest, Unit> getUnitMethodDescriptor =
      ApiMethodDescriptor.<GetUnitRequest, Unit>newBuilder()
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/GetUnit")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetUnitRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=projects/*/locations/*/units/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetUnitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetUnitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Unit>newBuilder()
                  .setDefaultInstance(Unit.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateUnitRequest, Unit> createUnitMethodDescriptor =
      ApiMethodDescriptor.<CreateUnitRequest, Unit>newBuilder()
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/CreateUnit")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateUnitRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{parent=projects/*/locations/*}/units",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateUnitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateUnitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        serializer.putQueryParam(fields, "unitId", request.getUnitId());
                        serializer.putQueryParam(fields, "validateOnly", request.getValidateOnly());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("unit", request.getUnit(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Unit>newBuilder()
                  .setDefaultInstance(Unit.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateUnitRequest, Unit> updateUnitMethodDescriptor =
      ApiMethodDescriptor.<UpdateUnitRequest, Unit>newBuilder()
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/UpdateUnit")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateUnitRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{unit.name=projects/*/locations/*/units/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateUnitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "unit.name", request.getUnit().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateUnitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "validateOnly", request.getValidateOnly());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("unit", request.getUnit(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Unit>newBuilder()
                  .setDefaultInstance(Unit.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteUnitRequest, Empty> deleteUnitMethodDescriptor =
      ApiMethodDescriptor.<DeleteUnitRequest, Empty>newBuilder()
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/DeleteUnit")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteUnitRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=projects/*/locations/*/units/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteUnitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteUnitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "etag", request.getEtag());
                        serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        serializer.putQueryParam(fields, "validateOnly", request.getValidateOnly());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListUnitOperationsRequest, ListUnitOperationsResponse>
      listUnitOperationsMethodDescriptor =
          ApiMethodDescriptor.<ListUnitOperationsRequest, ListUnitOperationsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/ListUnitOperations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUnitOperationsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/unitOperations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUnitOperationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUnitOperationsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListUnitOperationsResponse>newBuilder()
                      .setDefaultInstance(ListUnitOperationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetUnitOperationRequest, UnitOperation>
      getUnitOperationMethodDescriptor =
          ApiMethodDescriptor.<GetUnitOperationRequest, UnitOperation>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/GetUnitOperation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetUnitOperationRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/unitOperations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetUnitOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetUnitOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UnitOperation>newBuilder()
                      .setDefaultInstance(UnitOperation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateUnitOperationRequest, UnitOperation>
      createUnitOperationMethodDescriptor =
          ApiMethodDescriptor.<CreateUnitOperationRequest, UnitOperation>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/CreateUnitOperation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateUnitOperationRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/unitOperations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUnitOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUnitOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "unitOperationId", request.getUnitOperationId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("unitOperation", request.getUnitOperation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UnitOperation>newBuilder()
                      .setDefaultInstance(UnitOperation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateUnitOperationRequest, UnitOperation>
      updateUnitOperationMethodDescriptor =
          ApiMethodDescriptor.<UpdateUnitOperationRequest, UnitOperation>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/UpdateUnitOperation")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateUnitOperationRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{unitOperation.name=projects/*/locations/*/unitOperations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUnitOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "unitOperation.name", request.getUnitOperation().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUnitOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("unitOperation", request.getUnitOperation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UnitOperation>newBuilder()
                      .setDefaultInstance(UnitOperation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteUnitOperationRequest, Empty>
      deleteUnitOperationMethodDescriptor =
          ApiMethodDescriptor.<DeleteUnitOperationRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/DeleteUnitOperation")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteUnitOperationRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/unitOperations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUnitOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUnitOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListReleasesRequest, ListReleasesResponse>
      listReleasesMethodDescriptor =
          ApiMethodDescriptor.<ListReleasesRequest, ListReleasesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/ListReleases")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReleasesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/releases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReleasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReleasesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListReleasesResponse>newBuilder()
                      .setDefaultInstance(ListReleasesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetReleaseRequest, Release> getReleaseMethodDescriptor =
      ApiMethodDescriptor.<GetReleaseRequest, Release>newBuilder()
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/GetRelease")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetReleaseRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=projects/*/locations/*/releases/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetReleaseRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetReleaseRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Release>newBuilder()
                  .setDefaultInstance(Release.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateReleaseRequest, Release>
      createReleaseMethodDescriptor =
          ApiMethodDescriptor.<CreateReleaseRequest, Release>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/CreateRelease")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReleaseRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/releases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReleaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReleaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "releaseId", request.getReleaseId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("release", request.getRelease(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Release>newBuilder()
                      .setDefaultInstance(Release.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateReleaseRequest, Release>
      updateReleaseMethodDescriptor =
          ApiMethodDescriptor.<UpdateReleaseRequest, Release>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/UpdateRelease")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateReleaseRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{release.name=projects/*/locations/*/releases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReleaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "release.name", request.getRelease().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReleaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("release", request.getRelease(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Release>newBuilder()
                      .setDefaultInstance(Release.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteReleaseRequest, Empty>
      deleteReleaseMethodDescriptor =
          ApiMethodDescriptor.<DeleteReleaseRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeployments/DeleteRelease")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteReleaseRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/releases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReleaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReleaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
                          "/v1beta1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
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
                          "/v1beta1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
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
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSaasDeploymentsStub create(SaasDeploymentsStubSettings settings)
      throws IOException {
    return new HttpJsonSaasDeploymentsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSaasDeploymentsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSaasDeploymentsStub(
        SaasDeploymentsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSaasDeploymentsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSaasDeploymentsStub(
        SaasDeploymentsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSaasDeploymentsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSaasDeploymentsStub(
      SaasDeploymentsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSaasDeploymentsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSaasDeploymentsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSaasDeploymentsStub(
      SaasDeploymentsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListSaasRequest, ListSaasResponse> listSaasTransportSettings =
        HttpJsonCallSettings.<ListSaasRequest, ListSaasResponse>newBuilder()
            .setMethodDescriptor(listSaasMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetSaasRequest, Saas> getSaasTransportSettings =
        HttpJsonCallSettings.<GetSaasRequest, Saas>newBuilder()
            .setMethodDescriptor(getSaasMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateSaasRequest, Saas> createSaasTransportSettings =
        HttpJsonCallSettings.<CreateSaasRequest, Saas>newBuilder()
            .setMethodDescriptor(createSaasMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSaasRequest, Saas> updateSaasTransportSettings =
        HttpJsonCallSettings.<UpdateSaasRequest, Saas>newBuilder()
            .setMethodDescriptor(updateSaasMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("saas.name", String.valueOf(request.getSaas().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSaasRequest, Empty> deleteSaasTransportSettings =
        HttpJsonCallSettings.<DeleteSaasRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSaasMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListTenantsRequest, ListTenantsResponse> listTenantsTransportSettings =
        HttpJsonCallSettings.<ListTenantsRequest, ListTenantsResponse>newBuilder()
            .setMethodDescriptor(listTenantsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetTenantRequest, Tenant> getTenantTransportSettings =
        HttpJsonCallSettings.<GetTenantRequest, Tenant>newBuilder()
            .setMethodDescriptor(getTenantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateTenantRequest, Tenant> createTenantTransportSettings =
        HttpJsonCallSettings.<CreateTenantRequest, Tenant>newBuilder()
            .setMethodDescriptor(createTenantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateTenantRequest, Tenant> updateTenantTransportSettings =
        HttpJsonCallSettings.<UpdateTenantRequest, Tenant>newBuilder()
            .setMethodDescriptor(updateTenantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("tenant.name", String.valueOf(request.getTenant().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteTenantRequest, Empty> deleteTenantTransportSettings =
        HttpJsonCallSettings.<DeleteTenantRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTenantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListUnitKindsRequest, ListUnitKindsResponse>
        listUnitKindsTransportSettings =
            HttpJsonCallSettings.<ListUnitKindsRequest, ListUnitKindsResponse>newBuilder()
                .setMethodDescriptor(listUnitKindsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetUnitKindRequest, UnitKind> getUnitKindTransportSettings =
        HttpJsonCallSettings.<GetUnitKindRequest, UnitKind>newBuilder()
            .setMethodDescriptor(getUnitKindMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateUnitKindRequest, UnitKind> createUnitKindTransportSettings =
        HttpJsonCallSettings.<CreateUnitKindRequest, UnitKind>newBuilder()
            .setMethodDescriptor(createUnitKindMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateUnitKindRequest, UnitKind> updateUnitKindTransportSettings =
        HttpJsonCallSettings.<UpdateUnitKindRequest, UnitKind>newBuilder()
            .setMethodDescriptor(updateUnitKindMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("unit_kind.name", String.valueOf(request.getUnitKind().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteUnitKindRequest, Empty> deleteUnitKindTransportSettings =
        HttpJsonCallSettings.<DeleteUnitKindRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUnitKindMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListUnitsRequest, ListUnitsResponse> listUnitsTransportSettings =
        HttpJsonCallSettings.<ListUnitsRequest, ListUnitsResponse>newBuilder()
            .setMethodDescriptor(listUnitsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetUnitRequest, Unit> getUnitTransportSettings =
        HttpJsonCallSettings.<GetUnitRequest, Unit>newBuilder()
            .setMethodDescriptor(getUnitMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateUnitRequest, Unit> createUnitTransportSettings =
        HttpJsonCallSettings.<CreateUnitRequest, Unit>newBuilder()
            .setMethodDescriptor(createUnitMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateUnitRequest, Unit> updateUnitTransportSettings =
        HttpJsonCallSettings.<UpdateUnitRequest, Unit>newBuilder()
            .setMethodDescriptor(updateUnitMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("unit.name", String.valueOf(request.getUnit().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteUnitRequest, Empty> deleteUnitTransportSettings =
        HttpJsonCallSettings.<DeleteUnitRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUnitMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListUnitOperationsRequest, ListUnitOperationsResponse>
        listUnitOperationsTransportSettings =
            HttpJsonCallSettings.<ListUnitOperationsRequest, ListUnitOperationsResponse>newBuilder()
                .setMethodDescriptor(listUnitOperationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetUnitOperationRequest, UnitOperation> getUnitOperationTransportSettings =
        HttpJsonCallSettings.<GetUnitOperationRequest, UnitOperation>newBuilder()
            .setMethodDescriptor(getUnitOperationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateUnitOperationRequest, UnitOperation>
        createUnitOperationTransportSettings =
            HttpJsonCallSettings.<CreateUnitOperationRequest, UnitOperation>newBuilder()
                .setMethodDescriptor(createUnitOperationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateUnitOperationRequest, UnitOperation>
        updateUnitOperationTransportSettings =
            HttpJsonCallSettings.<UpdateUnitOperationRequest, UnitOperation>newBuilder()
                .setMethodDescriptor(updateUnitOperationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "unit_operation.name",
                          String.valueOf(request.getUnitOperation().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteUnitOperationRequest, Empty> deleteUnitOperationTransportSettings =
        HttpJsonCallSettings.<DeleteUnitOperationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUnitOperationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListReleasesRequest, ListReleasesResponse> listReleasesTransportSettings =
        HttpJsonCallSettings.<ListReleasesRequest, ListReleasesResponse>newBuilder()
            .setMethodDescriptor(listReleasesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetReleaseRequest, Release> getReleaseTransportSettings =
        HttpJsonCallSettings.<GetReleaseRequest, Release>newBuilder()
            .setMethodDescriptor(getReleaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateReleaseRequest, Release> createReleaseTransportSettings =
        HttpJsonCallSettings.<CreateReleaseRequest, Release>newBuilder()
            .setMethodDescriptor(createReleaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateReleaseRequest, Release> updateReleaseTransportSettings =
        HttpJsonCallSettings.<UpdateReleaseRequest, Release>newBuilder()
            .setMethodDescriptor(updateReleaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("release.name", String.valueOf(request.getRelease().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteReleaseRequest, Empty> deleteReleaseTransportSettings =
        HttpJsonCallSettings.<DeleteReleaseRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteReleaseMethodDescriptor)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listSaasMethodDescriptor);
    methodDescriptors.add(getSaasMethodDescriptor);
    methodDescriptors.add(createSaasMethodDescriptor);
    methodDescriptors.add(updateSaasMethodDescriptor);
    methodDescriptors.add(deleteSaasMethodDescriptor);
    methodDescriptors.add(listTenantsMethodDescriptor);
    methodDescriptors.add(getTenantMethodDescriptor);
    methodDescriptors.add(createTenantMethodDescriptor);
    methodDescriptors.add(updateTenantMethodDescriptor);
    methodDescriptors.add(deleteTenantMethodDescriptor);
    methodDescriptors.add(listUnitKindsMethodDescriptor);
    methodDescriptors.add(getUnitKindMethodDescriptor);
    methodDescriptors.add(createUnitKindMethodDescriptor);
    methodDescriptors.add(updateUnitKindMethodDescriptor);
    methodDescriptors.add(deleteUnitKindMethodDescriptor);
    methodDescriptors.add(listUnitsMethodDescriptor);
    methodDescriptors.add(getUnitMethodDescriptor);
    methodDescriptors.add(createUnitMethodDescriptor);
    methodDescriptors.add(updateUnitMethodDescriptor);
    methodDescriptors.add(deleteUnitMethodDescriptor);
    methodDescriptors.add(listUnitOperationsMethodDescriptor);
    methodDescriptors.add(getUnitOperationMethodDescriptor);
    methodDescriptors.add(createUnitOperationMethodDescriptor);
    methodDescriptors.add(updateUnitOperationMethodDescriptor);
    methodDescriptors.add(deleteUnitOperationMethodDescriptor);
    methodDescriptors.add(listReleasesMethodDescriptor);
    methodDescriptors.add(getReleaseMethodDescriptor);
    methodDescriptors.add(createReleaseMethodDescriptor);
    methodDescriptors.add(updateReleaseMethodDescriptor);
    methodDescriptors.add(deleteReleaseMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
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
