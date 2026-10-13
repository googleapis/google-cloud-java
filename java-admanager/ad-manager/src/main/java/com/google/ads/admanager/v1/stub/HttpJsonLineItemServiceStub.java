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

import static com.google.ads.admanager.v1.LineItemServiceClient.ListLineItemsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateLineItemsRequest;
import com.google.ads.admanager.v1.BatchActivateLineItemsResponse;
import com.google.ads.admanager.v1.BatchArchiveLineItemsRequest;
import com.google.ads.admanager.v1.BatchArchiveLineItemsResponse;
import com.google.ads.admanager.v1.BatchCreateLineItemsRequest;
import com.google.ads.admanager.v1.BatchCreateLineItemsResponse;
import com.google.ads.admanager.v1.BatchDeleteLineItemsRequest;
import com.google.ads.admanager.v1.BatchPauseLineItemsRequest;
import com.google.ads.admanager.v1.BatchPauseLineItemsResponse;
import com.google.ads.admanager.v1.BatchReleaseLineItemsRequest;
import com.google.ads.admanager.v1.BatchReleaseLineItemsResponse;
import com.google.ads.admanager.v1.BatchReserveAndOverbookLineItemsRequest;
import com.google.ads.admanager.v1.BatchReserveAndOverbookLineItemsResponse;
import com.google.ads.admanager.v1.BatchReserveLineItemsRequest;
import com.google.ads.admanager.v1.BatchReserveLineItemsResponse;
import com.google.ads.admanager.v1.BatchResumeAndOverbookLineItemsRequest;
import com.google.ads.admanager.v1.BatchResumeAndOverbookLineItemsResponse;
import com.google.ads.admanager.v1.BatchResumeLineItemsRequest;
import com.google.ads.admanager.v1.BatchResumeLineItemsResponse;
import com.google.ads.admanager.v1.BatchUnarchiveLineItemsRequest;
import com.google.ads.admanager.v1.BatchUnarchiveLineItemsResponse;
import com.google.ads.admanager.v1.BatchUpdateLineItemsRequest;
import com.google.ads.admanager.v1.BatchUpdateLineItemsResponse;
import com.google.ads.admanager.v1.CreateLineItemRequest;
import com.google.ads.admanager.v1.GetLineItemRequest;
import com.google.ads.admanager.v1.LineItem;
import com.google.ads.admanager.v1.ListLineItemsRequest;
import com.google.ads.admanager.v1.ListLineItemsResponse;
import com.google.ads.admanager.v1.UpdateLineItemRequest;
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
import com.google.protobuf.Empty;
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
 * REST stub implementation for the LineItemService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonLineItemServiceStub extends LineItemServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetLineItemRequest, LineItem>
      getLineItemMethodDescriptor =
          ApiMethodDescriptor.<GetLineItemRequest, LineItem>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LineItemService/GetLineItem")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLineItemRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/lineItems/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLineItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLineItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LineItem>newBuilder()
                      .setDefaultInstance(LineItem.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLineItemsRequest, ListLineItemsResponse>
      listLineItemsMethodDescriptor =
          ApiMethodDescriptor.<ListLineItemsRequest, ListLineItemsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LineItemService/ListLineItems")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLineItemsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/lineItems",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLineItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLineItemsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListLineItemsResponse>newBuilder()
                      .setDefaultInstance(ListLineItemsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateLineItemRequest, LineItem>
      createLineItemMethodDescriptor =
          ApiMethodDescriptor.<CreateLineItemRequest, LineItem>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LineItemService/CreateLineItem")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateLineItemRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/lineItems",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLineItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLineItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("lineItem", request.getLineItem(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LineItem>newBuilder()
                      .setDefaultInstance(LineItem.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateLineItemsRequest, BatchCreateLineItemsResponse>
      batchCreateLineItemsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateLineItemsRequest, BatchCreateLineItemsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LineItemService/BatchCreateLineItems")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateLineItemsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/lineItems:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateLineItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateLineItemsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateLineItemsResponse>newBuilder()
                      .setDefaultInstance(BatchCreateLineItemsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateLineItemRequest, LineItem>
      updateLineItemMethodDescriptor =
          ApiMethodDescriptor.<UpdateLineItemRequest, LineItem>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LineItemService/UpdateLineItem")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateLineItemRequest>newBuilder()
                      .setPath(
                          "/v1/{lineItem.name=networks/*/lineItems/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLineItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "lineItem.name", request.getLineItem().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLineItemRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("lineItem", request.getLineItem(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LineItem>newBuilder()
                      .setDefaultInstance(LineItem.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateLineItemsRequest, BatchUpdateLineItemsResponse>
      batchUpdateLineItemsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateLineItemsRequest, BatchUpdateLineItemsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LineItemService/BatchUpdateLineItems")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateLineItemsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/lineItems:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateLineItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateLineItemsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateLineItemsResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateLineItemsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchActivateLineItemsRequest, BatchActivateLineItemsResponse>
      batchActivateLineItemsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchActivateLineItemsRequest, BatchActivateLineItemsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LineItemService/BatchActivateLineItems")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchActivateLineItemsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/lineItems:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateLineItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateLineItemsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchActivateLineItemsResponse>newBuilder()
                      .setDefaultInstance(BatchActivateLineItemsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchPauseLineItemsRequest, BatchPauseLineItemsResponse>
      batchPauseLineItemsMethodDescriptor =
          ApiMethodDescriptor.<BatchPauseLineItemsRequest, BatchPauseLineItemsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LineItemService/BatchPauseLineItems")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchPauseLineItemsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/lineItems:batchPause",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchPauseLineItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchPauseLineItemsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchPauseLineItemsResponse>newBuilder()
                      .setDefaultInstance(BatchPauseLineItemsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchResumeLineItemsRequest, BatchResumeLineItemsResponse>
      batchResumeLineItemsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchResumeLineItemsRequest, BatchResumeLineItemsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LineItemService/BatchResumeLineItems")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchResumeLineItemsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/lineItems:batchResume",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchResumeLineItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchResumeLineItemsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchResumeLineItemsResponse>newBuilder()
                      .setDefaultInstance(BatchResumeLineItemsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchResumeAndOverbookLineItemsRequest, BatchResumeAndOverbookLineItemsResponse>
      batchResumeAndOverbookLineItemsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchResumeAndOverbookLineItemsRequest, BatchResumeAndOverbookLineItemsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LineItemService/BatchResumeAndOverbookLineItems")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchResumeAndOverbookLineItemsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/lineItems:batchResumeAndOverbook",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchResumeAndOverbookLineItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchResumeAndOverbookLineItemsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchResumeAndOverbookLineItemsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchResumeAndOverbookLineItemsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchDeleteLineItemsRequest, Empty>
      batchDeleteLineItemsMethodDescriptor =
          ApiMethodDescriptor.<BatchDeleteLineItemsRequest, Empty>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LineItemService/BatchDeleteLineItems")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeleteLineItemsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/lineItems:batchDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteLineItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteLineItemsRequest> serializer =
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
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchReserveLineItemsRequest, BatchReserveLineItemsResponse>
      batchReserveLineItemsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchReserveLineItemsRequest, BatchReserveLineItemsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LineItemService/BatchReserveLineItems")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchReserveLineItemsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/lineItems:batchReserve",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchReserveLineItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchReserveLineItemsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchReserveLineItemsResponse>newBuilder()
                      .setDefaultInstance(BatchReserveLineItemsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchReserveAndOverbookLineItemsRequest, BatchReserveAndOverbookLineItemsResponse>
      batchReserveAndOverbookLineItemsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchReserveAndOverbookLineItemsRequest, BatchReserveAndOverbookLineItemsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LineItemService/BatchReserveAndOverbookLineItems")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchReserveAndOverbookLineItemsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/lineItems:batchReserveAndOverbook",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchReserveAndOverbookLineItemsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchReserveAndOverbookLineItemsRequest>
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
                  ProtoMessageResponseParser.<BatchReserveAndOverbookLineItemsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchReserveAndOverbookLineItemsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchReleaseLineItemsRequest, BatchReleaseLineItemsResponse>
      batchReleaseLineItemsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchReleaseLineItemsRequest, BatchReleaseLineItemsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LineItemService/BatchReleaseLineItems")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchReleaseLineItemsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/lineItems:batchRelease",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchReleaseLineItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchReleaseLineItemsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchReleaseLineItemsResponse>newBuilder()
                      .setDefaultInstance(BatchReleaseLineItemsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchArchiveLineItemsRequest, BatchArchiveLineItemsResponse>
      batchArchiveLineItemsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchArchiveLineItemsRequest, BatchArchiveLineItemsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LineItemService/BatchArchiveLineItems")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchArchiveLineItemsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/lineItems:batchArchive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveLineItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveLineItemsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchArchiveLineItemsResponse>newBuilder()
                      .setDefaultInstance(BatchArchiveLineItemsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUnarchiveLineItemsRequest, BatchUnarchiveLineItemsResponse>
      batchUnarchiveLineItemsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUnarchiveLineItemsRequest, BatchUnarchiveLineItemsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.LineItemService/BatchUnarchiveLineItems")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUnarchiveLineItemsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/lineItems:batchUnarchive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUnarchiveLineItemsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUnarchiveLineItemsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUnarchiveLineItemsResponse>newBuilder()
                      .setDefaultInstance(BatchUnarchiveLineItemsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetLineItemRequest, LineItem> getLineItemCallable;
  private final UnaryCallable<ListLineItemsRequest, ListLineItemsResponse> listLineItemsCallable;
  private final UnaryCallable<ListLineItemsRequest, ListLineItemsPagedResponse>
      listLineItemsPagedCallable;
  private final UnaryCallable<CreateLineItemRequest, LineItem> createLineItemCallable;
  private final UnaryCallable<BatchCreateLineItemsRequest, BatchCreateLineItemsResponse>
      batchCreateLineItemsCallable;
  private final UnaryCallable<UpdateLineItemRequest, LineItem> updateLineItemCallable;
  private final UnaryCallable<BatchUpdateLineItemsRequest, BatchUpdateLineItemsResponse>
      batchUpdateLineItemsCallable;
  private final UnaryCallable<BatchActivateLineItemsRequest, BatchActivateLineItemsResponse>
      batchActivateLineItemsCallable;
  private final UnaryCallable<BatchPauseLineItemsRequest, BatchPauseLineItemsResponse>
      batchPauseLineItemsCallable;
  private final UnaryCallable<BatchResumeLineItemsRequest, BatchResumeLineItemsResponse>
      batchResumeLineItemsCallable;
  private final UnaryCallable<
          BatchResumeAndOverbookLineItemsRequest, BatchResumeAndOverbookLineItemsResponse>
      batchResumeAndOverbookLineItemsCallable;
  private final UnaryCallable<BatchDeleteLineItemsRequest, Empty> batchDeleteLineItemsCallable;
  private final UnaryCallable<BatchReserveLineItemsRequest, BatchReserveLineItemsResponse>
      batchReserveLineItemsCallable;
  private final UnaryCallable<
          BatchReserveAndOverbookLineItemsRequest, BatchReserveAndOverbookLineItemsResponse>
      batchReserveAndOverbookLineItemsCallable;
  private final UnaryCallable<BatchReleaseLineItemsRequest, BatchReleaseLineItemsResponse>
      batchReleaseLineItemsCallable;
  private final UnaryCallable<BatchArchiveLineItemsRequest, BatchArchiveLineItemsResponse>
      batchArchiveLineItemsCallable;
  private final UnaryCallable<BatchUnarchiveLineItemsRequest, BatchUnarchiveLineItemsResponse>
      batchUnarchiveLineItemsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLineItemServiceStub create(LineItemServiceStubSettings settings)
      throws IOException {
    return new HttpJsonLineItemServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLineItemServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLineItemServiceStub(
        LineItemServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonLineItemServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLineItemServiceStub(
        LineItemServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLineItemServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLineItemServiceStub(
      LineItemServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonLineItemServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLineItemServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLineItemServiceStub(
      LineItemServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetLineItemRequest, LineItem> getLineItemTransportSettings =
        HttpJsonCallSettings.<GetLineItemRequest, LineItem>newBuilder()
            .setMethodDescriptor(getLineItemMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListLineItemsRequest, ListLineItemsResponse>
        listLineItemsTransportSettings =
            HttpJsonCallSettings.<ListLineItemsRequest, ListLineItemsResponse>newBuilder()
                .setMethodDescriptor(listLineItemsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateLineItemRequest, LineItem> createLineItemTransportSettings =
        HttpJsonCallSettings.<CreateLineItemRequest, LineItem>newBuilder()
            .setMethodDescriptor(createLineItemMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<BatchCreateLineItemsRequest, BatchCreateLineItemsResponse>
        batchCreateLineItemsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateLineItemsRequest, BatchCreateLineItemsResponse>newBuilder()
                .setMethodDescriptor(batchCreateLineItemsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateLineItemRequest, LineItem> updateLineItemTransportSettings =
        HttpJsonCallSettings.<UpdateLineItemRequest, LineItem>newBuilder()
            .setMethodDescriptor(updateLineItemMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("line_item.name", String.valueOf(request.getLineItem().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdateLineItemsRequest, BatchUpdateLineItemsResponse>
        batchUpdateLineItemsTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateLineItemsRequest, BatchUpdateLineItemsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateLineItemsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchActivateLineItemsRequest, BatchActivateLineItemsResponse>
        batchActivateLineItemsTransportSettings =
            HttpJsonCallSettings
                .<BatchActivateLineItemsRequest, BatchActivateLineItemsResponse>newBuilder()
                .setMethodDescriptor(batchActivateLineItemsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchPauseLineItemsRequest, BatchPauseLineItemsResponse>
        batchPauseLineItemsTransportSettings =
            HttpJsonCallSettings
                .<BatchPauseLineItemsRequest, BatchPauseLineItemsResponse>newBuilder()
                .setMethodDescriptor(batchPauseLineItemsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchResumeLineItemsRequest, BatchResumeLineItemsResponse>
        batchResumeLineItemsTransportSettings =
            HttpJsonCallSettings
                .<BatchResumeLineItemsRequest, BatchResumeLineItemsResponse>newBuilder()
                .setMethodDescriptor(batchResumeLineItemsMethodDescriptor)
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
            BatchResumeAndOverbookLineItemsRequest, BatchResumeAndOverbookLineItemsResponse>
        batchResumeAndOverbookLineItemsTransportSettings =
            HttpJsonCallSettings
                .<BatchResumeAndOverbookLineItemsRequest, BatchResumeAndOverbookLineItemsResponse>
                    newBuilder()
                .setMethodDescriptor(batchResumeAndOverbookLineItemsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchDeleteLineItemsRequest, Empty> batchDeleteLineItemsTransportSettings =
        HttpJsonCallSettings.<BatchDeleteLineItemsRequest, Empty>newBuilder()
            .setMethodDescriptor(batchDeleteLineItemsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<BatchReserveLineItemsRequest, BatchReserveLineItemsResponse>
        batchReserveLineItemsTransportSettings =
            HttpJsonCallSettings
                .<BatchReserveLineItemsRequest, BatchReserveLineItemsResponse>newBuilder()
                .setMethodDescriptor(batchReserveLineItemsMethodDescriptor)
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
            BatchReserveAndOverbookLineItemsRequest, BatchReserveAndOverbookLineItemsResponse>
        batchReserveAndOverbookLineItemsTransportSettings =
            HttpJsonCallSettings
                .<BatchReserveAndOverbookLineItemsRequest, BatchReserveAndOverbookLineItemsResponse>
                    newBuilder()
                .setMethodDescriptor(batchReserveAndOverbookLineItemsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchReleaseLineItemsRequest, BatchReleaseLineItemsResponse>
        batchReleaseLineItemsTransportSettings =
            HttpJsonCallSettings
                .<BatchReleaseLineItemsRequest, BatchReleaseLineItemsResponse>newBuilder()
                .setMethodDescriptor(batchReleaseLineItemsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchArchiveLineItemsRequest, BatchArchiveLineItemsResponse>
        batchArchiveLineItemsTransportSettings =
            HttpJsonCallSettings
                .<BatchArchiveLineItemsRequest, BatchArchiveLineItemsResponse>newBuilder()
                .setMethodDescriptor(batchArchiveLineItemsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchUnarchiveLineItemsRequest, BatchUnarchiveLineItemsResponse>
        batchUnarchiveLineItemsTransportSettings =
            HttpJsonCallSettings
                .<BatchUnarchiveLineItemsRequest, BatchUnarchiveLineItemsResponse>newBuilder()
                .setMethodDescriptor(batchUnarchiveLineItemsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getLineItemCallable =
        callableFactory.createUnaryCallable(
            getLineItemTransportSettings, settings.getLineItemSettings(), clientContext);
    this.listLineItemsCallable =
        callableFactory.createUnaryCallable(
            listLineItemsTransportSettings, settings.listLineItemsSettings(), clientContext);
    this.listLineItemsPagedCallable =
        callableFactory.createPagedCallable(
            listLineItemsTransportSettings, settings.listLineItemsSettings(), clientContext);
    this.createLineItemCallable =
        callableFactory.createUnaryCallable(
            createLineItemTransportSettings, settings.createLineItemSettings(), clientContext);
    this.batchCreateLineItemsCallable =
        callableFactory.createUnaryCallable(
            batchCreateLineItemsTransportSettings,
            settings.batchCreateLineItemsSettings(),
            clientContext);
    this.updateLineItemCallable =
        callableFactory.createUnaryCallable(
            updateLineItemTransportSettings, settings.updateLineItemSettings(), clientContext);
    this.batchUpdateLineItemsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateLineItemsTransportSettings,
            settings.batchUpdateLineItemsSettings(),
            clientContext);
    this.batchActivateLineItemsCallable =
        callableFactory.createUnaryCallable(
            batchActivateLineItemsTransportSettings,
            settings.batchActivateLineItemsSettings(),
            clientContext);
    this.batchPauseLineItemsCallable =
        callableFactory.createUnaryCallable(
            batchPauseLineItemsTransportSettings,
            settings.batchPauseLineItemsSettings(),
            clientContext);
    this.batchResumeLineItemsCallable =
        callableFactory.createUnaryCallable(
            batchResumeLineItemsTransportSettings,
            settings.batchResumeLineItemsSettings(),
            clientContext);
    this.batchResumeAndOverbookLineItemsCallable =
        callableFactory.createUnaryCallable(
            batchResumeAndOverbookLineItemsTransportSettings,
            settings.batchResumeAndOverbookLineItemsSettings(),
            clientContext);
    this.batchDeleteLineItemsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteLineItemsTransportSettings,
            settings.batchDeleteLineItemsSettings(),
            clientContext);
    this.batchReserveLineItemsCallable =
        callableFactory.createUnaryCallable(
            batchReserveLineItemsTransportSettings,
            settings.batchReserveLineItemsSettings(),
            clientContext);
    this.batchReserveAndOverbookLineItemsCallable =
        callableFactory.createUnaryCallable(
            batchReserveAndOverbookLineItemsTransportSettings,
            settings.batchReserveAndOverbookLineItemsSettings(),
            clientContext);
    this.batchReleaseLineItemsCallable =
        callableFactory.createUnaryCallable(
            batchReleaseLineItemsTransportSettings,
            settings.batchReleaseLineItemsSettings(),
            clientContext);
    this.batchArchiveLineItemsCallable =
        callableFactory.createUnaryCallable(
            batchArchiveLineItemsTransportSettings,
            settings.batchArchiveLineItemsSettings(),
            clientContext);
    this.batchUnarchiveLineItemsCallable =
        callableFactory.createUnaryCallable(
            batchUnarchiveLineItemsTransportSettings,
            settings.batchUnarchiveLineItemsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getLineItemMethodDescriptor);
    methodDescriptors.add(listLineItemsMethodDescriptor);
    methodDescriptors.add(createLineItemMethodDescriptor);
    methodDescriptors.add(batchCreateLineItemsMethodDescriptor);
    methodDescriptors.add(updateLineItemMethodDescriptor);
    methodDescriptors.add(batchUpdateLineItemsMethodDescriptor);
    methodDescriptors.add(batchActivateLineItemsMethodDescriptor);
    methodDescriptors.add(batchPauseLineItemsMethodDescriptor);
    methodDescriptors.add(batchResumeLineItemsMethodDescriptor);
    methodDescriptors.add(batchResumeAndOverbookLineItemsMethodDescriptor);
    methodDescriptors.add(batchDeleteLineItemsMethodDescriptor);
    methodDescriptors.add(batchReserveLineItemsMethodDescriptor);
    methodDescriptors.add(batchReserveAndOverbookLineItemsMethodDescriptor);
    methodDescriptors.add(batchReleaseLineItemsMethodDescriptor);
    methodDescriptors.add(batchArchiveLineItemsMethodDescriptor);
    methodDescriptors.add(batchUnarchiveLineItemsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetLineItemRequest, LineItem> getLineItemCallable() {
    return getLineItemCallable;
  }

  @Override
  public UnaryCallable<ListLineItemsRequest, ListLineItemsResponse> listLineItemsCallable() {
    return listLineItemsCallable;
  }

  @Override
  public UnaryCallable<ListLineItemsRequest, ListLineItemsPagedResponse>
      listLineItemsPagedCallable() {
    return listLineItemsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateLineItemRequest, LineItem> createLineItemCallable() {
    return createLineItemCallable;
  }

  @Override
  public UnaryCallable<BatchCreateLineItemsRequest, BatchCreateLineItemsResponse>
      batchCreateLineItemsCallable() {
    return batchCreateLineItemsCallable;
  }

  @Override
  public UnaryCallable<UpdateLineItemRequest, LineItem> updateLineItemCallable() {
    return updateLineItemCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateLineItemsRequest, BatchUpdateLineItemsResponse>
      batchUpdateLineItemsCallable() {
    return batchUpdateLineItemsCallable;
  }

  @Override
  public UnaryCallable<BatchActivateLineItemsRequest, BatchActivateLineItemsResponse>
      batchActivateLineItemsCallable() {
    return batchActivateLineItemsCallable;
  }

  @Override
  public UnaryCallable<BatchPauseLineItemsRequest, BatchPauseLineItemsResponse>
      batchPauseLineItemsCallable() {
    return batchPauseLineItemsCallable;
  }

  @Override
  public UnaryCallable<BatchResumeLineItemsRequest, BatchResumeLineItemsResponse>
      batchResumeLineItemsCallable() {
    return batchResumeLineItemsCallable;
  }

  @Override
  public UnaryCallable<
          BatchResumeAndOverbookLineItemsRequest, BatchResumeAndOverbookLineItemsResponse>
      batchResumeAndOverbookLineItemsCallable() {
    return batchResumeAndOverbookLineItemsCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteLineItemsRequest, Empty> batchDeleteLineItemsCallable() {
    return batchDeleteLineItemsCallable;
  }

  @Override
  public UnaryCallable<BatchReserveLineItemsRequest, BatchReserveLineItemsResponse>
      batchReserveLineItemsCallable() {
    return batchReserveLineItemsCallable;
  }

  @Override
  public UnaryCallable<
          BatchReserveAndOverbookLineItemsRequest, BatchReserveAndOverbookLineItemsResponse>
      batchReserveAndOverbookLineItemsCallable() {
    return batchReserveAndOverbookLineItemsCallable;
  }

  @Override
  public UnaryCallable<BatchReleaseLineItemsRequest, BatchReleaseLineItemsResponse>
      batchReleaseLineItemsCallable() {
    return batchReleaseLineItemsCallable;
  }

  @Override
  public UnaryCallable<BatchArchiveLineItemsRequest, BatchArchiveLineItemsResponse>
      batchArchiveLineItemsCallable() {
    return batchArchiveLineItemsCallable;
  }

  @Override
  public UnaryCallable<BatchUnarchiveLineItemsRequest, BatchUnarchiveLineItemsResponse>
      batchUnarchiveLineItemsCallable() {
    return batchUnarchiveLineItemsCallable;
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
