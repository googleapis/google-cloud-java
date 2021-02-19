/*
 * Copyright 2020 Google LLC
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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
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
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the GameServerClustersService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcGameServerClustersServiceStub extends GameServerClustersServiceStub {
  private static final MethodDescriptor<
          ListGameServerClustersRequest, ListGameServerClustersResponse>
      listGameServerClustersMethodDescriptor =
          MethodDescriptor
              .<ListGameServerClustersRequest, ListGameServerClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerClustersService/ListGameServerClusters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGameServerClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGameServerClustersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGameServerClusterRequest, GameServerCluster>
      getGameServerClusterMethodDescriptor =
          MethodDescriptor.<GetGameServerClusterRequest, GameServerCluster>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerClustersService/GetGameServerCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GameServerCluster.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateGameServerClusterRequest, Operation>
      createGameServerClusterMethodDescriptor =
          MethodDescriptor.<CreateGameServerClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerClustersService/CreateGameServerCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          PreviewCreateGameServerClusterRequest, PreviewCreateGameServerClusterResponse>
      previewCreateGameServerClusterMethodDescriptor =
          MethodDescriptor
              .<PreviewCreateGameServerClusterRequest, PreviewCreateGameServerClusterResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerClustersService/PreviewCreateGameServerCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PreviewCreateGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      PreviewCreateGameServerClusterResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteGameServerClusterRequest, Operation>
      deleteGameServerClusterMethodDescriptor =
          MethodDescriptor.<DeleteGameServerClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerClustersService/DeleteGameServerCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          PreviewDeleteGameServerClusterRequest, PreviewDeleteGameServerClusterResponse>
      previewDeleteGameServerClusterMethodDescriptor =
          MethodDescriptor
              .<PreviewDeleteGameServerClusterRequest, PreviewDeleteGameServerClusterResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerClustersService/PreviewDeleteGameServerCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PreviewDeleteGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      PreviewDeleteGameServerClusterResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateGameServerClusterRequest, Operation>
      updateGameServerClusterMethodDescriptor =
          MethodDescriptor.<UpdateGameServerClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerClustersService/UpdateGameServerCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          PreviewUpdateGameServerClusterRequest, PreviewUpdateGameServerClusterResponse>
      previewUpdateGameServerClusterMethodDescriptor =
          MethodDescriptor
              .<PreviewUpdateGameServerClusterRequest, PreviewUpdateGameServerClusterResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1.GameServerClustersService/PreviewUpdateGameServerCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PreviewUpdateGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      PreviewUpdateGameServerClusterResponse.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcGameServerClustersServiceStub create(
      GameServerClustersServiceStubSettings settings) throws IOException {
    return new GrpcGameServerClustersServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcGameServerClustersServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcGameServerClustersServiceStub(
        GameServerClustersServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcGameServerClustersServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcGameServerClustersServiceStub(
        GameServerClustersServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcGameServerClustersServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcGameServerClustersServiceStub(
      GameServerClustersServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcGameServerClustersServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcGameServerClustersServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcGameServerClustersServiceStub(
      GameServerClustersServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListGameServerClustersRequest, ListGameServerClustersResponse>
        listGameServerClustersTransportSettings =
            GrpcCallSettings
                .<ListGameServerClustersRequest, ListGameServerClustersResponse>newBuilder()
                .setMethodDescriptor(listGameServerClustersMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListGameServerClustersRequest>() {
                      @Override
                      public Map<String, String> extract(ListGameServerClustersRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetGameServerClusterRequest, GameServerCluster>
        getGameServerClusterTransportSettings =
            GrpcCallSettings.<GetGameServerClusterRequest, GameServerCluster>newBuilder()
                .setMethodDescriptor(getGameServerClusterMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetGameServerClusterRequest>() {
                      @Override
                      public Map<String, String> extract(GetGameServerClusterRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateGameServerClusterRequest, Operation>
        createGameServerClusterTransportSettings =
            GrpcCallSettings.<CreateGameServerClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(createGameServerClusterMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateGameServerClusterRequest>() {
                      @Override
                      public Map<String, String> extract(CreateGameServerClusterRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<PreviewCreateGameServerClusterRequest, PreviewCreateGameServerClusterResponse>
        previewCreateGameServerClusterTransportSettings =
            GrpcCallSettings
                .<PreviewCreateGameServerClusterRequest, PreviewCreateGameServerClusterResponse>
                    newBuilder()
                .setMethodDescriptor(previewCreateGameServerClusterMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<PreviewCreateGameServerClusterRequest>() {
                      @Override
                      public Map<String, String> extract(
                          PreviewCreateGameServerClusterRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteGameServerClusterRequest, Operation>
        deleteGameServerClusterTransportSettings =
            GrpcCallSettings.<DeleteGameServerClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGameServerClusterMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<DeleteGameServerClusterRequest>() {
                      @Override
                      public Map<String, String> extract(DeleteGameServerClusterRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<PreviewDeleteGameServerClusterRequest, PreviewDeleteGameServerClusterResponse>
        previewDeleteGameServerClusterTransportSettings =
            GrpcCallSettings
                .<PreviewDeleteGameServerClusterRequest, PreviewDeleteGameServerClusterResponse>
                    newBuilder()
                .setMethodDescriptor(previewDeleteGameServerClusterMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<PreviewDeleteGameServerClusterRequest>() {
                      @Override
                      public Map<String, String> extract(
                          PreviewDeleteGameServerClusterRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateGameServerClusterRequest, Operation>
        updateGameServerClusterTransportSettings =
            GrpcCallSettings.<UpdateGameServerClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(updateGameServerClusterMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<UpdateGameServerClusterRequest>() {
                      @Override
                      public Map<String, String> extract(UpdateGameServerClusterRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put(
                            "game_server_cluster.name",
                            String.valueOf(request.getGameServerCluster().getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<PreviewUpdateGameServerClusterRequest, PreviewUpdateGameServerClusterResponse>
        previewUpdateGameServerClusterTransportSettings =
            GrpcCallSettings
                .<PreviewUpdateGameServerClusterRequest, PreviewUpdateGameServerClusterResponse>
                    newBuilder()
                .setMethodDescriptor(previewUpdateGameServerClusterMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<PreviewUpdateGameServerClusterRequest>() {
                      @Override
                      public Map<String, String> extract(
                          PreviewUpdateGameServerClusterRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put(
                            "game_server_cluster.name",
                            String.valueOf(request.getGameServerCluster().getName()));
                        return params.build();
                      }
                    })
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
    this.previewUpdateGameServerClusterCallable =
        callableFactory.createUnaryCallable(
            previewUpdateGameServerClusterTransportSettings,
            settings.previewUpdateGameServerClusterSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
    shutdown();
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
