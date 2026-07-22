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
 * Service to fetch operations for database instances.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SqlOperationsServiceGrpc {

  private SqlOperationsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.sql.v1.SqlOperationsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlOperationsGetRequest, com.google.cloud.sql.v1.Operation>
      getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get",
      requestType = com.google.cloud.sql.v1.SqlOperationsGetRequest.class,
      responseType = com.google.cloud.sql.v1.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlOperationsGetRequest, com.google.cloud.sql.v1.Operation>
      getGetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.SqlOperationsGetRequest, com.google.cloud.sql.v1.Operation>
        getGetMethod;
    if ((getGetMethod = SqlOperationsServiceGrpc.getGetMethod) == null) {
      synchronized (SqlOperationsServiceGrpc.class) {
        if ((getGetMethod = SqlOperationsServiceGrpc.getGetMethod) == null) {
          SqlOperationsServiceGrpc.getGetMethod =
              getGetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.SqlOperationsGetRequest,
                          com.google.cloud.sql.v1.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.SqlOperationsGetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlOperationsServiceMethodDescriptorSupplier("Get"))
                      .build();
        }
      }
    }
    return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlOperationsListRequest,
          com.google.cloud.sql.v1.OperationsListResponse>
      getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.google.cloud.sql.v1.SqlOperationsListRequest.class,
      responseType = com.google.cloud.sql.v1.OperationsListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlOperationsListRequest,
          com.google.cloud.sql.v1.OperationsListResponse>
      getListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.SqlOperationsListRequest,
            com.google.cloud.sql.v1.OperationsListResponse>
        getListMethod;
    if ((getListMethod = SqlOperationsServiceGrpc.getListMethod) == null) {
      synchronized (SqlOperationsServiceGrpc.class) {
        if ((getListMethod = SqlOperationsServiceGrpc.getListMethod) == null) {
          SqlOperationsServiceGrpc.getListMethod =
              getListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.SqlOperationsListRequest,
                          com.google.cloud.sql.v1.OperationsListResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.SqlOperationsListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.OperationsListResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlOperationsServiceMethodDescriptorSupplier("List"))
                      .build();
        }
      }
    }
    return getListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlOperationsCancelRequest, com.google.protobuf.Empty>
      getCancelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Cancel",
      requestType = com.google.cloud.sql.v1.SqlOperationsCancelRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1.SqlOperationsCancelRequest, com.google.protobuf.Empty>
      getCancelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1.SqlOperationsCancelRequest, com.google.protobuf.Empty>
        getCancelMethod;
    if ((getCancelMethod = SqlOperationsServiceGrpc.getCancelMethod) == null) {
      synchronized (SqlOperationsServiceGrpc.class) {
        if ((getCancelMethod = SqlOperationsServiceGrpc.getCancelMethod) == null) {
          SqlOperationsServiceGrpc.getCancelMethod =
              getCancelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1.SqlOperationsCancelRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Cancel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1.SqlOperationsCancelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlOperationsServiceMethodDescriptorSupplier("Cancel"))
                      .build();
        }
      }
    }
    return getCancelMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SqlOperationsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlOperationsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlOperationsServiceStub>() {
          @java.lang.Override
          public SqlOperationsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlOperationsServiceStub(channel, callOptions);
          }
        };
    return SqlOperationsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SqlOperationsServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlOperationsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlOperationsServiceBlockingV2Stub>() {
          @java.lang.Override
          public SqlOperationsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlOperationsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SqlOperationsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqlOperationsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlOperationsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlOperationsServiceBlockingStub>() {
          @java.lang.Override
          public SqlOperationsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlOperationsServiceBlockingStub(channel, callOptions);
          }
        };
    return SqlOperationsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SqlOperationsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlOperationsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlOperationsServiceFutureStub>() {
          @java.lang.Override
          public SqlOperationsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlOperationsServiceFutureStub(channel, callOptions);
          }
        };
    return SqlOperationsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to fetch operations for database instances.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves an instance operation that has been performed on an instance.
     * </pre>
     */
    default void get(
        com.google.cloud.sql.v1.SqlOperationsGetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all instance operations that have been performed on the given Cloud
     * SQL instance in the reverse chronological order of the start time.
     * </pre>
     */
    default void list(
        com.google.cloud.sql.v1.SqlOperationsListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.OperationsListResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels an instance operation that has been performed on an instance.
     * </pre>
     */
    default void cancel(
        com.google.cloud.sql.v1.SqlOperationsCancelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SqlOperationsService.
   *
   * <pre>
   * Service to fetch operations for database instances.
   * </pre>
   */
  public abstract static class SqlOperationsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SqlOperationsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SqlOperationsService.
   *
   * <pre>
   * Service to fetch operations for database instances.
   * </pre>
   */
  public static final class SqlOperationsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqlOperationsServiceStub> {
    private SqlOperationsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlOperationsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlOperationsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an instance operation that has been performed on an instance.
     * </pre>
     */
    public void get(
        com.google.cloud.sql.v1.SqlOperationsGetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all instance operations that have been performed on the given Cloud
     * SQL instance in the reverse chronological order of the start time.
     * </pre>
     */
    public void list(
        com.google.cloud.sql.v1.SqlOperationsListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.OperationsListResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels an instance operation that has been performed on an instance.
     * </pre>
     */
    public void cancel(
        com.google.cloud.sql.v1.SqlOperationsCancelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SqlOperationsService.
   *
   * <pre>
   * Service to fetch operations for database instances.
   * </pre>
   */
  public static final class SqlOperationsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SqlOperationsServiceBlockingV2Stub> {
    private SqlOperationsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlOperationsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlOperationsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an instance operation that has been performed on an instance.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation get(
        com.google.cloud.sql.v1.SqlOperationsGetRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all instance operations that have been performed on the given Cloud
     * SQL instance in the reverse chronological order of the start time.
     * </pre>
     */
    public com.google.cloud.sql.v1.OperationsListResponse list(
        com.google.cloud.sql.v1.SqlOperationsListRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels an instance operation that has been performed on an instance.
     * </pre>
     */
    public com.google.protobuf.Empty cancel(
        com.google.cloud.sql.v1.SqlOperationsCancelRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCancelMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SqlOperationsService.
   *
   * <pre>
   * Service to fetch operations for database instances.
   * </pre>
   */
  public static final class SqlOperationsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqlOperationsServiceBlockingStub> {
    private SqlOperationsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlOperationsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlOperationsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an instance operation that has been performed on an instance.
     * </pre>
     */
    public com.google.cloud.sql.v1.Operation get(
        com.google.cloud.sql.v1.SqlOperationsGetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all instance operations that have been performed on the given Cloud
     * SQL instance in the reverse chronological order of the start time.
     * </pre>
     */
    public com.google.cloud.sql.v1.OperationsListResponse list(
        com.google.cloud.sql.v1.SqlOperationsListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels an instance operation that has been performed on an instance.
     * </pre>
     */
    public com.google.protobuf.Empty cancel(
        com.google.cloud.sql.v1.SqlOperationsCancelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SqlOperationsService.
   *
   * <pre>
   * Service to fetch operations for database instances.
   * </pre>
   */
  public static final class SqlOperationsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqlOperationsServiceFutureStub> {
    private SqlOperationsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlOperationsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlOperationsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an instance operation that has been performed on an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.sql.v1.Operation>
        get(com.google.cloud.sql.v1.SqlOperationsGetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all instance operations that have been performed on the given Cloud
     * SQL instance in the reverse chronological order of the start time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1.OperationsListResponse>
        list(com.google.cloud.sql.v1.SqlOperationsListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels an instance operation that has been performed on an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> cancel(
        com.google.cloud.sql.v1.SqlOperationsCancelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET = 0;
  private static final int METHODID_LIST = 1;
  private static final int METHODID_CANCEL = 2;

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
        case METHODID_GET:
          serviceImpl.get(
              (com.google.cloud.sql.v1.SqlOperationsGetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.Operation>) responseObserver);
          break;
        case METHODID_LIST:
          serviceImpl.list(
              (com.google.cloud.sql.v1.SqlOperationsListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1.OperationsListResponse>)
                  responseObserver);
          break;
        case METHODID_CANCEL:
          serviceImpl.cancel(
              (com.google.cloud.sql.v1.SqlOperationsCancelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getGetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.SqlOperationsGetRequest,
                    com.google.cloud.sql.v1.Operation>(service, METHODID_GET)))
        .addMethod(
            getListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.SqlOperationsListRequest,
                    com.google.cloud.sql.v1.OperationsListResponse>(service, METHODID_LIST)))
        .addMethod(
            getCancelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1.SqlOperationsCancelRequest, com.google.protobuf.Empty>(
                    service, METHODID_CANCEL)))
        .build();
  }

  private abstract static class SqlOperationsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqlOperationsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.sql.v1.CloudSqlOperationsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqlOperationsService");
    }
  }

  private static final class SqlOperationsServiceFileDescriptorSupplier
      extends SqlOperationsServiceBaseDescriptorSupplier {
    SqlOperationsServiceFileDescriptorSupplier() {}
  }

  private static final class SqlOperationsServiceMethodDescriptorSupplier
      extends SqlOperationsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqlOperationsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqlOperationsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SqlOperationsServiceFileDescriptorSupplier())
                      .addMethod(getGetMethod())
                      .addMethod(getListMethod())
                      .addMethod(getCancelMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
