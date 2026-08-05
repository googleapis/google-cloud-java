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

import static com.google.ads.admanager.v1.CustomTargetingValueServiceClient.ListCustomTargetingValuesPagedResponse;

import com.google.ads.admanager.v1.BatchActivateCustomTargetingValuesRequest;
import com.google.ads.admanager.v1.BatchActivateCustomTargetingValuesResponse;
import com.google.ads.admanager.v1.BatchCreateCustomTargetingValuesRequest;
import com.google.ads.admanager.v1.BatchCreateCustomTargetingValuesResponse;
import com.google.ads.admanager.v1.BatchDeactivateCustomTargetingValuesRequest;
import com.google.ads.admanager.v1.BatchDeactivateCustomTargetingValuesResponse;
import com.google.ads.admanager.v1.BatchUpdateCustomTargetingValuesRequest;
import com.google.ads.admanager.v1.BatchUpdateCustomTargetingValuesResponse;
import com.google.ads.admanager.v1.CreateCustomTargetingValueRequest;
import com.google.ads.admanager.v1.CustomTargetingValue;
import com.google.ads.admanager.v1.GetCustomTargetingValueRequest;
import com.google.ads.admanager.v1.ListCustomTargetingValuesRequest;
import com.google.ads.admanager.v1.ListCustomTargetingValuesResponse;
import com.google.ads.admanager.v1.UpdateCustomTargetingValueRequest;
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
 * REST stub implementation for the CustomTargetingValueService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonCustomTargetingValueServiceStub extends CustomTargetingValueServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetCustomTargetingValueRequest, CustomTargetingValue>
      getCustomTargetingValueMethodDescriptor =
          ApiMethodDescriptor.<GetCustomTargetingValueRequest, CustomTargetingValue>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingValueService/GetCustomTargetingValue")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCustomTargetingValueRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/customTargetingValues/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomTargetingValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=networks/*/customTargetingKeys/*/customTargetingValues/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomTargetingValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomTargetingValue>newBuilder()
                      .setDefaultInstance(CustomTargetingValue.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCustomTargetingValuesRequest, ListCustomTargetingValuesResponse>
      listCustomTargetingValuesMethodDescriptor =
          ApiMethodDescriptor
              .<ListCustomTargetingValuesRequest, ListCustomTargetingValuesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingValueService/ListCustomTargetingValues")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCustomTargetingValuesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customTargetingValues",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomTargetingValuesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=networks/*/customTargetingKeys/*}/customTargetingValues")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomTargetingValuesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCustomTargetingValuesResponse>newBuilder()
                      .setDefaultInstance(ListCustomTargetingValuesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCustomTargetingValueRequest, CustomTargetingValue>
      createCustomTargetingValueMethodDescriptor =
          ApiMethodDescriptor.<CreateCustomTargetingValueRequest, CustomTargetingValue>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingValueService/CreateCustomTargetingValue")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCustomTargetingValueRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customTargetingValues",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomTargetingValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomTargetingValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "customTargetingValue",
                                      request.getCustomTargetingValue(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomTargetingValue>newBuilder()
                      .setDefaultInstance(CustomTargetingValue.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateCustomTargetingValuesRequest, BatchCreateCustomTargetingValuesResponse>
      batchCreateCustomTargetingValuesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateCustomTargetingValuesRequest, BatchCreateCustomTargetingValuesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingValueService/BatchCreateCustomTargetingValues")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateCustomTargetingValuesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customTargetingValues:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateCustomTargetingValuesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateCustomTargetingValuesRequest>
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
                  ProtoMessageResponseParser.<BatchCreateCustomTargetingValuesResponse>newBuilder()
                      .setDefaultInstance(
                          BatchCreateCustomTargetingValuesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCustomTargetingValueRequest, CustomTargetingValue>
      updateCustomTargetingValueMethodDescriptor =
          ApiMethodDescriptor.<UpdateCustomTargetingValueRequest, CustomTargetingValue>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingValueService/UpdateCustomTargetingValue")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCustomTargetingValueRequest>newBuilder()
                      .setPath(
                          "/v1/{customTargetingValue.name=networks/*/customTargetingValues/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomTargetingValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "customTargetingValue.name",
                                request.getCustomTargetingValue().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomTargetingValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "customTargetingValue",
                                      request.getCustomTargetingValue(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomTargetingValue>newBuilder()
                      .setDefaultInstance(CustomTargetingValue.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateCustomTargetingValuesRequest, BatchUpdateCustomTargetingValuesResponse>
      batchUpdateCustomTargetingValuesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateCustomTargetingValuesRequest, BatchUpdateCustomTargetingValuesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingValueService/BatchUpdateCustomTargetingValues")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateCustomTargetingValuesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customTargetingValues:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateCustomTargetingValuesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateCustomTargetingValuesRequest>
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
                  ProtoMessageResponseParser.<BatchUpdateCustomTargetingValuesResponse>newBuilder()
                      .setDefaultInstance(
                          BatchUpdateCustomTargetingValuesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchActivateCustomTargetingValuesRequest, BatchActivateCustomTargetingValuesResponse>
      batchActivateCustomTargetingValuesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchActivateCustomTargetingValuesRequest,
                  BatchActivateCustomTargetingValuesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingValueService/BatchActivateCustomTargetingValues")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchActivateCustomTargetingValuesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customTargetingValues:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateCustomTargetingValuesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateCustomTargetingValuesRequest>
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
                      .<BatchActivateCustomTargetingValuesResponse>newBuilder()
                      .setDefaultInstance(
                          BatchActivateCustomTargetingValuesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDeactivateCustomTargetingValuesRequest, BatchDeactivateCustomTargetingValuesResponse>
      batchDeactivateCustomTargetingValuesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDeactivateCustomTargetingValuesRequest,
                  BatchDeactivateCustomTargetingValuesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomTargetingValueService/BatchDeactivateCustomTargetingValues")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchDeactivateCustomTargetingValuesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customTargetingValues:batchDeactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateCustomTargetingValuesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateCustomTargetingValuesRequest>
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
                      .<BatchDeactivateCustomTargetingValuesResponse>newBuilder()
                      .setDefaultInstance(
                          BatchDeactivateCustomTargetingValuesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetCustomTargetingValueRequest, CustomTargetingValue>
      getCustomTargetingValueCallable;
  private final UnaryCallable<ListCustomTargetingValuesRequest, ListCustomTargetingValuesResponse>
      listCustomTargetingValuesCallable;
  private final UnaryCallable<
          ListCustomTargetingValuesRequest, ListCustomTargetingValuesPagedResponse>
      listCustomTargetingValuesPagedCallable;
  private final UnaryCallable<CreateCustomTargetingValueRequest, CustomTargetingValue>
      createCustomTargetingValueCallable;
  private final UnaryCallable<
          BatchCreateCustomTargetingValuesRequest, BatchCreateCustomTargetingValuesResponse>
      batchCreateCustomTargetingValuesCallable;
  private final UnaryCallable<UpdateCustomTargetingValueRequest, CustomTargetingValue>
      updateCustomTargetingValueCallable;
  private final UnaryCallable<
          BatchUpdateCustomTargetingValuesRequest, BatchUpdateCustomTargetingValuesResponse>
      batchUpdateCustomTargetingValuesCallable;
  private final UnaryCallable<
          BatchActivateCustomTargetingValuesRequest, BatchActivateCustomTargetingValuesResponse>
      batchActivateCustomTargetingValuesCallable;
  private final UnaryCallable<
          BatchDeactivateCustomTargetingValuesRequest, BatchDeactivateCustomTargetingValuesResponse>
      batchDeactivateCustomTargetingValuesCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCustomTargetingValueServiceStub create(
      CustomTargetingValueServiceStubSettings settings) throws IOException {
    return new HttpJsonCustomTargetingValueServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCustomTargetingValueServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCustomTargetingValueServiceStub(
        CustomTargetingValueServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonCustomTargetingValueServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCustomTargetingValueServiceStub(
        CustomTargetingValueServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCustomTargetingValueServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonCustomTargetingValueServiceStub(
      CustomTargetingValueServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCustomTargetingValueServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCustomTargetingValueServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonCustomTargetingValueServiceStub(
      CustomTargetingValueServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetCustomTargetingValueRequest, CustomTargetingValue>
        getCustomTargetingValueTransportSettings =
            HttpJsonCallSettings.<GetCustomTargetingValueRequest, CustomTargetingValue>newBuilder()
                .setMethodDescriptor(getCustomTargetingValueMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListCustomTargetingValuesRequest, ListCustomTargetingValuesResponse>
        listCustomTargetingValuesTransportSettings =
            HttpJsonCallSettings
                .<ListCustomTargetingValuesRequest, ListCustomTargetingValuesResponse>newBuilder()
                .setMethodDescriptor(listCustomTargetingValuesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateCustomTargetingValueRequest, CustomTargetingValue>
        createCustomTargetingValueTransportSettings =
            HttpJsonCallSettings
                .<CreateCustomTargetingValueRequest, CustomTargetingValue>newBuilder()
                .setMethodDescriptor(createCustomTargetingValueMethodDescriptor)
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
            BatchCreateCustomTargetingValuesRequest, BatchCreateCustomTargetingValuesResponse>
        batchCreateCustomTargetingValuesTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateCustomTargetingValuesRequest, BatchCreateCustomTargetingValuesResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateCustomTargetingValuesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateCustomTargetingValueRequest, CustomTargetingValue>
        updateCustomTargetingValueTransportSettings =
            HttpJsonCallSettings
                .<UpdateCustomTargetingValueRequest, CustomTargetingValue>newBuilder()
                .setMethodDescriptor(updateCustomTargetingValueMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "custom_targeting_value.name",
                          String.valueOf(request.getCustomTargetingValue().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            BatchUpdateCustomTargetingValuesRequest, BatchUpdateCustomTargetingValuesResponse>
        batchUpdateCustomTargetingValuesTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateCustomTargetingValuesRequest, BatchUpdateCustomTargetingValuesResponse>
                    newBuilder()
                .setMethodDescriptor(batchUpdateCustomTargetingValuesMethodDescriptor)
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
            BatchActivateCustomTargetingValuesRequest, BatchActivateCustomTargetingValuesResponse>
        batchActivateCustomTargetingValuesTransportSettings =
            HttpJsonCallSettings
                .<BatchActivateCustomTargetingValuesRequest,
                    BatchActivateCustomTargetingValuesResponse>
                    newBuilder()
                .setMethodDescriptor(batchActivateCustomTargetingValuesMethodDescriptor)
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
            BatchDeactivateCustomTargetingValuesRequest,
            BatchDeactivateCustomTargetingValuesResponse>
        batchDeactivateCustomTargetingValuesTransportSettings =
            HttpJsonCallSettings
                .<BatchDeactivateCustomTargetingValuesRequest,
                    BatchDeactivateCustomTargetingValuesResponse>
                    newBuilder()
                .setMethodDescriptor(batchDeactivateCustomTargetingValuesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getCustomTargetingValueCallable =
        callableFactory.createUnaryCallable(
            getCustomTargetingValueTransportSettings,
            settings.getCustomTargetingValueSettings(),
            clientContext);
    this.listCustomTargetingValuesCallable =
        callableFactory.createUnaryCallable(
            listCustomTargetingValuesTransportSettings,
            settings.listCustomTargetingValuesSettings(),
            clientContext);
    this.listCustomTargetingValuesPagedCallable =
        callableFactory.createPagedCallable(
            listCustomTargetingValuesTransportSettings,
            settings.listCustomTargetingValuesSettings(),
            clientContext);
    this.createCustomTargetingValueCallable =
        callableFactory.createUnaryCallable(
            createCustomTargetingValueTransportSettings,
            settings.createCustomTargetingValueSettings(),
            clientContext);
    this.batchCreateCustomTargetingValuesCallable =
        callableFactory.createUnaryCallable(
            batchCreateCustomTargetingValuesTransportSettings,
            settings.batchCreateCustomTargetingValuesSettings(),
            clientContext);
    this.updateCustomTargetingValueCallable =
        callableFactory.createUnaryCallable(
            updateCustomTargetingValueTransportSettings,
            settings.updateCustomTargetingValueSettings(),
            clientContext);
    this.batchUpdateCustomTargetingValuesCallable =
        callableFactory.createUnaryCallable(
            batchUpdateCustomTargetingValuesTransportSettings,
            settings.batchUpdateCustomTargetingValuesSettings(),
            clientContext);
    this.batchActivateCustomTargetingValuesCallable =
        callableFactory.createUnaryCallable(
            batchActivateCustomTargetingValuesTransportSettings,
            settings.batchActivateCustomTargetingValuesSettings(),
            clientContext);
    this.batchDeactivateCustomTargetingValuesCallable =
        callableFactory.createUnaryCallable(
            batchDeactivateCustomTargetingValuesTransportSettings,
            settings.batchDeactivateCustomTargetingValuesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getCustomTargetingValueMethodDescriptor);
    methodDescriptors.add(listCustomTargetingValuesMethodDescriptor);
    methodDescriptors.add(createCustomTargetingValueMethodDescriptor);
    methodDescriptors.add(batchCreateCustomTargetingValuesMethodDescriptor);
    methodDescriptors.add(updateCustomTargetingValueMethodDescriptor);
    methodDescriptors.add(batchUpdateCustomTargetingValuesMethodDescriptor);
    methodDescriptors.add(batchActivateCustomTargetingValuesMethodDescriptor);
    methodDescriptors.add(batchDeactivateCustomTargetingValuesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetCustomTargetingValueRequest, CustomTargetingValue>
      getCustomTargetingValueCallable() {
    return getCustomTargetingValueCallable;
  }

  @Override
  public UnaryCallable<ListCustomTargetingValuesRequest, ListCustomTargetingValuesResponse>
      listCustomTargetingValuesCallable() {
    return listCustomTargetingValuesCallable;
  }

  @Override
  public UnaryCallable<ListCustomTargetingValuesRequest, ListCustomTargetingValuesPagedResponse>
      listCustomTargetingValuesPagedCallable() {
    return listCustomTargetingValuesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateCustomTargetingValueRequest, CustomTargetingValue>
      createCustomTargetingValueCallable() {
    return createCustomTargetingValueCallable;
  }

  @Override
  public UnaryCallable<
          BatchCreateCustomTargetingValuesRequest, BatchCreateCustomTargetingValuesResponse>
      batchCreateCustomTargetingValuesCallable() {
    return batchCreateCustomTargetingValuesCallable;
  }

  @Override
  public UnaryCallable<UpdateCustomTargetingValueRequest, CustomTargetingValue>
      updateCustomTargetingValueCallable() {
    return updateCustomTargetingValueCallable;
  }

  @Override
  public UnaryCallable<
          BatchUpdateCustomTargetingValuesRequest, BatchUpdateCustomTargetingValuesResponse>
      batchUpdateCustomTargetingValuesCallable() {
    return batchUpdateCustomTargetingValuesCallable;
  }

  @Override
  public UnaryCallable<
          BatchActivateCustomTargetingValuesRequest, BatchActivateCustomTargetingValuesResponse>
      batchActivateCustomTargetingValuesCallable() {
    return batchActivateCustomTargetingValuesCallable;
  }

  @Override
  public UnaryCallable<
          BatchDeactivateCustomTargetingValuesRequest, BatchDeactivateCustomTargetingValuesResponse>
      batchDeactivateCustomTargetingValuesCallable() {
    return batchDeactivateCustomTargetingValuesCallable;
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
