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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.EntitySignalsMappingServiceClient.ListEntitySignalsMappingsPagedResponse;

import com.google.ads.admanager.v1.BatchCreateEntitySignalsMappingsRequest;
import com.google.ads.admanager.v1.BatchCreateEntitySignalsMappingsResponse;
import com.google.ads.admanager.v1.BatchUpdateEntitySignalsMappingsRequest;
import com.google.ads.admanager.v1.BatchUpdateEntitySignalsMappingsResponse;
import com.google.ads.admanager.v1.CreateEntitySignalsMappingRequest;
import com.google.ads.admanager.v1.EntitySignalsMapping;
import com.google.ads.admanager.v1.GetEntitySignalsMappingRequest;
import com.google.ads.admanager.v1.ListEntitySignalsMappingsRequest;
import com.google.ads.admanager.v1.ListEntitySignalsMappingsResponse;
import com.google.ads.admanager.v1.UpdateEntitySignalsMappingRequest;
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
 * REST stub implementation for the EntitySignalsMappingService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonEntitySignalsMappingServiceStub extends EntitySignalsMappingServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetEntitySignalsMappingRequest, EntitySignalsMapping>
      getEntitySignalsMappingMethodDescriptor =
          ApiMethodDescriptor.<GetEntitySignalsMappingRequest, EntitySignalsMapping>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.EntitySignalsMappingService/GetEntitySignalsMapping")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEntitySignalsMappingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/entitySignalsMappings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEntitySignalsMappingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEntitySignalsMappingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EntitySignalsMapping>newBuilder()
                      .setDefaultInstance(EntitySignalsMapping.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListEntitySignalsMappingsRequest, ListEntitySignalsMappingsResponse>
      listEntitySignalsMappingsMethodDescriptor =
          ApiMethodDescriptor
              .<ListEntitySignalsMappingsRequest, ListEntitySignalsMappingsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.EntitySignalsMappingService/ListEntitySignalsMappings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEntitySignalsMappingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/entitySignalsMappings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntitySignalsMappingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntitySignalsMappingsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListEntitySignalsMappingsResponse>newBuilder()
                      .setDefaultInstance(ListEntitySignalsMappingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateEntitySignalsMappingRequest, EntitySignalsMapping>
      createEntitySignalsMappingMethodDescriptor =
          ApiMethodDescriptor.<CreateEntitySignalsMappingRequest, EntitySignalsMapping>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.EntitySignalsMappingService/CreateEntitySignalsMapping")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEntitySignalsMappingRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/entitySignalsMappings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntitySignalsMappingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntitySignalsMappingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "entitySignalsMapping",
                                      request.getEntitySignalsMapping(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EntitySignalsMapping>newBuilder()
                      .setDefaultInstance(EntitySignalsMapping.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateEntitySignalsMappingRequest, EntitySignalsMapping>
      updateEntitySignalsMappingMethodDescriptor =
          ApiMethodDescriptor.<UpdateEntitySignalsMappingRequest, EntitySignalsMapping>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.EntitySignalsMappingService/UpdateEntitySignalsMapping")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEntitySignalsMappingRequest>newBuilder()
                      .setPath(
                          "/v1/{entitySignalsMapping.name=networks/*/entitySignalsMappings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEntitySignalsMappingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "entitySignalsMapping.name",
                                request.getEntitySignalsMapping().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEntitySignalsMappingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "entitySignalsMapping",
                                      request.getEntitySignalsMapping(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EntitySignalsMapping>newBuilder()
                      .setDefaultInstance(EntitySignalsMapping.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateEntitySignalsMappingsRequest, BatchCreateEntitySignalsMappingsResponse>
      batchCreateEntitySignalsMappingsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateEntitySignalsMappingsRequest, BatchCreateEntitySignalsMappingsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.EntitySignalsMappingService/BatchCreateEntitySignalsMappings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateEntitySignalsMappingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/entitySignalsMappings:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateEntitySignalsMappingsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateEntitySignalsMappingsRequest>
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
                  ProtoMessageResponseParser.<BatchCreateEntitySignalsMappingsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchCreateEntitySignalsMappingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateEntitySignalsMappingsRequest, BatchUpdateEntitySignalsMappingsResponse>
      batchUpdateEntitySignalsMappingsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateEntitySignalsMappingsRequest, BatchUpdateEntitySignalsMappingsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.EntitySignalsMappingService/BatchUpdateEntitySignalsMappings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateEntitySignalsMappingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/entitySignalsMappings:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateEntitySignalsMappingsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateEntitySignalsMappingsRequest>
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
                  ProtoMessageResponseParser.<BatchUpdateEntitySignalsMappingsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchUpdateEntitySignalsMappingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetEntitySignalsMappingRequest, EntitySignalsMapping>
      getEntitySignalsMappingCallable;
  private final UnaryCallable<ListEntitySignalsMappingsRequest, ListEntitySignalsMappingsResponse>
      listEntitySignalsMappingsCallable;
  private final UnaryCallable<
          ListEntitySignalsMappingsRequest, ListEntitySignalsMappingsPagedResponse>
      listEntitySignalsMappingsPagedCallable;
  private final UnaryCallable<CreateEntitySignalsMappingRequest, EntitySignalsMapping>
      createEntitySignalsMappingCallable;
  private final UnaryCallable<UpdateEntitySignalsMappingRequest, EntitySignalsMapping>
      updateEntitySignalsMappingCallable;
  private final UnaryCallable<
          BatchCreateEntitySignalsMappingsRequest, BatchCreateEntitySignalsMappingsResponse>
      batchCreateEntitySignalsMappingsCallable;
  private final UnaryCallable<
          BatchUpdateEntitySignalsMappingsRequest, BatchUpdateEntitySignalsMappingsResponse>
      batchUpdateEntitySignalsMappingsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonEntitySignalsMappingServiceStub create(
      EntitySignalsMappingServiceStubSettings settings) throws IOException {
    return new HttpJsonEntitySignalsMappingServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonEntitySignalsMappingServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonEntitySignalsMappingServiceStub(
        EntitySignalsMappingServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonEntitySignalsMappingServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonEntitySignalsMappingServiceStub(
        EntitySignalsMappingServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonEntitySignalsMappingServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonEntitySignalsMappingServiceStub(
      EntitySignalsMappingServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonEntitySignalsMappingServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonEntitySignalsMappingServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonEntitySignalsMappingServiceStub(
      EntitySignalsMappingServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetEntitySignalsMappingRequest, EntitySignalsMapping>
        getEntitySignalsMappingTransportSettings =
            HttpJsonCallSettings.<GetEntitySignalsMappingRequest, EntitySignalsMapping>newBuilder()
                .setMethodDescriptor(getEntitySignalsMappingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListEntitySignalsMappingsRequest, ListEntitySignalsMappingsResponse>
        listEntitySignalsMappingsTransportSettings =
            HttpJsonCallSettings
                .<ListEntitySignalsMappingsRequest, ListEntitySignalsMappingsResponse>newBuilder()
                .setMethodDescriptor(listEntitySignalsMappingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateEntitySignalsMappingRequest, EntitySignalsMapping>
        createEntitySignalsMappingTransportSettings =
            HttpJsonCallSettings
                .<CreateEntitySignalsMappingRequest, EntitySignalsMapping>newBuilder()
                .setMethodDescriptor(createEntitySignalsMappingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateEntitySignalsMappingRequest, EntitySignalsMapping>
        updateEntitySignalsMappingTransportSettings =
            HttpJsonCallSettings
                .<UpdateEntitySignalsMappingRequest, EntitySignalsMapping>newBuilder()
                .setMethodDescriptor(updateEntitySignalsMappingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "entity_signals_mapping.name",
                          String.valueOf(request.getEntitySignalsMapping().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            BatchCreateEntitySignalsMappingsRequest, BatchCreateEntitySignalsMappingsResponse>
        batchCreateEntitySignalsMappingsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateEntitySignalsMappingsRequest, BatchCreateEntitySignalsMappingsResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateEntitySignalsMappingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            BatchUpdateEntitySignalsMappingsRequest, BatchUpdateEntitySignalsMappingsResponse>
        batchUpdateEntitySignalsMappingsTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateEntitySignalsMappingsRequest, BatchUpdateEntitySignalsMappingsResponse>
                    newBuilder()
                .setMethodDescriptor(batchUpdateEntitySignalsMappingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getEntitySignalsMappingCallable =
        callableFactory.createUnaryCallable(
            getEntitySignalsMappingTransportSettings,
            settings.getEntitySignalsMappingSettings(),
            clientContext);
    this.listEntitySignalsMappingsCallable =
        callableFactory.createUnaryCallable(
            listEntitySignalsMappingsTransportSettings,
            settings.listEntitySignalsMappingsSettings(),
            clientContext);
    this.listEntitySignalsMappingsPagedCallable =
        callableFactory.createPagedCallable(
            listEntitySignalsMappingsTransportSettings,
            settings.listEntitySignalsMappingsSettings(),
            clientContext);
    this.createEntitySignalsMappingCallable =
        callableFactory.createUnaryCallable(
            createEntitySignalsMappingTransportSettings,
            settings.createEntitySignalsMappingSettings(),
            clientContext);
    this.updateEntitySignalsMappingCallable =
        callableFactory.createUnaryCallable(
            updateEntitySignalsMappingTransportSettings,
            settings.updateEntitySignalsMappingSettings(),
            clientContext);
    this.batchCreateEntitySignalsMappingsCallable =
        callableFactory.createUnaryCallable(
            batchCreateEntitySignalsMappingsTransportSettings,
            settings.batchCreateEntitySignalsMappingsSettings(),
            clientContext);
    this.batchUpdateEntitySignalsMappingsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateEntitySignalsMappingsTransportSettings,
            settings.batchUpdateEntitySignalsMappingsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getEntitySignalsMappingMethodDescriptor);
    methodDescriptors.add(listEntitySignalsMappingsMethodDescriptor);
    methodDescriptors.add(createEntitySignalsMappingMethodDescriptor);
    methodDescriptors.add(updateEntitySignalsMappingMethodDescriptor);
    methodDescriptors.add(batchCreateEntitySignalsMappingsMethodDescriptor);
    methodDescriptors.add(batchUpdateEntitySignalsMappingsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetEntitySignalsMappingRequest, EntitySignalsMapping>
      getEntitySignalsMappingCallable() {
    return getEntitySignalsMappingCallable;
  }

  @Override
  public UnaryCallable<ListEntitySignalsMappingsRequest, ListEntitySignalsMappingsResponse>
      listEntitySignalsMappingsCallable() {
    return listEntitySignalsMappingsCallable;
  }

  @Override
  public UnaryCallable<ListEntitySignalsMappingsRequest, ListEntitySignalsMappingsPagedResponse>
      listEntitySignalsMappingsPagedCallable() {
    return listEntitySignalsMappingsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateEntitySignalsMappingRequest, EntitySignalsMapping>
      createEntitySignalsMappingCallable() {
    return createEntitySignalsMappingCallable;
  }

  @Override
  public UnaryCallable<UpdateEntitySignalsMappingRequest, EntitySignalsMapping>
      updateEntitySignalsMappingCallable() {
    return updateEntitySignalsMappingCallable;
  }

  @Override
  public UnaryCallable<
          BatchCreateEntitySignalsMappingsRequest, BatchCreateEntitySignalsMappingsResponse>
      batchCreateEntitySignalsMappingsCallable() {
    return batchCreateEntitySignalsMappingsCallable;
  }

  @Override
  public UnaryCallable<
          BatchUpdateEntitySignalsMappingsRequest, BatchUpdateEntitySignalsMappingsResponse>
      batchUpdateEntitySignalsMappingsCallable() {
    return batchUpdateEntitySignalsMappingsCallable;
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
