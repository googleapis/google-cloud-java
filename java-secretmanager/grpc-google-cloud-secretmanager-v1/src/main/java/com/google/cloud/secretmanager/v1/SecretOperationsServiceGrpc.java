/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.secretmanager.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Secret Operations Service
 * Manages backups of secrets. Implements a REST model with the following
 * objects:
 * * [Backup][google.cloud.secretmanager.v1.Backup]
 * Note: `SecretOperationsService` is a regional service and must be called
 * using regional endpoints (`secretmanager.{location}.rep.googleapis.com`).
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SecretOperationsServiceGrpc {

  private SecretOperationsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.secretmanager.v1.SecretOperationsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.secretmanager.v1.ListBackupsRequest,
          com.google.cloud.secretmanager.v1.ListBackupsResponse>
      getListBackupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackups",
      requestType = com.google.cloud.secretmanager.v1.ListBackupsRequest.class,
      responseType = com.google.cloud.secretmanager.v1.ListBackupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.secretmanager.v1.ListBackupsRequest,
          com.google.cloud.secretmanager.v1.ListBackupsResponse>
      getListBackupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.secretmanager.v1.ListBackupsRequest,
            com.google.cloud.secretmanager.v1.ListBackupsResponse>
        getListBackupsMethod;
    if ((getListBackupsMethod = SecretOperationsServiceGrpc.getListBackupsMethod) == null) {
      synchronized (SecretOperationsServiceGrpc.class) {
        if ((getListBackupsMethod = SecretOperationsServiceGrpc.getListBackupsMethod) == null) {
          SecretOperationsServiceGrpc.getListBackupsMethod =
              getListBackupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.secretmanager.v1.ListBackupsRequest,
                          com.google.cloud.secretmanager.v1.ListBackupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.secretmanager.v1.ListBackupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.secretmanager.v1.ListBackupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecretOperationsServiceMethodDescriptorSupplier("ListBackups"))
                      .build();
        }
      }
    }
    return getListBackupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.secretmanager.v1.GetBackupRequest,
          com.google.cloud.secretmanager.v1.Backup>
      getGetBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackup",
      requestType = com.google.cloud.secretmanager.v1.GetBackupRequest.class,
      responseType = com.google.cloud.secretmanager.v1.Backup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.secretmanager.v1.GetBackupRequest,
          com.google.cloud.secretmanager.v1.Backup>
      getGetBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.secretmanager.v1.GetBackupRequest,
            com.google.cloud.secretmanager.v1.Backup>
        getGetBackupMethod;
    if ((getGetBackupMethod = SecretOperationsServiceGrpc.getGetBackupMethod) == null) {
      synchronized (SecretOperationsServiceGrpc.class) {
        if ((getGetBackupMethod = SecretOperationsServiceGrpc.getGetBackupMethod) == null) {
          SecretOperationsServiceGrpc.getGetBackupMethod =
              getGetBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.secretmanager.v1.GetBackupRequest,
                          com.google.cloud.secretmanager.v1.Backup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.secretmanager.v1.GetBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.secretmanager.v1.Backup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecretOperationsServiceMethodDescriptorSupplier("GetBackup"))
                      .build();
        }
      }
    }
    return getGetBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.secretmanager.v1.CreateBackupRequest, com.google.longrunning.Operation>
      getCreateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackup",
      requestType = com.google.cloud.secretmanager.v1.CreateBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.secretmanager.v1.CreateBackupRequest, com.google.longrunning.Operation>
      getCreateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.secretmanager.v1.CreateBackupRequest, com.google.longrunning.Operation>
        getCreateBackupMethod;
    if ((getCreateBackupMethod = SecretOperationsServiceGrpc.getCreateBackupMethod) == null) {
      synchronized (SecretOperationsServiceGrpc.class) {
        if ((getCreateBackupMethod = SecretOperationsServiceGrpc.getCreateBackupMethod) == null) {
          SecretOperationsServiceGrpc.getCreateBackupMethod =
              getCreateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.secretmanager.v1.CreateBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.secretmanager.v1.CreateBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecretOperationsServiceMethodDescriptorSupplier("CreateBackup"))
                      .build();
        }
      }
    }
    return getCreateBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.secretmanager.v1.UpdateBackupRequest, com.google.longrunning.Operation>
      getUpdateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackup",
      requestType = com.google.cloud.secretmanager.v1.UpdateBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.secretmanager.v1.UpdateBackupRequest, com.google.longrunning.Operation>
      getUpdateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.secretmanager.v1.UpdateBackupRequest, com.google.longrunning.Operation>
        getUpdateBackupMethod;
    if ((getUpdateBackupMethod = SecretOperationsServiceGrpc.getUpdateBackupMethod) == null) {
      synchronized (SecretOperationsServiceGrpc.class) {
        if ((getUpdateBackupMethod = SecretOperationsServiceGrpc.getUpdateBackupMethod) == null) {
          SecretOperationsServiceGrpc.getUpdateBackupMethod =
              getUpdateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.secretmanager.v1.UpdateBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.secretmanager.v1.UpdateBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecretOperationsServiceMethodDescriptorSupplier("UpdateBackup"))
                      .build();
        }
      }
    }
    return getUpdateBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.secretmanager.v1.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackup",
      requestType = com.google.cloud.secretmanager.v1.DeleteBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.secretmanager.v1.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.secretmanager.v1.DeleteBackupRequest, com.google.longrunning.Operation>
        getDeleteBackupMethod;
    if ((getDeleteBackupMethod = SecretOperationsServiceGrpc.getDeleteBackupMethod) == null) {
      synchronized (SecretOperationsServiceGrpc.class) {
        if ((getDeleteBackupMethod = SecretOperationsServiceGrpc.getDeleteBackupMethod) == null) {
          SecretOperationsServiceGrpc.getDeleteBackupMethod =
              getDeleteBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.secretmanager.v1.DeleteBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.secretmanager.v1.DeleteBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecretOperationsServiceMethodDescriptorSupplier("DeleteBackup"))
                      .build();
        }
      }
    }
    return getDeleteBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.secretmanager.v1.RestoreBackupRequest, com.google.longrunning.Operation>
      getRestoreBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreBackup",
      requestType = com.google.cloud.secretmanager.v1.RestoreBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.secretmanager.v1.RestoreBackupRequest, com.google.longrunning.Operation>
      getRestoreBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.secretmanager.v1.RestoreBackupRequest,
            com.google.longrunning.Operation>
        getRestoreBackupMethod;
    if ((getRestoreBackupMethod = SecretOperationsServiceGrpc.getRestoreBackupMethod) == null) {
      synchronized (SecretOperationsServiceGrpc.class) {
        if ((getRestoreBackupMethod = SecretOperationsServiceGrpc.getRestoreBackupMethod) == null) {
          SecretOperationsServiceGrpc.getRestoreBackupMethod =
              getRestoreBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.secretmanager.v1.RestoreBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestoreBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.secretmanager.v1.RestoreBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecretOperationsServiceMethodDescriptorSupplier("RestoreBackup"))
                      .build();
        }
      }
    }
    return getRestoreBackupMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SecretOperationsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecretOperationsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecretOperationsServiceStub>() {
          @java.lang.Override
          public SecretOperationsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecretOperationsServiceStub(channel, callOptions);
          }
        };
    return SecretOperationsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SecretOperationsServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecretOperationsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecretOperationsServiceBlockingV2Stub>() {
          @java.lang.Override
          public SecretOperationsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecretOperationsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SecretOperationsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecretOperationsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecretOperationsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecretOperationsServiceBlockingStub>() {
          @java.lang.Override
          public SecretOperationsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecretOperationsServiceBlockingStub(channel, callOptions);
          }
        };
    return SecretOperationsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SecretOperationsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecretOperationsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecretOperationsServiceFutureStub>() {
          @java.lang.Override
          public SecretOperationsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecretOperationsServiceFutureStub(channel, callOptions);
          }
        };
    return SecretOperationsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Secret Operations Service
   * Manages backups of secrets. Implements a REST model with the following
   * objects:
   * * [Backup][google.cloud.secretmanager.v1.Backup]
   * Note: `SecretOperationsService` is a regional service and must be called
   * using regional endpoints (`secretmanager.{location}.rep.googleapis.com`).
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Backups in a given project and location.
     * </pre>
     */
    default void listBackups(
        com.google.cloud.secretmanager.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.ListBackupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Backup.
     * </pre>
     */
    default void getBackup(
        com.google.cloud.secretmanager.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.Backup> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Backup in a given project and location.
     * </pre>
     */
    default void createBackup(
        com.google.cloud.secretmanager.v1.CreateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Backup.
     * </pre>
     */
    default void updateBackup(
        com.google.cloud.secretmanager.v1.UpdateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Backup.
     * </pre>
     */
    default void deleteBackup(
        com.google.cloud.secretmanager.v1.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores a [Secret][google.cloud.secretmanager.v1.Secret] from the given
     * [Backup][google.cloud.secretmanager.v1.Backup]. This creates a *new*
     * [Secret][google.cloud.secretmanager.v1.Secret] resource. The LRO tracks the
     * restoration process, and the result of the LRO is the newly created Secret.
     * </pre>
     */
    default void restoreBackup(
        com.google.cloud.secretmanager.v1.RestoreBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestoreBackupMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SecretOperationsService.
   *
   * <pre>
   * Secret Operations Service
   * Manages backups of secrets. Implements a REST model with the following
   * objects:
   * * [Backup][google.cloud.secretmanager.v1.Backup]
   * Note: `SecretOperationsService` is a regional service and must be called
   * using regional endpoints (`secretmanager.{location}.rep.googleapis.com`).
   * </pre>
   */
  public abstract static class SecretOperationsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SecretOperationsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SecretOperationsService.
   *
   * <pre>
   * Secret Operations Service
   * Manages backups of secrets. Implements a REST model with the following
   * objects:
   * * [Backup][google.cloud.secretmanager.v1.Backup]
   * Note: `SecretOperationsService` is a regional service and must be called
   * using regional endpoints (`secretmanager.{location}.rep.googleapis.com`).
   * </pre>
   */
  public static final class SecretOperationsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SecretOperationsServiceStub> {
    private SecretOperationsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecretOperationsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecretOperationsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Backups in a given project and location.
     * </pre>
     */
    public void listBackups(
        com.google.cloud.secretmanager.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.ListBackupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Backup.
     * </pre>
     */
    public void getBackup(
        com.google.cloud.secretmanager.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.Backup> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Backup in a given project and location.
     * </pre>
     */
    public void createBackup(
        com.google.cloud.secretmanager.v1.CreateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Backup.
     * </pre>
     */
    public void updateBackup(
        com.google.cloud.secretmanager.v1.UpdateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Backup.
     * </pre>
     */
    public void deleteBackup(
        com.google.cloud.secretmanager.v1.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores a [Secret][google.cloud.secretmanager.v1.Secret] from the given
     * [Backup][google.cloud.secretmanager.v1.Backup]. This creates a *new*
     * [Secret][google.cloud.secretmanager.v1.Secret] resource. The LRO tracks the
     * restoration process, and the result of the LRO is the newly created Secret.
     * </pre>
     */
    public void restoreBackup(
        com.google.cloud.secretmanager.v1.RestoreBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SecretOperationsService.
   *
   * <pre>
   * Secret Operations Service
   * Manages backups of secrets. Implements a REST model with the following
   * objects:
   * * [Backup][google.cloud.secretmanager.v1.Backup]
   * Note: `SecretOperationsService` is a regional service and must be called
   * using regional endpoints (`secretmanager.{location}.rep.googleapis.com`).
   * </pre>
   */
  public static final class SecretOperationsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SecretOperationsServiceBlockingV2Stub> {
    private SecretOperationsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecretOperationsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecretOperationsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Backups in a given project and location.
     * </pre>
     */
    public com.google.cloud.secretmanager.v1.ListBackupsResponse listBackups(
        com.google.cloud.secretmanager.v1.ListBackupsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Backup.
     * </pre>
     */
    public com.google.cloud.secretmanager.v1.Backup getBackup(
        com.google.cloud.secretmanager.v1.GetBackupRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Backup in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createBackup(
        com.google.cloud.secretmanager.v1.CreateBackupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Backup.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackup(
        com.google.cloud.secretmanager.v1.UpdateBackupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Backup.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackup(
        com.google.cloud.secretmanager.v1.DeleteBackupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restores a [Secret][google.cloud.secretmanager.v1.Secret] from the given
     * [Backup][google.cloud.secretmanager.v1.Backup]. This creates a *new*
     * [Secret][google.cloud.secretmanager.v1.Secret] resource. The LRO tracks the
     * restoration process, and the result of the LRO is the newly created Secret.
     * </pre>
     */
    public com.google.longrunning.Operation restoreBackup(
        com.google.cloud.secretmanager.v1.RestoreBackupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRestoreBackupMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SecretOperationsService.
   *
   * <pre>
   * Secret Operations Service
   * Manages backups of secrets. Implements a REST model with the following
   * objects:
   * * [Backup][google.cloud.secretmanager.v1.Backup]
   * Note: `SecretOperationsService` is a regional service and must be called
   * using regional endpoints (`secretmanager.{location}.rep.googleapis.com`).
   * </pre>
   */
  public static final class SecretOperationsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SecretOperationsServiceBlockingStub> {
    private SecretOperationsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecretOperationsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecretOperationsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Backups in a given project and location.
     * </pre>
     */
    public com.google.cloud.secretmanager.v1.ListBackupsResponse listBackups(
        com.google.cloud.secretmanager.v1.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Backup.
     * </pre>
     */
    public com.google.cloud.secretmanager.v1.Backup getBackup(
        com.google.cloud.secretmanager.v1.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Backup in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createBackup(
        com.google.cloud.secretmanager.v1.CreateBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Backup.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackup(
        com.google.cloud.secretmanager.v1.UpdateBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Backup.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackup(
        com.google.cloud.secretmanager.v1.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restores a [Secret][google.cloud.secretmanager.v1.Secret] from the given
     * [Backup][google.cloud.secretmanager.v1.Backup]. This creates a *new*
     * [Secret][google.cloud.secretmanager.v1.Secret] resource. The LRO tracks the
     * restoration process, and the result of the LRO is the newly created Secret.
     * </pre>
     */
    public com.google.longrunning.Operation restoreBackup(
        com.google.cloud.secretmanager.v1.RestoreBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreBackupMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * SecretOperationsService.
   *
   * <pre>
   * Secret Operations Service
   * Manages backups of secrets. Implements a REST model with the following
   * objects:
   * * [Backup][google.cloud.secretmanager.v1.Backup]
   * Note: `SecretOperationsService` is a regional service and must be called
   * using regional endpoints (`secretmanager.{location}.rep.googleapis.com`).
   * </pre>
   */
  public static final class SecretOperationsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SecretOperationsServiceFutureStub> {
    private SecretOperationsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecretOperationsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecretOperationsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Backups in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.secretmanager.v1.ListBackupsResponse>
        listBackups(com.google.cloud.secretmanager.v1.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.secretmanager.v1.Backup>
        getBackup(com.google.cloud.secretmanager.v1.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Backup in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBackup(com.google.cloud.secretmanager.v1.CreateBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBackup(com.google.cloud.secretmanager.v1.UpdateBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBackup(com.google.cloud.secretmanager.v1.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restores a [Secret][google.cloud.secretmanager.v1.Secret] from the given
     * [Backup][google.cloud.secretmanager.v1.Backup]. This creates a *new*
     * [Secret][google.cloud.secretmanager.v1.Secret] resource. The LRO tracks the
     * restoration process, and the result of the LRO is the newly created Secret.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restoreBackup(com.google.cloud.secretmanager.v1.RestoreBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreBackupMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_BACKUPS = 0;
  private static final int METHODID_GET_BACKUP = 1;
  private static final int METHODID_CREATE_BACKUP = 2;
  private static final int METHODID_UPDATE_BACKUP = 3;
  private static final int METHODID_DELETE_BACKUP = 4;
  private static final int METHODID_RESTORE_BACKUP = 5;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_BACKUPS:
          serviceImpl.listBackups(
              (com.google.cloud.secretmanager.v1.ListBackupsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.ListBackupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BACKUP:
          serviceImpl.getBackup(
              (com.google.cloud.secretmanager.v1.GetBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.Backup>)
                  responseObserver);
          break;
        case METHODID_CREATE_BACKUP:
          serviceImpl.createBackup(
              (com.google.cloud.secretmanager.v1.CreateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_BACKUP:
          serviceImpl.updateBackup(
              (com.google.cloud.secretmanager.v1.UpdateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BACKUP:
          serviceImpl.deleteBackup(
              (com.google.cloud.secretmanager.v1.DeleteBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESTORE_BACKUP:
          serviceImpl.restoreBackup(
              (com.google.cloud.secretmanager.v1.RestoreBackupRequest) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getListBackupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.secretmanager.v1.ListBackupsRequest,
                    com.google.cloud.secretmanager.v1.ListBackupsResponse>(
                    service, METHODID_LIST_BACKUPS)))
        .addMethod(
            getGetBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.secretmanager.v1.GetBackupRequest,
                    com.google.cloud.secretmanager.v1.Backup>(service, METHODID_GET_BACKUP)))
        .addMethod(
            getCreateBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.secretmanager.v1.CreateBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_BACKUP)))
        .addMethod(
            getUpdateBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.secretmanager.v1.UpdateBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BACKUP)))
        .addMethod(
            getDeleteBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.secretmanager.v1.DeleteBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BACKUP)))
        .addMethod(
            getRestoreBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.secretmanager.v1.RestoreBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESTORE_BACKUP)))
        .build();
  }

  private abstract static class SecretOperationsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SecretOperationsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.secretmanager.v1.OperationsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SecretOperationsService");
    }
  }

  private static final class SecretOperationsServiceFileDescriptorSupplier
      extends SecretOperationsServiceBaseDescriptorSupplier {
    SecretOperationsServiceFileDescriptorSupplier() {}
  }

  private static final class SecretOperationsServiceMethodDescriptorSupplier
      extends SecretOperationsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SecretOperationsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SecretOperationsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SecretOperationsServiceFileDescriptorSupplier())
                      .addMethod(getListBackupsMethod())
                      .addMethod(getGetBackupMethod())
                      .addMethod(getCreateBackupMethod())
                      .addMethod(getUpdateBackupMethod())
                      .addMethod(getDeleteBackupMethod())
                      .addMethod(getRestoreBackupMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
