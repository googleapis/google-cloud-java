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

import static com.google.ads.admanager.v1.DaiAuthenticationKeyServiceClient.ListDaiAuthenticationKeysPagedResponse;

import com.google.ads.admanager.v1.BatchActivateDaiAuthenticationKeysRequest;
import com.google.ads.admanager.v1.BatchActivateDaiAuthenticationKeysResponse;
import com.google.ads.admanager.v1.BatchCreateDaiAuthenticationKeysRequest;
import com.google.ads.admanager.v1.BatchCreateDaiAuthenticationKeysResponse;
import com.google.ads.admanager.v1.BatchDeactivateDaiAuthenticationKeysRequest;
import com.google.ads.admanager.v1.BatchDeactivateDaiAuthenticationKeysResponse;
import com.google.ads.admanager.v1.BatchUpdateDaiAuthenticationKeysRequest;
import com.google.ads.admanager.v1.BatchUpdateDaiAuthenticationKeysResponse;
import com.google.ads.admanager.v1.CreateDaiAuthenticationKeyRequest;
import com.google.ads.admanager.v1.DaiAuthenticationKey;
import com.google.ads.admanager.v1.GetDaiAuthenticationKeyRequest;
import com.google.ads.admanager.v1.ListDaiAuthenticationKeysRequest;
import com.google.ads.admanager.v1.ListDaiAuthenticationKeysResponse;
import com.google.ads.admanager.v1.UpdateDaiAuthenticationKeyRequest;
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
 * REST stub implementation for the DaiAuthenticationKeyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonDaiAuthenticationKeyServiceStub extends DaiAuthenticationKeyServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      getDaiAuthenticationKeyMethodDescriptor =
          ApiMethodDescriptor.<GetDaiAuthenticationKeyRequest, DaiAuthenticationKey>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DaiAuthenticationKeyService/GetDaiAuthenticationKey")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDaiAuthenticationKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/daiAuthenticationKeys/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDaiAuthenticationKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDaiAuthenticationKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DaiAuthenticationKey>newBuilder()
                      .setDefaultInstance(DaiAuthenticationKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDaiAuthenticationKeysRequest, ListDaiAuthenticationKeysResponse>
      listDaiAuthenticationKeysMethodDescriptor =
          ApiMethodDescriptor
              .<ListDaiAuthenticationKeysRequest, ListDaiAuthenticationKeysResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DaiAuthenticationKeyService/ListDaiAuthenticationKeys")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDaiAuthenticationKeysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/daiAuthenticationKeys",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDaiAuthenticationKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDaiAuthenticationKeysRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDaiAuthenticationKeysResponse>newBuilder()
                      .setDefaultInstance(ListDaiAuthenticationKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      createDaiAuthenticationKeyMethodDescriptor =
          ApiMethodDescriptor.<CreateDaiAuthenticationKeyRequest, DaiAuthenticationKey>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DaiAuthenticationKeyService/CreateDaiAuthenticationKey")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDaiAuthenticationKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/daiAuthenticationKeys",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDaiAuthenticationKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDaiAuthenticationKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "daiAuthenticationKey",
                                      request.getDaiAuthenticationKey(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DaiAuthenticationKey>newBuilder()
                      .setDefaultInstance(DaiAuthenticationKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateDaiAuthenticationKeysRequest, BatchCreateDaiAuthenticationKeysResponse>
      batchCreateDaiAuthenticationKeysMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateDaiAuthenticationKeysRequest, BatchCreateDaiAuthenticationKeysResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DaiAuthenticationKeyService/BatchCreateDaiAuthenticationKeys")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateDaiAuthenticationKeysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/daiAuthenticationKeys:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateDaiAuthenticationKeysRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateDaiAuthenticationKeysRequest>
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
                  ProtoMessageResponseParser.<BatchCreateDaiAuthenticationKeysResponse>newBuilder()
                      .setDefaultInstance(
                          BatchCreateDaiAuthenticationKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      updateDaiAuthenticationKeyMethodDescriptor =
          ApiMethodDescriptor.<UpdateDaiAuthenticationKeyRequest, DaiAuthenticationKey>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DaiAuthenticationKeyService/UpdateDaiAuthenticationKey")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDaiAuthenticationKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{daiAuthenticationKey.name=networks/*/daiAuthenticationKeys/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDaiAuthenticationKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "daiAuthenticationKey.name",
                                request.getDaiAuthenticationKey().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDaiAuthenticationKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "daiAuthenticationKey",
                                      request.getDaiAuthenticationKey(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DaiAuthenticationKey>newBuilder()
                      .setDefaultInstance(DaiAuthenticationKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateDaiAuthenticationKeysRequest, BatchUpdateDaiAuthenticationKeysResponse>
      batchUpdateDaiAuthenticationKeysMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateDaiAuthenticationKeysRequest, BatchUpdateDaiAuthenticationKeysResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DaiAuthenticationKeyService/BatchUpdateDaiAuthenticationKeys")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateDaiAuthenticationKeysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/daiAuthenticationKeys:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateDaiAuthenticationKeysRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateDaiAuthenticationKeysRequest>
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
                  ProtoMessageResponseParser.<BatchUpdateDaiAuthenticationKeysResponse>newBuilder()
                      .setDefaultInstance(
                          BatchUpdateDaiAuthenticationKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchActivateDaiAuthenticationKeysRequest, BatchActivateDaiAuthenticationKeysResponse>
      batchActivateDaiAuthenticationKeysMethodDescriptor =
          ApiMethodDescriptor
              .<BatchActivateDaiAuthenticationKeysRequest,
                  BatchActivateDaiAuthenticationKeysResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DaiAuthenticationKeyService/BatchActivateDaiAuthenticationKeys")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchActivateDaiAuthenticationKeysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/daiAuthenticationKeys:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateDaiAuthenticationKeysRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateDaiAuthenticationKeysRequest>
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
                      .<BatchActivateDaiAuthenticationKeysResponse>newBuilder()
                      .setDefaultInstance(
                          BatchActivateDaiAuthenticationKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDeactivateDaiAuthenticationKeysRequest, BatchDeactivateDaiAuthenticationKeysResponse>
      batchDeactivateDaiAuthenticationKeysMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDeactivateDaiAuthenticationKeysRequest,
                  BatchDeactivateDaiAuthenticationKeysResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.DaiAuthenticationKeyService/BatchDeactivateDaiAuthenticationKeys")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchDeactivateDaiAuthenticationKeysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/daiAuthenticationKeys:batchDeactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateDaiAuthenticationKeysRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateDaiAuthenticationKeysRequest>
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
                      .<BatchDeactivateDaiAuthenticationKeysResponse>newBuilder()
                      .setDefaultInstance(
                          BatchDeactivateDaiAuthenticationKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      getDaiAuthenticationKeyCallable;
  private final UnaryCallable<ListDaiAuthenticationKeysRequest, ListDaiAuthenticationKeysResponse>
      listDaiAuthenticationKeysCallable;
  private final UnaryCallable<
          ListDaiAuthenticationKeysRequest, ListDaiAuthenticationKeysPagedResponse>
      listDaiAuthenticationKeysPagedCallable;
  private final UnaryCallable<CreateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      createDaiAuthenticationKeyCallable;
  private final UnaryCallable<
          BatchCreateDaiAuthenticationKeysRequest, BatchCreateDaiAuthenticationKeysResponse>
      batchCreateDaiAuthenticationKeysCallable;
  private final UnaryCallable<UpdateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      updateDaiAuthenticationKeyCallable;
  private final UnaryCallable<
          BatchUpdateDaiAuthenticationKeysRequest, BatchUpdateDaiAuthenticationKeysResponse>
      batchUpdateDaiAuthenticationKeysCallable;
  private final UnaryCallable<
          BatchActivateDaiAuthenticationKeysRequest, BatchActivateDaiAuthenticationKeysResponse>
      batchActivateDaiAuthenticationKeysCallable;
  private final UnaryCallable<
          BatchDeactivateDaiAuthenticationKeysRequest, BatchDeactivateDaiAuthenticationKeysResponse>
      batchDeactivateDaiAuthenticationKeysCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDaiAuthenticationKeyServiceStub create(
      DaiAuthenticationKeyServiceStubSettings settings) throws IOException {
    return new HttpJsonDaiAuthenticationKeyServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDaiAuthenticationKeyServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDaiAuthenticationKeyServiceStub(
        DaiAuthenticationKeyServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonDaiAuthenticationKeyServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDaiAuthenticationKeyServiceStub(
        DaiAuthenticationKeyServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDaiAuthenticationKeyServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonDaiAuthenticationKeyServiceStub(
      DaiAuthenticationKeyServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDaiAuthenticationKeyServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDaiAuthenticationKeyServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonDaiAuthenticationKeyServiceStub(
      DaiAuthenticationKeyServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetDaiAuthenticationKeyRequest, DaiAuthenticationKey>
        getDaiAuthenticationKeyTransportSettings =
            HttpJsonCallSettings.<GetDaiAuthenticationKeyRequest, DaiAuthenticationKey>newBuilder()
                .setMethodDescriptor(getDaiAuthenticationKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListDaiAuthenticationKeysRequest, ListDaiAuthenticationKeysResponse>
        listDaiAuthenticationKeysTransportSettings =
            HttpJsonCallSettings
                .<ListDaiAuthenticationKeysRequest, ListDaiAuthenticationKeysResponse>newBuilder()
                .setMethodDescriptor(listDaiAuthenticationKeysMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
        createDaiAuthenticationKeyTransportSettings =
            HttpJsonCallSettings
                .<CreateDaiAuthenticationKeyRequest, DaiAuthenticationKey>newBuilder()
                .setMethodDescriptor(createDaiAuthenticationKeyMethodDescriptor)
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
            BatchCreateDaiAuthenticationKeysRequest, BatchCreateDaiAuthenticationKeysResponse>
        batchCreateDaiAuthenticationKeysTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateDaiAuthenticationKeysRequest, BatchCreateDaiAuthenticationKeysResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateDaiAuthenticationKeysMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
        updateDaiAuthenticationKeyTransportSettings =
            HttpJsonCallSettings
                .<UpdateDaiAuthenticationKeyRequest, DaiAuthenticationKey>newBuilder()
                .setMethodDescriptor(updateDaiAuthenticationKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "dai_authentication_key.name",
                          String.valueOf(request.getDaiAuthenticationKey().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            BatchUpdateDaiAuthenticationKeysRequest, BatchUpdateDaiAuthenticationKeysResponse>
        batchUpdateDaiAuthenticationKeysTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateDaiAuthenticationKeysRequest, BatchUpdateDaiAuthenticationKeysResponse>
                    newBuilder()
                .setMethodDescriptor(batchUpdateDaiAuthenticationKeysMethodDescriptor)
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
            BatchActivateDaiAuthenticationKeysRequest, BatchActivateDaiAuthenticationKeysResponse>
        batchActivateDaiAuthenticationKeysTransportSettings =
            HttpJsonCallSettings
                .<BatchActivateDaiAuthenticationKeysRequest,
                    BatchActivateDaiAuthenticationKeysResponse>
                    newBuilder()
                .setMethodDescriptor(batchActivateDaiAuthenticationKeysMethodDescriptor)
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
            BatchDeactivateDaiAuthenticationKeysRequest,
            BatchDeactivateDaiAuthenticationKeysResponse>
        batchDeactivateDaiAuthenticationKeysTransportSettings =
            HttpJsonCallSettings
                .<BatchDeactivateDaiAuthenticationKeysRequest,
                    BatchDeactivateDaiAuthenticationKeysResponse>
                    newBuilder()
                .setMethodDescriptor(batchDeactivateDaiAuthenticationKeysMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getDaiAuthenticationKeyCallable =
        callableFactory.createUnaryCallable(
            getDaiAuthenticationKeyTransportSettings,
            settings.getDaiAuthenticationKeySettings(),
            clientContext);
    this.listDaiAuthenticationKeysCallable =
        callableFactory.createUnaryCallable(
            listDaiAuthenticationKeysTransportSettings,
            settings.listDaiAuthenticationKeysSettings(),
            clientContext);
    this.listDaiAuthenticationKeysPagedCallable =
        callableFactory.createPagedCallable(
            listDaiAuthenticationKeysTransportSettings,
            settings.listDaiAuthenticationKeysSettings(),
            clientContext);
    this.createDaiAuthenticationKeyCallable =
        callableFactory.createUnaryCallable(
            createDaiAuthenticationKeyTransportSettings,
            settings.createDaiAuthenticationKeySettings(),
            clientContext);
    this.batchCreateDaiAuthenticationKeysCallable =
        callableFactory.createUnaryCallable(
            batchCreateDaiAuthenticationKeysTransportSettings,
            settings.batchCreateDaiAuthenticationKeysSettings(),
            clientContext);
    this.updateDaiAuthenticationKeyCallable =
        callableFactory.createUnaryCallable(
            updateDaiAuthenticationKeyTransportSettings,
            settings.updateDaiAuthenticationKeySettings(),
            clientContext);
    this.batchUpdateDaiAuthenticationKeysCallable =
        callableFactory.createUnaryCallable(
            batchUpdateDaiAuthenticationKeysTransportSettings,
            settings.batchUpdateDaiAuthenticationKeysSettings(),
            clientContext);
    this.batchActivateDaiAuthenticationKeysCallable =
        callableFactory.createUnaryCallable(
            batchActivateDaiAuthenticationKeysTransportSettings,
            settings.batchActivateDaiAuthenticationKeysSettings(),
            clientContext);
    this.batchDeactivateDaiAuthenticationKeysCallable =
        callableFactory.createUnaryCallable(
            batchDeactivateDaiAuthenticationKeysTransportSettings,
            settings.batchDeactivateDaiAuthenticationKeysSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getDaiAuthenticationKeyMethodDescriptor);
    methodDescriptors.add(listDaiAuthenticationKeysMethodDescriptor);
    methodDescriptors.add(createDaiAuthenticationKeyMethodDescriptor);
    methodDescriptors.add(batchCreateDaiAuthenticationKeysMethodDescriptor);
    methodDescriptors.add(updateDaiAuthenticationKeyMethodDescriptor);
    methodDescriptors.add(batchUpdateDaiAuthenticationKeysMethodDescriptor);
    methodDescriptors.add(batchActivateDaiAuthenticationKeysMethodDescriptor);
    methodDescriptors.add(batchDeactivateDaiAuthenticationKeysMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      getDaiAuthenticationKeyCallable() {
    return getDaiAuthenticationKeyCallable;
  }

  @Override
  public UnaryCallable<ListDaiAuthenticationKeysRequest, ListDaiAuthenticationKeysResponse>
      listDaiAuthenticationKeysCallable() {
    return listDaiAuthenticationKeysCallable;
  }

  @Override
  public UnaryCallable<ListDaiAuthenticationKeysRequest, ListDaiAuthenticationKeysPagedResponse>
      listDaiAuthenticationKeysPagedCallable() {
    return listDaiAuthenticationKeysPagedCallable;
  }

  @Override
  public UnaryCallable<CreateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      createDaiAuthenticationKeyCallable() {
    return createDaiAuthenticationKeyCallable;
  }

  @Override
  public UnaryCallable<
          BatchCreateDaiAuthenticationKeysRequest, BatchCreateDaiAuthenticationKeysResponse>
      batchCreateDaiAuthenticationKeysCallable() {
    return batchCreateDaiAuthenticationKeysCallable;
  }

  @Override
  public UnaryCallable<UpdateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      updateDaiAuthenticationKeyCallable() {
    return updateDaiAuthenticationKeyCallable;
  }

  @Override
  public UnaryCallable<
          BatchUpdateDaiAuthenticationKeysRequest, BatchUpdateDaiAuthenticationKeysResponse>
      batchUpdateDaiAuthenticationKeysCallable() {
    return batchUpdateDaiAuthenticationKeysCallable;
  }

  @Override
  public UnaryCallable<
          BatchActivateDaiAuthenticationKeysRequest, BatchActivateDaiAuthenticationKeysResponse>
      batchActivateDaiAuthenticationKeysCallable() {
    return batchActivateDaiAuthenticationKeysCallable;
  }

  @Override
  public UnaryCallable<
          BatchDeactivateDaiAuthenticationKeysRequest, BatchDeactivateDaiAuthenticationKeysResponse>
      batchDeactivateDaiAuthenticationKeysCallable() {
    return batchDeactivateDaiAuthenticationKeysCallable;
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
