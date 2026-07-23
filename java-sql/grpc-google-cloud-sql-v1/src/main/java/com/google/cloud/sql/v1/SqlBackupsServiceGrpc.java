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
package com.google.cloud.sql.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/** */
@io.grpc.stub.annotations.GrpcGenerated
public final class SqlBackupsServiceGrpc {

  private SqlBackupsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.sql.v1.SqlBackupsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.CreateBackupRequest, com.google.cloud.sql.v1.Operation>
      getCreateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackup",
      requestType = com.google.cloud.sql.v1.CreateBackupRequest.class,
      responseType = com.google.cloud.sql.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.CreateBackupRequest, com.google.cloud.sql.v1.Operation>
      getCreateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.CreateBackupRequest, com.google.cloud.sql.v1.Operation>
        getCreateBackupMethod;
    if ((getCreateBackupMethod = SqlBackupsServiceGrpc.getCreateBackupMethod) == null) {
      synchronized (SqlBackupsServiceGrpc.class) {
        if ((getCreateBackupMethod = SqlBackupsServiceGrpc.getCreateBackupMethod) == null) {
          SqlBackupsServiceGrpc.getCreateBackupMethod =
              getCreateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.CreateBackupRequest,
                          com.google.cloud.sql.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.CreateBackupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlBackupsServiceMethodDescriptorSupplier("CreateBackup"))
                      .build();
        }
      }
    }
    return getCreateBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.GetBackupRequest, com.google.cloud.sql.v1.Backup>
      getGetBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackup",
      requestType = com.google.cloud.sql.v1.GetBackupRequest.class,
      responseType = com.google.cloud.sql.v1.Backup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.GetBackupRequest, com.google.cloud.sql.v1.Backup>
      getGetBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.GetBackupRequest, com.google.cloud.sql.v1.Backup>
        getGetBackupMethod;
    if ((getGetBackupMethod = SqlBackupsServiceGrpc.getGetBackupMethod) == null) {
      synchronized (SqlBackupsServiceGrpc.class) {
        if ((getGetBackupMethod = SqlBackupsServiceGrpc.getGetBackupMethod) == null) {
          SqlBackupsServiceGrpc.getGetBackupMethod =
              getGetBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.GetBackupRequest, com.google.cloud.sql.v1.Backup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.GetBackupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.Backup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlBackupsServiceMethodDescriptorSupplier("GetBackup"))
                      .build();
        }
      }
    }
    return getGetBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.ListBackupsRequest, com.google.cloud.sql.v1.ListBackupsResponse>
      getListBackupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackups",
      requestType = com.google.cloud.sql.v1.ListBackupsRequest.class,
      responseType = com.google.cloud.sql.v1.ListBackupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.ListBackupsRequest, com.google.cloud.sql.v1.ListBackupsResponse>
      getListBackupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.ListBackupsRequest, com.google.cloud.sql.v1.ListBackupsResponse>
        getListBackupsMethod;
    if ((getListBackupsMethod = SqlBackupsServiceGrpc.getListBackupsMethod) == null) {
      synchronized (SqlBackupsServiceGrpc.class) {
        if ((getListBackupsMethod = SqlBackupsServiceGrpc.getListBackupsMethod) == null) {
          SqlBackupsServiceGrpc.getListBackupsMethod =
              getListBackupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.ListBackupsRequest,
                          com.google.cloud.sql.v1.ListBackupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.ListBackupsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.ListBackupsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlBackupsServiceMethodDescriptorSupplier("ListBackups"))
                      .build();
        }
      }
    }
    return getListBackupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.UpdateBackupRequest, com.google.cloud.sql.v1.Operation>
      getUpdateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackup",
      requestType = com.google.cloud.sql.v1.UpdateBackupRequest.class,
      responseType = com.google.cloud.sql.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.UpdateBackupRequest, com.google.cloud.sql.v1.Operation>
      getUpdateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.UpdateBackupRequest, com.google.cloud.sql.v1.Operation>
        getUpdateBackupMethod;
    if ((getUpdateBackupMethod = SqlBackupsServiceGrpc.getUpdateBackupMethod) == null) {
      synchronized (SqlBackupsServiceGrpc.class) {
        if ((getUpdateBackupMethod = SqlBackupsServiceGrpc.getUpdateBackupMethod) == null) {
          SqlBackupsServiceGrpc.getUpdateBackupMethod =
              getUpdateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.UpdateBackupRequest,
                          com.google.cloud.sql.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.UpdateBackupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlBackupsServiceMethodDescriptorSupplier("UpdateBackup"))
                      .build();
        }
      }
    }
    return getUpdateBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.DeleteBackupRequest, com.google.cloud.sql.v1.Operation>
      getDeleteBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackup",
      requestType = com.google.cloud.sql.v1.DeleteBackupRequest.class,
      responseType = com.google.cloud.sql.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.DeleteBackupRequest, com.google.cloud.sql.v1.Operation>
      getDeleteBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.DeleteBackupRequest, com.google.cloud.sql.v1.Operation>
        getDeleteBackupMethod;
    if ((getDeleteBackupMethod = SqlBackupsServiceGrpc.getDeleteBackupMethod) == null) {
      synchronized (SqlBackupsServiceGrpc.class) {
        if ((getDeleteBackupMethod = SqlBackupsServiceGrpc.getDeleteBackupMethod) == null) {
          SqlBackupsServiceGrpc.getDeleteBackupMethod =
              getDeleteBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.DeleteBackupRequest,
                          com.google.cloud.sql.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.DeleteBackupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlBackupsServiceMethodDescriptorSupplier("DeleteBackup"))
                      .build();
        }
      }
    }
    return getDeleteBackupMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SqlBackupsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlBackupsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlBackupsServiceStub>() {
          @java.lang.Override
          public SqlBackupsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlBackupsServiceStub(channel, callOptions);
          }
        };
    return SqlBackupsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SqlBackupsServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlBackupsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlBackupsServiceBlockingV2Stub>() {
          @java.lang.Override
          public SqlBackupsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlBackupsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SqlBackupsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqlBackupsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlBackupsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlBackupsServiceBlockingStub>() {
          @java.lang.Override
          public SqlBackupsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlBackupsServiceBlockingStub(channel, callOptions);
          }
        };
    return SqlBackupsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SqlBackupsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlBackupsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlBackupsServiceFutureStub>() {
          @java.lang.Override
          public SqlBackupsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlBackupsServiceFutureStub(channel, callOptions);
          }
        };
    return SqlBackupsServiceFutureStub.newStub(factory, channel);
  }

  /** */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a backup for a Cloud SQL instance. This API can be used only to
     * create on-demand backups.
     * </pre>
     */
    default void createBackup(
        com.google.cloud.sql.v1.CreateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a backup.
     * </pre>
     */
    default void getBackup(
        com.google.cloud.sql.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Backup> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all backups associated with the project.
     * </pre>
     */
    default void listBackups(
        com.google.cloud.sql.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.ListBackupsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the retention period and description of the backup. You can use
     * this API to update final backups only.
     * </pre>
     */
    default void updateBackup(
        com.google.cloud.sql.v1.UpdateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the backup.
     * </pre>
     */
    default void deleteBackup(
        com.google.cloud.sql.v1.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupMethod(), responseObserver);
    }
  }

  /** Base class for the server implementation of the service SqlBackupsService. */
  public abstract static class SqlBackupsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SqlBackupsServiceGrpc.bindService(this);
    }
  }

  /** A stub to allow clients to do asynchronous rpc calls to service SqlBackupsService. */
  public static final class SqlBackupsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqlBackupsServiceStub> {
    private SqlBackupsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlBackupsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlBackupsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a backup for a Cloud SQL instance. This API can be used only to
     * create on-demand backups.
     * </pre>
     */
    public void createBackup(
        com.google.cloud.sql.v1.CreateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a backup.
     * </pre>
     */
    public void getBackup(
        com.google.cloud.sql.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Backup> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all backups associated with the project.
     * </pre>
     */
    public void listBackups(
        com.google.cloud.sql.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.ListBackupsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the retention period and description of the backup. You can use
     * this API to update final backups only.
     * </pre>
     */
    public void updateBackup(
        com.google.cloud.sql.v1.UpdateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the backup.
     * </pre>
     */
    public void deleteBackup(
        com.google.cloud.sql.v1.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /** A stub to allow clients to do synchronous rpc calls to service SqlBackupsService. */
  public static final class SqlBackupsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SqlBackupsServiceBlockingV2Stub> {
    private SqlBackupsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlBackupsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlBackupsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a backup for a Cloud SQL instance. This API can be used only to
     * create on-demand backups.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation createBackup(
        com.google.cloud.sql.v1.CreateBackupRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a backup.
     * </pre>
     */
    public com.google.cloud.sql.v1.Backup getBackup(
        com.google.cloud.sql.v1.GetBackupRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all backups associated with the project.
     * </pre>
     */
    public com.google.cloud.sql.v1.ListBackupsResponse listBackups(
        com.google.cloud.sql.v1.ListBackupsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the retention period and description of the backup. You can use
     * this API to update final backups only.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation updateBackup(
        com.google.cloud.sql.v1.UpdateBackupRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the backup.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation deleteBackup(
        com.google.cloud.sql.v1.DeleteBackupRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteBackupMethod(), getCallOptions(), request);
    }
  }

  /** A stub to allow clients to do limited synchronous rpc calls to service SqlBackupsService. */
  public static final class SqlBackupsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqlBackupsServiceBlockingStub> {
    private SqlBackupsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlBackupsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlBackupsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a backup for a Cloud SQL instance. This API can be used only to
     * create on-demand backups.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation createBackup(
        com.google.cloud.sql.v1.CreateBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a backup.
     * </pre>
     */
    public com.google.cloud.sql.v1.Backup getBackup(
        com.google.cloud.sql.v1.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all backups associated with the project.
     * </pre>
     */
    public com.google.cloud.sql.v1.ListBackupsResponse listBackups(
        com.google.cloud.sql.v1.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the retention period and description of the backup. You can use
     * this API to update final backups only.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation updateBackup(
        com.google.cloud.sql.v1.UpdateBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the backup.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation deleteBackup(
        com.google.cloud.sql.v1.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SqlBackupsService.
   */
  public static final class SqlBackupsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqlBackupsServiceFutureStub> {
    private SqlBackupsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlBackupsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlBackupsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a backup for a Cloud SQL instance. This API can be used only to
     * create on-demand backups.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.sql.v1.Operation>
        createBackup(com.google.cloud.sql.v1.CreateBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.sql.v1.Backup>
        getBackup(com.google.cloud.sql.v1.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all backups associated with the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1.ListBackupsResponse>
        listBackups(com.google.cloud.sql.v1.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the retention period and description of the backup. You can use
     * this API to update final backups only.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.sql.v1.Operation>
        updateBackup(com.google.cloud.sql.v1.UpdateBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.sql.v1.Operation>
        deleteBackup(com.google.cloud.sql.v1.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_BACKUP = 0;
  private static final int METHODID_GET_BACKUP = 1;
  private static final int METHODID_LIST_BACKUPS = 2;
  private static final int METHODID_UPDATE_BACKUP = 3;
  private static final int METHODID_DELETE_BACKUP = 4;

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
        case METHODID_CREATE_BACKUP:
          serviceImpl.createBackup(
              (com.google.cloud.sql.v1.CreateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation>) responseObserver);
          break;
        case METHODID_GET_BACKUP:
          serviceImpl.getBackup(
              (com.google.cloud.sql.v1.GetBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Backup>) responseObserver);
          break;
        case METHODID_LIST_BACKUPS:
          serviceImpl.listBackups(
              (com.google.cloud.sql.v1.ListBackupsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.ListBackupsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BACKUP:
          serviceImpl.updateBackup(
              (com.google.cloud.sql.v1.UpdateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BACKUP:
          serviceImpl.deleteBackup(
              (com.google.cloud.sql.v1.DeleteBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation>) responseObserver);
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
            getCreateBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.CreateBackupRequest, com.google.cloud.sql.v1.Operation>(
                    service, METHODID_CREATE_BACKUP)))
        .addMethod(
            getGetBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.GetBackupRequest, com.google.cloud.sql.v1.Backup>(
                    service, METHODID_GET_BACKUP)))
        .addMethod(
            getListBackupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.ListBackupsRequest,
                    com.google.cloud.sql.v1.ListBackupsResponse>(service, METHODID_LIST_BACKUPS)))
        .addMethod(
            getUpdateBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.UpdateBackupRequest, com.google.cloud.sql.v1.Operation>(
                    service, METHODID_UPDATE_BACKUP)))
        .addMethod(
            getDeleteBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.DeleteBackupRequest, com.google.cloud.sql.v1.Operation>(
                    service, METHODID_DELETE_BACKUP)))
        .build();
  }

  private abstract static class SqlBackupsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqlBackupsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.sql.v1.CloudSqlBackupsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqlBackupsService");
    }
  }

  private static final class SqlBackupsServiceFileDescriptorSupplier
      extends SqlBackupsServiceBaseDescriptorSupplier {
    SqlBackupsServiceFileDescriptorSupplier() {}
  }

  private static final class SqlBackupsServiceMethodDescriptorSupplier
      extends SqlBackupsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqlBackupsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqlBackupsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SqlBackupsServiceFileDescriptorSupplier())
                      .addMethod(getCreateBackupMethod())
                      .addMethod(getGetBackupMethod())
                      .addMethod(getListBackupsMethod())
                      .addMethod(getUpdateBackupMethod())
                      .addMethod(getDeleteBackupMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
