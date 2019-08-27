/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.gaming.v1alpha.stub;

import static com.google.cloud.gaming.v1alpha.GameServerClustersServiceClient.ListGameServerClustersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gaming.v1alpha.CreateGameServerClusterRequest;
import com.google.cloud.gaming.v1alpha.DeleteGameServerClusterRequest;
import com.google.cloud.gaming.v1alpha.GameServerCluster;
import com.google.cloud.gaming.v1alpha.GetGameServerClusterRequest;
import com.google.cloud.gaming.v1alpha.ListGameServerClustersRequest;
import com.google.cloud.gaming.v1alpha.ListGameServerClustersResponse;
import com.google.cloud.gaming.v1alpha.UpdateGameServerClusterRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for gameservices API (prod).
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcGameServerClustersServiceStub extends GameServerClustersServiceStub {

  private static final MethodDescriptor<
          ListGameServerClustersRequest, ListGameServerClustersResponse>
      listGameServerClustersMethodDescriptor =
          MethodDescriptor
              .<ListGameServerClustersRequest, ListGameServerClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1alpha.GameServerClustersService/ListGameServerClusters")
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
                  "google.cloud.gaming.v1alpha.GameServerClustersService/GetGameServerCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GameServerCluster.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateGameServerClusterRequest, Operation>
      createGameServerClusterMethodDescriptor =
          MethodDescriptor.<CreateGameServerClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1alpha.GameServerClustersService/CreateGameServerCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteGameServerClusterRequest, Operation>
      deleteGameServerClusterMethodDescriptor =
          MethodDescriptor.<DeleteGameServerClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1alpha.GameServerClustersService/DeleteGameServerCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateGameServerClusterRequest, Operation>
      updateGameServerClusterMethodDescriptor =
          MethodDescriptor.<UpdateGameServerClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gaming.v1alpha.GameServerClustersService/UpdateGameServerCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;

  private final UnaryCallable<ListGameServerClustersRequest, ListGameServerClustersResponse>
      listGameServerClustersCallable;
  private final UnaryCallable<ListGameServerClustersRequest, ListGameServerClustersPagedResponse>
      listGameServerClustersPagedCallable;
  private final UnaryCallable<GetGameServerClusterRequest, GameServerCluster>
      getGameServerClusterCallable;
  private final UnaryCallable<CreateGameServerClusterRequest, Operation>
      createGameServerClusterCallable;
  private final OperationCallable<CreateGameServerClusterRequest, GameServerCluster, Empty>
      createGameServerClusterOperationCallable;
  private final UnaryCallable<DeleteGameServerClusterRequest, Operation>
      deleteGameServerClusterCallable;
  private final OperationCallable<DeleteGameServerClusterRequest, Empty, Empty>
      deleteGameServerClusterOperationCallable;
  private final UnaryCallable<UpdateGameServerClusterRequest, Operation>
      updateGameServerClusterCallable;
  private final OperationCallable<UpdateGameServerClusterRequest, GameServerCluster, Empty>
      updateGameServerClusterOperationCallable;

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
            this.operationsStub);
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
            this.operationsStub);
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
            this.operationsStub);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<ListGameServerClustersRequest, ListGameServerClustersPagedResponse>
      listGameServerClustersPagedCallable() {
    return listGameServerClustersPagedCallable;
  }

  public UnaryCallable<ListGameServerClustersRequest, ListGameServerClustersResponse>
      listGameServerClustersCallable() {
    return listGameServerClustersCallable;
  }

  public UnaryCallable<GetGameServerClusterRequest, GameServerCluster>
      getGameServerClusterCallable() {
    return getGameServerClusterCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<CreateGameServerClusterRequest, GameServerCluster, Empty>
      createGameServerClusterOperationCallable() {
    return createGameServerClusterOperationCallable;
  }

  public UnaryCallable<CreateGameServerClusterRequest, Operation>
      createGameServerClusterCallable() {
    return createGameServerClusterCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<DeleteGameServerClusterRequest, Empty, Empty>
      deleteGameServerClusterOperationCallable() {
    return deleteGameServerClusterOperationCallable;
  }

  public UnaryCallable<DeleteGameServerClusterRequest, Operation>
      deleteGameServerClusterCallable() {
    return deleteGameServerClusterCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<UpdateGameServerClusterRequest, GameServerCluster, Empty>
      updateGameServerClusterOperationCallable() {
    return updateGameServerClusterOperationCallable;
  }

  public UnaryCallable<UpdateGameServerClusterRequest, Operation>
      updateGameServerClusterCallable() {
    return updateGameServerClusterCallable;
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
