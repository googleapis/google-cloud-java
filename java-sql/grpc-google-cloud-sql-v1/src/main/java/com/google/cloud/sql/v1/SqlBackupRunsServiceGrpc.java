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

/**
 *
 *
 * <pre>
 * Service for managing database backups.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SqlBackupRunsServiceGrpc {

  private SqlBackupRunsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.sql.v1.SqlBackupRunsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlBackupRunsDeleteRequest, com.google.cloud.sql.v1.Operation>
      getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.google.cloud.sql.v1.SqlBackupRunsDeleteRequest.class,
      responseType = com.google.cloud.sql.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlBackupRunsDeleteRequest, com.google.cloud.sql.v1.Operation>
      getDeleteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.SqlBackupRunsDeleteRequest, com.google.cloud.sql.v1.Operation>
        getDeleteMethod;
    if ((getDeleteMethod = SqlBackupRunsServiceGrpc.getDeleteMethod) == null) {
      synchronized (SqlBackupRunsServiceGrpc.class) {
        if ((getDeleteMethod = SqlBackupRunsServiceGrpc.getDeleteMethod) == null) {
          SqlBackupRunsServiceGrpc.getDeleteMethod =
              getDeleteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.SqlBackupRunsDeleteRequest,
                          com.google.cloud.sql.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Delete"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.SqlBackupRunsDeleteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlBackupRunsServiceMethodDescriptorSupplier("Delete"))
                      .build();
        }
      }
    }
    return getDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlBackupRunsGetRequest, com.google.cloud.sql.v1.BackupRun>
      getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get",
      requestType = com.google.cloud.sql.v1.SqlBackupRunsGetRequest.class,
      responseType = com.google.cloud.sql.v1.BackupRun.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlBackupRunsGetRequest, com.google.cloud.sql.v1.BackupRun>
      getGetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.SqlBackupRunsGetRequest, com.google.cloud.sql.v1.BackupRun>
        getGetMethod;
    if ((getGetMethod = SqlBackupRunsServiceGrpc.getGetMethod) == null) {
      synchronized (SqlBackupRunsServiceGrpc.class) {
        if ((getGetMethod = SqlBackupRunsServiceGrpc.getGetMethod) == null) {
          SqlBackupRunsServiceGrpc.getGetMethod =
              getGetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.SqlBackupRunsGetRequest,
                          com.google.cloud.sql.v1.BackupRun>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.SqlBackupRunsGetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.BackupRun.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlBackupRunsServiceMethodDescriptorSupplier("Get"))
                      .build();
        }
      }
    }
    return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlBackupRunsInsertRequest, com.google.cloud.sql.v1.Operation>
      getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Insert",
      requestType = com.google.cloud.sql.v1.SqlBackupRunsInsertRequest.class,
      responseType = com.google.cloud.sql.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlBackupRunsInsertRequest, com.google.cloud.sql.v1.Operation>
      getInsertMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.SqlBackupRunsInsertRequest, com.google.cloud.sql.v1.Operation>
        getInsertMethod;
    if ((getInsertMethod = SqlBackupRunsServiceGrpc.getInsertMethod) == null) {
      synchronized (SqlBackupRunsServiceGrpc.class) {
        if ((getInsertMethod = SqlBackupRunsServiceGrpc.getInsertMethod) == null) {
          SqlBackupRunsServiceGrpc.getInsertMethod =
              getInsertMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.SqlBackupRunsInsertRequest,
                          com.google.cloud.sql.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Insert"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.SqlBackupRunsInsertRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlBackupRunsServiceMethodDescriptorSupplier("Insert"))
                      .build();
        }
      }
    }
    return getInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlBackupRunsListRequest,
          com.google.cloud.sql.v1.BackupRunsListResponse>
      getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.google.cloud.sql.v1.SqlBackupRunsListRequest.class,
      responseType = com.google.cloud.sql.v1.BackupRunsListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlBackupRunsListRequest,
          com.google.cloud.sql.v1.BackupRunsListResponse>
      getListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.SqlBackupRunsListRequest,
            com.google.cloud.sql.v1.BackupRunsListResponse>
        getListMethod;
    if ((getListMethod = SqlBackupRunsServiceGrpc.getListMethod) == null) {
      synchronized (SqlBackupRunsServiceGrpc.class) {
        if ((getListMethod = SqlBackupRunsServiceGrpc.getListMethod) == null) {
          SqlBackupRunsServiceGrpc.getListMethod =
              getListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.SqlBackupRunsListRequest,
                          com.google.cloud.sql.v1.BackupRunsListResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.SqlBackupRunsListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.BackupRunsListResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlBackupRunsServiceMethodDescriptorSupplier("List"))
                      .build();
        }
      }
    }
    return getListMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SqlBackupRunsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlBackupRunsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlBackupRunsServiceStub>() {
          @java.lang.Override
          public SqlBackupRunsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlBackupRunsServiceStub(channel, callOptions);
          }
        };
    return SqlBackupRunsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SqlBackupRunsServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlBackupRunsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlBackupRunsServiceBlockingV2Stub>() {
          @java.lang.Override
          public SqlBackupRunsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlBackupRunsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SqlBackupRunsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqlBackupRunsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlBackupRunsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlBackupRunsServiceBlockingStub>() {
          @java.lang.Override
          public SqlBackupRunsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlBackupRunsServiceBlockingStub(channel, callOptions);
          }
        };
    return SqlBackupRunsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SqlBackupRunsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlBackupRunsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlBackupRunsServiceFutureStub>() {
          @java.lang.Override
          public SqlBackupRunsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlBackupRunsServiceFutureStub(channel, callOptions);
          }
        };
    return SqlBackupRunsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing database backups.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Deletes the backup taken by a backup run.
     * </pre>
     */
    default void delete(
        com.google.cloud.sql.v1.SqlBackupRunsDeleteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a backup run.
     * </pre>
     */
    default void get(
        com.google.cloud.sql.v1.SqlBackupRunsGetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.BackupRun> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new backup run on demand.
     * </pre>
     */
    default void insert(
        com.google.cloud.sql.v1.SqlBackupRunsInsertRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all backup runs associated with the project or a given instance
     * and configuration in the reverse chronological order of the backup
     * initiation time.
     * </pre>
     */
    default void list(
        com.google.cloud.sql.v1.SqlBackupRunsListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.BackupRunsListResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SqlBackupRunsService.
   *
   * <pre>
   * Service for managing database backups.
   * </pre>
   */
  public abstract static class SqlBackupRunsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SqlBackupRunsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SqlBackupRunsService.
   *
   * <pre>
   * Service for managing database backups.
   * </pre>
   */
  public static final class SqlBackupRunsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqlBackupRunsServiceStub> {
    private SqlBackupRunsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlBackupRunsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlBackupRunsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes the backup taken by a backup run.
     * </pre>
     */
    public void delete(
        com.google.cloud.sql.v1.SqlBackupRunsDeleteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a backup run.
     * </pre>
     */
    public void get(
        com.google.cloud.sql.v1.SqlBackupRunsGetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.BackupRun> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new backup run on demand.
     * </pre>
     */
    public void insert(
        com.google.cloud.sql.v1.SqlBackupRunsInsertRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all backup runs associated with the project or a given instance
     * and configuration in the reverse chronological order of the backup
     * initiation time.
     * </pre>
     */
    public void list(
        com.google.cloud.sql.v1.SqlBackupRunsListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.BackupRunsListResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SqlBackupRunsService.
   *
   * <pre>
   * Service for managing database backups.
   * </pre>
   */
  public static final class SqlBackupRunsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SqlBackupRunsServiceBlockingV2Stub> {
    private SqlBackupRunsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlBackupRunsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlBackupRunsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes the backup taken by a backup run.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation delete(
        com.google.cloud.sql.v1.SqlBackupRunsDeleteRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a backup run.
     * </pre>
     */
    public com.google.cloud.sql.v1.BackupRun get(
        com.google.cloud.sql.v1.SqlBackupRunsGetRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new backup run on demand.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation insert(
        com.google.cloud.sql.v1.SqlBackupRunsInsertRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all backup runs associated with the project or a given instance
     * and configuration in the reverse chronological order of the backup
     * initiation time.
     * </pre>
     */
    public com.google.cloud.sql.v1.BackupRunsListResponse list(
        com.google.cloud.sql.v1.SqlBackupRunsListRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SqlBackupRunsService.
   *
   * <pre>
   * Service for managing database backups.
   * </pre>
   */
  public static final class SqlBackupRunsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqlBackupRunsServiceBlockingStub> {
    private SqlBackupRunsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlBackupRunsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlBackupRunsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes the backup taken by a backup run.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation delete(
        com.google.cloud.sql.v1.SqlBackupRunsDeleteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a backup run.
     * </pre>
     */
    public com.google.cloud.sql.v1.BackupRun get(
        com.google.cloud.sql.v1.SqlBackupRunsGetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new backup run on demand.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation insert(
        com.google.cloud.sql.v1.SqlBackupRunsInsertRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all backup runs associated with the project or a given instance
     * and configuration in the reverse chronological order of the backup
     * initiation time.
     * </pre>
     */
    public com.google.cloud.sql.v1.BackupRunsListResponse list(
        com.google.cloud.sql.v1.SqlBackupRunsListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SqlBackupRunsService.
   *
   * <pre>
   * Service for managing database backups.
   * </pre>
   */
  public static final class SqlBackupRunsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqlBackupRunsServiceFutureStub> {
    private SqlBackupRunsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlBackupRunsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlBackupRunsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes the backup taken by a backup run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.sql.v1.Operation>
        delete(com.google.cloud.sql.v1.SqlBackupRunsDeleteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a backup run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.sql.v1.BackupRun>
        get(com.google.cloud.sql.v1.SqlBackupRunsGetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new backup run on demand.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.sql.v1.Operation>
        insert(com.google.cloud.sql.v1.SqlBackupRunsInsertRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all backup runs associated with the project or a given instance
     * and configuration in the reverse chronological order of the backup
     * initiation time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1.BackupRunsListResponse>
        list(com.google.cloud.sql.v1.SqlBackupRunsListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELETE = 0;
  private static final int METHODID_GET = 1;
  private static final int METHODID_INSERT = 2;
  private static final int METHODID_LIST = 3;

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
        case METHODID_DELETE:
          serviceImpl.delete(
              (com.google.cloud.sql.v1.SqlBackupRunsDeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get(
              (com.google.cloud.sql.v1.SqlBackupRunsGetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.BackupRun>) responseObserver);
          break;
        case METHODID_INSERT:
          serviceImpl.insert(
              (com.google.cloud.sql.v1.SqlBackupRunsInsertRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation>) responseObserver);
          break;
        case METHODID_LIST:
          serviceImpl.list(
              (com.google.cloud.sql.v1.SqlBackupRunsListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.BackupRunsListResponse>)
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.SqlBackupRunsDeleteRequest,
                    com.google.cloud.sql.v1.Operation>(service, METHODID_DELETE)))
        .addMethod(
            getGetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.SqlBackupRunsGetRequest,
                    com.google.cloud.sql.v1.BackupRun>(service, METHODID_GET)))
        .addMethod(
            getInsertMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.SqlBackupRunsInsertRequest,
                    com.google.cloud.sql.v1.Operation>(service, METHODID_INSERT)))
        .addMethod(
            getListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.SqlBackupRunsListRequest,
                    com.google.cloud.sql.v1.BackupRunsListResponse>(service, METHODID_LIST)))
        .build();
  }

  private abstract static class SqlBackupRunsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqlBackupRunsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.sql.v1.CloudSqlBackupRunsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqlBackupRunsService");
    }
  }

  private static final class SqlBackupRunsServiceFileDescriptorSupplier
      extends SqlBackupRunsServiceBaseDescriptorSupplier {
    SqlBackupRunsServiceFileDescriptorSupplier() {}
  }

  private static final class SqlBackupRunsServiceMethodDescriptorSupplier
      extends SqlBackupRunsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqlBackupRunsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqlBackupRunsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SqlBackupRunsServiceFileDescriptorSupplier())
                      .addMethod(getDeleteMethod())
                      .addMethod(getGetMethod())
                      .addMethod(getInsertMethod())
                      .addMethod(getListMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
