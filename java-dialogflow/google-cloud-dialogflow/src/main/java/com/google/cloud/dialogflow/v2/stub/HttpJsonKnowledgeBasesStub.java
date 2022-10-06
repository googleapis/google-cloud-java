/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.KnowledgeBasesClient.ListKnowledgeBasesPagedResponse;
import static com.google.cloud.dialogflow.v2.KnowledgeBasesClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.CreateKnowledgeBaseRequest;
import com.google.cloud.dialogflow.v2.DeleteKnowledgeBaseRequest;
import com.google.cloud.dialogflow.v2.GetKnowledgeBaseRequest;
import com.google.cloud.dialogflow.v2.KnowledgeBase;
import com.google.cloud.dialogflow.v2.ListKnowledgeBasesRequest;
import com.google.cloud.dialogflow.v2.ListKnowledgeBasesResponse;
import com.google.cloud.dialogflow.v2.UpdateKnowledgeBaseRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the KnowledgeBases service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonKnowledgeBasesStub extends KnowledgeBasesStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse>
      listKnowledgeBasesMethodDescriptor =
          ApiMethodDescriptor.<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2.KnowledgeBases/ListKnowledgeBases")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListKnowledgeBasesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/knowledgeBases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListKnowledgeBasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=projects/*/locations/*}/knowledgeBases",
                          "/v2/{parent=projects/*/agent}/knowledgeBases")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListKnowledgeBasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListKnowledgeBasesResponse>newBuilder()
                      .setDefaultInstance(ListKnowledgeBasesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetKnowledgeBaseRequest, KnowledgeBase>
      getKnowledgeBaseMethodDescriptor =
          ApiMethodDescriptor.<GetKnowledgeBaseRequest, KnowledgeBase>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2.KnowledgeBases/GetKnowledgeBase")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetKnowledgeBaseRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/knowledgeBases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetKnowledgeBaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=projects/*/locations/*/knowledgeBases/*}",
                          "/v2/{name=projects/*/agent/knowledgeBases/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetKnowledgeBaseRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<KnowledgeBase>newBuilder()
                      .setDefaultInstance(KnowledgeBase.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateKnowledgeBaseRequest, KnowledgeBase>
      createKnowledgeBaseMethodDescriptor =
          ApiMethodDescriptor.<CreateKnowledgeBaseRequest, KnowledgeBase>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2.KnowledgeBases/CreateKnowledgeBase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateKnowledgeBaseRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/knowledgeBases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateKnowledgeBaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=projects/*/locations/*}/knowledgeBases",
                          "/v2/{parent=projects/*/agent}/knowledgeBases")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateKnowledgeBaseRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("knowledgeBase", request.getKnowledgeBase(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<KnowledgeBase>newBuilder()
                      .setDefaultInstance(KnowledgeBase.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteKnowledgeBaseRequest, Empty>
      deleteKnowledgeBaseMethodDescriptor =
          ApiMethodDescriptor.<DeleteKnowledgeBaseRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2.KnowledgeBases/DeleteKnowledgeBase")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteKnowledgeBaseRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/knowledgeBases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteKnowledgeBaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=projects/*/locations/*/knowledgeBases/*}",
                          "/v2/{name=projects/*/agent/knowledgeBases/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteKnowledgeBaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateKnowledgeBaseRequest, KnowledgeBase>
      updateKnowledgeBaseMethodDescriptor =
          ApiMethodDescriptor.<UpdateKnowledgeBaseRequest, KnowledgeBase>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2.KnowledgeBases/UpdateKnowledgeBase")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateKnowledgeBaseRequest>newBuilder()
                      .setPath(
                          "/v2/{knowledgeBase.name=projects/*/knowledgeBases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateKnowledgeBaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "knowledgeBase.name", request.getKnowledgeBase().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{knowledgeBase.name=projects/*/locations/*/knowledgeBases/*}",
                          "/v2/{knowledgeBase.name=projects/*/agent/knowledgeBases/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateKnowledgeBaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("knowledgeBase", request.getKnowledgeBase(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<KnowledgeBase>newBuilder()
                      .setDefaultInstance(KnowledgeBase.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse>
      listKnowledgeBasesCallable;
  private final UnaryCallable<ListKnowledgeBasesRequest, ListKnowledgeBasesPagedResponse>
      listKnowledgeBasesPagedCallable;
  private final UnaryCallable<GetKnowledgeBaseRequest, KnowledgeBase> getKnowledgeBaseCallable;
  private final UnaryCallable<CreateKnowledgeBaseRequest, KnowledgeBase>
      createKnowledgeBaseCallable;
  private final UnaryCallable<DeleteKnowledgeBaseRequest, Empty> deleteKnowledgeBaseCallable;
  private final UnaryCallable<UpdateKnowledgeBaseRequest, KnowledgeBase>
      updateKnowledgeBaseCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonKnowledgeBasesStub create(KnowledgeBasesStubSettings settings)
      throws IOException {
    return new HttpJsonKnowledgeBasesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonKnowledgeBasesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonKnowledgeBasesStub(
        KnowledgeBasesStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonKnowledgeBasesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonKnowledgeBasesStub(
        KnowledgeBasesStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonKnowledgeBasesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonKnowledgeBasesStub(
      KnowledgeBasesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonKnowledgeBasesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonKnowledgeBasesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonKnowledgeBasesStub(
      KnowledgeBasesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse>
        listKnowledgeBasesTransportSettings =
            HttpJsonCallSettings.<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse>newBuilder()
                .setMethodDescriptor(listKnowledgeBasesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetKnowledgeBaseRequest, KnowledgeBase> getKnowledgeBaseTransportSettings =
        HttpJsonCallSettings.<GetKnowledgeBaseRequest, KnowledgeBase>newBuilder()
            .setMethodDescriptor(getKnowledgeBaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateKnowledgeBaseRequest, KnowledgeBase>
        createKnowledgeBaseTransportSettings =
            HttpJsonCallSettings.<CreateKnowledgeBaseRequest, KnowledgeBase>newBuilder()
                .setMethodDescriptor(createKnowledgeBaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteKnowledgeBaseRequest, Empty> deleteKnowledgeBaseTransportSettings =
        HttpJsonCallSettings.<DeleteKnowledgeBaseRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteKnowledgeBaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateKnowledgeBaseRequest, KnowledgeBase>
        updateKnowledgeBaseTransportSettings =
            HttpJsonCallSettings.<UpdateKnowledgeBaseRequest, KnowledgeBase>newBuilder()
                .setMethodDescriptor(updateKnowledgeBaseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listKnowledgeBasesCallable =
        callableFactory.createUnaryCallable(
            listKnowledgeBasesTransportSettings,
            settings.listKnowledgeBasesSettings(),
            clientContext);
    this.listKnowledgeBasesPagedCallable =
        callableFactory.createPagedCallable(
            listKnowledgeBasesTransportSettings,
            settings.listKnowledgeBasesSettings(),
            clientContext);
    this.getKnowledgeBaseCallable =
        callableFactory.createUnaryCallable(
            getKnowledgeBaseTransportSettings, settings.getKnowledgeBaseSettings(), clientContext);
    this.createKnowledgeBaseCallable =
        callableFactory.createUnaryCallable(
            createKnowledgeBaseTransportSettings,
            settings.createKnowledgeBaseSettings(),
            clientContext);
    this.deleteKnowledgeBaseCallable =
        callableFactory.createUnaryCallable(
            deleteKnowledgeBaseTransportSettings,
            settings.deleteKnowledgeBaseSettings(),
            clientContext);
    this.updateKnowledgeBaseCallable =
        callableFactory.createUnaryCallable(
            updateKnowledgeBaseTransportSettings,
            settings.updateKnowledgeBaseSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listKnowledgeBasesMethodDescriptor);
    methodDescriptors.add(getKnowledgeBaseMethodDescriptor);
    methodDescriptors.add(createKnowledgeBaseMethodDescriptor);
    methodDescriptors.add(deleteKnowledgeBaseMethodDescriptor);
    methodDescriptors.add(updateKnowledgeBaseMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse>
      listKnowledgeBasesCallable() {
    return listKnowledgeBasesCallable;
  }

  @Override
  public UnaryCallable<ListKnowledgeBasesRequest, ListKnowledgeBasesPagedResponse>
      listKnowledgeBasesPagedCallable() {
    return listKnowledgeBasesPagedCallable;
  }

  @Override
  public UnaryCallable<GetKnowledgeBaseRequest, KnowledgeBase> getKnowledgeBaseCallable() {
    return getKnowledgeBaseCallable;
  }

  @Override
  public UnaryCallable<CreateKnowledgeBaseRequest, KnowledgeBase> createKnowledgeBaseCallable() {
    return createKnowledgeBaseCallable;
  }

  @Override
  public UnaryCallable<DeleteKnowledgeBaseRequest, Empty> deleteKnowledgeBaseCallable() {
    return deleteKnowledgeBaseCallable;
  }

  @Override
  public UnaryCallable<UpdateKnowledgeBaseRequest, KnowledgeBase> updateKnowledgeBaseCallable() {
    return updateKnowledgeBaseCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
