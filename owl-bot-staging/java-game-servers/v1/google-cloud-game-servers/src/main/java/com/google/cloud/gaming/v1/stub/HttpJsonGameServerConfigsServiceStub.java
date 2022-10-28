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

package com.google.cloud.gaming.v1.stub;

import static com.google.cloud.gaming.v1.GameServerConfigsServiceClient.ListGameServerConfigsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gaming.v1.CreateGameServerConfigRequest;
import com.google.cloud.gaming.v1.DeleteGameServerConfigRequest;
import com.google.cloud.gaming.v1.GameServerConfig;
import com.google.cloud.gaming.v1.GetGameServerConfigRequest;
import com.google.cloud.gaming.v1.ListGameServerConfigsRequest;
import com.google.cloud.gaming.v1.ListGameServerConfigsResponse;
import com.google.cloud.gaming.v1.OperationMetadata;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the GameServerConfigsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonGameServerConfigsServiceStub extends GameServerConfigsServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(GameServerConfig.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListGameServerConfigsRequest, ListGameServerConfigsResponse>
      listGameServerConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<ListGameServerConfigsRequest, ListGameServerConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerConfigsService/ListGameServerConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGameServerConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/gameServerDeployments/*}/configs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGameServerConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGameServerConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListGameServerConfigsResponse>newBuilder()
                      .setDefaultInstance(ListGameServerConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGameServerConfigRequest, GameServerConfig>
      getGameServerConfigMethodDescriptor =
          ApiMethodDescriptor.<GetGameServerConfigRequest, GameServerConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerConfigsService/GetGameServerConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGameServerConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/gameServerDeployments/*/configs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGameServerConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGameServerConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GameServerConfig>newBuilder()
                      .setDefaultInstance(GameServerConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateGameServerConfigRequest, Operation>
      createGameServerConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateGameServerConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerConfigsService/CreateGameServerConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGameServerConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/gameServerDeployments/*}/configs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGameServerConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGameServerConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "configId", request.getConfigId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("gameServerConfig", request.getGameServerConfig(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateGameServerConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteGameServerConfigRequest, Operation>
      deleteGameServerConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteGameServerConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerConfigsService/DeleteGameServerConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGameServerConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/gameServerDeployments/*/configs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGameServerConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGameServerConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteGameServerConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<ListGameServerConfigsRequest, ListGameServerConfigsResponse>
      listGameServerConfigsCallable;
  private final UnaryCallable<ListGameServerConfigsRequest, ListGameServerConfigsPagedResponse>
      listGameServerConfigsPagedCallable;
  private final UnaryCallable<GetGameServerConfigRequest, GameServerConfig>
      getGameServerConfigCallable;
  private final UnaryCallable<CreateGameServerConfigRequest, Operation>
      createGameServerConfigCallable;
  private final OperationCallable<
          CreateGameServerConfigRequest, GameServerConfig, OperationMetadata>
      createGameServerConfigOperationCallable;
  private final UnaryCallable<DeleteGameServerConfigRequest, Operation>
      deleteGameServerConfigCallable;
  private final OperationCallable<DeleteGameServerConfigRequest, Empty, OperationMetadata>
      deleteGameServerConfigOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGameServerConfigsServiceStub create(
      GameServerConfigsServiceStubSettings settings) throws IOException {
    return new HttpJsonGameServerConfigsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGameServerConfigsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGameServerConfigsServiceStub(
        GameServerConfigsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonGameServerConfigsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGameServerConfigsServiceStub(
        GameServerConfigsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGameServerConfigsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGameServerConfigsServiceStub(
      GameServerConfigsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGameServerConfigsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGameServerConfigsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGameServerConfigsServiceStub(
      GameServerConfigsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListGameServerConfigsRequest, ListGameServerConfigsResponse>
        listGameServerConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListGameServerConfigsRequest, ListGameServerConfigsResponse>newBuilder()
                .setMethodDescriptor(listGameServerConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetGameServerConfigRequest, GameServerConfig>
        getGameServerConfigTransportSettings =
            HttpJsonCallSettings.<GetGameServerConfigRequest, GameServerConfig>newBuilder()
                .setMethodDescriptor(getGameServerConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateGameServerConfigRequest, Operation>
        createGameServerConfigTransportSettings =
            HttpJsonCallSettings.<CreateGameServerConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(createGameServerConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteGameServerConfigRequest, Operation>
        deleteGameServerConfigTransportSettings =
            HttpJsonCallSettings.<DeleteGameServerConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGameServerConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listGameServerConfigsCallable =
        callableFactory.createUnaryCallable(
            listGameServerConfigsTransportSettings,
            settings.listGameServerConfigsSettings(),
            clientContext);
    this.listGameServerConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listGameServerConfigsTransportSettings,
            settings.listGameServerConfigsSettings(),
            clientContext);
    this.getGameServerConfigCallable =
        callableFactory.createUnaryCallable(
            getGameServerConfigTransportSettings,
            settings.getGameServerConfigSettings(),
            clientContext);
    this.createGameServerConfigCallable =
        callableFactory.createUnaryCallable(
            createGameServerConfigTransportSettings,
            settings.createGameServerConfigSettings(),
            clientContext);
    this.createGameServerConfigOperationCallable =
        callableFactory.createOperationCallable(
            createGameServerConfigTransportSettings,
            settings.createGameServerConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteGameServerConfigCallable =
        callableFactory.createUnaryCallable(
            deleteGameServerConfigTransportSettings,
            settings.deleteGameServerConfigSettings(),
            clientContext);
    this.deleteGameServerConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteGameServerConfigTransportSettings,
            settings.deleteGameServerConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listGameServerConfigsMethodDescriptor);
    methodDescriptors.add(getGameServerConfigMethodDescriptor);
    methodDescriptors.add(createGameServerConfigMethodDescriptor);
    methodDescriptors.add(deleteGameServerConfigMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListGameServerConfigsRequest, ListGameServerConfigsResponse>
      listGameServerConfigsCallable() {
    return listGameServerConfigsCallable;
  }

  @Override
  public UnaryCallable<ListGameServerConfigsRequest, ListGameServerConfigsPagedResponse>
      listGameServerConfigsPagedCallable() {
    return listGameServerConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetGameServerConfigRequest, GameServerConfig> getGameServerConfigCallable() {
    return getGameServerConfigCallable;
  }

  @Override
  public UnaryCallable<CreateGameServerConfigRequest, Operation> createGameServerConfigCallable() {
    return createGameServerConfigCallable;
  }

  @Override
  public OperationCallable<CreateGameServerConfigRequest, GameServerConfig, OperationMetadata>
      createGameServerConfigOperationCallable() {
    return createGameServerConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGameServerConfigRequest, Operation> deleteGameServerConfigCallable() {
    return deleteGameServerConfigCallable;
  }

  @Override
  public OperationCallable<DeleteGameServerConfigRequest, Empty, OperationMetadata>
      deleteGameServerConfigOperationCallable() {
    return deleteGameServerConfigOperationCallable;
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
