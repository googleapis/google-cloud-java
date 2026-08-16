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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.OrderServiceClient.ListOrdersPagedResponse;

import com.google.ads.admanager.v1.BatchApproveAndOverbookOrdersRequest;
import com.google.ads.admanager.v1.BatchApproveAndOverbookOrdersResponse;
import com.google.ads.admanager.v1.BatchApproveOrdersRequest;
import com.google.ads.admanager.v1.BatchApproveOrdersResponse;
import com.google.ads.admanager.v1.BatchApproveOrdersWithoutReservationRequest;
import com.google.ads.admanager.v1.BatchApproveOrdersWithoutReservationResponse;
import com.google.ads.admanager.v1.BatchArchiveOrdersRequest;
import com.google.ads.admanager.v1.BatchArchiveOrdersResponse;
import com.google.ads.admanager.v1.BatchCreateOrdersRequest;
import com.google.ads.admanager.v1.BatchCreateOrdersResponse;
import com.google.ads.admanager.v1.BatchDeleteOrdersRequest;
import com.google.ads.admanager.v1.BatchDeleteOrdersResponse;
import com.google.ads.admanager.v1.BatchDisapproveOrdersRequest;
import com.google.ads.admanager.v1.BatchDisapproveOrdersResponse;
import com.google.ads.admanager.v1.BatchDisapproveOrdersWithoutReservationChangesRequest;
import com.google.ads.admanager.v1.BatchDisapproveOrdersWithoutReservationChangesResponse;
import com.google.ads.admanager.v1.BatchPauseOrdersRequest;
import com.google.ads.admanager.v1.BatchPauseOrdersResponse;
import com.google.ads.admanager.v1.BatchResumeAndOverbookOrdersRequest;
import com.google.ads.admanager.v1.BatchResumeAndOverbookOrdersResponse;
import com.google.ads.admanager.v1.BatchResumeOrdersRequest;
import com.google.ads.admanager.v1.BatchResumeOrdersResponse;
import com.google.ads.admanager.v1.BatchRetractOrdersRequest;
import com.google.ads.admanager.v1.BatchRetractOrdersResponse;
import com.google.ads.admanager.v1.BatchRetractOrdersWithoutReservationChangesRequest;
import com.google.ads.admanager.v1.BatchRetractOrdersWithoutReservationChangesResponse;
import com.google.ads.admanager.v1.BatchSubmitOrdersForApprovalAndOverbookRequest;
import com.google.ads.admanager.v1.BatchSubmitOrdersForApprovalAndOverbookResponse;
import com.google.ads.admanager.v1.BatchSubmitOrdersForApprovalRequest;
import com.google.ads.admanager.v1.BatchSubmitOrdersForApprovalResponse;
import com.google.ads.admanager.v1.BatchSubmitOrdersForApprovalWithoutReservationChangesRequest;
import com.google.ads.admanager.v1.BatchSubmitOrdersForApprovalWithoutReservationChangesResponse;
import com.google.ads.admanager.v1.BatchUnarchiveOrdersRequest;
import com.google.ads.admanager.v1.BatchUnarchiveOrdersResponse;
import com.google.ads.admanager.v1.BatchUpdateOrdersRequest;
import com.google.ads.admanager.v1.BatchUpdateOrdersResponse;
import com.google.ads.admanager.v1.GetOrderRequest;
import com.google.ads.admanager.v1.ListOrdersRequest;
import com.google.ads.admanager.v1.ListOrdersResponse;
import com.google.ads.admanager.v1.Order;
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
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the OrderService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonOrderServiceStub extends OrderServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetOrderRequest, Order> getOrderMethodDescriptor =
      ApiMethodDescriptor.<GetOrderRequest, Order>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.OrderService/GetOrder")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetOrderRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/orders/*}",
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

  private static final ApiMethodDescriptor<ListOrdersRequest, ListOrdersResponse>
      listOrdersMethodDescriptor =
          ApiMethodDescriptor.<ListOrdersRequest, ListOrdersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.OrderService/ListOrders")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOrdersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders",
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
                            serializer.putQueryParam(fields, "skip", request.getSkip());
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

  private static final ApiMethodDescriptor<BatchCreateOrdersRequest, BatchCreateOrdersResponse>
      batchCreateOrdersMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateOrdersRequest, BatchCreateOrdersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.OrderService/BatchCreateOrders")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateOrdersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchCreateOrdersResponse>newBuilder()
                      .setDefaultInstance(BatchCreateOrdersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchUpdateOrdersRequest, BatchUpdateOrdersResponse>
      batchUpdateOrdersMethodDescriptor =
          ApiMethodDescriptor.<BatchUpdateOrdersRequest, BatchUpdateOrdersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.OrderService/BatchUpdateOrders")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateOrdersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchUpdateOrdersResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateOrdersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchApproveOrdersRequest, BatchApproveOrdersResponse>
      batchApproveOrdersMethodDescriptor =
          ApiMethodDescriptor.<BatchApproveOrdersRequest, BatchApproveOrdersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.OrderService/BatchApproveOrders")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchApproveOrdersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchApprove",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchApproveOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchApproveOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchApproveOrdersResponse>newBuilder()
                      .setDefaultInstance(BatchApproveOrdersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchApproveAndOverbookOrdersRequest, BatchApproveAndOverbookOrdersResponse>
      batchApproveAndOverbookOrdersMethodDescriptor =
          ApiMethodDescriptor
              .<BatchApproveAndOverbookOrdersRequest, BatchApproveAndOverbookOrdersResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.OrderService/BatchApproveAndOverbookOrders")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchApproveAndOverbookOrdersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchApproveAndOverbook",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchApproveAndOverbookOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchApproveAndOverbookOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchApproveAndOverbookOrdersResponse>newBuilder()
                      .setDefaultInstance(
                          BatchApproveAndOverbookOrdersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchSubmitOrdersForApprovalRequest, BatchSubmitOrdersForApprovalResponse>
      batchSubmitOrdersForApprovalMethodDescriptor =
          ApiMethodDescriptor
              .<BatchSubmitOrdersForApprovalRequest, BatchSubmitOrdersForApprovalResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.OrderService/BatchSubmitOrdersForApproval")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchSubmitOrdersForApprovalRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchSubmitForApproval",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchSubmitOrdersForApprovalRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchSubmitOrdersForApprovalRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchSubmitOrdersForApprovalResponse>newBuilder()
                      .setDefaultInstance(BatchSubmitOrdersForApprovalResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchSubmitOrdersForApprovalAndOverbookRequest,
          BatchSubmitOrdersForApprovalAndOverbookResponse>
      batchSubmitOrdersForApprovalAndOverbookMethodDescriptor =
          ApiMethodDescriptor
              .<BatchSubmitOrdersForApprovalAndOverbookRequest,
                  BatchSubmitOrdersForApprovalAndOverbookResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.OrderService/BatchSubmitOrdersForApprovalAndOverbook")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchSubmitOrdersForApprovalAndOverbookRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchSubmitForApprovalAndOverbook",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchSubmitOrdersForApprovalAndOverbookRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchSubmitOrdersForApprovalAndOverbookRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<BatchSubmitOrdersForApprovalAndOverbookResponse>newBuilder()
                      .setDefaultInstance(
                          BatchSubmitOrdersForApprovalAndOverbookResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchSubmitOrdersForApprovalWithoutReservationChangesRequest,
          BatchSubmitOrdersForApprovalWithoutReservationChangesResponse>
      batchSubmitOrdersForApprovalWithoutReservationChangesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchSubmitOrdersForApprovalWithoutReservationChangesRequest,
                  BatchSubmitOrdersForApprovalWithoutReservationChangesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.OrderService/BatchSubmitOrdersForApprovalWithoutReservationChanges")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchSubmitOrdersForApprovalWithoutReservationChangesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchSubmitForApprovalWithoutReservationChanges",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    BatchSubmitOrdersForApprovalWithoutReservationChangesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    BatchSubmitOrdersForApprovalWithoutReservationChangesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<BatchSubmitOrdersForApprovalWithoutReservationChangesResponse>newBuilder()
                      .setDefaultInstance(
                          BatchSubmitOrdersForApprovalWithoutReservationChangesResponse
                              .getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchPauseOrdersRequest, BatchPauseOrdersResponse>
      batchPauseOrdersMethodDescriptor =
          ApiMethodDescriptor.<BatchPauseOrdersRequest, BatchPauseOrdersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.OrderService/BatchPauseOrders")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchPauseOrdersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchPause",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchPauseOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchPauseOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchPauseOrdersResponse>newBuilder()
                      .setDefaultInstance(BatchPauseOrdersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchResumeOrdersRequest, BatchResumeOrdersResponse>
      batchResumeOrdersMethodDescriptor =
          ApiMethodDescriptor.<BatchResumeOrdersRequest, BatchResumeOrdersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.OrderService/BatchResumeOrders")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchResumeOrdersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchResume",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchResumeOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchResumeOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchResumeOrdersResponse>newBuilder()
                      .setDefaultInstance(BatchResumeOrdersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchResumeAndOverbookOrdersRequest, BatchResumeAndOverbookOrdersResponse>
      batchResumeAndOverbookOrdersMethodDescriptor =
          ApiMethodDescriptor
              .<BatchResumeAndOverbookOrdersRequest, BatchResumeAndOverbookOrdersResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.OrderService/BatchResumeAndOverbookOrders")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchResumeAndOverbookOrdersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchResumeAndOverbook",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchResumeAndOverbookOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchResumeAndOverbookOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchResumeAndOverbookOrdersResponse>newBuilder()
                      .setDefaultInstance(BatchResumeAndOverbookOrdersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchApproveOrdersWithoutReservationRequest, BatchApproveOrdersWithoutReservationResponse>
      batchApproveOrdersWithoutReservationMethodDescriptor =
          ApiMethodDescriptor
              .<BatchApproveOrdersWithoutReservationRequest,
                  BatchApproveOrdersWithoutReservationResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.OrderService/BatchApproveOrdersWithoutReservation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchApproveOrdersWithoutReservationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchApproveWithoutReservation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchApproveOrdersWithoutReservationRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchApproveOrdersWithoutReservationRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<BatchApproveOrdersWithoutReservationResponse>newBuilder()
                      .setDefaultInstance(
                          BatchApproveOrdersWithoutReservationResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchArchiveOrdersRequest, BatchArchiveOrdersResponse>
      batchArchiveOrdersMethodDescriptor =
          ApiMethodDescriptor.<BatchArchiveOrdersRequest, BatchArchiveOrdersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.OrderService/BatchArchiveOrders")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchArchiveOrdersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchArchive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchArchiveOrdersResponse>newBuilder()
                      .setDefaultInstance(BatchArchiveOrdersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUnarchiveOrdersRequest, BatchUnarchiveOrdersResponse>
      batchUnarchiveOrdersMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUnarchiveOrdersRequest, BatchUnarchiveOrdersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.OrderService/BatchUnarchiveOrders")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUnarchiveOrdersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchUnarchive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUnarchiveOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUnarchiveOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchUnarchiveOrdersResponse>newBuilder()
                      .setDefaultInstance(BatchUnarchiveOrdersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchDeleteOrdersRequest, BatchDeleteOrdersResponse>
      batchDeleteOrdersMethodDescriptor =
          ApiMethodDescriptor.<BatchDeleteOrdersRequest, BatchDeleteOrdersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.OrderService/BatchDeleteOrders")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeleteOrdersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchDeleteOrdersResponse>newBuilder()
                      .setDefaultInstance(BatchDeleteOrdersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDisapproveOrdersRequest, BatchDisapproveOrdersResponse>
      batchDisapproveOrdersMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDisapproveOrdersRequest, BatchDisapproveOrdersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.OrderService/BatchDisapproveOrders")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDisapproveOrdersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchDisapprove",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDisapproveOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDisapproveOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchDisapproveOrdersResponse>newBuilder()
                      .setDefaultInstance(BatchDisapproveOrdersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDisapproveOrdersWithoutReservationChangesRequest,
          BatchDisapproveOrdersWithoutReservationChangesResponse>
      batchDisapproveOrdersWithoutReservationChangesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDisapproveOrdersWithoutReservationChangesRequest,
                  BatchDisapproveOrdersWithoutReservationChangesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.OrderService/BatchDisapproveOrdersWithoutReservationChanges")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchDisapproveOrdersWithoutReservationChangesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchDisapproveWithoutReservationChanges",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    BatchDisapproveOrdersWithoutReservationChangesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    BatchDisapproveOrdersWithoutReservationChangesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<BatchDisapproveOrdersWithoutReservationChangesResponse>newBuilder()
                      .setDefaultInstance(
                          BatchDisapproveOrdersWithoutReservationChangesResponse
                              .getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchRetractOrdersRequest, BatchRetractOrdersResponse>
      batchRetractOrdersMethodDescriptor =
          ApiMethodDescriptor.<BatchRetractOrdersRequest, BatchRetractOrdersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.OrderService/BatchRetractOrders")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchRetractOrdersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchRetract",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRetractOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRetractOrdersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchRetractOrdersResponse>newBuilder()
                      .setDefaultInstance(BatchRetractOrdersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchRetractOrdersWithoutReservationChangesRequest,
          BatchRetractOrdersWithoutReservationChangesResponse>
      batchRetractOrdersWithoutReservationChangesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchRetractOrdersWithoutReservationChangesRequest,
                  BatchRetractOrdersWithoutReservationChangesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.OrderService/BatchRetractOrdersWithoutReservationChanges")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchRetractOrdersWithoutReservationChangesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/orders:batchRetractWithoutReservationChanges",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRetractOrdersWithoutReservationChangesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRetractOrdersWithoutReservationChangesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<BatchRetractOrdersWithoutReservationChangesResponse>newBuilder()
                      .setDefaultInstance(
                          BatchRetractOrdersWithoutReservationChangesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetOrderRequest, Order> getOrderCallable;
  private final UnaryCallable<ListOrdersRequest, ListOrdersResponse> listOrdersCallable;
  private final UnaryCallable<ListOrdersRequest, ListOrdersPagedResponse> listOrdersPagedCallable;
  private final UnaryCallable<BatchCreateOrdersRequest, BatchCreateOrdersResponse>
      batchCreateOrdersCallable;
  private final UnaryCallable<BatchUpdateOrdersRequest, BatchUpdateOrdersResponse>
      batchUpdateOrdersCallable;
  private final UnaryCallable<BatchApproveOrdersRequest, BatchApproveOrdersResponse>
      batchApproveOrdersCallable;
  private final UnaryCallable<
          BatchApproveAndOverbookOrdersRequest, BatchApproveAndOverbookOrdersResponse>
      batchApproveAndOverbookOrdersCallable;
  private final UnaryCallable<
          BatchSubmitOrdersForApprovalRequest, BatchSubmitOrdersForApprovalResponse>
      batchSubmitOrdersForApprovalCallable;
  private final UnaryCallable<
          BatchSubmitOrdersForApprovalAndOverbookRequest,
          BatchSubmitOrdersForApprovalAndOverbookResponse>
      batchSubmitOrdersForApprovalAndOverbookCallable;
  private final UnaryCallable<
          BatchSubmitOrdersForApprovalWithoutReservationChangesRequest,
          BatchSubmitOrdersForApprovalWithoutReservationChangesResponse>
      batchSubmitOrdersForApprovalWithoutReservationChangesCallable;
  private final UnaryCallable<BatchPauseOrdersRequest, BatchPauseOrdersResponse>
      batchPauseOrdersCallable;
  private final UnaryCallable<BatchResumeOrdersRequest, BatchResumeOrdersResponse>
      batchResumeOrdersCallable;
  private final UnaryCallable<
          BatchResumeAndOverbookOrdersRequest, BatchResumeAndOverbookOrdersResponse>
      batchResumeAndOverbookOrdersCallable;
  private final UnaryCallable<
          BatchApproveOrdersWithoutReservationRequest, BatchApproveOrdersWithoutReservationResponse>
      batchApproveOrdersWithoutReservationCallable;
  private final UnaryCallable<BatchArchiveOrdersRequest, BatchArchiveOrdersResponse>
      batchArchiveOrdersCallable;
  private final UnaryCallable<BatchUnarchiveOrdersRequest, BatchUnarchiveOrdersResponse>
      batchUnarchiveOrdersCallable;
  private final UnaryCallable<BatchDeleteOrdersRequest, BatchDeleteOrdersResponse>
      batchDeleteOrdersCallable;
  private final UnaryCallable<BatchDisapproveOrdersRequest, BatchDisapproveOrdersResponse>
      batchDisapproveOrdersCallable;
  private final UnaryCallable<
          BatchDisapproveOrdersWithoutReservationChangesRequest,
          BatchDisapproveOrdersWithoutReservationChangesResponse>
      batchDisapproveOrdersWithoutReservationChangesCallable;
  private final UnaryCallable<BatchRetractOrdersRequest, BatchRetractOrdersResponse>
      batchRetractOrdersCallable;
  private final UnaryCallable<
          BatchRetractOrdersWithoutReservationChangesRequest,
          BatchRetractOrdersWithoutReservationChangesResponse>
      batchRetractOrdersWithoutReservationChangesCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonOrderServiceStub create(OrderServiceStubSettings settings)
      throws IOException {
    return new HttpJsonOrderServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonOrderServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonOrderServiceStub(
        OrderServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonOrderServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonOrderServiceStub(
        OrderServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonOrderServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonOrderServiceStub(OrderServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonOrderServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonOrderServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonOrderServiceStub(
      OrderServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

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
            .setResourceNameExtractor(request -> request.getName())
            .build();
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
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<BatchCreateOrdersRequest, BatchCreateOrdersResponse>
        batchCreateOrdersTransportSettings =
            HttpJsonCallSettings.<BatchCreateOrdersRequest, BatchCreateOrdersResponse>newBuilder()
                .setMethodDescriptor(batchCreateOrdersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchUpdateOrdersRequest, BatchUpdateOrdersResponse>
        batchUpdateOrdersTransportSettings =
            HttpJsonCallSettings.<BatchUpdateOrdersRequest, BatchUpdateOrdersResponse>newBuilder()
                .setMethodDescriptor(batchUpdateOrdersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchApproveOrdersRequest, BatchApproveOrdersResponse>
        batchApproveOrdersTransportSettings =
            HttpJsonCallSettings.<BatchApproveOrdersRequest, BatchApproveOrdersResponse>newBuilder()
                .setMethodDescriptor(batchApproveOrdersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            BatchApproveAndOverbookOrdersRequest, BatchApproveAndOverbookOrdersResponse>
        batchApproveAndOverbookOrdersTransportSettings =
            HttpJsonCallSettings
                .<BatchApproveAndOverbookOrdersRequest, BatchApproveAndOverbookOrdersResponse>
                    newBuilder()
                .setMethodDescriptor(batchApproveAndOverbookOrdersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchSubmitOrdersForApprovalRequest, BatchSubmitOrdersForApprovalResponse>
        batchSubmitOrdersForApprovalTransportSettings =
            HttpJsonCallSettings
                .<BatchSubmitOrdersForApprovalRequest, BatchSubmitOrdersForApprovalResponse>
                    newBuilder()
                .setMethodDescriptor(batchSubmitOrdersForApprovalMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            BatchSubmitOrdersForApprovalAndOverbookRequest,
            BatchSubmitOrdersForApprovalAndOverbookResponse>
        batchSubmitOrdersForApprovalAndOverbookTransportSettings =
            HttpJsonCallSettings
                .<BatchSubmitOrdersForApprovalAndOverbookRequest,
                    BatchSubmitOrdersForApprovalAndOverbookResponse>
                    newBuilder()
                .setMethodDescriptor(batchSubmitOrdersForApprovalAndOverbookMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            BatchSubmitOrdersForApprovalWithoutReservationChangesRequest,
            BatchSubmitOrdersForApprovalWithoutReservationChangesResponse>
        batchSubmitOrdersForApprovalWithoutReservationChangesTransportSettings =
            HttpJsonCallSettings
                .<BatchSubmitOrdersForApprovalWithoutReservationChangesRequest,
                    BatchSubmitOrdersForApprovalWithoutReservationChangesResponse>
                    newBuilder()
                .setMethodDescriptor(
                    batchSubmitOrdersForApprovalWithoutReservationChangesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchPauseOrdersRequest, BatchPauseOrdersResponse>
        batchPauseOrdersTransportSettings =
            HttpJsonCallSettings.<BatchPauseOrdersRequest, BatchPauseOrdersResponse>newBuilder()
                .setMethodDescriptor(batchPauseOrdersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchResumeOrdersRequest, BatchResumeOrdersResponse>
        batchResumeOrdersTransportSettings =
            HttpJsonCallSettings.<BatchResumeOrdersRequest, BatchResumeOrdersResponse>newBuilder()
                .setMethodDescriptor(batchResumeOrdersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchResumeAndOverbookOrdersRequest, BatchResumeAndOverbookOrdersResponse>
        batchResumeAndOverbookOrdersTransportSettings =
            HttpJsonCallSettings
                .<BatchResumeAndOverbookOrdersRequest, BatchResumeAndOverbookOrdersResponse>
                    newBuilder()
                .setMethodDescriptor(batchResumeAndOverbookOrdersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            BatchApproveOrdersWithoutReservationRequest,
            BatchApproveOrdersWithoutReservationResponse>
        batchApproveOrdersWithoutReservationTransportSettings =
            HttpJsonCallSettings
                .<BatchApproveOrdersWithoutReservationRequest,
                    BatchApproveOrdersWithoutReservationResponse>
                    newBuilder()
                .setMethodDescriptor(batchApproveOrdersWithoutReservationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchArchiveOrdersRequest, BatchArchiveOrdersResponse>
        batchArchiveOrdersTransportSettings =
            HttpJsonCallSettings.<BatchArchiveOrdersRequest, BatchArchiveOrdersResponse>newBuilder()
                .setMethodDescriptor(batchArchiveOrdersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchUnarchiveOrdersRequest, BatchUnarchiveOrdersResponse>
        batchUnarchiveOrdersTransportSettings =
            HttpJsonCallSettings
                .<BatchUnarchiveOrdersRequest, BatchUnarchiveOrdersResponse>newBuilder()
                .setMethodDescriptor(batchUnarchiveOrdersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchDeleteOrdersRequest, BatchDeleteOrdersResponse>
        batchDeleteOrdersTransportSettings =
            HttpJsonCallSettings.<BatchDeleteOrdersRequest, BatchDeleteOrdersResponse>newBuilder()
                .setMethodDescriptor(batchDeleteOrdersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchDisapproveOrdersRequest, BatchDisapproveOrdersResponse>
        batchDisapproveOrdersTransportSettings =
            HttpJsonCallSettings
                .<BatchDisapproveOrdersRequest, BatchDisapproveOrdersResponse>newBuilder()
                .setMethodDescriptor(batchDisapproveOrdersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            BatchDisapproveOrdersWithoutReservationChangesRequest,
            BatchDisapproveOrdersWithoutReservationChangesResponse>
        batchDisapproveOrdersWithoutReservationChangesTransportSettings =
            HttpJsonCallSettings
                .<BatchDisapproveOrdersWithoutReservationChangesRequest,
                    BatchDisapproveOrdersWithoutReservationChangesResponse>
                    newBuilder()
                .setMethodDescriptor(batchDisapproveOrdersWithoutReservationChangesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchRetractOrdersRequest, BatchRetractOrdersResponse>
        batchRetractOrdersTransportSettings =
            HttpJsonCallSettings.<BatchRetractOrdersRequest, BatchRetractOrdersResponse>newBuilder()
                .setMethodDescriptor(batchRetractOrdersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            BatchRetractOrdersWithoutReservationChangesRequest,
            BatchRetractOrdersWithoutReservationChangesResponse>
        batchRetractOrdersWithoutReservationChangesTransportSettings =
            HttpJsonCallSettings
                .<BatchRetractOrdersWithoutReservationChangesRequest,
                    BatchRetractOrdersWithoutReservationChangesResponse>
                    newBuilder()
                .setMethodDescriptor(batchRetractOrdersWithoutReservationChangesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getOrderCallable =
        callableFactory.createUnaryCallable(
            getOrderTransportSettings, settings.getOrderSettings(), clientContext);
    this.listOrdersCallable =
        callableFactory.createUnaryCallable(
            listOrdersTransportSettings, settings.listOrdersSettings(), clientContext);
    this.listOrdersPagedCallable =
        callableFactory.createPagedCallable(
            listOrdersTransportSettings, settings.listOrdersSettings(), clientContext);
    this.batchCreateOrdersCallable =
        callableFactory.createUnaryCallable(
            batchCreateOrdersTransportSettings,
            settings.batchCreateOrdersSettings(),
            clientContext);
    this.batchUpdateOrdersCallable =
        callableFactory.createUnaryCallable(
            batchUpdateOrdersTransportSettings,
            settings.batchUpdateOrdersSettings(),
            clientContext);
    this.batchApproveOrdersCallable =
        callableFactory.createUnaryCallable(
            batchApproveOrdersTransportSettings,
            settings.batchApproveOrdersSettings(),
            clientContext);
    this.batchApproveAndOverbookOrdersCallable =
        callableFactory.createUnaryCallable(
            batchApproveAndOverbookOrdersTransportSettings,
            settings.batchApproveAndOverbookOrdersSettings(),
            clientContext);
    this.batchSubmitOrdersForApprovalCallable =
        callableFactory.createUnaryCallable(
            batchSubmitOrdersForApprovalTransportSettings,
            settings.batchSubmitOrdersForApprovalSettings(),
            clientContext);
    this.batchSubmitOrdersForApprovalAndOverbookCallable =
        callableFactory.createUnaryCallable(
            batchSubmitOrdersForApprovalAndOverbookTransportSettings,
            settings.batchSubmitOrdersForApprovalAndOverbookSettings(),
            clientContext);
    this.batchSubmitOrdersForApprovalWithoutReservationChangesCallable =
        callableFactory.createUnaryCallable(
            batchSubmitOrdersForApprovalWithoutReservationChangesTransportSettings,
            settings.batchSubmitOrdersForApprovalWithoutReservationChangesSettings(),
            clientContext);
    this.batchPauseOrdersCallable =
        callableFactory.createUnaryCallable(
            batchPauseOrdersTransportSettings, settings.batchPauseOrdersSettings(), clientContext);
    this.batchResumeOrdersCallable =
        callableFactory.createUnaryCallable(
            batchResumeOrdersTransportSettings,
            settings.batchResumeOrdersSettings(),
            clientContext);
    this.batchResumeAndOverbookOrdersCallable =
        callableFactory.createUnaryCallable(
            batchResumeAndOverbookOrdersTransportSettings,
            settings.batchResumeAndOverbookOrdersSettings(),
            clientContext);
    this.batchApproveOrdersWithoutReservationCallable =
        callableFactory.createUnaryCallable(
            batchApproveOrdersWithoutReservationTransportSettings,
            settings.batchApproveOrdersWithoutReservationSettings(),
            clientContext);
    this.batchArchiveOrdersCallable =
        callableFactory.createUnaryCallable(
            batchArchiveOrdersTransportSettings,
            settings.batchArchiveOrdersSettings(),
            clientContext);
    this.batchUnarchiveOrdersCallable =
        callableFactory.createUnaryCallable(
            batchUnarchiveOrdersTransportSettings,
            settings.batchUnarchiveOrdersSettings(),
            clientContext);
    this.batchDeleteOrdersCallable =
        callableFactory.createUnaryCallable(
            batchDeleteOrdersTransportSettings,
            settings.batchDeleteOrdersSettings(),
            clientContext);
    this.batchDisapproveOrdersCallable =
        callableFactory.createUnaryCallable(
            batchDisapproveOrdersTransportSettings,
            settings.batchDisapproveOrdersSettings(),
            clientContext);
    this.batchDisapproveOrdersWithoutReservationChangesCallable =
        callableFactory.createUnaryCallable(
            batchDisapproveOrdersWithoutReservationChangesTransportSettings,
            settings.batchDisapproveOrdersWithoutReservationChangesSettings(),
            clientContext);
    this.batchRetractOrdersCallable =
        callableFactory.createUnaryCallable(
            batchRetractOrdersTransportSettings,
            settings.batchRetractOrdersSettings(),
            clientContext);
    this.batchRetractOrdersWithoutReservationChangesCallable =
        callableFactory.createUnaryCallable(
            batchRetractOrdersWithoutReservationChangesTransportSettings,
            settings.batchRetractOrdersWithoutReservationChangesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getOrderMethodDescriptor);
    methodDescriptors.add(listOrdersMethodDescriptor);
    methodDescriptors.add(batchCreateOrdersMethodDescriptor);
    methodDescriptors.add(batchUpdateOrdersMethodDescriptor);
    methodDescriptors.add(batchApproveOrdersMethodDescriptor);
    methodDescriptors.add(batchApproveAndOverbookOrdersMethodDescriptor);
    methodDescriptors.add(batchSubmitOrdersForApprovalMethodDescriptor);
    methodDescriptors.add(batchSubmitOrdersForApprovalAndOverbookMethodDescriptor);
    methodDescriptors.add(batchSubmitOrdersForApprovalWithoutReservationChangesMethodDescriptor);
    methodDescriptors.add(batchPauseOrdersMethodDescriptor);
    methodDescriptors.add(batchResumeOrdersMethodDescriptor);
    methodDescriptors.add(batchResumeAndOverbookOrdersMethodDescriptor);
    methodDescriptors.add(batchApproveOrdersWithoutReservationMethodDescriptor);
    methodDescriptors.add(batchArchiveOrdersMethodDescriptor);
    methodDescriptors.add(batchUnarchiveOrdersMethodDescriptor);
    methodDescriptors.add(batchDeleteOrdersMethodDescriptor);
    methodDescriptors.add(batchDisapproveOrdersMethodDescriptor);
    methodDescriptors.add(batchDisapproveOrdersWithoutReservationChangesMethodDescriptor);
    methodDescriptors.add(batchRetractOrdersMethodDescriptor);
    methodDescriptors.add(batchRetractOrdersWithoutReservationChangesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetOrderRequest, Order> getOrderCallable() {
    return getOrderCallable;
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
  public UnaryCallable<BatchCreateOrdersRequest, BatchCreateOrdersResponse>
      batchCreateOrdersCallable() {
    return batchCreateOrdersCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateOrdersRequest, BatchUpdateOrdersResponse>
      batchUpdateOrdersCallable() {
    return batchUpdateOrdersCallable;
  }

  @Override
  public UnaryCallable<BatchApproveOrdersRequest, BatchApproveOrdersResponse>
      batchApproveOrdersCallable() {
    return batchApproveOrdersCallable;
  }

  @Override
  public UnaryCallable<BatchApproveAndOverbookOrdersRequest, BatchApproveAndOverbookOrdersResponse>
      batchApproveAndOverbookOrdersCallable() {
    return batchApproveAndOverbookOrdersCallable;
  }

  @Override
  public UnaryCallable<BatchSubmitOrdersForApprovalRequest, BatchSubmitOrdersForApprovalResponse>
      batchSubmitOrdersForApprovalCallable() {
    return batchSubmitOrdersForApprovalCallable;
  }

  @Override
  public UnaryCallable<
          BatchSubmitOrdersForApprovalAndOverbookRequest,
          BatchSubmitOrdersForApprovalAndOverbookResponse>
      batchSubmitOrdersForApprovalAndOverbookCallable() {
    return batchSubmitOrdersForApprovalAndOverbookCallable;
  }

  @Override
  public UnaryCallable<
          BatchSubmitOrdersForApprovalWithoutReservationChangesRequest,
          BatchSubmitOrdersForApprovalWithoutReservationChangesResponse>
      batchSubmitOrdersForApprovalWithoutReservationChangesCallable() {
    return batchSubmitOrdersForApprovalWithoutReservationChangesCallable;
  }

  @Override
  public UnaryCallable<BatchPauseOrdersRequest, BatchPauseOrdersResponse>
      batchPauseOrdersCallable() {
    return batchPauseOrdersCallable;
  }

  @Override
  public UnaryCallable<BatchResumeOrdersRequest, BatchResumeOrdersResponse>
      batchResumeOrdersCallable() {
    return batchResumeOrdersCallable;
  }

  @Override
  public UnaryCallable<BatchResumeAndOverbookOrdersRequest, BatchResumeAndOverbookOrdersResponse>
      batchResumeAndOverbookOrdersCallable() {
    return batchResumeAndOverbookOrdersCallable;
  }

  @Override
  public UnaryCallable<
          BatchApproveOrdersWithoutReservationRequest, BatchApproveOrdersWithoutReservationResponse>
      batchApproveOrdersWithoutReservationCallable() {
    return batchApproveOrdersWithoutReservationCallable;
  }

  @Override
  public UnaryCallable<BatchArchiveOrdersRequest, BatchArchiveOrdersResponse>
      batchArchiveOrdersCallable() {
    return batchArchiveOrdersCallable;
  }

  @Override
  public UnaryCallable<BatchUnarchiveOrdersRequest, BatchUnarchiveOrdersResponse>
      batchUnarchiveOrdersCallable() {
    return batchUnarchiveOrdersCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteOrdersRequest, BatchDeleteOrdersResponse>
      batchDeleteOrdersCallable() {
    return batchDeleteOrdersCallable;
  }

  @Override
  public UnaryCallable<BatchDisapproveOrdersRequest, BatchDisapproveOrdersResponse>
      batchDisapproveOrdersCallable() {
    return batchDisapproveOrdersCallable;
  }

  @Override
  public UnaryCallable<
          BatchDisapproveOrdersWithoutReservationChangesRequest,
          BatchDisapproveOrdersWithoutReservationChangesResponse>
      batchDisapproveOrdersWithoutReservationChangesCallable() {
    return batchDisapproveOrdersWithoutReservationChangesCallable;
  }

  @Override
  public UnaryCallable<BatchRetractOrdersRequest, BatchRetractOrdersResponse>
      batchRetractOrdersCallable() {
    return batchRetractOrdersCallable;
  }

  @Override
  public UnaryCallable<
          BatchRetractOrdersWithoutReservationChangesRequest,
          BatchRetractOrdersWithoutReservationChangesResponse>
      batchRetractOrdersWithoutReservationChangesCallable() {
    return batchRetractOrdersWithoutReservationChangesCallable;
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
