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
package com.google.cloud.gaming.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The game server config configures the game servers in an Agones fleet.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/gaming/v1/game_server_configs_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GameServerConfigsServiceGrpc {

  private GameServerConfigsServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.gaming.v1.GameServerConfigsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1.ListGameServerConfigsRequest,
          com.google.cloud.gaming.v1.ListGameServerConfigsResponse>
      getListGameServerConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGameServerConfigs",
      requestType = com.google.cloud.gaming.v1.ListGameServerConfigsRequest.class,
      responseType = com.google.cloud.gaming.v1.ListGameServerConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1.ListGameServerConfigsRequest,
          com.google.cloud.gaming.v1.ListGameServerConfigsResponse>
      getListGameServerConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1.ListGameServerConfigsRequest,
            com.google.cloud.gaming.v1.ListGameServerConfigsResponse>
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
                      .<com.google.cloud.gaming.v1.ListGameServerConfigsRequest,
                          com.google.cloud.gaming.v1.ListGameServerConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListGameServerConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1.ListGameServerConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1.ListGameServerConfigsResponse
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1.GetGameServerConfigRequest,
          com.google.cloud.gaming.v1.GameServerConfig>
      getGetGameServerConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGameServerConfig",
      requestType = com.google.cloud.gaming.v1.GetGameServerConfigRequest.class,
      responseType = com.google.cloud.gaming.v1.GameServerConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1.GetGameServerConfigRequest,
          com.google.cloud.gaming.v1.GameServerConfig>
      getGetGameServerConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1.GetGameServerConfigRequest,
            com.google.cloud.gaming.v1.GameServerConfig>
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
                      .<com.google.cloud.gaming.v1.GetGameServerConfigRequest,
                          com.google.cloud.gaming.v1.GameServerConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetGameServerConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1.GetGameServerConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1.GameServerConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerConfigsServiceMethodDescriptorSupplier(
                              "GetGameServerConfig"))
                      .build();
        }
      }
    }
    return getGetGameServerConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1.CreateGameServerConfigRequest,
          com.google.longrunning.Operation>
      getCreateGameServerConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGameServerConfig",
      requestType = com.google.cloud.gaming.v1.CreateGameServerConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1.CreateGameServerConfigRequest,
          com.google.longrunning.Operation>
      getCreateGameServerConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1.CreateGameServerConfigRequest,
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
                      .<com.google.cloud.gaming.v1.CreateGameServerConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateGameServerConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1.CreateGameServerConfigRequest
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1.DeleteGameServerConfigRequest,
          com.google.longrunning.Operation>
      getDeleteGameServerConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGameServerConfig",
      requestType = com.google.cloud.gaming.v1.DeleteGameServerConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1.DeleteGameServerConfigRequest,
          com.google.longrunning.Operation>
      getDeleteGameServerConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1.DeleteGameServerConfigRequest,
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
                      .<com.google.cloud.gaming.v1.DeleteGameServerConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteGameServerConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1.DeleteGameServerConfigRequest
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
    io.grpc.stub.AbstractStub.StubFactory<GameServerConfigsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GameServerConfigsServiceStub>() {
          @java.lang.Override
          public GameServerConfigsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GameServerConfigsServiceStub(channel, callOptions);
          }
        };
    return GameServerConfigsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GameServerConfigsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameServerConfigsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GameServerConfigsServiceBlockingStub>() {
          @java.lang.Override
          public GameServerConfigsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GameServerConfigsServiceBlockingStub(channel, callOptions);
          }
        };
    return GameServerConfigsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GameServerConfigsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameServerConfigsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GameServerConfigsServiceFutureStub>() {
          @java.lang.Override
          public GameServerConfigsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GameServerConfigsServiceFutureStub(channel, callOptions);
          }
        };
    return GameServerConfigsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The game server config configures the game servers in an Agones fleet.
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
        com.google.cloud.gaming.v1.ListGameServerConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.ListGameServerConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGameServerConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single game server config.
     * </pre>
     */
    public void getGameServerConfig(
        com.google.cloud.gaming.v1.GetGameServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.GameServerConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGameServerConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new game server config in a given project, location, and game
     * server deployment. Game server configs are immutable, and are not applied
     * until referenced in the game server deployment rollout resource.
     * </pre>
     */
    public void createGameServerConfig(
        com.google.cloud.gaming.v1.CreateGameServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGameServerConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single game server config. The deletion will fail if the game
     * server config is referenced in a game server deployment rollout.
     * </pre>
     */
    public void deleteGameServerConfig(
        com.google.cloud.gaming.v1.DeleteGameServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGameServerConfigMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListGameServerConfigsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1.ListGameServerConfigsRequest,
                      com.google.cloud.gaming.v1.ListGameServerConfigsResponse>(
                      this, METHODID_LIST_GAME_SERVER_CONFIGS)))
          .addMethod(
              getGetGameServerConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1.GetGameServerConfigRequest,
                      com.google.cloud.gaming.v1.GameServerConfig>(
                      this, METHODID_GET_GAME_SERVER_CONFIG)))
          .addMethod(
              getCreateGameServerConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1.CreateGameServerConfigRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_GAME_SERVER_CONFIG)))
          .addMethod(
              getDeleteGameServerConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1.DeleteGameServerConfigRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_GAME_SERVER_CONFIG)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The game server config configures the game servers in an Agones fleet.
   * </pre>
   */
  public static final class GameServerConfigsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GameServerConfigsServiceStub> {
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
        com.google.cloud.gaming.v1.ListGameServerConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.ListGameServerConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGameServerConfigsMethod(), getCallOptions()),
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
        com.google.cloud.gaming.v1.GetGameServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.GameServerConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGameServerConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new game server config in a given project, location, and game
     * server deployment. Game server configs are immutable, and are not applied
     * until referenced in the game server deployment rollout resource.
     * </pre>
     */
    public void createGameServerConfig(
        com.google.cloud.gaming.v1.CreateGameServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGameServerConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single game server config. The deletion will fail if the game
     * server config is referenced in a game server deployment rollout.
     * </pre>
     */
    public void deleteGameServerConfig(
        com.google.cloud.gaming.v1.DeleteGameServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGameServerConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The game server config configures the game servers in an Agones fleet.
   * </pre>
   */
  public static final class GameServerConfigsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GameServerConfigsServiceBlockingStub> {
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
    public com.google.cloud.gaming.v1.ListGameServerConfigsResponse listGameServerConfigs(
        com.google.cloud.gaming.v1.ListGameServerConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGameServerConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single game server config.
     * </pre>
     */
    public com.google.cloud.gaming.v1.GameServerConfig getGameServerConfig(
        com.google.cloud.gaming.v1.GetGameServerConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGameServerConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new game server config in a given project, location, and game
     * server deployment. Game server configs are immutable, and are not applied
     * until referenced in the game server deployment rollout resource.
     * </pre>
     */
    public com.google.longrunning.Operation createGameServerConfig(
        com.google.cloud.gaming.v1.CreateGameServerConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGameServerConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single game server config. The deletion will fail if the game
     * server config is referenced in a game server deployment rollout.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGameServerConfig(
        com.google.cloud.gaming.v1.DeleteGameServerConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGameServerConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The game server config configures the game servers in an Agones fleet.
   * </pre>
   */
  public static final class GameServerConfigsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GameServerConfigsServiceFutureStub> {
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
            com.google.cloud.gaming.v1.ListGameServerConfigsResponse>
        listGameServerConfigs(com.google.cloud.gaming.v1.ListGameServerConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGameServerConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single game server config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1.GameServerConfig>
        getGameServerConfig(com.google.cloud.gaming.v1.GetGameServerConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGameServerConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new game server config in a given project, location, and game
     * server deployment. Game server configs are immutable, and are not applied
     * until referenced in the game server deployment rollout resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createGameServerConfig(com.google.cloud.gaming.v1.CreateGameServerConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGameServerConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single game server config. The deletion will fail if the game
     * server config is referenced in a game server deployment rollout.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteGameServerConfig(com.google.cloud.gaming.v1.DeleteGameServerConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGameServerConfigMethod(), getCallOptions()), request);
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
              (com.google.cloud.gaming.v1.ListGameServerConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gaming.v1.ListGameServerConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GAME_SERVER_CONFIG:
          serviceImpl.getGameServerConfig(
              (com.google.cloud.gaming.v1.GetGameServerConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.GameServerConfig>)
                  responseObserver);
          break;
        case METHODID_CREATE_GAME_SERVER_CONFIG:
          serviceImpl.createGameServerConfig(
              (com.google.cloud.gaming.v1.CreateGameServerConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_GAME_SERVER_CONFIG:
          serviceImpl.deleteGameServerConfig(
              (com.google.cloud.gaming.v1.DeleteGameServerConfigRequest) request,
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
      return com.google.cloud.gaming.v1.GameServerConfigsServiceOuterClass.getDescriptor();
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
                      .addMethod(getListGameServerConfigsMethod())
                      .addMethod(getGetGameServerConfigMethod())
                      .addMethod(getCreateGameServerConfigMethod())
                      .addMethod(getDeleteGameServerConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
