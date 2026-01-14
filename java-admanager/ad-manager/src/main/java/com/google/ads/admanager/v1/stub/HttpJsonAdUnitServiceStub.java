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

import static com.google.ads.admanager.v1.AdUnitServiceClient.ListAdUnitSizesPagedResponse;
import static com.google.ads.admanager.v1.AdUnitServiceClient.ListAdUnitsPagedResponse;

import com.google.ads.admanager.v1.AdUnit;
import com.google.ads.admanager.v1.BatchActivateAdUnitsRequest;
import com.google.ads.admanager.v1.BatchActivateAdUnitsResponse;
import com.google.ads.admanager.v1.BatchArchiveAdUnitsRequest;
import com.google.ads.admanager.v1.BatchArchiveAdUnitsResponse;
import com.google.ads.admanager.v1.BatchCreateAdUnitsRequest;
import com.google.ads.admanager.v1.BatchCreateAdUnitsResponse;
import com.google.ads.admanager.v1.BatchDeactivateAdUnitsRequest;
import com.google.ads.admanager.v1.BatchDeactivateAdUnitsResponse;
import com.google.ads.admanager.v1.BatchUpdateAdUnitsRequest;
import com.google.ads.admanager.v1.BatchUpdateAdUnitsResponse;
import com.google.ads.admanager.v1.CreateAdUnitRequest;
import com.google.ads.admanager.v1.GetAdUnitRequest;
import com.google.ads.admanager.v1.ListAdUnitSizesRequest;
import com.google.ads.admanager.v1.ListAdUnitSizesResponse;
import com.google.ads.admanager.v1.ListAdUnitsRequest;
import com.google.ads.admanager.v1.ListAdUnitsResponse;
import com.google.ads.admanager.v1.UpdateAdUnitRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AdUnitService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonAdUnitServiceStub extends AdUnitServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAdUnitRequest, AdUnit> getAdUnitMethodDescriptor =
      ApiMethodDescriptor.<GetAdUnitRequest, AdUnit>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.AdUnitService/GetAdUnit")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAdUnitRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/adUnits/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetAdUnitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetAdUnitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<AdUnit>newBuilder()
                  .setDefaultInstance(AdUnit.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListAdUnitsRequest, ListAdUnitsResponse>
      listAdUnitsMethodDescriptor =
          ApiMethodDescriptor.<ListAdUnitsRequest, ListAdUnitsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdUnitService/ListAdUnits")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAdUnitsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adUnits",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdUnitsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdUnitsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAdUnitsResponse>newBuilder()
                      .setDefaultInstance(ListAdUnitsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAdUnitSizesRequest, ListAdUnitSizesResponse>
      listAdUnitSizesMethodDescriptor =
          ApiMethodDescriptor.<ListAdUnitSizesRequest, ListAdUnitSizesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdUnitService/ListAdUnitSizes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAdUnitSizesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adUnitSizes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdUnitSizesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdUnitSizesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAdUnitSizesResponse>newBuilder()
                      .setDefaultInstance(ListAdUnitSizesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAdUnitRequest, AdUnit>
      createAdUnitMethodDescriptor =
          ApiMethodDescriptor.<CreateAdUnitRequest, AdUnit>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdUnitService/CreateAdUnit")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAdUnitRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adUnits",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAdUnitRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAdUnitRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("adUnit", request.getAdUnit(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdUnit>newBuilder()
                      .setDefaultInstance(AdUnit.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAdUnitRequest, AdUnit>
      updateAdUnitMethodDescriptor =
          ApiMethodDescriptor.<UpdateAdUnitRequest, AdUnit>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdUnitService/UpdateAdUnit")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAdUnitRequest>newBuilder()
                      .setPath(
                          "/v1/{adUnit.name=networks/*/adUnits/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAdUnitRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "adUnit.name", request.getAdUnit().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAdUnitRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("adUnit", request.getAdUnit(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdUnit>newBuilder()
                      .setDefaultInstance(AdUnit.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchCreateAdUnitsRequest, BatchCreateAdUnitsResponse>
      batchCreateAdUnitsMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateAdUnitsRequest, BatchCreateAdUnitsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdUnitService/BatchCreateAdUnits")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateAdUnitsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adUnits:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateAdUnitsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateAdUnitsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateAdUnitsResponse>newBuilder()
                      .setDefaultInstance(BatchCreateAdUnitsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchUpdateAdUnitsRequest, BatchUpdateAdUnitsResponse>
      batchUpdateAdUnitsMethodDescriptor =
          ApiMethodDescriptor.<BatchUpdateAdUnitsRequest, BatchUpdateAdUnitsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdUnitService/BatchUpdateAdUnits")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateAdUnitsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adUnits:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateAdUnitsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateAdUnitsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateAdUnitsResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateAdUnitsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchActivateAdUnitsRequest, BatchActivateAdUnitsResponse>
      batchActivateAdUnitsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchActivateAdUnitsRequest, BatchActivateAdUnitsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdUnitService/BatchActivateAdUnits")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchActivateAdUnitsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adUnits:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateAdUnitsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateAdUnitsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchActivateAdUnitsResponse>newBuilder()
                      .setDefaultInstance(BatchActivateAdUnitsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDeactivateAdUnitsRequest, BatchDeactivateAdUnitsResponse>
      batchDeactivateAdUnitsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDeactivateAdUnitsRequest, BatchDeactivateAdUnitsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdUnitService/BatchDeactivateAdUnits")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeactivateAdUnitsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adUnits:batchDeactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateAdUnitsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateAdUnitsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchDeactivateAdUnitsResponse>newBuilder()
                      .setDefaultInstance(BatchDeactivateAdUnitsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchArchiveAdUnitsRequest, BatchArchiveAdUnitsResponse>
      batchArchiveAdUnitsMethodDescriptor =
          ApiMethodDescriptor.<BatchArchiveAdUnitsRequest, BatchArchiveAdUnitsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdUnitService/BatchArchiveAdUnits")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchArchiveAdUnitsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adUnits:batchArchive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveAdUnitsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveAdUnitsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchArchiveAdUnitsResponse>newBuilder()
                      .setDefaultInstance(BatchArchiveAdUnitsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetAdUnitRequest, AdUnit> getAdUnitCallable;
  private final UnaryCallable<ListAdUnitsRequest, ListAdUnitsResponse> listAdUnitsCallable;
  private final UnaryCallable<ListAdUnitsRequest, ListAdUnitsPagedResponse>
      listAdUnitsPagedCallable;
  private final UnaryCallable<ListAdUnitSizesRequest, ListAdUnitSizesResponse>
      listAdUnitSizesCallable;
  private final UnaryCallable<ListAdUnitSizesRequest, ListAdUnitSizesPagedResponse>
      listAdUnitSizesPagedCallable;
  private final UnaryCallable<CreateAdUnitRequest, AdUnit> createAdUnitCallable;
  private final UnaryCallable<UpdateAdUnitRequest, AdUnit> updateAdUnitCallable;
  private final UnaryCallable<BatchCreateAdUnitsRequest, BatchCreateAdUnitsResponse>
      batchCreateAdUnitsCallable;
  private final UnaryCallable<BatchUpdateAdUnitsRequest, BatchUpdateAdUnitsResponse>
      batchUpdateAdUnitsCallable;
  private final UnaryCallable<BatchActivateAdUnitsRequest, BatchActivateAdUnitsResponse>
      batchActivateAdUnitsCallable;
  private final UnaryCallable<BatchDeactivateAdUnitsRequest, BatchDeactivateAdUnitsResponse>
      batchDeactivateAdUnitsCallable;
  private final UnaryCallable<BatchArchiveAdUnitsRequest, BatchArchiveAdUnitsResponse>
      batchArchiveAdUnitsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAdUnitServiceStub create(AdUnitServiceStubSettings settings)
      throws IOException {
    return new HttpJsonAdUnitServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAdUnitServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAdUnitServiceStub(
        AdUnitServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonAdUnitServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAdUnitServiceStub(
        AdUnitServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAdUnitServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAdUnitServiceStub(
      AdUnitServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAdUnitServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAdUnitServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAdUnitServiceStub(
      AdUnitServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAdUnitRequest, AdUnit> getAdUnitTransportSettings =
        HttpJsonCallSettings.<GetAdUnitRequest, AdUnit>newBuilder()
            .setMethodDescriptor(getAdUnitMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAdUnitsRequest, ListAdUnitsResponse> listAdUnitsTransportSettings =
        HttpJsonCallSettings.<ListAdUnitsRequest, ListAdUnitsResponse>newBuilder()
            .setMethodDescriptor(listAdUnitsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAdUnitSizesRequest, ListAdUnitSizesResponse>
        listAdUnitSizesTransportSettings =
            HttpJsonCallSettings.<ListAdUnitSizesRequest, ListAdUnitSizesResponse>newBuilder()
                .setMethodDescriptor(listAdUnitSizesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateAdUnitRequest, AdUnit> createAdUnitTransportSettings =
        HttpJsonCallSettings.<CreateAdUnitRequest, AdUnit>newBuilder()
            .setMethodDescriptor(createAdUnitMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAdUnitRequest, AdUnit> updateAdUnitTransportSettings =
        HttpJsonCallSettings.<UpdateAdUnitRequest, AdUnit>newBuilder()
            .setMethodDescriptor(updateAdUnitMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("ad_unit.name", String.valueOf(request.getAdUnit().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchCreateAdUnitsRequest, BatchCreateAdUnitsResponse>
        batchCreateAdUnitsTransportSettings =
            HttpJsonCallSettings.<BatchCreateAdUnitsRequest, BatchCreateAdUnitsResponse>newBuilder()
                .setMethodDescriptor(batchCreateAdUnitsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchUpdateAdUnitsRequest, BatchUpdateAdUnitsResponse>
        batchUpdateAdUnitsTransportSettings =
            HttpJsonCallSettings.<BatchUpdateAdUnitsRequest, BatchUpdateAdUnitsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateAdUnitsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchActivateAdUnitsRequest, BatchActivateAdUnitsResponse>
        batchActivateAdUnitsTransportSettings =
            HttpJsonCallSettings
                .<BatchActivateAdUnitsRequest, BatchActivateAdUnitsResponse>newBuilder()
                .setMethodDescriptor(batchActivateAdUnitsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchDeactivateAdUnitsRequest, BatchDeactivateAdUnitsResponse>
        batchDeactivateAdUnitsTransportSettings =
            HttpJsonCallSettings
                .<BatchDeactivateAdUnitsRequest, BatchDeactivateAdUnitsResponse>newBuilder()
                .setMethodDescriptor(batchDeactivateAdUnitsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchArchiveAdUnitsRequest, BatchArchiveAdUnitsResponse>
        batchArchiveAdUnitsTransportSettings =
            HttpJsonCallSettings
                .<BatchArchiveAdUnitsRequest, BatchArchiveAdUnitsResponse>newBuilder()
                .setMethodDescriptor(batchArchiveAdUnitsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getAdUnitCallable =
        callableFactory.createUnaryCallable(
            getAdUnitTransportSettings, settings.getAdUnitSettings(), clientContext);
    this.listAdUnitsCallable =
        callableFactory.createUnaryCallable(
            listAdUnitsTransportSettings, settings.listAdUnitsSettings(), clientContext);
    this.listAdUnitsPagedCallable =
        callableFactory.createPagedCallable(
            listAdUnitsTransportSettings, settings.listAdUnitsSettings(), clientContext);
    this.listAdUnitSizesCallable =
        callableFactory.createUnaryCallable(
            listAdUnitSizesTransportSettings, settings.listAdUnitSizesSettings(), clientContext);
    this.listAdUnitSizesPagedCallable =
        callableFactory.createPagedCallable(
            listAdUnitSizesTransportSettings, settings.listAdUnitSizesSettings(), clientContext);
    this.createAdUnitCallable =
        callableFactory.createUnaryCallable(
            createAdUnitTransportSettings, settings.createAdUnitSettings(), clientContext);
    this.updateAdUnitCallable =
        callableFactory.createUnaryCallable(
            updateAdUnitTransportSettings, settings.updateAdUnitSettings(), clientContext);
    this.batchCreateAdUnitsCallable =
        callableFactory.createUnaryCallable(
            batchCreateAdUnitsTransportSettings,
            settings.batchCreateAdUnitsSettings(),
            clientContext);
    this.batchUpdateAdUnitsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateAdUnitsTransportSettings,
            settings.batchUpdateAdUnitsSettings(),
            clientContext);
    this.batchActivateAdUnitsCallable =
        callableFactory.createUnaryCallable(
            batchActivateAdUnitsTransportSettings,
            settings.batchActivateAdUnitsSettings(),
            clientContext);
    this.batchDeactivateAdUnitsCallable =
        callableFactory.createUnaryCallable(
            batchDeactivateAdUnitsTransportSettings,
            settings.batchDeactivateAdUnitsSettings(),
            clientContext);
    this.batchArchiveAdUnitsCallable =
        callableFactory.createUnaryCallable(
            batchArchiveAdUnitsTransportSettings,
            settings.batchArchiveAdUnitsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAdUnitMethodDescriptor);
    methodDescriptors.add(listAdUnitsMethodDescriptor);
    methodDescriptors.add(listAdUnitSizesMethodDescriptor);
    methodDescriptors.add(createAdUnitMethodDescriptor);
    methodDescriptors.add(updateAdUnitMethodDescriptor);
    methodDescriptors.add(batchCreateAdUnitsMethodDescriptor);
    methodDescriptors.add(batchUpdateAdUnitsMethodDescriptor);
    methodDescriptors.add(batchActivateAdUnitsMethodDescriptor);
    methodDescriptors.add(batchDeactivateAdUnitsMethodDescriptor);
    methodDescriptors.add(batchArchiveAdUnitsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAdUnitRequest, AdUnit> getAdUnitCallable() {
    return getAdUnitCallable;
  }

  @Override
  public UnaryCallable<ListAdUnitsRequest, ListAdUnitsResponse> listAdUnitsCallable() {
    return listAdUnitsCallable;
  }

  @Override
  public UnaryCallable<ListAdUnitsRequest, ListAdUnitsPagedResponse> listAdUnitsPagedCallable() {
    return listAdUnitsPagedCallable;
  }

  @Override
  public UnaryCallable<ListAdUnitSizesRequest, ListAdUnitSizesResponse> listAdUnitSizesCallable() {
    return listAdUnitSizesCallable;
  }

  @Override
  public UnaryCallable<ListAdUnitSizesRequest, ListAdUnitSizesPagedResponse>
      listAdUnitSizesPagedCallable() {
    return listAdUnitSizesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateAdUnitRequest, AdUnit> createAdUnitCallable() {
    return createAdUnitCallable;
  }

  @Override
  public UnaryCallable<UpdateAdUnitRequest, AdUnit> updateAdUnitCallable() {
    return updateAdUnitCallable;
  }

  @Override
  public UnaryCallable<BatchCreateAdUnitsRequest, BatchCreateAdUnitsResponse>
      batchCreateAdUnitsCallable() {
    return batchCreateAdUnitsCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateAdUnitsRequest, BatchUpdateAdUnitsResponse>
      batchUpdateAdUnitsCallable() {
    return batchUpdateAdUnitsCallable;
  }

  @Override
  public UnaryCallable<BatchActivateAdUnitsRequest, BatchActivateAdUnitsResponse>
      batchActivateAdUnitsCallable() {
    return batchActivateAdUnitsCallable;
  }

  @Override
  public UnaryCallable<BatchDeactivateAdUnitsRequest, BatchDeactivateAdUnitsResponse>
      batchDeactivateAdUnitsCallable() {
    return batchDeactivateAdUnitsCallable;
  }

  @Override
  public UnaryCallable<BatchArchiveAdUnitsRequest, BatchArchiveAdUnitsResponse>
      batchArchiveAdUnitsCallable() {
    return batchArchiveAdUnitsCallable;
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
