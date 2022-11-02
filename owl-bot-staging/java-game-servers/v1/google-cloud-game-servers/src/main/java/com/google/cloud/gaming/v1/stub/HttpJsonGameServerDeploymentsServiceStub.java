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

import static com.google.cloud.gaming.v1.GameServerDeploymentsServiceClient.ListGameServerDeploymentsPagedResponse;

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
import com.google.cloud.gaming.v1.CreateGameServerDeploymentRequest;
import com.google.cloud.gaming.v1.DeleteGameServerDeploymentRequest;
import com.google.cloud.gaming.v1.FetchDeploymentStateRequest;
import com.google.cloud.gaming.v1.FetchDeploymentStateResponse;
import com.google.cloud.gaming.v1.GameServerDeployment;
import com.google.cloud.gaming.v1.GameServerDeploymentRollout;
import com.google.cloud.gaming.v1.GetGameServerDeploymentRequest;
import com.google.cloud.gaming.v1.GetGameServerDeploymentRolloutRequest;
import com.google.cloud.gaming.v1.ListGameServerDeploymentsRequest;
import com.google.cloud.gaming.v1.ListGameServerDeploymentsResponse;
import com.google.cloud.gaming.v1.OperationMetadata;
import com.google.cloud.gaming.v1.PreviewGameServerDeploymentRolloutRequest;
import com.google.cloud.gaming.v1.PreviewGameServerDeploymentRolloutResponse;
import com.google.cloud.gaming.v1.UpdateGameServerDeploymentRequest;
import com.google.cloud.gaming.v1.UpdateGameServerDeploymentRolloutRequest;
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
 * REST stub implementation for the GameServerDeploymentsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonGameServerDeploymentsServiceStub extends GameServerDeploymentsServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(OperationMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .add(GameServerDeployment.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListGameServerDeploymentsRequest, ListGameServerDeploymentsResponse>
      listGameServerDeploymentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListGameServerDeploymentsRequest, ListGameServerDeploymentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerDeploymentsService/ListGameServerDeployments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGameServerDeploymentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/gameServerDeployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGameServerDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGameServerDeploymentsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListGameServerDeploymentsResponse>newBuilder()
                      .setDefaultInstance(ListGameServerDeploymentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGameServerDeploymentRequest, GameServerDeployment>
      getGameServerDeploymentMethodDescriptor =
          ApiMethodDescriptor.<GetGameServerDeploymentRequest, GameServerDeployment>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerDeploymentsService/GetGameServerDeployment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGameServerDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/gameServerDeployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGameServerDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGameServerDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GameServerDeployment>newBuilder()
                      .setDefaultInstance(GameServerDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateGameServerDeploymentRequest, Operation>
      createGameServerDeploymentMethodDescriptor =
          ApiMethodDescriptor.<CreateGameServerDeploymentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerDeploymentsService/CreateGameServerDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGameServerDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/gameServerDeployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGameServerDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGameServerDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "deploymentId", request.getDeploymentId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "gameServerDeployment",
                                      request.getGameServerDeployment(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateGameServerDeploymentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteGameServerDeploymentRequest, Operation>
      deleteGameServerDeploymentMethodDescriptor =
          ApiMethodDescriptor.<DeleteGameServerDeploymentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerDeploymentsService/DeleteGameServerDeployment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGameServerDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/gameServerDeployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGameServerDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGameServerDeploymentRequest> serializer =
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
                  (DeleteGameServerDeploymentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateGameServerDeploymentRequest, Operation>
      updateGameServerDeploymentMethodDescriptor =
          ApiMethodDescriptor.<UpdateGameServerDeploymentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerDeploymentsService/UpdateGameServerDeployment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGameServerDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{gameServerDeployment.name=projects/*/locations/*/gameServerDeployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGameServerDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "gameServerDeployment.name",
                                request.getGameServerDeployment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGameServerDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "gameServerDeployment",
                                      request.getGameServerDeployment(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateGameServerDeploymentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GetGameServerDeploymentRolloutRequest, GameServerDeploymentRollout>
      getGameServerDeploymentRolloutMethodDescriptor =
          ApiMethodDescriptor
              .<GetGameServerDeploymentRolloutRequest, GameServerDeploymentRollout>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerDeploymentsService/GetGameServerDeploymentRollout")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGameServerDeploymentRolloutRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/gameServerDeployments/*}/rollout",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGameServerDeploymentRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGameServerDeploymentRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GameServerDeploymentRollout>newBuilder()
                      .setDefaultInstance(GameServerDeploymentRollout.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateGameServerDeploymentRolloutRequest, Operation>
      updateGameServerDeploymentRolloutMethodDescriptor =
          ApiMethodDescriptor.<UpdateGameServerDeploymentRolloutRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerDeploymentsService/UpdateGameServerDeploymentRollout")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdateGameServerDeploymentRolloutRequest>newBuilder()
                      .setPath(
                          "/v1/{rollout.name=projects/*/locations/*/gameServerDeployments/*}/rollout",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGameServerDeploymentRolloutRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "rollout.name", request.getRollout().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGameServerDeploymentRolloutRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("rollout", request.getRollout(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateGameServerDeploymentRolloutRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          PreviewGameServerDeploymentRolloutRequest, PreviewGameServerDeploymentRolloutResponse>
      previewGameServerDeploymentRolloutMethodDescriptor =
          ApiMethodDescriptor
              .<PreviewGameServerDeploymentRolloutRequest,
                  PreviewGameServerDeploymentRolloutResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerDeploymentsService/PreviewGameServerDeploymentRollout")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PreviewGameServerDeploymentRolloutRequest>newBuilder()
                      .setPath(
                          "/v1/{rollout.name=projects/*/locations/*/gameServerDeployments/*}/rollout:preview",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PreviewGameServerDeploymentRolloutRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "rollout.name", request.getRollout().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PreviewGameServerDeploymentRolloutRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "previewTime", request.getPreviewTime());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("rollout", request.getRollout(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<PreviewGameServerDeploymentRolloutResponse>newBuilder()
                      .setDefaultInstance(
                          PreviewGameServerDeploymentRolloutResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FetchDeploymentStateRequest, FetchDeploymentStateResponse>
      fetchDeploymentStateMethodDescriptor =
          ApiMethodDescriptor
              .<FetchDeploymentStateRequest, FetchDeploymentStateResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerDeploymentsService/FetchDeploymentState")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchDeploymentStateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/gameServerDeployments/*}:fetchDeploymentState",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchDeploymentStateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchDeploymentStateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchDeploymentStateResponse>newBuilder()
                      .setDefaultInstance(FetchDeploymentStateResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListGameServerDeploymentsRequest, ListGameServerDeploymentsResponse>
      listGameServerDeploymentsCallable;
  private final UnaryCallable<
          ListGameServerDeploymentsRequest, ListGameServerDeploymentsPagedResponse>
      listGameServerDeploymentsPagedCallable;
  private final UnaryCallable<GetGameServerDeploymentRequest, GameServerDeployment>
      getGameServerDeploymentCallable;
  private final UnaryCallable<CreateGameServerDeploymentRequest, Operation>
      createGameServerDeploymentCallable;
  private final OperationCallable<
          CreateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
      createGameServerDeploymentOperationCallable;
  private final UnaryCallable<DeleteGameServerDeploymentRequest, Operation>
      deleteGameServerDeploymentCallable;
  private final OperationCallable<DeleteGameServerDeploymentRequest, Empty, OperationMetadata>
      deleteGameServerDeploymentOperationCallable;
  private final UnaryCallable<UpdateGameServerDeploymentRequest, Operation>
      updateGameServerDeploymentCallable;
  private final OperationCallable<
          UpdateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentOperationCallable;
  private final UnaryCallable<GetGameServerDeploymentRolloutRequest, GameServerDeploymentRollout>
      getGameServerDeploymentRolloutCallable;
  private final UnaryCallable<UpdateGameServerDeploymentRolloutRequest, Operation>
      updateGameServerDeploymentRolloutCallable;
  private final OperationCallable<
          UpdateGameServerDeploymentRolloutRequest, GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentRolloutOperationCallable;
  private final UnaryCallable<
          PreviewGameServerDeploymentRolloutRequest, PreviewGameServerDeploymentRolloutResponse>
      previewGameServerDeploymentRolloutCallable;
  private final UnaryCallable<FetchDeploymentStateRequest, FetchDeploymentStateResponse>
      fetchDeploymentStateCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGameServerDeploymentsServiceStub create(
      GameServerDeploymentsServiceStubSettings settings) throws IOException {
    return new HttpJsonGameServerDeploymentsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGameServerDeploymentsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGameServerDeploymentsServiceStub(
        GameServerDeploymentsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonGameServerDeploymentsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGameServerDeploymentsServiceStub(
        GameServerDeploymentsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGameServerDeploymentsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonGameServerDeploymentsServiceStub(
      GameServerDeploymentsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGameServerDeploymentsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGameServerDeploymentsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonGameServerDeploymentsServiceStub(
      GameServerDeploymentsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListGameServerDeploymentsRequest, ListGameServerDeploymentsResponse>
        listGameServerDeploymentsTransportSettings =
            HttpJsonCallSettings
                .<ListGameServerDeploymentsRequest, ListGameServerDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listGameServerDeploymentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetGameServerDeploymentRequest, GameServerDeployment>
        getGameServerDeploymentTransportSettings =
            HttpJsonCallSettings.<GetGameServerDeploymentRequest, GameServerDeployment>newBuilder()
                .setMethodDescriptor(getGameServerDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateGameServerDeploymentRequest, Operation>
        createGameServerDeploymentTransportSettings =
            HttpJsonCallSettings.<CreateGameServerDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(createGameServerDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteGameServerDeploymentRequest, Operation>
        deleteGameServerDeploymentTransportSettings =
            HttpJsonCallSettings.<DeleteGameServerDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGameServerDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateGameServerDeploymentRequest, Operation>
        updateGameServerDeploymentTransportSettings =
            HttpJsonCallSettings.<UpdateGameServerDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(updateGameServerDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetGameServerDeploymentRolloutRequest, GameServerDeploymentRollout>
        getGameServerDeploymentRolloutTransportSettings =
            HttpJsonCallSettings
                .<GetGameServerDeploymentRolloutRequest, GameServerDeploymentRollout>newBuilder()
                .setMethodDescriptor(getGameServerDeploymentRolloutMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateGameServerDeploymentRolloutRequest, Operation>
        updateGameServerDeploymentRolloutTransportSettings =
            HttpJsonCallSettings.<UpdateGameServerDeploymentRolloutRequest, Operation>newBuilder()
                .setMethodDescriptor(updateGameServerDeploymentRolloutMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            PreviewGameServerDeploymentRolloutRequest, PreviewGameServerDeploymentRolloutResponse>
        previewGameServerDeploymentRolloutTransportSettings =
            HttpJsonCallSettings
                .<PreviewGameServerDeploymentRolloutRequest,
                    PreviewGameServerDeploymentRolloutResponse>
                    newBuilder()
                .setMethodDescriptor(previewGameServerDeploymentRolloutMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<FetchDeploymentStateRequest, FetchDeploymentStateResponse>
        fetchDeploymentStateTransportSettings =
            HttpJsonCallSettings
                .<FetchDeploymentStateRequest, FetchDeploymentStateResponse>newBuilder()
                .setMethodDescriptor(fetchDeploymentStateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listGameServerDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listGameServerDeploymentsTransportSettings,
            settings.listGameServerDeploymentsSettings(),
            clientContext);
    this.listGameServerDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listGameServerDeploymentsTransportSettings,
            settings.listGameServerDeploymentsSettings(),
            clientContext);
    this.getGameServerDeploymentCallable =
        callableFactory.createUnaryCallable(
            getGameServerDeploymentTransportSettings,
            settings.getGameServerDeploymentSettings(),
            clientContext);
    this.createGameServerDeploymentCallable =
        callableFactory.createUnaryCallable(
            createGameServerDeploymentTransportSettings,
            settings.createGameServerDeploymentSettings(),
            clientContext);
    this.createGameServerDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            createGameServerDeploymentTransportSettings,
            settings.createGameServerDeploymentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteGameServerDeploymentCallable =
        callableFactory.createUnaryCallable(
            deleteGameServerDeploymentTransportSettings,
            settings.deleteGameServerDeploymentSettings(),
            clientContext);
    this.deleteGameServerDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            deleteGameServerDeploymentTransportSettings,
            settings.deleteGameServerDeploymentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateGameServerDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateGameServerDeploymentTransportSettings,
            settings.updateGameServerDeploymentSettings(),
            clientContext);
    this.updateGameServerDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            updateGameServerDeploymentTransportSettings,
            settings.updateGameServerDeploymentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getGameServerDeploymentRolloutCallable =
        callableFactory.createUnaryCallable(
            getGameServerDeploymentRolloutTransportSettings,
            settings.getGameServerDeploymentRolloutSettings(),
            clientContext);
    this.updateGameServerDeploymentRolloutCallable =
        callableFactory.createUnaryCallable(
            updateGameServerDeploymentRolloutTransportSettings,
            settings.updateGameServerDeploymentRolloutSettings(),
            clientContext);
    this.updateGameServerDeploymentRolloutOperationCallable =
        callableFactory.createOperationCallable(
            updateGameServerDeploymentRolloutTransportSettings,
            settings.updateGameServerDeploymentRolloutOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.previewGameServerDeploymentRolloutCallable =
        callableFactory.createUnaryCallable(
            previewGameServerDeploymentRolloutTransportSettings,
            settings.previewGameServerDeploymentRolloutSettings(),
            clientContext);
    this.fetchDeploymentStateCallable =
        callableFactory.createUnaryCallable(
            fetchDeploymentStateTransportSettings,
            settings.fetchDeploymentStateSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listGameServerDeploymentsMethodDescriptor);
    methodDescriptors.add(getGameServerDeploymentMethodDescriptor);
    methodDescriptors.add(createGameServerDeploymentMethodDescriptor);
    methodDescriptors.add(deleteGameServerDeploymentMethodDescriptor);
    methodDescriptors.add(updateGameServerDeploymentMethodDescriptor);
    methodDescriptors.add(getGameServerDeploymentRolloutMethodDescriptor);
    methodDescriptors.add(updateGameServerDeploymentRolloutMethodDescriptor);
    methodDescriptors.add(previewGameServerDeploymentRolloutMethodDescriptor);
    methodDescriptors.add(fetchDeploymentStateMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListGameServerDeploymentsRequest, ListGameServerDeploymentsResponse>
      listGameServerDeploymentsCallable() {
    return listGameServerDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListGameServerDeploymentsRequest, ListGameServerDeploymentsPagedResponse>
      listGameServerDeploymentsPagedCallable() {
    return listGameServerDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetGameServerDeploymentRequest, GameServerDeployment>
      getGameServerDeploymentCallable() {
    return getGameServerDeploymentCallable;
  }

  @Override
  public UnaryCallable<CreateGameServerDeploymentRequest, Operation>
      createGameServerDeploymentCallable() {
    return createGameServerDeploymentCallable;
  }

  @Override
  public OperationCallable<
          CreateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
      createGameServerDeploymentOperationCallable() {
    return createGameServerDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGameServerDeploymentRequest, Operation>
      deleteGameServerDeploymentCallable() {
    return deleteGameServerDeploymentCallable;
  }

  @Override
  public OperationCallable<DeleteGameServerDeploymentRequest, Empty, OperationMetadata>
      deleteGameServerDeploymentOperationCallable() {
    return deleteGameServerDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateGameServerDeploymentRequest, Operation>
      updateGameServerDeploymentCallable() {
    return updateGameServerDeploymentCallable;
  }

  @Override
  public OperationCallable<
          UpdateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentOperationCallable() {
    return updateGameServerDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<GetGameServerDeploymentRolloutRequest, GameServerDeploymentRollout>
      getGameServerDeploymentRolloutCallable() {
    return getGameServerDeploymentRolloutCallable;
  }

  @Override
  public UnaryCallable<UpdateGameServerDeploymentRolloutRequest, Operation>
      updateGameServerDeploymentRolloutCallable() {
    return updateGameServerDeploymentRolloutCallable;
  }

  @Override
  public OperationCallable<
          UpdateGameServerDeploymentRolloutRequest, GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentRolloutOperationCallable() {
    return updateGameServerDeploymentRolloutOperationCallable;
  }

  @Override
  public UnaryCallable<
          PreviewGameServerDeploymentRolloutRequest, PreviewGameServerDeploymentRolloutResponse>
      previewGameServerDeploymentRolloutCallable() {
    return previewGameServerDeploymentRolloutCallable;
  }

  @Override
  public UnaryCallable<FetchDeploymentStateRequest, FetchDeploymentStateResponse>
      fetchDeploymentStateCallable() {
    return fetchDeploymentStateCallable;
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
