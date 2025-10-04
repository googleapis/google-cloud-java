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

package com.google.cloud.gdchardwaremanagement.v1alpha.stub;

import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListChangeLogEntriesPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListCommentsPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListHardwareGroupsPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListHardwarePagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListLocationsPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListOrdersPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListSitesPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListSkusPagedResponse;
import static com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient.ListZonesPagedResponse;

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
import com.google.cloud.gdchardwaremanagement.v1alpha.CancelOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ChangeLogEntry;
import com.google.cloud.gdchardwaremanagement.v1alpha.Comment;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateCommentRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareGroupRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateHardwareRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateSiteRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.CreateZoneRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareGroupRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.DeleteHardwareRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.DeleteOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.DeleteSiteRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.DeleteZoneRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetChangeLogEntryRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetCommentRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareGroupRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetHardwareRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetSiteRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetSkuRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetZoneRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.Hardware;
import com.google.cloud.gdchardwaremanagement.v1alpha.HardwareGroup;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListChangeLogEntriesResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListCommentsResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareGroupsResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListHardwareResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListOrdersResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListSitesResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListSkusResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.ListZonesResponse;
import com.google.cloud.gdchardwaremanagement.v1alpha.OperationMetadata;
import com.google.cloud.gdchardwaremanagement.v1alpha.Order;
import com.google.cloud.gdchardwaremanagement.v1alpha.RecordActionOnCommentRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.RequestOrderDateChangeRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.SignalZoneStateRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.Site;
import com.google.cloud.gdchardwaremanagement.v1alpha.Sku;
import com.google.cloud.gdchardwaremanagement.v1alpha.SubmitOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareGroupRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.UpdateHardwareRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.UpdateOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.UpdateSiteRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.UpdateZoneRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.Zone;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the GDCHardwareManagement service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonGDCHardwareManagementStub extends GDCHardwareManagementStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(Order.getDescriptor())
          .add(HardwareGroup.getDescriptor())
          .add(Site.getDescriptor())
          .add(Hardware.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Zone.getDescriptor())
          .add(Comment.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListOrdersRequest, ListOrdersResponse>
      listOrdersMethodDescriptor =
          ApiMethodDescriptor.<ListOrdersRequest, ListOrdersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/ListOrders")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOrdersRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/orders",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrdersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListOrdersResponse>newBuilder()
                      .setDefaultInstance(ListOrdersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetOrderRequest, Order> getOrderMethodDescriptor =
      ApiMethodDescriptor.<GetOrderRequest, Order>newBuilder()
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/GetOrder")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetOrderRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/locations/*/orders/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetOrderRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetOrderRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Order>newBuilder()
                  .setDefaultInstance(Order.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateOrderRequest, Operation>
      createOrderMethodDescriptor =
          ApiMethodDescriptor.<CreateOrderRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/CreateOrder")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateOrderRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/orders",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOrderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOrderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "orderId", request.getOrderId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("order", request.getOrder(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateOrderRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateOrderRequest, Operation>
      updateOrderMethodDescriptor =
          ApiMethodDescriptor.<UpdateOrderRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/UpdateOrder")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateOrderRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{order.name=projects/*/locations/*/orders/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOrderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "order.name", request.getOrder().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOrderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("order", request.getOrder(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateOrderRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteOrderRequest, Operation>
      deleteOrderMethodDescriptor =
          ApiMethodDescriptor.<DeleteOrderRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/DeleteOrder")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteOrderRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/orders/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOrderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOrderRequest> serializer =
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
                  (DeleteOrderRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<SubmitOrderRequest, Operation>
      submitOrderMethodDescriptor =
          ApiMethodDescriptor.<SubmitOrderRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/SubmitOrder")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SubmitOrderRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/orders/*}:submit",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SubmitOrderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SubmitOrderRequest> serializer =
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
                  (SubmitOrderRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CancelOrderRequest, Operation>
      cancelOrderMethodDescriptor =
          ApiMethodDescriptor.<CancelOrderRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/CancelOrder")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CancelOrderRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/orders/*}:cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CancelOrderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CancelOrderRequest> serializer =
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
                  (CancelOrderRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListSitesRequest, ListSitesResponse>
      listSitesMethodDescriptor =
          ApiMethodDescriptor.<ListSitesRequest, ListSitesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/ListSites")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSitesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/sites",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSitesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSitesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListSitesResponse>newBuilder()
                      .setDefaultInstance(ListSitesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSiteRequest, Site> getSiteMethodDescriptor =
      ApiMethodDescriptor.<GetSiteRequest, Site>newBuilder()
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/GetSite")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSiteRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/locations/*/sites/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSiteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSiteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Site>newBuilder()
                  .setDefaultInstance(Site.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateSiteRequest, Operation>
      createSiteMethodDescriptor =
          ApiMethodDescriptor.<CreateSiteRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/CreateSite")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSiteRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/sites",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSiteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSiteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "siteId", request.getSiteId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("site", request.getSite(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateSiteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateSiteRequest, Operation>
      updateSiteMethodDescriptor =
          ApiMethodDescriptor.<UpdateSiteRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/UpdateSite")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSiteRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{site.name=projects/*/locations/*/sites/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSiteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "site.name", request.getSite().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSiteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("site", request.getSite(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateSiteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteSiteRequest, Operation>
      deleteSiteMethodDescriptor =
          ApiMethodDescriptor.<DeleteSiteRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/DeleteSite")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSiteRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/sites/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSiteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSiteRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteSiteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListHardwareGroupsRequest, ListHardwareGroupsResponse>
      listHardwareGroupsMethodDescriptor =
          ApiMethodDescriptor.<ListHardwareGroupsRequest, ListHardwareGroupsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/ListHardwareGroups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListHardwareGroupsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/orders/*}/hardwareGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListHardwareGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListHardwareGroupsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListHardwareGroupsResponse>newBuilder()
                      .setDefaultInstance(ListHardwareGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetHardwareGroupRequest, HardwareGroup>
      getHardwareGroupMethodDescriptor =
          ApiMethodDescriptor.<GetHardwareGroupRequest, HardwareGroup>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/GetHardwareGroup")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHardwareGroupRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/orders/*/hardwareGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetHardwareGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetHardwareGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HardwareGroup>newBuilder()
                      .setDefaultInstance(HardwareGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateHardwareGroupRequest, Operation>
      createHardwareGroupMethodDescriptor =
          ApiMethodDescriptor.<CreateHardwareGroupRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/CreateHardwareGroup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateHardwareGroupRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/orders/*}/hardwareGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHardwareGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHardwareGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "hardwareGroupId", request.getHardwareGroupId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("hardwareGroup", request.getHardwareGroup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateHardwareGroupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateHardwareGroupRequest, Operation>
      updateHardwareGroupMethodDescriptor =
          ApiMethodDescriptor.<UpdateHardwareGroupRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/UpdateHardwareGroup")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateHardwareGroupRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{hardwareGroup.name=projects/*/locations/*/orders/*/hardwareGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHardwareGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "hardwareGroup.name", request.getHardwareGroup().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHardwareGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("hardwareGroup", request.getHardwareGroup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateHardwareGroupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteHardwareGroupRequest, Operation>
      deleteHardwareGroupMethodDescriptor =
          ApiMethodDescriptor.<DeleteHardwareGroupRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/DeleteHardwareGroup")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteHardwareGroupRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/orders/*/hardwareGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteHardwareGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteHardwareGroupRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteHardwareGroupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListHardwareRequest, ListHardwareResponse>
      listHardwareMethodDescriptor =
          ApiMethodDescriptor.<ListHardwareRequest, ListHardwareResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/ListHardware")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListHardwareRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/hardware",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListHardwareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListHardwareRequest> serializer =
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
                  ProtoMessageResponseParser.<ListHardwareResponse>newBuilder()
                      .setDefaultInstance(ListHardwareResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetHardwareRequest, Hardware>
      getHardwareMethodDescriptor =
          ApiMethodDescriptor.<GetHardwareRequest, Hardware>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/GetHardware")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHardwareRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/hardware/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetHardwareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetHardwareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Hardware>newBuilder()
                      .setDefaultInstance(Hardware.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateHardwareRequest, Operation>
      createHardwareMethodDescriptor =
          ApiMethodDescriptor.<CreateHardwareRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/CreateHardware")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateHardwareRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/hardware",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHardwareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateHardwareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "hardwareId", request.getHardwareId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("hardware", request.getHardware(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateHardwareRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateHardwareRequest, Operation>
      updateHardwareMethodDescriptor =
          ApiMethodDescriptor.<UpdateHardwareRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/UpdateHardware")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateHardwareRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{hardware.name=projects/*/locations/*/hardware/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHardwareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "hardware.name", request.getHardware().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHardwareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("hardware", request.getHardware(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateHardwareRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteHardwareRequest, Operation>
      deleteHardwareMethodDescriptor =
          ApiMethodDescriptor.<DeleteHardwareRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/DeleteHardware")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteHardwareRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/hardware/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteHardwareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteHardwareRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteHardwareRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListCommentsRequest, ListCommentsResponse>
      listCommentsMethodDescriptor =
          ApiMethodDescriptor.<ListCommentsRequest, ListCommentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/ListComments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCommentsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/orders/*}/comments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCommentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCommentsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCommentsResponse>newBuilder()
                      .setDefaultInstance(ListCommentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCommentRequest, Comment> getCommentMethodDescriptor =
      ApiMethodDescriptor.<GetCommentRequest, Comment>newBuilder()
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/GetComment")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetCommentRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/locations/*/orders/*/comments/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetCommentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetCommentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Comment>newBuilder()
                  .setDefaultInstance(Comment.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateCommentRequest, Operation>
      createCommentMethodDescriptor =
          ApiMethodDescriptor.<CreateCommentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/CreateComment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCommentRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/orders/*}/comments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "commentId", request.getCommentId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("comment", request.getComment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateCommentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RecordActionOnCommentRequest, Comment>
      recordActionOnCommentMethodDescriptor =
          ApiMethodDescriptor.<RecordActionOnCommentRequest, Comment>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/RecordActionOnComment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RecordActionOnCommentRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/orders/*/comments/*}:recordAction",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RecordActionOnCommentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RecordActionOnCommentRequest> serializer =
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
                  ProtoMessageResponseParser.<Comment>newBuilder()
                      .setDefaultInstance(Comment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListChangeLogEntriesRequest, ListChangeLogEntriesResponse>
      listChangeLogEntriesMethodDescriptor =
          ApiMethodDescriptor
              .<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/ListChangeLogEntries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListChangeLogEntriesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/orders/*}/changeLogEntries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListChangeLogEntriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListChangeLogEntriesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListChangeLogEntriesResponse>newBuilder()
                      .setDefaultInstance(ListChangeLogEntriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetChangeLogEntryRequest, ChangeLogEntry>
      getChangeLogEntryMethodDescriptor =
          ApiMethodDescriptor.<GetChangeLogEntryRequest, ChangeLogEntry>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/GetChangeLogEntry")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetChangeLogEntryRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/orders/*/changeLogEntries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetChangeLogEntryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetChangeLogEntryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ChangeLogEntry>newBuilder()
                      .setDefaultInstance(ChangeLogEntry.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSkusRequest, ListSkusResponse>
      listSkusMethodDescriptor =
          ApiMethodDescriptor.<ListSkusRequest, ListSkusResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/ListSkus")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSkusRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/skus",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSkusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSkusRequest> serializer =
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
                  ProtoMessageResponseParser.<ListSkusResponse>newBuilder()
                      .setDefaultInstance(ListSkusResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSkuRequest, Sku> getSkuMethodDescriptor =
      ApiMethodDescriptor.<GetSkuRequest, Sku>newBuilder()
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/GetSku")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSkuRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/locations/*/skus/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSkuRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSkuRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Sku>newBuilder()
                  .setDefaultInstance(Sku.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListZonesRequest, ListZonesResponse>
      listZonesMethodDescriptor =
          ApiMethodDescriptor.<ListZonesRequest, ListZonesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/ListZones")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListZonesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/zones",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListZonesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListZonesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListZonesResponse>newBuilder()
                      .setDefaultInstance(ListZonesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetZoneRequest, Zone> getZoneMethodDescriptor =
      ApiMethodDescriptor.<GetZoneRequest, Zone>newBuilder()
          .setFullMethodName(
              "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/GetZone")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetZoneRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/locations/*/zones/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetZoneRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetZoneRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Zone>newBuilder()
                  .setDefaultInstance(Zone.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateZoneRequest, Operation>
      createZoneMethodDescriptor =
          ApiMethodDescriptor.<CreateZoneRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/CreateZone")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateZoneRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*}/zones",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateZoneRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateZoneRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "zoneId", request.getZoneId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("zone", request.getZone(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateZoneRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateZoneRequest, Operation>
      updateZoneMethodDescriptor =
          ApiMethodDescriptor.<UpdateZoneRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/UpdateZone")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateZoneRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{zone.name=projects/*/locations/*/zones/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateZoneRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "zone.name", request.getZone().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateZoneRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("zone", request.getZone(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateZoneRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteZoneRequest, Operation>
      deleteZoneMethodDescriptor =
          ApiMethodDescriptor.<DeleteZoneRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/DeleteZone")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteZoneRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/zones/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteZoneRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteZoneRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteZoneRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<SignalZoneStateRequest, Operation>
      signalZoneStateMethodDescriptor =
          ApiMethodDescriptor.<SignalZoneStateRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/SignalZoneState")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SignalZoneStateRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/zones/*}:signal",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SignalZoneStateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SignalZoneStateRequest> serializer =
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
                  (SignalZoneStateRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RequestOrderDateChangeRequest, Operation>
      requestOrderDateChangeMethodDescriptor =
          ApiMethodDescriptor.<RequestOrderDateChangeRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagement/RequestOrderDateChange")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RequestOrderDateChangeRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/orders/*}:requestDateChange",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RequestOrderDateChangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RequestOrderDateChangeRequest> serializer =
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
                  (RequestOrderDateChangeRequest request, Operation response) ->
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
                          "/v1alpha/{name=projects/*}/locations",
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
                          "/v1alpha/{name=projects/*/locations/*}",
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

  private final UnaryCallable<ListOrdersRequest, ListOrdersResponse> listOrdersCallable;
  private final UnaryCallable<ListOrdersRequest, ListOrdersPagedResponse> listOrdersPagedCallable;
  private final UnaryCallable<GetOrderRequest, Order> getOrderCallable;
  private final UnaryCallable<CreateOrderRequest, Operation> createOrderCallable;
  private final OperationCallable<CreateOrderRequest, Order, OperationMetadata>
      createOrderOperationCallable;
  private final UnaryCallable<UpdateOrderRequest, Operation> updateOrderCallable;
  private final OperationCallable<UpdateOrderRequest, Order, OperationMetadata>
      updateOrderOperationCallable;
  private final UnaryCallable<DeleteOrderRequest, Operation> deleteOrderCallable;
  private final OperationCallable<DeleteOrderRequest, Empty, OperationMetadata>
      deleteOrderOperationCallable;
  private final UnaryCallable<SubmitOrderRequest, Operation> submitOrderCallable;
  private final OperationCallable<SubmitOrderRequest, Order, OperationMetadata>
      submitOrderOperationCallable;
  private final UnaryCallable<CancelOrderRequest, Operation> cancelOrderCallable;
  private final OperationCallable<CancelOrderRequest, Order, OperationMetadata>
      cancelOrderOperationCallable;
  private final UnaryCallable<ListSitesRequest, ListSitesResponse> listSitesCallable;
  private final UnaryCallable<ListSitesRequest, ListSitesPagedResponse> listSitesPagedCallable;
  private final UnaryCallable<GetSiteRequest, Site> getSiteCallable;
  private final UnaryCallable<CreateSiteRequest, Operation> createSiteCallable;
  private final OperationCallable<CreateSiteRequest, Site, OperationMetadata>
      createSiteOperationCallable;
  private final UnaryCallable<UpdateSiteRequest, Operation> updateSiteCallable;
  private final OperationCallable<UpdateSiteRequest, Site, OperationMetadata>
      updateSiteOperationCallable;
  private final UnaryCallable<DeleteSiteRequest, Operation> deleteSiteCallable;
  private final OperationCallable<DeleteSiteRequest, Empty, OperationMetadata>
      deleteSiteOperationCallable;
  private final UnaryCallable<ListHardwareGroupsRequest, ListHardwareGroupsResponse>
      listHardwareGroupsCallable;
  private final UnaryCallable<ListHardwareGroupsRequest, ListHardwareGroupsPagedResponse>
      listHardwareGroupsPagedCallable;
  private final UnaryCallable<GetHardwareGroupRequest, HardwareGroup> getHardwareGroupCallable;
  private final UnaryCallable<CreateHardwareGroupRequest, Operation> createHardwareGroupCallable;
  private final OperationCallable<CreateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      createHardwareGroupOperationCallable;
  private final UnaryCallable<UpdateHardwareGroupRequest, Operation> updateHardwareGroupCallable;
  private final OperationCallable<UpdateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      updateHardwareGroupOperationCallable;
  private final UnaryCallable<DeleteHardwareGroupRequest, Operation> deleteHardwareGroupCallable;
  private final OperationCallable<DeleteHardwareGroupRequest, Empty, OperationMetadata>
      deleteHardwareGroupOperationCallable;
  private final UnaryCallable<ListHardwareRequest, ListHardwareResponse> listHardwareCallable;
  private final UnaryCallable<ListHardwareRequest, ListHardwarePagedResponse>
      listHardwarePagedCallable;
  private final UnaryCallable<GetHardwareRequest, Hardware> getHardwareCallable;
  private final UnaryCallable<CreateHardwareRequest, Operation> createHardwareCallable;
  private final OperationCallable<CreateHardwareRequest, Hardware, OperationMetadata>
      createHardwareOperationCallable;
  private final UnaryCallable<UpdateHardwareRequest, Operation> updateHardwareCallable;
  private final OperationCallable<UpdateHardwareRequest, Hardware, OperationMetadata>
      updateHardwareOperationCallable;
  private final UnaryCallable<DeleteHardwareRequest, Operation> deleteHardwareCallable;
  private final OperationCallable<DeleteHardwareRequest, Empty, OperationMetadata>
      deleteHardwareOperationCallable;
  private final UnaryCallable<ListCommentsRequest, ListCommentsResponse> listCommentsCallable;
  private final UnaryCallable<ListCommentsRequest, ListCommentsPagedResponse>
      listCommentsPagedCallable;
  private final UnaryCallable<GetCommentRequest, Comment> getCommentCallable;
  private final UnaryCallable<CreateCommentRequest, Operation> createCommentCallable;
  private final OperationCallable<CreateCommentRequest, Comment, OperationMetadata>
      createCommentOperationCallable;
  private final UnaryCallable<RecordActionOnCommentRequest, Comment> recordActionOnCommentCallable;
  private final UnaryCallable<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse>
      listChangeLogEntriesCallable;
  private final UnaryCallable<ListChangeLogEntriesRequest, ListChangeLogEntriesPagedResponse>
      listChangeLogEntriesPagedCallable;
  private final UnaryCallable<GetChangeLogEntryRequest, ChangeLogEntry> getChangeLogEntryCallable;
  private final UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable;
  private final UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable;
  private final UnaryCallable<GetSkuRequest, Sku> getSkuCallable;
  private final UnaryCallable<ListZonesRequest, ListZonesResponse> listZonesCallable;
  private final UnaryCallable<ListZonesRequest, ListZonesPagedResponse> listZonesPagedCallable;
  private final UnaryCallable<GetZoneRequest, Zone> getZoneCallable;
  private final UnaryCallable<CreateZoneRequest, Operation> createZoneCallable;
  private final OperationCallable<CreateZoneRequest, Zone, OperationMetadata>
      createZoneOperationCallable;
  private final UnaryCallable<UpdateZoneRequest, Operation> updateZoneCallable;
  private final OperationCallable<UpdateZoneRequest, Zone, OperationMetadata>
      updateZoneOperationCallable;
  private final UnaryCallable<DeleteZoneRequest, Operation> deleteZoneCallable;
  private final OperationCallable<DeleteZoneRequest, Empty, OperationMetadata>
      deleteZoneOperationCallable;
  private final UnaryCallable<SignalZoneStateRequest, Operation> signalZoneStateCallable;
  private final OperationCallable<SignalZoneStateRequest, Zone, OperationMetadata>
      signalZoneStateOperationCallable;
  private final UnaryCallable<RequestOrderDateChangeRequest, Operation>
      requestOrderDateChangeCallable;
  private final OperationCallable<RequestOrderDateChangeRequest, Order, OperationMetadata>
      requestOrderDateChangeOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGDCHardwareManagementStub create(
      GDCHardwareManagementStubSettings settings) throws IOException {
    return new HttpJsonGDCHardwareManagementStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGDCHardwareManagementStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGDCHardwareManagementStub(
        GDCHardwareManagementStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonGDCHardwareManagementStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGDCHardwareManagementStub(
        GDCHardwareManagementStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGDCHardwareManagementStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGDCHardwareManagementStub(
      GDCHardwareManagementStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonGDCHardwareManagementCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGDCHardwareManagementStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGDCHardwareManagementStub(
      GDCHardwareManagementStubSettings settings,
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

    HttpJsonCallSettings<ListOrdersRequest, ListOrdersResponse> listOrdersTransportSettings =
        HttpJsonCallSettings.<ListOrdersRequest, ListOrdersResponse>newBuilder()
            .setMethodDescriptor(listOrdersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetOrderRequest, Order> getOrderTransportSettings =
        HttpJsonCallSettings.<GetOrderRequest, Order>newBuilder()
            .setMethodDescriptor(getOrderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateOrderRequest, Operation> createOrderTransportSettings =
        HttpJsonCallSettings.<CreateOrderRequest, Operation>newBuilder()
            .setMethodDescriptor(createOrderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateOrderRequest, Operation> updateOrderTransportSettings =
        HttpJsonCallSettings.<UpdateOrderRequest, Operation>newBuilder()
            .setMethodDescriptor(updateOrderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("order.name", String.valueOf(request.getOrder().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteOrderRequest, Operation> deleteOrderTransportSettings =
        HttpJsonCallSettings.<DeleteOrderRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteOrderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SubmitOrderRequest, Operation> submitOrderTransportSettings =
        HttpJsonCallSettings.<SubmitOrderRequest, Operation>newBuilder()
            .setMethodDescriptor(submitOrderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CancelOrderRequest, Operation> cancelOrderTransportSettings =
        HttpJsonCallSettings.<CancelOrderRequest, Operation>newBuilder()
            .setMethodDescriptor(cancelOrderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListSitesRequest, ListSitesResponse> listSitesTransportSettings =
        HttpJsonCallSettings.<ListSitesRequest, ListSitesResponse>newBuilder()
            .setMethodDescriptor(listSitesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetSiteRequest, Site> getSiteTransportSettings =
        HttpJsonCallSettings.<GetSiteRequest, Site>newBuilder()
            .setMethodDescriptor(getSiteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateSiteRequest, Operation> createSiteTransportSettings =
        HttpJsonCallSettings.<CreateSiteRequest, Operation>newBuilder()
            .setMethodDescriptor(createSiteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSiteRequest, Operation> updateSiteTransportSettings =
        HttpJsonCallSettings.<UpdateSiteRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSiteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("site.name", String.valueOf(request.getSite().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSiteRequest, Operation> deleteSiteTransportSettings =
        HttpJsonCallSettings.<DeleteSiteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSiteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListHardwareGroupsRequest, ListHardwareGroupsResponse>
        listHardwareGroupsTransportSettings =
            HttpJsonCallSettings.<ListHardwareGroupsRequest, ListHardwareGroupsResponse>newBuilder()
                .setMethodDescriptor(listHardwareGroupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetHardwareGroupRequest, HardwareGroup> getHardwareGroupTransportSettings =
        HttpJsonCallSettings.<GetHardwareGroupRequest, HardwareGroup>newBuilder()
            .setMethodDescriptor(getHardwareGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateHardwareGroupRequest, Operation>
        createHardwareGroupTransportSettings =
            HttpJsonCallSettings.<CreateHardwareGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(createHardwareGroupMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateHardwareGroupRequest, Operation>
        updateHardwareGroupTransportSettings =
            HttpJsonCallSettings.<UpdateHardwareGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(updateHardwareGroupMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "hardware_group.name",
                          String.valueOf(request.getHardwareGroup().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteHardwareGroupRequest, Operation>
        deleteHardwareGroupTransportSettings =
            HttpJsonCallSettings.<DeleteHardwareGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteHardwareGroupMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListHardwareRequest, ListHardwareResponse> listHardwareTransportSettings =
        HttpJsonCallSettings.<ListHardwareRequest, ListHardwareResponse>newBuilder()
            .setMethodDescriptor(listHardwareMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetHardwareRequest, Hardware> getHardwareTransportSettings =
        HttpJsonCallSettings.<GetHardwareRequest, Hardware>newBuilder()
            .setMethodDescriptor(getHardwareMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateHardwareRequest, Operation> createHardwareTransportSettings =
        HttpJsonCallSettings.<CreateHardwareRequest, Operation>newBuilder()
            .setMethodDescriptor(createHardwareMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateHardwareRequest, Operation> updateHardwareTransportSettings =
        HttpJsonCallSettings.<UpdateHardwareRequest, Operation>newBuilder()
            .setMethodDescriptor(updateHardwareMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("hardware.name", String.valueOf(request.getHardware().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteHardwareRequest, Operation> deleteHardwareTransportSettings =
        HttpJsonCallSettings.<DeleteHardwareRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteHardwareMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCommentsRequest, ListCommentsResponse> listCommentsTransportSettings =
        HttpJsonCallSettings.<ListCommentsRequest, ListCommentsResponse>newBuilder()
            .setMethodDescriptor(listCommentsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetCommentRequest, Comment> getCommentTransportSettings =
        HttpJsonCallSettings.<GetCommentRequest, Comment>newBuilder()
            .setMethodDescriptor(getCommentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateCommentRequest, Operation> createCommentTransportSettings =
        HttpJsonCallSettings.<CreateCommentRequest, Operation>newBuilder()
            .setMethodDescriptor(createCommentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RecordActionOnCommentRequest, Comment>
        recordActionOnCommentTransportSettings =
            HttpJsonCallSettings.<RecordActionOnCommentRequest, Comment>newBuilder()
                .setMethodDescriptor(recordActionOnCommentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse>
        listChangeLogEntriesTransportSettings =
            HttpJsonCallSettings
                .<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse>newBuilder()
                .setMethodDescriptor(listChangeLogEntriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetChangeLogEntryRequest, ChangeLogEntry>
        getChangeLogEntryTransportSettings =
            HttpJsonCallSettings.<GetChangeLogEntryRequest, ChangeLogEntry>newBuilder()
                .setMethodDescriptor(getChangeLogEntryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListSkusRequest, ListSkusResponse> listSkusTransportSettings =
        HttpJsonCallSettings.<ListSkusRequest, ListSkusResponse>newBuilder()
            .setMethodDescriptor(listSkusMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetSkuRequest, Sku> getSkuTransportSettings =
        HttpJsonCallSettings.<GetSkuRequest, Sku>newBuilder()
            .setMethodDescriptor(getSkuMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListZonesRequest, ListZonesResponse> listZonesTransportSettings =
        HttpJsonCallSettings.<ListZonesRequest, ListZonesResponse>newBuilder()
            .setMethodDescriptor(listZonesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetZoneRequest, Zone> getZoneTransportSettings =
        HttpJsonCallSettings.<GetZoneRequest, Zone>newBuilder()
            .setMethodDescriptor(getZoneMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateZoneRequest, Operation> createZoneTransportSettings =
        HttpJsonCallSettings.<CreateZoneRequest, Operation>newBuilder()
            .setMethodDescriptor(createZoneMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateZoneRequest, Operation> updateZoneTransportSettings =
        HttpJsonCallSettings.<UpdateZoneRequest, Operation>newBuilder()
            .setMethodDescriptor(updateZoneMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("zone.name", String.valueOf(request.getZone().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteZoneRequest, Operation> deleteZoneTransportSettings =
        HttpJsonCallSettings.<DeleteZoneRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteZoneMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SignalZoneStateRequest, Operation> signalZoneStateTransportSettings =
        HttpJsonCallSettings.<SignalZoneStateRequest, Operation>newBuilder()
            .setMethodDescriptor(signalZoneStateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RequestOrderDateChangeRequest, Operation>
        requestOrderDateChangeTransportSettings =
            HttpJsonCallSettings.<RequestOrderDateChangeRequest, Operation>newBuilder()
                .setMethodDescriptor(requestOrderDateChangeMethodDescriptor)
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

    this.listOrdersCallable =
        callableFactory.createUnaryCallable(
            listOrdersTransportSettings, settings.listOrdersSettings(), clientContext);
    this.listOrdersPagedCallable =
        callableFactory.createPagedCallable(
            listOrdersTransportSettings, settings.listOrdersSettings(), clientContext);
    this.getOrderCallable =
        callableFactory.createUnaryCallable(
            getOrderTransportSettings, settings.getOrderSettings(), clientContext);
    this.createOrderCallable =
        callableFactory.createUnaryCallable(
            createOrderTransportSettings, settings.createOrderSettings(), clientContext);
    this.createOrderOperationCallable =
        callableFactory.createOperationCallable(
            createOrderTransportSettings,
            settings.createOrderOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateOrderCallable =
        callableFactory.createUnaryCallable(
            updateOrderTransportSettings, settings.updateOrderSettings(), clientContext);
    this.updateOrderOperationCallable =
        callableFactory.createOperationCallable(
            updateOrderTransportSettings,
            settings.updateOrderOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteOrderCallable =
        callableFactory.createUnaryCallable(
            deleteOrderTransportSettings, settings.deleteOrderSettings(), clientContext);
    this.deleteOrderOperationCallable =
        callableFactory.createOperationCallable(
            deleteOrderTransportSettings,
            settings.deleteOrderOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.submitOrderCallable =
        callableFactory.createUnaryCallable(
            submitOrderTransportSettings, settings.submitOrderSettings(), clientContext);
    this.submitOrderOperationCallable =
        callableFactory.createOperationCallable(
            submitOrderTransportSettings,
            settings.submitOrderOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.cancelOrderCallable =
        callableFactory.createUnaryCallable(
            cancelOrderTransportSettings, settings.cancelOrderSettings(), clientContext);
    this.cancelOrderOperationCallable =
        callableFactory.createOperationCallable(
            cancelOrderTransportSettings,
            settings.cancelOrderOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listSitesCallable =
        callableFactory.createUnaryCallable(
            listSitesTransportSettings, settings.listSitesSettings(), clientContext);
    this.listSitesPagedCallable =
        callableFactory.createPagedCallable(
            listSitesTransportSettings, settings.listSitesSettings(), clientContext);
    this.getSiteCallable =
        callableFactory.createUnaryCallable(
            getSiteTransportSettings, settings.getSiteSettings(), clientContext);
    this.createSiteCallable =
        callableFactory.createUnaryCallable(
            createSiteTransportSettings, settings.createSiteSettings(), clientContext);
    this.createSiteOperationCallable =
        callableFactory.createOperationCallable(
            createSiteTransportSettings,
            settings.createSiteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateSiteCallable =
        callableFactory.createUnaryCallable(
            updateSiteTransportSettings, settings.updateSiteSettings(), clientContext);
    this.updateSiteOperationCallable =
        callableFactory.createOperationCallable(
            updateSiteTransportSettings,
            settings.updateSiteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteSiteCallable =
        callableFactory.createUnaryCallable(
            deleteSiteTransportSettings, settings.deleteSiteSettings(), clientContext);
    this.deleteSiteOperationCallable =
        callableFactory.createOperationCallable(
            deleteSiteTransportSettings,
            settings.deleteSiteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listHardwareGroupsCallable =
        callableFactory.createUnaryCallable(
            listHardwareGroupsTransportSettings,
            settings.listHardwareGroupsSettings(),
            clientContext);
    this.listHardwareGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listHardwareGroupsTransportSettings,
            settings.listHardwareGroupsSettings(),
            clientContext);
    this.getHardwareGroupCallable =
        callableFactory.createUnaryCallable(
            getHardwareGroupTransportSettings, settings.getHardwareGroupSettings(), clientContext);
    this.createHardwareGroupCallable =
        callableFactory.createUnaryCallable(
            createHardwareGroupTransportSettings,
            settings.createHardwareGroupSettings(),
            clientContext);
    this.createHardwareGroupOperationCallable =
        callableFactory.createOperationCallable(
            createHardwareGroupTransportSettings,
            settings.createHardwareGroupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateHardwareGroupCallable =
        callableFactory.createUnaryCallable(
            updateHardwareGroupTransportSettings,
            settings.updateHardwareGroupSettings(),
            clientContext);
    this.updateHardwareGroupOperationCallable =
        callableFactory.createOperationCallable(
            updateHardwareGroupTransportSettings,
            settings.updateHardwareGroupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteHardwareGroupCallable =
        callableFactory.createUnaryCallable(
            deleteHardwareGroupTransportSettings,
            settings.deleteHardwareGroupSettings(),
            clientContext);
    this.deleteHardwareGroupOperationCallable =
        callableFactory.createOperationCallable(
            deleteHardwareGroupTransportSettings,
            settings.deleteHardwareGroupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listHardwareCallable =
        callableFactory.createUnaryCallable(
            listHardwareTransportSettings, settings.listHardwareSettings(), clientContext);
    this.listHardwarePagedCallable =
        callableFactory.createPagedCallable(
            listHardwareTransportSettings, settings.listHardwareSettings(), clientContext);
    this.getHardwareCallable =
        callableFactory.createUnaryCallable(
            getHardwareTransportSettings, settings.getHardwareSettings(), clientContext);
    this.createHardwareCallable =
        callableFactory.createUnaryCallable(
            createHardwareTransportSettings, settings.createHardwareSettings(), clientContext);
    this.createHardwareOperationCallable =
        callableFactory.createOperationCallable(
            createHardwareTransportSettings,
            settings.createHardwareOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateHardwareCallable =
        callableFactory.createUnaryCallable(
            updateHardwareTransportSettings, settings.updateHardwareSettings(), clientContext);
    this.updateHardwareOperationCallable =
        callableFactory.createOperationCallable(
            updateHardwareTransportSettings,
            settings.updateHardwareOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteHardwareCallable =
        callableFactory.createUnaryCallable(
            deleteHardwareTransportSettings, settings.deleteHardwareSettings(), clientContext);
    this.deleteHardwareOperationCallable =
        callableFactory.createOperationCallable(
            deleteHardwareTransportSettings,
            settings.deleteHardwareOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listCommentsCallable =
        callableFactory.createUnaryCallable(
            listCommentsTransportSettings, settings.listCommentsSettings(), clientContext);
    this.listCommentsPagedCallable =
        callableFactory.createPagedCallable(
            listCommentsTransportSettings, settings.listCommentsSettings(), clientContext);
    this.getCommentCallable =
        callableFactory.createUnaryCallable(
            getCommentTransportSettings, settings.getCommentSettings(), clientContext);
    this.createCommentCallable =
        callableFactory.createUnaryCallable(
            createCommentTransportSettings, settings.createCommentSettings(), clientContext);
    this.createCommentOperationCallable =
        callableFactory.createOperationCallable(
            createCommentTransportSettings,
            settings.createCommentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.recordActionOnCommentCallable =
        callableFactory.createUnaryCallable(
            recordActionOnCommentTransportSettings,
            settings.recordActionOnCommentSettings(),
            clientContext);
    this.listChangeLogEntriesCallable =
        callableFactory.createUnaryCallable(
            listChangeLogEntriesTransportSettings,
            settings.listChangeLogEntriesSettings(),
            clientContext);
    this.listChangeLogEntriesPagedCallable =
        callableFactory.createPagedCallable(
            listChangeLogEntriesTransportSettings,
            settings.listChangeLogEntriesSettings(),
            clientContext);
    this.getChangeLogEntryCallable =
        callableFactory.createUnaryCallable(
            getChangeLogEntryTransportSettings,
            settings.getChangeLogEntrySettings(),
            clientContext);
    this.listSkusCallable =
        callableFactory.createUnaryCallable(
            listSkusTransportSettings, settings.listSkusSettings(), clientContext);
    this.listSkusPagedCallable =
        callableFactory.createPagedCallable(
            listSkusTransportSettings, settings.listSkusSettings(), clientContext);
    this.getSkuCallable =
        callableFactory.createUnaryCallable(
            getSkuTransportSettings, settings.getSkuSettings(), clientContext);
    this.listZonesCallable =
        callableFactory.createUnaryCallable(
            listZonesTransportSettings, settings.listZonesSettings(), clientContext);
    this.listZonesPagedCallable =
        callableFactory.createPagedCallable(
            listZonesTransportSettings, settings.listZonesSettings(), clientContext);
    this.getZoneCallable =
        callableFactory.createUnaryCallable(
            getZoneTransportSettings, settings.getZoneSettings(), clientContext);
    this.createZoneCallable =
        callableFactory.createUnaryCallable(
            createZoneTransportSettings, settings.createZoneSettings(), clientContext);
    this.createZoneOperationCallable =
        callableFactory.createOperationCallable(
            createZoneTransportSettings,
            settings.createZoneOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateZoneCallable =
        callableFactory.createUnaryCallable(
            updateZoneTransportSettings, settings.updateZoneSettings(), clientContext);
    this.updateZoneOperationCallable =
        callableFactory.createOperationCallable(
            updateZoneTransportSettings,
            settings.updateZoneOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteZoneCallable =
        callableFactory.createUnaryCallable(
            deleteZoneTransportSettings, settings.deleteZoneSettings(), clientContext);
    this.deleteZoneOperationCallable =
        callableFactory.createOperationCallable(
            deleteZoneTransportSettings,
            settings.deleteZoneOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.signalZoneStateCallable =
        callableFactory.createUnaryCallable(
            signalZoneStateTransportSettings, settings.signalZoneStateSettings(), clientContext);
    this.signalZoneStateOperationCallable =
        callableFactory.createOperationCallable(
            signalZoneStateTransportSettings,
            settings.signalZoneStateOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.requestOrderDateChangeCallable =
        callableFactory.createUnaryCallable(
            requestOrderDateChangeTransportSettings,
            settings.requestOrderDateChangeSettings(),
            clientContext);
    this.requestOrderDateChangeOperationCallable =
        callableFactory.createOperationCallable(
            requestOrderDateChangeTransportSettings,
            settings.requestOrderDateChangeOperationSettings(),
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
    methodDescriptors.add(listOrdersMethodDescriptor);
    methodDescriptors.add(getOrderMethodDescriptor);
    methodDescriptors.add(createOrderMethodDescriptor);
    methodDescriptors.add(updateOrderMethodDescriptor);
    methodDescriptors.add(deleteOrderMethodDescriptor);
    methodDescriptors.add(submitOrderMethodDescriptor);
    methodDescriptors.add(cancelOrderMethodDescriptor);
    methodDescriptors.add(listSitesMethodDescriptor);
    methodDescriptors.add(getSiteMethodDescriptor);
    methodDescriptors.add(createSiteMethodDescriptor);
    methodDescriptors.add(updateSiteMethodDescriptor);
    methodDescriptors.add(deleteSiteMethodDescriptor);
    methodDescriptors.add(listHardwareGroupsMethodDescriptor);
    methodDescriptors.add(getHardwareGroupMethodDescriptor);
    methodDescriptors.add(createHardwareGroupMethodDescriptor);
    methodDescriptors.add(updateHardwareGroupMethodDescriptor);
    methodDescriptors.add(deleteHardwareGroupMethodDescriptor);
    methodDescriptors.add(listHardwareMethodDescriptor);
    methodDescriptors.add(getHardwareMethodDescriptor);
    methodDescriptors.add(createHardwareMethodDescriptor);
    methodDescriptors.add(updateHardwareMethodDescriptor);
    methodDescriptors.add(deleteHardwareMethodDescriptor);
    methodDescriptors.add(listCommentsMethodDescriptor);
    methodDescriptors.add(getCommentMethodDescriptor);
    methodDescriptors.add(createCommentMethodDescriptor);
    methodDescriptors.add(recordActionOnCommentMethodDescriptor);
    methodDescriptors.add(listChangeLogEntriesMethodDescriptor);
    methodDescriptors.add(getChangeLogEntryMethodDescriptor);
    methodDescriptors.add(listSkusMethodDescriptor);
    methodDescriptors.add(getSkuMethodDescriptor);
    methodDescriptors.add(listZonesMethodDescriptor);
    methodDescriptors.add(getZoneMethodDescriptor);
    methodDescriptors.add(createZoneMethodDescriptor);
    methodDescriptors.add(updateZoneMethodDescriptor);
    methodDescriptors.add(deleteZoneMethodDescriptor);
    methodDescriptors.add(signalZoneStateMethodDescriptor);
    methodDescriptors.add(requestOrderDateChangeMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListOrdersRequest, ListOrdersResponse> listOrdersCallable() {
    return listOrdersCallable;
  }

  @Override
  public UnaryCallable<ListOrdersRequest, ListOrdersPagedResponse> listOrdersPagedCallable() {
    return listOrdersPagedCallable;
  }

  @Override
  public UnaryCallable<GetOrderRequest, Order> getOrderCallable() {
    return getOrderCallable;
  }

  @Override
  public UnaryCallable<CreateOrderRequest, Operation> createOrderCallable() {
    return createOrderCallable;
  }

  @Override
  public OperationCallable<CreateOrderRequest, Order, OperationMetadata>
      createOrderOperationCallable() {
    return createOrderOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateOrderRequest, Operation> updateOrderCallable() {
    return updateOrderCallable;
  }

  @Override
  public OperationCallable<UpdateOrderRequest, Order, OperationMetadata>
      updateOrderOperationCallable() {
    return updateOrderOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteOrderRequest, Operation> deleteOrderCallable() {
    return deleteOrderCallable;
  }

  @Override
  public OperationCallable<DeleteOrderRequest, Empty, OperationMetadata>
      deleteOrderOperationCallable() {
    return deleteOrderOperationCallable;
  }

  @Override
  public UnaryCallable<SubmitOrderRequest, Operation> submitOrderCallable() {
    return submitOrderCallable;
  }

  @Override
  public OperationCallable<SubmitOrderRequest, Order, OperationMetadata>
      submitOrderOperationCallable() {
    return submitOrderOperationCallable;
  }

  @Override
  public UnaryCallable<CancelOrderRequest, Operation> cancelOrderCallable() {
    return cancelOrderCallable;
  }

  @Override
  public OperationCallable<CancelOrderRequest, Order, OperationMetadata>
      cancelOrderOperationCallable() {
    return cancelOrderOperationCallable;
  }

  @Override
  public UnaryCallable<ListSitesRequest, ListSitesResponse> listSitesCallable() {
    return listSitesCallable;
  }

  @Override
  public UnaryCallable<ListSitesRequest, ListSitesPagedResponse> listSitesPagedCallable() {
    return listSitesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSiteRequest, Site> getSiteCallable() {
    return getSiteCallable;
  }

  @Override
  public UnaryCallable<CreateSiteRequest, Operation> createSiteCallable() {
    return createSiteCallable;
  }

  @Override
  public OperationCallable<CreateSiteRequest, Site, OperationMetadata>
      createSiteOperationCallable() {
    return createSiteOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateSiteRequest, Operation> updateSiteCallable() {
    return updateSiteCallable;
  }

  @Override
  public OperationCallable<UpdateSiteRequest, Site, OperationMetadata>
      updateSiteOperationCallable() {
    return updateSiteOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSiteRequest, Operation> deleteSiteCallable() {
    return deleteSiteCallable;
  }

  @Override
  public OperationCallable<DeleteSiteRequest, Empty, OperationMetadata>
      deleteSiteOperationCallable() {
    return deleteSiteOperationCallable;
  }

  @Override
  public UnaryCallable<ListHardwareGroupsRequest, ListHardwareGroupsResponse>
      listHardwareGroupsCallable() {
    return listHardwareGroupsCallable;
  }

  @Override
  public UnaryCallable<ListHardwareGroupsRequest, ListHardwareGroupsPagedResponse>
      listHardwareGroupsPagedCallable() {
    return listHardwareGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetHardwareGroupRequest, HardwareGroup> getHardwareGroupCallable() {
    return getHardwareGroupCallable;
  }

  @Override
  public UnaryCallable<CreateHardwareGroupRequest, Operation> createHardwareGroupCallable() {
    return createHardwareGroupCallable;
  }

  @Override
  public OperationCallable<CreateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      createHardwareGroupOperationCallable() {
    return createHardwareGroupOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateHardwareGroupRequest, Operation> updateHardwareGroupCallable() {
    return updateHardwareGroupCallable;
  }

  @Override
  public OperationCallable<UpdateHardwareGroupRequest, HardwareGroup, OperationMetadata>
      updateHardwareGroupOperationCallable() {
    return updateHardwareGroupOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteHardwareGroupRequest, Operation> deleteHardwareGroupCallable() {
    return deleteHardwareGroupCallable;
  }

  @Override
  public OperationCallable<DeleteHardwareGroupRequest, Empty, OperationMetadata>
      deleteHardwareGroupOperationCallable() {
    return deleteHardwareGroupOperationCallable;
  }

  @Override
  public UnaryCallable<ListHardwareRequest, ListHardwareResponse> listHardwareCallable() {
    return listHardwareCallable;
  }

  @Override
  public UnaryCallable<ListHardwareRequest, ListHardwarePagedResponse> listHardwarePagedCallable() {
    return listHardwarePagedCallable;
  }

  @Override
  public UnaryCallable<GetHardwareRequest, Hardware> getHardwareCallable() {
    return getHardwareCallable;
  }

  @Override
  public UnaryCallable<CreateHardwareRequest, Operation> createHardwareCallable() {
    return createHardwareCallable;
  }

  @Override
  public OperationCallable<CreateHardwareRequest, Hardware, OperationMetadata>
      createHardwareOperationCallable() {
    return createHardwareOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateHardwareRequest, Operation> updateHardwareCallable() {
    return updateHardwareCallable;
  }

  @Override
  public OperationCallable<UpdateHardwareRequest, Hardware, OperationMetadata>
      updateHardwareOperationCallable() {
    return updateHardwareOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteHardwareRequest, Operation> deleteHardwareCallable() {
    return deleteHardwareCallable;
  }

  @Override
  public OperationCallable<DeleteHardwareRequest, Empty, OperationMetadata>
      deleteHardwareOperationCallable() {
    return deleteHardwareOperationCallable;
  }

  @Override
  public UnaryCallable<ListCommentsRequest, ListCommentsResponse> listCommentsCallable() {
    return listCommentsCallable;
  }

  @Override
  public UnaryCallable<ListCommentsRequest, ListCommentsPagedResponse> listCommentsPagedCallable() {
    return listCommentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCommentRequest, Comment> getCommentCallable() {
    return getCommentCallable;
  }

  @Override
  public UnaryCallable<CreateCommentRequest, Operation> createCommentCallable() {
    return createCommentCallable;
  }

  @Override
  public OperationCallable<CreateCommentRequest, Comment, OperationMetadata>
      createCommentOperationCallable() {
    return createCommentOperationCallable;
  }

  @Override
  public UnaryCallable<RecordActionOnCommentRequest, Comment> recordActionOnCommentCallable() {
    return recordActionOnCommentCallable;
  }

  @Override
  public UnaryCallable<ListChangeLogEntriesRequest, ListChangeLogEntriesResponse>
      listChangeLogEntriesCallable() {
    return listChangeLogEntriesCallable;
  }

  @Override
  public UnaryCallable<ListChangeLogEntriesRequest, ListChangeLogEntriesPagedResponse>
      listChangeLogEntriesPagedCallable() {
    return listChangeLogEntriesPagedCallable;
  }

  @Override
  public UnaryCallable<GetChangeLogEntryRequest, ChangeLogEntry> getChangeLogEntryCallable() {
    return getChangeLogEntryCallable;
  }

  @Override
  public UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable() {
    return listSkusCallable;
  }

  @Override
  public UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable() {
    return listSkusPagedCallable;
  }

  @Override
  public UnaryCallable<GetSkuRequest, Sku> getSkuCallable() {
    return getSkuCallable;
  }

  @Override
  public UnaryCallable<ListZonesRequest, ListZonesResponse> listZonesCallable() {
    return listZonesCallable;
  }

  @Override
  public UnaryCallable<ListZonesRequest, ListZonesPagedResponse> listZonesPagedCallable() {
    return listZonesPagedCallable;
  }

  @Override
  public UnaryCallable<GetZoneRequest, Zone> getZoneCallable() {
    return getZoneCallable;
  }

  @Override
  public UnaryCallable<CreateZoneRequest, Operation> createZoneCallable() {
    return createZoneCallable;
  }

  @Override
  public OperationCallable<CreateZoneRequest, Zone, OperationMetadata>
      createZoneOperationCallable() {
    return createZoneOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateZoneRequest, Operation> updateZoneCallable() {
    return updateZoneCallable;
  }

  @Override
  public OperationCallable<UpdateZoneRequest, Zone, OperationMetadata>
      updateZoneOperationCallable() {
    return updateZoneOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteZoneRequest, Operation> deleteZoneCallable() {
    return deleteZoneCallable;
  }

  @Override
  public OperationCallable<DeleteZoneRequest, Empty, OperationMetadata>
      deleteZoneOperationCallable() {
    return deleteZoneOperationCallable;
  }

  @Override
  public UnaryCallable<SignalZoneStateRequest, Operation> signalZoneStateCallable() {
    return signalZoneStateCallable;
  }

  @Override
  public OperationCallable<SignalZoneStateRequest, Zone, OperationMetadata>
      signalZoneStateOperationCallable() {
    return signalZoneStateOperationCallable;
  }

  @Override
  public UnaryCallable<RequestOrderDateChangeRequest, Operation> requestOrderDateChangeCallable() {
    return requestOrderDateChangeCallable;
  }

  @Override
  public OperationCallable<RequestOrderDateChangeRequest, Order, OperationMetadata>
      requestOrderDateChangeOperationCallable() {
    return requestOrderDateChangeOperationCallable;
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
