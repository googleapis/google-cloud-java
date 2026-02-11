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

import static com.google.ads.admanager.v1.CustomTargetingKeyServiceClient.ListCustomTargetingKeysPagedResponse;

import com.google.ads.admanager.v1.BatchActivateCustomTargetingKeysRequest;
import com.google.ads.admanager.v1.BatchActivateCustomTargetingKeysResponse;
import com.google.ads.admanager.v1.BatchCreateCustomTargetingKeysRequest;
import com.google.ads.admanager.v1.BatchCreateCustomTargetingKeysResponse;
import com.google.ads.admanager.v1.BatchDeactivateCustomTargetingKeysRequest;
import com.google.ads.admanager.v1.BatchDeactivateCustomTargetingKeysResponse;
import com.google.ads.admanager.v1.BatchUpdateCustomTargetingKeysRequest;
import com.google.ads.admanager.v1.BatchUpdateCustomTargetingKeysResponse;
import com.google.ads.admanager.v1.CreateCustomTargetingKeyRequest;
import com.google.ads.admanager.v1.CustomTargetingKey;
import com.google.ads.admanager.v1.GetCustomTargetingKeyRequest;
import com.google.ads.admanager.v1.ListCustomTargetingKeysRequest;
import com.google.ads.admanager.v1.ListCustomTargetingKeysResponse;
import com.google.ads.admanager.v1.UpdateCustomTargetingKeyRequest;
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
 * REST stub implementation for the CustomTargetingKeyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonCustomTargetingKeyServiceStub extends CustomTargetingKeyServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetCustomTargetingKeyRequest, CustomTargetingKey>
      getCustomTargetingKeyMethodDescriptor =
          ApiMethodDescriptor.<GetCustomTargetingKeyRequest, CustomTargetingKey>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingKeyService/GetCustomTargetingKey")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCustomTargetingKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/customTargetingKeys/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomTargetingKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomTargetingKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomTargetingKey>newBuilder()
                      .setDefaultInstance(CustomTargetingKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse>
      listCustomTargetingKeysMethodDescriptor =
          ApiMethodDescriptor
              .<ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingKeyService/ListCustomTargetingKeys")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCustomTargetingKeysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customTargetingKeys",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomTargetingKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomTargetingKeysRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCustomTargetingKeysResponse>newBuilder()
                      .setDefaultInstance(ListCustomTargetingKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCustomTargetingKeyRequest, CustomTargetingKey>
      createCustomTargetingKeyMethodDescriptor =
          ApiMethodDescriptor.<CreateCustomTargetingKeyRequest, CustomTargetingKey>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingKeyService/CreateCustomTargetingKey")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCustomTargetingKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customTargetingKeys",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomTargetingKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomTargetingKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "customTargetingKey", request.getCustomTargetingKey(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomTargetingKey>newBuilder()
                      .setDefaultInstance(CustomTargetingKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateCustomTargetingKeysRequest, BatchCreateCustomTargetingKeysResponse>
      batchCreateCustomTargetingKeysMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateCustomTargetingKeysRequest, BatchCreateCustomTargetingKeysResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingKeyService/BatchCreateCustomTargetingKeys")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateCustomTargetingKeysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customTargetingKeys:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateCustomTargetingKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateCustomTargetingKeysRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateCustomTargetingKeysResponse>newBuilder()
                      .setDefaultInstance(
                          BatchCreateCustomTargetingKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCustomTargetingKeyRequest, CustomTargetingKey>
      updateCustomTargetingKeyMethodDescriptor =
          ApiMethodDescriptor.<UpdateCustomTargetingKeyRequest, CustomTargetingKey>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingKeyService/UpdateCustomTargetingKey")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCustomTargetingKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{customTargetingKey.name=networks/*/customTargetingKeys/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomTargetingKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "customTargetingKey.name",
                                request.getCustomTargetingKey().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomTargetingKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "customTargetingKey", request.getCustomTargetingKey(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomTargetingKey>newBuilder()
                      .setDefaultInstance(CustomTargetingKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateCustomTargetingKeysRequest, BatchUpdateCustomTargetingKeysResponse>
      batchUpdateCustomTargetingKeysMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateCustomTargetingKeysRequest, BatchUpdateCustomTargetingKeysResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingKeyService/BatchUpdateCustomTargetingKeys")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateCustomTargetingKeysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customTargetingKeys:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateCustomTargetingKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateCustomTargetingKeysRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateCustomTargetingKeysResponse>newBuilder()
                      .setDefaultInstance(
                          BatchUpdateCustomTargetingKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchActivateCustomTargetingKeysRequest, BatchActivateCustomTargetingKeysResponse>
      batchActivateCustomTargetingKeysMethodDescriptor =
          ApiMethodDescriptor
              .<BatchActivateCustomTargetingKeysRequest, BatchActivateCustomTargetingKeysResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingKeyService/BatchActivateCustomTargetingKeys")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchActivateCustomTargetingKeysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customTargetingKeys:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateCustomTargetingKeysRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateCustomTargetingKeysRequest>
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
                  ProtoMessageResponseParser.<BatchActivateCustomTargetingKeysResponse>newBuilder()
                      .setDefaultInstance(
                          BatchActivateCustomTargetingKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDeactivateCustomTargetingKeysRequest, BatchDeactivateCustomTargetingKeysResponse>
      batchDeactivateCustomTargetingKeysMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDeactivateCustomTargetingKeysRequest,
                  BatchDeactivateCustomTargetingKeysResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingKeyService/BatchDeactivateCustomTargetingKeys")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchDeactivateCustomTargetingKeysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customTargetingKeys:batchDeactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateCustomTargetingKeysRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateCustomTargetingKeysRequest>
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
                      .<BatchDeactivateCustomTargetingKeysResponse>newBuilder()
                      .setDefaultInstance(
                          BatchDeactivateCustomTargetingKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetCustomTargetingKeyRequest, CustomTargetingKey>
      getCustomTargetingKeyCallable;
  private final UnaryCallable<ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse>
      listCustomTargetingKeysCallable;
  private final UnaryCallable<ListCustomTargetingKeysRequest, ListCustomTargetingKeysPagedResponse>
      listCustomTargetingKeysPagedCallable;
  private final UnaryCallable<CreateCustomTargetingKeyRequest, CustomTargetingKey>
      createCustomTargetingKeyCallable;
  private final UnaryCallable<
          BatchCreateCustomTargetingKeysRequest, BatchCreateCustomTargetingKeysResponse>
      batchCreateCustomTargetingKeysCallable;
  private final UnaryCallable<UpdateCustomTargetingKeyRequest, CustomTargetingKey>
      updateCustomTargetingKeyCallable;
  private final UnaryCallable<
          BatchUpdateCustomTargetingKeysRequest, BatchUpdateCustomTargetingKeysResponse>
      batchUpdateCustomTargetingKeysCallable;
  private final UnaryCallable<
          BatchActivateCustomTargetingKeysRequest, BatchActivateCustomTargetingKeysResponse>
      batchActivateCustomTargetingKeysCallable;
  private final UnaryCallable<
          BatchDeactivateCustomTargetingKeysRequest, BatchDeactivateCustomTargetingKeysResponse>
      batchDeactivateCustomTargetingKeysCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCustomTargetingKeyServiceStub create(
      CustomTargetingKeyServiceStubSettings settings) throws IOException {
    return new HttpJsonCustomTargetingKeyServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCustomTargetingKeyServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCustomTargetingKeyServiceStub(
        CustomTargetingKeyServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonCustomTargetingKeyServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCustomTargetingKeyServiceStub(
        CustomTargetingKeyServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCustomTargetingKeyServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCustomTargetingKeyServiceStub(
      CustomTargetingKeyServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCustomTargetingKeyServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCustomTargetingKeyServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCustomTargetingKeyServiceStub(
      CustomTargetingKeyServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetCustomTargetingKeyRequest, CustomTargetingKey>
        getCustomTargetingKeyTransportSettings =
            HttpJsonCallSettings.<GetCustomTargetingKeyRequest, CustomTargetingKey>newBuilder()
                .setMethodDescriptor(getCustomTargetingKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse>
        listCustomTargetingKeysTransportSettings =
            HttpJsonCallSettings
                .<ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse>newBuilder()
                .setMethodDescriptor(listCustomTargetingKeysMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateCustomTargetingKeyRequest, CustomTargetingKey>
        createCustomTargetingKeyTransportSettings =
            HttpJsonCallSettings.<CreateCustomTargetingKeyRequest, CustomTargetingKey>newBuilder()
                .setMethodDescriptor(createCustomTargetingKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            BatchCreateCustomTargetingKeysRequest, BatchCreateCustomTargetingKeysResponse>
        batchCreateCustomTargetingKeysTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateCustomTargetingKeysRequest, BatchCreateCustomTargetingKeysResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateCustomTargetingKeysMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateCustomTargetingKeyRequest, CustomTargetingKey>
        updateCustomTargetingKeyTransportSettings =
            HttpJsonCallSettings.<UpdateCustomTargetingKeyRequest, CustomTargetingKey>newBuilder()
                .setMethodDescriptor(updateCustomTargetingKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "custom_targeting_key.name",
                          String.valueOf(request.getCustomTargetingKey().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            BatchUpdateCustomTargetingKeysRequest, BatchUpdateCustomTargetingKeysResponse>
        batchUpdateCustomTargetingKeysTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateCustomTargetingKeysRequest, BatchUpdateCustomTargetingKeysResponse>
                    newBuilder()
                .setMethodDescriptor(batchUpdateCustomTargetingKeysMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            BatchActivateCustomTargetingKeysRequest, BatchActivateCustomTargetingKeysResponse>
        batchActivateCustomTargetingKeysTransportSettings =
            HttpJsonCallSettings
                .<BatchActivateCustomTargetingKeysRequest, BatchActivateCustomTargetingKeysResponse>
                    newBuilder()
                .setMethodDescriptor(batchActivateCustomTargetingKeysMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            BatchDeactivateCustomTargetingKeysRequest, BatchDeactivateCustomTargetingKeysResponse>
        batchDeactivateCustomTargetingKeysTransportSettings =
            HttpJsonCallSettings
                .<BatchDeactivateCustomTargetingKeysRequest,
                    BatchDeactivateCustomTargetingKeysResponse>
                    newBuilder()
                .setMethodDescriptor(batchDeactivateCustomTargetingKeysMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getCustomTargetingKeyCallable =
        callableFactory.createUnaryCallable(
            getCustomTargetingKeyTransportSettings,
            settings.getCustomTargetingKeySettings(),
            clientContext);
    this.listCustomTargetingKeysCallable =
        callableFactory.createUnaryCallable(
            listCustomTargetingKeysTransportSettings,
            settings.listCustomTargetingKeysSettings(),
            clientContext);
    this.listCustomTargetingKeysPagedCallable =
        callableFactory.createPagedCallable(
            listCustomTargetingKeysTransportSettings,
            settings.listCustomTargetingKeysSettings(),
            clientContext);
    this.createCustomTargetingKeyCallable =
        callableFactory.createUnaryCallable(
            createCustomTargetingKeyTransportSettings,
            settings.createCustomTargetingKeySettings(),
            clientContext);
    this.batchCreateCustomTargetingKeysCallable =
        callableFactory.createUnaryCallable(
            batchCreateCustomTargetingKeysTransportSettings,
            settings.batchCreateCustomTargetingKeysSettings(),
            clientContext);
    this.updateCustomTargetingKeyCallable =
        callableFactory.createUnaryCallable(
            updateCustomTargetingKeyTransportSettings,
            settings.updateCustomTargetingKeySettings(),
            clientContext);
    this.batchUpdateCustomTargetingKeysCallable =
        callableFactory.createUnaryCallable(
            batchUpdateCustomTargetingKeysTransportSettings,
            settings.batchUpdateCustomTargetingKeysSettings(),
            clientContext);
    this.batchActivateCustomTargetingKeysCallable =
        callableFactory.createUnaryCallable(
            batchActivateCustomTargetingKeysTransportSettings,
            settings.batchActivateCustomTargetingKeysSettings(),
            clientContext);
    this.batchDeactivateCustomTargetingKeysCallable =
        callableFactory.createUnaryCallable(
            batchDeactivateCustomTargetingKeysTransportSettings,
            settings.batchDeactivateCustomTargetingKeysSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getCustomTargetingKeyMethodDescriptor);
    methodDescriptors.add(listCustomTargetingKeysMethodDescriptor);
    methodDescriptors.add(createCustomTargetingKeyMethodDescriptor);
    methodDescriptors.add(batchCreateCustomTargetingKeysMethodDescriptor);
    methodDescriptors.add(updateCustomTargetingKeyMethodDescriptor);
    methodDescriptors.add(batchUpdateCustomTargetingKeysMethodDescriptor);
    methodDescriptors.add(batchActivateCustomTargetingKeysMethodDescriptor);
    methodDescriptors.add(batchDeactivateCustomTargetingKeysMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetCustomTargetingKeyRequest, CustomTargetingKey>
      getCustomTargetingKeyCallable() {
    return getCustomTargetingKeyCallable;
  }

  @Override
  public UnaryCallable<ListCustomTargetingKeysRequest, ListCustomTargetingKeysResponse>
      listCustomTargetingKeysCallable() {
    return listCustomTargetingKeysCallable;
  }

  @Override
  public UnaryCallable<ListCustomTargetingKeysRequest, ListCustomTargetingKeysPagedResponse>
      listCustomTargetingKeysPagedCallable() {
    return listCustomTargetingKeysPagedCallable;
  }

  @Override
  public UnaryCallable<CreateCustomTargetingKeyRequest, CustomTargetingKey>
      createCustomTargetingKeyCallable() {
    return createCustomTargetingKeyCallable;
  }

  @Override
  public UnaryCallable<
          BatchCreateCustomTargetingKeysRequest, BatchCreateCustomTargetingKeysResponse>
      batchCreateCustomTargetingKeysCallable() {
    return batchCreateCustomTargetingKeysCallable;
  }

  @Override
  public UnaryCallable<UpdateCustomTargetingKeyRequest, CustomTargetingKey>
      updateCustomTargetingKeyCallable() {
    return updateCustomTargetingKeyCallable;
  }

  @Override
  public UnaryCallable<
          BatchUpdateCustomTargetingKeysRequest, BatchUpdateCustomTargetingKeysResponse>
      batchUpdateCustomTargetingKeysCallable() {
    return batchUpdateCustomTargetingKeysCallable;
  }

  @Override
  public UnaryCallable<
          BatchActivateCustomTargetingKeysRequest, BatchActivateCustomTargetingKeysResponse>
      batchActivateCustomTargetingKeysCallable() {
    return batchActivateCustomTargetingKeysCallable;
  }

  @Override
  public UnaryCallable<
          BatchDeactivateCustomTargetingKeysRequest, BatchDeactivateCustomTargetingKeysResponse>
      batchDeactivateCustomTargetingKeysCallable() {
    return batchDeactivateCustomTargetingKeysCallable;
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
