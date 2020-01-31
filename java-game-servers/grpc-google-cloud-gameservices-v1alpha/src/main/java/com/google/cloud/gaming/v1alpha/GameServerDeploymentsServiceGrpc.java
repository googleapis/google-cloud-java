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
 * The game server deployment is used to control the deployment of game server
 * software to Agones fleets.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/gaming/v1alpha/game_server_deployments_service.proto")
public final class GameServerDeploymentsServiceGrpc {

  private GameServerDeploymentsServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.gaming.v1alpha.GameServerDeploymentsService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListGameServerDeploymentsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsRequest,
          com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsResponse>
      METHOD_LIST_GAME_SERVER_DEPLOYMENTS = getListGameServerDeploymentsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsRequest,
          com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsResponse>
      getListGameServerDeploymentsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsRequest,
          com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsResponse>
      getListGameServerDeploymentsMethod() {
    return getListGameServerDeploymentsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsRequest,
          com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsResponse>
      getListGameServerDeploymentsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsRequest,
            com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsResponse>
        getListGameServerDeploymentsMethod;
    if ((getListGameServerDeploymentsMethod =
            GameServerDeploymentsServiceGrpc.getListGameServerDeploymentsMethod)
        == null) {
      synchronized (GameServerDeploymentsServiceGrpc.class) {
        if ((getListGameServerDeploymentsMethod =
                GameServerDeploymentsServiceGrpc.getListGameServerDeploymentsMethod)
            == null) {
          GameServerDeploymentsServiceGrpc.getListGameServerDeploymentsMethod =
              getListGameServerDeploymentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsRequest,
                          com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerDeploymentsService",
                              "ListGameServerDeployments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerDeploymentsServiceMethodDescriptorSupplier(
                              "ListGameServerDeployments"))
                      .build();
        }
      }
    }
    return getListGameServerDeploymentsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetGameServerDeploymentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRequest,
          com.google.cloud.gaming.v1alpha.GameServerDeployment>
      METHOD_GET_GAME_SERVER_DEPLOYMENT = getGetGameServerDeploymentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRequest,
          com.google.cloud.gaming.v1alpha.GameServerDeployment>
      getGetGameServerDeploymentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRequest,
          com.google.cloud.gaming.v1alpha.GameServerDeployment>
      getGetGameServerDeploymentMethod() {
    return getGetGameServerDeploymentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRequest,
          com.google.cloud.gaming.v1alpha.GameServerDeployment>
      getGetGameServerDeploymentMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRequest,
            com.google.cloud.gaming.v1alpha.GameServerDeployment>
        getGetGameServerDeploymentMethod;
    if ((getGetGameServerDeploymentMethod =
            GameServerDeploymentsServiceGrpc.getGetGameServerDeploymentMethod)
        == null) {
      synchronized (GameServerDeploymentsServiceGrpc.class) {
        if ((getGetGameServerDeploymentMethod =
                GameServerDeploymentsServiceGrpc.getGetGameServerDeploymentMethod)
            == null) {
          GameServerDeploymentsServiceGrpc.getGetGameServerDeploymentMethod =
              getGetGameServerDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRequest,
                          com.google.cloud.gaming.v1alpha.GameServerDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerDeploymentsService",
                              "GetGameServerDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.GameServerDeployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerDeploymentsServiceMethodDescriptorSupplier(
                              "GetGameServerDeployment"))
                      .build();
        }
      }
    }
    return getGetGameServerDeploymentMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateGameServerDeploymentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateGameServerDeploymentRequest,
          com.google.longrunning.Operation>
      METHOD_CREATE_GAME_SERVER_DEPLOYMENT = getCreateGameServerDeploymentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateGameServerDeploymentRequest,
          com.google.longrunning.Operation>
      getCreateGameServerDeploymentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateGameServerDeploymentRequest,
          com.google.longrunning.Operation>
      getCreateGameServerDeploymentMethod() {
    return getCreateGameServerDeploymentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateGameServerDeploymentRequest,
          com.google.longrunning.Operation>
      getCreateGameServerDeploymentMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.CreateGameServerDeploymentRequest,
            com.google.longrunning.Operation>
        getCreateGameServerDeploymentMethod;
    if ((getCreateGameServerDeploymentMethod =
            GameServerDeploymentsServiceGrpc.getCreateGameServerDeploymentMethod)
        == null) {
      synchronized (GameServerDeploymentsServiceGrpc.class) {
        if ((getCreateGameServerDeploymentMethod =
                GameServerDeploymentsServiceGrpc.getCreateGameServerDeploymentMethod)
            == null) {
          GameServerDeploymentsServiceGrpc.getCreateGameServerDeploymentMethod =
              getCreateGameServerDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.CreateGameServerDeploymentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerDeploymentsService",
                              "CreateGameServerDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.CreateGameServerDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerDeploymentsServiceMethodDescriptorSupplier(
                              "CreateGameServerDeployment"))
                      .build();
        }
      }
    }
    return getCreateGameServerDeploymentMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteGameServerDeploymentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteGameServerDeploymentRequest,
          com.google.longrunning.Operation>
      METHOD_DELETE_GAME_SERVER_DEPLOYMENT = getDeleteGameServerDeploymentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteGameServerDeploymentRequest,
          com.google.longrunning.Operation>
      getDeleteGameServerDeploymentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteGameServerDeploymentRequest,
          com.google.longrunning.Operation>
      getDeleteGameServerDeploymentMethod() {
    return getDeleteGameServerDeploymentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteGameServerDeploymentRequest,
          com.google.longrunning.Operation>
      getDeleteGameServerDeploymentMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.DeleteGameServerDeploymentRequest,
            com.google.longrunning.Operation>
        getDeleteGameServerDeploymentMethod;
    if ((getDeleteGameServerDeploymentMethod =
            GameServerDeploymentsServiceGrpc.getDeleteGameServerDeploymentMethod)
        == null) {
      synchronized (GameServerDeploymentsServiceGrpc.class) {
        if ((getDeleteGameServerDeploymentMethod =
                GameServerDeploymentsServiceGrpc.getDeleteGameServerDeploymentMethod)
            == null) {
          GameServerDeploymentsServiceGrpc.getDeleteGameServerDeploymentMethod =
              getDeleteGameServerDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.DeleteGameServerDeploymentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerDeploymentsService",
                              "DeleteGameServerDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.DeleteGameServerDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerDeploymentsServiceMethodDescriptorSupplier(
                              "DeleteGameServerDeployment"))
                      .build();
        }
      }
    }
    return getDeleteGameServerDeploymentMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateGameServerDeploymentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRequest,
          com.google.longrunning.Operation>
      METHOD_UPDATE_GAME_SERVER_DEPLOYMENT = getUpdateGameServerDeploymentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRequest,
          com.google.longrunning.Operation>
      getUpdateGameServerDeploymentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRequest,
          com.google.longrunning.Operation>
      getUpdateGameServerDeploymentMethod() {
    return getUpdateGameServerDeploymentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRequest,
          com.google.longrunning.Operation>
      getUpdateGameServerDeploymentMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRequest,
            com.google.longrunning.Operation>
        getUpdateGameServerDeploymentMethod;
    if ((getUpdateGameServerDeploymentMethod =
            GameServerDeploymentsServiceGrpc.getUpdateGameServerDeploymentMethod)
        == null) {
      synchronized (GameServerDeploymentsServiceGrpc.class) {
        if ((getUpdateGameServerDeploymentMethod =
                GameServerDeploymentsServiceGrpc.getUpdateGameServerDeploymentMethod)
            == null) {
          GameServerDeploymentsServiceGrpc.getUpdateGameServerDeploymentMethod =
              getUpdateGameServerDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerDeploymentsService",
                              "UpdateGameServerDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerDeploymentsServiceMethodDescriptorSupplier(
                              "UpdateGameServerDeployment"))
                      .build();
        }
      }
    }
    return getUpdateGameServerDeploymentMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetGameServerDeploymentRolloutMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRolloutRequest,
          com.google.cloud.gaming.v1alpha.GameServerDeploymentRollout>
      METHOD_GET_GAME_SERVER_DEPLOYMENT_ROLLOUT = getGetGameServerDeploymentRolloutMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRolloutRequest,
          com.google.cloud.gaming.v1alpha.GameServerDeploymentRollout>
      getGetGameServerDeploymentRolloutMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRolloutRequest,
          com.google.cloud.gaming.v1alpha.GameServerDeploymentRollout>
      getGetGameServerDeploymentRolloutMethod() {
    return getGetGameServerDeploymentRolloutMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRolloutRequest,
          com.google.cloud.gaming.v1alpha.GameServerDeploymentRollout>
      getGetGameServerDeploymentRolloutMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRolloutRequest,
            com.google.cloud.gaming.v1alpha.GameServerDeploymentRollout>
        getGetGameServerDeploymentRolloutMethod;
    if ((getGetGameServerDeploymentRolloutMethod =
            GameServerDeploymentsServiceGrpc.getGetGameServerDeploymentRolloutMethod)
        == null) {
      synchronized (GameServerDeploymentsServiceGrpc.class) {
        if ((getGetGameServerDeploymentRolloutMethod =
                GameServerDeploymentsServiceGrpc.getGetGameServerDeploymentRolloutMethod)
            == null) {
          GameServerDeploymentsServiceGrpc.getGetGameServerDeploymentRolloutMethod =
              getGetGameServerDeploymentRolloutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRolloutRequest,
                          com.google.cloud.gaming.v1alpha.GameServerDeploymentRollout>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerDeploymentsService",
                              "GetGameServerDeploymentRollout"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRolloutRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.GameServerDeploymentRollout
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerDeploymentsServiceMethodDescriptorSupplier(
                              "GetGameServerDeploymentRollout"))
                      .build();
        }
      }
    }
    return getGetGameServerDeploymentRolloutMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateGameServerDeploymentRolloutMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRolloutRequest,
          com.google.longrunning.Operation>
      METHOD_UPDATE_GAME_SERVER_DEPLOYMENT_ROLLOUT =
          getUpdateGameServerDeploymentRolloutMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRolloutRequest,
          com.google.longrunning.Operation>
      getUpdateGameServerDeploymentRolloutMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRolloutRequest,
          com.google.longrunning.Operation>
      getUpdateGameServerDeploymentRolloutMethod() {
    return getUpdateGameServerDeploymentRolloutMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRolloutRequest,
          com.google.longrunning.Operation>
      getUpdateGameServerDeploymentRolloutMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRolloutRequest,
            com.google.longrunning.Operation>
        getUpdateGameServerDeploymentRolloutMethod;
    if ((getUpdateGameServerDeploymentRolloutMethod =
            GameServerDeploymentsServiceGrpc.getUpdateGameServerDeploymentRolloutMethod)
        == null) {
      synchronized (GameServerDeploymentsServiceGrpc.class) {
        if ((getUpdateGameServerDeploymentRolloutMethod =
                GameServerDeploymentsServiceGrpc.getUpdateGameServerDeploymentRolloutMethod)
            == null) {
          GameServerDeploymentsServiceGrpc.getUpdateGameServerDeploymentRolloutMethod =
              getUpdateGameServerDeploymentRolloutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRolloutRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerDeploymentsService",
                              "UpdateGameServerDeploymentRollout"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha
                                  .UpdateGameServerDeploymentRolloutRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerDeploymentsServiceMethodDescriptorSupplier(
                              "UpdateGameServerDeploymentRollout"))
                      .build();
        }
      }
    }
    return getUpdateGameServerDeploymentRolloutMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPreviewGameServerDeploymentRolloutMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutRequest,
          com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutResponse>
      METHOD_PREVIEW_GAME_SERVER_DEPLOYMENT_ROLLOUT =
          getPreviewGameServerDeploymentRolloutMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutRequest,
          com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutResponse>
      getPreviewGameServerDeploymentRolloutMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutRequest,
          com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutResponse>
      getPreviewGameServerDeploymentRolloutMethod() {
    return getPreviewGameServerDeploymentRolloutMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutRequest,
          com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutResponse>
      getPreviewGameServerDeploymentRolloutMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutRequest,
            com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutResponse>
        getPreviewGameServerDeploymentRolloutMethod;
    if ((getPreviewGameServerDeploymentRolloutMethod =
            GameServerDeploymentsServiceGrpc.getPreviewGameServerDeploymentRolloutMethod)
        == null) {
      synchronized (GameServerDeploymentsServiceGrpc.class) {
        if ((getPreviewGameServerDeploymentRolloutMethod =
                GameServerDeploymentsServiceGrpc.getPreviewGameServerDeploymentRolloutMethod)
            == null) {
          GameServerDeploymentsServiceGrpc.getPreviewGameServerDeploymentRolloutMethod =
              getPreviewGameServerDeploymentRolloutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutRequest,
                          com.google.cloud.gaming.v1alpha
                              .PreviewGameServerDeploymentRolloutResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerDeploymentsService",
                              "PreviewGameServerDeploymentRollout"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha
                                  .PreviewGameServerDeploymentRolloutRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha
                                  .PreviewGameServerDeploymentRolloutResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerDeploymentsServiceMethodDescriptorSupplier(
                              "PreviewGameServerDeploymentRollout"))
                      .build();
        }
      }
    }
    return getPreviewGameServerDeploymentRolloutMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getFetchDeploymentStateMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.FetchDeploymentStateRequest,
          com.google.cloud.gaming.v1alpha.FetchDeploymentStateResponse>
      METHOD_FETCH_DEPLOYMENT_STATE = getFetchDeploymentStateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.FetchDeploymentStateRequest,
          com.google.cloud.gaming.v1alpha.FetchDeploymentStateResponse>
      getFetchDeploymentStateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.FetchDeploymentStateRequest,
          com.google.cloud.gaming.v1alpha.FetchDeploymentStateResponse>
      getFetchDeploymentStateMethod() {
    return getFetchDeploymentStateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.FetchDeploymentStateRequest,
          com.google.cloud.gaming.v1alpha.FetchDeploymentStateResponse>
      getFetchDeploymentStateMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.FetchDeploymentStateRequest,
            com.google.cloud.gaming.v1alpha.FetchDeploymentStateResponse>
        getFetchDeploymentStateMethod;
    if ((getFetchDeploymentStateMethod =
            GameServerDeploymentsServiceGrpc.getFetchDeploymentStateMethod)
        == null) {
      synchronized (GameServerDeploymentsServiceGrpc.class) {
        if ((getFetchDeploymentStateMethod =
                GameServerDeploymentsServiceGrpc.getFetchDeploymentStateMethod)
            == null) {
          GameServerDeploymentsServiceGrpc.getFetchDeploymentStateMethod =
              getFetchDeploymentStateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.FetchDeploymentStateRequest,
                          com.google.cloud.gaming.v1alpha.FetchDeploymentStateResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerDeploymentsService",
                              "FetchDeploymentState"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.FetchDeploymentStateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.FetchDeploymentStateResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerDeploymentsServiceMethodDescriptorSupplier(
                              "FetchDeploymentState"))
                      .build();
        }
      }
    }
    return getFetchDeploymentStateMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GameServerDeploymentsServiceStub newStub(io.grpc.Channel channel) {
    return new GameServerDeploymentsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GameServerDeploymentsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new GameServerDeploymentsServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GameServerDeploymentsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new GameServerDeploymentsServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * The game server deployment is used to control the deployment of game server
   * software to Agones fleets.
   * </pre>
   */
  public abstract static class GameServerDeploymentsServiceImplBase
      implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists game server deployments in a given project and location.
     * </pre>
     */
    public void listGameServerDeployments(
        com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListGameServerDeploymentsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single game server deployment.
     * </pre>
     */
    public void getGameServerDeployment(
        com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.GameServerDeployment>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetGameServerDeploymentMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new game server deployment in a given project and location.
     * </pre>
     */
    public void createGameServerDeployment(
        com.google.cloud.gaming.v1alpha.CreateGameServerDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateGameServerDeploymentMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single game server deployment.
     * </pre>
     */
    public void deleteGameServerDeployment(
        com.google.cloud.gaming.v1alpha.DeleteGameServerDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGameServerDeploymentMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Patches a game server deployment.
     * </pre>
     */
    public void updateGameServerDeployment(
        com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGameServerDeploymentMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details a single game server deployment rollout.
     * </pre>
     */
    public void getGameServerDeploymentRollout(
        com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.GameServerDeploymentRollout>
            responseObserver) {
      asyncUnimplementedUnaryCall(
          getGetGameServerDeploymentRolloutMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Patches a single game server deployment rollout.
     * </pre>
     */
    public void updateGameServerDeploymentRollout(
        com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(
          getUpdateGameServerDeploymentRolloutMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Previews the game server deployment rollout. This API does not mutate the
     * rollout resource.
     * </pre>
     */
    public void previewGameServerDeploymentRollout(
        com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(
          getPreviewGameServerDeploymentRolloutMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves information about the current state of the deployment, e.g. it
     * gathers all the fleets and autoscalars for this deployment.
     * This includes fleets running older version of the deployment.
     * </pre>
     */
    public void fetchDeploymentState(
        com.google.cloud.gaming.v1alpha.FetchDeploymentStateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.FetchDeploymentStateResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getFetchDeploymentStateMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListGameServerDeploymentsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsRequest,
                      com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsResponse>(
                      this, METHODID_LIST_GAME_SERVER_DEPLOYMENTS)))
          .addMethod(
              getGetGameServerDeploymentMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRequest,
                      com.google.cloud.gaming.v1alpha.GameServerDeployment>(
                      this, METHODID_GET_GAME_SERVER_DEPLOYMENT)))
          .addMethod(
              getCreateGameServerDeploymentMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.CreateGameServerDeploymentRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_CREATE_GAME_SERVER_DEPLOYMENT)))
          .addMethod(
              getDeleteGameServerDeploymentMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.DeleteGameServerDeploymentRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_DELETE_GAME_SERVER_DEPLOYMENT)))
          .addMethod(
              getUpdateGameServerDeploymentMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_UPDATE_GAME_SERVER_DEPLOYMENT)))
          .addMethod(
              getGetGameServerDeploymentRolloutMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRolloutRequest,
                      com.google.cloud.gaming.v1alpha.GameServerDeploymentRollout>(
                      this, METHODID_GET_GAME_SERVER_DEPLOYMENT_ROLLOUT)))
          .addMethod(
              getUpdateGameServerDeploymentRolloutMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRolloutRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_UPDATE_GAME_SERVER_DEPLOYMENT_ROLLOUT)))
          .addMethod(
              getPreviewGameServerDeploymentRolloutMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutRequest,
                      com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutResponse>(
                      this, METHODID_PREVIEW_GAME_SERVER_DEPLOYMENT_ROLLOUT)))
          .addMethod(
              getFetchDeploymentStateMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.FetchDeploymentStateRequest,
                      com.google.cloud.gaming.v1alpha.FetchDeploymentStateResponse>(
                      this, METHODID_FETCH_DEPLOYMENT_STATE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The game server deployment is used to control the deployment of game server
   * software to Agones fleets.
   * </pre>
   */
  public static final class GameServerDeploymentsServiceStub
      extends io.grpc.stub.AbstractStub<GameServerDeploymentsServiceStub> {
    private GameServerDeploymentsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GameServerDeploymentsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServerDeploymentsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameServerDeploymentsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists game server deployments in a given project and location.
     * </pre>
     */
    public void listGameServerDeployments(
        com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListGameServerDeploymentsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single game server deployment.
     * </pre>
     */
    public void getGameServerDeployment(
        com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.GameServerDeployment>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetGameServerDeploymentMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new game server deployment in a given project and location.
     * </pre>
     */
    public void createGameServerDeployment(
        com.google.cloud.gaming.v1alpha.CreateGameServerDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateGameServerDeploymentMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single game server deployment.
     * </pre>
     */
    public void deleteGameServerDeployment(
        com.google.cloud.gaming.v1alpha.DeleteGameServerDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGameServerDeploymentMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Patches a game server deployment.
     * </pre>
     */
    public void updateGameServerDeployment(
        com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGameServerDeploymentMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details a single game server deployment rollout.
     * </pre>
     */
    public void getGameServerDeploymentRollout(
        com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.GameServerDeploymentRollout>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetGameServerDeploymentRolloutMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Patches a single game server deployment rollout.
     * </pre>
     */
    public void updateGameServerDeploymentRollout(
        com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel()
              .newCall(getUpdateGameServerDeploymentRolloutMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Previews the game server deployment rollout. This API does not mutate the
     * rollout resource.
     * </pre>
     */
    public void previewGameServerDeploymentRollout(
        com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel()
              .newCall(getPreviewGameServerDeploymentRolloutMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves information about the current state of the deployment, e.g. it
     * gathers all the fleets and autoscalars for this deployment.
     * This includes fleets running older version of the deployment.
     * </pre>
     */
    public void fetchDeploymentState(
        com.google.cloud.gaming.v1alpha.FetchDeploymentStateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.FetchDeploymentStateResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFetchDeploymentStateMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The game server deployment is used to control the deployment of game server
   * software to Agones fleets.
   * </pre>
   */
  public static final class GameServerDeploymentsServiceBlockingStub
      extends io.grpc.stub.AbstractStub<GameServerDeploymentsServiceBlockingStub> {
    private GameServerDeploymentsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GameServerDeploymentsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServerDeploymentsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameServerDeploymentsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists game server deployments in a given project and location.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsResponse
        listGameServerDeployments(
            com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListGameServerDeploymentsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single game server deployment.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.GameServerDeployment getGameServerDeployment(
        com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetGameServerDeploymentMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new game server deployment in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createGameServerDeployment(
        com.google.cloud.gaming.v1alpha.CreateGameServerDeploymentRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateGameServerDeploymentMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single game server deployment.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGameServerDeployment(
        com.google.cloud.gaming.v1alpha.DeleteGameServerDeploymentRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGameServerDeploymentMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Patches a game server deployment.
     * </pre>
     */
    public com.google.longrunning.Operation updateGameServerDeployment(
        com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGameServerDeploymentMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details a single game server deployment rollout.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.GameServerDeploymentRollout
        getGameServerDeploymentRollout(
            com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRolloutRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetGameServerDeploymentRolloutMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Patches a single game server deployment rollout.
     * </pre>
     */
    public com.google.longrunning.Operation updateGameServerDeploymentRollout(
        com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRolloutRequest request) {
      return blockingUnaryCall(
          getChannel(),
          getUpdateGameServerDeploymentRolloutMethodHelper(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Previews the game server deployment rollout. This API does not mutate the
     * rollout resource.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutResponse
        previewGameServerDeploymentRollout(
            com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutRequest request) {
      return blockingUnaryCall(
          getChannel(),
          getPreviewGameServerDeploymentRolloutMethodHelper(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves information about the current state of the deployment, e.g. it
     * gathers all the fleets and autoscalars for this deployment.
     * This includes fleets running older version of the deployment.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.FetchDeploymentStateResponse fetchDeploymentState(
        com.google.cloud.gaming.v1alpha.FetchDeploymentStateRequest request) {
      return blockingUnaryCall(
          getChannel(), getFetchDeploymentStateMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The game server deployment is used to control the deployment of game server
   * software to Agones fleets.
   * </pre>
   */
  public static final class GameServerDeploymentsServiceFutureStub
      extends io.grpc.stub.AbstractStub<GameServerDeploymentsServiceFutureStub> {
    private GameServerDeploymentsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GameServerDeploymentsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServerDeploymentsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameServerDeploymentsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists game server deployments in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsResponse>
        listGameServerDeployments(
            com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListGameServerDeploymentsMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single game server deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.GameServerDeployment>
        getGameServerDeployment(
            com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetGameServerDeploymentMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new game server deployment in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createGameServerDeployment(
            com.google.cloud.gaming.v1alpha.CreateGameServerDeploymentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateGameServerDeploymentMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single game server deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteGameServerDeployment(
            com.google.cloud.gaming.v1alpha.DeleteGameServerDeploymentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGameServerDeploymentMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Patches a game server deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateGameServerDeployment(
            com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGameServerDeploymentMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details a single game server deployment rollout.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.GameServerDeploymentRollout>
        getGameServerDeploymentRollout(
            com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRolloutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetGameServerDeploymentRolloutMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Patches a single game server deployment rollout.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateGameServerDeploymentRollout(
            com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRolloutRequest request) {
      return futureUnaryCall(
          getChannel()
              .newCall(getUpdateGameServerDeploymentRolloutMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Previews the game server deployment rollout. This API does not mutate the
     * rollout resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutResponse>
        previewGameServerDeploymentRollout(
            com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutRequest request) {
      return futureUnaryCall(
          getChannel()
              .newCall(getPreviewGameServerDeploymentRolloutMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves information about the current state of the deployment, e.g. it
     * gathers all the fleets and autoscalars for this deployment.
     * This includes fleets running older version of the deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.FetchDeploymentStateResponse>
        fetchDeploymentState(com.google.cloud.gaming.v1alpha.FetchDeploymentStateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFetchDeploymentStateMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_GAME_SERVER_DEPLOYMENTS = 0;
  private static final int METHODID_GET_GAME_SERVER_DEPLOYMENT = 1;
  private static final int METHODID_CREATE_GAME_SERVER_DEPLOYMENT = 2;
  private static final int METHODID_DELETE_GAME_SERVER_DEPLOYMENT = 3;
  private static final int METHODID_UPDATE_GAME_SERVER_DEPLOYMENT = 4;
  private static final int METHODID_GET_GAME_SERVER_DEPLOYMENT_ROLLOUT = 5;
  private static final int METHODID_UPDATE_GAME_SERVER_DEPLOYMENT_ROLLOUT = 6;
  private static final int METHODID_PREVIEW_GAME_SERVER_DEPLOYMENT_ROLLOUT = 7;
  private static final int METHODID_FETCH_DEPLOYMENT_STATE = 8;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GameServerDeploymentsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GameServerDeploymentsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_GAME_SERVER_DEPLOYMENTS:
          serviceImpl.listGameServerDeployments(
              (com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GAME_SERVER_DEPLOYMENT:
          serviceImpl.getGameServerDeployment(
              (com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.GameServerDeployment>)
                  responseObserver);
          break;
        case METHODID_CREATE_GAME_SERVER_DEPLOYMENT:
          serviceImpl.createGameServerDeployment(
              (com.google.cloud.gaming.v1alpha.CreateGameServerDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_GAME_SERVER_DEPLOYMENT:
          serviceImpl.deleteGameServerDeployment(
              (com.google.cloud.gaming.v1alpha.DeleteGameServerDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_GAME_SERVER_DEPLOYMENT:
          serviceImpl.updateGameServerDeployment(
              (com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_GAME_SERVER_DEPLOYMENT_ROLLOUT:
          serviceImpl.getGameServerDeploymentRollout(
              (com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRolloutRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gaming.v1alpha.GameServerDeploymentRollout>)
                  responseObserver);
          break;
        case METHODID_UPDATE_GAME_SERVER_DEPLOYMENT_ROLLOUT:
          serviceImpl.updateGameServerDeploymentRollout(
              (com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRolloutRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PREVIEW_GAME_SERVER_DEPLOYMENT_ROLLOUT:
          serviceImpl.previewGameServerDeploymentRollout(
              (com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gaming.v1alpha.PreviewGameServerDeploymentRolloutResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_DEPLOYMENT_STATE:
          serviceImpl.fetchDeploymentState(
              (com.google.cloud.gaming.v1alpha.FetchDeploymentStateRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gaming.v1alpha.FetchDeploymentStateResponse>)
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

  private abstract static class GameServerDeploymentsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GameServerDeploymentsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gaming.v1alpha.GameServerDeploymentsServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GameServerDeploymentsService");
    }
  }

  private static final class GameServerDeploymentsServiceFileDescriptorSupplier
      extends GameServerDeploymentsServiceBaseDescriptorSupplier {
    GameServerDeploymentsServiceFileDescriptorSupplier() {}
  }

  private static final class GameServerDeploymentsServiceMethodDescriptorSupplier
      extends GameServerDeploymentsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GameServerDeploymentsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (GameServerDeploymentsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GameServerDeploymentsServiceFileDescriptorSupplier())
                      .addMethod(getListGameServerDeploymentsMethodHelper())
                      .addMethod(getGetGameServerDeploymentMethodHelper())
                      .addMethod(getCreateGameServerDeploymentMethodHelper())
                      .addMethod(getDeleteGameServerDeploymentMethodHelper())
                      .addMethod(getUpdateGameServerDeploymentMethodHelper())
                      .addMethod(getGetGameServerDeploymentRolloutMethodHelper())
                      .addMethod(getUpdateGameServerDeploymentRolloutMethodHelper())
                      .addMethod(getPreviewGameServerDeploymentRolloutMethodHelper())
                      .addMethod(getFetchDeploymentStateMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
