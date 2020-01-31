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
 * The game server cluster maps to Kubernetes clusters running Agones and is
 * used to manage fleets within clusters.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/gaming/v1alpha/game_server_clusters_service.proto")
public final class GameServerClustersServiceGrpc {

  private GameServerClustersServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.gaming.v1alpha.GameServerClustersService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListGameServerClustersMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListGameServerClustersRequest,
          com.google.cloud.gaming.v1alpha.ListGameServerClustersResponse>
      METHOD_LIST_GAME_SERVER_CLUSTERS = getListGameServerClustersMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListGameServerClustersRequest,
          com.google.cloud.gaming.v1alpha.ListGameServerClustersResponse>
      getListGameServerClustersMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListGameServerClustersRequest,
          com.google.cloud.gaming.v1alpha.ListGameServerClustersResponse>
      getListGameServerClustersMethod() {
    return getListGameServerClustersMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListGameServerClustersRequest,
          com.google.cloud.gaming.v1alpha.ListGameServerClustersResponse>
      getListGameServerClustersMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.ListGameServerClustersRequest,
            com.google.cloud.gaming.v1alpha.ListGameServerClustersResponse>
        getListGameServerClustersMethod;
    if ((getListGameServerClustersMethod =
            GameServerClustersServiceGrpc.getListGameServerClustersMethod)
        == null) {
      synchronized (GameServerClustersServiceGrpc.class) {
        if ((getListGameServerClustersMethod =
                GameServerClustersServiceGrpc.getListGameServerClustersMethod)
            == null) {
          GameServerClustersServiceGrpc.getListGameServerClustersMethod =
              getListGameServerClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.ListGameServerClustersRequest,
                          com.google.cloud.gaming.v1alpha.ListGameServerClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerClustersService",
                              "ListGameServerClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.ListGameServerClustersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.ListGameServerClustersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerClustersServiceMethodDescriptorSupplier(
                              "ListGameServerClusters"))
                      .build();
        }
      }
    }
    return getListGameServerClustersMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetGameServerClusterMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetGameServerClusterRequest,
          com.google.cloud.gaming.v1alpha.GameServerCluster>
      METHOD_GET_GAME_SERVER_CLUSTER = getGetGameServerClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetGameServerClusterRequest,
          com.google.cloud.gaming.v1alpha.GameServerCluster>
      getGetGameServerClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetGameServerClusterRequest,
          com.google.cloud.gaming.v1alpha.GameServerCluster>
      getGetGameServerClusterMethod() {
    return getGetGameServerClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetGameServerClusterRequest,
          com.google.cloud.gaming.v1alpha.GameServerCluster>
      getGetGameServerClusterMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.GetGameServerClusterRequest,
            com.google.cloud.gaming.v1alpha.GameServerCluster>
        getGetGameServerClusterMethod;
    if ((getGetGameServerClusterMethod =
            GameServerClustersServiceGrpc.getGetGameServerClusterMethod)
        == null) {
      synchronized (GameServerClustersServiceGrpc.class) {
        if ((getGetGameServerClusterMethod =
                GameServerClustersServiceGrpc.getGetGameServerClusterMethod)
            == null) {
          GameServerClustersServiceGrpc.getGetGameServerClusterMethod =
              getGetGameServerClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.GetGameServerClusterRequest,
                          com.google.cloud.gaming.v1alpha.GameServerCluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerClustersService",
                              "GetGameServerCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.GetGameServerClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.GameServerCluster
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerClustersServiceMethodDescriptorSupplier(
                              "GetGameServerCluster"))
                      .build();
        }
      }
    }
    return getGetGameServerClusterMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateGameServerClusterMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateGameServerClusterRequest,
          com.google.longrunning.Operation>
      METHOD_CREATE_GAME_SERVER_CLUSTER = getCreateGameServerClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateGameServerClusterRequest,
          com.google.longrunning.Operation>
      getCreateGameServerClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateGameServerClusterRequest,
          com.google.longrunning.Operation>
      getCreateGameServerClusterMethod() {
    return getCreateGameServerClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateGameServerClusterRequest,
          com.google.longrunning.Operation>
      getCreateGameServerClusterMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.CreateGameServerClusterRequest,
            com.google.longrunning.Operation>
        getCreateGameServerClusterMethod;
    if ((getCreateGameServerClusterMethod =
            GameServerClustersServiceGrpc.getCreateGameServerClusterMethod)
        == null) {
      synchronized (GameServerClustersServiceGrpc.class) {
        if ((getCreateGameServerClusterMethod =
                GameServerClustersServiceGrpc.getCreateGameServerClusterMethod)
            == null) {
          GameServerClustersServiceGrpc.getCreateGameServerClusterMethod =
              getCreateGameServerClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.CreateGameServerClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerClustersService",
                              "CreateGameServerCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.CreateGameServerClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerClustersServiceMethodDescriptorSupplier(
                              "CreateGameServerCluster"))
                      .build();
        }
      }
    }
    return getCreateGameServerClusterMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPreviewCreateGameServerClusterMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterRequest,
          com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterResponse>
      METHOD_PREVIEW_CREATE_GAME_SERVER_CLUSTER = getPreviewCreateGameServerClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterRequest,
          com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterResponse>
      getPreviewCreateGameServerClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterRequest,
          com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterResponse>
      getPreviewCreateGameServerClusterMethod() {
    return getPreviewCreateGameServerClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterRequest,
          com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterResponse>
      getPreviewCreateGameServerClusterMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterRequest,
            com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterResponse>
        getPreviewCreateGameServerClusterMethod;
    if ((getPreviewCreateGameServerClusterMethod =
            GameServerClustersServiceGrpc.getPreviewCreateGameServerClusterMethod)
        == null) {
      synchronized (GameServerClustersServiceGrpc.class) {
        if ((getPreviewCreateGameServerClusterMethod =
                GameServerClustersServiceGrpc.getPreviewCreateGameServerClusterMethod)
            == null) {
          GameServerClustersServiceGrpc.getPreviewCreateGameServerClusterMethod =
              getPreviewCreateGameServerClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterRequest,
                          com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerClustersService",
                              "PreviewCreateGameServerCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerClustersServiceMethodDescriptorSupplier(
                              "PreviewCreateGameServerCluster"))
                      .build();
        }
      }
    }
    return getPreviewCreateGameServerClusterMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteGameServerClusterMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteGameServerClusterRequest,
          com.google.longrunning.Operation>
      METHOD_DELETE_GAME_SERVER_CLUSTER = getDeleteGameServerClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteGameServerClusterRequest,
          com.google.longrunning.Operation>
      getDeleteGameServerClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteGameServerClusterRequest,
          com.google.longrunning.Operation>
      getDeleteGameServerClusterMethod() {
    return getDeleteGameServerClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteGameServerClusterRequest,
          com.google.longrunning.Operation>
      getDeleteGameServerClusterMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.DeleteGameServerClusterRequest,
            com.google.longrunning.Operation>
        getDeleteGameServerClusterMethod;
    if ((getDeleteGameServerClusterMethod =
            GameServerClustersServiceGrpc.getDeleteGameServerClusterMethod)
        == null) {
      synchronized (GameServerClustersServiceGrpc.class) {
        if ((getDeleteGameServerClusterMethod =
                GameServerClustersServiceGrpc.getDeleteGameServerClusterMethod)
            == null) {
          GameServerClustersServiceGrpc.getDeleteGameServerClusterMethod =
              getDeleteGameServerClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.DeleteGameServerClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerClustersService",
                              "DeleteGameServerCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.DeleteGameServerClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerClustersServiceMethodDescriptorSupplier(
                              "DeleteGameServerCluster"))
                      .build();
        }
      }
    }
    return getDeleteGameServerClusterMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPreviewDeleteGameServerClusterMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterRequest,
          com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterResponse>
      METHOD_PREVIEW_DELETE_GAME_SERVER_CLUSTER = getPreviewDeleteGameServerClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterRequest,
          com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterResponse>
      getPreviewDeleteGameServerClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterRequest,
          com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterResponse>
      getPreviewDeleteGameServerClusterMethod() {
    return getPreviewDeleteGameServerClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterRequest,
          com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterResponse>
      getPreviewDeleteGameServerClusterMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterRequest,
            com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterResponse>
        getPreviewDeleteGameServerClusterMethod;
    if ((getPreviewDeleteGameServerClusterMethod =
            GameServerClustersServiceGrpc.getPreviewDeleteGameServerClusterMethod)
        == null) {
      synchronized (GameServerClustersServiceGrpc.class) {
        if ((getPreviewDeleteGameServerClusterMethod =
                GameServerClustersServiceGrpc.getPreviewDeleteGameServerClusterMethod)
            == null) {
          GameServerClustersServiceGrpc.getPreviewDeleteGameServerClusterMethod =
              getPreviewDeleteGameServerClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterRequest,
                          com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerClustersService",
                              "PreviewDeleteGameServerCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerClustersServiceMethodDescriptorSupplier(
                              "PreviewDeleteGameServerCluster"))
                      .build();
        }
      }
    }
    return getPreviewDeleteGameServerClusterMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateGameServerClusterMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateGameServerClusterRequest,
          com.google.longrunning.Operation>
      METHOD_UPDATE_GAME_SERVER_CLUSTER = getUpdateGameServerClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateGameServerClusterRequest,
          com.google.longrunning.Operation>
      getUpdateGameServerClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateGameServerClusterRequest,
          com.google.longrunning.Operation>
      getUpdateGameServerClusterMethod() {
    return getUpdateGameServerClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateGameServerClusterRequest,
          com.google.longrunning.Operation>
      getUpdateGameServerClusterMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.UpdateGameServerClusterRequest,
            com.google.longrunning.Operation>
        getUpdateGameServerClusterMethod;
    if ((getUpdateGameServerClusterMethod =
            GameServerClustersServiceGrpc.getUpdateGameServerClusterMethod)
        == null) {
      synchronized (GameServerClustersServiceGrpc.class) {
        if ((getUpdateGameServerClusterMethod =
                GameServerClustersServiceGrpc.getUpdateGameServerClusterMethod)
            == null) {
          GameServerClustersServiceGrpc.getUpdateGameServerClusterMethod =
              getUpdateGameServerClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.UpdateGameServerClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerClustersService",
                              "UpdateGameServerCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.UpdateGameServerClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerClustersServiceMethodDescriptorSupplier(
                              "UpdateGameServerCluster"))
                      .build();
        }
      }
    }
    return getUpdateGameServerClusterMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPreviewUpdateGameServerClusterMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterRequest,
          com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterResponse>
      METHOD_PREVIEW_UPDATE_GAME_SERVER_CLUSTER = getPreviewUpdateGameServerClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterRequest,
          com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterResponse>
      getPreviewUpdateGameServerClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterRequest,
          com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterResponse>
      getPreviewUpdateGameServerClusterMethod() {
    return getPreviewUpdateGameServerClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterRequest,
          com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterResponse>
      getPreviewUpdateGameServerClusterMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterRequest,
            com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterResponse>
        getPreviewUpdateGameServerClusterMethod;
    if ((getPreviewUpdateGameServerClusterMethod =
            GameServerClustersServiceGrpc.getPreviewUpdateGameServerClusterMethod)
        == null) {
      synchronized (GameServerClustersServiceGrpc.class) {
        if ((getPreviewUpdateGameServerClusterMethod =
                GameServerClustersServiceGrpc.getPreviewUpdateGameServerClusterMethod)
            == null) {
          GameServerClustersServiceGrpc.getPreviewUpdateGameServerClusterMethod =
              getPreviewUpdateGameServerClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterRequest,
                          com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerClustersService",
                              "PreviewUpdateGameServerCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerClustersServiceMethodDescriptorSupplier(
                              "PreviewUpdateGameServerCluster"))
                      .build();
        }
      }
    }
    return getPreviewUpdateGameServerClusterMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GameServerClustersServiceStub newStub(io.grpc.Channel channel) {
    return new GameServerClustersServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GameServerClustersServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new GameServerClustersServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GameServerClustersServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new GameServerClustersServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * The game server cluster maps to Kubernetes clusters running Agones and is
   * used to manage fleets within clusters.
   * </pre>
   */
  public abstract static class GameServerClustersServiceImplBase
      implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists game server clusters in a given project and location.
     * </pre>
     */
    public void listGameServerClusters(
        com.google.cloud.gaming.v1alpha.ListGameServerClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.ListGameServerClustersResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListGameServerClustersMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single game server cluster.
     * </pre>
     */
    public void getGameServerCluster(
        com.google.cloud.gaming.v1alpha.GetGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.GameServerCluster>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetGameServerClusterMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new game server cluster in a given project and location.
     * </pre>
     */
    public void createGameServerCluster(
        com.google.cloud.gaming.v1alpha.CreateGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateGameServerClusterMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Previews creation of a new game server cluster in a given project and
     * location.
     * </pre>
     */
    public void previewCreateGameServerCluster(
        com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(
          getPreviewCreateGameServerClusterMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single game server cluster.
     * </pre>
     */
    public void deleteGameServerCluster(
        com.google.cloud.gaming.v1alpha.DeleteGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGameServerClusterMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Previews deletion of a single game server cluster.
     * </pre>
     */
    public void previewDeleteGameServerCluster(
        com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(
          getPreviewDeleteGameServerClusterMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Patches a single game server cluster.
     * </pre>
     */
    public void updateGameServerCluster(
        com.google.cloud.gaming.v1alpha.UpdateGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGameServerClusterMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Previews updating a GameServerCluster.
     * </pre>
     */
    public void previewUpdateGameServerCluster(
        com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(
          getPreviewUpdateGameServerClusterMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListGameServerClustersMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.ListGameServerClustersRequest,
                      com.google.cloud.gaming.v1alpha.ListGameServerClustersResponse>(
                      this, METHODID_LIST_GAME_SERVER_CLUSTERS)))
          .addMethod(
              getGetGameServerClusterMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.GetGameServerClusterRequest,
                      com.google.cloud.gaming.v1alpha.GameServerCluster>(
                      this, METHODID_GET_GAME_SERVER_CLUSTER)))
          .addMethod(
              getCreateGameServerClusterMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.CreateGameServerClusterRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_GAME_SERVER_CLUSTER)))
          .addMethod(
              getPreviewCreateGameServerClusterMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterRequest,
                      com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterResponse>(
                      this, METHODID_PREVIEW_CREATE_GAME_SERVER_CLUSTER)))
          .addMethod(
              getDeleteGameServerClusterMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.DeleteGameServerClusterRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_GAME_SERVER_CLUSTER)))
          .addMethod(
              getPreviewDeleteGameServerClusterMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterRequest,
                      com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterResponse>(
                      this, METHODID_PREVIEW_DELETE_GAME_SERVER_CLUSTER)))
          .addMethod(
              getUpdateGameServerClusterMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.UpdateGameServerClusterRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_GAME_SERVER_CLUSTER)))
          .addMethod(
              getPreviewUpdateGameServerClusterMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterRequest,
                      com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterResponse>(
                      this, METHODID_PREVIEW_UPDATE_GAME_SERVER_CLUSTER)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The game server cluster maps to Kubernetes clusters running Agones and is
   * used to manage fleets within clusters.
   * </pre>
   */
  public static final class GameServerClustersServiceStub
      extends io.grpc.stub.AbstractStub<GameServerClustersServiceStub> {
    private GameServerClustersServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     *
     *
     * <pre>
     * Lists game server clusters in a given project and location.
     * </pre>
     */
    public void listGameServerClusters(
        com.google.cloud.gaming.v1alpha.ListGameServerClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.ListGameServerClustersResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListGameServerClustersMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single game server cluster.
     * </pre>
     */
    public void getGameServerCluster(
        com.google.cloud.gaming.v1alpha.GetGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.GameServerCluster>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetGameServerClusterMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new game server cluster in a given project and location.
     * </pre>
     */
    public void createGameServerCluster(
        com.google.cloud.gaming.v1alpha.CreateGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateGameServerClusterMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Previews creation of a new game server cluster in a given project and
     * location.
     * </pre>
     */
    public void previewCreateGameServerCluster(
        com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPreviewCreateGameServerClusterMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single game server cluster.
     * </pre>
     */
    public void deleteGameServerCluster(
        com.google.cloud.gaming.v1alpha.DeleteGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGameServerClusterMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Previews deletion of a single game server cluster.
     * </pre>
     */
    public void previewDeleteGameServerCluster(
        com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPreviewDeleteGameServerClusterMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Patches a single game server cluster.
     * </pre>
     */
    public void updateGameServerCluster(
        com.google.cloud.gaming.v1alpha.UpdateGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGameServerClusterMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Previews updating a GameServerCluster.
     * </pre>
     */
    public void previewUpdateGameServerCluster(
        com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPreviewUpdateGameServerClusterMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The game server cluster maps to Kubernetes clusters running Agones and is
   * used to manage fleets within clusters.
   * </pre>
   */
  public static final class GameServerClustersServiceBlockingStub
      extends io.grpc.stub.AbstractStub<GameServerClustersServiceBlockingStub> {
    private GameServerClustersServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     *
     *
     * <pre>
     * Lists game server clusters in a given project and location.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.ListGameServerClustersResponse listGameServerClusters(
        com.google.cloud.gaming.v1alpha.ListGameServerClustersRequest request) {
      return blockingUnaryCall(
          getChannel(), getListGameServerClustersMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single game server cluster.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.GameServerCluster getGameServerCluster(
        com.google.cloud.gaming.v1alpha.GetGameServerClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetGameServerClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new game server cluster in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createGameServerCluster(
        com.google.cloud.gaming.v1alpha.CreateGameServerClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateGameServerClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Previews creation of a new game server cluster in a given project and
     * location.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterResponse
        previewCreateGameServerCluster(
            com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getPreviewCreateGameServerClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single game server cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGameServerCluster(
        com.google.cloud.gaming.v1alpha.DeleteGameServerClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGameServerClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Previews deletion of a single game server cluster.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterResponse
        previewDeleteGameServerCluster(
            com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getPreviewDeleteGameServerClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Patches a single game server cluster.
     * </pre>
     */
    public com.google.longrunning.Operation updateGameServerCluster(
        com.google.cloud.gaming.v1alpha.UpdateGameServerClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGameServerClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Previews updating a GameServerCluster.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterResponse
        previewUpdateGameServerCluster(
            com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getPreviewUpdateGameServerClusterMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The game server cluster maps to Kubernetes clusters running Agones and is
   * used to manage fleets within clusters.
   * </pre>
   */
  public static final class GameServerClustersServiceFutureStub
      extends io.grpc.stub.AbstractStub<GameServerClustersServiceFutureStub> {
    private GameServerClustersServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     *
     *
     * <pre>
     * Lists game server clusters in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.ListGameServerClustersResponse>
        listGameServerClusters(
            com.google.cloud.gaming.v1alpha.ListGameServerClustersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListGameServerClustersMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single game server cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.GameServerCluster>
        getGameServerCluster(com.google.cloud.gaming.v1alpha.GetGameServerClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetGameServerClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new game server cluster in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createGameServerCluster(
            com.google.cloud.gaming.v1alpha.CreateGameServerClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateGameServerClusterMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Previews creation of a new game server cluster in a given project and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterResponse>
        previewCreateGameServerCluster(
            com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPreviewCreateGameServerClusterMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single game server cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteGameServerCluster(
            com.google.cloud.gaming.v1alpha.DeleteGameServerClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGameServerClusterMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Previews deletion of a single game server cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterResponse>
        previewDeleteGameServerCluster(
            com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPreviewDeleteGameServerClusterMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Patches a single game server cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateGameServerCluster(
            com.google.cloud.gaming.v1alpha.UpdateGameServerClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGameServerClusterMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Previews updating a GameServerCluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterResponse>
        previewUpdateGameServerCluster(
            com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPreviewUpdateGameServerClusterMethodHelper(), getCallOptions()),
          request);
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

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.listGameServerClusters(
              (com.google.cloud.gaming.v1alpha.ListGameServerClustersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gaming.v1alpha.ListGameServerClustersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GAME_SERVER_CLUSTER:
          serviceImpl.getGameServerCluster(
              (com.google.cloud.gaming.v1alpha.GetGameServerClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.GameServerCluster>)
                  responseObserver);
          break;
        case METHODID_CREATE_GAME_SERVER_CLUSTER:
          serviceImpl.createGameServerCluster(
              (com.google.cloud.gaming.v1alpha.CreateGameServerClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PREVIEW_CREATE_GAME_SERVER_CLUSTER:
          serviceImpl.previewCreateGameServerCluster(
              (com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gaming.v1alpha.PreviewCreateGameServerClusterResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_GAME_SERVER_CLUSTER:
          serviceImpl.deleteGameServerCluster(
              (com.google.cloud.gaming.v1alpha.DeleteGameServerClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PREVIEW_DELETE_GAME_SERVER_CLUSTER:
          serviceImpl.previewDeleteGameServerCluster(
              (com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gaming.v1alpha.PreviewDeleteGameServerClusterResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_GAME_SERVER_CLUSTER:
          serviceImpl.updateGameServerCluster(
              (com.google.cloud.gaming.v1alpha.UpdateGameServerClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PREVIEW_UPDATE_GAME_SERVER_CLUSTER:
          serviceImpl.previewUpdateGameServerCluster(
              (com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gaming.v1alpha.PreviewUpdateGameServerClusterResponse>)
                  responseObserver);
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

  private abstract static class GameServerClustersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GameServerClustersServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gaming.v1alpha.GameServerClustersServiceOuterClass.getDescriptor();
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
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GameServerClustersServiceFileDescriptorSupplier())
                      .addMethod(getListGameServerClustersMethodHelper())
                      .addMethod(getGetGameServerClusterMethodHelper())
                      .addMethod(getCreateGameServerClusterMethodHelper())
                      .addMethod(getPreviewCreateGameServerClusterMethodHelper())
                      .addMethod(getDeleteGameServerClusterMethodHelper())
                      .addMethod(getPreviewDeleteGameServerClusterMethodHelper())
                      .addMethod(getUpdateGameServerClusterMethodHelper())
                      .addMethod(getPreviewUpdateGameServerClusterMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
