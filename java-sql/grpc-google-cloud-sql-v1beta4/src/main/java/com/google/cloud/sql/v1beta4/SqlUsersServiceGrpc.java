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
package com.google.cloud.sql.v1beta4;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/** */
@io.grpc.stub.annotations.GrpcGenerated
public final class SqlUsersServiceGrpc {

  private SqlUsersServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.sql.v1beta4.SqlUsersService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlUsersDeleteRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.google.cloud.sql.v1beta4.SqlUsersDeleteRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlUsersDeleteRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getDeleteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlUsersDeleteRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getDeleteMethod;
    if ((getDeleteMethod = SqlUsersServiceGrpc.getDeleteMethod) == null) {
      synchronized (SqlUsersServiceGrpc.class) {
        if ((getDeleteMethod = SqlUsersServiceGrpc.getDeleteMethod) == null) {
          SqlUsersServiceGrpc.getDeleteMethod =
              getDeleteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlUsersDeleteRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Delete"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlUsersDeleteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlUsersServiceMethodDescriptorSupplier("Delete"))
                      .build();
        }
      }
    }
    return getDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlUsersGetRequest, com.google.cloud.sql.v1beta4.User>
      getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get",
      requestType = com.google.cloud.sql.v1beta4.SqlUsersGetRequest.class,
      responseType = com.google.cloud.sql.v1beta4.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlUsersGetRequest, com.google.cloud.sql.v1beta4.User>
      getGetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlUsersGetRequest, com.google.cloud.sql.v1beta4.User>
        getGetMethod;
    if ((getGetMethod = SqlUsersServiceGrpc.getGetMethod) == null) {
      synchronized (SqlUsersServiceGrpc.class) {
        if ((getGetMethod = SqlUsersServiceGrpc.getGetMethod) == null) {
          SqlUsersServiceGrpc.getGetMethod =
              getGetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlUsersGetRequest,
                          com.google.cloud.sql.v1beta4.User>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlUsersGetRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.User.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlUsersServiceMethodDescriptorSupplier("Get"))
                      .build();
        }
      }
    }
    return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlUsersInsertRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Insert",
      requestType = com.google.cloud.sql.v1beta4.SqlUsersInsertRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlUsersInsertRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getInsertMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlUsersInsertRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getInsertMethod;
    if ((getInsertMethod = SqlUsersServiceGrpc.getInsertMethod) == null) {
      synchronized (SqlUsersServiceGrpc.class) {
        if ((getInsertMethod = SqlUsersServiceGrpc.getInsertMethod) == null) {
          SqlUsersServiceGrpc.getInsertMethod =
              getInsertMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlUsersInsertRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Insert"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlUsersInsertRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlUsersServiceMethodDescriptorSupplier("Insert"))
                      .build();
        }
      }
    }
    return getInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlUsersListRequest,
          com.google.cloud.sql.v1beta4.UsersListResponse>
      getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.google.cloud.sql.v1beta4.SqlUsersListRequest.class,
      responseType = com.google.cloud.sql.v1beta4.UsersListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlUsersListRequest,
          com.google.cloud.sql.v1beta4.UsersListResponse>
      getListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlUsersListRequest,
            com.google.cloud.sql.v1beta4.UsersListResponse>
        getListMethod;
    if ((getListMethod = SqlUsersServiceGrpc.getListMethod) == null) {
      synchronized (SqlUsersServiceGrpc.class) {
        if ((getListMethod = SqlUsersServiceGrpc.getListMethod) == null) {
          SqlUsersServiceGrpc.getListMethod =
              getListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlUsersListRequest,
                          com.google.cloud.sql.v1beta4.UsersListResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlUsersListRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.UsersListResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlUsersServiceMethodDescriptorSupplier("List"))
                      .build();
        }
      }
    }
    return getListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlUsersUpdateRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.google.cloud.sql.v1beta4.SqlUsersUpdateRequest.class,
      responseType = com.google.cloud.sql.v1beta4.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.SqlUsersUpdateRequest,
          com.google.cloud.sql.v1beta4.Operation>
      getUpdateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.SqlUsersUpdateRequest,
            com.google.cloud.sql.v1beta4.Operation>
        getUpdateMethod;
    if ((getUpdateMethod = SqlUsersServiceGrpc.getUpdateMethod) == null) {
      synchronized (SqlUsersServiceGrpc.class) {
        if ((getUpdateMethod = SqlUsersServiceGrpc.getUpdateMethod) == null) {
          SqlUsersServiceGrpc.getUpdateMethod =
              getUpdateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.SqlUsersUpdateRequest,
                          com.google.cloud.sql.v1beta4.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Update"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.SqlUsersUpdateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new SqlUsersServiceMethodDescriptorSupplier("Update"))
                      .build();
        }
      }
    }
    return getUpdateMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SqlUsersServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlUsersServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlUsersServiceStub>() {
          @java.lang.Override
          public SqlUsersServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlUsersServiceStub(channel, callOptions);
          }
        };
    return SqlUsersServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SqlUsersServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlUsersServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlUsersServiceBlockingV2Stub>() {
          @java.lang.Override
          public SqlUsersServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlUsersServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SqlUsersServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqlUsersServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlUsersServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlUsersServiceBlockingStub>() {
          @java.lang.Override
          public SqlUsersServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlUsersServiceBlockingStub(channel, callOptions);
          }
        };
    return SqlUsersServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SqlUsersServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlUsersServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlUsersServiceFutureStub>() {
          @java.lang.Override
          public SqlUsersServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlUsersServiceFutureStub(channel, callOptions);
          }
        };
    return SqlUsersServiceFutureStub.newStub(factory, channel);
  }

  /** */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Deletes a user from a Cloud SQL instance.
     * </pre>
     */
    default void delete(
        com.google.cloud.sql.v1beta4.SqlUsersDeleteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a user.
     * </pre>
     */
    default void get(
        com.google.cloud.sql.v1beta4.SqlUsersGetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.User> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new user in a Cloud SQL instance.
     * </pre>
     */
    default void insert(
        com.google.cloud.sql.v1beta4.SqlUsersInsertRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists users in the specified Cloud SQL instance.
     * </pre>
     */
    default void list(
        com.google.cloud.sql.v1beta4.SqlUsersListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.UsersListResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing user in a Cloud SQL instance.
     * </pre>
     */
    default void update(
        com.google.cloud.sql.v1beta4.SqlUsersUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }
  }

  /** Base class for the server implementation of the service SqlUsersService. */
  public abstract static class SqlUsersServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SqlUsersServiceGrpc.bindService(this);
    }
  }

  /** A stub to allow clients to do asynchronous rpc calls to service SqlUsersService. */
  public static final class SqlUsersServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqlUsersServiceStub> {
    private SqlUsersServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlUsersServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlUsersServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user from a Cloud SQL instance.
     * </pre>
     */
    public void delete(
        com.google.cloud.sql.v1beta4.SqlUsersDeleteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a user.
     * </pre>
     */
    public void get(
        com.google.cloud.sql.v1beta4.SqlUsersGetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.User> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new user in a Cloud SQL instance.
     * </pre>
     */
    public void insert(
        com.google.cloud.sql.v1beta4.SqlUsersInsertRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists users in the specified Cloud SQL instance.
     * </pre>
     */
    public void list(
        com.google.cloud.sql.v1beta4.SqlUsersListRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.UsersListResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing user in a Cloud SQL instance.
     * </pre>
     */
    public void update(
        com.google.cloud.sql.v1beta4.SqlUsersUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /** A stub to allow clients to do synchronous rpc calls to service SqlUsersService. */
  public static final class SqlUsersServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SqlUsersServiceBlockingV2Stub> {
    private SqlUsersServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlUsersServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlUsersServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user from a Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation delete(
        com.google.cloud.sql.v1beta4.SqlUsersDeleteRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a user.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.User get(
        com.google.cloud.sql.v1beta4.SqlUsersGetRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new user in a Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation insert(
        com.google.cloud.sql.v1beta4.SqlUsersInsertRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists users in the specified Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.UsersListResponse list(
        com.google.cloud.sql.v1beta4.SqlUsersListRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing user in a Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation update(
        com.google.cloud.sql.v1beta4.SqlUsersUpdateRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }
  }

  /** A stub to allow clients to do limited synchronous rpc calls to service SqlUsersService. */
  public static final class SqlUsersServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqlUsersServiceBlockingStub> {
    private SqlUsersServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlUsersServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlUsersServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user from a Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation delete(
        com.google.cloud.sql.v1beta4.SqlUsersDeleteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a user.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.User get(
        com.google.cloud.sql.v1beta4.SqlUsersGetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new user in a Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation insert(
        com.google.cloud.sql.v1beta4.SqlUsersInsertRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists users in the specified Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.UsersListResponse list(
        com.google.cloud.sql.v1beta4.SqlUsersListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing user in a Cloud SQL instance.
     * </pre>
     */
    public com.google.cloud.sql.v1beta4.Operation update(
        com.google.cloud.sql.v1beta4.SqlUsersUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }
  }

  /** A stub to allow clients to do ListenableFuture-style rpc calls to service SqlUsersService. */
  public static final class SqlUsersServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqlUsersServiceFutureStub> {
    private SqlUsersServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlUsersServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlUsersServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user from a Cloud SQL instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        delete(com.google.cloud.sql.v1beta4.SqlUsersDeleteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a resource containing information about a user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.sql.v1beta4.User>
        get(com.google.cloud.sql.v1beta4.SqlUsersGetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new user in a Cloud SQL instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        insert(com.google.cloud.sql.v1beta4.SqlUsersInsertRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists users in the specified Cloud SQL instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.UsersListResponse>
        list(com.google.cloud.sql.v1beta4.SqlUsersListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing user in a Cloud SQL instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.sql.v1beta4.Operation>
        update(com.google.cloud.sql.v1beta4.SqlUsersUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELETE = 0;
  private static final int METHODID_GET = 1;
  private static final int METHODID_INSERT = 2;
  private static final int METHODID_LIST = 3;
  private static final int METHODID_UPDATE = 4;

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
              (com.google.cloud.sql.v1beta4.SqlUsersDeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get(
              (com.google.cloud.sql.v1beta4.SqlUsersGetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.User>) responseObserver);
          break;
        case METHODID_INSERT:
          serviceImpl.insert(
              (com.google.cloud.sql.v1beta4.SqlUsersInsertRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
                  responseObserver);
          break;
        case METHODID_LIST:
          serviceImpl.list(
              (com.google.cloud.sql.v1beta4.SqlUsersListRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.UsersListResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update(
              (com.google.cloud.sql.v1beta4.SqlUsersUpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.Operation>)
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
                    com.google.cloud.sql.v1beta4.SqlUsersDeleteRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_DELETE)))
        .addMethod(
            getGetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlUsersGetRequest,
                    com.google.cloud.sql.v1beta4.User>(service, METHODID_GET)))
        .addMethod(
            getInsertMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlUsersInsertRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_INSERT)))
        .addMethod(
            getListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlUsersListRequest,
                    com.google.cloud.sql.v1beta4.UsersListResponse>(service, METHODID_LIST)))
        .addMethod(
            getUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.SqlUsersUpdateRequest,
                    com.google.cloud.sql.v1beta4.Operation>(service, METHODID_UPDATE)))
        .build();
  }

  private abstract static class SqlUsersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqlUsersServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.sql.v1beta4.CloudSqlUsersProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqlUsersService");
    }
  }

  private static final class SqlUsersServiceFileDescriptorSupplier
      extends SqlUsersServiceBaseDescriptorSupplier {
    SqlUsersServiceFileDescriptorSupplier() {}
  }

  private static final class SqlUsersServiceMethodDescriptorSupplier
      extends SqlUsersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqlUsersServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqlUsersServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SqlUsersServiceFileDescriptorSupplier())
                      .addMethod(getDeleteMethod())
                      .addMethod(getGetMethod())
                      .addMethod(getInsertMethod())
                      .addMethod(getListMethod())
                      .addMethod(getUpdateMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
