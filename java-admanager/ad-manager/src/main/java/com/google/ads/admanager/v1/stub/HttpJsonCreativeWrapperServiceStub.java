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

import static com.google.ads.admanager.v1.CreativeWrapperServiceClient.ListCreativeWrappersPagedResponse;

import com.google.ads.admanager.v1.BatchActivateCreativeWrappersRequest;
import com.google.ads.admanager.v1.BatchActivateCreativeWrappersResponse;
import com.google.ads.admanager.v1.BatchCreateCreativeWrappersRequest;
import com.google.ads.admanager.v1.BatchCreateCreativeWrappersResponse;
import com.google.ads.admanager.v1.BatchDeactivateCreativeWrappersRequest;
import com.google.ads.admanager.v1.BatchDeactivateCreativeWrappersResponse;
import com.google.ads.admanager.v1.BatchUpdateCreativeWrappersRequest;
import com.google.ads.admanager.v1.BatchUpdateCreativeWrappersResponse;
import com.google.ads.admanager.v1.CreateCreativeWrapperRequest;
import com.google.ads.admanager.v1.CreativeWrapper;
import com.google.ads.admanager.v1.GetCreativeWrapperRequest;
import com.google.ads.admanager.v1.ListCreativeWrappersRequest;
import com.google.ads.admanager.v1.ListCreativeWrappersResponse;
import com.google.ads.admanager.v1.UpdateCreativeWrapperRequest;
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
 * REST stub implementation for the CreativeWrapperService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonCreativeWrapperServiceStub extends CreativeWrapperServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetCreativeWrapperRequest, CreativeWrapper>
      getCreativeWrapperMethodDescriptor =
          ApiMethodDescriptor.<GetCreativeWrapperRequest, CreativeWrapper>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CreativeWrapperService/GetCreativeWrapper")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCreativeWrapperRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/creativeWrappers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCreativeWrapperRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCreativeWrapperRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CreativeWrapper>newBuilder()
                      .setDefaultInstance(CreativeWrapper.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCreativeWrappersRequest, ListCreativeWrappersResponse>
      listCreativeWrappersMethodDescriptor =
          ApiMethodDescriptor
              .<ListCreativeWrappersRequest, ListCreativeWrappersResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CreativeWrapperService/ListCreativeWrappers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCreativeWrappersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/creativeWrappers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCreativeWrappersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCreativeWrappersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCreativeWrappersResponse>newBuilder()
                      .setDefaultInstance(ListCreativeWrappersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCreativeWrapperRequest, CreativeWrapper>
      createCreativeWrapperMethodDescriptor =
          ApiMethodDescriptor.<CreateCreativeWrapperRequest, CreativeWrapper>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CreativeWrapperService/CreateCreativeWrapper")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCreativeWrapperRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/creativeWrappers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCreativeWrapperRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCreativeWrapperRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("creativeWrapper", request.getCreativeWrapper(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CreativeWrapper>newBuilder()
                      .setDefaultInstance(CreativeWrapper.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateCreativeWrappersRequest, BatchCreateCreativeWrappersResponse>
      batchCreateCreativeWrappersMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateCreativeWrappersRequest, BatchCreateCreativeWrappersResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CreativeWrapperService/BatchCreateCreativeWrappers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateCreativeWrappersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/creativeWrappers:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateCreativeWrappersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateCreativeWrappersRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateCreativeWrappersResponse>newBuilder()
                      .setDefaultInstance(BatchCreateCreativeWrappersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCreativeWrapperRequest, CreativeWrapper>
      updateCreativeWrapperMethodDescriptor =
          ApiMethodDescriptor.<UpdateCreativeWrapperRequest, CreativeWrapper>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CreativeWrapperService/UpdateCreativeWrapper")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCreativeWrapperRequest>newBuilder()
                      .setPath(
                          "/v1/{creativeWrapper.name=networks/*/creativeWrappers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCreativeWrapperRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "creativeWrapper.name",
                                request.getCreativeWrapper().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCreativeWrapperRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("creativeWrapper", request.getCreativeWrapper(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CreativeWrapper>newBuilder()
                      .setDefaultInstance(CreativeWrapper.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateCreativeWrappersRequest, BatchUpdateCreativeWrappersResponse>
      batchUpdateCreativeWrappersMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateCreativeWrappersRequest, BatchUpdateCreativeWrappersResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CreativeWrapperService/BatchUpdateCreativeWrappers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateCreativeWrappersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/creativeWrappers:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateCreativeWrappersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateCreativeWrappersRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateCreativeWrappersResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateCreativeWrappersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchActivateCreativeWrappersRequest, BatchActivateCreativeWrappersResponse>
      batchActivateCreativeWrappersMethodDescriptor =
          ApiMethodDescriptor
              .<BatchActivateCreativeWrappersRequest, BatchActivateCreativeWrappersResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CreativeWrapperService/BatchActivateCreativeWrappers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchActivateCreativeWrappersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/creativeWrappers:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateCreativeWrappersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateCreativeWrappersRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchActivateCreativeWrappersResponse>newBuilder()
                      .setDefaultInstance(
                          BatchActivateCreativeWrappersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDeactivateCreativeWrappersRequest, BatchDeactivateCreativeWrappersResponse>
      batchDeactivateCreativeWrappersMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDeactivateCreativeWrappersRequest, BatchDeactivateCreativeWrappersResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CreativeWrapperService/BatchDeactivateCreativeWrappers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeactivateCreativeWrappersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/creativeWrappers:batchDeactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateCreativeWrappersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateCreativeWrappersRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchDeactivateCreativeWrappersResponse>newBuilder()
                      .setDefaultInstance(
                          BatchDeactivateCreativeWrappersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetCreativeWrapperRequest, CreativeWrapper>
      getCreativeWrapperCallable;
  private final UnaryCallable<ListCreativeWrappersRequest, ListCreativeWrappersResponse>
      listCreativeWrappersCallable;
  private final UnaryCallable<ListCreativeWrappersRequest, ListCreativeWrappersPagedResponse>
      listCreativeWrappersPagedCallable;
  private final UnaryCallable<CreateCreativeWrapperRequest, CreativeWrapper>
      createCreativeWrapperCallable;
  private final UnaryCallable<
          BatchCreateCreativeWrappersRequest, BatchCreateCreativeWrappersResponse>
      batchCreateCreativeWrappersCallable;
  private final UnaryCallable<UpdateCreativeWrapperRequest, CreativeWrapper>
      updateCreativeWrapperCallable;
  private final UnaryCallable<
          BatchUpdateCreativeWrappersRequest, BatchUpdateCreativeWrappersResponse>
      batchUpdateCreativeWrappersCallable;
  private final UnaryCallable<
          BatchActivateCreativeWrappersRequest, BatchActivateCreativeWrappersResponse>
      batchActivateCreativeWrappersCallable;
  private final UnaryCallable<
          BatchDeactivateCreativeWrappersRequest, BatchDeactivateCreativeWrappersResponse>
      batchDeactivateCreativeWrappersCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCreativeWrapperServiceStub create(
      CreativeWrapperServiceStubSettings settings) throws IOException {
    return new HttpJsonCreativeWrapperServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCreativeWrapperServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCreativeWrapperServiceStub(
        CreativeWrapperServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonCreativeWrapperServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCreativeWrapperServiceStub(
        CreativeWrapperServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCreativeWrapperServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCreativeWrapperServiceStub(
      CreativeWrapperServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCreativeWrapperServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCreativeWrapperServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCreativeWrapperServiceStub(
      CreativeWrapperServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetCreativeWrapperRequest, CreativeWrapper>
        getCreativeWrapperTransportSettings =
            HttpJsonCallSettings.<GetCreativeWrapperRequest, CreativeWrapper>newBuilder()
                .setMethodDescriptor(getCreativeWrapperMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListCreativeWrappersRequest, ListCreativeWrappersResponse>
        listCreativeWrappersTransportSettings =
            HttpJsonCallSettings
                .<ListCreativeWrappersRequest, ListCreativeWrappersResponse>newBuilder()
                .setMethodDescriptor(listCreativeWrappersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateCreativeWrapperRequest, CreativeWrapper>
        createCreativeWrapperTransportSettings =
            HttpJsonCallSettings.<CreateCreativeWrapperRequest, CreativeWrapper>newBuilder()
                .setMethodDescriptor(createCreativeWrapperMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchCreateCreativeWrappersRequest, BatchCreateCreativeWrappersResponse>
        batchCreateCreativeWrappersTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateCreativeWrappersRequest, BatchCreateCreativeWrappersResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateCreativeWrappersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateCreativeWrapperRequest, CreativeWrapper>
        updateCreativeWrapperTransportSettings =
            HttpJsonCallSettings.<UpdateCreativeWrapperRequest, CreativeWrapper>newBuilder()
                .setMethodDescriptor(updateCreativeWrapperMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "creative_wrapper.name",
                          String.valueOf(request.getCreativeWrapper().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchUpdateCreativeWrappersRequest, BatchUpdateCreativeWrappersResponse>
        batchUpdateCreativeWrappersTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateCreativeWrappersRequest, BatchUpdateCreativeWrappersResponse>
                    newBuilder()
                .setMethodDescriptor(batchUpdateCreativeWrappersMethodDescriptor)
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
            BatchActivateCreativeWrappersRequest, BatchActivateCreativeWrappersResponse>
        batchActivateCreativeWrappersTransportSettings =
            HttpJsonCallSettings
                .<BatchActivateCreativeWrappersRequest, BatchActivateCreativeWrappersResponse>
                    newBuilder()
                .setMethodDescriptor(batchActivateCreativeWrappersMethodDescriptor)
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
            BatchDeactivateCreativeWrappersRequest, BatchDeactivateCreativeWrappersResponse>
        batchDeactivateCreativeWrappersTransportSettings =
            HttpJsonCallSettings
                .<BatchDeactivateCreativeWrappersRequest, BatchDeactivateCreativeWrappersResponse>
                    newBuilder()
                .setMethodDescriptor(batchDeactivateCreativeWrappersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getCreativeWrapperCallable =
        callableFactory.createUnaryCallable(
            getCreativeWrapperTransportSettings,
            settings.getCreativeWrapperSettings(),
            clientContext);
    this.listCreativeWrappersCallable =
        callableFactory.createUnaryCallable(
            listCreativeWrappersTransportSettings,
            settings.listCreativeWrappersSettings(),
            clientContext);
    this.listCreativeWrappersPagedCallable =
        callableFactory.createPagedCallable(
            listCreativeWrappersTransportSettings,
            settings.listCreativeWrappersSettings(),
            clientContext);
    this.createCreativeWrapperCallable =
        callableFactory.createUnaryCallable(
            createCreativeWrapperTransportSettings,
            settings.createCreativeWrapperSettings(),
            clientContext);
    this.batchCreateCreativeWrappersCallable =
        callableFactory.createUnaryCallable(
            batchCreateCreativeWrappersTransportSettings,
            settings.batchCreateCreativeWrappersSettings(),
            clientContext);
    this.updateCreativeWrapperCallable =
        callableFactory.createUnaryCallable(
            updateCreativeWrapperTransportSettings,
            settings.updateCreativeWrapperSettings(),
            clientContext);
    this.batchUpdateCreativeWrappersCallable =
        callableFactory.createUnaryCallable(
            batchUpdateCreativeWrappersTransportSettings,
            settings.batchUpdateCreativeWrappersSettings(),
            clientContext);
    this.batchActivateCreativeWrappersCallable =
        callableFactory.createUnaryCallable(
            batchActivateCreativeWrappersTransportSettings,
            settings.batchActivateCreativeWrappersSettings(),
            clientContext);
    this.batchDeactivateCreativeWrappersCallable =
        callableFactory.createUnaryCallable(
            batchDeactivateCreativeWrappersTransportSettings,
            settings.batchDeactivateCreativeWrappersSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getCreativeWrapperMethodDescriptor);
    methodDescriptors.add(listCreativeWrappersMethodDescriptor);
    methodDescriptors.add(createCreativeWrapperMethodDescriptor);
    methodDescriptors.add(batchCreateCreativeWrappersMethodDescriptor);
    methodDescriptors.add(updateCreativeWrapperMethodDescriptor);
    methodDescriptors.add(batchUpdateCreativeWrappersMethodDescriptor);
    methodDescriptors.add(batchActivateCreativeWrappersMethodDescriptor);
    methodDescriptors.add(batchDeactivateCreativeWrappersMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetCreativeWrapperRequest, CreativeWrapper> getCreativeWrapperCallable() {
    return getCreativeWrapperCallable;
  }

  @Override
  public UnaryCallable<ListCreativeWrappersRequest, ListCreativeWrappersResponse>
      listCreativeWrappersCallable() {
    return listCreativeWrappersCallable;
  }

  @Override
  public UnaryCallable<ListCreativeWrappersRequest, ListCreativeWrappersPagedResponse>
      listCreativeWrappersPagedCallable() {
    return listCreativeWrappersPagedCallable;
  }

  @Override
  public UnaryCallable<CreateCreativeWrapperRequest, CreativeWrapper>
      createCreativeWrapperCallable() {
    return createCreativeWrapperCallable;
  }

  @Override
  public UnaryCallable<BatchCreateCreativeWrappersRequest, BatchCreateCreativeWrappersResponse>
      batchCreateCreativeWrappersCallable() {
    return batchCreateCreativeWrappersCallable;
  }

  @Override
  public UnaryCallable<UpdateCreativeWrapperRequest, CreativeWrapper>
      updateCreativeWrapperCallable() {
    return updateCreativeWrapperCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateCreativeWrappersRequest, BatchUpdateCreativeWrappersResponse>
      batchUpdateCreativeWrappersCallable() {
    return batchUpdateCreativeWrappersCallable;
  }

  @Override
  public UnaryCallable<BatchActivateCreativeWrappersRequest, BatchActivateCreativeWrappersResponse>
      batchActivateCreativeWrappersCallable() {
    return batchActivateCreativeWrappersCallable;
  }

  @Override
  public UnaryCallable<
          BatchDeactivateCreativeWrappersRequest, BatchDeactivateCreativeWrappersResponse>
      batchDeactivateCreativeWrappersCallable() {
    return batchDeactivateCreativeWrappersCallable;
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
