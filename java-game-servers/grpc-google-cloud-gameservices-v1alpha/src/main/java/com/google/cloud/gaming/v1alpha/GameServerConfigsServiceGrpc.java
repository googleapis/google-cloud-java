/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.gaming.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * The game server config is used to configure the set of game
 * servers in Agones Fleets.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/gaming/v1alpha/game_server_configs_service.proto")
public final class GameServerConfigsServiceGrpc {

  private GameServerConfigsServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.gaming.v1alpha.GameServerConfigsService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListGameServerConfigsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListGameServerConfigsRequest,
          com.google.cloud.gaming.v1alpha.ListGameServerConfigsResponse>
      METHOD_LIST_GAME_SERVER_CONFIGS = getListGameServerConfigsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListGameServerConfigsRequest,
          com.google.cloud.gaming.v1alpha.ListGameServerConfigsResponse>
      getListGameServerConfigsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListGameServerConfigsRequest,
          com.google.cloud.gaming.v1alpha.ListGameServerConfigsResponse>
      getListGameServerConfigsMethod() {
    return getListGameServerConfigsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListGameServerConfigsRequest,
          com.google.cloud.gaming.v1alpha.ListGameServerConfigsResponse>
      getListGameServerConfigsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.ListGameServerConfigsRequest,
            com.google.cloud.gaming.v1alpha.ListGameServerConfigsResponse>
        getListGameServerConfigsMethod;
    if ((getListGameServerConfigsMethod =
            GameServerConfigsServiceGrpc.getListGameServerConfigsMethod)
        == null) {
      synchronized (GameServerConfigsServiceGrpc.class) {
        if ((getListGameServerConfigsMethod =
                GameServerConfigsServiceGrpc.getListGameServerConfigsMethod)
            == null) {
          GameServerConfigsServiceGrpc.getListGameServerConfigsMethod =
              getListGameServerConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.ListGameServerConfigsRequest,
                          com.google.cloud.gaming.v1alpha.ListGameServerConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerConfigsService",
                              "ListGameServerConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.ListGameServerConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.ListGameServerConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerConfigsServiceMethodDescriptorSupplier(
                              "ListGameServerConfigs"))
                      .build();
        }
      }
    }
    return getListGameServerConfigsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetGameServerConfigMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetGameServerConfigRequest,
          com.google.cloud.gaming.v1alpha.GameServerConfig>
      METHOD_GET_GAME_SERVER_CONFIG = getGetGameServerConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetGameServerConfigRequest,
          com.google.cloud.gaming.v1alpha.GameServerConfig>
      getGetGameServerConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetGameServerConfigRequest,
          com.google.cloud.gaming.v1alpha.GameServerConfig>
      getGetGameServerConfigMethod() {
    return getGetGameServerConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetGameServerConfigRequest,
          com.google.cloud.gaming.v1alpha.GameServerConfig>
      getGetGameServerConfigMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.GetGameServerConfigRequest,
            com.google.cloud.gaming.v1alpha.GameServerConfig>
        getGetGameServerConfigMethod;
    if ((getGetGameServerConfigMethod = GameServerConfigsServiceGrpc.getGetGameServerConfigMethod)
        == null) {
      synchronized (GameServerConfigsServiceGrpc.class) {
        if ((getGetGameServerConfigMethod =
                GameServerConfigsServiceGrpc.getGetGameServerConfigMethod)
            == null) {
          GameServerConfigsServiceGrpc.getGetGameServerConfigMethod =
              getGetGameServerConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.GetGameServerConfigRequest,
                          com.google.cloud.gaming.v1alpha.GameServerConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerConfigsService",
                              "GetGameServerConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.GetGameServerConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.GameServerConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerConfigsServiceMethodDescriptorSupplier(
                              "GetGameServerConfig"))
                      .build();
        }
      }
    }
    return getGetGameServerConfigMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateGameServerConfigMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateGameServerConfigRequest,
          com.google.longrunning.Operation>
      METHOD_CREATE_GAME_SERVER_CONFIG = getCreateGameServerConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateGameServerConfigRequest,
          com.google.longrunning.Operation>
      getCreateGameServerConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateGameServerConfigRequest,
          com.google.longrunning.Operation>
      getCreateGameServerConfigMethod() {
    return getCreateGameServerConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateGameServerConfigRequest,
          com.google.longrunning.Operation>
      getCreateGameServerConfigMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.CreateGameServerConfigRequest,
            com.google.longrunning.Operation>
        getCreateGameServerConfigMethod;
    if ((getCreateGameServerConfigMethod =
            GameServerConfigsServiceGrpc.getCreateGameServerConfigMethod)
        == null) {
      synchronized (GameServerConfigsServiceGrpc.class) {
        if ((getCreateGameServerConfigMethod =
                GameServerConfigsServiceGrpc.getCreateGameServerConfigMethod)
            == null) {
          GameServerConfigsServiceGrpc.getCreateGameServerConfigMethod =
              getCreateGameServerConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.CreateGameServerConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerConfigsService",
                              "CreateGameServerConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.CreateGameServerConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerConfigsServiceMethodDescriptorSupplier(
                              "CreateGameServerConfig"))
                      .build();
        }
      }
    }
    return getCreateGameServerConfigMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteGameServerConfigMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteGameServerConfigRequest,
          com.google.longrunning.Operation>
      METHOD_DELETE_GAME_SERVER_CONFIG = getDeleteGameServerConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteGameServerConfigRequest,
          com.google.longrunning.Operation>
      getDeleteGameServerConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteGameServerConfigRequest,
          com.google.longrunning.Operation>
      getDeleteGameServerConfigMethod() {
    return getDeleteGameServerConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteGameServerConfigRequest,
          com.google.longrunning.Operation>
      getDeleteGameServerConfigMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.DeleteGameServerConfigRequest,
            com.google.longrunning.Operation>
        getDeleteGameServerConfigMethod;
    if ((getDeleteGameServerConfigMethod =
            GameServerConfigsServiceGrpc.getDeleteGameServerConfigMethod)
        == null) {
      synchronized (GameServerConfigsServiceGrpc.class) {
        if ((getDeleteGameServerConfigMethod =
                GameServerConfigsServiceGrpc.getDeleteGameServerConfigMethod)
            == null) {
          GameServerConfigsServiceGrpc.getDeleteGameServerConfigMethod =
              getDeleteGameServerConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.DeleteGameServerConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerConfigsService",
                              "DeleteGameServerConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.DeleteGameServerConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerConfigsServiceMethodDescriptorSupplier(
                              "DeleteGameServerConfig"))
                      .build();
        }
      }
    }
    return getDeleteGameServerConfigMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GameServerConfigsServiceStub newStub(io.grpc.Channel channel) {
    return new GameServerConfigsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GameServerConfigsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new GameServerConfigsServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GameServerConfigsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new GameServerConfigsServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * The game server config is used to configure the set of game
   * servers in Agones Fleets.
   * </pre>
   */
  public abstract static class GameServerConfigsServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists game server configs in a given project, location, and game server
     * deployment.
     * </pre>
     */
    public void listGameServerConfigs(
        com.google.cloud.gaming.v1alpha.ListGameServerConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.ListGameServerConfigsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListGameServerConfigsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single game server config.
     * </pre>
     */
    public void getGameServerConfig(
        com.google.cloud.gaming.v1alpha.GetGameServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.GameServerConfig>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetGameServerConfigMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new game server config in a given project, location, and game
     * server deployment. Game server configs are immutable. A game server config
     * is not applied until it is rolled out which is managed
     * by updating the game server rollout resource.
     * </pre>
     */
    public void createGameServerConfig(
        com.google.cloud.gaming.v1alpha.CreateGameServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateGameServerConfigMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single game server config. The deletion will fail if the game
     * server config is referenced in a game server rollout.
     * </pre>
     */
    public void deleteGameServerConfig(
        com.google.cloud.gaming.v1alpha.DeleteGameServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGameServerConfigMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListGameServerConfigsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.ListGameServerConfigsRequest,
                      com.google.cloud.gaming.v1alpha.ListGameServerConfigsResponse>(
                      this, METHODID_LIST_GAME_SERVER_CONFIGS)))
          .addMethod(
              getGetGameServerConfigMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.GetGameServerConfigRequest,
                      com.google.cloud.gaming.v1alpha.GameServerConfig>(
                      this, METHODID_GET_GAME_SERVER_CONFIG)))
          .addMethod(
              getCreateGameServerConfigMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.CreateGameServerConfigRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_GAME_SERVER_CONFIG)))
          .addMethod(
              getDeleteGameServerConfigMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.DeleteGameServerConfigRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_GAME_SERVER_CONFIG)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The game server config is used to configure the set of game
   * servers in Agones Fleets.
   * </pre>
   */
  public static final class GameServerConfigsServiceStub
      extends io.grpc.stub.AbstractStub<GameServerConfigsServiceStub> {
    private GameServerConfigsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GameServerConfigsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServerConfigsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameServerConfigsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists game server configs in a given project, location, and game server
     * deployment.
     * </pre>
     */
    public void listGameServerConfigs(
        com.google.cloud.gaming.v1alpha.ListGameServerConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.ListGameServerConfigsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListGameServerConfigsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single game server config.
     * </pre>
     */
    public void getGameServerConfig(
        com.google.cloud.gaming.v1alpha.GetGameServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.GameServerConfig>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetGameServerConfigMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new game server config in a given project, location, and game
     * server deployment. Game server configs are immutable. A game server config
     * is not applied until it is rolled out which is managed
     * by updating the game server rollout resource.
     * </pre>
     */
    public void createGameServerConfig(
        com.google.cloud.gaming.v1alpha.CreateGameServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateGameServerConfigMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single game server config. The deletion will fail if the game
     * server config is referenced in a game server rollout.
     * </pre>
     */
    public void deleteGameServerConfig(
        com.google.cloud.gaming.v1alpha.DeleteGameServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGameServerConfigMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The game server config is used to configure the set of game
   * servers in Agones Fleets.
   * </pre>
   */
  public static final class GameServerConfigsServiceBlockingStub
      extends io.grpc.stub.AbstractStub<GameServerConfigsServiceBlockingStub> {
    private GameServerConfigsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GameServerConfigsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServerConfigsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameServerConfigsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists game server configs in a given project, location, and game server
     * deployment.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.ListGameServerConfigsResponse listGameServerConfigs(
        com.google.cloud.gaming.v1alpha.ListGameServerConfigsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListGameServerConfigsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single game server config.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.GameServerConfig getGameServerConfig(
        com.google.cloud.gaming.v1alpha.GetGameServerConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetGameServerConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new game server config in a given project, location, and game
     * server deployment. Game server configs are immutable. A game server config
     * is not applied until it is rolled out which is managed
     * by updating the game server rollout resource.
     * </pre>
     */
    public com.google.longrunning.Operation createGameServerConfig(
        com.google.cloud.gaming.v1alpha.CreateGameServerConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateGameServerConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single game server config. The deletion will fail if the game
     * server config is referenced in a game server rollout.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGameServerConfig(
        com.google.cloud.gaming.v1alpha.DeleteGameServerConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGameServerConfigMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The game server config is used to configure the set of game
   * servers in Agones Fleets.
   * </pre>
   */
  public static final class GameServerConfigsServiceFutureStub
      extends io.grpc.stub.AbstractStub<GameServerConfigsServiceFutureStub> {
    private GameServerConfigsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GameServerConfigsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServerConfigsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameServerConfigsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists game server configs in a given project, location, and game server
     * deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.ListGameServerConfigsResponse>
        listGameServerConfigs(
            com.google.cloud.gaming.v1alpha.ListGameServerConfigsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListGameServerConfigsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single game server config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.GameServerConfig>
        getGameServerConfig(com.google.cloud.gaming.v1alpha.GetGameServerConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetGameServerConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new game server config in a given project, location, and game
     * server deployment. Game server configs are immutable. A game server config
     * is not applied until it is rolled out which is managed
     * by updating the game server rollout resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createGameServerConfig(
            com.google.cloud.gaming.v1alpha.CreateGameServerConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateGameServerConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single game server config. The deletion will fail if the game
     * server config is referenced in a game server rollout.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteGameServerConfig(
            com.google.cloud.gaming.v1alpha.DeleteGameServerConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGameServerConfigMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_GAME_SERVER_CONFIGS = 0;
  private static final int METHODID_GET_GAME_SERVER_CONFIG = 1;
  private static final int METHODID_CREATE_GAME_SERVER_CONFIG = 2;
  private static final int METHODID_DELETE_GAME_SERVER_CONFIG = 3;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GameServerConfigsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GameServerConfigsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_GAME_SERVER_CONFIGS:
          serviceImpl.listGameServerConfigs(
              (com.google.cloud.gaming.v1alpha.ListGameServerConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gaming.v1alpha.ListGameServerConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GAME_SERVER_CONFIG:
          serviceImpl.getGameServerConfig(
              (com.google.cloud.gaming.v1alpha.GetGameServerConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.GameServerConfig>)
                  responseObserver);
          break;
        case METHODID_CREATE_GAME_SERVER_CONFIG:
          serviceImpl.createGameServerConfig(
              (com.google.cloud.gaming.v1alpha.CreateGameServerConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_GAME_SERVER_CONFIG:
          serviceImpl.deleteGameServerConfig(
              (com.google.cloud.gaming.v1alpha.DeleteGameServerConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private abstract static class GameServerConfigsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GameServerConfigsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gaming.v1alpha.GameServerConfigsServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GameServerConfigsService");
    }
  }

  private static final class GameServerConfigsServiceFileDescriptorSupplier
      extends GameServerConfigsServiceBaseDescriptorSupplier {
    GameServerConfigsServiceFileDescriptorSupplier() {}
  }

  private static final class GameServerConfigsServiceMethodDescriptorSupplier
      extends GameServerConfigsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GameServerConfigsServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GameServerConfigsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GameServerConfigsServiceFileDescriptorSupplier())
                      .addMethod(getListGameServerConfigsMethodHelper())
                      .addMethod(getGetGameServerConfigMethodHelper())
                      .addMethod(getCreateGameServerConfigMethodHelper())
                      .addMethod(getDeleteGameServerConfigMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
