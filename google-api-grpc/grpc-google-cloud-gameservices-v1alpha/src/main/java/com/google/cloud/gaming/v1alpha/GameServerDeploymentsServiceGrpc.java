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
 * The game server deployment is used to configure the deployment of game server
 * software to Agones Fleets in game server clusters.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/gaming/v1alpha/game_server_deployments.proto")
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
  @java.lang.Deprecated // Use {@link #getStartRolloutMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.StartRolloutRequest, com.google.longrunning.Operation>
      METHOD_START_ROLLOUT = getStartRolloutMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.StartRolloutRequest, com.google.longrunning.Operation>
      getStartRolloutMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.StartRolloutRequest, com.google.longrunning.Operation>
      getStartRolloutMethod() {
    return getStartRolloutMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.StartRolloutRequest, com.google.longrunning.Operation>
      getStartRolloutMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.StartRolloutRequest, com.google.longrunning.Operation>
        getStartRolloutMethod;
    if ((getStartRolloutMethod = GameServerDeploymentsServiceGrpc.getStartRolloutMethod) == null) {
      synchronized (GameServerDeploymentsServiceGrpc.class) {
        if ((getStartRolloutMethod = GameServerDeploymentsServiceGrpc.getStartRolloutMethod)
            == null) {
          GameServerDeploymentsServiceGrpc.getStartRolloutMethod =
              getStartRolloutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.StartRolloutRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerDeploymentsService",
                              "StartRollout"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.StartRolloutRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerDeploymentsServiceMethodDescriptorSupplier("StartRollout"))
                      .build();
        }
      }
    }
    return getStartRolloutMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetRolloutTargetMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.SetRolloutTargetRequest, com.google.longrunning.Operation>
      METHOD_SET_ROLLOUT_TARGET = getSetRolloutTargetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.SetRolloutTargetRequest, com.google.longrunning.Operation>
      getSetRolloutTargetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.SetRolloutTargetRequest, com.google.longrunning.Operation>
      getSetRolloutTargetMethod() {
    return getSetRolloutTargetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.SetRolloutTargetRequest, com.google.longrunning.Operation>
      getSetRolloutTargetMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.SetRolloutTargetRequest,
            com.google.longrunning.Operation>
        getSetRolloutTargetMethod;
    if ((getSetRolloutTargetMethod = GameServerDeploymentsServiceGrpc.getSetRolloutTargetMethod)
        == null) {
      synchronized (GameServerDeploymentsServiceGrpc.class) {
        if ((getSetRolloutTargetMethod = GameServerDeploymentsServiceGrpc.getSetRolloutTargetMethod)
            == null) {
          GameServerDeploymentsServiceGrpc.getSetRolloutTargetMethod =
              getSetRolloutTargetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.SetRolloutTargetRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerDeploymentsService",
                              "SetRolloutTarget"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.SetRolloutTargetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerDeploymentsServiceMethodDescriptorSupplier(
                              "SetRolloutTarget"))
                      .build();
        }
      }
    }
    return getSetRolloutTargetMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCommitRolloutMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CommitRolloutRequest, com.google.longrunning.Operation>
      METHOD_COMMIT_ROLLOUT = getCommitRolloutMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CommitRolloutRequest, com.google.longrunning.Operation>
      getCommitRolloutMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CommitRolloutRequest, com.google.longrunning.Operation>
      getCommitRolloutMethod() {
    return getCommitRolloutMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CommitRolloutRequest, com.google.longrunning.Operation>
      getCommitRolloutMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.CommitRolloutRequest, com.google.longrunning.Operation>
        getCommitRolloutMethod;
    if ((getCommitRolloutMethod = GameServerDeploymentsServiceGrpc.getCommitRolloutMethod)
        == null) {
      synchronized (GameServerDeploymentsServiceGrpc.class) {
        if ((getCommitRolloutMethod = GameServerDeploymentsServiceGrpc.getCommitRolloutMethod)
            == null) {
          GameServerDeploymentsServiceGrpc.getCommitRolloutMethod =
              getCommitRolloutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.CommitRolloutRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerDeploymentsService",
                              "CommitRollout"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.CommitRolloutRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerDeploymentsServiceMethodDescriptorSupplier("CommitRollout"))
                      .build();
        }
      }
    }
    return getCommitRolloutMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRevertRolloutMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.RevertRolloutRequest, com.google.longrunning.Operation>
      METHOD_REVERT_ROLLOUT = getRevertRolloutMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.RevertRolloutRequest, com.google.longrunning.Operation>
      getRevertRolloutMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.RevertRolloutRequest, com.google.longrunning.Operation>
      getRevertRolloutMethod() {
    return getRevertRolloutMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.RevertRolloutRequest, com.google.longrunning.Operation>
      getRevertRolloutMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.RevertRolloutRequest, com.google.longrunning.Operation>
        getRevertRolloutMethod;
    if ((getRevertRolloutMethod = GameServerDeploymentsServiceGrpc.getRevertRolloutMethod)
        == null) {
      synchronized (GameServerDeploymentsServiceGrpc.class) {
        if ((getRevertRolloutMethod = GameServerDeploymentsServiceGrpc.getRevertRolloutMethod)
            == null) {
          GameServerDeploymentsServiceGrpc.getRevertRolloutMethod =
              getRevertRolloutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.RevertRolloutRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerDeploymentsService",
                              "RevertRollout"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.RevertRolloutRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerDeploymentsServiceMethodDescriptorSupplier("RevertRollout"))
                      .build();
        }
      }
    }
    return getRevertRolloutMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetDeploymentTargetMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetDeploymentTargetRequest,
          com.google.cloud.gaming.v1alpha.DeploymentTarget>
      METHOD_GET_DEPLOYMENT_TARGET = getGetDeploymentTargetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetDeploymentTargetRequest,
          com.google.cloud.gaming.v1alpha.DeploymentTarget>
      getGetDeploymentTargetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetDeploymentTargetRequest,
          com.google.cloud.gaming.v1alpha.DeploymentTarget>
      getGetDeploymentTargetMethod() {
    return getGetDeploymentTargetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetDeploymentTargetRequest,
          com.google.cloud.gaming.v1alpha.DeploymentTarget>
      getGetDeploymentTargetMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.GetDeploymentTargetRequest,
            com.google.cloud.gaming.v1alpha.DeploymentTarget>
        getGetDeploymentTargetMethod;
    if ((getGetDeploymentTargetMethod =
            GameServerDeploymentsServiceGrpc.getGetDeploymentTargetMethod)
        == null) {
      synchronized (GameServerDeploymentsServiceGrpc.class) {
        if ((getGetDeploymentTargetMethod =
                GameServerDeploymentsServiceGrpc.getGetDeploymentTargetMethod)
            == null) {
          GameServerDeploymentsServiceGrpc.getGetDeploymentTargetMethod =
              getGetDeploymentTargetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.GetDeploymentTargetRequest,
                          com.google.cloud.gaming.v1alpha.DeploymentTarget>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.GameServerDeploymentsService",
                              "GetDeploymentTarget"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.GetDeploymentTargetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.DeploymentTarget
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GameServerDeploymentsServiceMethodDescriptorSupplier(
                              "GetDeploymentTarget"))
                      .build();
        }
      }
    }
    return getGetDeploymentTargetMethod;
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
   * The game server deployment is used to configure the deployment of game server
   * software to Agones Fleets in game server clusters.
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
     * Starts rollout of this game server deployment based on the given game
     * server template.
     * </pre>
     */
    public void startRollout(
        com.google.cloud.gaming.v1alpha.StartRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getStartRolloutMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets rollout target for the ongoing game server deployment rollout in the
     * specified clusters and based on the given rollout percentage. Default is 0.
     * </pre>
     */
    public void setRolloutTarget(
        com.google.cloud.gaming.v1alpha.SetRolloutTargetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getSetRolloutTargetMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Commits the ongoing game server deployment rollout by setting the rollout
     * percentage to 100 in all clusters whose labels match labels in the game
     * server template.
     * </pre>
     */
    public void commitRollout(
        com.google.cloud.gaming.v1alpha.CommitRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCommitRolloutMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rolls back the ongoing game server deployment rollout by setting the
     * rollout percentage to 0 in all clusters whose labels match labels in the
     * game server template.
     * </pre>
     */
    public void revertRollout(
        com.google.cloud.gaming.v1alpha.RevertRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getRevertRolloutMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves information on the rollout target of the deployment, e.g. the
     * target percentage of game servers running stable_game_server_template and
     * new_game_server_template in clusters.
     * </pre>
     */
    public void getDeploymentTarget(
        com.google.cloud.gaming.v1alpha.GetDeploymentTargetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.DeploymentTarget>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetDeploymentTargetMethodHelper(), responseObserver);
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
              getStartRolloutMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.StartRolloutRequest,
                      com.google.longrunning.Operation>(this, METHODID_START_ROLLOUT)))
          .addMethod(
              getSetRolloutTargetMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.SetRolloutTargetRequest,
                      com.google.longrunning.Operation>(this, METHODID_SET_ROLLOUT_TARGET)))
          .addMethod(
              getCommitRolloutMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.CommitRolloutRequest,
                      com.google.longrunning.Operation>(this, METHODID_COMMIT_ROLLOUT)))
          .addMethod(
              getRevertRolloutMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.RevertRolloutRequest,
                      com.google.longrunning.Operation>(this, METHODID_REVERT_ROLLOUT)))
          .addMethod(
              getGetDeploymentTargetMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.GetDeploymentTargetRequest,
                      com.google.cloud.gaming.v1alpha.DeploymentTarget>(
                      this, METHODID_GET_DEPLOYMENT_TARGET)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The game server deployment is used to configure the deployment of game server
   * software to Agones Fleets in game server clusters.
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
     * Starts rollout of this game server deployment based on the given game
     * server template.
     * </pre>
     */
    public void startRollout(
        com.google.cloud.gaming.v1alpha.StartRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStartRolloutMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets rollout target for the ongoing game server deployment rollout in the
     * specified clusters and based on the given rollout percentage. Default is 0.
     * </pre>
     */
    public void setRolloutTarget(
        com.google.cloud.gaming.v1alpha.SetRolloutTargetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetRolloutTargetMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Commits the ongoing game server deployment rollout by setting the rollout
     * percentage to 100 in all clusters whose labels match labels in the game
     * server template.
     * </pre>
     */
    public void commitRollout(
        com.google.cloud.gaming.v1alpha.CommitRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCommitRolloutMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rolls back the ongoing game server deployment rollout by setting the
     * rollout percentage to 0 in all clusters whose labels match labels in the
     * game server template.
     * </pre>
     */
    public void revertRollout(
        com.google.cloud.gaming.v1alpha.RevertRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRevertRolloutMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves information on the rollout target of the deployment, e.g. the
     * target percentage of game servers running stable_game_server_template and
     * new_game_server_template in clusters.
     * </pre>
     */
    public void getDeploymentTarget(
        com.google.cloud.gaming.v1alpha.GetDeploymentTargetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.DeploymentTarget>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDeploymentTargetMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The game server deployment is used to configure the deployment of game server
   * software to Agones Fleets in game server clusters.
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
     * Starts rollout of this game server deployment based on the given game
     * server template.
     * </pre>
     */
    public com.google.longrunning.Operation startRollout(
        com.google.cloud.gaming.v1alpha.StartRolloutRequest request) {
      return blockingUnaryCall(
          getChannel(), getStartRolloutMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets rollout target for the ongoing game server deployment rollout in the
     * specified clusters and based on the given rollout percentage. Default is 0.
     * </pre>
     */
    public com.google.longrunning.Operation setRolloutTarget(
        com.google.cloud.gaming.v1alpha.SetRolloutTargetRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetRolloutTargetMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Commits the ongoing game server deployment rollout by setting the rollout
     * percentage to 100 in all clusters whose labels match labels in the game
     * server template.
     * </pre>
     */
    public com.google.longrunning.Operation commitRollout(
        com.google.cloud.gaming.v1alpha.CommitRolloutRequest request) {
      return blockingUnaryCall(
          getChannel(), getCommitRolloutMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back the ongoing game server deployment rollout by setting the
     * rollout percentage to 0 in all clusters whose labels match labels in the
     * game server template.
     * </pre>
     */
    public com.google.longrunning.Operation revertRollout(
        com.google.cloud.gaming.v1alpha.RevertRolloutRequest request) {
      return blockingUnaryCall(
          getChannel(), getRevertRolloutMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves information on the rollout target of the deployment, e.g. the
     * target percentage of game servers running stable_game_server_template and
     * new_game_server_template in clusters.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.DeploymentTarget getDeploymentTarget(
        com.google.cloud.gaming.v1alpha.GetDeploymentTargetRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDeploymentTargetMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The game server deployment is used to configure the deployment of game server
   * software to Agones Fleets in game server clusters.
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
     * Starts rollout of this game server deployment based on the given game
     * server template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        startRollout(com.google.cloud.gaming.v1alpha.StartRolloutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStartRolloutMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets rollout target for the ongoing game server deployment rollout in the
     * specified clusters and based on the given rollout percentage. Default is 0.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        setRolloutTarget(com.google.cloud.gaming.v1alpha.SetRolloutTargetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetRolloutTargetMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Commits the ongoing game server deployment rollout by setting the rollout
     * percentage to 100 in all clusters whose labels match labels in the game
     * server template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        commitRollout(com.google.cloud.gaming.v1alpha.CommitRolloutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCommitRolloutMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Rolls back the ongoing game server deployment rollout by setting the
     * rollout percentage to 0 in all clusters whose labels match labels in the
     * game server template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        revertRollout(com.google.cloud.gaming.v1alpha.RevertRolloutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRevertRolloutMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves information on the rollout target of the deployment, e.g. the
     * target percentage of game servers running stable_game_server_template and
     * new_game_server_template in clusters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.DeploymentTarget>
        getDeploymentTarget(com.google.cloud.gaming.v1alpha.GetDeploymentTargetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDeploymentTargetMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_GAME_SERVER_DEPLOYMENTS = 0;
  private static final int METHODID_GET_GAME_SERVER_DEPLOYMENT = 1;
  private static final int METHODID_CREATE_GAME_SERVER_DEPLOYMENT = 2;
  private static final int METHODID_DELETE_GAME_SERVER_DEPLOYMENT = 3;
  private static final int METHODID_UPDATE_GAME_SERVER_DEPLOYMENT = 4;
  private static final int METHODID_START_ROLLOUT = 5;
  private static final int METHODID_SET_ROLLOUT_TARGET = 6;
  private static final int METHODID_COMMIT_ROLLOUT = 7;
  private static final int METHODID_REVERT_ROLLOUT = 8;
  private static final int METHODID_GET_DEPLOYMENT_TARGET = 9;

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
        case METHODID_START_ROLLOUT:
          serviceImpl.startRollout(
              (com.google.cloud.gaming.v1alpha.StartRolloutRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SET_ROLLOUT_TARGET:
          serviceImpl.setRolloutTarget(
              (com.google.cloud.gaming.v1alpha.SetRolloutTargetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_COMMIT_ROLLOUT:
          serviceImpl.commitRollout(
              (com.google.cloud.gaming.v1alpha.CommitRolloutRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REVERT_ROLLOUT:
          serviceImpl.revertRollout(
              (com.google.cloud.gaming.v1alpha.RevertRolloutRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_DEPLOYMENT_TARGET:
          serviceImpl.getDeploymentTarget(
              (com.google.cloud.gaming.v1alpha.GetDeploymentTargetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.DeploymentTarget>)
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
      return com.google.cloud.gaming.v1alpha.GameServerDeployments.getDescriptor();
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
                      .addMethod(getStartRolloutMethodHelper())
                      .addMethod(getSetRolloutTargetMethodHelper())
                      .addMethod(getCommitRolloutMethodHelper())
                      .addMethod(getRevertRolloutMethodHelper())
                      .addMethod(getGetDeploymentTargetMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
