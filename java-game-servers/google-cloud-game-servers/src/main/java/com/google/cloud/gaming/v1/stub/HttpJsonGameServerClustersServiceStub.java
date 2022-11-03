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

import static com.google.cloud.gaming.v1.GameServerClustersServiceClient.ListGameServerClustersPagedResponse;

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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gaming.v1.CreateGameServerClusterRequest;
import com.google.cloud.gaming.v1.DeleteGameServerClusterRequest;
import com.google.cloud.gaming.v1.GameServerCluster;
import com.google.cloud.gaming.v1.GetGameServerClusterRequest;
import com.google.cloud.gaming.v1.ListGameServerClustersRequest;
import com.google.cloud.gaming.v1.ListGameServerClustersResponse;
import com.google.cloud.gaming.v1.OperationMetadata;
import com.google.cloud.gaming.v1.PreviewCreateGameServerClusterRequest;
import com.google.cloud.gaming.v1.PreviewCreateGameServerClusterResponse;
import com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterRequest;
import com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterResponse;
import com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterRequest;
import com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterResponse;
import com.google.cloud.gaming.v1.UpdateGameServerClusterRequest;
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
 * REST stub implementation for the GameServerClustersService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonGameServerClustersServiceStub extends GameServerClustersServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(GameServerCluster.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListGameServerClustersRequest, ListGameServerClustersResponse>
      listGameServerClustersMethodDescriptor =
          ApiMethodDescriptor
              .<ListGameServerClustersRequest, ListGameServerClustersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerClustersService/ListGameServerClusters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGameServerClustersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/realms/*}/gameServerClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGameServerClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGameServerClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListGameServerClustersResponse>newBuilder()
                      .setDefaultInstance(ListGameServerClustersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGameServerClusterRequest, GameServerCluster>
      getGameServerClusterMethodDescriptor =
          ApiMethodDescriptor.<GetGameServerClusterRequest, GameServerCluster>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerClustersService/GetGameServerCluster")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGameServerClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/realms/*/gameServerClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGameServerClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGameServerClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GameServerCluster>newBuilder()
                      .setDefaultInstance(GameServerCluster.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateGameServerClusterRequest, Operation>
      createGameServerClusterMethodDescriptor =
          ApiMethodDescriptor.<CreateGameServerClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerClustersService/CreateGameServerCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGameServerClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/realms/*}/gameServerClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGameServerClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGameServerClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "gameServerClusterId", request.getGameServerClusterId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "gameServerCluster", request.getGameServerCluster(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateGameServerClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          PreviewCreateGameServerClusterRequest, PreviewCreateGameServerClusterResponse>
      previewCreateGameServerClusterMethodDescriptor =
          ApiMethodDescriptor
              .<PreviewCreateGameServerClusterRequest, PreviewCreateGameServerClusterResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerClustersService/PreviewCreateGameServerCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PreviewCreateGameServerClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/realms/*}/gameServerClusters:previewCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PreviewCreateGameServerClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PreviewCreateGameServerClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "gameServerClusterId", request.getGameServerClusterId());
                            serializer.putQueryParam(
                                fields, "previewTime", request.getPreviewTime());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "gameServerCluster", request.getGameServerCluster(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PreviewCreateGameServerClusterResponse>newBuilder()
                      .setDefaultInstance(
                          PreviewCreateGameServerClusterResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteGameServerClusterRequest, Operation>
      deleteGameServerClusterMethodDescriptor =
          ApiMethodDescriptor.<DeleteGameServerClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerClustersService/DeleteGameServerCluster")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGameServerClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/realms/*/gameServerClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGameServerClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGameServerClusterRequest> serializer =
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
                  (DeleteGameServerClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          PreviewDeleteGameServerClusterRequest, PreviewDeleteGameServerClusterResponse>
      previewDeleteGameServerClusterMethodDescriptor =
          ApiMethodDescriptor
              .<PreviewDeleteGameServerClusterRequest, PreviewDeleteGameServerClusterResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerClustersService/PreviewDeleteGameServerCluster")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PreviewDeleteGameServerClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/realms/*/gameServerClusters/*}:previewDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PreviewDeleteGameServerClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PreviewDeleteGameServerClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "previewTime", request.getPreviewTime());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PreviewDeleteGameServerClusterResponse>newBuilder()
                      .setDefaultInstance(
                          PreviewDeleteGameServerClusterResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateGameServerClusterRequest, Operation>
      updateGameServerClusterMethodDescriptor =
          ApiMethodDescriptor.<UpdateGameServerClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerClustersService/UpdateGameServerCluster")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGameServerClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{gameServerCluster.name=projects/*/locations/*/realms/*/gameServerClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGameServerClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "gameServerCluster.name",
                                request.getGameServerCluster().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGameServerClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "gameServerCluster", request.getGameServerCluster(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateGameServerClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          PreviewUpdateGameServerClusterRequest, PreviewUpdateGameServerClusterResponse>
      previewUpdateGameServerClusterMethodDescriptor =
          ApiMethodDescriptor
              .<PreviewUpdateGameServerClusterRequest, PreviewUpdateGameServerClusterResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerClustersService/PreviewUpdateGameServerCluster")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PreviewUpdateGameServerClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{gameServerCluster.name=projects/*/locations/*/realms/*/gameServerClusters/*}:previewUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PreviewUpdateGameServerClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "gameServerCluster.name",
                                request.getGameServerCluster().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PreviewUpdateGameServerClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "previewTime", request.getPreviewTime());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "gameServerCluster", request.getGameServerCluster(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PreviewUpdateGameServerClusterResponse>newBuilder()
                      .setDefaultInstance(
                          PreviewUpdateGameServerClusterResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListGameServerClustersRequest, ListGameServerClustersResponse>
      listGameServerClustersCallable;
  private final UnaryCallable<ListGameServerClustersRequest, ListGameServerClustersPagedResponse>
      listGameServerClustersPagedCallable;
  private final UnaryCallable<GetGameServerClusterRequest, GameServerCluster>
      getGameServerClusterCallable;
  private final UnaryCallable<CreateGameServerClusterRequest, Operation>
      createGameServerClusterCallable;
  private final OperationCallable<
          CreateGameServerClusterRequest, GameServerCluster, OperationMetadata>
      createGameServerClusterOperationCallable;
  private final UnaryCallable<
          PreviewCreateGameServerClusterRequest, PreviewCreateGameServerClusterResponse>
      previewCreateGameServerClusterCallable;
  private final UnaryCallable<DeleteGameServerClusterRequest, Operation>
      deleteGameServerClusterCallable;
  private final OperationCallable<DeleteGameServerClusterRequest, Empty, OperationMetadata>
      deleteGameServerClusterOperationCallable;
  private final UnaryCallable<
          PreviewDeleteGameServerClusterRequest, PreviewDeleteGameServerClusterResponse>
      previewDeleteGameServerClusterCallable;
  private final UnaryCallable<UpdateGameServerClusterRequest, Operation>
      updateGameServerClusterCallable;
  private final OperationCallable<
          UpdateGameServerClusterRequest, GameServerCluster, OperationMetadata>
      updateGameServerClusterOperationCallable;
  private final UnaryCallable<
          PreviewUpdateGameServerClusterRequest, PreviewUpdateGameServerClusterResponse>
      previewUpdateGameServerClusterCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGameServerClustersServiceStub create(
      GameServerClustersServiceStubSettings settings) throws IOException {
    return new HttpJsonGameServerClustersServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGameServerClustersServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGameServerClustersServiceStub(
        GameServerClustersServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonGameServerClustersServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGameServerClustersServiceStub(
        GameServerClustersServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGameServerClustersServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGameServerClustersServiceStub(
      GameServerClustersServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGameServerClustersServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGameServerClustersServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGameServerClustersServiceStub(
      GameServerClustersServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListGameServerClustersRequest, ListGameServerClustersResponse>
        listGameServerClustersTransportSettings =
            HttpJsonCallSettings
                .<ListGameServerClustersRequest, ListGameServerClustersResponse>newBuilder()
                .setMethodDescriptor(listGameServerClustersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetGameServerClusterRequest, GameServerCluster>
        getGameServerClusterTransportSettings =
            HttpJsonCallSettings.<GetGameServerClusterRequest, GameServerCluster>newBuilder()
                .setMethodDescriptor(getGameServerClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateGameServerClusterRequest, Operation>
        createGameServerClusterTransportSettings =
            HttpJsonCallSettings.<CreateGameServerClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(createGameServerClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            PreviewCreateGameServerClusterRequest, PreviewCreateGameServerClusterResponse>
        previewCreateGameServerClusterTransportSettings =
            HttpJsonCallSettings
                .<PreviewCreateGameServerClusterRequest, PreviewCreateGameServerClusterResponse>
                    newBuilder()
                .setMethodDescriptor(previewCreateGameServerClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteGameServerClusterRequest, Operation>
        deleteGameServerClusterTransportSettings =
            HttpJsonCallSettings.<DeleteGameServerClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGameServerClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            PreviewDeleteGameServerClusterRequest, PreviewDeleteGameServerClusterResponse>
        previewDeleteGameServerClusterTransportSettings =
            HttpJsonCallSettings
                .<PreviewDeleteGameServerClusterRequest, PreviewDeleteGameServerClusterResponse>
                    newBuilder()
                .setMethodDescriptor(previewDeleteGameServerClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateGameServerClusterRequest, Operation>
        updateGameServerClusterTransportSettings =
            HttpJsonCallSettings.<UpdateGameServerClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(updateGameServerClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            PreviewUpdateGameServerClusterRequest, PreviewUpdateGameServerClusterResponse>
        previewUpdateGameServerClusterTransportSettings =
            HttpJsonCallSettings
                .<PreviewUpdateGameServerClusterRequest, PreviewUpdateGameServerClusterResponse>
                    newBuilder()
                .setMethodDescriptor(previewUpdateGameServerClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listGameServerClustersCallable =
        callableFactory.createUnaryCallable(
            listGameServerClustersTransportSettings,
            settings.listGameServerClustersSettings(),
            clientContext);
    this.listGameServerClustersPagedCallable =
        callableFactory.createPagedCallable(
            listGameServerClustersTransportSettings,
            settings.listGameServerClustersSettings(),
            clientContext);
    this.getGameServerClusterCallable =
        callableFactory.createUnaryCallable(
            getGameServerClusterTransportSettings,
            settings.getGameServerClusterSettings(),
            clientContext);
    this.createGameServerClusterCallable =
        callableFactory.createUnaryCallable(
            createGameServerClusterTransportSettings,
            settings.createGameServerClusterSettings(),
            clientContext);
    this.createGameServerClusterOperationCallable =
        callableFactory.createOperationCallable(
            createGameServerClusterTransportSettings,
            settings.createGameServerClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.previewCreateGameServerClusterCallable =
        callableFactory.createUnaryCallable(
            previewCreateGameServerClusterTransportSettings,
            settings.previewCreateGameServerClusterSettings(),
            clientContext);
    this.deleteGameServerClusterCallable =
        callableFactory.createUnaryCallable(
            deleteGameServerClusterTransportSettings,
            settings.deleteGameServerClusterSettings(),
            clientContext);
    this.deleteGameServerClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteGameServerClusterTransportSettings,
            settings.deleteGameServerClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.previewDeleteGameServerClusterCallable =
        callableFactory.createUnaryCallable(
            previewDeleteGameServerClusterTransportSettings,
            settings.previewDeleteGameServerClusterSettings(),
            clientContext);
    this.updateGameServerClusterCallable =
        callableFactory.createUnaryCallable(
            updateGameServerClusterTransportSettings,
            settings.updateGameServerClusterSettings(),
            clientContext);
    this.updateGameServerClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateGameServerClusterTransportSettings,
            settings.updateGameServerClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.previewUpdateGameServerClusterCallable =
        callableFactory.createUnaryCallable(
            previewUpdateGameServerClusterTransportSettings,
            settings.previewUpdateGameServerClusterSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listGameServerClustersMethodDescriptor);
    methodDescriptors.add(getGameServerClusterMethodDescriptor);
    methodDescriptors.add(createGameServerClusterMethodDescriptor);
    methodDescriptors.add(previewCreateGameServerClusterMethodDescriptor);
    methodDescriptors.add(deleteGameServerClusterMethodDescriptor);
    methodDescriptors.add(previewDeleteGameServerClusterMethodDescriptor);
    methodDescriptors.add(updateGameServerClusterMethodDescriptor);
    methodDescriptors.add(previewUpdateGameServerClusterMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListGameServerClustersRequest, ListGameServerClustersResponse>
      listGameServerClustersCallable() {
    return listGameServerClustersCallable;
  }

  @Override
  public UnaryCallable<ListGameServerClustersRequest, ListGameServerClustersPagedResponse>
      listGameServerClustersPagedCallable() {
    return listGameServerClustersPagedCallable;
  }

  @Override
  public UnaryCallable<GetGameServerClusterRequest, GameServerCluster>
      getGameServerClusterCallable() {
    return getGameServerClusterCallable;
  }

  @Override
  public UnaryCallable<CreateGameServerClusterRequest, Operation>
      createGameServerClusterCallable() {
    return createGameServerClusterCallable;
  }

  @Override
  public OperationCallable<CreateGameServerClusterRequest, GameServerCluster, OperationMetadata>
      createGameServerClusterOperationCallable() {
    return createGameServerClusterOperationCallable;
  }

  @Override
  public UnaryCallable<
          PreviewCreateGameServerClusterRequest, PreviewCreateGameServerClusterResponse>
      previewCreateGameServerClusterCallable() {
    return previewCreateGameServerClusterCallable;
  }

  @Override
  public UnaryCallable<DeleteGameServerClusterRequest, Operation>
      deleteGameServerClusterCallable() {
    return deleteGameServerClusterCallable;
  }

  @Override
  public OperationCallable<DeleteGameServerClusterRequest, Empty, OperationMetadata>
      deleteGameServerClusterOperationCallable() {
    return deleteGameServerClusterOperationCallable;
  }

  @Override
  public UnaryCallable<
          PreviewDeleteGameServerClusterRequest, PreviewDeleteGameServerClusterResponse>
      previewDeleteGameServerClusterCallable() {
    return previewDeleteGameServerClusterCallable;
  }

  @Override
  public UnaryCallable<UpdateGameServerClusterRequest, Operation>
      updateGameServerClusterCallable() {
    return updateGameServerClusterCallable;
  }

  @Override
  public OperationCallable<UpdateGameServerClusterRequest, GameServerCluster, OperationMetadata>
      updateGameServerClusterOperationCallable() {
    return updateGameServerClusterOperationCallable;
  }

  @Override
  public UnaryCallable<
          PreviewUpdateGameServerClusterRequest, PreviewUpdateGameServerClusterResponse>
      previewUpdateGameServerClusterCallable() {
    return previewUpdateGameServerClusterCallable;
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
