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

import static com.google.ads.admanager.v1.ForecastAdjustmentServiceClient.ListForecastAdjustmentsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateForecastAdjustmentsRequest;
import com.google.ads.admanager.v1.BatchActivateForecastAdjustmentsResponse;
import com.google.ads.admanager.v1.BatchCreateForecastAdjustmentsRequest;
import com.google.ads.admanager.v1.BatchCreateForecastAdjustmentsResponse;
import com.google.ads.admanager.v1.BatchDeactivateForecastAdjustmentsRequest;
import com.google.ads.admanager.v1.BatchDeactivateForecastAdjustmentsResponse;
import com.google.ads.admanager.v1.BatchUpdateForecastAdjustmentsRequest;
import com.google.ads.admanager.v1.BatchUpdateForecastAdjustmentsResponse;
import com.google.ads.admanager.v1.CalculateDailyAdOpportunityCountsRequest;
import com.google.ads.admanager.v1.CalculateDailyAdOpportunityCountsResponse;
import com.google.ads.admanager.v1.CreateForecastAdjustmentRequest;
import com.google.ads.admanager.v1.ForecastAdjustment;
import com.google.ads.admanager.v1.GetForecastAdjustmentRequest;
import com.google.ads.admanager.v1.ListForecastAdjustmentsRequest;
import com.google.ads.admanager.v1.ListForecastAdjustmentsResponse;
import com.google.ads.admanager.v1.UpdateForecastAdjustmentRequest;
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
 * REST stub implementation for the ForecastAdjustmentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonForecastAdjustmentServiceStub extends ForecastAdjustmentServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetForecastAdjustmentRequest, ForecastAdjustment>
      getForecastAdjustmentMethodDescriptor =
          ApiMethodDescriptor.<GetForecastAdjustmentRequest, ForecastAdjustment>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ForecastAdjustmentService/GetForecastAdjustment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetForecastAdjustmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/forecastAdjustments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetForecastAdjustmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetForecastAdjustmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ForecastAdjustment>newBuilder()
                      .setDefaultInstance(ForecastAdjustment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListForecastAdjustmentsRequest, ListForecastAdjustmentsResponse>
      listForecastAdjustmentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListForecastAdjustmentsRequest, ListForecastAdjustmentsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ForecastAdjustmentService/ListForecastAdjustments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListForecastAdjustmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/forecastAdjustments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListForecastAdjustmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListForecastAdjustmentsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListForecastAdjustmentsResponse>newBuilder()
                      .setDefaultInstance(ListForecastAdjustmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateForecastAdjustmentRequest, ForecastAdjustment>
      createForecastAdjustmentMethodDescriptor =
          ApiMethodDescriptor.<CreateForecastAdjustmentRequest, ForecastAdjustment>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ForecastAdjustmentService/CreateForecastAdjustment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateForecastAdjustmentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/forecastAdjustments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateForecastAdjustmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateForecastAdjustmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "forecastAdjustment", request.getForecastAdjustment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ForecastAdjustment>newBuilder()
                      .setDefaultInstance(ForecastAdjustment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateForecastAdjustmentsRequest, BatchCreateForecastAdjustmentsResponse>
      batchCreateForecastAdjustmentsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateForecastAdjustmentsRequest, BatchCreateForecastAdjustmentsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ForecastAdjustmentService/BatchCreateForecastAdjustments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateForecastAdjustmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/forecastAdjustments:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateForecastAdjustmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateForecastAdjustmentsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateForecastAdjustmentsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchCreateForecastAdjustmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchActivateForecastAdjustmentsRequest, BatchActivateForecastAdjustmentsResponse>
      batchActivateForecastAdjustmentsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchActivateForecastAdjustmentsRequest, BatchActivateForecastAdjustmentsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ForecastAdjustmentService/BatchActivateForecastAdjustments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchActivateForecastAdjustmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/forecastAdjustments:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateForecastAdjustmentsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateForecastAdjustmentsRequest>
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
                  ProtoMessageResponseParser.<BatchActivateForecastAdjustmentsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchActivateForecastAdjustmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDeactivateForecastAdjustmentsRequest, BatchDeactivateForecastAdjustmentsResponse>
      batchDeactivateForecastAdjustmentsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDeactivateForecastAdjustmentsRequest,
                  BatchDeactivateForecastAdjustmentsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ForecastAdjustmentService/BatchDeactivateForecastAdjustments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchDeactivateForecastAdjustmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/forecastAdjustments:batchDeactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateForecastAdjustmentsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateForecastAdjustmentsRequest>
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
                      .<BatchDeactivateForecastAdjustmentsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchDeactivateForecastAdjustmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateForecastAdjustmentRequest, ForecastAdjustment>
      updateForecastAdjustmentMethodDescriptor =
          ApiMethodDescriptor.<UpdateForecastAdjustmentRequest, ForecastAdjustment>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ForecastAdjustmentService/UpdateForecastAdjustment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateForecastAdjustmentRequest>newBuilder()
                      .setPath(
                          "/v1/{forecastAdjustment.name=networks/*/forecastAdjustments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateForecastAdjustmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "forecastAdjustment.name",
                                request.getForecastAdjustment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateForecastAdjustmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "forecastAdjustment", request.getForecastAdjustment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ForecastAdjustment>newBuilder()
                      .setDefaultInstance(ForecastAdjustment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateForecastAdjustmentsRequest, BatchUpdateForecastAdjustmentsResponse>
      batchUpdateForecastAdjustmentsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateForecastAdjustmentsRequest, BatchUpdateForecastAdjustmentsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ForecastAdjustmentService/BatchUpdateForecastAdjustments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateForecastAdjustmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/forecastAdjustments:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateForecastAdjustmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateForecastAdjustmentsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateForecastAdjustmentsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchUpdateForecastAdjustmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CalculateDailyAdOpportunityCountsRequest, CalculateDailyAdOpportunityCountsResponse>
      calculateDailyAdOpportunityCountsMethodDescriptor =
          ApiMethodDescriptor
              .<CalculateDailyAdOpportunityCountsRequest, CalculateDailyAdOpportunityCountsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ForecastAdjustmentService/CalculateDailyAdOpportunityCounts")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CalculateDailyAdOpportunityCountsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/forecastAdjustments:calculateDailyAdOpportunityCounts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CalculateDailyAdOpportunityCountsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CalculateDailyAdOpportunityCountsRequest>
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
                  ProtoMessageResponseParser.<CalculateDailyAdOpportunityCountsResponse>newBuilder()
                      .setDefaultInstance(
                          CalculateDailyAdOpportunityCountsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetForecastAdjustmentRequest, ForecastAdjustment>
      getForecastAdjustmentCallable;
  private final UnaryCallable<ListForecastAdjustmentsRequest, ListForecastAdjustmentsResponse>
      listForecastAdjustmentsCallable;
  private final UnaryCallable<ListForecastAdjustmentsRequest, ListForecastAdjustmentsPagedResponse>
      listForecastAdjustmentsPagedCallable;
  private final UnaryCallable<CreateForecastAdjustmentRequest, ForecastAdjustment>
      createForecastAdjustmentCallable;
  private final UnaryCallable<
          BatchCreateForecastAdjustmentsRequest, BatchCreateForecastAdjustmentsResponse>
      batchCreateForecastAdjustmentsCallable;
  private final UnaryCallable<
          BatchActivateForecastAdjustmentsRequest, BatchActivateForecastAdjustmentsResponse>
      batchActivateForecastAdjustmentsCallable;
  private final UnaryCallable<
          BatchDeactivateForecastAdjustmentsRequest, BatchDeactivateForecastAdjustmentsResponse>
      batchDeactivateForecastAdjustmentsCallable;
  private final UnaryCallable<UpdateForecastAdjustmentRequest, ForecastAdjustment>
      updateForecastAdjustmentCallable;
  private final UnaryCallable<
          BatchUpdateForecastAdjustmentsRequest, BatchUpdateForecastAdjustmentsResponse>
      batchUpdateForecastAdjustmentsCallable;
  private final UnaryCallable<
          CalculateDailyAdOpportunityCountsRequest, CalculateDailyAdOpportunityCountsResponse>
      calculateDailyAdOpportunityCountsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonForecastAdjustmentServiceStub create(
      ForecastAdjustmentServiceStubSettings settings) throws IOException {
    return new HttpJsonForecastAdjustmentServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonForecastAdjustmentServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonForecastAdjustmentServiceStub(
        ForecastAdjustmentServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonForecastAdjustmentServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonForecastAdjustmentServiceStub(
        ForecastAdjustmentServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonForecastAdjustmentServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonForecastAdjustmentServiceStub(
      ForecastAdjustmentServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonForecastAdjustmentServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonForecastAdjustmentServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonForecastAdjustmentServiceStub(
      ForecastAdjustmentServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetForecastAdjustmentRequest, ForecastAdjustment>
        getForecastAdjustmentTransportSettings =
            HttpJsonCallSettings.<GetForecastAdjustmentRequest, ForecastAdjustment>newBuilder()
                .setMethodDescriptor(getForecastAdjustmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListForecastAdjustmentsRequest, ListForecastAdjustmentsResponse>
        listForecastAdjustmentsTransportSettings =
            HttpJsonCallSettings
                .<ListForecastAdjustmentsRequest, ListForecastAdjustmentsResponse>newBuilder()
                .setMethodDescriptor(listForecastAdjustmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateForecastAdjustmentRequest, ForecastAdjustment>
        createForecastAdjustmentTransportSettings =
            HttpJsonCallSettings.<CreateForecastAdjustmentRequest, ForecastAdjustment>newBuilder()
                .setMethodDescriptor(createForecastAdjustmentMethodDescriptor)
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
            BatchCreateForecastAdjustmentsRequest, BatchCreateForecastAdjustmentsResponse>
        batchCreateForecastAdjustmentsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateForecastAdjustmentsRequest, BatchCreateForecastAdjustmentsResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateForecastAdjustmentsMethodDescriptor)
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
            BatchActivateForecastAdjustmentsRequest, BatchActivateForecastAdjustmentsResponse>
        batchActivateForecastAdjustmentsTransportSettings =
            HttpJsonCallSettings
                .<BatchActivateForecastAdjustmentsRequest, BatchActivateForecastAdjustmentsResponse>
                    newBuilder()
                .setMethodDescriptor(batchActivateForecastAdjustmentsMethodDescriptor)
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
            BatchDeactivateForecastAdjustmentsRequest, BatchDeactivateForecastAdjustmentsResponse>
        batchDeactivateForecastAdjustmentsTransportSettings =
            HttpJsonCallSettings
                .<BatchDeactivateForecastAdjustmentsRequest,
                    BatchDeactivateForecastAdjustmentsResponse>
                    newBuilder()
                .setMethodDescriptor(batchDeactivateForecastAdjustmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateForecastAdjustmentRequest, ForecastAdjustment>
        updateForecastAdjustmentTransportSettings =
            HttpJsonCallSettings.<UpdateForecastAdjustmentRequest, ForecastAdjustment>newBuilder()
                .setMethodDescriptor(updateForecastAdjustmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "forecast_adjustment.name",
                          String.valueOf(request.getForecastAdjustment().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            BatchUpdateForecastAdjustmentsRequest, BatchUpdateForecastAdjustmentsResponse>
        batchUpdateForecastAdjustmentsTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateForecastAdjustmentsRequest, BatchUpdateForecastAdjustmentsResponse>
                    newBuilder()
                .setMethodDescriptor(batchUpdateForecastAdjustmentsMethodDescriptor)
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
            CalculateDailyAdOpportunityCountsRequest, CalculateDailyAdOpportunityCountsResponse>
        calculateDailyAdOpportunityCountsTransportSettings =
            HttpJsonCallSettings
                .<CalculateDailyAdOpportunityCountsRequest,
                    CalculateDailyAdOpportunityCountsResponse>
                    newBuilder()
                .setMethodDescriptor(calculateDailyAdOpportunityCountsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getForecastAdjustmentCallable =
        callableFactory.createUnaryCallable(
            getForecastAdjustmentTransportSettings,
            settings.getForecastAdjustmentSettings(),
            clientContext);
    this.listForecastAdjustmentsCallable =
        callableFactory.createUnaryCallable(
            listForecastAdjustmentsTransportSettings,
            settings.listForecastAdjustmentsSettings(),
            clientContext);
    this.listForecastAdjustmentsPagedCallable =
        callableFactory.createPagedCallable(
            listForecastAdjustmentsTransportSettings,
            settings.listForecastAdjustmentsSettings(),
            clientContext);
    this.createForecastAdjustmentCallable =
        callableFactory.createUnaryCallable(
            createForecastAdjustmentTransportSettings,
            settings.createForecastAdjustmentSettings(),
            clientContext);
    this.batchCreateForecastAdjustmentsCallable =
        callableFactory.createUnaryCallable(
            batchCreateForecastAdjustmentsTransportSettings,
            settings.batchCreateForecastAdjustmentsSettings(),
            clientContext);
    this.batchActivateForecastAdjustmentsCallable =
        callableFactory.createUnaryCallable(
            batchActivateForecastAdjustmentsTransportSettings,
            settings.batchActivateForecastAdjustmentsSettings(),
            clientContext);
    this.batchDeactivateForecastAdjustmentsCallable =
        callableFactory.createUnaryCallable(
            batchDeactivateForecastAdjustmentsTransportSettings,
            settings.batchDeactivateForecastAdjustmentsSettings(),
            clientContext);
    this.updateForecastAdjustmentCallable =
        callableFactory.createUnaryCallable(
            updateForecastAdjustmentTransportSettings,
            settings.updateForecastAdjustmentSettings(),
            clientContext);
    this.batchUpdateForecastAdjustmentsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateForecastAdjustmentsTransportSettings,
            settings.batchUpdateForecastAdjustmentsSettings(),
            clientContext);
    this.calculateDailyAdOpportunityCountsCallable =
        callableFactory.createUnaryCallable(
            calculateDailyAdOpportunityCountsTransportSettings,
            settings.calculateDailyAdOpportunityCountsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getForecastAdjustmentMethodDescriptor);
    methodDescriptors.add(listForecastAdjustmentsMethodDescriptor);
    methodDescriptors.add(createForecastAdjustmentMethodDescriptor);
    methodDescriptors.add(batchCreateForecastAdjustmentsMethodDescriptor);
    methodDescriptors.add(batchActivateForecastAdjustmentsMethodDescriptor);
    methodDescriptors.add(batchDeactivateForecastAdjustmentsMethodDescriptor);
    methodDescriptors.add(updateForecastAdjustmentMethodDescriptor);
    methodDescriptors.add(batchUpdateForecastAdjustmentsMethodDescriptor);
    methodDescriptors.add(calculateDailyAdOpportunityCountsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetForecastAdjustmentRequest, ForecastAdjustment>
      getForecastAdjustmentCallable() {
    return getForecastAdjustmentCallable;
  }

  @Override
  public UnaryCallable<ListForecastAdjustmentsRequest, ListForecastAdjustmentsResponse>
      listForecastAdjustmentsCallable() {
    return listForecastAdjustmentsCallable;
  }

  @Override
  public UnaryCallable<ListForecastAdjustmentsRequest, ListForecastAdjustmentsPagedResponse>
      listForecastAdjustmentsPagedCallable() {
    return listForecastAdjustmentsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateForecastAdjustmentRequest, ForecastAdjustment>
      createForecastAdjustmentCallable() {
    return createForecastAdjustmentCallable;
  }

  @Override
  public UnaryCallable<
          BatchCreateForecastAdjustmentsRequest, BatchCreateForecastAdjustmentsResponse>
      batchCreateForecastAdjustmentsCallable() {
    return batchCreateForecastAdjustmentsCallable;
  }

  @Override
  public UnaryCallable<
          BatchActivateForecastAdjustmentsRequest, BatchActivateForecastAdjustmentsResponse>
      batchActivateForecastAdjustmentsCallable() {
    return batchActivateForecastAdjustmentsCallable;
  }

  @Override
  public UnaryCallable<
          BatchDeactivateForecastAdjustmentsRequest, BatchDeactivateForecastAdjustmentsResponse>
      batchDeactivateForecastAdjustmentsCallable() {
    return batchDeactivateForecastAdjustmentsCallable;
  }

  @Override
  public UnaryCallable<UpdateForecastAdjustmentRequest, ForecastAdjustment>
      updateForecastAdjustmentCallable() {
    return updateForecastAdjustmentCallable;
  }

  @Override
  public UnaryCallable<
          BatchUpdateForecastAdjustmentsRequest, BatchUpdateForecastAdjustmentsResponse>
      batchUpdateForecastAdjustmentsCallable() {
    return batchUpdateForecastAdjustmentsCallable;
  }

  @Override
  public UnaryCallable<
          CalculateDailyAdOpportunityCountsRequest, CalculateDailyAdOpportunityCountsResponse>
      calculateDailyAdOpportunityCountsCallable() {
    return calculateDailyAdOpportunityCountsCallable;
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
