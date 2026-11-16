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

import static com.google.ads.admanager.v1.YieldGroupServiceClient.ListYieldGroupsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateYieldGroupsRequest;
import com.google.ads.admanager.v1.BatchActivateYieldGroupsResponse;
import com.google.ads.admanager.v1.BatchArchiveYieldGroupsRequest;
import com.google.ads.admanager.v1.BatchArchiveYieldGroupsResponse;
import com.google.ads.admanager.v1.BatchCreateYieldGroupsRequest;
import com.google.ads.admanager.v1.BatchCreateYieldGroupsResponse;
import com.google.ads.admanager.v1.BatchDeactivateYieldGroupsRequest;
import com.google.ads.admanager.v1.BatchDeactivateYieldGroupsResponse;
import com.google.ads.admanager.v1.BatchUpdateYieldGroupsRequest;
import com.google.ads.admanager.v1.BatchUpdateYieldGroupsResponse;
import com.google.ads.admanager.v1.CreateYieldGroupRequest;
import com.google.ads.admanager.v1.GetYieldGroupRequest;
import com.google.ads.admanager.v1.ListYieldGroupsRequest;
import com.google.ads.admanager.v1.ListYieldGroupsResponse;
import com.google.ads.admanager.v1.UpdateYieldGroupRequest;
import com.google.ads.admanager.v1.YieldGroup;
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
 * REST stub implementation for the YieldGroupService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonYieldGroupServiceStub extends YieldGroupServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetYieldGroupRequest, YieldGroup>
      getYieldGroupMethodDescriptor =
          ApiMethodDescriptor.<GetYieldGroupRequest, YieldGroup>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.YieldGroupService/GetYieldGroup")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetYieldGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/yieldGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetYieldGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetYieldGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<YieldGroup>newBuilder()
                      .setDefaultInstance(YieldGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListYieldGroupsRequest, ListYieldGroupsResponse>
      listYieldGroupsMethodDescriptor =
          ApiMethodDescriptor.<ListYieldGroupsRequest, ListYieldGroupsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.YieldGroupService/ListYieldGroups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListYieldGroupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/yieldGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListYieldGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListYieldGroupsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListYieldGroupsResponse>newBuilder()
                      .setDefaultInstance(ListYieldGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateYieldGroupRequest, YieldGroup>
      createYieldGroupMethodDescriptor =
          ApiMethodDescriptor.<CreateYieldGroupRequest, YieldGroup>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.YieldGroupService/CreateYieldGroup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateYieldGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/yieldGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateYieldGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateYieldGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("yieldGroup", request.getYieldGroup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<YieldGroup>newBuilder()
                      .setDefaultInstance(YieldGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateYieldGroupsRequest, BatchCreateYieldGroupsResponse>
      batchCreateYieldGroupsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateYieldGroupsRequest, BatchCreateYieldGroupsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.YieldGroupService/BatchCreateYieldGroups")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateYieldGroupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/yieldGroups:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateYieldGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateYieldGroupsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateYieldGroupsResponse>newBuilder()
                      .setDefaultInstance(BatchCreateYieldGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateYieldGroupRequest, YieldGroup>
      updateYieldGroupMethodDescriptor =
          ApiMethodDescriptor.<UpdateYieldGroupRequest, YieldGroup>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.YieldGroupService/UpdateYieldGroup")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateYieldGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{yieldGroup.name=networks/*/yieldGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateYieldGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "yieldGroup.name", request.getYieldGroup().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateYieldGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("yieldGroup", request.getYieldGroup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<YieldGroup>newBuilder()
                      .setDefaultInstance(YieldGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateYieldGroupsRequest, BatchUpdateYieldGroupsResponse>
      batchUpdateYieldGroupsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateYieldGroupsRequest, BatchUpdateYieldGroupsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.YieldGroupService/BatchUpdateYieldGroups")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateYieldGroupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/yieldGroups:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateYieldGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateYieldGroupsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateYieldGroupsResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateYieldGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchActivateYieldGroupsRequest, BatchActivateYieldGroupsResponse>
      batchActivateYieldGroupsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchActivateYieldGroupsRequest, BatchActivateYieldGroupsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.YieldGroupService/BatchActivateYieldGroups")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchActivateYieldGroupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/yieldGroups:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateYieldGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateYieldGroupsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchActivateYieldGroupsResponse>newBuilder()
                      .setDefaultInstance(BatchActivateYieldGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDeactivateYieldGroupsRequest, BatchDeactivateYieldGroupsResponse>
      batchDeactivateYieldGroupsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDeactivateYieldGroupsRequest, BatchDeactivateYieldGroupsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.YieldGroupService/BatchDeactivateYieldGroups")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeactivateYieldGroupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/yieldGroups:batchDeactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateYieldGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateYieldGroupsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchDeactivateYieldGroupsResponse>newBuilder()
                      .setDefaultInstance(BatchDeactivateYieldGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchArchiveYieldGroupsRequest, BatchArchiveYieldGroupsResponse>
      batchArchiveYieldGroupsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchArchiveYieldGroupsRequest, BatchArchiveYieldGroupsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.YieldGroupService/BatchArchiveYieldGroups")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchArchiveYieldGroupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/yieldGroups:batchArchive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveYieldGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveYieldGroupsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchArchiveYieldGroupsResponse>newBuilder()
                      .setDefaultInstance(BatchArchiveYieldGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetYieldGroupRequest, YieldGroup> getYieldGroupCallable;
  private final UnaryCallable<ListYieldGroupsRequest, ListYieldGroupsResponse>
      listYieldGroupsCallable;
  private final UnaryCallable<ListYieldGroupsRequest, ListYieldGroupsPagedResponse>
      listYieldGroupsPagedCallable;
  private final UnaryCallable<CreateYieldGroupRequest, YieldGroup> createYieldGroupCallable;
  private final UnaryCallable<BatchCreateYieldGroupsRequest, BatchCreateYieldGroupsResponse>
      batchCreateYieldGroupsCallable;
  private final UnaryCallable<UpdateYieldGroupRequest, YieldGroup> updateYieldGroupCallable;
  private final UnaryCallable<BatchUpdateYieldGroupsRequest, BatchUpdateYieldGroupsResponse>
      batchUpdateYieldGroupsCallable;
  private final UnaryCallable<BatchActivateYieldGroupsRequest, BatchActivateYieldGroupsResponse>
      batchActivateYieldGroupsCallable;
  private final UnaryCallable<BatchDeactivateYieldGroupsRequest, BatchDeactivateYieldGroupsResponse>
      batchDeactivateYieldGroupsCallable;
  private final UnaryCallable<BatchArchiveYieldGroupsRequest, BatchArchiveYieldGroupsResponse>
      batchArchiveYieldGroupsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonYieldGroupServiceStub create(YieldGroupServiceStubSettings settings)
      throws IOException {
    return new HttpJsonYieldGroupServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonYieldGroupServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonYieldGroupServiceStub(
        YieldGroupServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonYieldGroupServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonYieldGroupServiceStub(
        YieldGroupServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonYieldGroupServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonYieldGroupServiceStub(
      YieldGroupServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonYieldGroupServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonYieldGroupServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonYieldGroupServiceStub(
      YieldGroupServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetYieldGroupRequest, YieldGroup> getYieldGroupTransportSettings =
        HttpJsonCallSettings.<GetYieldGroupRequest, YieldGroup>newBuilder()
            .setMethodDescriptor(getYieldGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListYieldGroupsRequest, ListYieldGroupsResponse>
        listYieldGroupsTransportSettings =
            HttpJsonCallSettings.<ListYieldGroupsRequest, ListYieldGroupsResponse>newBuilder()
                .setMethodDescriptor(listYieldGroupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateYieldGroupRequest, YieldGroup> createYieldGroupTransportSettings =
        HttpJsonCallSettings.<CreateYieldGroupRequest, YieldGroup>newBuilder()
            .setMethodDescriptor(createYieldGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<BatchCreateYieldGroupsRequest, BatchCreateYieldGroupsResponse>
        batchCreateYieldGroupsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateYieldGroupsRequest, BatchCreateYieldGroupsResponse>newBuilder()
                .setMethodDescriptor(batchCreateYieldGroupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateYieldGroupRequest, YieldGroup> updateYieldGroupTransportSettings =
        HttpJsonCallSettings.<UpdateYieldGroupRequest, YieldGroup>newBuilder()
            .setMethodDescriptor(updateYieldGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "yield_group.name", String.valueOf(request.getYieldGroup().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdateYieldGroupsRequest, BatchUpdateYieldGroupsResponse>
        batchUpdateYieldGroupsTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateYieldGroupsRequest, BatchUpdateYieldGroupsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateYieldGroupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchActivateYieldGroupsRequest, BatchActivateYieldGroupsResponse>
        batchActivateYieldGroupsTransportSettings =
            HttpJsonCallSettings
                .<BatchActivateYieldGroupsRequest, BatchActivateYieldGroupsResponse>newBuilder()
                .setMethodDescriptor(batchActivateYieldGroupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchDeactivateYieldGroupsRequest, BatchDeactivateYieldGroupsResponse>
        batchDeactivateYieldGroupsTransportSettings =
            HttpJsonCallSettings
                .<BatchDeactivateYieldGroupsRequest, BatchDeactivateYieldGroupsResponse>newBuilder()
                .setMethodDescriptor(batchDeactivateYieldGroupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchArchiveYieldGroupsRequest, BatchArchiveYieldGroupsResponse>
        batchArchiveYieldGroupsTransportSettings =
            HttpJsonCallSettings
                .<BatchArchiveYieldGroupsRequest, BatchArchiveYieldGroupsResponse>newBuilder()
                .setMethodDescriptor(batchArchiveYieldGroupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getYieldGroupCallable =
        callableFactory.createUnaryCallable(
            getYieldGroupTransportSettings, settings.getYieldGroupSettings(), clientContext);
    this.listYieldGroupsCallable =
        callableFactory.createUnaryCallable(
            listYieldGroupsTransportSettings, settings.listYieldGroupsSettings(), clientContext);
    this.listYieldGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listYieldGroupsTransportSettings, settings.listYieldGroupsSettings(), clientContext);
    this.createYieldGroupCallable =
        callableFactory.createUnaryCallable(
            createYieldGroupTransportSettings, settings.createYieldGroupSettings(), clientContext);
    this.batchCreateYieldGroupsCallable =
        callableFactory.createUnaryCallable(
            batchCreateYieldGroupsTransportSettings,
            settings.batchCreateYieldGroupsSettings(),
            clientContext);
    this.updateYieldGroupCallable =
        callableFactory.createUnaryCallable(
            updateYieldGroupTransportSettings, settings.updateYieldGroupSettings(), clientContext);
    this.batchUpdateYieldGroupsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateYieldGroupsTransportSettings,
            settings.batchUpdateYieldGroupsSettings(),
            clientContext);
    this.batchActivateYieldGroupsCallable =
        callableFactory.createUnaryCallable(
            batchActivateYieldGroupsTransportSettings,
            settings.batchActivateYieldGroupsSettings(),
            clientContext);
    this.batchDeactivateYieldGroupsCallable =
        callableFactory.createUnaryCallable(
            batchDeactivateYieldGroupsTransportSettings,
            settings.batchDeactivateYieldGroupsSettings(),
            clientContext);
    this.batchArchiveYieldGroupsCallable =
        callableFactory.createUnaryCallable(
            batchArchiveYieldGroupsTransportSettings,
            settings.batchArchiveYieldGroupsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getYieldGroupMethodDescriptor);
    methodDescriptors.add(listYieldGroupsMethodDescriptor);
    methodDescriptors.add(createYieldGroupMethodDescriptor);
    methodDescriptors.add(batchCreateYieldGroupsMethodDescriptor);
    methodDescriptors.add(updateYieldGroupMethodDescriptor);
    methodDescriptors.add(batchUpdateYieldGroupsMethodDescriptor);
    methodDescriptors.add(batchActivateYieldGroupsMethodDescriptor);
    methodDescriptors.add(batchDeactivateYieldGroupsMethodDescriptor);
    methodDescriptors.add(batchArchiveYieldGroupsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetYieldGroupRequest, YieldGroup> getYieldGroupCallable() {
    return getYieldGroupCallable;
  }

  @Override
  public UnaryCallable<ListYieldGroupsRequest, ListYieldGroupsResponse> listYieldGroupsCallable() {
    return listYieldGroupsCallable;
  }

  @Override
  public UnaryCallable<ListYieldGroupsRequest, ListYieldGroupsPagedResponse>
      listYieldGroupsPagedCallable() {
    return listYieldGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateYieldGroupRequest, YieldGroup> createYieldGroupCallable() {
    return createYieldGroupCallable;
  }

  @Override
  public UnaryCallable<BatchCreateYieldGroupsRequest, BatchCreateYieldGroupsResponse>
      batchCreateYieldGroupsCallable() {
    return batchCreateYieldGroupsCallable;
  }

  @Override
  public UnaryCallable<UpdateYieldGroupRequest, YieldGroup> updateYieldGroupCallable() {
    return updateYieldGroupCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateYieldGroupsRequest, BatchUpdateYieldGroupsResponse>
      batchUpdateYieldGroupsCallable() {
    return batchUpdateYieldGroupsCallable;
  }

  @Override
  public UnaryCallable<BatchActivateYieldGroupsRequest, BatchActivateYieldGroupsResponse>
      batchActivateYieldGroupsCallable() {
    return batchActivateYieldGroupsCallable;
  }

  @Override
  public UnaryCallable<BatchDeactivateYieldGroupsRequest, BatchDeactivateYieldGroupsResponse>
      batchDeactivateYieldGroupsCallable() {
    return batchDeactivateYieldGroupsCallable;
  }

  @Override
  public UnaryCallable<BatchArchiveYieldGroupsRequest, BatchArchiveYieldGroupsResponse>
      batchArchiveYieldGroupsCallable() {
    return batchArchiveYieldGroupsCallable;
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
