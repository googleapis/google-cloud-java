package com.google.cloud.gaming.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The game server cluster maps to Kubernetes clusters running Agones and is
 * used to manage fleets within clusters.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/gaming/v1/game_server_clusters_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GameServerClustersServiceGrpc {

  private GameServerClustersServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.gaming.v1.GameServerClustersService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.ListGameServerClustersRequest,
      com.google.cloud.gaming.v1.ListGameServerClustersResponse> getListGameServerClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGameServerClusters",
      requestType = com.google.cloud.gaming.v1.ListGameServerClustersRequest.class,
      responseType = com.google.cloud.gaming.v1.ListGameServerClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.ListGameServerClustersRequest,
      com.google.cloud.gaming.v1.ListGameServerClustersResponse> getListGameServerClustersMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.ListGameServerClustersRequest, com.google.cloud.gaming.v1.ListGameServerClustersResponse> getListGameServerClustersMethod;
    if ((getListGameServerClustersMethod = GameServerClustersServiceGrpc.getListGameServerClustersMethod) == null) {
      synchronized (GameServerClustersServiceGrpc.class) {
        if ((getListGameServerClustersMethod = GameServerClustersServiceGrpc.getListGameServerClustersMethod) == null) {
          GameServerClustersServiceGrpc.getListGameServerClustersMethod = getListGameServerClustersMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gaming.v1.ListGameServerClustersRequest, com.google.cloud.gaming.v1.ListGameServerClustersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGameServerClusters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.ListGameServerClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.ListGameServerClustersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameServerClustersServiceMethodDescriptorSupplier("ListGameServerClusters"))
              .build();
        }
      }
    }
    return getListGameServerClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.GetGameServerClusterRequest,
      com.google.cloud.gaming.v1.GameServerCluster> getGetGameServerClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGameServerCluster",
      requestType = com.google.cloud.gaming.v1.GetGameServerClusterRequest.class,
      responseType = com.google.cloud.gaming.v1.GameServerCluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.GetGameServerClusterRequest,
      com.google.cloud.gaming.v1.GameServerCluster> getGetGameServerClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.GetGameServerClusterRequest, com.google.cloud.gaming.v1.GameServerCluster> getGetGameServerClusterMethod;
    if ((getGetGameServerClusterMethod = GameServerClustersServiceGrpc.getGetGameServerClusterMethod) == null) {
      synchronized (GameServerClustersServiceGrpc.class) {
        if ((getGetGameServerClusterMethod = GameServerClustersServiceGrpc.getGetGameServerClusterMethod) == null) {
          GameServerClustersServiceGrpc.getGetGameServerClusterMethod = getGetGameServerClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gaming.v1.GetGameServerClusterRequest, com.google.cloud.gaming.v1.GameServerCluster>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGameServerCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.GetGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.GameServerCluster.getDefaultInstance()))
              .setSchemaDescriptor(new GameServerClustersServiceMethodDescriptorSupplier("GetGameServerCluster"))
              .build();
        }
      }
    }
    return getGetGameServerClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.CreateGameServerClusterRequest,
      com.google.longrunning.Operation> getCreateGameServerClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGameServerCluster",
      requestType = com.google.cloud.gaming.v1.CreateGameServerClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.CreateGameServerClusterRequest,
      com.google.longrunning.Operation> getCreateGameServerClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.CreateGameServerClusterRequest, com.google.longrunning.Operation> getCreateGameServerClusterMethod;
    if ((getCreateGameServerClusterMethod = GameServerClustersServiceGrpc.getCreateGameServerClusterMethod) == null) {
      synchronized (GameServerClustersServiceGrpc.class) {
        if ((getCreateGameServerClusterMethod = GameServerClustersServiceGrpc.getCreateGameServerClusterMethod) == null) {
          GameServerClustersServiceGrpc.getCreateGameServerClusterMethod = getCreateGameServerClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gaming.v1.CreateGameServerClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateGameServerCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.CreateGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GameServerClustersServiceMethodDescriptorSupplier("CreateGameServerCluster"))
              .build();
        }
      }
    }
    return getCreateGameServerClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.PreviewCreateGameServerClusterRequest,
      com.google.cloud.gaming.v1.PreviewCreateGameServerClusterResponse> getPreviewCreateGameServerClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PreviewCreateGameServerCluster",
      requestType = com.google.cloud.gaming.v1.PreviewCreateGameServerClusterRequest.class,
      responseType = com.google.cloud.gaming.v1.PreviewCreateGameServerClusterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.PreviewCreateGameServerClusterRequest,
      com.google.cloud.gaming.v1.PreviewCreateGameServerClusterResponse> getPreviewCreateGameServerClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.PreviewCreateGameServerClusterRequest, com.google.cloud.gaming.v1.PreviewCreateGameServerClusterResponse> getPreviewCreateGameServerClusterMethod;
    if ((getPreviewCreateGameServerClusterMethod = GameServerClustersServiceGrpc.getPreviewCreateGameServerClusterMethod) == null) {
      synchronized (GameServerClustersServiceGrpc.class) {
        if ((getPreviewCreateGameServerClusterMethod = GameServerClustersServiceGrpc.getPreviewCreateGameServerClusterMethod) == null) {
          GameServerClustersServiceGrpc.getPreviewCreateGameServerClusterMethod = getPreviewCreateGameServerClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gaming.v1.PreviewCreateGameServerClusterRequest, com.google.cloud.gaming.v1.PreviewCreateGameServerClusterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PreviewCreateGameServerCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.PreviewCreateGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.PreviewCreateGameServerClusterResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameServerClustersServiceMethodDescriptorSupplier("PreviewCreateGameServerCluster"))
              .build();
        }
      }
    }
    return getPreviewCreateGameServerClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.DeleteGameServerClusterRequest,
      com.google.longrunning.Operation> getDeleteGameServerClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGameServerCluster",
      requestType = com.google.cloud.gaming.v1.DeleteGameServerClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.DeleteGameServerClusterRequest,
      com.google.longrunning.Operation> getDeleteGameServerClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.DeleteGameServerClusterRequest, com.google.longrunning.Operation> getDeleteGameServerClusterMethod;
    if ((getDeleteGameServerClusterMethod = GameServerClustersServiceGrpc.getDeleteGameServerClusterMethod) == null) {
      synchronized (GameServerClustersServiceGrpc.class) {
        if ((getDeleteGameServerClusterMethod = GameServerClustersServiceGrpc.getDeleteGameServerClusterMethod) == null) {
          GameServerClustersServiceGrpc.getDeleteGameServerClusterMethod = getDeleteGameServerClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gaming.v1.DeleteGameServerClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteGameServerCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.DeleteGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GameServerClustersServiceMethodDescriptorSupplier("DeleteGameServerCluster"))
              .build();
        }
      }
    }
    return getDeleteGameServerClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterRequest,
      com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterResponse> getPreviewDeleteGameServerClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PreviewDeleteGameServerCluster",
      requestType = com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterRequest.class,
      responseType = com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterRequest,
      com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterResponse> getPreviewDeleteGameServerClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterRequest, com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterResponse> getPreviewDeleteGameServerClusterMethod;
    if ((getPreviewDeleteGameServerClusterMethod = GameServerClustersServiceGrpc.getPreviewDeleteGameServerClusterMethod) == null) {
      synchronized (GameServerClustersServiceGrpc.class) {
        if ((getPreviewDeleteGameServerClusterMethod = GameServerClustersServiceGrpc.getPreviewDeleteGameServerClusterMethod) == null) {
          GameServerClustersServiceGrpc.getPreviewDeleteGameServerClusterMethod = getPreviewDeleteGameServerClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterRequest, com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PreviewDeleteGameServerCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameServerClustersServiceMethodDescriptorSupplier("PreviewDeleteGameServerCluster"))
              .build();
        }
      }
    }
    return getPreviewDeleteGameServerClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.UpdateGameServerClusterRequest,
      com.google.longrunning.Operation> getUpdateGameServerClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGameServerCluster",
      requestType = com.google.cloud.gaming.v1.UpdateGameServerClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.UpdateGameServerClusterRequest,
      com.google.longrunning.Operation> getUpdateGameServerClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.UpdateGameServerClusterRequest, com.google.longrunning.Operation> getUpdateGameServerClusterMethod;
    if ((getUpdateGameServerClusterMethod = GameServerClustersServiceGrpc.getUpdateGameServerClusterMethod) == null) {
      synchronized (GameServerClustersServiceGrpc.class) {
        if ((getUpdateGameServerClusterMethod = GameServerClustersServiceGrpc.getUpdateGameServerClusterMethod) == null) {
          GameServerClustersServiceGrpc.getUpdateGameServerClusterMethod = getUpdateGameServerClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gaming.v1.UpdateGameServerClusterRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateGameServerCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.UpdateGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new GameServerClustersServiceMethodDescriptorSupplier("UpdateGameServerCluster"))
              .build();
        }
      }
    }
    return getUpdateGameServerClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterRequest,
      com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterResponse> getPreviewUpdateGameServerClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PreviewUpdateGameServerCluster",
      requestType = com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterRequest.class,
      responseType = com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterRequest,
      com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterResponse> getPreviewUpdateGameServerClusterMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterRequest, com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterResponse> getPreviewUpdateGameServerClusterMethod;
    if ((getPreviewUpdateGameServerClusterMethod = GameServerClustersServiceGrpc.getPreviewUpdateGameServerClusterMethod) == null) {
      synchronized (GameServerClustersServiceGrpc.class) {
        if ((getPreviewUpdateGameServerClusterMethod = GameServerClustersServiceGrpc.getPreviewUpdateGameServerClusterMethod) == null) {
          GameServerClustersServiceGrpc.getPreviewUpdateGameServerClusterMethod = getPreviewUpdateGameServerClusterMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterRequest, com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PreviewUpdateGameServerCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameServerClustersServiceMethodDescriptorSupplier("PreviewUpdateGameServerCluster"))
              .build();
        }
      }
    }
    return getPreviewUpdateGameServerClusterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GameServerClustersServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameServerClustersServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameServerClustersServiceStub>() {
        @java.lang.Override
        public GameServerClustersServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameServerClustersServiceStub(channel, callOptions);
        }
      };
    return GameServerClustersServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GameServerClustersServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameServerClustersServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameServerClustersServiceBlockingStub>() {
        @java.lang.Override
        public GameServerClustersServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameServerClustersServiceBlockingStub(channel, callOptions);
        }
      };
    return GameServerClustersServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GameServerClustersServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameServerClustersServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameServerClustersServiceFutureStub>() {
        @java.lang.Override
        public GameServerClustersServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameServerClustersServiceFutureStub(channel, callOptions);
        }
      };
    return GameServerClustersServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The game server cluster maps to Kubernetes clusters running Agones and is
   * used to manage fleets within clusters.
   * </pre>
   */
  public static abstract class GameServerClustersServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists game server clusters in a given project and location.
     * </pre>
     */
    public void listGameServerClusters(com.google.cloud.gaming.v1.ListGameServerClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.ListGameServerClustersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListGameServerClustersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single game server cluster.
     * </pre>
     */
    public void getGameServerCluster(com.google.cloud.gaming.v1.GetGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.GameServerCluster> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetGameServerClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new game server cluster in a given project and location.
     * </pre>
     */
    public void createGameServerCluster(com.google.cloud.gaming.v1.CreateGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateGameServerClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Previews creation of a new game server cluster in a given project and
     * location.
     * </pre>
     */
    public void previewCreateGameServerCluster(com.google.cloud.gaming.v1.PreviewCreateGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.PreviewCreateGameServerClusterResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPreviewCreateGameServerClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single game server cluster.
     * </pre>
     */
    public void deleteGameServerCluster(com.google.cloud.gaming.v1.DeleteGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteGameServerClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Previews deletion of a single game server cluster.
     * </pre>
     */
    public void previewDeleteGameServerCluster(com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPreviewDeleteGameServerClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Patches a single game server cluster.
     * </pre>
     */
    public void updateGameServerCluster(com.google.cloud.gaming.v1.UpdateGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateGameServerClusterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Previews updating a GameServerCluster.
     * </pre>
     */
    public void previewUpdateGameServerCluster(com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPreviewUpdateGameServerClusterMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListGameServerClustersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gaming.v1.ListGameServerClustersRequest,
                com.google.cloud.gaming.v1.ListGameServerClustersResponse>(
                  this, METHODID_LIST_GAME_SERVER_CLUSTERS)))
          .addMethod(
            getGetGameServerClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gaming.v1.GetGameServerClusterRequest,
                com.google.cloud.gaming.v1.GameServerCluster>(
                  this, METHODID_GET_GAME_SERVER_CLUSTER)))
          .addMethod(
            getCreateGameServerClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gaming.v1.CreateGameServerClusterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_GAME_SERVER_CLUSTER)))
          .addMethod(
            getPreviewCreateGameServerClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gaming.v1.PreviewCreateGameServerClusterRequest,
                com.google.cloud.gaming.v1.PreviewCreateGameServerClusterResponse>(
                  this, METHODID_PREVIEW_CREATE_GAME_SERVER_CLUSTER)))
          .addMethod(
            getDeleteGameServerClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gaming.v1.DeleteGameServerClusterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_GAME_SERVER_CLUSTER)))
          .addMethod(
            getPreviewDeleteGameServerClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterRequest,
                com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterResponse>(
                  this, METHODID_PREVIEW_DELETE_GAME_SERVER_CLUSTER)))
          .addMethod(
            getUpdateGameServerClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gaming.v1.UpdateGameServerClusterRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_GAME_SERVER_CLUSTER)))
          .addMethod(
            getPreviewUpdateGameServerClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterRequest,
                com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterResponse>(
                  this, METHODID_PREVIEW_UPDATE_GAME_SERVER_CLUSTER)))
          .build();
    }
  }

  /**
   * <pre>
   * The game server cluster maps to Kubernetes clusters running Agones and is
   * used to manage fleets within clusters.
   * </pre>
   */
  public static final class GameServerClustersServiceStub extends io.grpc.stub.AbstractAsyncStub<GameServerClustersServiceStub> {
    private GameServerClustersServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServerClustersServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameServerClustersServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists game server clusters in a given project and location.
     * </pre>
     */
    public void listGameServerClusters(com.google.cloud.gaming.v1.ListGameServerClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.ListGameServerClustersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGameServerClustersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single game server cluster.
     * </pre>
     */
    public void getGameServerCluster(com.google.cloud.gaming.v1.GetGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.GameServerCluster> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGameServerClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new game server cluster in a given project and location.
     * </pre>
     */
    public void createGameServerCluster(com.google.cloud.gaming.v1.CreateGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGameServerClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Previews creation of a new game server cluster in a given project and
     * location.
     * </pre>
     */
    public void previewCreateGameServerCluster(com.google.cloud.gaming.v1.PreviewCreateGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.PreviewCreateGameServerClusterResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPreviewCreateGameServerClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single game server cluster.
     * </pre>
     */
    public void deleteGameServerCluster(com.google.cloud.gaming.v1.DeleteGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGameServerClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Previews deletion of a single game server cluster.
     * </pre>
     */
    public void previewDeleteGameServerCluster(com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPreviewDeleteGameServerClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Patches a single game server cluster.
     * </pre>
     */
    public void updateGameServerCluster(com.google.cloud.gaming.v1.UpdateGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGameServerClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Previews updating a GameServerCluster.
     * </pre>
     */
    public void previewUpdateGameServerCluster(com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPreviewUpdateGameServerClusterMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The game server cluster maps to Kubernetes clusters running Agones and is
   * used to manage fleets within clusters.
   * </pre>
   */
  public static final class GameServerClustersServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GameServerClustersServiceBlockingStub> {
    private GameServerClustersServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServerClustersServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameServerClustersServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists game server clusters in a given project and location.
     * </pre>
     */
    public com.google.cloud.gaming.v1.ListGameServerClustersResponse listGameServerClusters(com.google.cloud.gaming.v1.ListGameServerClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGameServerClustersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single game server cluster.
     * </pre>
     */
    public com.google.cloud.gaming.v1.GameServerCluster getGameServerCluster(com.google.cloud.gaming.v1.GetGameServerClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGameServerClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new game server cluster in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createGameServerCluster(com.google.cloud.gaming.v1.CreateGameServerClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGameServerClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Previews creation of a new game server cluster in a given project and
     * location.
     * </pre>
     */
    public com.google.cloud.gaming.v1.PreviewCreateGameServerClusterResponse previewCreateGameServerCluster(com.google.cloud.gaming.v1.PreviewCreateGameServerClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPreviewCreateGameServerClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single game server cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGameServerCluster(com.google.cloud.gaming.v1.DeleteGameServerClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGameServerClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Previews deletion of a single game server cluster.
     * </pre>
     */
    public com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterResponse previewDeleteGameServerCluster(com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPreviewDeleteGameServerClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Patches a single game server cluster.
     * </pre>
     */
    public com.google.longrunning.Operation updateGameServerCluster(com.google.cloud.gaming.v1.UpdateGameServerClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGameServerClusterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Previews updating a GameServerCluster.
     * </pre>
     */
    public com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterResponse previewUpdateGameServerCluster(com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPreviewUpdateGameServerClusterMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The game server cluster maps to Kubernetes clusters running Agones and is
   * used to manage fleets within clusters.
   * </pre>
   */
  public static final class GameServerClustersServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GameServerClustersServiceFutureStub> {
    private GameServerClustersServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServerClustersServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameServerClustersServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists game server clusters in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gaming.v1.ListGameServerClustersResponse> listGameServerClusters(
        com.google.cloud.gaming.v1.ListGameServerClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGameServerClustersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single game server cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gaming.v1.GameServerCluster> getGameServerCluster(
        com.google.cloud.gaming.v1.GetGameServerClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGameServerClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new game server cluster in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createGameServerCluster(
        com.google.cloud.gaming.v1.CreateGameServerClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGameServerClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Previews creation of a new game server cluster in a given project and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gaming.v1.PreviewCreateGameServerClusterResponse> previewCreateGameServerCluster(
        com.google.cloud.gaming.v1.PreviewCreateGameServerClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPreviewCreateGameServerClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single game server cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteGameServerCluster(
        com.google.cloud.gaming.v1.DeleteGameServerClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGameServerClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Previews deletion of a single game server cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterResponse> previewDeleteGameServerCluster(
        com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPreviewDeleteGameServerClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Patches a single game server cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateGameServerCluster(
        com.google.cloud.gaming.v1.UpdateGameServerClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGameServerClusterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Previews updating a GameServerCluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterResponse> previewUpdateGameServerCluster(
        com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPreviewUpdateGameServerClusterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_GAME_SERVER_CLUSTERS = 0;
  private static final int METHODID_GET_GAME_SERVER_CLUSTER = 1;
  private static final int METHODID_CREATE_GAME_SERVER_CLUSTER = 2;
  private static final int METHODID_PREVIEW_CREATE_GAME_SERVER_CLUSTER = 3;
  private static final int METHODID_DELETE_GAME_SERVER_CLUSTER = 4;
  private static final int METHODID_PREVIEW_DELETE_GAME_SERVER_CLUSTER = 5;
  private static final int METHODID_UPDATE_GAME_SERVER_CLUSTER = 6;
  private static final int METHODID_PREVIEW_UPDATE_GAME_SERVER_CLUSTER = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GameServerClustersServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GameServerClustersServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_GAME_SERVER_CLUSTERS:
          serviceImpl.listGameServerClusters((com.google.cloud.gaming.v1.ListGameServerClustersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.ListGameServerClustersResponse>) responseObserver);
          break;
        case METHODID_GET_GAME_SERVER_CLUSTER:
          serviceImpl.getGameServerCluster((com.google.cloud.gaming.v1.GetGameServerClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.GameServerCluster>) responseObserver);
          break;
        case METHODID_CREATE_GAME_SERVER_CLUSTER:
          serviceImpl.createGameServerCluster((com.google.cloud.gaming.v1.CreateGameServerClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PREVIEW_CREATE_GAME_SERVER_CLUSTER:
          serviceImpl.previewCreateGameServerCluster((com.google.cloud.gaming.v1.PreviewCreateGameServerClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.PreviewCreateGameServerClusterResponse>) responseObserver);
          break;
        case METHODID_DELETE_GAME_SERVER_CLUSTER:
          serviceImpl.deleteGameServerCluster((com.google.cloud.gaming.v1.DeleteGameServerClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PREVIEW_DELETE_GAME_SERVER_CLUSTER:
          serviceImpl.previewDeleteGameServerCluster((com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GAME_SERVER_CLUSTER:
          serviceImpl.updateGameServerCluster((com.google.cloud.gaming.v1.UpdateGameServerClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PREVIEW_UPDATE_GAME_SERVER_CLUSTER:
          serviceImpl.previewUpdateGameServerCluster((com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterResponse>) responseObserver);
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

  private static abstract class GameServerClustersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GameServerClustersServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gaming.v1.GameServerClustersServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GameServerClustersService");
    }
  }

  private static final class GameServerClustersServiceFileDescriptorSupplier
      extends GameServerClustersServiceBaseDescriptorSupplier {
    GameServerClustersServiceFileDescriptorSupplier() {}
  }

  private static final class GameServerClustersServiceMethodDescriptorSupplier
      extends GameServerClustersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GameServerClustersServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (GameServerClustersServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GameServerClustersServiceFileDescriptorSupplier())
              .addMethod(getListGameServerClustersMethod())
              .addMethod(getGetGameServerClusterMethod())
              .addMethod(getCreateGameServerClusterMethod())
              .addMethod(getPreviewCreateGameServerClusterMethod())
              .addMethod(getDeleteGameServerClusterMethod())
              .addMethod(getPreviewDeleteGameServerClusterMethod())
              .addMethod(getUpdateGameServerClusterMethod())
              .addMethod(getPreviewUpdateGameServerClusterMethod())
              .build();
        }
      }
    }
    return result;
  }
}
